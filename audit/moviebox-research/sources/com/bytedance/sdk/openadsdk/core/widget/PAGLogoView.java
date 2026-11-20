package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class PAGLogoView extends LinearLayout {
    public PAGLogoView(Context context) {
        this(context, null);
    }

    public PAGLogoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PAGLogoView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initView(context);
    }

    @RequiresApi(api = 21)
    public PAGLogoView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        initView(context);
    }

    private void initView(Context context) {
        kX.zY(context, 1.0f);
        int iZY = kX.zY(context, 2.0f);
        com.bytedance.sdk.openadsdk.core.ExN.We we2 = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(kX.zY(context, 14.0f), kX.zY(context, 6.0f));
        layoutParams.leftMargin = iZY;
        we2.setLayoutParams(layoutParams);
        we2.setImageDrawable(com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_ad_logo"));
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams2.leftMargin = iZY;
        layoutParams2.rightMargin = iZY;
        qj2.setLayoutParams(layoutParams2);
        qj2.setText(com.bytedance.sdk.component.utils.Sfl.sc(context, "tt_logo_en"));
        qj2.setTextSize(1, 8.0f);
        qj2.setGravity(17);
        qj2.setTextColor(Color.parseColor("#BFFFFFFF"));
        addView(we2);
        addView(qj2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#26000000"));
        gradientDrawable.setCornerRadius(iZY);
        setBackground(gradientDrawable);
        setGravity(16);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -2;
        layoutParams.height = kX.zY(getContext(), 12.0f);
        super.setLayoutParams(com.bytedance.sdk.openadsdk.core.ExN.Ol.sc(this, layoutParams));
    }
}
