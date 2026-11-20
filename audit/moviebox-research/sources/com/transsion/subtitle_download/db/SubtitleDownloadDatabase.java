package com.transsion.subtitle_download.db;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.room.r;
import g6.g;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class SubtitleDownloadDatabase extends RoomDatabase {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile SubtitleDownloadDatabase f58353q;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final b f58352p = new b(null);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f58354r = new a();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends d6.b {
        public a() {
            super(1, 2);
        }

        @Override // d6.b
        public void a(g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE ST_DOWNLOAD_TABLE ADD COLUMN failCount INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class b {

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a extends RoomDatabase.b {
            @Override // androidx.room.RoomDatabase.b
            public void a(g db2) {
                Intrinsics.g(db2, "db");
                super.a(db2);
                com.transsion.subtitle_download.utils.b.f58375a.b("SubtitleDownloadDataBase --> getInstance() --> buildDatabase() --> onCreate() --> db_name is = " + db2.getPath());
            }

            @Override // androidx.room.RoomDatabase.b
            public void c(g db2) {
                Intrinsics.g(db2, "db");
                super.c(db2);
                com.transsion.subtitle_download.utils.b.f58375a.b("SubtitleDownloadDataBase --> getInstance() --> buildDatabase() --> onOpen()");
            }
        }

        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SubtitleDownloadDatabase a(Context context) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.f(applicationContext, "context.applicationContext");
            return (SubtitleDownloadDatabase) r.a(applicationContext, SubtitleDownloadDatabase.class, "oneroom-subtitle-db").c().b(SubtitleDownloadDatabase.f58354r).a(new a()).d();
        }

        public final SubtitleDownloadDatabase b(Context context) {
            Intrinsics.g(context, "context");
            SubtitleDownloadDatabase subtitleDownloadDatabase = SubtitleDownloadDatabase.f58353q;
            if (subtitleDownloadDatabase == null) {
                synchronized (this) {
                    subtitleDownloadDatabase = SubtitleDownloadDatabase.f58353q;
                    if (subtitleDownloadDatabase == null) {
                        SubtitleDownloadDatabase subtitleDownloadDatabaseA = SubtitleDownloadDatabase.f58352p.a(context);
                        SubtitleDownloadDatabase.f58353q = subtitleDownloadDatabaseA;
                        subtitleDownloadDatabase = subtitleDownloadDatabaseA;
                    }
                }
            }
            return subtitleDownloadDatabase;
        }
    }

    public abstract dy.a J();
}
