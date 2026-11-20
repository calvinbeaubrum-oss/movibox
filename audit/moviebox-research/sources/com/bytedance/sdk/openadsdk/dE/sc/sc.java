package com.bytedance.sdk.openadsdk.dE.sc;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.bytedance.sdk.component.utils.Tf;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc extends SQLiteOpenHelper {
    private static volatile sc pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    final Context f28610sc;

    private sc(Context context) {
        super(context, "pag_monitor.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.f28610sc = context;
    }

    public static SQLiteDatabase pFF() {
        try {
            sc scVarZY = zY();
            if (scVarZY == null) {
                return null;
            }
            SQLiteDatabase readableDatabase = scVarZY.getReadableDatabase();
            if (readableDatabase.isOpen()) {
                return readableDatabase;
            }
            return null;
        } catch (Throwable th2) {
            th2.getMessage();
            return null;
        }
    }

    private ArrayList<String> pFF(SQLiteDatabase sQLiteDatabase) {
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
        } catch (Exception e11) {
            Tf.sc("MonitorSQLiteOpenHelper", e11.getMessage());
        }
        return arrayList;
    }

    public static SQLiteDatabase sc() {
        try {
            sc scVarZY = zY();
            if (scVarZY == null) {
                return null;
            }
            SQLiteDatabase writableDatabase = scVarZY.getWritableDatabase();
            if (writableDatabase.isOpen()) {
                return writableDatabase;
            }
            return null;
        } catch (Throwable th2) {
            th2.getMessage();
            return null;
        }
    }

    private void sc(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayListPFF = pFF(sQLiteDatabase);
        if (arrayListPFF == null || arrayListPFF.size() <= 0) {
            return;
        }
        Iterator<String> it = arrayListPFF.iterator();
        while (it.hasNext()) {
            sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
        }
    }

    private static sc zY() {
        if (pFF == null) {
            synchronized (sc.class) {
                try {
                    if (pFF == null) {
                        pFF = new sc(com.bytedance.sdk.openadsdk.dE.sc.sc());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return pFF;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(new StringBuilder("CREATE TABLE IF NOT EXISTS monitor_table (_id INTEGER PRIMARY KEY AUTOINCREMENT,sdk_version TEXT ,scene TEXT ,start_count INTEGER default 0 , success_count INTEGER default 0  , fail_count INTEGER default 0  , rit TEXT  , tag TEXT  , label TEXT  , timestamp INTEGER default 0 ,mediation TEXT  , is_init INTEGER , extra TEXT )").toString());
        } catch (Throwable th2) {
            Log.e("MonitorSQLiteOpenHelper", th2.getMessage());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        try {
            if (i11 <= i12) {
                onCreate(sQLiteDatabase);
            } else {
                sc(sQLiteDatabase);
                onCreate(sQLiteDatabase);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
    }
}
