package com.bytedance.sdk.component.adexpress.dynamic.zY;

import android.content.Context;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF implements qr {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.TRI.zY f26860sc;

    public pFF(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN exN, com.bytedance.sdk.component.adexpress.dynamic.We.qr qrVar) {
        this.f26860sc = new com.bytedance.sdk.component.adexpress.TRI.zY(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(context, 180.0f), (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(context, 180.0f));
        layoutParams.gravity = 17;
        this.f26860sc.setLayoutParams(layoutParams);
        this.f26860sc.setGuideText(qrVar.OKY());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    /* JADX INFO: renamed from: We, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.adexpress.TRI.zY zY() {
        return this.f26860sc;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    public void pFF() {
        this.f26860sc.pFF();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    public void sc() {
        this.f26860sc.sc();
    }
}
