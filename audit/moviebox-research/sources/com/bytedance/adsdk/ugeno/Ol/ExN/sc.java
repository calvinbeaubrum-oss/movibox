package com.bytedance.adsdk.ugeno.Ol.ExN;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.adsdk.ugeno.qr.Qj;
import com.bytedance.adsdk.ugeno.qr.We;
import com.bytedance.adsdk.ugeno.zY;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc extends FrameLayout {
    private LinearLayout ExN;
    private zY Qj;
    private LinearLayout TRI;
    private float We;
    private float pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private Context f26322qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private float f26323sc;
    private double zY;

    public sc(Context context) {
        super(context);
        this.f26322qr = context;
        this.ExN = new LinearLayout(context);
        this.TRI = new LinearLayout(context);
        this.ExN.setOrientation(0);
        this.ExN.setGravity(GravityCompat.START);
        this.TRI.setOrientation(0);
        this.TRI.setGravity(GravityCompat.START);
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) this.f26323sc, (int) this.pFF);
        float f11 = this.We;
        layoutParams.leftMargin = (int) f11;
        layoutParams.topMargin = 0;
        layoutParams.rightMargin = (int) f11;
        layoutParams.bottomMargin = 1;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        zY zYVar = this.Qj;
        if (zYVar != null) {
            zYVar.qr();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        zY zYVar = this.Qj;
        if (zYVar != null) {
            zYVar.Qj();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        zY zYVar = this.Qj;
        if (zYVar != null) {
            zYVar.sc(i11, i12, i13, i14);
        }
        super.onLayout(z11, i11, i12, i13, i14);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        zY zYVar = this.Qj;
        if (zYVar != null) {
            zYVar.sc(i11, i12);
        }
        super.onMeasure(i11, i12);
        this.ExN.measure(i11, i12);
        double dFloor = Math.floor(this.zY);
        float f11 = this.We;
        float f12 = this.f26323sc;
        this.TRI.measure(View.MeasureSpec.makeMeasureSpec((int) ((((double) (f11 + f11 + f12)) * dFloor) + ((double) f11) + ((this.zY - dFloor) * ((double) f12))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.ExN.getMeasuredHeight(), 1073741824));
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        zY zYVar = this.Qj;
        if (zYVar != null) {
            zYVar.pFF(i11, i12, i13, i14);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
    }

    public void sc(double d11, int i11, int i12, float f11, int i13) {
        removeAllViews();
        this.ExN.removeAllViews();
        this.TRI.removeAllViews();
        this.f26323sc = (int) Qj.sc(this.f26322qr, f11);
        this.pFF = (int) Qj.sc(this.f26322qr, f11);
        this.zY = d11;
        this.We = i13;
        for (int i14 = 0; i14 < 5; i14++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setImageResource(We.sc(this.f26322qr, "tt_ugen_rating_star"));
            starImageView.setColorFilter(i11, PorterDuff.Mode.SRC_IN);
            this.TRI.addView(starImageView);
        }
        for (int i15 = 0; i15 < 5; i15++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageResource(We.sc(this.f26322qr, "tt_ugen_rating_star"));
            starImageView2.setColorFilter(i12);
            this.ExN.addView(starImageView2);
        }
        addView(this.ExN);
        addView(this.TRI);
        requestLayout();
    }

    public void sc(zY zYVar) {
        this.Qj = zYVar;
    }
}
