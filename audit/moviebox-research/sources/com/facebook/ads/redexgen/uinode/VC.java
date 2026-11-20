package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class VC extends AbstractC09600q {
    public static byte[] A01;
    public final /* synthetic */ V2 A00;

    static {
        A01();
    }

    public VC(V2 v11) {
        this.A00 = v11;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 109);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{Ascii.ETB, 42, 61, 50, Utf8.REPLACEMENT_BYTE, 46, -23, 42, 45, 60, -23, 54, 42, 55, 42, 48, 46, 59, -23, 61, 49, 46, 50, 59, -23, 56, 64, 55, -23, 50, 54, 57, 59, 46, 60, 60, 50, 56, 55, 60, -9};
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A0B(C1913bK c1913bK) {
        this.A00.A1T(c1913bK);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A0C() {
        if (this.A00.A0G != null) {
            this.A00.A0G.AAc();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A0D() {
        throw new IllegalStateException(A00(0, 41, 92));
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A0F(InterfaceC09590p interfaceC09590p) {
        if (this.A00.A0A != null) {
            this.A00.A0A.A0J();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A0G(C1401Jb c1401Jb) {
        this.A00.A11().A0E().A2m(C1453Lf.A01(this.A00.A00), c1401Jb.A03().getErrorCode(), c1401Jb.A04());
        if (this.A00.A0G != null) {
            this.A00.A0G.ABR(c1401Jb);
        }
    }
}
