package com.mbridge.msdk.e;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class b extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f43851a;

    public b(Context context, String str, String str2) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.f43851a = str2;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (y.a(sQLiteDatabase)) {
            return;
        }
        try {
            sQLiteDatabase.execSQL(String.format(i.f43873a, this.f43851a));
        } catch (Exception e11) {
            if (a.f43738a) {
                Log.e("TrackManager", "create table error", e11);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        if (y.a(sQLiteDatabase)) {
            return;
        }
        try {
            sQLiteDatabase.execSQL(String.format(i.f43874b, this.f43851a));
            sQLiteDatabase.execSQL(String.format(i.f43873a, this.f43851a));
        } catch (Exception e11) {
            if (a.f43738a) {
                Log.e("TrackManager", "downgrade table error", e11);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        if (y.a(sQLiteDatabase)) {
            return;
        }
        try {
            sQLiteDatabase.execSQL(String.format(i.f43874b, this.f43851a));
            sQLiteDatabase.execSQL(String.format(i.f43873a, this.f43851a));
        } catch (Exception e11) {
            if (a.f43738a) {
                Log.e("TrackManager", "upgrade table error", e11);
            }
        }
    }
}
