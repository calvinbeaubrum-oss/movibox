package com.mbridge.msdk.newreward.function.a;

import android.text.TextUtils;
import com.cloud.config.utils.XLogUtil;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.j;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.ao;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.newreward.a.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f46135a = 4;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f46136b = 5;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f46137c = "BaseCandidateCache";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private JSONArray f46138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private JSONObject f46139e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f46140f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f46141g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f46142h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private e f46143i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.c.c f46144j;

    /* JADX INFO: renamed from: com.mbridge.msdk.newreward.function.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0505a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.mbridge.msdk.newreward.function.d.a.b f46145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private double f46146b;

        public C0505a(double d11, com.mbridge.msdk.newreward.function.d.a.b bVar) {
            this.f46146b = d11;
            this.f46145a = bVar;
        }

        public final com.mbridge.msdk.newreward.function.d.a.b a() {
            return this.f46145a;
        }
    }

    private String a(String str, int i11, String str2, String str3) {
        if (TextUtils.isEmpty(str) || str.contains("ca_sce") || str.contains("real_rid") || str.contains("real_bp")) {
            return str;
        }
        if (ao.c(str) > 0) {
            return str + "&ca_sce=" + i11 + "&real_rid=" + str2 + "&real_bp=" + str3;
        }
        return str + "?ca_sce=" + i11 + "&real_rid=" + str2 + "&real_bp=" + str3;
    }

    private String a(Map<Integer, String> map, int i11, String str, String str2) {
        if (map == null || map.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                String value = entry.getValue();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(CampaignEx.JSON_AD_IMP_KEY, entry.getKey());
                jSONObject.put("url", a(value, i11, str, str2));
                jSONArray.put(jSONObject);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return jSONArray.toString();
    }

    private List<Map<Integer, String>> a(List<Map<Integer, String>> list, int i11, String str, String str2) {
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < list.size(); i12++) {
            Map<Integer, String> map = list.get(i12);
            if (map != null && map.size() > 0) {
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    map.put(entry.getKey(), a(entry.getValue(), i11, str, str2));
                }
                arrayList.add(map);
            }
        }
        return arrayList;
    }

    private void a(int i11, int i12, List<CampaignEx> list, boolean z11, String str, String str2, int i13, String str3) {
        String currentLocalRid;
        d dVar = new d();
        try {
            dVar.a("type", i12 + "");
            dVar.a("result", z11 ? "1" : "2");
            dVar.a("max_usage_limit", i13 + "");
            dVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, str3 + "");
            dVar.a("scene", "db");
            JSONObject jSONObject = this.f46139e;
            if (jSONObject != null) {
                dVar.a(XLogUtil.TAG, jSONObject.toString());
            }
            if (i12 == 1 && TextUtils.isEmpty(str2)) {
                try {
                    List<com.mbridge.msdk.newreward.function.d.a.b> listA = com.mbridge.msdk.newreward.function.e.c.a().b().a(this.f46141g, this.f46142h, str3, true, 0);
                    JSONArray jSONArray = new JSONArray();
                    if (listA != null && listA.size() > 0) {
                        for (int i14 = 0; i14 < listA.size(); i14++) {
                            com.mbridge.msdk.newreward.function.d.a.b bVar = listA.get(i14);
                            if (bVar != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("rid", bVar.d());
                                jSONObject2.put("ts", bVar.G());
                                jSONObject2.put("lrid", bVar.e());
                                jSONObject2.put("ecppv", x.b(bVar.q() + ""));
                                jSONObject2.put("state", bVar.h());
                                jSONObject2.put("showCount", bVar.r());
                                jSONObject2.put("interval_ts", bVar.o());
                                jSONArray.put(jSONObject2);
                            }
                        }
                    }
                    dVar.a("cache", jSONArray.toString());
                } catch (JSONException e11) {
                    e11.printStackTrace();
                }
            }
            com.mbridge.msdk.foundation.same.report.d.b bVarB = null;
            if (list == null || list.size() <= 0) {
                currentLocalRid = str2;
            } else {
                try {
                    JSONArray jSONArray2 = new JSONArray();
                    CampaignEx campaignEx = list.get(0);
                    if (campaignEx != null) {
                        currentLocalRid = campaignEx.getCurrentLocalRid();
                        try {
                            bVarB = com.mbridge.msdk.foundation.same.report.d.c.a().b(currentLocalRid);
                        } catch (JSONException e12) {
                            e = e12;
                            e.printStackTrace();
                        }
                    } else {
                        currentLocalRid = str2;
                    }
                    for (int i15 = 0; i15 < list.size(); i15++) {
                        CampaignEx campaignEx2 = list.get(i15);
                        if (campaignEx2 != null) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("rid", campaignEx2.getRequestId());
                            jSONObject3.put("rid_n", campaignEx2.getRequestIdNotice());
                            jSONArray2.put(jSONObject3);
                        }
                    }
                    dVar.a("c_info", jSONArray2.toString());
                } catch (JSONException e13) {
                    e = e13;
                    currentLocalRid = str2;
                }
            }
            dVar.a("rid", str);
            dVar.a("lrid", currentLocalRid);
            if (bVarB == null) {
                new com.mbridge.msdk.foundation.same.report.d.b();
            }
            com.mbridge.msdk.newreward.function.c.c cVar = this.f46144j;
            cVar.a(this.f46143i, com.mbridge.msdk.newreward.function.c.e.METRICS_KEY_M_CANDIDATE_DB, cVar.a("metrics_data", dVar));
        } catch (Exception e14) {
            e14.printStackTrace();
        }
    }

    private String[] a(String[] strArr, int i11, String str, String str2) {
        if (strArr == null || strArr.length == 0) {
            return strArr;
        }
        String[] strArr2 = new String[strArr.length];
        for (int i12 = 0; i12 < strArr.length; i12++) {
            strArr2[i12] = a(strArr[i12], i11, str, str2);
        }
        return strArr2;
    }

    private List<String> b(List<String> list, int i11, String str, String str2) {
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < list.size(); i12++) {
            arrayList.add(a(list.get(i12), i11, str, str2));
        }
        return arrayList;
    }

    public final b a() {
        b bVar = new b();
        try {
            JSONArray jSONArray = this.f46138d;
            if (jSONArray == null || jSONArray.length() == 0) {
                bVar.d("setting config is null");
                bVar.a(com.mbridge.msdk.foundation.b.c.f44009a);
                return bVar;
            }
        } catch (Exception unused) {
            bVar.d("checkConfigAndDB exception");
            bVar.a(com.mbridge.msdk.foundation.b.c.f44011c);
        }
        return bVar;
    }

    public final List<com.mbridge.msdk.newreward.function.d.a.b> a(int i11, int i12, String str) {
        return com.mbridge.msdk.newreward.function.e.c.a().b().a(i12, str, this.f46140f, true, 0);
    }

    public final JSONObject a(String str) {
        JSONArray jSONArray = this.f46138d;
        if (jSONArray == null) {
            return null;
        }
        if (jSONArray.length() <= 1) {
            return this.f46138d.optJSONObject(0);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i11 = 0; i11 < this.f46138d.length(); i11++) {
            try {
                JSONObject jSONObjectOptJSONObject = this.f46138d.optJSONObject(i11);
                if (jSONObjectOptJSONObject != null && str.equals(jSONObjectOptJSONObject.getString("g"))) {
                    this.f46139e = jSONObjectOptJSONObject;
                    return jSONObjectOptJSONObject;
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return null;
    }

    public final void a(int i11) {
        this.f46141g = i11;
    }

    public final void a(e eVar) {
        this.f46143i = eVar;
    }

    public final void a(com.mbridge.msdk.newreward.function.c.c cVar) {
        this.f46144j = cVar;
    }

    public final void a(String str, String str2, int i11, double d11) {
        if (d11 == 0.0d) {
            return;
        }
        try {
            if (i11 == 1) {
                a(f46135a, 3, null, true, str2, str, -1, this.f46140f);
            } else if (i11 == 2) {
                a(f46135a, 1, null, true, str2, str, -1, this.f46140f);
            } else if (i11 != 3) {
            } else {
                a(f46135a, 4, null, true, str2, str, -1, this.f46140f);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void a(List<com.mbridge.msdk.newreward.function.d.a.a> list, com.mbridge.msdk.foundation.same.report.d.b bVar, String str, int i11, String str2, int i12, double d11) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (int i13 = 0; i13 < list.size(); i13++) {
                        CampaignEx campaignExG = list.get(i13).g();
                        campaignExG.setReadyState(0);
                        if (bVar != null) {
                            campaignExG.setNLRid(bVar.f());
                        }
                        campaignExG.setNRid(str);
                        campaignExG.setReasond(str2);
                        campaignExG.setTyped(i11);
                        String strB = x.b(d11 + "");
                        campaignExG.setNoticeUrl(a(campaignExG.getNoticeUrl(), i12, str, strB));
                        campaignExG.setClickURL(a(campaignExG.getClickURL(), i12, str, strB));
                        campaignExG.setImpressionURL(a(campaignExG.getImpressionURL(), i12, str, strB));
                        campaignExG.setOnlyImpressionURL(a(campaignExG.getOnlyImpressionURL(), i12, str, strB));
                        campaignExG.setAdvImp(a(campaignExG.getAdvImpList(), i12, str, strB));
                        j nativeVideoTracking = campaignExG.getNativeVideoTracking();
                        if (nativeVideoTracking != null) {
                            nativeVideoTracking.k(a(nativeVideoTracking.l(), i12, str, strB));
                            nativeVideoTracking.c(a(nativeVideoTracking.c(), i12, str, strB));
                            nativeVideoTracking.o(a(nativeVideoTracking.p(), i12, str, strB));
                            nativeVideoTracking.s(a(nativeVideoTracking.t(), i12, str, strB));
                            nativeVideoTracking.a(a(nativeVideoTracking.a(), i12, str, strB));
                            nativeVideoTracking.b(a(nativeVideoTracking.b(), i12, str, strB));
                            nativeVideoTracking.r(a(nativeVideoTracking.s(), i12, str, strB));
                            nativeVideoTracking.u(a(nativeVideoTracking.v(), i12, str, strB));
                            nativeVideoTracking.t(a(nativeVideoTracking.v(), i12, str, strB));
                            nativeVideoTracking.v(a(nativeVideoTracking.w(), i12, str, strB));
                            nativeVideoTracking.h(a(nativeVideoTracking.h(), i12, str, strB));
                            nativeVideoTracking.p(a(nativeVideoTracking.q(), i12, str, strB));
                            nativeVideoTracking.q(a(nativeVideoTracking.r(), i12, str, strB));
                            nativeVideoTracking.n(a(nativeVideoTracking.o(), i12, str, strB));
                            nativeVideoTracking.e(a(nativeVideoTracking.e(), i12, str, strB));
                            nativeVideoTracking.f(a(nativeVideoTracking.f(), i12, str, strB));
                            nativeVideoTracking.g(a(nativeVideoTracking.g(), i12, str, strB));
                            nativeVideoTracking.i(a(nativeVideoTracking.j(), i12, str, strB));
                            nativeVideoTracking.j(a(nativeVideoTracking.k(), i12, str, strB));
                            nativeVideoTracking.l(a(nativeVideoTracking.m(), i12, str, strB));
                            nativeVideoTracking.a(a(nativeVideoTracking.i(), i12, str, strB));
                            nativeVideoTracking.d(a(nativeVideoTracking.d(), i12, str, strB));
                            nativeVideoTracking.m(a(nativeVideoTracking.n(), i12, str, strB));
                            campaignExG.setNativeVideoTracking(nativeVideoTracking);
                            campaignExG.setNativeVideoTrackingString(CampaignEx.object2TrackingStr(nativeVideoTracking));
                        }
                        campaignExG.setPv_urls(b(campaignExG.getPv_urls(), i12, str, strB));
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public final void a(JSONArray jSONArray) {
        this.f46138d = jSONArray;
    }

    public final String b(String str) {
        b bVarC = c(str);
        if (bVarC != null && bVarC.h() != com.mbridge.msdk.foundation.b.c.f44011c && bVarC.h() != com.mbridge.msdk.foundation.b.c.f44009a) {
            String[] strArrSplit = x.a(str.split("_")[3]).split("\\|");
            if (strArrSplit.length > 1) {
                return strArrSplit[1];
            }
        }
        return "";
    }

    public final b c(String str) {
        b bVar = new b();
        if (TextUtils.isEmpty(str) || str.split("_").length <= 3 || TextUtils.isEmpty(str.split("_")[3])) {
            bVar.d("bid token exception");
            bVar.a(com.mbridge.msdk.foundation.b.c.f44009a);
            return bVar;
        }
        JSONArray jSONArray = this.f46138d;
        if (jSONArray == null || jSONArray.length() == 0) {
            bVar.d("config is empty");
            bVar.a(com.mbridge.msdk.foundation.b.c.f44009a);
            return bVar;
        }
        String strA = x.a(str.split("_")[3]);
        if (TextUtils.isEmpty(strA)) {
            bVar.d("bid token exception:decode error");
            bVar.a(com.mbridge.msdk.foundation.b.c.f44009a);
            return bVar;
        }
        String[] strArrSplit = strA.split("\\|");
        if (strArrSplit.length == 0) {
            bVar.d("bid token can not get bid price");
            bVar.a(com.mbridge.msdk.foundation.b.c.f44009a);
            return bVar;
        }
        if (strArrSplit.length > 0) {
            try {
                Double.parseDouble(strArrSplit[0]);
            } catch (Exception unused) {
                bVar.d("bid token can not cast bid price");
                bVar.a(com.mbridge.msdk.foundation.b.c.f44009a);
                return bVar;
            }
        }
        if (TextUtils.isEmpty(this.f46140f)) {
            bVar.d("unitId is empty");
            bVar.a(com.mbridge.msdk.foundation.b.c.f44011c);
        }
        return bVar;
    }

    public final double d(String str) {
        b bVarC = c(str);
        if (bVarC != null && bVarC.h() != com.mbridge.msdk.foundation.b.c.f44011c && bVarC.h() != com.mbridge.msdk.foundation.b.c.f44009a) {
            try {
                String[] strArrSplit = x.a(str.split("_")[3]).split("\\|");
                if (strArrSplit.length > 0) {
                    return Double.parseDouble(strArrSplit[0]);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return -1.0d;
    }

    public final void e(String str) {
        this.f46140f = str;
    }

    public final void f(String str) {
        this.f46142h = str;
    }
}
