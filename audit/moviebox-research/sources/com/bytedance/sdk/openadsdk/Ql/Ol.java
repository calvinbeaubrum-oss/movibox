package com.bytedance.sdk.openadsdk.Ql;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.widget.Xc;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Ol extends WH {
    public Ol(Context context) {
        this(context, null);
    }

    public Ol(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Ol(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    @Override // com.bytedance.sdk.openadsdk.Ql.WH
    public com.bytedance.sdk.openadsdk.core.ExN.Qj We(Context context) {
        com.bytedance.sdk.openadsdk.core.ExN.Qj qjWe = super.We(context);
        qjWe.setBackground(com.bytedance.sdk.openadsdk.utils.Ol.sc(context, "tt_download_corner_bg"));
        qjWe.setTextSize(2, 14.0f);
        return qjWe;
    }

    @Override // com.bytedance.sdk.openadsdk.Ql.WH
    public com.bytedance.sdk.openadsdk.core.ExN.Qj pFF(Context context) {
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        qj2.setEllipsize(TextUtils.TruncateAt.END);
        qj2.setGravity(16);
        qj2.setMaxWidth(kX.zY(context, 153.0f));
        qj2.setSingleLine();
        qj2.setText("Pangle");
        qj2.setTextColor(-1);
        qj2.setTextSize(2, 14.0f);
        return qj2;
    }

    @Override // com.bytedance.sdk.openadsdk.Ql.WH
    public void sc(Context context) {
        int iZY = kX.zY(context, 10.0f);
        int iZY2 = kX.zY(context, 6.0f);
        int iZY3 = kX.zY(context, 16.0f);
        int iZY4 = kX.zY(context, 15.0f);
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
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, kX.zY(context, 48.0f));
        layoutParams2.addRule(12);
        qrVar2.setLayoutParams(layoutParams2);
        qrVar2.setBackgroundColor(Color.parseColor("#26000000"));
        qrVar2.setGravity(16);
        qrVar2.setPadding(iZY4, 0, 0, 0);
        qrVar.addView(qrVar2);
        Xc xcQr = qr(context);
        this.zY = xcQr;
        int i12 = com.bytedance.sdk.openadsdk.utils.SR.vYl;
        xcQr.setId(i12);
        int iZY5 = kX.zY(context, 40.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iZY5, iZY5);
        layoutParams3.addRule(20);
        layoutParams3.addRule(9);
        layoutParams3.addRule(15);
        layoutParams3.leftMargin = iZY;
        layoutParams3.setMarginStart(iZY);
        this.zY.setLayoutParams(layoutParams3);
        qrVar2.addView(this.zY);
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams4.addRule(17, i12);
        layoutParams4.addRule(1, i12);
        exN.setLayoutParams(layoutParams4);
        exN.setGravity(16);
        exN.setOrientation(1);
        qrVar2.addView(exN);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qjPFF = pFF(context);
        this.We = qjPFF;
        qjPFF.setId(com.bytedance.sdk.openadsdk.utils.SR.f28744ds);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(kX.zY(context, 130.0f), kX.zY(context, 20.0f));
        layoutParams5.leftMargin = iZY2;
        layoutParams5.setMarginStart(iZY2);
        this.We.setLayoutParams(layoutParams5);
        exN.addView(this.We);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qjZY = zY(context);
        this.ExN = qjZY;
        qjZY.setId(com.bytedance.sdk.openadsdk.utils.SR.jcs);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.leftMargin = iZY2;
        layoutParams6.setMarginStart(iZY2);
        this.ExN.setLayoutParams(layoutParams6);
        exN.addView(this.ExN);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qjWe = We(context);
        this.TRI = qjWe;
        qjWe.setId(com.bytedance.sdk.openadsdk.utils.SR.JP);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(kX.zY(context, 80.0f), kX.zY(context, 30.0f));
        layoutParams7.addRule(21);
        layoutParams7.addRule(11);
        layoutParams7.addRule(15);
        layoutParams7.rightMargin = iZY;
        layoutParams7.setMarginEnd(iZY);
        this.TRI.setLayoutParams(layoutParams7);
        qrVar2.addView(this.TRI);
        View viewQj = Qj(context);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(2, i11);
        layoutParams8.leftMargin = iZY3;
        layoutParams8.bottomMargin = iZY;
        viewQj.setLayoutParams(layoutParams8);
        qrVar.addView(viewQj);
    }

    @Override // com.bytedance.sdk.openadsdk.Ql.WH
    public com.bytedance.sdk.openadsdk.core.ExN.Qj zY(Context context) {
        com.bytedance.sdk.openadsdk.core.ExN.Qj qjZY = super.zY(context);
        qjZY.setGravity(16);
        qjZY.setMaxWidth(kX.zY(context, 153.0f));
        qjZY.setTextColor(-1);
        qjZY.setTextSize(2, 13.0f);
        return qjZY;
    }
}
