package com.bytedance.adsdk.pFF.zY.zY;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.adsdk.pFF.zY.pFF.dE;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class qr extends sc {
    private final pFF Qj;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final com.bytedance.adsdk.pFF.sc.sc.We f26285qr;

    public qr(com.bytedance.adsdk.pFF.Ol ol2, ExN exN, pFF pff, com.bytedance.adsdk.pFF.qr qrVar) {
        super(ol2, exN);
        this.Qj = pff;
        com.bytedance.adsdk.pFF.sc.sc.We we2 = new com.bytedance.adsdk.pFF.sc.sc.We(ol2, this, new dE("__container", exN.SR(), false), qrVar);
        this.f26285qr = we2;
        we2.sc(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.bytedance.adsdk.pFF.zY.zY.sc
    public com.bytedance.adsdk.pFF.ExN.WH UFX() {
        com.bytedance.adsdk.pFF.ExN.WH whUFX = super.UFX();
        return whUFX != null ? whUFX : this.Qj.UFX();
    }

    @Override // com.bytedance.adsdk.pFF.zY.zY.sc
    public com.bytedance.adsdk.pFF.zY.pFF.sc WH() {
        com.bytedance.adsdk.pFF.zY.pFF.sc scVarWH = super.WH();
        return scVarWH != null ? scVarWH : this.Qj.WH();
    }

    @Override // com.bytedance.adsdk.pFF.zY.zY.sc
    public void pFF(Canvas canvas, Matrix matrix, int i11) {
        super.pFF(canvas, matrix, i11);
        this.f26285qr.sc(canvas, matrix, i11);
    }

    @Override // com.bytedance.adsdk.pFF.zY.zY.sc, com.bytedance.adsdk.pFF.sc.sc.ExN
    public void sc(RectF rectF, Matrix matrix, boolean z11) {
        super.sc(rectF, matrix, z11);
        this.f26285qr.sc(rectF, this.f26287sc, z11);
    }
}
