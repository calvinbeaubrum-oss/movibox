package c7;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a7.a> f14690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PointF f14691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14692c;

    public i() {
        this.f14690a = new ArrayList();
    }

    public i(PointF pointF, boolean z11, List<a7.a> list) {
        this.f14691b = pointF;
        this.f14692c = z11;
        this.f14690a = new ArrayList(list);
    }

    public List<a7.a> a() {
        return this.f14690a;
    }

    public PointF b() {
        return this.f14691b;
    }

    public void c(i iVar, i iVar2, float f11) {
        if (this.f14691b == null) {
            this.f14691b = new PointF();
        }
        this.f14692c = iVar.d() || iVar2.d();
        if (iVar.a().size() != iVar2.a().size()) {
            g7.f.c("Curves must have the same number of control points. Shape 1: " + iVar.a().size() + "\tShape 2: " + iVar2.a().size());
        }
        int iMin = Math.min(iVar.a().size(), iVar2.a().size());
        if (this.f14690a.size() < iMin) {
            for (int size = this.f14690a.size(); size < iMin; size++) {
                this.f14690a.add(new a7.a());
            }
        } else if (this.f14690a.size() > iMin) {
            for (int size2 = this.f14690a.size() - 1; size2 >= iMin; size2--) {
                List<a7.a> list = this.f14690a;
                list.remove(list.size() - 1);
            }
        }
        PointF pointFB = iVar.b();
        PointF pointFB2 = iVar2.b();
        f(g7.k.i(pointFB.x, pointFB2.x, f11), g7.k.i(pointFB.y, pointFB2.y, f11));
        for (int size3 = this.f14690a.size() - 1; size3 >= 0; size3--) {
            a7.a aVar = iVar.a().get(size3);
            a7.a aVar2 = iVar2.a().get(size3);
            PointF pointFA = aVar.a();
            PointF pointFB3 = aVar.b();
            PointF pointFC = aVar.c();
            PointF pointFA2 = aVar2.a();
            PointF pointFB4 = aVar2.b();
            PointF pointFC2 = aVar2.c();
            this.f14690a.get(size3).d(g7.k.i(pointFA.x, pointFA2.x, f11), g7.k.i(pointFA.y, pointFA2.y, f11));
            this.f14690a.get(size3).e(g7.k.i(pointFB3.x, pointFB4.x, f11), g7.k.i(pointFB3.y, pointFB4.y, f11));
            this.f14690a.get(size3).f(g7.k.i(pointFC.x, pointFC2.x, f11), g7.k.i(pointFC.y, pointFC2.y, f11));
        }
    }

    public boolean d() {
        return this.f14692c;
    }

    public void e(boolean z11) {
        this.f14692c = z11;
    }

    public void f(float f11, float f12) {
        if (this.f14691b == null) {
            this.f14691b = new PointF();
        }
        this.f14691b.set(f11, f12);
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f14690a.size() + "closed=" + this.f14692c + '}';
    }
}
