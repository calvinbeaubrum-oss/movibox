package com.bytedance.adsdk.pFF.sc.sc;

import android.annotation.TargetApi;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(19)
public class Tf implements Ql, WH {
    private final com.bytedance.adsdk.pFF.zY.pFF.Ol TRI;
    private final String We;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Path f26208sc = new Path();
    private final Path pFF = new Path();
    private final Path zY = new Path();
    private final List<Ql> ExN = new ArrayList();

    /* JADX INFO: renamed from: com.bytedance.adsdk.pFF.sc.sc.Tf$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        static final /* synthetic */ int[] f26209sc;

        static {
            int[] iArr = new int[com.bytedance.adsdk.pFF.zY.pFF.Ol.sc.values().length];
            f26209sc = iArr;
            try {
                iArr[com.bytedance.adsdk.pFF.zY.pFF.Ol.sc.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26209sc[com.bytedance.adsdk.pFF.zY.pFF.Ol.sc.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26209sc[com.bytedance.adsdk.pFF.zY.pFF.Ol.sc.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f26209sc[com.bytedance.adsdk.pFF.zY.pFF.Ol.sc.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f26209sc[com.bytedance.adsdk.pFF.zY.pFF.Ol.sc.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public Tf(com.bytedance.adsdk.pFF.zY.pFF.Ol ol2) {
        this.We = ol2.sc();
        this.TRI = ol2;
    }

    private void sc() {
        for (int i11 = 0; i11 < this.ExN.size(); i11++) {
            this.zY.addPath(this.ExN.get(i11).We());
        }
    }

    @TargetApi(19)
    private void sc(Path.Op op2) {
        this.pFF.reset();
        this.f26208sc.reset();
        for (int size = this.ExN.size() - 1; size > 0; size--) {
            Ql ql2 = this.ExN.get(size);
            if (ql2 instanceof We) {
                We we2 = (We) ql2;
                List<Ql> listPFF = we2.pFF();
                for (int size2 = listPFF.size() - 1; size2 >= 0; size2--) {
                    Path pathWe = listPFF.get(size2).We();
                    pathWe.transform(we2.zY());
                    this.pFF.addPath(pathWe);
                }
            } else {
                this.pFF.addPath(ql2.We());
            }
        }
        Ql ql3 = this.ExN.get(0);
        if (ql3 instanceof We) {
            We we3 = (We) ql3;
            List<Ql> listPFF2 = we3.pFF();
            for (int i11 = 0; i11 < listPFF2.size(); i11++) {
                Path pathWe2 = listPFF2.get(i11).We();
                pathWe2.transform(we3.zY());
                this.f26208sc.addPath(pathWe2);
            }
        } else {
            this.f26208sc.set(ql3.We());
        }
        this.zY.op(this.f26208sc, this.pFF, op2);
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.Ql
    public Path We() {
        this.zY.reset();
        if (this.TRI.zY()) {
            return this.zY;
        }
        int i11 = AnonymousClass1.f26209sc[this.TRI.pFF().ordinal()];
        if (i11 == 1) {
            sc();
        } else if (i11 == 2) {
            sc(Path.Op.UNION);
        } else if (i11 == 3) {
            sc(Path.Op.REVERSE_DIFFERENCE);
        } else if (i11 == 4) {
            sc(Path.Op.INTERSECT);
        } else if (i11 == 5) {
            sc(Path.Op.XOR);
        }
        return this.zY;
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.zY
    public void sc(List<zY> list, List<zY> list2) {
        for (int i11 = 0; i11 < this.ExN.size(); i11++) {
            this.ExN.get(i11).sc(list, list2);
        }
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.WH
    public void sc(ListIterator<zY> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            zY zYVarPrevious = listIterator.previous();
            if (zYVarPrevious instanceof Ql) {
                this.ExN.add((Ql) zYVarPrevious);
                listIterator.remove();
            }
        }
    }
}
