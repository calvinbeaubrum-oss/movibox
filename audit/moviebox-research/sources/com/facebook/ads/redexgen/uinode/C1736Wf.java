package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.Metadata;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.emsg.EventMessage;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1736Wf implements DW {
    @Override // com.facebook.ads.redexgen.uinode.DW
    public final Metadata A51(E3 e11) {
        ByteBuffer byteBuffer = e11.A01;
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        C1376Hz c1376Hz = new C1376Hz(bArrArray, iLimit);
        String strA0Q = c1376Hz.A0Q();
        String strA0Q2 = c1376Hz.A0Q();
        long jA0M = c1376Hz.A0M();
        return new Metadata(new EventMessage(strA0Q, strA0Q2, IF.A0F(c1376Hz.A0M(), 1000L, jA0M), c1376Hz.A0M(), Arrays.copyOfRange(bArrArray, c1376Hz.A06(), iLimit), IF.A0F(c1376Hz.A0M(), 1000000L, jA0M)));
    }
}
