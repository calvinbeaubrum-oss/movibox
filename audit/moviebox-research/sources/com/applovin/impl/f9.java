package com.applovin.impl;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f9 implements o2 {
    private static final f9 H = new b().a();
    public static final o2.a I = new o2.a() { // from class: com.applovin.impl.nv
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return f9.a(bundle);
        }
    };
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    private int G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f18891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f18892d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f18893f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f18894g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f18895h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f18896i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f18897j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final bf f18898k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f18899l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f18900m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f18901n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List f18902o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final y6 f18903p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f18904q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f18905r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f18906s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final float f18907t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f18908u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final float f18909v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final byte[] f18910w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f18911x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final r3 f18912y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f18913z;

    /* JADX INFO: compiled from: source.java */
    public static final class b {
        private int A;
        private int B;
        private int C;
        private int D;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f18914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f18915b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f18916c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f18917d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f18918e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f18919f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f18920g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f18921h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private bf f18922i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f18923j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f18924k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f18925l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private List f18926m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private y6 f18927n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private long f18928o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f18929p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f18930q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private float f18931r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f18932s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private float f18933t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private byte[] f18934u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private int f18935v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private r3 f18936w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private int f18937x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private int f18938y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private int f18939z;

        public b() {
            this.f18919f = -1;
            this.f18920g = -1;
            this.f18925l = -1;
            this.f18928o = Long.MAX_VALUE;
            this.f18929p = -1;
            this.f18930q = -1;
            this.f18931r = -1.0f;
            this.f18933t = 1.0f;
            this.f18935v = -1;
            this.f18937x = -1;
            this.f18938y = -1;
            this.f18939z = -1;
            this.C = -1;
            this.D = 0;
        }

        private b(f9 f9Var) {
            this.f18914a = f9Var.f18889a;
            this.f18915b = f9Var.f18890b;
            this.f18916c = f9Var.f18891c;
            this.f18917d = f9Var.f18892d;
            this.f18918e = f9Var.f18893f;
            this.f18919f = f9Var.f18894g;
            this.f18920g = f9Var.f18895h;
            this.f18921h = f9Var.f18897j;
            this.f18922i = f9Var.f18898k;
            this.f18923j = f9Var.f18899l;
            this.f18924k = f9Var.f18900m;
            this.f18925l = f9Var.f18901n;
            this.f18926m = f9Var.f18902o;
            this.f18927n = f9Var.f18903p;
            this.f18928o = f9Var.f18904q;
            this.f18929p = f9Var.f18905r;
            this.f18930q = f9Var.f18906s;
            this.f18931r = f9Var.f18907t;
            this.f18932s = f9Var.f18908u;
            this.f18933t = f9Var.f18909v;
            this.f18934u = f9Var.f18910w;
            this.f18935v = f9Var.f18911x;
            this.f18936w = f9Var.f18912y;
            this.f18937x = f9Var.f18913z;
            this.f18938y = f9Var.A;
            this.f18939z = f9Var.B;
            this.A = f9Var.C;
            this.B = f9Var.D;
            this.C = f9Var.E;
            this.D = f9Var.F;
        }

        public b a(float f11) {
            this.f18931r = f11;
            return this;
        }

        public b a(int i11) {
            this.C = i11;
            return this;
        }

        public b a(long j11) {
            this.f18928o = j11;
            return this;
        }

        public b a(bf bfVar) {
            this.f18922i = bfVar;
            return this;
        }

        public b a(r3 r3Var) {
            this.f18936w = r3Var;
            return this;
        }

        public b a(y6 y6Var) {
            this.f18927n = y6Var;
            return this;
        }

        public b a(String str) {
            this.f18921h = str;
            return this;
        }

        public b a(List list) {
            this.f18926m = list;
            return this;
        }

        public b a(byte[] bArr) {
            this.f18934u = bArr;
            return this;
        }

        public f9 a() {
            return new f9(this);
        }

        public b b(float f11) {
            this.f18933t = f11;
            return this;
        }

        public b b(int i11) {
            this.f18919f = i11;
            return this;
        }

        public b b(String str) {
            this.f18923j = str;
            return this;
        }

        public b c(int i11) {
            this.f18937x = i11;
            return this;
        }

        public b c(String str) {
            this.f18914a = str;
            return this;
        }

        public b d(int i11) {
            this.D = i11;
            return this;
        }

        public b d(String str) {
            this.f18915b = str;
            return this;
        }

        public b e(int i11) {
            this.A = i11;
            return this;
        }

        public b e(String str) {
            this.f18916c = str;
            return this;
        }

        public b f(int i11) {
            this.B = i11;
            return this;
        }

        public b f(String str) {
            this.f18924k = str;
            return this;
        }

        public b g(int i11) {
            this.f18930q = i11;
            return this;
        }

        public b h(int i11) {
            this.f18914a = Integer.toString(i11);
            return this;
        }

        public b i(int i11) {
            this.f18925l = i11;
            return this;
        }

        public b j(int i11) {
            this.f18939z = i11;
            return this;
        }

        public b k(int i11) {
            this.f18920g = i11;
            return this;
        }

        public b l(int i11) {
            this.f18918e = i11;
            return this;
        }

        public b m(int i11) {
            this.f18932s = i11;
            return this;
        }

        public b n(int i11) {
            this.f18938y = i11;
            return this;
        }

        public b o(int i11) {
            this.f18917d = i11;
            return this;
        }

        public b p(int i11) {
            this.f18935v = i11;
            return this;
        }

        public b q(int i11) {
            this.f18929p = i11;
            return this;
        }
    }

    private f9(b bVar) {
        this.f18889a = bVar.f18914a;
        this.f18890b = bVar.f18915b;
        this.f18891c = xp.f(bVar.f18916c);
        this.f18892d = bVar.f18917d;
        this.f18893f = bVar.f18918e;
        int i11 = bVar.f18919f;
        this.f18894g = i11;
        int i12 = bVar.f18920g;
        this.f18895h = i12;
        this.f18896i = i12 != -1 ? i12 : i11;
        this.f18897j = bVar.f18921h;
        this.f18898k = bVar.f18922i;
        this.f18899l = bVar.f18923j;
        this.f18900m = bVar.f18924k;
        this.f18901n = bVar.f18925l;
        this.f18902o = bVar.f18926m == null ? Collections.emptyList() : bVar.f18926m;
        y6 y6Var = bVar.f18927n;
        this.f18903p = y6Var;
        this.f18904q = bVar.f18928o;
        this.f18905r = bVar.f18929p;
        this.f18906s = bVar.f18930q;
        this.f18907t = bVar.f18931r;
        this.f18908u = bVar.f18932s == -1 ? 0 : bVar.f18932s;
        this.f18909v = bVar.f18933t == -1.0f ? 1.0f : bVar.f18933t;
        this.f18910w = bVar.f18934u;
        this.f18911x = bVar.f18935v;
        this.f18912y = bVar.f18936w;
        this.f18913z = bVar.f18937x;
        this.A = bVar.f18938y;
        this.B = bVar.f18939z;
        this.C = bVar.A == -1 ? 0 : bVar.A;
        this.D = bVar.B != -1 ? bVar.B : 0;
        this.E = bVar.C;
        if (bVar.D != 0 || y6Var == null) {
            this.F = bVar.D;
        } else {
            this.F = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static f9 a(Bundle bundle) {
        b bVar = new b();
        p2.a(bundle);
        int i11 = 0;
        String string = bundle.getString(b(0));
        f9 f9Var = H;
        bVar.c((String) a(string, f9Var.f18889a)).d((String) a(bundle.getString(b(1)), f9Var.f18890b)).e((String) a(bundle.getString(b(2)), f9Var.f18891c)).o(bundle.getInt(b(3), f9Var.f18892d)).l(bundle.getInt(b(4), f9Var.f18893f)).b(bundle.getInt(b(5), f9Var.f18894g)).k(bundle.getInt(b(6), f9Var.f18895h)).a((String) a(bundle.getString(b(7)), f9Var.f18897j)).a((bf) a((bf) bundle.getParcelable(b(8)), f9Var.f18898k)).b((String) a(bundle.getString(b(9)), f9Var.f18899l)).f((String) a(bundle.getString(b(10)), f9Var.f18900m)).i(bundle.getInt(b(11), f9Var.f18901n));
        ArrayList arrayList = new ArrayList();
        while (true) {
            byte[] byteArray = bundle.getByteArray(c(i11));
            if (byteArray == null) {
                b bVarA = bVar.a(arrayList).a((y6) bundle.getParcelable(b(13)));
                String strB = b(14);
                f9 f9Var2 = H;
                bVarA.a(bundle.getLong(strB, f9Var2.f18904q)).q(bundle.getInt(b(15), f9Var2.f18905r)).g(bundle.getInt(b(16), f9Var2.f18906s)).a(bundle.getFloat(b(17), f9Var2.f18907t)).m(bundle.getInt(b(18), f9Var2.f18908u)).b(bundle.getFloat(b(19), f9Var2.f18909v)).a(bundle.getByteArray(b(20))).p(bundle.getInt(b(21), f9Var2.f18911x)).a((r3) p2.a(r3.f22030g, bundle.getBundle(b(22)))).c(bundle.getInt(b(23), f9Var2.f18913z)).n(bundle.getInt(b(24), f9Var2.A)).j(bundle.getInt(b(25), f9Var2.B)).e(bundle.getInt(b(26), f9Var2.C)).f(bundle.getInt(b(27), f9Var2.D)).a(bundle.getInt(b(28), f9Var2.E)).d(bundle.getInt(b(29), f9Var2.F));
                return bVar.a();
            }
            arrayList.add(byteArray);
            i11++;
        }
    }

    private static Object a(Object obj, Object obj2) {
        return obj != null ? obj : obj2;
    }

    private static String b(int i11) {
        return Integer.toString(i11, 36);
    }

    private static String c(int i11) {
        return b(12) + "_" + Integer.toString(i11, 36);
    }

    public b a() {
        return new b();
    }

    public f9 a(int i11) {
        return a().d(i11).a();
    }

    public boolean a(f9 f9Var) {
        if (this.f18902o.size() != f9Var.f18902o.size()) {
            return false;
        }
        for (int i11 = 0; i11 < this.f18902o.size(); i11++) {
            if (!Arrays.equals((byte[]) this.f18902o.get(i11), (byte[]) f9Var.f18902o.get(i11))) {
                return false;
            }
        }
        return true;
    }

    public int b() {
        int i11;
        int i12 = this.f18905r;
        if (i12 == -1 || (i11 = this.f18906s) == -1) {
            return -1;
        }
        return i12 * i11;
    }

    public boolean equals(Object obj) {
        int i11;
        if (this == obj) {
            return true;
        }
        if (obj == null || f9.class != obj.getClass()) {
            return false;
        }
        f9 f9Var = (f9) obj;
        int i12 = this.G;
        return (i12 == 0 || (i11 = f9Var.G) == 0 || i12 == i11) && this.f18892d == f9Var.f18892d && this.f18893f == f9Var.f18893f && this.f18894g == f9Var.f18894g && this.f18895h == f9Var.f18895h && this.f18901n == f9Var.f18901n && this.f18904q == f9Var.f18904q && this.f18905r == f9Var.f18905r && this.f18906s == f9Var.f18906s && this.f18908u == f9Var.f18908u && this.f18911x == f9Var.f18911x && this.f18913z == f9Var.f18913z && this.A == f9Var.A && this.B == f9Var.B && this.C == f9Var.C && this.D == f9Var.D && this.E == f9Var.E && this.F == f9Var.F && Float.compare(this.f18907t, f9Var.f18907t) == 0 && Float.compare(this.f18909v, f9Var.f18909v) == 0 && xp.a((Object) this.f18889a, (Object) f9Var.f18889a) && xp.a((Object) this.f18890b, (Object) f9Var.f18890b) && xp.a((Object) this.f18897j, (Object) f9Var.f18897j) && xp.a((Object) this.f18899l, (Object) f9Var.f18899l) && xp.a((Object) this.f18900m, (Object) f9Var.f18900m) && xp.a((Object) this.f18891c, (Object) f9Var.f18891c) && Arrays.equals(this.f18910w, f9Var.f18910w) && xp.a(this.f18898k, f9Var.f18898k) && xp.a(this.f18912y, f9Var.f18912y) && xp.a(this.f18903p, f9Var.f18903p) && a(f9Var);
    }

    public int hashCode() {
        if (this.G == 0) {
            String str = this.f18889a;
            int iHashCode = ((str == null ? 0 : str.hashCode()) + 527) * 31;
            String str2 = this.f18890b;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f18891c;
            int iHashCode3 = (((((((((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f18892d) * 31) + this.f18893f) * 31) + this.f18894g) * 31) + this.f18895h) * 31;
            String str4 = this.f18897j;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            bf bfVar = this.f18898k;
            int iHashCode5 = (iHashCode4 + (bfVar == null ? 0 : bfVar.hashCode())) * 31;
            String str5 = this.f18899l;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.f18900m;
            this.G = ((((((((((((((((((((((((((((((iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.f18901n) * 31) + ((int) this.f18904q)) * 31) + this.f18905r) * 31) + this.f18906s) * 31) + Float.floatToIntBits(this.f18907t)) * 31) + this.f18908u) * 31) + Float.floatToIntBits(this.f18909v)) * 31) + this.f18911x) * 31) + this.f18913z) * 31) + this.A) * 31) + this.B) * 31) + this.C) * 31) + this.D) * 31) + this.E) * 31) + this.F;
        }
        return this.G;
    }

    public String toString() {
        return "Format(" + this.f18889a + ", " + this.f18890b + ", " + this.f18899l + ", " + this.f18900m + ", " + this.f18897j + ", " + this.f18896i + ", " + this.f18891c + ", [" + this.f18905r + ", " + this.f18906s + ", " + this.f18907t + "], [" + this.f18913z + ", " + this.A + "])";
    }
}
