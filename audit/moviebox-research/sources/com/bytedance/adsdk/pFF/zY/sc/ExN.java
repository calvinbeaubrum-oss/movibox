package com.bytedance.adsdk.pFF.zY.sc;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExN implements Ql<PointF, PointF> {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final List<com.bytedance.adsdk.pFF.qr.sc<PointF>> f26263sc;

    public ExN(List<com.bytedance.adsdk.pFF.qr.sc<PointF>> list) {
        this.f26263sc = list;
    }

    @Override // com.bytedance.adsdk.pFF.zY.sc.Ql
    public boolean pFF() {
        return this.f26263sc.size() == 1 && this.f26263sc.get(0).ExN();
    }

    @Override // com.bytedance.adsdk.pFF.zY.sc.Ql
    public com.bytedance.adsdk.pFF.sc.pFF.sc<PointF, PointF> sc() {
        return this.f26263sc.get(0).ExN() ? new com.bytedance.adsdk.pFF.sc.pFF.UFX(this.f26263sc) : new com.bytedance.adsdk.pFF.sc.pFF.WH(this.f26263sc);
    }

    @Override // com.bytedance.adsdk.pFF.zY.sc.Ql
    public List<com.bytedance.adsdk.pFF.qr.sc<PointF>> zY() {
        return this.f26263sc;
    }
}
