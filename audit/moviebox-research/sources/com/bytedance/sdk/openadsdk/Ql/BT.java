package com.bytedance.sdk.openadsdk.Ql;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.Sfl;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class BT extends com.bytedance.sdk.openadsdk.core.ExN.qr {
    public BT(Context context) {
        this(context, null);
    }

    public BT(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BT(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        sc(context);
    }

    private void sc(Context context) {
        setId(com.bytedance.sdk.openadsdk.utils.SR.xP);
        setBackgroundColor(Color.parseColor("#00000000"));
        setGravity(16);
        setVisibility(8);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        int i11 = com.bytedance.sdk.openadsdk.utils.SR.Eyy;
        qj2.setId(i11);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        qj2.setLayoutParams(layoutParams);
        qj2.setIncludeFontPadding(false);
        qj2.setText(Sfl.sc(context, "tt_video_without_wifi_tips"));
        qj2.setTextColor(Color.parseColor("#cacaca"));
        qj2.setTextSize(2, 14.0f);
        addView(qj2);
        com.bytedance.sdk.openadsdk.core.ExN.qr qrVar = new com.bytedance.sdk.openadsdk.core.ExN.qr(context);
        qrVar.setId(com.bytedance.sdk.openadsdk.utils.SR.VU);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, i11);
        layoutParams2.addRule(13);
        qrVar.setLayoutParams(layoutParams2);
        addView(qrVar);
        com.bytedance.sdk.openadsdk.core.ExN.We we2 = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
        we2.setId(com.bytedance.sdk.openadsdk.utils.SR.HL);
        int iZY = kX.zY(context, 44.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iZY, iZY);
        layoutParams3.addRule(15);
        we2.setLayoutParams(layoutParams3);
        we2.setImageDrawable(Sfl.zY(context, "tt_new_play_video"));
        we2.setScaleType(ImageView.ScaleType.FIT_XY);
        qrVar.addView(we2);
    }
}
