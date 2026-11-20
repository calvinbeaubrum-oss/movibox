package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.Sfl;
import com.bytedance.sdk.openadsdk.common.Tf;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.Xc;
import com.bytedance.sdk.openadsdk.utils.SR;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We {
    public static void pFF(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        View zYVar = new zY(context);
        zYVar.setId(SR.Tf);
        zYVar.setVisibility(8);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        frameLayout.addView(zYVar, layoutParams);
        View exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN.setId(SR.Ql);
        exN.setVisibility(8);
        frameLayout.addView(exN, new FrameLayout.LayoutParams(-1, -1));
        View we2 = new com.bytedance.sdk.component.Ol.We(context, true);
        we2.setLayerType(2, null);
        we2.setVisibility(4);
        we2.setId(SR.SR);
        frameLayout.addView(we2, new FrameLayout.LayoutParams(-1, -1));
        View frameLayout2 = new FrameLayout(context);
        frameLayout2.setId(SR.BT);
        frameLayout2.setVisibility(4);
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        View we3 = new com.bytedance.sdk.component.Ol.We(context, true);
        we3.setVisibility(8);
        we3.setId(SR.dE);
        frameLayout.addView(we3, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(new RFEndCardBackUpLayout(context), new FrameLayout.LayoutParams(-1, -1));
    }

    public static void sc(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        com.bytedance.sdk.openadsdk.core.ExN.qr qrVar = new com.bytedance.sdk.openadsdk.core.ExN.qr(context);
        qrVar.setId(SR.FI);
        qrVar.setBackgroundColor(Color.parseColor("#F8F8F8"));
        frameLayout.addView(qrVar, new FrameLayout.LayoutParams(-1, -1));
        View tf2 = new Tf(context);
        tf2.setId(SR.WP);
        qrVar.addView(tf2, new RelativeLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN.setId(SR.cvk);
        exN.setOrientation(1);
        exN.setVisibility(8);
        exN.setGravity(1);
        exN.setId(SR.kX);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        qrVar.addView(exN, layoutParams);
        Xc xc2 = new Xc(context);
        xc2.setId(SR.McK);
        exN.addView(xc2, new LinearLayout.LayoutParams(kX.zY(context, 80.0f), kX.zY(context, 80.0f)));
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        qj2.setId(SR.HJN);
        qj2.setTextColor(Color.parseColor("#161823"));
        qj2.setTextSize(2, 24.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = kX.zY(context, 12.0f);
        exN.addView(qj2, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj3 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        qj3.setId(SR.Gb);
        qj3.setGravity(17);
        qj3.setTextColor(Color.parseColor("#80161823"));
        qj3.setTextSize(2, 16.0f);
        qj3.setTextAlignment(4);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        int iZY = kX.zY(context, 60.0f);
        layoutParams3.leftMargin = iZY;
        layoutParams3.rightMargin = iZY;
        layoutParams3.setMarginStart(iZY);
        layoutParams3.setMarginEnd(layoutParams3.rightMargin);
        layoutParams3.topMargin = kX.zY(context, 8.0f);
        exN.addView(qj3, layoutParams3);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj4 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        qj4.setId(SR.cD);
        qj4.setGravity(17);
        qj4.setTextColor(-1);
        qj4.setText(Sfl.sc(context, "tt_video_mobile_go_detail"));
        qj4.setBackground(com.bytedance.sdk.openadsdk.utils.Ol.sc(context, "tt_reward_video_download_btn_bg"));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(kX.zY(context, 255.0f), kX.zY(context, 44.0f));
        layoutParams4.topMargin = kX.zY(context, 32.0f);
        exN.addView(qj4, layoutParams4);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj5 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        qj5.setId(SR.II);
        qj5.setGravity(17);
        qj5.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        qj5.setText("Sorry,this AD fails to load...");
        qj5.setVisibility(8);
        qj5.setGravity(1);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(13);
        qrVar.addView(qj5, layoutParams5);
        View pAGLogoView = new PAGLogoView(context);
        pAGLogoView.setId(SR.Cb);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, kX.zY(context, 14.0f));
        layoutParams6.addRule(12);
        int iZY2 = kX.zY(context, 16.0f);
        layoutParams6.leftMargin = iZY2;
        layoutParams6.setMarginStart(iZY2);
        layoutParams6.bottomMargin = kX.zY(context, 20.0f);
        qrVar.addView(pAGLogoView, layoutParams6);
    }
}
