package org.studio.nox.movibox

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.io.Serializable
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executors

data class VideoFile(val name: String, val url: String, val sizeMb: Long) : Serializable
data class VideoItem(
    val id: String,
    val title: String,
    val year: String,
    val category: String,
    val description: String,
    val poster: String,
    val files: List<VideoFile>
) : Serializable

data class DownloadRow(val dbId: Long, val title: String, val done: Boolean, val failed: Boolean, val uri: String?)

/**
 * Données de l'application.
 *
 * - Catalogue : chargé depuis assets/catalog.json (hors ligne garanti), puis
 *   tenté une fois par lancement depuis CATALOG_URL pour rester actualisable :
 *   "les serveurs" de l'app sont Internet Archive + le CDN Blender, deux sources
 *   vidéo légales qui servent du MP4 progressif (compatible seek et téléchargement).
 * - Aucun droit premium, aucune limite, aucune publicité : tout est ouvert par construction.
 */
object Catalog {
    private const val PREFS = "movibox"
    private const val KEY_REMOTE = "catalog_remote"

    // URL optionnelle d'un catalogue distant (JSON même schéma). Vide = asset embarqué seul.
    const val CATALOG_URL = "https://raw.githubusercontent.com/calvinbeaubrum-oss/movibox-catalog/main/catalog.json"

    @Volatile private var cache: List<VideoItem>? = null
    private val pool = Executors.newSingleThreadExecutor()

    fun load(context: Context): List<VideoItem> {
        cache?.let { return it }
        val local = parse(context.assets.open("catalog.json").bufferedReader().readText())
        val stored = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).getString(KEY_REMOTE, null)
        val merged = stored?.let { s -> runCatching { parse(s) }.getOrNull() } ?: local
        cache = merged
        return merged
    }

    /** Rafraîchit le catalogue en arrière-plan depuis CATALOG_URL et mémorise la réponse valide. */
    fun refreshAsync(context: Context) {
        val ctx = context.applicationContext
        pool.execute {
            runCatching {
                val conn = URL(CATALOG_URL).openConnection() as HttpURLConnection
                conn.connectTimeout = 6000
                conn.readTimeout = 8000
                conn.inputStream.bufferedReader().readText().also { conn.disconnect() }
            }.getOrNull()?.let { text ->
                val items = runCatching { parse(text) }.getOrNull()
                if (!items.isNullOrEmpty()) {
                    cache = items
                    ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
                        .edit().putString(KEY_REMOTE, text).apply()
                }
            }
        }
    }

    private fun parse(json: String): List<VideoItem> {
        val root = JSONObject(json)
        val out = mutableListOf<VideoItem>()
        val arr = root.getJSONArray("items")
        for (i in 0 until arr.length()) {
            val o = arr.getJSONObject(i)
            val files = mutableListOf<VideoFile>()
            val fa = o.getJSONArray("files")
            for (j in 0 until fa.length()) {
                val f = fa.getJSONObject(j)
                files.add(VideoFile(f.optString("name", "HD"), f.getString("url"), f.optLong("sizeMb", 0)))
            }
            if (files.isEmpty()) continue
            out.add(
                VideoItem(
                    id = o.getString("id"),
                    title = o.getString("title"),
                    year = o.optString("year", ""),
                    category = o.optString("category", "classics"),
                    description = o.optString("description", ""),
                    poster = o.optString("poster", ""),
                    files = files
                )
            )
        }
        return out
    }
}

/** Favoris, historique et reprise de lecture, tout en SharedPreferences. */
object Store {
    private const val PREFS = "movibox"
    private const val KEY_FAV = "favorites"
    private const val KEY_HIST = "history"
    private const val KEY_POS = "positions"

    private fun sp(ctx: Context) = ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
    private fun readSet(ctx: Context, key: String): MutableSet<String> =
        sp(ctx).getStringSet(key, emptySet())!!.toMutableSet()

    fun isFavorite(ctx: Context, id: String) = readSet(ctx, KEY_FAV).contains(id)
    fun toggleFavorite(ctx: Context, id: String) {
        val s = readSet(ctx, KEY_FAV)
        if (!s.add(id)) s.remove(id)
        sp(ctx).edit().putStringSet(KEY_FAV, s).apply()
    }
    fun markWatched(ctx: Context, id: String) {
        val s = readSet(ctx, KEY_HIST)
        s.remove(id); s.add(id)
        sp(ctx).edit().putStringSet(KEY_HIST, s).apply()
    }
    fun isWatched(ctx: Context, id: String) = readSet(ctx, KEY_HIST).contains(id)

    fun savePosition(ctx: Context, key: String, positionMs: Long) {
        sp(ctx).edit().putLong("pos_$key", positionMs).apply()
    }
    fun getPosition(ctx: Context, key: String): Long = sp(ctx).getLong("pos_$key", 0L)
}

/** Téléchargements : DownloadManager système = multi en parallèle, notifications, stockage Téléchargements/MoviBox. */
object Downloader {
    const val FOLDER = "MoviBox"

    fun enqueue(context: Context, item: VideoItem, file: VideoFile): Long {
        val safeName = item.title.replace(Regex("[^A-Za-z0-9 ._-]"), "").trim() + " - " + file.name + ".mp4"
        val req = DownloadManager.Request(Uri.parse(file.url))
            .setTitle(item.title)
            .setDescription("MoviBox - " + file.name)
            .setMimeType("video/mp4")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, FOLDER + File.separator + safeName)
            .setAllowedOverMetered(true)
            .setAllowedOverRoaming(false)
        return context.getSystemService(DownloadManager::class.java).enqueue(req)
    }

    fun list(context: Context): List<DownloadRow> {
        val dm = context.getSystemService(DownloadManager::class.java) ?: return emptyList()
        val q = DownloadManager.Query().setFilterByStatus(
            DownloadManager.STATUS_SUCCESSFUL or DownloadManager.STATUS_RUNNING or
                DownloadManager.STATUS_PENDING or DownloadManager.STATUS_PAUSED or
                DownloadManager.STATUS_FAILED
        )
        val rows = mutableListOf<DownloadRow>()
        dm.query(q)?.use { c ->
            val iId = c.getColumnIndexOrThrow(DownloadManager.COLUMN_ID)
            val iTitle = c.getColumnIndexOrThrow(DownloadManager.COLUMN_TITLE)
            val iStatus = c.getColumnIndexOrThrow(DownloadManager.COLUMN_STATUS)
            val iUri = c.getColumnIndexOrThrow(DownloadManager.COLUMN_LOCAL_URI)
            val iDesc = c.getColumnIndexOrThrow(DownloadManager.COLUMN_DESCRIPTION)
            while (c.moveToNext()) {
                if (!c.getString(iDesc).orEmpty().startsWith("MoviBox")) continue
                val status = c.getInt(iStatus)
                rows.add(
                    DownloadRow(
                        dbId = c.getLong(iId),
                        title = c.getString(iTitle) ?: "?",
                        done = status == DownloadManager.STATUS_SUCCESSFUL,
                        failed = status == DownloadManager.STATUS_FAILED,
                        uri = c.getString(iUri)
                    )
                )
            }
        }
        return rows.sortedByDescending { it.dbId }
    }

    fun localUri(context: Context, row: DownloadRow): Uri {
        val dm = context.getSystemService(DownloadManager::class.java)!!
        return dm.getUriForDownloadedFile(row.dbId) ?: Uri.parse(row.uri)
    }

    fun remove(context: Context, row: DownloadRow) {
        context.getSystemService(DownloadManager::class.java).remove(row.dbId)
    }
}
