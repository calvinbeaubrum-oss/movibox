package com.mbridge.msdk.foundation.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ad;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f44189a;

    /* JADX INFO: compiled from: source.java */
    public class a extends SQLiteOpenHelper {
        public a(Context context, String str, int i11) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i11);
            if (MBridgeConstans.DEBUG) {
                ad.a("DatabaseOpenHelper", "数据库： name :" + str + "  " + i11);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (MBridgeConstans.DEBUG) {
                ad.a("DatabaseOpenHelper", "数据库创建了");
            }
            g.this.a(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
            g.this.a(sQLiteDatabase, i11, i12);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
            if (MBridgeConstans.DEBUG) {
                ad.a("DatabaseOpenHelper", "数据库升级了");
            }
            g.this.b(sQLiteDatabase, i11, i12);
        }
    }

    public g(Context context) {
        this.f44189a = new a(context, a(), b());
    }

    public abstract String a();

    public abstract void a(SQLiteDatabase sQLiteDatabase);

    public abstract void a(SQLiteDatabase sQLiteDatabase, int i11, int i12);

    public abstract int b();

    public abstract void b(SQLiteDatabase sQLiteDatabase, int i11, int i12);

    public final SQLiteDatabase c() {
        return this.f44189a.getReadableDatabase();
    }

    public final synchronized SQLiteDatabase d() {
        SQLiteDatabase writableDatabase;
        try {
            writableDatabase = this.f44189a.getWritableDatabase();
        } catch (Exception unused) {
            writableDatabase = null;
        }
        return writableDatabase;
    }
}
