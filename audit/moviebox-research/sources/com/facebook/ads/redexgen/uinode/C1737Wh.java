package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1737Wh implements DY {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 87);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-61, -10, -10, -25, -17, -14, -10, -25, -26, -94, -10, -15, -94, -27, -12, -25, -29, -10, -25, -94, -26, -25, -27, -15, -26, -25, -12, -94, -24, -15, -12, -94, -9, -16, -11, -9, -14, -14, -15, -12, -10, -25, -26, -94, -24, -15, -12, -17, -29, -10, 8, Ascii.ETB, Ascii.ETB, 19, Ascii.DLE, 10, 8, Ascii.ESC, Ascii.DLE, Ascii.SYN, Ascii.NAK, -42, Ascii.DLE, Ascii.VT, -38, -39, -24, -24, -28, -31, -37, -39, -20, -31, -25, -26, -89, -16, -91, -35, -27, -21, -33, -72, -57, -57, -61, -64, -70, -72, -53, -64, -58, -59, -122, -49, -124, -54, -70, -53, -68, -118, -116};
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0009  */
    @Override // com.facebook.ads.redexgen.uinode.DY
    public final DW A4Y(Format format) {
        byte b11;
        String str = format.A0O;
        switch (str.hashCode()) {
            case -1248341703:
                if (!str.equals(A00(50, 15, 80))) {
                    b11 = -1;
                } else {
                    b11 = 0;
                }
                break;
            case 1154383568:
                if (!str.equals(A00(65, 18, 33))) {
                    b11 = -1;
                } else {
                    b11 = 1;
                }
                break;
            case 1652648887:
                if (!str.equals(A00(83, 20, 0))) {
                    b11 = -1;
                } else {
                    b11 = 2;
                }
                break;
            default:
                b11 = -1;
                break;
        }
        switch (b11) {
            case 0:
                return new C1734Wd();
            case 1:
                return new C1736Wf();
            case 2:
                return new C1733Wa();
            default:
                throw new IllegalArgumentException(A00(0, 50, 43));
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.DY
    public final boolean AGf(Format format) {
        String str = format.A0O;
        return A00(50, 15, 80).equals(str) || A00(65, 18, 33).equals(str) || A00(83, 20, 0).equals(str);
    }
}
