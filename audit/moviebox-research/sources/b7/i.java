package b7;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class i implements o<PointF, PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f14037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f14038b;

    public i(b bVar, b bVar2) {
        this.f14037a = bVar;
        this.f14038b = bVar2;
    }

    @Override // b7.o
    public y6.a<PointF, PointF> a() {
        return new y6.n(this.f14037a.a(), this.f14038b.a());
    }

    @Override // b7.o
    public List<h7.a<PointF>> b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // b7.o
    public boolean c() {
        return this.f14037a.c() && this.f14038b.c();
    }
}
