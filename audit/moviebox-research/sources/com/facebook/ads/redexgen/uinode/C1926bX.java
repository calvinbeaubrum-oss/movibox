package com.facebook.ads.redexgen.uinode;

import android.net.Uri;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bX, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1926bX extends AbstractC09520h {
    public static byte[] A01;
    public static final String A02;
    public final Uri A00;

    static {
        A01();
        A02 = C1926bX.class.getSimpleName();
    }

    public C1926bX(C1795Yn c1795Yn, J2 j11, String str, Uri uri) {
        super(c1795Yn, j11, str);
        this.A00 = uri;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 1);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{88, 115, 123, 126, 119, 118, 50, -122, -127, 50, -127, -126, 119, -128, 50, 126, 123, -128, 125, 50, -121, -124, 126, 76, 50};
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09520h
    public final EnumC09510g A0C() {
        try {
            C1443Kv.A0D(new C1443Kv(), super.A00, this.A00, this.A02);
        } catch (Exception unused) {
            String str = A00(0, 25, 17) + this.A00.toString();
        }
        return EnumC09510g.A08;
    }
}
