package com.applovin.impl;

import androidx.core.view.MotionEventCompat;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f17657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f17658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f17659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f17660d;

    public ah() {
        this.f17657a = xp.f24377f;
    }

    public ah(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public ah(byte[] bArr, int i11) {
        this.f17657a = bArr;
        this.f17660d = i11;
    }

    private void a() {
        int i11;
        int i12 = this.f17658b;
        b1.b(i12 >= 0 && (i12 < (i11 = this.f17660d) || (i12 == i11 && this.f17659c == 0)));
    }

    public int a(int i11) {
        int i12;
        if (i11 == 0) {
            return 0;
        }
        this.f17659c += i11;
        int i13 = 0;
        while (true) {
            i12 = this.f17659c;
            if (i12 <= 8) {
                break;
            }
            int i14 = i12 - 8;
            this.f17659c = i14;
            byte[] bArr = this.f17657a;
            int i15 = this.f17658b;
            this.f17658b = i15 + 1;
            i13 |= (bArr[i15] & 255) << i14;
        }
        byte[] bArr2 = this.f17657a;
        int i16 = this.f17658b;
        int i17 = ((-1) >>> (32 - i11)) & (i13 | ((bArr2[i16] & 255) >> (8 - i12)));
        if (i12 == 8) {
            this.f17659c = 0;
            this.f17658b = i16 + 1;
        }
        a();
        return i17;
    }

    public String a(int i11, Charset charset) {
        byte[] bArr = new byte[i11];
        b(bArr, 0, i11);
        return new String(bArr, charset);
    }

    public void a(int i11, int i12) {
        if (i12 < 32) {
            i11 &= (1 << i12) - 1;
        }
        int iMin = Math.min(8 - this.f17659c, i12);
        int i13 = this.f17659c;
        int i14 = (8 - i13) - iMin;
        int i15 = (MotionEventCompat.ACTION_POINTER_INDEX_MASK >> i13) | ((1 << i14) - 1);
        byte[] bArr = this.f17657a;
        int i16 = this.f17658b;
        byte b11 = (byte) (i15 & bArr[i16]);
        bArr[i16] = b11;
        int i17 = i12 - iMin;
        bArr[i16] = (byte) (b11 | ((i11 >>> i17) << i14));
        int i18 = i16 + 1;
        while (i17 > 8) {
            this.f17657a[i18] = (byte) (i11 >>> (i17 - 8));
            i17 -= 8;
            i18++;
        }
        int i19 = 8 - i17;
        byte[] bArr2 = this.f17657a;
        byte b12 = (byte) (bArr2[i18] & ((1 << i19) - 1));
        bArr2[i18] = b12;
        bArr2[i18] = (byte) (((i11 & ((1 << i17) - 1)) << i19) | b12);
        d(i12);
        a();
    }

    public void a(bh bhVar) {
        a(bhVar.c(), bhVar.e());
        c(bhVar.d() * 8);
    }

    public void a(byte[] bArr) {
        a(bArr, bArr.length);
    }

    public void a(byte[] bArr, int i11) {
        this.f17657a = bArr;
        this.f17658b = 0;
        this.f17659c = 0;
        this.f17660d = i11;
    }

    public void a(byte[] bArr, int i11, int i12) {
        int i13 = (i12 >> 3) + i11;
        while (i11 < i13) {
            byte[] bArr2 = this.f17657a;
            int i14 = this.f17658b;
            int i15 = i14 + 1;
            this.f17658b = i15;
            byte b11 = bArr2[i14];
            int i16 = this.f17659c;
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
        int i18 = this.f17659c;
        if (i18 + i17 > 8) {
            byte[] bArr3 = this.f17657a;
            int i19 = this.f17658b;
            this.f17658b = i19 + 1;
            bArr[i13] = (byte) (b13 | ((bArr3[i19] & 255) << i18));
            this.f17659c = i18 - 8;
        }
        int i21 = this.f17659c + i17;
        this.f17659c = i21;
        byte[] bArr4 = this.f17657a;
        int i22 = this.f17658b;
        bArr[i13] = (byte) (((byte) (((255 & bArr4[i22]) >> (8 - i21)) << (8 - i17))) | bArr[i13]);
        if (i21 == 8) {
            this.f17659c = 0;
            this.f17658b = i22 + 1;
        }
        a();
    }

    public int b() {
        return ((this.f17660d - this.f17658b) * 8) - this.f17659c;
    }

    public long b(int i11) {
        return i11 <= 32 ? xp.i(a(i11)) : xp.c(a(i11 - 32), a(32));
    }

    public void b(byte[] bArr, int i11, int i12) {
        b1.b(this.f17659c == 0);
        System.arraycopy(this.f17657a, this.f17658b, bArr, i11, i12);
        this.f17658b += i12;
        a();
    }

    public void c() {
        if (this.f17659c == 0) {
            return;
        }
        this.f17659c = 0;
        this.f17658b++;
        a();
    }

    public void c(int i11) {
        int i12 = i11 / 8;
        this.f17658b = i12;
        this.f17659c = i11 - (i12 * 8);
        a();
    }

    public int d() {
        b1.b(this.f17659c == 0);
        return this.f17658b;
    }

    public void d(int i11) {
        int i12 = i11 / 8;
        int i13 = this.f17658b + i12;
        this.f17658b = i13;
        int i14 = this.f17659c + (i11 - (i12 * 8));
        this.f17659c = i14;
        if (i14 > 7) {
            this.f17658b = i13 + 1;
            this.f17659c = i14 - 8;
        }
        a();
    }

    public int e() {
        return (this.f17658b * 8) + this.f17659c;
    }

    public void e(int i11) {
        b1.b(this.f17659c == 0);
        this.f17658b += i11;
        a();
    }

    public boolean f() {
        boolean z11 = (this.f17657a[this.f17658b] & (128 >> this.f17659c)) != 0;
        g();
        return z11;
    }

    public void g() {
        int i11 = this.f17659c + 1;
        this.f17659c = i11;
        if (i11 == 8) {
            this.f17659c = 0;
            this.f17658b++;
        }
        a();
    }
}
