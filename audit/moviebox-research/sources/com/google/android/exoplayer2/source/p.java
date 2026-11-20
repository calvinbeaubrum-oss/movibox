package com.google.android.exoplayer2.source;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.n1;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.w;
import java.io.IOException;
import nh.g0;
import tg.d0;
import tg.e0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class p implements e0 {

    @Nullable
    public m1 A;

    @Nullable
    public m1 B;
    public int C;
    public boolean D;
    public boolean E;
    public long F;
    public boolean G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f34332a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final com.google.android.exoplayer2.drm.c f34335d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final com.google.android.exoplayer2.drm.b.a f34336e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public d f34337f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public m1 f34338g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public DrmSession f34339h;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f34347p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f34348q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f34349r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f34350s;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f34354w;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f34357z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f34333b = new b();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f34340i = 1000;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f34341j = new int[1000];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long[] f34342k = new long[1000];

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long[] f34345n = new long[1000];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int[] f34344m = new int[1000];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int[] f34343l = new int[1000];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public e0.a[] f34346o = new e0.a[1000];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g0<c> f34334c = new g0<>(new com.google.android.exoplayer2.util.i() { // from class: nh.c0
        @Override // com.google.android.exoplayer2.util.i
        public final void accept(Object obj) {
            com.google.android.exoplayer2.source.p.L((com.google.android.exoplayer2.source.p.c) obj);
        }
    });

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f34351t = Long.MIN_VALUE;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f34352u = Long.MIN_VALUE;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f34353v = Long.MIN_VALUE;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f34356y = true;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f34355x = true;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f34358a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f34359b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public e0.a f34360c;
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m1 f34361a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.google.android.exoplayer2.drm.c.b f34362b;

        public c(m1 m1Var, com.google.android.exoplayer2.drm.c.b bVar) {
            this.f34361a = m1Var;
            this.f34362b = bVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void b(m1 m1Var);
    }

    public p(com.google.android.exoplayer2.upstream.b bVar, @Nullable com.google.android.exoplayer2.drm.c cVar, @Nullable com.google.android.exoplayer2.drm.b.a aVar) {
        this.f34335d = cVar;
        this.f34336e = aVar;
        this.f34332a = new o(bVar);
    }

    public static /* synthetic */ void L(c cVar) {
        cVar.f34362b.release();
    }

    public static p k(com.google.android.exoplayer2.upstream.b bVar, com.google.android.exoplayer2.drm.c cVar, com.google.android.exoplayer2.drm.b.a aVar) {
        return new p(bVar, (com.google.android.exoplayer2.drm.c) com.google.android.exoplayer2.util.a.e(cVar), (com.google.android.exoplayer2.drm.b.a) com.google.android.exoplayer2.util.a.e(aVar));
    }

    public static p l(com.google.android.exoplayer2.upstream.b bVar) {
        return new p(bVar, null, null);
    }

    public final synchronized long A() {
        return Math.max(this.f34352u, B(this.f34350s));
    }

    public final long B(int i11) {
        long jMax = Long.MIN_VALUE;
        if (i11 == 0) {
            return Long.MIN_VALUE;
        }
        int iD = D(i11 - 1);
        for (int i12 = 0; i12 < i11; i12++) {
            jMax = Math.max(jMax, this.f34345n[iD]);
            if ((this.f34344m[iD] & 1) != 0) {
                break;
            }
            iD--;
            if (iD == -1) {
                iD = this.f34340i - 1;
            }
        }
        return jMax;
    }

    public final int C() {
        return this.f34348q + this.f34350s;
    }

    public final int D(int i11) {
        int i12 = this.f34349r + i11;
        int i13 = this.f34340i;
        return i12 < i13 ? i12 : i12 - i13;
    }

    public final synchronized int E(long j11, boolean z11) {
        int iD = D(this.f34350s);
        if (H() && j11 >= this.f34345n[iD]) {
            if (j11 > this.f34353v && z11) {
                return this.f34347p - this.f34350s;
            }
            int iV = v(iD, this.f34347p - this.f34350s, j11, true);
            if (iV == -1) {
                return 0;
            }
            return iV;
        }
        return 0;
    }

    @Nullable
    public final synchronized m1 F() {
        return this.f34356y ? null : this.B;
    }

    public final int G() {
        return this.f34348q + this.f34347p;
    }

    public final boolean H() {
        return this.f34350s != this.f34347p;
    }

    public final void I() {
        this.f34357z = true;
    }

    public final synchronized boolean J() {
        return this.f34354w;
    }

    @CallSuper
    public synchronized boolean K(boolean z11) {
        m1 m1Var;
        boolean z12 = true;
        if (H()) {
            if (this.f34334c.e(C()).f34361a != this.f34338g) {
                return true;
            }
            return M(D(this.f34350s));
        }
        if (!z11 && !this.f34354w && ((m1Var = this.B) == null || m1Var == this.f34338g)) {
            z12 = false;
        }
        return z12;
    }

    public final boolean M(int i11) {
        DrmSession drmSession = this.f34339h;
        return drmSession == null || drmSession.getState() == 4 || ((this.f34344m[i11] & 1073741824) == 0 && this.f34339h.b());
    }

    @CallSuper
    public void N() throws IOException {
        DrmSession drmSession = this.f34339h;
        if (drmSession != null && drmSession.getState() == 1) {
            throw ((DrmSession.DrmSessionException) com.google.android.exoplayer2.util.a.e(this.f34339h.getError()));
        }
    }

    public final void O(m1 m1Var, n1 n1Var) {
        m1 m1Var2 = this.f34338g;
        boolean z11 = m1Var2 == null;
        DrmInitData drmInitData = z11 ? null : m1Var2.f33448p;
        this.f34338g = m1Var;
        DrmInitData drmInitData2 = m1Var.f33448p;
        com.google.android.exoplayer2.drm.c cVar = this.f34335d;
        n1Var.f33603b = cVar != null ? m1Var.c(cVar.a(m1Var)) : m1Var;
        n1Var.f33602a = this.f34339h;
        if (this.f34335d == null) {
            return;
        }
        if (z11 || !o0.c(drmInitData, drmInitData2)) {
            DrmSession drmSession = this.f34339h;
            DrmSession drmSessionC = this.f34335d.c(this.f34336e, m1Var);
            this.f34339h = drmSessionC;
            n1Var.f33602a = drmSessionC;
            if (drmSession != null) {
                drmSession.f(this.f34336e);
            }
        }
    }

    public final synchronized int P(n1 n1Var, DecoderInputBuffer decoderInputBuffer, boolean z11, boolean z12, b bVar) {
        try {
            decoderInputBuffer.f33031d = false;
            if (!H()) {
                if (!z12 && !this.f34354w) {
                    m1 m1Var = this.B;
                    if (m1Var == null || (!z11 && m1Var == this.f34338g)) {
                        return -3;
                    }
                    O((m1) com.google.android.exoplayer2.util.a.e(m1Var), n1Var);
                    return -5;
                }
                decoderInputBuffer.l(4);
                return -4;
            }
            m1 m1Var2 = this.f34334c.e(C()).f34361a;
            if (!z11 && m1Var2 == this.f34338g) {
                int iD = D(this.f34350s);
                if (!M(iD)) {
                    decoderInputBuffer.f33031d = true;
                    return -3;
                }
                decoderInputBuffer.l(this.f34344m[iD]);
                long j11 = this.f34345n[iD];
                decoderInputBuffer.f33032f = j11;
                if (j11 < this.f34351t) {
                    decoderInputBuffer.a(Integer.MIN_VALUE);
                }
                bVar.f34358a = this.f34343l[iD];
                bVar.f34359b = this.f34342k[iD];
                bVar.f34360c = this.f34346o[iD];
                return -4;
            }
            O(m1Var2, n1Var);
            return -5;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized int Q() {
        try {
        } catch (Throwable th2) {
            throw th2;
        }
        return H() ? this.f34341j[D(this.f34350s)] : this.C;
    }

    @CallSuper
    public void R() {
        r();
        U();
    }

    @CallSuper
    public int S(n1 n1Var, DecoderInputBuffer decoderInputBuffer, int i11, boolean z11) {
        int iP = P(n1Var, decoderInputBuffer, (i11 & 2) != 0, z11, this.f34333b);
        if (iP == -4 && !decoderInputBuffer.i()) {
            boolean z12 = (i11 & 1) != 0;
            if ((i11 & 4) == 0) {
                if (z12) {
                    this.f34332a.f(decoderInputBuffer, this.f34333b);
                } else {
                    this.f34332a.m(decoderInputBuffer, this.f34333b);
                }
            }
            if (!z12) {
                this.f34350s++;
            }
        }
        return iP;
    }

    @CallSuper
    public void T() {
        W(true);
        U();
    }

    public final void U() {
        DrmSession drmSession = this.f34339h;
        if (drmSession != null) {
            drmSession.f(this.f34336e);
            this.f34339h = null;
            this.f34338g = null;
        }
    }

    public final void V() {
        W(false);
    }

    @CallSuper
    public void W(boolean z11) {
        this.f34332a.n();
        this.f34347p = 0;
        this.f34348q = 0;
        this.f34349r = 0;
        this.f34350s = 0;
        this.f34355x = true;
        this.f34351t = Long.MIN_VALUE;
        this.f34352u = Long.MIN_VALUE;
        this.f34353v = Long.MIN_VALUE;
        this.f34354w = false;
        this.f34334c.b();
        if (z11) {
            this.A = null;
            this.B = null;
            this.f34356y = true;
        }
    }

    public final synchronized void X() {
        this.f34350s = 0;
        this.f34332a.o();
    }

    public final synchronized boolean Y(int i11) {
        X();
        int i12 = this.f34348q;
        if (i11 >= i12 && i11 <= this.f34347p + i12) {
            this.f34351t = Long.MIN_VALUE;
            this.f34350s = i11 - i12;
            return true;
        }
        return false;
    }

    public final synchronized boolean Z(long j11, boolean z11) {
        X();
        int iD = D(this.f34350s);
        if (H() && j11 >= this.f34345n[iD] && (j11 <= this.f34353v || z11)) {
            int iV = v(iD, this.f34347p - this.f34350s, j11, true);
            if (iV == -1) {
                return false;
            }
            this.f34351t = j11;
            this.f34350s += iV;
            return true;
        }
        return false;
    }

    @Override // tg.e0
    public final int a(com.google.android.exoplayer2.upstream.g gVar, int i11, boolean z11, int i12) throws IOException {
        return this.f34332a.p(gVar, i11, z11);
    }

    public final void a0(long j11) {
        if (this.F != j11) {
            this.F = j11;
            I();
        }
    }

    @Override // tg.e0
    public /* synthetic */ int b(com.google.android.exoplayer2.upstream.g gVar, int i11, boolean z11) {
        return d0.a(this, gVar, i11, z11);
    }

    public final void b0(long j11) {
        this.f34351t = j11;
    }

    @Override // tg.e0
    public /* synthetic */ void c(c0 c0Var, int i11) {
        d0.b(this, c0Var, i11);
    }

    public final synchronized boolean c0(m1 m1Var) {
        try {
            this.f34356y = false;
            if (o0.c(m1Var, this.B)) {
                return false;
            }
            if (this.f34334c.g() || !this.f34334c.f().f34361a.equals(m1Var)) {
                this.B = m1Var;
            } else {
                this.B = this.f34334c.f().f34361a;
            }
            m1 m1Var2 = this.B;
            this.D = w.a(m1Var2.f33445m, m1Var2.f33442j);
            this.E = false;
            return true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0054  */
    @Override // tg.e0
    public void d(long j11, int i11, int i12, int i13, @Nullable e0.a aVar) {
        int i14;
        if (this.f34357z) {
            e((m1) com.google.android.exoplayer2.util.a.i(this.A));
        }
        int i15 = i11 & 1;
        boolean z11 = i15 != 0;
        if (this.f34355x) {
            if (!z11) {
                return;
            } else {
                this.f34355x = false;
            }
        }
        long j12 = this.F + j11;
        if (!this.D) {
            i14 = i11;
        } else {
            if (j12 < this.f34351t) {
                return;
            }
            if (i15 == 0) {
                if (!this.E) {
                    com.google.android.exoplayer2.util.s.i("SampleQueue", "Overriding unexpected non-sync sample for format: " + this.B);
                    this.E = true;
                }
                i14 = i11 | 1;
            } else {
                i14 = i11;
            }
        }
        if (this.G) {
            if (!z11 || !h(j12)) {
                return;
            } else {
                this.G = false;
            }
        }
        i(j12, i14, (this.f34332a.e() - ((long) i12)) - ((long) i13), i12, aVar);
    }

    public final void d0(@Nullable d dVar) {
        this.f34337f = dVar;
    }

    @Override // tg.e0
    public final void e(m1 m1Var) {
        m1 m1VarW = w(m1Var);
        this.f34357z = false;
        this.A = m1Var;
        boolean zC0 = c0(m1VarW);
        d dVar = this.f34337f;
        if (dVar == null || !zC0) {
            return;
        }
        dVar.b(m1VarW);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x000e  */
    public final synchronized void e0(int i11) {
        boolean z11;
        if (i11 >= 0) {
            try {
                if (this.f34350s + i11 <= this.f34347p) {
                    z11 = true;
                } else {
                    z11 = false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        } else {
            z11 = false;
        }
        com.google.android.exoplayer2.util.a.a(z11);
        this.f34350s += i11;
    }

    @Override // tg.e0
    public final void f(c0 c0Var, int i11, int i12) {
        this.f34332a.q(c0Var, i11);
    }

    public final void f0(int i11) {
        this.C = i11;
    }

    public final void g0() {
        this.G = true;
    }

    public final synchronized boolean h(long j11) {
        if (this.f34347p == 0) {
            return j11 > this.f34352u;
        }
        if (A() >= j11) {
            return false;
        }
        t(this.f34348q + j(j11));
        return true;
    }

    public final synchronized void i(long j11, int i11, long j12, int i12, @Nullable e0.a aVar) {
        try {
            int i13 = this.f34347p;
            if (i13 > 0) {
                int iD = D(i13 - 1);
                com.google.android.exoplayer2.util.a.a(this.f34342k[iD] + ((long) this.f34343l[iD]) <= j12);
            }
            this.f34354w = (536870912 & i11) != 0;
            this.f34353v = Math.max(this.f34353v, j11);
            int iD2 = D(this.f34347p);
            this.f34345n[iD2] = j11;
            this.f34342k[iD2] = j12;
            this.f34343l[iD2] = i12;
            this.f34344m[iD2] = i11;
            this.f34346o[iD2] = aVar;
            this.f34341j[iD2] = this.C;
            if (this.f34334c.g() || !this.f34334c.f().f34361a.equals(this.B)) {
                com.google.android.exoplayer2.drm.c cVar = this.f34335d;
                this.f34334c.a(G(), new c((m1) com.google.android.exoplayer2.util.a.e(this.B), cVar != null ? cVar.d(this.f34336e, this.B) : com.google.android.exoplayer2.drm.c.b.f33172a));
            }
            int i14 = this.f34347p + 1;
            this.f34347p = i14;
            int i15 = this.f34340i;
            if (i14 == i15) {
                int i16 = i15 + 1000;
                int[] iArr = new int[i16];
                long[] jArr = new long[i16];
                long[] jArr2 = new long[i16];
                int[] iArr2 = new int[i16];
                int[] iArr3 = new int[i16];
                e0.a[] aVarArr = new e0.a[i16];
                int i17 = this.f34349r;
                int i18 = i15 - i17;
                System.arraycopy(this.f34342k, i17, jArr, 0, i18);
                System.arraycopy(this.f34345n, this.f34349r, jArr2, 0, i18);
                System.arraycopy(this.f34344m, this.f34349r, iArr2, 0, i18);
                System.arraycopy(this.f34343l, this.f34349r, iArr3, 0, i18);
                System.arraycopy(this.f34346o, this.f34349r, aVarArr, 0, i18);
                System.arraycopy(this.f34341j, this.f34349r, iArr, 0, i18);
                int i19 = this.f34349r;
                System.arraycopy(this.f34342k, 0, jArr, i18, i19);
                System.arraycopy(this.f34345n, 0, jArr2, i18, i19);
                System.arraycopy(this.f34344m, 0, iArr2, i18, i19);
                System.arraycopy(this.f34343l, 0, iArr3, i18, i19);
                System.arraycopy(this.f34346o, 0, aVarArr, i18, i19);
                System.arraycopy(this.f34341j, 0, iArr, i18, i19);
                this.f34342k = jArr;
                this.f34345n = jArr2;
                this.f34344m = iArr2;
                this.f34343l = iArr3;
                this.f34346o = aVarArr;
                this.f34341j = iArr;
                this.f34349r = 0;
                this.f34340i = i16;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final int j(long j11) {
        int i11 = this.f34347p;
        int iD = D(i11 - 1);
        while (i11 > this.f34350s && this.f34345n[iD] >= j11) {
            i11--;
            iD--;
            if (iD == -1) {
                iD = this.f34340i - 1;
            }
        }
        return i11;
    }

    public final synchronized long m(long j11, boolean z11, boolean z12) {
        int i11;
        try {
            int i12 = this.f34347p;
            if (i12 != 0) {
                long[] jArr = this.f34345n;
                int i13 = this.f34349r;
                if (j11 >= jArr[i13]) {
                    if (z12 && (i11 = this.f34350s) != i12) {
                        i12 = i11 + 1;
                    }
                    int iV = v(i13, i12, j11, z11);
                    if (iV == -1) {
                        return -1L;
                    }
                    return p(iV);
                }
            }
            return -1L;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized long n() {
        int i11 = this.f34347p;
        if (i11 == 0) {
            return -1L;
        }
        return p(i11);
    }

    public synchronized long o() {
        int i11 = this.f34350s;
        if (i11 == 0) {
            return -1L;
        }
        return p(i11);
    }

    public final long p(int i11) {
        this.f34352u = Math.max(this.f34352u, B(i11));
        this.f34347p -= i11;
        int i12 = this.f34348q + i11;
        this.f34348q = i12;
        int i13 = this.f34349r + i11;
        this.f34349r = i13;
        int i14 = this.f34340i;
        if (i13 >= i14) {
            this.f34349r = i13 - i14;
        }
        int i15 = this.f34350s - i11;
        this.f34350s = i15;
        if (i15 < 0) {
            this.f34350s = 0;
        }
        this.f34334c.d(i12);
        if (this.f34347p != 0) {
            return this.f34342k[this.f34349r];
        }
        int i16 = this.f34349r;
        if (i16 == 0) {
            i16 = this.f34340i;
        }
        int i17 = i16 - 1;
        return this.f34342k[i17] + ((long) this.f34343l[i17]);
    }

    public final void q(long j11, boolean z11, boolean z12) {
        this.f34332a.b(m(j11, z11, z12));
    }

    public final void r() {
        this.f34332a.b(n());
    }

    public final void s() {
        this.f34332a.b(o());
    }

    public final long t(int i11) {
        int iG = G() - i11;
        boolean z11 = false;
        com.google.android.exoplayer2.util.a.a(iG >= 0 && iG <= this.f34347p - this.f34350s);
        int i12 = this.f34347p - iG;
        this.f34347p = i12;
        this.f34353v = Math.max(this.f34352u, B(i12));
        if (iG == 0 && this.f34354w) {
            z11 = true;
        }
        this.f34354w = z11;
        this.f34334c.c(i11);
        int i13 = this.f34347p;
        if (i13 == 0) {
            return 0L;
        }
        int iD = D(i13 - 1);
        return this.f34342k[iD] + ((long) this.f34343l[iD]);
    }

    public final void u(int i11) {
        this.f34332a.c(t(i11));
    }

    public final int v(int i11, int i12, long j11, boolean z11) {
        int i13 = -1;
        for (int i14 = 0; i14 < i12; i14++) {
            long j12 = this.f34345n[i11];
            if (j12 > j11) {
                return i13;
            }
            if (!z11 || (this.f34344m[i11] & 1) != 0) {
                if (j12 == j11) {
                    return i14;
                }
                i13 = i14;
            }
            i11++;
            if (i11 == this.f34340i) {
                i11 = 0;
            }
        }
        return i13;
    }

    @CallSuper
    public m1 w(m1 m1Var) {
        return (this.F == 0 || m1Var.f33449q == Long.MAX_VALUE) ? m1Var : m1Var.b().i0(m1Var.f33449q + this.F).E();
    }

    public final int x() {
        return this.f34348q;
    }

    public final synchronized long y() {
        return this.f34347p == 0 ? Long.MIN_VALUE : this.f34345n[this.f34349r];
    }

    public final synchronized long z() {
        return this.f34353v;
    }
}
