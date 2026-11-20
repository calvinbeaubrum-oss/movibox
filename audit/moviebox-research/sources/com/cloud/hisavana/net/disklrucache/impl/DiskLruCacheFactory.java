package com.cloud.hisavana.net.disklrucache.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class DiskLruCacheFactory implements IDiskCache.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f29008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f29009b;

    public DiskLruCacheFactory(long j11, int i11) {
        this.f29008a = j11;
        this.f29009b = i11;
    }

    public IDiskCache a() {
        return new DiskCacheImpl(null, this.f29008a, this.f29009b);
    }
}
