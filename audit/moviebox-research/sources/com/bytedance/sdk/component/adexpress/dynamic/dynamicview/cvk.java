package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class cvk extends qr implements com.bytedance.sdk.component.adexpress.dynamic.zY {
    private boolean YIK;
    private boolean pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private boolean f26826sc;

    public cvk(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        super(context, dynamicRootView, qj2);
        dynamicRootView.setTimeOutListener(this);
        if ("timedown".equals(qj2.WH().pFF())) {
            dynamicRootView.setTimedown(this.Qj);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.qr, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.OXF
    public boolean Ol() {
        super.Ol();
        if (com.bytedance.sdk.component.adexpress.We.qr.pFF(this.SR.getRenderRequest().We())) {
            setVisibility(8);
        }
        if ("timedown".equals(this.Ql.WH().pFF())) {
            ((TextView) this.BT).setText(String.valueOf((int) Double.parseDouble(this.Tf.WH())));
            return true;
        }
        ((TextView) this.BT).setText(((int) Double.parseDouble(this.Tf.WH())) + "s");
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN
    public void TRI() {
        if (!TextUtils.equals("skip-with-countdowns-video-countdown", this.Ql.WH().pFF()) && !TextUtils.equals("skip-with-time-countdown", this.Ql.WH().pFF())) {
            super.TRI();
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f26791qr, this.Qj);
        layoutParams.gravity = 8388627;
        if (com.bytedance.sdk.component.adexpress.We.pFF()) {
            layoutParams.leftMargin = this.Ol;
        }
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
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
        if (z12 || this.YIK) {
            ((TextView) this.BT).setText("");
            setVisibility(8);
            return;
        }
        try {
            if (Integer.parseInt((String) charSequence) <= 0) {
                setVisibility(8);
                return;
            }
        } catch (Exception unused) {
        }
        setVisibility(0);
        if (!z11 && this.SR.getRenderRequest().sc() && com.bytedance.sdk.component.adexpress.We.qr.pFF(this.SR.getRenderRequest().We())) {
            if (com.bytedance.sdk.component.adexpress.We.pFF()) {
                ((TextView) this.BT).setText(i11 + "s");
            } else {
                ((TextView) this.BT).setText(String.format(com.bytedance.sdk.component.utils.Sfl.sc(com.bytedance.sdk.component.adexpress.We.sc(), "tt_reward_full_skip"), Integer.valueOf(i11)));
            }
            this.f26826sc = true;
            return;
        }
        if (com.bytedance.sdk.component.adexpress.We.pFF() && !"open_ad".equals(this.SR.getRenderRequest().We()) && this.SR.getRenderRequest().sc()) {
            this.YIK = true;
            setVisibility(8);
            return;
        }
        if ("timedown".equals(this.Ql.WH().pFF())) {
            ((TextView) this.BT).setText(charSequence);
            return;
        }
        ((TextView) this.BT).setText(((Object) charSequence) + "s");
        this.pFF = true;
        if (this.f26826sc) {
            CharSequence text = ((TextView) this.BT).getText();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (com.bytedance.sdk.component.adexpress.dynamic.ExN.UFX.pFF(text != null ? text.toString() : "", this.Tf.ExN(), true)[0] + com.bytedance.sdk.component.adexpress.We.Qj.sc(com.bytedance.sdk.component.adexpress.We.sc(), this.Tf.zY() + this.Tf.We())), this.Qj);
            layoutParams.gravity = 8388629;
            this.BT.setLayoutParams(layoutParams);
            this.f26826sc = false;
            requestLayout();
        }
    }
}
