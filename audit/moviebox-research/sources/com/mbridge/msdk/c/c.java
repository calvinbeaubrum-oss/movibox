package com.mbridge.msdk.c;

import com.applovin.sdk.AppLovinEventTypes;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class c {
    private String A;
    private int D;
    private int E;
    private int I;
    private String K;
    private int N;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<Integer> f42976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<Integer> f42977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f42978d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f42979e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f42980f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f42981g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f42982h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f42983i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f42985k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f42986l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f42987m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f42988n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f42989o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f42990p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f42991q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f42992r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f42993s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f42994t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f42995u;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private String f43000z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f42975a = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f42984j = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f42996v = 30;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f42997w = 1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f42998x = 10;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f42999y = 60;
    private int B = 1;
    private String C = "";
    private int F = 100;
    private int G = 60;
    private int H = 5000;
    private int J = 1;
    private String L = "";
    private String M = "";

    public static k a(JSONObject jSONObject) {
        k kVar = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            k kVar2 = new k();
            try {
                ((c) kVar2).K = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                String strOptString = jSONObject.optString("ab_id");
                ((c) kVar2).f42975a = strOptString;
                com.mbridge.msdk.foundation.controller.a.f44041b.put(((c) kVar2).K, strOptString);
                ((c) kVar2).L = jSONObject.optString("rid");
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("adSourceList");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                        arrayList.add(Integer.valueOf(jSONArrayOptJSONArray.optInt(i11)));
                    }
                    ((c) kVar2).f42976b = arrayList;
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("ad_source_timeout");
                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i12 = 0; i12 < jSONArrayOptJSONArray2.length(); i12++) {
                        arrayList2.add(Integer.valueOf(jSONArrayOptJSONArray2.optInt(i12)));
                    }
                    ((c) kVar2).f42977c = arrayList2;
                }
                ((c) kVar2).I = jSONObject.optInt("tpqn");
                ((c) kVar2).f42980f = jSONObject.optInt("aqn");
                ((c) kVar2).f42979e = jSONObject.optInt("acn");
                ((c) kVar2).N = jSONObject.optInt("wt");
                int i13 = 1;
                ((c) kVar2).f42997w = jSONObject.optInt("iscasf", 1);
                ((c) kVar2).H = jSONObject.optInt("spmxrt", 5000);
                ((c) kVar2).f42990p = jSONObject.optLong("current_time");
                ((c) kVar2).B = jSONObject.optInt("offset");
                ((c) kVar2).f42991q = jSONObject.optLong("dlct", 3600L);
                ((c) kVar2).f42981g = jSONObject.optInt("autoplay", 0);
                ((c) kVar2).f42992r = jSONObject.optInt("dlnet", 2);
                ((c) kVar2).A = jSONObject.optString("no_offer");
                ((c) kVar2).f42983i = jSONObject.optInt("cb_type");
                ((c) kVar2).f42986l = jSONObject.optLong("clct", 86400L);
                ((c) kVar2).f42985k = jSONObject.optLong("clcq", 300L);
                ((c) kVar2).F = jSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100);
                ((c) kVar2).f42984j = jSONObject.optInt("cd_rate", 0);
                ((c) kVar2).f42988n = jSONObject.optInt(AppLovinEventTypes.USER_VIEWED_CONTENT, 1);
                ((c) kVar2).f42995u = jSONObject.optInt("impt", 0);
                ((c) kVar2).f42994t = jSONObject.optInt("icon_type", 1);
                ((c) kVar2).f43000z = jSONObject.optString("no_ads_url", "");
                ((c) kVar2).E = jSONObject.optInt("playclosebtn_tm", -1);
                ((c) kVar2).D = jSONObject.optInt("play_ctdown", 0);
                ((c) kVar2).f42987m = jSONObject.optInt("close_alert", 0);
                ((c) kVar2).f42996v = jSONObject.optInt("intershowlimit", 30);
                ((c) kVar2).G = jSONObject.optInt("refreshFq", 60);
                ((c) kVar2).f42982h = jSONObject.optInt("closeBtn", 0);
                int iOptInt = jSONObject.optInt("tmorl", 1);
                if (iOptInt <= 2 && iOptInt > 0) {
                    i13 = iOptInt;
                }
                ((c) kVar2).J = i13;
                ((c) kVar2).C = jSONObject.optString("placementid", "");
                ((c) kVar2).f42998x = jSONObject.optInt("ltafemty", 10);
                ((c) kVar2).f42999y = jSONObject.optInt("ltorwc", 60);
                ((c) kVar2).M = jSONObject.optString("vtag", "");
                return kVar2;
            } catch (Exception e11) {
                e = e11;
                kVar = kVar2;
                e.printStackTrace();
                return kVar;
            }
        } catch (Exception e12) {
            e = e12;
        }
    }

    public final String a() {
        return this.f42975a;
    }

    public final void a(int i11) {
        this.f42981g = i11;
    }

    public final void a(long j11) {
        this.f42991q = j11;
    }

    public final void a(String str) {
        this.C = str;
    }

    public final void a(List<Integer> list) {
        this.f42976b = list;
    }

    public final List<Integer> b() {
        return this.f42976b;
    }

    public final void b(int i11) {
        this.f42978d = i11;
    }

    public final void b(String str) {
        this.K = str;
    }

    public final void b(List<Integer> list) {
        this.f42977c = list;
    }

    public final List<Integer> c() {
        return this.f42977c;
    }

    public final void c(int i11) {
        this.f42979e = i11;
    }

    public final int d() {
        return this.f42979e;
    }

    public final void d(int i11) {
        this.f42980f = i11;
    }

    public final int e() {
        return this.f42980f;
    }

    public final void e(int i11) {
        this.f42984j = i11;
    }

    public final int f() {
        return this.f42982h;
    }

    public final void f(int i11) {
        this.f42988n = i11;
    }

    public final int g() {
        return this.f42984j;
    }

    public final void g(int i11) {
        this.f42989o = i11;
    }

    public final int h() {
        return this.f42988n;
    }

    public final void h(int i11) {
        this.f42992r = i11;
    }

    public final long i() {
        return this.f42990p;
    }

    public final void i(int i11) {
        this.f42995u = i11;
    }

    public final long j() {
        return this.f42991q;
    }

    public final void j(int i11) {
        this.f42998x = i11;
    }

    public final int k() {
        return this.f42992r;
    }

    public final void k(int i11) {
        this.f42999y = i11;
    }

    public final int l() {
        return this.f42995u;
    }

    public final void l(int i11) {
        this.F = i11;
    }

    public final int m() {
        return this.f42997w;
    }

    public final void m(int i11) {
        this.G = i11;
    }

    public final int n() {
        return this.f42998x;
    }

    public final void n(int i11) {
        this.I = i11;
    }

    public final int o() {
        return this.f42999y;
    }

    public final void o(int i11) {
        this.N = i11;
    }

    public final int p() {
        return this.F;
    }

    public final void p(int i11) {
        this.B = i11;
    }

    public final int q() {
        return this.G;
    }

    public final int r() {
        return this.H;
    }

    public final String s() {
        return this.L;
    }

    public final String t() {
        return this.M;
    }

    public String toString() {
        List<Integer> list = this.f42976b;
        String str = "";
        if (list != null && list.size() > 0) {
            Iterator<Integer> it = this.f42976b.iterator();
            while (it.hasNext()) {
                str = str + it.next() + ",";
            }
        }
        return "offset = " + this.B + " unitId = " + this.K + " fbPlacementId = " + this.f42993s + str;
    }

    public final int u() {
        return this.N;
    }

    public final int v() {
        return this.f42981g;
    }

    public final int w() {
        return this.B;
    }

    public final JSONObject x() {
        JSONObject jSONObject = new JSONObject();
        try {
            List<Integer> list = this.f42976b;
            if (list != null && list.size() > 0) {
                int size = list.size();
                JSONArray jSONArray = new JSONArray();
                for (int i11 = 0; i11 < size; i11++) {
                    jSONArray.put(list.get(i11));
                }
                jSONObject.put("adSourceList", jSONArray);
            }
            List<Integer> list2 = this.f42977c;
            if (list2 != null && list2.size() > 0) {
                int size2 = list2.size();
                JSONArray jSONArray2 = new JSONArray();
                for (int i12 = 0; i12 < size2; i12++) {
                    jSONArray2.put(list2.get(i12));
                }
                jSONObject.put("ad_source_timeout", jSONArray2);
            }
            jSONObject.put("tpqn", this.I);
            jSONObject.put("aqn", this.f42980f);
            jSONObject.put("acn", this.f42979e);
            jSONObject.put("wt", this.N);
            jSONObject.put("current_time", this.f42990p);
            jSONObject.put("offset", this.B);
            jSONObject.put("dlct", this.f42991q);
            jSONObject.put("autoplay", this.f42981g);
            jSONObject.put("dlnet", this.f42992r);
            jSONObject.put("no_offer", this.A);
            jSONObject.put("cb_type", this.f42983i);
            jSONObject.put("clct", this.f42986l);
            jSONObject.put("clcq", this.f42985k);
            jSONObject.put(CampaignEx.JSON_KEY_READY_RATE, this.F);
            jSONObject.put(AppLovinEventTypes.USER_VIEWED_CONTENT, this.f42988n);
            jSONObject.put("impt", this.f42995u);
            jSONObject.put("icon_type", this.f42994t);
            jSONObject.put("no_ads_url", this.f43000z);
            jSONObject.put("playclosebtn_tm", this.E);
            jSONObject.put("play_ctdown", this.D);
            jSONObject.put("close_alert", this.f42987m);
            jSONObject.put("closeBtn", this.f42982h);
            jSONObject.put("refreshFq", this.G);
            jSONObject.put("countdown", this.f42989o);
            jSONObject.put("allowSkip", this.f42978d);
            jSONObject.put("tmorl", this.J);
            jSONObject.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, this.K);
            jSONObject.put("placementid", this.C);
            jSONObject.put("ltafemty", this.f42998x);
            jSONObject.put("ltorwc", this.f42999y);
            jSONObject.put("vtag", this.M);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }
}
