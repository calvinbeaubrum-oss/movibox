package com.facebook.ads.redexgen.uinode;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeBannerAd;
import java.util.ArrayList;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class SI extends LinearLayout implements QB {
    public final NativeBannerAd A00;
    public final C1795Yn A01;
    public final ArrayList<View> A02;
    public static final int A04 = (int) (LD.A02 * 42.0f);
    public static final int A03 = (int) (LD.A02 * 48.0f);
    public static final int A05 = (int) (LD.A02 * 54.0f);
    public static final int A07 = (int) (LD.A02 * 4.0f);
    public static final int A06 = (int) (LD.A02 * 8.0f);

    public SI(C1795Yn c1795Yn, NativeBannerAd nativeBannerAd, JR jr2, JS js2, MediaView mediaView, AdOptionsView adOptionsView) {
        LinearLayout.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        super(c1795Yn);
        ArrayList<View> arrayList = new ArrayList<>();
        this.A02 = arrayList;
        this.A00 = nativeBannerAd;
        this.A01 = c1795Yn;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        int iA00 = A00(js2);
        O4 o11 = new O4(c1795Yn);
        o11.setFullCircleCorners(true);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(iA00, iA00);
        layoutParams3.gravity = 16;
        o11.addView(mediaView, new LinearLayout.LayoutParams(-1, -1));
        linearLayout.addView(o11, layoutParams3);
        Q8 q11 = new Q8(c1795Yn, nativeBannerAd, js2, jr2, adOptionsView);
        int i11 = A06;
        q11.setPadding(i11, 0, 0, 0);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2);
        layoutParams4.weight = 1.0f;
        layoutParams4.gravity = 16;
        linearLayout.addView(q11, layoutParams4);
        if (js2 == JS.A0A) {
            int i12 = A07;
            setPadding(i12, i12, i12, i12);
            setOrientation(0);
            layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            linearLayout.setPadding(0, 0, i12, 0);
        } else {
            setPadding(i11, i11, i11, i11);
            setOrientation(1);
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            linearLayout.setPadding(0, 0, 0, i11);
        }
        layoutParams.weight = 1.0f;
        addView(linearLayout, layoutParams);
        TextView textView = new TextView(getContext());
        int i13 = A07;
        textView.setPadding(i11, i13, i11, i13);
        jr2.A05(textView);
        textView.setText(nativeBannerAd.getAdCallToAction());
        addView(textView, layoutParams2);
        arrayList.add(mediaView);
        arrayList.add(textView);
    }

    public static int A00(JS js2) {
        switch (Q9.A00[js2.ordinal()]) {
            case 1:
                return A04;
            case 2:
                return A03;
            default:
                return A05;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.QB
    public View getView() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.uinode.QB
    public ArrayList<View> getViewsForInteraction() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.uinode.QB
    public final void unregisterView() {
        this.A00.unregisterView();
    }
}
