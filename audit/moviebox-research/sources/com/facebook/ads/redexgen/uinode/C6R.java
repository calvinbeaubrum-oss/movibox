package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6R, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C6R {
    public static boolean A04;
    public static byte[] A05;
    public static final String A06;
    public final C6S A00;
    public final C6T A01;
    public final C1794Ym A02;
    public final InterfaceC1613Rj A03;

    static {
        A01();
        A06 = C6R.class.getSimpleName();
    }

    public C6R(C1794Ym c1794Ym, InterfaceC1360Hj interfaceC1360Hj, C6S c6s, C6T c6t) {
        this.A02 = c1794Ym;
        InterfaceC1613Rj interfaceC1613RjA4i = interfaceC1360Hj.A4i(EnumC1614Rk.A06);
        this.A03 = interfaceC1613RjA4i;
        this.A00 = c6s;
        this.A01 = c6t;
        interfaceC1613RjA4i.A3R(new C1803Yv(this));
        A02();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 114);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{46, 56, 19, 41, 52, 56, 62, 45, Utf8.REPLACEMENT_BYTE};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void A02() {
        if (KL.A02(this)) {
            return;
        }
        try {
            if (!this.A03.A9C()) {
                this.A02.A04().A8z();
                return;
            }
            String strOptString = this.A03.A6h().optString(A00(0, 9, 62));
            if (!TextUtils.isEmpty(strOptString)) {
                this.A00.A04(this.A02, strOptString);
                if (!A04 || C1384Ih.A0f(this.A02)) {
                    A04 = true;
                    this.A01.A07();
                }
            }
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}
