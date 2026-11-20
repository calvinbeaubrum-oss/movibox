package com.facebook.ads.redexgen.uinode;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ml, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1485Ml implements View.OnClickListener {
    public final /* synthetic */ C1487Mn A00;

    public ViewOnClickListenerC1485Ml(C1487Mn c1487Mn) {
        this.A00 = c1487Mn;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A04.A9N();
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}
