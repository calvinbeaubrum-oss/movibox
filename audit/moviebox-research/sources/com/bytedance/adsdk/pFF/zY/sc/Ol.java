package com.bytedance.adsdk.pFF.zY.sc;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Ol implements Ql<PointF, PointF> {
    private final pFF pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final pFF f26264sc;

    public Ol(pFF pff, pFF pff2) {
        this.f26264sc = pff;
        this.pFF = pff2;
    }

    @Override // com.bytedance.adsdk.pFF.zY.sc.Ql
    public boolean pFF() {
        return this.f26264sc.pFF() && this.pFF.pFF();
    }

    @Override // com.bytedance.adsdk.pFF.zY.sc.Ql
    public com.bytedance.adsdk.pFF.sc.pFF.sc<PointF, PointF> sc() {
        return new com.bytedance.adsdk.pFF.sc.pFF.SR(this.f26264sc.sc(), this.pFF.sc());
    }

    @Override // com.bytedance.adsdk.pFF.zY.sc.Ql
    public List<com.bytedance.adsdk.pFF.qr.sc<PointF>> zY() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }
}
