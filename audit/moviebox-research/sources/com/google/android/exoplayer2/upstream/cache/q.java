package com.google.android.exoplayer2.upstream.cache;

import java.util.Comparator;
import java.util.TreeSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class q implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f35368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TreeSet<h> f35369b = new TreeSet<>(new Comparator() { // from class: com.google.android.exoplayer2.upstream.cache.p
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return q.g((h) obj, (h) obj2);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f35370c;

    public q(long j11) {
        this.f35368a = j11;
    }

    public static int g(h hVar, h hVar2) {
        long j11 = hVar.f35327g;
        long j12 = hVar2.f35327g;
        if (j11 - j12 == 0) {
            return hVar.compareTo(hVar2);
        }
        return j11 < j12 ? -1 : 1;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.b
    public boolean a() {
        return true;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
    public void b(Cache cache, h hVar) {
        this.f35369b.add(hVar);
        this.f35370c += hVar.f35324c;
        h(cache, 0L);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.b
    public void c(Cache cache, String str, long j11, long j12) {
        if (j12 != -1) {
            h(cache, j12);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
    public void d(Cache cache, h hVar) {
        this.f35369b.remove(hVar);
        this.f35370c -= hVar.f35324c;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
    public void e(Cache cache, h hVar, h hVar2) {
        d(cache, hVar);
        b(cache, hVar2);
    }

    public final void h(Cache cache, long j11) {
        while (this.f35370c + j11 > this.f35368a && !this.f35369b.isEmpty()) {
            cache.h(this.f35369b.first());
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.b
    public void onCacheInitialized() {
    }
}
