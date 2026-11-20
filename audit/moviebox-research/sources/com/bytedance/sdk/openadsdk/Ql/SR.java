package com.bytedance.sdk.openadsdk.Ql;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class SR extends com.bytedance.sdk.openadsdk.core.ExN.qr {
    public SR(Context context) {
        this(context, null);
    }

    public SR(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SR(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        sc(context);
    }

    private void sc(Context context) {
        setBackgroundColor(Color.parseColor("#000000"));
        setId(520093726);
        int iZY = kX.zY(context, 60.0f);
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVar = new com.bytedance.sdk.openadsdk.core.ExN.zY(context);
        zYVar.setId(com.bytedance.sdk.openadsdk.utils.SR.f28741ag);
        zYVar.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        zYVar.setBackgroundColor(0);
        addView(zYVar);
        com.bytedance.sdk.openadsdk.core.ExN.We we2 = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
        we2.setId(com.bytedance.sdk.openadsdk.utils.SR.pCa);
        we2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        we2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        zYVar.addView(we2);
        com.bytedance.sdk.openadsdk.core.ExN.TRI tri = new com.bytedance.sdk.openadsdk.core.ExN.TRI(context);
        tri.setId(com.bytedance.sdk.openadsdk.utils.SR.f28743bp);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iZY, iZY);
        layoutParams.gravity = 17;
        tri.setLayoutParams(layoutParams);
        tri.setIndeterminateDrawable(com.bytedance.sdk.openadsdk.utils.Ol.sc(context, "tt_video_loading_progress_bar"));
        zYVar.addView(tri);
        com.bytedance.sdk.openadsdk.core.ExN.We we3 = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
        we3.setId(com.bytedance.sdk.openadsdk.utils.SR.WgX);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        we3.setLayoutParams(layoutParams2);
        we3.setScaleType(ImageView.ScaleType.CENTER);
        we3.setImageDrawable(com.bytedance.sdk.openadsdk.utils.Ol.sc(context, "tt_play_movebar_textpage"));
        we3.setVisibility(8);
        addView(we3);
        View tf2 = new Tf(context);
        tf2.setId(com.bytedance.sdk.openadsdk.utils.SR.VZ);
        tf2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(tf2);
    }
}
