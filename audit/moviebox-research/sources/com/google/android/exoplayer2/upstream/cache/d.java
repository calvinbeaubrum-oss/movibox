package com.google.android.exoplayer2.upstream.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.exoplayer2.database.DatabaseIOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f35318c = {"name", "length", "last_touch_timestamp"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rg.a f35319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f35320b;

    public d(rg.a aVar) {
        this.f35319a = aVar;
    }

    public static void a(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
    }

    public static String d(String str) {
        return "ExoPlayerCacheFileMetadata" + str;
    }

    public Map<String, c> b() throws DatabaseIOException {
        try {
            Cursor cursorC = c();
            try {
                HashMap map = new HashMap(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    map.put((String) com.google.android.exoplayer2.util.a.e(cursorC.getString(0)), new c(cursorC.getLong(1), cursorC.getLong(2)));
                }
                cursorC.close();
                return map;
            } catch (Throwable th2) {
                if (cursorC != null) {
                    try {
                        cursorC.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    public final Cursor c() {
        com.google.android.exoplayer2.util.a.e(this.f35320b);
        return this.f35319a.getReadableDatabase().query(this.f35320b, f35318c, null, null, null, null, null);
    }

    public void e(long j11) throws DatabaseIOException {
        try {
            String hexString = Long.toHexString(j11);
            this.f35320b = d(hexString);
            if (rg.c.b(this.f35319a.getReadableDatabase(), 2, hexString) != 1) {
                SQLiteDatabase writableDatabase = this.f35319a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    rg.c.d(writableDatabase, 2, hexString, 1);
                    a(writableDatabase, this.f35320b);
                    writableDatabase.execSQL("CREATE TABLE " + this.f35320b + " (name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)");
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    public void f(String str) throws DatabaseIOException {
        com.google.android.exoplayer2.util.a.e(this.f35320b);
        try {
            this.f35319a.getWritableDatabase().delete(this.f35320b, "name = ?", new String[]{str});
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    public void g(Set<String> set) throws DatabaseIOException {
        com.google.android.exoplayer2.util.a.e(this.f35320b);
        try {
            SQLiteDatabase writableDatabase = this.f35319a.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    writableDatabase.delete(this.f35320b, "name = ?", new String[]{it.next()});
                }
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    public void h(String str, long j11, long j12) throws DatabaseIOException {
        com.google.android.exoplayer2.util.a.e(this.f35320b);
        try {
            SQLiteDatabase writableDatabase = this.f35319a.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str);
            contentValues.put("length", Long.valueOf(j11));
            contentValues.put("last_touch_timestamp", Long.valueOf(j12));
            writableDatabase.replaceOrThrow(this.f35320b, null, contentValues);
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }
}
