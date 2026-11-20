package com.facebook.ads.redexgen.uinode;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1579Qb implements View.OnClickListener {
    public final /* synthetic */ C1444Kw A00;

    public ViewOnClickListenerC1579Qb(C1444Kw c1444Kw) {
        this.A00 = c1444Kw;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A03.A04(J9.A0d, null);
            this.A00.A02.A0E().A3B();
            if (this.A00.A00 == null) {
                return;
            }
            if (this.A00.A07()) {
                this.A00.A00.setVolume(1.0f);
            } else {
                this.A00.A00.setVolume(0.0f);
            }
            this.A00.A09();
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}
