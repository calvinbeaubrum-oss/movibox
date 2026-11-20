package z3;

import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Chars;
import java.nio.charset.Charset;
import java.util.Arrays;
import okhttp3.internal.http2.Settings;
import okio.Utf8;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final char[] f81761d = {'\r', '\n'};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final char[] f81762e = {'\n'};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ImmutableSet<Charset> f81763f = ImmutableSet.of(com.google.common.base.c.f38163a, com.google.common.base.c.f38165c, com.google.common.base.c.f38168f, com.google.common.base.c.f38166d, com.google.common.base.c.f38167e);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f81764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f81765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f81766c;

    public c0() {
        this.f81764a = u0.f81843f;
    }

    public c0(int i11) {
        this.f81764a = new byte[i11];
        this.f81766c = i11;
    }

    public c0(byte[] bArr) {
        this.f81764a = bArr;
        this.f81766c = bArr.length;
    }

    public c0(byte[] bArr, int i11) {
        this.f81764a = bArr;
        this.f81766c = i11;
    }

    public long A() {
        byte[] bArr = this.f81764a;
        int i11 = this.f81765b;
        int i12 = i11 + 7;
        long j11 = ((((long) bArr[i11]) & 255) << 56) | ((((long) bArr[i11 + 1]) & 255) << 48) | ((((long) bArr[i11 + 2]) & 255) << 40) | ((((long) bArr[i11 + 3]) & 255) << 32) | ((((long) bArr[i11 + 4]) & 255) << 24) | ((((long) bArr[i11 + 5]) & 255) << 16) | ((((long) bArr[i11 + 6]) & 255) << 8);
        this.f81765b = i11 + 8;
        return (((long) bArr[i12]) & 255) | j11;
    }

    @Nullable
    public String B() {
        return n((char) 0);
    }

    public String C(int i11) {
        if (i11 == 0) {
            return "";
        }
        int i12 = this.f81765b;
        int i13 = (i12 + i11) - 1;
        String strI = u0.I(this.f81764a, i12, (i13 >= this.f81766c || this.f81764a[i13] != 0) ? i11 : i11 - 1);
        this.f81765b += i11;
        return strI;
    }

    public short D() {
        byte[] bArr = this.f81764a;
        int i11 = this.f81765b;
        int i12 = i11 + 1;
        int i13 = (bArr[i11] & 255) << 8;
        this.f81765b = i11 + 2;
        return (short) ((bArr[i12] & 255) | i13);
    }

    public String E(int i11) {
        return F(i11, com.google.common.base.c.f38165c);
    }

    public String F(int i11, Charset charset) {
        String str = new String(this.f81764a, this.f81765b, i11, charset);
        this.f81765b += i11;
        return str;
    }

    public int G() {
        return (H() << 21) | (H() << 14) | (H() << 7) | H();
    }

    public int H() {
        byte[] bArr = this.f81764a;
        int i11 = this.f81765b;
        this.f81765b = i11 + 1;
        return bArr[i11] & 255;
    }

    public int I() {
        byte[] bArr = this.f81764a;
        int i11 = this.f81765b;
        int i12 = (bArr[i11 + 1] & 255) | ((bArr[i11] & 255) << 8);
        this.f81765b = i11 + 4;
        return i12;
    }

    public long J() {
        byte[] bArr = this.f81764a;
        int i11 = this.f81765b;
        int i12 = i11 + 3;
        long j11 = ((((long) bArr[i11]) & 255) << 24) | ((((long) bArr[i11 + 1]) & 255) << 16) | ((((long) bArr[i11 + 2]) & 255) << 8);
        this.f81765b = i11 + 4;
        return (((long) bArr[i12]) & 255) | j11;
    }

    public int K() {
        byte[] bArr = this.f81764a;
        int i11 = this.f81765b;
        int i12 = i11 + 2;
        int i13 = ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11] & 255) << 16);
        this.f81765b = i11 + 3;
        return (bArr[i12] & 255) | i13;
    }

    public int L() {
        int iQ = q();
        if (iQ >= 0) {
            return iQ;
        }
        throw new IllegalStateException("Top bit not zero: " + iQ);
    }

    public long M() {
        long jA = A();
        if (jA >= 0) {
            return jA;
        }
        throw new IllegalStateException("Top bit not zero: " + jA);
    }

    public int N() {
        byte[] bArr = this.f81764a;
        int i11 = this.f81765b;
        int i12 = i11 + 1;
        int i13 = (bArr[i11] & 255) << 8;
        this.f81765b = i11 + 2;
        return (bArr[i12] & 255) | i13;
    }

    public long O() {
        int i11;
        int i12;
        long j11 = this.f81764a[this.f81765b];
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
            byte b11 = this.f81764a[this.f81765b + i11];
            if ((b11 & 192) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j11);
            }
            j11 = (j11 << 6) | ((long) (b11 & Utf8.REPLACEMENT_BYTE));
        }
        this.f81765b += i12;
        return j11;
    }

    @Nullable
    public Charset P() {
        if (a() >= 3) {
            byte[] bArr = this.f81764a;
            int i11 = this.f81765b;
            if (bArr[i11] == -17 && bArr[i11 + 1] == -69 && bArr[i11 + 2] == -65) {
                this.f81765b = i11 + 3;
                return com.google.common.base.c.f38165c;
            }
        }
        if (a() < 2) {
            return null;
        }
        byte[] bArr2 = this.f81764a;
        int i12 = this.f81765b;
        byte b11 = bArr2[i12];
        if (b11 == -2 && bArr2[i12 + 1] == -1) {
            this.f81765b = i12 + 2;
            return com.google.common.base.c.f38166d;
        }
        if (b11 != -1 || bArr2[i12 + 1] != -2) {
            return null;
        }
        this.f81765b = i12 + 2;
        return com.google.common.base.c.f38167e;
    }

    public void Q(int i11) {
        S(b() < i11 ? new byte[i11] : this.f81764a, i11);
    }

    public void R(byte[] bArr) {
        S(bArr, bArr.length);
    }

    public void S(byte[] bArr, int i11) {
        this.f81764a = bArr;
        this.f81766c = i11;
        this.f81765b = 0;
    }

    public void T(int i11) {
        a.a(i11 >= 0 && i11 <= this.f81764a.length);
        this.f81766c = i11;
    }

    public void U(int i11) {
        a.a(i11 >= 0 && i11 <= this.f81766c);
        this.f81765b = i11;
    }

    public void V(int i11) {
        U(this.f81765b + i11);
    }

    public final void W(Charset charset) {
        if (m(charset, f81761d) == '\r') {
            m(charset, f81762e);
        }
    }

    public int a() {
        return this.f81766c - this.f81765b;
    }

    public int b() {
        return this.f81764a.length;
    }

    public void c(int i11) {
        if (i11 > b()) {
            this.f81764a = Arrays.copyOf(this.f81764a, i11);
        }
    }

    public final int d(Charset charset) {
        int i11;
        if (charset.equals(com.google.common.base.c.f38165c) || charset.equals(com.google.common.base.c.f38163a)) {
            i11 = 1;
        } else {
            if (!charset.equals(com.google.common.base.c.f38168f) && !charset.equals(com.google.common.base.c.f38167e) && !charset.equals(com.google.common.base.c.f38166d)) {
                throw new IllegalArgumentException("Unsupported charset: " + charset);
            }
            i11 = 2;
        }
        int i12 = this.f81765b;
        while (true) {
            int i13 = this.f81766c;
            if (i12 >= i13 - (i11 - 1)) {
                return i13;
            }
            if ((charset.equals(com.google.common.base.c.f38165c) || charset.equals(com.google.common.base.c.f38163a)) && u0.K0(this.f81764a[i12])) {
                return i12;
            }
            if (charset.equals(com.google.common.base.c.f38168f) || charset.equals(com.google.common.base.c.f38166d)) {
                byte[] bArr = this.f81764a;
                if (bArr[i12] == 0 && u0.K0(bArr[i12 + 1])) {
                    return i12;
                }
            }
            if (charset.equals(com.google.common.base.c.f38167e)) {
                byte[] bArr2 = this.f81764a;
                if (bArr2[i12 + 1] == 0 && u0.K0(bArr2[i12])) {
                    return i12;
                }
            }
            i12 += i11;
        }
    }

    public byte[] e() {
        return this.f81764a;
    }

    public int f() {
        return this.f81765b;
    }

    public int g() {
        return this.f81766c;
    }

    public char h(Charset charset) {
        a.b(f81763f.contains(charset), "Unsupported charset: " + charset);
        return (char) (i(charset) >> 16);
    }

    public final int i(Charset charset) {
        byte bA;
        char cD;
        int i11 = 1;
        if ((charset.equals(com.google.common.base.c.f38165c) || charset.equals(com.google.common.base.c.f38163a)) && a() >= 1) {
            bA = (byte) Chars.a(com.google.common.primitives.g.c(this.f81764a[this.f81765b]));
        } else {
            if ((charset.equals(com.google.common.base.c.f38168f) || charset.equals(com.google.common.base.c.f38166d)) && a() >= 2) {
                byte[] bArr = this.f81764a;
                int i12 = this.f81765b;
                cD = Chars.d(bArr[i12], bArr[i12 + 1]);
            } else {
                if (!charset.equals(com.google.common.base.c.f38167e) || a() < 2) {
                    return 0;
                }
                byte[] bArr2 = this.f81764a;
                int i13 = this.f81765b;
                cD = Chars.d(bArr2[i13 + 1], bArr2[i13]);
            }
            bA = (byte) cD;
            i11 = 2;
        }
        return (Chars.a(bA) << 16) + i11;
    }

    public int j() {
        return this.f81764a[this.f81765b] & 255;
    }

    public void k(b0 b0Var, int i11) {
        l(b0Var.f81757a, 0, i11);
        b0Var.p(0);
    }

    public void l(byte[] bArr, int i11, int i12) {
        System.arraycopy(this.f81764a, this.f81765b, bArr, i11, i12);
        this.f81765b += i12;
    }

    public final char m(Charset charset, char[] cArr) {
        int i11 = i(charset);
        if (i11 == 0) {
            return (char) 0;
        }
        char c11 = (char) (i11 >> 16);
        if (!Chars.c(cArr, c11)) {
            return (char) 0;
        }
        this.f81765b += i11 & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        return c11;
    }

    @Nullable
    public String n(char c11) {
        if (a() == 0) {
            return null;
        }
        int i11 = this.f81765b;
        while (i11 < this.f81766c && this.f81764a[i11] != c11) {
            i11++;
        }
        byte[] bArr = this.f81764a;
        int i12 = this.f81765b;
        String strI = u0.I(bArr, i12, i11 - i12);
        this.f81765b = i11;
        if (i11 < this.f81766c) {
            this.f81765b = i11 + 1;
        }
        return strI;
    }

    public double o() {
        return Double.longBitsToDouble(A());
    }

    public float p() {
        return Float.intBitsToFloat(q());
    }

    public int q() {
        byte[] bArr = this.f81764a;
        int i11 = this.f81765b;
        int i12 = ((bArr[i11 + 1] & 255) << 16) | ((bArr[i11] & 255) << 24);
        int i13 = i11 + 3;
        int i14 = i12 | ((bArr[i11 + 2] & 255) << 8);
        this.f81765b = i11 + 4;
        return (bArr[i13] & 255) | i14;
    }

    public int r() {
        byte[] bArr = this.f81764a;
        int i11 = this.f81765b;
        int i12 = i11 + 2;
        int i13 = ((bArr[i11 + 1] & 255) << 8) | (((bArr[i11] & 255) << 24) >> 8);
        this.f81765b = i11 + 3;
        return (bArr[i12] & 255) | i13;
    }

    @Nullable
    public String s() {
        return t(com.google.common.base.c.f38165c);
    }

    @Nullable
    public String t(Charset charset) {
        a.b(f81763f.contains(charset), "Unsupported charset: " + charset);
        if (a() == 0) {
            return null;
        }
        if (!charset.equals(com.google.common.base.c.f38163a)) {
            P();
        }
        String strF = F(d(charset) - this.f81765b, charset);
        if (this.f81765b == this.f81766c) {
            return strF;
        }
        W(charset);
        return strF;
    }

    public int u() {
        byte[] bArr = this.f81764a;
        int i11 = this.f81765b;
        int i12 = ((bArr[i11 + 1] & 255) << 8) | (bArr[i11] & 255);
        int i13 = i11 + 3;
        int i14 = i12 | ((bArr[i11 + 2] & 255) << 16);
        this.f81765b = i11 + 4;
        return ((bArr[i13] & 255) << 24) | i14;
    }

    public long v() {
        byte[] bArr = this.f81764a;
        int i11 = this.f81765b;
        int i12 = i11 + 7;
        long j11 = (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48);
        this.f81765b = i11 + 8;
        return ((((long) bArr[i12]) & 255) << 56) | j11;
    }

    public short w() {
        byte[] bArr = this.f81764a;
        int i11 = this.f81765b;
        int i12 = i11 + 1;
        int i13 = bArr[i11] & 255;
        this.f81765b = i11 + 2;
        return (short) (((bArr[i12] & 255) << 8) | i13);
    }

    public long x() {
        byte[] bArr = this.f81764a;
        int i11 = this.f81765b;
        int i12 = i11 + 3;
        long j11 = (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16);
        this.f81765b = i11 + 4;
        return ((((long) bArr[i12]) & 255) << 24) | j11;
    }

    public int y() {
        int iU = u();
        if (iU >= 0) {
            return iU;
        }
        throw new IllegalStateException("Top bit not zero: " + iU);
    }

    public int z() {
        byte[] bArr = this.f81764a;
        int i11 = this.f81765b;
        int i12 = i11 + 1;
        int i13 = bArr[i11] & 255;
        this.f81765b = i11 + 2;
        return ((bArr[i12] & 255) << 8) | i13;
    }
}
