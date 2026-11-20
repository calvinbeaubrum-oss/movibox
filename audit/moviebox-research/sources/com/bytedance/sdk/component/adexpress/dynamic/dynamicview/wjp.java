package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class wjp extends TRI {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public pFF f26829sc;

    public wjp(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        super(context, dynamicRootView, qj2);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.OXF
    public boolean Ol() {
        return super.Ol();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN
    public GradientDrawable getDrawable() {
        pFF pff = new pFF();
        this.f26829sc = pff;
        return pff;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN
    public GradientDrawable sc(GradientDrawable.Orientation orientation, int[] iArr) {
        pFF pff = new pFF(orientation, iArr);
        this.f26829sc = pff;
        return pff;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN
    public pFF sc(Bitmap bitmap) {
        sc scVar = new sc(bitmap, this.f26829sc);
        this.f26829sc = scVar;
        return scVar;
    }
}
