package com.bytedance.sdk.component.adexpress.dynamic.zY;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.TRI.uEA;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Xc<E extends uEA> implements qr<E> {
    protected int ExN;
    protected com.bytedance.sdk.component.adexpress.dynamic.We.qr We;
    protected Context pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected uEA f26858sc;
    protected com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN zY;

    public Xc(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN exN, com.bytedance.sdk.component.adexpress.dynamic.We.qr qrVar) {
        this(context, exN, qrVar, 0);
    }

    public Xc(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN exN, com.bytedance.sdk.component.adexpress.dynamic.We.qr qrVar, int i11) {
        this.ExN = i11;
        this.pFF = context;
        this.zY = exN;
        this.We = qrVar;
        We();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    /* JADX INFO: renamed from: ExN, reason: merged with bridge method [inline-methods] */
    public E zY() {
        return (E) this.f26858sc;
    }

    public void We() {
        this.f26858sc = new uEA(this.pFF, this.We.pc());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.pFF, 200.0f));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.pFF, 100 - this.ExN);
        this.f26858sc.setLayoutParams(layoutParams);
        try {
            this.f26858sc.setGuideText(this.We.OKY());
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    public void pFF() {
        this.f26858sc.pFF();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    public void sc() {
        this.f26858sc.sc();
    }
}
