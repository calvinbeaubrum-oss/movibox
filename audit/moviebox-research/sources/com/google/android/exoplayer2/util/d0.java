package com.google.android.exoplayer2.util;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f35552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f35553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f35554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f35555d;

    public d0(byte[] bArr, int i11, int i12) {
        i(bArr, i11, i12);
    }

    public final void a() {
        int i11;
        int i12 = this.f35554c;
        a.g(i12 >= 0 && (i12 < (i11 = this.f35553b) || (i12 == i11 && this.f35555d == 0)));
    }

    public boolean b(int i11) {
        int i12 = this.f35554c;
        int i13 = i11 / 8;
        int i14 = i12 + i13;
        int i15 = (this.f35555d + i11) - (i13 * 8);
        if (i15 > 7) {
            i14++;
            i15 -= 8;
        }
        while (true) {
            i12++;
            if (i12 > i14 || i14 >= this.f35553b) {
                break;
            }
            if (j(i12)) {
                i14++;
                i12 += 2;
            }
        }
        int i16 = this.f35553b;
        if (i14 >= i16) {
            return i14 == i16 && i15 == 0;
        }
        return true;
    }

    public boolean c() {
        int i11 = this.f35554c;
        int i12 = this.f35555d;
        int i13 = 0;
        while (this.f35554c < this.f35553b && !d()) {
            i13++;
        }
        boolean z11 = this.f35554c == this.f35553b;
        this.f35554c = i11;
        this.f35555d = i12;
        return !z11 && b((i13 * 2) + 1);
    }

    public boolean d() {
        boolean z11 = (this.f35552a[this.f35554c] & (128 >> this.f35555d)) != 0;
        k();
        return z11;
    }

    public int e(int i11) {
        int i12;
        this.f35555d += i11;
        int i13 = 0;
        while (true) {
            i12 = this.f35555d;
            int i14 = 2;
            if (i12 <= 8) {
                break;
            }
            int i15 = i12 - 8;
            this.f35555d = i15;
            byte[] bArr = this.f35552a;
            int i16 = this.f35554c;
            i13 |= (bArr[i16] & 255) << i15;
            if (!j(i16 + 1)) {
                i14 = 1;
            }
            this.f35554c = i16 + i14;
        }
        byte[] bArr2 = this.f35552a;
        int i17 = this.f35554c;
        int i18 = ((-1) >>> (32 - i11)) & (i13 | ((bArr2[i17] & 255) >> (8 - i12)));
        if (i12 == 8) {
            this.f35555d = 0;
            this.f35554c = i17 + (j(i17 + 1) ? 2 : 1);
        }
        a();
        return i18;
    }

    public final int f() {
        int i11 = 0;
        while (!d()) {
            i11++;
        }
        return ((1 << i11) - 1) + (i11 > 0 ? e(i11) : 0);
    }

    public int g() {
        int iF = f();
        return (iF % 2 == 0 ? -1 : 1) * ((iF + 1) / 2);
    }

    public int h() {
        return f();
    }

    public void i(byte[] bArr, int i11, int i12) {
        this.f35552a = bArr;
        this.f35554c = i11;
        this.f35553b = i12;
        this.f35555d = 0;
        a();
    }

    public final boolean j(int i11) {
        if (2 <= i11 && i11 < this.f35553b) {
            byte[] bArr = this.f35552a;
            if (bArr[i11] == 3 && bArr[i11 - 2] == 0 && bArr[i11 - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    public void k() {
        int i11 = this.f35555d + 1;
        this.f35555d = i11;
        if (i11 == 8) {
            this.f35555d = 0;
            int i12 = this.f35554c;
            this.f35554c = i12 + (j(i12 + 1) ? 2 : 1);
        }
        a();
    }

    public void l(int i11) {
        int i12 = this.f35554c;
        int i13 = i11 / 8;
        int i14 = i12 + i13;
        this.f35554c = i14;
        int i15 = this.f35555d + (i11 - (i13 * 8));
        this.f35555d = i15;
        if (i15 > 7) {
            this.f35554c = i14 + 1;
            this.f35555d = i15 - 8;
        }
        while (true) {
            i12++;
            if (i12 > this.f35554c) {
                a();
                return;
            } else if (j(i12)) {
                this.f35554c++;
                i12 += 2;
            }
        }
    }
}
