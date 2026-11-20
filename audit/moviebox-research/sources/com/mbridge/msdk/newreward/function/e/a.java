package com.mbridge.msdk.newreward.function.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.sdk.component.TRI.sc.sc.sc.pFF;
import com.google.android.gms.common.api.Api;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.newreward.function.common.DatabaseUtils;
import com.mbridge.msdk.newreward.function.common.JSONUtils;
import com.mbridge.msdk.newreward.function.common.MBridgeTaskManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SQLiteDatabase f46403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f46404b = new Object();

    public a(SQLiteDatabase sQLiteDatabase) {
        this.f46403a = sQLiteDatabase;
    }

    private static String a() {
        return "ad_type=? and app_id=? and placement_id=? and unit_id=? and (state in (6,402,406,403,8,7) or invalid_time<? )";
    }

    private static List<com.mbridge.msdk.newreward.function.d.a.b> a(Cursor cursor) {
        cursor = cursor;
        if (cursor == null || cursor.getCount() <= 0) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            int columnIndex = cursor.getColumnIndex("ad_type");
            int columnIndex2 = cursor.getColumnIndex("app_id");
            int columnIndex3 = cursor.getColumnIndex("placement_id");
            int columnIndex4 = cursor.getColumnIndex(MBridgeConstans.PROPERTIES_UNIT_ID);
            int columnIndex5 = cursor.getColumnIndex(TrackingKey.REQUEST_ID);
            int columnIndex6 = cursor.getColumnIndex("local_id");
            int columnIndex7 = cursor.getColumnIndex("bid_token");
            int columnIndex8 = cursor.getColumnIndex("header_bidding");
            int columnIndex9 = cursor.getColumnIndex("load_start_time");
            int columnIndex10 = cursor.getColumnIndex("backup_id");
            int columnIndex11 = cursor.getColumnIndex("state");
            int columnIndex12 = cursor.getColumnIndex("template");
            int columnIndex13 = cursor.getColumnIndex("invalid_time");
            int columnIndex14 = cursor.getColumnIndex("invalid_time_2");
            ArrayList arrayList2 = arrayList;
            int columnIndex15 = cursor.getColumnIndex("invalid_time_backup");
            int columnIndex16 = cursor.getColumnIndex("ecppv");
            int columnIndex17 = cursor.getColumnIndex("session_id");
            int i11 = columnIndex14;
            int columnIndex18 = cursor.getColumnIndex("system_id");
            int i12 = columnIndex13;
            int columnIndex19 = cursor.getColumnIndex("show_count");
            int columnIndex20 = cursor.getColumnIndex(com.mbridge.msdk.foundation.entity.b.JSON_KEY_PARENT_SESSION_ID);
            int columnIndex21 = cursor.getColumnIndex("data");
            int columnIndex22 = cursor.getColumnIndex("token_rule");
            while (cursor.moveToNext()) {
                int i13 = columnIndex22;
                columnIndex = columnIndex;
                columnIndex2 = columnIndex2;
                columnIndex3 = columnIndex3;
                columnIndex4 = columnIndex4;
                com.mbridge.msdk.newreward.function.d.a.b bVar = new com.mbridge.msdk.newreward.function.d.a.b(cursor.getInt(columnIndex), cursor.getString(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4));
                bVar.a(cursor.getString(columnIndex5));
                bVar.b(cursor.getString(columnIndex6));
                String string = cursor.getString(columnIndex7);
                bVar.c(string);
                boolean z11 = true;
                if (cursor.getInt(columnIndex8) != 1) {
                    z11 = false;
                }
                bVar.a(z11);
                bVar.e(cursor.getLong(columnIndex9));
                bVar.d(cursor.getString(columnIndex17));
                bVar.e(cursor.getString(columnIndex18));
                bVar.f(cursor.getString(columnIndex10));
                bVar.a(cursor.getInt(columnIndex11));
                bVar.b(cursor.getInt(columnIndex12));
                columnIndex18 = columnIndex18;
                int i14 = i12;
                bVar.b(cursor.getLong(i14));
                i12 = i14;
                int i15 = i11;
                bVar.c(cursor.getLong(i15));
                i11 = i15;
                int i16 = columnIndex15;
                bVar.d(cursor.getLong(i16));
                columnIndex15 = i16;
                int i17 = columnIndex16;
                bVar.a(cursor.getDouble(i17));
                int i18 = columnIndex19;
                bVar.c(cursor.getInt(i18));
                columnIndex16 = i17;
                int i19 = columnIndex20;
                bVar.g(cursor.getString(i19));
                columnIndex17 = columnIndex17;
                bVar.i(cursor.getInt(i13));
                int i21 = columnIndex21;
                JSONObject jSONObject = JSONUtils.parse(cursor.getString(i21));
                bVar.a(jSONObject);
                columnIndex22 = i13;
                arrayList2 = arrayList2;
                arrayList2.add(bVar);
                CampaignUnit campaignUnit = com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(jSONObject, string);
                if (campaignUnit != null) {
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList<CampaignEx> ads = campaignUnit.getAds();
                    if (ads != null) {
                        for (CampaignEx campaignEx : ads) {
                            int i22 = i21;
                            int i23 = i18;
                            campaignEx.setRequestId(bVar.d());
                            campaignEx.setLocalRequestId(bVar.e());
                            com.mbridge.msdk.newreward.function.d.a.a aVar = new com.mbridge.msdk.newreward.function.d.a.a(bVar);
                            aVar.a(campaignEx);
                            int i24 = i19;
                            aVar.b(campaignEx.getAppName());
                            aVar.c(campaignEx.getRequestIdNotice());
                            aVar.a(campaignEx.getId());
                            arrayList3.add(aVar);
                            bVar.h(campaignEx.getCMPTEntryUrl());
                            bVar.f(campaignEx.getMof_tplid());
                            bVar.h(campaignEx.getVcn());
                            CampaignEx.c rewardTemplateMode = campaignEx.getRewardTemplateMode();
                            if (rewardTemplateMode != null) {
                                bVar.g(rewardTemplateMode.b());
                            }
                            i18 = i23;
                            i21 = i22;
                            i19 = i24;
                        }
                        columnIndex21 = i21;
                        int i25 = i18;
                        int i26 = i19;
                        bVar.b(ads);
                        bVar.a(arrayList3);
                        columnIndex19 = i25;
                        columnIndex20 = i26;
                    }
                }
                columnIndex21 = i21;
                columnIndex20 = i19;
                columnIndex19 = i18;
            }
            return arrayList2;
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.a("CampaignTable", "parseCampaignTable: ", e11);
            }
            return null;
        }
    }

    public final List<com.mbridge.msdk.newreward.function.d.a.b> a(int i11, String str, String str2, boolean z11) {
        Cursor cursorQuery;
        Cursor cursor = null;
        if (!DatabaseUtils.isDatabaseAvailable(this.f46403a)) {
            if (MBridgeConstans.DEBUG) {
                ad.b("CampaignTable", "find: database is not available");
            }
            return null;
        }
        synchronized (this.f46404b) {
            try {
                try {
                    cursorQuery = this.f46403a.query("campaign", null, "ad_type=? and app_id=? and placement_id=? and unit_id=? and header_bidding=? and state in (401,404,405)", new String[]{String.valueOf(i11), com.mbridge.msdk.foundation.controller.c.m().k(), str, str2, String.valueOf(z11 ? 1 : 0)}, null, null, "load_start_time desc");
                    try {
                        try {
                            List<com.mbridge.msdk.newreward.function.d.a.b> listA = a(cursorQuery);
                            if (listA == null || listA.size() == 0) {
                                if (MBridgeConstans.DEBUG) {
                                    ad.b("CampaignTable", "find: mBridgeCampaigns is null or empty");
                                }
                            }
                            DatabaseUtils.closeCursor(cursorQuery);
                            return listA;
                        } catch (Exception e11) {
                            e = e11;
                            if (MBridgeConstans.DEBUG) {
                                ad.a("CampaignTable", "find: ", e);
                            }
                            DatabaseUtils.closeCursor(cursorQuery);
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = cursorQuery;
                        DatabaseUtils.closeCursor(cursor);
                        throw th;
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            } catch (Exception e12) {
                e = e12;
                cursorQuery = null;
            } catch (Throwable th4) {
                th = th4;
                DatabaseUtils.closeCursor(cursor);
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<com.mbridge.msdk.newreward.function.d.a.b> a(int i11, String str, String str2, boolean z11, int i12) {
        Cursor cursorQuery;
        pFF.sc scVar = 0;
        if (!DatabaseUtils.isDatabaseAvailable(this.f46403a)) {
            if (MBridgeConstans.DEBUG) {
                ad.b("CampaignTable", "find: database is not available");
            }
            return null;
        }
        synchronized (this.f46404b) {
            try {
                try {
                    try {
                        cursorQuery = this.f46403a.query("campaign", null, "ad_type=? and app_id=? and placement_id=? and unit_id=? and header_bidding=? and state=? and invalid_time>?", new String[]{String.valueOf(i11), com.mbridge.msdk.foundation.controller.c.m().k(), str, str2, String.valueOf(z11 ? 1 : 0), String.valueOf(3), String.valueOf(System.currentTimeMillis())}, null, null, "load_start_time desc", String.valueOf(i12 <= 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : i12));
                        try {
                            List<com.mbridge.msdk.newreward.function.d.a.b> listA = a(cursorQuery);
                            if (listA == null || listA.size() == 0) {
                                if (MBridgeConstans.DEBUG) {
                                    ad.b("CampaignTable", "find: mBridgeCampaigns is null or empty");
                                }
                            }
                            DatabaseUtils.closeCursor(cursorQuery);
                            return listA;
                        } catch (Exception e11) {
                            e = e11;
                            if (MBridgeConstans.DEBUG) {
                                ad.a("CampaignTable", "find: ", e);
                            }
                            DatabaseUtils.closeCursor(cursorQuery);
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        scVar = 1;
                        DatabaseUtils.closeCursor(scVar);
                        throw th;
                    }
                } catch (Exception e12) {
                    e = e12;
                    cursorQuery = null;
                } catch (Throwable th3) {
                    th = th3;
                    DatabaseUtils.closeCursor(scVar);
                    throw th;
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
    }

    public final void a(final int i11, final String str, final String str2) {
        MBridgeTaskManager.campaignTableExecute(new Runnable() { // from class: com.mbridge.msdk.newreward.function.e.a.6
            @Override // java.lang.Runnable
            public final void run() {
                a.this.d(i11, str, str2);
            }
        });
    }

    public final void a(final int i11, final String str, final String str2, final String str3, final int i12) {
        MBridgeTaskManager.campaignTableExecute(new Runnable() { // from class: com.mbridge.msdk.newreward.function.e.a.5
            @Override // java.lang.Runnable
            public final void run() {
                a.this.b(i11, str, str2, str3, i12);
            }
        });
    }

    public final void a(final int i11, final String str, final String str2, final String str3, final boolean z11, final String str4, final long j11) {
        MBridgeTaskManager.campaignTableExecute(new Runnable() { // from class: com.mbridge.msdk.newreward.function.e.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.b(i11, str, str2, str3, z11, str4, j11);
            }
        });
    }

    public final void a(final int i11, final String str, final String str2, final boolean z11, final int i12, final b bVar) {
        MBridgeTaskManager.campaignTableExecute(new Runnable() { // from class: com.mbridge.msdk.newreward.function.e.a.4
            @Override // java.lang.Runnable
            public final void run() {
                List<com.mbridge.msdk.newreward.function.d.a.b> listA = a.this.a(i11, str, str2, z11, i12);
                if (listA == null || listA.size() == 0) {
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a();
                        return;
                    }
                    return;
                }
                b bVar3 = bVar;
                if (bVar3 != null) {
                    bVar3.a(listA);
                }
            }
        });
    }

    public final void a(final int i11, final String str, final String str2, final boolean z11, final b bVar) {
        MBridgeTaskManager.campaignTableExecute(new Runnable() { // from class: com.mbridge.msdk.newreward.function.e.a.3
            @Override // java.lang.Runnable
            public final void run() {
                List<com.mbridge.msdk.newreward.function.d.a.b> listA = a.this.a(i11, str, str2, z11);
                if (listA == null || listA.isEmpty()) {
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a();
                        return;
                    }
                    return;
                }
                b bVar3 = bVar;
                if (bVar3 != null) {
                    bVar3.a(listA);
                }
            }
        });
    }

    public final void a(final com.mbridge.msdk.newreward.function.d.a.b bVar) {
        MBridgeTaskManager.campaignTableExecute(new Runnable() { // from class: com.mbridge.msdk.newreward.function.e.a.2
            @Override // java.lang.Runnable
            public final void run() {
                a.this.b(bVar);
            }
        });
    }

    public final void b(final int i11, final String str, final String str2) {
        MBridgeTaskManager.campaignTableExecute(new Runnable() { // from class: com.mbridge.msdk.newreward.function.e.a.7
            @Override // java.lang.Runnable
            public final void run() {
                a.this.c(i11, str, str2);
            }
        });
    }

    public final void b(int i11, String str, String str2, String str3, int i12) {
        SQLiteDatabase sQLiteDatabase;
        if (!DatabaseUtils.isDatabaseAvailable(this.f46403a)) {
            if (MBridgeConstans.DEBUG) {
                ad.b("CampaignTable", "updateState: database is not available");
                return;
            }
            return;
        }
        synchronized (this.f46404b) {
            try {
                try {
                    DatabaseUtils.beginTransaction(this.f46403a);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("state", Integer.valueOf(i12));
                    int iUpdate = this.f46403a.update("campaign", contentValues, "ad_type=? and app_id=? and placement_id=? and unit_id=? and local_id=?", new String[]{String.valueOf(i11), com.mbridge.msdk.foundation.controller.c.m().k(), str, str2, str3});
                    if (MBridgeConstans.DEBUG) {
                        ad.a("CampaignTable", "updateState result:  " + iUpdate);
                    }
                    DatabaseUtils.setTransactionSuccessful(this.f46403a);
                    sQLiteDatabase = this.f46403a;
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        ad.a("CampaignTable", "updateState: ", e11);
                    }
                    sQLiteDatabase = this.f46403a;
                }
                DatabaseUtils.endTransaction(sQLiteDatabase);
            } catch (Throwable th2) {
                DatabaseUtils.endTransaction(this.f46403a);
                throw th2;
            }
        }
    }

    public final void b(int i11, String str, String str2, String str3, boolean z11, String str4, long j11) {
        SQLiteDatabase sQLiteDatabase;
        if (!DatabaseUtils.isDatabaseAvailable(this.f46403a)) {
            if (MBridgeConstans.DEBUG) {
                ad.b("CampaignTable", "insert: database is not available");
                return;
            }
            return;
        }
        double d11 = com.mbridge.msdk.newreward.function.h.a.d(str4);
        synchronized (this.f46404b) {
            try {
                try {
                    Cursor cursorQuery = this.f46403a.query("campaign", null, "ad_type=? and app_id=? and placement_id=? and unit_id=? and local_id=?", new String[]{String.valueOf(i11), com.mbridge.msdk.foundation.controller.c.m().k(), str, str2, str3}, null, null, null);
                    if (cursorQuery != null && cursorQuery.getCount() > 0) {
                        if (MBridgeConstans.DEBUG) {
                            ad.a("CampaignTable", "insert:  already exist");
                        }
                        DatabaseUtils.closeCursor(cursorQuery);
                        DatabaseUtils.endTransaction(this.f46403a);
                        return;
                    }
                    DatabaseUtils.beginTransaction(this.f46403a);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("ad_type", Integer.valueOf(i11));
                    contentValues.put("app_id", com.mbridge.msdk.foundation.controller.c.m().k());
                    contentValues.put("placement_id", str);
                    contentValues.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                    contentValues.put("local_id", str3);
                    contentValues.put("state", (Integer) 0);
                    contentValues.put("bid_token", str4);
                    contentValues.put("invalid_time", Long.valueOf(j11));
                    contentValues.put("header_bidding", Integer.valueOf(z11 ? 1 : 0));
                    contentValues.put("load_start_time", Long.valueOf(System.currentTimeMillis()));
                    contentValues.put("ecppv", Double.valueOf(d11));
                    long jInsert = this.f46403a.insert("campaign", null, contentValues);
                    if (MBridgeConstans.DEBUG) {
                        ad.a("CampaignTable", "insert result:  " + jInsert);
                    }
                    DatabaseUtils.setTransactionSuccessful(this.f46403a);
                    sQLiteDatabase = this.f46403a;
                    DatabaseUtils.endTransaction(sQLiteDatabase);
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        ad.a("CampaignTable", "insert: ", e11);
                    }
                    sQLiteDatabase = this.f46403a;
                }
            } catch (Throwable th2) {
                DatabaseUtils.endTransaction(this.f46403a);
                throw th2;
            }
        }
    }

    public final void b(com.mbridge.msdk.newreward.function.d.a.b bVar) {
        SQLiteDatabase sQLiteDatabase;
        if (bVar == null) {
            if (MBridgeConstans.DEBUG) {
                ad.b("CampaignTable", "insert: mBridgeCampaigns is null");
                return;
            }
            return;
        }
        List<com.mbridge.msdk.newreward.function.d.a.a> listS = bVar.s();
        if (listS == null || listS.isEmpty()) {
            if (MBridgeConstans.DEBUG) {
                ad.b("CampaignTable", "insert: campaignList is null or empty");
                return;
            }
            return;
        }
        if (!DatabaseUtils.isDatabaseAvailable(this.f46403a)) {
            if (MBridgeConstans.DEBUG) {
                ad.b("CampaignTable", "insert: database is not available");
                return;
            }
            return;
        }
        synchronized (this.f46404b) {
            try {
                try {
                    DatabaseUtils.beginTransaction(this.f46403a);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(TrackingKey.REQUEST_ID, bVar.d());
                    contentValues.put("session_id", bVar.i());
                    contentValues.put("system_id", bVar.j());
                    contentValues.put("backup_id", bVar.k());
                    contentValues.put("state", Integer.valueOf(bVar.h()));
                    contentValues.put("template", Integer.valueOf(bVar.m()));
                    contentValues.put("invalid_time", Long.valueOf(bVar.n()));
                    contentValues.put("invalid_time_2", Long.valueOf(bVar.o()));
                    contentValues.put("invalid_time_backup", Long.valueOf(bVar.p()));
                    contentValues.put("show_count", Integer.valueOf(bVar.r()));
                    contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_PARENT_SESSION_ID, bVar.l());
                    contentValues.put("token_rule", Integer.valueOf(bVar.E()));
                    contentValues.put("data", bVar.t().toString());
                    long jUpdate = this.f46403a.update("campaign", contentValues, "ad_type=? and app_id=? and placement_id=? and unit_id=? and local_id=?", new String[]{String.valueOf(bVar.a()), com.mbridge.msdk.foundation.controller.c.m().k(), bVar.b(), bVar.c(), bVar.e()});
                    if (MBridgeConstans.DEBUG) {
                        ad.a("CampaignTable", "updateCampaign result:  " + jUpdate);
                    }
                    DatabaseUtils.setTransactionSuccessful(this.f46403a);
                    sQLiteDatabase = this.f46403a;
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        ad.a("CampaignTable", "updateCampaign: ", e11);
                    }
                    sQLiteDatabase = this.f46403a;
                }
                DatabaseUtils.endTransaction(sQLiteDatabase);
            } catch (Throwable th2) {
                DatabaseUtils.endTransaction(this.f46403a);
                throw th2;
            }
        }
    }

    public final void c(int i11, String str, String str2) {
        SQLiteDatabase sQLiteDatabase;
        if (!DatabaseUtils.isDatabaseAvailable(this.f46403a)) {
            if (MBridgeConstans.DEBUG) {
                ad.b("CampaignTable", "clearLoadCheckCampaigns: database is not available");
                return;
            }
            return;
        }
        synchronized (this.f46404b) {
            try {
                try {
                    DatabaseUtils.beginTransaction(this.f46403a);
                    int iDelete = this.f46403a.delete("campaign", "ad_type=? and app_id=? and placement_id=? and unit_id=? and state in (0,405,401,404);", new String[]{String.valueOf(i11), com.mbridge.msdk.foundation.controller.c.m().k(), str, str2});
                    if (MBridgeConstans.DEBUG) {
                        ad.a("CampaignTable", "clearLoadCheckCampaigns result:  " + iDelete);
                    }
                    DatabaseUtils.setTransactionSuccessful(this.f46403a);
                    sQLiteDatabase = this.f46403a;
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        ad.a("CampaignTable", "clearLoadCheckCampaigns: ", e11);
                    }
                    sQLiteDatabase = this.f46403a;
                }
                DatabaseUtils.endTransaction(sQLiteDatabase);
            } catch (Throwable th2) {
                DatabaseUtils.endTransaction(this.f46403a);
                throw th2;
            }
        }
    }

    public final void d(int i11, String str, String str2) {
        SQLiteDatabase sQLiteDatabase;
        if (!DatabaseUtils.isDatabaseAvailable(this.f46403a)) {
            if (MBridgeConstans.DEBUG) {
                ad.b("CampaignTable", "clearUnInvalidCampaign: database is not available");
                return;
            }
            return;
        }
        synchronized (this.f46404b) {
            try {
                try {
                    DatabaseUtils.beginTransaction(this.f46403a);
                    int iDelete = this.f46403a.delete("campaign", a(), new String[]{String.valueOf(i11), com.mbridge.msdk.foundation.controller.c.m().k(), str, str2, String.valueOf(System.currentTimeMillis())});
                    if (MBridgeConstans.DEBUG) {
                        ad.a("CampaignTable", "clearUnInvalidCampaign result:  " + iDelete);
                    }
                    DatabaseUtils.setTransactionSuccessful(this.f46403a);
                    sQLiteDatabase = this.f46403a;
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        ad.a("CampaignTable", "clearUnInvalidCampaign: ", e11);
                    }
                    sQLiteDatabase = this.f46403a;
                }
                DatabaseUtils.endTransaction(sQLiteDatabase);
            } catch (Throwable th2) {
                DatabaseUtils.endTransaction(this.f46403a);
                throw th2;
            }
        }
    }

    public final List<String> e(int i11, String str, String str2) {
        Cursor cursor = null;
        if (!DatabaseUtils.isDatabaseAvailable(this.f46403a)) {
            if (MBridgeConstans.DEBUG) {
                ad.b("CampaignTable", "database is not available");
            }
            return null;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.f46404b) {
            try {
                try {
                    try {
                        Cursor cursorQuery = this.f46403a.query("campaign", null, a(), new String[]{String.valueOf(i11), com.mbridge.msdk.foundation.controller.c.m().k(), str, str2, String.valueOf(System.currentTimeMillis())}, null, null, null, null);
                        if (cursorQuery != null) {
                            try {
                                if (cursorQuery.getCount() > 0) {
                                    int columnIndex = cursorQuery.getColumnIndex("local_id");
                                    while (cursorQuery.moveToNext()) {
                                        String string = cursorQuery.getString(columnIndex);
                                        if (!TextUtils.isEmpty(string)) {
                                            arrayList.add(string);
                                        }
                                    }
                                    DatabaseUtils.closeCursor(cursorQuery);
                                }
                            } catch (Exception e11) {
                                e = e11;
                                cursor = cursorQuery;
                                if (MBridgeConstans.DEBUG) {
                                    ad.a("CampaignTable", "find: ", e);
                                }
                                DatabaseUtils.closeCursor(cursor);
                            } catch (Throwable th2) {
                                th = th2;
                                cursor = cursorQuery;
                                DatabaseUtils.closeCursor(cursor);
                                throw th;
                            }
                            return arrayList;
                        }
                        DatabaseUtils.closeCursor(cursorQuery);
                        return null;
                    } catch (Throwable th3) {
                        throw th3;
                    }
                } catch (Exception e12) {
                    e = e12;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }
}
