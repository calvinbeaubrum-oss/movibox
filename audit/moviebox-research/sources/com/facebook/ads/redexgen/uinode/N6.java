package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class N6 extends LinearLayout {
    public static final int A03 = (int) (LD.A02 * 40.0f);
    public static final int A04 = (int) (LD.A02 * 20.0f);
    public static final int A05 = (int) (LD.A02 * 10.0f);
    public final C2W A00;
    public final C1795Yn A01;
    public final InterfaceC1490Mq A02;

    public N6(C1795Yn c1795Yn, C2W c2w, InterfaceC1490Mq interfaceC1490Mq, EnumC1470Lw enumC1470Lw) {
        this(c1795Yn, c2w, interfaceC1490Mq, null, enumC1470Lw);
    }

    public N6(C1795Yn c1795Yn, C2W c2w, InterfaceC1490Mq interfaceC1490Mq, String str, EnumC1470Lw enumC1470Lw) {
        super(c1795Yn);
        this.A01 = c1795Yn;
        this.A00 = c2w;
        this.A02 = interfaceC1490Mq;
        setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (!TextUtils.isEmpty(str)) {
            View viewA01 = A01(str);
            viewA01.setPadding(0, 0, 0, 0);
            View view = new View(getContext());
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
            AbstractC1462Lo.A0M(view, -10459280);
            addView(viewA01, layoutParams);
            addView(view);
        }
        if (!TextUtils.isEmpty(c2w.A03())) {
            View viewA00 = A00(enumC1470Lw, c2w.A03());
            int i11 = A05;
            viewA00.setPadding(0, i11, 0, i11);
            addView(viewA00, layoutParams);
        }
        NC ncA03 = A03();
        ncA03.setPadding(0, A05, 0, 0);
        addView(ncA03, layoutParams);
    }

    private View A00(EnumC1470Lw enumC1470Lw, String str) {
        ImageView imageView = new ImageView(getContext());
        imageView.setColorFilter(-10459280);
        int i11 = A04;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i11, i11);
        layoutParams.gravity = 16;
        imageView.setImageBitmap(AbstractC1471Lx.A01(enumC1470Lw));
        TextView textView = new TextView(getContext());
        AbstractC1462Lo.A0X(textView, true, 14);
        textView.setTextColor(-10459280);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        textView.setText(str);
        textView.setPadding(A05, 0, 0, 0);
        textView.setFocusable(true);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.addView(imageView, layoutParams);
        linearLayout.addView(textView, layoutParams2);
        return linearLayout;
    }

    private View A01(String str) {
        ImageView imageView = new ImageView(getContext());
        imageView.setColorFilter(-10459280);
        imageView.setImageBitmap(AbstractC1471Lx.A01(EnumC1470Lw.BACK_ARROW));
        int i11 = A05;
        imageView.setPadding(0, i11, i11 * 2, i11);
        int i12 = A03;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i12, i12);
        imageView.setOnClickListener(new N4(this));
        TextView textView = new TextView(getContext());
        textView.setGravity(17);
        textView.setText(str);
        AbstractC1462Lo.A0X(textView, true, 16);
        textView.setTextColor(-14934495);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, 0, i12, 0);
        layoutParams2.gravity = 17;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.addView(imageView, layoutParams);
        linearLayout.addView(textView, layoutParams2);
        return linearLayout;
    }

    private NC A03() {
        NC nc2 = new NC(this.A01);
        for (C2W c2w : this.A00.A05()) {
            C1492Ms c1492Ms = new C1492Ms(this.A01);
            c1492Ms.setData(c2w.A04(), null);
            c1492Ms.setOnClickListener(new N5(this, c1492Ms, c2w));
            nc2.addView(c1492Ms);
        }
        return nc2;
    }
}
