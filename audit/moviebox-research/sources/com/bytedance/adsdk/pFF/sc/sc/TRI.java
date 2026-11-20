package com.bytedance.adsdk.pFF.sc.sc;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TRI implements com.bytedance.adsdk.pFF.sc.pFF.sc.InterfaceC0222sc, Ql, UFX {
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<?, PointF> ExN;
    private boolean Qj;
    private final com.bytedance.adsdk.pFF.zY.pFF.pFF TRI;
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<?, PointF> We;
    private final String pFF;
    private final com.bytedance.adsdk.pFF.Ol zY;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Path f26207sc = new Path();

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final pFF f26206qr = new pFF();

    public TRI(com.bytedance.adsdk.pFF.Ol ol2, com.bytedance.adsdk.pFF.zY.zY.sc scVar, com.bytedance.adsdk.pFF.zY.pFF.pFF pff) {
        this.pFF = pff.sc();
        this.zY = ol2;
        com.bytedance.adsdk.pFF.sc.pFF.sc<PointF, PointF> scVarSc = pff.zY().sc();
        this.We = scVarSc;
        com.bytedance.adsdk.pFF.sc.pFF.sc<PointF, PointF> scVarSc2 = pff.pFF().sc();
        this.ExN = scVarSc2;
        this.TRI = pff;
        scVar.sc(scVarSc);
        scVar.sc(scVarSc2);
        scVarSc.sc(this);
        scVarSc2.sc(this);
    }

    private void pFF() {
        this.Qj = false;
        this.zY.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.Ql
    public Path We() {
        if (this.Qj) {
            return this.f26207sc;
        }
        this.f26207sc.reset();
        if (this.TRI.ExN()) {
            this.Qj = true;
            return this.f26207sc;
        }
        PointF pointFQr = this.We.qr();
        float f11 = pointFQr.x / 2.0f;
        float f12 = pointFQr.y / 2.0f;
        float f13 = f11 * 0.55228f;
        float f14 = 0.55228f * f12;
        this.f26207sc.reset();
        if (this.TRI.We()) {
            float f15 = -f12;
            this.f26207sc.moveTo(0.0f, f15);
            float f16 = 0.0f - f13;
            float f17 = -f11;
            float f18 = 0.0f - f14;
            this.f26207sc.cubicTo(f16, f15, f17, f18, f17, 0.0f);
            float f19 = f14 + 0.0f;
            this.f26207sc.cubicTo(f17, f19, f16, f12, 0.0f, f12);
            float f21 = f13 + 0.0f;
            this.f26207sc.cubicTo(f21, f12, f11, f19, f11, 0.0f);
            this.f26207sc.cubicTo(f11, f18, f21, f15, 0.0f, f15);
        } else {
            float f22 = -f12;
            this.f26207sc.moveTo(0.0f, f22);
            float f23 = f13 + 0.0f;
            float f24 = 0.0f - f14;
            this.f26207sc.cubicTo(f23, f22, f11, f24, f11, 0.0f);
            float f25 = f14 + 0.0f;
            this.f26207sc.cubicTo(f11, f25, f23, f12, 0.0f, f12);
            float f26 = 0.0f - f13;
            float f27 = -f11;
            this.f26207sc.cubicTo(f26, f12, f27, f25, f27, 0.0f);
            this.f26207sc.cubicTo(f27, f24, f26, f22, 0.0f, f22);
        }
        PointF pointFQr2 = this.ExN.qr();
        this.f26207sc.offset(pointFQr2.x, pointFQr2.y);
        this.f26207sc.close();
        this.f26206qr.sc(this.f26207sc);
        this.Qj = true;
        return this.f26207sc;
    }

    @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.InterfaceC0222sc
    public void sc() {
        pFF();
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.zY
    public void sc(List<zY> list, List<zY> list2) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            zY zYVar = list.get(i11);
            if (zYVar instanceof Dl) {
                Dl dl2 = (Dl) zYVar;
                if (dl2.pFF() == com.bytedance.adsdk.pFF.zY.pFF.Sfl.sc.SIMULTANEOUSLY) {
                    this.f26206qr.sc(dl2);
                    dl2.sc(this);
                }
            }
        }
    }
}
