package com.facebook.ads.redexgen.uinode;

import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Cv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1258Cv {
    public static byte[] A00;
    public static String[] A01 = {"7VlHbmI4sHauhoCWaFlUZM9mZRV70mzp", "LqGkn09UNvdqUAgssIpSCyoRJ1iI6QKK", "ZmFU8Mfu7g0bs6JKYNiQ5l9NQyV6", "IM1BduvbFOrOx4pkelis2wS2axXVXfJJ", "7P5Q", "68Q2Pgf", "FTYWHoYlDOl1N68V4e618z2hAoSaWMYg", "QxGNaBvq4MkZwy6AnQRq9NbnhINTK41p"};

    static {
        A06();
    }

    public static int A00(int i11) {
        int i12 = 0;
        while (i11 > 0) {
            i12++;
            i11 >>>= 1;
        }
        return i12;
    }

    public static long A01(long j11, long j12) {
        return (long) Math.floor(Math.pow(j11, 1.0d / j12));
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:47:0x00f2  */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00bf, code lost:
    
        if (r12 <= 2) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c1, code lost:
    
        if (r12 == 1) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c3, code lost:
    
        if (r12 != r0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c5, code lost:
    
        r14.A03(32);
        r14.A03(32);
        r4 = r14.A02(4) + 1;
        r14.A03(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00d5, code lost:
    
        if (r12 != 1) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d7, code lost:
    
        if (r9 == 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d9, code lost:
    
        r0 = A01(r10, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00df, code lost:
    
        r14.A03((int) (((long) r4) * r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ea, code lost:
    
        return new com.facebook.ads.redexgen.uinode.C1255Cr(r9, r10, r11, r12, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00eb, code lost:
    
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ee, code lost:
    
        r0 = ((long) r10) * ((long) r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00f3, code lost:
    
        if (r12 <= 2) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0116, code lost:
    
        throw new com.facebook.ads.redexgen.uinode.C11849v(A05(228, 42, okhttp3.internal.ws.WebSocketProtocol.PAYLOAD_SHORT) + r12);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C1255Cr A02(C1253Cp c1253Cp) throws C11849v {
        int i11;
        if (c1253Cp.A02(24) != 5653314) {
            throw new C11849v(A05(38, 55, 48) + c1253Cp.A01());
        }
        int iA02 = c1253Cp.A02(16);
        int iA03 = c1253Cp.A02(24);
        long[] jArr = new long[iA03];
        boolean zA04 = c1253Cp.A04();
        if (zA04) {
            int iA04 = c1253Cp.A02(5) + 1;
            if (A01[2].length() == 28) {
                String[] strArr = A01;
                strArr[1] = "1cSOg3h3ybf5GdNSDQ1j15ANMpdZWzzr";
                strArr[7] = "jhd3qNXlvMIll0ru3ldJW8SSybUsx7s0";
                int i12 = 0;
                while (i12 < jArr.length) {
                    int iA05 = c1253Cp.A02(A00(iA03 - i12));
                    for (int i13 = 0; i13 < iA05 && i12 < jArr.length; i13++) {
                        jArr[i12] = iA04;
                        i12++;
                    }
                    iA04++;
                }
                int iA06 = c1253Cp.A02(4);
                if (A01[4].length() != 21) {
                    String[] strArr2 = A01;
                    strArr2[1] = "KIsHkHKvV7xwjCpzTZWlwmB6O9ozk4U5";
                    strArr2[7] = "gTkrsBAD0STtBzLAHVDmD3NWQB3XU8zx";
                    i11 = 2;
                } else {
                    i11 = 2;
                }
            }
            throw new RuntimeException();
        }
        boolean zA05 = c1253Cp.A04();
        for (int i14 = 0; i14 < jArr.length; i14++) {
            if (!zA05) {
                jArr[i14] = c1253Cp.A02(5) + 1;
            } else if (c1253Cp.A04()) {
                jArr[i14] = c1253Cp.A02(5) + 1;
            } else {
                if (A01[2].length() != 28) {
                    throw new RuntimeException();
                }
                A01[4] = "ecSAxFMYmzVL";
                jArr[i14] = 0;
            }
        }
        int iA07 = c1253Cp.A02(4);
        if (A01[4].length() != 21) {
            String[] strArr3 = A01;
            strArr3[1] = "KIsHkHKvV7xwjCpzTZWlwmB6O9ozk4U5";
            strArr3[7] = "gTkrsBAD0STtBzLAHVDmD3NWQB3XU8zx";
            i11 = 2;
        } else {
            i11 = 2;
        }
    }

    public static C1256Cs A03(C1376Hz c1376Hz) throws C11849v {
        A0A(3, c1376Hz, false);
        String strA0S = c1376Hz.A0S((int) c1376Hz.A0K());
        int length = 7 + 4 + strA0S.length();
        long jA0K = c1376Hz.A0K();
        String[] strArr = new String[(int) jA0K];
        int length2 = length + 4;
        int i11 = 0;
        while (true) {
            long j11 = i11;
            if (A01[3].charAt(18) != 'i') {
                throw new RuntimeException();
            }
            A01[5] = "ziwCMa4";
            if (j11 >= jA0K) {
                if ((c1376Hz.A0E() & 1) != 0) {
                    return new C1256Cs(strA0S, strArr, length2 + 1);
                }
                throw new C11849v(A05(198, 30, 84));
            }
            strArr[i11] = c1376Hz.A0S((int) c1376Hz.A0K());
            length2 = length2 + 4 + strArr[i11].length();
            i11++;
        }
    }

    public static C1257Cu A04(C1376Hz c1376Hz) throws C11849v {
        A0A(1, c1376Hz, false);
        long jA0K = c1376Hz.A0K();
        int iA0E = c1376Hz.A0E();
        long jA0K2 = c1376Hz.A0K();
        int iA0A = c1376Hz.A0A();
        int iA0A2 = c1376Hz.A0A();
        int iA0A3 = c1376Hz.A0A();
        int iA0E2 = c1376Hz.A0E();
        return new C1257Cu(jA0K, iA0E, jA0K2, iA0A, iA0A2, iA0A3, (int) Math.pow(2.0d, iA0E2 & 15), (int) Math.pow(2.0d, (iA0E2 & 240) >> 4), (c1376Hz.A0E() & 1) > 0, Arrays.copyOf(c1376Hz.A00, c1376Hz.A07()));
    }

    public static String A05(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 2);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A00 = new byte[]{116, 77, 80, 64, 75, 81, 119, 86, 75, 78, Ascii.FS, 1, 9, Ascii.FS, Ascii.SUB, Ascii.CR, Ascii.FS, Ascii.GS, 89, Ascii.SUB, 17, Ascii.CAN, Ascii.VT, Ascii.CAN, Ascii.SUB, Ascii.CR, Ascii.FS, Ascii.VT, 10, 89, 94, Ascii.SI, Ascii.SYN, Ascii.VT, Ascii.ESC, Ascii.DLE, 10, 94, 87, 74, 66, 87, 81, 70, 87, 86, Ascii.DC2, 81, 93, 86, 87, Ascii.DC2, 80, 93, 93, 89, Ascii.DC2, 70, 93, Ascii.DC2, 65, 70, 83, 64, 70, Ascii.DC2, 69, 91, 70, 90, Ascii.DC2, 105, 2, 74, 7, 4, Ascii.RS, Ascii.DC2, 2, 74, 6, 1, Ascii.RS, Ascii.DC2, 2, 74, 6, 0, 111, Ascii.DC2, 83, 70, Ascii.DC2, 78, 83, 91, 78, 72, 95, 78, 79, Ascii.VT, 67, 78, 74, 79, 78, 89, Ascii.VT, 95, 82, 91, 78, Ascii.VT, 70, 76, 79, 79, 82, 0, 84, 89, 80, 69, 0, 71, 82, 69, 65, 84, 69, 82, 0, 84, 72, 65, 78, 0, 17, 0, 78, 79, 84, 0, 68, 69, 67, 79, 68, 65, 66, 76, 69, Ascii.SUB, 0, 49, 37, 54, 58, 62, 57, 48, 119, 53, 62, 35, 119, 54, 49, 35, 50, 37, 119, 58, 56, 51, 50, 36, 119, 57, 56, 35, 119, 36, 50, 35, 119, 54, 36, 119, 50, 47, 39, 50, 52, 35, 50, 51, 48, 36, 55, 59, Utf8.REPLACEMENT_BYTE, 56, 49, 118, 52, Utf8.REPLACEMENT_BYTE, 34, 118, 51, 46, 38, 51, 53, 34, 51, 50, 118, 34, 57, 118, 52, 51, 118, 37, 51, 34, Ascii.DLE, 19, 19, Ascii.ETB, 9, Ascii.FF, 92, 8, 5, Ascii.FF, Ascii.EM, 92, Ascii.ESC, Ascii.SO, Ascii.EM, Ascii.GS, 8, Ascii.EM, Ascii.SO, 92, 8, Ascii.DC4, Ascii.GS, Ascii.DC2, 92, 78, 92, Ascii.DC2, 19, 8, 92, Ascii.CAN, Ascii.EM, Ascii.US, 19, Ascii.CAN, Ascii.GS, Ascii.RS, Ascii.DLE, Ascii.EM, 70, 92, 104, 100, 117, 117, 108, 107, 98, 37, 113, 124, 117, 96, 37, 106, 113, 109, 96, 119, 37, 113, 109, 100, 107, 37, 53, 37, 107, 106, 113, 37, 118, 112, 117, 117, 106, 119, 113, 96, 97, Utf8.REPLACEMENT_BYTE, 37, 93, 65, 76, 78, 72, 69, 66, 65, 73, 72, 95, Ascii.CR, 66, 75, Ascii.CR, 89, 68, 64, 72, Ascii.CR, 73, 66, 64, 76, 68, 67, Ascii.CR, 89, 95, 76, 67, 94, 75, 66, 95, 64, 94, Ascii.CR, 67, 66, 89, Ascii.CR, 87, 72, 95, 66, 72, 73, Ascii.CR, 66, 88, 89, 114, 101, 115, 105, 100, 117, 101, 84, 121, 112, 101, 32, 103, 114, 101, 97, 116, 101, 114, 32, 116, 104, 97, 110, 32, 50, 32, 105, 115, 32, 110, 111, 116, 32, 100, 101, 99, 111, 100, 97, 98, 108, 101, 107, 112, Utf8.REPLACEMENT_BYTE, 109, 122, 108, 122, 109, 105, 122, 123, Utf8.REPLACEMENT_BYTE, 125, 118, 107, 108, Utf8.REPLACEMENT_BYTE, 114, 106, 108, 107, Utf8.REPLACEMENT_BYTE, 125, 122, Utf8.REPLACEMENT_BYTE, 101, 122, 109, 112, Utf8.REPLACEMENT_BYTE, 126, 121, 107, 122, 109, Utf8.REPLACEMENT_BYTE, 114, 126, 111, 111, 118, 113, 120, Utf8.REPLACEMENT_BYTE, 124, 112, 106, 111, 115, 118, 113, 120, Utf8.REPLACEMENT_BYTE, 108, 107, 122, 111, 108, 82, 73, 73, 6, 85, 78, 73, 84, 82, 6, 78, 67, 71, 66, 67, 84, Ascii.FS, 6};
        if (A01[2].length() != 28) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[6] = "mgdhOJqoKNbrHZTmAlzuBC741swozh2A";
        strArr[0] = "We2DdWBOrlseFOiGq0myNglhwb5nF2sN";
    }

    public static void A07(int i11, C1253Cp c1253Cp) throws C11849v {
        int iA02 = c1253Cp.A02(6) + 1;
        for (int i12 = 0; i12 < iA02; i12++) {
            int iA03 = c1253Cp.A02(16);
            switch (iA03) {
                case 0:
                    int iA04 = c1253Cp.A04() ? c1253Cp.A02(4) + 1 : 1;
                    if (c1253Cp.A04()) {
                        int iA05 = c1253Cp.A02(8) + 1;
                        for (int i13 = 0; i13 < iA05; i13++) {
                            c1253Cp.A03(A00(i11 - 1));
                            c1253Cp.A03(A00(i11 - 1));
                        }
                    }
                    if (c1253Cp.A02(2) != 0) {
                        throw new C11849v(A05(406, 58, 29));
                    }
                    if (iA04 > 1) {
                        for (int i14 = 0; i14 < i11; i14++) {
                            c1253Cp.A03(4);
                            String[] strArr = A01;
                            if (strArr[6].charAt(31) == strArr[0].charAt(31)) {
                                throw new RuntimeException();
                            }
                            String[] strArr2 = A01;
                            strArr2[6] = "Wlyx46da0LhUJCMQF7d9pJYsMbXYpIdM";
                            strArr2[0] = "HglI0wxUFDuveiNJ2qiTiY5BYhneBiG1";
                        }
                    }
                    for (int i15 = 0; i15 < iA04; i15++) {
                        c1253Cp.A03(8);
                        c1253Cp.A03(8);
                        c1253Cp.A03(8);
                    }
                    break;
                    break;
                default:
                    Log.e(A05(0, 10, 32), A05(270, 41, 7) + iA03);
                    break;
            }
        }
    }

    public static void A08(C1253Cp c1253Cp) throws C11849v {
        int iA02 = c1253Cp.A02(6) + 1;
        for (int i11 = 0; i11 < iA02; i11++) {
            int iA03 = c1253Cp.A02(16);
            switch (iA03) {
                case 0:
                    c1253Cp.A03(8);
                    c1253Cp.A03(16);
                    c1253Cp.A03(16);
                    c1253Cp.A03(6);
                    c1253Cp.A03(8);
                    int iA04 = c1253Cp.A02(4) + 1;
                    for (int i12 = 0; i12 < iA04; i12++) {
                        c1253Cp.A03(8);
                    }
                    break;
                case 1:
                    int iA05 = c1253Cp.A02(5);
                    int i13 = -1;
                    int[] iArr = new int[iA05];
                    for (int i14 = 0; i14 < iA05; i14++) {
                        iArr[i14] = c1253Cp.A02(4);
                        if (iArr[i14] > i13) {
                            i13 = iArr[i14];
                        }
                    }
                    int[] iArr2 = new int[i13 + 1];
                    for (int i15 = 0; i15 < iArr2.length; i15++) {
                        iArr2[i15] = c1253Cp.A02(3) + 1;
                        int iA06 = c1253Cp.A02(2);
                        if (iA06 > 0) {
                            c1253Cp.A03(8);
                        }
                        for (int i16 = 0; i16 < (1 << iA06); i16++) {
                            c1253Cp.A03(8);
                        }
                    }
                    c1253Cp.A03(2);
                    int iA07 = c1253Cp.A02(4);
                    int i17 = 0;
                    int i18 = 0;
                    for (int i19 = 0; i19 < iA05; i19++) {
                        i17 += iArr2[iArr[i19]];
                        while (i18 < i17) {
                            c1253Cp.A03(iA07);
                            i18++;
                        }
                    }
                    break;
                default:
                    throw new C11849v(A05(114, 41, 34) + iA03);
            }
        }
    }

    public static void A09(C1253Cp c1253Cp) throws C11849v {
        int iA02 = c1253Cp.A02(6) + 1;
        for (int i11 = 0; i11 < iA02; i11++) {
            if (c1253Cp.A02(16) > 2) {
                throw new C11849v(A05(363, 43, 2));
            }
            c1253Cp.A03(24);
            c1253Cp.A03(24);
            c1253Cp.A03(24);
            int iA03 = c1253Cp.A02(6) + 1;
            c1253Cp.A03(8);
            int[] iArr = new int[iA03];
            for (int i12 = 0; i12 < iA03; i12++) {
                int iA04 = 0;
                int iA05 = c1253Cp.A02(3);
                if (c1253Cp.A04()) {
                    iA04 = c1253Cp.A02(5);
                }
                iArr[i12] = (iA04 * 8) + iA05;
            }
            for (int i13 = 0; i13 < iA03; i13++) {
                for (int i14 = 0; i14 < 8; i14++) {
                    if ((iArr[i13] & (1 << i14)) != 0) {
                        c1253Cp.A03(8);
                    }
                }
            }
        }
    }

    public static boolean A0A(int i11, C1376Hz c1376Hz, boolean z11) throws C11849v {
        if (c1376Hz.A04() < 7) {
            if (z11) {
                return false;
            }
            throw new C11849v(A05(464, 18, 36) + c1376Hz.A04());
        }
        if (c1376Hz.A0E() != i11) {
            if (z11) {
                return false;
            }
            throw new C11849v(A05(93, 21, 41) + Integer.toHexString(i11));
        }
        if (c1376Hz.A0E() == 118 && c1376Hz.A0E() == 111 && c1376Hz.A0E() == 114 && c1376Hz.A0E() == 98 && c1376Hz.A0E() == 105 && c1376Hz.A0E() == 115) {
            return true;
        }
        if (z11) {
            return false;
        }
        throw new C11849v(A05(10, 28, 123));
    }

    public static Ct[] A0B(C1253Cp c1253Cp) {
        int iA02 = c1253Cp.A02(6) + 1;
        Ct[] ctArr = new Ct[iA02];
        for (int i11 = 0; i11 < iA02; i11++) {
            ctArr[i11] = new Ct(c1253Cp.A04(), c1253Cp.A02(16), c1253Cp.A02(16), c1253Cp.A02(8));
        }
        return ctArr;
    }

    public static Ct[] A0C(C1376Hz c1376Hz, int i11) throws C11849v {
        A0A(5, c1376Hz, false);
        int iA0E = c1376Hz.A0E() + 1;
        C1253Cp c1253Cp = new C1253Cp(c1376Hz.A00);
        c1253Cp.A03(c1376Hz.A06() * 8);
        for (int i12 = 0; i12 < iA0E; i12++) {
            A02(c1253Cp);
        }
        int iA02 = c1253Cp.A02(6) + 1;
        for (int i13 = 0; i13 < iA02; i13++) {
            if (c1253Cp.A02(16) != 0) {
                throw new C11849v(A05(311, 52, 47));
            }
        }
        A08(c1253Cp);
        A09(c1253Cp);
        A07(i11, c1253Cp);
        Ct[] ctArrA0B = A0B(c1253Cp);
        if (c1253Cp.A04()) {
            return ctArrA0B;
        }
        throw new C11849v(A05(155, 43, 85));
    }
}
