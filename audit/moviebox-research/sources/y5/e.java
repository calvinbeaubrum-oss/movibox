package y5;

import u4.m0;
import u4.n0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f81222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f81223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f81224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f81225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f81226e;

    public e(c cVar, int i11, long j11, long j12) {
        this.f81222a = cVar;
        this.f81223b = i11;
        this.f81224c = j11;
        long j13 = (j12 - j11) / ((long) cVar.f81217e);
        this.f81225d = j13;
        this.f81226e = b(j13);
    }

    public final long b(long j11) {
        return u0.f1(j11 * ((long) this.f81223b), 1000000L, this.f81222a.f81215c);
    }

    @Override // u4.m0
    public long getDurationUs() {
        return this.f81226e;
    }

    @Override // u4.m0
    public m0.a getSeekPoints(long j11) {
        long jQ = u0.q((((long) this.f81222a.f81215c) * j11) / (((long) this.f81223b) * 1000000), 0L, this.f81225d - 1);
        long j12 = this.f81224c + (((long) this.f81222a.f81217e) * jQ);
        long jB = b(jQ);
        n0 n0Var = new n0(jB, j12);
        if (jB >= j11 || jQ == this.f81225d - 1) {
            return new m0.a(n0Var);
        }
        long j13 = jQ + 1;
        return new m0.a(n0Var, new n0(b(j13), this.f81224c + (((long) this.f81222a.f81217e) * j13)));
    }

    @Override // u4.m0
    public boolean isSeekable() {
        return true;
    }
}
