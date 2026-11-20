package com.google.android.exoplayer2.source.rtsp;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class j0 implements c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f34554a;

    public j0(long j11) {
        this.f34554a = j11;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.c.a
    public c a(int i11) {
        i0 i0Var = new i0(this.f34554a);
        i0Var.a(k.a(i11 * 2));
        return i0Var;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.c.a
    public /* synthetic */ c.a b() {
        return b.a(this);
    }
}
