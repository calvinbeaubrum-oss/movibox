package com.cloud.hisavana.sdk;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class o0 extends SQLiteOpenHelper {

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o0 f29943a = new o0(com.cloud.sdk.commonutil.util.f.a());
    }

    public o0(Context context) {
        super(context, "hisavana.db", (SQLiteDatabase.CursorFactory) null, 3140);
    }

    public static o0 a() {
        return a.f29943a;
    }

    public final void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS cloudList");
        da.a.d().q("requestConfigTime");
        da.a.d().q("hisavanaCurrentCloudControlVersion");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS cloudList(codeSeatId VARCHAR(20) PRIMARY KEY, code_seat_bean TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS retry_tracking_table(uuid TEXT NOT NULL, create_time INTEGER,retry_times INTEGER,tracking_data TEXT,md5 TEXT,PRIMARY KEY (uuid))");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS adList");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS adList(_id INTEGER PRIMARY KEY AUTOINCREMENT,ad_creative_id VARCHAR(20), codeSeatId VARCHAR(20),file_path VARCHAR(20),price DOUBLE,is_offline_ad INTEGER,ad_request_ver INTEGER,ad_bean TEXT);");
    }

    public final void c(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL("ALTER TABLE default_ad RENAME TO default_ad_temp;");
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS default_ad(ad_creative_id TEXT,codeSeatId VARCHAR(20),ad_type INTEGER,price DOUBLE DEFAULT 0.0,ad_request_ver INTEGER NOT NULL DEFAULT 0,displayed_times INTEGER NOT NULL  DEFAULT 0,displayed_date VARCHAR(20),start_date VARCHAR(20),end_date VARCHAR(20),display_max_times INTEGER NOT NULL DEFAULT 0,file_path TEXT,default_country_white TEXT,default_country_black TEXT,default_brand_white TEXT,default_brand_black TEXT,ad_bean TEXT, PRIMARY KEY (ad_creative_id,codeSeatId));");
                sQLiteDatabase.execSQL("INSERT INTO default_ad SELECT * FROM default_ad_temp;");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS default_ad_temp;");
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e11) {
                z.a().d("HisavanaDatabaseHelper", "upgrade3140 failed :" + e11.getMessage());
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS cloudList(codeSeatId VARCHAR(20) PRIMARY KEY, code_seat_bean TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS adList(_id INTEGER PRIMARY KEY AUTOINCREMENT,ad_creative_id VARCHAR(20), codeSeatId VARCHAR(20),file_path VARCHAR(20),price DOUBLE,is_offline_ad INTEGER,ad_request_ver INTEGER,ad_bean TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS retry_tracking_table(uuid TEXT NOT NULL, create_time INTEGER,retry_times INTEGER,tracking_data TEXT,md5 TEXT,PRIMARY KEY (uuid))");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS default_ad(ad_creative_id TEXT,codeSeatId VARCHAR(20),ad_type INTEGER,price DOUBLE DEFAULT 0.0,ad_request_ver INTEGER NOT NULL DEFAULT 0,displayed_times INTEGER NOT NULL  DEFAULT 0,displayed_date VARCHAR(20),start_date VARCHAR(20),end_date VARCHAR(20),display_max_times INTEGER NOT NULL DEFAULT 0,file_path TEXT,default_country_white TEXT,default_country_black TEXT,default_brand_white TEXT,default_brand_black TEXT,ad_bean TEXT, PRIMARY KEY (ad_creative_id,codeSeatId));");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS attr_impression(_id INTEGER PRIMARY KEY AUTOINCREMENT,pkg TEXT,imp_ts INTEGRE NOT NULL DEFAULT 0,ad_creative_id VARCHAR(20));");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS attr_click(_id INTEGER PRIMARY KEY AUTOINCREMENT,ac_type INTEGER,pkg TEXT,dl_type VARCHAR(20),codeSeatId VARCHAR(20),click_ts INTEGRE NOT NULL DEFAULT 0,ad_creative_id VARCHAR(20));");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        z.a().d("HisavanaDatabaseHelper", "onDowngrade");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS cloudList");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS adList");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS retry_tracking_table");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS default_ad");
        onCreate(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        z.a().d("HisavanaDatabaseHelper", "onUpgrade");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS cloudList(codeSeatId VARCHAR(20) PRIMARY KEY, code_seat_bean TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS adList(_id INTEGER PRIMARY KEY AUTOINCREMENT,ad_creative_id VARCHAR(20), codeSeatId VARCHAR(20),file_path VARCHAR(20),price DOUBLE,is_offline_ad INTEGER,ad_request_ver INTEGER,ad_bean TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS retry_tracking_table(uuid TEXT NOT NULL, create_time INTEGER,retry_times INTEGER,tracking_data TEXT,md5 TEXT,PRIMARY KEY (uuid))");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS default_ad(ad_creative_id TEXT,codeSeatId VARCHAR(20),ad_type INTEGER,price DOUBLE DEFAULT 0.0,ad_request_ver INTEGER NOT NULL DEFAULT 0,displayed_times INTEGER NOT NULL  DEFAULT 0,displayed_date VARCHAR(20),start_date VARCHAR(20),end_date VARCHAR(20),display_max_times INTEGER NOT NULL DEFAULT 0,file_path TEXT,default_country_white TEXT,default_country_black TEXT,default_brand_white TEXT,default_brand_black TEXT,ad_bean TEXT, PRIMARY KEY (ad_creative_id,codeSeatId));");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS attr_impression(_id INTEGER PRIMARY KEY AUTOINCREMENT,pkg TEXT,imp_ts INTEGRE NOT NULL DEFAULT 0,ad_creative_id VARCHAR(20));");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS attr_click(_id INTEGER PRIMARY KEY AUTOINCREMENT,ac_type INTEGER,pkg TEXT,dl_type VARCHAR(20),codeSeatId VARCHAR(20),click_ts INTEGRE NOT NULL DEFAULT 0,ad_creative_id VARCHAR(20));");
        if (i11 == 2700) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS retry_tracking_table");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS retry_tracking_table(uuid TEXT NOT NULL, create_time INTEGER,retry_times INTEGER,tracking_data TEXT,md5 TEXT,PRIMARY KEY (uuid))");
        }
        if (i11 < 2900) {
            b(sQLiteDatabase);
        }
        if (i11 < 3140) {
            c(sQLiteDatabase);
        }
    }
}
