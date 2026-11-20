package m5;

import androidx.media3.common.y;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import u4.l0;
import u4.m0;
import u4.r0;
import u4.t;
import u4.u;
import z3.c0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r0 f70834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u f70835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f70836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f70837e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f70838f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f70839g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f70840h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f70841i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f70843k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f70844l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f70845m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f70833a = new e();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f70842j = new b();

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public y f70846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g f70847b;
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements g {
        public c() {
        }

        @Override // m5.g
        public long a(t tVar) {
            return -1L;
        }

        @Override // m5.g
        public m0 createSeekMap() {
            return new m0.b(C.TIME_UNSET);
        }

        @Override // m5.g
        public void startSeek(long j11) {
        }
    }

    public final void a() {
        z3.a.i(this.f70834b);
        u0.i(this.f70835c);
    }

    public long b(long j11) {
        return (j11 * 1000000) / ((long) this.f70841i);
    }

    public long c(long j11) {
        return (((long) this.f70841i) * j11) / 1000000;
    }

    public void d(u uVar, r0 r0Var) {
        this.f70835c = uVar;
        this.f70834b = r0Var;
        l(true);
    }

    public void e(long j11) {
        this.f70839g = j11;
    }

    public abstract long f(c0 c0Var);

    public final int g(t tVar, l0 l0Var) throws IOException {
        a();
        int i11 = this.f70840h;
        if (i11 == 0) {
            return j(tVar);
        }
        if (i11 == 1) {
            tVar.skipFully((int) this.f70838f);
            this.f70840h = 2;
            return 0;
        }
        if (i11 == 2) {
            u0.i(this.f70836d);
            return k(tVar, l0Var);
        }
        if (i11 == 3) {
            return -1;
        }
        throw new IllegalStateException();
    }

    public final boolean h(t tVar) throws IOException {
        while (this.f70833a.d(tVar)) {
            this.f70843k = tVar.getPosition() - this.f70838f;
            if (!i(this.f70833a.c(), this.f70838f, this.f70842j)) {
                return true;
            }
            this.f70838f = tVar.getPosition();
        }
        this.f70840h = 3;
        return false;
    }

    public abstract boolean i(c0 c0Var, long j11, b bVar) throws IOException;

    public final int j(t tVar) throws IOException {
        if (!h(tVar)) {
            return -1;
        }
        y yVar = this.f70842j.f70846a;
        this.f70841i = yVar.A;
        if (!this.f70845m) {
            this.f70834b.b(yVar);
            this.f70845m = true;
        }
        g gVar = this.f70842j.f70847b;
        if (gVar != null) {
            this.f70836d = gVar;
        } else if (tVar.getLength() == -1) {
            this.f70836d = new c();
        } else {
            f fVarB = this.f70833a.b();
            this.f70836d = new m5.a(this, this.f70838f, tVar.getLength(), fVarB.f70826h + fVarB.f70827i, fVarB.f70821c, (fVarB.f70820b & 4) != 0);
        }
        this.f70840h = 2;
        this.f70833a.f();
        return 0;
    }

    public final int k(t tVar, l0 l0Var) throws IOException {
        long jA = this.f70836d.a(tVar);
        if (jA >= 0) {
            l0Var.f78322a = jA;
            return 1;
        }
        if (jA < -1) {
            e(-(jA + 2));
        }
        if (!this.f70844l) {
            this.f70835c.f((m0) z3.a.i(this.f70836d.createSeekMap()));
            this.f70844l = true;
        }
        if (this.f70843k <= 0 && !this.f70833a.d(tVar)) {
            this.f70840h = 3;
            return -1;
        }
        this.f70843k = 0L;
        c0 c0VarC = this.f70833a.c();
        long jF = f(c0VarC);
        if (jF >= 0) {
            long j11 = this.f70839g;
            if (j11 + jF >= this.f70837e) {
                long jB = b(j11);
                this.f70834b.c(c0VarC, c0VarC.g());
                this.f70834b.f(jB, 1, c0VarC.g(), 0, null);
                this.f70837e = -1L;
            }
        }
        this.f70839g += jF;
        return 0;
    }

    public void l(boolean z11) {
        if (z11) {
            this.f70842j = new b();
            this.f70838f = 0L;
            this.f70840h = 0;
        } else {
            this.f70840h = 1;
        }
        this.f70837e = -1L;
        this.f70839g = 0L;
    }

    public final void m(long j11, long j12) {
        this.f70833a.e();
        if (j11 == 0) {
            l(!this.f70844l);
        } else if (this.f70840h != 0) {
            this.f70837e = c(j12);
            ((g) u0.i(this.f70836d)).startSeek(this.f70837e);
            this.f70840h = 2;
        }
    }
}
