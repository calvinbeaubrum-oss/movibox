package com.facebook.ads.redexgen.uinode;

import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class OG {
    public static byte[] A05;
    public boolean A00 = false;
    public final Handler A01 = new Handler(Looper.getMainLooper());
    public final AbstractC1898b5 A02;
    public final C1795Yn A03;
    public final OE A04;

    static {
        A03();
    }

    public OG(C1795Yn c1795Yn, AbstractC1898b5 abstractC1898b5, OE oe2) {
        this.A03 = c1795Yn;
        this.A04 = oe2;
        this.A02 = abstractC1898b5;
    }

    public static OG A01(C1795Yn c1795Yn, AbstractC1898b5 abstractC1898b5, OE oe2) {
        Object objA0H = c1795Yn.A0H();
        if (objA0H == null) {
            objA0H = new OG(c1795Yn, abstractC1898b5, oe2);
            c1795Yn.A0N(objA0H);
        }
        return (OG) objA0H;
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 56);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A05 = new byte[]{84, 91, 94, 84, 92, 104, 68, 88, 66, 69, 84, 82};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05(String str, C1U c1u, String str2) {
        Map<String, String> mapA05 = new C1508Ni().A03(null).A02(null).A05();
        mapA05.put(A02(0, 12, 15), str);
        this.A03.A09().A9j(str2, mapA05);
        if (c1u != null) {
            C1U.A06(c1u, this.A03);
        }
        if (C1384Ih.A20(this.A03)) {
            HashMap map = new HashMap();
            map.put(AbstractC1928bZ.A03, Boolean.TRUE.toString());
            map.put(AbstractC1928bZ.A04, Boolean.TRUE.toString());
            map.put(AbstractC1928bZ.A05, Boolean.TRUE.toString());
            this.A03.A09().A9s(str2, map);
        }
        this.A04.AC9();
    }

    public static boolean A06(C1795Yn c1795Yn) {
        return C1384Ih.A1F(c1795Yn) && C1443Kv.A0H(c1795Yn);
    }

    public final OF A09(AbstractC1898b5 abstractC1898b5) {
        if (C1384Ih.A1K(this.A03)) {
            boolean z11 = abstractC1898b5.A0l() && A06(this.A03);
            return new OF(z11, z11);
        }
        boolean zA0l = abstractC1898b5.A0l();
        return new OF(zA0l, zA0l && A06(this.A03));
    }

    public final void A0A() {
        this.A00 = false;
        this.A01.removeCallbacksAndMessages(null);
    }

    public final void A0B(String str, C1U c1u, String str2) {
        A0A();
        this.A00 = true;
        this.A01.postDelayed(new OD(this, str, c1u, str2), this.A02.A0H());
    }
}
