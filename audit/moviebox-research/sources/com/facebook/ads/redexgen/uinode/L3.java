package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.AdSize;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class L3 {
    public static byte[] A00;
    public static String[] A01 = {"gFe3mTVqEc", "o3XICwck3thy8t5khkuFfgIyTYcE10rb", "CXZamXhEArpjjLRWzP01hTJHhdHKIPhL", "oFEH5ENhqq8Jzm18l75xaKQx7AXJNwzV", "R1QKRY6v8stJjzPTGoE1sFm3d511QSKK", "fRlItu1oZcW1vgjv2TfsauDW1x1gg146", "rMZj8KW6uJSswCV0wJ61u4oJuHgPLcpr", "VRcOG4k1oxgWu574CIBxVkEWQ"};
    public static final Map<EnumC1403Je, EnumC1405Jg> A02;

    static {
        A07();
        HashMap map = new HashMap();
        A02 = map;
        map.put(EnumC1403Je.A08, EnumC1405Jg.A0C);
        map.put(EnumC1403Je.A06, EnumC1405Jg.A0E);
        map.put(EnumC1403Je.A05, EnumC1405Jg.A0D);
    }

    public static AdSize A00(EnumC1403Je enumC1403Je) {
        return AdSize.fromWidthAndHeight(enumC1403Je.A03(), enumC1403Je.A02());
    }

    public static AdSize A01(EnumC1405Jg enumC1405Jg) {
        for (Map.Entry<EnumC1403Je, EnumC1405Jg> entry : A02.entrySet()) {
            if (entry.getValue() == enumC1405Jg) {
                return A00(entry.getKey());
            }
        }
        AdSize adSize = AdSize.BANNER_320_50;
        if (A01[2].charAt(13) != 'L') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[3] = "8yxIcOBY3dyXYw8tx9RnPYEelWv3PiEU";
        strArr[5] = "RuT7gwLbx9UlwnZGushHq4GsGVsr9kdh";
        return adSize;
    }

    public static EnumC1403Je A02(int i11) {
        switch (i11) {
            case 4:
                return EnumC1403Je.A04;
            case 5:
                return EnumC1403Je.A05;
            case 6:
                return EnumC1403Je.A06;
            case 7:
                return EnumC1403Je.A08;
            case 100:
                return EnumC1403Je.A07;
            default:
                throw new IllegalArgumentException(A06(48, 20, 63));
        }
    }

    public static EnumC1403Je A03(int i11, int i12) {
        if (EnumC1403Je.A07.A02() == i12 && EnumC1403Je.A07.A03() == i11) {
            EnumC1403Je enumC1403Je = EnumC1403Je.A07;
            if (A01[2].charAt(13) != 'L') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[4] = "oPyqycdUDaMLkpnFUSD1lOVVut5Ak4ux";
            strArr[6] = "t44MnsVi8idfM7jbHI01veBsrnLqKP4H";
            return enumC1403Je;
        }
        if (EnumC1403Je.A04.A02() == i12 && EnumC1403Je.A04.A03() == i11) {
            return EnumC1403Je.A04;
        }
        if (EnumC1403Je.A05.A02() == i12 && EnumC1403Je.A05.A03() == i11) {
            EnumC1403Je enumC1403Je2 = EnumC1403Je.A05;
            if (A01[1].charAt(1) == 'd') {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[4] = "zTuOoFSTcjvo6siKnZ91TQqR6FN8Kxgy";
            strArr2[6] = "bIxUq8CGRMwo1zGvdui1T5X5wsDAfXTH";
            return enumC1403Je2;
        }
        if (EnumC1403Je.A06.A02() == i12 && EnumC1403Je.A06.A03() == i11) {
            return EnumC1403Je.A06;
        }
        if (EnumC1403Je.A08.A02() == i12 && EnumC1403Je.A08.A03() == i11) {
            return EnumC1403Je.A08;
        }
        throw new IllegalArgumentException(A06(0, 48, 39));
    }

    public static EnumC1403Je A04(AdSize adSize) {
        return A03(adSize.getWidth(), adSize.getHeight());
    }

    public static EnumC1405Jg A05(EnumC1403Je enumC1403Je) {
        EnumC1405Jg enumC1405Jg = A02.get(enumC1403Je);
        if (enumC1405Jg != null) {
            return enumC1405Jg;
        }
        EnumC1405Jg enumC1405Jg2 = EnumC1405Jg.A0F;
        if (A01[1].charAt(1) == 'd') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[3] = "UG6JCyDXDBzWMb76AfK0hQ3l3bgkgswO";
        strArr[5] = "9YhmwLNWXnVy8pTRO5fFllqJZ4ALiPvn";
        return enumC1405Jg2;
    }

    public static String A06(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 25);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A00 = new byte[]{125, 95, 80, Ascii.EM, 74, Ascii.RS, 93, 76, 91, 95, 74, 91, Ascii.RS, Ascii.DEL, 90, 109, 87, 68, 91, Ascii.RS, 75, 77, 87, 80, 89, Ascii.RS, 74, 86, 87, 77, Ascii.RS, 73, 87, 90, 74, 86, Ascii.RS, 95, 80, 90, Ascii.RS, 86, 91, 87, 89, 86, 74, Ascii.DLE, 115, 72, 77, 72, 73, 81, 72, 6, 103, 66, 117, 79, 92, 67, 6, 82, 95, 86, 67, 8};
    }
}
