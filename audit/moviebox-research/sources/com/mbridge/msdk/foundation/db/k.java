package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.hisavana.common.constant.ComConstants;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class k extends a<com.mbridge.msdk.foundation.entity.g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static k f44195a;

    private k(g gVar) {
        super(gVar);
    }

    public static k a(g gVar) {
        if (f44195a == null) {
            synchronized (k.class) {
                try {
                    if (f44195a == null) {
                        f44195a = new k(gVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f44195a;
    }

    private synchronized long b(com.mbridge.msdk.foundation.entity.g gVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", gVar.a());
            contentValues.put("fc_a", Integer.valueOf(gVar.c()));
            contentValues.put("fc_b", Integer.valueOf(gVar.d()));
            contentValues.put("ts", Long.valueOf(gVar.f()));
            contentValues.put("impression_count", Integer.valueOf(gVar.e()));
            contentValues.put("click_count", Integer.valueOf(gVar.b()));
            contentValues.put("ts", Long.valueOf(gVar.f()));
            if (getWritableDatabase() == null) {
                return -1L;
            }
            return getWritableDatabase().insert("frequence", null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public final synchronized void a() {
        try {
            String str = "ts<" + (System.currentTimeMillis() - ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED);
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("frequence", str, null);
            }
        } catch (Exception unused) {
        }
    }

    public final synchronized void a(com.mbridge.msdk.foundation.entity.g gVar) {
        if (!b(gVar.a())) {
            b(gVar);
        }
    }

    public final synchronized void a(String str) {
        if (b(str)) {
            String str2 = "UPDATE frequence Set impression_count=impression_count+1 WHERE id=" + str;
            if (getReadableDatabase() != null) {
                getReadableDatabase().execSQL(str2);
            }
        }
    }

    public final synchronized boolean b(String str) {
        Cursor cursor = null;
        try {
            try {
                synchronized (str) {
                    Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT id FROM frequence WHERE id='" + str + "'", null);
                    if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
                        cursorRawQuery.close();
                        return true;
                    }
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return false;
                }
            } catch (Exception unused) {
                if (0 != 0) {
                    cursor.close();
                }
                return false;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final long[] b() {
        Throwable th2;
        Cursor cursorRawQuery;
        try {
            cursorRawQuery = getReadableDatabase().rawQuery("SELECT id FROM frequence WHERE fc_a<impression_count", null);
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.getCount() > 0) {
                        long[] jArr = new long[cursorRawQuery.getCount()];
                        int i11 = 0;
                        while (cursorRawQuery.moveToNext()) {
                            jArr[i11] = cursorRawQuery.getLong(cursorRawQuery.getColumnIndexOrThrow("id"));
                            i11++;
                        }
                        cursorRawQuery.close();
                        return jArr;
                    }
                } catch (Exception unused) {
                    if (cursorRawQuery != null) {
                    }
                    return null;
                } catch (Throwable th3) {
                    th2 = th3;
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    throw th2;
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (Exception unused2) {
            cursorRawQuery = null;
        } catch (Throwable th4) {
            th2 = th4;
            cursorRawQuery = null;
        }
        return null;
    }
}
