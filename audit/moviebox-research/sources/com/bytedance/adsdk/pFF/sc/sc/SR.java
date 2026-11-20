package com.bytedance.adsdk.pFF.sc.sc;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class SR implements com.bytedance.adsdk.pFF.sc.pFF.sc.InterfaceC0222sc, Ql, UFX {
    private boolean BT;
    private final boolean ExN;
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<?, Float> Ol;
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<?, PointF> Qj;
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<?, Float> Ql;
    private final boolean TRI;
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<?, Float> Tf;
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<?, Float> UFX;
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<?, Float> WH;
    private final com.bytedance.adsdk.pFF.zY.pFF.WH.sc We;
    private final String pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<?, Float> f26203qr;
    private final com.bytedance.adsdk.pFF.Ol zY;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Path f26204sc = new Path();
    private final pFF SR = new pFF();

    /* JADX INFO: renamed from: com.bytedance.adsdk.pFF.sc.sc.SR$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        static final /* synthetic */ int[] f26205sc;

        static {
            int[] iArr = new int[com.bytedance.adsdk.pFF.zY.pFF.WH.sc.values().length];
            f26205sc = iArr;
            try {
                iArr[com.bytedance.adsdk.pFF.zY.pFF.WH.sc.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26205sc[com.bytedance.adsdk.pFF.zY.pFF.WH.sc.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public SR(com.bytedance.adsdk.pFF.Ol ol2, com.bytedance.adsdk.pFF.zY.zY.sc scVar, com.bytedance.adsdk.pFF.zY.pFF.WH wh2) {
        this.zY = ol2;
        this.pFF = wh2.sc();
        com.bytedance.adsdk.pFF.zY.pFF.WH.sc scVarPFF = wh2.pFF();
        this.We = scVarPFF;
        this.ExN = wh2.WH();
        this.TRI = wh2.UFX();
        com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> scVarSc = wh2.zY().sc();
        this.f26203qr = scVarSc;
        com.bytedance.adsdk.pFF.sc.pFF.sc<PointF, PointF> scVarSc2 = wh2.We().sc();
        this.Qj = scVarSc2;
        com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> scVarSc3 = wh2.ExN().sc();
        this.Ol = scVarSc3;
        com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> scVarSc4 = wh2.qr().sc();
        this.UFX = scVarSc4;
        com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> scVarSc5 = wh2.Ol().sc();
        this.Ql = scVarSc5;
        com.bytedance.adsdk.pFF.zY.pFF.WH.sc scVar2 = com.bytedance.adsdk.pFF.zY.pFF.WH.sc.STAR;
        if (scVarPFF == scVar2) {
            this.WH = wh2.TRI().sc();
            this.Tf = wh2.Qj().sc();
        } else {
            this.WH = null;
            this.Tf = null;
        }
        scVar.sc(scVarSc);
        scVar.sc(scVarSc2);
        scVar.sc(scVarSc3);
        scVar.sc(scVarSc4);
        scVar.sc(scVarSc5);
        if (scVarPFF == scVar2) {
            scVar.sc(this.WH);
            scVar.sc(this.Tf);
        }
        scVarSc.sc(this);
        scVarSc2.sc(this);
        scVarSc3.sc(this);
        scVarSc4.sc(this);
        scVarSc5.sc(this);
        if (scVarPFF == scVar2) {
            this.WH.sc(this);
            this.Tf.sc(this);
        }
    }

    private void ExN() {
        int iFloor = (int) Math.floor(this.f26203qr.qr().floatValue());
        com.bytedance.adsdk.pFF.sc.pFF.sc<?, Float> scVar = this.Ol;
        double radians = Math.toRadians((scVar == null ? 0.0d : scVar.qr().floatValue()) - 90.0d);
        double d11 = iFloor;
        float fFloatValue = this.Ql.qr().floatValue() / 100.0f;
        float fFloatValue2 = this.UFX.qr().floatValue();
        double d12 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d12);
        float fSin = (float) (Math.sin(radians) * d12);
        this.f26204sc.moveTo(fCos, fSin);
        double d13 = (float) (6.283185307179586d / d11);
        double d14 = radians + d13;
        double dCeil = Math.ceil(d11);
        int i11 = 0;
        while (i11 < dCeil) {
            float fCos2 = (float) (Math.cos(d14) * d12);
            double d15 = dCeil;
            float fSin2 = (float) (d12 * Math.sin(d14));
            if (fFloatValue != 0.0f) {
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos3 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                double dAtan3 = (float) (Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                float f11 = fFloatValue2 * fFloatValue * 0.25f;
                this.f26204sc.cubicTo(fCos - (fCos3 * f11), fSin - (fSin3 * f11), fCos2 + (((float) Math.cos(dAtan3)) * f11), fSin2 + (f11 * ((float) Math.sin(dAtan3))), fCos2, fSin2);
            } else {
                this.f26204sc.lineTo(fCos2, fSin2);
            }
            d14 += d13;
            i11++;
            fSin = fSin2;
            fCos = fCos2;
            dCeil = d15;
            d12 = d12;
            d13 = d13;
        }
        PointF pointFQr = this.Qj.qr();
        this.f26204sc.offset(pointFQr.x, pointFQr.y);
        this.f26204sc.close();
    }

    private void pFF() {
        this.BT = false;
        this.zY.invalidateSelf();
    }

    private void zY() {
        float f11;
        float f12;
        double d11;
        float fSin;
        float f13;
        float f14;
        float f15;
        float fFloatValue = this.f26203qr.qr().floatValue();
        com.bytedance.adsdk.pFF.sc.pFF.sc<?, Float> scVar = this.Ol;
        double radians = Math.toRadians((scVar == null ? 0.0d : scVar.qr().floatValue()) - 90.0d);
        double d12 = fFloatValue;
        float f16 = (float) (6.283185307179586d / d12);
        if (this.TRI) {
            f16 *= -1.0f;
        }
        float f17 = f16 / 2.0f;
        float f18 = fFloatValue - ((int) fFloatValue);
        if (f18 != 0.0f) {
            radians += (double) ((1.0f - f18) * f17);
        }
        float fFloatValue2 = this.UFX.qr().floatValue();
        float fFloatValue3 = this.WH.qr().floatValue();
        com.bytedance.adsdk.pFF.sc.pFF.sc<?, Float> scVar2 = this.Tf;
        float fFloatValue4 = scVar2 != null ? scVar2.qr().floatValue() / 100.0f : 0.0f;
        com.bytedance.adsdk.pFF.sc.pFF.sc<?, Float> scVar3 = this.Ql;
        float fFloatValue5 = scVar3 != null ? scVar3.qr().floatValue() / 100.0f : 0.0f;
        if (f18 != 0.0f) {
            f13 = ((fFloatValue2 - fFloatValue3) * f18) + fFloatValue3;
            double d13 = f13;
            float fCos = (float) (d13 * Math.cos(radians));
            fSin = (float) (d13 * Math.sin(radians));
            this.f26204sc.moveTo(fCos, fSin);
            d11 = radians + ((double) ((f16 * f18) / 2.0f));
            f11 = fCos;
            f12 = f17;
        } else {
            double d14 = fFloatValue2;
            float fCos2 = (float) (Math.cos(radians) * d14);
            float fSin2 = (float) (d14 * Math.sin(radians));
            this.f26204sc.moveTo(fCos2, fSin2);
            f11 = fCos2;
            f12 = f17;
            d11 = radians + ((double) f12);
            fSin = fSin2;
            f13 = 0.0f;
        }
        double dCeil = Math.ceil(d12) * 2.0d;
        int i11 = 0;
        float f19 = f12;
        float f21 = f11;
        boolean z11 = false;
        while (true) {
            double d15 = i11;
            if (d15 >= dCeil) {
                PointF pointFQr = this.Qj.qr();
                this.f26204sc.offset(pointFQr.x, pointFQr.y);
                this.f26204sc.close();
                return;
            }
            float f22 = z11 ? fFloatValue2 : fFloatValue3;
            float f23 = (f13 == 0.0f || d15 != dCeil - 2.0d) ? f19 : (f16 * f18) / 2.0f;
            if (f13 == 0.0f || d15 != dCeil - 1.0d) {
                f13 = f22;
            }
            double d16 = f13;
            double d17 = dCeil;
            float fCos3 = (float) (d16 * Math.cos(d11));
            float fSin3 = (float) (d16 * Math.sin(d11));
            if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                this.f26204sc.lineTo(fCos3, fSin3);
                f14 = fFloatValue4;
                f15 = fFloatValue5;
            } else {
                f14 = fFloatValue4;
                double dAtan2 = (float) (Math.atan2(fSin, f21) - 1.5707963267948966d);
                float fCos4 = (float) Math.cos(dAtan2);
                float fSin4 = (float) Math.sin(dAtan2);
                f15 = fFloatValue5;
                double dAtan3 = (float) (Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                float fCos5 = (float) Math.cos(dAtan3);
                float fSin5 = (float) Math.sin(dAtan3);
                float f24 = z11 ? f14 : f15;
                float f25 = z11 ? f15 : f14;
                float f26 = (z11 ? fFloatValue3 : fFloatValue2) * f24 * 0.47829f;
                float f27 = fCos4 * f26;
                float f28 = f26 * fSin4;
                float f29 = (z11 ? fFloatValue2 : fFloatValue3) * f25 * 0.47829f;
                float f31 = fCos5 * f29;
                float f32 = f29 * fSin5;
                if (f18 != 0.0f) {
                    if (i11 == 0) {
                        f27 *= f18;
                        f28 *= f18;
                    } else if (d15 == d17 - 1.0d) {
                        f31 *= f18;
                        f32 *= f18;
                    }
                }
                this.f26204sc.cubicTo(f21 - f27, fSin - f28, fCos3 + f31, fSin3 + f32, fCos3, fSin3);
            }
            d11 += (double) f23;
            z11 = !z11;
            i11++;
            f21 = fCos3;
            fSin = fSin3;
            fFloatValue5 = f15;
            fFloatValue4 = f14;
            f13 = f13;
            f16 = f16;
            dCeil = d17;
        }
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.Ql
    public Path We() {
        if (this.BT) {
            return this.f26204sc;
        }
        this.f26204sc.reset();
        if (this.ExN) {
            this.BT = true;
            return this.f26204sc;
        }
        int i11 = AnonymousClass1.f26205sc[this.We.ordinal()];
        if (i11 == 1) {
            zY();
        } else if (i11 == 2) {
            ExN();
        }
        this.f26204sc.close();
        this.SR.sc(this.f26204sc);
        this.BT = true;
        return this.f26204sc;
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
                    this.SR.sc(dl2);
                    dl2.sc(this);
                }
            }
        }
    }
}
