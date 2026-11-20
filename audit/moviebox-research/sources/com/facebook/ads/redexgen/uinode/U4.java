package com.facebook.ads.redexgen.uinode;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class U4 extends AbstractC1488Mo {
    public static byte[] A05;
    public static final int A06;
    public static final int A07;
    public static final int A08;
    public final ImageView A00;
    public final LinearLayout A01;
    public final ScrollView A02;
    public final C2S A03;
    public final C1795Yn A04;

    static {
        A0C();
        A08 = (int) (LD.A02 * 8.0f);
        A07 = (int) (LD.A02 * 10.0f);
        A06 = (int) (LD.A02 * 44.0f);
    }

    public U4(C1795Yn c1795Yn, J2 j11, String str) {
        super(c1795Yn, j11, str);
        this.A04 = c1795Yn;
        this.A03 = C2T.A00(c1795Yn.A01());
        ImageView imageView = new ImageView(getContext());
        this.A00 = imageView;
        int i11 = A07;
        imageView.setPadding(i11, i11, i11, i11);
        imageView.setColorFilter(-10459280);
        int i12 = A06;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i12, i12);
        layoutParams.gravity = 3;
        imageView.setLayoutParams(layoutParams);
        ScrollView scrollView = new ScrollView(getContext());
        this.A02 = scrollView;
        scrollView.setFillViewport(true);
        AbstractC1462Lo.A0M(scrollView, -218103809);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.A01 = linearLayout;
        linearLayout.setOrientation(1);
        int i13 = A08;
        linearLayout.setPadding(i13, i13, i13, i13);
        scrollView.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        addView(scrollView, new FrameLayout.LayoutParams(-1, -1));
    }

    public static String A0B(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 55);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0C() {
        A05 = new byte[]{53, Ascii.SYN, Ascii.DC4, Ascii.FS, 105, 70, 69, 89, 79, 10, 107, 78, 10, 120, 79, 90, 69, 88, 94, 67, 68, 77};
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1488Mo
    public final void A0L() {
        this.A00.setImageBitmap(AbstractC1471Lx.A01(EnumC1470Lw.CROSS));
        this.A00.setOnClickListener(new N7(this));
        this.A00.setContentDescription(A0B(4, 18, 29));
        C1492Ms c1492Ms = new C1492Ms(this.A04);
        c1492Ms.setData(this.A03.A0H(), EnumC1470Lw.HIDE_AD);
        c1492Ms.setOnClickListener(new N8(this, c1492Ms));
        C1492Ms c1492Ms2 = new C1492Ms(this.A04);
        c1492Ms2.setData(this.A03.A0L(), EnumC1470Lw.REPORT_AD);
        c1492Ms2.setOnClickListener(new N9(this, c1492Ms2));
        C1492Ms c1492Ms3 = new C1492Ms(this.A04);
        c1492Ms3.setData(this.A03.A0M(), EnumC1470Lw.AD_CHOICES_ICON);
        c1492Ms3.setOnClickListener(new NA(this, c1492Ms3));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i11 = A08;
        layoutParams.setMargins(i11, i11, i11, i11);
        layoutParams.gravity = 17;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, 0);
        layoutParams2.gravity = 17;
        layoutParams2.weight = 1.0f;
        AbstractC1462Lo.A0T(this.A01);
        this.A01.removeAllViews();
        this.A01.addView(this.A00);
        this.A01.addView(linearLayout, layoutParams2);
        linearLayout.addView(c1492Ms, layoutParams);
        linearLayout.addView(c1492Ms2, layoutParams);
        linearLayout.addView(c1492Ms3, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1488Mo
    public final void A0M() {
        AbstractC1462Lo.A0I(this);
        AbstractC1462Lo.A0J(this);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1488Mo
    public final void A0N(C2W c2w, C2U c2u) {
        String strA0H;
        EnumC1470Lw enumC1470Lw;
        int i11;
        this.A00.setOnClickListener(null);
        if (c2u == C2U.A05) {
            strA0H = this.A03.A0F();
            enumC1470Lw = EnumC1470Lw.REPORT_AD;
            i11 = -552389;
        } else {
            strA0H = this.A03.A0H();
            enumC1470Lw = EnumC1470Lw.HIDE_AD;
            i11 = -13272859;
        }
        C1487Mn c1487MnA0M = new C1486Mm(this.A04, this.A0B).A0I(strA0H).A0H(this.A03.A0D()).A0F(c2w.A04()).A0K(false).A0E(enumC1470Lw).A0D(i11).A0L(false).A0J(false).A0M();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.gravity = 17;
        layoutParams.weight = 1.0f;
        AbstractC1462Lo.A0T(this.A01);
        this.A02.fullScroll(33);
        this.A01.removeAllViews();
        this.A01.addView(c1487MnA0M, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1488Mo
    public final void A0O(C2W c2w, C2U c2u) {
        N6 n11 = new N6(this.A04, c2w, this.A0B, c2u == C2U.A05 ? EnumC1470Lw.REPORT_AD : EnumC1470Lw.HIDE_AD);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, 0);
        layoutParams.gravity = 17;
        layoutParams.weight = 1.0f;
        this.A00.setImageBitmap(AbstractC1471Lx.A01(EnumC1470Lw.BACK_ARROW));
        this.A00.setOnClickListener(new NB(this));
        this.A00.setContentDescription(A0B(0, 4, 64));
        AbstractC1462Lo.A0T(this.A01);
        this.A02.fullScroll(33);
        this.A01.removeAllViews();
        this.A01.addView(this.A00);
        this.A01.addView(n11, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1488Mo
    public final boolean A0P() {
        return true;
    }
}
