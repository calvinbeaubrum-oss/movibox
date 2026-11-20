package com.bytedance.adsdk.pFF.sc.pFF;

import android.graphics.Path;
import android.graphics.PointF;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Ol extends com.bytedance.adsdk.pFF.qr.sc<PointF> {
    private final com.bytedance.adsdk.pFF.qr.sc<PointF> UFX;
    private Path WH;

    public Ol(com.bytedance.adsdk.pFF.qr qrVar, com.bytedance.adsdk.pFF.qr.sc<PointF> scVar) {
        super(qrVar, scVar.f26180sc, scVar.pFF, scVar.zY, scVar.We, scVar.ExN, scVar.TRI, scVar.f26179qr);
        this.UFX = scVar;
        sc();
    }

    public Path pFF() {
        return this.WH;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void sc() {
        T t11;
        T t12;
        T t13 = this.pFF;
        boolean z11 = (t13 == 0 || (t12 = this.f26180sc) == 0 || !((PointF) t12).equals(((PointF) t13).x, ((PointF) t13).y)) ? false : true;
        T t14 = this.f26180sc;
        if (t14 == 0 || (t11 = this.pFF) == 0 || z11) {
            return;
        }
        com.bytedance.adsdk.pFF.qr.sc<PointF> scVar = this.UFX;
        this.WH = com.bytedance.adsdk.pFF.TRI.TRI.sc((PointF) t14, (PointF) t11, scVar.Qj, scVar.Ol);
    }
}
