package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1671Tp extends AbstractC10002e {
    public static byte[] A07;
    public static final int A08;
    public static final int A09;
    public static final int A0A;
    public static final int A0B;
    public static final int A0C;
    public final LinearLayout A00;
    public final RelativeLayout A01;
    public final AbstractC1898b5 A02;
    public final C1795Yn A03;
    public final J2 A04;
    public final C1454Lg A05;
    public final MC A06;

    static {
        A06();
        A0B = (int) (AbstractC10002e.A08 * 12.0f);
        A0C = (int) (AbstractC10002e.A08 * 84.0f);
        A0A = (int) (AbstractC10002e.A08 * 14.0f);
        A08 = (int) (AbstractC10002e.A08 * 8.0f);
        A09 = AbstractC10112p.A01(-1, 77);
    }

    public C1671Tp(C1795Yn c1795Yn, AbstractC1898b5 abstractC1898b5, J2 j11, MC mc2) {
        super(c1795Yn);
        C1454Lg c1454Lg = new C1454Lg();
        this.A05 = c1454Lg;
        this.A03 = c1795Yn;
        this.A02 = abstractC1898b5;
        this.A04 = j11;
        this.A06 = mc2;
        c1454Lg.A05();
        setRadius(20.0f);
        setMaxCardElevation(75.0f);
        RelativeLayout relativeLayout = new RelativeLayout(c1795Yn);
        this.A01 = relativeLayout;
        OA.A00(c1795Yn, relativeLayout, abstractC1898b5.A0x().A0D().A07());
        LinearLayout linearLayout = new LinearLayout(c1795Yn);
        this.A00 = linearLayout;
        linearLayout.setOrientation(1);
        A05();
        A04();
        relativeLayout.addView(linearLayout, new RelativeLayout.LayoutParams(-1, -1));
        addView(relativeLayout, new FrameLayout.LayoutParams(-1, -1));
    }

    public static String A03(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 50);
        }
        return new String(bArrCopyOfRange);
    }

    private void A04() {
        ViewOnClickListenerC1667Tl viewOnClickListenerC1667Tl = new ViewOnClickListenerC1667Tl(this.A03, QP.A04.A02(), this.A02.A0w().A01(), this.A02.A0x().A0F().A06(), this.A04, this.A06, null, this.A05, this.A02.A0y());
        viewOnClickListenerC1667Tl.setViewShowsOverMedia(true);
        AbstractC1462Lo.A0G(1001, viewOnClickListenerC1667Tl);
        viewOnClickListenerC1667Tl.setCta(this.A02.A0x().A0F(), this.A02.A12(), new HashMap(), null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i11 = A0B;
        viewOnClickListenerC1667Tl.setPadding(i11, i11, i11, i11);
        layoutParams.setMargins(i11, i11, i11, i11 * 2);
        this.A00.addView(viewOnClickListenerC1667Tl, layoutParams);
    }

    private void A05() {
        RelativeLayout relativeLayout = new RelativeLayout(this.A03);
        O3 o11 = new O3(this.A03);
        AsyncTaskC1672Tq asyncTaskC1672Tq = new AsyncTaskC1672Tq(o11, this.A03);
        int i11 = A0C;
        asyncTaskC1672Tq.A05(i11, i11).A07(this.A02.A10().A01());
        o11.setFullCircleCorners(true);
        AbstractC1462Lo.A0M(o11, 0);
        AbstractC1462Lo.A0K(o11);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i11, i11);
        int i12 = A0B;
        layoutParams.setMargins(i12, i12, i12, i12);
        layoutParams.addRule(14);
        relativeLayout.addView(o11, layoutParams);
        TextView textView = new TextView(this.A03);
        AbstractC1462Lo.A0K(textView);
        textView.setTextColor(this.A02.A0w().A01().A06(true));
        textView.setText(this.A02.A0x().A0E().A06());
        textView.setGravity(17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(3, o11.getId());
        relativeLayout.addView(textView, layoutParams2);
        LinearLayout linearLayout = new LinearLayout(this.A03);
        AbstractC1462Lo.A0K(linearLayout);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.setMargins(i12, 0, i12, i12);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, textView.getId());
        relativeLayout.addView(linearLayout, layoutParams3);
        O5 o12 = new O5(this.A03, A0A, 5, A09, -1);
        o12.setGravity(16);
        linearLayout.addView(o12, new LinearLayout.LayoutParams(-2, -1));
        TextView textView2 = new TextView(this.A03);
        textView2.setTextColor(this.A02.A0w().A01().A06(true));
        textView2.setGravity(16);
        textView2.setIncludeFontPadding(false);
        AbstractC1462Lo.A0X(textView2, false, 14);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams4.leftMargin = A08;
        linearLayout.addView(textView2, layoutParams4);
        if (TextUtils.isEmpty(this.A02.A0x().A0E().A03())) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
            o12.setRating(Float.parseFloat(this.A02.A0x().A0E().A03()));
            if (this.A02.A0x().A0E().A02() != null) {
                textView2.setText(A03(0, 1, 20) + NumberFormat.getNumberInstance().format(Integer.parseInt(this.A02.A0x().A0E().A02())) + A03(1, 1, 41));
            }
        }
        TextView textView3 = new TextView(this.A03);
        textView3.setTextColor(this.A02.A0w().A01().A06(true));
        textView3.setText(this.A02.A0x().A0E().A01());
        textView3.setGravity(17);
        textView3.setPadding(i12, i12, i12, i12);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(14);
        layoutParams5.addRule(3, linearLayout.getId());
        relativeLayout.addView(textView3, layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams6.gravity = 4;
        layoutParams6.weight = 0.8f;
        this.A00.addView(relativeLayout, layoutParams6);
    }

    public static void A06() {
        A07 = new byte[]{110, -124};
    }
}
