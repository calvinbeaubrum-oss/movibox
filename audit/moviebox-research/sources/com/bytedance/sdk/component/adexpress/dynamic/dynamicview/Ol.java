package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Ol extends TRI {
    public Ol(Context context, @NonNull DynamicRootView dynamicRootView, @NonNull com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        super(context, dynamicRootView, qj2);
        if (com.bytedance.sdk.component.adexpress.We.pFF()) {
            this.BT = new ImageView(context);
        } else {
            this.BT = new com.bytedance.sdk.component.adexpress.TRI.Ol(context);
        }
        this.BT.setTag(3);
        addView(this.BT, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.BT);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.OXF
    public boolean Ol() {
        super.Ol();
        if (com.bytedance.sdk.component.adexpress.We.pFF()) {
            Drawable drawableSc = com.bytedance.sdk.component.adexpress.We.zY.sc(getContext(), this.Tf);
            if (drawableSc != null) {
                this.BT.setBackground(drawableSc);
            }
            int iWe = com.bytedance.sdk.component.utils.Sfl.We(getContext(), "tt_close_btn");
            if (iWe > 0) {
                ((ImageView) this.BT).setImageResource(iWe);
            }
            ((ImageView) this.BT).setScaleType(ImageView.ScaleType.FIT_XY);
            return true;
        }
        int iSc = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.UFX, this.Tf.Xc());
        View view = this.BT;
        if (view instanceof com.bytedance.sdk.component.adexpress.TRI.Ol) {
            ((com.bytedance.sdk.component.adexpress.TRI.Ol) view).setRadius((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.UFX, this.Tf.BT()));
            ((com.bytedance.sdk.component.adexpress.TRI.Ol) this.BT).setStrokeWidth(iSc);
            ((com.bytedance.sdk.component.adexpress.TRI.Ol) this.BT).setStrokeColor(this.Tf.dE());
            ((com.bytedance.sdk.component.adexpress.TRI.Ol) this.BT).setBgColor(this.Tf.McK());
            ((com.bytedance.sdk.component.adexpress.TRI.Ol) this.BT).setDislikeColor(this.Tf.qr());
            ((com.bytedance.sdk.component.adexpress.TRI.Ol) this.BT).setDislikeWidth((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.UFX, 1.0f));
        }
        return true;
    }
}
