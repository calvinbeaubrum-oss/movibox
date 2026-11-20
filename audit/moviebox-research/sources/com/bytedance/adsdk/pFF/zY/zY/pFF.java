package com.bytedance.adsdk.pFF.zY.zY;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.LongSparseArray;
import com.bytedance.component.sdk.annotation.FloatRange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF extends sc {
    private final RectF Ol;
    private final List<sc> Qj;
    private boolean Tf;
    private final Paint UFX;
    private final RectF WH;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> f26283qr;

    /* JADX INFO: renamed from: com.bytedance.adsdk.pFF.zY.zY.pFF$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        static final /* synthetic */ int[] f26284sc;

        static {
            int[] iArr = new int[ExN.pFF.values().length];
            f26284sc = iArr;
            try {
                iArr[ExN.pFF.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26284sc[ExN.pFF.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public pFF(com.bytedance.adsdk.pFF.Ol ol2, ExN exN, List<ExN> list, com.bytedance.adsdk.pFF.qr qrVar, Context context) {
        int i11;
        sc scVar;
        ExN.pFF pffTf;
        int i12;
        super(ol2, exN);
        this.Qj = new ArrayList();
        this.Ol = new RectF();
        this.WH = new RectF();
        this.UFX = new Paint();
        this.Tf = true;
        com.bytedance.adsdk.pFF.zY.sc.pFF pffDl = exN.Dl();
        if (pffDl != null) {
            com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> scVarSc = pffDl.sc();
            this.f26283qr = scVarSc;
            sc(scVarSc);
            this.f26283qr.sc(this);
        } else {
            this.f26283qr = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(qrVar.Ql().size());
        int size = list.size() - 1;
        sc scVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            ExN exN2 = list.get(size);
            sc scVarSc2 = sc.sc(this, exN2, ol2, qrVar, context);
            if (scVarSc2 != null) {
                longSparseArray.put(scVarSc2.pFF().ExN(), scVarSc2);
                if (scVar2 != null) {
                    scVar2.sc(scVarSc2);
                    scVar2 = null;
                } else {
                    this.Qj.add(0, scVarSc2);
                    if (exN2 != null && (pffTf = exN2.Tf()) != null && ((i12 = AnonymousClass1.f26284sc[pffTf.ordinal()]) == 1 || i12 == 2)) {
                        scVar2 = scVarSc2;
                    }
                }
            }
            size--;
        }
        for (i11 = 0; i11 < longSparseArray.size(); i11++) {
            sc scVar3 = (sc) longSparseArray.get(longSparseArray.keyAt(i11));
            if (scVar3 != null && (scVar = (sc) longSparseArray.get(scVar3.pFF().Ql())) != null) {
                scVar3.pFF(scVar);
            }
        }
    }

    public List<sc> Tf() {
        return this.Qj;
    }

    @Override // com.bytedance.adsdk.pFF.zY.zY.sc
    public void pFF(Canvas canvas, Matrix matrix, int i11) {
        super.pFF(canvas, matrix, i11);
        com.bytedance.adsdk.pFF.ExN.sc("CompositionLayer#draw");
        this.WH.set(0.0f, 0.0f, this.zY.Qj(), this.zY.Ol());
        matrix.mapRect(this.WH);
        boolean z11 = this.pFF.Ol() && this.Qj.size() > 1 && i11 != 255;
        if (z11) {
            this.UFX.setAlpha(i11);
            com.bytedance.adsdk.pFF.TRI.TRI.sc(canvas, this.WH, this.UFX);
        } else {
            canvas.save();
        }
        if (z11) {
            i11 = 255;
        }
        for (int size = this.Qj.size() - 1; size >= 0; size--) {
            if ((!this.Tf && "__container".equals(this.zY.TRI())) || this.WH.isEmpty() || canvas.clipRect(this.WH)) {
                this.Qj.get(size).sc(canvas, matrix, i11);
            }
        }
        canvas.restore();
        com.bytedance.adsdk.pFF.ExN.pFF("CompositionLayer#draw");
    }

    public void pFF(boolean z11) {
        this.Tf = z11;
    }

    @Override // com.bytedance.adsdk.pFF.zY.zY.sc
    public void sc(@FloatRange(from = 0.0d, to = 1.0d) float f11) {
        super.sc(f11);
        if (this.f26283qr != null) {
            f11 = ((this.f26283qr.qr().floatValue() * this.zY.sc().Tf()) - this.zY.sc().TRI()) / (this.pFF.cvk().Xc() + 0.01f);
        }
        if (this.f26283qr == null) {
            f11 -= this.zY.zY();
        }
        if (this.zY.pFF() != 0.0f && !"__container".equals(this.zY.TRI())) {
            f11 /= this.zY.pFF();
        }
        for (int size = this.Qj.size() - 1; size >= 0; size--) {
            this.Qj.get(size).sc(f11);
        }
    }

    @Override // com.bytedance.adsdk.pFF.zY.zY.sc, com.bytedance.adsdk.pFF.sc.sc.ExN
    public void sc(RectF rectF, Matrix matrix, boolean z11) {
        super.sc(rectF, matrix, z11);
        for (int size = this.Qj.size() - 1; size >= 0; size--) {
            this.Ol.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.Qj.get(size).sc(this.Ol, this.f26287sc, true);
            rectF.union(this.Ol);
        }
    }

    @Override // com.bytedance.adsdk.pFF.zY.zY.sc
    public void sc(boolean z11) {
        super.sc(z11);
        Iterator<sc> it = this.Qj.iterator();
        while (it.hasNext()) {
            it.next().sc(z11);
        }
    }
}
