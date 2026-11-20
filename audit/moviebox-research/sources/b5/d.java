package b5;

import u4.d0;
import u4.t;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends d0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f14026b;

    public d(t tVar, long j11) {
        super(tVar);
        z3.a.a(tVar.getPosition() >= j11);
        this.f14026b = j11;
    }

    @Override // u4.d0, u4.t
    public long getLength() {
        return super.getLength() - this.f14026b;
    }

    @Override // u4.d0, u4.t
    public long getPeekPosition() {
        return super.getPeekPosition() - this.f14026b;
    }

    @Override // u4.d0, u4.t
    public long getPosition() {
        return super.getPosition() - this.f14026b;
    }
}
