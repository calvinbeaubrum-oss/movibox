package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class UFX {
    private com.bytedance.sdk.openadsdk.core.ExN.Qj ExN;
    private com.bytedance.sdk.openadsdk.core.widget.Xc We;
    protected Context pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected View f27699sc = ExN();
    private com.bytedance.sdk.openadsdk.core.widget.Ol zY;

    public UFX(Context context) {
        this.pFF = context;
    }

    private View ExN() {
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(this.pFF);
        exN.setGravity(1);
        exN.setOrientation(1);
        com.bytedance.sdk.openadsdk.core.widget.Xc xc2 = new com.bytedance.sdk.openadsdk.core.widget.Xc(this.pFF);
        this.We = xc2;
        xc2.setId(520093745);
        int iZY = kX.zY(this.pFF, 64.0f);
        exN.addView(this.We, new LinearLayout.LayoutParams(iZY, iZY));
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(this.pFF);
        this.ExN = qj2;
        qj2.setId(520093746);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(kX.zY(this.pFF, 219.0f), -2);
        layoutParams.topMargin = kX.zY(this.pFF, 16.0f);
        this.ExN.setLayoutParams(layoutParams);
        this.ExN.setEllipsize(TextUtils.TruncateAt.END);
        this.ExN.setGravity(17);
        this.ExN.setMaxWidth(kX.zY(this.pFF, 150.0f));
        this.ExN.setMaxLines(2);
        this.ExN.setTextColor(-1);
        this.ExN.setTextSize(1, 16.0f);
        exN.addView(this.ExN);
        this.zY = new com.bytedance.sdk.openadsdk.core.widget.Ol(this.pFF);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(kX.zY(this.pFF, 219.0f), kX.zY(this.pFF, 6.0f));
        layoutParams2.topMargin = kX.zY(this.pFF, 32.0f);
        exN.addView(this.zY, layoutParams2);
        return exN;
    }

    public void We() {
        this.f27699sc = null;
        this.pFF = null;
    }

    public com.bytedance.sdk.openadsdk.core.widget.Xc pFF() {
        return this.We;
    }

    public View sc() {
        return this.f27699sc;
    }

    public void sc(int i11) {
        this.zY.setProgress(i11);
    }

    public com.bytedance.sdk.openadsdk.core.ExN.Qj zY() {
        return this.ExN;
    }
}
