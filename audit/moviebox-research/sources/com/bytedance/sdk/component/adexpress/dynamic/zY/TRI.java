package com.bytedance.sdk.component.adexpress.dynamic.zY;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.TRI.YIK;
import com.bytedance.sdk.component.adexpress.TRI.uEA;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TRI extends Xc<com.bytedance.sdk.component.adexpress.TRI.TRI> {
    public TRI(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN exN, com.bytedance.sdk.component.adexpress.dynamic.We.qr qrVar, int i11, int i12, int i13, JSONObject jSONObject) {
        super(context, exN, qrVar);
        this.pFF = context;
        this.We = qrVar;
        this.zY = exN;
        sc(i11, i12, i13, jSONObject, qrVar);
    }

    private void sc(int i11, int i12, int i13, JSONObject jSONObject, com.bytedance.sdk.component.adexpress.dynamic.We.qr qrVar) {
        int iEo;
        this.f26858sc = new com.bytedance.sdk.component.adexpress.TRI.TRI(this.pFF, i11, i12, i13, jSONObject);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.pFF, 300.0f));
        layoutParams.gravity = 81;
        Context context = this.pFF;
        if (qrVar.eo() > 0) {
            iEo = qrVar.eo();
        } else {
            iEo = com.bytedance.sdk.component.adexpress.We.pFF() ? 0 : 120;
        }
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(context, iEo);
        this.f26858sc.setLayoutParams(layoutParams);
        this.f26858sc.setClipChildren(false);
        this.f26858sc.setSlideText(this.We.OKY());
        uEA uea = this.f26858sc;
        if (uea instanceof com.bytedance.sdk.component.adexpress.TRI.TRI) {
            ((com.bytedance.sdk.component.adexpress.TRI.TRI) uea).setShakeText(this.We.ht());
            final YIK shakeView = ((com.bytedance.sdk.component.adexpress.TRI.TRI) this.f26858sc).getShakeView();
            if (shakeView != null) {
                shakeView.setOnShakeViewListener(new com.bytedance.sdk.component.adexpress.TRI.Sfl.sc() { // from class: com.bytedance.sdk.component.adexpress.dynamic.zY.TRI.1
                });
                shakeView.setOnClickListener((View.OnClickListener) this.zY.getDynamicClickListener());
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.Xc
    public void We() {
    }
}
