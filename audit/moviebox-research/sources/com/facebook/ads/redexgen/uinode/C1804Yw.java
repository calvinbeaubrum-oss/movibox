package com.facebook.ads.redexgen.uinode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1804Yw implements C6O {
    public static byte[] A01;
    public final Map<String, C6M> A00 = new HashMap();

    static {
        A01();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 8);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-53, -58, -86, -53, -55, -64, -59, -66};
    }

    @Override // com.facebook.ads.redexgen.uinode.C6O
    public final synchronized String AFE() {
        StringBuilder sb2;
        sb2 = new StringBuilder();
        Iterator<C6M> it = this.A00.values().iterator();
        if (it.hasNext()) {
            it.next();
            throw new NullPointerException(A00(0, 8, 79));
        }
        return sb2.toString();
    }

    @Override // com.facebook.ads.redexgen.uinode.C6O
    public final synchronized void reset() {
        this.A00.clear();
    }
}
