package y4;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import java.io.IOException;
import java.util.Map;
import u4.a0;
import u4.b0;
import u4.l0;
import u4.m0;
import u4.r;
import u4.r0;
import u4.s;
import u4.t;
import u4.u;
import u4.x;
import u4.y;
import u4.z;
import z3.c0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements s {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final y f81168o = new y() { // from class: y4.c
        @Override // u4.y
        public /* synthetic */ y a(o5.s.a aVar) {
            return x.c(this, aVar);
        }

        @Override // u4.y
        public /* synthetic */ s[] b(Uri uri, Map map) {
            return x.a(this, uri, map);
        }

        @Override // u4.y
        public /* synthetic */ y c(boolean z11) {
            return x.b(this, z11);
        }

        @Override // u4.y
        public final s[] createExtractors() {
            return d.j();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f81169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f81170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f81171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z.a f81172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public u f81173e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public r0 f81174f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f81175g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public Metadata f81176h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public u4.c0 f81177i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f81178j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f81179k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f81180l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f81181m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f81182n;

    public d() {
        this(0);
    }

    public d(int i11) {
        this.f81169a = new byte[42];
        this.f81170b = new c0(new byte[32768], 0);
        this.f81171c = (i11 & 1) != 0;
        this.f81172d = new z.a();
        this.f81175g = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ s[] j() {
        return new s[]{new d()};
    }

    @Override // u4.s
    public boolean b(t tVar) throws IOException {
        a0.c(tVar, false);
        return a0.a(tVar);
    }

    @Override // u4.s
    public /* synthetic */ s c() {
        return r.a(this);
    }

    @Override // u4.s
    public int d(t tVar, l0 l0Var) throws IOException {
        int i11 = this.f81175g;
        if (i11 == 0) {
            m(tVar);
            return 0;
        }
        if (i11 == 1) {
            i(tVar);
            return 0;
        }
        if (i11 == 2) {
            o(tVar);
            return 0;
        }
        if (i11 == 3) {
            n(tVar);
            return 0;
        }
        if (i11 == 4) {
            g(tVar);
            return 0;
        }
        if (i11 == 5) {
            return l(tVar, l0Var);
        }
        throw new IllegalStateException();
    }

    public final long e(c0 c0Var, boolean z11) {
        boolean zD;
        z3.a.e(this.f81177i);
        int iF = c0Var.f();
        while (iF <= c0Var.g() - 16) {
            c0Var.U(iF);
            if (z.d(c0Var, this.f81177i, this.f81179k, this.f81172d)) {
                c0Var.U(iF);
                return this.f81172d.f78414a;
            }
            iF++;
        }
        if (!z11) {
            c0Var.U(iF);
            return -1L;
        }
        while (iF <= c0Var.g() - this.f81178j) {
            c0Var.U(iF);
            try {
                zD = z.d(c0Var, this.f81177i, this.f81179k, this.f81172d);
            } catch (IndexOutOfBoundsException unused) {
                zD = false;
            }
            if (c0Var.f() <= c0Var.g() && zD) {
                c0Var.U(iF);
                return this.f81172d.f78414a;
            }
            iF++;
        }
        c0Var.U(c0Var.g());
        return -1L;
    }

    @Override // u4.s
    public void f(u uVar) {
        this.f81173e = uVar;
        this.f81174f = uVar.track(0, 1);
        uVar.endTracks();
    }

    public final void g(t tVar) throws IOException {
        this.f81179k = a0.b(tVar);
        ((u) u0.i(this.f81173e)).f(h(tVar.getPosition(), tVar.getLength()));
        this.f81175g = 5;
    }

    public final m0 h(long j11, long j12) {
        z3.a.e(this.f81177i);
        u4.c0 c0Var = this.f81177i;
        if (c0Var.f78229k != null) {
            return new b0(c0Var, j11);
        }
        if (j12 == -1 || c0Var.f78228j <= 0) {
            return new m0.b(c0Var.f());
        }
        b bVar = new b(c0Var, this.f81179k, j11, j12);
        this.f81180l = bVar;
        return bVar.b();
    }

    public final void i(t tVar) throws IOException {
        byte[] bArr = this.f81169a;
        tVar.peekFully(bArr, 0, bArr.length);
        tVar.resetPeekPosition();
        this.f81175g = 2;
    }

    public final void k() {
        ((r0) u0.i(this.f81174f)).f((this.f81182n * 1000000) / ((long) ((u4.c0) u0.i(this.f81177i)).f78223e), 1, this.f81181m, 0, null);
    }

    public final int l(t tVar, l0 l0Var) throws IOException {
        boolean z11;
        z3.a.e(this.f81174f);
        z3.a.e(this.f81177i);
        b bVar = this.f81180l;
        if (bVar != null && bVar.d()) {
            return this.f81180l.c(tVar, l0Var);
        }
        if (this.f81182n == -1) {
            this.f81182n = z.i(tVar, this.f81177i);
            return 0;
        }
        int iG = this.f81170b.g();
        if (iG < 32768) {
            int i11 = tVar.read(this.f81170b.e(), iG, 32768 - iG);
            z11 = i11 == -1;
            if (!z11) {
                this.f81170b.T(iG + i11);
            } else if (this.f81170b.a() == 0) {
                k();
                return -1;
            }
        } else {
            z11 = false;
        }
        int iF = this.f81170b.f();
        int i12 = this.f81181m;
        int i13 = this.f81178j;
        if (i12 < i13) {
            c0 c0Var = this.f81170b;
            c0Var.V(Math.min(i13 - i12, c0Var.a()));
        }
        long jE = e(this.f81170b, z11);
        int iF2 = this.f81170b.f() - iF;
        this.f81170b.U(iF);
        this.f81174f.c(this.f81170b, iF2);
        this.f81181m += iF2;
        if (jE != -1) {
            k();
            this.f81181m = 0;
            this.f81182n = jE;
        }
        if (this.f81170b.a() < 16) {
            int iA = this.f81170b.a();
            System.arraycopy(this.f81170b.e(), this.f81170b.f(), this.f81170b.e(), 0, iA);
            this.f81170b.U(0);
            this.f81170b.T(iA);
        }
        return 0;
    }

    public final void m(t tVar) throws IOException {
        this.f81176h = a0.d(tVar, !this.f81171c);
        this.f81175g = 1;
    }

    public final void n(t tVar) throws IOException {
        a0.a aVar = new a0.a(this.f81177i);
        boolean zE = false;
        while (!zE) {
            zE = a0.e(tVar, aVar);
            this.f81177i = (u4.c0) u0.i(aVar.f78197a);
        }
        z3.a.e(this.f81177i);
        this.f81178j = Math.max(this.f81177i.f78221c, 6);
        ((r0) u0.i(this.f81174f)).b(this.f81177i.g(this.f81169a, this.f81176h));
        this.f81175g = 4;
    }

    public final void o(t tVar) throws IOException {
        a0.i(tVar);
        this.f81175g = 3;
    }

    @Override // u4.s
    public void release() {
    }

    @Override // u4.s
    public void seek(long j11, long j12) {
        if (j11 == 0) {
            this.f81175g = 0;
        } else {
            b bVar = this.f81180l;
            if (bVar != null) {
                bVar.h(j12);
            }
        }
        this.f81182n = j12 != 0 ? -1L : 0L;
        this.f81181m = 0;
        this.f81170b.Q(0);
    }
}
