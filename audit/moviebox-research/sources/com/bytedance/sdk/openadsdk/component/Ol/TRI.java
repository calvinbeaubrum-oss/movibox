package com.bytedance.sdk.openadsdk.component.Ol;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.Xc;
import com.bytedance.sdk.openadsdk.core.widget.dE;
import com.bytedance.sdk.openadsdk.utils.Ol;
import com.bytedance.sdk.openadsdk.utils.SR;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TRI extends zY {
    private final com.bytedance.sdk.openadsdk.core.ExN.ExN Ql;
    private final dE SR;

    public TRI(Context context) {
        super(context);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setBackground(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor("#EDFCFF"), Color.parseColor("#FFF6FD")}));
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        this.Ql = exN;
        exN.setId(520093758);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = kX.zY(context, 24.0f);
        layoutParams.topMargin = kX.zY(context, 56.0f);
        exN.setLayoutParams(layoutParams);
        exN.setClickable(false);
        exN.setGravity(16);
        exN.setOrientation(0);
        Xc xc2 = new Xc(context);
        this.TRI = xc2;
        xc2.setId(520093759);
        this.TRI.setLayoutParams(new LinearLayout.LayoutParams(kX.zY(context, 24.0f), kX.zY(context, 24.0f)));
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        this.f27747qr = qj2;
        qj2.setId(520093761);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = kX.zY(context, 8.0f);
        this.f27747qr.setLayoutParams(layoutParams2);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj3 = this.f27747qr;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        qj3.setEllipsize(truncateAt);
        this.f27747qr.setMaxLines(2);
        this.f27747qr.setTextColor(Color.parseColor("#161823"));
        this.f27747qr.setTextSize(12.0f);
        com.bytedance.sdk.openadsdk.core.ExN.qr qrVar = new com.bytedance.sdk.openadsdk.core.ExN.qr(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(kX.zY(context, 327.0f), -2);
        layoutParams3.addRule(13);
        layoutParams3.leftMargin = kX.zY(context, 24.0f);
        layoutParams3.rightMargin = kX.zY(context, 24.0f);
        qrVar.setLayoutParams(layoutParams3);
        Xc xc3 = new Xc(context);
        this.Ol = xc3;
        int i11 = SR.coa;
        xc3.setId(i11);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(kX.zY(context, 80.0f), kX.zY(context, 80.0f));
        layoutParams4.addRule(14);
        this.Ol.setLayoutParams(layoutParams4);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj4 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        this.WH = qj4;
        int i12 = SR.LVf;
        qj4.setId(i12);
        this.WH.setTextSize(24.0f);
        this.WH.setTextColor(Color.parseColor("#161823"));
        this.WH.setGravity(17);
        this.WH.setMaxLines(1);
        this.WH.setEllipsize(truncateAt);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(3, i11);
        layoutParams5.topMargin = kX.zY(context, 12.0f);
        layoutParams5.addRule(14);
        this.WH.setLayoutParams(layoutParams5);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj5 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        this.UFX = qj5;
        int i13 = SR.Qy;
        qj5.setId(i13);
        this.UFX.setTextSize(16.0f);
        this.UFX.setTextColor(Color.parseColor("#80161823"));
        this.UFX.setGravity(17);
        this.UFX.setMaxLines(2);
        this.UFX.setEllipsize(truncateAt);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams6.addRule(3, i12);
        layoutParams6.topMargin = kX.zY(context, 4.0f);
        layoutParams6.addRule(14);
        this.UFX.setLayoutParams(layoutParams6);
        dE dEVar = new dE(context);
        this.SR = dEVar;
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(14);
        layoutParams7.topMargin = kX.zY(context, 12.0f);
        dEVar.setLayoutParams(layoutParams7);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj6 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        this.ExN = qj6;
        qj6.setId(520093717);
        this.ExN.setBackground(Ol.sc(context, "tt_reward_full_video_backup_btn_bg"));
        this.ExN.setEllipsize(truncateAt);
        this.ExN.setLines(1);
        this.ExN.setGravity(17);
        this.ExN.setTextColor(-1);
        this.ExN.setTextSize(16.0f);
        this.ExN.setTag("open_ad_click_button_tag");
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, kX.zY(context, 44.0f));
        layoutParams8.addRule(3, i13);
        layoutParams8.topMargin = kX.zY(context, 54.0f);
        layoutParams8.addRule(14);
        this.ExN.setLayoutParams(layoutParams8);
        PAGLogoView pAGLogoView = new PAGLogoView(context);
        this.We = pAGLogoView;
        pAGLogoView.setId(520093757);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, kX.zY(context, 14.0f));
        layoutParams9.leftMargin = kX.zY(context, 16.0f);
        layoutParams9.bottomMargin = kX.zY(context, 24.0f);
        layoutParams9.addRule(12);
        this.We.setLayoutParams(layoutParams9);
        addView(this.Qj);
        exN.addView(this.TRI);
        exN.addView(this.f27747qr);
        addView(exN);
        qrVar.addView(this.Ol);
        qrVar.addView(this.WH);
        qrVar.addView(this.UFX);
        qrVar.addView(dEVar);
        qrVar.addView(this.ExN);
        addView(qrVar);
        addView(this.We);
    }

    @Override // com.bytedance.sdk.openadsdk.component.Ol.zY
    public com.bytedance.sdk.openadsdk.core.ExN.We getAdIconView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.Ol.zY
    public com.bytedance.sdk.openadsdk.core.ExN.Qj getAdTitleTextView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.Ol.zY
    public dE getScoreBar() {
        return this.SR;
    }

    @Override // com.bytedance.sdk.openadsdk.component.Ol.zY
    public View getUserInfo() {
        return this.Ql;
    }
}
