package com.bytedance.adsdk.pFF.zY.pFF;

import android.graphics.PointF;
import com.bytedance.component.sdk.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class SR {
    private PointF pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final List<com.bytedance.adsdk.pFF.zY.sc> f26240sc;
    private boolean zY;

    public SR() {
        this.f26240sc = new ArrayList();
    }

    public SR(PointF pointF, boolean z11, List<com.bytedance.adsdk.pFF.zY.sc> list) {
        this.pFF = pointF;
        this.zY = z11;
        this.f26240sc = new ArrayList(list);
    }

    public boolean pFF() {
        return this.zY;
    }

    public PointF sc() {
        return this.pFF;
    }

    public void sc(float f11, float f12) {
        if (this.pFF == null) {
            this.pFF = new PointF();
        }
        this.pFF.set(f11, f12);
    }

    public void sc(SR sr2, SR sr3, @FloatRange(from = 0.0d, to = 1.0d) float f11) {
        if (this.pFF == null) {
            this.pFF = new PointF();
        }
        this.zY = sr2.pFF() || sr3.pFF();
        if (sr2.zY().size() != sr3.zY().size()) {
            sr2.zY().size();
            sr3.zY().size();
        }
        int iMin = Math.min(sr2.zY().size(), sr3.zY().size());
        if (this.f26240sc.size() < iMin) {
            for (int size = this.f26240sc.size(); size < iMin; size++) {
                this.f26240sc.add(new com.bytedance.adsdk.pFF.zY.sc());
            }
        } else if (this.f26240sc.size() > iMin) {
            for (int size2 = this.f26240sc.size() - 1; size2 >= iMin; size2--) {
                List<com.bytedance.adsdk.pFF.zY.sc> list = this.f26240sc;
                list.remove(list.size() - 1);
            }
        }
        PointF pointFSc = sr2.sc();
        PointF pointFSc2 = sr3.sc();
        sc(com.bytedance.adsdk.pFF.TRI.ExN.sc(pointFSc.x, pointFSc2.x, f11), com.bytedance.adsdk.pFF.TRI.ExN.sc(pointFSc.y, pointFSc2.y, f11));
        for (int size3 = this.f26240sc.size() - 1; size3 >= 0; size3--) {
            com.bytedance.adsdk.pFF.zY.sc scVar = sr2.zY().get(size3);
            com.bytedance.adsdk.pFF.zY.sc scVar2 = sr3.zY().get(size3);
            PointF pointFSc3 = scVar.sc();
            PointF pointFPFF = scVar.pFF();
            PointF pointFZY = scVar.zY();
            PointF pointFSc4 = scVar2.sc();
            PointF pointFPFF2 = scVar2.pFF();
            PointF pointFZY2 = scVar2.zY();
            this.f26240sc.get(size3).sc(com.bytedance.adsdk.pFF.TRI.ExN.sc(pointFSc3.x, pointFSc4.x, f11), com.bytedance.adsdk.pFF.TRI.ExN.sc(pointFSc3.y, pointFSc4.y, f11));
            this.f26240sc.get(size3).pFF(com.bytedance.adsdk.pFF.TRI.ExN.sc(pointFPFF.x, pointFPFF2.x, f11), com.bytedance.adsdk.pFF.TRI.ExN.sc(pointFPFF.y, pointFPFF2.y, f11));
            this.f26240sc.get(size3).zY(com.bytedance.adsdk.pFF.TRI.ExN.sc(pointFZY.x, pointFZY2.x, f11), com.bytedance.adsdk.pFF.TRI.ExN.sc(pointFZY.y, pointFZY2.y, f11));
        }
    }

    public void sc(boolean z11) {
        this.zY = z11;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f26240sc.size() + "closed=" + this.zY + '}';
    }

    public List<com.bytedance.adsdk.pFF.zY.sc> zY() {
        return this.f26240sc;
    }
}
