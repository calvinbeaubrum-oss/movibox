package com.facebook.ads.redexgen.uinode;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1568Pq implements View.OnClickListener {
    public final /* synthetic */ C1569Pr A00;

    public ViewOnClickListenerC1568Pq(C1569Pr c1569Pr) {
        this.A00 = c1569Pr;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A05.performClick();
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}
