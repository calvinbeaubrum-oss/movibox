package ah;

import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.t;
import tg.b0;
import tg.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f499d;

    public b(long j11, long j12, long j13) {
        this.f499d = j11;
        this.f496a = j13;
        t tVar = new t();
        this.f497b = tVar;
        t tVar2 = new t();
        this.f498c = tVar2;
        tVar.a(0L);
        tVar2.a(j12);
    }

    @Override // ah.g
    public long a() {
        return this.f496a;
    }

    public boolean b(long j11) {
        t tVar = this.f497b;
        return j11 - tVar.b(tVar.c() - 1) < 100000;
    }

    public void c(long j11, long j12) {
        if (b(j11)) {
            return;
        }
        this.f497b.a(j11);
        this.f498c.a(j12);
    }

    public void d(long j11) {
        this.f499d = j11;
    }

    @Override // tg.b0
    public long getDurationUs() {
        return this.f499d;
    }

    @Override // tg.b0
    public b0.a getSeekPoints(long j11) {
        int iF = o0.f(this.f497b, j11, true, true);
        c0 c0Var = new c0(this.f497b.b(iF), this.f498c.b(iF));
        if (c0Var.f76996a == j11 || iF == this.f497b.c() - 1) {
            return new b0.a(c0Var);
        }
        int i11 = iF + 1;
        return new b0.a(c0Var, new c0(this.f497b.b(i11), this.f498c.b(i11)));
    }

    @Override // ah.g
    public long getTimeUs(long j11) {
        return this.f497b.b(o0.f(this.f498c, j11, true, true));
    }

    @Override // tg.b0
    public boolean isSeekable() {
        return true;
    }
}
