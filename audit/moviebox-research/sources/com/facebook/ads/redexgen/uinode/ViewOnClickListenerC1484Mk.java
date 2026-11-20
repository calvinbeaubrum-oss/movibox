package com.facebook.ads.redexgen.uinode;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1484Mk implements View.OnClickListener {
    public final /* synthetic */ C1487Mn A00;

    public ViewOnClickListenerC1484Mk(C1487Mn c1487Mn) {
        this.A00 = c1487Mn;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            if (this.A00.A05) {
                this.A00.A04.A4L();
            } else {
                this.A00.A04.A4M();
            }
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}
