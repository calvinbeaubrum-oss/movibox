package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1767Xl implements C4 {
    @Override // com.facebook.ads.redexgen.uinode.C4
    public final void A5n(Format format) {
    }

    @Override // com.facebook.ads.redexgen.uinode.C4
    public final int AFQ(InterfaceC1234Bt interfaceC1234Bt, int i11, boolean z11) throws InterruptedException, IOException {
        int iAGM = interfaceC1234Bt.AGM(i11);
        if (iAGM != -1) {
            return iAGM;
        }
        if (z11) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.facebook.ads.redexgen.uinode.C4
    public final void AFR(C1376Hz c1376Hz, int i11) {
        c1376Hz.A0Z(i11);
    }

    @Override // com.facebook.ads.redexgen.uinode.C4
    public final void AFS(long j11, int i11, int i12, int i13, C3 c11) {
    }
}
