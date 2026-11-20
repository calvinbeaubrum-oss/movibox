package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Po, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1566Po extends LinearLayout {
    public static final int A04 = (int) (LD.A02 * 32.0f);
    public static final int A05 = (int) (LD.A02 * 8.0f);
    public TextView A00;
    public TextView A01;
    public O3 A02;
    public final C1795Yn A03;

    public C1566Po(C1795Yn c1795Yn) {
        super(c1795Yn);
        this.A03 = c1795Yn;
        A00(c1795Yn);
    }

    private final void A00(C1795Yn c1795Yn) {
        setGravity(16);
        O3 o11 = new O3(c1795Yn);
        this.A02 = o11;
        o11.setFullCircleCorners(true);
        int i11 = A04;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i11, i11);
        layoutParams.setMargins(0, 0, A05, 0);
        addView(this.A02, layoutParams);
        LinearLayout linearLayout = new LinearLayout(c1795Yn);
        linearLayout.setOrientation(1);
        this.A00 = new TextView(c1795Yn);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        AbstractC1462Lo.A0X(this.A00, true, 16);
        this.A00.setEllipsize(TextUtils.TruncateAt.END);
        this.A00.setSingleLine(true);
        TextView textView = new TextView(c1795Yn);
        this.A01 = textView;
        AbstractC1462Lo.A0X(textView, false, 14);
        linearLayout.addView(this.A00);
        linearLayout.addView(this.A01);
        addView(linearLayout, layoutParams2);
    }

    public final void A01() {
        this.A02.setImageBitmap(null);
        this.A00.setText("");
        this.A01.setText("");
    }

    public final void A02(int i11, int i12) {
        this.A00.setTextColor(i11);
        this.A01.setTextColor(i12);
    }

    public void setPageDetails(C09701a c09701a) {
        AsyncTaskC1672Tq asyncTaskC1672Tq = new AsyncTaskC1672Tq(this.A02, this.A03);
        int i11 = A04;
        asyncTaskC1672Tq.A05(i11, i11);
        asyncTaskC1672Tq.A07(c09701a.A01());
        this.A00.setText(c09701a.A02());
        this.A01.setText(c09701a.A03());
    }
}
