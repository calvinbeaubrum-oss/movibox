package com.bytedance.sdk.component.adexpress.dynamic.zY;

import android.content.Context;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class wjp implements qr<com.bytedance.sdk.component.adexpress.TRI.UFX> {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final com.bytedance.sdk.component.adexpress.TRI.UFX f26877sc;

    public wjp(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN exN, com.bytedance.sdk.component.adexpress.dynamic.We.qr qrVar) {
        com.bytedance.sdk.component.adexpress.TRI.UFX ufx = new com.bytedance.sdk.component.adexpress.TRI.UFX(context);
        this.f26877sc = ufx;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(context, qrVar.eo() > 0 ? qrVar.eo() : com.bytedance.sdk.component.adexpress.We.pFF() ? 0 : 120);
        ufx.setLayoutParams(layoutParams);
        ufx.setClipChildren(false);
        ufx.setText(qrVar.OKY());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    /* JADX INFO: renamed from: We, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.adexpress.TRI.UFX zY() {
        return this.f26877sc;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    public void pFF() {
        com.bytedance.sdk.component.adexpress.TRI.UFX ufx = this.f26877sc;
        if (ufx != null) {
            ufx.pFF();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    public void sc() {
        com.bytedance.sdk.component.adexpress.TRI.UFX ufx = this.f26877sc;
        if (ufx != null) {
            ufx.sc();
        }
    }
}
