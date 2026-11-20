package com.facebook.ads.redexgen.uinode;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.My, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1498My implements View.OnClickListener {
    public final /* synthetic */ C1492Ms A00;
    public final /* synthetic */ U5 A01;

    public ViewOnClickListenerC1498My(U5 u11, C1492Ms c1492Ms) {
        this.A01 = u11;
        this.A00 = c1492Ms;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A01();
            this.A01.A0B.ACI(C2U.A03);
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}
