package com.mbridge.msdk.newreward.function.d.a;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.function.d.c.d;
import com.mbridge.msdk.newreward.function.d.c.e;
import com.mbridge.msdk.newreward.function.d.c.i;
import com.mbridge.msdk.newreward.function.d.c.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    private String A;
    private int B;
    private int C;
    private List<CampaignEx> D;
    private int E;
    private long G;
    private Map<String, Object> H;
    private String I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f46282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f46283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f46284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f46285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f46286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f46287f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f46288g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f46289h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f46291j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f46292k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f46293l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f46294m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f46295n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f46296o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f46297p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f46298q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f46299r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private double f46300s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f46301t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private List<a> f46302u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private JSONObject f46303v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private d<?> f46304w;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Context f46307z;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f46290i = 30000;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f46305x = 60000;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f46306y = 60000;
    private int F = 0;

    public b(int i11, String str, String str2, String str3) {
        this.f46282a = i11;
        this.f46283b = str;
        this.f46284c = str2;
        this.f46285d = str3;
    }

    public final int A() {
        return this.C;
    }

    public final int B() {
        return this.B;
    }

    public final List<CampaignEx> C() {
        return this.D;
    }

    public final int D() {
        int i11 = this.E;
        if (i11 <= 0) {
            return 1;
        }
        return i11;
    }

    public final int E() {
        return this.F;
    }

    public final Map<String, Object> F() {
        if (this.H == null) {
            this.H = new HashMap();
        }
        return this.H;
    }

    public final long G() {
        return this.G;
    }

    public final String H() {
        return this.I;
    }

    public final int a() {
        return this.f46282a;
    }

    public final void a(double d11) {
        this.f46300s = d11;
    }

    public final void a(int i11) {
        this.f46291j = i11;
    }

    public final void a(long j11) {
        this.f46290i = j11;
    }

    public final void a(String str) {
        this.f46286e = str;
    }

    public final void a(List<a> list) {
        this.f46302u = list;
    }

    public final void a(JSONObject jSONObject) {
        this.f46303v = jSONObject;
    }

    public final void a(boolean z11) {
        this.f46289h = z11;
    }

    public final String b() {
        return this.f46284c;
    }

    public final void b(int i11) {
        this.f46296o = i11;
    }

    public final void b(long j11) {
        this.f46297p = j11;
    }

    public final void b(String str) {
        this.f46287f = str;
    }

    public final void b(List<CampaignEx> list) {
        this.D = list;
    }

    public final String c() {
        return this.f46285d;
    }

    public final void c(int i11) {
        this.f46301t = i11;
    }

    public final void c(long j11) {
        this.f46298q = j11;
    }

    public final void c(String str) {
        this.f46288g = str;
    }

    public final String d() {
        return this.f46286e;
    }

    public final void d(int i11) {
        this.f46305x = i11;
    }

    public final void d(long j11) {
        this.f46299r = j11;
    }

    public final void d(String str) {
        this.f46292k = str;
    }

    public final String e() {
        return this.f46287f;
    }

    public final void e(int i11) {
        this.f46306y = i11;
    }

    public final void e(long j11) {
        this.G = j11;
    }

    public final void e(String str) {
        this.f46293l = str;
    }

    public final String f() {
        return this.f46288g;
    }

    public final void f(int i11) {
        this.C = i11;
    }

    public final void f(String str) {
        this.f46294m = str;
    }

    public final void g(int i11) {
        this.B = i11;
    }

    public final void g(String str) {
        this.f46295n = str;
    }

    public final boolean g() {
        return this.f46289h;
    }

    public final int h() {
        return this.f46291j;
    }

    public final void h(int i11) {
        this.E = i11;
    }

    public final void h(String str) {
        this.A = str;
    }

    public final String i() {
        return this.f46292k;
    }

    public final void i(int i11) {
        this.F = i11;
    }

    public final void i(String str) {
        this.I = str;
    }

    public final String j() {
        return this.f46293l;
    }

    public final String k() {
        return this.f46294m;
    }

    public final String l() {
        return this.f46295n;
    }

    public final int m() {
        return this.f46296o;
    }

    public final long n() {
        return this.f46297p;
    }

    public final long o() {
        return this.f46298q;
    }

    public final long p() {
        return this.f46299r;
    }

    public final double q() {
        return this.f46300s;
    }

    public final int r() {
        return this.f46301t;
    }

    public final List<a> s() {
        return this.f46302u;
    }

    public final JSONObject t() {
        return this.f46303v;
    }

    public final d<?> u() {
        d<?> dVar = this.f46304w;
        if (dVar != null) {
            return dVar;
        }
        String str = this.A;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f46304w == null) {
            if (com.mbridge.msdk.newreward.function.h.a.b(str)) {
                this.f46304w = new e(this, null);
            } else {
                this.f46304w = new i(this, null);
            }
        }
        return this.f46304w;
    }

    public final int v() {
        return this.f46305x;
    }

    public final Context w() {
        return this.f46307z;
    }

    public final boolean x() {
        List<a> list;
        d<?> dVar = this.f46304w;
        if ((dVar != null && !dVar.c()) || (list = this.f46302u) == null || list.isEmpty()) {
            return false;
        }
        int size = this.f46302u.size();
        Iterator<a> it = this.f46302u.iterator();
        int i11 = 0;
        while (true) {
            boolean z11 = true;
            if (!it.hasNext()) {
                break;
            }
            a next = it.next();
            n nVarD = next.d();
            boolean z12 = nVarD == null || nVarD.c();
            d<?> dVarF = next.f();
            boolean z13 = dVarF == null || dVarF.c();
            d<?> dVarC = next.c();
            if (dVarC != null && !dVarC.c()) {
                z11 = false;
            }
            if (z12 && z13 && z11) {
                i11++;
            }
        }
        return i11 == size;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x007e  */
    public final boolean y() {
        List<a> list;
        boolean z11;
        boolean z12 = this.f46297p > System.currentTimeMillis();
        boolean zX = x();
        d<?> dVar = this.f46304w;
        if (!(dVar == null || dVar.c()) || (list = this.f46302u) == null || list.isEmpty()) {
            z11 = false;
        } else {
            int size = this.f46302u.size();
            int i11 = 0;
            for (a aVar : this.f46302u) {
                n nVarD = aVar.d();
                boolean z13 = nVarD == null || nVarD.d();
                d<?> dVarF = aVar.f();
                boolean z14 = dVarF == null || dVarF.d();
                d<?> dVarC = aVar.c();
                boolean z15 = dVarC == null || dVarC.d();
                if (z13 && z14 && z15) {
                    i11++;
                }
            }
            if (i11 == size) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        return z12 && zX && z11;
    }

    public final String z() {
        return this.A;
    }
}
