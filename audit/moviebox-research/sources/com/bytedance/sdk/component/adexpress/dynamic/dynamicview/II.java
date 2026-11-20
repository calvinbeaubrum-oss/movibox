package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class II extends TRI implements com.bytedance.sdk.component.adexpress.dynamic.zY {
    private int Dl;
    private int YIK;
    boolean pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    int f26798sc;
    private boolean uEA;

    public II(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        super(context, dynamicRootView, qj2);
        this.Dl = 0;
        setTag(Integer.valueOf(getClickArea()));
        sc();
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().WP()) {
            return;
        }
        View view = this.BT;
        if (view != null) {
            view.setVisibility(8);
        }
        setVisibility(8);
    }

    private void sc() {
        List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> listUFX = this.Ql.UFX();
        if (listUFX == null || listUFX.size() <= 0) {
            return;
        }
        for (com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2 : listUFX) {
            if (TextUtils.equals("skip-with-time-skip-btn", qj2.WH().pFF())) {
                int iSc = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.UFX, qj2.Qj() + (com.bytedance.sdk.component.adexpress.We.pFF() ? qj2.Ql() : 0));
                this.YIK = iSc;
                this.f26798sc = this.f26791qr - iSc;
                break;
            }
        }
        this.Dl = this.f26791qr - this.f26798sc;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.OXF
    public boolean Ol() {
        if (com.bytedance.sdk.component.adexpress.We.qr.pFF(this.SR.getRenderRequest().We())) {
            return true;
        }
        super.Ol();
        setPadding((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(com.bytedance.sdk.component.adexpress.We.sc(), this.Tf.zY()), (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(com.bytedance.sdk.component.adexpress.We.sc(), this.Tf.pFF()), (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(com.bytedance.sdk.component.adexpress.We.sc(), this.Tf.We()), (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(com.bytedance.sdk.component.adexpress.We.sc(), this.Tf.sc()));
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN
    public void TRI() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.pFF) {
            layoutParams.leftMargin = this.Ol;
        } else {
            layoutParams.leftMargin = this.Ol + this.Dl;
        }
        if (this.uEA && this.Tf != null) {
            layoutParams.leftMargin = ((this.Ol + this.Dl) - ((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(com.bytedance.sdk.component.adexpress.We.sc(), this.Tf.zY()))) - ((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(com.bytedance.sdk.component.adexpress.We.sc(), this.Tf.We()));
        }
        if (com.bytedance.sdk.component.adexpress.We.pFF()) {
            layoutParams.topMargin = this.WH - ((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(com.bytedance.sdk.component.adexpress.We.sc(), this.Tf.pFF()));
        } else {
            layoutParams.topMargin = this.WH;
        }
        layoutParams.setMarginStart(layoutParams.leftMargin);
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
        if (this.uEA && this.Tf != null) {
            setMeasuredDimension(this.YIK + ((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(com.bytedance.sdk.component.adexpress.We.sc(), this.Tf.zY())) + ((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(com.bytedance.sdk.component.adexpress.We.sc(), this.Tf.We())), this.Qj);
        } else if (this.pFF) {
            setMeasuredDimension(this.f26791qr, this.Qj);
        } else {
            setMeasuredDimension(this.f26798sc, this.Qj);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY
    public void sc(CharSequence charSequence, boolean z11, int i11, boolean z12) {
        if (z12 && this.uEA != z12) {
            this.uEA = z12;
            TRI();
            return;
        }
        if (z11 && this.pFF != z11) {
            this.pFF = z11;
            TRI();
        }
        this.pFF = z11;
    }
}
