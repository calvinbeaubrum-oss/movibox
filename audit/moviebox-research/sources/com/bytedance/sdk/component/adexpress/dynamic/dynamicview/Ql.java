package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Ql extends TRI {
    public Ql(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        super(context, dynamicRootView, qj2);
        TextView textView = new TextView(context);
        this.BT = textView;
        textView.setTag(Integer.valueOf(getClickArea()));
        addView(this.BT, getWidgetLayoutParams());
    }

    private boolean sc() {
        if (com.bytedance.sdk.component.adexpress.We.pFF()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.Tf.pFF) && this.Tf.pFF.contains("adx:")) || com.bytedance.sdk.component.adexpress.dynamic.ExN.UFX.pFF();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.OXF
    public boolean Ol() {
        super.Ol();
        this.BT.setTextAlignment(this.Tf.Qj());
        ((TextView) this.BT).setTextColor(this.Tf.qr());
        ((TextView) this.BT).setTextSize(this.Tf.ExN());
        if (com.bytedance.sdk.component.adexpress.We.pFF()) {
            ((TextView) this.BT).setIncludeFontPadding(false);
            ((TextView) this.BT).setTextSize(Math.min(((com.bytedance.sdk.component.adexpress.We.Qj.pFF(com.bytedance.sdk.component.adexpress.We.sc(), this.Qj) - this.Tf.pFF()) - this.Tf.sc()) - 0.5f, this.Tf.ExN()));
            ((TextView) this.BT).setText(com.bytedance.sdk.component.utils.Sfl.sc(getContext(), "tt_logo_en"));
            return true;
        }
        if (!sc()) {
            ((TextView) this.BT).setText(com.bytedance.sdk.component.utils.Sfl.pFF(getContext(), "tt_logo_cn"));
            return true;
        }
        if (com.bytedance.sdk.component.adexpress.dynamic.ExN.UFX.pFF()) {
            ((TextView) this.BT).setText(com.bytedance.sdk.component.adexpress.dynamic.ExN.UFX.sc());
            return true;
        }
        ((TextView) this.BT).setText(com.bytedance.sdk.component.adexpress.dynamic.ExN.UFX.sc(this.Tf.pFF));
        return true;
    }
}
