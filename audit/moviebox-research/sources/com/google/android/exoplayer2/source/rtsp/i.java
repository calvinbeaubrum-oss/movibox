package com.google.android.exoplayer2.source.rtsp;

import androidx.annotation.Nullable;
import java.util.Comparator;
import java.util.TreeSet;
import okhttp3.internal.http2.Settings;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TreeSet<a> f34540a = new TreeSet<>(new Comparator() { // from class: com.google.android.exoplayer2.source.rtsp.h
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return i.d((i.a) obj, (i.a) obj2);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f34541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f34542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f34543d;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f34544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f34545b;

        public a(g gVar, long j11) {
            this.f34544a = gVar;
            this.f34545b = j11;
        }
    }

    public i() {
        g();
    }

    public static int c(int i11, int i12) {
        int iMin;
        int i13 = i11 - i12;
        if (Math.abs(i13) <= 1000 || (iMin = (Math.min(i11, i12) - Math.max(i11, i12)) + Settings.DEFAULT_INITIAL_WINDOW_SIZE) >= 1000) {
            return i13;
        }
        return i11 < i12 ? iMin : -iMin;
    }

    public static /* synthetic */ int d(a aVar, a aVar2) {
        return c(aVar.f34544a.f34500g, aVar2.f34544a.f34500g);
    }

    public final synchronized void b(a aVar) {
        this.f34541b = aVar.f34544a.f34500g;
        this.f34540a.add(aVar);
    }

    public synchronized boolean e(g gVar, long j11) {
        if (this.f34540a.size() >= 5000) {
            throw new IllegalStateException("Queue size limit of 5000 reached.");
        }
        int i11 = gVar.f34500g;
        if (!this.f34543d) {
            g();
            this.f34542c = g.c(i11);
            this.f34543d = true;
            b(new a(gVar, j11));
            return true;
        }
        if (Math.abs(c(i11, g.b(this.f34541b))) < 1000) {
            if (c(i11, this.f34542c) <= 0) {
                return false;
            }
            b(new a(gVar, j11));
            return true;
        }
        this.f34542c = g.c(i11);
        this.f34540a.clear();
        b(new a(gVar, j11));
        return true;
    }

    @Nullable
    public synchronized g f(long j11) {
        if (this.f34540a.isEmpty()) {
            return null;
        }
        a aVarFirst = this.f34540a.first();
        int i11 = aVarFirst.f34544a.f34500g;
        if (i11 != g.b(this.f34542c) && j11 < aVarFirst.f34545b) {
            return null;
        }
        this.f34540a.pollFirst();
        this.f34542c = i11;
        return aVarFirst.f34544a;
    }

    public synchronized void g() {
        this.f34540a.clear();
        this.f34543d = false;
        this.f34542c = -1;
        this.f34541b = -1;
    }
}
