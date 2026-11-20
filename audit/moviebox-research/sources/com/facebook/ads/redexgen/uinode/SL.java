package com.facebook.ads.redexgen.uinode;

import android.widget.ImageView;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class SL extends O4 {
    public final ImageView A00;
    public final C1795Yn A01;

    public SL(C1795Yn c1795Yn) {
        super(c1795Yn);
        this.A01 = c1795Yn;
        ImageView imageView = new ImageView(c1795Yn);
        this.A00 = imageView;
        imageView.setAdjustViewBounds(true);
        addView(imageView, new RelativeLayout.LayoutParams(-2, -1));
    }

    public final void A00(String str) {
        AsyncTaskC1672Tq asyncTaskC1672Tq = new AsyncTaskC1672Tq(this.A00, this.A01);
        asyncTaskC1672Tq.A04();
        asyncTaskC1672Tq.A07(str);
    }
}
