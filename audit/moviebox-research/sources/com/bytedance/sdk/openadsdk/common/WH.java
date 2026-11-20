package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.Sfl;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class WH extends RelativeLayout {
    public WH(Context context) {
        super(context);
        sc();
    }

    private void sc() {
        Context context = getContext();
        int iZY = kX.zY(context, 12.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, kX.zY(context, 44.0f)));
        setBackgroundColor(-1);
        com.bytedance.sdk.openadsdk.core.ExN.We we2 = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
        we2.setId(520093720);
        we2.setClickable(true);
        we2.setFocusable(true);
        we2.setImageDrawable(com.bytedance.sdk.openadsdk.utils.Ol.sc(context, "tt_leftbackicon_selector"));
        int iZY2 = kX.zY(context, 24.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iZY2, iZY2);
        layoutParams.leftMargin = iZY;
        layoutParams.addRule(15);
        addView(we2, layoutParams);
        com.bytedance.sdk.openadsdk.core.ExN.We we3 = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
        we3.setId(520093716);
        we3.setClickable(true);
        we3.setFocusable(true);
        we3.setImageDrawable(com.bytedance.sdk.openadsdk.utils.Ol.sc(context, "tt_titlebar_close_seletor"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iZY2, iZY2);
        layoutParams2.leftMargin = iZY;
        layoutParams2.addRule(15);
        layoutParams2.addRule(1, 520093720);
        addView(we3, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ExN.We we4 = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
        int i11 = com.bytedance.sdk.openadsdk.utils.SR.eoh;
        we4.setId(i11);
        we4.setImageDrawable(Sfl.zY(context, "tt_ad_feedback_new"));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iZY2, iZY2);
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        layoutParams3.rightMargin = iZY;
        addView(we4, layoutParams3);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        qj2.setId(com.bytedance.sdk.openadsdk.utils.SR.Mrq);
        qj2.setSingleLine(true);
        qj2.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        qj2.setGravity(17);
        qj2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        qj2.setTextSize(1, 16.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(kX.zY(context, 240.0f), -2);
        layoutParams4.addRule(15);
        layoutParams4.addRule(1, 520093716);
        layoutParams4.addRule(0, i11);
        int iZY3 = kX.zY(context, 25.0f);
        layoutParams4.rightMargin = iZY3;
        layoutParams4.leftMargin = iZY3;
        addView(qj2, layoutParams4);
    }
}
