package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class FI extends TRI {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private int f26796sc;

    public FI(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        super(context, dynamicRootView, qj2);
        this.f26796sc = 0;
        com.bytedance.sdk.component.adexpress.TRI.FI fi2 = new com.bytedance.sdk.component.adexpress.TRI.FI(context, null);
        this.BT = fi2;
        fi2.setTag(Integer.valueOf(getClickArea()));
        addView(this.BT, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.OXF
    public boolean Ol() {
        DynamicRootView dynamicRootView;
        super.Ol();
        double dQl = this.Tf.Ql();
        if (com.bytedance.sdk.component.adexpress.We.pFF() && (dQl < 0.0d || dQl > 5.0d || ((dynamicRootView = this.SR) != null && dynamicRootView.getRenderRequest() != null && this.SR.getRenderRequest().WH() != 4))) {
            this.BT.setVisibility(8);
            return true;
        }
        double d11 = (dQl < 0.0d || dQl > 5.0d) ? 5.0d : dQl;
        this.BT.setVisibility(0);
        ((com.bytedance.sdk.component.adexpress.TRI.FI) this.BT).sc(d11, this.Tf.qr(), (int) this.Tf.ExN(), ((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.UFX, this.Tf.pFF())) + ((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.UFX, this.Tf.sc())) + ((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.UFX, this.Tf.ExN())));
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN
    public void TRI() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f26791qr, this.Qj);
        layoutParams.topMargin = this.WH;
        int i11 = this.Ol + this.f26796sc;
        layoutParams.leftMargin = i11;
        layoutParams.setMarginStart(i11);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        int iSc = (int) ((com.bytedance.sdk.component.adexpress.We.Qj.sc(com.bytedance.sdk.component.adexpress.We.sc(), this.Tf.ExN()) * 5.0f) + com.bytedance.sdk.component.adexpress.We.Qj.sc(com.bytedance.sdk.component.adexpress.We.sc(), this.Tf.zY() + com.bytedance.sdk.component.adexpress.We.Qj.sc(com.bytedance.sdk.component.adexpress.We.sc(), this.Tf.We())));
        if (this.f26791qr > iSc && 4 == this.Tf.Qj()) {
            this.f26796sc = (this.f26791qr - iSc) / 2;
        }
        this.f26791qr = iSc;
        return new FrameLayout.LayoutParams(this.f26791qr, this.Qj);
    }
}
