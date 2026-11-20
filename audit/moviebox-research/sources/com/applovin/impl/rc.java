package com.applovin.impl;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class rc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f22077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long[] f22078b;

    public rc() {
        this(32);
    }

    public rc(int i11) {
        this.f22078b = new long[i11];
    }

    public int a() {
        return this.f22077a;
    }

    public long a(int i11) {
        if (i11 >= 0 && i11 < this.f22077a) {
            return this.f22078b[i11];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i11 + ", size is " + this.f22077a);
    }

    public void a(long j11) {
        int i11 = this.f22077a;
        long[] jArr = this.f22078b;
        if (i11 == jArr.length) {
            this.f22078b = Arrays.copyOf(jArr, i11 * 2);
        }
        long[] jArr2 = this.f22078b;
        int i12 = this.f22077a;
        this.f22077a = i12 + 1;
        jArr2[i12] = j11;
    }

    public long[] b() {
        return Arrays.copyOf(this.f22078b, this.f22077a);
    }
}
