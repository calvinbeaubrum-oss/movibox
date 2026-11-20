package com.transsion.baselib.db;

import android.os.Environment;
import androidx.room.RoomDatabase;
import g6.g;
import java.io.File;
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
public abstract class AppEsDatabase extends RoomDatabase {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final b f51061p = new b(null);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static String f51062q = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar + "OneRoom/config";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f51063r = new a();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends d6.b {
        public a() {
            super(1, 2);
        }

        @Override // d6.b
        public void a(g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE DOWNLOAD_ES_TABLE ADD COLUMN subjectId TEXT");
            database.E("ALTER TABLE DOWNLOAD_ES_TABLE ADD COLUMN groupId TEXT");
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
