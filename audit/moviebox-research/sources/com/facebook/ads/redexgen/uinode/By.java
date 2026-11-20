package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.DefaultOggSeeker;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class By {
    public static byte[] A07;
    public static String[] A08 = {"FJwhSbR0Dqb1wEJXVBdpfUEyE2PwmXT5", "QXyUQtNV4ztNvs", "u680PItdmSCtrwUArgQMKOt5dGhFKyFy", "M6QX6bpZXsa0EpVfLqUIYL0ok3oIyD", "4ddrBoC1HSiu89JLzfXMV59B74qIm2xJ", "MUUz2dKYtP7sZF6Tuk5kEGRgHEx452fJ", "i1sqGOju2LE8Q92QQNgFTaNu0rUo1z4f", "5HWyWxmgcaxBLo1LpD3PpaOIjtbRMHJC"};
    public static final int[] A09;
    public static final int[] A0A;
    public static final int[] A0B;
    public static final int[] A0C;
    public static final int[] A0D;
    public static final int[] A0E;
    public static final String[] A0F;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public String A06;

    static {
        A02();
        A0F = new String[]{A01(10, 13, 94), A01(23, 13, 115), A01(0, 10, 1)};
        A0E = new int[]{44100, 48000, 32000};
        A09 = new int[]{32, 64, 96, 128, 160, PsExtractor.AUDIO_STREAM, 224, 256, 288, 320, 352, 384, TTAdConstant.PACKAGE_NAME_CODE, 448};
        A0D = new int[]{32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, PsExtractor.AUDIO_STREAM, 224, 256};
        A0A = new int[]{32, 48, 56, 64, 80, 96, 112, 128, 160, PsExtractor.AUDIO_STREAM, 224, 256, 320, 384};
        A0B = new int[]{32, 40, 48, 56, 64, 80, 96, 112, 128, 160, PsExtractor.AUDIO_STREAM, 224, 256, 320};
        A0C = new int[]{8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160};
    }

    public static int A00(int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        if ((i11 & (-2097152)) != -2097152 || (i12 = (i11 >>> 19) & 3) == 1 || (i13 = (i11 >>> 17) & 3) == 0 || (i14 = (i11 >>> 12) & 15) == 0 || i14 == 15 || (i15 = (i11 >>> 10) & 3) == 3) {
            return -1;
        }
        int i17 = A0E[i15];
        if (i12 == 2) {
            i17 /= 2;
        } else if (i12 == 0) {
            i17 /= 4;
        }
        int i18 = (i11 >>> 9) & 1;
        String[] strArr = A08;
        if (strArr[5].charAt(20) == strArr[4].charAt(20)) {
            throw new RuntimeException();
        }
        A08[0] = "wCPzQVRdLc9fuoZbbzdyTQMs65DUcW8k";
        if (i13 == 3) {
            return ((((i12 == 3 ? A09[i14 - 1] : A0D[i14 - 1]) * 12000) / i17) + i18) * 4;
        }
        if (i12 == 3) {
            i16 = i13 == 2 ? A0A[i14 - 1] : A0B[i14 - 1];
        } else {
            i16 = A0C[i14 - 1];
        }
        if (i12 == 3) {
            return ((144000 * i16) / i17) + i18;
        }
        return (((i13 == 1 ? DefaultOggSeeker.MATCH_RANGE : 144000) * i16) / i17) + i18;
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            int i15 = bArrCopyOfRange[i14] - i13;
            String[] strArr = A08;
            if (strArr[6].charAt(26) == strArr[2].charAt(26)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[6] = "mZfo4fIlXHQscYR0BkWPKUfaL8c0bByk";
            strArr2[2] = "AkiufmiMzZJvhyS77AiglOXb5e3YRP2V";
            bArrCopyOfRange[i14] = (byte) (i15 - 94);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A07 = new byte[]{-64, -44, -61, -56, -50, -114, -52, -49, -60, -58, Ascii.GS, 49, 32, 37, 43, -21, 41, 44, 33, 35, -23, 8, -19, 50, 70, 53, 58, 64, 0, 62, 65, 54, 56, -2, Ascii.GS, 3};
    }

    private void A03(int i11, String str, int i12, int i13, int i14, int i15, int i16) {
        this.A05 = i11;
        this.A06 = str;
        this.A02 = i12;
        this.A03 = i13;
        this.A01 = i14;
        this.A00 = i15;
        this.A04 = i16;
    }

    public static boolean A04(int i11, By by) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        if ((i11 & (-2097152)) != -2097152 || (i12 = (i11 >>> 19) & 3) == 1 || (i13 = (i11 >>> 17) & 3) == 0 || (i14 = (i11 >>> 12) & 15) == 0 || i14 == 15 || (i15 = (i11 >>> 10) & 3) == 3) {
            return false;
        }
        int i19 = A0E[i15];
        if (i12 == 2) {
            i19 /= 2;
        } else if (i12 == 0) {
            i19 /= 4;
        }
        int i21 = (i11 >>> 9) & 1;
        if (i13 == 3) {
            i16 = i12 == 3 ? A09[i14 - 1] : A0D[i14 - 1];
            i18 = (((i16 * 12000) / i19) + i21) * 4;
            i17 = 384;
        } else {
            if (i12 == 3) {
                i16 = i13 == 2 ? A0A[i14 - 1] : A0B[i14 - 1];
                i17 = 1152;
                i18 = ((144000 * i16) / i19) + i21;
            } else {
                i16 = A0C[i14 - 1];
                i17 = i13 == 1 ? 576 : 1152;
                i18 = (((i13 == 1 ? DefaultOggSeeker.MATCH_RANGE : 144000) * i16) / i19) + i21;
            }
        }
        by.A03(i12, A0F[3 - i13], i18, i19, ((i11 >> 6) & 3) == 3 ? 1 : 2, i16 * 1000, i17);
        return true;
    }
}
