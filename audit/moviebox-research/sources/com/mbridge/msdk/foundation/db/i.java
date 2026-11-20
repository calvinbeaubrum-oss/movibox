package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.hisavana.common.constant.ComConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.out.Campaign;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class i extends a<Campaign> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f44192a = "com.mbridge.msdk.foundation.db.i";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static i f44193b;

    private i(g gVar) {
        super(gVar);
    }

    public static i a(g gVar) {
        if (f44193b == null) {
            synchronized (i.class) {
                try {
                    if (f44193b == null) {
                        f44193b = new i(gVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f44193b;
    }

    private synchronized boolean b(String str) {
        try {
            Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT play_time FROM dailyplaycap WHERE unit_id='" + str + "'", null);
            if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
                cursorRawQuery.close();
                return true;
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private synchronized void c(String str) {
        try {
            if (getWritableDatabase() == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("first_insert_timestamp", (Integer) 0);
            contentValues.put("play_time", (Integer) 0);
            getWritableDatabase().update("dailyplaycap", contentValues, "unit_id = '" + str + "'", null);
        } catch (Throwable unused) {
            ad.c(f44192a, "resetTimeAndTimestamp error");
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0072  */
    /* JADX WARN: Code duplicated, block: B:26:0x0078 A[Catch: all -> 0x006b, Exception -> 0x006f, TryCatch #7 {Exception -> 0x006f, all -> 0x006b, blocks: (B:14:0x003f, B:16:0x0045, B:18:0x0066, B:26:0x0078, B:27:0x0081), top: B:59:0x003f }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00d2 A[EXC_TOP_SPLITTER, PHI: r1
  0x00d2: PHI (r1v4 android.database.Cursor) = (r1v3 android.database.Cursor), (r1v5 android.database.Cursor) binds: [B:38:0x00d9, B:34:0x00d0] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public final synchronized void a(String str) {
        long j11;
        long j12;
        Cursor cursor = null;
        try {
            try {
                if (getWritableDatabase() == null) {
                    return;
                }
                ContentValues contentValues = new ContentValues();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (b(str)) {
                    Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT * FROM dailyplaycap where unit_id ='" + str + "'", null);
                    if (cursorRawQuery != null) {
                        try {
                            if (cursorRawQuery.getCount() > 0) {
                                cursorRawQuery.moveToFirst();
                                j11 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("first_insert_timestamp"));
                                j12 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("play_time"));
                                if (jCurrentTimeMillis - ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED > j11) {
                                    c(str);
                                    j12 = 0;
                                }
                            } else {
                                j11 = 0;
                                j12 = 0;
                            }
                            if (j11 == 0) {
                                contentValues.put("first_insert_timestamp", Long.valueOf(jCurrentTimeMillis));
                            }
                            contentValues.put("play_time", Long.valueOf(j12 + 1));
                            getWritableDatabase().update("dailyplaycap", contentValues, "unit_id = '" + str + "'", null);
                            cursor = cursorRawQuery;
                        } catch (Exception e11) {
                            e = e11;
                            cursor = cursorRawQuery;
                            e.printStackTrace();
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Throwable unused) {
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = cursorRawQuery;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Throwable unused2) {
                                }
                            }
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                throw th3;
                            }
                        }
                    } else {
                        j11 = 0;
                        j12 = 0;
                        if (j11 == 0) {
                            contentValues.put("first_insert_timestamp", Long.valueOf(jCurrentTimeMillis));
                        }
                        contentValues.put("play_time", Long.valueOf(j12 + 1));
                        getWritableDatabase().update("dailyplaycap", contentValues, "unit_id = '" + str + "'", null);
                        cursor = cursorRawQuery;
                    }
                }
                contentValues.put("first_insert_timestamp", Long.valueOf(jCurrentTimeMillis));
                contentValues.put("play_time", (Long) 1L);
                contentValues.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
                getWritableDatabase().insert("dailyplaycap", null, contentValues);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e12) {
                e = e12;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0065 A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r0 r1
  0x0065: PHI (r0v2 android.database.Cursor) = (r0v1 android.database.Cursor), (r0v3 android.database.Cursor) binds: [B:25:0x007f, B:21:0x0063] A[DONT_GENERATE, DONT_INLINE]
  0x0065: PHI (r1v1 boolean) = (r1v0 boolean), (r1v3 boolean) binds: [B:25:0x007f, B:21:0x0063] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public final boolean a(String str, int i11) {
        Cursor cursorRawQuery = null;
        boolean z11 = false;
        try {
            cursorRawQuery = getReadableDatabase().rawQuery("SELECT * FROM dailyplaycap where unit_id ='" + str + "'", null);
            if (cursorRawQuery != null && cursorRawQuery.getCount() > 0 && cursorRawQuery.moveToFirst()) {
                long j11 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("first_insert_timestamp"));
                long j12 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("play_time"));
                if (j11 != 0) {
                    if (System.currentTimeMillis() - ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED > j11) {
                        c(str);
                    } else if (i11 > 0 && j12 >= i11) {
                        z11 = true;
                    }
                }
            }
            if (cursorRawQuery != null) {
            }
        } catch (Throwable th2) {
            try {
                ad.c(f44192a, "isOverCap is error" + th2);
            } finally {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        return z11;
    }
}
