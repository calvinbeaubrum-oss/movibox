package com.bytedance.sdk.openadsdk.Ql;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.widget.Xc;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Qj extends WH {
    public Qj(Context context) {
        this(context, null);
    }

    public Qj(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Qj(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    @Override // com.bytedance.sdk.openadsdk.Ql.WH
    public com.bytedance.sdk.openadsdk.core.ExN.Qj We(Context context) {
        com.bytedance.sdk.openadsdk.core.ExN.Qj qjWe = super.We(context);
        qjWe.setBackground(com.bytedance.sdk.openadsdk.utils.Ol.sc(context, "tt_download_corner_bg"));
        qjWe.setTextSize(2, 15.0f);
        return qjWe;
    }

    @Override // com.bytedance.sdk.openadsdk.Ql.WH
    public com.bytedance.sdk.openadsdk.core.ExN.Qj pFF(Context context) {
        com.bytedance.sdk.openadsdk.core.ExN.Qj qjPFF = super.pFF(context);
        qjPFF.setGravity(16);
        qjPFF.setMaxWidth(kX.zY(context, 250.0f));
        qjPFF.setTextColor(-1);
        qjPFF.setTextSize(2, 17.0f);
        qjPFF.setText("APP NAME");
        return qjPFF;
    }

    @Override // com.bytedance.sdk.openadsdk.Ql.WH
    public void sc(Context context) {
        int iZY = kX.zY(context, 10.0f);
        int iZY2 = kX.zY(context, 16.0f);
        int iZY3 = kX.zY(context, 15.0f);
        int iZY4 = kX.zY(context, 20.0f);
        com.bytedance.sdk.openadsdk.core.ExN.qr qrVar = new com.bytedance.sdk.openadsdk.core.ExN.qr(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        qrVar.setLayoutParams(layoutParams);
        addView(qrVar);
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVarExN = ExN(context);
        this.f27113sc = zYVarExN;
        zYVarExN.setId(com.bytedance.sdk.openadsdk.utils.SR.ymG);
        this.f27113sc.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        qrVar.addView(this.f27113sc);
        com.bytedance.sdk.openadsdk.core.ExN.We weTRI = TRI(context);
        this.pFF = weTRI;
        weTRI.setId(com.bytedance.sdk.openadsdk.utils.SR.HC);
        this.pFF.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        qrVar.addView(this.pFF);
        com.bytedance.sdk.openadsdk.core.ExN.qr qrVar2 = new com.bytedance.sdk.openadsdk.core.ExN.qr(context);
        int i11 = com.bytedance.sdk.openadsdk.utils.SR.mbO;
        qrVar2.setId(i11);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, kX.zY(context, 60.0f));
        layoutParams2.addRule(12);
        layoutParams2.rightMargin = iZY3;
        layoutParams2.leftMargin = iZY3;
        layoutParams2.bottomMargin = iZY3;
        layoutParams2.setMarginEnd(iZY3);
        layoutParams2.setMarginStart(iZY3);
        qrVar2.setBackgroundColor(Color.parseColor("#26000000"));
        qrVar2.setLayoutParams(layoutParams2);
        qrVar.addView(qrVar2);
        Xc xcQr = qr(context);
        this.zY = xcQr;
        int i12 = com.bytedance.sdk.openadsdk.utils.SR.vYl;
        xcQr.setId(i12);
        int iZY5 = kX.zY(context, 50.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iZY5, iZY5);
        layoutParams3.addRule(20);
        layoutParams3.addRule(9);
        layoutParams3.addRule(15);
        this.zY.setLayoutParams(layoutParams3);
        qrVar2.addView(this.zY);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qjPFF = pFF(context);
        this.We = qjPFF;
        qjPFF.setId(com.bytedance.sdk.openadsdk.utils.SR.f28744ds);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(15);
        layoutParams4.leftMargin = iZY4;
        layoutParams4.setMarginStart(iZY4);
        layoutParams4.addRule(1, i12);
        layoutParams4.addRule(17, i12);
        this.We.setLayoutParams(layoutParams4);
        qrVar2.addView(this.We);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qjWe = We(context);
        this.TRI = qjWe;
        qjWe.setId(com.bytedance.sdk.openadsdk.utils.SR.JP);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(kX.zY(context, 100.0f), kX.zY(context, 30.0f));
        layoutParams5.addRule(21);
        layoutParams5.addRule(11);
        layoutParams5.addRule(15);
        layoutParams5.rightMargin = iZY;
        layoutParams5.setMarginEnd(iZY);
        this.TRI.setLayoutParams(layoutParams5);
        qrVar2.addView(this.TRI);
        View viewQj = Qj(context);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(2, i11);
        layoutParams6.leftMargin = iZY2;
        layoutParams6.bottomMargin = iZY;
        viewQj.setLayoutParams(layoutParams6);
        qrVar.addView(viewQj);
    }
}
