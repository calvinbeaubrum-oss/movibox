package com.transsion.ad.db;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class MbAdDatabase extends RoomDatabase {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile MbAdDatabase f50388q;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final e f50387p = new e(null);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f50389r = new a();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final b f50390s = new b();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final c f50391t = new c();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final d f50392u = new d();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends d6.b {
        public a() {
            super(1, 2);
        }

        @Override // d6.b
        public void a(g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE MB_AD_DB_PLANS ADD COLUMN dispatchTimeStart TEXT");
            database.E("ALTER TABLE MB_AD_DB_PLANS ADD COLUMN dispatchTimeEnd TEXT");
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends d6.b {
        public b() {
            super(2, 3);
        }

        @Override // d6.b
        public void a(g database) {
            Intrinsics.g(database, "database");
            database.E("CREATE TABLE IF NOT EXISTS LOCAL_MCC (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Country` TEXT NOT NULL, `Mcc` TEXT NOT NULL, `Iso` TEXT NOT NULL, `CountryCode` TEXT NOT NULL)");
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends d6.b {
        public c() {
            super(3, 4);
        }

        @Override // d6.b
        public void a(g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE MB_AD_DB_PLANS ADD COLUMN adSource TEXT");
            database.E("ALTER TABLE MB_AD_DB_PLANS ADD COLUMN extAdSlot TEXT");
            database.E("CREATE TABLE IF NOT EXISTS ps_link_ad (`id` INTEGER NOT NULL,`nonId` TEXT NOT NULL, `adSource` TEXT NOT NULL, `extAdSlot` TEXT NOT NULL, `rank` INTEGER NOT NULL, `psPlanId` TEXT, `psLinkAdInfoStr` TEXT, `psInfoJson` TEXT, PRIMARY KEY(`id`))");
            database.E("ALTER TABLE MB_AD_DB_PLANS ADD COLUMN extImage TEXT");
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends d6.b {
        public d() {
            super(4, 5);
        }

        @Override // d6.b
        public void a(g database) {
            Intrinsics.g(database, "database");
            database.E("ALTER TABLE mb_ad_db_plans ADD COLUMN bidEcpmCent REAL");
            database.E("ALTER TABLE mb_ad_db_plans ADD COLUMN ecpmCent INTEGER");
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class e {

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a extends RoomDatabase.b {
            @Override // androidx.room.RoomDatabase.b
            public void a(g db2) {
                Intrinsics.g(db2, "db");
                super.a(db2);
                com.transsion.ad.a.t(com.transsion.ad.a.f50276a, a.class.getSimpleName() + " --> getInstance() --> buildDatabase() --> onCreate() --> db.path = " + db2.getPath(), false, 2, null);
            }

            @Override // androidx.room.RoomDatabase.b
            public void c(g db2) {
                Intrinsics.g(db2, "db");
                super.c(db2);
                com.transsion.ad.a.t(com.transsion.ad.a.f50276a, a.class.getSimpleName() + " --> getInstance() --> buildDatabase() --> onOpen()", false, 2, null);
            }
        }

        public e() {
        }

        public /* synthetic */ e(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MbAdDatabase a(Context context) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.f(applicationContext, "context.applicationContext");
            return (MbAdDatabase) r.a(applicationContext, MbAdDatabase.class, "mb-ad-plans-db").b(MbAdDatabase.f50389r, MbAdDatabase.f50390s, MbAdDatabase.f50391t, MbAdDatabase.f50392u).a(new a()).d();
        }

        public final MbAdDatabase b(Context context) {
            Intrinsics.g(context, "context");
            MbAdDatabase mbAdDatabase = MbAdDatabase.f50388q;
            if (mbAdDatabase == null) {
                synchronized (this) {
                    mbAdDatabase = MbAdDatabase.f50388q;
                    if (mbAdDatabase == null) {
                        MbAdDatabase mbAdDatabaseA = MbAdDatabase.f50387p.a(context);
                        MbAdDatabase.f50388q = mbAdDatabaseA;
                        mbAdDatabase = mbAdDatabaseA;
                    }
                }
            }
            return mbAdDatabase;
        }
    }

    public abstract qq.a M();

    public abstract rq.a N();

    public abstract sq.a O();
}
