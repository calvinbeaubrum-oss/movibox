package com.bytedance.sdk.openadsdk.Ql;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.Xc;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF extends WH {
    public pFF(Context context) {
        this(context, null);
    }

    public pFF(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public pFF(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    @Override // com.bytedance.sdk.openadsdk.Ql.WH
    public com.bytedance.sdk.openadsdk.core.ExN.Qj pFF(Context context) {
        com.bytedance.sdk.openadsdk.core.ExN.Qj qjPFF = super.pFF(context);
        qjPFF.setTextColor(-1);
        qjPFF.setTextSize(2, 13.0f);
        qjPFF.setText("Pangle");
        return qjPFF;
    }

    @Override // com.bytedance.sdk.openadsdk.Ql.WH
    public void sc(Context context) {
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        exN.setOrientation(1);
        addView(exN);
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVar = new com.bytedance.sdk.openadsdk.core.ExN.zY(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 2.0f;
        zYVar.setLayoutParams(layoutParams);
        exN.addView(zYVar);
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVarExN = ExN(context);
        this.f27113sc = zYVarExN;
        zYVarExN.setId(com.bytedance.sdk.openadsdk.utils.SR.ymG);
        this.f27113sc.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        zYVar.addView(this.f27113sc);
        com.bytedance.sdk.openadsdk.core.ExN.We weTRI = TRI(context);
        this.pFF = weTRI;
        weTRI.setId(com.bytedance.sdk.openadsdk.utils.SR.HC);
        this.pFF.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        zYVar.addView(this.pFF);
        PAGLogoView pAGLogoViewQj = Qj(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 80;
        int iZY = kX.zY(context, 10.0f);
        layoutParams2.leftMargin = iZY;
        layoutParams2.topMargin = iZY;
        layoutParams2.bottomMargin = iZY;
        pAGLogoViewQj.setLayoutParams(layoutParams2);
        zYVar.addView(pAGLogoViewQj);
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN2 = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams3.weight = 1.0f;
        exN2.setLayoutParams(layoutParams3);
        exN2.setOrientation(1);
        exN2.setGravity(81);
        int iZY2 = kX.zY(context, 16.0f);
        exN2.setPadding(iZY2, iZY2, iZY2, iZY2);
        exN.addView(exN2);
        com.bytedance.sdk.openadsdk.core.ExN.qr qrVar = new com.bytedance.sdk.openadsdk.core.ExN.qr(context);
        qrVar.setId(com.bytedance.sdk.openadsdk.utils.SR.hE);
        qrVar.setLayoutParams(new LinearLayout.LayoutParams(-2, kX.zY(context, 40.0f)));
        qrVar.setGravity(17);
        exN2.addView(qrVar);
        Xc xcQr = qr(context);
        this.zY = xcQr;
        xcQr.setId(com.bytedance.sdk.openadsdk.utils.SR.vYl);
        int iZY3 = kX.zY(context, 35.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iZY3, iZY3);
        layoutParams4.addRule(20);
        layoutParams4.addRule(9);
        layoutParams4.addRule(15);
        this.zY.setLayoutParams(layoutParams4);
        qrVar.addView(this.zY);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qjPFF = pFF(context);
        this.We = qjPFF;
        qjPFF.setId(com.bytedance.sdk.openadsdk.utils.SR.f28744ds);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, iZY * 2);
        int iZY4 = kX.zY(context, 6.0f);
        layoutParams5.leftMargin = iZY4;
        layoutParams5.setMarginStart(iZY4);
        layoutParams5.addRule(1, this.zY.getId());
        layoutParams5.addRule(17, this.zY.getId());
        this.We.setLayoutParams(layoutParams5);
        qrVar.addView(this.We);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qjZY = zY(context);
        this.ExN = qjZY;
        qjZY.setId(com.bytedance.sdk.openadsdk.utils.SR.jcs);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, kX.zY(context, 20.0f));
        layoutParams6.addRule(3, this.We.getId());
        layoutParams6.addRule(8, this.zY.getId());
        layoutParams6.addRule(17, this.zY.getId());
        layoutParams6.addRule(1, this.zY.getId());
        layoutParams6.leftMargin = iZY4;
        layoutParams6.setMarginStart(iZY4);
        this.ExN.setLayoutParams(layoutParams6);
        qrVar.addView(this.ExN);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qjWe = We(context);
        this.TRI = qjWe;
        qjWe.setId(com.bytedance.sdk.openadsdk.utils.SR.JP);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, kX.zY(context, 22.0f));
        layoutParams7.topMargin = iZY2;
        this.TRI.setLayoutParams(layoutParams7);
        exN2.addView(this.TRI);
    }

    @Override // com.bytedance.sdk.openadsdk.Ql.WH
    public com.bytedance.sdk.openadsdk.core.ExN.Qj zY(Context context) {
        com.bytedance.sdk.openadsdk.core.ExN.Qj qjZY = super.zY(context);
        qjZY.setTextColor(-1);
        return qjZY;
    }
}
