package com.google.android.exoplayer2.source;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.j3;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class g extends c<Void> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final i f33937l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f33938m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final j3.d f33939n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final j3.b f33940o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public a f33941p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public f f33942q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f33943r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f33944s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f33945t;

    /* JADX INFO: compiled from: source.java */
    public static final class a extends nh.m {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final Object f33946g = new Object();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final Object f33947d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public final Object f33948f;

        public a(j3 j3Var, @Nullable Object obj, @Nullable Object obj2) {
            super(j3Var);
            this.f33947d = obj;
            this.f33948f = obj2;
        }

        public static a A(u1 u1Var) {
            return new a(new b(u1Var), j3.d.f33373s, f33946g);
        }

        public static a B(j3 j3Var, @Nullable Object obj, @Nullable Object obj2) {
            return new a(j3Var, obj, obj2);
        }

        @Override // nh.m, com.google.android.exoplayer2.j3
        public int f(Object obj) {
            Object obj2;
            j3 j3Var = this.f71944c;
            if (f33946g.equals(obj) && (obj2 = this.f33948f) != null) {
                obj = obj2;
            }
            return j3Var.f(obj);
        }

        @Override // nh.m, com.google.android.exoplayer2.j3
        public j3.b k(int i11, j3.b bVar, boolean z11) {
            this.f71944c.k(i11, bVar, z11);
            if (o0.c(bVar.f33363b, this.f33948f) && z11) {
                bVar.f33363b = f33946g;
            }
            return bVar;
        }

        @Override // nh.m, com.google.android.exoplayer2.j3
        public Object q(int i11) {
            Object objQ = this.f71944c.q(i11);
            return o0.c(objQ, this.f33948f) ? f33946g : objQ;
        }

        @Override // nh.m, com.google.android.exoplayer2.j3
        public j3.d s(int i11, j3.d dVar, long j11) {
            this.f71944c.s(i11, dVar, j11);
            if (o0.c(dVar.f33377a, this.f33947d)) {
                dVar.f33377a = j3.d.f33373s;
            }
            return dVar;
        }

        public a z(j3 j3Var) {
            return new a(j3Var, this.f33947d, this.f33948f);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends j3 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final u1 f33949c;

        public b(u1 u1Var) {
            this.f33949c = u1Var;
        }

        @Override // com.google.android.exoplayer2.j3
        public int f(Object obj) {
            return obj == a.f33946g ? 0 : -1;
        }

        @Override // com.google.android.exoplayer2.j3
        public j3.b k(int i11, j3.b bVar, boolean z11) {
            bVar.w(z11 ? 0 : null, z11 ? a.f33946g : null, 0, C.TIME_UNSET, 0L, oh.c.f72417h, true);
            return bVar;
        }

        @Override // com.google.android.exoplayer2.j3
        public int m() {
            return 1;
        }

        @Override // com.google.android.exoplayer2.j3
        public Object q(int i11) {
            return a.f33946g;
        }

        @Override // com.google.android.exoplayer2.j3
        public j3.d s(int i11, j3.d dVar, long j11) {
            dVar.k(j3.d.f33373s, this.f33949c, null, C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, false, true, null, 0L, C.TIME_UNSET, 0, 0, 0L);
            dVar.f33388m = true;
            return dVar;
        }

        @Override // com.google.android.exoplayer2.j3
        public int t() {
            return 1;
        }
    }

    public g(i iVar, boolean z11) {
        this.f33937l = iVar;
        this.f33938m = z11 && iVar.c();
        this.f33939n = new j3.d();
        this.f33940o = new j3.b();
        j3 j3VarD = iVar.d();
        if (j3VarD == null) {
            this.f33941p = a.A(iVar.a());
        } else {
            this.f33941p = a.B(j3VarD, null, null);
            this.f33945t = true;
        }
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public void B(@Nullable k0 k0Var) {
        super.B(k0Var);
        if (this.f33938m) {
            return;
        }
        this.f33943r = true;
        K(null, this.f33937l);
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public void D() {
        this.f33944s = false;
        this.f33943r = false;
        super.D();
    }

    @Override // com.google.android.exoplayer2.source.i
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public f e(i.b bVar, com.google.android.exoplayer2.upstream.b bVar2, long j11) {
        f fVar = new f(bVar, bVar2, j11);
        fVar.n(this.f33937l);
        if (this.f33944s) {
            fVar.b(bVar.c(N(bVar.f71960a)));
        } else {
            this.f33942q = fVar;
            if (!this.f33943r) {
                this.f33943r = true;
                K(null, this.f33937l);
            }
        }
        return fVar;
    }

    public final Object M(Object obj) {
        return (this.f33941p.f33948f == null || !this.f33941p.f33948f.equals(obj)) ? obj : a.f33946g;
    }

    public final Object N(Object obj) {
        return (this.f33941p.f33948f == null || !obj.equals(a.f33946g)) ? obj : this.f33941p.f33948f;
    }

    @Override // com.google.android.exoplayer2.source.c
    @Nullable
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public i.b F(Void r11, i.b bVar) {
        return bVar.c(M(bVar.f71960a));
    }

    public j3 P() {
        return this.f33941p;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0074  */
    /* JADX WARN: Code duplicated, block: B:30:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.exoplayer2.source.c
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void I(Void r13, i iVar, j3 j3Var) {
        long j11;
        i.b bVarC;
        if (this.f33944s) {
            this.f33941p = this.f33941p.z(j3Var);
            f fVar = this.f33942q;
            if (fVar != null) {
                R(fVar.c());
            }
        } else {
            if (!j3Var.u()) {
                j3Var.r(0, this.f33939n);
                long jF = this.f33939n.f();
                Object obj = this.f33939n.f33377a;
                f fVar2 = this.f33942q;
                if (fVar2 != null) {
                    long jI = fVar2.i();
                    this.f33941p.l(this.f33942q.f33928a.f71960a, this.f33940o);
                    long jQ = this.f33940o.q() + jI;
                    if (jQ != this.f33941p.r(0, this.f33939n).f()) {
                        j11 = jQ;
                    } else {
                        j11 = jF;
                    }
                } else {
                    j11 = jF;
                }
                Pair<Object, Long> pairN = j3Var.n(this.f33939n, this.f33940o, 0, j11);
                Object obj2 = pairN.first;
                long jLongValue = ((Long) pairN.second).longValue();
                this.f33941p = this.f33945t ? this.f33941p.z(j3Var) : a.B(j3Var, obj, obj2);
                f fVar3 = this.f33942q;
                if (fVar3 != null) {
                    R(jLongValue);
                    i.b bVar = fVar3.f33928a;
                    bVarC = bVar.c(N(bVar.f71960a));
                }
                this.f33945t = true;
                this.f33944s = true;
                C(this.f33941p);
                if (bVarC != null) {
                    ((f) com.google.android.exoplayer2.util.a.e(this.f33942q)).b(bVarC);
                }
            }
            this.f33941p = this.f33945t ? this.f33941p.z(j3Var) : a.B(j3Var, j3.d.f33373s, a.f33946g);
        }
        bVarC = null;
        this.f33945t = true;
        this.f33944s = true;
        C(this.f33941p);
        if (bVarC != null) {
            ((f) com.google.android.exoplayer2.util.a.e(this.f33942q)).b(bVarC);
        }
    }

    public final void R(long j11) {
        f fVar = this.f33942q;
        int iF = this.f33941p.f(fVar.f33928a.f71960a);
        if (iF == -1) {
            return;
        }
        long j12 = this.f33941p.j(iF, this.f33940o).f33365d;
        if (j12 != C.TIME_UNSET && j11 >= j12) {
            j11 = Math.max(0L, j12 - 1);
        }
        fVar.l(j11);
    }

    @Override // com.google.android.exoplayer2.source.i
    public u1 a() {
        return this.f33937l.a();
    }

    @Override // com.google.android.exoplayer2.source.i
    public void k(h hVar) {
        ((f) hVar).m();
        if (hVar == this.f33942q) {
            this.f33942q = null;
        }
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.i
    public void maybeThrowSourceInfoRefreshError() {
    }
}
