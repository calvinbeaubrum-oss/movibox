package u4;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p0 implements m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f78377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f78378b;

    public p0(long j11) {
        this(j11, 0L);
    }

    public p0(long j11, long j12) {
        this.f78377a = j11;
        this.f78378b = j12;
    }

    @Override // u4.m0
    public long getDurationUs() {
        return this.f78377a;
    }

    @Override // u4.m0
    public m0.a getSeekPoints(long j11) {
        return new m0.a(new n0(j11, this.f78378b));
    }

    @Override // u4.m0
    public boolean isSeekable() {
        return true;
    }
}
