package com.facebook.ads.redexgen.uinode;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.NativeAd;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class QC extends LinearLayout {
    public static final int A00 = (int) (LD.A02 * 32.0f);
    public static final int A01 = (int) (LD.A02 * 8.0f);

    public QC(C1795Yn c1795Yn, NativeAd nativeAd, JR jr2, O3 o11, AdOptionsView adOptionsView) {
        super(c1795Yn);
        setOrientation(0);
        o11.setFullCircleCorners(true);
        int i11 = A00;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i11, i11);
        layoutParams.gravity = 16;
        layoutParams.setMargins(0, 0, A01, 0);
        addView(o11, layoutParams);
        TextView textView = new TextView(c1795Yn);
        jr2.A08(textView);
        textView.setMaxLines(1);
        textView.setText(nativeAd.getAdvertiserName());
        TextView textView2 = new TextView(c1795Yn);
        jr2.A06(textView2);
        textView2.setMaxLines(1);
        textView2.setText(nativeAd.getSponsoredTranslation());
        LinearLayout linearLayout = new LinearLayout(c1795Yn);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.weight = 1.0f;
        layoutParams2.gravity = 16;
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(textView2, new LinearLayout.LayoutParams(-1, -2));
        addView(linearLayout, layoutParams2);
        addView(adOptionsView, new LinearLayout.LayoutParams(-2, -2));
    }
}
