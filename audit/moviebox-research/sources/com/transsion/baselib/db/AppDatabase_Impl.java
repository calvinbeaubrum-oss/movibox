package com.transsion.baselib.db;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.u;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.transsion.baselib.db.place.PlaceDao;
import com.transsion.baselib.db.video.IShortTvFavoriteStateDao;
import com.transsion.baselib.db.video.ShortTVPlayDao;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.baselib.db.video.f;
import com.transsion.ninegridview.preview.GifImagePreviewActivity;
import com.transsion.push.PushConstants;
import e6.b;
import e6.e;
import g6.g;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import tr.c;
import tr.d;
import tr.h;
import tr.i;
import tr.k;
import tr.l;
import tr.m;
import tr.n;
import tr.o;
import tr.p;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class AppDatabase_Impl extends AppDatabase {

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public volatile rr.a f51047m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public volatile c f51048n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public volatile yr.a f51049o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public volatile m f51050p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public volatile xr.a f51051q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public volatile h f51052r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public volatile f f51053s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public volatile ShortTVPlayDao f51054t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public volatile o f51055u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public volatile IShortTvFavoriteStateDao f51056v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public volatile VideoDetailPlayDao f51057w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public volatile vr.a f51058x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public volatile PlaceDao f51059y0;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    public class a extends u.b {
        public a(int i11) {
            super(i11);
        }

        @Override // androidx.room.u.b
        public void a(g gVar) {
            gVar.E("CREATE TABLE IF NOT EXISTS `audio` (`audioId` TEXT NOT NULL, `cover` TEXT, `duration` INTEGER, `size` INTEGER, `url` TEXT, `title` TEXT, `desc` TEXT, `bitrate` INTEGER, `updateTimeStamp` INTEGER, `readProcess` INTEGER, `localPath` TEXT, `ops` TEXT, `resourceId` TEXT, `postId` TEXT, `subjectId` TEXT, `groupId` TEXT, `status` INTEGER NOT NULL, `subjectTitle` TEXT, `se` INTEGER NOT NULL, `ep` INTEGER NOT NULL, PRIMARY KEY(`audioId`))");
            gVar.E("CREATE TABLE IF NOT EXISTS `download_table` (`url` TEXT NOT NULL, `resourceId` TEXT, `name` TEXT, `cover` TEXT, `size` INTEGER, `postId` TEXT, `sizeFormat` TEXT, `path` TEXT, `duration` INTEGER, `updateTimeStamp` INTEGER, `progress` INTEGER NOT NULL, `supportRanges` INTEGER NOT NULL, `status` INTEGER NOT NULL, `type` INTEGER NOT NULL, `readProgress` INTEGER NOT NULL, `createAt` INTEGER NOT NULL, `isRead` INTEGER NOT NULL, `episode` INTEGER NOT NULL, `ep` INTEGER NOT NULL, `se` INTEGER NOT NULL, `resolution` INTEGER NOT NULL, `resourcePosition` INTEGER NOT NULL, `multiresolution` INTEGER NOT NULL, `videoWidth` INTEGER NOT NULL, `videoHeight` INTEGER NOT NULL, `downloadErrorCount` INTEGER NOT NULL, `subtitleStarted` INTEGER NOT NULL, `subjectId` TEXT, `pageFrom` TEXT, `lastPageFrom` TEXT, `subjectName` TEXT, `lastPlayTimeStamp` INTEGER NOT NULL, `fileType` INTEGER NOT NULL, `totalEpisode` INTEGER NOT NULL, `uploadBy` TEXT, `sourceUrl` TEXT, `urlCreateAt` INTEGER NOT NULL, `subtitleSelectId` TEXT, `taskId` TEXT, `sessionTime` INTEGER NOT NULL, `reportStatus` INTEGER NOT NULL, `downloadHeaderSize` INTEGER NOT NULL, `rootPath` TEXT, `rootPathType` INTEGER NOT NULL, `thumbnail` TEXT, `averageHueLight` TEXT, `isTransferFailed` INTEGER NOT NULL, `isClosedTransferFailed` INTEGER NOT NULL, `subjectType` INTEGER NOT NULL, `genre` TEXT, `subjectDurationSeconds` INTEGER, `currentDubLanName` TEXT, `currentDubLanCode` TEXT, `ops` TEXT, `restrictLevel` TEXT, `releaseDate` TEXT, `countryName` TEXT, `seNum` INTEGER, `subtitles` TEXT, `imdbRate` TEXT, `lastAdStartTimeStamp` INTEGER, `lastAdEndTimeStamp` INTEGER, PRIMARY KEY(`url`))");
            gVar.E("CREATE TABLE IF NOT EXISTS `video` (`postId` TEXT NOT NULL, `playProgress` INTEGER, `url` TEXT, PRIMARY KEY(`postId`))");
            gVar.E("CREATE TABLE IF NOT EXISTS `download_thread_info` (`id` INTEGER NOT NULL, `threadId` INTEGER NOT NULL, `downloadInfoId` TEXT, `uri` TEXT, `start` INTEGER NOT NULL, `end` INTEGER NOT NULL, `progress` INTEGER NOT NULL, PRIMARY KEY(`id`))");
            gVar.E("CREATE TABLE IF NOT EXISTS `room_table` (`groupId` TEXT NOT NULL, `name` TEXT, `avatar` TEXT, `hasJoin` INTEGER, `newPostCount` INTEGER, `description` TEXT, `postCount` INTEGER, `userCount` INTEGER, `level` TEXT, `updateTimeStamp` INTEGER NOT NULL, PRIMARY KEY(`groupId`))");
            gVar.E("CREATE TABLE IF NOT EXISTS `permanent_msg` (`id` INTEGER NOT NULL, `deep_link_list` TEXT, `desc` TEXT, `image_list` TEXT, `message_id` TEXT, `style` TEXT, `title` TEXT, PRIMARY KEY(`id`))");
            gVar.E("CREATE TABLE IF NOT EXISTS `download_subtitle_table` (`resourceId` TEXT NOT NULL, `postId` TEXT, `url` TEXT, `path` TEXT, `lan` TEXT, `lanName` TEXT NOT NULL, `subtitleName` TEXT, `size` INTEGER, `delayDuration` INTEGER, `status` INTEGER NOT NULL, `type` INTEGER NOT NULL, `fileCharsetName` TEXT, `subjectId` TEXT, `ep` INTEGER NOT NULL, `se` INTEGER NOT NULL, `resolution` INTEGER NOT NULL, PRIMARY KEY(`resourceId`))");
            gVar.E("CREATE TABLE IF NOT EXISTS `msg` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `deep_link` TEXT, `desc` TEXT, `image_list` TEXT, `message_id` TEXT, `source` TEXT, `style` TEXT, `title` TEXT, `type` TEXT, `receive_time` INTEGER, `msg_status` INTEGER NOT NULL, `show_time` INTEGER, `force_show` INTEGER NOT NULL, `has_screen_on` INTEGER NOT NULL, `built_in` INTEGER NOT NULL, `permanent_msg_status` INTEGER NOT NULL)");
            gVar.E("CREATE TABLE IF NOT EXISTS `consume_bean` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `updateTimeStamp` INTEGER NOT NULL, `dataType` INTEGER NOT NULL, `appVersion` INTEGER NOT NULL, `consumeJson` TEXT)");
            gVar.E("CREATE TABLE IF NOT EXISTS `download_thread_range` (`threadId` INTEGER NOT NULL, `rangeId` INTEGER NOT NULL, `resourceId` TEXT, `start` INTEGER NOT NULL, `end` INTEGER NOT NULL, `progress` INTEGER NOT NULL, PRIMARY KEY(`threadId`, `rangeId`))");
            gVar.E("CREATE TABLE IF NOT EXISTS `video_land_ad` (`resourceId` TEXT NOT NULL, `startAdDayKey` INTEGER NOT NULL, `endAdDayKey` INTEGER NOT NULL, PRIMARY KEY(`resourceId`))");
            gVar.E("CREATE TABLE IF NOT EXISTS `subtitle_language_map_table` (`lan` TEXT NOT NULL, `lanIOS3` TEXT, `lanName` TEXT NOT NULL, `inSearch` INTEGER NOT NULL, PRIMARY KEY(`lan`))");
            gVar.E("CREATE TABLE IF NOT EXISTS `non_ad_plans` (`id` TEXT NOT NULL, `version` TEXT, `name` TEXT, `startTime` TEXT, `endTime` TEXT, `extraConfig` TEXT, `displayTimes` INTEGER, `showedTimes` INTEGER, `showDate` TEXT, `advertiserName` TEXT, `advertiserAvatar` TEXT, `advertiserAvatarPath` TEXT, `brand` TEXT, `denyBrand` TEXT, `model` TEXT, `denyModel` TEXT, `country` TEXT, `scenes` TEXT, `adMaterialList` TEXT, `adPlanUpdateTime` TEXT, `sort` INTEGER, `adShowLevel` TEXT, `filterClientVersion` TEXT, `adPlanCreateTime` TEXT, `appStarDesc` TEXT, `appSizeDesc` TEXT, PRIMARY KEY(`id`))");
            gVar.E("CREATE TABLE IF NOT EXISTS `local_mcc` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Country` TEXT NOT NULL, `Mcc` TEXT NOT NULL, `Iso` TEXT NOT NULL, `CountryCode` TEXT NOT NULL)");
            gVar.E("CREATE TABLE IF NOT EXISTS `short_tv_play` (`subjectId` TEXT NOT NULL, `id` TEXT NOT NULL, `ep` INTEGER NOT NULL, `se` INTEGER NOT NULL, `totalEp` INTEGER NOT NULL, `progress` INTEGER NOT NULL, `title` TEXT, `description` TEXT, `coverUrl` TEXT, `thumbnail` TEXT, `videoId` TEXT, `videoUrl` TEXT, `timeStamp` INTEGER NOT NULL, PRIMARY KEY(`subjectId`))");
            gVar.E("CREATE TABLE IF NOT EXISTS `ShortTvFavoriteState` (`subjectId` TEXT NOT NULL, `favoriteNum` TEXT, `hasFavorite` INTEGER NOT NULL, `favoriteTime` TEXT, PRIMARY KEY(`subjectId`))");
            gVar.E("CREATE TABLE IF NOT EXISTS `video_detail_play` (`subjectId` TEXT NOT NULL, `id` TEXT NOT NULL, `ep` INTEGER NOT NULL, `se` INTEGER NOT NULL, `progress` INTEGER NOT NULL, `title` TEXT, `coverUrl` TEXT, `thumbnail` TEXT, `videoUrl` TEXT, `timeStamp` INTEGER NOT NULL, `subtitleSelectId` TEXT, `totalDuration` INTEGER, `subjectDurationSeconds` INTEGER, `averageHueLight` TEXT, `subjectType` INTEGER, `hasDelete` INTEGER NOT NULL, `playMode` TEXT NOT NULL, `downloadUrl` TEXT, `downloadFilePath` TEXT, `downloadSize` INTEGER NOT NULL, `dubs` TEXT, `lastAdStartTimeStamp` INTEGER, `lastAdEndTimeStamp` INTEGER, `rewardPlayed` INTEGER NOT NULL, `rewardUnlock` INTEGER NOT NULL, `rewardFree` INTEGER NOT NULL, PRIMARY KEY(`subjectId`, `ep`, `se`))");
            gVar.E("CREATE TABLE IF NOT EXISTS `music_liked` (`subjectId` TEXT NOT NULL, `title` TEXT, `coverUrl` TEXT, `countryName` TEXT, `genre` TEXT, `releaseDate` TEXT, `durationSeconds` INTEGER NOT NULL, `singerName` TEXT, `singerAvatar` TEXT, `path` TEXT, `timeStamp` INTEGER NOT NULL, PRIMARY KEY(`subjectId`))");
            gVar.E("CREATE TABLE IF NOT EXISTS `place_list` (`latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `name` TEXT, `address` TEXT, `distance` TEXT, PRIMARY KEY(`latitude`, `longitude`))");
            gVar.E("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            gVar.E("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'de426e98025aef5d335cf70708de8ce2')");
        }

        @Override // androidx.room.u.b
        public void b(g gVar) {
            gVar.E("DROP TABLE IF EXISTS `audio`");
            gVar.E("DROP TABLE IF EXISTS `download_table`");
            gVar.E("DROP TABLE IF EXISTS `video`");
            gVar.E("DROP TABLE IF EXISTS `download_thread_info`");
            gVar.E("DROP TABLE IF EXISTS `room_table`");
            gVar.E("DROP TABLE IF EXISTS `permanent_msg`");
            gVar.E("DROP TABLE IF EXISTS `download_subtitle_table`");
            gVar.E("DROP TABLE IF EXISTS `msg`");
            gVar.E("DROP TABLE IF EXISTS `consume_bean`");
            gVar.E("DROP TABLE IF EXISTS `download_thread_range`");
            gVar.E("DROP TABLE IF EXISTS `video_land_ad`");
            gVar.E("DROP TABLE IF EXISTS `subtitle_language_map_table`");
            gVar.E("DROP TABLE IF EXISTS `non_ad_plans`");
            gVar.E("DROP TABLE IF EXISTS `local_mcc`");
            gVar.E("DROP TABLE IF EXISTS `short_tv_play`");
            gVar.E("DROP TABLE IF EXISTS `ShortTvFavoriteState`");
            gVar.E("DROP TABLE IF EXISTS `video_detail_play`");
            gVar.E("DROP TABLE IF EXISTS `music_liked`");
            gVar.E("DROP TABLE IF EXISTS `place_list`");
            if (AppDatabase_Impl.this.f12777h != null) {
                int size = AppDatabase_Impl.this.f12777h.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((RoomDatabase.b) AppDatabase_Impl.this.f12777h.get(i11)).b(gVar);
                }
            }
        }

        @Override // androidx.room.u.b
        public void c(g gVar) {
            if (AppDatabase_Impl.this.f12777h != null) {
                int size = AppDatabase_Impl.this.f12777h.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((RoomDatabase.b) AppDatabase_Impl.this.f12777h.get(i11)).a(gVar);
                }
            }
        }

        @Override // androidx.room.u.b
        public void d(g gVar) {
            AppDatabase_Impl.this.f12770a = gVar;
            AppDatabase_Impl.this.x(gVar);
            if (AppDatabase_Impl.this.f12777h != null) {
                int size = AppDatabase_Impl.this.f12777h.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((RoomDatabase.b) AppDatabase_Impl.this.f12777h.get(i11)).c(gVar);
                }
            }
        }

        @Override // androidx.room.u.b
        public void e(g gVar) {
        }

        @Override // androidx.room.u.b
        public void f(g gVar) {
            b.b(gVar);
        }

        @Override // androidx.room.u.b
        public u.c g(g gVar) {
            HashMap map = new HashMap(20);
            map.put("audioId", new e.a("audioId", "TEXT", true, 1, null, 1));
            map.put("cover", new e.a("cover", "TEXT", false, 0, null, 1));
            map.put("duration", new e.a("duration", "INTEGER", false, 0, null, 1));
            map.put("size", new e.a("size", "INTEGER", false, 0, null, 1));
            map.put("url", new e.a("url", "TEXT", false, 0, null, 1));
            map.put(CampaignEx.JSON_KEY_TITLE, new e.a(CampaignEx.JSON_KEY_TITLE, "TEXT", false, 0, null, 1));
            map.put(CampaignEx.JSON_KEY_DESC, new e.a(CampaignEx.JSON_KEY_DESC, "TEXT", false, 0, null, 1));
            map.put("bitrate", new e.a("bitrate", "INTEGER", false, 0, null, 1));
            map.put("updateTimeStamp", new e.a("updateTimeStamp", "INTEGER", false, 0, null, 1));
            map.put("readProcess", new e.a("readProcess", "INTEGER", false, 0, null, 1));
            map.put("localPath", new e.a("localPath", "TEXT", false, 0, null, 1));
            map.put("ops", new e.a("ops", "TEXT", false, 0, null, 1));
            map.put("resourceId", new e.a("resourceId", "TEXT", false, 0, null, 1));
            map.put("postId", new e.a("postId", "TEXT", false, 0, null, 1));
            map.put("subjectId", new e.a("subjectId", "TEXT", false, 0, null, 1));
            map.put("groupId", new e.a("groupId", "TEXT", false, 0, null, 1));
            map.put(NotificationCompat.CATEGORY_STATUS, new e.a(NotificationCompat.CATEGORY_STATUS, "INTEGER", true, 0, null, 1));
            map.put("subjectTitle", new e.a("subjectTitle", "TEXT", false, 0, null, 1));
            map.put("se", new e.a("se", "INTEGER", true, 0, null, 1));
            map.put("ep", new e.a("ep", "INTEGER", true, 0, null, 1));
            e eVar = new e(MimeTypes.BASE_TYPE_AUDIO, map, new HashSet(0), new HashSet(0));
            e eVarA = e.a(gVar, MimeTypes.BASE_TYPE_AUDIO);
            if (!eVar.equals(eVarA)) {
                return new u.c(false, "audio(com.transsion.baselib.db.audio.AudioBean).\n Expected:\n" + eVar + "\n Found:\n" + eVarA);
            }
            HashMap map2 = new HashMap(62);
            map2.put("url", new e.a("url", "TEXT", true, 1, null, 1));
            map2.put("resourceId", new e.a("resourceId", "TEXT", false, 0, null, 1));
            map2.put("name", new e.a("name", "TEXT", false, 0, null, 1));
            map2.put("cover", new e.a("cover", "TEXT", false, 0, null, 1));
            map2.put("size", new e.a("size", "INTEGER", false, 0, null, 1));
            map2.put("postId", new e.a("postId", "TEXT", false, 0, null, 1));
            map2.put("sizeFormat", new e.a("sizeFormat", "TEXT", false, 0, null, 1));
            map2.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, new e.a(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, "TEXT", false, 0, null, 1));
            map2.put("duration", new e.a("duration", "INTEGER", false, 0, null, 1));
            map2.put("updateTimeStamp", new e.a("updateTimeStamp", "INTEGER", false, 0, null, 1));
            map2.put(NotificationCompat.CATEGORY_PROGRESS, new e.a(NotificationCompat.CATEGORY_PROGRESS, "INTEGER", true, 0, null, 1));
            map2.put("supportRanges", new e.a("supportRanges", "INTEGER", true, 0, null, 1));
            map2.put(NotificationCompat.CATEGORY_STATUS, new e.a(NotificationCompat.CATEGORY_STATUS, "INTEGER", true, 0, null, 1));
            map2.put("type", new e.a("type", "INTEGER", true, 0, null, 1));
            map2.put("readProgress", new e.a("readProgress", "INTEGER", true, 0, null, 1));
            map2.put("createAt", new e.a("createAt", "INTEGER", true, 0, null, 1));
            map2.put("isRead", new e.a("isRead", "INTEGER", true, 0, null, 1));
            map2.put("episode", new e.a("episode", "INTEGER", true, 0, null, 1));
            map2.put("ep", new e.a("ep", "INTEGER", true, 0, null, 1));
            map2.put("se", new e.a("se", "INTEGER", true, 0, null, 1));
            map2.put("resolution", new e.a("resolution", "INTEGER", true, 0, null, 1));
            map2.put("resourcePosition", new e.a("resourcePosition", "INTEGER", true, 0, null, 1));
            map2.put("multiresolution", new e.a("multiresolution", "INTEGER", true, 0, null, 1));
            map2.put("videoWidth", new e.a("videoWidth", "INTEGER", true, 0, null, 1));
            map2.put("videoHeight", new e.a("videoHeight", "INTEGER", true, 0, null, 1));
            map2.put("downloadErrorCount", new e.a("downloadErrorCount", "INTEGER", true, 0, null, 1));
            map2.put("subtitleStarted", new e.a("subtitleStarted", "INTEGER", true, 0, null, 1));
            map2.put("subjectId", new e.a("subjectId", "TEXT", false, 0, null, 1));
            map2.put("pageFrom", new e.a("pageFrom", "TEXT", false, 0, null, 1));
            map2.put("lastPageFrom", new e.a("lastPageFrom", "TEXT", false, 0, null, 1));
            map2.put("subjectName", new e.a("subjectName", "TEXT", false, 0, null, 1));
            map2.put("lastPlayTimeStamp", new e.a("lastPlayTimeStamp", "INTEGER", true, 0, null, 1));
            map2.put("fileType", new e.a("fileType", "INTEGER", true, 0, null, 1));
            map2.put("totalEpisode", new e.a("totalEpisode", "INTEGER", true, 0, null, 1));
            map2.put("uploadBy", new e.a("uploadBy", "TEXT", false, 0, null, 1));
            map2.put("sourceUrl", new e.a("sourceUrl", "TEXT", false, 0, null, 1));
            map2.put("urlCreateAt", new e.a("urlCreateAt", "INTEGER", true, 0, null, 1));
            map2.put("subtitleSelectId", new e.a("subtitleSelectId", "TEXT", false, 0, null, 1));
            map2.put("taskId", new e.a("taskId", "TEXT", false, 0, null, 1));
            map2.put("sessionTime", new e.a("sessionTime", "INTEGER", true, 0, null, 1));
            map2.put("reportStatus", new e.a("reportStatus", "INTEGER", true, 0, null, 1));
            map2.put("downloadHeaderSize", new e.a("downloadHeaderSize", "INTEGER", true, 0, null, 1));
            map2.put("rootPath", new e.a("rootPath", "TEXT", false, 0, null, 1));
            map2.put("rootPathType", new e.a("rootPathType", "INTEGER", true, 0, null, 1));
            map2.put("thumbnail", new e.a("thumbnail", "TEXT", false, 0, null, 1));
            map2.put("averageHueLight", new e.a("averageHueLight", "TEXT", false, 0, null, 1));
            map2.put("isTransferFailed", new e.a("isTransferFailed", "INTEGER", true, 0, null, 1));
            map2.put("isClosedTransferFailed", new e.a("isClosedTransferFailed", "INTEGER", true, 0, null, 1));
            map2.put("subjectType", new e.a("subjectType", "INTEGER", true, 0, null, 1));
            map2.put("genre", new e.a("genre", "TEXT", false, 0, null, 1));
            map2.put("subjectDurationSeconds", new e.a("subjectDurationSeconds", "INTEGER", false, 0, null, 1));
            map2.put("currentDubLanName", new e.a("currentDubLanName", "TEXT", false, 0, null, 1));
            map2.put("currentDubLanCode", new e.a("currentDubLanCode", "TEXT", false, 0, null, 1));
            map2.put("ops", new e.a("ops", "TEXT", false, 0, null, 1));
            map2.put("restrictLevel", new e.a("restrictLevel", "TEXT", false, 0, null, 1));
            map2.put("releaseDate", new e.a("releaseDate", "TEXT", false, 0, null, 1));
            map2.put("countryName", new e.a("countryName", "TEXT", false, 0, null, 1));
            map2.put("seNum", new e.a("seNum", "INTEGER", false, 0, null, 1));
            map2.put("subtitles", new e.a("subtitles", "TEXT", false, 0, null, 1));
            map2.put("imdbRate", new e.a("imdbRate", "TEXT", false, 0, null, 1));
            map2.put("lastAdStartTimeStamp", new e.a("lastAdStartTimeStamp", "INTEGER", false, 0, null, 1));
            map2.put("lastAdEndTimeStamp", new e.a("lastAdEndTimeStamp", "INTEGER", false, 0, null, 1));
            e eVar2 = new e("download_table", map2, new HashSet(0), new HashSet(0));
            e eVarA2 = e.a(gVar, "download_table");
            if (!eVar2.equals(eVarA2)) {
                return new u.c(false, "download_table(com.transsion.baselib.db.download.DownloadBean).\n Expected:\n" + eVar2 + "\n Found:\n" + eVarA2);
            }
            HashMap map3 = new HashMap(3);
            map3.put("postId", new e.a("postId", "TEXT", true, 1, null, 1));
            map3.put("playProgress", new e.a("playProgress", "INTEGER", false, 0, null, 1));
            map3.put("url", new e.a("url", "TEXT", false, 0, null, 1));
            e eVar3 = new e("video", map3, new HashSet(0), new HashSet(0));
            e eVarA3 = e.a(gVar, "video");
            if (!eVar3.equals(eVarA3)) {
                return new u.c(false, "video(com.transsion.baselib.db.video.VideoBean).\n Expected:\n" + eVar3 + "\n Found:\n" + eVarA3);
            }
            HashMap map4 = new HashMap(7);
            map4.put("id", new e.a("id", "INTEGER", true, 1, null, 1));
            map4.put("threadId", new e.a("threadId", "INTEGER", true, 0, null, 1));
            map4.put("downloadInfoId", new e.a("downloadInfoId", "TEXT", false, 0, null, 1));
            map4.put("uri", new e.a("uri", "TEXT", false, 0, null, 1));
            map4.put("start", new e.a("start", "INTEGER", true, 0, null, 1));
            map4.put(TtmlNode.END, new e.a(TtmlNode.END, "INTEGER", true, 0, null, 1));
            map4.put(NotificationCompat.CATEGORY_PROGRESS, new e.a(NotificationCompat.CATEGORY_PROGRESS, "INTEGER", true, 0, null, 1));
            e eVar4 = new e("download_thread_info", map4, new HashSet(0), new HashSet(0));
            e eVarA4 = e.a(gVar, "download_thread_info");
            if (!eVar4.equals(eVarA4)) {
                return new u.c(false, "download_thread_info(com.transsion.baselib.db.download.DownloadTaskInfo).\n Expected:\n" + eVar4 + "\n Found:\n" + eVarA4);
            }
            HashMap map5 = new HashMap(10);
            map5.put("groupId", new e.a("groupId", "TEXT", true, 1, null, 1));
            map5.put("name", new e.a("name", "TEXT", false, 0, null, 1));
            map5.put("avatar", new e.a("avatar", "TEXT", false, 0, null, 1));
            map5.put("hasJoin", new e.a("hasJoin", "INTEGER", false, 0, null, 1));
            map5.put("newPostCount", new e.a("newPostCount", "INTEGER", false, 0, null, 1));
            map5.put(TrackingKey.DESCRIPTION, new e.a(TrackingKey.DESCRIPTION, "TEXT", false, 0, null, 1));
            map5.put("postCount", new e.a("postCount", "INTEGER", false, 0, null, 1));
            map5.put("userCount", new e.a("userCount", "INTEGER", false, 0, null, 1));
            map5.put("level", new e.a("level", "TEXT", false, 0, null, 1));
            map5.put("updateTimeStamp", new e.a("updateTimeStamp", "INTEGER", true, 0, null, 1));
            e eVar5 = new e("room_table", map5, new HashSet(0), new HashSet(0));
            e eVarA5 = e.a(gVar, "room_table");
            if (!eVar5.equals(eVarA5)) {
                return new u.c(false, "room_table(com.transsion.baselib.db.room.RoomItemBean).\n Expected:\n" + eVar5 + "\n Found:\n" + eVarA5);
            }
            HashMap map6 = new HashMap(7);
            map6.put("id", new e.a("id", "INTEGER", true, 1, null, 1));
            map6.put("deep_link_list", new e.a("deep_link_list", "TEXT", false, 0, null, 1));
            map6.put(CampaignEx.JSON_KEY_DESC, new e.a(CampaignEx.JSON_KEY_DESC, "TEXT", false, 0, null, 1));
            map6.put(GifImagePreviewActivity.IMAGE_LIST, new e.a(GifImagePreviewActivity.IMAGE_LIST, "TEXT", false, 0, null, 1));
            map6.put(PushConstants.EXTRA_PUSH_MESSAGE_ID, new e.a(PushConstants.EXTRA_PUSH_MESSAGE_ID, "TEXT", false, 0, null, 1));
            map6.put(TtmlNode.TAG_STYLE, new e.a(TtmlNode.TAG_STYLE, "TEXT", false, 0, null, 1));
            map6.put(CampaignEx.JSON_KEY_TITLE, new e.a(CampaignEx.JSON_KEY_TITLE, "TEXT", false, 0, null, 1));
            e eVar6 = new e("permanent_msg", map6, new HashSet(0), new HashSet(0));
            e eVarA6 = e.a(gVar, "permanent_msg");
            if (!eVar6.equals(eVarA6)) {
                return new u.c(false, "permanent_msg(com.transsion.baselib.db.notification.PermanentMsgBean).\n Expected:\n" + eVar6 + "\n Found:\n" + eVarA6);
            }
            HashMap map7 = new HashMap(16);
            map7.put("resourceId", new e.a("resourceId", "TEXT", true, 1, null, 1));
            map7.put("postId", new e.a("postId", "TEXT", false, 0, null, 1));
            map7.put("url", new e.a("url", "TEXT", false, 0, null, 1));
            map7.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, new e.a(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, "TEXT", false, 0, null, 1));
            map7.put("lan", new e.a("lan", "TEXT", false, 0, null, 1));
            map7.put("lanName", new e.a("lanName", "TEXT", true, 0, null, 1));
            map7.put("subtitleName", new e.a("subtitleName", "TEXT", false, 0, null, 1));
            map7.put("size", new e.a("size", "INTEGER", false, 0, null, 1));
            map7.put("delayDuration", new e.a("delayDuration", "INTEGER", false, 0, null, 1));
            map7.put(NotificationCompat.CATEGORY_STATUS, new e.a(NotificationCompat.CATEGORY_STATUS, "INTEGER", true, 0, null, 1));
            map7.put("type", new e.a("type", "INTEGER", true, 0, null, 1));
            map7.put("fileCharsetName", new e.a("fileCharsetName", "TEXT", false, 0, null, 1));
            map7.put("subjectId", new e.a("subjectId", "TEXT", false, 0, null, 1));
            map7.put("ep", new e.a("ep", "INTEGER", true, 0, null, 1));
            map7.put("se", new e.a("se", "INTEGER", true, 0, null, 1));
            map7.put("resolution", new e.a("resolution", "INTEGER", true, 0, null, 1));
            e eVar7 = new e("download_subtitle_table", map7, new HashSet(0), new HashSet(0));
            e eVarA7 = e.a(gVar, "download_subtitle_table");
            if (!eVar7.equals(eVarA7)) {
                return new u.c(false, "download_subtitle_table(com.transsion.baselib.db.download.SubtitleBean).\n Expected:\n" + eVar7 + "\n Found:\n" + eVarA7);
            }
            HashMap map8 = new HashMap(16);
            map8.put("id", new e.a("id", "INTEGER", true, 1, null, 1));
            map8.put(CampaignEx.JSON_KEY_DEEP_LINK_URL, new e.a(CampaignEx.JSON_KEY_DEEP_LINK_URL, "TEXT", false, 0, null, 1));
            map8.put(CampaignEx.JSON_KEY_DESC, new e.a(CampaignEx.JSON_KEY_DESC, "TEXT", false, 0, null, 1));
            map8.put(GifImagePreviewActivity.IMAGE_LIST, new e.a(GifImagePreviewActivity.IMAGE_LIST, "TEXT", false, 0, null, 1));
            map8.put(PushConstants.EXTRA_PUSH_MESSAGE_ID, new e.a(PushConstants.EXTRA_PUSH_MESSAGE_ID, "TEXT", false, 0, null, 1));
            map8.put("source", new e.a("source", "TEXT", false, 0, null, 1));
            map8.put(TtmlNode.TAG_STYLE, new e.a(TtmlNode.TAG_STYLE, "TEXT", false, 0, null, 1));
            map8.put(CampaignEx.JSON_KEY_TITLE, new e.a(CampaignEx.JSON_KEY_TITLE, "TEXT", false, 0, null, 1));
            map8.put("type", new e.a("type", "TEXT", false, 0, null, 1));
            map8.put("receive_time", new e.a("receive_time", "INTEGER", false, 0, null, 1));
            map8.put("msg_status", new e.a("msg_status", "INTEGER", true, 0, null, 1));
            map8.put(TrackingKey.SHOW_TIME, new e.a(TrackingKey.SHOW_TIME, "INTEGER", false, 0, null, 1));
            map8.put("force_show", new e.a("force_show", "INTEGER", true, 0, null, 1));
            map8.put("has_screen_on", new e.a("has_screen_on", "INTEGER", true, 0, null, 1));
            map8.put("built_in", new e.a("built_in", "INTEGER", true, 0, null, 1));
            map8.put("permanent_msg_status", new e.a("permanent_msg_status", "INTEGER", true, 0, null, 1));
            e eVar8 = new e(NotificationCompat.CATEGORY_MESSAGE, map8, new HashSet(0), new HashSet(0));
            e eVarA8 = e.a(gVar, NotificationCompat.CATEGORY_MESSAGE);
            if (!eVar8.equals(eVarA8)) {
                return new u.c(false, "msg(com.transsion.baselib.db.notification.MsgBean).\n Expected:\n" + eVar8 + "\n Found:\n" + eVarA8);
            }
            HashMap map9 = new HashMap(5);
            map9.put("id", new e.a("id", "INTEGER", true, 1, null, 1));
            map9.put("updateTimeStamp", new e.a("updateTimeStamp", "INTEGER", true, 0, null, 1));
            map9.put("dataType", new e.a("dataType", "INTEGER", true, 0, null, 1));
            map9.put("appVersion", new e.a("appVersion", "INTEGER", true, 0, null, 1));
            map9.put("consumeJson", new e.a("consumeJson", "TEXT", false, 0, null, 1));
            e eVar9 = new e("consume_bean", map9, new HashSet(0), new HashSet(0));
            e eVarA9 = e.a(gVar, "consume_bean");
            if (!eVar9.equals(eVarA9)) {
                return new u.c(false, "consume_bean(com.transsion.baselib.db.consume.ConsumeBean).\n Expected:\n" + eVar9 + "\n Found:\n" + eVarA9);
            }
            HashMap map10 = new HashMap(6);
            map10.put("threadId", new e.a("threadId", "INTEGER", true, 1, null, 1));
            map10.put("rangeId", new e.a("rangeId", "INTEGER", true, 2, null, 1));
            map10.put("resourceId", new e.a("resourceId", "TEXT", false, 0, null, 1));
            map10.put("start", new e.a("start", "INTEGER", true, 0, null, 1));
            map10.put(TtmlNode.END, new e.a(TtmlNode.END, "INTEGER", true, 0, null, 1));
            map10.put(NotificationCompat.CATEGORY_PROGRESS, new e.a(NotificationCompat.CATEGORY_PROGRESS, "INTEGER", true, 0, null, 1));
            e eVar10 = new e("download_thread_range", map10, new HashSet(0), new HashSet(0));
            e eVarA10 = e.a(gVar, "download_thread_range");
            if (!eVar10.equals(eVarA10)) {
                return new u.c(false, "download_thread_range(com.transsion.baselib.db.download.DownloadRange).\n Expected:\n" + eVar10 + "\n Found:\n" + eVarA10);
            }
            HashMap map11 = new HashMap(3);
            map11.put("resourceId", new e.a("resourceId", "TEXT", true, 1, null, 1));
            map11.put("startAdDayKey", new e.a("startAdDayKey", "INTEGER", true, 0, null, 1));
            map11.put("endAdDayKey", new e.a("endAdDayKey", "INTEGER", true, 0, null, 1));
            e eVar11 = new e("video_land_ad", map11, new HashSet(0), new HashSet(0));
            e eVarA11 = e.a(gVar, "video_land_ad");
            if (!eVar11.equals(eVarA11)) {
                return new u.c(false, "video_land_ad(com.transsion.baselib.db.video.VideoLandAdBean).\n Expected:\n" + eVar11 + "\n Found:\n" + eVarA11);
            }
            HashMap map12 = new HashMap(4);
            map12.put("lan", new e.a("lan", "TEXT", true, 1, null, 1));
            map12.put("lanIOS3", new e.a("lanIOS3", "TEXT", false, 0, null, 1));
            map12.put("lanName", new e.a("lanName", "TEXT", true, 0, null, 1));
            map12.put("inSearch", new e.a("inSearch", "INTEGER", true, 0, null, 1));
            e eVar12 = new e("subtitle_language_map_table", map12, new HashSet(0), new HashSet(0));
            e eVarA12 = e.a(gVar, "subtitle_language_map_table");
            if (!eVar12.equals(eVarA12)) {
                return new u.c(false, "subtitle_language_map_table(com.transsion.baselib.db.download.SubtitleLanguageMapBean).\n Expected:\n" + eVar12 + "\n Found:\n" + eVarA12);
            }
            HashMap map13 = new HashMap(26);
            map13.put("id", new e.a("id", "TEXT", true, 1, null, 1));
            map13.put("version", new e.a("version", "TEXT", false, 0, null, 1));
            map13.put("name", new e.a("name", "TEXT", false, 0, null, 1));
            map13.put("startTime", new e.a("startTime", "TEXT", false, 0, null, 1));
            map13.put("endTime", new e.a("endTime", "TEXT", false, 0, null, 1));
            map13.put("extraConfig", new e.a("extraConfig", "TEXT", false, 0, null, 1));
            map13.put("displayTimes", new e.a("displayTimes", "INTEGER", false, 0, null, 1));
            map13.put("showedTimes", new e.a("showedTimes", "INTEGER", false, 0, null, 1));
            map13.put("showDate", new e.a("showDate", "TEXT", false, 0, null, 1));
            map13.put("advertiserName", new e.a("advertiserName", "TEXT", false, 0, null, 1));
            map13.put("advertiserAvatar", new e.a("advertiserAvatar", "TEXT", false, 0, null, 1));
            map13.put("advertiserAvatarPath", new e.a("advertiserAvatarPath", "TEXT", false, 0, null, 1));
            map13.put("brand", new e.a("brand", "TEXT", false, 0, null, 1));
            map13.put("denyBrand", new e.a("denyBrand", "TEXT", false, 0, null, 1));
            map13.put("model", new e.a("model", "TEXT", false, 0, null, 1));
            map13.put("denyModel", new e.a("denyModel", "TEXT", false, 0, null, 1));
            map13.put(PlaceTypes.COUNTRY, new e.a(PlaceTypes.COUNTRY, "TEXT", false, 0, null, 1));
            map13.put("scenes", new e.a("scenes", "TEXT", false, 0, null, 1));
            map13.put("adMaterialList", new e.a("adMaterialList", "TEXT", false, 0, null, 1));
            map13.put("adPlanUpdateTime", new e.a("adPlanUpdateTime", "TEXT", false, 0, null, 1));
            map13.put("sort", new e.a("sort", "INTEGER", false, 0, null, 1));
            map13.put("adShowLevel", new e.a("adShowLevel", "TEXT", false, 0, null, 1));
            map13.put("filterClientVersion", new e.a("filterClientVersion", "TEXT", false, 0, null, 1));
            map13.put("adPlanCreateTime", new e.a("adPlanCreateTime", "TEXT", false, 0, null, 1));
            map13.put("appStarDesc", new e.a("appStarDesc", "TEXT", false, 0, null, 1));
            map13.put("appSizeDesc", new e.a("appSizeDesc", "TEXT", false, 0, null, 1));
            e eVar13 = new e("non_ad_plans", map13, new HashSet(0), new HashSet(0));
            e eVarA13 = e.a(gVar, "non_ad_plans");
            if (!eVar13.equals(eVarA13)) {
                return new u.c(false, "non_ad_plans(com.transsion.baselib.db.non.NonAdPlans).\n Expected:\n" + eVar13 + "\n Found:\n" + eVarA13);
            }
            HashMap map14 = new HashMap(5);
            map14.put("id", new e.a("id", "INTEGER", true, 1, null, 1));
            map14.put("Country", new e.a("Country", "TEXT", true, 0, null, 1));
            map14.put("Mcc", new e.a("Mcc", "TEXT", true, 0, null, 1));
            map14.put("Iso", new e.a("Iso", "TEXT", true, 0, null, 1));
            map14.put("CountryCode", new e.a("CountryCode", "TEXT", true, 0, null, 1));
            e eVar14 = new e("local_mcc", map14, new HashSet(0), new HashSet(0));
            e eVarA14 = e.a(gVar, "local_mcc");
            if (!eVar14.equals(eVarA14)) {
                return new u.c(false, "local_mcc(com.transsion.baselib.db.mcc.LocalMcc).\n Expected:\n" + eVar14 + "\n Found:\n" + eVarA14);
            }
            HashMap map15 = new HashMap(13);
            map15.put("subjectId", new e.a("subjectId", "TEXT", true, 1, null, 1));
            map15.put("id", new e.a("id", "TEXT", true, 0, null, 1));
            map15.put("ep", new e.a("ep", "INTEGER", true, 0, null, 1));
            map15.put("se", new e.a("se", "INTEGER", true, 0, null, 1));
            map15.put("totalEp", new e.a("totalEp", "INTEGER", true, 0, null, 1));
            map15.put(NotificationCompat.CATEGORY_PROGRESS, new e.a(NotificationCompat.CATEGORY_PROGRESS, "INTEGER", true, 0, null, 1));
            map15.put(CampaignEx.JSON_KEY_TITLE, new e.a(CampaignEx.JSON_KEY_TITLE, "TEXT", false, 0, null, 1));
            map15.put(TrackingKey.DESCRIPTION, new e.a(TrackingKey.DESCRIPTION, "TEXT", false, 0, null, 1));
            map15.put("coverUrl", new e.a("coverUrl", "TEXT", false, 0, null, 1));
            map15.put("thumbnail", new e.a("thumbnail", "TEXT", false, 0, null, 1));
            map15.put("videoId", new e.a("videoId", "TEXT", false, 0, null, 1));
            map15.put("videoUrl", new e.a("videoUrl", "TEXT", false, 0, null, 1));
            map15.put("timeStamp", new e.a("timeStamp", "INTEGER", true, 0, null, 1));
            e eVar15 = new e("short_tv_play", map15, new HashSet(0), new HashSet(0));
            e eVarA15 = e.a(gVar, "short_tv_play");
            if (!eVar15.equals(eVarA15)) {
                return new u.c(false, "short_tv_play(com.transsion.baselib.db.video.ShortTVPlayBean).\n Expected:\n" + eVar15 + "\n Found:\n" + eVarA15);
            }
            HashMap map16 = new HashMap(4);
            map16.put("subjectId", new e.a("subjectId", "TEXT", true, 1, null, 1));
            map16.put("favoriteNum", new e.a("favoriteNum", "TEXT", false, 0, null, 1));
            map16.put("hasFavorite", new e.a("hasFavorite", "INTEGER", true, 0, null, 1));
            map16.put("favoriteTime", new e.a("favoriteTime", "TEXT", false, 0, null, 1));
            e eVar16 = new e("ShortTvFavoriteState", map16, new HashSet(0), new HashSet(0));
            e eVarA16 = e.a(gVar, "ShortTvFavoriteState");
            if (!eVar16.equals(eVarA16)) {
                return new u.c(false, "ShortTvFavoriteState(com.transsion.baselib.db.video.ShortTvFavoriteState).\n Expected:\n" + eVar16 + "\n Found:\n" + eVarA16);
            }
            HashMap map17 = new HashMap(26);
            map17.put("subjectId", new e.a("subjectId", "TEXT", true, 1, null, 1));
            map17.put("id", new e.a("id", "TEXT", true, 0, null, 1));
            map17.put("ep", new e.a("ep", "INTEGER", true, 2, null, 1));
            map17.put("se", new e.a("se", "INTEGER", true, 3, null, 1));
            map17.put(NotificationCompat.CATEGORY_PROGRESS, new e.a(NotificationCompat.CATEGORY_PROGRESS, "INTEGER", true, 0, null, 1));
            map17.put(CampaignEx.JSON_KEY_TITLE, new e.a(CampaignEx.JSON_KEY_TITLE, "TEXT", false, 0, null, 1));
            map17.put("coverUrl", new e.a("coverUrl", "TEXT", false, 0, null, 1));
            map17.put("thumbnail", new e.a("thumbnail", "TEXT", false, 0, null, 1));
            map17.put("videoUrl", new e.a("videoUrl", "TEXT", false, 0, null, 1));
            map17.put("timeStamp", new e.a("timeStamp", "INTEGER", true, 0, null, 1));
            map17.put("subtitleSelectId", new e.a("subtitleSelectId", "TEXT", false, 0, null, 1));
            map17.put("totalDuration", new e.a("totalDuration", "INTEGER", false, 0, null, 1));
            map17.put("subjectDurationSeconds", new e.a("subjectDurationSeconds", "INTEGER", false, 0, null, 1));
            map17.put("averageHueLight", new e.a("averageHueLight", "TEXT", false, 0, null, 1));
            map17.put("subjectType", new e.a("subjectType", "INTEGER", false, 0, null, 1));
            map17.put("hasDelete", new e.a("hasDelete", "INTEGER", true, 0, null, 1));
            map17.put("playMode", new e.a("playMode", "TEXT", true, 0, null, 1));
            map17.put("downloadUrl", new e.a("downloadUrl", "TEXT", false, 0, null, 1));
            map17.put("downloadFilePath", new e.a("downloadFilePath", "TEXT", false, 0, null, 1));
            map17.put("downloadSize", new e.a("downloadSize", "INTEGER", true, 0, null, 1));
            map17.put("dubs", new e.a("dubs", "TEXT", false, 0, null, 1));
            map17.put("lastAdStartTimeStamp", new e.a("lastAdStartTimeStamp", "INTEGER", false, 0, null, 1));
            map17.put("lastAdEndTimeStamp", new e.a("lastAdEndTimeStamp", "INTEGER", false, 0, null, 1));
            map17.put("rewardPlayed", new e.a("rewardPlayed", "INTEGER", true, 0, null, 1));
            map17.put("rewardUnlock", new e.a("rewardUnlock", "INTEGER", true, 0, null, 1));
            map17.put("rewardFree", new e.a("rewardFree", "INTEGER", true, 0, null, 1));
            e eVar17 = new e("video_detail_play", map17, new HashSet(0), new HashSet(0));
            e eVarA17 = e.a(gVar, "video_detail_play");
            if (!eVar17.equals(eVarA17)) {
                return new u.c(false, "video_detail_play(com.transsion.baselib.db.video.VideoDetailPlayBean).\n Expected:\n" + eVar17 + "\n Found:\n" + eVarA17);
            }
            HashMap map18 = new HashMap(11);
            map18.put("subjectId", new e.a("subjectId", "TEXT", true, 1, null, 1));
            map18.put(CampaignEx.JSON_KEY_TITLE, new e.a(CampaignEx.JSON_KEY_TITLE, "TEXT", false, 0, null, 1));
            map18.put("coverUrl", new e.a("coverUrl", "TEXT", false, 0, null, 1));
            map18.put("countryName", new e.a("countryName", "TEXT", false, 0, null, 1));
            map18.put("genre", new e.a("genre", "TEXT", false, 0, null, 1));
            map18.put("releaseDate", new e.a("releaseDate", "TEXT", false, 0, null, 1));
            map18.put("durationSeconds", new e.a("durationSeconds", "INTEGER", true, 0, null, 1));
            map18.put("singerName", new e.a("singerName", "TEXT", false, 0, null, 1));
            map18.put("singerAvatar", new e.a("singerAvatar", "TEXT", false, 0, null, 1));
            map18.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, new e.a(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, "TEXT", false, 0, null, 1));
            map18.put("timeStamp", new e.a("timeStamp", "INTEGER", true, 0, null, 1));
            e eVar18 = new e("music_liked", map18, new HashSet(0), new HashSet(0));
            e eVarA18 = e.a(gVar, "music_liked");
            if (!eVar18.equals(eVarA18)) {
                return new u.c(false, "music_liked(com.transsion.baselib.db.music.MusicLikedDbBean).\n Expected:\n" + eVar18 + "\n Found:\n" + eVarA18);
            }
            HashMap map19 = new HashMap(5);
            map19.put("latitude", new e.a("latitude", "REAL", true, 1, null, 1));
            map19.put("longitude", new e.a("longitude", "REAL", true, 2, null, 1));
            map19.put("name", new e.a("name", "TEXT", false, 0, null, 1));
            map19.put(PlaceTypes.ADDRESS, new e.a(PlaceTypes.ADDRESS, "TEXT", false, 0, null, 1));
            map19.put("distance", new e.a("distance", "TEXT", false, 0, null, 1));
            e eVar19 = new e("place_list", map19, new HashSet(0), new HashSet(0));
            e eVarA19 = e.a(gVar, "place_list");
            if (eVar19.equals(eVarA19)) {
                return new u.c(true, null);
            }
            return new u.c(false, "place_list(com.transsion.baselib.db.place.PlaceDBBean).\n Expected:\n" + eVar19 + "\n Found:\n" + eVarA19);
        }
    }

    @Override // com.transsion.baselib.db.AppDatabase
    public rr.a D0() {
        rr.a aVar;
        if (this.f51047m0 != null) {
            return this.f51047m0;
        }
        synchronized (this) {
            try {
                if (this.f51047m0 == null) {
                    this.f51047m0 = new rr.b(this);
                }
                aVar = this.f51047m0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    @Override // com.transsion.baselib.db.AppDatabase
    public c E0() {
        c cVar;
        if (this.f51048n0 != null) {
            return this.f51048n0;
        }
        synchronized (this) {
            try {
                if (this.f51048n0 == null) {
                    this.f51048n0 = new d(this);
                }
                cVar = this.f51048n0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return cVar;
    }

    @Override // com.transsion.baselib.db.AppDatabase
    public h F0() {
        h hVar;
        if (this.f51052r0 != null) {
            return this.f51052r0;
        }
        synchronized (this) {
            try {
                if (this.f51052r0 == null) {
                    this.f51052r0 = new i(this);
                }
                hVar = this.f51052r0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return hVar;
    }

    @Override // com.transsion.baselib.db.AppDatabase
    public xr.a G0() {
        xr.a aVar;
        if (this.f51051q0 != null) {
            return this.f51051q0;
        }
        synchronized (this) {
            try {
                if (this.f51051q0 == null) {
                    this.f51051q0 = new xr.b(this);
                }
                aVar = this.f51051q0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    @Override // com.transsion.baselib.db.AppDatabase
    public vr.a H0() {
        vr.a aVar;
        if (this.f51058x0 != null) {
            return this.f51058x0;
        }
        synchronized (this) {
            try {
                if (this.f51058x0 == null) {
                    this.f51058x0 = new vr.b(this);
                }
                aVar = this.f51058x0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    @Override // com.transsion.baselib.db.AppDatabase
    public PlaceDao I0() {
        PlaceDao placeDao;
        if (this.f51059y0 != null) {
            return this.f51059y0;
        }
        synchronized (this) {
            try {
                if (this.f51059y0 == null) {
                    this.f51059y0 = new com.transsion.baselib.db.place.a(this);
                }
                placeDao = this.f51059y0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return placeDao;
    }

    @Override // com.transsion.baselib.db.AppDatabase
    public yr.a J0() {
        yr.a aVar;
        if (this.f51049o0 != null) {
            return this.f51049o0;
        }
        synchronized (this) {
            try {
                if (this.f51049o0 == null) {
                    this.f51049o0 = new yr.b(this);
                }
                aVar = this.f51049o0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    @Override // com.transsion.baselib.db.AppDatabase
    public ShortTVPlayDao K0() {
        ShortTVPlayDao shortTVPlayDao;
        if (this.f51054t0 != null) {
            return this.f51054t0;
        }
        synchronized (this) {
            try {
                if (this.f51054t0 == null) {
                    this.f51054t0 = new com.transsion.baselib.db.video.b(this);
                }
                shortTVPlayDao = this.f51054t0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return shortTVPlayDao;
    }

    @Override // com.transsion.baselib.db.AppDatabase
    public IShortTvFavoriteStateDao L0() {
        IShortTvFavoriteStateDao iShortTvFavoriteStateDao;
        if (this.f51056v0 != null) {
            return this.f51056v0;
        }
        synchronized (this) {
            try {
                if (this.f51056v0 == null) {
                    this.f51056v0 = new com.transsion.baselib.db.video.a(this);
                }
                iShortTvFavoriteStateDao = this.f51056v0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return iShortTvFavoriteStateDao;
    }

    @Override // com.transsion.baselib.db.AppDatabase
    public m M0() {
        m mVar;
        if (this.f51050p0 != null) {
            return this.f51050p0;
        }
        synchronized (this) {
            try {
                if (this.f51050p0 == null) {
                    this.f51050p0 = new n(this);
                }
                mVar = this.f51050p0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return mVar;
    }

    @Override // com.transsion.baselib.db.AppDatabase
    public o N0() {
        o oVar;
        if (this.f51055u0 != null) {
            return this.f51055u0;
        }
        synchronized (this) {
            try {
                if (this.f51055u0 == null) {
                    this.f51055u0 = new p(this);
                }
                oVar = this.f51055u0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return oVar;
    }

    @Override // com.transsion.baselib.db.AppDatabase
    public VideoDetailPlayDao O0() {
        VideoDetailPlayDao videoDetailPlayDao;
        if (this.f51057w0 != null) {
            return this.f51057w0;
        }
        synchronized (this) {
            try {
                if (this.f51057w0 == null) {
                    this.f51057w0 = new com.transsion.baselib.db.video.e(this);
                }
                videoDetailPlayDao = this.f51057w0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return videoDetailPlayDao;
    }

    @Override // com.transsion.baselib.db.AppDatabase
    public f P0() {
        f fVar;
        if (this.f51053s0 != null) {
            return this.f51053s0;
        }
        synchronized (this) {
            try {
                if (this.f51053s0 == null) {
                    this.f51053s0 = new com.transsion.baselib.db.video.g(this);
                }
                fVar = this.f51053s0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return fVar;
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker g() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), MimeTypes.BASE_TYPE_AUDIO, "download_table", "video", "download_thread_info", "room_table", "permanent_msg", "download_subtitle_table", NotificationCompat.CATEGORY_MESSAGE, "consume_bean", "download_thread_range", "video_land_ad", "subtitle_language_map_table", "non_ad_plans", "local_mcc", "short_tv_play", "ShortTvFavoriteState", "video_detail_play", "music_liked", "place_list");
    }

    @Override // androidx.room.RoomDatabase
    public g6.h h(androidx.room.f fVar) {
        return fVar.f12842c.a(g6.h.b.a(fVar.f12840a).d(fVar.f12841b).c(new u(fVar, new a(48), "de426e98025aef5d335cf70708de8ce2", "ad1db06d3b44787570030ec6b568d251")).b());
    }

    @Override // androidx.room.RoomDatabase
    public List<d6.b> j(@NonNull Map<Class<? extends d6.a>, d6.a> map) {
        return Arrays.asList(new d6.b[0]);
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends d6.a>> p() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public Map<Class<?>, List<Class<?>>> q() {
        HashMap map = new HashMap();
        map.put(rr.a.class, rr.b.n());
        map.put(c.class, d.R());
        map.put(com.transsion.baselib.db.video.c.class, com.transsion.baselib.db.video.d.a());
        map.put(k.class, l.a());
        map.put(yr.a.class, yr.b.g());
        map.put(m.class, n.j());
        map.put(xr.c.class, xr.d.a());
        map.put(xr.a.class, xr.b.l());
        map.put(sr.a.class, sr.b.a());
        map.put(wr.a.class, wr.b.a());
        map.put(ur.a.class, ur.b.a());
        map.put(h.class, i.g());
        map.put(f.class, com.transsion.baselib.db.video.g.a());
        map.put(ShortTVPlayDao.class, com.transsion.baselib.db.video.b.j());
        map.put(o.class, p.g());
        map.put(IShortTvFavoriteStateDao.class, com.transsion.baselib.db.video.a.h());
        map.put(VideoDetailPlayDao.class, com.transsion.baselib.db.video.e.z());
        map.put(vr.a.class, vr.b.j());
        map.put(PlaceDao.class, com.transsion.baselib.db.place.a.h());
        return map;
    }
}
