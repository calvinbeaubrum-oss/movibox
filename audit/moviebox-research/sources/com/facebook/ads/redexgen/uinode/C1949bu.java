package com.facebook.ads.redexgen.uinode;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1949bu {
    public static byte[] A00;

    static {
        A04();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 4);
        }
        return new String(bArrCopyOfRange);
    }

    public static String A01(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = C1949bu.class.getName();
        int i11 = 0;
        while (!stackTrace[i11].getClassName().equals(name)) {
            i11++;
        }
        while (stackTrace[i11].getClassName().equals(name)) {
            i11++;
        }
        StackTraceElement stackTraceElement = stackTrace[i11];
        return A00(30, 48, 120) + stackTraceElement.getClassName() + A00(29, 1, 24) + stackTraceElement.getMethodName() + A00(17, 12, 121) + str;
    }

    public static <T extends Throwable> T A02(T t11) {
        return (T) A03(t11, C1949bu.class.getName());
    }

    public static <T extends Throwable> T A03(T t11, String str) {
        StackTraceElement[] stackTrace = t11.getStackTrace();
        int length = stackTrace.length;
        int i11 = -1;
        for (int i12 = 0; i12 < length; i12++) {
            if (str.equals(stackTrace[i12].getClassName())) {
                i11 = i12;
            }
        }
        t11.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i11 + 1, length));
        return t11;
    }

    public static void A04() {
        A00 = new byte[]{-119, -42, -34, -36, -35, -119, -41, -40, -35, -119, -53, -50, -119, -41, -34, -43, -43, -87, -99, -19, -34, -17, -34, -22, -30, -15, -30, -17, -99, 74, -52, -35, -18, -35, -23, -31, -16, -31, -18, -100, -17, -20, -31, -33, -27, -30, -27, -31, -32, -100, -35, -17, -100, -22, -21, -22, -87, -22, -15, -24, -24, -100, -27, -17, -100, -22, -15, -24, -24, -74, -100, -23, -31, -16, -28, -21, -32, -100};
    }

    public static void A05(Object obj, String str) {
        if (obj == null) {
            A08(str);
            throw null;
        }
    }

    public static void A06(Object obj, String str) {
        if (obj == null) {
            throw ((NullPointerException) A02(new NullPointerException(str + A00(0, 17, 101))));
        }
    }

    public static void A07(Object obj, String str) {
        if (obj == null) {
            A09(str);
            throw null;
        }
    }

    public static void A08(String str) {
        throw ((NullPointerException) A02(new NullPointerException(str)));
    }

    public static void A09(String str) {
        throw ((NullPointerException) A02(new NullPointerException(A01(str))));
    }

    public static boolean A0A(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }
}
