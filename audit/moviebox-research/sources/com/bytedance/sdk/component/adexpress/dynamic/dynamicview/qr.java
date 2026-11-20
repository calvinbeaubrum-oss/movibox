package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class qr extends TRI {
    public qr(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        super(context, dynamicRootView, qj2);
        com.bytedance.sdk.component.adexpress.dynamic.animation.view.sc scVar = new com.bytedance.sdk.component.adexpress.dynamic.animation.view.sc(context);
        this.BT = scVar;
        scVar.setTag(Integer.valueOf(getClickArea()));
        addView(this.BT, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.OXF
    public boolean Ol() {
        super.Ol();
        if (TextUtils.equals("download-progress-button", this.Ql.WH().pFF()) && TextUtils.isEmpty(this.Tf.WH())) {
            this.BT.setVisibility(4);
            return true;
        }
        this.BT.setTextAlignment(this.Tf.Qj());
        ((TextView) this.BT).setText(this.Tf.WH());
        ((TextView) this.BT).setTextColor(this.Tf.qr());
        ((TextView) this.BT).setTextSize(this.Tf.ExN());
        ((TextView) this.BT).setGravity(17);
        ((TextView) this.BT).setIncludeFontPadding(false);
        if ("fillButton".equals(this.Ql.WH().pFF())) {
            this.BT.setPadding(0, 0, 0, 0);
        } else {
            this.BT.setPadding(this.Tf.zY(), this.Tf.pFF(), this.Tf.We(), this.Tf.sc());
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        if (!com.bytedance.sdk.component.adexpress.We.pFF() || !"fillButton".equals(this.Ql.WH().pFF())) {
            return super.getWidgetLayoutParams();
        }
        ((TextView) this.BT).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView) this.BT).setMaxLines(1);
        FrameLayout.LayoutParams widgetLayoutParams = super.getWidgetLayoutParams();
        widgetLayoutParams.width -= this.Tf.wjp() * 2;
        widgetLayoutParams.height -= this.Tf.wjp() * 2;
        widgetLayoutParams.topMargin += this.Tf.wjp();
        int iWjp = widgetLayoutParams.leftMargin + this.Tf.wjp();
        widgetLayoutParams.leftMargin = iWjp;
        widgetLayoutParams.setMarginStart(iWjp);
        widgetLayoutParams.setMarginEnd(widgetLayoutParams.rightMargin);
        return widgetLayoutParams;
    }
}
