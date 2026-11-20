package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.internal.exoplayer2.thirdparty.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.vungle.warren.error.VungleException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class B1 {
    public static byte[] A00;
    public static String[] A01 = {"LgmYw98W3bgowMYQY6Q3BawqAxXNUuUl", "GpzgTRDYOaIyAt6xSJRYAk3b6rAdzkZ0", "RtCZFOI40BGARGfB2sOg6MLybkAs9Fzf", "Gx3YqKVlWhsXJsTGKtjglmBlxW0pOlYg", "tq174XAFZe", "aVWuh4A2S2MgQagwT", "vwD2gnTxyUihDEDfn", "xhuYGO7iBGvSpDZMcS9LxFC"};
    public static final int[] A02;
    public static final int[] A03;
    public static final int[] A04;

    static {
        A06();
        A02 = new int[]{1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
        A03 = new int[]{-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
        A04 = new int[]{64, 112, 128, PsExtractor.AUDIO_STREAM, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};
    }

    public static int A00(ByteBuffer byteBuffer) {
        int i11;
        int iPosition = byteBuffer.position();
        switch (byteBuffer.get(iPosition)) {
            case -2:
                i11 = ((byteBuffer.get(iPosition + 5) & 1) << 6) | ((byteBuffer.get(iPosition + 4) & 252) >> 2);
                break;
            case -1:
                i11 = ((byteBuffer.get(iPosition + 4) & 7) << 4) | ((byteBuffer.get(iPosition + 7) & 60) >> 2);
                break;
            case VungleException.WEB_CRASH /* 31 */:
                i11 = ((byteBuffer.get(iPosition + 5) & 7) << 4) | ((byteBuffer.get(iPosition + 6) & 60) >> 2);
                break;
            default:
                i11 = ((byteBuffer.get(iPosition + 4) & 1) << 6) | ((byteBuffer.get(iPosition + 5) & 252) >> 2);
                break;
        }
        return (i11 + 1) * 32;
    }

    public static int A01(byte[] bArr) {
        int i11;
        boolean z11 = false;
        switch (bArr[0]) {
            case -2:
                i11 = (((bArr[4] & 3) << 12) | ((bArr[7] & 255) << 4) | ((bArr[6] & 240) >> 4)) + 1;
                break;
            case -1:
                int i12 = (bArr[7] & 3) << 12;
                int i13 = (bArr[6] & 255) << 4;
                if (A01[1].charAt(17) == 'C') {
                    i11 = (i12 | i13 | ((bArr[9] & 60) >> 2)) + 1;
                    z11 = true;
                } else {
                    A01[2] = "MBjMF3o66WyYJ7fC9eQP49KWn3JCWQGt";
                    i11 = (i12 | i13 | ((bArr[9] & 60) >> 2)) + 1;
                    z11 = true;
                }
                break;
            case VungleException.WEB_CRASH /* 31 */:
                int i14 = (bArr[6] & 3) << 12;
                byte b11 = bArr[7];
                String[] strArr = A01;
                if (strArr[5].length() != strArr[6].length()) {
                    throw new RuntimeException();
                }
                A01[0] = "meKDaeVMRSRS1vVcwwYXxolxpiaSquNW";
                i11 = (i14 | ((b11 & 255) << 4) | ((bArr[8] & 60) >> 2)) + 1;
                z11 = true;
                break;
            default:
                i11 = (((bArr[5] & 3) << 12) | ((bArr[6] & 255) << 4) | ((bArr[7] & 240) >> 4)) + 1;
                break;
        }
        return z11 ? (i11 * 16) / 14 : i11;
    }

    public static int A02(byte[] bArr) {
        int i11;
        switch (bArr[0]) {
            case -2:
                i11 = ((bArr[5] & 1) << 6) | ((bArr[4] & 252) >> 2);
                break;
            case -1:
                i11 = ((bArr[4] & 7) << 4) | ((bArr[7] & 60) >> 2);
                break;
            case VungleException.WEB_CRASH /* 31 */:
                i11 = ((bArr[5] & 7) << 4) | ((bArr[6] & 60) >> 2);
                break;
            default:
                byte b11 = bArr[4];
                String[] strArr = A01;
                if (strArr[5].length() != strArr[6].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A01;
                strArr2[5] = "0rS52mmndmktv37b0";
                strArr2[6] = "cQepkBNQqnKQzzIfS";
                i11 = ((b11 & 1) << 6) | ((bArr[5] & 252) >> 2);
                break;
        }
        return (i11 + 1) * 32;
    }

    public static Format A03(byte[] bArr, String str, String str2, DrmInitData drmInitData) {
        C1375Hy c1375HyA04 = A04(bArr);
        c1375HyA04.A08(60);
        int i11 = A02[c1375HyA04.A04(6)];
        int i12 = A03[c1375HyA04.A04(4)];
        int iA04 = c1375HyA04.A04(5);
        int[] iArr = A04;
        int i13 = iA04 >= iArr.length ? -1 : (iArr[iA04] * 1000) / 2;
        c1375HyA04.A08(10);
        return Format.A07(str, A05(0, 13, 102), null, i13, -1, i11 + (c1375HyA04.A04(2) > 0 ? 1 : 0), i12, null, drmInitData, 0, str2);
    }

    public static C1375Hy A04(byte[] bArr) {
        if (bArr[0] == 127) {
            return new C1375Hy(bArr);
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        if (A08(bArrCopyOf)) {
            for (int i11 = 0; i11 < bArrCopyOf.length - 1; i11 += 2) {
                byte b11 = bArrCopyOf[i11];
                bArrCopyOf[i11] = bArrCopyOf[i11 + 1];
                bArrCopyOf[i11 + 1] = b11;
            }
        }
        C1375Hy c1375Hy = new C1375Hy(bArrCopyOf);
        if (bArrCopyOf[0] == 31) {
            C1375Hy c1375Hy2 = new C1375Hy(bArrCopyOf);
            while (c1375Hy2.A01() >= 16) {
                c1375Hy2.A08(2);
                c1375Hy.A0A(c1375Hy2.A04(14), 14);
            }
        }
        c1375Hy.A0B(bArrCopyOf);
        return c1375Hy;
    }

    public static String A05(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 70);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A00 = new byte[]{65, 85, 68, 73, 79, Ascii.SI, 86, 78, 68, Ascii.SO, 68, 84, 83};
    }

    public static boolean A07(int i11) {
        return i11 == 2147385345 || i11 == -25230976 || i11 == 536864768 || i11 == -14745368;
    }

    public static boolean A08(byte[] bArr) {
        return bArr[0] == -2 || bArr[0] == -1;
    }
}
