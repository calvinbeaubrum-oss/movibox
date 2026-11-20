package k5;

import u4.j0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends u4.i implements g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f68242h;

    public a(long j11, long j12, j0.a aVar, boolean z11) {
        super(j11, j12, aVar.f78320f, aVar.f78317c, z11);
        this.f68242h = aVar.f78320f;
    }

    @Override // k5.g
    public long a() {
        return -1L;
    }

    @Override // k5.g
    public int e() {
        return this.f68242h;
    }

    @Override // k5.g
    public long getTimeUs(long j11) {
        return c(j11);
    }
}
