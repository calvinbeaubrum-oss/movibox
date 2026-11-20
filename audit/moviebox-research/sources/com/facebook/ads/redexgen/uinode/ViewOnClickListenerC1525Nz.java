package com.facebook.ads.redexgen.uinode;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1525Nz implements View.OnClickListener {
    public final /* synthetic */ O1 A00;

    public ViewOnClickListenerC1525Nz(O1 o11) {
        this.A00 = o11;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A04();
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}
