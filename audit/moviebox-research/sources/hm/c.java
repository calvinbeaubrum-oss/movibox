package hm;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f66502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f66503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f66504c;

    public c(byte[] bArr) {
        this.f66502a = bArr;
    }

    public int a() {
        return ((this.f66502a.length - this.f66503b) * 8) - this.f66504c;
    }

    public int b() {
        return this.f66504c;
    }

    public int c() {
        return this.f66503b;
    }

    public int d(int i11) {
        if (i11 < 1 || i11 > 32 || i11 > a()) {
            throw new IllegalArgumentException(String.valueOf(i11));
        }
        int i12 = this.f66504c;
        int i13 = 0;
        if (i12 > 0) {
            int i14 = 8 - i12;
            int iMin = Math.min(i11, i14);
            int i15 = i14 - iMin;
            byte[] bArr = this.f66502a;
            int i16 = this.f66503b;
            int i17 = (((255 >> (8 - iMin)) << i15) & bArr[i16]) >> i15;
            i11 -= iMin;
            int i18 = this.f66504c + iMin;
            this.f66504c = i18;
            if (i18 == 8) {
                this.f66504c = 0;
                this.f66503b = i16 + 1;
            }
            i13 = i17;
        }
        if (i11 <= 0) {
            return i13;
        }
        while (i11 >= 8) {
            int i19 = i13 << 8;
            byte[] bArr2 = this.f66502a;
            int i21 = this.f66503b;
            i13 = (bArr2[i21] & 255) | i19;
            this.f66503b = i21 + 1;
            i11 -= 8;
        }
        if (i11 <= 0) {
            return i13;
        }
        int i22 = 8 - i11;
        int i23 = (i13 << i11) | ((((255 >> i22) << i22) & this.f66502a[this.f66503b]) >> i22);
        this.f66504c += i11;
        return i23;
    }
}
