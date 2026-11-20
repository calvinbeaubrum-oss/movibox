package com.mbridge.msdk.videocommon.d;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    private static h H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f48481a;
    private int F;
    private int I;
    private JSONArray W;
    private JSONObject X;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f48482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f48483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<com.mbridge.msdk.videocommon.b.b> f48484d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f48485e;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ArrayList<Integer> f48501u;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f48486f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f48487g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f48488h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f48489i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f48490j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f48491k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f48492l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f48493m = 5;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f48494n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f48495o = 3;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f48496p = 80;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f48497q = 100;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f48498r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private double f48499s = 1.0d;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f48500t = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f48502v = 3;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f48503w = 1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f48504x = 100;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f48505y = 60;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f48506z = 0;
    private int A = 70;
    private int B = 0;
    private int C = -1;
    private int D = -1;
    private int E = -1;
    private int G = 20;
    private int J = 0;
    private int K = 1;
    private String L = "";
    private int M = 1;
    private String N = "";
    private int O = 1;
    private String P = "Virtual Item";
    private String Q = "";
    private String R = "";
    private int S = 0;
    private int T = 1;
    private int U = 60;
    private String V = "";

    public static c a(JSONObject jSONObject) {
        c cVar = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            c cVar2 = new c();
            try {
                cVar2.f48484d = com.mbridge.msdk.videocommon.b.b.a(jSONObject.optJSONArray("adSourceList"));
                cVar2.f48489i = jSONObject.optInt("callbackType");
                int iOptInt = jSONObject.optInt("aqn", 1);
                if (iOptInt <= 0) {
                    iOptInt = 1;
                }
                cVar2.f48490j = iOptInt;
                int iOptInt2 = jSONObject.optInt("acn", 1);
                if (iOptInt2 < 0) {
                    iOptInt2 = 1;
                }
                cVar2.f48491k = iOptInt2;
                cVar2.f48492l = jSONObject.optInt("vcn", 5);
                cVar2.f48493m = jSONObject.optInt("offset", 5);
                cVar2.f48494n = jSONObject.optInt("dlnet", 1);
                cVar2.I = jSONObject.optInt("endscreen_type", 2);
                cVar2.f48495o = jSONObject.optInt("tv_start", 3);
                cVar2.f48496p = jSONObject.optInt("tv_end", 80);
                cVar2.f48497q = jSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100);
                cVar2.f48485e = jSONObject.optLong("current_time");
                cVar2.f48506z = jSONObject.optInt("orientation", 0);
                cVar2.B = jSONObject.optInt("daily_play_cap", 0);
                cVar2.C = jSONObject.optInt("video_skip_time", -1);
                cVar2.D = jSONObject.optInt("video_skip_result", 2);
                cVar2.E = jSONObject.optInt("video_interactive_type", -1);
                cVar2.F = jSONObject.optInt("close_button_delay", 1);
                cVar2.f48486f = jSONObject.optInt("playclosebtn_tm", -1);
                cVar2.f48487g = jSONObject.optInt("play_ctdown", 0);
                cVar2.f48488h = jSONObject.optInt("close_alert", 0);
                cVar2.G = jSONObject.optInt("rdrct", 20);
                cVar2.f48500t = jSONObject.optInt("rfpv", -1);
                cVar2.f48499s = jSONObject.optDouble("vdcmp", 1.0d);
                cVar2.A = jSONObject.optInt("load_global_timeout", 70);
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("atl_type");
                ArrayList<Integer> arrayList = new ArrayList<>();
                try {
                    if (jSONArrayOptJSONArray != null) {
                        for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                            arrayList.add(Integer.valueOf(jSONArrayOptJSONArray.getInt(i11)));
                        }
                    } else {
                        arrayList.add(4);
                        arrayList.add(6);
                    }
                    cVar2.f48501u = arrayList;
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                cVar2.f48502v = jSONObject.optInt("atl_dyt", 3);
                int iOptInt3 = jSONObject.optInt("tmorl", 1);
                if (iOptInt3 > 2 || iOptInt3 <= 0) {
                    iOptInt3 = 1;
                }
                cVar2.f48503w = iOptInt3;
                cVar2.f48483c = jSONObject.optString("placementid");
                cVar2.f48504x = jSONObject.optInt("ltafemty", 10);
                cVar2.f48505y = jSONObject.optInt("ltorwc", 60);
                cVar2.d(jSONObject.optString("ab_id"));
                cVar2.R = jSONObject.optString("rid", "");
                cVar2.J = jSONObject.optInt(RewardPlus.AMOUNT_MAX, 0);
                cVar2.K = jSONObject.optInt(RewardPlus.CALLBACK_RULE, 1);
                cVar2.L = jSONObject.optString(RewardPlus.VIRTUAL_CURRENCY, "");
                cVar2.y(jSONObject.optInt("amount", 1));
                cVar2.N = jSONObject.optString(RewardPlus.ICON, "");
                cVar2.O = jSONObject.optInt(RewardPlus.CURRENCY_ID, 1);
                cVar2.e(jSONObject.optString("name", "Virtual Item"));
                cVar2.T = jSONObject.optInt("video_error_rule", 1);
                cVar2.U = jSONObject.optInt("loadtmo", 60);
                cVar2.V = jSONObject.optString("vtag", "");
                cVar2.W = jSONObject.optJSONArray("local_cache_info");
                try {
                    String strOptString = jSONObject.optString(MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_RETRY_STRATEGY);
                    if (!TextUtils.isEmpty(strOptString)) {
                        String strA = x.a(strOptString);
                        if (!TextUtils.isEmpty(strA)) {
                            cVar2.X = new JSONObject(strA);
                        }
                    }
                } catch (Exception unused) {
                }
                return cVar2;
            } catch (Exception e12) {
                e = e12;
                cVar = cVar2;
                e.printStackTrace();
                return cVar;
            }
        } catch (Exception e13) {
            e = e13;
        }
    }

    public static c c(String str) {
        JSONObject jSONObjectOptJSONObject;
        if (H == null) {
            H = h.a(com.mbridge.msdk.foundation.controller.c.m().c());
        }
        c cVar = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String strOptString = jSONObject.optString("vtag", "");
                String strOptString2 = jSONObject.optString("rid", "");
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("unitSetting");
                if (jSONArrayOptJSONArray == null || (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0)) == null) {
                    return null;
                }
                String strOptString3 = jSONObjectOptJSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                if (TextUtils.isEmpty(strOptString3)) {
                    return null;
                }
                c cVar2 = new c();
                try {
                    cVar2.V = strOptString;
                    cVar2.R = strOptString2;
                    List<com.mbridge.msdk.videocommon.b.b> listA = com.mbridge.msdk.videocommon.b.b.a(jSONObjectOptJSONObject.optJSONArray("adSourceList"));
                    cVar2.f48482b = strOptString3;
                    cVar2.f48484d = listA;
                    cVar2.f48489i = jSONObjectOptJSONObject.optInt("callbackType");
                    int iOptInt = jSONObjectOptJSONObject.optInt("aqn", 1);
                    if (iOptInt <= 0) {
                        iOptInt = 1;
                    }
                    cVar2.f48490j = iOptInt;
                    int iOptInt2 = jSONObjectOptJSONObject.optInt("acn", 1);
                    if (iOptInt2 < 0) {
                        iOptInt2 = 1;
                    }
                    cVar2.f48491k = iOptInt2;
                    cVar2.f48492l = jSONObjectOptJSONObject.optInt("vcn", 5);
                    cVar2.f48493m = jSONObjectOptJSONObject.optInt("offset", 5);
                    cVar2.f48494n = jSONObjectOptJSONObject.optInt("dlnet", 1);
                    cVar2.I = jSONObjectOptJSONObject.optInt("endscreen_type", 2);
                    cVar2.f48495o = jSONObjectOptJSONObject.optInt("tv_start", 3);
                    cVar2.f48496p = jSONObjectOptJSONObject.optInt("tv_end", 80);
                    cVar2.f48497q = jSONObjectOptJSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100);
                    cVar2.f48498r = jSONObjectOptJSONObject.optInt("cd_rate", 0);
                    cVar2.f48485e = jSONObject.optLong("current_time");
                    cVar2.f48506z = jSONObjectOptJSONObject.optInt("orientation", 0);
                    cVar2.B = jSONObjectOptJSONObject.optInt("daily_play_cap", 0);
                    cVar2.C = jSONObjectOptJSONObject.optInt("video_skip_time", -1);
                    cVar2.D = jSONObjectOptJSONObject.optInt("video_skip_result", 2);
                    cVar2.E = jSONObjectOptJSONObject.optInt("video_interactive_type", -1);
                    cVar2.F = jSONObjectOptJSONObject.optInt("close_button_delay", 1);
                    cVar2.f48486f = jSONObjectOptJSONObject.optInt("playclosebtn_tm", -1);
                    cVar2.f48487g = jSONObjectOptJSONObject.optInt("play_ctdown", 0);
                    cVar2.f48488h = jSONObjectOptJSONObject.optInt("close_alert", 0);
                    cVar2.G = jSONObjectOptJSONObject.optInt("rdrct", 20);
                    cVar2.A = jSONObjectOptJSONObject.optInt("load_global_timeout", 70);
                    cVar2.f48500t = jSONObjectOptJSONObject.optInt("rfpv", -1);
                    cVar2.f48499s = jSONObjectOptJSONObject.optDouble("vdcmp", 1.0d);
                    f48481a = jSONObjectOptJSONObject.optString("atzu");
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("atl_type");
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    try {
                        if (jSONArrayOptJSONArray2 != null) {
                            for (int i11 = 0; i11 < jSONArrayOptJSONArray2.length(); i11++) {
                                arrayList.add(Integer.valueOf(jSONArrayOptJSONArray2.getInt(i11)));
                            }
                        } else {
                            arrayList.add(4);
                            arrayList.add(6);
                        }
                        cVar2.f48501u = arrayList;
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                    int iOptInt3 = jSONObjectOptJSONObject.optInt("atl_dyt", 0);
                    cVar2.f48502v = iOptInt3 > 0 ? iOptInt3 : 3;
                    int iOptInt4 = jSONObjectOptJSONObject.optInt("tmorl", 1);
                    if (iOptInt4 > 2 || iOptInt4 <= 0) {
                        iOptInt4 = 1;
                    }
                    cVar2.f48503w = iOptInt4;
                    cVar2.f48483c = jSONObjectOptJSONObject.optString("placementid");
                    cVar2.f48504x = jSONObjectOptJSONObject.optInt("ltafemty", 10);
                    cVar2.f48505y = jSONObjectOptJSONObject.optInt("ltorwc", 60);
                    cVar2.d(jSONObjectOptJSONObject.optString("ab_id"));
                    cVar2.J = jSONObjectOptJSONObject.optInt(RewardPlus.AMOUNT_MAX, 0);
                    cVar2.K = jSONObjectOptJSONObject.optInt(RewardPlus.CALLBACK_RULE, 1);
                    cVar2.L = jSONObjectOptJSONObject.optString(RewardPlus.VIRTUAL_CURRENCY, "");
                    cVar2.y(jSONObjectOptJSONObject.optInt("amount", 1));
                    cVar2.N = jSONObjectOptJSONObject.optString(RewardPlus.ICON, "");
                    cVar2.O = jSONObjectOptJSONObject.optInt(RewardPlus.CURRENCY_ID, 1);
                    cVar2.e(jSONObjectOptJSONObject.optString("name", "Virtual Item"));
                    cVar2.T = jSONObjectOptJSONObject.optInt("video_error_rule", 1);
                    cVar2.U = jSONObjectOptJSONObject.optInt("loadtmo", 60);
                    cVar2.W = jSONObjectOptJSONObject.optJSONArray("local_cache_info");
                    try {
                        String strOptString4 = jSONObjectOptJSONObject.optString(MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_RETRY_STRATEGY);
                        if (!TextUtils.isEmpty(strOptString4)) {
                            String strA = x.a(strOptString4);
                            if (!TextUtils.isEmpty(strA)) {
                                cVar2.X = new JSONObject(strA);
                            }
                        }
                    } catch (Exception unused) {
                    }
                    return cVar2;
                } catch (Exception e12) {
                    e = e12;
                    cVar = cVar2;
                }
            } catch (Exception e13) {
                e = e13;
            }
            e.printStackTrace();
        }
        return cVar;
    }

    private void d(String str) {
        this.Q = str;
        com.mbridge.msdk.foundation.controller.a.f44041b.put(this.f48482b, str);
    }

    private void e(String str) {
        if (TextUtils.isEmpty(str)) {
            this.P = this.L;
        } else {
            this.P = str;
        }
    }

    private void y(int i11) {
        if (i11 <= 0) {
            this.M = 1;
        } else {
            this.M = i11;
        }
    }

    public final int A() {
        return this.f48502v;
    }

    public final Queue<Integer> B() {
        LinkedList linkedList;
        Exception e11;
        try {
            List<com.mbridge.msdk.videocommon.b.b> list = this.f48484d;
            if (list == null || list.size() <= 0) {
                return null;
            }
            linkedList = new LinkedList();
            for (int i11 = 0; i11 < this.f48484d.size(); i11++) {
                try {
                    linkedList.add(Integer.valueOf(this.f48484d.get(i11).b()));
                } catch (Exception e12) {
                    e11 = e12;
                    e11.printStackTrace();
                }
            }
            return linkedList;
        } catch (Exception e13) {
            linkedList = null;
            e11 = e13;
        }
        e11.printStackTrace();
        return linkedList;
    }

    public final int C() {
        return this.T;
    }

    public final int D() {
        return this.U;
    }

    public final JSONObject E() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, this.f48482b);
            jSONObject.put("callbackType", this.f48489i);
            List<com.mbridge.msdk.videocommon.b.b> list = this.f48484d;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (com.mbridge.msdk.videocommon.b.b bVar : this.f48484d) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", bVar.a());
                    jSONObject2.put("timeout", bVar.b());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("adSourceList", jSONArray);
            }
            jSONObject.put("aqn", this.f48490j);
            jSONObject.put("acn", this.f48491k);
            jSONObject.put("vcn", this.f48492l);
            jSONObject.put("offset", this.f48493m);
            jSONObject.put("dlnet", this.f48494n);
            jSONObject.put("tv_start", this.f48495o);
            jSONObject.put("tv_end", this.f48496p);
            jSONObject.put(CampaignEx.JSON_KEY_READY_RATE, this.f48497q);
            jSONObject.put("endscreen_type", this.I);
            jSONObject.put("daily_play_cap", this.B);
            jSONObject.put("video_skip_time", this.C);
            jSONObject.put("video_skip_result", this.D);
            jSONObject.put("video_interactive_type", this.E);
            jSONObject.put("orientation", this.f48506z);
            jSONObject.put("close_button_delay", this.F);
            jSONObject.put("playclosebtn_tm", this.f48486f);
            jSONObject.put("play_ctdown", this.f48487g);
            jSONObject.put("close_alert", this.f48488h);
            jSONObject.put("rfpv", this.f48500t);
            jSONObject.put("vdcmp", this.f48499s);
            JSONArray jSONArray2 = new JSONArray();
            ArrayList<Integer> arrayList = this.f48501u;
            if (arrayList != null) {
                if (arrayList.size() > 0) {
                    Iterator<Integer> it = this.f48501u.iterator();
                    while (it.hasNext()) {
                        jSONArray2.put(it.next());
                    }
                }
                jSONObject.put("atl_type", jSONArray2);
            }
            jSONObject.put("atl_dyt", this.f48502v);
            jSONObject.put("tmorl", this.f48503w);
            jSONObject.put("placementid", this.f48483c);
            jSONObject.put("ltafemty", this.f48504x);
            jSONObject.put("ltorwc", this.f48505y);
            jSONObject.put(RewardPlus.AMOUNT_MAX, this.J);
            jSONObject.put(RewardPlus.CALLBACK_RULE, this.K);
            jSONObject.put(RewardPlus.VIRTUAL_CURRENCY, this.L);
            jSONObject.put("amount", this.M);
            jSONObject.put(RewardPlus.ICON, this.N);
            jSONObject.put(RewardPlus.CURRENCY_ID, this.O);
            jSONObject.put("name", this.P);
            jSONObject.put("isDefault", this.S);
            jSONObject.put("video_error_rule", this.T);
            jSONObject.put("loadtmo", this.U);
            jSONObject.put("vtag", this.V);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    public final int F() {
        return this.A;
    }

    public final JSONArray G() {
        return this.W;
    }

    public final int a() {
        return this.f48504x;
    }

    public final void a(int i11) {
        this.f48506z = i11;
    }

    public final void a(String str) {
        this.f48482b = str;
    }

    public final void a(ArrayList<Integer> arrayList) {
        this.f48501u = arrayList;
    }

    public final void a(List<com.mbridge.msdk.videocommon.b.b> list) {
        this.f48484d = list;
    }

    public final int b() {
        return this.f48505y;
    }

    public final void b(int i11) {
        this.B = i11;
    }

    public final void b(String str) {
        this.f48483c = str;
    }

    public final int c() {
        return this.f48506z;
    }

    public final void c(int i11) {
        this.C = i11;
    }

    public final int d() {
        return this.B;
    }

    public final void d(int i11) {
        this.D = i11;
    }

    public final int e() {
        return this.C;
    }

    public final void e(int i11) {
        this.E = i11;
    }

    public final int f() {
        return this.D;
    }

    public final void f(int i11) {
        this.F = i11;
    }

    public final int g() {
        return this.E;
    }

    public final void g(int i11) {
        this.I = i11;
    }

    public final int h() {
        return this.f48486f;
    }

    public final void h(int i11) {
        this.f48495o = i11;
    }

    public final int i() {
        return this.f48488h;
    }

    public final void i(int i11) {
        this.f48496p = i11;
    }

    public final String j() {
        return this.V;
    }

    public final void j(int i11) {
        this.f48497q = i11;
    }

    public final String k() {
        return this.Q;
    }

    public final void k(int i11) {
        this.f48498r = i11;
    }

    public final String l() {
        return this.R;
    }

    public final void l(int i11) {
        this.f48490j = i11;
    }

    public final int m() {
        return this.M;
    }

    public final void m(int i11) {
        this.f48491k = i11;
    }

    public final String n() {
        return this.P;
    }

    public final void n(int i11) {
        this.f48492l = i11;
    }

    public final int o() {
        return this.G;
    }

    public final void o(int i11) {
        this.f48493m = i11;
    }

    public final int p() {
        return this.F;
    }

    public final void p(int i11) {
        this.f48494n = i11;
    }

    public final int q() {
        return this.I;
    }

    public final void q(int i11) {
        this.f48489i = i11;
    }

    public final int r() {
        return this.f48497q;
    }

    public final void r(int i11) {
        this.f48503w = i11;
    }

    public final int s() {
        return this.f48498r;
    }

    public final boolean s(int i11) {
        ArrayList<Integer> arrayList = this.f48501u;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return this.f48501u.contains(Integer.valueOf(i11));
    }

    public final int t() {
        return this.f48490j;
    }

    public final void t(int i11) {
        this.f48502v = i11;
    }

    public final int u() {
        return this.f48491k;
    }

    public final void u(int i11) {
        this.S = i11;
    }

    public final int v() {
        return this.f48493m;
    }

    public final void v(int i11) {
        this.T = i11;
    }

    public final int w() {
        return this.f48494n;
    }

    public final void w(int i11) {
        this.U = i11;
    }

    public final long x() {
        return this.f48485e;
    }

    public final void x(int i11) {
        this.A = i11;
    }

    public final int y() {
        return this.f48503w;
    }

    public final String z() {
        return this.f48483c;
    }
}
