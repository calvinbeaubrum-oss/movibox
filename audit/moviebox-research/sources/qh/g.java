package qh;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import rh.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class g implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tg.d f74786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f74787b;

    public g(tg.d dVar, long j11) {
        this.f74786a = dVar;
        this.f74787b = j11;
    }

    @Override // qh.e
    public long a(long j11, long j12) {
        return this.f74786a.f77001d[(int) j11];
    }

    @Override // qh.e
    public long b(long j11, long j12) {
        return 0L;
    }

    @Override // qh.e
    public long c(long j11, long j12) {
        return C.TIME_UNSET;
    }

    @Override // qh.e
    public i d(long j11) {
        tg.d dVar = this.f74786a;
        int i11 = (int) j11;
        return new i(null, dVar.f77000c[i11], dVar.f76999b[i11]);
    }

    @Override // qh.e
    public long e(long j11, long j12) {
        return this.f74786a.b(j11 + this.f74787b);
    }

    @Override // qh.e
    public long f(long j11) {
        return this.f74786a.f76998a;
    }

    @Override // qh.e
    public boolean g() {
        return true;
    }

    @Override // qh.e
    public long getTimeUs(long j11) {
        return this.f74786a.f77002e[(int) j11] - this.f74787b;
    }

    @Override // qh.e
    public long h() {
        return 0L;
    }

    @Override // qh.e
    public long i(long j11, long j12) {
        return this.f74786a.f76998a;
    }
}
