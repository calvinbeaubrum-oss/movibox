package com.facebook.ads.redexgen.uinode;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1558Pg extends LinearLayout {
    public LinearLayout A00;
    public final int A01;
    public final C1795Yn A02;
    public final O3 A03;
    public final O9 A04;
    public static final int A07 = (int) (LD.A02 * 16.0f);
    public static final int A08 = (int) (LD.A02 * 16.0f);
    public static final int A06 = (int) (LD.A02 * 8.0f);
    public static final int A05 = (int) (LD.A02 * 72.0f);

    public C1558Pg(C1556Pe c1556Pe) {
        super(c1556Pe.A06);
        C1795Yn c1795Yn = c1556Pe.A06;
        this.A02 = c1795Yn;
        this.A03 = new O3(c1795Yn);
        this.A04 = new O9(c1795Yn, c1556Pe.A01, true, false, true);
        this.A01 = c1556Pe.A00;
        A03(c1556Pe);
    }

    public /* synthetic */ C1558Pg(C1556Pe c1556Pe, C1639Sj c1639Sj) {
        this(c1556Pe);
    }

    private void A00() {
        A01(this.A03, 150);
        A01(this.A04, 170);
        LinearLayout linearLayout = this.A00;
        if (linearLayout != null) {
            A01(linearLayout, 190);
        }
    }

    private void A01(View view, int i11) {
        view.setTranslationY(i11);
        view.setScaleY(0.75f);
        view.setScaleX(0.75f);
        view.animate().translationYBy(-i11).scaleX(1.0f).scaleY(1.0f).setDuration(300L).setInterpolator(new DecelerateInterpolator(2.0f));
    }

    private void A02(C1556Pe c1556Pe) {
        if (TextUtils.isEmpty(c1556Pe.A03)) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.A00 = linearLayout;
        linearLayout.setGravity(17);
        LinearLayout linearLayout2 = this.A00;
        int i11 = A08;
        linearLayout2.setPadding(i11, i11 / 2, i11, i11 / 2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, i11 / 2, 0, 0);
        TextView textView = new TextView(getContext());
        textView.setTextColor(-1);
        AbstractC1462Lo.A0X(textView, false, 16);
        textView.setText(c1556Pe.A03);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        ImageView imageView = new ImageView(getContext());
        new AsyncTaskC1672Tq(imageView, this.A02).A04().A07(c1556Pe.A02);
        int i12 = A07;
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i12, i12);
        layoutParams3.setMargins(0, 0, i11 / 2, 0);
        this.A00.addView(imageView, layoutParams3);
        this.A00.addView(textView, layoutParams2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(100.0f);
        gradientDrawable.setColor(469762047);
        AbstractC1462Lo.A0S(this.A00, gradientDrawable);
        addView(this.A00, layoutParams);
    }

    private void A03(C1556Pe c1556Pe) {
        AbstractC1462Lo.A0M(this.A03, 0);
        this.A03.setRadius(50);
        if (c1556Pe.A04.A00() == C1L.A05) {
            this.A03.setFullCircleCorners(true);
        } else {
            this.A03.setRadius(A06);
        }
        new AsyncTaskC1672Tq(this.A03, this.A02).A04().A07(c1556Pe.A05.A01());
        this.A04.A03(c1556Pe.A04.A06(), c1556Pe.A05.A03(), null, false, true);
        this.A04.getDescriptionTextView().setAlpha(0.8f);
        this.A04.setAlignment(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i11 = A08;
        layoutParams.setMargins(0, i11, 0, i11 / 2);
        View view = this.A03;
        int i12 = A05;
        addView(view, new LinearLayout.LayoutParams(i12, i12));
        addView(this.A04, layoutParams);
        A02(c1556Pe);
        AbstractC1462Lo.A0M(this, -14473425);
        setGravity(17);
        setOrientation(1);
    }

    public final void A04(InterfaceC1557Pf interfaceC1557Pf) {
        A00();
        postDelayed(new C1639Sj(this, interfaceC1557Pf), this.A01);
    }
}
