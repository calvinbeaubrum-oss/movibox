package com.applovin.impl;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class eo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long[] f18757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object[] f18758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f18759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f18760d;

    public eo() {
        this(10);
    }

    public eo(int i11) {
        this.f18757a = new long[i11];
        this.f18758b = a(i11);
    }

    private Object a(long j11, boolean z11) {
        Object objD = null;
        long j12 = Long.MAX_VALUE;
        while (this.f18760d > 0) {
            long j13 = j11 - this.f18757a[this.f18759c];
            if (j13 < 0 && (z11 || (-j13) >= j12)) {
                break;
            }
            objD = d();
            j12 = j13;
        }
        return objD;
    }

    private void a(long j11) {
        int i11 = this.f18760d;
        if (i11 > 0) {
            if (j11 <= this.f18757a[((this.f18759c + i11) - 1) % this.f18758b.length]) {
                a();
            }
        }
    }

    private static Object[] a(int i11) {
        return new Object[i11];
    }

    private void b() {
        int length = this.f18758b.length;
        if (this.f18760d < length) {
            return;
        }
        int i11 = length * 2;
        long[] jArr = new long[i11];
        Object[] objArrA = a(i11);
        int i12 = this.f18759c;
        int i13 = length - i12;
        System.arraycopy(this.f18757a, i12, jArr, 0, i13);
        System.arraycopy(this.f18758b, this.f18759c, objArrA, 0, i13);
        int i14 = this.f18759c;
        if (i14 > 0) {
            System.arraycopy(this.f18757a, 0, jArr, i13, i14);
            System.arraycopy(this.f18758b, 0, objArrA, i13, this.f18759c);
        }
        this.f18757a = jArr;
        this.f18758b = objArrA;
        this.f18759c = 0;
    }

    private void b(long j11, Object obj) {
        int i11 = this.f18759c;
        int i12 = this.f18760d;
        Object[] objArr = this.f18758b;
        int length = (i11 + i12) % objArr.length;
        this.f18757a[length] = j11;
        objArr[length] = obj;
        this.f18760d = i12 + 1;
    }

    private Object d() {
        b1.b(this.f18760d > 0);
        Object[] objArr = this.f18758b;
        int i11 = this.f18759c;
        Object obj = objArr[i11];
        objArr[i11] = null;
        this.f18759c = (i11 + 1) % objArr.length;
        this.f18760d--;
        return obj;
    }

    public synchronized void a() {
        this.f18759c = 0;
        this.f18760d = 0;
        Arrays.fill(this.f18758b, (Object) null);
    }

    public synchronized void a(long j11, Object obj) {
        a(j11);
        b();
        b(j11, obj);
    }

    public synchronized Object b(long j11) {
        return a(j11, false);
    }

    public synchronized Object c() {
        return this.f18760d == 0 ? null : d();
    }

    public synchronized Object c(long j11) {
        return a(j11, true);
    }

    public synchronized int e() {
        return this.f18760d;
    }
}
