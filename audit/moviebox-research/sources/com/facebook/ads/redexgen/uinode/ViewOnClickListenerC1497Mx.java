package com.facebook.ads.redexgen.uinode;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1497Mx implements View.OnClickListener {
    public final /* synthetic */ U5 A00;

    public ViewOnClickListenerC1497Mx(U5 u11) {
        this.A00 = u11;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A0B.A8P();
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}
