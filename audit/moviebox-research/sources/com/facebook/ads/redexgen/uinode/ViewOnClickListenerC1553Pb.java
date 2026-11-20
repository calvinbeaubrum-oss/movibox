package com.facebook.ads.redexgen.uinode;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1553Pb implements View.OnClickListener {
    public final /* synthetic */ C1653Sx A00;

    public ViewOnClickListenerC1553Pb(C1653Sx c1653Sx) {
        this.A00 = c1653Sx;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            if (!this.A00.A0K) {
                this.A00.A0L = true;
                C1653Sx c1653Sx = this.A00;
                c1653Sx.A0h(((C1308Ff) c1653Sx.A0T).A0G().toString());
                if (((PQ) this.A00).A05.A0H() >= 0) {
                    this.A00.A08.postDelayed(this.A00.A0j, ((PQ) this.A00).A05.A0H());
                }
            }
            C1653Sx c1653Sx2 = this.A00;
            c1653Sx2.A0k(c1653Sx2.A0K ? false : true);
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}
