package ch;

import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import tg.a0;
import tg.b0;
import tg.e0;
import tg.m;
import tg.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e0 f14830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n f14831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f14832d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f14833e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f14834f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f14835g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14836h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f14837i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f14839k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f14840l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f14841m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f14829a = new e();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f14838j = new b();

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public m1 f14842a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g f14843b;
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements g {
        public c() {
        }

        @Override // ch.g
        public long a(m mVar) {
            return -1L;
        }

        @Override // ch.g
        public b0 createSeekMap() {
            return new b0.b(C.TIME_UNSET);
        }

        @Override // ch.g
        public void startSeek(long j11) {
        }
    }

    public final void a() {
        com.google.android.exoplayer2.util.a.i(this.f14830b);
        o0.j(this.f14831c);
    }

    public long b(long j11) {
        return (j11 * 1000000) / ((long) this.f14837i);
    }

    public long c(long j11) {
        return (((long) this.f14837i) * j11) / 1000000;
    }

    public void d(n nVar, e0 e0Var) {
        this.f14831c = nVar;
        this.f14830b = e0Var;
        l(true);
    }

    public void e(long j11) {
        this.f14835g = j11;
    }

    public abstract long f(c0 c0Var);

    public final int g(m mVar, a0 a0Var) throws IOException {
        a();
        int i11 = this.f14836h;
        if (i11 == 0) {
            return j(mVar);
        }
        if (i11 == 1) {
            mVar.skipFully((int) this.f14834f);
            this.f14836h = 2;
            return 0;
        }
        if (i11 == 2) {
            o0.j(this.f14832d);
            return k(mVar, a0Var);
        }
        if (i11 == 3) {
            return -1;
        }
        throw new IllegalStateException();
    }

    public abstract boolean h(c0 c0Var, long j11, b bVar) throws IOException;

    public final boolean i(m mVar) throws IOException {
        while (this.f14829a.d(mVar)) {
            this.f14839k = mVar.getPosition() - this.f14834f;
            if (!h(this.f14829a.c(), this.f14834f, this.f14838j)) {
                return true;
            }
            this.f14834f = mVar.getPosition();
        }
        this.f14836h = 3;
        return false;
    }

    public final int j(m mVar) throws IOException {
        if (!i(mVar)) {
            return -1;
        }
        m1 m1Var = this.f14838j.f14842a;
        this.f14837i = m1Var.A;
        if (!this.f14841m) {
            this.f14830b.e(m1Var);
            this.f14841m = true;
        }
        g gVar = this.f14838j.f14843b;
        if (gVar != null) {
            this.f14832d = gVar;
        } else if (mVar.getLength() == -1) {
            this.f14832d = new c();
        } else {
            f fVarB = this.f14829a.b();
            this.f14832d = new ch.a(this, this.f14834f, mVar.getLength(), fVarB.f14822h + fVarB.f14823i, fVarB.f14817c, (fVarB.f14816b & 4) != 0);
        }
        this.f14836h = 2;
        this.f14829a.f();
        return 0;
    }

    public final int k(m mVar, a0 a0Var) throws IOException {
        long jA = this.f14832d.a(mVar);
        if (jA >= 0) {
            a0Var.f76990a = jA;
            return 1;
        }
        if (jA < -1) {
            e(-(jA + 2));
        }
        if (!this.f14840l) {
            this.f14831c.g((b0) com.google.android.exoplayer2.util.a.i(this.f14832d.createSeekMap()));
            this.f14840l = true;
        }
        if (this.f14839k <= 0 && !this.f14829a.d(mVar)) {
            this.f14836h = 3;
            return -1;
        }
        this.f14839k = 0L;
        c0 c0VarC = this.f14829a.c();
        long jF = f(c0VarC);
        if (jF >= 0) {
            long j11 = this.f14835g;
            if (j11 + jF >= this.f14833e) {
                long jB = b(j11);
                this.f14830b.c(c0VarC, c0VarC.f());
                this.f14830b.d(jB, 1, c0VarC.f(), 0, null);
                this.f14833e = -1L;
            }
        }
        this.f14835g += jF;
        return 0;
    }

    public void l(boolean z11) {
        if (z11) {
            this.f14838j = new b();
            this.f14834f = 0L;
            this.f14836h = 0;
        } else {
            this.f14836h = 1;
        }
        this.f14833e = -1L;
        this.f14835g = 0L;
    }

    public final void m(long j11, long j12) {
        this.f14829a.e();
        if (j11 == 0) {
            l(!this.f14840l);
        } else if (this.f14836h != 0) {
            this.f14833e = c(j12);
            ((g) o0.j(this.f14832d)).startSeek(this.f14833e);
            this.f14836h = 2;
        }
    }
}
