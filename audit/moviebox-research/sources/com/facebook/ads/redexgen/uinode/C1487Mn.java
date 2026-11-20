package com.facebook.ads.redexgen.uinode;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1487Mn extends RelativeLayout {
    public static final int A06;
    public static final int A07;
    public static final int A08;
    public static final int A09;
    public static final int A0A;
    public static final int A0B;
    public static final int A0C;
    public static final int A0D;
    public static final int A0E;
    public static final int A0F;
    public final int A00;
    public final int A01;
    public final C2S A02;
    public final C1795Yn A03;
    public final InterfaceC1490Mq A04;
    public final boolean A05;

    static {
        int i11 = (int) (LD.A02 * 16.0f);
        A09 = i11;
        A0A = (int) (LD.A02 * 8.0f);
        A0D = (int) (LD.A02 * 44.0f);
        int i12 = (int) (LD.A02 * 10.0f);
        A08 = i12;
        A07 = i11 - i12;
        A0E = (int) (LD.A02 * 75.0f);
        A0B = (int) (LD.A02 * 25.0f);
        A0F = (int) (LD.A02 * 45.0f);
        A0C = (int) (LD.A02 * 15.0f);
        A06 = (int) (LD.A02 * 16.0f);
    }

    public C1487Mn(C1486Mm c1486Mm) {
        super(c1486Mm.A0C);
        C1795Yn c1795Yn = c1486Mm.A0C;
        this.A03 = c1795Yn;
        this.A02 = C2T.A00(c1795Yn.A01());
        this.A04 = c1486Mm.A02;
        this.A01 = c1486Mm.A0B ? A0E : A0F;
        this.A00 = c1486Mm.A0B ? A0B : A0C;
        this.A05 = c1486Mm.A07;
        setFocusable(true);
        View viewA01 = A01(c1486Mm);
        View viewA00 = A00(c1486Mm);
        View footerView = getFooterView();
        AbstractC1462Lo.A0K(viewA01);
        AbstractC1462Lo.A0K(viewA00);
        AbstractC1462Lo.A0K(footerView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(13);
        layoutParams2.addRule(3, viewA01.getId());
        layoutParams2.addRule(2, footerView.getId());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(12);
        int i11 = A09;
        layoutParams3.setMargins(i11, 0, i11, i11);
        addView(viewA01, layoutParams);
        addView(viewA00, layoutParams2);
        addView(footerView, layoutParams3);
        footerView.setVisibility(c1486Mm.A08 ? 0 : 8);
    }

    public /* synthetic */ C1487Mn(C1486Mm c1486Mm, ViewOnClickListenerC1484Mk viewOnClickListenerC1484Mk) {
        this(c1486Mm);
    }

    private View A00(C1486Mm c1486Mm) {
        ImageView imageView = new ImageView(getContext());
        int i11 = this.A00;
        imageView.setPadding(i11, i11, i11, i11);
        imageView.setImageBitmap(AbstractC1471Lx.A01(c1486Mm.A01));
        imageView.setColorFilter(-1);
        int i12 = this.A01;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i12, i12);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(c1486Mm.A00);
        AbstractC1462Lo.A0S(imageView, gradientDrawable);
        layoutParams.gravity = 17;
        int i13 = A09;
        layoutParams.setMargins(i13, 0, i13, i13);
        TextView textView = new TextView(getContext());
        AbstractC1462Lo.A0X(textView, true, 20);
        textView.setTextColor(-14934495);
        textView.setText(c1486Mm.A06);
        textView.setGravity(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(i13, 0, i13, i13);
        TextView textView2 = new TextView(getContext());
        AbstractC1462Lo.A0X(textView2, false, 16);
        textView2.setTextColor(-10459280);
        textView2.setText(c1486Mm.A05);
        textView2.setGravity(17);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.setMargins(i13, 0, i13, i13);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.addView(imageView, layoutParams);
        linearLayout.addView(textView, layoutParams2);
        linearLayout.addView(textView2, layoutParams3);
        if (c1486Mm.A09) {
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(17);
            if (!TextUtils.isEmpty(c1486Mm.A04)) {
                O3 o11 = new O3(this.A03);
                int i14 = A0F;
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i14, i14);
                layoutParams4.setMargins(0, 0, A0A, 0);
                o11.setFullCircleCorners(true);
                new AsyncTaskC1672Tq(o11, this.A03).A05(i14, i14).A07(c1486Mm.A04);
                linearLayout2.addView(o11, layoutParams4);
            }
            C1492Ms c1492Ms = new C1492Ms(this.A03);
            c1492Ms.setData(c1486Mm.A03, EnumC1470Lw.CHECKMARK);
            c1492Ms.setSelected(true);
            linearLayout2.addView(c1492Ms, new LinearLayout.LayoutParams(-2, -2));
            linearLayout.addView(linearLayout2);
        }
        return linearLayout;
    }

    private View A01(C1486Mm c1486Mm) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        if (c1486Mm.A0A) {
            ImageView imageView = new ImageView(getContext());
            int i11 = A08;
            imageView.setPadding(i11, i11, i11, i11);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setImageBitmap(AbstractC1471Lx.A01(EnumC1470Lw.CROSS));
            imageView.setOnClickListener(new ViewOnClickListenerC1484Mk(this));
            int i12 = A0D;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i12, i12);
            int i13 = A07;
            layoutParams.setMargins(i13, i13, i13, i13);
            linearLayout.addView(imageView, layoutParams);
        }
        return linearLayout;
    }

    private View getFooterView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageBitmap(AbstractC1471Lx.A01(EnumC1470Lw.SETTINGS));
        imageView.setColorFilter(-13272859);
        int i11 = A06;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i11, i11);
        layoutParams.gravity = 17;
        TextView textView = new TextView(getContext());
        AbstractC1462Lo.A0X(textView, false, 16);
        textView.setTextColor(-13272859);
        int i12 = A0A;
        textView.setPadding(i12, i12, i12, i12);
        textView.setText(this.A02.A0J());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        linearLayout.setOnClickListener(new ViewOnClickListenerC1485Ml(this));
        linearLayout.addView(imageView, layoutParams);
        linearLayout.addView(textView, layoutParams2);
        return linearLayout;
    }
}
