package com.mbridge.msdk.mbsignalcommon.communication;

import android.text.TextUtils;
import android.util.Base64;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f45732a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f45733b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f45734c = 1;

    public static String a(float f11, float f12) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f44372h, ai.b(com.mbridge.msdk.foundation.controller.c.m().c(), f11));
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f44373i, ai.b(com.mbridge.msdk.foundation.controller.c.m().c(), f12));
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f44377m, 0);
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f44375k, com.mbridge.msdk.foundation.controller.c.m().c().getResources().getConfiguration().orientation);
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f44376l, ai.d(com.mbridge.msdk.foundation.controller.c.m().c()));
            jSONObject.put(com.mbridge.msdk.foundation.same.a.f44374j, jSONObject2);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String a(int i11) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TrackingKey.CODE, i11);
            String string = jSONObject.toString();
            return !TextUtils.isEmpty(string) ? Base64.encodeToString(string.getBytes(), 2) : "";
        } catch (Throwable unused) {
            ad.b(f45732a, "code to string is error");
            return "";
        }
    }

    public static void a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TrackingKey.CODE, f45734c);
            jSONObject.put("message", str);
            jSONObject.put("data", new JSONObject());
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e11) {
            ad.a(f45732a, e11.getMessage());
        }
    }

    public static void a(Object obj, JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                a(obj, "data is empty");
                return;
            }
            final CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(jSONObjectOptJSONObject);
            if (campaignWithBackData == null) {
                a(obj, "data camapign is empty");
                return;
            }
            new Thread(new Runnable() { // from class: com.mbridge.msdk.mbsignalcommon.communication.d.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        k kVarA = k.a(h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
                        if (kVarA != null) {
                            if (kVarA.b(campaignWithBackData.getId())) {
                                kVarA.a(campaignWithBackData.getId());
                            } else {
                                com.mbridge.msdk.foundation.entity.g gVar = new com.mbridge.msdk.foundation.entity.g();
                                gVar.a(campaignWithBackData.getId());
                                gVar.b(campaignWithBackData.getFca());
                                gVar.c(campaignWithBackData.getFcb());
                                gVar.a(0);
                                gVar.d(1);
                                gVar.a(System.currentTimeMillis());
                                kVarA.a(gVar);
                            }
                        }
                        d.a(campaignWithBackData.getCampaignUnitId(), campaignWithBackData);
                    } catch (Throwable th2) {
                        ad.a(d.f45732a, th2.getMessage(), th2);
                    }
                }
            }).start();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(TrackingKey.CODE, f45733b);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("id", "");
                jSONObject2.put("data", jSONObject3);
                g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (Exception e11) {
                a(obj, e11.getMessage());
                ad.a(f45732a, e11.getMessage());
            }
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
        }
    }

    public static /* synthetic */ void a(String str, CampaignEx campaignEx) {
        if (com.mbridge.msdk.foundation.same.a.d.f44398b == null || TextUtils.isEmpty(campaignEx.getId())) {
            return;
        }
        com.mbridge.msdk.foundation.same.a.d.a(str, campaignEx, "banner");
    }
}
