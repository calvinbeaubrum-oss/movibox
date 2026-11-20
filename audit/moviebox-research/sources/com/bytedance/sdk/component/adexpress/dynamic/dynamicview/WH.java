package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class WH extends TRI {
    public WH(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        super(context, dynamicRootView, qj2);
        if (com.bytedance.sdk.component.adexpress.We.pFF()) {
            ImageView imageView = new ImageView(context);
            this.BT = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f26791qr = this.Qj;
        } else {
            this.BT = new TextView(context);
        }
        this.BT.setTag(3);
        addView(this.BT, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.BT);
        if (dynamicRootView.getRenderRequest() != null) {
            if (dynamicRootView.getRenderRequest().Qj() && dynamicRootView.getRenderRequest().WP()) {
                return;
            }
            this.BT.setVisibility(8);
            setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.OXF
    public boolean Ol() {
        super.Ol();
        if (com.bytedance.sdk.component.adexpress.We.pFF()) {
            Drawable drawableSc = com.bytedance.sdk.component.adexpress.We.zY.sc(getContext(), this.Tf);
            if (drawableSc != null) {
                ((ImageView) this.BT).setBackground(drawableSc);
            }
            ((ImageView) this.BT).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int iWe = com.bytedance.sdk.component.utils.Sfl.We(getContext(), "tt_reward_full_feedback");
            if (iWe > 0) {
                ((ImageView) this.BT).setImageResource(iWe);
            }
            return true;
        }
        ((TextView) this.BT).setText(getText());
        this.BT.setTextAlignment(this.Tf.Qj());
        ((TextView) this.BT).setTextColor(this.Tf.qr());
        ((TextView) this.BT).setTextSize(this.Tf.ExN());
        this.BT.setBackground(getBackgroundDrawable());
        if (this.Tf.uEA()) {
            int iJPJ = this.Tf.JPJ();
            if (iJPJ > 0) {
                ((TextView) this.BT).setLines(iJPJ);
                ((TextView) this.BT).setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            ((TextView) this.BT).setMaxLines(1);
            ((TextView) this.BT).setGravity(17);
            ((TextView) this.BT).setEllipsize(TextUtils.TruncateAt.END);
        }
        this.BT.setPadding((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(com.bytedance.sdk.component.adexpress.We.sc(), this.Tf.zY()), (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(com.bytedance.sdk.component.adexpress.We.sc(), this.Tf.pFF()), (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(com.bytedance.sdk.component.adexpress.We.sc(), this.Tf.We()), (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(com.bytedance.sdk.component.adexpress.We.sc(), this.Tf.sc()));
        ((TextView) this.BT).setGravity(17);
        return true;
    }

    public String getText() {
        return com.bytedance.sdk.component.utils.Sfl.sc(com.bytedance.sdk.component.adexpress.We.sc(), "tt_reward_feedback");
    }
}
