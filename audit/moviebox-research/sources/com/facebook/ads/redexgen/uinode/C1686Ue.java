package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ue, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1686Ue implements LU {
    public final LT A00;
    public final LU A01;

    public C1686Ue(LU lu2, int i11, int i12) {
        this.A01 = lu2;
        this.A00 = new LT(i11, i12);
    }

    @Override // com.facebook.ads.redexgen.uinode.LU
    public final void AE8(String str) {
        this.A00.A04(str);
        if (this.A00.A02() == null || !LW.A08(this.A00)) {
            return;
        }
        this.A01.AE8(this.A00.A02());
    }

    @Override // com.facebook.ads.redexgen.uinode.LU
    public final void flush() {
        this.A00.A03();
        while (this.A00.A02() != null) {
            if (LW.A08(this.A00)) {
                this.A01.AE8(this.A00.A02());
            }
            this.A00.A03();
        }
    }
}
