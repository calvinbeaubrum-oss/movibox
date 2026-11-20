package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.nio.charset.Charset;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1376Hz {
    public static byte[] A03;
    public static String[] A04 = {"oSbtVRwphkTFlAHrFUFfvlQVewHH9uZD", "ke9406sA8vEe4ogcratlCLLRCygX4Y6v", "LkVrMYKeL4j", "rD3J2lWEcQES1OY4rXh7UnGCqOy7njew", "qJRaOB7ViewD6", "qa5huEKLFbsop1eqm4Yriado9DIEiYjV", "GSl3McmMnOZYTOuxGBg0tC3pnH", "ySC3qX4TjccxO5mLdOZ"};
    public byte[] A00;
    public int A01;
    public int A02;

    static {
        A01();
    }

    public C1376Hz() {
    }

    public C1376Hz(int i11) {
        this.A00 = new byte[i11];
        this.A01 = i11;
    }

    public C1376Hz(byte[] bArr) {
        this.A00 = bArr;
        this.A01 = bArr.length;
    }

    public C1376Hz(byte[] bArr, int i11) {
        this.A00 = bArr;
        this.A01 = i11;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            byte b11 = bArrCopyOfRange[i14];
            String[] strArr = A04;
            if (strArr[6].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[5] = "EdmI6fYX5kJGCYPfpqvG1yUufp2PCRFX";
            strArr2[3] = "bDUsxAC2PGUD72vhZpZ7z8M6PcC6y0P6";
            bArrCopyOfRange[i14] = (byte) ((b11 - i13) - 116);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{50, 87, 95, 74, 85, 82, 77, 9, 62, 61, 47, Ascii.SYN, 33, 9, 92, 78, 90, 94, 78, 87, 76, 78, 9, 76, 88, 87, 93, 82, 87, 94, 74, 93, 82, 88, 87, 9, 75, 98, 93, 78, 35, 9, 41, 78, 86, 65, 76, 73, 68, 0, 53, 52, 38, Ascii.CR, Ascii.CAN, 0, 83, 69, 81, 85, 69, 78, 67, 69, 0, 70, 73, 82, 83, 84, 0, 66, 89, 84, 69, Ascii.SUB, 0, -35, -8, -7, -87, -21, -14, -3, -87, -9, -8, -3, -87, 3, -18, -5, -8, -61, -87, -32, -33, -47, -72, -61};
    }

    public final char A02() {
        byte[] bArr = this.A00;
        int i11 = this.A02;
        return (char) ((bArr[i11 + 1] & 255) | ((bArr[i11] & 255) << 8));
    }

    public final double A03() {
        return Double.longBitsToDouble(A0L());
    }

    public final int A04() {
        return this.A01 - this.A02;
    }

    public final int A05() {
        byte[] bArr = this.A00;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public final int A06() {
        return this.A02;
    }

    public final int A07() {
        return this.A01;
    }

    public final int A08() {
        byte[] bArr = this.A00;
        int i11 = this.A02;
        int i12 = i11 + 1;
        this.A02 = i12;
        int i13 = (bArr[i11] & 255) << 24;
        int i14 = i12 + 1;
        this.A02 = i14;
        int i15 = i13 | ((bArr[i12] & 255) << 16);
        int i16 = i14 + 1;
        this.A02 = i16;
        int i17 = i15 | ((bArr[i14] & 255) << 8);
        this.A02 = i16 + 1;
        return (bArr[i16] & 255) | i17;
    }

    public final int A09() {
        byte[] bArr = this.A00;
        int i11 = this.A02;
        int i12 = i11 + 1;
        this.A02 = i12;
        int i13 = ((bArr[i11] & 255) << 24) >> 8;
        int i14 = i12 + 1;
        this.A02 = i14;
        int i15 = i13 | ((bArr[i12] & 255) << 8);
        this.A02 = i14 + 1;
        return (bArr[i14] & 255) | i15;
    }

    public final int A0A() {
        byte[] bArr = this.A00;
        int i11 = this.A02;
        int i12 = i11 + 1;
        this.A02 = i12;
        int i13 = bArr[i11] & 255;
        int i14 = i12 + 1;
        this.A02 = i14;
        int i15 = i13 | ((bArr[i12] & 255) << 8);
        int i16 = i14 + 1;
        this.A02 = i16;
        int i17 = i15 | ((bArr[i14] & 255) << 16);
        this.A02 = i16 + 1;
        return ((bArr[i16] & 255) << 24) | i17;
    }

    public final int A0B() {
        int iA0A = A0A();
        if (iA0A >= 0) {
            return iA0A;
        }
        throw new IllegalStateException(A00(77, 18, 21) + iA0A);
    }

    public final int A0C() {
        byte[] bArr = this.A00;
        int i11 = this.A02;
        int i12 = i11 + 1;
        this.A02 = i12;
        int i13 = bArr[i11] & 255;
        this.A02 = i12 + 1;
        return ((bArr[i12] & 255) << 8) | i13;
    }

    public final int A0D() {
        return (A0E() << 21) | (A0E() << 14) | (A0E() << 7) | A0E();
    }

    public final int A0E() {
        byte[] bArr = this.A00;
        int i11 = this.A02;
        this.A02 = i11 + 1;
        return bArr[i11] & 255;
    }

    public final int A0F() {
        byte[] bArr = this.A00;
        int i11 = this.A02;
        int i12 = i11 + 1;
        this.A02 = i12;
        int i13 = (bArr[i11] & 255) << 8;
        int i14 = i12 + 1;
        this.A02 = i14;
        int i15 = (bArr[i12] & 255) | i13;
        this.A02 = i14 + 2;
        return i15;
    }

    public final int A0G() {
        byte[] bArr = this.A00;
        int i11 = this.A02;
        int i12 = i11 + 1;
        this.A02 = i12;
        int i13 = (bArr[i11] & 255) << 16;
        int i14 = i12 + 1;
        this.A02 = i14;
        int i15 = i13 | ((bArr[i12] & 255) << 8);
        this.A02 = i14 + 1;
        return (bArr[i14] & 255) | i15;
    }

    public final int A0H() {
        int iA08 = A08();
        if (iA08 >= 0) {
            return iA08;
        }
        throw new IllegalStateException(A00(77, 18, 21) + iA08);
    }

    public final int A0I() {
        byte[] bArr = this.A00;
        int i11 = this.A02;
        int i12 = i11 + 1;
        this.A02 = i12;
        int i13 = (bArr[i11] & 255) << 8;
        this.A02 = i12 + 1;
        return (bArr[i12] & 255) | i13;
    }

    public final long A0J() {
        byte[] bArr = this.A00;
        int i11 = this.A02;
        int i12 = i11 + 1;
        this.A02 = i12;
        long j11 = ((long) bArr[i11]) & 255;
        int i13 = i12 + 1;
        this.A02 = i13;
        long j12 = j11 | ((((long) bArr[i12]) & 255) << 8);
        int i14 = i13 + 1;
        this.A02 = i14;
        long j13 = j12 | ((((long) bArr[i13]) & 255) << 16);
        int i15 = i14 + 1;
        this.A02 = i15;
        long j14 = j13 | ((((long) bArr[i14]) & 255) << 24);
        int i16 = i15 + 1;
        this.A02 = i16;
        long j15 = j14 | ((((long) bArr[i15]) & 255) << 32);
        int i17 = i16 + 1;
        this.A02 = i17;
        long j16 = j15 | ((((long) bArr[i16]) & 255) << 40);
        int i18 = i17 + 1;
        this.A02 = i18;
        long j17 = j16 | ((((long) bArr[i17]) & 255) << 48);
        this.A02 = i18 + 1;
        return ((((long) bArr[i18]) & 255) << 56) | j17;
    }

    public final long A0K() {
        byte[] bArr = this.A00;
        int i11 = this.A02;
        int i12 = i11 + 1;
        this.A02 = i12;
        long j11 = ((long) bArr[i11]) & 255;
        int i13 = i12 + 1;
        this.A02 = i13;
        long j12 = j11 | ((((long) bArr[i12]) & 255) << 8);
        int i14 = i13 + 1;
        this.A02 = i14;
        long j13 = j12 | ((((long) bArr[i13]) & 255) << 16);
        this.A02 = i14 + 1;
        return ((((long) bArr[i14]) & 255) << 24) | j13;
    }

    public final long A0L() {
        byte[] bArr = this.A00;
        int i11 = this.A02;
        int i12 = i11 + 1;
        this.A02 = i12;
        long j11 = (((long) bArr[i11]) & 255) << 56;
        int i13 = i12 + 1;
        this.A02 = i13;
        long j12 = j11 | ((((long) bArr[i12]) & 255) << 48);
        int i14 = i13 + 1;
        this.A02 = i14;
        long j13 = j12 | ((((long) bArr[i13]) & 255) << 40);
        int i15 = i14 + 1;
        this.A02 = i15;
        long j14 = j13 | ((((long) bArr[i14]) & 255) << 32);
        int i16 = i15 + 1;
        this.A02 = i16;
        long j15 = j14 | ((((long) bArr[i15]) & 255) << 24);
        int i17 = i16 + 1;
        this.A02 = i17;
        long j16 = j15 | ((((long) bArr[i16]) & 255) << 16);
        int i18 = i17 + 1;
        this.A02 = i18;
        long j17 = j16 | ((((long) bArr[i17]) & 255) << 8);
        this.A02 = i18 + 1;
        return (((long) bArr[i18]) & 255) | j17;
    }

    public final long A0M() {
        byte[] bArr = this.A00;
        int i11 = this.A02;
        int i12 = i11 + 1;
        this.A02 = i12;
        long j11 = (((long) bArr[i11]) & 255) << 24;
        int i13 = i12 + 1;
        this.A02 = i13;
        long j12 = j11 | ((((long) bArr[i12]) & 255) << 16);
        int i14 = i13 + 1;
        this.A02 = i14;
        long j13 = j12 | ((((long) bArr[i13]) & 255) << 8);
        this.A02 = i14 + 1;
        return (((long) bArr[i14]) & 255) | j13;
    }

    public final long A0N() {
        long jA0L = A0L();
        if (jA0L >= 0) {
            return jA0L;
        }
        throw new IllegalStateException(A00(77, 18, 21) + jA0L);
    }

    public final long A0O() {
        int i11 = 0;
        long j11 = this.A00[this.A02];
        for (int i12 = 7; i12 >= 0; i12--) {
            if ((((long) (1 << i12)) & j11) == 0) {
                if (i12 >= 6) {
                    if (i12 != 7) {
                        break;
                    }
                    i11 = 1;
                    break;
                }
                j11 &= (long) ((1 << i12) - 1);
                i11 = 7 - i12;
                break;
            }
        }
        if (i11 == 0) {
            throw new NumberFormatException(A00(42, 35, 108) + j11);
        }
        for (int i13 = 1; i13 < i11; i13++) {
            byte[] bArr = this.A00;
            int i14 = this.A02;
            if (A04[2].length() != 11) {
                throw new RuntimeException();
            }
            A04[2] = "bgE5KGMxqsO";
            byte b11 = bArr[i14 + i13];
            if ((b11 & 192) != 128) {
                throw new NumberFormatException(A00(0, 42, 117) + j11);
            }
            j11 = (j11 << 6) | ((long) (b11 & Utf8.REPLACEMENT_BYTE));
        }
        this.A02 += i11;
        return j11;
    }

    public final String A0P() {
        if (A04() == 0) {
            return null;
        }
        int i11 = this.A02;
        while (i11 < this.A01 && !IF.A0d(this.A00[i11])) {
            i11++;
        }
        int i12 = this.A02;
        if (i11 - i12 >= 3) {
            byte[] bArr = this.A00;
            if (bArr[i12] == -17 && bArr[i12 + 1] == -69 && bArr[i12 + 2] == -65) {
                this.A02 = i12 + 3;
            }
        }
        byte[] bArr2 = this.A00;
        int i13 = this.A02;
        String strA0R = IF.A0R(bArr2, i13, i11 - i13);
        this.A02 = i11;
        int i14 = this.A01;
        if (i11 == i14) {
            return strA0R;
        }
        byte[] bArr3 = this.A00;
        if (bArr3[i11] == 13) {
            int i15 = i11 + 1;
            this.A02 = i15;
            if (i15 == i14) {
                return strA0R;
            }
        }
        int i16 = this.A02;
        if (A04[0].charAt(27) == 'i') {
            throw new RuntimeException();
        }
        A04[7] = "dK52fOK8jWv7xyi3a3n";
        if (bArr3[i16] == 10) {
            int i17 = i16 + 1;
            if (A04[0].charAt(27) != 'i') {
                String[] strArr = A04;
                strArr[5] = "CzkRNJa9FDUHAtzqy7ViO0FrfGLEXvBM";
                strArr[3] = "L6K2rBVJE7KS5cY2UbZwATPHMS3LrQAX";
                this.A02 = i17;
            } else {
                A04[0] = "fuXjTapUFN2iKU6xFo1uSk4UrCSPBhbp";
                this.A02 = i17;
            }
        }
        return strA0R;
    }

    public final String A0Q() {
        if (A04() == 0) {
            return null;
        }
        int i11 = this.A02;
        while (i11 < this.A01 && this.A00[i11] != 0) {
            i11++;
        }
        byte[] bArr = this.A00;
        int i12 = this.A02;
        String strA0R = IF.A0R(bArr, i12, i11 - i12);
        this.A02 = i11;
        if (i11 < this.A01) {
            this.A02 = i11 + 1;
        }
        return strA0R;
    }

    public final String A0R(int i11) {
        if (i11 == 0) {
            return A00(0, 0, 25);
        }
        int i12 = i11;
        int i13 = this.A02;
        int i14 = (i13 + i11) - 1;
        if (i14 < this.A01 && this.A00[i14] == 0) {
            i12--;
        }
        String strA0R = IF.A0R(this.A00, i13, i12);
        String[] strArr = A04;
        if (strArr[6].length() == strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[6] = "dyM2aynMSNvMWhKjh5bvH5o1wH";
        strArr2[4] = "u6o51QVZzHu50";
        this.A02 += i11;
        return strA0R;
    }

    public final String A0S(int i11) {
        return A0T(i11, Charset.forName(A00(95, 5, 23)));
    }

    public final String A0T(int i11, Charset charset) {
        String str = new String(this.A00, this.A02, i11, charset);
        this.A02 += i11;
        return str;
    }

    public final short A0U() {
        byte[] bArr = this.A00;
        int i11 = this.A02;
        int i12 = i11 + 1;
        this.A02 = i12;
        int i13 = (bArr[i11] & 255) << 8;
        this.A02 = i12 + 1;
        return (short) ((bArr[i12] & 255) | i13);
    }

    public final void A0V() {
        this.A02 = 0;
        this.A01 = 0;
    }

    public final void A0W(int i11) {
        A0b(A05() < i11 ? new byte[i11] : this.A00, i11);
    }

    public final void A0X(int i11) {
        AbstractC1351Ha.A03(i11 >= 0 && i11 <= this.A00.length);
        this.A01 = i11;
    }

    public final void A0Y(int i11) {
        AbstractC1351Ha.A03(i11 >= 0 && i11 <= this.A01);
        this.A02 = i11;
    }

    public final void A0Z(int i11) {
        A0Y(this.A02 + i11);
    }

    public final void A0a(C1375Hy c1375Hy, int i11) {
        A0c(c1375Hy.A00, 0, i11);
        c1375Hy.A07(0);
    }

    public final void A0b(byte[] bArr, int i11) {
        this.A00 = bArr;
        this.A01 = i11;
        this.A02 = 0;
    }

    public final void A0c(byte[] bArr, int i11, int i12) {
        System.arraycopy(this.A00, this.A02, bArr, i11, i12);
        this.A02 += i12;
    }
}
