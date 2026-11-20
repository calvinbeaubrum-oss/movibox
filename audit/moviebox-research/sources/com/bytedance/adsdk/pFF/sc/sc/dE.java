package com.bytedance.adsdk.pFF.sc.sc;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class dE implements com.bytedance.adsdk.pFF.sc.pFF.sc.InterfaceC0222sc, ExN, Ql, UFX, WH {
    private final String ExN;
    private final com.bytedance.adsdk.pFF.sc.pFF.dE Ol;
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> Qj;
    private final boolean TRI;
    private We WH;
    private final com.bytedance.adsdk.pFF.zY.zY.sc We;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> f26214qr;
    private final com.bytedance.adsdk.pFF.Ol zY;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Matrix f26215sc = new Matrix();
    private final Path pFF = new Path();

    public dE(com.bytedance.adsdk.pFF.Ol ol2, com.bytedance.adsdk.pFF.zY.zY.sc scVar, com.bytedance.adsdk.pFF.zY.pFF.Tf tf2) {
        this.zY = ol2;
        this.We = scVar;
        this.ExN = tf2.sc();
        this.TRI = tf2.ExN();
        com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> scVarSc = tf2.pFF().sc();
        this.f26214qr = scVarSc;
        scVar.sc(scVarSc);
        scVarSc.sc(this);
        com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> scVarSc2 = tf2.zY().sc();
        this.Qj = scVarSc2;
        scVar.sc(scVarSc2);
        scVarSc2.sc(this);
        com.bytedance.adsdk.pFF.sc.pFF.dE dEVarWH = tf2.We().WH();
        this.Ol = dEVarWH;
        dEVarWH.sc(scVar);
        dEVarWH.sc(this);
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.Ql
    public Path We() {
        Path pathWe = this.WH.We();
        this.pFF.reset();
        float fFloatValue = this.f26214qr.qr().floatValue();
        float fFloatValue2 = this.Qj.qr().floatValue();
        for (int i11 = ((int) fFloatValue) - 1; i11 >= 0; i11--) {
            this.f26215sc.set(this.Ol.pFF(i11 + fFloatValue2));
            this.pFF.addPath(pathWe, this.f26215sc);
        }
        return this.pFF;
    }

    @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.InterfaceC0222sc
    public void sc() {
        this.zY.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.ExN
    public void sc(Canvas canvas, Matrix matrix, int i11) {
        float fFloatValue = this.f26214qr.qr().floatValue();
        float fFloatValue2 = this.Qj.qr().floatValue();
        float fFloatValue3 = this.Ol.pFF().qr().floatValue() / 100.0f;
        float fFloatValue4 = this.Ol.zY().qr().floatValue() / 100.0f;
        for (int i12 = ((int) fFloatValue) - 1; i12 >= 0; i12--) {
            this.f26215sc.set(matrix);
            float f11 = i12;
            this.f26215sc.preConcat(this.Ol.pFF(f11 + fFloatValue2));
            this.WH.sc(canvas, this.f26215sc, (int) (i11 * com.bytedance.adsdk.pFF.TRI.ExN.sc(fFloatValue3, fFloatValue4, f11 / fFloatValue)));
        }
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.ExN
    public void sc(RectF rectF, Matrix matrix, boolean z11) {
        this.WH.sc(rectF, matrix, z11);
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.zY
    public void sc(List<zY> list, List<zY> list2) {
        this.WH.sc(list, list2);
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.WH
    public void sc(ListIterator<zY> listIterator) {
        if (this.WH != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.WH = new We(this.zY, this.We, "Repeater", this.TRI, arrayList, null);
    }
}
