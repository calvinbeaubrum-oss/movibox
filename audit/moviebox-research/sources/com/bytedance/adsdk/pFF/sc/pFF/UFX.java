package com.bytedance.adsdk.pFF.sc.pFF;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class UFX extends qr<PointF> {
    private final PointF We;

    public UFX(List<com.bytedance.adsdk.pFF.qr.sc<PointF>> list) {
        super(list);
        this.We = new PointF();
    }

    @Override // com.bytedance.adsdk.pFF.sc.pFF.sc
    /* JADX INFO: renamed from: pFF, reason: merged with bridge method [inline-methods] */
    public PointF sc(com.bytedance.adsdk.pFF.qr.sc<PointF> scVar, float f11) {
        return sc(scVar, f11, f11, f11);
    }

    @Override // com.bytedance.adsdk.pFF.sc.pFF.sc
    /* JADX INFO: renamed from: pFF, reason: merged with bridge method [inline-methods] */
    public PointF sc(com.bytedance.adsdk.pFF.qr.sc<PointF> scVar, float f11, float f12, float f13) {
        PointF pointF;
        PointF pointF2 = scVar.f26180sc;
        if (pointF2 == null || (pointF = scVar.pFF) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF3 = pointF2;
        PointF pointF4 = pointF;
        if (this.zY != null) {
            scVar.f26179qr.floatValue();
            We();
            Qj();
            throw null;
        }
        PointF pointF5 = this.We;
        float f14 = pointF3.x;
        float f15 = f14 + (f12 * (pointF4.x - f14));
        float f16 = pointF3.y;
        pointF5.set(f15, f16 + (f13 * (pointF4.y - f16)));
        return this.We;
    }
}
