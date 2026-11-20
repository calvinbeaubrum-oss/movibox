package com.facebook.ads.redexgen.uinode;

import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1372Hv {
    public static byte[] A00;
    public static int[] A01;
    public static String[] A02 = {"NtIRWyZV8H4fZGcEpCmcKf3IqD05aRmR", "GeJrrdqpTOChTmOZ0a7zD9rW5xWuwwPC", "fB9woPX", "60Ey3AJYIgulbHGVt5ok32wwr6OtRAhs", "ywmal8sml3QBlriqnsJwUXbJL0wOA6tO", "h15JbuXclRunjao1u8Y3u6XMQgnEqNxE", "VnL2Csv3rCYD2ISe0PbhclEmcnjJ2Dil", "pqWxkCx1Owc6AlIW11IRV9LZfrwFezHs"};
    public static final byte[] A03;
    public static final float[] A04;
    public static final Object A05;

    static {
        A08();
        A03 = new byte[]{0, 0, 0, 1};
        A04 = new float[]{1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
        A05 = new Object();
        A01 = new int[10];
    }

    public static int A00(byte[] bArr, int i11) {
        return (bArr[i11 + 3] & 126) >> 1;
    }

    public static int A01(byte[] bArr, int i11) {
        return bArr[i11 + 3] & Ascii.US;
    }

    public static int A02(byte[] bArr, int i11) {
        int i12;
        synchronized (A05) {
            int iA03 = 0;
            int i13 = 0;
            while (iA03 < i11) {
                iA03 = A03(bArr, iA03, i11);
                if (iA03 < i11) {
                    int[] iArr = A01;
                    if (iArr.length <= i13) {
                        A01 = Arrays.copyOf(iArr, iArr.length * 2);
                    }
                    A01[i13] = iA03;
                    iA03 += 3;
                    i13++;
                }
            }
            i12 = i11 - i13;
            int i14 = 0;
            int i15 = 0;
            for (int i16 = 0; i16 < i13; i16++) {
                int i17 = A01[i16] - i14;
                System.arraycopy(bArr, i14, bArr, i15, i17);
                int i18 = i15 + i17;
                int i19 = i18 + 1;
                bArr[i18] = 0;
                i15 = i19 + 1;
                bArr[i19] = 0;
                i14 += i17 + 3;
            }
            System.arraycopy(bArr, i14, bArr, i15, i12 - i15);
        }
        return i12;
    }

    public static int A03(byte[] bArr, int i11, int i12) {
        while (i11 < i12 - 2) {
            if (bArr[i11] == 0 && bArr[i11 + 1] == 0 && bArr[i11 + 2] == 3) {
                return i11;
            }
            i11++;
        }
        return i12;
    }

    /* JADX WARN: Code duplicated, block: B:98:0x0133  */
    public static int A04(byte[] bArr, int i11, int i12, boolean[] zArr) {
        boolean z11;
        boolean z12;
        int i13 = i12 - i11;
        AbstractC1351Ha.A04(i13 >= 0);
        if (i13 == 0) {
            return i12;
        }
        if (zArr != null) {
            if (zArr[0]) {
                A0B(zArr);
                return i11 - 3;
            }
            if (i13 > 1 && zArr[1] && bArr[i11] == 1) {
                A0B(zArr);
                return i11 - 2;
            }
            if (i13 > 2 && zArr[2] && bArr[i11] == 0 && bArr[i11 + 1] == 1) {
                A0B(zArr);
                return i11 - 1;
            }
        }
        int i14 = i12 - 1;
        int i15 = i11 + 2;
        while (i15 < i14) {
            if ((bArr[i15] & 254) == 0) {
                if (bArr[i15 - 2] == 0 && bArr[i15 - 1] == 0 && bArr[i15] == 1) {
                    if (zArr != null) {
                        A0B(zArr);
                    }
                    int i16 = i15 - 2;
                    if (A02[2].length() != 30) {
                        String[] strArr = A02;
                        strArr[5] = "cwZIqZ1AW63JkQ3pIqo9DKAUVDIU8B2n";
                        strArr[0] = "C4ULzJ2O8tT1dK0koFoE4t7X4OAunQC5";
                        return i16;
                    }
                    throw new RuntimeException();
                }
                i15 -= 2;
            }
            i15 += 3;
        }
        if (zArr != null) {
            if (i13 > 2) {
                if (bArr[i12 - 3] == 0) {
                    byte b11 = bArr[i12 - 2];
                    String[] strArr2 = A02;
                    if (strArr2[6].charAt(16) == strArr2[1].charAt(16)) {
                        String[] strArr3 = A02;
                        strArr3[5] = "3nijOMlfzKgjywxgx1aIEuQEOVvcrnGF";
                        strArr3[0] = "mhxYTAHU7iRAJ8bI14cg8xnokscJO5gc";
                        if (b11 == 0) {
                            byte b12 = bArr[i12 - 1];
                            String[] strArr4 = A02;
                            if (strArr4[5].charAt(21) == strArr4[0].charAt(21)) {
                                throw new RuntimeException();
                            }
                            String[] strArr5 = A02;
                            strArr5[3] = "9ZCFGjZIw1dXFFVp2oTHQfikOa97hWgs";
                            strArr5[7] = "4W5bkIHCCYZDsaIH6FljQxOPKIhpSySs";
                            if (b12 == 1) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                        } else {
                            z11 = false;
                        }
                    }
                    throw new RuntimeException();
                }
                z11 = false;
            } else if (i13 == 2) {
                z11 = zArr[2] && bArr[i12 + (-2)] == 0 && bArr[i12 + (-1)] == 1;
            } else {
                z11 = zArr[1] && bArr[i12 + (-1)] == 1;
            }
            zArr[0] = z11;
            if (i13 > 1) {
                z12 = bArr[i12 + (-2)] == 0 && bArr[i12 + (-1)] == 0;
            } else {
                z12 = zArr[2] && bArr[i12 + (-1)] == 0;
            }
            zArr[1] = z12;
            zArr[2] = bArr[i12 + (-1)] == 0;
        }
        return i12;
    }

    public static C1370Ht A05(byte[] bArr, int i11, int i12) {
        I0 i13 = new I0(bArr, i11, i12);
        i13.A07(8);
        int iA04 = i13.A04();
        int iA05 = i13.A04();
        i13.A06();
        return new C1370Ht(iA04, iA05, i13.A0A());
    }

    /* JADX WARN: Code duplicated, block: B:24:0x007c  */
    /* JADX WARN: Code duplicated, block: B:28:0x0084  */
    /* JADX WARN: Code duplicated, block: B:30:0x008a  */
    /* JADX WARN: Code duplicated, block: B:33:0x009d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x009f  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:39:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:41:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:50:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:54:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:57:0x010e  */
    /* JADX WARN: Code duplicated, block: B:59:0x0120  */
    /* JADX WARN: Code duplicated, block: B:62:0x0132  */
    /* JADX WARN: Code duplicated, block: B:69:0x0158  */
    /* JADX WARN: Code duplicated, block: B:75:0x0171  */
    /* JADX WARN: Code duplicated, block: B:77:0x0176  */
    /* JADX WARN: Code duplicated, block: B:78:0x0179  */
    /* JADX WARN: Code duplicated, block: B:79:0x01a1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:80:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:82:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:84:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:85:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:87:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:88:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:89:0x01de  */
    /* JADX WARN: Code duplicated, block: B:90:0x01ec A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:91:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:94:0x0203 A[LOOP:0: B:92:0x01fe->B:94:0x0203, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:98:0x00b2 A[SYNTHETIC] */
    public static C1371Hu A06(byte[] bArr, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int iA04;
        int iA05;
        boolean zA0A;
        long jA04;
        int i16;
        boolean zA0A2;
        int i17;
        int i18;
        String[] strArr;
        float f11;
        int iA06;
        float[] fArr;
        int iA07;
        int iA08;
        int iA09;
        int iA010;
        int i19;
        int i21;
        int i22;
        I0 i23 = new I0(bArr, i11, i12);
        i23.A07(8);
        int iA011 = i23.A05(8);
        i23.A07(16);
        int iA012 = i23.A04();
        int iA013 = 1;
        boolean zA0A3 = false;
        if (iA011 == 100) {
            iA013 = i23.A04();
            zA0A3 = iA013 == 3 ? i23.A0A() : false;
            i23.A04();
            i23.A04();
            i23.A06();
            if (i23.A0A()) {
                if (iA013 != 3) {
                    i13 = 8;
                } else {
                    i13 = 12;
                }
                for (i14 = 0; i14 < i13; i14++) {
                    if (i23.A0A()) {
                        if (i14 < 6) {
                            i15 = 16;
                        } else {
                            i15 = 64;
                        }
                        A09(i23, i15);
                    }
                }
            }
            int iA014 = i23.A04() + 4;
            iA04 = i23.A04();
            iA05 = 0;
            zA0A = false;
            if (iA04 == 0) {
                iA05 = i23.A04() + 4;
                if (A02[4].charAt(6) == 's') {
                    String[] strArr2 = A02;
                    strArr2[6] = "0FcrA39w8cpWUUBY0PhZdDl2WVIzmr3H";
                    strArr2[1] = "bEwoHyJue3o3gWd30VLAmFgh8fIWiG5R";
                }
            } else if (iA04 == 1) {
                zA0A = i23.A0A();
                i23.A03();
                i23.A03();
                jA04 = i23.A04();
                for (i16 = 0; i16 < jA04; i16++) {
                    i23.A04();
                }
            }
            i23.A04();
            i23.A06();
            int iA015 = i23.A04() + 1;
            int iA016 = i23.A04() + 1;
            zA0A2 = i23.A0A();
            int i24 = (2 - (zA0A2 ? 1 : 0)) * iA016;
            if (!zA0A2) {
                i23.A06();
            }
            i23.A06();
            i17 = iA015 * 16;
            i18 = i24 * 16;
            if (i23.A0A()) {
                int iA017 = i23.A04();
                int iA018 = i23.A04();
                iA09 = i23.A04();
                iA010 = i23.A04();
                if (iA013 == 0) {
                    i19 = 1;
                    i21 = 2 - (zA0A2 ? 1 : 0);
                } else {
                    if (iA013 == 3) {
                        i19 = 1;
                    } else {
                        i19 = 2;
                    }
                    i21 = (2 - (zA0A2 ? 1 : 0)) * (iA013 == 1 ? 2 : 1);
                }
                i22 = (iA017 + iA018) * i19;
                if (A02[2].length() != 30) {
                    String[] strArr3 = A02;
                    strArr3[6] = "K9ZSRxGlh7Ws8i4c0lKuIdr8XNNG4vGX";
                    strArr3[1] = "z3Vhx6GLQ83q5V050JhbnsU4vD8C98vT";
                    i17 -= i22;
                    i18 -= (iA09 + iA010) * i21;
                }
            } else {
                strArr = A02;
                if (strArr[6].charAt(16) != strArr[1].charAt(16)) {
                    String[] strArr4 = A02;
                    strArr4[6] = "rEmuJ6sFB5gWWdCI0T7L47ZB03FBkEHD";
                    strArr4[1] = "kUZJy2qQtWdVgeJj0t3oDkGmETEmhFuj";
                } else {
                    String[] strArr5 = A02;
                    strArr5[5] = "DSl3hQKuabn38CmnzrECcwmRq5HwdYpG";
                    strArr5[0] = "fA6X51zRtxq1lySt2ARPPLPLlCaXaXco";
                }
            }
            f11 = 1.0f;
            if (i23.A0A() && i23.A0A()) {
                iA06 = i23.A05(8);
                if (iA06 == 255) {
                    iA07 = i23.A05(16);
                    iA08 = i23.A05(16);
                    if (iA07 != 0 && iA08 != 0) {
                        f11 = iA07 / iA08;
                    }
                } else {
                    fArr = A04;
                    if (iA06 < fArr.length) {
                        f11 = fArr[iA06];
                    } else {
                        Log.w(A07(0, 11, 38), A07(11, 35, 89) + iA06);
                    }
                }
            }
            return new C1371Hu(iA012, i17, i18, f11, zA0A3, zA0A2, iA014, iA04, iA05, zA0A);
        }
        if (A02[4].charAt(6) == 's') {
            String[] strArr6 = A02;
            strArr6[5] = "yVhhMtRnqXgY1Kb3O7KmUsZDbX87nSR0";
            strArr6[0] = "CScaMkkS4ynj4HoVSfcs8Df7mB4vIw2E";
            if (iA011 == 110 || iA011 == 122 || iA011 == 244 || iA011 == 44 || iA011 == 83 || iA011 == 86) {
                iA013 = i23.A04();
                if (iA013 == 3) {
                }
                i23.A04();
                i23.A04();
                i23.A06();
                if (i23.A0A()) {
                    if (iA013 != 3) {
                        i13 = 8;
                    } else {
                        i13 = 12;
                    }
                    while (i14 < i13) {
                        if (i23.A0A()) {
                            if (i14 < 6) {
                                i15 = 16;
                            } else {
                                i15 = 64;
                            }
                            A09(i23, i15);
                        }
                    }
                }
            } else {
                String[] strArr7 = A02;
                if (strArr7[5].charAt(21) != strArr7[0].charAt(21)) {
                    A02[2] = "JhuiEkWh4gR2K7eJg";
                    if (iA011 != 118) {
                        if (iA011 != 128 || iA011 == 138) {
                        }
                    }
                } else if (iA011 != 118) {
                    if (iA011 != 128) {
                    }
                }
                iA013 = i23.A04();
                if (iA013 == 3) {
                }
                i23.A04();
                i23.A04();
                i23.A06();
                if (i23.A0A()) {
                    if (iA013 != 3) {
                        i13 = 8;
                    } else {
                        i13 = 12;
                    }
                    while (i14 < i13) {
                        if (i23.A0A()) {
                            if (i14 < 6) {
                                i15 = 16;
                            } else {
                                i15 = 64;
                            }
                            A09(i23, i15);
                        }
                    }
                }
            }
            int iA019 = i23.A04() + 4;
            iA04 = i23.A04();
            iA05 = 0;
            zA0A = false;
            if (iA04 == 0) {
                iA05 = i23.A04() + 4;
                if (A02[4].charAt(6) == 's') {
                    String[] strArr8 = A02;
                    strArr8[6] = "0FcrA39w8cpWUUBY0PhZdDl2WVIzmr3H";
                    strArr8[1] = "bEwoHyJue3o3gWd30VLAmFgh8fIWiG5R";
                }
            } else if (iA04 == 1) {
                zA0A = i23.A0A();
                i23.A03();
                i23.A03();
                jA04 = i23.A04();
                while (i16 < jA04) {
                    i23.A04();
                }
            }
            i23.A04();
            i23.A06();
            int iA0110 = i23.A04() + 1;
            int iA0111 = i23.A04() + 1;
            zA0A2 = i23.A0A();
            int i25 = (2 - (zA0A2 ? 1 : 0)) * iA0111;
            if (!zA0A2) {
                i23.A06();
            }
            i23.A06();
            i17 = iA0110 * 16;
            i18 = i25 * 16;
            if (i23.A0A()) {
                int iA0112 = i23.A04();
                int iA0113 = i23.A04();
                iA09 = i23.A04();
                iA010 = i23.A04();
                if (iA013 == 0) {
                    i19 = 1;
                    i21 = 2 - (zA0A2 ? 1 : 0);
                } else {
                    if (iA013 == 3) {
                        i19 = 1;
                    } else {
                        i19 = 2;
                    }
                    i21 = (2 - (zA0A2 ? 1 : 0)) * (iA013 == 1 ? 2 : 1);
                }
                i22 = (iA0112 + iA0113) * i19;
                if (A02[2].length() != 30) {
                    String[] strArr9 = A02;
                    strArr9[6] = "K9ZSRxGlh7Ws8i4c0lKuIdr8XNNG4vGX";
                    strArr9[1] = "z3Vhx6GLQ83q5V050JhbnsU4vD8C98vT";
                    i17 -= i22;
                    i18 -= (iA09 + iA010) * i21;
                }
            } else {
                strArr = A02;
                if (strArr[6].charAt(16) != strArr[1].charAt(16)) {
                    String[] strArr10 = A02;
                    strArr10[6] = "rEmuJ6sFB5gWWdCI0T7L47ZB03FBkEHD";
                    strArr10[1] = "kUZJy2qQtWdVgeJj0t3oDkGmETEmhFuj";
                } else {
                    String[] strArr11 = A02;
                    strArr11[5] = "DSl3hQKuabn38CmnzrECcwmRq5HwdYpG";
                    strArr11[0] = "fA6X51zRtxq1lySt2ARPPLPLlCaXaXco";
                }
            }
            f11 = 1.0f;
            if (i23.A0A()) {
                iA06 = i23.A05(8);
                if (iA06 == 255) {
                    iA07 = i23.A05(16);
                    iA08 = i23.A05(16);
                    if (iA07 != 0) {
                        f11 = iA07 / iA08;
                    }
                } else {
                    fArr = A04;
                    if (iA06 < fArr.length) {
                        f11 = fArr[iA06];
                    } else {
                        Log.w(A07(0, 11, 38), A07(11, 35, 89) + iA06);
                    }
                }
            }
            return new C1371Hu(iA012, i17, i18, f11, zA0A3, zA0A2, iA019, iA04, iA05, zA0A);
        }
        throw new RuntimeException();
    }

    public static String A07(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 29);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A00 = new byte[]{117, 90, 87, 110, 85, 82, 79, 110, 79, 82, 87, 17, 42, 33, 60, 52, 33, 39, 48, 33, 32, 100, 37, 55, 52, 33, 39, 48, Ascii.ESC, 54, 37, 48, 45, 43, Ascii.ESC, 45, 32, 39, 100, 50, 37, 40, 49, 33, 126, 100, Ascii.RS, 1, Ascii.FF, Ascii.CR, 7, 71, 9, Ascii.RS, Ascii.VT, 85, 74, 71, 70, 76, Ascii.FF, 75, 70, 85, 64};
    }

    public static void A09(I0 i11, int i12) {
        int i13 = 8;
        int iA03 = 8;
        for (int i14 = 0; i14 < i12; i14++) {
            if (iA03 != 0) {
                iA03 = ((i11.A03() + i13) + 256) % 256;
            }
            if (iA03 != 0) {
                i13 = iA03;
            }
            String[] strArr = A02;
            if (strArr[6].charAt(16) != strArr[1].charAt(16)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[3] = "KXMRoqtdhshm8G74asFo5uqDFob0Iegs";
            strArr2[7] = "VTZDrARlCd8p2vM8k7YrNOP12vylJmks";
        }
    }

    public static void A0A(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int i11 = 0;
        for (int i12 = 0; i12 + 1 < iPosition; i12++) {
            int i13 = byteBuffer.get(i12) & 255;
            if (i11 == 3) {
                if (A02[4].charAt(6) != 's') {
                    throw new RuntimeException();
                }
                A02[2] = "cLm552F16buuPP9xMufxVHaN";
                if (i13 == 1 && (byteBuffer.get(i12 + 1) & Ascii.US) == 7) {
                    ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
                    byteBufferDuplicate.position(i12 - 3);
                    byteBufferDuplicate.limit(iPosition);
                    byteBuffer.position(0);
                    byteBuffer.put(byteBufferDuplicate);
                    if (A02[4].charAt(6) != 's') {
                        String[] strArr = A02;
                        strArr[3] = "6nmXEFQWU8IXvuDOHtOk9CPNFswxHRRs";
                        strArr[7] = "sRzFReGlCKeKmBP91kaLZyOllIcQLpOs";
                        return;
                    } else {
                        String[] strArr2 = A02;
                        strArr2[5] = "MM5ABksrrLy98KCtfJajpuklss5i1OmF";
                        strArr2[0] = "sCLzk23Fd4ag3qXWex39LdUh6FJSiknG";
                        return;
                    }
                }
            } else if (i13 == 0) {
                i11++;
            }
            if (i13 != 0) {
                i11 = 0;
            }
        }
        byteBuffer.clear();
    }

    public static void A0B(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static boolean A0C(String str, byte b11) {
        if (A07(46, 9, 117).equals(str) && (b11 & Ascii.US) == 6) {
            return true;
        }
        return A07(55, 10, 62).equals(str) && ((b11 & 126) >> 1) == 39;
    }
}
