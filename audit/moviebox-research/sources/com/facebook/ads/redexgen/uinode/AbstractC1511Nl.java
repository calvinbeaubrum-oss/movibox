package com.facebook.ads.redexgen.uinode;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1511Nl {
    public static void A00(View view, boolean z11, View.OnClickListener onClickListener) {
        if (!z11) {
            view.setOnClickListener(onClickListener);
        } else if (z11) {
            ViewOnClickListenerC1510Nk viewOnClickListenerC1510Nk = new ViewOnClickListenerC1510Nk(onClickListener);
            view.setOnClickListener(viewOnClickListenerC1510Nk);
            view.setOnTouchListener(new ViewOnTouchListenerC1509Nj(viewOnClickListenerC1510Nk));
        }
    }
}
