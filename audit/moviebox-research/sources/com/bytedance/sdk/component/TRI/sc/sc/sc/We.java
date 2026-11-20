package com.bytedance.sdk.component.TRI.sc.sc.sc;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.sdk.component.TRI.sc.Qj;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    final Context f26637sc;

    public We(Context context) {
        super(context, "ttadlog.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.f26637sc = context;
    }

    private void pFF(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayListZY = zY(sQLiteDatabase);
        if (arrayListZY == null || arrayListZY.size() <= 0) {
            return;
        }
        Iterator<String> it = arrayListZY.iterator();
        while (it.hasNext()) {
            sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
        }
    }

    private void sc(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.TRI.sc.sc.sc.sc.sc.pFF(Qj.qr().We().pFF()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.TRI.sc.sc.sc.sc.We.zY(Qj.qr().We().sc()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.TRI.sc.sc.sc.sc.qr.zY(Qj.qr().We().We()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.TRI.sc.sc.sc.sc.TRI.sc(Qj.qr().We().ExN()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.TRI.sc.TRI.TRI.pFF());
    }

    private ArrayList<String> zY(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
            if (cursorRawQuery != null) {
                while (cursorRawQuery.moveToNext()) {
                    String string = cursorRawQuery.getString(0);
                    if (!string.equals("android_metadata") && !string.equals("sqlite_sequence")) {
                        arrayList.add(string);
                    }
                }
                cursorRawQuery.close();
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sc(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        try {
            if (i11 <= i12) {
                sc(sQLiteDatabase);
            } else {
                pFF(sQLiteDatabase);
                sc(sQLiteDatabase);
            }
        } catch (Throwable unused) {
        }
    }
}
