package z3;

import androidx.core.view.MotionEventCompat;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f81757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f81758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f81759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f81760d;

    public b0() {
        this.f81757a = u0.f81843f;
    }

    public b0(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public b0(byte[] bArr, int i11) {
        this.f81757a = bArr;
        this.f81760d = i11;
    }

    public final void a() {
        int i11;
        int i12 = this.f81758b;
        a.g(i12 >= 0 && (i12 < (i11 = this.f81760d) || (i12 == i11 && this.f81759c == 0)));
    }

    public int b() {
        return ((this.f81760d - this.f81758b) * 8) - this.f81759c;
    }

    public void c() {
        if (this.f81759c == 0) {
            return;
        }
        this.f81759c = 0;
        this.f81758b++;
        a();
    }

    public int d() {
        a.g(this.f81759c == 0);
        return this.f81758b;
    }

    public int e() {
        return (this.f81758b * 8) + this.f81759c;
    }

    public void f(int i11, int i12) {
        if (i12 < 32) {
            i11 &= (1 << i12) - 1;
        }
        int iMin = Math.min(8 - this.f81759c, i12);
        int i13 = this.f81759c;
        int i14 = (8 - i13) - iMin;
        int i15 = (MotionEventCompat.ACTION_POINTER_INDEX_MASK >> i13) | ((1 << i14) - 1);
        byte[] bArr = this.f81757a;
        int i16 = this.f81758b;
        byte b11 = (byte) (i15 & bArr[i16]);
        bArr[i16] = b11;
        int i17 = i12 - iMin;
        bArr[i16] = (byte) (b11 | ((i11 >>> i17) << i14));
        int i18 = i16 + 1;
        while (i17 > 8) {
            this.f81757a[i18] = (byte) (i11 >>> (i17 - 8));
            i17 -= 8;
            i18++;
        }
        int i19 = 8 - i17;
        byte[] bArr2 = this.f81757a;
        byte b12 = (byte) (bArr2[i18] & ((1 << i19) - 1));
        bArr2[i18] = b12;
        bArr2[i18] = (byte) (((i11 & ((1 << i17) - 1)) << i19) | b12);
        r(i12);
        a();
    }

    public boolean g() {
        boolean z11 = (this.f81757a[this.f81758b] & (128 >> this.f81759c)) != 0;
        q();
        return z11;
    }

    public int h(int i11) {
        int i12;
        if (i11 == 0) {
            return 0;
        }
        this.f81759c += i11;
        int i13 = 0;
        while (true) {
            i12 = this.f81759c;
            if (i12 <= 8) {
                break;
            }
            int i14 = i12 - 8;
            this.f81759c = i14;
            byte[] bArr = this.f81757a;
            int i15 = this.f81758b;
            this.f81758b = i15 + 1;
            i13 |= (bArr[i15] & 255) << i14;
        }
        byte[] bArr2 = this.f81757a;
        int i16 = this.f81758b;
        int i17 = ((-1) >>> (32 - i11)) & (i13 | ((bArr2[i16] & 255) >> (8 - i12)));
        if (i12 == 8) {
            this.f81759c = 0;
            this.f81758b = i16 + 1;
        }
        a();
        return i17;
    }

    public void i(byte[] bArr, int i11, int i12) {
        int i13 = (i12 >> 3) + i11;
        while (i11 < i13) {
            byte[] bArr2 = this.f81757a;
            int i14 = this.f81758b;
            int i15 = i14 + 1;
            this.f81758b = i15;
            byte b11 = bArr2[i14];
            int i16 = this.f81759c;
            byte b12 = (byte) (b11 << i16);
            bArr[i11] = b12;
            bArr[i11] = (byte) (((255 & bArr2[i15]) >> (8 - i16)) | b12);
            i11++;
        }
        int i17 = i12 & 7;
        if (i17 == 0) {
            return;
        }
        byte b13 = (byte) (bArr[i13] & (255 >> i17));
        bArr[i13] = b13;
        int i18 = this.f81759c;
        if (i18 + i17 > 8) {
            byte[] bArr3 = this.f81757a;
            int i19 = this.f81758b;
            this.f81758b = i19 + 1;
            bArr[i13] = (byte) (b13 | ((bArr3[i19] & 255) << i18));
            this.f81759c = i18 - 8;
        }
        int i21 = this.f81759c + i17;
        this.f81759c = i21;
        byte[] bArr4 = this.f81757a;
        int i22 = this.f81758b;
        bArr[i13] = (byte) (((byte) (((255 & bArr4[i22]) >> (8 - i21)) << (8 - i17))) | bArr[i13]);
        if (i21 == 8) {
            this.f81759c = 0;
            this.f81758b = i22 + 1;
        }
        a();
    }

    public long j(int i11) {
        return i11 <= 32 ? u0.z1(h(i11)) : u0.y1(h(i11 - 32), h(32));
    }

    public void k(byte[] bArr, int i11, int i12) {
        a.g(this.f81759c == 0);
        System.arraycopy(this.f81757a, this.f81758b, bArr, i11, i12);
        this.f81758b += i12;
        a();
    }

    public String l(int i11, Charset charset) {
        byte[] bArr = new byte[i11];
        k(bArr, 0, i11);
        return new String(bArr, charset);
    }

    public void m(c0 c0Var) {
        o(c0Var.e(), c0Var.g());
        p(c0Var.f() * 8);
    }

    public void n(byte[] bArr) {
        o(bArr, bArr.length);
    }

    public void o(byte[] bArr, int i11) {
        this.f81757a = bArr;
        this.f81758b = 0;
        this.f81759c = 0;
        this.f81760d = i11;
    }

    public void p(int i11) {
        int i12 = i11 / 8;
        this.f81758b = i12;
        this.f81759c = i11 - (i12 * 8);
        a();
    }

    public void q() {
        int i11 = this.f81759c + 1;
        this.f81759c = i11;
        if (i11 == 8) {
            this.f81759c = 0;
            this.f81758b++;
        }
        a();
    }

    public void r(int i11) {
        int i12 = i11 / 8;
        int i13 = this.f81758b + i12;
        this.f81758b = i13;
        int i14 = this.f81759c + (i11 - (i12 * 8));
        this.f81759c = i14;
        if (i14 > 7) {
            this.f81758b = i13 + 1;
            this.f81759c = i14 - 8;
        }
        a();
    }

    public void s(int i11) {
        a.g(this.f81759c == 0);
        this.f81758b += i11;
        a();
    }
}
