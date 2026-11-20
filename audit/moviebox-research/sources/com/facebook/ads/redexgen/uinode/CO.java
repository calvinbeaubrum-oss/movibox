package com.facebook.ads.redexgen.uinode;

import android.util.Log;
import android.util.Pair;
import com.applovin.exoplayer2.common.base.Ascii;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.internal.exoplayer2.thirdparty.drm.DrmInitData;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.Metadata;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.Id3Frame;
import com.google.logging.type.LogSeverity;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import okio.Utf8;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class CO {
    public static byte[] A00;
    public static String[] A01 = {DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "1fRxwJ5XE31BEFto", "uScK6DjhwaakoKLKywWqQqJcG3f6AUTY", "4Hlq2lRki9cJUEzjlqXKmdMa0dcUUFBD", "g78w6vvkNWOU54nDIB5PtPh0iS7AkCQe", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Krct3XGjvdQG30dTRHyGL58gGhCYlC87", "LauCO"};
    public static final int A02;
    public static final int A03;
    public static final int A04;
    public static final int A05;
    public static final int A06;
    public static final int A07;
    public static final int A08;

    static {
        A0J();
        A08 = IF.A08(A0I(696, 4, 49));
        A05 = IF.A08(A0I(662, 4, 118));
        A07 = IF.A08(A0I(692, 4, 67));
        A04 = IF.A08(A0I(636, 4, 12));
        A06 = IF.A08(A0I(TTAdConstant.STYLE_SIZE_RADIO_2_3, 4, 95));
        A02 = IF.A08(A0I(606, 4, 15));
        A03 = IF.A08(A0I(632, 4, 120));
    }

    public static float A00(C1376Hz c1376Hz, int i11) {
        c1376Hz.A0Y(i11 + 8);
        return c1376Hz.A0H() / c1376Hz.A0H();
    }

    public static int A01(C1376Hz c1376Hz) {
        int iA0E = c1376Hz.A0E();
        int i11 = iA0E & 127;
        while ((iA0E & 128) == 128) {
            iA0E = c1376Hz.A0E();
            i11 = (i11 << 7) | (iA0E & 127);
        }
        return i11;
    }

    public static int A02(C1376Hz c1376Hz) {
        c1376Hz.A0Y(16);
        int iA08 = c1376Hz.A08();
        if (iA08 == A05) {
            return 1;
        }
        if (iA08 == A08) {
            return 2;
        }
        if (iA08 == A07 || iA08 == A04 || iA08 == A06 || iA08 == A02) {
            return 3;
        }
        return iA08 == A03 ? 4 : -1;
    }

    public static int A03(C1376Hz c1376Hz, int i11, int i12) {
        int iA06 = c1376Hz.A06();
        while (iA06 - i11 < i12) {
            c1376Hz.A0Y(iA06);
            int iA08 = c1376Hz.A08();
            boolean z11 = iA08 > 0;
            if (A01[4].charAt(24) != 'i') {
                throw new RuntimeException();
            }
            A01[4] = "NygnrBLA11LVP9MJCR7n8rNii2RIBIyr";
            AbstractC1351Ha.A05(z11, A0I(574, 32, 87));
            if (c1376Hz.A08() == CJ.A0T) {
                return iA06;
            }
            iA06 += iA08;
        }
        return -1;
    }

    public static long A04(C1376Hz c1376Hz) {
        c1376Hz.A0Y(8);
        c1376Hz.A0Z(CJ.A01(c1376Hz.A08()) != 0 ? 16 : 8);
        if (A01[1].length() == 12) {
            throw new RuntimeException();
        }
        A01[7] = "3W9G8I03JPUdsev";
        return c1376Hz.A0M();
    }

    public static Pair<long[], long[]> A05(XT xt2) {
        XS xsA07;
        if (xt2 == null || (xsA07 = xt2.A07(CJ.A0P)) == null) {
            return Pair.create(null, null);
        }
        C1376Hz c1376Hz = xsA07.A00;
        c1376Hz.A0Y(8);
        int iA01 = CJ.A01(c1376Hz.A08());
        int iA0H = c1376Hz.A0H();
        long[] jArr = new long[iA0H];
        long[] jArr2 = new long[iA0H];
        for (int i11 = 0; i11 < iA0H; i11++) {
            jArr[i11] = iA01 == 1 ? c1376Hz.A0N() : c1376Hz.A0M();
            jArr2[i11] = iA01 == 1 ? c1376Hz.A0L() : c1376Hz.A08();
            if (c1376Hz.A0U() != 1) {
                throw new IllegalArgumentException(A0I(272, 23, 92));
            }
            c1376Hz.A0Z(2);
        }
        return Pair.create(jArr, jArr2);
    }

    public static Pair<Long, String> A06(C1376Hz c1376Hz) {
        c1376Hz.A0Y(8);
        int iA01 = CJ.A01(c1376Hz.A08());
        c1376Hz.A0Z(iA01 == 0 ? 8 : 16);
        long jA0M = c1376Hz.A0M();
        c1376Hz.A0Z(iA01 == 0 ? 4 : 8);
        int iA0I = c1376Hz.A0I();
        return Pair.create(Long.valueOf(jA0M), A0I(0, 0, 85) + ((char) (((iA0I >> 10) & 31) + 96)) + ((char) (((iA0I >> 5) & 31) + 96)) + ((char) ((iA0I & 31) + 96)));
    }

    public static Pair<String, byte[]> A07(C1376Hz c1376Hz, int i11) {
        c1376Hz.A0Y(i11 + 8 + 4);
        c1376Hz.A0Z(1);
        A01(c1376Hz);
        c1376Hz.A0Z(2);
        int iA0E = c1376Hz.A0E();
        if ((iA0E & 128) != 0) {
            c1376Hz.A0Z(2);
        }
        int i12 = iA0E & 64;
        if (A01[6].charAt(18) != 'y') {
            throw new RuntimeException();
        }
        A01[4] = "xKeFRQRG14ulCThjCTH6nGG5i69swr7b";
        if (i12 != 0) {
            c1376Hz.A0Z(c1376Hz.A0I());
        }
        if ((iA0E & 32) != 0) {
            c1376Hz.A0Z(2);
        }
        c1376Hz.A0Z(1);
        A01(c1376Hz);
        String strA03 = AbstractC1369Hs.A03(c1376Hz.A0E());
        if (!A0I(482, 10, 95).equals(strA03) && !A0I(501, 13, 123).equals(strA03) && !A0I(514, 16, 48).equals(strA03)) {
            c1376Hz.A0Z(12);
            c1376Hz.A0Z(1);
            int iA01 = A01(c1376Hz);
            byte[] bArr = new byte[iA01];
            c1376Hz.A0c(bArr, 0, iA01);
            return Pair.create(strA03, bArr);
        }
        Pair<String, byte[]> pairCreate = Pair.create(strA03, null);
        if (A01[6].charAt(18) != 'y') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[0] = "4";
        strArr[5] = "i";
        return pairCreate;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0076  */
    public static Pair<Integer, C1243Cf> A08(C1376Hz c1376Hz, int i11, int i12) {
        int i13 = i11 + 8;
        int i14 = -1;
        int i15 = 0;
        String strA0S = null;
        Integer numValueOf = null;
        while (i13 - i11 < i12) {
            c1376Hz.A0Y(i13);
            int iA08 = c1376Hz.A08();
            int iA09 = c1376Hz.A08();
            if (iA09 == CJ.A0U) {
                numValueOf = Integer.valueOf(c1376Hz.A08());
            } else if (iA09 == CJ.A10) {
                c1376Hz.A0Z(4);
                strA0S = c1376Hz.A0S(4);
            } else if (iA09 == CJ.A0z) {
                i14 = i13;
                if (A01[1].length() == 12) {
                    throw new RuntimeException();
                }
                A01[4] = "1Dp8zcpsjMOU2LphvBo6Szkhi7qi1syu";
                i15 = iA08;
            } else {
                continue;
            }
            i13 += iA08;
        }
        if (A01[4].charAt(24) != 'i') {
            A01[2] = "sI3X7CYNkWTnNUBuJepPqwY6PzAeX7x4";
            if (!A0I(566, 4, 77).equals(strA0S)) {
                if (!A0I(558, 4, 73).equals(strA0S) && !A0I(570, 4, 77).equals(strA0S) && !A0I(TTAdConstant.STYLE_SIZE_RADIO_9_16, 4, 125).equals(strA0S)) {
                    return null;
                }
            }
        } else {
            A01[1] = "yPyTXv33PIzdo";
            if (!A0I(566, 4, 77).equals(strA0S)) {
                if (!A0I(558, 4, 73).equals(strA0S)) {
                    return null;
                }
            }
        }
        if (A01[3].charAt(18) == 'y') {
            throw new RuntimeException();
        }
        A01[4] = "c3g2qilHanrF8nzgjzcjaWK2icn944It";
        AbstractC1351Ha.A05(numValueOf != null, A0I(610, 22, 16));
        AbstractC1351Ha.A05(i14 != -1, A0I(640, 22, 118));
        C1243Cf c1243CfA0D = A0D(c1376Hz, i14, i15, strA0S);
        AbstractC1351Ha.A05(c1243CfA0D != null, A0I(670, 22, 49));
        return Pair.create(numValueOf, c1243CfA0D);
    }

    public static Pair<Integer, C1243Cf> A09(C1376Hz c1376Hz, int i11, int i12) {
        Pair<Integer, C1243Cf> pairA08;
        int iA06 = c1376Hz.A06();
        while (true) {
            int i13 = iA06 - i11;
            if (A01[3].charAt(18) == 'y') {
                throw new RuntimeException();
            }
            A01[6] = "VuSqoU71mDFleviScFynwgGpV5GSmBmr";
            if (i13 >= i12) {
                return null;
            }
            c1376Hz.A0Y(iA06);
            int iA08 = c1376Hz.A08();
            AbstractC1351Ha.A05(iA08 > 0, A0I(574, 32, 87));
            if (c1376Hz.A08() == CJ.A14 && (pairA08 = A08(c1376Hz, iA06, iA08)) != null) {
                return pairA08;
            }
            iA06 += iA08;
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x009b  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:67:0x0111  */
    public static CM A0A(C1376Hz c1376Hz, int i11, int i12, String str, DrmInitData drmInitData, boolean z11) throws C11849v {
        c1376Hz.A0Y(12);
        int iA08 = c1376Hz.A08();
        CM cm2 = new CM(iA08);
        for (int i13 = 0; i13 < iA08; i13++) {
            int iA06 = c1376Hz.A06();
            int iA09 = c1376Hz.A08();
            AbstractC1351Ha.A05(iA09 > 0, A0I(574, 32, 87));
            int iA010 = c1376Hz.A08();
            if (iA010 != CJ.A07) {
                int i14 = CJ.A08;
                if (A01[4].charAt(24) == 'i') {
                    A01[2] = "XfWsLr5EskpQolouThrY0L7T3EnzbtXq";
                    if (iA010 == i14 || iA010 == CJ.A0S) {
                        A0K(c1376Hz, iA010, iA06, iA09, i11, i12, drmInitData, cm2, i13);
                    } else {
                        int i15 = CJ.A0m;
                        if (A01[7].length() != 14) {
                            String[] strArr = A01;
                            strArr[0] = "z";
                            strArr[5] = PrepareException.ERROR_NO_URL;
                            if (iA010 == i15 || iA010 == CJ.A0Y || iA010 == CJ.A0X || iA010 == CJ.A0t || iA010 == CJ.A1T) {
                                A0K(c1376Hz, iA010, iA06, iA09, i11, i12, drmInitData, cm2, i13);
                            } else {
                                int i16 = CJ.A1U;
                                if (A01[4].charAt(24) == 'i') {
                                    A01[6] = "2YqAUbM6XE3am7qEi8y8ENpTVaXzAM3G";
                                    if (iA010 == i16) {
                                        A0K(c1376Hz, iA010, iA06, iA09, i11, i12, drmInitData, cm2, i13);
                                    } else if (iA010 != CJ.A0l) {
                                        A0M(c1376Hz, iA010, iA06, iA09, i11, str, z11, drmInitData, cm2, i13);
                                    } else {
                                        A0M(c1376Hz, iA010, iA06, iA09, i11, str, z11, drmInitData, cm2, i13);
                                    }
                                } else if (iA010 == i16) {
                                    A0K(c1376Hz, iA010, iA06, iA09, i11, i12, drmInitData, cm2, i13);
                                } else if (iA010 != CJ.A0l || iA010 == CJ.A0R || iA010 == CJ.A05) {
                                    A0M(c1376Hz, iA010, iA06, iA09, i11, str, z11, drmInitData, cm2, i13);
                                } else {
                                    int i17 = CJ.A0N;
                                    if (A01[6].charAt(18) != 'y') {
                                        A01[7] = "sstJHJE2SSSA0gl";
                                        if (iA010 != i17) {
                                            if (iA010 == CJ.A0J && iA010 != CJ.A0K && iA010 != CJ.A0L && iA010 != CJ.A0M && iA010 != CJ.A0w && iA010 != CJ.A0x && iA010 != CJ.A0b && iA010 != CJ.A15 && iA010 != CJ.A04 && iA010 != CJ.A06) {
                                                if (iA010 == CJ.A03 || iA010 == CJ.A1P || iA010 == CJ.A1X || iA010 == CJ.A19 || iA010 == CJ.A0A) {
                                                    iA06 = iA06;
                                                    iA09 = iA09;
                                                    A0L(c1376Hz, iA010, iA06, iA09, i11, str, cm2);
                                                } else if (iA010 == CJ.A0B) {
                                                    cm2.A02 = Format.A0B(Integer.toString(i11), A0I(315, 27, 43), null, -1, null);
                                                }
                                            }
                                        }
                                    } else {
                                        A01[4] = "NowU1j8TXSe0umpE5Ib758xlieALevMk";
                                        if (iA010 != i17) {
                                            if (iA010 == CJ.A0J) {
                                            }
                                        }
                                    }
                                    A0M(c1376Hz, iA010, iA06, iA09, i11, str, z11, drmInitData, cm2, i13);
                                }
                            }
                        }
                    }
                }
                throw new RuntimeException();
            }
            A0K(c1376Hz, iA010, iA06, iA09, i11, i12, drmInitData, cm2, i13);
            c1376Hz.A0Y(iA06 + iA09);
        }
        return cm2;
    }

    public static CN A0B(C1376Hz c1376Hz) {
        long jA0M;
        int i11;
        c1376Hz.A0Y(8);
        int iA01 = CJ.A01(c1376Hz.A08());
        c1376Hz.A0Z(iA01 == 0 ? 8 : 16);
        int iA08 = c1376Hz.A08();
        c1376Hz.A0Z(4);
        boolean z11 = true;
        String[] strArr = A01;
        if (strArr[0].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[0] = CampaignEx.JSON_KEY_AD_R;
        strArr2[5] = "s";
        int iA06 = c1376Hz.A06();
        int i12 = iA01 == 0 ? 4 : 8;
        for (int i13 = 0; i13 < i12; i13++) {
            if (c1376Hz.A00[iA06 + i13] != -1) {
                z11 = false;
                break;
            }
        }
        if (z11) {
            c1376Hz.A0Z(i12);
            jA0M = C.TIME_UNSET;
        } else {
            jA0M = iA01 == 0 ? c1376Hz.A0M() : c1376Hz.A0N();
            if (jA0M == 0) {
                jA0M = C.TIME_UNSET;
            }
        }
        c1376Hz.A0Z(16);
        int iA09 = c1376Hz.A08();
        int iA010 = c1376Hz.A08();
        c1376Hz.A0Z(4);
        int iA011 = c1376Hz.A08();
        int iA012 = c1376Hz.A08();
        if (iA09 == 0 && iA010 == 65536 && iA011 == (-65536) && iA012 == 0) {
            i11 = 90;
        } else if (iA09 == 0 && iA010 == (-65536) && iA011 == 65536 && iA012 == 0) {
            i11 = 270;
        } else {
            i11 = (iA09 == (-65536) && iA010 == 0 && iA011 == 0 && iA012 == (-65536)) ? 180 : 0;
        }
        return new CN(iA08, jA0M, i11);
    }

    public static C1242Ce A0C(XT xt2, XS xs2, long j11, DrmInitData drmInitData, boolean z11, boolean z12) throws C11849v {
        long j12 = j11;
        XT xtA06 = xt2.A06(CJ.A0e);
        int iA02 = A02(xtA06.A07(CJ.A0W).A00);
        if (iA02 == -1) {
            return null;
        }
        CN cnA0B = A0B(xt2.A07(CJ.A1K).A00);
        if (j12 == C.TIME_UNSET) {
            j12 = cnA0B.A02;
        }
        long jA04 = A04(xs2.A00);
        if (A01[6].charAt(18) != 'y') {
            throw new RuntimeException();
        }
        A01[7] = "VRI";
        long jA0F = j12 == C.TIME_UNSET ? C.TIME_UNSET : IF.A0F(j12, 1000000L, jA04);
        XT xtA07 = xtA06.A06(CJ.A0i).A06(CJ.A17);
        Pair<Long, String> pairA06 = A06(xtA06.A07(CJ.A0d).A00);
        CM cmA0A = A0A(xtA07.A07(CJ.A1B).A00, cnA0B.A00, cnA0B.A01, (String) pairA06.second, drmInitData, z12);
        long[] jArr = null;
        long[] jArr2 = null;
        if (!z11) {
            Pair<long[], long[]> pairA05 = A05(xt2.A06(CJ.A0O));
            jArr = (long[]) pairA05.first;
            jArr2 = (long[]) pairA05.second;
        }
        if (cmA0A.A02 == null) {
            return null;
        }
        return new C1242Ce(cnA0B.A00, iA02, ((Long) pairA06.first).longValue(), jA04, jA0F, cmA0A.A02, cmA0A.A01, cmA0A.A03, cmA0A.A00, jArr, jArr2);
    }

    public static C1243Cf A0D(C1376Hz c1376Hz, int i11, int i12, String str) {
        int i13 = i11 + 8;
        while (i13 - i11 < i12) {
            c1376Hz.A0Y(i13);
            int iA08 = c1376Hz.A08();
            if (c1376Hz.A08() == CJ.A1H) {
                int iA01 = CJ.A01(c1376Hz.A08());
                c1376Hz.A0Z(1);
                int i14 = 0;
                int i15 = 0;
                if (iA01 == 0) {
                    c1376Hz.A0Z(1);
                } else {
                    int iA0E = c1376Hz.A0E();
                    i14 = (iA0E & 240) >> 4;
                    i15 = iA0E & 15;
                }
                boolean z11 = c1376Hz.A0E() == 1;
                int iA0E2 = c1376Hz.A0E();
                byte[] bArr = new byte[16];
                c1376Hz.A0c(bArr, 0, bArr.length);
                byte[] bArr2 = null;
                if (z11 && iA0E2 == 0) {
                    int iA0E3 = c1376Hz.A0E();
                    if (A01[3].charAt(18) == 'y') {
                        throw new RuntimeException();
                    }
                    A01[6] = "4wz2pNpdOED2I1F7uwyPx7ja9AIbtNj6";
                    bArr2 = new byte[iA0E3];
                    c1376Hz.A0c(bArr2, 0, iA0E3);
                }
                return new C1243Cf(z11, str, iA0E2, bArr, i14, i15, bArr2);
            }
            i13 += iA08;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x029a  */
    /* JADX WARN: Code duplicated, block: B:105:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:109:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:157:0x044f  */
    /* JADX WARN: Code duplicated, block: B:195:0x0512  */
    /* JADX WARN: Code duplicated, block: B:207:0x006e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:209:0x01b8 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:45:0x011d  */
    /* JADX WARN: Code duplicated, block: B:48:0x013d A[ADDED_TO_REGION, LOOP:1: B:48:0x013d->B:51:0x0154, LOOP_START, PHI: r5 r9
  0x013d: PHI (r5v27 long) = (r5v21 long), (r5v30 long) binds: [B:47:0x013b, B:51:0x0154] A[DONT_GENERATE, DONT_INLINE]
  0x013d: PHI (r9v20 int) = (r9v19 int), (r9v22 int) binds: [B:47:0x013b, B:51:0x0154] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:49:0x013f  */
    /* JADX WARN: Code duplicated, block: B:51:0x0154 A[LOOP:1: B:48:0x013d->B:51:0x0154, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:53:0x0162 A[ADDED_TO_REGION, LOOP:2: B:53:0x0162->B:55:0x0166, LOOP_START, PHI: r26 r27 r28
  0x0162: PHI (r26v8 int) = (r26v6 int), (r26v9 int) binds: [B:52:0x0160, B:55:0x0166] A[DONT_GENERATE, DONT_INLINE]
  0x0162: PHI (r27v6 int) = (r27v2 int), (r27v7 int) binds: [B:52:0x0160, B:55:0x0166] A[DONT_GENERATE, DONT_INLINE]
  0x0162: PHI (r28v8 int) = (r28v6 int), (r28v10 int) binds: [B:52:0x0160, B:55:0x0166] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:54:0x0164 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:59:0x0182  */
    /* JADX WARN: Code duplicated, block: B:62:0x018f  */
    /* JADX WARN: Code duplicated, block: B:65:0x0196  */
    /* JADX WARN: Code duplicated, block: B:67:0x019d  */
    /* JADX WARN: Code duplicated, block: B:70:0x01ac A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:73:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:82:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:85:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:87:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:89:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:90:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:92:0x01fe A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:95:0x0204  */
    /* JADX WARN: Code duplicated, block: B:96:0x026e  */
    /* JADX WARN: Code duplicated, block: B:99:0x027c A[LOOP:8: B:97:0x0276->B:99:0x027c, LOOP_END] */
    public static C1245Ch A0E(C1242Ce c1242Ce, XT xt2, C1237Bw c1237Bw) throws C11849v {
        CL xq2;
        boolean z11;
        int i11;
        long j11;
        String strA0I;
        long[] jArr;
        int[] iArr;
        Format format;
        long[] jArr2;
        int[] iArr2;
        long[] jArr3;
        int[] iArr3;
        long j12;
        long jA0F;
        boolean z12;
        long j13;
        int i12;
        int i13;
        boolean z13;
        boolean z14;
        int i14;
        XS xsA07 = xt2.A07(CJ.A1D);
        if (xsA07 != null) {
            xq2 = new XR(xsA07);
        } else {
            XS xsA08 = xt2.A07(CJ.A1F);
            if (xsA08 == null) {
                throw new C11849v(A0I(230, 42, 96));
            }
            xq2 = new XQ(xsA08);
        }
        int iA7o = xq2.A7o();
        if (iA7o == 0) {
            return new C1245Ch(c1242Ce, new long[0], new int[0], 0, new long[0], new int[0], C.TIME_UNSET);
        }
        boolean z15 = false;
        XS xsA09 = xt2.A07(CJ.A18);
        if (xsA09 == null) {
            z15 = true;
            xsA09 = xt2.A07(CJ.A0C);
        }
        C1376Hz c1376Hz = xsA09.A00;
        C1376Hz c1376Hz2 = xt2.A07(CJ.A1A).A00;
        int i15 = CJ.A1E;
        if (A01[4].charAt(24) == 'i') {
            A01[3] = "VC45zkewNZzpqmaBl1H7tUMq9GmKccOG";
            C1376Hz c1376Hz3 = xt2.A07(i15).A00;
            XS xsA010 = xt2.A07(CJ.A1C);
            C1376Hz c1376Hz4 = xsA010 != null ? xsA010.A00 : null;
            XS xsA011 = xt2.A07(CJ.A0D);
            C1376Hz c1376Hz5 = xsA011 != null ? xsA011.A00 : null;
            CK ck2 = new CK(c1376Hz2, c1376Hz, z15);
            c1376Hz3.A0Y(12);
            int iA0H = c1376Hz3.A0H() - 1;
            int iA0H2 = c1376Hz3.A0H();
            int iA0H3 = c1376Hz3.A0H();
            int iA0H4 = 0;
            int iA0H5 = 0;
            int iA08 = 0;
            if (c1376Hz5 != null) {
                c1376Hz5.A0Y(12);
                iA0H5 = c1376Hz5.A0H();
            }
            int iA0H6 = -1;
            int iA0H7 = 0;
            if (c1376Hz4 != null) {
                c1376Hz4.A0Y(12);
                iA0H7 = c1376Hz4.A0H();
                if (iA0H7 > 0) {
                    iA0H6 = c1376Hz4.A0H() - 1;
                } else {
                    c1376Hz4 = null;
                }
            }
            boolean zA93 = xq2.A93();
            if (A01[7].length() == 14) {
                A01[3] = "JmCEQgBO3I7S12cR5vZQ3WUXD6vvV57N";
                if (zA93) {
                    if (!A0I(492, 9, 73).equals(c1242Ce.A07.A0O)) {
                    }
                }
                i11 = 0;
                j11 = 0;
                strA0I = A0I(128, 11, 7);
                if (z11) {
                    jArr = new long[ck2.A05];
                    iArr = new int[ck2.A05];
                    while (ck2.A02()) {
                        jArr[ck2.A00] = ck2.A02;
                        iArr[ck2.A00] = ck2.A01;
                    }
                    format = c1242Ce.A07;
                    if (A01[6].charAt(18) != 'y') {
                        CR crA00 = CS.A00(IF.A05(format.A0A, c1242Ce.A07.A05), jArr, iArr, iA0H3);
                        jArr2 = crA00.A04;
                        iArr2 = crA00.A03;
                        i11 = crA00.A00;
                        jArr3 = crA00.A05;
                        iArr3 = crA00.A02;
                        j12 = crA00.A01;
                    } else {
                        String[] strArr = A01;
                        strArr[0] = "5";
                        strArr[5] = "P";
                        CR crA01 = CS.A00(IF.A05(format.A0A, c1242Ce.A07.A05), jArr, iArr, iA0H3);
                        jArr2 = crA01.A04;
                        iArr2 = crA01.A03;
                        i11 = crA01.A00;
                        jArr3 = crA01.A05;
                        iArr3 = crA01.A02;
                        j12 = crA01.A01;
                    }
                } else {
                    jArr2 = new long[iA7o];
                    iArr2 = new int[iA7o];
                    jArr3 = new long[iA7o];
                    iArr3 = new int[iA7o];
                    j13 = 0;
                    i12 = 0;
                    for (i13 = 0; i13 < iA7o; i13++) {
                        while (i12 == 0) {
                            AbstractC1351Ha.A04(ck2.A02());
                            if (A01[2].charAt(2) != 't') {
                                A01[7] = "3XDIuarfTH54Gh2sDFB8u";
                                j13 = ck2.A02;
                                i12 = ck2.A01;
                            }
                        }
                        if (c1376Hz5 != null) {
                            while (iA0H4 == 0) {
                                iA0H4 = c1376Hz5.A0H();
                                iA08 = c1376Hz5.A08();
                                iA0H5--;
                            }
                            iA0H4--;
                        }
                        jArr2[i13] = j13;
                        iArr2[i13] = xq2.AEN();
                        if (iArr2[i13] > i11) {
                            i11 = iArr2[i13];
                        }
                        jArr3[i13] = j11 + ((long) iA08);
                        if (c1376Hz4 == null) {
                            i14 = 1;
                        } else {
                            i14 = 0;
                        }
                        iArr3[i13] = i14;
                        if (i13 == iA0H6) {
                            iArr3[i13] = 1;
                            iA0H7--;
                            if (iA0H7 > 0) {
                                iA0H6 = c1376Hz4.A0H() - 1;
                            }
                        }
                        j11 += (long) iA0H3;
                        iA0H2--;
                        if (iA0H2 != 0) {
                        }
                        j13 += (long) iArr2[i13];
                        i12--;
                    }
                    j12 = j11 + ((long) iA08);
                    if (iA0H4 == 0) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    AbstractC1351Ha.A03(z13);
                    while (iA0H5 > 0) {
                        if (c1376Hz5.A0H() == 0) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        AbstractC1351Ha.A03(z14);
                        c1376Hz5.A08();
                        iA0H5--;
                    }
                    if (iA0H7 == 0) {
                        Log.w(strA0I, A0I(198, 32, 66) + c1242Ce.A00 + A0I(94, 34, 29) + iA0H7 + A0I(0, 35, 33) + iA0H2 + A0I(35, 26, 27) + i12 + A0I(61, 33, 101) + iA0H);
                    } else {
                        Log.w(strA0I, A0I(198, 32, 66) + c1242Ce.A00 + A0I(94, 34, 29) + iA0H7 + A0I(0, 35, 33) + iA0H2 + A0I(35, 26, 27) + i12 + A0I(61, 33, 101) + iA0H);
                    }
                }
                jA0F = IF.A0F(j12, 1000000L, c1242Ce.A06);
                if (c1242Ce.A08 != null) {
                }
                IF.A0a(jArr3, 1000000L, c1242Ce.A06);
                return new C1245Ch(c1242Ce, jArr2, iArr2, i11, jArr3, iArr3, jA0F);
            }
            A01[4] = "hEJdTsd1BrdgtnhVHuIKNZxoiMcvZFQc";
            if (zA93) {
                if (!A0I(492, 9, 73).equals(c1242Ce.A07.A0O) && iA0H == 0 && iA0H5 == 0 && iA0H7 == 0) {
                    z11 = true;
                }
            }
            i11 = 0;
            j11 = 0;
            strA0I = A0I(128, 11, 7);
            if (z11) {
                jArr2 = new long[iA7o];
                iArr2 = new int[iA7o];
                jArr3 = new long[iA7o];
                iArr3 = new int[iA7o];
                j13 = 0;
                i12 = 0;
                while (i13 < iA7o) {
                    while (i12 == 0) {
                        AbstractC1351Ha.A04(ck2.A02());
                        if (A01[2].charAt(2) != 't') {
                            A01[7] = "3XDIuarfTH54Gh2sDFB8u";
                            j13 = ck2.A02;
                            i12 = ck2.A01;
                        }
                    }
                    if (c1376Hz5 != null) {
                        while (iA0H4 == 0 && iA0H5 > 0) {
                            iA0H4 = c1376Hz5.A0H();
                            iA08 = c1376Hz5.A08();
                            iA0H5--;
                        }
                        iA0H4--;
                    }
                    jArr2[i13] = j13;
                    iArr2[i13] = xq2.AEN();
                    if (iArr2[i13] > i11) {
                        i11 = iArr2[i13];
                    }
                    jArr3[i13] = j11 + ((long) iA08);
                    if (c1376Hz4 == null) {
                        i14 = 1;
                    } else {
                        i14 = 0;
                    }
                    iArr3[i13] = i14;
                    if (i13 == iA0H6) {
                        iArr3[i13] = 1;
                        iA0H7--;
                        if (iA0H7 > 0) {
                            iA0H6 = c1376Hz4.A0H() - 1;
                        }
                    }
                    j11 += (long) iA0H3;
                    iA0H2--;
                    if (iA0H2 != 0 && iA0H > 0) {
                        iA0H2 = c1376Hz3.A0H();
                        iA0H3 = c1376Hz3.A08();
                        iA0H--;
                    }
                    j13 += (long) iArr2[i13];
                    i12--;
                }
                j12 = j11 + ((long) iA08);
                if (iA0H4 == 0) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                AbstractC1351Ha.A03(z13);
                while (iA0H5 > 0) {
                    if (c1376Hz5.A0H() == 0) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    AbstractC1351Ha.A03(z14);
                    c1376Hz5.A08();
                    iA0H5--;
                }
                if (iA0H7 == 0 || iA0H2 != 0 || i12 != 0 || iA0H != 0) {
                    Log.w(strA0I, A0I(198, 32, 66) + c1242Ce.A00 + A0I(94, 34, 29) + iA0H7 + A0I(0, 35, 33) + iA0H2 + A0I(35, 26, 27) + i12 + A0I(61, 33, 101) + iA0H);
                }
            } else {
                jArr = new long[ck2.A05];
                iArr = new int[ck2.A05];
                while (ck2.A02()) {
                    jArr[ck2.A00] = ck2.A02;
                    iArr[ck2.A00] = ck2.A01;
                }
                format = c1242Ce.A07;
                if (A01[6].charAt(18) != 'y') {
                    CR crA02 = CS.A00(IF.A05(format.A0A, c1242Ce.A07.A05), jArr, iArr, iA0H3);
                    jArr2 = crA02.A04;
                    iArr2 = crA02.A03;
                    i11 = crA02.A00;
                    jArr3 = crA02.A05;
                    iArr3 = crA02.A02;
                    j12 = crA02.A01;
                } else {
                    String[] strArr2 = A01;
                    strArr2[0] = "5";
                    strArr2[5] = "P";
                    CR crA03 = CS.A00(IF.A05(format.A0A, c1242Ce.A07.A05), jArr, iArr, iA0H3);
                    jArr2 = crA03.A04;
                    iArr2 = crA03.A03;
                    i11 = crA03.A00;
                    jArr3 = crA03.A05;
                    iArr3 = crA03.A02;
                    j12 = crA03.A01;
                }
            }
            jA0F = IF.A0F(j12, 1000000L, c1242Ce.A06);
            if (c1242Ce.A08 != null || c1237Bw.A03()) {
                IF.A0a(jArr3, 1000000L, c1242Ce.A06);
                return new C1245Ch(c1242Ce, jArr2, iArr2, i11, jArr3, iArr3, jA0F);
            }
            if (c1242Ce.A08.length == 1 && c1242Ce.A03 == 1 && jArr3.length >= 2) {
                long j14 = c1242Ce.A09[0];
                long jA0F2 = j14 + IF.A0F(c1242Ce.A08[0], c1242Ce.A06, c1242Ce.A05);
                if (A0N(jArr3, j12, j14, jA0F2)) {
                    long jA0F3 = IF.A0F(j14 - jArr3[0], c1242Ce.A07.A0C, c1242Ce.A06);
                    long jA0F4 = IF.A0F(j12 - jA0F2, c1242Ce.A07.A0C, c1242Ce.A06);
                    if (jA0F3 != 0 || jA0F4 != 0) {
                        jArr3 = jArr3;
                        jArr3 = jArr3;
                        if (jA0F3 <= 2147483647L && jA0F4 <= 2147483647L) {
                            c1237Bw.A00 = (int) jA0F3;
                            c1237Bw.A01 = (int) jA0F4;
                            IF.A0a(jArr3, 1000000L, c1242Ce.A06);
                            return new C1245Ch(c1242Ce, jArr2, iArr2, i11, jArr3, iArr3, jA0F);
                        }
                    }
                }
            }
            jArr3 = jArr3;
            jArr3 = jArr3;
            if (c1242Ce.A08.length == 1) {
                long[] jArr4 = c1242Ce.A08;
                if (A01[7].length() == 14) {
                    throw new RuntimeException();
                }
                String[] strArr3 = A01;
                strArr3[0] = "2";
                strArr3[5] = "c";
                if (jArr4[0] == 0) {
                    long j15 = c1242Ce.A09[0];
                    for (int i16 = 0; i16 < jArr3.length; i16++) {
                        jArr3[i16] = IF.A0F(jArr3[i16] - j15, 1000000L, c1242Ce.A06);
                    }
                    return new C1245Ch(c1242Ce, jArr2, iArr2, i11, jArr3, iArr3, IF.A0F(j12 - j15, 1000000L, c1242Ce.A06));
                }
            }
            boolean z16 = c1242Ce.A03 == 1;
            int i17 = 0;
            int i18 = 0;
            boolean z17 = false;
            for (int i19 = 0; i19 < c1242Ce.A08.length; i19++) {
                long j16 = c1242Ce.A09[i19];
                if (j16 != -1) {
                    long jA0F5 = IF.A0F(c1242Ce.A08[i19], c1242Ce.A06, c1242Ce.A05);
                    int iA0A = IF.A0A(jArr3, j16, true, true);
                    int iA0A2 = IF.A0A(jArr3, j16 + jA0F5, z16, false);
                    i17 += iA0A2 - iA0A;
                    z17 |= i18 != iA0A;
                    i18 = iA0A2;
                }
            }
            if (A01[1].length() != 12) {
                A01[6] = "kwnW70E81yVLGqt4h2ynIc7oXyulLjyz";
                if (i17 != iA7o) {
                    z12 = true;
                } else {
                    z12 = false;
                }
            } else {
                A01[4] = "IBcqblQzdyIwYrCXVHJIvpyFiJoNYMYn";
                if (i17 != iA7o) {
                    z12 = true;
                } else {
                    z12 = false;
                }
            }
            boolean z18 = z17 | z12;
            long[] jArr5 = z18 ? new long[i17] : jArr2;
            int[] iArr4 = z18 ? new int[i17] : iArr2;
            if (z18) {
                i11 = 0;
            }
            int[] iArr5 = z18 ? new int[i17] : iArr3;
            long[] jArr6 = new long[i17];
            long j17 = 0;
            int i21 = 0;
            for (int i22 = 0; i22 < c1242Ce.A08.length; i22++) {
                long j18 = c1242Ce.A09[i22];
                long j19 = c1242Ce.A08[i22];
                if (j18 != -1) {
                    long jA0F6 = IF.A0F(j19, c1242Ce.A06, c1242Ce.A05) + j18;
                    int iA0A3 = IF.A0A(jArr3, j18, true, true);
                    int iA0A4 = IF.A0A(jArr3, jA0F6, z16, false);
                    if (z18) {
                        int i23 = iA0A4 - iA0A3;
                        System.arraycopy(jArr2, iA0A3, jArr5, i21, i23);
                        System.arraycopy(iArr2, iA0A3, iArr4, i21, i23);
                        System.arraycopy(iArr3, iA0A3, iArr5, i21, i23);
                    }
                    if (iA0A3 < iA0A4 && (iArr5[i21] & 1) == 0) {
                        Log.w(strA0I, A0I(139, 59, 39));
                        throw new XP();
                    }
                    while (iA0A3 < iA0A4) {
                        jArr6[i21] = IF.A0F(j17, 1000000L, c1242Ce.A05) + IF.A0F(jArr3[iA0A3] - j18, 1000000L, c1242Ce.A06);
                        if (z18 && iArr4[i21] > i11) {
                            i11 = iArr2[iA0A3];
                        }
                        i21++;
                        iA0A3++;
                    }
                    if (A01[7].length() != 14) {
                        A01[7] = "ss";
                    }
                }
                j17 += j19;
            }
            return new C1245Ch(c1242Ce, jArr5, iArr4, i11, jArr6, iArr5, IF.A0F(j17, 1000000L, c1242Ce.A06));
            z11 = false;
            i11 = 0;
            j11 = 0;
            strA0I = A0I(128, 11, 7);
            if (z11) {
                jArr2 = new long[iA7o];
                iArr2 = new int[iA7o];
                jArr3 = new long[iA7o];
                iArr3 = new int[iA7o];
                j13 = 0;
                i12 = 0;
                while (i13 < iA7o) {
                    while (i12 == 0) {
                        AbstractC1351Ha.A04(ck2.A02());
                        if (A01[2].charAt(2) != 't') {
                            A01[7] = "3XDIuarfTH54Gh2sDFB8u";
                            j13 = ck2.A02;
                            i12 = ck2.A01;
                        }
                    }
                    if (c1376Hz5 != null) {
                        while (iA0H4 == 0) {
                            iA0H4 = c1376Hz5.A0H();
                            iA08 = c1376Hz5.A08();
                            iA0H5--;
                        }
                        iA0H4--;
                    }
                    jArr2[i13] = j13;
                    iArr2[i13] = xq2.AEN();
                    if (iArr2[i13] > i11) {
                        i11 = iArr2[i13];
                    }
                    jArr3[i13] = j11 + ((long) iA08);
                    if (c1376Hz4 == null) {
                        i14 = 1;
                    } else {
                        i14 = 0;
                    }
                    iArr3[i13] = i14;
                    if (i13 == iA0H6) {
                        iArr3[i13] = 1;
                        iA0H7--;
                        if (iA0H7 > 0) {
                            iA0H6 = c1376Hz4.A0H() - 1;
                        }
                    }
                    j11 += (long) iA0H3;
                    iA0H2--;
                    if (iA0H2 != 0) {
                    }
                    j13 += (long) iArr2[i13];
                    i12--;
                }
                j12 = j11 + ((long) iA08);
                if (iA0H4 == 0) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                AbstractC1351Ha.A03(z13);
                while (iA0H5 > 0) {
                    if (c1376Hz5.A0H() == 0) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    AbstractC1351Ha.A03(z14);
                    c1376Hz5.A08();
                    iA0H5--;
                }
                if (iA0H7 == 0) {
                    Log.w(strA0I, A0I(198, 32, 66) + c1242Ce.A00 + A0I(94, 34, 29) + iA0H7 + A0I(0, 35, 33) + iA0H2 + A0I(35, 26, 27) + i12 + A0I(61, 33, 101) + iA0H);
                } else {
                    Log.w(strA0I, A0I(198, 32, 66) + c1242Ce.A00 + A0I(94, 34, 29) + iA0H7 + A0I(0, 35, 33) + iA0H2 + A0I(35, 26, 27) + i12 + A0I(61, 33, 101) + iA0H);
                }
            } else {
                jArr = new long[ck2.A05];
                iArr = new int[ck2.A05];
                while (ck2.A02()) {
                    jArr[ck2.A00] = ck2.A02;
                    iArr[ck2.A00] = ck2.A01;
                }
                format = c1242Ce.A07;
                if (A01[6].charAt(18) != 'y') {
                    CR crA04 = CS.A00(IF.A05(format.A0A, c1242Ce.A07.A05), jArr, iArr, iA0H3);
                    jArr2 = crA04.A04;
                    iArr2 = crA04.A03;
                    i11 = crA04.A00;
                    jArr3 = crA04.A05;
                    iArr3 = crA04.A02;
                    j12 = crA04.A01;
                } else {
                    String[] strArr4 = A01;
                    strArr4[0] = "5";
                    strArr4[5] = "P";
                    CR crA05 = CS.A00(IF.A05(format.A0A, c1242Ce.A07.A05), jArr, iArr, iA0H3);
                    jArr2 = crA05.A04;
                    iArr2 = crA05.A03;
                    i11 = crA05.A00;
                    jArr3 = crA05.A05;
                    iArr3 = crA05.A02;
                    j12 = crA05.A01;
                }
            }
            jA0F = IF.A0F(j12, 1000000L, c1242Ce.A06);
            if (c1242Ce.A08 != null) {
            }
            IF.A0a(jArr3, 1000000L, c1242Ce.A06);
            return new C1245Ch(c1242Ce, jArr2, iArr2, i11, jArr3, iArr3, jA0F);
        }
        throw new RuntimeException();
    }

    public static Metadata A0F(XS xs2, boolean z11) {
        if (z11) {
            return null;
        }
        C1376Hz c1376Hz = xs2.A00;
        c1376Hz.A0Y(8);
        while (c1376Hz.A04() >= 8) {
            int iA06 = c1376Hz.A06();
            int iA08 = c1376Hz.A08();
            if (c1376Hz.A08() == CJ.A0h) {
                c1376Hz.A0Y(iA06);
                return A0H(c1376Hz, iA06 + iA08);
            }
            c1376Hz.A0Z(iA08 - 8);
        }
        return null;
    }

    public static Metadata A0G(C1376Hz c1376Hz, int i11) {
        c1376Hz.A0Z(8);
        ArrayList arrayList = new ArrayList();
        while (c1376Hz.A06() < i11) {
            Id3Frame id3FrameA04 = CW.A04(c1376Hz);
            if (id3FrameA04 != null) {
                arrayList.add(id3FrameA04);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static Metadata A0H(C1376Hz c1376Hz, int i11) {
        c1376Hz.A0Z(12);
        while (true) {
            int iA06 = c1376Hz.A06();
            if (A01[2].charAt(2) == 't') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[0] = "B";
            strArr[5] = "e";
            if (iA06 >= i11) {
                return null;
            }
            int iA07 = c1376Hz.A06();
            int iA08 = c1376Hz.A08();
            if (c1376Hz.A08() == CJ.A0a) {
                c1376Hz.A0Y(iA07);
                return A0G(c1376Hz, iA07 + iA08);
            }
            c1376Hz.A0Z(iA08 - 8);
        }
    }

    public static String A0I(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 15);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0J() {
        A00 = new byte[]{92, 80, -94, -107, -99, -111, -103, -98, -103, -98, -105, -125, -111, -99, -96, -100, -107, -93, 113, -92, -124, -103, -99, -107, -93, -92, -111, -99, -96, 116, -107, -100, -92, -111, 80, 86, 74, -100, -113, -105, -117, -109, -104, -109, -104, -111, 125, -117, -105, -102, -106, -113, -99, 115, -104, 109, -110, -97, -104, -107, 74, -96, -108, -26, -39, -31, -43, -35, -30, -35, -30, -37, -56, -35, -31, -39, -25, -24, -43, -31, -28, -72, -39, -32, -24, -43, -73, -36, -43, -30, -37, -39, -25, -108, 102, 76, -98, -111, -103, -115, -107, -102, -107, -102, -109, Ascii.DEL, -91, -102, -113, -108, -98, -101, -102, -107, -90, -115, -96, -107, -101, -102, Ascii.DEL, -115, -103, -100, -104, -111, -97, 76, 87, -118, -123, -125, 102, 119, -120, -119, 123, -120, -119, Ascii.DEL, -99, -92, -91, -88, -97, -92, -99, 86, -101, -102, -97, -86, 86, -94, -97, -87, -86, 112, 86, -101, -102, -97, -86, 86, -102, -91, -101, -87, 86, -92, -91, -86, 86, -87, -86, -105, -88, -86, 86, -83, -97, -86, -98, 86, -105, 86, -87, -81, -92, -103, 86, -87, -105, -93, -90, -94, -101, 100, -102, -65, -76, -64, -65, -60, -70, -60, -59, -74, -65, -59, 113, -60, -59, -77, -67, 113, -77, -64, -55, 113, -73, -64, -61, 113, -59, -61, -78, -76, -68, 113, -61, -31, -48, -46, -38, -113, -41, -48, -30, -113, -35, -34, -113, -30, -48, -36, -33, -37, -44, -113, -29, -48, -47, -37, -44, -113, -30, -40, -23, -44, -113, -40, -35, -43, -34, -31, -36, -48, -29, -40, -34, -35, -64, -39, -34, -32, -37, -37, -38, -35, -33, -48, -49, -117, -40, -48, -49, -44, -52, -117, -35, -52, -33, -48, -103, -126, -111, -111, -115, -118, -124, -126, -107, -118, -112, -113, 80, -107, -107, -114, -115, 76, -103, -114, -115, -101, -86, -86, -90, -93, -99, -101, -82, -93, -87, -88, 105, -78, 103, -99, -101, -89, -97, -84, -101, 103, -89, -87, -82, -93, -87, -88, -88, -73, -73, -77, -80, -86, -88, -69, -80, -74, -75, 118, -65, 116, -76, -73, 123, 116, -86, -84, -88, 116, 125, 119, Ascii.DEL, 121, -120, -120, -124, -127, 123, 121, -116, -127, -121, -122, 71, -112, 69, -123, -120, 76, 69, -114, -116, -116, -89, -74, -74, -78, -81, -87, -89, -70, -81, -75, -76, 117, -66, 115, -73, -69, -81, -87, -79, -70, -81, -77, -85, 115, -70, -66, 121, -83, -96, -76, -93, -88, -82, 110, 114, -90, -81, -81, 126, -110, -127, -122, -116, 76, 126, -128, 80, -39, -19, -36, -31, -25, -89, -39, -28, -39, -37, 120, -116, 123, -128, -122, 70, 120, -124, -119, 68, -114, 121, -30, -10, -27, -22, -16, -80, -26, -30, -28, -76, -127, -107, -124, -119, -113, 79, -115, -112, 84, -127, 77, -116, -127, -108, -115, -49, -29, -46, -41, -35, -99, -37, -34, -45, -43, -71, -51, -68, -63, -57, -121, -54, -71, -49, -21, -1, -18, -13, -7, -71, 0, -8, -18, -72, -18, -2, -3, -96, -76, -93, -88, -82, 110, -75, -83, -93, 109, -93, -77, -78, 109, -89, -93, -36, -16, -33, -28, -22, -86, -15, -23, -33, -87, -33, -17, -18, -87, -29, -33, -74, -21, -19, -22, -31, -28, -25, -32, -72, -25, -35, -19, -69, -70, -69, -119, -17, -18, -17, -1, -65, -63, -54, -65, -65, -63, -54, -49, -55, -50, -49, -46, -54, -89, -38, -43, -45, -71, -49, -32, -53, -122, -39, -50, -43, -37, -46, -54, -122, -56, -53, -122, -42, -43, -39, -49, -38, -49, -36, -53, -127, -118, -127, -114, -123, -111, -116, -128, Utf8.REPLACEMENT_BYTE, -128, -109, -114, -116, Utf8.REPLACEMENT_BYTE, -120, -110, Utf8.REPLACEMENT_BYTE, -116, -128, -115, -125, -128, -109, -114, -111, -104, -12, -20, -5, -24, -114, 125, -113, -121, -8, -24, -19, -18, -91, -26, -7, -12, -14, -91, -18, -8, -91, -14, -26, -13, -23, -26, -7, -12, -9, -2, -8, -12, -6, -13, -31, -29, -48, -30, -76, -91, -82, -93, 96, -95, -76, -81, -83, 96, -87, -77, 96, -83, -95, -82, -92, -95, -76, -81, -78, -71, -58, -73, -54, -58, -74, -87, -92, -91, -61, -74, -79, -78, -68, 124, -128, -76, -67, -67, -112, -125, 126, Ascii.DEL, -119, 73, 123, -112, 125, -114, -127, 124, 125, -121, 71, -128, 125, -114, 123, -21, -34, -39, -38, -28, -92, -19, -94, -21, -29, -39, -93, -28, -29, -89, -93, -21, -27, -83, -95, -108, -113, -112, -102, 90, -93, 88, -95, -103, -113, 89, -102, -103, 93, 89, -95, -101, 100};
    }

    /* JADX WARN: Code duplicated, block: B:104:0x00c9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:105:0x00c9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:111:0x00c9 A[DONT_GENERATE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x008c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x0122 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x012b  */
    /* JADX WARN: Code duplicated, block: B:50:0x0136  */
    /* JADX WARN: Code duplicated, block: B:54:0x0148  */
    /* JADX WARN: Code duplicated, block: B:55:0x0154  */
    /* JADX WARN: Code duplicated, block: B:57:0x0158 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x0169  */
    /* JADX WARN: Code duplicated, block: B:60:0x016c  */
    /* JADX WARN: Code duplicated, block: B:62:0x0170 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x0187  */
    /* JADX WARN: Code duplicated, block: B:65:0x018a  */
    /* JADX WARN: Code duplicated, block: B:67:0x018e  */
    /* JADX WARN: Code duplicated, block: B:68:0x0196  */
    /* JADX WARN: Code duplicated, block: B:70:0x019a  */
    /* JADX WARN: Code duplicated, block: B:71:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:73:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:75:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:78:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:80:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:81:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:82:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:83:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:84:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:90:0x0209  */
    public static void A0K(C1376Hz c1376Hz, int i11, int i12, int i13, int i14, int i15, DrmInitData drmInitData, CM cm2, int i16) throws C11849v {
        int iA0E;
        DrmInitData drmInitDataA02 = drmInitData;
        int iIntValue = i11;
        c1376Hz.A0Y(i12 + 8 + 8);
        c1376Hz.A0Z(16);
        int iA0I = c1376Hz.A0I();
        int iA0I2 = c1376Hz.A0I();
        boolean z11 = false;
        float fA00 = 1.0f;
        c1376Hz.A0Z(50);
        int iA06 = c1376Hz.A06();
        if (iIntValue != CJ.A0S) {
            if (A01[7].length() != 14) {
                A01[2] = "PeJuctV1gZmOLx5oH2gSZJGQBpKTFEo9";
            }
            throw new RuntimeException();
        }
        Pair<Integer, C1243Cf> pairA09 = A09(c1376Hz, i12, i13);
        if (pairA09 != null) {
            iIntValue = ((Integer) pairA09.first).intValue();
            drmInitDataA02 = drmInitDataA02 == null ? null : drmInitDataA02.A02(((C1243Cf) pairA09.second).A02);
            cm2.A03[i16] = (C1243Cf) pairA09.second;
        }
        c1376Hz.A0Y(iA06);
        List<byte[]> listSingletonList = null;
        String strA0I = null;
        byte[] bArrA0O = null;
        int i17 = -1;
        String[] strArr = A01;
        if (strArr[0].length() == strArr[5].length()) {
            A01[4] = "jNZq0IwPPShJWAAKA9azFLLmiQKjz3bf";
            while (iA06 - i12 < i13) {
                c1376Hz.A0Y(iA06);
                int iA07 = c1376Hz.A06();
                int iA08 = c1376Hz.A08();
                if (iA08 == 0 && c1376Hz.A06() - i12 == i13) {
                    if (strA0I == null) {
                        return;
                    }
                    cm2.A02 = Format.A04(Integer.toString(i14), strA0I, null, -1, -1, iA0I, iA0I2, -1.0f, listSingletonList, i15, fA00, bArrA0O, i17, null, drmInitDataA02);
                    return;
                }
                AbstractC1351Ha.A05(iA08 > 0, A0I(574, 32, 87));
                int iA09 = c1376Hz.A08();
                if (iA09 == CJ.A09) {
                    AbstractC1351Ha.A04(strA0I == null);
                    strA0I = A0I(710, 9, 11);
                    c1376Hz.A0Y(iA07 + 8);
                    IH ihA00 = IH.A00(c1376Hz);
                    listSingletonList = ihA00.A04;
                    cm2.A00 = ihA00.A02;
                    if (!z11) {
                        fA00 = ihA00.A00;
                    }
                } else {
                    int i18 = CJ.A0Z;
                    if (A01[1].length() != 12) {
                        A01[7] = "trr";
                        if (iA09 == i18) {
                            AbstractC1351Ha.A04(strA0I == null);
                            strA0I = A0I(719, 10, 9);
                            c1376Hz.A0Y(iA07 + 8);
                            IN inA00 = IN.A00(c1376Hz);
                            listSingletonList = inA00.A01;
                            cm2.A00 = inA00.A00;
                        } else {
                            int i19 = CJ.A1V;
                            if (A01[4].charAt(24) != 'i') {
                                A01[4] = "BNWfK92Afgdig3u125odHn9NiRsm91NE";
                                if (iA09 == i19) {
                                    AbstractC1351Ha.A04(strA0I == null);
                                    if (iIntValue == CJ.A1T) {
                                        strA0I = A0I(729, 19, 102);
                                    } else {
                                        strA0I = A0I(748, 19, 28);
                                    }
                                } else if (iA09 == CJ.A0E) {
                                    AbstractC1351Ha.A04(strA0I == null);
                                    strA0I = A0I(LogSeverity.ALERT_VALUE, 10, 62);
                                } else if (iA09 == CJ.A0T) {
                                    AbstractC1351Ha.A04(strA0I == null);
                                    Pair<String, byte[]> pairA07 = A07(c1376Hz, iA07);
                                    strA0I = (String) pairA07.first;
                                    listSingletonList = Collections.singletonList((byte[]) pairA07.second);
                                } else if (iA09 == CJ.A0q) {
                                    fA00 = A00(c1376Hz, iA07);
                                    z11 = true;
                                } else if (iA09 == CJ.A1G) {
                                    bArrA0O = A0O(c1376Hz, iA07, iA08);
                                } else if (iA09 == CJ.A16) {
                                    iA0E = c1376Hz.A0E();
                                    c1376Hz.A0Z(3);
                                    if (iA0E == 0) {
                                        switch (c1376Hz.A0E()) {
                                            case 0:
                                                i17 = 0;
                                                break;
                                            case 1:
                                                i17 = 1;
                                                break;
                                            case 2:
                                                i17 = 2;
                                                break;
                                            case 3:
                                                i17 = 3;
                                                if (A01[1].length() != 12) {
                                                    A01[2] = "dnuTGkt9wQcTbo6J7tdoKURT12LZQ83u";
                                                } else {
                                                    A01[2] = "ncqjdIo8Q7C9TEhGWLQwCcGeWNY5S9h6";
                                                }
                                                break;
                                        }
                                    }
                                }
                            } else {
                                String[] strArr2 = A01;
                                strArr2[0] = "R";
                                strArr2[5] = "z";
                                if (iA09 == i19) {
                                    AbstractC1351Ha.A04(strA0I == null);
                                    if (iIntValue == CJ.A1T) {
                                        strA0I = A0I(729, 19, 102);
                                    } else {
                                        strA0I = A0I(748, 19, 28);
                                    }
                                } else if (iA09 == CJ.A0E) {
                                    AbstractC1351Ha.A04(strA0I == null);
                                    strA0I = A0I(LogSeverity.ALERT_VALUE, 10, 62);
                                } else if (iA09 == CJ.A0T) {
                                    AbstractC1351Ha.A04(strA0I == null);
                                    Pair<String, byte[]> pairA08 = A07(c1376Hz, iA07);
                                    strA0I = (String) pairA08.first;
                                    listSingletonList = Collections.singletonList((byte[]) pairA08.second);
                                } else if (iA09 == CJ.A0q) {
                                    fA00 = A00(c1376Hz, iA07);
                                    z11 = true;
                                } else if (iA09 == CJ.A1G) {
                                    bArrA0O = A0O(c1376Hz, iA07, iA08);
                                } else if (iA09 == CJ.A16) {
                                    iA0E = c1376Hz.A0E();
                                    c1376Hz.A0Z(3);
                                    if (iA0E == 0) {
                                        switch (c1376Hz.A0E()) {
                                            case 0:
                                                i17 = 0;
                                                break;
                                            case 1:
                                                i17 = 1;
                                                break;
                                            case 2:
                                                i17 = 2;
                                                break;
                                            case 3:
                                                i17 = 3;
                                                if (A01[1].length() != 12) {
                                                    A01[2] = "dnuTGkt9wQcTbo6J7tdoKURT12LZQ83u";
                                                } else {
                                                    A01[2] = "ncqjdIo8Q7C9TEhGWLQwCcGeWNY5S9h6";
                                                }
                                                break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                iA06 += iA08;
            }
            if (strA0I == null) {
                return;
            }
            cm2.A02 = Format.A04(Integer.toString(i14), strA0I, null, -1, -1, iA0I, iA0I2, -1.0f, listSingletonList, i15, fA00, bArrA0O, i17, null, drmInitDataA02);
            return;
        }
        throw new RuntimeException();
    }

    public static void A0L(C1376Hz c1376Hz, int i11, int i12, int i13, int i14, String str, CM cm2) throws C11849v {
        String strA0I;
        c1376Hz.A0Y(i12 + 8 + 8);
        List listSingletonList = null;
        long j11 = Long.MAX_VALUE;
        if (i11 == CJ.A03) {
            strA0I = A0I(295, 20, 18);
        } else if (i11 == CJ.A1P) {
            strA0I = A0I(388, 28, 55);
            int i15 = (i13 - 8) - 8;
            byte[] bArr = new byte[i15];
            c1376Hz.A0c(bArr, 0, i15);
            listSingletonList = Collections.singletonList(bArr);
        } else if (i11 == CJ.A1X) {
            strA0I = A0I(367, 21, 9);
        } else if (i11 == CJ.A19) {
            strA0I = A0I(295, 20, 18);
            j11 = 0;
        } else {
            if (i11 != CJ.A0A) {
                throw new IllegalStateException();
            }
            strA0I = A0I(342, 25, 56);
            cm2.A01 = 1;
        }
        cm2.A02 = Format.A09(Integer.toString(i14), strA0I, null, -1, 0, str, -1, null, j11, listSingletonList);
    }

    public static void A0M(C1376Hz c1376Hz, int i11, int i12, int i13, int i14, String str, boolean z11, DrmInitData drmInitData, CM cm2, int i15) throws C11849v {
        int iA0I;
        int iA0F;
        DrmInitData drmInitDataA02 = drmInitData;
        int iIntValue = i11;
        c1376Hz.A0Y(i12 + 8 + 8);
        int iA0I2 = 0;
        if (z11) {
            iA0I2 = c1376Hz.A0I();
            c1376Hz.A0Z(6);
        } else {
            c1376Hz.A0Z(8);
        }
        if (iA0I2 == 0 || iA0I2 == 1) {
            iA0I = c1376Hz.A0I();
            c1376Hz.A0Z(6);
            iA0F = c1376Hz.A0F();
            if (iA0I2 == 1) {
                c1376Hz.A0Z(16);
            }
        } else {
            if (iA0I2 != 2) {
                return;
            }
            c1376Hz.A0Z(16);
            iA0F = (int) Math.round(c1376Hz.A03());
            iA0I = c1376Hz.A0H();
            c1376Hz.A0Z(20);
        }
        int iA06 = c1376Hz.A06();
        if (iIntValue == CJ.A0R) {
            Pair<Integer, C1243Cf> pairA09 = A09(c1376Hz, i12, i13);
            if (A01[2].charAt(2) == 't') {
                throw new RuntimeException();
            }
            A01[1] = "rXJd0uQKTdLTB";
            if (pairA09 != null) {
                iIntValue = ((Integer) pairA09.first).intValue();
                drmInitDataA02 = drmInitDataA02 == null ? null : drmInitDataA02.A02(((C1243Cf) pairA09.second).A02);
                cm2.A03[i15] = (C1243Cf) pairA09.second;
            }
            c1376Hz.A0Y(iA06);
        }
        String strA0I = null;
        if (iIntValue == CJ.A05) {
            strA0I = A0I(426, 9, 14);
        } else if (iIntValue == CJ.A0N) {
            strA0I = A0I(457, 10, 114);
        } else if (iIntValue == CJ.A0J) {
            strA0I = A0I(501, 13, 123);
        } else if (iIntValue == CJ.A0L || iIntValue == CJ.A0M) {
            strA0I = A0I(514, 16, 48);
        } else if (iIntValue == CJ.A0K) {
            strA0I = A0I(530, 28, 108);
        } else if (iIntValue == CJ.A0w) {
            strA0I = A0I(TTAdConstant.PACKAGE_NAME_CODE, 10, 48);
        } else if (iIntValue == CJ.A0x) {
            strA0I = A0I(445, 12, 8);
        } else if (iIntValue == CJ.A0b || iIntValue == CJ.A15) {
            strA0I = A0I(492, 9, 73);
        } else if (iIntValue == CJ.A04) {
            strA0I = A0I(482, 10, 95);
        } else {
            int i16 = CJ.A06;
            if (A01[7].length() == 14) {
                throw new RuntimeException();
            }
            A01[1] = "HdbKXAaE1rDpPSyLEE9ktT";
            if (iIntValue == i16) {
                strA0I = A0I(435, 10, 105);
            }
        }
        byte[] bArr = null;
        if (A01[4].charAt(24) != 'i') {
            throw new RuntimeException();
        }
        A01[6] = "QyfbMcdO26pfDQU6rlymYH0CLTjMRKBW";
        while (iA06 - i12 < i13) {
            c1376Hz.A0Y(iA06);
            int iA08 = c1376Hz.A08();
            AbstractC1351Ha.A05(iA08 > 0, A0I(574, 32, 87));
            int iA09 = c1376Hz.A08();
            if (iA09 == CJ.A0T || (z11 && iA09 == CJ.A1W)) {
                int iA03 = iA09 == CJ.A0T ? iA06 : A03(c1376Hz, iA06, iA08);
                if (iA03 != -1) {
                    Pair<String, byte[]> pairA07 = A07(c1376Hz, iA03);
                    strA0I = (String) pairA07.first;
                    bArr = (byte[]) pairA07.second;
                    if (A0I(467, 15, 17).equals(strA0I)) {
                        Pair<Integer, Integer> pairA03 = AbstractC1355He.A03(bArr);
                        iA0F = ((Integer) pairA03.first).intValue();
                        iA0I = ((Integer) pairA03.second).intValue();
                    }
                }
            } else {
                int i17 = CJ.A0F;
                if (A01[2].charAt(2) == 't') {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[0] = "Q";
                strArr[5] = "M";
                if (iA09 == i17) {
                    c1376Hz.A0Y(iA06 + 8);
                    cm2.A02 = AQ.A07(c1376Hz, Integer.toString(i14), str, drmInitDataA02);
                } else if (iA09 == CJ.A0I) {
                    c1376Hz.A0Y(iA06 + 8);
                    cm2.A02 = AQ.A08(c1376Hz, Integer.toString(i14), str, drmInitDataA02);
                } else if (iA09 == CJ.A0H) {
                    cm2.A02 = Format.A07(Integer.toString(i14), strA0I, null, -1, -1, iA0I, iA0F, null, drmInitDataA02, 0, str);
                } else if (iA09 == CJ.A06) {
                    bArr = new byte[iA08];
                    c1376Hz.A0Y(iA06);
                    c1376Hz.A0c(bArr, 0, iA08);
                }
            }
            iA06 += iA08;
        }
        if (cm2.A02 != null || strA0I == null) {
            return;
        }
        cm2.A02 = Format.A06(Integer.toString(i14), strA0I, null, -1, -1, iA0I, iA0F, A0I(492, 9, 73).equals(strA0I) ? 2 : -1, bArr != null ? Collections.singletonList(bArr) : null, drmInitDataA02, 0, str);
    }

    public static boolean A0N(long[] jArr, long j11, long j12, long j13) {
        int length = jArr.length - 1;
        return jArr[0] <= j12 && j12 < jArr[IF.A06(3, 0, length)] && jArr[IF.A06(jArr.length - 3, 0, length)] < j13 && j13 <= j11;
    }

    public static byte[] A0O(C1376Hz c1376Hz, int i11, int i12) {
        int i13 = i11 + 8;
        while (true) {
            int i14 = i13 - i11;
            String[] strArr = A01;
            if (strArr[0].length() != strArr[5].length()) {
                break;
            }
            A01[2] = "hiyhCkw83qioTZht4ycME2aPtqNlSya0";
            if (i14 >= i12) {
                if (A01[4].charAt(24) != 'i') {
                    return null;
                }
                A01[6] = "op0Xll27WP2wTMdM3NyEU8fL7oyu7ROp";
                return null;
            }
            c1376Hz.A0Y(i13);
            int iA08 = c1376Hz.A08();
            int iA09 = c1376Hz.A08();
            int i15 = CJ.A0r;
            if (A01[2].charAt(2) == 't') {
                break;
            }
            String[] strArr2 = A01;
            strArr2[0] = "K";
            strArr2[5] = "V";
            if (iA09 == i15) {
                return Arrays.copyOfRange(c1376Hz.A00, i13, i13 + iA08);
            }
            i13 += iA08;
        }
        throw new RuntimeException();
    }
}
