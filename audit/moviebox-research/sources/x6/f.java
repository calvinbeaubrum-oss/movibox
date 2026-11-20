package x6;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.p0;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class f implements m, y6.a.b, k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f80300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LottieDrawable f80301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y6.a<?, PointF> f80302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final y6.a<?, PointF> f80303e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c7.b f80304f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f80306h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f80299a = new Path();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f80305g = new b();

    public f(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, c7.b bVar) {
        this.f80300b = bVar.b();
        this.f80301c = lottieDrawable;
        y6.a<PointF, PointF> aVarA = bVar.d().a();
        this.f80302d = aVarA;
        y6.a<PointF, PointF> aVarA2 = bVar.c().a();
        this.f80303e = aVarA2;
        this.f80304f = bVar;
        aVar.i(aVarA);
        aVar.i(aVarA2);
        aVarA.a(this);
        aVarA2.a(this);
    }

    @Override // y6.a.b
    public void b() {
        g();
    }

    @Override // x6.c
    public void c(List<c> list, List<c> list2) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            c cVar = list.get(i11);
            if (cVar instanceof u) {
                u uVar = (u) cVar;
                if (uVar.j() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f80305g.a(uVar);
                    uVar.d(this);
                }
            }
        }
    }

    @Override // a7.e
    public <T> void d(T t11, @Nullable h7.c<T> cVar) {
        if (t11 == p0.f15277k) {
            this.f80302d.o(cVar);
        } else if (t11 == p0.f15280n) {
            this.f80303e.o(cVar);
        }
    }

    @Override // a7.e
    public void e(a7.d dVar, int i11, List<a7.d> list, a7.d dVar2) {
        g7.k.k(dVar, i11, list, dVar2, this);
    }

    public final void g() {
        this.f80306h = false;
        this.f80301c.invalidateSelf();
    }

    @Override // x6.c
    public String getName() {
        return this.f80300b;
    }

    @Override // x6.m
    public Path getPath() {
        if (this.f80306h) {
            return this.f80299a;
        }
        this.f80299a.reset();
        if (this.f80304f.e()) {
            this.f80306h = true;
            return this.f80299a;
        }
        PointF pointFH = this.f80302d.h();
        float f11 = pointFH.x / 2.0f;
        float f12 = pointFH.y / 2.0f;
        float f13 = f11 * 0.55228f;
        float f14 = 0.55228f * f12;
        this.f80299a.reset();
        if (this.f80304f.f()) {
            float f15 = -f12;
            this.f80299a.moveTo(0.0f, f15);
            float f16 = 0.0f - f13;
            float f17 = -f11;
            float f18 = 0.0f - f14;
            this.f80299a.cubicTo(f16, f15, f17, f18, f17, 0.0f);
            float f19 = f14 + 0.0f;
            this.f80299a.cubicTo(f17, f19, f16, f12, 0.0f, f12);
            float f21 = f13 + 0.0f;
            this.f80299a.cubicTo(f21, f12, f11, f19, f11, 0.0f);
            this.f80299a.cubicTo(f11, f18, f21, f15, 0.0f, f15);
        } else {
            float f22 = -f12;
            this.f80299a.moveTo(0.0f, f22);
            float f23 = f13 + 0.0f;
            float f24 = 0.0f - f14;
            this.f80299a.cubicTo(f23, f22, f11, f24, f11, 0.0f);
            float f25 = f14 + 0.0f;
            this.f80299a.cubicTo(f11, f25, f23, f12, 0.0f, f12);
            float f26 = 0.0f - f13;
            float f27 = -f11;
            this.f80299a.cubicTo(f26, f12, f27, f25, f27, 0.0f);
            this.f80299a.cubicTo(f27, f24, f26, f22, 0.0f, f22);
        }
        PointF pointFH2 = this.f80303e.h();
        this.f80299a.offset(pointFH2.x, pointFH2.y);
        this.f80299a.close();
        this.f80305g.b(this.f80299a);
        this.f80306h = true;
        return this.f80299a;
    }
}
