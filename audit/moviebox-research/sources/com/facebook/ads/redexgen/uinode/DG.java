package com.facebook.ads.redexgen.uinode;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import com.applovin.exoplayer2.common.base.Ascii;
import com.transsion.gslb.Worker;
import java.util.Arrays;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.Utf8;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class DG {
    public static byte[] A07;
    public static String[] A08 = {"l47F2JAJicAi7iJT7Ur8ZlCw", "pcnHbOoGzPExKCHxm2AK1l1xVYlhX3pn", "L7qDH0sZJIKjQPetVGF", "mKMCCcAhi76NHeIY7m5kov", "q39HFngYrns05eD5pjaqNYndLlzCP1N1", "S0mWvWCgmnvtEg9hs9CnV7qg", "HTiL2pHQ4MkdfTxzAGhBA6OvrbDKlrFs", "nbOKc9xHpWJnEmTOZOJWDKzO97xo4CwF"};
    public final MediaCodecInfo.CodecCapabilities A00;
    public final String A01;
    public final String A02;
    public final boolean A03;
    public final boolean A04;
    public final boolean A05;
    public final boolean A06;

    static {
        A04();
    }

    public DG(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z11, boolean z12, boolean z13) {
        this.A02 = (String) AbstractC1351Ha.A01(str);
        this.A01 = str2;
        this.A00 = codecCapabilities;
        this.A04 = z11;
        boolean z14 = true;
        this.A03 = (z12 || codecCapabilities == null || !A07(codecCapabilities)) ? false : true;
        this.A06 = codecCapabilities != null && A0B(codecCapabilities);
        if (!z13 && (codecCapabilities == null || !A09(codecCapabilities))) {
            z14 = false;
        }
        this.A05 = z14;
    }

    public static int A00(String str, String str2, int i11) {
        int i12;
        if (i11 > 1 || ((IF.A02 >= 26 && i11 > 0) || A03(226, 10, 45).equals(str2) || A03(121, 10, 96).equals(str2) || A03(140, 12, 97).equals(str2) || A03(211, 15, 35).equals(str2) || A03(255, 12, 77).equals(str2) || A03(236, 10, 92).equals(str2) || A03(246, 9, 101).equals(str2) || A03(162, 10, 106).equals(str2) || A03(172, 15, 62).equals(str2) || A03(187, 15, 13).equals(str2) || A03(202, 9, 74).equals(str2))) {
            return i11;
        }
        if (A03(131, 9, 44).equals(str2)) {
            i12 = 6;
        } else {
            String strA03 = A03(152, 10, 58);
            if (A08[4].charAt(25) == 'Z') {
                throw new RuntimeException();
            }
            A08[4] = "P3Nhh7RBH5ErFPjvJQxGDiPekJNUcZJn";
            i12 = strA03.equals(str2) ? 16 : 30;
        }
        Log.w(A03(54, 14, 111), A03(9, 29, 122) + str + A03(6, 3, 52) + i11 + A03(0, 4, 49) + i12 + A03(79, 1, 119));
        return i12;
    }

    public static DG A01(String str) {
        return new DG(str, null, null, true, false, false);
    }

    public static DG A02(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z11, boolean z12) {
        return new DG(str, str2, codecCapabilities, false, z11, z12);
    }

    public static String A03(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 121);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A07 = new byte[]{-54, Ascii.RS, Ascii.EM, -54, Ascii.GS, 17, -39, -51, 8, 52, 102, 102, 104, 96, 88, 87, 64, 84, 107, 54, 91, 84, 97, 97, 88, 95, 52, 87, 93, 104, 102, 103, 96, 88, 97, 103, 45, 19, 56, 106, 106, 108, 100, 92, 91, 74, 108, 103, 103, 102, 105, 107, Ascii.ETB, 82, 53, 77, 76, 81, 73, 43, 87, 76, 77, 75, 49, 86, 78, 87, 4, 37, 9, 43, 38, 38, 37, 40, 42, -42, 17, 77, 58, -3, 56, 36, 39, 36, 51, 55, 44, 57, 40, -16, 51, 47, 36, 60, 37, 36, 38, 46, Ascii.FS, 39, 36, 34, 41, -23, Ascii.RS, Ascii.FS, 43, 46, -31, -20, -23, -25, -18, -82, -10, -61, -31, -16, -13, 58, 78, 61, 66, 72, 8, Ascii.FF, 64, 73, 73, 6, Ascii.SUB, 9, Ascii.SO, Ascii.DC4, -44, 6, 8, -40, 59, 79, 62, 67, 73, 9, 59, 71, 76, 7, 81, 60, Ascii.DC4, 40, Ascii.ETB, Ascii.FS, 34, -30, Ascii.CAN, Ascii.DC4, Ascii.SYN, -26, 68, 88, 71, 76, 82, Ascii.DC2, 73, 79, 68, 70, Ascii.CAN, 44, Ascii.ESC, 32, 38, -26, Ascii.RS, -18, -24, -24, -28, Ascii.CAN, 35, Ascii.CAN, 46, -25, -5, -22, -17, -11, -75, -19, -67, -73, -73, -77, -13, -14, -25, -3, 36, 56, 39, 44, 50, -14, 42, 54, 48, -3, 17, 0, 5, Ascii.VT, -53, 9, Ascii.FF, -48, -3, -55, 8, -3, Ascii.DLE, 9, 7, Ascii.ESC, 10, Ascii.SI, Ascii.NAK, -43, 19, Ascii.SYN, Ascii.VT, Ascii.CR, 54, 74, 57, 62, 68, 4, 68, 69, 74, 72, Utf8.REPLACEMENT_BYTE, 83, 66, 71, 77, Ascii.CR, 80, Utf8.REPLACEMENT_BYTE, 85, 39, 59, 42, 47, 53, -11, 60, 53, 56, 40, 47, 57, Ascii.SO, 19, Ascii.FF, Ascii.EM, Ascii.EM, Ascii.DLE, Ascii.ETB, -18, Ascii.SUB, 32, Ascii.EM, Ascii.US, -39, Ascii.FF, -18, Ascii.FF, Ascii.ESC, Ascii.RS, 5, 10, 3, Ascii.DLE, Ascii.DLE, 7, Ascii.SO, -27, 17, Ascii.ETB, Ascii.DLE, Ascii.SYN, -48, 5, 3, Ascii.DC2, Ascii.NAK, 44, 49, 42, 55, 55, 46, 53, Ascii.FF, 56, 62, 55, 61, -9, 60, 62, 57, 57, 56, 59, 61, -11, -23, -17, -5, -16, -15, -17, -70, -7, -11, -7, -15, -84, 87, 99, 88, 89, 87, 34, 100, 102, 99, 90, 93, 96, 89, 64, 89, 106, 89, 96, 32, Ascii.DC4, Ascii.DLE, -2, 10, Ascii.CR, 9, 2, -17, -2, 17, 2, -53, -2, -32, -2, Ascii.CR, Ascii.DLE, 87, 69, 81, 84, 80, 73, 54, 69, 88, 73, Ascii.DC2, 71, 69, 84, 87, 46, Ascii.FS, 40, 43, 39, 32, Ascii.CR, Ascii.FS, 47, 32, -23, 46, 48, 43, 43, 42, 45, 47, -25, -37, Ascii.DC4, 6, 4, Ascii.SYN, 19, 6, -50, 17, Ascii.CR, 2, Ascii.SUB, 3, 2, 4, Ascii.FF, 81, 71, 88, 67, Ascii.US, 76, 66, 48, Utf8.REPLACEMENT_BYTE, 82, 67, Ascii.FF, 65, Utf8.REPLACEMENT_BYTE, 78, 81, 9, -1, Ascii.DLE, -5, -41, 4, -6, -24, -9, 10, -5, -60, 8, 5, 10, -9, 10, -5, -6, -62, -74, 80, 70, 87, 66, Ascii.RS, 75, 65, 47, 62, 81, 66, Ascii.VT, 80, 82, 77, 77, 76, 79, 81, 9, -3, 40, Ascii.RS, 47, Ascii.SUB, -10, 35, Ascii.EM, 7, Ascii.SYN, 41, Ascii.SUB, -29, 43, -8, Ascii.SYN, 37, 40, Ascii.RS, Ascii.US, Ascii.CAN, Ascii.CAN, Ascii.SI, Ascii.SYN, Ascii.SI, Ascii.SO, -41, Ascii.SUB, Ascii.SYN, Ascii.VT, 35, Ascii.FF, Ascii.VT, Ascii.CR, Ascii.NAK, 58};
    }

    private void A05(String str) {
        StringBuilder sbAppend = new StringBuilder().append(A03(38, 16, WebSocketProtocol.PAYLOAD_SHORT)).append(str);
        String strA03 = A03(80, 3, 100);
        sbAppend.append(strA03).append(this.A02).append(A03(4, 2, 120)).append(this.A01).append(strA03).append(IF.A04).append(A03(79, 1, 119)).toString();
    }

    private void A06(String str) {
        StringBuilder sbAppend = new StringBuilder().append(A03(68, 11, 61)).append(str);
        String strA03 = A03(80, 3, 100);
        sbAppend.append(strA03).append(this.A02).append(A03(4, 2, 120)).append(this.A01).append(strA03).append(IF.A04).append(A03(79, 1, 119)).toString();
    }

    public static boolean A07(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return IF.A02 >= 19 && A08(codecCapabilities);
    }

    public static boolean A08(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(A03(83, 17, 74));
    }

    public static boolean A09(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return IF.A02 >= 21 && A0A(codecCapabilities);
    }

    public static boolean A0A(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(A03(406, 15, 40));
    }

    public static boolean A0B(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return IF.A02 >= 21 && A0C(codecCapabilities);
    }

    public static boolean A0C(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(A03(496, 17, 49));
    }

    public static boolean A0D(MediaCodecInfo.VideoCapabilities videoCapabilities, int i11, int i12, double d11) {
        return (d11 == -1.0d || d11 <= 0.0d) ? videoCapabilities.isSizeSupported(i11, i12) : videoCapabilities.areSizeAndRateSupported(i11, i12, d11);
    }

    public final Point A0E(int i11, int i12) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.A00;
        if (codecCapabilities == null) {
            A06(A03(100, 10, 66));
            return null;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            A06(A03(Worker.WHAT_QUIT, 11, 7));
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(IF.A04(i11, widthAlignment) * widthAlignment, IF.A04(i12, heightAlignment) * heightAlignment);
    }

    public final boolean A0F(int i11) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.A00;
        if (codecCapabilities == null) {
            A06(A03(285, 17, 41));
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            A06(A03(267, 18, 50));
            return false;
        }
        if (A00(this.A02, this.A01, audioCapabilities.getMaxInputChannelCount()) >= i11) {
            return true;
        }
        A06(A03(302, 22, 80) + i11);
        return false;
    }

    public final boolean A0G(int i11) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.A00;
        if (codecCapabilities != null) {
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                A06(A03(355, 16, 36));
                return false;
            }
            if (audioCapabilities.isSampleRateSupported(i11)) {
                return true;
            }
            A06(A03(386, 20, 66) + i11);
            return false;
        }
        String strA03 = A03(371, 15, 107);
        String[] strArr = A08;
        if (strArr[7].charAt(27) == strArr[1].charAt(27)) {
            throw new RuntimeException();
        }
        A08[4] = "1TDMmIQfG5hcmUgl4hLs4ptEQsykv9BZ";
        A06(strA03);
        return false;
    }

    public final boolean A0H(int i11, int i12, double d11) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.A00;
        if (codecCapabilities == null) {
            A06(A03(StatusLine.HTTP_MISDIRECTED_REQUEST, 16, 101));
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            A06(A03(479, 17, 60));
            return false;
        }
        if (A0D(videoCapabilities, i11, i12, d11)) {
            return true;
        }
        String strA03 = A03(513, 1, 73);
        if (i11 >= i12 || !A0D(videoCapabilities, i12, i11, d11)) {
            A06(A03(458, 21, 100) + i11 + strA03 + i12 + strA03 + d11);
            return false;
        }
        A05(A03(437, 21, 29) + i11 + strA03 + i12 + strA03 + d11);
        return true;
    }

    public final boolean A0I(String str) {
        if (str == null || this.A01 == null) {
            return true;
        }
        String strA05 = AbstractC1369Hs.A05(str);
        if (A08[4].charAt(25) != 'Z') {
            String[] strArr = A08;
            strArr[7] = "DCoMJKO3SQRZ9AZ8Punft1OMrNVoZ9FQ";
            strArr[1] = "kGwQMpRYxL2xz4mLYOs80Kob4iU3fTuT";
            if (strA05 == null) {
                return true;
            }
            boolean zEquals = this.A01.equals(strA05);
            String strA03 = A03(4, 2, 120);
            if (A08[6].charAt(14) != 'p') {
                A08[6] = "vbTHdtkviQLZpSNmsPVzchXkRABJSF9Q";
                if (!zEquals) {
                    A06(A03(324, 11, 19) + str + strA03 + strA05);
                    return false;
                }
                Pair<Integer, Integer> pairA02 = DR.A02(str);
                if (pairA02 == null) {
                    return true;
                }
                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : A0J()) {
                    if (codecProfileLevel.profile == ((Integer) pairA02.first).intValue() && codecProfileLevel.level >= ((Integer) pairA02.second).intValue()) {
                        return true;
                    }
                }
                A06(A03(335, 20, 123) + str + strA03 + strA05);
                return false;
            }
        }
        throw new RuntimeException();
    }

    public final MediaCodecInfo.CodecProfileLevel[] A0J() {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.A00;
        return (codecCapabilities == null || codecCapabilities.profileLevels == null) ? new MediaCodecInfo.CodecProfileLevel[0] : this.A00.profileLevels;
    }
}
