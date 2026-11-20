package com.bytedance.sdk.component.adexpress.dynamic.zY;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc implements qr {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.TRI.pFF f26861sc;

    public sc(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN exN, com.bytedance.sdk.component.adexpress.dynamic.We.qr qrVar) {
        double dBSP = qrVar.bSP();
        dBSP = dBSP == 0.0d ? 1.0d : dBSP;
        double dNQ = qrVar.NQ();
        double d11 = dNQ != 0.0d ? dNQ : 1.0d;
        int dynamicWidth = (int) (((double) exN.getDynamicWidth()) * 0.32d * dBSP);
        int dynamicWidth2 = (int) (((double) exN.getDynamicWidth()) * 0.32d * d11);
        this.f26861sc = new com.bytedance.sdk.component.adexpress.TRI.pFF(context, dynamicWidth, dynamicWidth2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dynamicWidth, dynamicWidth2);
        layoutParams.gravity = 17;
        layoutParams.topMargin = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(context, qrVar.Bs() - 7);
        layoutParams.leftMargin = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(context, qrVar.YdT() - 3);
        this.f26861sc.setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    public void pFF() {
        this.f26861sc.pFF();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    public void sc() {
        this.f26861sc.sc();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    public ViewGroup zY() {
        return this.f26861sc;
    }
}
