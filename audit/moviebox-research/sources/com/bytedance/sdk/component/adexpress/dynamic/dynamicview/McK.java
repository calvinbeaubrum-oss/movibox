package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class McK extends TRI implements com.bytedance.sdk.component.adexpress.dynamic.zY {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private boolean f26799sc;

    public McK(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        super(context, dynamicRootView, qj2);
        if (dynamicRootView.getRenderRequest() != null) {
            this.f26799sc = dynamicRootView.getRenderRequest().Ql();
        }
        this.f26791qr = this.Qj;
        ImageView imageView = new ImageView(context);
        this.BT = imageView;
        imageView.setTag(Integer.valueOf(getClickArea()));
        addView(this.BT, getWidgetLayoutParams());
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().WP()) {
            return;
        }
        this.BT.setVisibility(8);
        setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.OXF
    public boolean Ol() {
        Drawable drawableZY;
        super.Ol();
        ((ImageView) this.BT).setScaleType(ImageView.ScaleType.CENTER_CROP);
        Drawable drawableSc = com.bytedance.sdk.component.adexpress.We.zY.sc(getContext(), this.Tf);
        if (drawableSc != null) {
            ((ImageView) this.BT).setBackground(drawableSc);
        }
        if (this.f26799sc) {
            drawableZY = com.bytedance.sdk.component.utils.Sfl.zY(getContext(), "tt_close_btn");
        } else {
            drawableZY = com.bytedance.sdk.component.utils.Sfl.zY(getContext(), "tt_skip_btn");
            if (drawableZY != null) {
                drawableZY.setAutoMirrored(true);
            }
        }
        if (drawableZY != null) {
            ((ImageView) this.BT).setImageDrawable(drawableZY);
        }
        setVisibility(8);
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY
    public void sc(CharSequence charSequence, boolean z11, int i11, boolean z12) {
        int i12 = 0;
        if (!z11 && !z12) {
            i12 = 8;
        }
        setVisibility(i12);
    }
}
