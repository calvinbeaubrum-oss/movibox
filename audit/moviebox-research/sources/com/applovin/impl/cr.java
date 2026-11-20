package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class cr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f18302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f18303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f18304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f18305d;

    public cr(byte[] bArr) {
        this.f18302a = bArr;
        this.f18303b = bArr.length;
    }

    private void a() {
        int i11;
        int i12 = this.f18304c;
        b1.b(i12 >= 0 && (i12 < (i11 = this.f18303b) || (i12 == i11 && this.f18305d == 0)));
    }

    public int a(int i11) {
        int i12 = this.f18304c;
        int iMin = Math.min(i11, 8 - this.f18305d);
        int i13 = i12 + 1;
        int i14 = ((this.f18302a[i12] & 255) >> this.f18305d) & (255 >> (8 - iMin));
        while (iMin < i11) {
            i14 |= (this.f18302a[i13] & 255) << iMin;
            iMin += 8;
            i13++;
        }
        int i15 = i14 & ((-1) >>> (32 - i11));
        b(i11);
        return i15;
    }

    public int b() {
        return (this.f18304c * 8) + this.f18305d;
    }

    public void b(int i11) {
        int i12 = i11 / 8;
        int i13 = this.f18304c + i12;
        this.f18304c = i13;
        int i14 = this.f18305d + (i11 - (i12 * 8));
        this.f18305d = i14;
        if (i14 > 7) {
            this.f18304c = i13 + 1;
            this.f18305d = i14 - 8;
        }
        a();
    }

    public boolean c() {
        boolean z11 = (((this.f18302a[this.f18304c] & 255) >> this.f18305d) & 1) == 1;
        b(1);
        return z11;
    }
}
