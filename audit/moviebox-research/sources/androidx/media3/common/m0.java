package androidx.media3.common;

import android.net.Uri;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m0 f9282a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f9283b = u0.E0(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f9284c = u0.E0(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f9285d = u0.E0(2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public static final i<m0> f9286e = new androidx.media3.common.b();

    /* JADX INFO: compiled from: source.java */
    public class a extends m0 {
        @Override // androidx.media3.common.m0
        public int b(Object obj) {
            return -1;
        }

        @Override // androidx.media3.common.m0
        public b g(int i11, b bVar, boolean z11) {
            throw new IndexOutOfBoundsException();
        }

        @Override // androidx.media3.common.m0
        public int i() {
            return 0;
        }

        @Override // androidx.media3.common.m0
        public Object m(int i11) {
            throw new IndexOutOfBoundsException();
        }

        @Override // androidx.media3.common.m0
        public c o(int i11, c cVar, long j11) {
            throw new IndexOutOfBoundsException();
        }

        @Override // androidx.media3.common.m0
        public int p() {
            return 0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final String f9287h = u0.E0(0);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final String f9288i = u0.E0(1);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final String f9289j = u0.E0(2);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final String f9290k = u0.E0(3);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final String f9291l = u0.E0(4);

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @Deprecated
        public static final i<b> f9292m = new androidx.media3.common.b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public Object f9293a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public Object f9294b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f9295c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f9296d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f9297e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f9298f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public androidx.media3.common.c f9299g = androidx.media3.common.c.f9089g;

        public int a(int i11) {
            return this.f9299g.a(i11).f9113b;
        }

        public long b(int i11, int i12) {
            androidx.media3.common.c.a aVarA = this.f9299g.a(i11);
            return aVarA.f9113b != -1 ? aVarA.f9118g[i12] : C.TIME_UNSET;
        }

        public int c() {
            return this.f9299g.f9097b;
        }

        public int d(long j11) {
            return this.f9299g.b(j11, this.f9296d);
        }

        public int e(long j11) {
            return this.f9299g.c(j11, this.f9296d);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !b.class.equals(obj.getClass())) {
                return false;
            }
            b bVar = (b) obj;
            return u0.c(this.f9293a, bVar.f9293a) && u0.c(this.f9294b, bVar.f9294b) && this.f9295c == bVar.f9295c && this.f9296d == bVar.f9296d && this.f9297e == bVar.f9297e && this.f9298f == bVar.f9298f && u0.c(this.f9299g, bVar.f9299g);
        }

        public long f(int i11) {
            return this.f9299g.a(i11).f9112a;
        }

        public long g() {
            return this.f9299g.f9098c;
        }

        public int h(int i11, int i12) {
            androidx.media3.common.c.a aVarA = this.f9299g.a(i11);
            if (aVarA.f9113b != -1) {
                return aVarA.f9117f[i12];
            }
            return 0;
        }

        public int hashCode() {
            Object obj = this.f9293a;
            int iHashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.f9294b;
            int iHashCode2 = (((iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.f9295c) * 31;
            long j11 = this.f9296d;
            int i11 = (iHashCode2 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
            long j12 = this.f9297e;
            return ((((i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + (this.f9298f ? 1 : 0)) * 31) + this.f9299g.hashCode();
        }

        public long i(int i11) {
            return this.f9299g.a(i11).f9119h;
        }

        public long j() {
            return u0.B1(this.f9296d);
        }

        public long k() {
            return this.f9296d;
        }

        public int l(int i11) {
            return this.f9299g.a(i11).d();
        }

        public int m(int i11, int i12) {
            return this.f9299g.a(i11).e(i12);
        }

        public long n() {
            return u0.B1(this.f9297e);
        }

        public long o() {
            return this.f9297e;
        }

        public int p() {
            return this.f9299g.f9100e;
        }

        public boolean q(int i11) {
            return !this.f9299g.a(i11).f();
        }

        public boolean r(int i11) {
            return i11 == c() - 1 && this.f9299g.d(i11);
        }

        public boolean s(int i11) {
            return this.f9299g.a(i11).f9120i;
        }

        public b t(@Nullable Object obj, @Nullable Object obj2, int i11, long j11, long j12) {
            return u(obj, obj2, i11, j11, j12, androidx.media3.common.c.f9089g, false);
        }

        public b u(@Nullable Object obj, @Nullable Object obj2, int i11, long j11, long j12, androidx.media3.common.c cVar, boolean z11) {
            this.f9293a = obj;
            this.f9294b = obj2;
            this.f9295c = i11;
            this.f9296d = j11;
            this.f9297e = j12;
            this.f9299g = cVar;
            this.f9298f = z11;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        @Deprecated
        public Object f9310b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public Object f9312d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f9313e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f9314f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f9315g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f9316h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f9317i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Deprecated
        public boolean f9318j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        public b0.g f9319k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f9320l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f9321m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f9322n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f9323o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f9324p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public long f9325q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final Object f9300r = new Object();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final Object f9301s = new Object();

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final b0 f9302t = new b0.c().d("androidx.media3.common.Timeline").i(Uri.EMPTY).a();

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final String f9303u = u0.E0(1);

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final String f9304v = u0.E0(2);

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final String f9305w = u0.E0(3);

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final String f9306x = u0.E0(4);

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final String f9307y = u0.E0(5);

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final String f9308z = u0.E0(6);
        public static final String A = u0.E0(7);
        public static final String B = u0.E0(8);
        public static final String C = u0.E0(9);
        public static final String D = u0.E0(10);
        public static final String E = u0.E0(11);
        public static final String F = u0.E0(12);
        public static final String G = u0.E0(13);

        @Deprecated
        public static final i<c> H = new androidx.media3.common.b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f9309a = f9300r;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b0 f9311c = f9302t;

        public long a() {
            return u0.i0(this.f9315g);
        }

        public long b() {
            return u0.B1(this.f9321m);
        }

        public long c() {
            return this.f9321m;
        }

        public long d() {
            return u0.B1(this.f9322n);
        }

        public long e() {
            return this.f9325q;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !c.class.equals(obj.getClass())) {
                return false;
            }
            c cVar = (c) obj;
            return u0.c(this.f9309a, cVar.f9309a) && u0.c(this.f9311c, cVar.f9311c) && u0.c(this.f9312d, cVar.f9312d) && u0.c(this.f9319k, cVar.f9319k) && this.f9313e == cVar.f9313e && this.f9314f == cVar.f9314f && this.f9315g == cVar.f9315g && this.f9316h == cVar.f9316h && this.f9317i == cVar.f9317i && this.f9320l == cVar.f9320l && this.f9321m == cVar.f9321m && this.f9322n == cVar.f9322n && this.f9323o == cVar.f9323o && this.f9324p == cVar.f9324p && this.f9325q == cVar.f9325q;
        }

        public boolean f() {
            z3.a.g(this.f9318j == (this.f9319k != null));
            return this.f9319k != null;
        }

        public c g(Object obj, @Nullable b0 b0Var, @Nullable Object obj2, long j11, long j12, long j13, boolean z11, boolean z12, @Nullable b0.g gVar, long j14, long j15, int i11, int i12, long j16) {
            b0.h hVar;
            this.f9309a = obj;
            this.f9311c = b0Var != null ? b0Var : f9302t;
            this.f9310b = (b0Var == null || (hVar = b0Var.f8951b) == null) ? null : hVar.f9054h;
            this.f9312d = obj2;
            this.f9313e = j11;
            this.f9314f = j12;
            this.f9315g = j13;
            this.f9316h = z11;
            this.f9317i = z12;
            this.f9318j = gVar != null;
            this.f9319k = gVar;
            this.f9321m = j14;
            this.f9322n = j15;
            this.f9323o = i11;
            this.f9324p = i12;
            this.f9325q = j16;
            this.f9320l = false;
            return this;
        }

        public int hashCode() {
            int iHashCode = (((217 + this.f9309a.hashCode()) * 31) + this.f9311c.hashCode()) * 31;
            Object obj = this.f9312d;
            int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            b0.g gVar = this.f9319k;
            int iHashCode3 = (iHashCode2 + (gVar != null ? gVar.hashCode() : 0)) * 31;
            long j11 = this.f9313e;
            int i11 = (iHashCode3 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
            long j12 = this.f9314f;
            int i12 = (i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31;
            long j13 = this.f9315g;
            int i13 = (((((((i12 + ((int) (j13 ^ (j13 >>> 32)))) * 31) + (this.f9316h ? 1 : 0)) * 31) + (this.f9317i ? 1 : 0)) * 31) + (this.f9320l ? 1 : 0)) * 31;
            long j14 = this.f9321m;
            int i14 = (i13 + ((int) (j14 ^ (j14 >>> 32)))) * 31;
            long j15 = this.f9322n;
            int i15 = (((((i14 + ((int) (j15 ^ (j15 >>> 32)))) * 31) + this.f9323o) * 31) + this.f9324p) * 31;
            long j16 = this.f9325q;
            return i15 + ((int) (j16 ^ (j16 >>> 32)));
        }
    }

    public int a(boolean z11) {
        return q() ? -1 : 0;
    }

    public abstract int b(Object obj);

    public int c(boolean z11) {
        if (q()) {
            return -1;
        }
        return p() - 1;
    }

    public final int d(int i11, b bVar, c cVar, int i12, boolean z11) {
        int i13 = f(i11, bVar).f9295c;
        if (n(i13, cVar).f9324p != i11) {
            return i11 + 1;
        }
        int iE = e(i13, i12, z11);
        if (iE == -1) {
            return -1;
        }
        return n(iE, cVar).f9323o;
    }

    public int e(int i11, int i12, boolean z11) {
        if (i12 == 0) {
            if (i11 == c(z11)) {
                return -1;
            }
            return i11 + 1;
        }
        if (i12 == 1) {
            return i11;
        }
        if (i12 == 2) {
            return i11 == c(z11) ? a(z11) : i11 + 1;
        }
        throw new IllegalStateException();
    }

    public boolean equals(@Nullable Object obj) {
        int iC;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m0)) {
            return false;
        }
        m0 m0Var = (m0) obj;
        if (m0Var.p() != p() || m0Var.i() != i()) {
            return false;
        }
        c cVar = new c();
        b bVar = new b();
        c cVar2 = new c();
        b bVar2 = new b();
        for (int i11 = 0; i11 < p(); i11++) {
            if (!n(i11, cVar).equals(m0Var.n(i11, cVar2))) {
                return false;
            }
        }
        for (int i12 = 0; i12 < i(); i12++) {
            if (!g(i12, bVar, true).equals(m0Var.g(i12, bVar2, true))) {
                return false;
            }
        }
        int iA = a(true);
        if (iA != m0Var.a(true) || (iC = c(true)) != m0Var.c(true)) {
            return false;
        }
        while (iA != iC) {
            int iE = e(iA, 0, true);
            if (iE != m0Var.e(iA, 0, true)) {
                return false;
            }
            iA = iE;
        }
        return true;
    }

    public final b f(int i11, b bVar) {
        return g(i11, bVar, false);
    }

    public abstract b g(int i11, b bVar, boolean z11);

    public b h(Object obj, b bVar) {
        return g(b(obj), bVar, true);
    }

    public int hashCode() {
        c cVar = new c();
        b bVar = new b();
        int iP = 217 + p();
        for (int i11 = 0; i11 < p(); i11++) {
            iP = (iP * 31) + n(i11, cVar).hashCode();
        }
        int i12 = (iP * 31) + i();
        for (int i13 = 0; i13 < i(); i13++) {
            i12 = (i12 * 31) + g(i13, bVar, true).hashCode();
        }
        int iA = a(true);
        while (iA != -1) {
            i12 = (i12 * 31) + iA;
            iA = e(iA, 0, true);
        }
        return i12;
    }

    public abstract int i();

    public final Pair<Object, Long> j(c cVar, b bVar, int i11, long j11) {
        return (Pair) z3.a.e(k(cVar, bVar, i11, j11, 0L));
    }

    @Nullable
    public final Pair<Object, Long> k(c cVar, b bVar, int i11, long j11, long j12) {
        z3.a.c(i11, 0, p());
        o(i11, cVar, j12);
        if (j11 == C.TIME_UNSET) {
            j11 = cVar.c();
            if (j11 == C.TIME_UNSET) {
                return null;
            }
        }
        int i12 = cVar.f9323o;
        f(i12, bVar);
        while (i12 < cVar.f9324p && bVar.f9297e != j11) {
            int i13 = i12 + 1;
            if (f(i13, bVar).f9297e > j11) {
                break;
            }
            i12 = i13;
        }
        g(i12, bVar, true);
        long jMin = j11 - bVar.f9297e;
        long j13 = bVar.f9296d;
        if (j13 != C.TIME_UNSET) {
            jMin = Math.min(jMin, j13 - 1);
        }
        return Pair.create(z3.a.e(bVar.f9294b), Long.valueOf(Math.max(0L, jMin)));
    }

    public int l(int i11, int i12, boolean z11) {
        if (i12 == 0) {
            if (i11 == a(z11)) {
                return -1;
            }
            return i11 - 1;
        }
        if (i12 == 1) {
            return i11;
        }
        if (i12 == 2) {
            return i11 == a(z11) ? c(z11) : i11 - 1;
        }
        throw new IllegalStateException();
    }

    public abstract Object m(int i11);

    public final c n(int i11, c cVar) {
        return o(i11, cVar, 0L);
    }

    public abstract c o(int i11, c cVar, long j11);

    public abstract int p();

    public final boolean q() {
        return p() == 0;
    }

    public final boolean r(int i11, b bVar, c cVar, int i12, boolean z11) {
        return d(i11, bVar, cVar, i12, z11) == -1;
    }
}
