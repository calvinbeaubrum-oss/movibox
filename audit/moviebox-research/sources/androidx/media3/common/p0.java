package androidx.media3.common;

import android.content.Context;
import android.graphics.Point;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.common.api.Api;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class p0 {
    public static final p0 C;

    @Deprecated
    public static final p0 D;
    public static final String E;
    public static final String F;
    public static final String G;
    public static final String H;
    public static final String I;
    public static final String J;
    public static final String K;
    public static final String L;
    public static final String M;
    public static final String N;
    public static final String O;
    public static final String P;
    public static final String Q;
    public static final String R;
    public static final String S;
    public static final String T;
    public static final String U;
    public static final String V;
    public static final String W;
    public static final String X;
    public static final String Y;
    public static final String Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final String f9354a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final String f9355b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final String f9356c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final String f9357d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final String f9358e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final String f9359f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final String f9360g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final String f9361h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final String f9362i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    @Deprecated
    public static final i<p0> f9363j0;
    public final ImmutableMap<n0, o0> A;
    public final ImmutableSet<Integer> B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9368e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f9369f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f9370g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f9371h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f9372i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f9373j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f9374k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ImmutableList<String> f9375l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f9376m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ImmutableList<String> f9377n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f9378o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f9379p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f9380q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ImmutableList<String> f9381r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b f9382s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ImmutableList<String> f9383t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f9384u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f9385v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f9386w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f9387x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f9388y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f9389z;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f9390d = new a().d();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f9391e = u0.E0(1);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f9392f = u0.E0(2);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final String f9393g = u0.E0(3);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f9394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f9395b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f9396c;

        /* JADX INFO: compiled from: source.java */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f9397a = 0;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f9398b = false;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f9399c = false;

            public b d() {
                return new b(this);
            }
        }

        public b(a aVar) {
            this.f9394a = aVar.f9397a;
            this.f9395b = aVar.f9398b;
            this.f9396c = aVar.f9399c;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f9394a == bVar.f9394a && this.f9395b == bVar.f9395b && this.f9396c == bVar.f9396c;
        }

        public int hashCode() {
            return ((((this.f9394a + 31) * 31) + (this.f9395b ? 1 : 0)) * 31) + (this.f9396c ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {
        public HashMap<n0, o0> A;
        public HashSet<Integer> B;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f9400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9401b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f9402c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f9403d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f9404e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f9405f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f9406g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f9407h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f9408i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f9409j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f9410k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public ImmutableList<String> f9411l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f9412m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public ImmutableList<String> f9413n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f9414o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f9415p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f9416q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public ImmutableList<String> f9417r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public b f9418s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public ImmutableList<String> f9419t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f9420u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f9421v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f9422w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f9423x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public boolean f9424y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public boolean f9425z;

        @Deprecated
        public c() {
            this.f9400a = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f9401b = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f9402c = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f9403d = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f9408i = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f9409j = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f9410k = true;
            this.f9411l = ImmutableList.of();
            this.f9412m = 0;
            this.f9413n = ImmutableList.of();
            this.f9414o = 0;
            this.f9415p = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f9416q = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f9417r = ImmutableList.of();
            this.f9418s = b.f9390d;
            this.f9419t = ImmutableList.of();
            this.f9420u = 0;
            this.f9421v = 0;
            this.f9422w = false;
            this.f9423x = false;
            this.f9424y = false;
            this.f9425z = false;
            this.A = new HashMap<>();
            this.B = new HashSet<>();
        }

        public c(Context context) {
            this();
            I(context);
            M(context, true);
        }

        public c(p0 p0Var) {
            E(p0Var);
        }

        public p0 C() {
            return new p0(this);
        }

        public c D(int i11) {
            Iterator<o0> it = this.A.values().iterator();
            while (it.hasNext()) {
                if (it.next().a() == i11) {
                    it.remove();
                }
            }
            return this;
        }

        public final void E(p0 p0Var) {
            this.f9400a = p0Var.f9364a;
            this.f9401b = p0Var.f9365b;
            this.f9402c = p0Var.f9366c;
            this.f9403d = p0Var.f9367d;
            this.f9404e = p0Var.f9368e;
            this.f9405f = p0Var.f9369f;
            this.f9406g = p0Var.f9370g;
            this.f9407h = p0Var.f9371h;
            this.f9408i = p0Var.f9372i;
            this.f9409j = p0Var.f9373j;
            this.f9410k = p0Var.f9374k;
            this.f9411l = p0Var.f9375l;
            this.f9412m = p0Var.f9376m;
            this.f9413n = p0Var.f9377n;
            this.f9414o = p0Var.f9378o;
            this.f9415p = p0Var.f9379p;
            this.f9416q = p0Var.f9380q;
            this.f9417r = p0Var.f9381r;
            this.f9418s = p0Var.f9382s;
            this.f9419t = p0Var.f9383t;
            this.f9420u = p0Var.f9384u;
            this.f9421v = p0Var.f9385v;
            this.f9422w = p0Var.f9386w;
            this.f9423x = p0Var.f9387x;
            this.f9424y = p0Var.f9388y;
            this.f9425z = p0Var.f9389z;
            this.B = new HashSet<>(p0Var.B);
            this.A = new HashMap<>(p0Var.A);
        }

        public c F(p0 p0Var) {
            E(p0Var);
            return this;
        }

        public c G(int i11) {
            this.f9421v = i11;
            return this;
        }

        public c H(o0 o0Var) {
            D(o0Var.a());
            this.A.put(o0Var.f9352a, o0Var);
            return this;
        }

        public c I(Context context) {
            if (u0.f81838a >= 19) {
                J(context);
            }
            return this;
        }

        @RequiresApi(19)
        public final void J(Context context) {
            CaptioningManager captioningManager;
            if ((u0.f81838a >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.f9420u = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.f9419t = ImmutableList.of(u0.e0(locale));
                }
            }
        }

        public c K(int i11, boolean z11) {
            if (z11) {
                this.B.add(Integer.valueOf(i11));
            } else {
                this.B.remove(Integer.valueOf(i11));
            }
            return this;
        }

        public c L(int i11, int i12, boolean z11) {
            this.f9408i = i11;
            this.f9409j = i12;
            this.f9410k = z11;
            return this;
        }

        public c M(Context context, boolean z11) {
            Point pointT = u0.T(context);
            return L(pointT.x, pointT.y, z11);
        }
    }

    static {
        p0 p0VarC = new c().C();
        C = p0VarC;
        D = p0VarC;
        E = u0.E0(1);
        F = u0.E0(2);
        G = u0.E0(3);
        H = u0.E0(4);
        I = u0.E0(5);
        J = u0.E0(6);
        K = u0.E0(7);
        L = u0.E0(8);
        M = u0.E0(9);
        N = u0.E0(10);
        O = u0.E0(11);
        P = u0.E0(12);
        Q = u0.E0(13);
        R = u0.E0(14);
        S = u0.E0(15);
        T = u0.E0(16);
        U = u0.E0(17);
        V = u0.E0(18);
        W = u0.E0(19);
        X = u0.E0(20);
        Y = u0.E0(21);
        Z = u0.E0(22);
        f9354a0 = u0.E0(23);
        f9355b0 = u0.E0(24);
        f9356c0 = u0.E0(25);
        f9357d0 = u0.E0(26);
        f9358e0 = u0.E0(27);
        f9359f0 = u0.E0(28);
        f9360g0 = u0.E0(29);
        f9361h0 = u0.E0(30);
        f9362i0 = u0.E0(31);
        f9363j0 = new androidx.media3.common.b();
    }

    public p0(c cVar) {
        this.f9364a = cVar.f9400a;
        this.f9365b = cVar.f9401b;
        this.f9366c = cVar.f9402c;
        this.f9367d = cVar.f9403d;
        this.f9368e = cVar.f9404e;
        this.f9369f = cVar.f9405f;
        this.f9370g = cVar.f9406g;
        this.f9371h = cVar.f9407h;
        this.f9372i = cVar.f9408i;
        this.f9373j = cVar.f9409j;
        this.f9374k = cVar.f9410k;
        this.f9375l = cVar.f9411l;
        this.f9376m = cVar.f9412m;
        this.f9377n = cVar.f9413n;
        this.f9378o = cVar.f9414o;
        this.f9379p = cVar.f9415p;
        this.f9380q = cVar.f9416q;
        this.f9381r = cVar.f9417r;
        this.f9382s = cVar.f9418s;
        this.f9383t = cVar.f9419t;
        this.f9384u = cVar.f9420u;
        this.f9385v = cVar.f9421v;
        this.f9386w = cVar.f9422w;
        this.f9387x = cVar.f9423x;
        this.f9388y = cVar.f9424y;
        this.f9389z = cVar.f9425z;
        this.A = ImmutableMap.copyOf((Map) cVar.A);
        this.B = ImmutableSet.copyOf((Collection) cVar.B);
    }

    public c a() {
        return new c(this);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        p0 p0Var = (p0) obj;
        return this.f9364a == p0Var.f9364a && this.f9365b == p0Var.f9365b && this.f9366c == p0Var.f9366c && this.f9367d == p0Var.f9367d && this.f9368e == p0Var.f9368e && this.f9369f == p0Var.f9369f && this.f9370g == p0Var.f9370g && this.f9371h == p0Var.f9371h && this.f9374k == p0Var.f9374k && this.f9372i == p0Var.f9372i && this.f9373j == p0Var.f9373j && this.f9375l.equals(p0Var.f9375l) && this.f9376m == p0Var.f9376m && this.f9377n.equals(p0Var.f9377n) && this.f9378o == p0Var.f9378o && this.f9379p == p0Var.f9379p && this.f9380q == p0Var.f9380q && this.f9381r.equals(p0Var.f9381r) && this.f9382s.equals(p0Var.f9382s) && this.f9383t.equals(p0Var.f9383t) && this.f9384u == p0Var.f9384u && this.f9385v == p0Var.f9385v && this.f9386w == p0Var.f9386w && this.f9387x == p0Var.f9387x && this.f9388y == p0Var.f9388y && this.f9389z == p0Var.f9389z && this.A.equals(p0Var.A) && this.B.equals(p0Var.B);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((this.f9364a + 31) * 31) + this.f9365b) * 31) + this.f9366c) * 31) + this.f9367d) * 31) + this.f9368e) * 31) + this.f9369f) * 31) + this.f9370g) * 31) + this.f9371h) * 31) + (this.f9374k ? 1 : 0)) * 31) + this.f9372i) * 31) + this.f9373j) * 31) + this.f9375l.hashCode()) * 31) + this.f9376m) * 31) + this.f9377n.hashCode()) * 31) + this.f9378o) * 31) + this.f9379p) * 31) + this.f9380q) * 31) + this.f9381r.hashCode()) * 31) + this.f9382s.hashCode()) * 31) + this.f9383t.hashCode()) * 31) + this.f9384u) * 31) + this.f9385v) * 31) + (this.f9386w ? 1 : 0)) * 31) + (this.f9387x ? 1 : 0)) * 31) + (this.f9388y ? 1 : 0)) * 31) + (this.f9389z ? 1 : 0)) * 31) + this.A.hashCode()) * 31) + this.B.hashCode();
    }
}
