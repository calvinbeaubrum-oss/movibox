package com.google.android.exoplayer2.source;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.j3;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.upstream.v;
import com.google.android.exoplayer2.upstream.z;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import nh.f0;
import sg.u;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class n extends com.google.android.exoplayer2.source.a implements m.b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final u1 f34302i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final u1.h f34303j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.k.a f34304k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final l.a f34305l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.c f34306m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final z f34307n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f34308o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f34309p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f34310q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f34311r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f34312s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    public k0 f34313t;

    /* JADX INFO: compiled from: source.java */
    public class a extends nh.m {
        public a(n nVar, j3 j3Var) {
            super(j3Var);
        }

        @Override // nh.m, com.google.android.exoplayer2.j3
        public j3.b k(int i11, j3.b bVar, boolean z11) {
            super.k(i11, bVar, z11);
            bVar.f33367g = true;
            return bVar;
        }

        @Override // nh.m, com.google.android.exoplayer2.j3
        public j3.d s(int i11, j3.d dVar, long j11) {
            super.s(i11, dVar, j11);
            dVar.f33388m = true;
            return dVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.upstream.k.a f34314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public l.a f34315b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public u f34316c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public z f34317d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f34318e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public String f34319f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public Object f34320g;

        public b(com.google.android.exoplayer2.upstream.k.a aVar) {
            this(aVar, new tg.i());
        }

        public b(com.google.android.exoplayer2.upstream.k.a aVar, l.a aVar2) {
            this(aVar, aVar2, new com.google.android.exoplayer2.drm.a(), new v(), 1048576);
        }

        public b(com.google.android.exoplayer2.upstream.k.a aVar, l.a aVar2, u uVar, z zVar, int i11) {
            this.f34314a = aVar;
            this.f34315b = aVar2;
            this.f34316c = uVar;
            this.f34317d = zVar;
            this.f34318e = i11;
        }

        public b(com.google.android.exoplayer2.upstream.k.a aVar, final tg.r rVar) {
            this(aVar, new l.a() { // from class: nh.b0
                @Override // com.google.android.exoplayer2.source.l.a
                public final com.google.android.exoplayer2.source.l a(qg.u1 u1Var) {
                    return com.google.android.exoplayer2.source.n.b.f(rVar, u1Var);
                }
            });
        }

        public static /* synthetic */ l f(tg.r rVar, qg.u1 u1Var) {
            return new nh.a(rVar);
        }

        @Override // com.google.android.exoplayer2.source.i.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public n a(u1 u1Var) {
            com.google.android.exoplayer2.util.a.e(u1Var.f34776b);
            u1.h hVar = u1Var.f34776b;
            boolean z11 = false;
            boolean z12 = hVar.f34846h == null && this.f34320g != null;
            if (hVar.f34843e == null && this.f34319f != null) {
                z11 = true;
            }
            if (z12 && z11) {
                u1Var = u1Var.b().h(this.f34320g).b(this.f34319f).a();
            } else if (z12) {
                u1Var = u1Var.b().h(this.f34320g).a();
            } else if (z11) {
                u1Var = u1Var.b().b(this.f34319f).a();
            }
            u1 u1Var2 = u1Var;
            return new n(u1Var2, this.f34314a, this.f34315b, this.f34316c.a(u1Var2), this.f34317d, this.f34318e, null);
        }

        @Override // com.google.android.exoplayer2.source.i.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public b b(u uVar) {
            this.f34316c = (u) com.google.android.exoplayer2.util.a.f(uVar, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // com.google.android.exoplayer2.source.i.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public b c(z zVar) {
            this.f34317d = (z) com.google.android.exoplayer2.util.a.f(zVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }
    }

    public n(u1 u1Var, com.google.android.exoplayer2.upstream.k.a aVar, l.a aVar2, com.google.android.exoplayer2.drm.c cVar, z zVar, int i11) {
        this.f34303j = (u1.h) com.google.android.exoplayer2.util.a.e(u1Var.f34776b);
        this.f34302i = u1Var;
        this.f34304k = aVar;
        this.f34305l = aVar2;
        this.f34306m = cVar;
        this.f34307n = zVar;
        this.f34308o = i11;
        this.f34309p = true;
        this.f34310q = C.TIME_UNSET;
    }

    public /* synthetic */ n(u1 u1Var, com.google.android.exoplayer2.upstream.k.a aVar, l.a aVar2, com.google.android.exoplayer2.drm.c cVar, z zVar, int i11, a aVar3) {
        this(u1Var, aVar, aVar2, cVar, zVar, i11);
    }

    @Override // com.google.android.exoplayer2.source.a
    public void B(@Nullable k0 k0Var) {
        this.f34313t = k0Var;
        this.f34306m.prepare();
        this.f34306m.b((Looper) com.google.android.exoplayer2.util.a.e(Looper.myLooper()), z());
        E();
    }

    @Override // com.google.android.exoplayer2.source.a
    public void D() {
        this.f34306m.release();
    }

    public final void E() {
        j3 f0Var = new f0(this.f34310q, this.f34311r, false, this.f34312s, null, this.f34302i);
        if (this.f34309p) {
            f0Var = new a(this, f0Var);
        }
        C(f0Var);
    }

    @Override // com.google.android.exoplayer2.source.i
    public u1 a() {
        return this.f34302i;
    }

    @Override // com.google.android.exoplayer2.source.m.b
    public void b(long j11, boolean z11, boolean z12) {
        if (j11 == C.TIME_UNSET) {
            j11 = this.f34310q;
        }
        if (!this.f34309p && this.f34310q == j11 && this.f34311r == z11 && this.f34312s == z12) {
            return;
        }
        this.f34310q = j11;
        this.f34311r = z11;
        this.f34312s = z12;
        this.f34309p = false;
        E();
    }

    @Override // com.google.android.exoplayer2.source.i
    public h e(i.b bVar, com.google.android.exoplayer2.upstream.b bVar2, long j11) {
        com.google.android.exoplayer2.upstream.k kVarCreateDataSource = this.f34304k.createDataSource();
        k0 k0Var = this.f34313t;
        if (k0Var != null) {
            kVarCreateDataSource.e(k0Var);
        }
        return new m(this.f34303j.f34839a, kVarCreateDataSource, this.f34305l.a(z()), this.f34306m, t(bVar), this.f34307n, v(bVar), this, bVar2, this.f34303j.f34843e, this.f34308o);
    }

    @Override // com.google.android.exoplayer2.source.i
    public void k(h hVar) {
        ((m) hVar).S();
    }

    @Override // com.google.android.exoplayer2.source.i
    public void maybeThrowSourceInfoRefreshError() {
    }
}
