package androidx.media3.exoplayer.source;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.f0;
import androidx.media3.common.y;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.t1;
import java.io.IOException;
import org.mvel2.ast.ASTNode;
import p4.h0;
import u4.q0;
import u4.r0;
import z3.c0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class s implements r0 {

    @Nullable
    public y A;

    @Nullable
    public y B;
    public long C;
    public boolean E;
    public long F;
    public boolean G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f11306a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final androidx.media3.exoplayer.drm.c f11309d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final androidx.media3.exoplayer.drm.b.a f11310e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public d f11311f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public y f11312g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public DrmSession f11313h;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f11321p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f11322q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f11323r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f11324s;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f11328w;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f11331z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f11307b = new b();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f11314i = 1000;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long[] f11315j = new long[1000];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long[] f11316k = new long[1000];

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long[] f11319n = new long[1000];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int[] f11318m = new int[1000];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int[] f11317l = new int[1000];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public r0.a[] f11320o = new r0.a[1000];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h0<c> f11308c = new h0<>(new z3.h() { // from class: p4.d0
        @Override // z3.h
        public final void accept(Object obj) {
            androidx.media3.exoplayer.source.s.M((androidx.media3.exoplayer.source.s.c) obj);
        }
    });

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f11325t = Long.MIN_VALUE;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f11326u = Long.MIN_VALUE;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f11327v = Long.MIN_VALUE;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f11330y = true;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f11329x = true;
    public boolean D = true;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f11333b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public r0.a f11334c;
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y f11335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final androidx.media3.exoplayer.drm.c.b f11336b;

        public c(y yVar, androidx.media3.exoplayer.drm.c.b bVar) {
            this.f11335a = yVar;
            this.f11336b = bVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void c(y yVar);
    }

    public s(androidx.media3.exoplayer.upstream.b bVar, @Nullable androidx.media3.exoplayer.drm.c cVar, @Nullable androidx.media3.exoplayer.drm.b.a aVar) {
        this.f11309d = cVar;
        this.f11310e = aVar;
        this.f11306a = new r(bVar);
    }

    public static /* synthetic */ void M(c cVar) {
        cVar.f11336b.release();
    }

    public static s k(androidx.media3.exoplayer.upstream.b bVar, androidx.media3.exoplayer.drm.c cVar, androidx.media3.exoplayer.drm.b.a aVar) {
        return new s(bVar, (androidx.media3.exoplayer.drm.c) z3.a.e(cVar), (androidx.media3.exoplayer.drm.b.a) z3.a.e(aVar));
    }

    public static s l(androidx.media3.exoplayer.upstream.b bVar) {
        return new s(bVar, null, null);
    }

    public final synchronized long A() {
        return this.f11327v;
    }

    public final synchronized long B() {
        return Math.max(this.f11326u, C(this.f11324s));
    }

    public final long C(int i11) {
        long jMax = Long.MIN_VALUE;
        if (i11 == 0) {
            return Long.MIN_VALUE;
        }
        int iE = E(i11 - 1);
        for (int i12 = 0; i12 < i11; i12++) {
            jMax = Math.max(jMax, this.f11319n[iE]);
            if ((this.f11318m[iE] & 1) != 0) {
                break;
            }
            iE--;
            if (iE == -1) {
                iE = this.f11314i - 1;
            }
        }
        return jMax;
    }

    public final int D() {
        return this.f11322q + this.f11324s;
    }

    public final int E(int i11) {
        int i12 = this.f11323r + i11;
        int i13 = this.f11314i;
        return i12 < i13 ? i12 : i12 - i13;
    }

    public final synchronized int F(long j11, boolean z11) {
        int iE = E(this.f11324s);
        if (I() && j11 >= this.f11319n[iE]) {
            if (j11 > this.f11327v && z11) {
                return this.f11321p - this.f11324s;
            }
            int iW = w(iE, this.f11321p - this.f11324s, j11, true);
            if (iW == -1) {
                return 0;
            }
            return iW;
        }
        return 0;
    }

    @Nullable
    public final synchronized y G() {
        return this.f11330y ? null : this.B;
    }

    public final int H() {
        return this.f11322q + this.f11321p;
    }

    public final boolean I() {
        return this.f11324s != this.f11321p;
    }

    public final void J() {
        this.f11331z = true;
    }

    public final synchronized boolean K() {
        return this.f11328w;
    }

    @CallSuper
    public synchronized boolean L(boolean z11) {
        y yVar;
        boolean z12 = true;
        if (I()) {
            if (this.f11308c.e(D()).f11335a != this.f11312g) {
                return true;
            }
            return N(E(this.f11324s));
        }
        if (!z11 && !this.f11328w && ((yVar = this.B) == null || yVar == this.f11312g)) {
            z12 = false;
        }
        return z12;
    }

    public final boolean N(int i11) {
        DrmSession drmSession = this.f11313h;
        return drmSession == null || drmSession.getState() == 4 || ((this.f11318m[i11] & 1073741824) == 0 && this.f11313h.b());
    }

    @CallSuper
    public void O() throws IOException {
        DrmSession drmSession = this.f11313h;
        if (drmSession != null && drmSession.getState() == 1) {
            throw ((DrmSession.DrmSessionException) z3.a.e(this.f11313h.getError()));
        }
    }

    public final void P(y yVar, t1 t1Var) {
        y yVar2 = this.f11312g;
        boolean z11 = yVar2 == null;
        DrmInitData drmInitData = yVar2 == null ? null : yVar2.f9504p;
        this.f11312g = yVar;
        DrmInitData drmInitData2 = yVar.f9504p;
        androidx.media3.exoplayer.drm.c cVar = this.f11309d;
        t1Var.f11382b = cVar != null ? yVar.c(cVar.c(yVar)) : yVar;
        t1Var.f11381a = this.f11313h;
        if (this.f11309d == null) {
            return;
        }
        if (z11 || !u0.c(drmInitData, drmInitData2)) {
            DrmSession drmSession = this.f11313h;
            DrmSession drmSessionB = this.f11309d.b(this.f11310e, yVar);
            this.f11313h = drmSessionB;
            t1Var.f11381a = drmSessionB;
            if (drmSession != null) {
                drmSession.f(this.f11310e);
            }
        }
    }

    public final synchronized int Q(t1 t1Var, DecoderInputBuffer decoderInputBuffer, boolean z11, boolean z12, b bVar) {
        try {
            decoderInputBuffer.f9781d = false;
            if (!I()) {
                if (!z12 && !this.f11328w) {
                    y yVar = this.B;
                    if (yVar == null || (!z11 && yVar == this.f11312g)) {
                        return -3;
                    }
                    P((y) z3.a.e(yVar), t1Var);
                    return -5;
                }
                decoderInputBuffer.setFlags(4);
                decoderInputBuffer.f9782f = Long.MIN_VALUE;
                return -4;
            }
            y yVar2 = this.f11308c.e(D()).f11335a;
            if (!z11 && yVar2 == this.f11312g) {
                int iE = E(this.f11324s);
                if (!N(iE)) {
                    decoderInputBuffer.f9781d = true;
                    return -3;
                }
                decoderInputBuffer.setFlags(this.f11318m[iE]);
                if (this.f11324s == this.f11321p - 1 && (z12 || this.f11328w)) {
                    decoderInputBuffer.addFlag(ASTNode.DISCARD);
                }
                long j11 = this.f11319n[iE];
                decoderInputBuffer.f9782f = j11;
                if (j11 < this.f11325t) {
                    decoderInputBuffer.addFlag(Integer.MIN_VALUE);
                }
                bVar.f11332a = this.f11317l[iE];
                bVar.f11333b = this.f11316k[iE];
                bVar.f11334c = this.f11320o[iE];
                return -4;
            }
            P(yVar2, t1Var);
            return -5;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized long R() {
        try {
        } catch (Throwable th2) {
            throw th2;
        }
        return I() ? this.f11315j[E(this.f11324s)] : this.C;
    }

    @CallSuper
    public void S() {
        r();
        V();
    }

    @CallSuper
    public int T(t1 t1Var, DecoderInputBuffer decoderInputBuffer, int i11, boolean z11) {
        int iQ = Q(t1Var, decoderInputBuffer, (i11 & 2) != 0, z11, this.f11307b);
        if (iQ == -4 && !decoderInputBuffer.isEndOfStream()) {
            boolean z12 = (i11 & 1) != 0;
            if ((i11 & 4) == 0) {
                if (z12) {
                    this.f11306a.f(decoderInputBuffer, this.f11307b);
                } else {
                    this.f11306a.m(decoderInputBuffer, this.f11307b);
                }
            }
            if (!z12) {
                this.f11324s++;
            }
        }
        return iQ;
    }

    @CallSuper
    public void U() {
        X(true);
        V();
    }

    public final void V() {
        DrmSession drmSession = this.f11313h;
        if (drmSession != null) {
            drmSession.f(this.f11310e);
            this.f11313h = null;
            this.f11312g = null;
        }
    }

    public final void W() {
        X(false);
    }

    @CallSuper
    public void X(boolean z11) {
        this.f11306a.n();
        this.f11321p = 0;
        this.f11322q = 0;
        this.f11323r = 0;
        this.f11324s = 0;
        this.f11329x = true;
        this.f11325t = Long.MIN_VALUE;
        this.f11326u = Long.MIN_VALUE;
        this.f11327v = Long.MIN_VALUE;
        this.f11328w = false;
        this.f11308c.b();
        if (z11) {
            this.A = null;
            this.B = null;
            this.f11330y = true;
            this.D = true;
        }
    }

    public final synchronized void Y() {
        this.f11324s = 0;
        this.f11306a.o();
    }

    public final synchronized boolean Z(int i11) {
        Y();
        int i12 = this.f11322q;
        if (i11 >= i12 && i11 <= this.f11321p + i12) {
            this.f11325t = Long.MIN_VALUE;
            this.f11324s = i11 - i12;
            return true;
        }
        return false;
    }

    @Override // u4.r0
    public final void a(c0 c0Var, int i11, int i12) {
        this.f11306a.q(c0Var, i11);
    }

    public final synchronized boolean a0(long j11, boolean z11) {
        try {
            Y();
            int iE = E(this.f11324s);
            if (I() && j11 >= this.f11319n[iE] && (j11 <= this.f11327v || z11)) {
                int iV = this.D ? v(iE, this.f11321p - this.f11324s, j11, z11) : w(iE, this.f11321p - this.f11324s, j11, true);
                if (iV == -1) {
                    return false;
                }
                this.f11325t = j11;
                this.f11324s += iV;
                return true;
            }
            return false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // u4.r0
    public final void b(y yVar) {
        y yVarX = x(yVar);
        this.f11331z = false;
        this.A = yVar;
        boolean zD0 = d0(yVarX);
        d dVar = this.f11311f;
        if (dVar == null || !zD0) {
            return;
        }
        dVar.c(yVarX);
    }

    public final void b0(long j11) {
        if (this.F != j11) {
            this.F = j11;
            J();
        }
    }

    @Override // u4.r0
    public /* synthetic */ void c(c0 c0Var, int i11) {
        q0.b(this, c0Var, i11);
    }

    public final void c0(long j11) {
        this.f11325t = j11;
    }

    @Override // u4.r0
    public /* synthetic */ int d(androidx.media3.common.l lVar, int i11, boolean z11) {
        return q0.a(this, lVar, i11, z11);
    }

    public final synchronized boolean d0(y yVar) {
        try {
            this.f11330y = false;
            if (u0.c(yVar, this.B)) {
                return false;
            }
            if (this.f11308c.g() || !this.f11308c.f().f11335a.equals(yVar)) {
                this.B = yVar;
            } else {
                this.B = this.f11308c.f().f11335a;
            }
            boolean z11 = this.D;
            y yVar2 = this.B;
            this.D = z11 & f0.a(yVar2.f9501m, yVar2.f9498j);
            this.E = false;
            return true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // u4.r0
    public final int e(androidx.media3.common.l lVar, int i11, boolean z11, int i12) throws IOException {
        return this.f11306a.p(lVar, i11, z11);
    }

    public final void e0(@Nullable d dVar) {
        this.f11311f = dVar;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0054  */
    @Override // u4.r0
    public void f(long j11, int i11, int i12, int i13, @Nullable r0.a aVar) {
        int i14;
        if (this.f11331z) {
            b((y) z3.a.i(this.A));
        }
        int i15 = i11 & 1;
        boolean z11 = i15 != 0;
        if (this.f11329x) {
            if (!z11) {
                return;
            } else {
                this.f11329x = false;
            }
        }
        long j12 = this.F + j11;
        if (!this.D) {
            i14 = i11;
        } else {
            if (j12 < this.f11325t) {
                return;
            }
            if (i15 == 0) {
                if (!this.E) {
                    z3.o.h("SampleQueue", "Overriding unexpected non-sync sample for format: " + this.B);
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
        i(j12, i14, (this.f11306a.e() - ((long) i12)) - ((long) i13), i12, aVar);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x000e  */
    public final synchronized void f0(int i11) {
        boolean z11;
        if (i11 >= 0) {
            try {
                if (this.f11324s + i11 <= this.f11321p) {
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
        z3.a.a(z11);
        this.f11324s += i11;
    }

    public final void g0(long j11) {
        this.C = j11;
    }

    public final synchronized boolean h(long j11) {
        if (this.f11321p == 0) {
            return j11 > this.f11326u;
        }
        if (B() >= j11) {
            return false;
        }
        t(this.f11322q + j(j11));
        return true;
    }

    public final void h0() {
        this.G = true;
    }

    public final synchronized void i(long j11, int i11, long j12, int i12, @Nullable r0.a aVar) {
        try {
            int i13 = this.f11321p;
            if (i13 > 0) {
                int iE = E(i13 - 1);
                z3.a.a(this.f11316k[iE] + ((long) this.f11317l[iE]) <= j12);
            }
            this.f11328w = (536870912 & i11) != 0;
            this.f11327v = Math.max(this.f11327v, j11);
            int iE2 = E(this.f11321p);
            this.f11319n[iE2] = j11;
            this.f11316k[iE2] = j12;
            this.f11317l[iE2] = i12;
            this.f11318m[iE2] = i11;
            this.f11320o[iE2] = aVar;
            this.f11315j[iE2] = this.C;
            if (this.f11308c.g() || !this.f11308c.f().f11335a.equals(this.B)) {
                y yVar = (y) z3.a.e(this.B);
                androidx.media3.exoplayer.drm.c cVar = this.f11309d;
                this.f11308c.a(H(), new c(yVar, cVar != null ? cVar.d(this.f11310e, yVar) : androidx.media3.exoplayer.drm.c.b.f10294a));
            }
            int i14 = this.f11321p + 1;
            this.f11321p = i14;
            int i15 = this.f11314i;
            if (i14 == i15) {
                int i16 = i15 + 1000;
                long[] jArr = new long[i16];
                long[] jArr2 = new long[i16];
                long[] jArr3 = new long[i16];
                int[] iArr = new int[i16];
                int[] iArr2 = new int[i16];
                r0.a[] aVarArr = new r0.a[i16];
                int i17 = this.f11323r;
                int i18 = i15 - i17;
                System.arraycopy(this.f11316k, i17, jArr2, 0, i18);
                System.arraycopy(this.f11319n, this.f11323r, jArr3, 0, i18);
                System.arraycopy(this.f11318m, this.f11323r, iArr, 0, i18);
                System.arraycopy(this.f11317l, this.f11323r, iArr2, 0, i18);
                System.arraycopy(this.f11320o, this.f11323r, aVarArr, 0, i18);
                System.arraycopy(this.f11315j, this.f11323r, jArr, 0, i18);
                int i19 = this.f11323r;
                System.arraycopy(this.f11316k, 0, jArr2, i18, i19);
                System.arraycopy(this.f11319n, 0, jArr3, i18, i19);
                System.arraycopy(this.f11318m, 0, iArr, i18, i19);
                System.arraycopy(this.f11317l, 0, iArr2, i18, i19);
                System.arraycopy(this.f11320o, 0, aVarArr, i18, i19);
                System.arraycopy(this.f11315j, 0, jArr, i18, i19);
                this.f11316k = jArr2;
                this.f11319n = jArr3;
                this.f11318m = iArr;
                this.f11317l = iArr2;
                this.f11320o = aVarArr;
                this.f11315j = jArr;
                this.f11323r = 0;
                this.f11314i = i16;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final int j(long j11) {
        int i11 = this.f11321p;
        int iE = E(i11 - 1);
        while (i11 > this.f11324s && this.f11319n[iE] >= j11) {
            i11--;
            iE--;
            if (iE == -1) {
                iE = this.f11314i - 1;
            }
        }
        return i11;
    }

    public final synchronized long m(long j11, boolean z11, boolean z12) {
        int i11;
        try {
            int i12 = this.f11321p;
            if (i12 != 0) {
                long[] jArr = this.f11319n;
                int i13 = this.f11323r;
                if (j11 >= jArr[i13]) {
                    if (z12 && (i11 = this.f11324s) != i12) {
                        i12 = i11 + 1;
                    }
                    int iW = w(i13, i12, j11, z11);
                    if (iW == -1) {
                        return -1L;
                    }
                    return p(iW);
                }
            }
            return -1L;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized long n() {
        int i11 = this.f11321p;
        if (i11 == 0) {
            return -1L;
        }
        return p(i11);
    }

    public synchronized long o() {
        int i11 = this.f11324s;
        if (i11 == 0) {
            return -1L;
        }
        return p(i11);
    }

    public final long p(int i11) {
        this.f11326u = Math.max(this.f11326u, C(i11));
        this.f11321p -= i11;
        int i12 = this.f11322q + i11;
        this.f11322q = i12;
        int i13 = this.f11323r + i11;
        this.f11323r = i13;
        int i14 = this.f11314i;
        if (i13 >= i14) {
            this.f11323r = i13 - i14;
        }
        int i15 = this.f11324s - i11;
        this.f11324s = i15;
        if (i15 < 0) {
            this.f11324s = 0;
        }
        this.f11308c.d(i12);
        if (this.f11321p != 0) {
            return this.f11316k[this.f11323r];
        }
        int i16 = this.f11323r;
        if (i16 == 0) {
            i16 = this.f11314i;
        }
        int i17 = i16 - 1;
        return this.f11316k[i17] + ((long) this.f11317l[i17]);
    }

    public final void q(long j11, boolean z11, boolean z12) {
        this.f11306a.b(m(j11, z11, z12));
    }

    public final void r() {
        this.f11306a.b(n());
    }

    public final void s() {
        this.f11306a.b(o());
    }

    public final long t(int i11) {
        int iH = H() - i11;
        boolean z11 = false;
        z3.a.a(iH >= 0 && iH <= this.f11321p - this.f11324s);
        int i12 = this.f11321p - iH;
        this.f11321p = i12;
        this.f11327v = Math.max(this.f11326u, C(i12));
        if (iH == 0 && this.f11328w) {
            z11 = true;
        }
        this.f11328w = z11;
        this.f11308c.c(i11);
        int i13 = this.f11321p;
        if (i13 == 0) {
            return 0L;
        }
        int iE = E(i13 - 1);
        return this.f11316k[iE] + ((long) this.f11317l[iE]);
    }

    public final void u(int i11) {
        this.f11306a.c(t(i11));
    }

    public final int v(int i11, int i12, long j11, boolean z11) {
        for (int i13 = 0; i13 < i12; i13++) {
            if (this.f11319n[i11] >= j11) {
                return i13;
            }
            i11++;
            if (i11 == this.f11314i) {
                i11 = 0;
            }
        }
        if (z11) {
            return i12;
        }
        return -1;
    }

    public final int w(int i11, int i12, long j11, boolean z11) {
        int i13 = -1;
        for (int i14 = 0; i14 < i12; i14++) {
            long j12 = this.f11319n[i11];
            if (j12 > j11) {
                return i13;
            }
            if (!z11 || (this.f11318m[i11] & 1) != 0) {
                if (j12 == j11) {
                    return i14;
                }
                i13 = i14;
            }
            i11++;
            if (i11 == this.f11314i) {
                i11 = 0;
            }
        }
        return i13;
    }

    @CallSuper
    public y x(y yVar) {
        return (this.F == 0 || yVar.f9505q == Long.MAX_VALUE) ? yVar : yVar.b().o0(yVar.f9505q + this.F).I();
    }

    public final int y() {
        return this.f11322q;
    }

    public final synchronized long z() {
        return this.f11321p == 0 ? Long.MIN_VALUE : this.f11319n[this.f11323r];
    }
}
