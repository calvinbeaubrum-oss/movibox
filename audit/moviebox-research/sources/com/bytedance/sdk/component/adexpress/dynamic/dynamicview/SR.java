package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.PorterDuff;
import android.widget.ImageView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class SR extends TRI {
    public SR(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        super(context, dynamicRootView, qj2);
        ImageView imageView = new ImageView(context);
        this.BT = imageView;
        imageView.setTag(Integer.valueOf(getClickArea()));
        if (com.bytedance.sdk.component.adexpress.We.pFF()) {
            this.Qj = Math.max(dynamicRootView.getLogoUnionHeight(), this.Qj);
        }
        addView(this.BT, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.OXF
    public boolean Ol() {
        super.Ol();
        if (com.bytedance.sdk.component.adexpress.We.pFF()) {
            ((ImageView) this.BT).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        ((ImageView) this.BT).setImageResource(com.bytedance.sdk.component.utils.Sfl.We(getContext(), "tt_ad_logo"));
        ((ImageView) this.BT).setColorFilter(this.Tf.qr(), PorterDuff.Mode.SRC_IN);
        return true;
    }
}
