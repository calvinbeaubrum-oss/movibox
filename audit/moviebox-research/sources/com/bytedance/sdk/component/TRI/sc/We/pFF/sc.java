package com.bytedance.sdk.component.TRI.sc.We.pFF;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc {
    private int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private int f26604sc;

    public sc(int i11, int i12, long j11) {
        if (i12 < i11) {
            throw new IllegalStateException("atMostBatchSendCount should meet a condition (atMostBatchSendCount >= maxCacheCount)");
        }
        this.f26604sc = i11;
        this.pFF = i12;
    }

    public static sc ExN() {
        return new sc(3, 100, 172800000L);
    }

    public static sc We() {
        return new sc(1, 100, -1L);
    }

    public static sc zY() {
        return new sc(1, 100, 172800000L);
    }

    public int pFF() {
        return this.pFF;
    }

    public int sc() {
        return this.f26604sc;
    }
}
