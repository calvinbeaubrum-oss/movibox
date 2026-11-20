package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Uf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1687Uf implements LU {
    public int A00;
    public final LU A01;

    public C1687Uf(LU lu2, int i11) {
        this.A01 = lu2;
        this.A00 = i11;
    }

    @Override // com.facebook.ads.redexgen.uinode.LU
    public final void AE8(String str) {
        if (this.A00 > 0) {
            this.A01.AE8(str);
            this.A00--;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.LU
    public final void flush() {
        this.A01.flush();
    }
}
