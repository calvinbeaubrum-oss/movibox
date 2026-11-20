package com.bytedance.sdk.openadsdk.Ql;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.Xc;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY extends WH {
    public zY(Context context) {
        this(context, null);
    }

    public zY(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public zY(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    @Override // com.bytedance.sdk.openadsdk.Ql.WH
    public com.bytedance.sdk.openadsdk.core.ExN.Qj pFF(Context context) {
        com.bytedance.sdk.openadsdk.core.ExN.Qj qjPFF = super.pFF(context);
        qjPFF.setTextColor(-1);
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
        layoutParams.weight = 337.0f;
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
        layoutParams3.weight = 263.0f;
        exN2.setLayoutParams(layoutParams3);
        exN2.setOrientation(1);
        exN2.setGravity(81);
        int iZY2 = kX.zY(context, 16.0f);
        exN2.setPadding(iZY2, iZY2, iZY2, iZY2);
        exN.addView(exN2);
        Xc xcQr = qr(context);
        this.zY = xcQr;
        xcQr.setId(com.bytedance.sdk.openadsdk.utils.SR.vYl);
        int iZY3 = kX.zY(context, 45.0f);
        this.zY.setLayoutParams(new LinearLayout.LayoutParams(iZY3, iZY3));
        exN2.addView(this.zY);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qjPFF = pFF(context);
        this.We = qjPFF;
        qjPFF.setId(com.bytedance.sdk.openadsdk.utils.SR.f28744ds);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = kX.zY(context, 4.0f);
        this.We.setLayoutParams(layoutParams4);
        exN2.addView(this.We);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qjZY = zY(context);
        this.ExN = qjZY;
        qjZY.setId(com.bytedance.sdk.openadsdk.utils.SR.jcs);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.topMargin = iZY;
        layoutParams5.bottomMargin = kX.zY(context, 25.0f);
        this.ExN.setLayoutParams(layoutParams5);
        exN2.addView(this.ExN);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qjWe = We(context);
        this.TRI = qjWe;
        qjWe.setId(com.bytedance.sdk.openadsdk.utils.SR.JP);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, kX.zY(context, 32.0f));
        layoutParams6.topMargin = iZY2;
        this.TRI.setLayoutParams(layoutParams6);
        exN2.addView(this.TRI);
    }
}
