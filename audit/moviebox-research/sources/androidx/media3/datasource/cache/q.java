package androidx.media3.datasource.cache;

import java.util.Comparator;
import java.util.TreeSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f9728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TreeSet<h> f9729b = new TreeSet<>(new Comparator() { // from class: androidx.media3.datasource.cache.p
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return q.g((h) obj, (h) obj2);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f9730c;

    public q(long j11) {
        this.f9728a = j11;
    }

    public static int g(h hVar, h hVar2) {
        long j11 = hVar.f9687g;
        long j12 = hVar2.f9687g;
        if (j11 - j12 == 0) {
            return hVar.compareTo(hVar2);
        }
        return j11 < j12 ? -1 : 1;
    }

    @Override // androidx.media3.datasource.cache.b
    public boolean a() {
        return true;
    }

    @Override // androidx.media3.datasource.cache.Cache.a
    public void b(Cache cache, h hVar, h hVar2) {
        e(cache, hVar);
        c(cache, hVar2);
    }

    @Override // androidx.media3.datasource.cache.Cache.a
    public void c(Cache cache, h hVar) {
        this.f9729b.add(hVar);
        this.f9730c += hVar.f9684c;
        h(cache, 0L);
    }

    @Override // androidx.media3.datasource.cache.b
    public void d(Cache cache, String str, long j11, long j12) {
        if (j12 != -1) {
            h(cache, j12);
        }
    }

    @Override // androidx.media3.datasource.cache.Cache.a
    public void e(Cache cache, h hVar) {
        this.f9729b.remove(hVar);
        this.f9730c -= hVar.f9684c;
    }

    public final void h(Cache cache, long j11) {
        while (this.f9730c + j11 > this.f9728a && !this.f9729b.isEmpty()) {
            cache.f(this.f9729b.first());
        }
    }

    @Override // androidx.media3.datasource.cache.b
    public void onCacheInitialized() {
    }
}
