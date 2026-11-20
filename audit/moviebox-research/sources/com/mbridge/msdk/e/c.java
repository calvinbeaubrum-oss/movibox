package com.mbridge.msdk.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.hisavana.common.tracking.TrackingKey;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f43852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f43853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f43854c = new Object();

    public c(b bVar, String str) {
        this.f43852a = bVar;
        this.f43853b = str;
    }

    private static boolean a(SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase == null || !sQLiteDatabase.isOpen() || sQLiteDatabase.isReadOnly();
    }

    private static void b(SQLiteDatabase sQLiteDatabase) {
        if (y.a(sQLiteDatabase) || !sQLiteDatabase.inTransaction()) {
            return;
        }
        try {
            sQLiteDatabase.endTransaction();
        } catch (Exception e11) {
            if (a.f43738a) {
                Log.e("TrackManager", "endTransaction: ", e11);
            }
        }
    }

    private static void c(SQLiteDatabase sQLiteDatabase) {
        if (y.a(sQLiteDatabase)) {
            return;
        }
        try {
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e11) {
            if (a.f43738a) {
                Log.e("TrackManager", "transactionSuccess: ", e11);
            }
        }
    }

    private static void d(SQLiteDatabase sQLiteDatabase) {
        if (y.a(sQLiteDatabase)) {
            return;
        }
        try {
            sQLiteDatabase.beginTransaction();
        } catch (Exception e11) {
            if (a.f43738a) {
                Log.e("TrackManager", "beginTransaction: ", e11);
            }
        }
    }

    public final int a() {
        SQLiteDatabase writableDatabase;
        synchronized (this.f43854c) {
            int iMax = 0;
            if (y.a(this.f43852a)) {
                return 0;
            }
            Cursor cursorQuery = null;
            try {
                writableDatabase = this.f43852a.getWritableDatabase();
            } catch (Exception e11) {
                if (a.f43738a) {
                    Log.e("TrackManager", "getAvailableCount getWritableDatabase: " + e11.getMessage());
                }
                writableDatabase = null;
            }
            try {
                if (a(writableDatabase)) {
                    return 0;
                }
                d(writableDatabase);
                cursorQuery = writableDatabase.query(this.f43853b, null, "state = ? OR state = ?", new String[]{String.valueOf(3), String.valueOf(0)}, null, null, null, null);
                if (cursorQuery != null && cursorQuery.moveToNext()) {
                    iMax = Math.max(cursorQuery.getCount(), 0);
                }
                c(writableDatabase);
                b(writableDatabase);
                return iMax;
            } catch (Exception e12) {
                if (a.f43738a) {
                    Log.e("TrackManager", "getAvailableCount: " + e12.getMessage());
                }
                b(writableDatabase);
            } finally {
                b(writableDatabase);
                y.a(cursorQuery);
            }
        }
    }

    public final long a(i iVar) {
        SQLiteDatabase writableDatabase;
        synchronized (this.f43854c) {
            long jInsert = -1;
            if (y.a(this.f43852a)) {
                return -1L;
            }
            try {
                writableDatabase = this.f43852a.getWritableDatabase();
            } catch (Exception e11) {
                if (a.f43738a) {
                    Log.e("TrackManager", "insert getWritableDatabase: " + e11.getMessage());
                }
                writableDatabase = null;
            }
            if (a(writableDatabase)) {
                return -1L;
            }
            try {
                try {
                    d(writableDatabase);
                    ContentValues contentValues = new ContentValues(16);
                    e eVarC = iVar.c();
                    contentValues.put("name", eVarC.a());
                    contentValues.put("type", Integer.valueOf(eVarC.b()));
                    contentValues.put("time_stamp", Long.valueOf(eVarC.f()));
                    contentValues.put("properties", eVarC.d().toString());
                    contentValues.put(TrackingKey.PRIORITY, Integer.valueOf(eVarC.c()));
                    contentValues.put("state", Integer.valueOf(iVar.e()));
                    contentValues.put("report_count", Integer.valueOf(iVar.d()));
                    contentValues.put("uuid", eVarC.e());
                    contentValues.put("ignore_max_timeout", Integer.valueOf(!eVarC.j() ? 1 : 0));
                    contentValues.put("ignore_max_retry_times", Integer.valueOf(!eVarC.k() ? 1 : 0));
                    contentValues.put("invalid_time", Long.valueOf(iVar.g()));
                    jInsert = writableDatabase.insert(this.f43853b, null, contentValues);
                    c(writableDatabase);
                } catch (Exception e12) {
                    if (a.f43738a) {
                        Log.e("TrackManager", "insert: " + e12.getMessage());
                    }
                }
                b(writableDatabase);
                return jInsert;
            } catch (Throwable th2) {
                b(writableDatabase);
                throw th2;
            }
        }
    }

    public final List<i> a(int i11) {
        SQLiteDatabase writableDatabase;
        Throwable th2;
        Cursor cursorQuery;
        List<i> list;
        synchronized (this.f43854c) {
            Cursor cursor = null;
            List<i> listB = null;
            if (y.a(this.f43852a)) {
                return null;
            }
            try {
                writableDatabase = this.f43852a.getWritableDatabase();
            } catch (Exception e11) {
                if (a.f43738a) {
                    Log.e("TrackManager", "getAvailable getWritableDatabase: " + e11.getMessage());
                }
                writableDatabase = null;
            }
            try {
                if (a(writableDatabase)) {
                    return null;
                }
                try {
                    d(writableDatabase);
                    cursorQuery = writableDatabase.query(this.f43853b, null, "state = ? OR state = ?", new String[]{String.valueOf(0), String.valueOf(3)}, null, null, "priority DESC", String.valueOf(i11));
                    try {
                        listB = y.b(cursorQuery);
                        c(writableDatabase);
                        b(writableDatabase);
                        y.a(cursorQuery);
                    } catch (Exception e12) {
                        e = e12;
                        List<i> list2 = listB;
                        cursor = cursorQuery;
                        list = list2;
                        if (a.f43738a) {
                            Log.e("TrackManager", "getAvailable: " + e.getMessage());
                        }
                        b(writableDatabase);
                        y.a(cursor);
                        listB = list;
                    } catch (Throwable th3) {
                        th2 = th3;
                        b(writableDatabase);
                        y.a(cursorQuery);
                        throw th2;
                    }
                } catch (Exception e13) {
                    e = e13;
                    list = null;
                }
                return listB;
            } catch (Throwable th4) {
                th2 = th4;
                cursorQuery = null;
            }
        }
    }

    public final void a(List<i> list) {
        SQLiteDatabase writableDatabase;
        synchronized (this.f43854c) {
            if (y.a(this.f43852a) || y.a((List<?>) list)) {
                return;
            }
            try {
                writableDatabase = this.f43852a.getWritableDatabase();
            } catch (Exception e11) {
                if (a.f43738a) {
                    Log.e("TrackManager", "updateReportStateReporting getWritableDatabase: " + e11.getMessage());
                }
                writableDatabase = null;
            }
            if (a(writableDatabase)) {
                return;
            }
            try {
                try {
                    d(writableDatabase);
                    for (i iVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("state", (Integer) 1);
                        writableDatabase.update(this.f43853b, contentValues, "uuid = ?", new String[]{iVar.f()});
                    }
                    c(writableDatabase);
                } catch (Exception e12) {
                    if (a.f43738a) {
                        Log.e("TrackManager", "updateReportStateReporting: " + e12.getMessage());
                    }
                }
                b(writableDatabase);
            } catch (Throwable th2) {
                b(writableDatabase);
                throw th2;
            }
        }
    }

    public final int b() {
        SQLiteDatabase writableDatabase;
        synchronized (this.f43854c) {
            int iDelete = -1;
            if (y.a(this.f43852a)) {
                return -1;
            }
            try {
                writableDatabase = this.f43852a.getWritableDatabase();
            } catch (Exception e11) {
                if (a.f43738a) {
                    Log.e("TrackManager", "deleteInvalidEvents getWritableDatabase: " + e11.getMessage());
                }
                writableDatabase = null;
            }
            try {
                if (a(writableDatabase)) {
                    return -1;
                }
                try {
                    d(writableDatabase);
                    iDelete = writableDatabase.delete(this.f43853b, "state = ? OR state = ?", new String[]{String.valueOf(-1), String.valueOf(2)});
                    c(writableDatabase);
                } catch (Exception e12) {
                    if (a.f43738a) {
                        Log.e("TrackManager", "deleteInvalidEvents: " + e12.getMessage());
                    }
                }
                b(writableDatabase);
                return iDelete;
            } catch (Throwable th2) {
                b(writableDatabase);
                throw th2;
            }
        }
    }

    public final void b(List<i> list) {
        SQLiteDatabase writableDatabase;
        synchronized (this.f43854c) {
            if (y.a(this.f43852a) || y.a((List<?>) list)) {
                return;
            }
            try {
                writableDatabase = this.f43852a.getWritableDatabase();
            } catch (Exception e11) {
                if (a.f43738a) {
                    Log.e("TrackManager", "updateReportStateSuccess getWritableDatabase: " + e11.getMessage());
                }
                writableDatabase = null;
            }
            if (a(writableDatabase)) {
                return;
            }
            try {
                try {
                    d(writableDatabase);
                    for (i iVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("state", (Integer) 2);
                        writableDatabase.update(this.f43853b, contentValues, "uuid = ?", new String[]{iVar.f()});
                    }
                    c(writableDatabase);
                } catch (Exception e12) {
                    if (a.f43738a) {
                        Log.e("TrackManager", "updateReportStateSuccess: " + e12.getMessage());
                    }
                }
                b(writableDatabase);
            } catch (Throwable th2) {
                b(writableDatabase);
                throw th2;
            }
        }
    }

    public final void c() {
        SQLiteDatabase writableDatabase;
        synchronized (this.f43854c) {
            if (y.a(this.f43852a)) {
                return;
            }
            try {
                writableDatabase = this.f43852a.getWritableDatabase();
            } catch (Exception e11) {
                if (a.f43738a) {
                    Log.e("TrackManager", "updateReportStateForReporting getWritableDatabase: " + e11.getMessage());
                }
                writableDatabase = null;
            }
            if (a(writableDatabase)) {
                return;
            }
            try {
                try {
                    d(writableDatabase);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("state", (Integer) 3);
                    writableDatabase.update(this.f43853b, contentValues, "state = ?", new String[]{String.valueOf(1)});
                    c(writableDatabase);
                } catch (Exception e12) {
                    if (a.f43738a) {
                        Log.e("TrackManager", "updateReportStateForReporting: " + e12.getMessage());
                    }
                }
                b(writableDatabase);
            } catch (Throwable th2) {
                b(writableDatabase);
                throw th2;
            }
        }
    }

    public final void c(List<i> list) {
        SQLiteDatabase writableDatabase;
        synchronized (this.f43854c) {
            if (y.a(this.f43852a) || y.a((List<?>) list)) {
                return;
            }
            try {
                writableDatabase = this.f43852a.getWritableDatabase();
            } catch (Exception e11) {
                if (a.f43738a) {
                    Log.e("TrackManager", "updateReportStateFailed getWritableDatabase: " + e11.getMessage());
                }
                writableDatabase = null;
            }
            if (a(writableDatabase)) {
                return;
            }
            try {
                try {
                    d(writableDatabase);
                    for (i iVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("state", Integer.valueOf(iVar.e()));
                        contentValues.put("report_count", Integer.valueOf(iVar.d()));
                        writableDatabase.update(this.f43853b, contentValues, "uuid = ?", new String[]{iVar.f()});
                    }
                    c(writableDatabase);
                } catch (Exception e12) {
                    if (a.f43738a) {
                        Log.e("TrackManager", "updateReportStateFailed: " + e12.getMessage());
                    }
                }
                b(writableDatabase);
            } catch (Throwable th2) {
                b(writableDatabase);
                throw th2;
            }
        }
    }
}
