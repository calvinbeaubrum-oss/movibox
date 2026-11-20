package com.facebook.ads.redexgen.uinode;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Oj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1535Oj implements View.OnClickListener {
    public final /* synthetic */ TT A00;

    public ViewOnClickListenerC1535Oj(TT tt2) {
        this.A00 = tt2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            if (!this.A00.A0O) {
                this.A00.A0P = true;
                TT tt2 = this.A00;
                tt2.A0d(((C1308Ff) tt2.A0c).A0G().toString());
                if (this.A00.A0G.A0H() >= 0) {
                    this.A00.A09.postDelayed(this.A00.A0i, this.A00.A0G.A0H());
                }
            }
            TT tt3 = this.A00;
            tt3.A0g(tt3.A0O ? false : true);
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}
