package com.facebook.ads.redexgen.uinode;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import java.util.ArrayList;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class SH extends FrameLayout implements QB {
    public TextView A00;
    public TextView A01;
    public TextView A02;
    public TextView A03;
    public final MediaView A04;
    public final NativeAd A05;
    public final QC A06;
    public final ArrayList<View> A07;
    public static String[] A08 = {"LrUXeZd5oXG5wJ7", "S6ePTdxfK6c7yhvbHMQjZqIgQsLDz3QO", "YqVXoEdDoNpK3nL0El5", "Exhg7LXIw6HgSAmcccR052cOKtX3WF", "LN", "59F20xOEewuTmZzPatOKMeF6XI6ZvB1j", "IRBrDKvf2o0dBHWjf99N02m12yrR0Bg7", "KZ90h8EmVWfLUNKv0pT"};
    public static final int A0E = (int) (LD.A02 * 6.0f);
    public static final int A0D = (int) (LD.A02 * 8.0f);
    public static final int A0C = (int) (LD.A02 * 12.0f);
    public static final int A0A = (int) (LD.A02 * 350.0f);
    public static final int A09 = (int) (LD.A02 * 250.0f);
    public static final int A0B = (int) (LD.A02 * 175.0f);

    public SH(C1795Yn c1795Yn, NativeAd nativeAd, JR jr2, JS js2, O3 o11, MediaView mediaView, AdOptionsView adOptionsView) {
        super(c1795Yn);
        ArrayList<View> arrayList = new ArrayList<>();
        this.A07 = arrayList;
        this.A05 = nativeAd;
        this.A04 = mediaView;
        QC qc2 = new QC(c1795Yn, nativeAd, jr2, o11, adOptionsView);
        this.A06 = qc2;
        int i11 = A0C;
        qc2.setPadding(i11, i11, i11, A0E);
        addView(qc2, new FrameLayout.LayoutParams(-1, -2));
        if (js2 == JS.A09 || js2 == JS.A0B) {
            A07(jr2);
        }
        addView(mediaView, new FrameLayout.LayoutParams(-1, -2));
        if (js2 != JS.A0B || nativeAd.getAdCreativeType() != NativeAd.AdCreativeType.CAROUSEL) {
            A06(jr2);
            A04(jr2);
            A05(jr2);
        }
        arrayList.add(o11);
        arrayList.add(mediaView);
    }

    private int A00() {
        TextView textView = this.A03;
        int measuredHeight = 0;
        int measuredHeight2 = (textView == null || textView.getVisibility() != 0) ? 0 : this.A03.getMeasuredHeight();
        TextView textView2 = this.A02;
        if (A08[1].charAt(0) == 'k') {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[6] = "SrhbzBCrZmwJCsE1GN19GBhRpshhKBl4";
        strArr[5] = "lZXGEU0s5y97LRskCQS4IC0Q6rEMlB8o";
        int measuredHeight3 = (textView2 == null || textView2.getVisibility() != 0) ? 0 : this.A02.getMeasuredHeight();
        TextView textView3 = this.A00;
        int measuredHeight4 = (textView3 == null || textView3.getVisibility() != 0) ? 0 : this.A00.getMeasuredHeight();
        TextView textView4 = this.A01;
        if (A08[1].charAt(0) == 'k') {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[6] = "nRuc5lutSXPKh9f7kKzdW2kIhLu3nB9m";
        strArr2[5] = "FuxAmHJZMOFMUG38wB3yXnFuBZuRMBRE";
        if (textView4 != null && textView4.getVisibility() == 0) {
            measuredHeight = this.A01.getMeasuredHeight() + A0C + A0D;
        }
        return ((((getMeasuredHeight() - this.A06.getMeasuredHeight()) - measuredHeight2) - measuredHeight3) - measuredHeight4) - measuredHeight;
    }

    private void A01() {
        TextView textView = this.A03;
        if (textView != null) {
            textView.setLines(1);
        }
        TextView textView2 = this.A02;
        if (textView2 != null) {
            textView2.setLines(1);
        }
        TextView textView3 = this.A00;
        if (textView3 != null) {
            textView3.setLines(1);
        }
    }

    private void A02(int i11) {
        AbstractC1462Lo.A0N(this.A04, i11 > A0B ? 0 : 8);
        AbstractC1462Lo.A0N(this.A03, i11 > A0A ? 0 : 8);
        AbstractC1462Lo.A0N(this.A00, i11 <= A09 ? 8 : 0);
    }

    public static void A03(int i11, int i12, TextView... textViewArr) {
        for (TextView textView : textViewArr) {
            if (textView != null && textView.getVisibility() == 0) {
                int iA04 = AbstractC1462Lo.A04(textView, i12);
                textView.setLines(iA04 + 1);
                textView.measure(i11, View.MeasureSpec.makeMeasureSpec(textView.getMeasuredHeight() + (textView.getLineHeight() * iA04), 1073741824));
                i12 -= textView.getLineHeight() * iA04;
            }
        }
    }

    private void A04(JR jr2) {
        if (this.A05.getAdBodyText() == null || this.A05.getAdBodyText().trim().isEmpty()) {
            return;
        }
        TextView textView = new TextView(getContext());
        this.A00 = textView;
        jr2.A06(textView);
        this.A00.setText(this.A05.getAdBodyText());
        TextView textView2 = this.A00;
        int i11 = A0C;
        textView2.setPadding(i11, 0, i11, 0);
        addView(this.A00, new FrameLayout.LayoutParams(-1, -2));
    }

    private void A05(JR jr2) {
        if (this.A05.hasCallToAction()) {
            TextView textView = new TextView(getContext());
            this.A01 = textView;
            AbstractC1462Lo.A0K(textView);
            jr2.A05(this.A01);
            this.A01.setText(this.A05.getAdCallToAction());
            TextView textView2 = this.A01;
            int i11 = A0D;
            textView2.setPadding(i11, i11, i11, i11);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(i11, 0, i11, 0);
            addView(this.A01, layoutParams);
            this.A07.add(this.A01);
        }
    }

    private void A06(JR jr2) {
        if (this.A05.getAdHeadline() == null || this.A05.getAdHeadline().trim().isEmpty()) {
            return;
        }
        TextView textView = new TextView(getContext());
        this.A02 = textView;
        jr2.A07(textView);
        this.A02.setText(this.A05.getAdHeadline());
        TextView textView2 = this.A02;
        int i11 = A0C;
        textView2.setPadding(i11, A0D, i11, 0);
        addView(this.A02, new FrameLayout.LayoutParams(-1, -2));
    }

    private void A07(JR jr2) {
        if (this.A05.getAdLinkDescription() == null || this.A05.getAdLinkDescription().trim().isEmpty()) {
            return;
        }
        TextView textView = new TextView(getContext());
        this.A03 = textView;
        jr2.A06(textView);
        this.A03.setText(this.A05.getAdLinkDescription());
        TextView textView2 = this.A03;
        int i11 = A0C;
        textView2.setPadding(i11, 0, i11, A0D);
        addView(this.A03, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.facebook.ads.redexgen.uinode.QB
    public View getView() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.uinode.QB
    public ArrayList<View> getViewsForInteraction() {
        return this.A07;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        QC qc2 = this.A06;
        qc2.layout(i11, i12, i13, qc2.getMeasuredHeight() + i12);
        int measuredHeight = i12 + this.A06.getMeasuredHeight();
        TextView textView = this.A03;
        if (textView != null && textView.getVisibility() == 0) {
            int measuredHeight2 = this.A03.getMeasuredHeight();
            this.A03.layout(i11, measuredHeight, i13, measuredHeight + measuredHeight2);
            measuredHeight += measuredHeight2;
        }
        MediaView mediaView = this.A04;
        mediaView.layout(i11, measuredHeight, i13, mediaView.getMeasuredHeight() + measuredHeight);
        int measuredHeight3 = measuredHeight + this.A04.getMeasuredHeight();
        TextView textView2 = this.A02;
        if (textView2 != null) {
            textView2.layout(i11, measuredHeight3, i13, textView2.getMeasuredHeight() + measuredHeight3);
            measuredHeight3 += this.A02.getMeasuredHeight();
        }
        TextView textView3 = this.A00;
        if (textView3 != null && textView3.getVisibility() == 0) {
            TextView textView4 = this.A00;
            if (A08[1].charAt(0) == 'k') {
                throw new RuntimeException();
            }
            A08[3] = "gjv6mmFqHT0";
            textView4.layout(i11, measuredHeight3, i13, textView4.getMeasuredHeight() + measuredHeight3);
        }
        TextView textView5 = this.A01;
        if (textView5 != null) {
            int i15 = A0C;
            textView5.layout(i11 + i15, (i14 - textView5.getMeasuredHeight()) - i15, i13 - i15, i14 - i15);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i11, int i12) {
        A02(View.MeasureSpec.getSize(i12));
        A01();
        super.onMeasure(i11, i12);
        int iA00 = A00();
        int iMin = (this.A04.getMediaWidth() == 0 || this.A04.getMediaHeight() == 0 || ((ZH) this.A04.getMediaViewApi()).A0N()) ? iA00 : Math.min((int) (this.A04.getMeasuredWidth() * (this.A04.getMediaHeight() / this.A04.getMediaWidth())), iA00);
        this.A04.measure(i11, View.MeasureSpec.makeMeasureSpec(iMin, 1073741824));
        if (iMin < iA00) {
            A03(i11, iA00 - iMin, this.A02, this.A00, this.A03);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.QB
    public final void unregisterView() {
        this.A05.unregisterView();
    }
}
