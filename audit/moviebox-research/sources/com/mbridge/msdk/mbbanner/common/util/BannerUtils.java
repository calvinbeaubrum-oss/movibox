package com.mbridge.msdk.mbbanner.common.util;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.g;
import com.mbridge.msdk.foundation.same.a.d;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class BannerUtils {
    private static final String TAG = "BannerUtils";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f45397a = 0;

    private static synchronized List<com.mbridge.msdk.foundation.same.d.a> fillIdInList(List<com.mbridge.msdk.foundation.same.d.a> list, List<CampaignEx> list2) {
        if (list2 != null) {
            try {
                if (list2.size() > 0) {
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    for (CampaignEx campaignEx : list2) {
                        if (campaignEx != null) {
                            com.mbridge.msdk.foundation.same.d.a aVar = new com.mbridge.msdk.foundation.same.d.a(campaignEx.getId(), campaignEx.getCreativeId());
                            if (list.size() >= 20) {
                                list.remove(0);
                            }
                            list.add(aVar);
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return list;
    }

    public static String getCloseIds(String str) {
        List<com.mbridge.msdk.foundation.same.d.a> list;
        try {
            Map<String, List<com.mbridge.msdk.foundation.same.d.a>> map = d.f44397a;
            if (map == null || !an.b(str) || !map.containsKey(str) || (list = map.get(str)) == null || list.size() <= 0) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (int i11 = 0; i11 < list.size(); i11++) {
                JSONObject jSONObject = new JSONObject();
                com.mbridge.msdk.foundation.same.d.a aVar = list.get(i11);
                jSONObject.put(BidResponsedEx.KEY_CID, aVar.a());
                jSONObject.put("crid", aVar.b());
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        } catch (Exception e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static void inserCloseId(String str, List<CampaignEx> list) {
        Map<String, List<com.mbridge.msdk.foundation.same.d.a>> map = d.f44397a;
        if (map == null || list == null || list.size() <= 0) {
            return;
        }
        if (an.b(str)) {
            if (map.containsKey(str)) {
                map.put(str, fillIdInList(map.get(str), list));
            } else {
                map.put(str, fillIdInList(new ArrayList(), list));
            }
        }
        d.f44397a = map;
    }

    public static CampaignEx managerCampaignEX(String str, CampaignEx campaignEx) {
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
                Iterator<String> itKeys = jSONObject.keys();
                try {
                    if (!jSONObject.has(CampaignEx.JSON_KEY_DEEP_LINK_URL)) {
                        jSONObjectCampaignToJsonObject.put(CampaignEx.JSON_KEY_DEEP_LINK_URL, "");
                    }
                } catch (Exception unused) {
                }
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
            } catch (JSONException e11) {
                e11.printStackTrace();
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
                    strValueOf = String.valueOf(ai.a(c.m().c(), Integer.valueOf(jSONObjectOptJSONObject.getString(com.mbridge.msdk.foundation.same.a.f44372h)).intValue()));
                    strValueOf2 = String.valueOf(ai.a(c.m().c(), Integer.valueOf(jSONObjectOptJSONObject.getString(com.mbridge.msdk.foundation.same.a.f44373i)).intValue()));
                } else {
                    strValueOf = "-999";
                    strValueOf2 = "-999";
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
                            strOptString3 = String.valueOf(ai.a(c.m().c(), Integer.valueOf(strOptString3).intValue()));
                        }
                        sb2.append(next2);
                        sb2.append("=");
                        sb2.append(strOptString3);
                    }
                    campaignWithBackData2.setNoticeUrl(noticeUrl + ((Object) sb2));
                }
            }
            return campaignWithBackData2;
        } catch (Throwable unused2) {
            return campaignEx;
        }
    }

    public static void uisList(Context context, List<CampaignEx> list) {
        if (context == null || list == null || list.size() == 0) {
            return;
        }
        k kVarA = k.a(h.a(context));
        for (int i11 = 0; i11 < list.size(); i11++) {
            CampaignEx campaignEx = list.get(i11);
            if (kVarA != null && !kVarA.b(campaignEx.getId())) {
                g gVar = new g();
                gVar.a(campaignEx.getId());
                gVar.b(campaignEx.getFca());
                gVar.c(campaignEx.getFcb());
                gVar.a(0);
                gVar.d(0);
                gVar.a(System.currentTimeMillis());
                kVarA.a(gVar);
            }
        }
    }
}
