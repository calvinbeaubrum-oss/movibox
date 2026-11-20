package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ui, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1690Ui implements LU {
    public int A00;
    public final LU A01;
    public final LU A02;

    public C1690Ui(LU lu2, int i11, LU lu3) {
        this.A01 = lu2;
        this.A00 = i11;
        this.A02 = lu3;
    }

    @Override // com.facebook.ads.redexgen.uinode.LU
    public final void AE8(String str) {
        if (this.A00 <= 0) {
            this.A02.AE8(str);
            return;
        }
        this.A01.AE8(str);
        this.A01.flush();
        this.A00--;
    }

    @Override // com.facebook.ads.redexgen.uinode.LU
    public final void flush() {
        this.A02.flush();
    }
}
