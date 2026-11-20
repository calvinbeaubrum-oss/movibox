package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class HJN extends TRI implements com.bytedance.sdk.component.adexpress.dynamic.zY {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private boolean f26797sc;

    public HJN(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        super(context, dynamicRootView, qj2);
        this.f26791qr = this.Qj;
        ImageView imageView = new ImageView(context);
        this.BT = imageView;
        imageView.setTag(Integer.valueOf(getClickArea()));
        addView(this.BT, getWidgetLayoutParams());
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() != null) {
            if (!dynamicRootView.getRenderRequest().WP()) {
                this.BT.setVisibility(8);
                setVisibility(8);
            }
            this.f26797sc = dynamicRootView.getRenderRequest().Ql();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.OXF
    public boolean Ol() {
        super.Ol();
        View view = this.BT;
        if (view != null) {
            ((ImageView) view).setScaleType(ImageView.ScaleType.CENTER_CROP);
            Drawable drawableSc = com.bytedance.sdk.component.adexpress.We.zY.sc(getContext(), this.Tf);
            if (drawableSc != null) {
                ((ImageView) this.BT).setBackground(drawableSc);
            }
            Drawable drawableZY = this.f26797sc ? com.bytedance.sdk.component.utils.Sfl.zY(getContext(), "tt_close_btn") : com.bytedance.sdk.component.utils.Sfl.zY(getContext(), "tt_skip_btn");
            if (drawableZY != null) {
                drawableZY.setAutoMirrored(true);
                ((ImageView) this.BT).setImageDrawable(drawableZY);
            }
            int iSc = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.UFX, this.Tf.pFF());
            this.BT.setPadding(iSc, iSc, iSc, iSc);
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
