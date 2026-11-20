package com.facebook.ads.redexgen.uinode;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.widget.TextView;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.internal.api.NativeAdViewAttributesApi;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class JR implements NativeAdViewAttributesApi {
    public static final int A08 = (int) (LD.A02 * 4.0f);
    public static final int A07 = (int) (LD.A02 * 1.0f);
    public Typeface A06 = Typeface.create(Typeface.SANS_SERIF, 0);
    public int A00 = -1;
    public int A04 = -14868183;
    public int A05 = -10393744;
    public int A01 = -1;
    public int A03 = -12420889;
    public int A02 = -12420889;

    public final int A00() {
        return this.A00;
    }

    public final int A01() {
        return this.A01;
    }

    public final int A02() {
        return this.A02;
    }

    public final int A03() {
        return this.A03;
    }

    public final int A04(float f11) {
        int i11 = this.A01;
        return AbstractC10112p.A02(((-16777216) & i11) | ((i11 ^ (-1)) & 16777215), i11, f11);
    }

    public final void A05(TextView textView) {
        textView.setTextSize(2, 14.0f);
        textView.setTypeface(this.A06, 1);
        textView.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.A01);
        int i11 = A08;
        gradientDrawable.setCornerRadius(i11);
        int i12 = A07;
        gradientDrawable.setStroke(i12, this.A02);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(this.A03);
        gradientDrawable2.setCornerRadius(i11);
        gradientDrawable2.setStroke(i12, this.A02);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        AbstractC1462Lo.A0S(textView, stateListDrawable);
        textView.setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{this.A01, this.A03}));
    }

    public final void A06(TextView textView) {
        textView.setTextColor(this.A05);
        textView.setTextSize(14.0f);
        textView.setTypeface(this.A06);
        textView.setEllipsize(TextUtils.TruncateAt.END);
    }

    public final void A07(TextView textView) {
        textView.setTextColor(this.A04);
        textView.setTextSize(16.0f);
        textView.setTypeface(this.A06, 1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
    }

    public final void A08(TextView textView) {
        textView.setTextColor(this.A04);
        textView.setTextSize(16.0f);
        textView.setTypeface(this.A06, 1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
    }

    public final void A09(AdOptionsView adOptionsView, int i11) {
        adOptionsView.setIconColor(this.A04);
        adOptionsView.setIconSizeDp(i11);
    }

    @Override // com.facebook.ads.internal.api.NativeAdViewAttributesApi
    public final void setBackgroundColor(int i11) {
        this.A00 = i11;
    }

    @Override // com.facebook.ads.internal.api.NativeAdViewAttributesApi
    public final void setCTABackgroundColor(int i11) {
        this.A01 = i11;
    }

    @Override // com.facebook.ads.internal.api.NativeAdViewAttributesApi
    public final void setCTABorderColor(int i11) {
        this.A02 = i11;
    }

    @Override // com.facebook.ads.internal.api.NativeAdViewAttributesApi
    public final void setCTATextColor(int i11) {
        this.A03 = i11;
    }

    @Override // com.facebook.ads.internal.api.NativeAdViewAttributesApi
    public final void setPrimaryTextColor(int i11) {
        this.A04 = i11;
    }

    @Override // com.facebook.ads.internal.api.NativeAdViewAttributesApi
    public final void setSecondaryTextColor(int i11) {
        this.A05 = i11;
    }

    @Override // com.facebook.ads.internal.api.NativeAdViewAttributesApi
    public final void setTypeface(Typeface typeface) {
        this.A06 = typeface;
    }
}
