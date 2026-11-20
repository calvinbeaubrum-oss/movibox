package com.facebook.ads.redexgen.uinode;

import android.util.Log;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Cf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1243Cf {
    public static byte[] A05;
    public static String[] A06 = {"ACQ", "Z1SKPMzbMAJhhabQH0qvIzzSk7pS7MzN", "6aLpRH6Tia4Sh8DeOCrm6uJB9pdHn", "T4Je7I0RF5bnUk10PIFXPnn9hg731vE9", "YJYhptho8kfm6vGcPcLLXGA80bzp3", "trfcxoKHMENKiNLiuCQzDNtcz23hOMTL", "PokKsHpwVBHIedcIPmeYCrQhpW", "5FKTxH2gEdxAxWs98iwby2xSeh4hilLh"};
    public final int A00;
    public final C3 A01;
    public final String A02;
    public final boolean A03;
    public final byte[] A04;

    static {
        A02();
    }

    public C1243Cf(boolean z11, String str, int i11, byte[] bArr, int i12, int i13, byte[] bArr2) {
        AbstractC1351Ha.A03((bArr2 == null) ^ (i11 == 0));
        this.A03 = z11;
        this.A02 = str;
        this.A00 = i11;
        this.A04 = bArr2;
        this.A01 = new C3(A00(str), bArr, i12, i13);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:25:0x00aa A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x00ab A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x000c  */
    /* JADX WARN: Code duplicated, block: B:9:0x0010  */
    public static int A00(String str) {
        byte b11;
        if (str == null) {
            return 1;
        }
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals(A01(86, 4, 37))) {
                    b11 = 2;
                } else {
                    b11 = -1;
                }
                switch (b11) {
                    case 0:
                    case 1:
                        return 1;
                    case 2:
                    case 3:
                        return 2;
                    default:
                        Log.w(A01(32, 18, 68), A01(50, 36, 66) + str + A01(0, 32, 69));
                        return 1;
                }
            case 3046671:
                if (str.equals(A01(90, 4, 79))) {
                    b11 = 3;
                } else {
                    b11 = -1;
                }
                switch (b11) {
                    case 0:
                    case 1:
                        return 1;
                    case 2:
                    case 3:
                        return 2;
                    default:
                        Log.w(A01(32, 18, 68), A01(50, 36, 66) + str + A01(0, 32, 69));
                        return 1;
                }
            case 3049879:
                if (str.equals(A01(94, 4, 91))) {
                    b11 = 0;
                } else {
                    b11 = -1;
                }
                switch (b11) {
                    case 0:
                    case 1:
                        return 1;
                    case 2:
                    case 3:
                        return 2;
                    default:
                        Log.w(A01(32, 18, 68), A01(50, 36, 66) + str + A01(0, 32, 69));
                        return 1;
                }
            case 3049895:
                String[] strArr = A06;
                if (strArr[6].length() == strArr[4].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A06;
                strArr2[6] = "rNJbBmSCz61bnA88RIw0tsQVuO";
                strArr2[4] = "wNvz1GaKF14i8ay7xmv7DcMchQNLl";
                if (str.equals(A01(98, 4, 101))) {
                    b11 = 1;
                } else {
                    b11 = -1;
                }
                switch (b11) {
                    case 0:
                    case 1:
                        return 1;
                    case 2:
                    case 3:
                        return 2;
                    default:
                        Log.w(A01(32, 18, 68), A01(50, 36, 66) + str + A01(0, 32, 69));
                        return 1;
                }
            default:
                b11 = -1;
                switch (b11) {
                    case 0:
                    case 1:
                        return 1;
                    case 2:
                    case 3:
                        return 2;
                    default:
                        Log.w(A01(32, 18, 68), A01(50, 36, 66) + str + A01(0, 32, 69));
                        return 1;
                }
        }
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 2);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A05 = new byte[]{110, 117, 103, -120, -70, -70, -68, -76, -80, -75, -82, 103, -120, -116, -102, 116, -118, -101, -103, 103, -86, -71, -64, -73, -69, -74, 103, -76, -74, -85, -84, 117, -102, -72, -89, -87, -79, -117, -76, -87, -72, -65, -74, -70, -81, -75, -76, -120, -75, -66, -103, -78, -73, -71, -76, -76, -77, -74, -72, -87, -88, 100, -76, -74, -77, -72, -87, -89, -72, -83, -77, -78, 100, -73, -89, -84, -87, -79, -87, 100, -72, -67, -76, -87, 100, 107, -118, -119, -118, 88, -76, -77, -76, -60, -64, -62, -53, -64, -54, -52, -43, -38};
    }
}
