package com.mbridge.msdk.foundation.same.report.d;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ao;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f44820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, Map<String, String>> f44821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, Map<String, String>> f44822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, Long> f44823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.mbridge.msdk.foundation.c.b f44824e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f44825f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<CampaignEx> f44826g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f44827h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f44828i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f44829j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f44830k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f44831l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f44832m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f44833n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f44834o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f44835p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f44836q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f44837r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f44838s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f44839t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f44840u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f44841v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f44842w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private CampaignEx f44843x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private List<CampaignEx> f44844y;

    public b() {
        this.f44820a = false;
        this.f44821b = new HashMap();
        this.f44822c = new HashMap();
        this.f44823d = new HashMap();
        this.f44825f = "";
        this.f44837r = -1;
        this.f44839t = false;
        this.f44841v = false;
    }

    public b(boolean z11) {
        this.f44820a = false;
        this.f44821b = new HashMap();
        this.f44822c = new HashMap();
        this.f44823d = new HashMap();
        this.f44825f = "";
        this.f44837r = -1;
        this.f44839t = false;
        this.f44841v = false;
        this.f44820a = z11;
    }

    public final void a(int i11) {
        this.f44837r = i11;
    }

    public final void a(com.mbridge.msdk.foundation.c.b bVar) {
        this.f44824e = bVar;
    }

    public final void a(CampaignEx campaignEx) {
        this.f44843x = campaignEx;
    }

    public final void a(String str) {
        this.f44836q = str;
    }

    public final void a(String str, d dVar) {
        Map<String, String> map;
        if (TextUtils.isEmpty(str) || dVar == null) {
            return;
        }
        try {
            String str2 = this.f44825f + str;
            Map<String, Map<String, String>> map2 = this.f44821b;
            if (map2 != null) {
                if (!map2.containsKey(str2) || (map = this.f44821b.get(str2)) == null) {
                    this.f44821b.put(str2, dVar.a());
                } else {
                    map.putAll(dVar.a());
                }
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public final void a(String str, d dVar, int i11) {
        Map<String, String> map;
        if (TextUtils.isEmpty(str) || dVar == null) {
            return;
        }
        try {
            String str2 = this.f44825f + "_" + i11 + "_" + str;
            Map<String, Map<String, String>> map2 = this.f44822c;
            if (map2 != null) {
                if (!map2.containsKey(str2) || (map = this.f44822c.get(str2)) == null) {
                    this.f44822c.put(str2, dVar.a());
                } else {
                    map.putAll(dVar.a());
                }
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public final void a(List<CampaignEx> list) {
        this.f44826g = list;
    }

    public final void a(boolean z11) {
        this.f44839t = z11;
    }

    public final boolean a() {
        return this.f44820a;
    }

    public final int b() {
        return this.f44837r;
    }

    public final void b(int i11) {
        this.f44828i = i11;
    }

    public final void b(String str) {
        this.f44835p = str;
    }

    public final void b(List<CampaignEx> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f44844y = list;
    }

    public final void b(boolean z11) {
        this.f44840u = z11;
    }

    public final String c() {
        return this.f44836q;
    }

    public final void c(int i11) {
        this.f44838s = i11;
    }

    public final void c(String str) {
        this.f44825f = str;
    }

    public final void c(boolean z11) {
        this.f44841v = z11;
    }

    public final Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public final String d() {
        return this.f44835p;
    }

    public final void d(String str) {
        this.f44827h = str;
    }

    public final void d(boolean z11) {
        this.f44842w = z11;
    }

    public final List<CampaignEx> e() {
        return this.f44826g;
    }

    public final void e(String str) {
        this.f44829j = str;
    }

    public final String f() {
        return this.f44825f;
    }

    public final void f(String str) {
        this.f44830k = str;
    }

    public final CampaignEx g() {
        return this.f44843x;
    }

    public final void g(String str) {
        this.f44831l = str;
    }

    public final List<CampaignEx> h() {
        return this.f44844y;
    }

    public final void h(String str) {
        this.f44833n = str;
    }

    public final String i() {
        Map<String, String> map;
        if (!TextUtils.isEmpty(this.f44827h)) {
            return this.f44827h;
        }
        try {
            if (TextUtils.isEmpty(this.f44827h)) {
                String str = this.f44825f + this.f44836q;
                Map<String, Map<String, String>> map2 = this.f44821b;
                if (map2 != null && map2.containsKey(str) && (map = this.f44821b.get(str)) != null && map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
                    this.f44827h = map.get(MBridgeConstans.PROPERTIES_UNIT_ID);
                }
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
        return this.f44827h;
    }

    public final void i(String str) {
        this.f44834o = str;
    }

    public final int j() {
        return this.f44828i;
    }

    public final Map<String, String> j(String str) {
        com.mbridge.msdk.foundation.c.b bVar;
        com.mbridge.msdk.foundation.c.b bVar2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        d dVar = new d();
        try {
            this.f44836q = str;
            dVar.a("ts", Long.valueOf(System.currentTimeMillis()));
            if (!TextUtils.isEmpty(i())) {
                dVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, i());
            }
            int i11 = this.f44828i;
            if (i11 != 0) {
                dVar.a("adtp", Integer.valueOf(i11));
            }
            if (!TextUtils.isEmpty(this.f44834o)) {
                dVar.a(CampaignEx.JSON_KEY_HB, this.f44834o);
            }
            if (!TextUtils.isEmpty(this.f44829j)) {
                dVar.a("bid_tk", this.f44829j);
            }
            if (!TextUtils.isEmpty(str)) {
                dVar.a("key", str);
            }
            if (Arrays.asList(a.f44809a).contains(str)) {
                dVar.a("from_cache", this.f44839t ? "1" : "2");
            }
            if ("2000047".contains(str) && (bVar2 = this.f44824e) != null) {
                dVar.a("type", Integer.valueOf(bVar2.f()));
                dVar.a("reason", bVar2.b());
                if (!TextUtils.isEmpty(bVar2.h())) {
                    dVar.a("reason_d", bVar2.h());
                    dVar.a("type_d", Integer.valueOf(bVar2.g()));
                }
            }
            if ("2000048".contains(str) && (bVar = this.f44824e) != null && !TextUtils.isEmpty(bVar.h())) {
                dVar.a("type", Integer.valueOf(bVar.g()));
                dVar.a("reason", bVar.h());
            }
            if ("2000126".equals(this.f44836q)) {
                String str2 = this.f44829j;
                g gVarA = h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
                String strA = com.mbridge.msdk.foundation.same.net.g.d.f().a(str2, TextUtils.isEmpty(str2) ? gVarA.ar() : gVarA.F());
                String strA2 = TextUtils.isEmpty(strA) ? "" : ao.a(strA);
                dVar.a("dns_ty", Integer.valueOf(com.mbridge.msdk.c.e.a().a(strA2)));
                dVar.a("dns_hs", strA2);
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
        return dVar.a();
    }

    public final String k() {
        return this.f44830k;
    }

    public final void k(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String str2 = this.f44825f + str;
            Map<String, Map<String, String>> map = this.f44821b;
            if (map == null || !map.containsKey(str2)) {
                return;
            }
            this.f44821b.remove(str2);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public final long l(String str) {
        Map<String, Long> map;
        try {
            if (TextUtils.isEmpty(str) || (map = this.f44823d) == null || !map.containsKey(str)) {
                return 0L;
            }
            Long l11 = this.f44823d.get(str);
            return System.currentTimeMillis() - (l11 != null ? l11.longValue() : 0L);
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return 0L;
            }
            e11.printStackTrace();
            return 0L;
        }
    }

    public final String l() {
        return this.f44831l;
    }

    public final String m() {
        return this.f44833n;
    }

    public final void m(String str) {
        if (this.f44823d == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f44823d.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public final int n() {
        return this.f44838s;
    }

    public final void n(String str) {
        this.f44832m = str;
    }

    public final com.mbridge.msdk.foundation.c.b o() {
        return this.f44824e;
    }

    public final Map<String, Map<String, String>> p() {
        return this.f44821b;
    }

    public final Map<String, Map<String, String>> q() {
        return this.f44822c;
    }

    public final boolean r() {
        return this.f44840u;
    }

    public final boolean s() {
        return this.f44841v;
    }

    public final String t() {
        return this.f44832m;
    }
}
