package androidx.media3.datasource.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.media3.database.DatabaseIOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f9678c = {"name", "length", "last_touch_timestamp"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b4.a f9679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9680b;

    public d(b4.a aVar) {
        this.f9679a = aVar;
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
                    map.put((String) z3.a.e(cursorC.getString(0)), new c(cursorC.getLong(1), cursorC.getLong(2)));
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
        z3.a.e(this.f9680b);
        return this.f9679a.getReadableDatabase().query(this.f9680b, f9678c, null, null, null, null, null);
    }

    public void e(long j11) throws DatabaseIOException {
        try {
            String hexString = Long.toHexString(j11);
            this.f9680b = d(hexString);
            if (b4.c.b(this.f9679a.getReadableDatabase(), 2, hexString) != 1) {
                SQLiteDatabase writableDatabase = this.f9679a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    b4.c.d(writableDatabase, 2, hexString, 1);
                    a(writableDatabase, this.f9680b);
                    writableDatabase.execSQL("CREATE TABLE " + this.f9680b + " (name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)");
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
        z3.a.e(this.f9680b);
        try {
            this.f9679a.getWritableDatabase().delete(this.f9680b, "name = ?", new String[]{str});
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    public void g(Set<String> set) throws DatabaseIOException {
        z3.a.e(this.f9680b);
        try {
            SQLiteDatabase writableDatabase = this.f9679a.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    writableDatabase.delete(this.f9680b, "name = ?", new String[]{it.next()});
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
        z3.a.e(this.f9680b);
        try {
            SQLiteDatabase writableDatabase = this.f9679a.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str);
            contentValues.put("length", Long.valueOf(j11));
            contentValues.put("last_touch_timestamp", Long.valueOf(j12));
            writableDatabase.replaceOrThrow(this.f9680b, null, contentValues);
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }
}
