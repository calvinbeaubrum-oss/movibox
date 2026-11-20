package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class dE extends TRI implements com.bytedance.sdk.component.adexpress.dynamic.pFF {
    public dE(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        super(context, dynamicRootView, qj2);
        ImageView imageView = new ImageView(context);
        this.BT = imageView;
        imageView.setTag(5);
        addView(this.BT, getWidgetLayoutParams());
        dynamicRootView.setMuteListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().WP()) {
            return;
        }
        this.BT.setVisibility(8);
        setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN
    public boolean ExN() {
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.OXF
    public boolean Ol() {
        super.Ol();
        if (com.bytedance.sdk.component.adexpress.We.pFF()) {
            ((ImageView) this.BT).setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            ((ImageView) this.BT).setScaleType(ImageView.ScaleType.CENTER);
        }
        setSoundMute(this.SR.mIsMute);
        if (!com.bytedance.sdk.component.adexpress.We.pFF()) {
            ((ImageView) this.BT).setBackgroundDrawable(com.bytedance.sdk.component.adexpress.We.Ol.sc(0, Integer.valueOf(this.Tf.McK()), new int[]{this.Qj / 2}, null, null, null));
            return true;
        }
        Drawable drawableSc = com.bytedance.sdk.component.adexpress.We.zY.sc(getContext(), this.Tf);
        if (drawableSc == null) {
            return true;
        }
        ((ImageView) this.BT).setBackground(drawableSc);
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.pFF
    public void setSoundMute(boolean z11) {
        int iWe;
        if (com.bytedance.sdk.component.adexpress.We.pFF()) {
            iWe = z11 ? com.bytedance.sdk.component.utils.Sfl.We(getContext(), "tt_reward_full_mute") : com.bytedance.sdk.component.utils.Sfl.We(getContext(), "tt_reward_full_unmute");
        } else {
            iWe = z11 ? com.bytedance.sdk.component.utils.Sfl.We(getContext(), "tt_mute") : com.bytedance.sdk.component.utils.Sfl.We(getContext(), "tt_unmute");
        }
        ((ImageView) this.BT).setImageResource(iWe);
        if (((ImageView) this.BT).getDrawable() != null) {
            ((ImageView) this.BT).getDrawable().setAutoMirrored(true);
        }
    }
}
