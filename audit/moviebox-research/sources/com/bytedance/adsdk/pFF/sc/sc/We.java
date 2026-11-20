package com.bytedance.adsdk.pFF.sc.sc;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We implements com.bytedance.adsdk.pFF.sc.pFF.sc.InterfaceC0222sc, ExN, Ql {
    private final RectF ExN;
    private final com.bytedance.adsdk.pFF.Ol Ol;
    private final List<zY> Qj;
    private final String TRI;
    private com.bytedance.adsdk.pFF.sc.pFF.dE UFX;
    private List<Ql> WH;
    private final Path We;
    private final RectF pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final boolean f26210qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Paint f26211sc;
    private final Matrix zY;

    public We(com.bytedance.adsdk.pFF.Ol ol2, com.bytedance.adsdk.pFF.zY.zY.sc scVar, com.bytedance.adsdk.pFF.zY.pFF.dE dEVar, com.bytedance.adsdk.pFF.qr qrVar) {
        this(ol2, scVar, dEVar.sc(), dEVar.zY(), sc(ol2, qrVar, scVar, dEVar.pFF()), sc(dEVar.pFF()));
    }

    public We(com.bytedance.adsdk.pFF.Ol ol2, com.bytedance.adsdk.pFF.zY.zY.sc scVar, String str, boolean z11, List<zY> list, com.bytedance.adsdk.pFF.zY.sc.Tf tf2) {
        this.f26211sc = new com.bytedance.adsdk.pFF.sc.sc();
        this.pFF = new RectF();
        this.zY = new Matrix();
        this.We = new Path();
        this.ExN = new RectF();
        this.TRI = str;
        this.Ol = ol2;
        this.f26210qr = z11;
        this.Qj = list;
        if (tf2 != null) {
            com.bytedance.adsdk.pFF.sc.pFF.dE dEVarWH = tf2.WH();
            this.UFX = dEVarWH;
            dEVarWH.sc(scVar);
            this.UFX.sc(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            zY zYVar = list.get(size);
            if (zYVar instanceof WH) {
                arrayList.add((WH) zYVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((WH) arrayList.get(size2)).sc(list.listIterator(list.size()));
        }
    }

    private boolean ExN() {
        int i11 = 0;
        for (int i12 = 0; i12 < this.Qj.size(); i12++) {
            if ((this.Qj.get(i12) instanceof ExN) && (i11 = i11 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    public static com.bytedance.adsdk.pFF.zY.sc.Tf sc(List<com.bytedance.adsdk.pFF.zY.pFF.zY> list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            com.bytedance.adsdk.pFF.zY.pFF.zY zYVar = list.get(i11);
            if (zYVar instanceof com.bytedance.adsdk.pFF.zY.sc.Tf) {
                return (com.bytedance.adsdk.pFF.zY.sc.Tf) zYVar;
            }
        }
        return null;
    }

    private static List<zY> sc(com.bytedance.adsdk.pFF.Ol ol2, com.bytedance.adsdk.pFF.qr qrVar, com.bytedance.adsdk.pFF.zY.zY.sc scVar, List<com.bytedance.adsdk.pFF.zY.pFF.zY> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i11 = 0; i11 < list.size(); i11++) {
            zY zYVarSc = list.get(i11).sc(ol2, qrVar, scVar);
            if (zYVarSc != null) {
                arrayList.add(zYVarSc);
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.Ql
    public Path We() {
        this.zY.reset();
        com.bytedance.adsdk.pFF.sc.pFF.dE dEVar = this.UFX;
        if (dEVar != null) {
            this.zY.set(dEVar.We());
        }
        this.We.reset();
        if (this.f26210qr) {
            return this.We;
        }
        for (int size = this.Qj.size() - 1; size >= 0; size--) {
            zY zYVar = this.Qj.get(size);
            if (zYVar instanceof Ql) {
                this.We.addPath(((Ql) zYVar).We(), this.zY);
            }
        }
        return this.We;
    }

    public List<Ql> pFF() {
        if (this.WH == null) {
            this.WH = new ArrayList();
            for (int i11 = 0; i11 < this.Qj.size(); i11++) {
                zY zYVar = this.Qj.get(i11);
                if (zYVar instanceof Ql) {
                    this.WH.add((Ql) zYVar);
                }
            }
        }
        return this.WH;
    }

    @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.InterfaceC0222sc
    public void sc() {
        this.Ol.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.ExN
    public void sc(Canvas canvas, Matrix matrix, int i11) {
        if (this.f26210qr) {
            return;
        }
        this.zY.set(matrix);
        com.bytedance.adsdk.pFF.sc.pFF.dE dEVar = this.UFX;
        if (dEVar != null) {
            this.zY.preConcat(dEVar.We());
            i11 = (int) (((((this.UFX.sc() == null ? 100 : this.UFX.sc().qr().intValue()) / 100.0f) * i11) / 255.0f) * 255.0f);
        }
        boolean z11 = this.Ol.Ol() && ExN() && i11 != 255;
        if (z11) {
            this.pFF.set(0.0f, 0.0f, 0.0f, 0.0f);
            sc(this.pFF, this.zY, true);
            this.f26211sc.setAlpha(i11);
            com.bytedance.adsdk.pFF.TRI.TRI.sc(canvas, this.pFF, this.f26211sc);
        }
        if (z11) {
            i11 = 255;
        }
        for (int size = this.Qj.size() - 1; size >= 0; size--) {
            zY zYVar = this.Qj.get(size);
            if (zYVar instanceof ExN) {
                ((ExN) zYVar).sc(canvas, this.zY, i11);
            }
        }
        if (z11) {
            canvas.restore();
        }
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.ExN
    public void sc(RectF rectF, Matrix matrix, boolean z11) {
        this.zY.set(matrix);
        com.bytedance.adsdk.pFF.sc.pFF.dE dEVar = this.UFX;
        if (dEVar != null) {
            this.zY.preConcat(dEVar.We());
        }
        this.ExN.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.Qj.size() - 1; size >= 0; size--) {
            zY zYVar = this.Qj.get(size);
            if (zYVar instanceof ExN) {
                ((ExN) zYVar).sc(this.ExN, this.zY, z11);
                rectF.union(this.ExN);
            }
        }
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.zY
    public void sc(List<zY> list, List<zY> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.Qj.size());
        arrayList.addAll(list);
        for (int size = this.Qj.size() - 1; size >= 0; size--) {
            zY zYVar = this.Qj.get(size);
            zYVar.sc(arrayList, this.Qj.subList(0, size));
            arrayList.add(zYVar);
        }
    }

    public Matrix zY() {
        com.bytedance.adsdk.pFF.sc.pFF.dE dEVar = this.UFX;
        if (dEVar != null) {
            return dEVar.We();
        }
        this.zY.reset();
        return this.zY;
    }
}
