package com.facebook.ads.redexgen.uinode;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class NG implements View.OnClickListener {
    public final /* synthetic */ NJ A00;

    public NG(NJ nj2) {
        this.A00 = nj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            if (this.A00.A0A.canGoForward()) {
                this.A00.A0A.goForward();
            }
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}
