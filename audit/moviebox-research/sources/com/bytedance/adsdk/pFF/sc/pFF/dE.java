package com.bytedance.adsdk.pFF.sc.pFF;

import android.graphics.Matrix;
import android.graphics.PointF;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class dE {
    private final float[] ExN;
    private sc<Float, Float> Ol;
    private sc<com.bytedance.adsdk.pFF.qr.zY, com.bytedance.adsdk.pFF.qr.zY> Qj;
    private sc<?, Float> Ql;
    private sc<?, Float> SR;
    private sc<PointF, PointF> TRI;
    private We Tf;
    private We UFX;
    private sc<Integer, Integer> WH;
    private final Matrix We;
    private final Matrix pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private sc<?, PointF> f26188qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Matrix f26189sc = new Matrix();
    private final Matrix zY;

    public dE(com.bytedance.adsdk.pFF.zY.sc.Tf tf2) {
        this.TRI = tf2.sc() == null ? null : tf2.sc().sc();
        this.f26188qr = tf2.pFF() == null ? null : tf2.pFF().sc();
        this.Qj = tf2.zY() == null ? null : tf2.zY().sc();
        this.Ol = tf2.We() == null ? null : tf2.We().sc();
        We we2 = tf2.Qj() == null ? null : (We) tf2.Qj().sc();
        this.UFX = we2;
        if (we2 != null) {
            this.pFF = new Matrix();
            this.zY = new Matrix();
            this.We = new Matrix();
            this.ExN = new float[9];
        } else {
            this.pFF = null;
            this.zY = null;
            this.We = null;
            this.ExN = null;
        }
        this.Tf = tf2.Ol() == null ? null : (We) tf2.Ol().sc();
        if (tf2.ExN() != null) {
            this.WH = tf2.ExN().sc();
        }
        if (tf2.TRI() != null) {
            this.Ql = tf2.TRI().sc();
        } else {
            this.Ql = null;
        }
        if (tf2.qr() != null) {
            this.SR = tf2.qr().sc();
        } else {
            this.SR = null;
        }
    }

    private void ExN() {
        for (int i11 = 0; i11 < 9; i11++) {
            this.ExN[i11] = 0.0f;
        }
    }

    public Matrix We() {
        PointF pointFQr;
        PointF pointFQr2;
        this.f26189sc.reset();
        sc<?, PointF> scVar = this.f26188qr;
        if (scVar != null && (pointFQr2 = scVar.qr()) != null) {
            float f11 = pointFQr2.x;
            if (f11 != 0.0f || pointFQr2.y != 0.0f) {
                this.f26189sc.preTranslate(f11, pointFQr2.y);
            }
        }
        sc<Float, Float> scVar2 = this.Ol;
        if (scVar2 != null) {
            float fFloatValue = scVar2 instanceof Xc ? scVar2.qr().floatValue() : ((We) scVar2).Ol();
            if (fFloatValue != 0.0f) {
                this.f26189sc.preRotate(fFloatValue);
            }
        }
        We we2 = this.UFX;
        if (we2 != null) {
            We we3 = this.Tf;
            float fCos = we3 == null ? 0.0f : (float) Math.cos(Math.toRadians((-we3.Ol()) + 90.0f));
            We we4 = this.Tf;
            float fSin = we4 == null ? 1.0f : (float) Math.sin(Math.toRadians((-we4.Ol()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(we2.Ol()));
            ExN();
            float[] fArr = this.ExN;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f12 = -fSin;
            fArr[3] = f12;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.pFF.setValues(fArr);
            ExN();
            float[] fArr2 = this.ExN;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.zY.setValues(fArr2);
            ExN();
            float[] fArr3 = this.ExN;
            fArr3[0] = fCos;
            fArr3[1] = f12;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.We.setValues(fArr3);
            this.zY.preConcat(this.pFF);
            this.We.preConcat(this.zY);
            this.f26189sc.preConcat(this.We);
        }
        sc<com.bytedance.adsdk.pFF.qr.zY, com.bytedance.adsdk.pFF.qr.zY> scVar3 = this.Qj;
        if (scVar3 != null) {
            com.bytedance.adsdk.pFF.qr.zY zYVarQr = scVar3.qr();
            if (zYVarQr.sc() != 1.0f || zYVarQr.pFF() != 1.0f) {
                this.f26189sc.preScale(zYVarQr.sc(), zYVarQr.pFF());
            }
        }
        sc<PointF, PointF> scVar4 = this.TRI;
        if (scVar4 != null && (((pointFQr = scVar4.qr()) != null && pointFQr.x != 0.0f) || pointFQr.y != 0.0f)) {
            this.f26189sc.preTranslate(-pointFQr.x, -pointFQr.y);
        }
        return this.f26189sc;
    }

    public Matrix pFF(float f11) {
        sc<?, PointF> scVar = this.f26188qr;
        PointF pointFQr = scVar == null ? null : scVar.qr();
        sc<com.bytedance.adsdk.pFF.qr.zY, com.bytedance.adsdk.pFF.qr.zY> scVar2 = this.Qj;
        com.bytedance.adsdk.pFF.qr.zY zYVarQr = scVar2 == null ? null : scVar2.qr();
        this.f26189sc.reset();
        if (pointFQr != null) {
            this.f26189sc.preTranslate(pointFQr.x * f11, pointFQr.y * f11);
        }
        if (zYVarQr != null) {
            double d11 = f11;
            this.f26189sc.preScale((float) Math.pow(zYVarQr.sc(), d11), (float) Math.pow(zYVarQr.pFF(), d11));
        }
        sc<Float, Float> scVar3 = this.Ol;
        if (scVar3 != null) {
            float fFloatValue = scVar3.qr().floatValue();
            sc<PointF, PointF> scVar4 = this.TRI;
            PointF pointFQr2 = scVar4 != null ? scVar4.qr() : null;
            this.f26189sc.preRotate(fFloatValue * f11, pointFQr2 == null ? 0.0f : pointFQr2.x, pointFQr2 != null ? pointFQr2.y : 0.0f);
        }
        return this.f26189sc;
    }

    public sc<?, Float> pFF() {
        return this.Ql;
    }

    public sc<?, Integer> sc() {
        return this.WH;
    }

    public void sc(float f11) {
        sc<Integer, Integer> scVar = this.WH;
        if (scVar != null) {
            scVar.sc(f11);
        }
        sc<?, Float> scVar2 = this.Ql;
        if (scVar2 != null) {
            scVar2.sc(f11);
        }
        sc<?, Float> scVar3 = this.SR;
        if (scVar3 != null) {
            scVar3.sc(f11);
        }
        sc<PointF, PointF> scVar4 = this.TRI;
        if (scVar4 != null) {
            scVar4.sc(f11);
        }
        sc<?, PointF> scVar5 = this.f26188qr;
        if (scVar5 != null) {
            scVar5.sc(f11);
        }
        sc<com.bytedance.adsdk.pFF.qr.zY, com.bytedance.adsdk.pFF.qr.zY> scVar6 = this.Qj;
        if (scVar6 != null) {
            scVar6.sc(f11);
        }
        sc<Float, Float> scVar7 = this.Ol;
        if (scVar7 != null) {
            scVar7.sc(f11);
        }
        We we2 = this.UFX;
        if (we2 != null) {
            we2.sc(f11);
        }
        We we3 = this.Tf;
        if (we3 != null) {
            we3.sc(f11);
        }
    }

    public void sc(sc.InterfaceC0222sc interfaceC0222sc) {
        sc<Integer, Integer> scVar = this.WH;
        if (scVar != null) {
            scVar.sc(interfaceC0222sc);
        }
        sc<?, Float> scVar2 = this.Ql;
        if (scVar2 != null) {
            scVar2.sc(interfaceC0222sc);
        }
        sc<?, Float> scVar3 = this.SR;
        if (scVar3 != null) {
            scVar3.sc(interfaceC0222sc);
        }
        sc<PointF, PointF> scVar4 = this.TRI;
        if (scVar4 != null) {
            scVar4.sc(interfaceC0222sc);
        }
        sc<?, PointF> scVar5 = this.f26188qr;
        if (scVar5 != null) {
            scVar5.sc(interfaceC0222sc);
        }
        sc<com.bytedance.adsdk.pFF.qr.zY, com.bytedance.adsdk.pFF.qr.zY> scVar6 = this.Qj;
        if (scVar6 != null) {
            scVar6.sc(interfaceC0222sc);
        }
        sc<Float, Float> scVar7 = this.Ol;
        if (scVar7 != null) {
            scVar7.sc(interfaceC0222sc);
        }
        We we2 = this.UFX;
        if (we2 != null) {
            we2.sc(interfaceC0222sc);
        }
        We we3 = this.Tf;
        if (we3 != null) {
            we3.sc(interfaceC0222sc);
        }
    }

    public void sc(com.bytedance.adsdk.pFF.zY.zY.sc scVar) {
        scVar.sc(this.WH);
        scVar.sc(this.Ql);
        scVar.sc(this.SR);
        scVar.sc(this.TRI);
        scVar.sc(this.f26188qr);
        scVar.sc(this.Qj);
        scVar.sc(this.Ol);
        scVar.sc(this.UFX);
        scVar.sc(this.Tf);
    }

    public sc<?, Float> zY() {
        return this.SR;
    }
}
