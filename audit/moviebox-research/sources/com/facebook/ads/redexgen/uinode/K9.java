package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class K9 {
    public static byte[] A00;
    public static String[] A01 = {"DRlsPwjpEwtNoZv5ySnxf", "lqEqsXUgP0JMZJfgrKxewN2wIWHzYKcc", "dBjDOWAGvP7mSKAaP52zl", "ype", "mP5mKraLiX8XnVkHST8LkS5AYOMnukgh", "WxiRHArz5NNbCsZRJT7jzOWIY3Iz", "jBZrwNF22PwjCa8Ii6ulb8rFZ5hC5AS6", "qRbUwr6kgq5VO8gbp3xyKAMHfEJZ"};
    public static final AtomicReference<String> A02;
    public static final AtomicReference<String> A03;

    static {
        A09();
        A02 = new AtomicReference<>();
        A03 = new AtomicReference<>();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 88);
        }
        return new String(bArrCopyOfRange);
    }

    public static String A01(C11237f c11237f) {
        return A05(c11237f) + A00(47, 19, 24);
    }

    public static String A02(C11237f c11237f) {
        return A07(c11237f, C1384Ih.A0T(c11237f)) + A00(22, 14, 63);
    }

    public static String A03(C11237f c11237f) {
        return A05(c11237f) + A00(1, 21, 21);
    }

    public static String A04(C11237f c11237f) {
        return A07(c11237f, C1384Ih.A0U(c11237f)) + A00(36, 11, 123);
    }

    public static String A05(C11237f c11237f) {
        String str = A02.get();
        return !TextUtils.isEmpty(str) ? str : A06(c11237f, A00(66, 28, 104));
    }

    public static String A06(C11237f c11237f, String str) {
        String strA8F = c11237f.A04().A8F();
        Locale locale = Locale.US;
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(strA8F) ? A00(0, 0, 29) : A00(0, 1, 0) + strA8F;
        if (A01[4].charAt(27) == 'a') {
            throw new RuntimeException();
        }
        A01[1] = "Rtsd39h1DjNUt9rd7OM3RjcgvmtBKqBR";
        return String.format(locale, str, objArr);
    }

    public static String A07(C11237f c11237f, String str) {
        String str2 = A03.get();
        return !TextUtils.isEmpty(str2) ? str2 : A08(A06(c11237f, A00(94, 26, 52)), str);
    }

    public static String A08(String str, String str2) {
        return TextUtils.isEmpty(str2) ? str : str.replace(A00(120, 3, 124), str2);
    }

    public static void A09() {
        A00 = new byte[]{118, 98, 123, 116, 126, 116, 120, 126, 116, 121, 125, 116, 116, 122, 116, 125, 124, 98, 47, 56, 42, 62, 72, 6, 3, 9, Ascii.DLE, 56, Ascii.VT, 8, 0, 0, Ascii.SO, 9, 0, 72, Ascii.FF, 66, 71, 77, 84, 124, 80, 90, 77, 64, 17, 111, 46, 37, 52, 55, 47, 50, 43, Ascii.US, 33, 36, 51, Ascii.US, 35, 47, 45, 45, 47, 46, 88, 68, 68, 64, 67, 10, Ascii.US, Ascii.US, 87, 66, 81, 64, 88, Ascii.NAK, 67, Ascii.RS, 86, 81, 83, 85, 82, 95, 95, 91, Ascii.RS, 83, 95, 93, 4, Ascii.CAN, Ascii.CAN, Ascii.FS, Ascii.US, 86, 67, 67, Ascii.ESC, Ascii.ESC, Ascii.ESC, 73, Ascii.US, 66, 10, Ascii.CR, Ascii.SI, 9, Ascii.SO, 3, 3, 7, 66, Ascii.SI, 3, 1, 83, 83, 83};
    }
}
