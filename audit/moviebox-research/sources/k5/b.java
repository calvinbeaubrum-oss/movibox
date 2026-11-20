package k5;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.math.RoundingMode;
import u4.m0;
import u4.n0;
import z3.p;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f68243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f68244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f68245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f68246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f68247e;

    public b(long j11, long j12, long j13) {
        this.f68247e = j11;
        this.f68243a = j13;
        p pVar = new p();
        this.f68244b = pVar;
        p pVar2 = new p();
        this.f68245c = pVar2;
        pVar.a(0L);
        pVar2.a(j12);
        int i11 = -2147483647;
        if (j11 == C.TIME_UNSET) {
            this.f68246d = -2147483647;
            return;
        }
        long jH1 = u0.h1(j12 - j13, 8L, j11, RoundingMode.HALF_UP);
        if (jH1 > 0 && jH1 <= 2147483647L) {
            i11 = (int) jH1;
        }
        this.f68246d = i11;
    }

    @Override // k5.g
    public long a() {
        return this.f68243a;
    }

    public boolean b(long j11) {
        p pVar = this.f68244b;
        return j11 - pVar.b(pVar.c() - 1) < 100000;
    }

    public void c(long j11, long j12) {
        if (b(j11)) {
            return;
        }
        this.f68244b.a(j11);
        this.f68245c.a(j12);
    }

    public void d(long j11) {
        this.f68247e = j11;
    }

    @Override // k5.g
    public int e() {
        return this.f68246d;
    }

    @Override // u4.m0
    public long getDurationUs() {
        return this.f68247e;
    }

    @Override // u4.m0
    public m0.a getSeekPoints(long j11) {
        int iF = u0.f(this.f68244b, j11, true, true);
        n0 n0Var = new n0(this.f68244b.b(iF), this.f68245c.b(iF));
        if (n0Var.f78353a == j11 || iF == this.f68244b.c() - 1) {
            return new m0.a(n0Var);
        }
        int i11 = iF + 1;
        return new m0.a(n0Var, new n0(this.f68244b.b(i11), this.f68245c.b(i11)));
    }

    @Override // k5.g
    public long getTimeUs(long j11) {
        return this.f68244b.b(u0.f(this.f68245c, j11, true, true));
    }

    @Override // u4.m0
    public boolean isSeekable() {
        return true;
    }
}
