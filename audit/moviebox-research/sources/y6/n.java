package y6;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class n extends a<PointF, PointF> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PointF f81273i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PointF f81274j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a<Float, Float> f81275k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a<Float, Float> f81276l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public h7.c<Float> f81277m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public h7.c<Float> f81278n;

    public n(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.f81273i = new PointF();
        this.f81274j = new PointF();
        this.f81275k = aVar;
        this.f81276l = aVar2;
        n(f());
    }

    @Override // y6.a
    public void n(float f11) {
        this.f81275k.n(f11);
        this.f81276l.n(f11);
        this.f81273i.set(this.f81275k.h().floatValue(), this.f81276l.h().floatValue());
        for (int i11 = 0; i11 < this.f81227a.size(); i11++) {
            this.f81227a.get(i11).b();
        }
    }

    @Override // y6.a
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public PointF h() {
        return i(null, 0.0f);
    }

    @Override // y6.a
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public PointF i(h7.a<PointF> aVar, float f11) {
        Float fB;
        h7.a<Float> aVarB;
        h7.a<Float> aVarB2;
        Float fB2 = null;
        if (this.f81277m == null || (aVarB2 = this.f81275k.b()) == null) {
            fB = null;
        } else {
            float fD = this.f81275k.d();
            Float f12 = aVarB2.f66356h;
            h7.c<Float> cVar = this.f81277m;
            float f13 = aVarB2.f66355g;
            fB = cVar.b(f13, f12 == null ? f13 : f12.floatValue(), aVarB2.f66350b, aVarB2.f66351c, f11, f11, fD);
        }
        if (this.f81278n != null && (aVarB = this.f81276l.b()) != null) {
            float fD2 = this.f81276l.d();
            Float f14 = aVarB.f66356h;
            h7.c<Float> cVar2 = this.f81278n;
            float f15 = aVarB.f66355g;
            fB2 = cVar2.b(f15, f14 == null ? f15 : f14.floatValue(), aVarB.f66350b, aVarB.f66351c, f11, f11, fD2);
        }
        if (fB == null) {
            this.f81274j.set(this.f81273i.x, 0.0f);
        } else {
            this.f81274j.set(fB.floatValue(), 0.0f);
        }
        if (fB2 == null) {
            PointF pointF = this.f81274j;
            pointF.set(pointF.x, this.f81273i.y);
        } else {
            PointF pointF2 = this.f81274j;
            pointF2.set(pointF2.x, fB2.floatValue());
        }
        return this.f81274j;
    }

    public void s(@Nullable h7.c<Float> cVar) {
        h7.c<Float> cVar2 = this.f81277m;
        if (cVar2 != null) {
            cVar2.c(null);
        }
        this.f81277m = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }

    public void t(@Nullable h7.c<Float> cVar) {
        h7.c<Float> cVar2 = this.f81278n;
        if (cVar2 != null) {
            cVar2.c(null);
        }
        this.f81278n = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }
}
