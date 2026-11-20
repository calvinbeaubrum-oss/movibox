package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class zp {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long[] f24907d = {128, 64, 32, 16, 8, 4, 2, 1};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f24908a = new byte[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f24910c;

    public static int a(int i11) {
        long j11;
        int i12 = 0;
        do {
            long[] jArr = f24907d;
            if (i12 >= jArr.length) {
                return -1;
            }
            j11 = jArr[i12] & ((long) i11);
            i12++;
        } while (j11 == 0);
        return i12;
    }

    public static long a(byte[] bArr, int i11, boolean z11) {
        long j11 = ((long) bArr[0]) & 255;
        if (z11) {
            j11 &= ~f24907d[i11 - 1];
        }
        for (int i12 = 1; i12 < i11; i12++) {
            j11 = (j11 << 8) | (((long) bArr[i12]) & 255);
        }
        return j11;
    }

    public int a() {
        return this.f24910c;
    }

    public long a(l8 l8Var, boolean z11, boolean z12, int i11) {
        if (this.f24909b == 0) {
            if (!l8Var.a(this.f24908a, 0, 1, z11)) {
                return -1L;
            }
            int iA = a(this.f24908a[0] & 255);
            this.f24910c = iA;
            if (iA == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.f24909b = 1;
        }
        int i12 = this.f24910c;
        if (i12 > i11) {
            this.f24909b = 0;
            return -2L;
        }
        if (i12 != 1) {
            l8Var.d(this.f24908a, 1, i12 - 1);
        }
        this.f24909b = 0;
        return a(this.f24908a, this.f24910c, z12);
    }

    public void b() {
        this.f24909b = 0;
        this.f24910c = 0;
    }
}
