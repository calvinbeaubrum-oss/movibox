package a4;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f411d;

    public b(byte[] bArr, int i11, int i12) {
        i(bArr, i11, i12);
    }

    public final void a() {
        int i11;
        int i12 = this.f410c;
        z3.a.g(i12 >= 0 && (i12 < (i11 = this.f409b) || (i12 == i11 && this.f411d == 0)));
    }

    public boolean b(int i11) {
        int i12 = this.f410c;
        int i13 = i11 / 8;
        int i14 = i12 + i13;
        int i15 = (this.f411d + i11) - (i13 * 8);
        if (i15 > 7) {
            i14++;
            i15 -= 8;
        }
        while (true) {
            i12++;
            if (i12 > i14 || i14 >= this.f409b) {
                break;
            }
            if (j(i12)) {
                i14++;
                i12 += 2;
            }
        }
        int i16 = this.f409b;
        if (i14 >= i16) {
            return i14 == i16 && i15 == 0;
        }
        return true;
    }

    public boolean c() {
        int i11 = this.f410c;
        int i12 = this.f411d;
        int i13 = 0;
        while (this.f410c < this.f409b && !d()) {
            i13++;
        }
        boolean z11 = this.f410c == this.f409b;
        this.f410c = i11;
        this.f411d = i12;
        return !z11 && b((i13 * 2) + 1);
    }

    public boolean d() {
        boolean z11 = (this.f408a[this.f410c] & (128 >> this.f411d)) != 0;
        k();
        return z11;
    }

    public int e(int i11) {
        int i12;
        this.f411d += i11;
        int i13 = 0;
        while (true) {
            i12 = this.f411d;
            int i14 = 2;
            if (i12 <= 8) {
                break;
            }
            int i15 = i12 - 8;
            this.f411d = i15;
            byte[] bArr = this.f408a;
            int i16 = this.f410c;
            i13 |= (bArr[i16] & 255) << i15;
            if (!j(i16 + 1)) {
                i14 = 1;
            }
            this.f410c = i16 + i14;
        }
        byte[] bArr2 = this.f408a;
        int i17 = this.f410c;
        int i18 = ((-1) >>> (32 - i11)) & (i13 | ((bArr2[i17] & 255) >> (8 - i12)));
        if (i12 == 8) {
            this.f411d = 0;
            this.f410c = i17 + (j(i17 + 1) ? 2 : 1);
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
        this.f408a = bArr;
        this.f410c = i11;
        this.f409b = i12;
        this.f411d = 0;
        a();
    }

    public final boolean j(int i11) {
        if (2 <= i11 && i11 < this.f409b) {
            byte[] bArr = this.f408a;
            if (bArr[i11] == 3 && bArr[i11 - 2] == 0 && bArr[i11 - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    public void k() {
        int i11 = this.f411d + 1;
        this.f411d = i11;
        if (i11 == 8) {
            this.f411d = 0;
            int i12 = this.f410c;
            this.f410c = i12 + (j(i12 + 1) ? 2 : 1);
        }
        a();
    }

    public void l(int i11) {
        int i12 = this.f410c;
        int i13 = i11 / 8;
        int i14 = i12 + i13;
        this.f410c = i14;
        int i15 = this.f411d + (i11 - (i13 * 8));
        this.f411d = i15;
        if (i15 > 7) {
            this.f410c = i14 + 1;
            this.f411d = i15 - 8;
        }
        while (true) {
            i12++;
            if (i12 > this.f410c) {
                a();
                return;
            } else if (j(i12)) {
                this.f410c++;
                i12 += 2;
            }
        }
    }
}
