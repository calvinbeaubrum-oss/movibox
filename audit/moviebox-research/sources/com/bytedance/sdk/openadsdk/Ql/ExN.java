package com.bytedance.sdk.openadsdk.Ql;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ExN extends WH {
    private com.bytedance.sdk.openadsdk.core.ExN.Qj Qj;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ExN.We f27111qr;

    public ExN(Context context) {
        this(context, null);
    }

    public ExN(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExN(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    public com.bytedance.sdk.openadsdk.core.ExN.Qj getTtBuDescTV() {
        return this.Qj;
    }

    public com.bytedance.sdk.openadsdk.core.ExN.We getTtBuImg() {
        return this.f27111qr;
    }

    @Override // com.bytedance.sdk.openadsdk.Ql.WH
    public void sc(Context context) {
        int iZY = kX.zY(context, 6.0f);
        setPadding(iZY, iZY, iZY, iZY);
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVarExN = ExN(context);
        this.f27113sc = zYVarExN;
        zYVarExN.setId(com.bytedance.sdk.openadsdk.utils.SR.ymG);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        int iZY2 = kX.zY(context, 26.0f);
        layoutParams.topMargin = iZY2;
        this.f27113sc.setLayoutParams(layoutParams);
        addView(this.f27113sc);
        com.bytedance.sdk.openadsdk.core.ExN.We we2 = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
        this.f27111qr = we2;
        we2.setId(com.bytedance.sdk.openadsdk.utils.SR.GOt);
        this.f27111qr.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.topMargin = iZY2;
        this.f27111qr.setLayoutParams(layoutParams2);
        addView(this.f27111qr);
        PAGLogoView pAGLogoViewQj = Qj(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 80;
        int iZY3 = kX.zY(context, 10.0f);
        layoutParams3.leftMargin = iZY3;
        layoutParams3.topMargin = iZY3;
        layoutParams3.bottomMargin = iZY3;
        pAGLogoViewQj.setLayoutParams(layoutParams3);
        addView(pAGLogoViewQj);
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        exN.setOrientation(0);
        exN.setGravity(17);
        addView(exN);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        this.Qj = qj2;
        qj2.setId(com.bytedance.sdk.openadsdk.utils.SR.Pu);
        this.Qj.setEllipsize(TextUtils.TruncateAt.END);
        this.Qj.setMaxLines(1);
        this.Qj.setTextColor(-1);
        this.Qj.setTextSize(2, 12.0f);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2);
        layoutParams4.weight = 1.0f;
        this.Qj.setLayoutParams(layoutParams4);
        exN.addView(this.Qj);
    }
}
