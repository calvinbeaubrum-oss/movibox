package com.bytedance.sdk.component.adexpress.dynamic.zY;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class BT implements qr<com.bytedance.sdk.component.adexpress.TRI.Sfl> {
    private String ExN;
    private JSONObject Ol;
    private int Qj;
    private int TRI;
    private com.bytedance.sdk.component.adexpress.dynamic.We.qr We;
    private Context pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private int f26843qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.TRI.Sfl f26844sc;
    private com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN zY;

    public BT(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN exN, com.bytedance.sdk.component.adexpress.dynamic.We.qr qrVar, String str, int i11, int i12, int i13, JSONObject jSONObject) {
        this.pFF = context;
        this.zY = exN;
        this.We = qrVar;
        this.ExN = str;
        this.TRI = i11;
        this.f26843qr = i12;
        this.Qj = i13;
        this.Ol = jSONObject;
        ExN();
    }

    private void ExN() {
        final com.bytedance.sdk.component.adexpress.dynamic.TRI.sc dynamicClickListener = this.zY.getDynamicClickListener();
        try {
            new JSONObject().put("convertActionType", 1);
        } catch (Throwable unused) {
        }
        if ("16".equals(this.ExN)) {
            Context context = this.pFF;
            com.bytedance.sdk.component.adexpress.TRI.Sfl sfl = new com.bytedance.sdk.component.adexpress.TRI.Sfl(context, com.bytedance.sdk.component.adexpress.zY.sc.Qj(context), this.TRI, this.f26843qr, this.Qj, this.Ol);
            this.f26844sc = sfl;
            if (sfl.getShakeLayout() != null) {
                this.f26844sc.getShakeLayout().setOnClickListener((View.OnClickListener) dynamicClickListener);
            }
        } else {
            Context context2 = this.pFF;
            this.f26844sc = new com.bytedance.sdk.component.adexpress.TRI.Sfl(context2, com.bytedance.sdk.component.adexpress.zY.sc.qr(context2), this.TRI, this.f26843qr, this.Qj, this.Ol);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.f26844sc.setGravity(17);
        layoutParams.gravity = 17;
        this.f26844sc.setLayoutParams(layoutParams);
        this.f26844sc.setTranslationY(com.bytedance.sdk.component.adexpress.We.Qj.sc(this.pFF, this.We.kDg()));
        this.f26844sc.setShakeText(this.We.OKY());
        this.f26844sc.setClipChildren(false);
        this.f26844sc.setOnShakeViewListener(new com.bytedance.sdk.component.adexpress.TRI.Sfl.sc() { // from class: com.bytedance.sdk.component.adexpress.dynamic.zY.BT.1
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    /* JADX INFO: renamed from: We, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.adexpress.TRI.Sfl zY() {
        return this.f26844sc;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    public void pFF() {
        this.f26844sc.clearAnimation();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    public void sc() {
        this.f26844sc.sc();
    }
}
