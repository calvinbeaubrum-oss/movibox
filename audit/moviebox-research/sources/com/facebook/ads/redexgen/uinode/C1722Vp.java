package com.facebook.ads.redexgen.uinode;

import android.net.Uri;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1722Vp implements InterfaceC1346Gu {
    public final int A00;
    public final InterfaceC1346Gu A01;
    public final I3 A02;

    public C1722Vp(InterfaceC1346Gu interfaceC1346Gu, I3 i11, int i12) {
        this.A01 = (InterfaceC1346Gu) AbstractC1351Ha.A01(interfaceC1346Gu);
        this.A02 = (I3) AbstractC1351Ha.A01(i11);
        this.A00 = i12;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1346Gu
    public final Uri A8E() {
        return this.A01.A8E();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1346Gu
    public final long ADl(C1350Gy c1350Gy) throws IOException {
        this.A02.A02(this.A00);
        return this.A01.ADl(c1350Gy);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1346Gu
    public final void close() throws IOException {
        this.A01.close();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1346Gu
    public final int read(byte[] bArr, int i11, int i12) throws IOException {
        this.A02.A02(this.A00);
        return this.A01.read(bArr, i11, i12);
    }
}
