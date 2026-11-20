package com.facebook.ads.redexgen.uinode;

import android.graphics.Color;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2p, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC10112p {
    public static byte[] A00;
    public static String[] A01 = {"5xFyhJyAmXwpndJ9EoKqTFqqLI0O0t2g", "XKBE22ujheeLcTYagdBtfv4d5l35c1GL", "dLXeMiu6Rni", "1iBW7", "i8dAz", "3kaHypJVzQjnFbgNDhrnWnyYOdOCg92b", "E8vO87QQkuay4qK7aMyGFQLc0ZjeOzJS", "6MpCOYCclTS"};
    public static final ThreadLocal<double[]> A02;

    static {
        A04();
        A02 = new ThreadLocal<>();
    }

    public static double A00(int i11) {
        double[] dArrA07 = A07();
        A06(i11, dArrA07);
        return dArrA07[1] / 100.0d;
    }

    public static int A01(int i11, int i12) {
        if (i12 >= 0) {
            String[] strArr = A01;
            if (strArr[7].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[4] = "QbRpT";
            strArr2[3] = "VTwjf";
            if (i12 <= 255) {
                return (16777215 & i11) | (i12 << 24);
            }
        }
        throw new IllegalArgumentException(A03(0, 32, 3));
    }

    public static int A02(int i11, int i12, float f11) {
        float f12 = 1.0f - f11;
        return Color.argb((int) ((Color.alpha(i11) * f12) + (Color.alpha(i12) * f11)), (int) ((Color.red(i11) * f12) + (Color.red(i12) * f11)), (int) ((Color.green(i11) * f12) + (Color.green(i12) * f11)), (int) ((Color.blue(i11) * f12) + (Color.blue(i12) * f11)));
    }

    public static String A03(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 52);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{-104, -93, -89, -97, -104, 87, -92, -84, -86, -85, 87, -103, -100, 87, -103, -100, -85, -82, -100, -100, -91, 87, 103, 87, -104, -91, -101, 87, 105, 108, 108, 101, -59, -53, -54, -82, -49, -48, 118, -61, -53, -55, -54, 118, -66, -73, -52, -69, 118, -73, 118, -62, -69, -60, -67, -54, -66, 118, -59, -68, 118, -119, -124};
    }

    public static void A05(int i11, int i12, int i13, double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException(A03(32, 31, 34));
        }
        double d11 = ((double) i11) / 255.0d;
        double dPow = d11 < 0.04045d ? d11 / 12.92d : Math.pow((d11 + 0.055d) / 1.055d, 2.4d);
        double d12 = ((double) i12) / 255.0d;
        double dPow2 = d12 < 0.04045d ? d12 / 12.92d : Math.pow((d12 + 0.055d) / 1.055d, 2.4d);
        double d13 = ((double) i13) / 255.0d;
        double dPow3 = d13 < 0.04045d ? d13 / 12.92d : Math.pow((0.055d + d13) / 1.055d, 2.4d);
        dArr[0] = ((0.4124d * dPow) + (0.3576d * dPow2) + (0.1805d * dPow3)) * 100.0d;
        dArr[1] = ((0.2126d * dPow) + (0.7152d * dPow2) + (0.0722d * dPow3)) * 100.0d;
        dArr[2] = ((0.0193d * dPow) + (0.1192d * dPow2) + (0.9505d * dPow3)) * 100.0d;
    }

    public static void A06(int i11, double[] dArr) {
        A05(Color.red(i11), Color.green(i11), Color.blue(i11), dArr);
    }

    public static double[] A07() {
        ThreadLocal<double[]> threadLocal = A02;
        double[] dArr = threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }
}
