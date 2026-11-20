package com.bytedance.sdk.component.adexpress.dynamic.zY;

import android.content.Context;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class SR implements qr<com.bytedance.sdk.component.adexpress.TRI.dE> {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.TRI.dE f26852sc;

    public SR(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN exN, com.bytedance.sdk.component.adexpress.dynamic.We.qr qrVar) {
        this.f26852sc = new com.bytedance.sdk.component.adexpress.TRI.dE(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(context, 180.0f), (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(context, 180.0f));
        layoutParams.gravity = 17;
        layoutParams.leftMargin = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(context, 20.0f);
        this.f26852sc.setLayoutParams(layoutParams);
        this.f26852sc.setGuideText(qrVar.OKY());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    /* JADX INFO: renamed from: We, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.adexpress.TRI.dE zY() {
        return this.f26852sc;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    public void pFF() {
        this.f26852sc.pFF();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    public void sc() {
        this.f26852sc.sc();
    }
}
