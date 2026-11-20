package com.bytedance.adsdk.pFF.sc.pFF;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class WH extends qr<PointF> {
    private final float[] ExN;
    private final PathMeasure TRI;
    private final PointF We;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private Ol f26187qr;

    public WH(List<? extends com.bytedance.adsdk.pFF.qr.sc<PointF>> list) {
        super(list);
        this.We = new PointF();
        this.ExN = new float[2];
        this.TRI = new PathMeasure();
    }

    @Override // com.bytedance.adsdk.pFF.sc.pFF.sc
    /* JADX INFO: renamed from: pFF, reason: merged with bridge method [inline-methods] */
    public PointF sc(com.bytedance.adsdk.pFF.qr.sc<PointF> scVar, float f11) {
        Ol ol2 = (Ol) scVar;
        Path pathPFF = ol2.pFF();
        if (pathPFF == null) {
            return scVar.f26180sc;
        }
        if (this.zY != null) {
            ol2.f26179qr.floatValue();
            We();
            Qj();
            throw null;
        }
        if (this.f26187qr != ol2) {
            this.TRI.setPath(pathPFF, false);
            this.f26187qr = ol2;
        }
        PathMeasure pathMeasure = this.TRI;
        pathMeasure.getPosTan(f11 * pathMeasure.getLength(), this.ExN, null);
        PointF pointF = this.We;
        float[] fArr = this.ExN;
        pointF.set(fArr[0], fArr[1]);
        return this.We;
    }
}
