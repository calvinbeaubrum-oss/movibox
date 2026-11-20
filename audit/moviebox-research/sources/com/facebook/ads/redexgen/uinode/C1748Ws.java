package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ws, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1748Ws implements D6 {
    public static byte[] A03;
    public C4 A00;
    public IB A01;
    public boolean A02;

    static {
        A01();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 88);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{90, 75, 75, 87, 82, 88, 90, 79, 82, 84, 85, Ascii.DC4, 67, Ascii.SYN, 72, 88, 79, 94, 8, Ascii.SO};
    }

    @Override // com.facebook.ads.redexgen.uinode.D6
    public final void A4R(C1376Hz c1376Hz) {
        if (!this.A02) {
            if (this.A01.A05() == C.TIME_UNSET) {
                return;
            }
            this.A00.A5n(Format.A02(null, A00(0, 20, 99), this.A01.A05()));
            this.A02 = true;
        }
        int iA04 = c1376Hz.A04();
        this.A00.AFR(c1376Hz, iA04);
        this.A00.AFS(this.A01.A04(), 1, iA04, 0, null);
    }

    @Override // com.facebook.ads.redexgen.uinode.D6
    public final void A8q(IB ib2, InterfaceC1235Bu interfaceC1235Bu, DC dc2) {
        this.A01 = ib2;
        dc2.A05();
        C4 c4AGi = interfaceC1235Bu.AGi(dc2.A03(), 4);
        this.A00 = c4AGi;
        c4AGi.A5n(Format.A0B(dc2.A04(), A00(0, 20, 99), null, -1, null));
    }
}
