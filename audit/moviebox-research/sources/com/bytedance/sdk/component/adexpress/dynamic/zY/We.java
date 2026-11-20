package com.bytedance.sdk.component.adexpress.dynamic.zY;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.TRI.uEA;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We extends Xc<com.bytedance.sdk.component.adexpress.TRI.qr> {
    public We(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN exN, com.bytedance.sdk.component.adexpress.dynamic.We.qr qrVar) {
        super(context, exN, qrVar);
        sc(qrVar);
    }

    private void sc(com.bytedance.sdk.component.adexpress.dynamic.We.qr qrVar) {
        this.f26858sc = new com.bytedance.sdk.component.adexpress.TRI.qr(this.pFF);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.pFF, qrVar.eo());
        this.f26858sc.setLayoutParams(layoutParams);
        this.f26858sc.setSlideText(this.We.OKY());
        uEA uea = this.f26858sc;
        if (uea instanceof com.bytedance.sdk.component.adexpress.TRI.qr) {
            ((com.bytedance.sdk.component.adexpress.TRI.qr) uea).setButtonText(this.We.WH());
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
