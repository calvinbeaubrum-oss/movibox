package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Dl extends qr implements com.bytedance.sdk.component.adexpress.dynamic.zY {
    private int YIK;
    private int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private int[] f26790sc;

    public Dl(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        super(context, dynamicRootView, qj2);
        dynamicRootView.setTimeOutListener(this);
    }

    private void sc() {
        int iSc = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.UFX, this.Tf.ExN());
        this.pFF = ((this.Qj - iSc) / 2) - this.Tf.sc();
        this.YIK = 0;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.qr, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.OXF
    public boolean Ol() {
        super.Ol();
        ((TextView) this.BT).setText("");
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN
    public void TRI() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f26791qr, this.Qj);
        layoutParams.gravity = 8388629;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (TextUtils.isEmpty(((TextView) this.BT).getText())) {
            setMeasuredDimension(0, this.Qj);
        } else {
            setMeasuredDimension(this.f26791qr, this.Qj);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY
    @SuppressLint({"SetTextI18n"})
    public void sc(CharSequence charSequence, boolean z11, int i11, boolean z12) {
        String strSc = com.bytedance.sdk.component.utils.Sfl.sc(com.bytedance.sdk.component.adexpress.We.sc(), "tt_reward_screen_skip_tx");
        if (i11 == 0) {
            this.BT.setVisibility(0);
            ((TextView) this.BT).setText("| ".concat(String.valueOf(strSc)));
            this.BT.measure(-2, -2);
            this.f26790sc = new int[]{this.BT.getMeasuredWidth() + 1, this.BT.getMeasuredHeight()};
            View view = this.BT;
            int[] iArr = this.f26790sc;
            view.setLayoutParams(new FrameLayout.LayoutParams(iArr[0], iArr[1]));
            ((TextView) this.BT).setGravity(17);
            ((TextView) this.BT).setIncludeFontPadding(false);
            sc();
            this.BT.setPadding(this.Tf.zY(), this.pFF, this.Tf.We(), this.YIK);
        }
        requestLayout();
    }
}
