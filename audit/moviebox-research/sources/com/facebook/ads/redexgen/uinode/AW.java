package com.facebook.ads.redexgen.uinode;

import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class AW extends AbstractC1570Ps {
    public static byte[] A01;
    public final /* synthetic */ P3 A00;

    static {
        A01();
    }

    public AW(P3 p11) {
        this.A00 = p11;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 17);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-78, -65, -65, -68, -65};
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC11578s
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final void A03(C1571Pt c1571Pt) {
        new Handler(Looper.getMainLooper()).post(new P1(this));
        this.A00.A0B.ADY(A00(0, 5, 60), this.A00.A03());
    }
}
