package com.bytedance.sdk.component.adexpress.dynamic.zY;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.TRI.Dl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class dE implements qr {
    private com.bytedance.sdk.component.adexpress.dynamic.We.qr We;
    private Context pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Dl f26859sc;
    private com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN zY;

    public dE(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN exN, com.bytedance.sdk.component.adexpress.dynamic.We.qr qrVar) {
        this.pFF = context;
        this.zY = exN;
        this.We = qrVar;
        We();
    }

    private void We() {
        this.f26859sc = new Dl(this.pFF);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.pFF, 120.0f));
        layoutParams.gravity = 17;
        this.f26859sc.setLayoutParams(layoutParams);
        this.f26859sc.setClipChildren(false);
        this.f26859sc.setGuideText(this.We.OKY());
        com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN exN = this.zY;
        if (exN != null) {
            this.f26859sc.setOnClickListener((View.OnClickListener) exN.getDynamicClickListener());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    public void pFF() {
        Dl dl2 = this.f26859sc;
        if (dl2 != null) {
            dl2.pFF();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    public void sc() {
        Dl dl2 = this.f26859sc;
        if (dl2 != null) {
            dl2.sc();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    public ViewGroup zY() {
        return this.f26859sc;
    }
}
