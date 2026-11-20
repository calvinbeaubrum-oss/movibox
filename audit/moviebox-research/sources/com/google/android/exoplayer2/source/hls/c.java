package com.google.android.exoplayer2.source.hls;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.k.a f33984a;

    public c(com.google.android.exoplayer2.upstream.k.a aVar) {
        this.f33984a = aVar;
    }

    @Override // com.google.android.exoplayer2.source.hls.f
    public com.google.android.exoplayer2.upstream.k a(int i11) {
        return this.f33984a.createDataSource();
    }
}
