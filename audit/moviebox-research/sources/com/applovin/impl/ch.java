package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f18188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f18189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f18190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f18191d;

    public ch(byte[] bArr, int i11, int i12) {
        a(bArr, i11, i12);
    }

    private void a() {
        int i11;
        int i12 = this.f18190c;
        b1.b(i12 >= 0 && (i12 < (i11 = this.f18189b) || (i12 == i11 && this.f18191d == 0)));
    }

    private boolean c(int i11) {
        if (2 <= i11 && i11 < this.f18189b) {
            byte[] bArr = this.f18188a;
            if (bArr[i11] == 3 && bArr[i11 - 2] == 0 && bArr[i11 - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    private int d() {
        int i11 = 0;
        while (!c()) {
            i11++;
        }
        return ((1 << i11) - 1) + (i11 > 0 ? b(i11) : 0);
    }

    public void a(byte[] bArr, int i11, int i12) {
        this.f18188a = bArr;
        this.f18190c = i11;
        this.f18189b = i12;
        this.f18191d = 0;
        a();
    }

    public boolean a(int i11) {
        int i12 = this.f18190c;
        int i13 = i11 / 8;
        int i14 = i12 + i13;
        int i15 = (this.f18191d + i11) - (i13 * 8);
        if (i15 > 7) {
            i14++;
            i15 -= 8;
        }
        while (true) {
            int i16 = i12 + 1;
            if (i16 > i14 || i14 >= this.f18189b) {
                break;
            }
            if (c(i16)) {
                i14++;
                i12 += 3;
            } else {
                i12 = i16;
            }
        }
        int i17 = this.f18189b;
        return i14 < i17 || (i14 == i17 && i15 == 0);
    }

    public int b(int i11) {
        int i12;
        this.f18191d += i11;
        int i13 = 0;
        while (true) {
            i12 = this.f18191d;
            int i14 = 2;
            if (i12 <= 8) {
                break;
            }
            int i15 = i12 - 8;
            this.f18191d = i15;
            byte[] bArr = this.f18188a;
            int i16 = this.f18190c;
            i13 |= (bArr[i16] & 255) << i15;
            if (!c(i16 + 1)) {
                i14 = 1;
            }
            this.f18190c = i16 + i14;
        }
        byte[] bArr2 = this.f18188a;
        int i17 = this.f18190c;
        int i18 = ((-1) >>> (32 - i11)) & (i13 | ((bArr2[i17] & 255) >> (8 - i12)));
        if (i12 == 8) {
            this.f18191d = 0;
            this.f18190c = i17 + (c(i17 + 1) ? 2 : 1);
        }
        a();
        return i18;
    }

    public boolean b() {
        int i11 = this.f18190c;
        int i12 = this.f18191d;
        int i13 = 0;
        while (this.f18190c < this.f18189b && !c()) {
            i13++;
        }
        boolean z11 = this.f18190c == this.f18189b;
        this.f18190c = i11;
        this.f18191d = i12;
        return !z11 && a((i13 * 2) + 1);
    }

    public boolean c() {
        boolean z11 = (this.f18188a[this.f18190c] & (128 >> this.f18191d)) != 0;
        g();
        return z11;
    }

    public void d(int i11) {
        int i12 = this.f18190c;
        int i13 = i11 / 8;
        int i14 = i12 + i13;
        this.f18190c = i14;
        int i15 = this.f18191d + (i11 - (i13 * 8));
        this.f18191d = i15;
        if (i15 > 7) {
            this.f18190c = i14 + 1;
            this.f18191d = i15 - 8;
        }
        while (true) {
            i12++;
            if (i12 > this.f18190c) {
                a();
                return;
            } else if (c(i12)) {
                this.f18190c++;
                i12 += 2;
            }
        }
    }

    public int e() {
        int iD = d();
        return (iD % 2 == 0 ? -1 : 1) * ((iD + 1) / 2);
    }

    public int f() {
        return d();
    }

    public void g() {
        int i11 = this.f18191d + 1;
        this.f18191d = i11;
        if (i11 == 8) {
            this.f18191d = 0;
            int i12 = this.f18190c;
            this.f18190c = i12 + (c(i12 + 1) ? 2 : 1);
        }
        a();
    }
}
