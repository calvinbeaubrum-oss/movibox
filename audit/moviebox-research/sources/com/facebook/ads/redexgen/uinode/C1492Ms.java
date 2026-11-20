package com.facebook.ads.redexgen.uinode;

import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ms, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1492Ms extends LinearLayout {
    public boolean A00;
    public final ImageView A01;
    public final TextView A02;
    public static final int A04 = (int) (LD.A02 * 16.0f);
    public static final int A05 = (int) (LD.A02 * 12.0f);
    public static final int A06 = (int) (LD.A02 * 12.0f);
    public static final int A03 = (int) (LD.A02 * 16.0f);

    public C1492Ms(C1795Yn c1795Yn) {
        super(c1795Yn);
        this.A00 = false;
        setOrientation(0);
        int i11 = A04;
        int i12 = A05;
        setPadding(i11, i12, i11, i12);
        ImageView imageView = new ImageView(getContext());
        this.A01 = imageView;
        int i13 = A03;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i13, i13);
        layoutParams.gravity = 17;
        TextView textView = new TextView(getContext());
        this.A02 = textView;
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        addView(imageView, layoutParams);
        addView(textView, layoutParams2);
        A00();
    }

    private void A00() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(this.A00 ? -13272859 : -1315344);
        gradientDrawable.setCornerRadius(50.0f);
        AbstractC1462Lo.A0S(this, gradientDrawable);
        AbstractC1462Lo.A0X(this.A02, false, 14);
        int i11 = this.A00 ? -1 : -10459280;
        this.A02.setTextColor(i11);
        this.A01.setColorFilter(i11);
    }

    public final void A01() {
        setSelected(!this.A00);
    }

    public void setData(String str, EnumC1470Lw enumC1470Lw) {
        this.A02.setText(str);
        if (enumC1470Lw != null) {
            this.A01.setImageBitmap(AbstractC1471Lx.A01(enumC1470Lw));
            this.A01.setVisibility(0);
            this.A02.setPadding(A06, 0, 0, 0);
        } else {
            this.A01.setVisibility(8);
            this.A02.setPadding(0, 0, 0, 0);
        }
        A00();
    }

    @Override // android.view.View
    public void setSelected(boolean z11) {
        this.A00 = z11;
        A00();
    }
}
