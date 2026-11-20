package com.facebook.ads.redexgen.uinode;

import com.google.logging.type.LogSeverity;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public enum JS {
    A06(-1, 100, 1, 0),
    A07(-1, 120, 2, 1),
    A08(-1, LogSeverity.NOTICE_VALUE, 3, 2),
    A09(-1, LogSeverity.WARNING_VALUE, 4, 3),
    A0A(-1, 50, 5, 4),
    A0B(-1, -1, 6, 5);

    public static byte[] A04;
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;

    static {
        A02();
    }

    JS(int i11, int i12, int i13, int i14) {
        this.A03 = i11;
        this.A01 = i12;
        this.A02 = i13;
        this.A00 = i14;
    }

    public static JS A00(int i11) {
        for (JS js2 : values()) {
            if (js2.A00 == i11) {
                return js2;
            }
        }
        return null;
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 57);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{-110, -113, -109, -111, -110, -98, -87, 123, 122, 122, -63, -66, -62, -64, -63, -51, -40, -86, -85, -87, -65, -68, -64, -66, -65, -53, -42, -86, -89, -89, -47, -50, -46, -48, -47, -35, -24, -67, -71, -71, -121, -124, -120, -122, -121, -109, -98, 116, 111, -72, -85, -87, -70, -59, -86, -65, -76, -89, -77, -81, -87};
    }

    public final int A03() {
        return this.A01;
    }

    public final int A04() {
        return this.A02;
    }

    public final int A05() {
        return this.A03;
    }
}
