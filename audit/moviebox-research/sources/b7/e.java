package b7;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements o<PointF, PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<h7.a<PointF>> f14036a;

    public e(List<h7.a<PointF>> list) {
        this.f14036a = list;
    }

    @Override // b7.o
    public y6.a<PointF, PointF> a() {
        return this.f14036a.get(0).i() ? new y6.k(this.f14036a) : new y6.j(this.f14036a);
    }

    @Override // b7.o
    public List<h7.a<PointF>> b() {
        return this.f14036a;
    }

    @Override // b7.o
    public boolean c() {
        return this.f14036a.size() == 1 && this.f14036a.get(0).i();
    }
}
