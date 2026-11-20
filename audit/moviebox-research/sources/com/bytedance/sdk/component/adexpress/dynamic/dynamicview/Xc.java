package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Xc extends TRI {
    private TextView Dl;
    private LinearLayout JPJ;
    private TextView YIK;
    private TextView pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private TextView f26821sc;
    private TextView uEA;

    public Xc(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        super(context, dynamicRootView, qj2);
        this.f26821sc = new TextView(this.UFX);
        this.pFF = new TextView(this.UFX);
        this.YIK = new TextView(this.UFX);
        this.JPJ = new LinearLayout(this.UFX);
        this.Dl = new TextView(this.UFX);
        this.uEA = new TextView(this.UFX);
        this.f26821sc.setTag(9);
        this.pFF.setTag(10);
        this.YIK.setTag(12);
        this.JPJ.addView(this.YIK);
        this.JPJ.addView(this.uEA);
        this.JPJ.addView(this.pFF);
        this.JPJ.addView(this.Dl);
        this.JPJ.addView(this.f26821sc);
        addView(this.JPJ, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.OXF
    public boolean Ol() {
        this.YIK.setText("Function");
        this.pFF.setText("Permission list");
        this.Dl.setText(" | ");
        this.uEA.setText(" | ");
        this.f26821sc.setText("Privacy policy");
        com.bytedance.sdk.component.adexpress.dynamic.We.qr qrVar = this.Tf;
        if (qrVar != null) {
            this.YIK.setTextColor(qrVar.qr());
            this.YIK.setTextSize(this.Tf.ExN());
            this.pFF.setTextColor(this.Tf.qr());
            this.pFF.setTextSize(this.Tf.ExN());
            this.Dl.setTextColor(this.Tf.qr());
            this.uEA.setTextColor(this.Tf.qr());
            this.f26821sc.setTextColor(this.Tf.qr());
            this.f26821sc.setTextSize(this.Tf.ExN());
            return false;
        }
        this.YIK.setTextColor(-1);
        this.YIK.setTextSize(12.0f);
        this.pFF.setTextColor(-1);
        this.pFF.setTextSize(12.0f);
        this.Dl.setTextColor(-1);
        this.uEA.setTextColor(-1);
        this.f26821sc.setTextColor(-1);
        this.f26821sc.setTextSize(12.0f);
        return false;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN
    public boolean We() {
        this.f26821sc.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.f26821sc.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.pFF.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.pFF.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.YIK.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.YIK.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.f26791qr, this.Qj);
    }
}
