package yg;

import tg.m;
import tg.w;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f81341b;

    public c(m mVar, long j11) {
        super(mVar);
        com.google.android.exoplayer2.util.a.a(mVar.getPosition() >= j11);
        this.f81341b = j11;
    }

    @Override // tg.w, tg.m
    public long getLength() {
        return super.getLength() - this.f81341b;
    }

    @Override // tg.w, tg.m
    public long getPeekPosition() {
        return super.getPeekPosition() - this.f81341b;
    }

    @Override // tg.w, tg.m
    public long getPosition() {
        return super.getPosition() - this.f81341b;
    }
}
