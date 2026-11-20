package com.bytedance.sdk.component.adexpress.TRI;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class FI extends FrameLayout {
    private static final int Ol = (com.bytedance.sdk.component.adexpress.dynamic.ExN.UFX.pFF("", 0.0f, true)[1] / 2) + 1;
    private static final int WH = (com.bytedance.sdk.component.adexpress.dynamic.ExN.UFX.pFF("", 0.0f, true)[1] / 2) + 3;
    private Drawable ExN;
    private float Qj;
    private Drawable TRI;
    private float We;
    LinearLayout pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private double f26669qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    LinearLayout f26670sc;
    private float zY;

    public FI(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f26670sc = new LinearLayout(getContext());
        this.pFF = new LinearLayout(getContext());
        this.f26670sc.setOrientation(0);
        this.f26670sc.setGravity(GravityCompat.START);
        this.pFF.setOrientation(0);
        this.pFF.setGravity(GravityCompat.START);
        this.ExN = com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_star_thick");
        this.TRI = com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_star");
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams((int) this.zY, (int) this.We));
        imageView.setPadding(1, Ol, 1, WH);
        return imageView;
    }

    public Drawable getStarEmptyDrawable() {
        return this.ExN;
    }

    public Drawable getStarFillDrawable() {
        return this.TRI;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        this.f26670sc.measure(i11, i12);
        double d11 = this.f26669qr;
        float f11 = this.zY;
        this.pFF.measure(View.MeasureSpec.makeMeasureSpec((int) (((double) ((((int) d11) * f11) + 1.0f)) + (((double) (f11 - 2.0f)) * (d11 - ((double) ((int) d11))))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f26670sc.getMeasuredHeight(), 1073741824));
        if (this.Qj > 0.0f) {
            LinearLayout linearLayout = this.f26670sc;
            linearLayout.setPadding(0, ((int) (linearLayout.getMeasuredHeight() - this.Qj)) / 2, 0, 0);
            this.pFF.setPadding(0, ((int) (this.f26670sc.getMeasuredHeight() - this.Qj)) / 2, 0, 0);
        }
    }

    public void sc(double d11, int i11, int i12, int i13) {
        float f11 = i12;
        this.zY = (int) com.bytedance.sdk.component.adexpress.We.Qj.zY(getContext(), f11);
        this.We = (int) com.bytedance.sdk.component.adexpress.We.Qj.zY(getContext(), f11);
        this.f26669qr = d11;
        this.Qj = i13;
        removeAllViews();
        for (int i14 = 0; i14 < 5; i14++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setColorFilter(i11, PorterDuff.Mode.SRC_IN);
            starImageView.setImageDrawable(getStarFillDrawable());
            this.pFF.addView(starImageView);
        }
        for (int i15 = 0; i15 < 5; i15++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageDrawable(getStarEmptyDrawable());
            this.f26670sc.addView(starImageView2);
        }
        addView(this.f26670sc);
        addView(this.pFF);
        requestLayout();
    }
}
