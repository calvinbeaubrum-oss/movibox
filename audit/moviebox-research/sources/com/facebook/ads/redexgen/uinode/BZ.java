package com.facebook.ads.redexgen.uinode;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class BZ extends SA {
    public BZ(C1795Yn c1795Yn) {
        super(c1795Yn);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int i11, int i12) {
        if (View.MeasureSpec.getMode(i11) == 1073741824) {
            i12 = i11;
        } else if (View.MeasureSpec.getMode(i12) == 1073741824) {
            i11 = i12;
        }
        super.onMeasure(i11, i12);
    }
}
