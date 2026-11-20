package x6;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.p0;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class o implements y6.a.b, k, m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f80378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f80379d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LottieDrawable f80380e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final y6.a<?, PointF> f80381f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final y6.a<?, PointF> f80382g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final y6.a<?, Float> f80383h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f80386k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f80376a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f80377b = new RectF();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f80384i = new b();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public y6.a<Float, Float> f80385j = null;

    public o(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, c7.f fVar) {
        this.f80378c = fVar.c();
        this.f80379d = fVar.f();
        this.f80380e = lottieDrawable;
        y6.a<PointF, PointF> aVarA = fVar.d().a();
        this.f80381f = aVarA;
        y6.a<PointF, PointF> aVarA2 = fVar.e().a();
        this.f80382g = aVarA2;
        y6.d dVarA = fVar.b().a();
        this.f80383h = dVarA;
        aVar.i(aVarA);
        aVar.i(aVarA2);
        aVar.i(dVarA);
        aVarA.a(this);
        aVarA2.a(this);
        dVarA.a(this);
    }

    private void g() {
        this.f80386k = false;
        this.f80380e.invalidateSelf();
    }

    @Override // y6.a.b
    public void b() {
        g();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:12:0x0029  */
    /* JADX WARN: Code duplicated, block: B:18:0x0031 A[SYNTHETIC] */
    @Override // x6.c
    public void c(List<c> list, List<c> list2) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            c cVar = list.get(i11);
            if (cVar instanceof u) {
                u uVar = (u) cVar;
                if (uVar.j() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f80384i.a(uVar);
                    uVar.d(this);
                } else if (cVar instanceof q) {
                    this.f80385j = ((q) cVar).g();
                }
            } else if (cVar instanceof q) {
                this.f80385j = ((q) cVar).g();
            }
        }
    }

    @Override // a7.e
    public <T> void d(T t11, @Nullable h7.c<T> cVar) {
        if (t11 == p0.f15278l) {
            this.f80382g.o(cVar);
        } else if (t11 == p0.f15280n) {
            this.f80381f.o(cVar);
        } else if (t11 == p0.f15279m) {
            this.f80383h.o(cVar);
        }
    }

    @Override // a7.e
    public void e(a7.d dVar, int i11, List<a7.d> list, a7.d dVar2) {
        g7.k.k(dVar, i11, list, dVar2, this);
    }

    @Override // x6.c
    public String getName() {
        return this.f80378c;
    }

    @Override // x6.m
    public Path getPath() {
        y6.a<Float, Float> aVar;
        if (this.f80386k) {
            return this.f80376a;
        }
        this.f80376a.reset();
        if (this.f80379d) {
            this.f80386k = true;
            return this.f80376a;
        }
        PointF pointFH = this.f80382g.h();
        float f11 = pointFH.x / 2.0f;
        float f12 = pointFH.y / 2.0f;
        y6.a<?, Float> aVar2 = this.f80383h;
        float fQ = aVar2 == null ? 0.0f : ((y6.d) aVar2).q();
        if (fQ == 0.0f && (aVar = this.f80385j) != null) {
            fQ = Math.min(aVar.h().floatValue(), Math.min(f11, f12));
        }
        float fMin = Math.min(f11, f12);
        if (fQ > fMin) {
            fQ = fMin;
        }
        PointF pointFH2 = this.f80381f.h();
        this.f80376a.moveTo(pointFH2.x + f11, (pointFH2.y - f12) + fQ);
        this.f80376a.lineTo(pointFH2.x + f11, (pointFH2.y + f12) - fQ);
        if (fQ > 0.0f) {
            RectF rectF = this.f80377b;
            float f13 = pointFH2.x;
            float f14 = fQ * 2.0f;
            float f15 = pointFH2.y;
            rectF.set((f13 + f11) - f14, (f15 + f12) - f14, f13 + f11, f15 + f12);
            this.f80376a.arcTo(this.f80377b, 0.0f, 90.0f, false);
        }
        this.f80376a.lineTo((pointFH2.x - f11) + fQ, pointFH2.y + f12);
        if (fQ > 0.0f) {
            RectF rectF2 = this.f80377b;
            float f16 = pointFH2.x;
            float f17 = pointFH2.y;
            float f18 = fQ * 2.0f;
            rectF2.set(f16 - f11, (f17 + f12) - f18, (f16 - f11) + f18, f17 + f12);
            this.f80376a.arcTo(this.f80377b, 90.0f, 90.0f, false);
        }
        this.f80376a.lineTo(pointFH2.x - f11, (pointFH2.y - f12) + fQ);
        if (fQ > 0.0f) {
            RectF rectF3 = this.f80377b;
            float f19 = pointFH2.x;
            float f21 = pointFH2.y;
            float f22 = fQ * 2.0f;
            rectF3.set(f19 - f11, f21 - f12, (f19 - f11) + f22, (f21 - f12) + f22);
            this.f80376a.arcTo(this.f80377b, 180.0f, 90.0f, false);
        }
        this.f80376a.lineTo((pointFH2.x + f11) - fQ, pointFH2.y - f12);
        if (fQ > 0.0f) {
            RectF rectF4 = this.f80377b;
            float f23 = pointFH2.x;
            float f24 = fQ * 2.0f;
            float f25 = pointFH2.y;
            rectF4.set((f23 + f11) - f24, f25 - f12, f23 + f11, (f25 - f12) + f24);
            this.f80376a.arcTo(this.f80377b, 270.0f, 90.0f, false);
        }
        this.f80376a.close();
        this.f80384i.b(this.f80376a);
        this.f80386k = true;
        return this.f80376a;
    }
}
