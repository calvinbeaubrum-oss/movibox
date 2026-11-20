package com.cloud.hisavana.net.disklrucache.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class DiskCacheProvider implements IDiskCache.Provider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile IDiskCache f29005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile IDiskCache f29006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile IDiskCache f29007c;

    public final IDiskCache a(long j11) {
        if (this.f29007c == null) {
            synchronized (this) {
                try {
                    if (this.f29007c == null) {
                        this.f29007c = new DiskLruCacheFactory(j11, 4).a();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this.f29007c;
    }

    public IDiskCache b(long j11, int i11) {
        if (i11 != 3) {
            return i11 != 4 ? c(j11) : a(j11);
        }
        return d(j11);
    }

    public final IDiskCache c(long j11) {
        if (this.f29005a == null) {
            synchronized (this) {
                try {
                    if (this.f29005a == null) {
                        this.f29005a = new DiskLruCacheFactory(j11, 1).a();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this.f29005a;
    }

    public final IDiskCache d(long j11) {
        if (this.f29006b == null) {
            synchronized (this) {
                try {
                    if (this.f29006b == null) {
                        this.f29006b = new DiskLruCacheFactory(j11, 3).a();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this.f29006b;
    }
}
