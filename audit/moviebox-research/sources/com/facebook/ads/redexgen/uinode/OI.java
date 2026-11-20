package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class OI {
    public static float A00(C1G c1g) {
        int iA01 = c1g.A0D().A01();
        int iA00 = c1g.A0D().A00();
        if (iA00 > 0) {
            return iA01 / iA00;
        }
        return -1.0f;
    }

    public static int A01(double d11) {
        return (int) (((double) (LC.A00().widthPixels - (OL.A07 * 2))) / d11);
    }

    public static int A02(int i11) {
        return (LC.A00().heightPixels - i11) - ((AbstractC1462Lo.A01(16) + (AbstractC1521Nv.A0A * 2)) + (OL.A07 * 2));
    }

    public static OH A03(ViewOnClickListenerC1667Tl viewOnClickListenerC1667Tl, String str) {
        return new OH(viewOnClickListenerC1667Tl, str);
    }

    public static boolean A04(double d11) {
        return d11 < 0.9d;
    }

    public static boolean A05(double d11, int i11) {
        return A02(i11) < A01(d11);
    }

    public static boolean A06(int i11, int i12, double d11) {
        return i11 == 2 || A05(d11, i12);
    }
}
