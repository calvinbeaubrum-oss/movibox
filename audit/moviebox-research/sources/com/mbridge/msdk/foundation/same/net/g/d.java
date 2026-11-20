package com.mbridge.msdk.foundation.same.net.g;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.e.o;
import com.mbridge.msdk.e.t;
import com.mbridge.msdk.e.w;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.report.u;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class d {
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public String K;
    public String L;
    public String M;
    public String N;
    public String O;
    private final String P;
    private String Q;
    private String R;
    private String S;
    private String T;
    private String U;
    private String V;
    private String W;
    private String X;
    private String Y;
    private String Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f44618a;

    /* JADX INFO: renamed from: aa, reason: collision with root package name */
    private String f44619aa;

    /* JADX INFO: renamed from: ab, reason: collision with root package name */
    private String f44620ab;

    /* JADX INFO: renamed from: ac, reason: collision with root package name */
    private String f44621ac;

    /* JADX INFO: renamed from: ad, reason: collision with root package name */
    private String f44622ad;

    /* JADX INFO: renamed from: ae, reason: collision with root package name */
    private boolean f44623ae;

    /* JADX INFO: renamed from: af, reason: collision with root package name */
    private int f44624af;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f44625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f44626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f44627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f44628e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f44629f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f44630g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f44631h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f44632i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f44633j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f44634k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f44635l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f44636m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f44637n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f44638o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f44639p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f44640q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f44641r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f44642s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ArrayList<String> f44643t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f44644u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f44645v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ArrayList<String> f44646w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f44647x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f44648y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f44649z;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f44650a = new d();
    }

    private d() {
        this.P = "RequestUrlUtil";
        this.f44618a = DomainNameUtils.getInstance().DEFAULT_HOST_APPLETS;
        this.f44625b = DomainNameUtils.getInstance().DEFAULT_CDN_SPARE_SETTING_URL;
        this.f44626c = DomainNameUtils.getInstance().DEFAULT_HOST_ANALYTICS;
        this.f44627d = DomainNameUtils.getInstance().DEFAULT_HOST_API;
        this.f44628e = DomainNameUtils.getInstance().DEFAULT_HOST_MONITOR_DEFAULT;
        this.f44629f = DomainNameUtils.getInstance().DEFAULT_HOST_PRIVACY;
        this.f44630g = DomainNameUtils.getInstance().DEFAULT_HOST_REVENUE_DEFAULT;
        this.f44631h = DomainNameUtils.getInstance().DEFAULT_HOST_SETTING;
        this.f44632i = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_ANALYTICS;
        this.f44633j = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_MONITOR;
        this.f44634k = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_REVENUE;
        this.f44635l = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_SETTING;
        this.f44636m = 9377;
        this.f44637n = 9377;
        this.f44638o = 9988;
        this.f44639p = 9377;
        this.f44640q = false;
        this.f44641r = false;
        this.f44642s = 1;
        this.f44643t = DomainNameUtils.getInstance().SPARE_SETTING_HOST;
        this.f44644u = 0;
        this.f44645v = 0;
        this.f44646w = DomainNameUtils.getInstance().SPARE_TCP_SETTING_HOST;
        this.Q = DomainNameUtils.getInstance().DEFAULT_HB_HOST;
        this.R = "/bid";
        this.f44647x = this.Q + this.R;
        this.S = "/sdk/customid";
        this.f44648y = this.f44631h + this.S;
        this.f44649z = this.f44635l + this.S;
        this.T = "/image";
        this.A = this.f44627d + this.T;
        this.U = "/load";
        this.B = this.Q + this.U;
        this.V = "/mapping";
        this.C = this.f44631h + this.V;
        this.D = this.f44635l + this.V;
        this.W = "";
        this.E = this.f44630g + this.W;
        this.X = "/batchPaidEvent";
        this.F = this.f44630g + this.X;
        this.Y = "/setting";
        this.G = this.f44631h + this.Y;
        this.H = this.f44635l + this.Y;
        this.Z = "/rewardsetting";
        this.I = this.f44631h + this.Z;
        this.J = this.f44635l + this.Z;
        this.f44619aa = "/appwall/setting";
        this.K = this.f44631h + this.f44619aa;
        this.L = this.f44635l + this.f44619aa;
        this.f44620ab = "/openapi/ad/v3";
        this.M = this.f44627d + this.f44620ab;
        this.f44621ac = "/openapi/ad/v4";
        this.N = this.f44627d + this.f44621ac;
        this.f44622ad = "/openapi/ad/v5";
        this.O = this.f44627d + this.f44622ad;
        this.f44623ae = true;
        this.f44624af = 0;
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("(https|http)://[-A-Za-z0-9{}+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]").matcher(str.trim()).matches();
    }

    private String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return Uri.parse(str).getHost();
        } catch (Throwable th2) {
            ad.b("RequestUrlUtil", th2.getMessage());
            return "";
        }
    }

    public static d f() {
        return a.f44650a;
    }

    public final String a(String str) {
        return a.f44650a.a(str, 1);
    }

    public final String a(String str, int i11) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] strArrSplit = str.split("_");
                return strArrSplit.length > 1 ? a(true, strArrSplit[1]) : a(true, "");
            }
        } catch (Exception e11) {
            ad.b("RequestUrlUtil", e11.getMessage());
        }
        return i11 % 2 == 0 ? this.O : this.M;
    }

    public final String a(boolean z11, String str) {
        if (!z11) {
            return this.f44647x.replace("{}", "");
        }
        if (!this.B.contains("{}") || TextUtils.isEmpty(str)) {
            return this.B.replace("{}", "");
        }
        return this.B.replace("{}", str + "-");
    }

    public final void a(int i11) {
        this.f44624af = i11;
    }

    public final boolean a() {
        try {
            if (this.f44641r) {
                ArrayList<String> arrayList = this.f44646w;
                if (arrayList != null && this.f44645v <= arrayList.size() - 1) {
                    if (!b(this.f44646w.get(this.f44645v))) {
                        this.f44635l = this.f44646w.get(this.f44645v);
                        c();
                    }
                    return true;
                }
            } else {
                ArrayList<String> arrayList2 = this.f44643t;
                if (arrayList2 != null && this.f44644u <= arrayList2.size() - 1) {
                    this.f44631h = this.f44643t.get(this.f44644u);
                    b();
                    return true;
                }
            }
            if (this.f44640q) {
                this.f44644u = 0;
                this.f44645v = 0;
            }
            return false;
        } catch (Throwable th2) {
            ad.a("RequestUrlUtil", th2.getMessage());
            return false;
        }
    }

    public final void b() {
        this.G = this.f44631h + this.Y;
        this.f44648y = this.f44631h + this.S;
        this.I = this.f44631h + this.Z;
        this.C = this.f44631h + this.V;
        this.K = this.f44631h + this.f44619aa;
    }

    public final void c() {
        this.H = this.f44635l + this.Y;
        this.f44649z = this.f44635l + this.S;
        this.J = this.f44635l + this.Z;
        this.D = this.f44635l + this.V;
        this.L = this.f44635l + this.f44619aa;
    }

    public final int d() {
        return this.f44624af;
    }

    public final void e() {
        HashMap<String, String> mapG;
        g gVarB = h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
        if (gVarB != null) {
            com.mbridge.msdk.c.a aVarN = gVarB.n();
            if (aVarN != null) {
                this.f44634k = aVarN.f();
                this.f44638o = aVarN.g();
                this.f44630g = aVarN.e();
                this.F = this.f44630g + this.X;
            }
            com.mbridge.msdk.c.d dVarC = gVarB.C();
            if (dVarC != null) {
                this.f44633j = dVarC.d();
                this.f44637n = dVarC.e();
                this.f44628e = dVarC.c();
                this.E = this.f44628e + this.W;
                com.mbridge.msdk.c.d dVarC2 = gVarB.C();
                if (dVarC2 != null && dVarC2.a() != 1) {
                    int iA = af.a().a("monitor", "type", af.a().a("t_r_t", 1));
                    if (iA != 0 && iA != 1) {
                        iA = 0;
                    }
                    t.a().a(com.mbridge.msdk.foundation.controller.c.m().c(), new w.a().a(new com.mbridge.msdk.foundation.same.report.h()).a(new u()).a(iA, iA == 1 ? new o(new com.mbridge.msdk.foundation.same.report.t((byte) 2), a.f44650a.f44633j, a.f44650a.f44637n) : new o(new com.mbridge.msdk.e.a.a.g(), a.f44650a.E, 0)).e(af.a().a("t_m_e_t", 604800000)).a(af.a().a("t_m_e_s", 50)).d(af.a().a("t_m_r_c", 50)).b(af.a().a("t_m_t", DefaultLoadControl.DEFAULT_MIN_BUFFER_MS)).c(af.a().a("t_m_r_t_s", 2)).a(), dVarC2.b() * 1000, com.mbridge.msdk.foundation.same.report.g.a());
                }
            }
            this.f44641r = gVarB.ap() == 2;
            this.f44642s = gVarB.ap();
            this.f44623ae = !gVarB.y(2);
            if (gVarB.G() != null && gVarB.G().size() > 0 && (mapG = gVarB.G()) != null && mapG.size() > 0) {
                if (mapG.containsKey("v") && !TextUtils.isEmpty(mapG.get("v")) && b(mapG.get("v"))) {
                    this.f44627d = mapG.get("v");
                    this.M = this.f44627d + this.f44620ab;
                    this.N = this.f44627d + this.f44621ac;
                    this.O = this.f44627d + this.f44622ad;
                    this.A = this.f44627d + this.T;
                }
                if (mapG.containsKey(CampaignEx.JSON_KEY_HB) && !TextUtils.isEmpty(mapG.get(CampaignEx.JSON_KEY_HB)) && b(mapG.get(CampaignEx.JSON_KEY_HB))) {
                    this.Q = mapG.get(CampaignEx.JSON_KEY_HB);
                    this.f44647x = this.Q + this.R;
                    this.B = this.Q + this.U;
                }
                if (mapG.containsKey("lg") && !TextUtils.isEmpty(mapG.get("lg"))) {
                    String str = mapG.get("lg");
                    if (b(str)) {
                        this.f44626c = str;
                    } else {
                        this.f44632i = str;
                    }
                }
                if (mapG.containsKey("lgt") && !TextUtils.isEmpty(mapG.get("lgt"))) {
                    String str2 = mapG.get("lgt");
                    if (b(str2)) {
                        String strC = c(str2);
                        if (!TextUtils.isEmpty(strC)) {
                            this.f44632i = strC;
                        }
                    } else {
                        this.f44632i = str2;
                    }
                }
            }
            String strY = gVarB.y();
            if (!TextUtils.isEmpty(strY)) {
                this.f44631h = strY;
                b();
                this.f44643t.add(0, strY);
            }
            String strZ = gVarB.z();
            if (TextUtils.isEmpty(strZ)) {
                return;
            }
            this.f44635l = strZ;
            c();
            this.f44646w.add(0, strZ);
        }
    }
}
