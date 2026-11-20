package com.facebook.ads.redexgen.uinode;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.ads.internal.api.AdNativeComponentView;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class MN extends AdNativeComponentView {
    public static final int A01 = (int) (LD.A02 * 1.0f);
    public final ImageView A00;

    public MN(C1795Yn c1795Yn) {
        super(c1795Yn);
        MZ mz2 = new MZ(c1795Yn);
        this.A00 = mz2;
        mz2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        LI.A04(mz2, LI.A0A);
        addView(mz2, new ViewGroup.LayoutParams(-1, -1));
        AbstractC1462Lo.A0M(mz2, -2130706433);
        int i11 = A01;
        setPadding(i11, i11, i11, i11);
    }

    @Override // com.facebook.ads.internal.api.AdNativeComponentView
    public View getAdContentsView() {
        return this.A00;
    }

    public ImageView getImageCardView() {
        return this.A00;
    }
}
