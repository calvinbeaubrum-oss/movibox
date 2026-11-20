package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class YIK extends qr implements com.bytedance.sdk.component.adexpress.dynamic.zY {
    public YIK(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        super(context, dynamicRootView, qj2);
        dynamicRootView.setTimeOutListener(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN
    public void TRI() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f26791qr, this.Qj);
        int i11 = this.Ol;
        layoutParams.leftMargin = i11;
        layoutParams.gravity = 16;
        layoutParams.setMarginStart(i11);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.qr, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (TextUtils.isEmpty(((TextView) this.BT).getText())) {
            setMeasuredDimension(0, this.Qj);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY
    public void sc(CharSequence charSequence, boolean z11, int i11, boolean z12) {
        if (i11 != 0) {
            ((TextView) this.BT).setText(" | " + String.format(com.bytedance.sdk.component.utils.Sfl.sc(com.bytedance.sdk.component.adexpress.We.sc(), "tt_reward_full_skip_count_down"), Integer.valueOf(i11)));
        } else if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        requestLayout();
    }
}
