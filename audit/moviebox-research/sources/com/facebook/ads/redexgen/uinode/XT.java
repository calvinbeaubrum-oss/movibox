package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XT extends CJ {
    public static byte[] A03;
    public final long A00;
    public final List<XT> A01;
    public final List<XS> A02;

    static {
        A05();
    }

    public XT(int i11, long j11) {
        super(i11);
        this.A00 = j11;
        this.A02 = new ArrayList();
        this.A01 = new ArrayList();
    }

    public static String A04(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 42);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A03 = new byte[]{Ascii.FF, 79, 67, 66, 88, 77, 69, 66, 73, 94, 95, Ascii.SYN, Ascii.FF, 79, 3, 10, Ascii.SO, Ascii.EM, 10, Ascii.FS, 85, 79};
    }

    public final XT A06(int i11) {
        int size = this.A01.size();
        for (int i12 = 0; i12 < size; i12++) {
            XT xt2 = this.A01.get(i12);
            if (((CJ) xt2).A00 == i11) {
                return xt2;
            }
        }
        return null;
    }

    public final XS A07(int i11) {
        int size = this.A02.size();
        for (int i12 = 0; i12 < size; i12++) {
            XS xs2 = this.A02.get(i12);
            if (((CJ) xs2).A00 == i11) {
                return xs2;
            }
        }
        return null;
    }

    public final void A08(XT xt2) {
        this.A01.add(xt2);
    }

    public final void A09(XS xs2) {
        this.A02.add(xs2);
    }

    @Override // com.facebook.ads.redexgen.uinode.CJ
    public final String toString() {
        return CJ.A02(super.A00) + A04(13, 9, 69) + Arrays.toString(this.A02.toArray()) + A04(0, 13, 6) + Arrays.toString(this.A01.toArray());
    }
}
