package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.widget.FrameLayout;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class uEA extends TRI implements com.bytedance.sdk.component.adexpress.dynamic.zY {
    private int YIK;
    private int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private int f26828sc;

    public uEA(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        super(context, dynamicRootView, qj2);
        setTag(Integer.valueOf(getClickArea()));
        dynamicRootView.setTimeOutListener(this);
        sc();
    }

    private void sc() {
        List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> listUFX = this.Ql.UFX();
        if (listUFX == null || listUFX.size() <= 0) {
            return;
        }
        for (com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2 : listUFX) {
            if (qj2.WH().sc() == 21) {
                this.f26828sc = (int) (this.f26791qr - com.bytedance.sdk.component.adexpress.We.Qj.sc(this.UFX, qj2.Qj()));
            }
            if (qj2.WH().sc() == 20) {
                this.pFF = (int) (this.f26791qr - com.bytedance.sdk.component.adexpress.We.Qj.sc(this.UFX, qj2.Qj()));
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.OXF
    public boolean Ol() {
        setBackground(getBackgroundDrawable());
        setPadding((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(com.bytedance.sdk.component.adexpress.We.sc(), this.Tf.zY()), (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(com.bytedance.sdk.component.adexpress.We.sc(), this.Tf.pFF()), (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(com.bytedance.sdk.component.adexpress.We.sc(), this.Tf.We()), (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(com.bytedance.sdk.component.adexpress.We.sc(), this.Tf.sc()));
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN
    public void TRI() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int i11 = this.Ol;
        layoutParams.leftMargin = i11;
        layoutParams.topMargin = this.WH;
        layoutParams.setMarginStart(i11);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (this.YIK == 0) {
            setMeasuredDimension(this.pFF, this.Qj);
        } else {
            setMeasuredDimension(this.f26828sc, this.Qj);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY
    public void sc(CharSequence charSequence, boolean z11, int i11, boolean z12) {
        this.YIK = i11;
    }
}
