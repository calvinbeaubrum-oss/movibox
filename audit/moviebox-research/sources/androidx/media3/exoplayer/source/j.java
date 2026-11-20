package androidx.media3.exoplayer.source;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.b0;
import androidx.media3.common.m0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import p4.i0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j extends x {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f11197m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final m0.c f11198n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final m0.b f11199o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public a f11200p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public i f11201q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f11202r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f11203s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f11204t;

    /* JADX INFO: compiled from: source.java */
    public static final class a extends p4.m {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final Object f11205i = new Object();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public final Object f11206g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public final Object f11207h;

        public a(m0 m0Var, @Nullable Object obj, @Nullable Object obj2) {
            super(m0Var);
            this.f11206g = obj;
            this.f11207h = obj2;
        }

        public static a u(b0 b0Var) {
            return new a(new b(b0Var), m0.c.f9300r, f11205i);
        }

        public static a v(m0 m0Var, @Nullable Object obj, @Nullable Object obj2) {
            return new a(m0Var, obj, obj2);
        }

        @Override // p4.m, androidx.media3.common.m0
        public int b(Object obj) {
            Object obj2;
            m0 m0Var = this.f73577f;
            if (f11205i.equals(obj) && (obj2 = this.f11207h) != null) {
                obj = obj2;
            }
            return m0Var.b(obj);
        }

        @Override // p4.m, androidx.media3.common.m0
        public m0.b g(int i11, m0.b bVar, boolean z11) {
            this.f73577f.g(i11, bVar, z11);
            if (u0.c(bVar.f9294b, this.f11207h) && z11) {
                bVar.f9294b = f11205i;
            }
            return bVar;
        }

        @Override // p4.m, androidx.media3.common.m0
        public Object m(int i11) {
            Object objM = this.f73577f.m(i11);
            return u0.c(objM, this.f11207h) ? f11205i : objM;
        }

        @Override // p4.m, androidx.media3.common.m0
        public m0.c o(int i11, m0.c cVar, long j11) {
            this.f73577f.o(i11, cVar, j11);
            if (u0.c(cVar.f9309a, this.f11206g)) {
                cVar.f9309a = m0.c.f9300r;
            }
            return cVar;
        }

        public a t(m0 m0Var) {
            return new a(m0Var, this.f11206g, this.f11207h);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends m0 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final b0 f11208f;

        public b(b0 b0Var) {
            this.f11208f = b0Var;
        }

        @Override // androidx.media3.common.m0
        public int b(Object obj) {
            return obj == a.f11205i ? 0 : -1;
        }

        @Override // androidx.media3.common.m0
        public m0.b g(int i11, m0.b bVar, boolean z11) {
            bVar.u(z11 ? 0 : null, z11 ? a.f11205i : null, 0, C.TIME_UNSET, 0L, androidx.media3.common.c.f9089g, true);
            return bVar;
        }

        @Override // androidx.media3.common.m0
        public int i() {
            return 1;
        }

        @Override // androidx.media3.common.m0
        public Object m(int i11) {
            return a.f11205i;
        }

        @Override // androidx.media3.common.m0
        public m0.c o(int i11, m0.c cVar, long j11) {
            cVar.g(m0.c.f9300r, this.f11208f, null, C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, false, true, null, 0L, C.TIME_UNSET, 0, 0, 0L);
            cVar.f9320l = true;
            return cVar;
        }

        @Override // androidx.media3.common.m0
        public int p() {
            return 1;
        }
    }

    public j(l lVar, boolean z11) {
        super(lVar);
        this.f11197m = z11 && lVar.c();
        this.f11198n = new m0.c();
        this.f11199o = new m0.b();
        m0 m0VarD = lVar.d();
        if (m0VarD == null) {
            this.f11200p = a.u(lVar.a());
        } else {
            this.f11200p = a.v(m0VarD, null, null);
            this.f11204t = true;
        }
    }

    @Override // androidx.media3.exoplayer.source.c, androidx.media3.exoplayer.source.a
    public void B() {
        this.f11203s = false;
        this.f11202r = false;
        super.B();
    }

    @Override // androidx.media3.exoplayer.source.x
    @Nullable
    public l.b J(l.b bVar) {
        return bVar.a(U(bVar.f11209a));
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0074  */
    /* JADX WARN: Code duplicated, block: B:30:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // androidx.media3.exoplayer.source.x
    public void P(m0 m0Var) {
        long j11;
        l.b bVarA;
        if (this.f11203s) {
            this.f11200p = this.f11200p.t(m0Var);
            i iVar = this.f11201q;
            if (iVar != null) {
                X(iVar.i());
            }
        } else {
            if (!m0Var.q()) {
                m0Var.n(0, this.f11198n);
                long jC = this.f11198n.c();
                Object obj = this.f11198n.f9309a;
                i iVar2 = this.f11201q;
                if (iVar2 != null) {
                    long j12 = iVar2.j();
                    this.f11200p.h(this.f11201q.f11188a.f11209a, this.f11199o);
                    long jO = this.f11199o.o() + j12;
                    if (jO != this.f11200p.n(0, this.f11198n).c()) {
                        j11 = jO;
                    } else {
                        j11 = jC;
                    }
                } else {
                    j11 = jC;
                }
                Pair<Object, Long> pairJ = m0Var.j(this.f11198n, this.f11199o, 0, j11);
                Object obj2 = pairJ.first;
                long jLongValue = ((Long) pairJ.second).longValue();
                this.f11200p = this.f11204t ? this.f11200p.t(m0Var) : a.v(m0Var, obj, obj2);
                i iVar3 = this.f11201q;
                if (iVar3 != null) {
                    X(jLongValue);
                    l.b bVar = iVar3.f11188a;
                    bVarA = bVar.a(V(bVar.f11209a));
                }
                this.f11204t = true;
                this.f11203s = true;
                A(this.f11200p);
                if (bVarA != null) {
                    ((i) z3.a.e(this.f11201q)).c(bVarA);
                }
            }
            this.f11200p = this.f11204t ? this.f11200p.t(m0Var) : a.v(m0Var, m0.c.f9300r, a.f11205i);
        }
        bVarA = null;
        this.f11204t = true;
        this.f11203s = true;
        A(this.f11200p);
        if (bVarA != null) {
            ((i) z3.a.e(this.f11201q)).c(bVarA);
        }
    }

    @Override // androidx.media3.exoplayer.source.x
    public void S() {
        if (this.f11197m) {
            return;
        }
        this.f11202r = true;
        R();
    }

    @Override // androidx.media3.exoplayer.source.l
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public i h(l.b bVar, androidx.media3.exoplayer.upstream.b bVar2, long j11) {
        i iVar = new i(bVar, bVar2, j11);
        iVar.o(this.f11378k);
        if (this.f11203s) {
            iVar.c(bVar.a(V(bVar.f11209a)));
        } else {
            this.f11201q = iVar;
            if (!this.f11202r) {
                this.f11202r = true;
                R();
            }
        }
        return iVar;
    }

    public final Object U(Object obj) {
        return (this.f11200p.f11207h == null || !this.f11200p.f11207h.equals(obj)) ? obj : a.f11205i;
    }

    public final Object V(Object obj) {
        return (this.f11200p.f11207h == null || !obj.equals(a.f11205i)) ? obj : this.f11200p.f11207h;
    }

    public m0 W() {
        return this.f11200p;
    }

    public final void X(long j11) {
        i iVar = this.f11201q;
        int iB = this.f11200p.b(iVar.f11188a.f11209a);
        if (iB == -1) {
            return;
        }
        long j12 = this.f11200p.f(iB, this.f11199o).f9296d;
        if (j12 != C.TIME_UNSET && j11 >= j12) {
            j11 = Math.max(0L, j12 - 1);
        }
        iVar.m(j11);
    }

    @Override // androidx.media3.exoplayer.source.l
    public void l(k kVar) {
        ((i) kVar).n();
        if (kVar == this.f11201q) {
            this.f11201q = null;
        }
    }

    @Override // androidx.media3.exoplayer.source.c, androidx.media3.exoplayer.source.l
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // androidx.media3.exoplayer.source.x, androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.l
    public void n(b0 b0Var) {
        if (this.f11204t) {
            this.f11200p = this.f11200p.t(new i0(this.f11200p.f73577f, b0Var));
        } else {
            this.f11200p = a.u(b0Var);
        }
        this.f11378k.n(b0Var);
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.l
    public boolean q(b0 b0Var) {
        return this.f11378k.q(b0Var);
    }
}
