package com.facebook.ads.redexgen.uinode;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class NE implements View.OnClickListener {
    public final /* synthetic */ NJ A00;

    public NE(NJ nj2) {
        this.A00 = nj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            if (this.A00.A05 != null) {
                this.A00.A05.AB6();
            }
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}
