package com.bytedance.adsdk.ugeno.sc;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TRI implements ExN {
    private float ExN;
    private float TRI;
    private float We;
    private float pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private View f26445sc;
    private float zY;

    public TRI(View view) {
        this.f26445sc = view;
    }

    public void ExN(float f11) {
        this.TRI = f11;
        this.f26445sc.postInvalidate();
    }

    public void We(float f11) {
        this.ExN = f11;
        this.f26445sc.postInvalidate();
    }

    @Override // com.bytedance.adsdk.ugeno.sc.ExN
    public float getRipple() {
        return this.zY;
    }

    @Override // com.bytedance.adsdk.ugeno.sc.ExN
    public float getRubIn() {
        return this.TRI;
    }

    @Override // com.bytedance.adsdk.ugeno.sc.ExN
    public float getShine() {
        return this.We;
    }

    @Override // com.bytedance.adsdk.ugeno.sc.ExN
    public float getStretch() {
        return this.ExN;
    }

    public void pFF(float f11) {
        View view = this.f26445sc;
        if (view == null) {
            return;
        }
        this.zY = f11;
        view.postInvalidate();
    }

    public float sc() {
        return this.pFF;
    }

    public void sc(float f11) {
        View view = this.f26445sc;
        if (view == null) {
            return;
        }
        this.pFF = f11;
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setCornerRadius(f11);
        }
    }

    public void sc(int i11) {
        View view = this.f26445sc;
        if (view == null) {
            return;
        }
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(i11);
        } else if (background instanceof ColorDrawable) {
            ((ColorDrawable) background.mutate()).setColor(i11);
        }
    }

    public void zY(float f11) {
        View view = this.f26445sc;
        if (view == null) {
            return;
        }
        this.We = f11;
        view.postInvalidate();
    }
}
