package com.bytedance.sdk.component.adexpress.dynamic.zY;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.WP;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class UFX implements qr<ViewGroup> {
    private final FrameLayout pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final com.bytedance.sdk.component.adexpress.TRI.WH f26857sc;

    public UFX(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN exN, com.bytedance.sdk.component.adexpress.dynamic.We.qr qrVar, String str, String str2) {
        com.bytedance.sdk.component.adexpress.TRI.WH wh2 = new com.bytedance.sdk.component.adexpress.TRI.WH(context);
        this.f26857sc = wh2;
        wh2.setImageLottieTosPath(str);
        FrameLayout frameLayout = new FrameLayout(context);
        this.pFF = frameLayout;
        frameLayout.addView(wh2, new FrameLayout.LayoutParams(-2, -2));
        double dBSP = qrVar.bSP();
        dBSP = dBSP == 0.0d ? 1.0d : dBSP;
        double dNQ = qrVar.NQ();
        double d11 = dNQ != 0.0d ? dNQ : 1.0d;
        if ("22".equals(str2)) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(context, 250.0f));
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(context, 120.0f);
            frameLayout.setLayoutParams(layoutParams);
            return;
        }
        if (!"20".equals(str2)) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) (((double) exN.getDynamicWidth()) * 0.32d * dBSP), (int) (((double) exN.getDynamicWidth()) * 0.32d * d11));
            layoutParams2.gravity = 17;
            frameLayout.setLayoutParams(layoutParams2);
        } else {
            sc(context, frameLayout, qrVar);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 81;
            layoutParams3.bottomMargin = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(context, qrVar.eo() > 0 ? qrVar.eo() : com.bytedance.sdk.component.adexpress.We.pFF() ? 0 : 120);
            frameLayout.setLayoutParams(layoutParams3);
            frameLayout.setClipChildren(false);
        }
    }

    private void sc(Context context, FrameLayout frameLayout, com.bytedance.sdk.component.adexpress.dynamic.We.qr qrVar) {
        LinearLayout linearLayout = new LinearLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(0, -WP.sc(context, 5.0f), 0, 0);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setText(context.getString(com.bytedance.sdk.component.utils.Sfl.pFF(context, "tt_splash_brush_mask_title")));
        textView.setTextColor(-1);
        textView.setTextSize(2, 20.0f);
        TextView textView2 = new TextView(context);
        textView2.setId(2097610738);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, WP.sc(context, 5.0f), 0, 0);
        textView2.setLayoutParams(layoutParams2);
        textView2.setText(context.getString(com.bytedance.sdk.component.utils.Sfl.pFF(context, "tt_splash_brush_mask_hint")));
        if (qrVar != null && !TextUtils.isEmpty(qrVar.OKY())) {
            textView2.setText(qrVar.OKY());
        }
        textView2.setTextColor(-1);
        textView2.setTextSize(2, 14.0f);
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        frameLayout.addView(linearLayout);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    public void pFF() {
        this.f26857sc.TRI();
        ViewParent parent = this.pFF.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.pFF);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    public void sc() {
        this.f26857sc.Qj();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    public ViewGroup zY() {
        return this.pFF;
    }
}
