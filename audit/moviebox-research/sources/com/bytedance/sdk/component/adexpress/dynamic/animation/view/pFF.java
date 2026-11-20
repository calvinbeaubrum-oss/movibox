package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.We.qr;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF extends ImageView implements IAnimation {
    private float ExN;
    private qr TRI;
    private float We;
    private float pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    zY f26785sc;
    private float zY;

    public pFF(Context context) {
        super(context);
        this.f26785sc = new zY();
    }

    public qr getBrickNativeValue() {
        return this.TRI;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public float getMarqueeValue() {
        return this.We;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public float getRippleValue() {
        return this.pFF;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public float getShineValue() {
        return this.zY;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public float getStretchValue() {
        return this.ExN;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        qr qrVar;
        super.onDraw(canvas);
        this.f26785sc.sc(canvas, this, this);
        if (getRippleValue() == 0.0f || (qrVar = this.TRI) == null || qrVar.pFF() <= 0) {
            return;
        }
        ((ViewGroup) getParent()).setClipChildren(false);
        ((ViewGroup) getParent().getParent()).setClipChildren(false);
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.f26785sc.sc(this, i11, i12);
    }

    public void setBrickNativeValue(qr qrVar) {
        this.TRI = qrVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public void setMarqueeValue(float f11) {
        this.We = f11;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public void setRippleValue(float f11) {
        this.pFF = f11;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public void setShineValue(float f11) {
        this.zY = f11;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public void setStretchValue(float f11) {
        this.ExN = f11;
        this.f26785sc.sc(this, f11);
    }
}
