package com.facebook.ads.redexgen.uinode;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class QR implements QK {
    public final View A00;
    public final C1795Yn A01;

    public QR(C1795Yn c1795Yn, View view) {
        this.A01 = c1795Yn;
        this.A00 = view;
    }

    @Override // com.facebook.ads.redexgen.uinode.QK
    public final double A8K() {
        return RE.A0E(this.A00, 0, this.A01).A00();
    }
}
