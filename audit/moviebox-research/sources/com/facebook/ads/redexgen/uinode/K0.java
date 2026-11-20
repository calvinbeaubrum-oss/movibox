package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class K0 {
    public static Map<String, Long> A00;
    public static Map<String, Long> A01;
    public static Map<String, String> A02;
    public static boolean A03;
    public static byte[] A04;
    public static String[] A05 = {"WcKxqk7L6BbuUQ1o7qmtmX6WSmYBceUW", "BgR1wHMut0LLHWxcn1vNnqjOmnDpA7yk", "nofrFHfyJT7pmG0QketyEOeNZ4PDBNqx", "tJ6rTzDc1vJYhzSuFM6hiX1fKi0tAXSV", "zeDIr51bIn8XcOdXOM6dVjfvh9EOKJZZ", "x4ZdmXYSSnH60B6WOaypztUTceO04NF4", "XXJyOaEVU", "eLFDRkAKNxNhqN4Dib4JBju5Hz9f2MYZ"};

    static {
        A04();
        A01 = new ConcurrentHashMap();
        A00 = new ConcurrentHashMap();
        A02 = new ConcurrentHashMap();
        A03 = false;
    }

    public static long A00(String str, EnumC1405Jg enumC1405Jg) {
        if (A01.containsKey(str)) {
            return A01.get(str).longValue();
        }
        switch (C1424Jz.A00[enumC1405Jg.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return 15000L;
            default:
                return -1000L;
        }
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 64);
        }
        return new String(bArrCopyOfRange);
    }

    public static String A02(K1 k11) {
        AbstractC1414Jp.A05(A01(44, 15, 94), A01(22, 22, 87), A01(14, 8, 116));
        return A02.get(A03(k11));
    }

    public static String A03(K1 k11) {
        Locale locale = Locale.US;
        Object[] objArr = new Object[5];
        objArr[0] = k11.A08();
        objArr[1] = k11.A06();
        objArr[2] = Integer.valueOf(k11.A07() == null ? 0 : k11.A07().A00());
        objArr[3] = Integer.valueOf(k11.A07() != null ? k11.A07().A01() : 0);
        objArr[4] = Integer.valueOf(k11.A04());
        return String.format(locale, A01(0, 14, 120), objArr);
    }

    public static void A04() {
        A04 = new byte[]{-35, 43, -14, -35, 43, -14, -35, Ascii.FS, -14, -35, Ascii.FS, -14, -35, Ascii.FS, -22, -24, -27, -19, -23, Ascii.SUB, -19, Ascii.ETB, -20, 10, 0, 5, -2, -73, 3, -8, 10, Ascii.VT, -73, -8, -5, -73, 9, -4, 10, 7, 6, 5, 10, -4, 5, 3, Ascii.DC2, -22, -1, 17, Ascii.DC2, -16, 3, 17, Ascii.SO, Ascii.CR, Ascii.FF, 17, 3};
    }

    public static void A05(long j11, K1 k11) {
        A01.put(A03(k11), Long.valueOf(j11));
    }

    public static void A06(K1 k11) {
        A00.put(A03(k11), Long.valueOf(System.currentTimeMillis()));
    }

    public static void A07(String str, K1 k11) {
        A02.put(A03(k11), str);
    }

    public static boolean A08(K1 k11) {
        if (A03) {
            return false;
        }
        String strA03 = A03(k11);
        if (!A00.containsKey(strA03)) {
            return false;
        }
        Long l11 = A00.get(strA03);
        if (A05[3].charAt(17) != 'M') {
            throw new RuntimeException();
        }
        A05[6] = "HNdF4hlEpt9Mz";
        return System.currentTimeMillis() - l11.longValue() < A00(strA03, k11.A06());
    }
}
