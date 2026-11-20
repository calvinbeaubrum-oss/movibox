package com.bytedance.sdk.openadsdk.Ql;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Tf extends com.bytedance.sdk.openadsdk.core.ExN.qr {
    public Tf(Context context) {
        this(context, null);
    }

    public Tf(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Tf(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        sc(context);
    }

    private void sc(Context context) {
        setId(com.bytedance.sdk.openadsdk.utils.SR.VZ);
        setVisibility(8);
        setBackgroundColor(Color.parseColor("#7f000000"));
        com.bytedance.sdk.openadsdk.core.ExN.We we2 = new com.bytedance.sdk.openadsdk.core.ExN.We(getContext());
        we2.setId(com.bytedance.sdk.openadsdk.utils.SR.f28755vl);
        we2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        we2.setImageTintMode(PorterDuff.Mode.SRC_OVER);
        we2.setImageTintList(ColorStateList.valueOf(Color.parseColor("#7f000000")));
        we2.setBackgroundColor(Color.parseColor("#7f000000"));
        we2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(we2);
        com.bytedance.sdk.openadsdk.core.ExN.qr qrVar = new com.bytedance.sdk.openadsdk.core.ExN.qr(context);
        qrVar.setId(com.bytedance.sdk.openadsdk.utils.SR.f28745ef);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        qrVar.setLayoutParams(layoutParams);
        addView(qrVar);
        int iZY = kX.zY(context, 44.0f);
        com.bytedance.sdk.openadsdk.core.widget.sc scVar = new com.bytedance.sdk.openadsdk.core.widget.sc(context);
        int i11 = com.bytedance.sdk.openadsdk.utils.SR.qKn;
        scVar.setId(i11);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iZY, iZY);
        layoutParams2.addRule(14);
        scVar.setLayoutParams(layoutParams2);
        scVar.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        qrVar.addView(scVar);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        qj2.setId(com.bytedance.sdk.openadsdk.utils.SR.f28751pc);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iZY, iZY);
        layoutParams3.addRule(8, i11);
        layoutParams3.addRule(19, i11);
        layoutParams3.addRule(5, i11);
        layoutParams3.addRule(7, i11);
        layoutParams3.addRule(18, i11);
        layoutParams3.addRule(6, i11);
        layoutParams3.addRule(14);
        qj2.setLayoutParams(layoutParams3);
        qj2.setBackground(com.bytedance.sdk.openadsdk.utils.Ol.sc(context, "tt_circle_solid_mian"));
        qj2.setGravity(17);
        qj2.setTextColor(-1);
        qj2.setTextSize(2, 19.0f);
        qj2.setTypeface(Typeface.defaultFromStyle(1));
        qj2.setVisibility(8);
        qrVar.addView(qj2);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj3 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        int i12 = com.bytedance.sdk.openadsdk.utils.SR.GI;
        qj3.setId(i12);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(3, i11);
        layoutParams4.addRule(14);
        layoutParams4.topMargin = kX.zY(context, 6.0f);
        qj3.setLayoutParams(layoutParams4);
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        qj3.setEllipsize(truncateAt);
        qj3.setMaxLines(1);
        qj3.setTextColor(-1);
        qj3.setTextSize(2, 12.0f);
        qrVar.addView(qj3);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj4 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        qj4.setId(com.bytedance.sdk.openadsdk.utils.SR.MxZ);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(kX.zY(context, 100.0f), kX.zY(context, 28.0f));
        layoutParams5.addRule(14);
        layoutParams5.addRule(3, i12);
        layoutParams5.topMargin = kX.zY(context, 20.0f);
        qj4.setLayoutParams(layoutParams5);
        qj4.setMinWidth(kX.zY(context, 72.0f));
        qj4.setMaxLines(1);
        qj4.setEllipsize(truncateAt);
        qj4.setTextColor(-1);
        qj4.setTextSize(2, 14.0f);
        qj4.setBackground(com.bytedance.sdk.openadsdk.utils.Ol.sc(context, "tt_ad_cover_btn_begin_bg"));
        qj4.setGravity(17);
        int iZY2 = kX.zY(context, 10.0f);
        int iZY3 = kX.zY(context, 2.0f);
        qj4.setPadding(iZY2, iZY3, iZY2, iZY3);
        qj4.setVisibility(8);
        qrVar.addView(qj4);
    }
}
