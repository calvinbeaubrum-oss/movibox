package com.bytedance.adsdk.pFF.zY.zY;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.pFF.sc.pFF.dE;
import com.bytedance.adsdk.pFF.zY.pFF.SR;
import com.bytedance.component.sdk.annotation.FloatRange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class sc implements com.bytedance.adsdk.pFF.sc.pFF.sc.InterfaceC0222sc, com.bytedance.adsdk.pFF.sc.sc.ExN {
    private final RectF BT;
    private com.bytedance.adsdk.pFF.sc.pFF.Qj Dl;
    float ExN;
    private sc FI;
    private final Matrix Gb;
    private Paint HJN;
    private boolean II;
    private sc JPJ;
    private boolean McK;
    private final Paint Ql;
    private final Paint SR;
    private final RectF Sfl;
    BlurMaskFilter TRI;
    private final Paint Tf;
    private final Paint UFX;
    private List<sc> WP;
    final dE We;
    private final RectF Xc;
    private final String YIK;
    private float cD;
    private final List<com.bytedance.adsdk.pFF.sc.pFF.sc<?, ?>> cvk;
    private final RectF dE;
    final com.bytedance.adsdk.pFF.Ol pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    final Matrix f26287sc;
    private com.bytedance.adsdk.pFF.sc.pFF.We uEA;
    private final RectF wjp;
    final ExN zY;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final Path f26286qr = new Path();
    private final Matrix Qj = new Matrix();
    private final Matrix Ol = new Matrix();
    private final Paint WH = new com.bytedance.adsdk.pFF.sc.sc(1);

    /* JADX INFO: renamed from: com.bytedance.adsdk.pFF.zY.zY.sc$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        static final /* synthetic */ int[] f26289sc;

        static {
            int[] iArr = new int[com.bytedance.adsdk.pFF.zY.pFF.Qj.sc.values().length];
            pFF = iArr;
            try {
                iArr[com.bytedance.adsdk.pFF.zY.pFF.Qj.sc.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                pFF[com.bytedance.adsdk.pFF.zY.pFF.Qj.sc.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                pFF[com.bytedance.adsdk.pFF.zY.pFF.Qj.sc.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                pFF[com.bytedance.adsdk.pFF.zY.pFF.Qj.sc.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ExN.sc.values().length];
            f26289sc = iArr2;
            try {
                iArr2[ExN.sc.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f26289sc[ExN.sc.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f26289sc[ExN.sc.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f26289sc[ExN.sc.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f26289sc[ExN.sc.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f26289sc[ExN.sc.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f26289sc[ExN.sc.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public sc(com.bytedance.adsdk.pFF.Ol ol2, ExN exN) {
        PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
        this.UFX = new com.bytedance.adsdk.pFF.sc.sc(1, mode);
        PorterDuff.Mode mode2 = PorterDuff.Mode.DST_OUT;
        this.Tf = new com.bytedance.adsdk.pFF.sc.sc(1, mode2);
        com.bytedance.adsdk.pFF.sc.sc scVar = new com.bytedance.adsdk.pFF.sc.sc(1);
        this.Ql = scVar;
        this.SR = new com.bytedance.adsdk.pFF.sc.sc(PorterDuff.Mode.CLEAR);
        this.BT = new RectF();
        this.dE = new RectF();
        this.Xc = new RectF();
        this.wjp = new RectF();
        this.Sfl = new RectF();
        this.f26287sc = new Matrix();
        this.cvk = new ArrayList();
        this.II = true;
        this.ExN = 0.0f;
        this.Gb = new Matrix();
        this.cD = 1.0f;
        this.pFF = ol2;
        this.zY = exN;
        this.YIK = exN.TRI() + "#draw";
        if (exN.Tf() == ExN.pFF.INVERT) {
            scVar.setXfermode(new PorterDuffXfermode(mode2));
        } else {
            scVar.setXfermode(new PorterDuffXfermode(mode));
        }
        dE dEVarWH = exN.BT().WH();
        this.We = dEVarWH;
        dEVarWH.sc((com.bytedance.adsdk.pFF.sc.pFF.sc.InterfaceC0222sc) this);
        if (exN.WH() != null && !exN.WH().isEmpty()) {
            com.bytedance.adsdk.pFF.sc.pFF.Qj qj2 = new com.bytedance.adsdk.pFF.sc.pFF.Qj(exN.WH());
            this.Dl = qj2;
            Iterator<com.bytedance.adsdk.pFF.sc.pFF.sc<SR, Path>> it = qj2.pFF().iterator();
            while (it.hasNext()) {
                it.next().sc(this);
            }
            for (com.bytedance.adsdk.pFF.sc.pFF.sc<Integer, Integer> scVar2 : this.Dl.zY()) {
                sc(scVar2);
                scVar2.sc(this);
            }
        }
        Tf();
    }

    private void BT() {
        if (this.WP != null) {
            return;
        }
        if (this.FI == null) {
            this.WP = Collections.emptyList();
            return;
        }
        this.WP = new ArrayList();
        for (sc scVar = this.FI; scVar != null; scVar = scVar.FI) {
            this.WP.add(scVar);
        }
    }

    private void ExN(Canvas canvas, Matrix matrix, com.bytedance.adsdk.pFF.sc.pFF.sc<SR, Path> scVar, com.bytedance.adsdk.pFF.sc.pFF.sc<Integer, Integer> scVar2) {
        com.bytedance.adsdk.pFF.TRI.TRI.sc(canvas, this.BT, this.UFX);
        canvas.drawRect(this.BT, this.WH);
        this.Tf.setAlpha((int) (scVar2.qr().intValue() * 2.55f));
        this.f26286qr.set(scVar.qr());
        this.f26286qr.transform(matrix);
        canvas.drawPath(this.f26286qr, this.Tf);
        canvas.restore();
    }

    private void Ql() {
        this.pFF.invalidateSelf();
    }

    private boolean SR() {
        if (this.Dl.pFF().isEmpty()) {
            return false;
        }
        for (int i11 = 0; i11 < this.Dl.sc().size(); i11++) {
            if (this.Dl.sc().get(i11).sc() != com.bytedance.adsdk.pFF.zY.pFF.Qj.sc.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void Tf() {
        if (this.zY.We().isEmpty()) {
            pFF(true);
            return;
        }
        com.bytedance.adsdk.pFF.sc.pFF.We we2 = new com.bytedance.adsdk.pFF.sc.pFF.We(this.zY.We());
        this.uEA = we2;
        we2.sc();
        this.uEA.sc(new com.bytedance.adsdk.pFF.sc.pFF.sc.InterfaceC0222sc() { // from class: com.bytedance.adsdk.pFF.zY.zY.sc.1
            @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.InterfaceC0222sc
            public void sc() {
                sc scVar = sc.this;
                scVar.pFF(scVar.uEA.Ol() == 1.0f);
            }
        });
        pFF(this.uEA.qr().floatValue() == 1.0f);
        sc(this.uEA);
    }

    private void We(Canvas canvas, Matrix matrix, com.bytedance.adsdk.pFF.sc.pFF.sc<SR, Path> scVar, com.bytedance.adsdk.pFF.sc.pFF.sc<Integer, Integer> scVar2) {
        com.bytedance.adsdk.pFF.TRI.TRI.sc(canvas, this.BT, this.UFX);
        this.f26286qr.set(scVar.qr());
        this.f26286qr.transform(matrix);
        this.WH.setAlpha((int) (scVar2.qr().intValue() * 2.55f));
        canvas.drawPath(this.f26286qr, this.WH);
        canvas.restore();
    }

    private void pFF(Canvas canvas, Matrix matrix, com.bytedance.adsdk.pFF.sc.pFF.sc<SR, Path> scVar, com.bytedance.adsdk.pFF.sc.pFF.sc<Integer, Integer> scVar2) {
        com.bytedance.adsdk.pFF.TRI.TRI.sc(canvas, this.BT, this.WH);
        canvas.drawRect(this.BT, this.WH);
        this.f26286qr.set(scVar.qr());
        this.f26286qr.transform(matrix);
        this.WH.setAlpha((int) (scVar2.qr().intValue() * 2.55f));
        canvas.drawPath(this.f26286qr, this.Tf);
        canvas.restore();
    }

    private void pFF(RectF rectF, Matrix matrix) {
        if (zY() && this.zY.Tf() != ExN.pFF.INVERT) {
            this.wjp.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.JPJ.sc(this.wjp, matrix, true);
            if (rectF.intersect(this.wjp)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(boolean z11) {
        if (z11 != this.II) {
            this.II = z11;
            Ql();
        }
    }

    public static sc sc(pFF pff, ExN exN, com.bytedance.adsdk.pFF.Ol ol2, com.bytedance.adsdk.pFF.qr qrVar, Context context) {
        switch (AnonymousClass2.f26289sc[exN.UFX().ordinal()]) {
            case 1:
                return new qr(ol2, exN, pff, qrVar);
            case 2:
                return new pFF(ol2, exN, qrVar.pFF(exN.qr()), qrVar, context);
            case 3:
                return new Qj(ol2, exN);
            case 4:
                if (sc(ol2, exN, "text:")) {
                    return new zY(ol2, exN, context);
                }
                return sc(ol2, exN, "videoview:") ? new WH(ol2, exN, context) : new We(ol2, exN);
            case 5:
                return new TRI(ol2, exN);
            case 6:
                return new Ol(ol2, exN);
            default:
                Objects.toString(exN.UFX());
                return null;
        }
    }

    private void sc(Canvas canvas) {
        com.bytedance.adsdk.pFF.ExN.sc("Layer#clearLayer");
        RectF rectF = this.BT;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.SR);
        com.bytedance.adsdk.pFF.ExN.pFF("Layer#clearLayer");
    }

    private void sc(Canvas canvas, Matrix matrix) {
        com.bytedance.adsdk.pFF.ExN.sc("Layer#saveLayer");
        com.bytedance.adsdk.pFF.TRI.TRI.sc(canvas, this.BT, this.UFX, 19);
        if (Build.VERSION.SDK_INT < 28) {
            sc(canvas);
        }
        com.bytedance.adsdk.pFF.ExN.pFF("Layer#saveLayer");
        for (int i11 = 0; i11 < this.Dl.sc().size(); i11++) {
            com.bytedance.adsdk.pFF.zY.pFF.Qj qj2 = this.Dl.sc().get(i11);
            com.bytedance.adsdk.pFF.sc.pFF.sc<SR, Path> scVar = this.Dl.pFF().get(i11);
            com.bytedance.adsdk.pFF.sc.pFF.sc<Integer, Integer> scVar2 = this.Dl.zY().get(i11);
            int i12 = AnonymousClass2.pFF[qj2.sc().ordinal()];
            if (i12 != 1) {
                if (i12 == 2) {
                    if (i11 == 0) {
                        this.WH.setColor(ViewCompat.MEASURED_STATE_MASK);
                        this.WH.setAlpha(255);
                        canvas.drawRect(this.BT, this.WH);
                    }
                    if (qj2.We()) {
                        zY(canvas, matrix, scVar, scVar2);
                    } else {
                        sc(canvas, matrix, scVar);
                    }
                } else if (i12 != 3) {
                    if (i12 == 4) {
                        if (qj2.We()) {
                            pFF(canvas, matrix, scVar, scVar2);
                        } else {
                            sc(canvas, matrix, scVar, scVar2);
                        }
                    }
                } else if (qj2.We()) {
                    ExN(canvas, matrix, scVar, scVar2);
                } else {
                    We(canvas, matrix, scVar, scVar2);
                }
            } else if (SR()) {
                this.WH.setAlpha(255);
                canvas.drawRect(this.BT, this.WH);
            }
        }
        com.bytedance.adsdk.pFF.ExN.sc("Layer#restoreLayer");
        canvas.restore();
        com.bytedance.adsdk.pFF.ExN.pFF("Layer#restoreLayer");
    }

    private void sc(Canvas canvas, Matrix matrix, com.bytedance.adsdk.pFF.sc.pFF.sc<SR, Path> scVar) {
        this.f26286qr.set(scVar.qr());
        this.f26286qr.transform(matrix);
        canvas.drawPath(this.f26286qr, this.Tf);
    }

    private void sc(Canvas canvas, Matrix matrix, com.bytedance.adsdk.pFF.sc.pFF.sc<SR, Path> scVar, com.bytedance.adsdk.pFF.sc.pFF.sc<Integer, Integer> scVar2) {
        this.f26286qr.set(scVar.qr());
        this.f26286qr.transform(matrix);
        this.WH.setAlpha((int) (scVar2.qr().intValue() * 2.55f));
        canvas.drawPath(this.f26286qr, this.WH);
    }

    private void sc(RectF rectF, Matrix matrix) {
        this.Xc.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (qr()) {
            int size = this.Dl.sc().size();
            for (int i11 = 0; i11 < size; i11++) {
                com.bytedance.adsdk.pFF.zY.pFF.Qj qj2 = this.Dl.sc().get(i11);
                Path pathQr = this.Dl.pFF().get(i11).qr();
                if (pathQr != null) {
                    this.f26286qr.set(pathQr);
                    this.f26286qr.transform(matrix);
                    int i12 = AnonymousClass2.pFF[qj2.sc().ordinal()];
                    if (i12 == 1 || i12 == 2) {
                        return;
                    }
                    if ((i12 == 3 || i12 == 4) && qj2.We()) {
                        return;
                    }
                    this.f26286qr.computeBounds(this.Sfl, false);
                    if (i11 == 0) {
                        this.Xc.set(this.Sfl);
                    } else {
                        RectF rectF2 = this.Xc;
                        rectF2.set(Math.min(rectF2.left, this.Sfl.left), Math.min(this.Xc.top, this.Sfl.top), Math.max(this.Xc.right, this.Sfl.right), Math.max(this.Xc.bottom, this.Sfl.bottom));
                    }
                }
            }
            if (rectF.intersect(this.Xc)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private static boolean sc(com.bytedance.adsdk.pFF.Ol ol2, ExN exN, String str) {
        com.bytedance.adsdk.pFF.WH whTRI;
        if (ol2 == null || exN == null || str == null || (whTRI = ol2.TRI(exN.qr())) == null) {
            return false;
        }
        return str.equals(whTRI.WH());
    }

    private void zY(float f11) {
        this.pFF.cvk().zY().sc(this.zY.TRI(), f11);
    }

    private void zY(Canvas canvas, Matrix matrix, com.bytedance.adsdk.pFF.sc.pFF.sc<SR, Path> scVar, com.bytedance.adsdk.pFF.sc.pFF.sc<Integer, Integer> scVar2) {
        com.bytedance.adsdk.pFF.TRI.TRI.sc(canvas, this.BT, this.Tf);
        canvas.drawRect(this.BT, this.WH);
        this.Tf.setAlpha((int) (scVar2.qr().intValue() * 2.55f));
        this.f26286qr.set(scVar.qr());
        this.f26286qr.transform(matrix);
        canvas.drawPath(this.f26286qr, this.Tf);
        canvas.restore();
    }

    public String ExN() {
        ExN exN = this.zY;
        if (exN != null) {
            return exN.qr();
        }
        return null;
    }

    public String Ol() {
        return this.zY.TRI();
    }

    public boolean Qj() {
        return this.II;
    }

    public float TRI() {
        return this.cD;
    }

    public com.bytedance.adsdk.pFF.ExN.WH UFX() {
        return this.zY.FI();
    }

    public com.bytedance.adsdk.pFF.zY.pFF.sc WH() {
        return this.zY.JPJ();
    }

    public Matrix We() {
        return this.Gb;
    }

    public BlurMaskFilter pFF(float f11) {
        if (this.ExN == f11) {
            return this.TRI;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f11 / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.TRI = blurMaskFilter;
        this.ExN = f11;
        return blurMaskFilter;
    }

    public ExN pFF() {
        return this.zY;
    }

    public void pFF(Canvas canvas, Matrix matrix, int i11) {
        sc(i11);
    }

    public void pFF(sc scVar) {
        this.FI = scVar;
    }

    public boolean qr() {
        com.bytedance.adsdk.pFF.sc.pFF.Qj qj2 = this.Dl;
        return (qj2 == null || qj2.pFF().isEmpty()) ? false : true;
    }

    @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.InterfaceC0222sc
    public void sc() {
        Ql();
    }

    public void sc(@FloatRange(from = 0.0d, to = 1.0d) float f11) {
        this.We.sc(f11);
        if (this.Dl != null) {
            for (int i11 = 0; i11 < this.Dl.pFF().size(); i11++) {
                this.Dl.pFF().get(i11).sc(f11);
            }
        }
        com.bytedance.adsdk.pFF.sc.pFF.We we2 = this.uEA;
        if (we2 != null) {
            we2.sc(f11);
        }
        sc scVar = this.JPJ;
        if (scVar != null) {
            scVar.sc(f11);
        }
        for (int i12 = 0; i12 < this.cvk.size(); i12++) {
            this.cvk.get(i12).sc(f11);
        }
    }

    public void sc(int i11) {
        this.cD = ((this.We.sc() != null ? this.We.sc().qr().intValue() : 100) / 100.0f) * (i11 / 255.0f);
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.ExN
    public void sc(Canvas canvas, Matrix matrix, int i11) {
        Paint paint;
        Integer numQr;
        com.bytedance.adsdk.pFF.ExN.sc(this.YIK);
        if (!this.II || this.zY.uEA()) {
            com.bytedance.adsdk.pFF.ExN.pFF(this.YIK);
            return;
        }
        BT();
        com.bytedance.adsdk.pFF.ExN.sc("Layer#parentMatrix");
        this.Gb.set(matrix);
        this.Qj.reset();
        this.Qj.set(matrix);
        for (int size = this.WP.size() - 1; size >= 0; size--) {
            this.Qj.preConcat(this.WP.get(size).We.We());
        }
        com.bytedance.adsdk.pFF.ExN.pFF("Layer#parentMatrix");
        com.bytedance.adsdk.pFF.sc.pFF.sc<?, Integer> scVarSc = this.We.sc();
        int iIntValue = (int) ((((i11 / 255.0f) * ((scVarSc == null || (numQr = scVarSc.qr()) == null) ? 100 : numQr.intValue())) / 100.0f) * 255.0f);
        if (!zY() && !qr()) {
            this.Qj.preConcat(this.We.We());
            com.bytedance.adsdk.pFF.ExN.sc("Layer#drawLayer");
            pFF(canvas, this.Qj, iIntValue);
            com.bytedance.adsdk.pFF.ExN.pFF("Layer#drawLayer");
            zY(com.bytedance.adsdk.pFF.ExN.pFF(this.YIK));
            return;
        }
        com.bytedance.adsdk.pFF.ExN.sc("Layer#computeBounds");
        sc(this.BT, this.Qj, false);
        pFF(this.BT, matrix);
        this.Qj.preConcat(this.We.We());
        sc(this.BT, this.Qj);
        this.dE.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        canvas.getMatrix(this.Ol);
        if (!this.Ol.isIdentity()) {
            Matrix matrix2 = this.Ol;
            matrix2.invert(matrix2);
            this.Ol.mapRect(this.dE);
        }
        if (!this.BT.intersect(this.dE)) {
            this.BT.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        com.bytedance.adsdk.pFF.ExN.pFF("Layer#computeBounds");
        if (this.BT.width() >= 1.0f && this.BT.height() >= 1.0f) {
            com.bytedance.adsdk.pFF.ExN.sc("Layer#saveLayer");
            this.WH.setAlpha(255);
            com.bytedance.adsdk.pFF.TRI.TRI.sc(canvas, this.BT, this.WH);
            com.bytedance.adsdk.pFF.ExN.pFF("Layer#saveLayer");
            sc(canvas);
            com.bytedance.adsdk.pFF.ExN.sc("Layer#drawLayer");
            pFF(canvas, this.Qj, iIntValue);
            com.bytedance.adsdk.pFF.ExN.pFF("Layer#drawLayer");
            if (qr()) {
                sc(canvas, this.Qj);
            }
            if (zY()) {
                com.bytedance.adsdk.pFF.ExN.sc("Layer#drawMatte");
                com.bytedance.adsdk.pFF.ExN.sc("Layer#saveLayer");
                com.bytedance.adsdk.pFF.TRI.TRI.sc(canvas, this.BT, this.Ql, 19);
                com.bytedance.adsdk.pFF.ExN.pFF("Layer#saveLayer");
                sc(canvas);
                this.JPJ.sc(canvas, matrix, iIntValue);
                com.bytedance.adsdk.pFF.ExN.sc("Layer#restoreLayer");
                canvas.restore();
                com.bytedance.adsdk.pFF.ExN.pFF("Layer#restoreLayer");
                com.bytedance.adsdk.pFF.ExN.pFF("Layer#drawMatte");
            }
            com.bytedance.adsdk.pFF.ExN.sc("Layer#restoreLayer");
            canvas.restore();
            com.bytedance.adsdk.pFF.ExN.pFF("Layer#restoreLayer");
        }
        if (this.McK && (paint = this.HJN) != null) {
            paint.setStyle(Paint.Style.STROKE);
            this.HJN.setColor(-251901);
            this.HJN.setStrokeWidth(4.0f);
            canvas.drawRect(this.BT, this.HJN);
            this.HJN.setStyle(Paint.Style.FILL);
            this.HJN.setColor(1357638635);
            canvas.drawRect(this.BT, this.HJN);
        }
        zY(com.bytedance.adsdk.pFF.ExN.pFF(this.YIK));
    }

    public void sc(RectF rectF, Matrix matrix, boolean z11) {
        this.BT.set(0.0f, 0.0f, 0.0f, 0.0f);
        BT();
        this.f26287sc.set(matrix);
        if (z11) {
            List<sc> list = this.WP;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f26287sc.preConcat(this.WP.get(size).We.We());
                }
            } else {
                sc scVar = this.FI;
                if (scVar != null) {
                    this.f26287sc.preConcat(scVar.We.We());
                }
            }
        }
        this.f26287sc.preConcat(this.We.We());
    }

    public void sc(com.bytedance.adsdk.pFF.sc.pFF.sc<?, ?> scVar) {
        if (scVar == null) {
            return;
        }
        this.cvk.add(scVar);
    }

    public void sc(sc scVar) {
        this.JPJ = scVar;
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.zY
    public void sc(List<com.bytedance.adsdk.pFF.sc.sc.zY> list, List<com.bytedance.adsdk.pFF.sc.sc.zY> list2) {
    }

    public void sc(boolean z11) {
        if (z11 && this.HJN == null) {
            this.HJN = new com.bytedance.adsdk.pFF.sc.sc();
        }
        this.McK = z11;
    }

    public boolean zY() {
        return this.JPJ != null;
    }
}
