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
public class We extends WH {
    public We(Context context) {
        this(context, null);
    }

    public We(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public We(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    @Override // com.bytedance.sdk.openadsdk.Ql.WH
    public void sc(Context context) {
        int iZY = kX.zY(context, 10.0f);
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        exN.setLayoutParams(layoutParams);
        layoutParams.gravity = 17;
        exN.setOrientation(1);
        exN.setPadding(iZY, iZY, iZY, iZY);
        addView(exN);
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVar = new com.bytedance.sdk.openadsdk.core.ExN.zY(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 3.0f;
        zYVar.setLayoutParams(layoutParams2);
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
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 80;
        layoutParams3.leftMargin = iZY;
        layoutParams3.topMargin = iZY;
        layoutParams3.bottomMargin = iZY;
        pAGLogoViewQj.setLayoutParams(layoutParams3);
        zYVar.addView(pAGLogoViewQj);
        com.bytedance.sdk.openadsdk.core.ExN.qr qrVar = new com.bytedance.sdk.openadsdk.core.ExN.qr(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams4.weight = 1.0f;
        qrVar.setLayoutParams(layoutParams4);
        exN.addView(qrVar);
        Xc xcQr = qr(context);
        this.zY = xcQr;
        int i11 = com.bytedance.sdk.openadsdk.utils.SR.vYl;
        xcQr.setId(i11);
        int iZY2 = kX.zY(context, 40.0f);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(iZY2, iZY2);
        layoutParams5.addRule(15);
        this.zY.setLayoutParams(layoutParams5);
        qrVar.addView(this.zY);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qjPFF = pFF(context);
        this.We = qjPFF;
        qjPFF.setId(com.bytedance.sdk.openadsdk.utils.SR.f28744ds);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(15);
        layoutParams6.leftMargin = iZY;
        layoutParams6.setMarginStart(iZY);
        layoutParams6.addRule(1, i11);
        layoutParams6.addRule(17, i11);
        this.We.setLayoutParams(layoutParams6);
        qrVar.addView(this.We);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qjWe = We(context);
        this.TRI = qjWe;
        qjWe.setId(com.bytedance.sdk.openadsdk.utils.SR.JP);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(kX.zY(context, 100.0f), kX.zY(context, 32.0f));
        layoutParams7.addRule(11);
        layoutParams7.addRule(21);
        layoutParams7.addRule(15);
        this.TRI.setLayoutParams(layoutParams7);
        qrVar.addView(this.TRI);
    }
}
