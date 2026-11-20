package com.facebook.ads.redexgen.uinode;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ny, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1524Ny implements View.OnClickListener {
    public final /* synthetic */ O1 A00;

    public ViewOnClickListenerC1524Ny(O1 o11) {
        this.A00 = o11;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A04.ACB();
            if (this.A00.A00 != null) {
                AbstractC1462Lo.A0L(this.A00.A00);
            }
            for (View view2 : this.A00.A06) {
                AbstractC1462Lo.A0N(view2, 0);
            }
            AbstractC1462Lo.A0J(this.A00);
            if (this.A00.A05 != null) {
                AbstractC1462Lo.A0N(this.A00.A05, 0);
                this.A00.A05.A0b(QM.A02, 14);
            }
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}
