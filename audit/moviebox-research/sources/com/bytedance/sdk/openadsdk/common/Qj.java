package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.utils.Sfl;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Qj extends LinearLayout {
    public Qj(Context context) {
        super(context);
        sc();
    }

    private static ImageView sc(Context context, float f11, float f12, float f13, float f14) {
        com.bytedance.sdk.openadsdk.core.ExN.We we2 = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
        we2.setClickable(true);
        we2.setFocusable(true);
        we2.setPadding(kX.zY(context, f13), kX.zY(context, f14), kX.zY(context, f13), kX.zY(context, f14));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(kX.zY(context, 40.0f), kX.zY(context, 44.0f));
        if (f11 > 0.0f) {
            layoutParams.leftMargin = kX.zY(context, f11);
        }
        if (f12 > 0.0f) {
            layoutParams.rightMargin = kX.zY(context, f12);
        }
        we2.setLayoutParams(layoutParams);
        return we2;
    }

    private void sc() {
        Context context = getContext();
        setId(com.bytedance.sdk.openadsdk.utils.SR.mD);
        setLayoutParams(new ViewGroup.LayoutParams(-1, kX.zY(context, 44.5f)));
        setBackgroundColor(-1);
        setClickable(true);
        setFocusable(true);
        setOrientation(1);
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#1F161823"));
        addView(view, new LinearLayout.LayoutParams(-1, kX.zY(context, 0.5f)));
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN.setOrientation(0);
        addView(exN, new LinearLayout.LayoutParams(-1, kX.zY(context, 44.0f)));
        ImageView imageViewSc = sc(context, 16.0f, 0.0f, 14.75f, 12.5f);
        imageViewSc.setId(com.bytedance.sdk.openadsdk.utils.SR.dix);
        imageViewSc.setImageResource(Sfl.We(context, "tt_ad_arrow_backward"));
        exN.addView(imageViewSc);
        View view2 = new View(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 0);
        layoutParams.weight = 1.0f;
        exN.addView(view2, layoutParams);
        ImageView imageViewSc2 = sc(context, 8.0f, 0.0f, 14.75f, 12.5f);
        imageViewSc2.setId(com.bytedance.sdk.openadsdk.utils.SR.IEI);
        imageViewSc2.setImageResource(Sfl.We(context, "tt_ad_arrow_forward"));
        exN.addView(imageViewSc2);
        View view3 = new View(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, 0);
        layoutParams2.weight = 1.0f;
        exN.addView(view3, layoutParams2);
        ImageView imageViewSc3 = sc(context, 8.0f, 0.0f, 10.0f, 12.0f);
        imageViewSc3.setId(com.bytedance.sdk.openadsdk.utils.SR.PPh);
        imageViewSc3.setImageResource(Sfl.We(context, "tt_ad_refresh"));
        exN.addView(imageViewSc3);
        View view4 = new View(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, 0);
        layoutParams3.weight = 1.0f;
        exN.addView(view4, layoutParams3);
        ImageView imageViewSc4 = sc(context, 0.0f, 16.0f, 9.0f, 11.0f);
        imageViewSc4.setId(com.bytedance.sdk.openadsdk.utils.SR.gsl);
        imageViewSc4.setImageResource(Sfl.We(context, "tt_ad_link"));
        exN.addView(imageViewSc4);
    }
}
