package androidx.media3.exoplayer.source;

import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.media3.common.b0;
import androidx.media3.common.m0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import e4.x3;
import p4.g0;
import u4.y;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q extends androidx.media3.exoplayer.source.a implements p.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final androidx.media3.datasource.a.InterfaceC0090a f11278h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final o.a f11279i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.media3.exoplayer.drm.c f11280j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final androidx.media3.exoplayer.upstream.m f11281k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f11282l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f11283m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f11284n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f11285o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f11286p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public c4.o f11287q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public b0 f11288r;

    /* JADX INFO: compiled from: source.java */
    public class a extends p4.m {
        public a(m0 m0Var) {
            super(m0Var);
        }

        @Override // p4.m, androidx.media3.common.m0
        public m0.b g(int i11, m0.b bVar, boolean z11) {
            super.g(i11, bVar, z11);
            bVar.f9298f = true;
            return bVar;
        }

        @Override // p4.m, androidx.media3.common.m0
        public m0.c o(int i11, m0.c cVar, long j11) {
            super.o(i11, cVar, j11);
            cVar.f9320l = true;
            return cVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements l.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.media3.datasource.a.InterfaceC0090a f11290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public o.a f11291b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public i4.u f11292c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public androidx.media3.exoplayer.upstream.m f11293d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f11294e;

        public b(androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a) {
            this(interfaceC0090a, new u4.m());
        }

        public b(androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a, o.a aVar) {
            this(interfaceC0090a, aVar, new androidx.media3.exoplayer.drm.a(), new androidx.media3.exoplayer.upstream.k(), 1048576);
        }

        public b(androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a, o.a aVar, i4.u uVar, androidx.media3.exoplayer.upstream.m mVar, int i11) {
            this.f11290a = interfaceC0090a;
            this.f11291b = aVar;
            this.f11292c = uVar;
            this.f11293d = mVar;
            this.f11294e = i11;
        }

        public b(androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a, final y yVar) {
            this(interfaceC0090a, new o.a() { // from class: p4.c0
                @Override // androidx.media3.exoplayer.source.o.a
                public final androidx.media3.exoplayer.source.o a(x3 x3Var) {
                    return androidx.media3.exoplayer.source.q.b.i(yVar, x3Var);
                }
            });
        }

        public static /* synthetic */ o i(y yVar, x3 x3Var) {
            return new p4.a(yVar);
        }

        @Override // androidx.media3.exoplayer.source.l.a
        public /* synthetic */ l.a a(o5.s.a aVar) {
            return p4.q.c(this, aVar);
        }

        @Override // androidx.media3.exoplayer.source.l.a
        public /* synthetic */ l.a b(boolean z11) {
            return p4.q.a(this, z11);
        }

        @Override // androidx.media3.exoplayer.source.l.a
        public /* synthetic */ l.a f(androidx.media3.exoplayer.upstream.f.a aVar) {
            return p4.q.b(this, aVar);
        }

        @Override // androidx.media3.exoplayer.source.l.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public q c(b0 b0Var) {
            z3.a.e(b0Var.f8951b);
            return new q(b0Var, this.f11290a, this.f11291b, this.f11292c.a(b0Var), this.f11293d, this.f11294e, null);
        }

        @Override // androidx.media3.exoplayer.source.l.a
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public b d(i4.u uVar) {
            this.f11292c = (i4.u) z3.a.f(uVar, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // androidx.media3.exoplayer.source.l.a
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public b e(androidx.media3.exoplayer.upstream.m mVar) {
            this.f11293d = (androidx.media3.exoplayer.upstream.m) z3.a.f(mVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }
    }

    public q(b0 b0Var, androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a, o.a aVar, androidx.media3.exoplayer.drm.c cVar, androidx.media3.exoplayer.upstream.m mVar, int i11) {
        this.f11288r = b0Var;
        this.f11278h = interfaceC0090a;
        this.f11279i = aVar;
        this.f11280j = cVar;
        this.f11281k = mVar;
        this.f11282l = i11;
        this.f11283m = true;
        this.f11284n = C.TIME_UNSET;
    }

    public /* synthetic */ q(b0 b0Var, androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a, o.a aVar, androidx.media3.exoplayer.drm.c cVar, androidx.media3.exoplayer.upstream.m mVar, int i11, a aVar2) {
        this(b0Var, interfaceC0090a, aVar, cVar, mVar, i11);
    }

    @Override // androidx.media3.exoplayer.source.a
    public void B() {
        this.f11280j.release();
    }

    public final b0.h C() {
        return (b0.h) z3.a.e(a().f8951b);
    }

    public final void D() {
        m0 g0Var = new g0(this.f11284n, this.f11285o, false, this.f11286p, null, a());
        if (this.f11283m) {
            g0Var = new a(g0Var);
        }
        A(g0Var);
    }

    @Override // androidx.media3.exoplayer.source.l
    public synchronized b0 a() {
        return this.f11288r;
    }

    @Override // androidx.media3.exoplayer.source.p.c
    public void b(long j11, boolean z11, boolean z12) {
        if (j11 == C.TIME_UNSET) {
            j11 = this.f11284n;
        }
        if (!this.f11283m && this.f11284n == j11 && this.f11285o == z11 && this.f11286p == z12) {
            return;
        }
        this.f11284n = j11;
        this.f11285o = z11;
        this.f11286p = z12;
        this.f11283m = false;
        D();
    }

    @Override // androidx.media3.exoplayer.source.l
    public k h(l.b bVar, androidx.media3.exoplayer.upstream.b bVar2, long j11) {
        androidx.media3.datasource.a aVarCreateDataSource = this.f11278h.createDataSource();
        c4.o oVar = this.f11287q;
        if (oVar != null) {
            aVarCreateDataSource.c(oVar);
        }
        b0.h hVarC = C();
        return new p(hVarC.f9047a, aVarCreateDataSource, this.f11279i.a(x()), this.f11280j, s(bVar), this.f11281k, u(bVar), this, bVar2, hVarC.f9051e, this.f11282l, u0.S0(hVarC.f9055i));
    }

    @Override // androidx.media3.exoplayer.source.l
    public void l(k kVar) {
        ((p) kVar).U();
    }

    @Override // androidx.media3.exoplayer.source.l
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.l
    public synchronized void n(b0 b0Var) {
        this.f11288r = b0Var;
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.l
    public boolean q(b0 b0Var) {
        b0.h hVarC = C();
        b0.h hVar = b0Var.f8951b;
        return hVar != null && hVar.f9047a.equals(hVarC.f9047a) && hVar.f9055i == hVarC.f9055i && u0.c(hVar.f9051e, hVarC.f9051e);
    }

    @Override // androidx.media3.exoplayer.source.a
    public void z(@Nullable c4.o oVar) {
        this.f11287q = oVar;
        this.f11280j.a((Looper) z3.a.e(Looper.myLooper()), x());
        this.f11280j.prepare();
        D();
    }
}
