package com.bytedance.adsdk.pFF.sc.sc;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class YIK extends sc {
    private final String ExN;
    private com.bytedance.adsdk.pFF.sc.pFF.sc<ColorFilter, ColorFilter> Qj;
    private final boolean TRI;
    private final com.bytedance.adsdk.pFF.zY.zY.sc We;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<Integer, Integer> f26213qr;

    public YIK(com.bytedance.adsdk.pFF.Ol ol2, com.bytedance.adsdk.pFF.zY.zY.sc scVar, com.bytedance.adsdk.pFF.zY.pFF.wjp wjpVar) {
        super(ol2, scVar, wjpVar.qr().sc(), wjpVar.Qj().sc(), wjpVar.Ol(), wjpVar.zY(), wjpVar.We(), wjpVar.ExN(), wjpVar.TRI());
        this.We = scVar;
        this.ExN = wjpVar.sc();
        this.TRI = wjpVar.WH();
        com.bytedance.adsdk.pFF.sc.pFF.sc<Integer, Integer> scVarSc = wjpVar.pFF().sc();
        this.f26213qr = scVarSc;
        scVarSc.sc(this);
        scVar.sc(scVarSc);
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.sc, com.bytedance.adsdk.pFF.sc.sc.ExN
    public void sc(Canvas canvas, Matrix matrix, int i11) {
        if (this.TRI) {
            return;
        }
        this.pFF.setColor(((com.bytedance.adsdk.pFF.sc.pFF.pFF) this.f26213qr).Ol());
        com.bytedance.adsdk.pFF.sc.pFF.sc<ColorFilter, ColorFilter> scVar = this.Qj;
        if (scVar != null) {
            this.pFF.setColorFilter(scVar.qr());
        }
        super.sc(canvas, matrix, i11);
    }
}
