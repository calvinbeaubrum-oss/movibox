package com.transsion.baselib.db;

import android.content.Context;
import androidx.room.RoomDatabase;
import com.transsion.baselib.db.place.PlaceDao;
import com.transsion.baselib.db.video.IShortTvFavoriteStateDao;
import com.transsion.baselib.db.video.ShortTVPlayDao;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public abstract class AppDatabase extends RoomDatabase {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile AppDatabase f51037q;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final v0 f51036p = new v0(null);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final k f51038r = new k();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final v f51039s = new v();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final g0 f51040t = new g0();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final p0 f51041u = new p0();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final q0 f51042v = new q0();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final r0 f51043w = new r0();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final s0 f51044x = new s0();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final t0 f51045y = new t0();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final u0 f51046z = new u0();
    public static final a A = new a();
    public static final b B = new b();
    public static final c C = new c();
    public static final d D = new d();
    public static final e E = new e();
    public static final f F = new f();
    public static final g G = new g();
    public static final h H = new h();
    public static final i I = new i();
    public static final j J = new j();
    public static final l K = new l();
    public static final m L = new m();
    public static final n M = new n();
    public static final o N = new o();
    public static final p O = new p();
    public static final q P = new q();
    public static final r Q = new r();
    public static final s R = new s();
    public static final t S = new t();
    public static final u T = new u();
    public static final w U = new w();
    public static final x V = new x();
    public static final y W = new y();
    public static final z X = new z();
    public static final a0 Y = new a0();
    public static final b0 Z = new b0();

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final c0 f51024a0 = new c0();

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final d0 f51025b0 = new d0();

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final e0 f51026c0 = new e0();

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final f0 f51027d0 = new f0();

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final h0 f51028e0 = new h0();

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final i0 f51029f0 = new i0();

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final j0 f51030g0 = new j0();

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final k0 f51031h0 = new k0();

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final l0 f51032i0 = new l0();

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final m0 f51033j0 = new m0();

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final n0 f51034k0 = new n0();

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final o0 f51035l0 = new o0();

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a extends d6.b {
        public a() {
            super(10, 11);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("CREATE TABLE IF NOT EXISTS DOWNLOAD_THREAD_RANGE (`threadId` INTEGER NOT NULL, `rangeId` INTEGER NOT NULL, `resourceId` TEXT, `start` INTEGER NOT NULL, `end` INTEGER NOT NULL, `progress` INTEGER NOT NULL, PRIMARY KEY(`threadId`, `rangeId`))");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD subjectName TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD lastPlayTimeStamp INTEGER NOT NULL DEFAULT 0");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD fileType INTEGER NOT NULL DEFAULT 1");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a0 extends d6.b {
        public a0() {
            super(34, 35);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("CREATE TABLE IF NOT EXISTS VIDEO_DETAIL_PLAY (`subjectId` TEXT NOT NULL, `id` TEXT NOT NULL, `ep` INTEGER NOT NULL, `se` INTEGER NOT NULL, `progress` INTEGER NOT NULL, `title` TEXT, `coverUrl` TEXT, `thumbnail` TEXT, `videoUrl` TEXT, `timeStamp` INTEGER NOT NULL, PRIMARY KEY(`subjectId`))");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class b extends d6.b {
        public b() {
            super(11, 12);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE AUDIO ADD subjectTitle TEXT");
            database.E("ALTER TABLE AUDIO ADD se INTEGER NOT NULL DEFAULT 0");
            database.E("ALTER TABLE AUDIO ADD ep INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class b0 extends d6.b {
        public b0() {
            super(35, 36);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE VIDEO_DETAIL_PLAY ADD subtitleSelectId TEXT");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class c extends d6.b {
        public c() {
            super(12, 13);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD ep INTEGER NOT NULL DEFAULT 0");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD se INTEGER NOT NULL DEFAULT 0");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD videoWidth INTEGER NOT NULL DEFAULT 0");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD videoHeight INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class c0 extends d6.b {
        public c0() {
            super(36, 37);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE NON_AD_PLANS ADD adShowLevel TEXT");
            database.E("ALTER TABLE NON_AD_PLANS ADD filterClientVersion TEXT");
            database.E("ALTER TABLE NON_AD_PLANS ADD adPlanCreateTime TEXT");
            database.E("ALTER TABLE NON_AD_PLANS ADD appStarDesc TEXT");
            database.E("ALTER TABLE NON_AD_PLANS ADD appSizeDesc TEXT");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class d extends d6.b {
        public d() {
            super(13, 14);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD totalEpisode INTEGER NOT NULL DEFAULT 1");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class d0 extends d6.b {
        public d0() {
            super(37, 38);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD averageHueLight TEXT");
            database.E("CREATE TABLE IF NOT EXISTS VIDEO_DETAIL_PLAY_NEW (`subjectId` TEXT NOT NULL, `id` TEXT NOT NULL, `ep` INTEGER NOT NULL, `se` INTEGER NOT NULL, `progress` INTEGER NOT NULL, `title` TEXT, `coverUrl` TEXT, `thumbnail` TEXT, `videoUrl` TEXT, `timeStamp` INTEGER NOT NULL, `subtitleSelectId` TEXT, `totalDuration` INTEGER DEFAULT 0, `averageHueLight` TEXT, `subjectType` INTEGER, `hasDelete` INTEGER NOT NULL DEFAULT 0, `playMode` TEXT NOT NULL DEFAULT `2`, `downloadUrl` TEXT, `downloadFilePath` TEXT, `downloadSize` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`subjectId`, `ep`, `se`))");
            database.E("INSERT OR IGNORE INTO `VIDEO_DETAIL_PLAY_NEW` (subjectId, id, ep, se, progress, title, coverUrl, thumbnail, videoUrl, timeStamp, subtitleSelectId) SELECT subjectId, id, ep, se, progress, title, coverUrl, thumbnail, videoUrl, timeStamp, subtitleSelectId FROM `VIDEO_DETAIL_PLAY`");
            database.E("INSERT OR IGNORE INTO `VIDEO_DETAIL_PLAY_NEW` (subjectId, id, ep, se, progress, title, coverUrl, thumbnail, videoUrl, timeStamp, subtitleSelectId, totalDuration, averageHueLight, subjectType, hasDelete, playMode, downloadUrl, downloadFilePath, downloadSize) SELECT subjectId, resourceId, ep, se, progress, subjectName, cover, thumbnail, url, lastPlayTimeStamp, subtitleSelectId, duration, averageHueLight, subjectType, 0, 1, url, path, size FROM `download_table` WHERE (type in (2,3,5)) AND fileType = 1 AND lastPlayTimeStamp > 0 ORDER BY updateTimeStamp DESC");
            database.E("DROP TABLE VIDEO_DETAIL_PLAY");
            database.E("ALTER TABLE VIDEO_DETAIL_PLAY_NEW RENAME TO VIDEO_DETAIL_PLAY");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class e extends d6.b {
        public e() {
            super(14, 15);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD downloadErrorCount INTEGER NOT NULL DEFAULT 0");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD subtitleStarted INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class e0 extends d6.b {
        public e0() {
            super(38, 39);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD genre TEXT");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class f extends d6.b {
        public f() {
            super(15, 16);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD resolution INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class f0 extends d6.b {
        public f0() {
            super(39, 40);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE VIDEO_DETAIL_PLAY ADD COLUMN dubs TEXT");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class g extends d6.b {
        public g() {
            super(16, 17);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD multiresolution INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class g0 extends d6.b {
        public g0() {
            super(3, 4);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD resourceId TEXT");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class h extends d6.b {
        public h() {
            super(17, 18);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD resourcePosition INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class h0 extends d6.b {
        public h0() {
            super(40, 41);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE VIDEO_DETAIL_PLAY ADD subjectDurationSeconds INTEGER DEFAULT 0");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD subjectDurationSeconds INTEGER DEFAULT 0");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class i extends d6.b {
        public i() {
            super(18, 19);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD uploadBy TEXT ");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD sourceUrl TEXT ");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class i0 extends d6.b {
        public i0() {
            super(41, 42);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE VIDEO_DETAIL_PLAY ADD lastAdStartTimeStamp INTEGER");
            database.E("ALTER TABLE VIDEO_DETAIL_PLAY ADD lastAdEndTimeStamp INTEGER");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class j extends d6.b {
        public j() {
            super(19, 20);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE MSG ADD built_in INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class j0 extends d6.b {
        public j0() {
            super(42, 43);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN currentDubLanCode TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN currentDubLanName TEXT");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class k extends d6.b {
        public k() {
            super(1, 2);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN postId TEXT");
            database.E("ALTER TABLE AUDIO ADD COLUMN ops TEXT");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class k0 extends d6.b {
        public k0() {
            super(43, 44);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("CREATE TABLE IF NOT EXISTS MUSIC_LIKED (`subjectId` TEXT NOT NULL, `title` TEXT, `coverUrl` TEXT, `countryName` TEXT, `genre` TEXT, `releaseDate` TEXT, `durationSeconds` INTEGER NOT NULL DEFAULT 0, `singerName` TEXT, `singerAvatar` TEXT, `path` TEXT, `timeStamp` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`subjectId`))");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD ops TEXT");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class l extends d6.b {
        public l() {
            super(20, 21);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("CREATE TABLE IF NOT EXISTS VIDEO_LAND_AD (`resourceId` TEXT NOT NULL, `startAdDayKey` INTEGER NOT NULL, `endAdDayKey` INTEGER NOT NULL, PRIMARY KEY(`resourceId`))");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class l0 extends d6.b {
        public l0() {
            super(44, 45);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN restrictLevel TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN releaseDate TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN countryName TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN subtitles TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN imdbRate TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN seNum INTEGER");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class m extends d6.b {
        public m() {
            super(21, 22);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD urlCreateAt INTEGER NOT NULL DEFAULT 0");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD subtitleSelectId TEXT");
            database.E("ALTER TABLE DOWNLOAD_SUBTITLE_TABLE ADD subtitleName TEXT");
            database.E("ALTER TABLE DOWNLOAD_SUBTITLE_TABLE ADD type INTEGER NOT NULL DEFAULT 1");
            database.E("CREATE TABLE IF NOT EXISTS SUBTITLE_LANGUAGE_MAP_TABLE (`lan` TEXT NOT NULL, `lanName` TEXT NOT NULL, `inSearch` INTEGER NOT NULL, PRIMARY KEY(`lan`))");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class m0 extends d6.b {
        public m0() {
            super(45, 46);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("CREATE TABLE IF NOT EXISTS `place_list` (`latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `name` TEXT, `address` TEXT, `distance` TEXT, PRIMARY KEY(`latitude`, `longitude`))");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class n extends d6.b {
        public n() {
            super(22, 23);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE MSG ADD permanent_msg_status INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class n0 extends d6.b {
        public n0() {
            super(46, 47);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN lastAdStartTimeStamp INTEGER");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN lastAdEndTimeStamp INTEGER");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class o extends d6.b {
        public o() {
            super(23, 24);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD taskId TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD sessionTime INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class o0 extends d6.b {
        public o0() {
            super(47, 48);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE VIDEO_DETAIL_PLAY ADD COLUMN rewardPlayed INTEGER NOT NULL DEFAULT 0");
            database.E("ALTER TABLE VIDEO_DETAIL_PLAY ADD COLUMN rewardUnlock INTEGER NOT NULL DEFAULT 0");
            database.E("ALTER TABLE VIDEO_DETAIL_PLAY ADD COLUMN rewardFree INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class p extends d6.b {
        public p() {
            super(24, 25);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD reportStatus INTEGER NOT NULL DEFAULT 0");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD downloadHeaderSize INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class p0 extends d6.b {
        public p0() {
            super(4, 5);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE AUDIO ADD COLUMN resourceId TEXT");
            database.E("ALTER TABLE AUDIO ADD COLUMN postId TEXT");
            database.E("ALTER TABLE AUDIO ADD COLUMN subjectId TEXT");
            database.E("ALTER TABLE AUDIO ADD COLUMN groupId TEXT");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class q extends d6.b {
        public q() {
            super(25, 26);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE DOWNLOAD_SUBTITLE_TABLE ADD fileCharsetName TEXT");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class q0 extends d6.b {
        public q0() {
            super(5, 6);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("CREATE TABLE IF NOT EXISTS `DOWNLOAD_SUBTITLE_TABLE` (`resourceId` TEXT NOT NULL, `postId` TEXT, `url` TEXT, `path` TEXT, `lan` TEXT, `lanName` TEXT NOT NULL, `size` INTEGER,`delayDuration` INTEGER, `status` INTEGER NOT NULL, PRIMARY KEY(`resourceId`))");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD episode INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class r extends d6.b {
        public r() {
            super(26, 27);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD rootPath TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD rootPathType INTEGER NOT NULL DEFAULT 1");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD thumbnail TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD isTransferFailed INTEGER NOT NULL DEFAULT 0");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD isClosedTransferFailed INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class r0 extends d6.b {
        public r0() {
            super(6, 7);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD pageFrom TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD lastPageFrom TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD subjectId TEXT");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class s extends d6.b {
        public s() {
            super(27, 28);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE DOWNLOAD_SUBTITLE_TABLE ADD subjectId TEXT");
            database.E("ALTER TABLE DOWNLOAD_SUBTITLE_TABLE ADD ep INTEGER NOT NULL DEFAULT 0");
            database.E("ALTER TABLE DOWNLOAD_SUBTITLE_TABLE ADD se INTEGER NOT NULL DEFAULT 0");
            database.E("ALTER TABLE DOWNLOAD_SUBTITLE_TABLE ADD resolution INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class s0 extends d6.b {
        public s0() {
            super(7, 8);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("CREATE TABLE IF NOT EXISTS PERMANENT_MSG (`id` INTEGER NOT NULL, `deep_link_list` TEXT, `desc` TEXT, `image_list` TEXT, `message_id` TEXT, `style` TEXT, `title` TEXT, PRIMARY KEY(`id`))");
            database.E("CREATE TABLE IF NOT EXISTS MSG (`id` INTEGER NOT NULL, `deep_link` TEXT, `desc` TEXT, `image_list` TEXT, `message_id` TEXT, `style` TEXT, `title` TEXT, `source` TEXT, `type` TEXT, `receive_time` INTEGER, `msg_status` INTEGER NOT NULL, `show_time` INTEGER, `force_show` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class t extends d6.b {
        public t() {
            super(28, 29);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE SUBTITLE_LANGUAGE_MAP_TABLE ADD lanIOS3 TEXT");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class t0 extends d6.b {
        public t0() {
            super(8, 9);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE MSG ADD `has_screen_on` INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class u extends d6.b {
        public u() {
            super(29, 30);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("CREATE TABLE IF NOT EXISTS SHORT_TV_PLAY (`subjectId` TEXT NOT NULL, `id` TEXT NOT NULL, `ep` INTEGER NOT NULL, `se` INTEGER NOT NULL, `totalEp` INTEGER NOT NULL, `progress` INTEGER NOT NULL, `title` TEXT, `description` TEXT, `coverUrl` TEXT, `thumbnail` TEXT, `videoId` TEXT, `videoUrl` TEXT, `timeStamp` INTEGER NOT NULL, PRIMARY KEY(`subjectId`))");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class u0 extends d6.b {
        public u0() {
            super(9, 10);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("CREATE TABLE IF NOT EXISTS CONSUME_BEAN (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `updateTimeStamp` INTEGER NOT NULL,`dataType` INTEGER NOT NULL,`appVersion` INTEGER NOT NULL, `consumeJson` TEXT)");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class v extends d6.b {
        public v() {
            super(2, 3);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD isRead INTEGER NOT NULL DEFAULT 1");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    @SourceDebugExtension
    public static final class v0 {

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a extends RoomDatabase.b {
            @Override // androidx.room.RoomDatabase.b
            public void a(g6.g db2) {
                Intrinsics.g(db2, "db");
                super.a(db2);
                uo.b.a.f(uo.b.f78622a, "database", "onCreate db_name is=" + db2.getPath(), false, 4, null);
            }
        }

        public v0() {
        }

        public /* synthetic */ v0(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AppDatabase a(Context context) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.f(applicationContext, "context.applicationContext");
            return (AppDatabase) androidx.room.r.a(applicationContext, AppDatabase.class, "oneroom-db").c().b(AppDatabase.f51038r, AppDatabase.f51039s, AppDatabase.f51040t, AppDatabase.f51041u, AppDatabase.f51042v, AppDatabase.f51043w, AppDatabase.f51044x, AppDatabase.f51045y, AppDatabase.f51046z, AppDatabase.A, AppDatabase.B, AppDatabase.C, AppDatabase.D, AppDatabase.E, AppDatabase.F, AppDatabase.G, AppDatabase.H, AppDatabase.I, AppDatabase.J, AppDatabase.K, AppDatabase.L, AppDatabase.M, AppDatabase.N, AppDatabase.O, AppDatabase.P, AppDatabase.Q, AppDatabase.R, AppDatabase.S, AppDatabase.T, AppDatabase.U, AppDatabase.V, AppDatabase.W, AppDatabase.X, AppDatabase.Y, AppDatabase.Z, AppDatabase.f51024a0, AppDatabase.f51025b0, AppDatabase.f51026c0, AppDatabase.f51027d0, AppDatabase.f51028e0, AppDatabase.f51029f0, AppDatabase.f51030g0, AppDatabase.f51031h0, AppDatabase.f51032i0, AppDatabase.f51033j0, AppDatabase.f51034k0, AppDatabase.f51035l0).a(new a()).d();
        }

        public final AppDatabase b(Context context) {
            Intrinsics.g(context, "context");
            AppDatabase appDatabase = AppDatabase.f51037q;
            if (appDatabase == null) {
                synchronized (this) {
                    appDatabase = AppDatabase.f51037q;
                    if (appDatabase == null) {
                        AppDatabase appDatabaseA = AppDatabase.f51036p.a(context);
                        AppDatabase.f51037q = appDatabaseA;
                        appDatabase = appDatabaseA;
                    }
                }
            }
            return appDatabase;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class w extends d6.b {
        public w() {
            super(30, 31);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("CREATE TABLE IF NOT EXISTS NON_AD_PLANS (`id` TEXT NOT NULL, `version` TEXT, `name` TEXT, `startTime` TEXT, `endTime` TEXT, `extraConfig` TEXT, `displayTimes` INTEGER, `showedTimes` INTEGER, `showDate` TEXT, `advertiserName` TEXT, `advertiserAvatar` TEXT, `advertiserAvatarPath` TEXT, `brand` TEXT, `denyBrand` TEXT, `model` TEXT, `denyModel` TEXT, `country` TEXT, `scenes` TEXT, `adMaterialList` TEXT, PRIMARY KEY(`id`))");
            database.E("CREATE TABLE IF NOT EXISTS LOCAL_MCC (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Country` TEXT NOT NULL, `Mcc` TEXT NOT NULL, `Iso` TEXT NOT NULL, `CountryCode` TEXT NOT NULL)");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class x extends d6.b {
        public x() {
            super(31, 32);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE NON_AD_PLANS ADD adPlanUpdateTime TEXT");
            database.E("ALTER TABLE NON_AD_PLANS ADD sort INTEGER");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class y extends d6.b {
        public y() {
            super(32, 33);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD subjectType INTEGER NOT NULL DEFAULT 1");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class z extends d6.b {
        public z() {
            super(33, 34);
        }

        @Override // d6.b
        public void a(g6.g database) {
            Intrinsics.g(database, "database");
            database.E("CREATE TABLE IF NOT EXISTS ShortTvFavoriteState (`subjectId` TEXT NOT NULL, `favoriteNum` TEXT, `hasFavorite` INTEGER not null default 0,`favoriteTime` TEXT, PRIMARY KEY(`subjectId`))");
        }
    }

    public abstract rr.a D0();

    public abstract tr.c E0();

    public abstract tr.h F0();

    public abstract xr.a G0();

    public abstract vr.a H0();

    public abstract PlaceDao I0();

    public abstract yr.a J0();

    public abstract ShortTVPlayDao K0();

    public abstract IShortTvFavoriteStateDao L0();

    public abstract tr.m M0();

    public abstract tr.o N0();

    public abstract VideoDetailPlayDao O0();

    public abstract com.transsion.baselib.db.video.f P0();
}
