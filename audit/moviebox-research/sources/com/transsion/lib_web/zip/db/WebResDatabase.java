package com.transsion.lib_web.zip.db;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.room.r;
import g6.g;
import hu.h;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class WebResDatabase extends RoomDatabase {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile WebResDatabase f53074q;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final b f53073p = new b(null);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f53075r = new a();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends d6.b {
        public a() {
            super(1, 2);
        }

        @Override // d6.b
        public void a(g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN postId TEXT");
            database.E("ALTER TABLE AUDIO ADD COLUMN ops TEXT");
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
                h.f66795a.c("WebResDatabase --> getInstance() --> buildDatabase() --> onCreate() --> db.path = " + db2.getPath());
            }

            @Override // androidx.room.RoomDatabase.b
            public void c(g db2) {
                Intrinsics.g(db2, "db");
                super.c(db2);
                h.f66795a.c("WebResDatabase --> getInstance() --> buildDatabase() --> onOpen()");
            }
        }

        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WebResDatabase a(Context context) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.f(applicationContext, "context.applicationContext");
            return (WebResDatabase) r.a(applicationContext, WebResDatabase.class, "mb-web-res-db").b(new d6.b[0]).a(new a()).d();
        }

        public final WebResDatabase b(Context context) {
            Intrinsics.g(context, "context");
            WebResDatabase webResDatabase = WebResDatabase.f53074q;
            if (webResDatabase == null) {
                synchronized (this) {
                    webResDatabase = WebResDatabase.f53074q;
                    if (webResDatabase == null) {
                        WebResDatabase webResDatabaseA = WebResDatabase.f53073p.a(context);
                        WebResDatabase.f53074q = webResDatabaseA;
                        webResDatabase = webResDatabaseA;
                    }
                }
            }
            return webResDatabase;
        }
    }

    public abstract ju.a I();
}
