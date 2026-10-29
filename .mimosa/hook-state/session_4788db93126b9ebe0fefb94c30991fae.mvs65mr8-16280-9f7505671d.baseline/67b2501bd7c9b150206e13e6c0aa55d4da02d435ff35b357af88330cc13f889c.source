package org.studio.nox.movibox

import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import java.io.Serializable

/**
 * Lecteur plein écran. Deux sources possibles :
 *  - un VideoItem du catalogue (streaming depuis les serveurs vidéo publics) ;
 *  - un fichier téléchargé (localUri), pour la lecture hors ligne.
 * Toutes les qualités disponibles sont proposées à tout le monde, sans plafond.
 */
class PlayerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE

        val item = intent.getSerializableExtra("item") as? VideoItem
        val fileIndex = intent.getIntExtra("fileIndex", 0)
        val localUri = intent.getStringExtra("localUri")
        val localTitle = intent.getStringExtra("title") ?: ""

        setContent {
            MoviBoxTheme {
                PlayerScreen(item, fileIndex, localUri, localTitle) { finish() }
            }
        }
    }
}

@Composable
fun PlayerScreen(
    item: VideoItem?,
    fileIndex: Int,
    localUri: String?,
    localTitle: String,
    onClose: () -> Unit
) {
    val ctx = LocalContext.current
    var selectedFile by remember(item) { mutableStateOf(item?.files?.getOrNull(fileIndex.coerceIn(0, (item?.files?.size ?: 1) - 1))) }
    val sourceUrl: String? = remember(selectedFile, localUri) {
        localUri ?: selectedFile?.url
    }
    val title = selectedFile?.let { item?.title } ?: localTitle
    val posKey = remember(selectedFile, localUri) { localUri ?: (item?.id + "|" + selectedFile?.name) }

    var fav by remember(item) { mutableStateOf(item != null && Store.isFavorite(ctx, item.id)) }

    val player = remember {
        ExoPlayer.Builder(ctx).build().apply {
            playWhenReady = true
        }
    }
    DisposableEffect(player) { onDispose { player.release() } }

    LaunchedEffect(sourceUrl) {
        sourceUrl?.let { url ->
            val resume = if (posKey != null) Store.getPosition(ctx, posKey) else 0L
            player.setMediaItem(MediaItem.fromUri(Uri.parse(url)), resume)
            player.prepare()
        }
    }

    DisposableEffect(posKey) {
        val listener = object : Player.Listener {
            override fun onPlaybackStateChanged(state: Int) {
                if (state == Player.STATE_ENDED && posKey != null) Store.savePosition(ctx, posKey, 0L)
            }
        }
        player.addListener(listener)
        onDispose {
            player.removeListener(listener)
            posKey?.let { Store.savePosition(ctx, it, player.currentPosition) }
        }
    }

    // Sauvegarde périodique de la position pour la reprise.
    LaunchedEffect(posKey) {
        while (true) {
            kotlinx.coroutines.delay(3000)
            posKey?.let { Store.savePosition(ctx, it, player.currentPosition) }
        }
    }

    Box(Modifier.fillMaxSize().background(Color.Black)) {
        AndroidView(
            factory = { viewContext ->
                PlayerView(viewContext).apply {
                    this.player = player
                    setShowNextButton(false)
                    setShowPreviousButton(false)
                }
            },
            modifier = Modifier.fillMaxSize()
        )
        Row(
            Modifier
                .align(Alignment.TopStart)
                .padding(10.dp)
                .horizontalScroll(rememberScrollState()),
            verticalAlignment = Alignment.CenterVertically
        ) {
            item?.files?.forEachIndexed { index, file ->
                QualityChip(
                    label = file.name,
                    selected = selectedFile == file
                ) { selectedFile = file }
            }
            Spacer(Modifier.width(6.dp))
            if (item != null) {
                Icon(
                    if (fav) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                    contentDescription = stringResource(R.string.favorite),
                    tint = if (fav) Accent2 else Color.White,
                    modifier = Modifier
                        .padding(6.dp)
                        .clickable {
                            Store.toggleFavorite(ctx, item.id)
                            fav = Store.isFavorite(ctx, item.id)
                        }
                )
                item.files.forEach { file ->
                    Icon(
                        Icons.Filled.Download,
                        contentDescription = stringResource(R.string.download_file, file.name),
                        tint = Accent,
                        modifier = Modifier
                            .padding(6.dp)
                            .clickable {
                                runCatching { Downloader.enqueue(ctx, item, file) }
                            }
                    )
                }
            }
        }
        if (localUri != null) {
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0x9912141D),
                modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 12.dp)
            ) {
                Text(
                    stringResource(R.string.offline_playback),
                    color = Color.White, fontSize = 11.sp,
                    modifier = Modifier.padding(10.dp, 5.dp)
                )
            }
        }
    }
}

@Composable
fun QualityChip(label: String, selected: Boolean, onClick: () -> Unit) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        color = if (selected) Accent else Color(0x9912141D),
        modifier = Modifier
            .padding(3.dp)
            .clickable(onClick = onClick)
    ) {
        Text(
            label, fontSize = 12.sp,
            color = if (selected) Color.White else Color(0xFFEDEFF7),
            modifier = Modifier.padding(10.dp, 5.dp)
        )
    }
}
