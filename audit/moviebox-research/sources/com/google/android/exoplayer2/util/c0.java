package com.google.android.exoplayer2.util;

import androidx.annotation.Nullable;
import java.nio.charset.Charset;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f35549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f35550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f35551c;

    public c0() {
        this.f35549a = o0.f35613f;
    }

    public c0(int i11) {
        this.f35549a = new byte[i11];
        this.f35551c = i11;
    }

    public c0(byte[] bArr) {
        this.f35549a = bArr;
        this.f35551c = bArr.length;
    }

    public c0(byte[] bArr, int i11) {
        this.f35549a = bArr;
        this.f35551c = i11;
    }

    public String A(int i11) {
        return B(i11, com.google.common.base.c.f38165c);
    }

    public String B(int i11, Charset charset) {
        String str = new String(this.f35549a, this.f35550b, i11, charset);
        this.f35550b += i11;
        return str;
    }

    public int C() {
        return (D() << 21) | (D() << 14) | (D() << 7) | D();
    }

    public int D() {
        byte[] bArr = this.f35549a;
        int i11 = this.f35550b;
        this.f35550b = i11 + 1;
        return bArr[i11] & 255;
    }

    public int E() {
        byte[] bArr = this.f35549a;
        int i11 = this.f35550b;
        int i12 = (bArr[i11 + 1] & 255) | ((bArr[i11] & 255) << 8);
        this.f35550b = i11 + 4;
        return i12;
    }

    public long F() {
        byte[] bArr = this.f35549a;
        int i11 = this.f35550b;
        int i12 = i11 + 3;
        long j11 = ((((long) bArr[i11]) & 255) << 24) | ((((long) bArr[i11 + 1]) & 255) << 16) | ((((long) bArr[i11 + 2]) & 255) << 8);
        this.f35550b = i11 + 4;
        return (((long) bArr[i12]) & 255) | j11;
    }

    public int G() {
        byte[] bArr = this.f35549a;
        int i11 = this.f35550b;
        int i12 = i11 + 2;
        int i13 = ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11] & 255) << 16);
        this.f35550b = i11 + 3;
        return (bArr[i12] & 255) | i13;
    }

    public int H() {
        int iN = n();
        if (iN >= 0) {
            return iN;
        }
        throw new IllegalStateException("Top bit not zero: " + iN);
    }

    public long I() {
        long jW = w();
        if (jW >= 0) {
            return jW;
        }
        throw new IllegalStateException("Top bit not zero: " + jW);
    }

    public int J() {
        byte[] bArr = this.f35549a;
        int i11 = this.f35550b;
        int i12 = i11 + 1;
        int i13 = (bArr[i11] & 255) << 8;
        this.f35550b = i11 + 2;
        return (bArr[i12] & 255) | i13;
    }

    public long K() {
        int i11;
        int i12;
        long j11 = this.f35549a[this.f35550b];
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
            byte b11 = this.f35549a[this.f35550b + i11];
            if ((b11 & 192) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j11);
            }
            j11 = (j11 << 6) | ((long) (b11 & Utf8.REPLACEMENT_BYTE));
        }
        this.f35550b += i12;
        return j11;
    }

    public void L(int i11) {
        N(b() < i11 ? new byte[i11] : this.f35549a, i11);
    }

    public void M(byte[] bArr) {
        N(bArr, bArr.length);
    }

    public void N(byte[] bArr, int i11) {
        this.f35549a = bArr;
        this.f35551c = i11;
        this.f35550b = 0;
    }

    public void O(int i11) {
        a.a(i11 >= 0 && i11 <= this.f35549a.length);
        this.f35551c = i11;
    }

    public void P(int i11) {
        a.a(i11 >= 0 && i11 <= this.f35551c);
        this.f35550b = i11;
    }

    public void Q(int i11) {
        P(this.f35550b + i11);
    }

    public int a() {
        return this.f35551c - this.f35550b;
    }

    public int b() {
        return this.f35549a.length;
    }

    public void c(int i11) {
        if (i11 > b()) {
            this.f35549a = Arrays.copyOf(this.f35549a, i11);
        }
    }

    public byte[] d() {
        return this.f35549a;
    }

    public int e() {
        return this.f35550b;
    }

    public int f() {
        return this.f35551c;
    }

    public char g() {
        byte[] bArr = this.f35549a;
        int i11 = this.f35550b;
        return (char) ((bArr[i11 + 1] & 255) | ((bArr[i11] & 255) << 8));
    }

    public int h() {
        return this.f35549a[this.f35550b] & 255;
    }

    public void i(b0 b0Var, int i11) {
        j(b0Var.f35543a, 0, i11);
        b0Var.p(0);
    }

    public void j(byte[] bArr, int i11, int i12) {
        System.arraycopy(this.f35549a, this.f35550b, bArr, i11, i12);
        this.f35550b += i12;
    }

    @Nullable
    public String k(char c11) {
        if (a() == 0) {
            return null;
        }
        int i11 = this.f35550b;
        while (i11 < this.f35551c && this.f35549a[i11] != c11) {
            i11++;
        }
        byte[] bArr = this.f35549a;
        int i12 = this.f35550b;
        String strE = o0.E(bArr, i12, i11 - i12);
        this.f35550b = i11;
        if (i11 < this.f35551c) {
            this.f35550b = i11 + 1;
        }
        return strE;
    }

    public double l() {
        return Double.longBitsToDouble(w());
    }

    public float m() {
        return Float.intBitsToFloat(n());
    }

    public int n() {
        byte[] bArr = this.f35549a;
        int i11 = this.f35550b;
        int i12 = ((bArr[i11 + 1] & 255) << 16) | ((bArr[i11] & 255) << 24);
        int i13 = i11 + 3;
        int i14 = i12 | ((bArr[i11 + 2] & 255) << 8);
        this.f35550b = i11 + 4;
        return (bArr[i13] & 255) | i14;
    }

    public int o() {
        byte[] bArr = this.f35549a;
        int i11 = this.f35550b;
        int i12 = i11 + 2;
        int i13 = ((bArr[i11 + 1] & 255) << 8) | (((bArr[i11] & 255) << 24) >> 8);
        this.f35550b = i11 + 3;
        return (bArr[i12] & 255) | i13;
    }

    @Nullable
    public String p() {
        if (a() == 0) {
            return null;
        }
        int i11 = this.f35550b;
        while (i11 < this.f35551c && !o0.v0(this.f35549a[i11])) {
            i11++;
        }
        int i12 = this.f35550b;
        if (i11 - i12 >= 3) {
            byte[] bArr = this.f35549a;
            if (bArr[i12] == -17 && bArr[i12 + 1] == -69 && bArr[i12 + 2] == -65) {
                this.f35550b = i12 + 3;
            }
        }
        byte[] bArr2 = this.f35549a;
        int i13 = this.f35550b;
        String strE = o0.E(bArr2, i13, i11 - i13);
        this.f35550b = i11;
        int i14 = this.f35551c;
        if (i11 == i14) {
            return strE;
        }
        byte[] bArr3 = this.f35549a;
        if (bArr3[i11] == 13) {
            int i15 = i11 + 1;
            this.f35550b = i15;
            if (i15 == i14) {
                return strE;
            }
        }
        int i16 = this.f35550b;
        if (bArr3[i16] == 10) {
            this.f35550b = i16 + 1;
        }
        return strE;
    }

    public int q() {
        byte[] bArr = this.f35549a;
        int i11 = this.f35550b;
        int i12 = ((bArr[i11 + 1] & 255) << 8) | (bArr[i11] & 255);
        int i13 = i11 + 3;
        int i14 = i12 | ((bArr[i11 + 2] & 255) << 16);
        this.f35550b = i11 + 4;
        return ((bArr[i13] & 255) << 24) | i14;
    }

    public long r() {
        byte[] bArr = this.f35549a;
        int i11 = this.f35550b;
        int i12 = i11 + 7;
        long j11 = (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48);
        this.f35550b = i11 + 8;
        return ((((long) bArr[i12]) & 255) << 56) | j11;
    }

    public short s() {
        byte[] bArr = this.f35549a;
        int i11 = this.f35550b;
        int i12 = i11 + 1;
        int i13 = bArr[i11] & 255;
        this.f35550b = i11 + 2;
        return (short) (((bArr[i12] & 255) << 8) | i13);
    }

    public long t() {
        byte[] bArr = this.f35549a;
        int i11 = this.f35550b;
        int i12 = i11 + 3;
        long j11 = (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16);
        this.f35550b = i11 + 4;
        return ((((long) bArr[i12]) & 255) << 24) | j11;
    }

    public int u() {
        int iQ = q();
        if (iQ >= 0) {
            return iQ;
        }
        throw new IllegalStateException("Top bit not zero: " + iQ);
    }

    public int v() {
        byte[] bArr = this.f35549a;
        int i11 = this.f35550b;
        int i12 = i11 + 1;
        int i13 = bArr[i11] & 255;
        this.f35550b = i11 + 2;
        return ((bArr[i12] & 255) << 8) | i13;
    }

    public long w() {
        byte[] bArr = this.f35549a;
        int i11 = this.f35550b;
        int i12 = i11 + 7;
        long j11 = ((((long) bArr[i11]) & 255) << 56) | ((((long) bArr[i11 + 1]) & 255) << 48) | ((((long) bArr[i11 + 2]) & 255) << 40) | ((((long) bArr[i11 + 3]) & 255) << 32) | ((((long) bArr[i11 + 4]) & 255) << 24) | ((((long) bArr[i11 + 5]) & 255) << 16) | ((((long) bArr[i11 + 6]) & 255) << 8);
        this.f35550b = i11 + 8;
        return (((long) bArr[i12]) & 255) | j11;
    }

    @Nullable
    public String x() {
        return k((char) 0);
    }

    public String y(int i11) {
        if (i11 == 0) {
            return "";
        }
        int i12 = this.f35550b;
        int i13 = (i12 + i11) - 1;
        String strE = o0.E(this.f35549a, i12, (i13 >= this.f35551c || this.f35549a[i13] != 0) ? i11 : i11 - 1);
        this.f35550b += i11;
        return strE;
    }

    public short z() {
        byte[] bArr = this.f35549a;
        int i11 = this.f35550b;
        int i12 = i11 + 1;
        int i13 = (bArr[i11] & 255) << 8;
        this.f35550b = i11 + 2;
        return (short) ((bArr[i12] & 255) | i13);
    }
}
