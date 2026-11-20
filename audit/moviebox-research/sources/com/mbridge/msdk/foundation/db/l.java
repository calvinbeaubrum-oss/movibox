package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class l extends a<com.mbridge.msdk.foundation.entity.h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static l f44196a;

    private l(g gVar) {
        super(gVar);
    }

    public static l a(g gVar) {
        if (f44196a == null) {
            synchronized (l.class) {
                try {
                    if (f44196a == null) {
                        f44196a = new l(gVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f44196a;
    }

    public final synchronized int a() {
        int i11;
        i11 = 0;
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = getReadableDatabase().rawQuery("select count(*) from load_stat", null);
                if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                    i11 = cursorRawQuery.getInt(0);
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                if (cursorRawQuery != null) {
                }
            }
        } catch (Throwable th2) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th2;
        }
        return i11;
    }

    public final synchronized List<com.mbridge.msdk.foundation.entity.h> a(int i11) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Cursor cursor = null;
        arrayList2 = null;
        arrayList2 = null;
        cursor = null;
        try {
            try {
                Cursor cursorRawQuery = getReadableDatabase().rawQuery("select * from load_stat LIMIT " + i11, null);
                if (cursorRawQuery != null) {
                    try {
                        try {
                            if (cursorRawQuery.getCount() > 0) {
                                arrayList = new ArrayList();
                                int i12 = 0;
                                while (cursorRawQuery.moveToNext() && i12 < i11) {
                                    try {
                                        i12++;
                                        int i13 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_AD_SOURCE_ID));
                                        String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("time"));
                                        int i14 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("adNum"));
                                        String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_CAMPAIGN_UNITID));
                                        int i15 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("fb"));
                                        int i16 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("timeout"));
                                        int i17 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("network_type"));
                                        String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("network_type_str"));
                                        int i18 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_HB));
                                        com.mbridge.msdk.foundation.entity.h hVar = new com.mbridge.msdk.foundation.entity.h(i13, string, i14, string2, i15, i16, i17);
                                        hVar.c(string3);
                                        hVar.c(i18);
                                        arrayList.add(hVar);
                                        int i19 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("id"));
                                        if (getWritableDatabase() != null) {
                                            getWritableDatabase().delete("load_stat", "id = ?", new String[]{i19 + ""});
                                        }
                                    } catch (Exception e11) {
                                        e = e11;
                                        cursor = cursorRawQuery;
                                        e.printStackTrace();
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        arrayList2 = arrayList;
                                    }
                                }
                                arrayList2 = arrayList;
                            }
                        } catch (Exception e12) {
                            e = e12;
                            arrayList = null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = cursorRawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (Exception e13) {
                e = e13;
                arrayList = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        return arrayList2;
    }

    public final synchronized void a(com.mbridge.msdk.foundation.entity.h hVar) {
        if (getWritableDatabase() == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("time", hVar.b());
        contentValues.put(CampaignEx.JSON_KEY_AD_SOURCE_ID, Integer.valueOf(hVar.a()));
        contentValues.put("adNum", Integer.valueOf(hVar.c()));
        contentValues.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, hVar.d());
        contentValues.put("fb", Integer.valueOf(hVar.e()));
        contentValues.put(CampaignEx.JSON_KEY_HB, Integer.valueOf(hVar.h()));
        contentValues.put("timeout", Integer.valueOf(hVar.i()));
        contentValues.put("network_type", Integer.valueOf(hVar.g()));
        contentValues.put("network_type_str", hVar.f());
        getWritableDatabase().insert("load_stat", null, contentValues);
    }
}
