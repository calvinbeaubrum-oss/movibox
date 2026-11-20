package com.mbridge.msdk.foundation.db;

import android.database.Cursor;
import com.applovin.sdk.AppLovinEventTypes;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class e extends a<com.mbridge.msdk.foundation.entity.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static e f44166a;

    private e(g gVar) {
        super(gVar);
    }

    public static e a(g gVar) {
        if (f44166a == null) {
            synchronized (e.class) {
                try {
                    if (f44166a == null) {
                        f44166a = new e(gVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f44166a;
    }

    public final synchronized int a() {
        int i11;
        i11 = 0;
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = getReadableDatabase().rawQuery("select count(*) from click_time", null);
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

    /* JADX WARN: Code duplicated, block: B:42:0x014a A[Catch: all -> 0x0134, TRY_ENTER, TryCatch #2 {, blocks: (B:4:0x0003, B:24:0x012f, B:30:0x0138, B:42:0x014a, B:43:0x014d), top: B:48:0x0003 }] */
    public final synchronized List<com.mbridge.msdk.foundation.entity.e> a(int i11) {
        Cursor cursorRawQuery;
        String str = "select * from click_time LIMIT " + i11;
        Cursor cursor = null;
        if (getWritableDatabase() == null) {
            return null;
        }
        try {
            cursorRawQuery = getWritableDatabase().rawQuery(str, null);
            if (cursorRawQuery != null) {
                try {
                    try {
                        if (cursorRawQuery.getCount() > 0) {
                            ArrayList arrayList = new ArrayList();
                            int i12 = 0;
                            while (cursorRawQuery.moveToNext() && i12 < i11) {
                                i12++;
                                int i13 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("id"));
                                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("campaignId"));
                                int i14 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("click_type"));
                                String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("click_duration"));
                                String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("last_url"));
                                int i15 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("type"));
                                int i16 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(TrackingKey.CODE));
                                String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("header"));
                                arrayList.add(new com.mbridge.msdk.foundation.entity.e(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("rid")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("rid_n")), string, string2, string3, i16, cursorRawQuery.getString(cursorRawQuery.getColumnIndex("exception")), string4, cursorRawQuery.getString(cursorRawQuery.getColumnIndex(AppLovinEventTypes.USER_VIEWED_CONTENT)), i15, i14, cursorRawQuery.getString(cursorRawQuery.getColumnIndex(MBridgeConstans.PROPERTIES_UNIT_ID)), cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_LANDING_TYPE)), cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_LINK_TYPE)), cursorRawQuery.getString(cursorRawQuery.getColumnIndex(TrackingKey.CLICK_TIME)), cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("network_type")), cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("market_result")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("network_str"))));
                                getWritableDatabase().delete(TrackingKey.CLICK_TIME, "id = ?", new String[]{i13 + ""});
                            }
                            cursorRawQuery.close();
                            return arrayList;
                        }
                    } catch (Exception e11) {
                        e = e11;
                        e.printStackTrace();
                        if (cursorRawQuery != null) {
                        }
                        return null;
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
        } catch (Exception e12) {
            e = e12;
            cursorRawQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return null;
    }
}
