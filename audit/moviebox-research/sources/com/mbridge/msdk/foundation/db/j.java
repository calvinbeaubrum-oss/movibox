package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.hisavana.common.constant.ComConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class j extends a<com.mbridge.msdk.foundation.entity.f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static j f44194a;

    private j(g gVar) {
        super(gVar);
    }

    public static synchronized j a(g gVar) {
        try {
            if (f44194a == null) {
                f44194a = new j(gVar);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f44194a;
    }

    private synchronized boolean a(String str, String str2) {
        try {
            Cursor cursorRawQuery = getReadableDatabase().rawQuery("select id from fq_info where unitId='" + str + "' and id='" + str2 + "'", null);
            if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
                cursorRawQuery.close();
                return true;
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return false;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public final synchronized void a(com.mbridge.msdk.foundation.entity.f fVar) {
        try {
            try {
                if (getWritableDatabase() == null) {
                    return;
                }
                if (fVar != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("id", fVar.a());
                    contentValues.put("time", Long.valueOf(fVar.b()));
                    contentValues.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, fVar.d());
                    contentValues.put("type", Integer.valueOf(fVar.c()));
                    if (a(fVar.d(), fVar.a())) {
                        getWritableDatabase().update("fq_info", contentValues, "id = " + fVar.a() + " AND " + CampaignEx.JSON_KEY_CAMPAIGN_UNITID + " = " + fVar.d(), null);
                    } else {
                        getWritableDatabase().insert("fq_info", null, contentValues);
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void a(String str) {
        try {
            String str2 = "time<" + (System.currentTimeMillis() - ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED) + " and " + CampaignEx.JSON_KEY_CAMPAIGN_UNITID + "=?";
            String[] strArr = {str};
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("fq_info", str2, strArr);
            }
        } catch (Exception unused) {
        }
    }
}
