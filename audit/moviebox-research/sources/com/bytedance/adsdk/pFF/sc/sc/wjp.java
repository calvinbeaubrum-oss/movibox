package com.bytedance.adsdk.pFF.sc.sc;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class wjp implements com.bytedance.adsdk.pFF.sc.pFF.sc.InterfaceC0222sc, Ql {
    private final com.bytedance.adsdk.pFF.sc.pFF.Ql ExN;
    private boolean TRI;
    private final com.bytedance.adsdk.pFF.Ol We;
    private final String pFF;
    private final boolean zY;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Path f26223sc = new Path();

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final pFF f26222qr = new pFF();

    public wjp(com.bytedance.adsdk.pFF.Ol ol2, com.bytedance.adsdk.pFF.zY.zY.sc scVar, com.bytedance.adsdk.pFF.zY.pFF.Xc xc2) {
        this.pFF = xc2.sc();
        this.zY = xc2.zY();
        this.We = ol2;
        com.bytedance.adsdk.pFF.sc.pFF.Ql qlSc = xc2.pFF().sc();
        this.ExN = qlSc;
        scVar.sc(qlSc);
        qlSc.sc(this);
    }

    private void pFF() {
        this.TRI = false;
        this.We.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.Ql
    public Path We() {
        if (this.TRI) {
            return this.f26223sc;
        }
        this.f26223sc.reset();
        if (this.zY) {
            this.TRI = true;
            return this.f26223sc;
        }
        Path pathQr = this.ExN.qr();
        if (pathQr == null) {
            return this.f26223sc;
        }
        this.f26223sc.set(pathQr);
        this.f26223sc.setFillType(Path.FillType.EVEN_ODD);
        this.f26222qr.sc(this.f26223sc);
        this.TRI = true;
        return this.f26223sc;
    }

    @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.InterfaceC0222sc
    public void sc() {
        pFF();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:12:0x002a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:13:0x002c  */
    /* JADX WARN: Code duplicated, block: B:21:0x0036 A[SYNTHETIC] */
    @Override // com.bytedance.adsdk.pFF.sc.sc.zY
    public void sc(List<zY> list, List<zY> list2) {
        ArrayList arrayList = null;
        for (int i11 = 0; i11 < list.size(); i11++) {
            zY zYVar = list.get(i11);
            if (zYVar instanceof Dl) {
                Dl dl2 = (Dl) zYVar;
                if (dl2.pFF() == com.bytedance.adsdk.pFF.zY.pFF.Sfl.sc.SIMULTANEOUSLY) {
                    this.f26222qr.sc(dl2);
                    dl2.sc(this);
                } else if (!(zYVar instanceof Sfl)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((Sfl) zYVar);
                }
            } else if (!(zYVar instanceof Sfl)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((Sfl) zYVar);
            }
        }
        this.ExN.sc((List<Sfl>) arrayList);
    }
}
