package com.facebook.ads.redexgen.uinode;

import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class M9 extends LinearLayout {
    public static byte[] A04;
    public static final int A05;
    public static final int A06;
    public static final int A07;
    public static final int A08;
    public static final int A09;
    public final ImageView A00;
    public final ImageView A01;
    public final C2S A02;
    public final C1795Yn A03;

    static {
        A03();
        A08 = (int) (LD.A02 * 50.0f);
        A05 = (int) (LD.A02 * 10.0f);
        A06 = (int) (LD.A02 * 20.0f);
        A09 = (int) (LD.A02 * 4.0f);
        A07 = (int) (LD.A02 * 12.0f);
    }

    public M9(C1795Yn c1795Yn, int i11) {
        super(c1795Yn);
        this.A03 = c1795Yn;
        this.A02 = C2T.A00(c1795Yn.A01());
        setOrientation(0);
        this.A00 = new ImageView(c1795Yn);
        this.A01 = new ImageView(c1795Yn);
        A04(i11);
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 91);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A04 = new byte[]{118, 83};
    }

    private void A04(int i11) {
        A05(this.A00, EnumC1470Lw.AD_CHOICES_ICON);
        if (i11 != 2) {
            int i12 = A05;
            setPadding(i12, i12, i12, i12);
            A05(this.A01, i11 == 1 ? EnumC1470Lw.AN_INFO_ICON : EnumC1470Lw.DEFAULT_INFO_ICON);
            int i13 = A06;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i13, i13);
            layoutParams.gravity = 17;
            addView(this.A01, layoutParams);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i13, i13);
            layoutParams2.setMargins(A09, 0, 0, 0);
            layoutParams2.gravity = 17;
            addView(this.A00, layoutParams2);
            return;
        }
        int i14 = A05;
        setPadding(i14, i14 / 3, i14, i14 / 3);
        TextView textView = new TextView(this.A03);
        textView.setText(A02(0, 2, 108));
        textView.setTextColor(-1);
        textView.setPadding(0, i14 / 2, i14 / 2, i14 / 2);
        AbstractC1462Lo.A0X(textView, true, 13);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        addView(textView, layoutParams3);
        int i15 = A07;
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i15, i15);
        layoutParams4.gravity = 16;
        addView(this.A00, layoutParams4);
    }

    public static void A05(ImageView imageView, EnumC1470Lw enumC1470Lw) {
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageBitmap(AbstractC1471Lx.A01(enumC1470Lw));
        imageView.setColorFilter(-1);
    }

    public void setAdDetails(C09701a c09701a, String str, JA ja2, MC mc2) {
        setOnClickListener(new M8(this, ja2, mc2, str, c09701a));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i11) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(A08);
        gradientDrawable.setColor(i11);
        AbstractC1462Lo.A0S(this, gradientDrawable);
    }

    public void setIconColors(int i11) {
        this.A00.setColorFilter(i11);
        this.A01.setColorFilter(i11);
    }
}
