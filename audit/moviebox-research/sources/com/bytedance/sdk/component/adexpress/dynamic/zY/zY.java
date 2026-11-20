package com.bytedance.sdk.component.adexpress.dynamic.zY;

import android.content.Context;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY implements qr {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    com.bytedance.sdk.component.adexpress.TRI.ExN f26878sc;

    public zY(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN exN, com.bytedance.sdk.component.adexpress.dynamic.We.qr qrVar) {
        this.f26878sc = new com.bytedance.sdk.component.adexpress.TRI.ExN(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(exN.getDynamicHeight(), exN.getDynamicHeight());
        layoutParams.gravity = 17;
        this.f26878sc.setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    /* JADX INFO: renamed from: We, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.adexpress.TRI.ExN zY() {
        return this.f26878sc;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    public void pFF() {
        this.f26878sc.pFF();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    public void sc() {
        this.f26878sc.sc();
    }
}
