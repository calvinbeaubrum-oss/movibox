package com.bytedance.sdk.component.adexpress.dynamic.zY;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Tf implements qr {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.TRI.SR f26856sc;

    public Tf(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN exN, com.bytedance.sdk.component.adexpress.dynamic.We.qr qrVar) {
        this.f26856sc = new com.bytedance.sdk.component.adexpress.TRI.SR(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(context, 180.0f), (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(context, 180.0f));
        layoutParams.gravity = 17;
        this.f26856sc.setLayoutParams(layoutParams);
        this.f26856sc.setGuideText(qrVar.OKY());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    public void pFF() {
        this.f26856sc.pFF();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    public void sc() {
        this.f26856sc.sc();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    public ViewGroup zY() {
        return this.f26856sc;
    }
}
