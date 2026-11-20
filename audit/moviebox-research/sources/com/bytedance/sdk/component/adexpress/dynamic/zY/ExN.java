package com.bytedance.sdk.component.adexpress.dynamic.zY;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.TRI.uEA;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExN extends Xc<com.bytedance.sdk.component.adexpress.TRI.qr> {
    public ExN(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN exN, com.bytedance.sdk.component.adexpress.dynamic.We.qr qrVar) {
        super(context, exN, qrVar);
        sc(qrVar);
    }

    private void sc(com.bytedance.sdk.component.adexpress.dynamic.We.qr qrVar) {
        this.f26858sc = new com.bytedance.sdk.component.adexpress.TRI.Qj(this.pFF);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 81;
        this.f26858sc.setLayoutParams(layoutParams);
        uEA uea = this.f26858sc;
        if (uea instanceof com.bytedance.sdk.component.adexpress.TRI.Qj) {
            ((com.bytedance.sdk.component.adexpress.TRI.Qj) uea).setButtonText(this.We.OKY());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.Xc
    public void We() {
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.Xc, com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    public void pFF() {
        this.f26858sc.pFF();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.Xc, com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    public void sc() {
        this.f26858sc.sc();
    }
}
