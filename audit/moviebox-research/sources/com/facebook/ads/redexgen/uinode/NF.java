package com.facebook.ads.redexgen.uinode;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class NF implements View.OnClickListener {
    public final /* synthetic */ NJ A00;

    public NF(NJ nj2) {
        this.A00 = nj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            if (this.A00.A0A.canGoBack()) {
                this.A00.A0A.goBack();
            }
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}
