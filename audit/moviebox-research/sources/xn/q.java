package xn;

import android.graphics.Rect;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f80635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f80636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f80637c;

    public q(byte[] bArr, int i11, int i12) {
        this.f80635a = bArr;
        this.f80636b = i11;
        this.f80637c = i12;
    }

    public static byte[] e(byte[] bArr, int i11, int i12) {
        int i13 = i11 * i12;
        byte[] bArr2 = new byte[i13];
        int i14 = i13 - 1;
        for (int i15 = 0; i15 < i13; i15++) {
            bArr2[i14] = bArr[i15];
            i14--;
        }
        return bArr2;
    }

    public static byte[] f(byte[] bArr, int i11, int i12) {
        int i13 = i11 * i12;
        byte[] bArr2 = new byte[i13];
        int i14 = i13 - 1;
        for (int i15 = 0; i15 < i11; i15++) {
            for (int i16 = i12 - 1; i16 >= 0; i16--) {
                bArr2[i14] = bArr[(i16 * i11) + i15];
                i14--;
            }
        }
        return bArr2;
    }

    public static byte[] g(byte[] bArr, int i11, int i12) {
        byte[] bArr2 = new byte[i11 * i12];
        int i13 = 0;
        for (int i14 = 0; i14 < i11; i14++) {
            for (int i15 = i12 - 1; i15 >= 0; i15--) {
                bArr2[i13] = bArr[(i15 * i11) + i14];
                i13++;
            }
        }
        return bArr2;
    }

    public q a(Rect rect, int i11) {
        int iWidth = rect.width() / i11;
        int iHeight = rect.height() / i11;
        int i12 = rect.top;
        byte[] bArr = new byte[iWidth * iHeight];
        if (i11 == 1) {
            int i13 = (i12 * this.f80636b) + rect.left;
            for (int i14 = 0; i14 < iHeight; i14++) {
                System.arraycopy(this.f80635a, i13, bArr, i14 * iWidth, iWidth);
                i13 += this.f80636b;
            }
        } else {
            int i15 = (i12 * this.f80636b) + rect.left;
            for (int i16 = 0; i16 < iHeight; i16++) {
                int i17 = i16 * iWidth;
                int i18 = i15;
                for (int i19 = 0; i19 < iWidth; i19++) {
                    bArr[i17] = this.f80635a[i18];
                    i18 += i11;
                    i17++;
                }
                i15 += this.f80636b * i11;
            }
        }
        return new q(bArr, iWidth, iHeight);
    }

    public byte[] b() {
        return this.f80635a;
    }

    public int c() {
        return this.f80637c;
    }

    public int d() {
        return this.f80636b;
    }

    public q h(int i11) {
        if (i11 == 90) {
            return new q(g(this.f80635a, this.f80636b, this.f80637c), this.f80637c, this.f80636b);
        }
        if (i11 != 180) {
            return i11 != 270 ? this : new q(f(this.f80635a, this.f80636b, this.f80637c), this.f80637c, this.f80636b);
        }
        return new q(e(this.f80635a, this.f80636b, this.f80637c), this.f80636b, this.f80637c);
    }
}
