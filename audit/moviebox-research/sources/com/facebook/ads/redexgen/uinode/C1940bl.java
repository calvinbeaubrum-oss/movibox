package com.facebook.ads.redexgen.uinode;

import java.io.ByteArrayInputStream;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1940bl implements C0K {
    public ByteArrayInputStream A00;
    public final byte[] A01;

    public C1940bl(byte[] bArr) {
        this.A01 = bArr;
    }

    @Override // com.facebook.ads.redexgen.uinode.C0K
    public final void ADm(int i11) throws C1939bk {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.A01);
        this.A00 = byteArrayInputStream;
        byteArrayInputStream.skip(i11);
    }

    @Override // com.facebook.ads.redexgen.uinode.C0K
    public final void close() throws C1939bk {
    }

    @Override // com.facebook.ads.redexgen.uinode.C0K
    public final int length() throws C1939bk {
        return this.A01.length;
    }

    @Override // com.facebook.ads.redexgen.uinode.C0K
    public final int read(byte[] bArr) throws C1939bk {
        return this.A00.read(bArr, 0, bArr.length);
    }
}
