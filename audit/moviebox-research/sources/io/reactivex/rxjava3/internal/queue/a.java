package io.reactivex.rxjava3.internal.queue;

import io.reactivex.rxjava3.internal.util.g;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import m10.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a<T> implements f<T> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f67461j = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object f67462k = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f67464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f67465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f67466d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AtomicReferenceArray<Object> f67467f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f67468g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AtomicReferenceArray<Object> f67469h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f67463a = new AtomicLong();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicLong f67470i = new AtomicLong();

    public a(int i11) {
        int iA = g.a(Math.max(8, i11));
        int i12 = iA - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(iA + 1);
        this.f67467f = atomicReferenceArray;
        this.f67466d = i12;
        a(iA);
        this.f67469h = atomicReferenceArray;
        this.f67468g = i12;
        this.f67465c = iA - 2;
        o(0L);
    }

    public static int b(int i11) {
        return i11;
    }

    public static int c(long j11, int i11) {
        return b(((int) j11) & i11);
    }

    public static Object g(AtomicReferenceArray<Object> atomicReferenceArray, int i11) {
        return atomicReferenceArray.get(i11);
    }

    private void l(long j11) {
        this.f67470i.lazySet(j11);
    }

    public static void m(AtomicReferenceArray<Object> atomicReferenceArray, int i11, Object obj) {
        atomicReferenceArray.lazySet(i11, obj);
    }

    private void o(long j11) {
        this.f67463a.lazySet(j11);
    }

    public final void a(int i11) {
        this.f67464b = Math.min(i11 / 4, f67461j);
    }

    @Override // m10.g
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public final long d() {
        return this.f67470i.get();
    }

    public final long e() {
        return this.f67463a.get();
    }

    public final long f() {
        return this.f67470i.get();
    }

    public final AtomicReferenceArray<Object> h(AtomicReferenceArray<Object> atomicReferenceArray, int i11) {
        int iB = b(i11);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) g(atomicReferenceArray, iB);
        m(atomicReferenceArray, iB, null);
        return atomicReferenceArray2;
    }

    public final long i() {
        return this.f67463a.get();
    }

    @Override // m10.g
    public boolean isEmpty() {
        return i() == f();
    }

    public final T j(AtomicReferenceArray<Object> atomicReferenceArray, long j11, int i11) {
        this.f67469h = atomicReferenceArray;
        int iC = c(j11, i11);
        T t11 = (T) g(atomicReferenceArray, iC);
        if (t11 != null) {
            m(atomicReferenceArray, iC, null);
            l(j11 + 1);
        }
        return t11;
    }

    public final void k(AtomicReferenceArray<Object> atomicReferenceArray, long j11, int i11, T t11, long j12) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f67467f = atomicReferenceArray2;
        this.f67465c = (j12 + j11) - 1;
        m(atomicReferenceArray2, i11, t11);
        n(atomicReferenceArray, atomicReferenceArray2);
        m(atomicReferenceArray, i11, f67462k);
        o(j11 + 1);
    }

    public final void n(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        m(atomicReferenceArray, b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    @Override // m10.g
    public boolean offer(T t11) {
        if (t11 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.f67467f;
        long jE = e();
        int i11 = this.f67466d;
        int iC = c(jE, i11);
        if (jE < this.f67465c) {
            return p(atomicReferenceArray, t11, jE, iC);
        }
        long j11 = ((long) this.f67464b) + jE;
        if (g(atomicReferenceArray, c(j11, i11)) == null) {
            this.f67465c = j11 - 1;
            return p(atomicReferenceArray, t11, jE, iC);
        }
        if (g(atomicReferenceArray, c(1 + jE, i11)) == null) {
            return p(atomicReferenceArray, t11, jE, iC);
        }
        k(atomicReferenceArray, jE, iC, t11, i11);
        return true;
    }

    public final boolean p(AtomicReferenceArray<Object> atomicReferenceArray, T t11, long j11, int i11) {
        m(atomicReferenceArray, i11, t11);
        o(j11 + 1);
        return true;
    }

    @Override // m10.f, m10.g
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f67469h;
        long jD = d();
        int i11 = this.f67468g;
        int iC = c(jD, i11);
        T t11 = (T) g(atomicReferenceArray, iC);
        boolean z11 = t11 == f67462k;
        if (t11 == null || z11) {
            if (z11) {
                return j(h(atomicReferenceArray, i11 + 1), jD, i11);
            }
            return null;
        }
        m(atomicReferenceArray, iC, null);
        l(jD + 1);
        return t11;
    }
}
