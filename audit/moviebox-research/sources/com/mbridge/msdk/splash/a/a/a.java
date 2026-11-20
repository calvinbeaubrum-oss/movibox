package com.mbridge.msdk.splash.a.a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f46955a = "a";

    public static CampaignEx a(String str, CampaignEx campaignEx) throws JSONException {
        String strValueOf;
        String strValueOf2;
        if (TextUtils.isEmpty(str)) {
            return campaignEx;
        }
        if (TextUtils.isEmpty(str) && campaignEx == null) {
            return null;
        }
        if (str.contains("notice")) {
            try {
                JSONObject jSONObjectCampaignToJsonObject = CampaignEx.campaignToJsonObject(campaignEx);
                JSONObject jSONObject = new JSONObject(str);
                try {
                    if (!jSONObject.has(CampaignEx.JSON_KEY_DEEP_LINK_URL)) {
                        jSONObjectCampaignToJsonObject.put(CampaignEx.JSON_KEY_DEEP_LINK_URL, "");
                    }
                } catch (Exception e11) {
                    ad.b(f46955a, e11.getMessage());
                }
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObjectCampaignToJsonObject.put(next, jSONObject.getString(next));
                }
                CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(jSONObjectCampaignToJsonObject);
                String strOptString = jSONObjectCampaignToJsonObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                if (!TextUtils.isEmpty(strOptString)) {
                    campaignWithBackData.setCampaignUnitId(strOptString);
                }
                return campaignWithBackData;
            } catch (JSONException e12) {
                ad.b(f46955a, e12.getMessage());
                return campaignEx;
            }
        }
        try {
            JSONObject jSONObjectCampaignToJsonObject2 = CampaignEx.campaignToJsonObject(campaignEx);
            CampaignEx campaignWithBackData2 = CampaignEx.parseCampaignWithBackData(jSONObjectCampaignToJsonObject2);
            if (campaignWithBackData2 == null) {
                campaignWithBackData2 = campaignEx;
            }
            if (!TextUtils.isEmpty(str)) {
                String strOptString2 = jSONObjectCampaignToJsonObject2.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                if (!TextUtils.isEmpty(strOptString2)) {
                    campaignWithBackData2.setCampaignUnitId(strOptString2);
                }
                JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject(com.mbridge.msdk.foundation.same.a.f44374j);
                if (jSONObjectOptJSONObject != null) {
                    String string = jSONObjectOptJSONObject.getString(com.mbridge.msdk.foundation.same.a.f44372h);
                    String string2 = jSONObjectOptJSONObject.getString(com.mbridge.msdk.foundation.same.a.f44373i);
                    if (TextUtils.isEmpty(string)) {
                        string = "-999";
                    }
                    int i11 = Integer.parseInt(string);
                    if (TextUtils.isEmpty(string2)) {
                        string2 = "-999";
                    }
                    int i12 = Integer.parseInt(string2);
                    strValueOf = i11 != -999 ? String.valueOf(ai.a(c.m().c(), i11)) : "-999";
                    strValueOf2 = i12 != -999 ? String.valueOf(ai.a(c.m().c(), i12)) : "-999";
                } else {
                    strValueOf = "-999";
                    strValueOf2 = strValueOf;
                }
                campaignWithBackData2.setClickURL(com.mbridge.msdk.click.c.a(campaignWithBackData2.getClickURL(), strValueOf, strValueOf2));
                String noticeUrl = campaignWithBackData2.getNoticeUrl();
                if (jSONObjectOptJSONObject != null) {
                    Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
                    StringBuilder sb2 = new StringBuilder();
                    while (itKeys2.hasNext()) {
                        sb2.append("&");
                        String next2 = itKeys2.next();
                        String strOptString3 = jSONObjectOptJSONObject.optString(next2);
                        if (com.mbridge.msdk.foundation.same.a.f44372h.equals(next2) || com.mbridge.msdk.foundation.same.a.f44373i.equals(next2)) {
                            if (TextUtils.isEmpty(strOptString3)) {
                                strOptString3 = "-999";
                            }
                            int i13 = Integer.parseInt(strOptString3);
                            strOptString3 = i13 != -999 ? String.valueOf(ai.a(c.m().c(), i13)) : "-999";
                        }
                        sb2.append(next2);
                        sb2.append("=");
                        sb2.append(strOptString3);
                    }
                    campaignWithBackData2.setNoticeUrl(noticeUrl + ((Object) sb2));
                }
            }
            return campaignWithBackData2;
        } catch (Throwable unused) {
            return campaignEx;
        }
    }

    public static String a(int i11, float f11, float f12) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (i11 == 4) {
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f44372h, -999);
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f44373i, -999);
            } else {
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f44372h, ai.b(c.m().c(), f11));
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f44373i, ai.b(c.m().c(), f12));
            }
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f44377m, i11);
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f44375k, c.m().c().getResources().getConfiguration().orientation);
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f44376l, ai.d(c.m().c()));
            jSONObject.put(com.mbridge.msdk.foundation.same.a.f44374j, jSONObject2);
        } catch (Exception e11) {
            ad.b(f46955a, e11.getMessage());
        }
        return jSONObject.toString();
    }
}
