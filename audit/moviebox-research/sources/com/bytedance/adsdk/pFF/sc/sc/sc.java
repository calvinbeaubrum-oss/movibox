package com.bytedance.adsdk.pFF.sc.sc;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class sc implements com.bytedance.adsdk.pFF.sc.pFF.sc.InterfaceC0222sc, ExN, UFX {
    private com.bytedance.adsdk.pFF.sc.pFF.sc<ColorFilter, ColorFilter> BT;
    private final com.bytedance.adsdk.pFF.Ol Qj;
    private final List<com.bytedance.adsdk.pFF.sc.pFF.sc<?, Float>> Ql;
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<?, Float> SR;
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<?, Integer> Tf;
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<?, Float> UFX;
    private final float[] WH;
    private com.bytedance.adsdk.pFF.sc.pFF.zY Xc;
    private com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> dE;
    final Paint pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected final com.bytedance.adsdk.pFF.zY.zY.sc f26220sc;
    float zY;
    private final PathMeasure We = new PathMeasure();
    private final Path ExN = new Path();
    private final Path TRI = new Path();

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final RectF f26219qr = new RectF();
    private final List<C0223sc> Ol = new ArrayList();

    /* JADX INFO: renamed from: com.bytedance.adsdk.pFF.sc.sc.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0223sc {
        private final Dl pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final List<Ql> f26221sc;

        private C0223sc(Dl dl2) {
            this.f26221sc = new ArrayList();
            this.pFF = dl2;
        }
    }

    public sc(com.bytedance.adsdk.pFF.Ol ol2, com.bytedance.adsdk.pFF.zY.zY.sc scVar, Paint.Cap cap, Paint.Join join, float f11, com.bytedance.adsdk.pFF.zY.sc.We we2, com.bytedance.adsdk.pFF.zY.sc.pFF pff, List<com.bytedance.adsdk.pFF.zY.sc.pFF> list, com.bytedance.adsdk.pFF.zY.sc.pFF pff2) {
        com.bytedance.adsdk.pFF.sc.sc scVar2 = new com.bytedance.adsdk.pFF.sc.sc(1);
        this.pFF = scVar2;
        this.zY = 0.0f;
        this.Qj = ol2;
        this.f26220sc = scVar;
        scVar2.setStyle(Paint.Style.STROKE);
        scVar2.setStrokeCap(cap);
        scVar2.setStrokeJoin(join);
        scVar2.setStrokeMiter(f11);
        this.Tf = we2.sc();
        this.UFX = pff.sc();
        if (pff2 == null) {
            this.SR = null;
        } else {
            this.SR = pff2.sc();
        }
        this.Ql = new ArrayList(list.size());
        this.WH = new float[list.size()];
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.Ql.add(list.get(i11).sc());
        }
        scVar.sc(this.Tf);
        scVar.sc(this.UFX);
        for (int i12 = 0; i12 < this.Ql.size(); i12++) {
            scVar.sc(this.Ql.get(i12));
        }
        com.bytedance.adsdk.pFF.sc.pFF.sc<?, Float> scVar3 = this.SR;
        if (scVar3 != null) {
            scVar.sc(scVar3);
        }
        this.Tf.sc(this);
        this.UFX.sc(this);
        for (int i13 = 0; i13 < list.size(); i13++) {
            this.Ql.get(i13).sc(this);
        }
        com.bytedance.adsdk.pFF.sc.pFF.sc<?, Float> scVar4 = this.SR;
        if (scVar4 != null) {
            scVar4.sc(this);
        }
        if (scVar.WH() != null) {
            com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> scVarSc = scVar.WH().sc().sc();
            this.dE = scVarSc;
            scVarSc.sc(this);
            scVar.sc(this.dE);
        }
        if (scVar.UFX() != null) {
            this.Xc = new com.bytedance.adsdk.pFF.sc.pFF.zY(this, scVar, scVar.UFX());
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0113  */
    private void sc(Canvas canvas, C0223sc c0223sc, Matrix matrix) {
        float f11;
        float f12;
        float fMin;
        com.bytedance.adsdk.pFF.ExN.sc("StrokeContent#applyTrimPath");
        if (c0223sc.pFF == null) {
            com.bytedance.adsdk.pFF.ExN.pFF("StrokeContent#applyTrimPath");
            return;
        }
        this.ExN.reset();
        for (int size = c0223sc.f26221sc.size() - 1; size >= 0; size--) {
            this.ExN.addPath(((Ql) c0223sc.f26221sc.get(size)).We(), matrix);
        }
        float fFloatValue = c0223sc.pFF.zY().qr().floatValue() / 100.0f;
        float fFloatValue2 = c0223sc.pFF.We().qr().floatValue() / 100.0f;
        float fFloatValue3 = c0223sc.pFF.ExN().qr().floatValue() / 360.0f;
        if (fFloatValue < 0.01f && fFloatValue2 > 0.99f) {
            canvas.drawPath(this.ExN, this.pFF);
            com.bytedance.adsdk.pFF.ExN.pFF("StrokeContent#applyTrimPath");
            return;
        }
        this.We.setPath(this.ExN, false);
        float length = this.We.getLength();
        while (this.We.nextContour()) {
            length += this.We.getLength();
        }
        float f13 = fFloatValue3 * length;
        float f14 = (fFloatValue * length) + f13;
        float fMin2 = Math.min((fFloatValue2 * length) + f13, (f14 + length) - 1.0f);
        float f15 = 0.0f;
        for (int size2 = c0223sc.f26221sc.size() - 1; size2 >= 0; size2--) {
            this.TRI.set(((Ql) c0223sc.f26221sc.get(size2)).We());
            this.TRI.transform(matrix);
            this.We.setPath(this.TRI, false);
            float length2 = this.We.getLength();
            if (fMin2 > length) {
                float f16 = fMin2 - length;
                if (f16 >= f15 + length2 || f15 >= f16) {
                    f11 = f15 + length2;
                    if (f11 < f14 && f15 <= fMin2) {
                        if (f11 > fMin2 || f14 >= f15) {
                            f12 = f14 < f15 ? 0.0f : (f14 - f15) / length2;
                            fMin = fMin2 > f11 ? 1.0f : (fMin2 - f15) / length2;
                        } else {
                            canvas.drawPath(this.TRI, this.pFF);
                        }
                    }
                } else {
                    f12 = f14 > length ? (f14 - length) / length2 : 0.0f;
                    fMin = Math.min(f16 / length2, 1.0f);
                }
                com.bytedance.adsdk.pFF.TRI.TRI.sc(this.TRI, f12, fMin, 0.0f);
                canvas.drawPath(this.TRI, this.pFF);
            } else {
                f11 = f15 + length2;
                if (f11 < f14) {
                }
            }
            f15 += length2;
        }
        com.bytedance.adsdk.pFF.ExN.pFF("StrokeContent#applyTrimPath");
    }

    private void sc(Matrix matrix) {
        com.bytedance.adsdk.pFF.ExN.sc("StrokeContent#applyDashPattern");
        if (this.Ql.isEmpty()) {
            com.bytedance.adsdk.pFF.ExN.pFF("StrokeContent#applyDashPattern");
            return;
        }
        float fSc = com.bytedance.adsdk.pFF.TRI.TRI.sc(matrix);
        for (int i11 = 0; i11 < this.Ql.size(); i11++) {
            this.WH[i11] = this.Ql.get(i11).qr().floatValue();
            if (i11 % 2 == 0) {
                float[] fArr = this.WH;
                if (fArr[i11] < 1.0f) {
                    fArr[i11] = 1.0f;
                }
            } else {
                float[] fArr2 = this.WH;
                if (fArr2[i11] < 0.1f) {
                    fArr2[i11] = 0.1f;
                }
            }
            float[] fArr3 = this.WH;
            fArr3[i11] = fArr3[i11] * fSc;
        }
        com.bytedance.adsdk.pFF.sc.pFF.sc<?, Float> scVar = this.SR;
        this.pFF.setPathEffect(new DashPathEffect(this.WH, scVar == null ? 0.0f : fSc * scVar.qr().floatValue()));
        com.bytedance.adsdk.pFF.ExN.pFF("StrokeContent#applyDashPattern");
    }

    @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.InterfaceC0222sc
    public void sc() {
        this.Qj.invalidateSelf();
    }

    public void sc(Canvas canvas, Matrix matrix, int i11) {
        com.bytedance.adsdk.pFF.ExN.sc("StrokeContent#draw");
        if (com.bytedance.adsdk.pFF.TRI.TRI.pFF(matrix)) {
            com.bytedance.adsdk.pFF.ExN.pFF("StrokeContent#draw");
            return;
        }
        this.pFF.setAlpha(com.bytedance.adsdk.pFF.TRI.ExN.sc((int) ((((i11 / 255.0f) * ((com.bytedance.adsdk.pFF.sc.pFF.TRI) this.Tf).Ol()) / 100.0f) * 255.0f), 0, 255));
        this.pFF.setStrokeWidth(((com.bytedance.adsdk.pFF.sc.pFF.We) this.UFX).Ol() * com.bytedance.adsdk.pFF.TRI.TRI.sc(matrix));
        if (this.pFF.getStrokeWidth() <= 0.0f) {
            com.bytedance.adsdk.pFF.ExN.pFF("StrokeContent#draw");
            return;
        }
        sc(matrix);
        com.bytedance.adsdk.pFF.sc.pFF.sc<ColorFilter, ColorFilter> scVar = this.BT;
        if (scVar != null) {
            this.pFF.setColorFilter(scVar.qr());
        }
        com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> scVar2 = this.dE;
        if (scVar2 != null) {
            float fFloatValue = scVar2.qr().floatValue();
            if (fFloatValue == 0.0f) {
                this.pFF.setMaskFilter(null);
            } else if (fFloatValue != this.zY) {
                this.pFF.setMaskFilter(this.f26220sc.pFF(fFloatValue));
            }
            this.zY = fFloatValue;
        }
        com.bytedance.adsdk.pFF.sc.pFF.zY zYVar = this.Xc;
        if (zYVar != null) {
            zYVar.sc(this.pFF);
        }
        for (int i12 = 0; i12 < this.Ol.size(); i12++) {
            C0223sc c0223sc = this.Ol.get(i12);
            if (c0223sc.pFF != null) {
                sc(canvas, c0223sc, matrix);
            } else {
                com.bytedance.adsdk.pFF.ExN.sc("StrokeContent#buildPath");
                this.ExN.reset();
                for (int size = c0223sc.f26221sc.size() - 1; size >= 0; size--) {
                    this.ExN.addPath(((Ql) c0223sc.f26221sc.get(size)).We(), matrix);
                }
                com.bytedance.adsdk.pFF.ExN.pFF("StrokeContent#buildPath");
                com.bytedance.adsdk.pFF.ExN.sc("StrokeContent#drawPath");
                canvas.drawPath(this.ExN, this.pFF);
                com.bytedance.adsdk.pFF.ExN.pFF("StrokeContent#drawPath");
            }
        }
        com.bytedance.adsdk.pFF.ExN.pFF("StrokeContent#draw");
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.ExN
    public void sc(RectF rectF, Matrix matrix, boolean z11) {
        com.bytedance.adsdk.pFF.ExN.sc("StrokeContent#getBounds");
        this.ExN.reset();
        for (int i11 = 0; i11 < this.Ol.size(); i11++) {
            C0223sc c0223sc = this.Ol.get(i11);
            for (int i12 = 0; i12 < c0223sc.f26221sc.size(); i12++) {
                this.ExN.addPath(((Ql) c0223sc.f26221sc.get(i12)).We(), matrix);
            }
        }
        this.ExN.computeBounds(this.f26219qr, false);
        float fOl = ((com.bytedance.adsdk.pFF.sc.pFF.We) this.UFX).Ol();
        RectF rectF2 = this.f26219qr;
        float f11 = fOl / 2.0f;
        rectF2.set(rectF2.left - f11, rectF2.top - f11, rectF2.right + f11, rectF2.bottom + f11);
        rectF.set(this.f26219qr);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.bytedance.adsdk.pFF.ExN.pFF("StrokeContent#getBounds");
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0055  */
    /* JADX WARN: Code duplicated, block: B:23:0x0059 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x005b  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069 A[SYNTHETIC] */
    @Override // com.bytedance.adsdk.pFF.sc.sc.zY
    public void sc(List<zY> list, List<zY> list2) {
        Dl dl2 = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            zY zYVar = list.get(size);
            if (zYVar instanceof Dl) {
                Dl dl3 = (Dl) zYVar;
                if (dl3.pFF() == com.bytedance.adsdk.pFF.zY.pFF.Sfl.sc.INDIVIDUALLY) {
                    dl2 = dl3;
                }
            }
        }
        if (dl2 != null) {
            dl2.sc(this);
        }
        C0223sc c0223sc = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            zY zYVar2 = list2.get(size2);
            if (zYVar2 instanceof Dl) {
                Dl dl4 = (Dl) zYVar2;
                if (dl4.pFF() == com.bytedance.adsdk.pFF.zY.pFF.Sfl.sc.INDIVIDUALLY) {
                    if (c0223sc != null) {
                        this.Ol.add(c0223sc);
                    }
                    c0223sc = new C0223sc(dl4);
                    dl4.sc(this);
                } else if (!(zYVar2 instanceof Ql)) {
                    if (c0223sc == null) {
                        c0223sc = new C0223sc(dl2);
                    }
                    c0223sc.f26221sc.add((Ql) zYVar2);
                }
            } else if (!(zYVar2 instanceof Ql)) {
                if (c0223sc == null) {
                    c0223sc = new C0223sc(dl2);
                }
                c0223sc.f26221sc.add((Ql) zYVar2);
            }
        }
        if (c0223sc != null) {
            this.Ol.add(c0223sc);
        }
    }
}
