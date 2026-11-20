package com.transsion.push.db;

import android.content.Context;
import android.util.Log;
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
public abstract class PermanentPushDatabase extends RoomDatabase {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f56857p = new a(null);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile PermanentPushDatabase f56858q;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a {

        /* JADX INFO: renamed from: com.transsion.push.db.PermanentPushDatabase$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0593a extends RoomDatabase.b {
            @Override // androidx.room.RoomDatabase.b
            public void a(g db2) {
                Intrinsics.g(db2, "db");
                super.a(db2);
                Log.e("PUSH_SHOW", "PermanentPushDatabase --> getInstance() --> buildDatabase() --> onCreate() --> db_name is = " + db2.getPath());
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PermanentPushDatabase a(Context context) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.f(applicationContext, "context.applicationContext");
            return (PermanentPushDatabase) r.a(applicationContext, PermanentPushDatabase.class, "permanent_database").a(new C0593a()).d();
        }

        public final PermanentPushDatabase b(Context context) {
            Intrinsics.g(context, "context");
            PermanentPushDatabase permanentPushDatabase = PermanentPushDatabase.f56858q;
            if (permanentPushDatabase == null) {
                synchronized (this) {
                    permanentPushDatabase = PermanentPushDatabase.f56858q;
                    if (permanentPushDatabase == null) {
                        PermanentPushDatabase permanentPushDatabaseA = PermanentPushDatabase.f56857p.a(context);
                        PermanentPushDatabase.f56858q = permanentPushDatabaseA;
                        permanentPushDatabase = permanentPushDatabaseA;
                    }
                }
            }
            return permanentPushDatabase;
        }
    }

    public abstract com.transsion.push.db.a I();
}
