package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class o extends a<com.mbridge.msdk.foundation.entity.h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static o f44200a;

    private o(g gVar) {
        super(gVar);
    }

    public static o a(g gVar) {
        if (f44200a == null) {
            synchronized (o.class) {
                try {
                    if (f44200a == null) {
                        f44200a = new o(gVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f44200a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.util.List<com.mbridge.msdk.foundation.entity.i>] */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final synchronized List<com.mbridge.msdk.foundation.entity.i> a(int i11) {
        ?? r11;
        ArrayList arrayList;
        r11 = 0;
        r11 = 0;
        r11 = 0;
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = getReadableDatabase().rawQuery("select * from unit_id WHERE ad_type = " + i11, null);
                if (cursorRawQuery != null) {
                    try {
                        try {
                            if (cursorRawQuery.getCount() > 0) {
                                arrayList = new ArrayList(cursorRawQuery.getCount());
                                while (cursorRawQuery.moveToNext()) {
                                    try {
                                        arrayList.add(new com.mbridge.msdk.foundation.entity.i(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("placement_id")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_CAMPAIGN_UNITID)), i11));
                                    } catch (Exception e11) {
                                        e = e11;
                                        cursor = cursorRawQuery;
                                        e.printStackTrace();
                                        if (cursor != null) {
                                            try {
                                                cursor.close();
                                            } catch (Exception unused) {
                                            }
                                        }
                                        r11 = arrayList;
                                    }
                                }
                                r11 = arrayList;
                            }
                        } catch (Exception e12) {
                            e = e12;
                            arrayList = null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        r11 = cursorRawQuery;
                        if (r11 != 0) {
                            try {
                                r11.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                }
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Exception unused3) {
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e13) {
            e = e13;
            arrayList = null;
        }
        return r11;
    }

    public final synchronized void a(String str) {
        if (getWritableDatabase() != null) {
            getWritableDatabase().delete(MBridgeConstans.PROPERTIES_UNIT_ID, "unitId = ?", new String[]{str + ""});
        }
    }

    public final synchronized void a(String str, String str2, int i11) {
        if (getWritableDatabase() == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("placement_id", str);
        contentValues.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, str2);
        contentValues.put("ad_type", Integer.valueOf(i11));
        getWritableDatabase().insert(MBridgeConstans.PROPERTIES_UNIT_ID, null, contentValues);
    }
}
