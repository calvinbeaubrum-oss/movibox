package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class BT extends TRI {
    com.bytedance.sdk.component.adexpress.dynamic.We.Qj pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    String f26788sc;

    public BT(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2, String str) {
        super(context, dynamicRootView, qj2);
        this.f26788sc = str;
        this.pFF = qj2;
        com.bytedance.sdk.component.adexpress.TRI.WH lottieView = getLottieView();
        if (lottieView != null) {
            addView(lottieView, getWidgetLayoutParams());
        }
    }

    private com.bytedance.sdk.component.adexpress.TRI.WH getLottieView() {
        com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2 = this.Ql;
        if (qj2 == null || qj2.WH() == null || this.UFX == null || TextUtils.isEmpty(this.f26788sc)) {
            return null;
        }
        com.bytedance.sdk.component.adexpress.dynamic.We.TRI triExN = this.Ql.WH().ExN();
        String strKDg = triExN != null ? triExN.kDg() : "";
        if (TextUtils.isEmpty(strKDg)) {
            return null;
        }
        String str = this.f26788sc + "static/lotties/" + strKDg + ".json";
        com.bytedance.sdk.component.adexpress.TRI.WH wh2 = new com.bytedance.sdk.component.adexpress.TRI.WH(this.UFX);
        wh2.setImageLottieTosPath(str);
        wh2.Qj();
        return wh2;
    }
}
