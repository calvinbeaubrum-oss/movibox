package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.cloud.tmc.integration.bridge.NetworkBridge;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.an;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class q extends a<com.mbridge.msdk.foundation.entity.n> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f44202a = "com.mbridge.msdk.foundation.db.q";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static q f44203b;

    private q(g gVar) {
        super(gVar);
    }

    public static q a(g gVar) {
        if (f44203b == null) {
            synchronized (q.class) {
                try {
                    if (f44203b == null) {
                        f44203b = new q(gVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f44203b;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0020 A[EXC_TOP_SPLITTER, PHI: r0 r1
  0x0020: PHI (r0v4 int) = (r0v0 int), (r0v6 int) binds: [B:20:0x0029, B:14:0x001e] A[DONT_GENERATE, DONT_INLINE]
  0x0020: PHI (r1v3 android.database.Cursor) = (r1v2 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:20:0x0029, B:14:0x001e] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public final synchronized int a() {
        int i11;
        i11 = 0;
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = getReadableDatabase().rawQuery("select count(*) from reward_report", null);
                if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                    i11 = cursorRawQuery.getInt(0);
                }
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            }
        } catch (Throwable th2) {
            if (cursorRawQuery != null) {
                try {
                    cursorRawQuery.close();
                } catch (Exception unused2) {
                }
            }
            throw th2;
        }
        return i11;
    }

    public final synchronized long a(com.mbridge.msdk.foundation.entity.n nVar) {
        try {
            if (nVar != null) {
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("key", nVar.a());
                    contentValues.put(NetworkBridge.KEY_NETWORK_TYPE, Integer.valueOf(nVar.k()));
                    contentValues.put("network_str", nVar.l());
                    contentValues.put("isCompleteView", Integer.valueOf(nVar.w()));
                    contentValues.put("watchedMillis", Integer.valueOf(nVar.x()));
                    contentValues.put("videoLength", Integer.valueOf(nVar.p()));
                    if (!TextUtils.isEmpty(nVar.r())) {
                        contentValues.put("offerUrl", nVar.r());
                    }
                    if (!TextUtils.isEmpty(nVar.h())) {
                        contentValues.put("reason", URLEncoder.encode(nVar.h(), "utf-8"));
                    }
                    contentValues.put("result", Integer.valueOf(nVar.m()));
                    contentValues.put("duration", nVar.n());
                    contentValues.put("videoSize", Long.valueOf(nVar.o()));
                    contentValues.put("type", nVar.t());
                    String strS = nVar.s();
                    if (!TextUtils.isEmpty(strS)) {
                        contentValues.put("endcard_url", strS);
                    }
                    String strQ = nVar.q();
                    if (!TextUtils.isEmpty(strQ)) {
                        contentValues.put(CampaignEx.JSON_KEY_VIDEO_URL, strQ);
                    }
                    String strF = nVar.f();
                    if (!TextUtils.isEmpty(strF)) {
                        contentValues.put("rid", strF);
                    }
                    String strG = nVar.g();
                    if (!TextUtils.isEmpty(strG)) {
                        contentValues.put("rid_n", strG);
                    }
                    String strZ = nVar.z();
                    if (!TextUtils.isEmpty(strZ)) {
                        contentValues.put("template_url", strZ);
                    }
                    String strV = nVar.v();
                    if (!TextUtils.isEmpty(strV)) {
                        contentValues.put("image_url", strV);
                    }
                    String strD = nVar.d();
                    if (!TextUtils.isEmpty(strD)) {
                        contentValues.put("ad_type", URLEncoder.encode(strD, "utf-8"));
                    }
                    contentValues.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, nVar.c());
                    contentValues.put("campaignId", nVar.e());
                    if ("2000039".equals(nVar.a())) {
                        String strA = com.mbridge.msdk.foundation.entity.n.a(nVar);
                        if (an.b(strA)) {
                            contentValues.put("h5_click_data", strA);
                        }
                    }
                    String strB = nVar.b();
                    if (!TextUtils.isEmpty(strB)) {
                        contentValues.put("resource_type", URLEncoder.encode(strB, "utf-8"));
                    }
                    String strJ = nVar.j();
                    if (!TextUtils.isEmpty(strJ)) {
                        contentValues.put("device_id", URLEncoder.encode(strJ, "utf-8"));
                    }
                    String strI = nVar.i();
                    if (!TextUtils.isEmpty(strI)) {
                        contentValues.put("creative", URLEncoder.encode(strI, "utf-8"));
                    }
                    contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, Integer.valueOf(nVar.u()));
                    return getWritableDatabase().insert("reward_report", null, contentValues);
                } catch (Exception e11) {
                    e11.printStackTrace();
                    ad.b(f44202a, e11.getMessage());
                }
            }
            return -1L;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0361 A[Catch: all -> 0x0343, Exception -> 0x036b, TRY_ENTER, TRY_LEAVE, TryCatch #3 {, blocks: (B:4:0x0003, B:128:0x0367, B:129:0x036a, B:125:0x0361, B:109:0x033f, B:117:0x034a), top: B:140:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x0367 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:163:0x02f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:0x02fb  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public final synchronized List<com.mbridge.msdk.foundation.entity.n> a(String str) {
        Cursor cursor;
        Cursor cursorQuery;
        Cursor cursor2;
        com.mbridge.msdk.foundation.entity.n nVar;
        String str2;
        ArrayList arrayList;
        Cursor cursor3;
        com.mbridge.msdk.foundation.entity.n nVar2;
        String str3 = str;
        synchronized (this) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        cursorQuery = getReadableDatabase().query("reward_report", null, "key=?", new String[]{str}, null, null, null);
                        if (cursorQuery != null) {
                            try {
                                if (cursorQuery.getCount() > 0) {
                                    ArrayList arrayList2 = new ArrayList();
                                    while (cursorQuery.moveToNext()) {
                                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("key"));
                                        int i11 = cursorQuery.getInt(cursorQuery.getColumnIndex(NetworkBridge.KEY_NETWORK_TYPE));
                                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("network_str"));
                                        cursorQuery.getInt(cursorQuery.getColumnIndex("isCompleteView"));
                                        cursorQuery.getInt(cursorQuery.getColumnIndex("watchedMillis"));
                                        int i12 = cursorQuery.getInt(cursorQuery.getColumnIndex("videoLength"));
                                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("offerUrl"));
                                        String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("reason"));
                                        int i13 = cursorQuery.getInt(cursorQuery.getColumnIndex("result"));
                                        String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("duration"));
                                        int i14 = cursorQuery.getInt(cursorQuery.getColumnIndex("videoSize"));
                                        String string6 = cursorQuery.getString(cursorQuery.getColumnIndex("campaignId"));
                                        String string7 = cursorQuery.getString(cursorQuery.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_URL));
                                        String string8 = cursorQuery.getString(cursorQuery.getColumnIndex(CampaignEx.JSON_KEY_CAMPAIGN_UNITID));
                                        String string9 = cursorQuery.getString(cursorQuery.getColumnIndex("rid"));
                                        String string10 = cursorQuery.getString(cursorQuery.getColumnIndex("rid_n"));
                                        String string11 = cursorQuery.getString(cursorQuery.getColumnIndex("ad_type"));
                                        String string12 = cursorQuery.getString(cursorQuery.getColumnIndex("resource_type"));
                                        ArrayList arrayList3 = arrayList2;
                                        String string13 = cursorQuery.getString(cursorQuery.getColumnIndex("device_id"));
                                        String string14 = cursorQuery.getString(cursorQuery.getColumnIndex("creative"));
                                        int i15 = cursorQuery.getInt(cursorQuery.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T));
                                        if (str3.equals("2000021")) {
                                            try {
                                                try {
                                                    nVar = new com.mbridge.msdk.foundation.entity.n(string, i11, string3, string4, string2);
                                                    nVar.e(string6);
                                                    nVar.m(string7);
                                                    nVar.f(string9);
                                                    nVar.g(string10);
                                                    nVar.c(string8);
                                                    str2 = str3;
                                                    cursor2 = cursorQuery;
                                                    if (nVar != null) {
                                                        try {
                                                            arrayList = arrayList3;
                                                            arrayList.add(nVar);
                                                        } catch (Exception e11) {
                                                            e = e11;
                                                        } catch (Throwable th2) {
                                                            th = th2;
                                                            cursor = cursor2;
                                                            if (cursor != null) {
                                                                try {
                                                                    cursor.close();
                                                                } catch (Exception unused) {
                                                                }
                                                            }
                                                            throw th;
                                                        }
                                                    } else {
                                                        arrayList = arrayList3;
                                                    }
                                                    int i16 = cursor2.getInt(cursor2.getColumnIndex("id"));
                                                    getWritableDatabase().delete("reward_report", "id = ?", new String[]{i16 + ""});
                                                    arrayList2 = arrayList;
                                                    cursorQuery = cursor2;
                                                    str3 = str2;
                                                } catch (Exception e12) {
                                                    e = e12;
                                                    e.printStackTrace();
                                                    ad.b(f44202a, e.getMessage());
                                                    if (cursorQuery != null) {
                                                        cursorQuery.close();
                                                    }
                                                    return null;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                cursor = cursorQuery;
                                                if (cursor != null) {
                                                    cursor.close();
                                                }
                                                throw th;
                                            }
                                        } else if (str3.equals("2000022")) {
                                            try {
                                                cursor3 = cursorQuery;
                                                try {
                                                    nVar = new com.mbridge.msdk.foundation.entity.n(string, i11, i12, string3, i13, string5, i14, string2);
                                                    nVar.e(string6);
                                                    nVar.m(string7);
                                                    nVar.f(string9);
                                                    nVar.c(string8);
                                                    nVar.h(string4);
                                                    nVar.g(string10);
                                                    nVar.d(string11);
                                                    str2 = str3;
                                                    cursor2 = cursor3;
                                                    if (nVar != null) {
                                                        arrayList = arrayList3;
                                                        arrayList.add(nVar);
                                                    } else {
                                                        arrayList = arrayList3;
                                                    }
                                                    int i17 = cursor2.getInt(cursor2.getColumnIndex("id"));
                                                    getWritableDatabase().delete("reward_report", "id = ?", new String[]{i17 + ""});
                                                    arrayList2 = arrayList;
                                                    cursorQuery = cursor2;
                                                    str3 = str2;
                                                } catch (Exception e13) {
                                                    e = e13;
                                                    cursorQuery = cursor3;
                                                    e.printStackTrace();
                                                    ad.b(f44202a, e.getMessage());
                                                    if (cursorQuery != null) {
                                                        cursorQuery.close();
                                                    }
                                                    return null;
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    cursor = cursor3;
                                                    if (cursor != null) {
                                                        cursor.close();
                                                    }
                                                    throw th;
                                                }
                                            } catch (Exception e14) {
                                                e = e14;
                                            } catch (Throwable th5) {
                                                th = th5;
                                                cursor3 = cursorQuery;
                                            }
                                        } else {
                                            cursor3 = cursorQuery;
                                            try {
                                                if (str3.equals("2000025")) {
                                                    nVar = new com.mbridge.msdk.foundation.entity.n(string, i11, i12, string3, i13, string5, i14, string2);
                                                } else {
                                                    if (str3.equals("2000024")) {
                                                        nVar = new com.mbridge.msdk.foundation.entity.n(string, i11, string3, string4, string2);
                                                    } else {
                                                        if ("2000039".equals(str3)) {
                                                            try {
                                                                nVar = new com.mbridge.msdk.foundation.entity.n(cursor3.getString(cursor3.getColumnIndex("h5_click_data")));
                                                                str2 = str3;
                                                                cursor2 = cursor3;
                                                            } catch (Exception e15) {
                                                                e = e15;
                                                                cursorQuery = cursor3;
                                                            } catch (Throwable th6) {
                                                                th = th6;
                                                                cursor = cursor3;
                                                                if (cursor != null) {
                                                                    cursor.close();
                                                                }
                                                                throw th;
                                                            }
                                                        } else {
                                                            try {
                                                                if ("2000043".equals(str3)) {
                                                                    try {
                                                                        String string15 = cursor3.getString(cursor3.getColumnIndex("type"));
                                                                        String string16 = cursor3.getString(cursor3.getColumnIndex("endcard_url"));
                                                                        cursor3 = cursor3;
                                                                        com.mbridge.msdk.foundation.entity.n nVar3 = new com.mbridge.msdk.foundation.entity.n(str, i13, string5, string16, string6, string8, string4, string15);
                                                                        nVar3.f(string9);
                                                                        nVar3.g(string10);
                                                                        if (!TextUtils.isEmpty(string6)) {
                                                                            nVar3.e(string6);
                                                                        }
                                                                        nVar3.c(i15);
                                                                        nVar3.d(string11);
                                                                        nVar3.b(string12);
                                                                        nVar3.j(string13);
                                                                        nVar3.i(string14);
                                                                        str2 = str;
                                                                        nVar = nVar3;
                                                                        cursor2 = cursor3;
                                                                    } catch (Exception e16) {
                                                                        e = e16;
                                                                        cursor3 = cursor3;
                                                                        cursorQuery = cursor3;
                                                                        e.printStackTrace();
                                                                        ad.b(f44202a, e.getMessage());
                                                                        if (cursorQuery != null) {
                                                                            cursorQuery.close();
                                                                        }
                                                                        return null;
                                                                    } catch (Throwable th7) {
                                                                        th = th7;
                                                                        cursor3 = cursor3;
                                                                        cursor = cursor3;
                                                                        if (cursor != null) {
                                                                            cursor.close();
                                                                        }
                                                                        throw th;
                                                                    }
                                                                } else {
                                                                    cursor3 = cursor3;
                                                                    str2 = str;
                                                                    if ("2000045".equals(str2)) {
                                                                        nVar2 = new com.mbridge.msdk.foundation.entity.n();
                                                                        nVar2.a(str2);
                                                                        nVar2.a(i11);
                                                                        nVar2.b(i13);
                                                                        nVar2.e(string6);
                                                                        cursor2 = cursor3;
                                                                        nVar2.q(cursor2.getString(cursor2.getColumnIndex("template_url")));
                                                                        nVar2.h(string4);
                                                                        nVar2.f(string9);
                                                                        nVar2.g(string10);
                                                                        nVar2.c(string8);
                                                                    } else {
                                                                        cursor2 = cursor3;
                                                                        if ("2000044".equals(str2)) {
                                                                            nVar2 = new com.mbridge.msdk.foundation.entity.n();
                                                                            nVar2.a(str2);
                                                                            nVar2.a(i11);
                                                                            nVar2.e(string6);
                                                                            nVar2.p(cursor2.getString(cursor2.getColumnIndex("image_url")));
                                                                            nVar2.h(string4);
                                                                            nVar2.f(string9);
                                                                            nVar2.g(string10);
                                                                            nVar2.c(string8);
                                                                        } else if ("2000054".equals(str2)) {
                                                                            com.mbridge.msdk.foundation.entity.n nVar4 = new com.mbridge.msdk.foundation.entity.n();
                                                                            nVar4.a(str2);
                                                                            nVar4.b(string12);
                                                                            nVar4.c(string8);
                                                                            nVar4.j(string13);
                                                                            nVar4.d(string11);
                                                                            nVar4.e(string6);
                                                                            nVar4.f(string9);
                                                                            nVar4.g(string10);
                                                                            nVar4.b(i13);
                                                                            nVar4.h(string4);
                                                                            nVar4.a(i11);
                                                                            nVar4.i(string14);
                                                                            nVar4.c(i15);
                                                                            nVar = nVar4;
                                                                        } else {
                                                                            nVar = null;
                                                                        }
                                                                    }
                                                                    nVar = nVar2;
                                                                }
                                                            } catch (Exception e17) {
                                                                e = e17;
                                                                cursor2 = cursor3;
                                                            } catch (Throwable th8) {
                                                                th = th8;
                                                                cursor2 = cursor3;
                                                                cursor = cursor2;
                                                                if (cursor != null) {
                                                                    cursor.close();
                                                                }
                                                                throw th;
                                                            }
                                                        }
                                                        if (nVar != null) {
                                                            arrayList = arrayList3;
                                                            arrayList.add(nVar);
                                                        } else {
                                                            arrayList = arrayList3;
                                                        }
                                                        int i18 = cursor2.getInt(cursor2.getColumnIndex("id"));
                                                        getWritableDatabase().delete("reward_report", "id = ?", new String[]{i18 + ""});
                                                        arrayList2 = arrayList;
                                                        cursorQuery = cursor2;
                                                        str3 = str2;
                                                    }
                                                    cursorQuery = cursor2;
                                                    e.printStackTrace();
                                                    ad.b(f44202a, e.getMessage());
                                                    if (cursorQuery != null) {
                                                        cursorQuery.close();
                                                    }
                                                }
                                                str2 = str3;
                                                cursor2 = cursor3;
                                                if (nVar != null) {
                                                    arrayList = arrayList3;
                                                    arrayList.add(nVar);
                                                } else {
                                                    arrayList = arrayList3;
                                                }
                                                int i19 = cursor2.getInt(cursor2.getColumnIndex("id"));
                                                getWritableDatabase().delete("reward_report", "id = ?", new String[]{i19 + ""});
                                                arrayList2 = arrayList;
                                                cursorQuery = cursor2;
                                                str3 = str2;
                                            } catch (Exception e18) {
                                                e = e18;
                                                cursor2 = cursor3;
                                            } catch (Throwable th9) {
                                                th = th9;
                                                cursor2 = cursor3;
                                            }
                                        }
                                    }
                                    ArrayList arrayList4 = arrayList2;
                                    try {
                                        cursorQuery.close();
                                    } catch (Exception unused2) {
                                    }
                                    return arrayList4;
                                }
                            } catch (Exception e19) {
                                e = e19;
                            } catch (Throwable th10) {
                                th = th10;
                                cursor2 = cursorQuery;
                            }
                        }
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    } catch (Exception e21) {
                        e = e21;
                        cursorQuery = null;
                    } catch (Throwable th11) {
                        th = th11;
                        cursor = null;
                    }
                }
            } catch (Exception unused3) {
            }
            return null;
        }
    }
}
