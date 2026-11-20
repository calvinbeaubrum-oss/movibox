package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Charsets;
import java.nio.charset.Charset;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class bh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f17919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f17920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f17921c;

    public bh() {
        this.f17919a = xp.f24377f;
    }

    public bh(int i11) {
        this.f17919a = new byte[i11];
        this.f17921c = i11;
    }

    public bh(byte[] bArr) {
        this.f17919a = bArr;
        this.f17921c = bArr.length;
    }

    public bh(byte[] bArr, int i11) {
        this.f17919a = bArr;
        this.f17921c = i11;
    }

    public int A() {
        int iJ = j();
        if (iJ >= 0) {
            return iJ;
        }
        throw new IllegalStateException("Top bit not zero: " + iJ);
    }

    public long B() {
        long jS = s();
        if (jS >= 0) {
            return jS;
        }
        throw new IllegalStateException("Top bit not zero: " + jS);
    }

    public int C() {
        byte[] bArr = this.f17919a;
        int i11 = this.f17920b;
        int i12 = i11 + 1;
        int i13 = (bArr[i11] & 255) << 8;
        this.f17920b = i11 + 2;
        return (bArr[i12] & 255) | i13;
    }

    public long D() {
        int i11;
        int i12;
        long j11 = this.f17919a[this.f17920b];
        int i13 = 7;
        while (true) {
            if (i13 >= 0) {
                int i14 = 1 << i13;
                if ((((long) i14) & j11) == 0) {
                    if (i13 < 6) {
                        j11 &= (long) (i14 - 1);
                        i12 = 7 - i13;
                        break;
                    }
                    if (i13 == 7) {
                        i12 = 1;
                        break;
                    }
                } else {
                    i13--;
                }
            }
            i12 = 0;
            break;
        }
        if (i12 == 0) {
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j11);
        }
        for (i11 = 1; i11 < i12; i11++) {
            byte b11 = this.f17919a[this.f17920b + i11];
            if ((b11 & 192) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j11);
            }
            j11 = (j11 << 6) | ((long) (b11 & Utf8.REPLACEMENT_BYTE));
        }
        this.f17920b += i12;
        return j11;
    }

    public int a() {
        return this.f17921c - this.f17920b;
    }

    public String a(char c11) {
        if (a() == 0) {
            return null;
        }
        int i11 = this.f17920b;
        while (i11 < this.f17921c && this.f17919a[i11] != c11) {
            i11++;
        }
        byte[] bArr = this.f17919a;
        int i12 = this.f17920b;
        String strA = xp.a(bArr, i12, i11 - i12);
        this.f17920b = i11;
        if (i11 < this.f17921c) {
            this.f17920b = i11 + 1;
        }
        return strA;
    }

    public String a(int i11, Charset charset) {
        String str = new String(this.f17919a, this.f17920b, i11, charset);
        this.f17920b += i11;
        return str;
    }

    public void a(int i11) {
        if (i11 > b()) {
            this.f17919a = Arrays.copyOf(this.f17919a, i11);
        }
    }

    public void a(ah ahVar, int i11) {
        a(ahVar.f17657a, 0, i11);
        ahVar.c(0);
    }

    public void a(byte[] bArr) {
        a(bArr, bArr.length);
    }

    public void a(byte[] bArr, int i11) {
        this.f17919a = bArr;
        this.f17921c = i11;
        this.f17920b = 0;
    }

    public void a(byte[] bArr, int i11, int i12) {
        System.arraycopy(this.f17919a, this.f17920b, bArr, i11, i12);
        this.f17920b += i12;
    }

    public int b() {
        return this.f17919a.length;
    }

    public String b(int i11) {
        if (i11 == 0) {
            return "";
        }
        int i12 = this.f17920b;
        int i13 = (i12 + i11) - 1;
        String strA = xp.a(this.f17919a, i12, (i13 >= this.f17921c || this.f17919a[i13] != 0) ? i11 : i11 - 1);
        this.f17920b += i11;
        return strA;
    }

    public String c(int i11) {
        return a(i11, Charsets.UTF_8);
    }

    public byte[] c() {
        return this.f17919a;
    }

    public int d() {
        return this.f17920b;
    }

    public void d(int i11) {
        a(b() < i11 ? new byte[i11] : this.f17919a, i11);
    }

    public int e() {
        return this.f17921c;
    }

    public void e(int i11) {
        b1.a(i11 >= 0 && i11 <= this.f17919a.length);
        this.f17921c = i11;
    }

    public char f() {
        byte[] bArr = this.f17919a;
        int i11 = this.f17920b;
        return (char) ((bArr[i11 + 1] & 255) | ((bArr[i11] & 255) << 8));
    }

    public void f(int i11) {
        b1.a(i11 >= 0 && i11 <= this.f17921c);
        this.f17920b = i11;
    }

    public int g() {
        return this.f17919a[this.f17920b] & 255;
    }

    public void g(int i11) {
        f(this.f17920b + i11);
    }

    public double h() {
        return Double.longBitsToDouble(s());
    }

    public float i() {
        return Float.intBitsToFloat(j());
    }

    public int j() {
        byte[] bArr = this.f17919a;
        int i11 = this.f17920b;
        int i12 = ((bArr[i11 + 1] & 255) << 16) | ((bArr[i11] & 255) << 24);
        int i13 = i11 + 3;
        int i14 = i12 | ((bArr[i11 + 2] & 255) << 8);
        this.f17920b = i11 + 4;
        return (bArr[i13] & 255) | i14;
    }

    public int k() {
        byte[] bArr = this.f17919a;
        int i11 = this.f17920b;
        int i12 = i11 + 2;
        int i13 = ((bArr[i11 + 1] & 255) << 8) | (((bArr[i11] & 255) << 24) >> 8);
        this.f17920b = i11 + 3;
        return (bArr[i12] & 255) | i13;
    }

    public String l() {
        if (a() == 0) {
            return null;
        }
        int i11 = this.f17920b;
        while (i11 < this.f17921c && !xp.h(this.f17919a[i11])) {
            i11++;
        }
        int i12 = this.f17920b;
        if (i11 - i12 >= 3) {
            byte[] bArr = this.f17919a;
            if (bArr[i12] == -17 && bArr[i12 + 1] == -69 && bArr[i12 + 2] == -65) {
                this.f17920b = i12 + 3;
            }
        }
        byte[] bArr2 = this.f17919a;
        int i13 = this.f17920b;
        String strA = xp.a(bArr2, i13, i11 - i13);
        this.f17920b = i11;
        int i14 = this.f17921c;
        if (i11 == i14) {
            return strA;
        }
        byte[] bArr3 = this.f17919a;
        if (bArr3[i11] == 13) {
            int i15 = i11 + 1;
            this.f17920b = i15;
            if (i15 == i14) {
                return strA;
            }
        }
        int i16 = this.f17920b;
        if (bArr3[i16] == 10) {
            this.f17920b = i16 + 1;
        }
        return strA;
    }

    public int m() {
        byte[] bArr = this.f17919a;
        int i11 = this.f17920b;
        int i12 = ((bArr[i11 + 1] & 255) << 8) | (bArr[i11] & 255);
        int i13 = i11 + 3;
        int i14 = i12 | ((bArr[i11 + 2] & 255) << 16);
        this.f17920b = i11 + 4;
        return ((bArr[i13] & 255) << 24) | i14;
    }

    public long n() {
        byte[] bArr = this.f17919a;
        int i11 = this.f17920b;
        int i12 = i11 + 7;
        long j11 = (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48);
        this.f17920b = i11 + 8;
        return ((((long) bArr[i12]) & 255) << 56) | j11;
    }

    public short o() {
        byte[] bArr = this.f17919a;
        int i11 = this.f17920b;
        int i12 = i11 + 1;
        int i13 = bArr[i11] & 255;
        this.f17920b = i11 + 2;
        return (short) (((bArr[i12] & 255) << 8) | i13);
    }

    public long p() {
        byte[] bArr = this.f17919a;
        int i11 = this.f17920b;
        int i12 = i11 + 3;
        long j11 = (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16);
        this.f17920b = i11 + 4;
        return ((((long) bArr[i12]) & 255) << 24) | j11;
    }

    public int q() {
        int iM = m();
        if (iM >= 0) {
            return iM;
        }
        throw new IllegalStateException("Top bit not zero: " + iM);
    }

    public int r() {
        byte[] bArr = this.f17919a;
        int i11 = this.f17920b;
        int i12 = i11 + 1;
        int i13 = bArr[i11] & 255;
        this.f17920b = i11 + 2;
        return ((bArr[i12] & 255) << 8) | i13;
    }

    public long s() {
        byte[] bArr = this.f17919a;
        int i11 = this.f17920b;
        int i12 = i11 + 7;
        long j11 = ((((long) bArr[i11]) & 255) << 56) | ((((long) bArr[i11 + 1]) & 255) << 48) | ((((long) bArr[i11 + 2]) & 255) << 40) | ((((long) bArr[i11 + 3]) & 255) << 32) | ((((long) bArr[i11 + 4]) & 255) << 24) | ((((long) bArr[i11 + 5]) & 255) << 16) | ((((long) bArr[i11 + 6]) & 255) << 8);
        this.f17920b = i11 + 8;
        return (((long) bArr[i12]) & 255) | j11;
    }

    public String t() {
        return a((char) 0);
    }

    public short u() {
        byte[] bArr = this.f17919a;
        int i11 = this.f17920b;
        int i12 = i11 + 1;
        int i13 = (bArr[i11] & 255) << 8;
        this.f17920b = i11 + 2;
        return (short) ((bArr[i12] & 255) | i13);
    }

    public int v() {
        return (w() << 21) | (w() << 14) | (w() << 7) | w();
    }

    public int w() {
        byte[] bArr = this.f17919a;
        int i11 = this.f17920b;
        this.f17920b = i11 + 1;
        return bArr[i11] & 255;
    }

    public int x() {
        byte[] bArr = this.f17919a;
        int i11 = this.f17920b;
        int i12 = (bArr[i11 + 1] & 255) | ((bArr[i11] & 255) << 8);
        this.f17920b = i11 + 4;
        return i12;
    }

    public long y() {
        byte[] bArr = this.f17919a;
        int i11 = this.f17920b;
        int i12 = i11 + 3;
        long j11 = ((((long) bArr[i11]) & 255) << 24) | ((((long) bArr[i11 + 1]) & 255) << 16) | ((((long) bArr[i11 + 2]) & 255) << 8);
        this.f17920b = i11 + 4;
        return (((long) bArr[i12]) & 255) | j11;
    }

    public int z() {
        byte[] bArr = this.f17919a;
        int i11 = this.f17920b;
        int i12 = i11 + 2;
        int i13 = ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11] & 255) << 16);
        this.f17920b = i11 + 3;
        return (bArr[i12] & 255) | i13;
    }
}
