package com.facebook.ads.redexgen.uinode;

import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class H4 extends IOException {
    public final int A00;
    public final C1350Gy A01;

    public H4(IOException iOException, C1350Gy c1350Gy, int i11) {
        super(iOException);
        this.A01 = c1350Gy;
        this.A00 = i11;
    }

    public H4(String str, C1350Gy c1350Gy, int i11) {
        super(str);
        this.A01 = c1350Gy;
        this.A00 = i11;
    }

    public H4(String str, IOException iOException, C1350Gy c1350Gy, int i11) {
        super(str, iOException);
        this.A01 = c1350Gy;
        this.A00 = i11;
    }
}
