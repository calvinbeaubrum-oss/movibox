package com.bytedance.sdk.openadsdk.common;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.Sfl;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Ol extends RelativeLayout {
    public Ol(Context context) {
        super(context);
        sc();
    }

    private void sc() {
        setId(com.bytedance.sdk.openadsdk.utils.SR.NQ);
        setBackgroundColor(-1);
        Context context = getContext();
        setLayoutParams(new ViewGroup.LayoutParams(-1, kX.zY(context, 44.0f)));
        com.bytedance.sdk.openadsdk.core.ExN.We we2 = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
        int i11 = com.bytedance.sdk.openadsdk.utils.SR.kDg;
        we2.setId(i11);
        we2.setClickable(true);
        we2.setFocusable(true);
        we2.setPadding(kX.zY(context, 12.0f), kX.zY(context, 14.0f), kX.zY(context, 12.0f), kX.zY(context, 14.0f));
        we2.setImageResource(Sfl.We(context, "tt_ad_xmark"));
        addView(we2, new RelativeLayout.LayoutParams(kX.zY(context, 40.0f), kX.zY(context, 44.0f)));
        com.bytedance.sdk.openadsdk.core.ExN.We we3 = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
        int i12 = com.bytedance.sdk.openadsdk.utils.SR.NP;
        we3.setId(i12);
        we3.setPadding(kX.zY(context, 8.0f), kX.zY(context, 10.0f), kX.zY(context, 8.0f), kX.zY(context, 10.0f));
        we3.setImageResource(Sfl.We(context, "tt_ad_feedback"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(kX.zY(context, 40.0f), kX.zY(context, 44.0f));
        layoutParams.addRule(11);
        addView(we3, layoutParams);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        qj2.setId(com.bytedance.sdk.openadsdk.utils.SR.DNB);
        qj2.setSingleLine(true);
        qj2.setEllipsize(TextUtils.TruncateAt.END);
        qj2.setGravity(17);
        qj2.setTextColor(Color.parseColor("#222222"));
        qj2.setTextSize(2, 17.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(kX.zY(context, 191.0f), kX.zY(context, 24.0f));
        layoutParams2.addRule(15);
        layoutParams2.addRule(0, i12);
        layoutParams2.addRule(1, i11);
        int iZY = kX.zY(context, 10.0f);
        layoutParams2.leftMargin = iZY;
        layoutParams2.rightMargin = iZY;
        addView(qj2, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ExN.TRI tri = new com.bytedance.sdk.openadsdk.core.ExN.TRI(context, null, R.style.Widget.ProgressBar.Horizontal);
        tri.setId(com.bytedance.sdk.openadsdk.utils.SR.otH);
        tri.setProgress(1);
        tri.setProgressDrawable(com.bytedance.sdk.openadsdk.utils.Ol.sc(context, "tt_privacy_progress_style"));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, kX.zY(context, 2.0f));
        layoutParams3.addRule(12);
        addView(tri, layoutParams3);
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#1F161823"));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, kX.zY(context, 0.5f));
        layoutParams4.addRule(12);
        addView(view, layoutParams4);
    }
}
