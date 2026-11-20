package com.mbridge.msdk.foundation.b;

import android.text.TextUtils;
import com.cloud.config.utils.XLogUtil;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.j;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ao;
import com.mbridge.msdk.foundation.tools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f43990b = 4;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f43991c = "BaseCandidateCache";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.mbridge.msdk.foundation.db.c f43992a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private JSONArray f43993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private JSONObject f43994e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f43995f;

    /* JADX INFO: renamed from: com.mbridge.msdk.foundation.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0483a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private b f43997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private double f43998b;

        public C0483a(double d11, b bVar) {
            this.f43998b = d11;
            this.f43997a = bVar;
        }

        public final b a() {
            return this.f43997a;
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

    public final long a(List<CampaignEx> list, String str) {
        if (list == null || list.size() == 0) {
            return 0L;
        }
        String ecppv = list.get(0).getEcppv();
        if (TextUtils.isEmpty(ecppv)) {
            return 0L;
        }
        String strA = x.a(ecppv);
        if (TextUtils.isEmpty(strA)) {
            return 0L;
        }
        try {
            if (Double.parseDouble(strA) <= 0.0d) {
                return 0L;
            }
            JSONObject jSONObjectA = a(b(str));
            int iOptInt = jSONObjectA != null ? jSONObjectA.optInt("max_cache_num", 20) : 20;
            com.mbridge.msdk.foundation.db.c cVar = this.f43992a;
            if (cVar == null || iOptInt <= 0) {
                return -1L;
            }
            return cVar.a(list, this.f43995f);
        } catch (Exception e11) {
            e11.printStackTrace();
            return -1L;
        }
    }

    public final c a() {
        c cVar = new c();
        try {
            JSONArray jSONArray = this.f43993d;
            if (jSONArray != null && jSONArray.length() != 0) {
                if (this.f43992a == null) {
                    cVar.d("db error");
                    cVar.a(c.f44011c);
                    return cVar;
                }
                return cVar;
            }
            cVar.d("setting config is null");
            cVar.a(c.f44009a);
            return cVar;
        } catch (Exception unused) {
            cVar.d("checkConfigAndDB exception");
            cVar.a(c.f44011c);
        }
    }

    public final List<b> a(int i11, long j11) {
        com.mbridge.msdk.foundation.db.c cVar;
        if (i11 >= 0 && (cVar = this.f43992a) != null) {
            cVar.a(this.f43995f, i11);
            a(f43990b, 1, null, true, "", "", i11, this.f43995f);
        }
        com.mbridge.msdk.foundation.db.c cVar2 = this.f43992a;
        if (cVar2 != null) {
            return cVar2.a(this.f43995f, 0, j11);
        }
        return null;
    }

    public final JSONObject a(String str) {
        JSONArray jSONArray = this.f43993d;
        if (jSONArray == null) {
            return null;
        }
        if (jSONArray.length() <= 1) {
            return this.f43993d.optJSONObject(0);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i11 = 0; i11 < this.f43993d.length(); i11++) {
            try {
                JSONObject jSONObjectOptJSONObject = this.f43993d.optJSONObject(i11);
                if (jSONObjectOptJSONObject != null && str.equals(jSONObjectOptJSONObject.getString("g"))) {
                    this.f43994e = jSONObjectOptJSONObject;
                    return jSONObjectOptJSONObject;
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return null;
    }

    public final void a(int i11, int i12, List<CampaignEx> list, boolean z11, String str, String str2, int i13, String str3) {
        String currentLocalRid;
        com.mbridge.msdk.foundation.db.c cVar;
        JSONArray jSONArray;
        com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
        try {
            dVar.a("type", i12 + "");
            dVar.a("result", z11 ? "1" : "2");
            dVar.a("max_usage_limit", i13 + "");
            dVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, str3 + "");
            dVar.a("scene", "db");
            JSONObject jSONObject = this.f43994e;
            if (jSONObject != null) {
                dVar.a(XLogUtil.TAG, jSONObject.toString());
            }
            if (i12 == 1 && TextUtils.isEmpty(str2) && (cVar = this.f43992a) != null) {
                try {
                    List<b> listA = cVar.a(str3, -1, -1L);
                    JSONArray jSONArray2 = new JSONArray();
                    if (listA != null && listA.size() > 0) {
                        int i14 = 0;
                        while (i14 < listA.size()) {
                            b bVar = listA.get(i14);
                            if (bVar != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("rid", bVar.e());
                                jSONObject2.put("ts", bVar.h());
                                jSONObject2.put("lrid", bVar.d());
                                jSONObject2.put("ecppv", x.b(bVar.c() + ""));
                                jSONObject2.put("state", bVar.g());
                                jSONObject2.put("showCount", bVar.f());
                                jSONObject2.put("interval_ts", bVar.a());
                                jSONArray = jSONArray2;
                                jSONArray.put(jSONObject2);
                            } else {
                                jSONArray = jSONArray2;
                            }
                            i14++;
                            jSONArray2 = jSONArray;
                        }
                    }
                    dVar.a("cache", jSONArray2.toString());
                } catch (JSONException e11) {
                    e11.printStackTrace();
                }
            }
            com.mbridge.msdk.foundation.same.report.d.b bVar2 = null;
            if (list == null || list.size() <= 0) {
                currentLocalRid = str2;
            } else {
                try {
                    JSONArray jSONArray3 = new JSONArray();
                    CampaignEx campaignEx = list.get(0);
                    if (campaignEx != null) {
                        currentLocalRid = campaignEx.getCurrentLocalRid();
                        try {
                            bVar2 = com.mbridge.msdk.foundation.same.report.d.c.a().b(currentLocalRid);
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
                            jSONArray3.put(jSONObject3);
                        }
                    }
                    dVar.a("c_info", jSONArray3.toString());
                } catch (JSONException e13) {
                    e = e13;
                    currentLocalRid = str2;
                }
            }
            dVar.a("rid", str);
            dVar.a("lrid", currentLocalRid);
            if (bVar2 == null) {
                bVar2 = new com.mbridge.msdk.foundation.same.report.d.b();
            }
            bVar2.d(str3);
            bVar2.a("m_candidate_db", dVar);
            com.mbridge.msdk.foundation.same.report.d.c.a().a("m_candidate_db", bVar2);
        } catch (Exception e14) {
            e14.printStackTrace();
        }
    }

    public final void a(String str, String str2, int i11, String str3) {
        try {
            if (this.f43992a == null || TextUtils.isEmpty(str3)) {
                return;
            }
            if (i11 == 1) {
                this.f43992a.a(str2, str, this.f43995f, i11);
                a(f43990b, 3, null, true, str2, str, -1, this.f43995f);
            } else if (i11 == 2) {
                this.f43992a.a(this.f43995f, str2, str);
                a(f43990b, 1, null, true, str2, str, -1, this.f43995f);
            } else if (i11 == 3) {
                this.f43992a.b(str2, str, this.f43995f);
                a(f43990b, 4, null, true, str2, str, -1, this.f43995f);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void a(List<C0483a> list, int i11) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    Collections.sort(list, new Comparator<C0483a>() { // from class: com.mbridge.msdk.foundation.b.a.1
                        @Override // java.util.Comparator
                        public final /* synthetic */ int compare(C0483a c0483a, C0483a c0483a2) {
                            return Double.compare(c0483a.f43998b, c0483a2.f43998b);
                        }
                    });
                    int size = list.size() - i11;
                    if (size > 0) {
                        List<C0483a> listSubList = list.subList(0, size);
                        if (this.f43992a == null || listSubList.size() <= 0) {
                            return;
                        }
                        for (int i12 = 0; i12 < listSubList.size(); i12++) {
                            b bVar = listSubList.get(i12).f43997a;
                            this.f43992a.a(this.f43995f, bVar.e(), bVar.d());
                            a(f43990b, 1, null, true, bVar.e(), bVar.d(), -1, this.f43995f);
                        }
                    }
                }
            } catch (Exception e11) {
                ad.a(f43991c, e11);
            }
        }
    }

    public final void a(List<CampaignEx> list, com.mbridge.msdk.foundation.same.report.d.b bVar, String str, int i11, String str2, int i12, double d11) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (int i13 = 0; i13 < list.size(); i13++) {
                        CampaignEx campaignEx = list.get(i13);
                        campaignEx.setReadyState(0);
                        if (bVar != null) {
                            campaignEx.setNLRid(bVar.f());
                        }
                        campaignEx.setNRid(str);
                        campaignEx.setReasond(str2);
                        campaignEx.setTyped(i11);
                        String strB = x.b(d11 + "");
                        campaignEx.setNoticeUrl(a(campaignEx.getNoticeUrl(), i12, str, strB));
                        campaignEx.setClickURL(a(campaignEx.getClickURL(), i12, str, strB));
                        campaignEx.setImpressionURL(a(campaignEx.getImpressionURL(), i12, str, strB));
                        campaignEx.setOnlyImpressionURL(a(campaignEx.getOnlyImpressionURL(), i12, str, strB));
                        campaignEx.setAdvImp(a(campaignEx.getAdvImpList(), i12, str, strB));
                        j nativeVideoTracking = campaignEx.getNativeVideoTracking();
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
                            campaignEx.setNativeVideoTracking(nativeVideoTracking);
                            campaignEx.setNativeVideoTrackingString(CampaignEx.object2TrackingStr(nativeVideoTracking));
                        }
                        campaignEx.setPv_urls(b(campaignEx.getPv_urls(), i12, str, strB));
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public final void a(JSONArray jSONArray) {
        this.f43993d = jSONArray;
    }

    public final String b(String str) {
        c cVarC = c(str);
        if (cVarC != null && cVarC.g() != c.f44011c && cVarC.g() != c.f44009a) {
            String[] strArrSplit = x.a(str.split("_")[3]).split("\\|");
            if (strArrSplit.length > 1) {
                return strArrSplit[1];
            }
        }
        return "";
    }

    public final c c(String str) {
        c cVar = new c();
        if (TextUtils.isEmpty(str) || str.split("_").length <= 3 || TextUtils.isEmpty(str.split("_")[3])) {
            cVar.d("bid token exception");
            cVar.a(c.f44009a);
            return cVar;
        }
        JSONArray jSONArray = this.f43993d;
        if (jSONArray == null || jSONArray.length() == 0) {
            cVar.d("config is empty");
            cVar.a(c.f44009a);
            return cVar;
        }
        String strA = x.a(str.split("_")[3]);
        if (TextUtils.isEmpty(strA)) {
            cVar.d("bid token exception:decode error");
            cVar.a(c.f44009a);
            return cVar;
        }
        String[] strArrSplit = strA.split("\\|");
        if (strArrSplit.length == 0) {
            cVar.d("bid token can not get bid price");
            cVar.a(c.f44009a);
            return cVar;
        }
        if (strArrSplit.length > 0) {
            try {
                Double.parseDouble(strArrSplit[0]);
            } catch (Exception unused) {
                cVar.d("bid token can not cast bid price");
                cVar.a(c.f44009a);
                return cVar;
            }
        }
        if (TextUtils.isEmpty(this.f43995f)) {
            cVar.d("unitId is empty");
            cVar.a(c.f44011c);
        }
        return cVar;
    }

    public final double d(String str) {
        c cVarC = c(str);
        if (cVarC != null && cVarC.g() != c.f44011c && cVarC.g() != c.f44009a) {
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
        this.f43995f = str;
    }
}
