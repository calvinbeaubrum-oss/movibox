package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f44162a = "com.mbridge.msdk.foundation.db.c";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile c f44163b;

    private c(g gVar) {
        super(gVar);
    }

    public static c a(g gVar) {
        if (f44163b == null) {
            synchronized (c.class) {
                try {
                    if (f44163b == null) {
                        f44163b = new c(gVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f44163b;
    }

    private synchronized boolean a(String str, String str2) {
        Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT rid FROM CacheCampaign WHERE rid='" + str + "' AND unitid = '" + str2 + "'", null);
        if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
            try {
                cursorRawQuery.close();
            } catch (Exception unused) {
            }
            return true;
        }
        if (cursorRawQuery != null) {
            try {
                cursorRawQuery.close();
            } catch (Exception unused2) {
            }
        }
        return false;
    }

    public final long a(String str, String str2, String str3, int i11) {
        if (!a(str, str3)) {
            return -1L;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", Integer.valueOf(i11));
        return getWritableDatabase().update("CacheCampaign", contentValues, "rid='" + str + "' AND unitid = '" + str3 + "' AND state = 0", null);
    }

    public final long a(List<CampaignEx> list, String str) {
        CampaignEx campaignEx;
        if (list != null) {
            try {
                if (list.size() == 0 || TextUtils.isEmpty(str) || (campaignEx = list.get(0)) == null) {
                    return 0L;
                }
                if (getWritableDatabase() == null) {
                    return -1L;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("rid", campaignEx.getRequestId());
                contentValues.put("lrid", campaignEx.getLocalRequestId());
                contentValues.put("unitid", str);
                JSONArray jSONArray = new JSONArray();
                Iterator<CampaignEx> it = list.iterator();
                while (it.hasNext()) {
                    jSONArray.put(CampaignEx.campaignToJsonObject(it.next()));
                }
                contentValues.put("campaigns", jSONArray.toString());
                contentValues.put("ts", Long.valueOf(campaignEx.getTimestamp()));
                long candidateCacheTime = campaignEx.getCandidateCacheTime();
                if (candidateCacheTime == 0) {
                    candidateCacheTime = campaignEx.getPlctb();
                    if (candidateCacheTime == 0) {
                        com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
                        if (gVarB == null) {
                            com.mbridge.msdk.c.h.a();
                            gVarB = com.mbridge.msdk.c.i.a();
                        }
                        candidateCacheTime = gVarB.ac();
                    }
                }
                try {
                    if (af.a().a("c_e_t", false)) {
                        candidateCacheTime *= 24;
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                contentValues.put("interval_ts", Long.valueOf(candidateCacheTime * 1000));
                contentValues.put("ecppv", campaignEx.getEcppv());
                contentValues.put("show_count", Integer.valueOf(campaignEx.getShowCount()));
                contentValues.put("state", (Integer) 0);
                if (!a(campaignEx.getRequestId(), str)) {
                    return getWritableDatabase().insert("CacheCampaign", null, contentValues);
                }
                return getWritableDatabase().update("CacheCampaign", contentValues, "rid='" + campaignEx.getRequestId() + "' AND lrid='" + campaignEx.getLocalRequestId() + "' AND unitid = '" + str + "' AND state = 1", null);
            } catch (Exception e12) {
                e12.printStackTrace();
                return -1L;
            }
        }
        return 0L;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0131 A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r9
  0x0131: PHI (r9v6 android.database.Cursor) = (r9v5 android.database.Cursor), (r9v7 android.database.Cursor) binds: [B:33:0x013a, B:27:0x012f] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public final List<com.mbridge.msdk.foundation.b.b> a(String str, int i11, long j11) {
        Cursor cursorRawQuery;
        try {
            cursorRawQuery = getReadableDatabase().rawQuery("SELECT * FROM CacheCampaign" + (" WHERE unitid = '" + str + "' AND state > " + i11 + " and (" + TrackingKey.SHOW_TIME + " is null or " + TrackingKey.SHOW_TIME + " < " + j11 + ")"), null);
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.getCount() > 0) {
                        ArrayList arrayList = new ArrayList();
                        while (cursorRawQuery.moveToNext()) {
                            com.mbridge.msdk.foundation.b.b bVar = new com.mbridge.msdk.foundation.b.b();
                            String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("campaigns"));
                            JSONArray jSONArray = new JSONArray(string);
                            if (TextUtils.isEmpty(string)) {
                                try {
                                    cursorRawQuery.close();
                                } catch (Exception unused) {
                                }
                                return null;
                            }
                            if (jSONArray.length() > 0) {
                                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                                for (int i12 = 0; i12 < jSONArray.length(); i12++) {
                                    copyOnWriteArrayList.add(CampaignEx.parseCampaignWithBackData((JSONObject) jSONArray.get(i12)));
                                }
                                bVar.a(copyOnWriteArrayList);
                            }
                            bVar.b(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("lrid")));
                            bVar.c(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("rid")));
                            bVar.d(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("unitid")));
                            bVar.a(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ecppv")));
                            bVar.b(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("ts")));
                            bVar.b(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("state")));
                            bVar.a(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("show_count")));
                            bVar.c(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex(TrackingKey.SHOW_TIME)));
                            bVar.a(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("interval_ts")));
                            arrayList.add(bVar);
                        }
                        try {
                            cursorRawQuery.close();
                        } catch (Exception unused2) {
                        }
                        return arrayList;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                    } finally {
                        if (cursorRawQuery != null) {
                            try {
                                cursorRawQuery.close();
                            } catch (Exception unused3) {
                            }
                        }
                    }
                }
            }
            if (cursorRawQuery != null) {
            }
        } catch (Throwable th3) {
            th = th3;
            cursorRawQuery = null;
        }
        return null;
    }

    public final synchronized void a(String str, int i11) {
        if (i11 <= 0) {
            i11 = 1;
        }
        try {
            String str2 = "unitid = '" + str + "' AND ( (ts + interval_ts) < " + System.currentTimeMillis() + " OR show_count >= " + i11 + " )";
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return;
            }
            try {
                writableDatabase.execSQL("delete from CacheCampaign where " + str2);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        } catch (Exception e12) {
            ad.b("CacheCampaignDao", e12.getLocalizedMessage());
        }
    }

    public final synchronized void a(String str, String str2, String str3) {
        try {
            if (a(str2, str)) {
                String str4 = "unitid = '" + str + "' AND rid = '" + str2 + "'";
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase == null) {
                    return;
                }
                try {
                    writableDatabase.execSQL("delete from CacheCampaign where " + str4);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        } catch (Exception e12) {
            ad.b("CampaignDao", e12.getLocalizedMessage());
        }
    }

    public final void b(String str, String str2, String str3) {
        if (a(str, str3)) {
            getWritableDatabase().execSQL("UPDATE CacheCampaign SET show_count = show_count + 1 , show_time = " + System.currentTimeMillis() + " WHERE " + ("rid='" + str + "' AND unitid = '" + str3 + "' AND state = 1"));
        }
    }
}
