package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.internal.exoplayer2.thirdparty.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.nio.ByteBuffer;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AQ {
    public static byte[] A00;
    public static String[] A01 = {"sCxx5L5gWudXPe4xp1ThsNryHSmynjHF", "9Nf9uybzHO2S6jQpjiGasa9ZwcLHyUhN", "2aneS77IEDbgq", "fX6HyBPcmxgssJA51nXZ3qA", "", "AlikR2RGcjs8IOnjMv6bsO9qZZebDHqD", "DHEXyDlkH8L0aTNQHdBgfWGXbAOYtdTx", "PJLs5pK7Ccf4tt9LWMwQ38VoV6l96kFD"};
    public static final int[] A02;
    public static final int[] A03;
    public static final int[] A04;
    public static final int[] A05;
    public static final int[] A06;
    public static final int[] A07;

    static {
        A0B();
        A03 = new int[]{1, 2, 3, 6};
        A05 = new int[]{48000, 44100, 32000};
        A06 = new int[]{24000, 22050, 16000};
        A04 = new int[]{2, 1, 2, 3, 3, 4, 4, 5};
        A02 = new int[]{32, 40, 48, 56, 64, 80, 96, 112, 128, 160, PsExtractor.AUDIO_STREAM, 224, 256, 320, 384, 448, 512, 576, 640};
        A07 = new int[]{69, 87, 104, 121, 139, 174, 208, 243, 278, 348, TTAdConstant.DOWNLOAD_URL_AND_PACKAGE_NAME, 487, 557, 696, 835, 975, 1114, 1253, 1393};
    }

    public static int A00() {
        return 1536;
    }

    public static int A01(int i11, int i12) {
        int i13 = i12 / 2;
        if (i11 < 0) {
            return -1;
        }
        int[] iArr = A05;
        if (i11 >= iArr.length || i12 < 0) {
            return -1;
        }
        int[] iArr2 = A07;
        if (i13 >= iArr2.length) {
            return -1;
        }
        int i14 = iArr[i11];
        if (i14 == 44100) {
            return (iArr2[i13] + (i12 % 2)) * 2;
        }
        int i15 = A02[i13];
        if (i14 != 32000) {
            return i15 * 4;
        }
        int i16 = i15 * 6;
        if (A01[6].charAt(31) == 'Q') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[3] = "qimZQilZsB2lt3Dt1pYE9Xl";
        strArr[4] = "";
        return i16;
    }

    public static int A02(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit() - 10;
        for (int i11 = iPosition; i11 <= iLimit; i11++) {
            if ((byteBuffer.getInt(i11 + 4) & (-16777217)) == -1167101192) {
                return i11 - iPosition;
            }
        }
        String[] strArr = A01;
        if (strArr[7].charAt(29) == strArr[5].charAt(29)) {
            throw new RuntimeException();
        }
        A01[2] = "FkGXqBuH9rf";
        return -1;
    }

    public static int A03(ByteBuffer byteBuffer) {
        return (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? A03[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4] : 6) * 256;
    }

    public static int A04(ByteBuffer byteBuffer, int i11) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i11) + ((byteBuffer.get((byteBuffer.position() + i11) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }

    public static int A05(byte[] bArr) {
        if (bArr.length < 5) {
            return -1;
        }
        return A01((bArr[4] & 192) >> 6, bArr[4] & Utf8.REPLACEMENT_BYTE);
    }

    public static int A06(byte[] bArr) {
        if (bArr[4] != -8 || bArr[5] != 114 || bArr[6] != 111 || (bArr[7] & 254) != 186) {
            return 0;
        }
        byte b11 = bArr[(bArr[7] & 255) == 187 ? '\t' : '\b'];
        String[] strArr = A01;
        if (strArr[3].length() == strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[1] = "Qkic1459317rghhXW1uTsPZAwlwTKIiV";
        strArr2[0] = "TPYz26W0Cq4ZALktt0QhsmVlkvC9xybr";
        return 40 << ((b11 >> 4) & 7);
    }

    public static Format A07(C1376Hz c1376Hz, String str, String str2, DrmInitData drmInitData) {
        int i11 = A05[(c1376Hz.A0E() & PsExtractor.AUDIO_STREAM) >> 6];
        int iA0E = c1376Hz.A0E();
        int i12 = A04[(iA0E & 56) >> 3];
        if ((iA0E & 4) != 0) {
            i12++;
        }
        return Format.A07(str, A0A(0, 9, 26), null, -1, -1, i12, i11, null, drmInitData, 0, str2);
    }

    public static Format A08(C1376Hz c1376Hz, String str, String str2, DrmInitData drmInitData) {
        c1376Hz.A0Z(2);
        int i11 = A05[(c1376Hz.A0E() & PsExtractor.AUDIO_STREAM) >> 6];
        int iA0E = c1376Hz.A0E();
        int i12 = A04[(iA0E & 14) >> 1];
        if ((iA0E & 1) != 0) {
            i12++;
        }
        if (((c1376Hz.A0E() & 30) >> 1) > 0 && (c1376Hz.A0E() & 2) != 0) {
            i12 += 2;
        }
        String strA0A = A0A(9, 10, 48);
        if (c1376Hz.A04() > 0 && (c1376Hz.A0E() & 1) != 0) {
            strA0A = A0A(19, 14, 124);
        }
        return Format.A07(str, strA0A, null, -1, -1, i12, i11, null, drmInitData, 0, str2);
    }

    /* JADX WARN: Code duplicated, block: B:133:0x0207  */
    /* JADX WARN: Code duplicated, block: B:160:0x0273  */
    /* JADX WARN: Code duplicated, block: B:162:0x027d  */
    /* JADX WARN: Code duplicated, block: B:164:0x028e  */
    /* JADX WARN: Code duplicated, block: B:166:0x02a9  */
    public static AP A09(C1375Hy c1375Hy) {
        String strA0A;
        int iA01;
        int i11;
        int i12;
        int i13;
        int i14;
        int iA04;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int iA03 = c1375Hy.A03();
        c1375Hy.A08(40);
        boolean z11 = c1375Hy.A04(5) == 16;
        c1375Hy.A07(iA03);
        int i22 = -1;
        if (!z11) {
            strA0A = A0A(0, 9, 26);
            c1375Hy.A08(32);
            int iA05 = c1375Hy.A04(2);
            iA01 = A01(iA05, c1375Hy.A04(6));
            c1375Hy.A08(8);
            int iA06 = c1375Hy.A04(3);
            if ((iA06 & 1) == 0 || iA06 == 1) {
                i11 = 2;
            } else {
                i11 = 2;
                c1375Hy.A08(2);
            }
            if ((iA06 & 4) != 0) {
                c1375Hy.A08(i11);
            }
            if (iA06 == i11) {
                c1375Hy.A08(i11);
            }
            i12 = A05[iA05];
            i13 = 1536;
            boolean zA0F = c1375Hy.A0F();
            int[] iArr = A04;
            if (A01[6].charAt(31) != 'Q') {
                A01[2] = "4KahRN";
                i14 = iArr[iA06] + (zA0F ? 1 : 0);
                return new AP(strA0A, i22, i14, i12, iA01, i13);
            }
            throw new RuntimeException();
        }
        c1375Hy.A08(16);
        switch (c1375Hy.A04(2)) {
            case 0:
                i22 = 0;
                break;
            case 1:
                i22 = 1;
                break;
            case 2:
                i22 = 2;
                break;
            default:
                i22 = -1;
                break;
        }
        c1375Hy.A08(3);
        iA01 = (c1375Hy.A04(11) + 1) * 2;
        int iA07 = c1375Hy.A04(2);
        if (iA07 == 3) {
            iA04 = 3;
            i12 = A06[c1375Hy.A04(2)];
            i15 = 6;
        } else {
            iA04 = c1375Hy.A04(2);
            String[] strArr = A01;
            if (strArr[3].length() != strArr[4].length()) {
                String[] strArr2 = A01;
                strArr2[7] = "8hYjpgfNHnAwS9QM7NBT3rLslQs0BeQi";
                strArr2[5] = "JdPcmmaJKVXmYa4gXJhhMISDBvQK9V8e";
                i15 = A03[iA04];
                i12 = A05[iA07];
            } else {
                i15 = A03[iA04];
                i12 = A05[iA07];
            }
        }
        i13 = i15 * 256;
        int iA08 = c1375Hy.A04(3);
        boolean zA0F2 = c1375Hy.A0F();
        i14 = A04[iA08] + (zA0F2 ? 1 : 0);
        c1375Hy.A08(10);
        if (c1375Hy.A0F()) {
            c1375Hy.A08(8);
        }
        if (iA08 == 0) {
            c1375Hy.A08(5);
            if (c1375Hy.A0F()) {
                c1375Hy.A08(8);
            }
        }
        if (i22 == 1 && c1375Hy.A0F()) {
            c1375Hy.A08(16);
        }
        if (c1375Hy.A0F()) {
            if (iA08 > 2) {
                c1375Hy.A08(2);
            }
            if ((iA08 & 1) == 0 || iA08 <= 2) {
                i19 = 6;
            } else {
                i19 = 6;
                c1375Hy.A08(6);
            }
            if ((iA08 & 4) != 0) {
                c1375Hy.A08(i19);
            }
            if (zA0F2 && c1375Hy.A0F()) {
                c1375Hy.A08(5);
            }
            if (i22 == 0) {
                if (c1375Hy.A0F()) {
                    i21 = 6;
                    c1375Hy.A08(6);
                } else {
                    i21 = 6;
                }
                if (iA08 == 0 && c1375Hy.A0F()) {
                    c1375Hy.A08(i21);
                }
                if (c1375Hy.A0F()) {
                    c1375Hy.A08(i21);
                }
                int iA09 = c1375Hy.A04(2);
                if (iA09 == 1) {
                    c1375Hy.A08(5);
                } else if (iA09 == 2) {
                    c1375Hy.A08(12);
                } else if (iA09 == 3) {
                    int iA010 = c1375Hy.A04(5);
                    if (c1375Hy.A0F()) {
                        c1375Hy.A08(5);
                        if (c1375Hy.A0F()) {
                            c1375Hy.A08(4);
                        }
                        if (c1375Hy.A0F()) {
                            c1375Hy.A08(4);
                        }
                        boolean zA0F3 = c1375Hy.A0F();
                        String[] strArr3 = A01;
                        if (strArr3[1].charAt(20) != strArr3[0].charAt(20)) {
                            A01[2] = "kC";
                            if (zA0F3) {
                                c1375Hy.A08(4);
                            }
                        } else {
                            A01[2] = "vcp8LN0Hh9uJKmo";
                            if (zA0F3) {
                                c1375Hy.A08(4);
                            }
                        }
                        if (c1375Hy.A0F()) {
                            c1375Hy.A08(4);
                        }
                        if (c1375Hy.A0F()) {
                            c1375Hy.A08(4);
                        }
                        if (c1375Hy.A0F()) {
                            c1375Hy.A08(4);
                        }
                        if (c1375Hy.A0F()) {
                            c1375Hy.A08(4);
                        }
                        if (c1375Hy.A0F()) {
                            if (c1375Hy.A0F()) {
                                c1375Hy.A08(4);
                            }
                            if (c1375Hy.A0F()) {
                                c1375Hy.A08(4);
                            }
                        }
                    }
                    if (c1375Hy.A0F()) {
                        c1375Hy.A08(5);
                        String[] strArr4 = A01;
                        if (strArr4[3].length() != strArr4[4].length()) {
                            String[] strArr5 = A01;
                            strArr5[1] = "LWpchFhzl4zZLaolhYStszHUjMzJpa2W";
                            strArr5[0] = "6uYdOttcy9rqBmgvIK07scrDJCGtgIZT";
                            if (c1375Hy.A0F()) {
                                c1375Hy.A08(7);
                                if (c1375Hy.A0F()) {
                                    if (A01[6].charAt(31) != 'Q') {
                                        String[] strArr6 = A01;
                                        strArr6[3] = "efqTs5tkRdGBLzL99Y2zBy0";
                                        strArr6[4] = "";
                                        c1375Hy.A08(8);
                                    } else {
                                        c1375Hy.A08(8);
                                    }
                                }
                            }
                        } else if (c1375Hy.A0F()) {
                            c1375Hy.A08(7);
                            if (c1375Hy.A0F()) {
                                if (A01[6].charAt(31) != 'Q') {
                                    String[] strArr7 = A01;
                                    strArr7[3] = "efqTs5tkRdGBLzL99Y2zBy0";
                                    strArr7[4] = "";
                                    c1375Hy.A08(8);
                                } else {
                                    c1375Hy.A08(8);
                                }
                            }
                        }
                    }
                    c1375Hy.A08((iA010 + 2) * 8);
                    c1375Hy.A05();
                }
                if (iA08 < 2) {
                    if (c1375Hy.A0F()) {
                        c1375Hy.A08(14);
                    }
                    if (iA08 == 0 && c1375Hy.A0F()) {
                        c1375Hy.A08(14);
                    }
                }
                if (c1375Hy.A0F()) {
                    if (iA04 == 0) {
                        c1375Hy.A08(5);
                    } else {
                        for (int i23 = 0; i23 < i15; i23++) {
                            if (c1375Hy.A0F()) {
                                c1375Hy.A08(5);
                            }
                        }
                    }
                }
            }
        }
        if (c1375Hy.A0F()) {
            c1375Hy.A08(5);
            if (iA08 == 2) {
                c1375Hy.A08(4);
            }
            if (iA08 >= 6) {
                c1375Hy.A08(2);
            }
            boolean zA0F4 = c1375Hy.A0F();
            if (A01[6].charAt(31) != 'Q') {
                A01[6] = "dl0wWt6J8L8AikPCmNhR7kaZE8RAZ0S5";
                if (zA0F4) {
                    i18 = 8;
                    c1375Hy.A08(8);
                } else {
                    i18 = 8;
                }
                if (iA08 == 0 && c1375Hy.A0F()) {
                    c1375Hy.A08(i18);
                }
                i16 = 3;
                if (iA07 < 3) {
                    c1375Hy.A06();
                }
            }
            throw new RuntimeException();
        }
        i16 = 3;
        if (i22 == 0 && iA04 != i16) {
            c1375Hy.A06();
        }
        if (i22 != 2) {
            i17 = 6;
        } else if (iA04 == i16 || c1375Hy.A0F()) {
            i17 = 6;
            c1375Hy.A08(6);
        } else {
            i17 = 6;
        }
        strA0A = A0A(9, 10, 48);
        if (c1375Hy.A0F()) {
            int iA011 = c1375Hy.A04(i17);
            String[] strArr8 = A01;
            if (strArr8[3].length() == strArr8[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr9 = A01;
            strArr9[1] = "3ApKKtyzWMiiSaP5bzYqsGtpnyYQD1rl";
            strArr9[0] = "8bIrpLiP8D9Hp4mjJ2yCsEloJ1XyNCEo";
            if (iA011 == 1 && c1375Hy.A04(8) == 1) {
                strA0A = A0A(19, 14, 124);
            }
        }
        return new AP(strA0A, i22, i14, i12, iA01, i13);
    }

    public static String A0A(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 64);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0B() {
        A00 = new byte[]{-69, -49, -66, -61, -55, -119, -69, -67, -115, -47, -27, -44, -39, -33, -97, -43, -47, -45, -93, Ascii.GS, 49, 32, 37, 43, -21, 33, Ascii.GS, Ascii.US, -17, -23, 38, 43, Ascii.US};
    }
}
