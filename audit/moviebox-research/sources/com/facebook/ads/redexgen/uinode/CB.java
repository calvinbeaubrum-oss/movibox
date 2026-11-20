package com.facebook.ads.redexgen.uinode;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class CB extends WW implements InterfaceC1288El {
    public long A00;
    public boolean A01;
    public final int A02;
    public final int A03;
    public final Uri A04;
    public final InterfaceC1236Bv A05;
    public final InterfaceC1345Gt A06;
    public final Object A07;
    public final String A08;

    public CB(Uri uri, InterfaceC1345Gt interfaceC1345Gt, InterfaceC1236Bv interfaceC1236Bv, int i11, String str, int i12, Object obj) {
        this.A04 = uri;
        this.A06 = interfaceC1345Gt;
        this.A05 = interfaceC1236Bv;
        this.A03 = i11;
        this.A08 = str;
        this.A02 = i12;
        this.A00 = C.TIME_UNSET;
        this.A07 = obj;
    }

    private void A00(long j11, boolean z11) {
        this.A00 = j11;
        this.A01 = z11;
        A01(new WN(this.A00, this.A01, false, this.A07), null);
    }

    @Override // com.facebook.ads.redexgen.uinode.WW
    public final void A02() {
    }

    @Override // com.facebook.ads.redexgen.uinode.WW
    public final void A03(Y6 y11, boolean z11) {
        A00(this.A00, false);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1293Eq
    public final WP A4k(C1291Eo c1291Eo, InterfaceC1338Gm interfaceC1338Gm) {
        AbstractC1351Ha.A03(c1291Eo.A02 == 0);
        return new CD(this.A04, this.A06.A4X(), this.A05.A4b(), this.A03, A00(c1291Eo), this, interfaceC1338Gm, this.A08, this.A02);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1293Eq
    public final void AAO() throws IOException {
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1288El
    public final void AD9(long j11, boolean z11) {
        if (j11 == C.TIME_UNSET) {
            j11 = this.A00;
        }
        if (this.A00 == j11 && this.A01 == z11) {
            return;
        }
        A00(j11, z11);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1293Eq
    public final void AEa(WP wp2) {
        ((CD) wp2).A0R();
    }
}
