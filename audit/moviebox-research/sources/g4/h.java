package g4;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u4.h f65394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f65395b;

    public h(u4.h hVar, long j11) {
        this.f65394a = hVar;
        this.f65395b = j11;
    }

    @Override // g4.f
    public long a(long j11, long j12) {
        return this.f65394a.f78286d[(int) j11];
    }

    @Override // g4.f
    public long b(long j11, long j12) {
        return 0L;
    }

    @Override // g4.f
    public long c(long j11, long j12) {
        return C.TIME_UNSET;
    }

    @Override // g4.f
    public h4.i d(long j11) {
        u4.h hVar = this.f65394a;
        int i11 = (int) j11;
        return new h4.i(null, hVar.f78285c[i11], hVar.f78284b[i11]);
    }

    @Override // g4.f
    public long e(long j11, long j12) {
        return this.f65394a.b(j11 + this.f65395b);
    }

    @Override // g4.f
    public long f(long j11) {
        return this.f65394a.f78283a;
    }

    @Override // g4.f
    public boolean g() {
        return true;
    }

    @Override // g4.f
    public long getTimeUs(long j11) {
        return this.f65394a.f78287e[(int) j11] - this.f65395b;
    }

    @Override // g4.f
    public long h() {
        return 0L;
    }

    @Override // g4.f
    public long i(long j11, long j12) {
        return this.f65394a.f78283a;
    }
}
