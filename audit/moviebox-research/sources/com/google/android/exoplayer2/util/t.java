package com.google.android.exoplayer2.util;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f35643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long[] f35644b;

    public t() {
        this(32);
    }

    public t(int i11) {
        this.f35644b = new long[i11];
    }

    public void a(long j11) {
        int i11 = this.f35643a;
        long[] jArr = this.f35644b;
        if (i11 == jArr.length) {
            this.f35644b = Arrays.copyOf(jArr, i11 * 2);
        }
        long[] jArr2 = this.f35644b;
        int i12 = this.f35643a;
        this.f35643a = i12 + 1;
        jArr2[i12] = j11;
    }

    public long b(int i11) {
        if (i11 >= 0 && i11 < this.f35643a) {
            return this.f35644b[i11];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i11 + ", size is " + this.f35643a);
    }

    public int c() {
        return this.f35643a;
    }

    public long[] d() {
        return Arrays.copyOf(this.f35644b, this.f35643a);
    }
}
