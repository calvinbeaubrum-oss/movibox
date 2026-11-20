package com.mbridge.msdk.newreward.function.common;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ad;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class DatabaseUtils {
    private DatabaseUtils() {
    }

    public static void beginTransaction(SQLiteDatabase sQLiteDatabase) {
        if (isDatabaseAvailable(sQLiteDatabase)) {
            try {
                sQLiteDatabase.beginTransaction();
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.a("DatabaseUtils", "beginTransaction", e11);
                }
            }
        }
    }

    public static void closeCursor(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        try {
            cursor.close();
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.a("DatabaseUtils", "closeCursor", e11);
            }
        }
    }

    public static void endTransaction(SQLiteDatabase sQLiteDatabase) {
        if (isDatabaseAvailable(sQLiteDatabase) && sQLiteDatabase.inTransaction()) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.a("DatabaseUtils", "endTransaction", e11);
                }
            }
        }
    }

    public static boolean isDatabaseAvailable(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            return false;
        }
        try {
            return sQLiteDatabase.isOpen() && !sQLiteDatabase.isReadOnly();
        } catch (Exception unused) {
            return false;
        }
    }

    public static void setTransactionSuccessful(SQLiteDatabase sQLiteDatabase) {
        if (isDatabaseAvailable(sQLiteDatabase)) {
            try {
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.a("DatabaseUtils", "setTransactionSuccessful", e11);
                }
            }
        }
    }
}
