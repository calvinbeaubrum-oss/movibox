package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class u2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f23500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f23501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f23502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f23503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f23504e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f23505f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Throwable f23506g;

    public Throwable a() {
        return this.f23506g;
    }

    public void a(int i11) {
        this.f23505f = i11;
    }

    public void a(long j11) {
        this.f23501b += j11;
    }

    public void a(Throwable th2) {
        this.f23506g = th2;
    }

    public int b() {
        return this.f23505f;
    }

    public void c() {
        this.f23504e++;
    }

    public void d() {
        this.f23503d++;
    }

    public void e() {
        this.f23502c = true;
    }

    public String toString() {
        return "CacheStatsTracker{totalDownloadedBytes=" + this.f23500a + ", totalCachedBytes=" + this.f23501b + ", isHTMLCachingCancelled=" + this.f23502c + ", htmlResourceCacheSuccessCount=" + this.f23503d + ", htmlResourceCacheFailureCount=" + this.f23504e + '}';
    }
}
