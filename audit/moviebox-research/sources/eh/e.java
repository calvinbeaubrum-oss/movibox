package eh;

import com.google.android.exoplayer2.util.o0;
import tg.b0;
import tg.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f64208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f64209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f64210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f64211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f64212e;

    public e(c cVar, int i11, long j11, long j12) {
        this.f64208a = cVar;
        this.f64209b = i11;
        this.f64210c = j11;
        long j13 = (j12 - j11) / ((long) cVar.f64203e);
        this.f64211d = j13;
        this.f64212e = b(j13);
    }

    public final long b(long j11) {
        return o0.O0(j11 * ((long) this.f64209b), 1000000L, this.f64208a.f64201c);
    }

    @Override // tg.b0
    public long getDurationUs() {
        return this.f64212e;
    }

    @Override // tg.b0
    public b0.a getSeekPoints(long j11) {
        long jR = o0.r((((long) this.f64208a.f64201c) * j11) / (((long) this.f64209b) * 1000000), 0L, this.f64211d - 1);
        long j12 = this.f64210c + (((long) this.f64208a.f64203e) * jR);
        long jB = b(jR);
        c0 c0Var = new c0(jB, j12);
        if (jB >= j11 || jR == this.f64211d - 1) {
            return new b0.a(c0Var);
        }
        long j13 = jR + 1;
        return new b0.a(c0Var, new c0(b(j13), this.f64210c + (((long) this.f64208a.f64203e) * j13)));
    }

    @Override // tg.b0
    public boolean isSeekable() {
        return true;
    }
}
