package com.squareup.okhttp.internal.framed;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f49201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f49202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f49203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f49204d = new int[10];

    public void a() {
        this.f49203c = 0;
        this.f49202b = 0;
        this.f49201a = 0;
        Arrays.fill(this.f49204d, 0);
    }

    public int b(int i11) {
        int i12 = h(i11) ? 2 : 0;
        return k(i11) ? i12 | 1 : i12;
    }

    public int c(int i11) {
        return this.f49204d[i11];
    }

    public int d() {
        if ((this.f49201a & 2) != 0) {
            return this.f49204d[1];
        }
        return -1;
    }

    public int e(int i11) {
        return (this.f49201a & 128) != 0 ? this.f49204d[7] : i11;
    }

    public int f(int i11) {
        return (this.f49201a & 16) != 0 ? this.f49204d[4] : i11;
    }

    public int g(int i11) {
        return (this.f49201a & 32) != 0 ? this.f49204d[5] : i11;
    }

    public boolean h(int i11) {
        return ((1 << i11) & this.f49203c) != 0;
    }

    public boolean i(int i11) {
        return ((1 << i11) & this.f49201a) != 0;
    }

    public void j(h hVar) {
        for (int i11 = 0; i11 < 10; i11++) {
            if (hVar.i(i11)) {
                l(i11, hVar.b(i11), hVar.c(i11));
            }
        }
    }

    public boolean k(int i11) {
        return ((1 << i11) & this.f49202b) != 0;
    }

    public h l(int i11, int i12, int i13) {
        int[] iArr = this.f49204d;
        if (i11 >= iArr.length) {
            return this;
        }
        int i14 = 1 << i11;
        this.f49201a |= i14;
        if ((i12 & 1) != 0) {
            this.f49202b |= i14;
        } else {
            this.f49202b &= ~i14;
        }
        if ((i12 & 2) != 0) {
            this.f49203c |= i14;
        } else {
            this.f49203c &= ~i14;
        }
        iArr[i11] = i13;
        return this;
    }

    public int m() {
        return Integer.bitCount(this.f49201a);
    }
}
