package com.facebook.ads.redexgen.uinode;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1759Xd extends C6 {
    public static byte[] A01;
    public static String[] A02 = {"lkUmj0P9ANZweJy", "AYR", "2bCiSP20yUx8Jjv69HyX94pfkMFX1Tn5", "GuptQSCxLEDTiFK9bPX0ljmbSmBcx9xx", "QILfBos", "yeLNYaj", "n8HrTtIUehfoTgx", "xV0sp6lxPyztL8QZzt7llBh4QSI4V12v"};
    public long A00;

    static {
        A0A();
    }

    public C1759Xd() {
        super(null);
        this.A00 = C.TIME_UNSET;
    }

    public static int A00(C1376Hz c1376Hz) {
        return c1376Hz.A0E();
    }

    public static Boolean A01(C1376Hz c1376Hz) {
        return Boolean.valueOf(c1376Hz.A0E() == 1);
    }

    public static Double A02(C1376Hz c1376Hz) {
        return Double.valueOf(Double.longBitsToDouble(c1376Hz.A0L()));
    }

    public static Object A03(C1376Hz c1376Hz, int i11) {
        switch (i11) {
            case 0:
                return A02(c1376Hz);
            case 1:
                return A01(c1376Hz);
            case 2:
                return A05(c1376Hz);
            case 3:
                return A09(c1376Hz);
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            default:
                String[] strArr = A02;
                if (strArr[3].charAt(7) == strArr[7].charAt(7)) {
                    A02[2] = "Zl5TZ6M60aHBYOe9FM2F5W6f579JKUNd";
                    return null;
                }
                break;
            case 8:
                HashMap<String, Object> mapA08 = A08(c1376Hz);
                String[] strArr2 = A02;
                if (strArr2[0].length() == strArr2[6].length()) {
                    String[] strArr3 = A02;
                    strArr3[0] = "AtnlLuJZPUjXwht";
                    strArr3[6] = "kJYayAh32s2xp3N";
                    return mapA08;
                }
                break;
            case 10:
                return A06(c1376Hz);
            case 11:
                return A07(c1376Hz);
        }
        throw new RuntimeException();
    }

    public static String A04(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            byte b11 = (byte) ((bArrCopyOfRange[i14] - i13) - 31);
            String[] strArr = A02;
            if (strArr[3].charAt(7) != strArr[7].charAt(7)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[3] = "WF1W4nbxyUcfRBlDsHDD1CgmrC98ElX3";
            strArr2[7] = "aIs3tFZxis4srcfFD6vTbXobqrKXyR4d";
            bArrCopyOfRange[i14] = b11;
        }
        return new String(bArrCopyOfRange);
    }

    public static String A05(C1376Hz c1376Hz) {
        int iA0I = c1376Hz.A0I();
        int iA06 = c1376Hz.A06();
        c1376Hz.A0Z(iA0I);
        return new String(c1376Hz.A00, iA06, iA0I);
    }

    public static ArrayList<Object> A06(C1376Hz c1376Hz) {
        int iA0H = c1376Hz.A0H();
        ArrayList<Object> arrayList = new ArrayList<>(iA0H);
        for (int i11 = 0; i11 < iA0H; i11++) {
            arrayList.add(A03(c1376Hz, A00(c1376Hz)));
        }
        return arrayList;
    }

    public static Date A07(C1376Hz c1376Hz) {
        Date date = new Date((long) A02(c1376Hz).doubleValue());
        c1376Hz.A0Z(2);
        return date;
    }

    public static HashMap<String, Object> A08(C1376Hz c1376Hz) {
        int iA0H = c1376Hz.A0H();
        HashMap<String, Object> map = new HashMap<>(iA0H);
        for (int i11 = 0; i11 < iA0H; i11++) {
            map.put(A05(c1376Hz), A03(c1376Hz, A00(c1376Hz)));
        }
        return map;
    }

    public static HashMap<String, Object> A09(C1376Hz c1376Hz) {
        HashMap<String, Object> map = new HashMap<>();
        while (true) {
            String strA05 = A05(c1376Hz);
            int iA00 = A00(c1376Hz);
            if (iA00 == 9) {
                return map;
            }
            map.put(strA05, A03(c1376Hz, iA00));
        }
    }

    public static void A0A() {
        A01 = new byte[]{-40, -23, -26, -43, -24, -35, -29, -30, 5, 4, -29, -5, 10, -9, -38, -9, 10, -9};
    }

    @Override // com.facebook.ads.redexgen.uinode.C6
    public final void A0B(C1376Hz c1376Hz, long j11) throws C11849v {
        if (A00(c1376Hz) != 2) {
            throw new C11849v();
        }
        if (A04(8, 10, 119).equals(A05(c1376Hz)) && A00(c1376Hz) == 8) {
            HashMap<String, Object> mapA08 = A08(c1376Hz);
            String strA04 = A04(0, 8, 85);
            if (mapA08.containsKey(strA04)) {
                double dDoubleValue = ((Double) mapA08.get(strA04)).doubleValue();
                if (dDoubleValue > 0.0d) {
                    this.A00 = (long) (1000000.0d * dDoubleValue);
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.C6
    public final boolean A0C(C1376Hz c1376Hz) {
        return true;
    }

    public final long A0D() {
        return this.A00;
    }
}
