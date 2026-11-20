package y6;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.p0;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f81283a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix f81284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f81285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Matrix f81286d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float[] f81287e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public a<PointF, PointF> f81288f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public a<?, PointF> f81289g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public a<h7.d, h7.d> f81290h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public a<Float, Float> f81291i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public a<Integer, Integer> f81292j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public d f81293k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public d f81294l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public a<?, Float> f81295m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public a<?, Float> f81296n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f81297o;

    public p(b7.n nVar) {
        this.f81288f = nVar.c() == null ? null : nVar.c().a();
        this.f81289g = nVar.f() == null ? null : nVar.f().a();
        this.f81290h = nVar.h() == null ? null : nVar.h().a();
        this.f81291i = nVar.g() == null ? null : nVar.g().a();
        this.f81293k = nVar.i() == null ? null : nVar.i().a();
        this.f81297o = nVar.l();
        if (this.f81293k != null) {
            this.f81284b = new Matrix();
            this.f81285c = new Matrix();
            this.f81286d = new Matrix();
            this.f81287e = new float[9];
        } else {
            this.f81284b = null;
            this.f81285c = null;
            this.f81286d = null;
            this.f81287e = null;
        }
        this.f81294l = nVar.j() == null ? null : nVar.j().a();
        if (nVar.e() != null) {
            this.f81292j = nVar.e().a();
        }
        if (nVar.k() != null) {
            this.f81295m = nVar.k().a();
        } else {
            this.f81295m = null;
        }
        if (nVar.d() != null) {
            this.f81296n = nVar.d().a();
        } else {
            this.f81296n = null;
        }
    }

    public void a(com.airbnb.lottie.model.layer.a aVar) {
        aVar.i(this.f81292j);
        aVar.i(this.f81295m);
        aVar.i(this.f81296n);
        aVar.i(this.f81288f);
        aVar.i(this.f81289g);
        aVar.i(this.f81290h);
        aVar.i(this.f81291i);
        aVar.i(this.f81293k);
        aVar.i(this.f81294l);
    }

    public void b(a.b bVar) {
        a<Integer, Integer> aVar = this.f81292j;
        if (aVar != null) {
            aVar.a(bVar);
        }
        a<?, Float> aVar2 = this.f81295m;
        if (aVar2 != null) {
            aVar2.a(bVar);
        }
        a<?, Float> aVar3 = this.f81296n;
        if (aVar3 != null) {
            aVar3.a(bVar);
        }
        a<PointF, PointF> aVar4 = this.f81288f;
        if (aVar4 != null) {
            aVar4.a(bVar);
        }
        a<?, PointF> aVar5 = this.f81289g;
        if (aVar5 != null) {
            aVar5.a(bVar);
        }
        a<h7.d, h7.d> aVar6 = this.f81290h;
        if (aVar6 != null) {
            aVar6.a(bVar);
        }
        a<Float, Float> aVar7 = this.f81291i;
        if (aVar7 != null) {
            aVar7.a(bVar);
        }
        d dVar = this.f81293k;
        if (dVar != null) {
            dVar.a(bVar);
        }
        d dVar2 = this.f81294l;
        if (dVar2 != null) {
            dVar2.a(bVar);
        }
    }

    public <T> boolean c(T t11, @Nullable h7.c<T> cVar) {
        if (t11 == p0.f15272f) {
            a<PointF, PointF> aVar = this.f81288f;
            if (aVar == null) {
                this.f81288f = new q(cVar, new PointF());
                return true;
            }
            aVar.o(cVar);
            return true;
        }
        if (t11 == p0.f15273g) {
            a<?, PointF> aVar2 = this.f81289g;
            if (aVar2 == null) {
                this.f81289g = new q(cVar, new PointF());
                return true;
            }
            aVar2.o(cVar);
            return true;
        }
        if (t11 == p0.f15274h) {
            a<?, PointF> aVar3 = this.f81289g;
            if (aVar3 instanceof n) {
                ((n) aVar3).s(cVar);
                return true;
            }
        }
        if (t11 == p0.f15275i) {
            a<?, PointF> aVar4 = this.f81289g;
            if (aVar4 instanceof n) {
                ((n) aVar4).t(cVar);
                return true;
            }
        }
        if (t11 == p0.f15281o) {
            a<h7.d, h7.d> aVar5 = this.f81290h;
            if (aVar5 == null) {
                this.f81290h = new q(cVar, new h7.d());
                return true;
            }
            aVar5.o(cVar);
            return true;
        }
        if (t11 == p0.f15282p) {
            a<Float, Float> aVar6 = this.f81291i;
            if (aVar6 == null) {
                this.f81291i = new q(cVar, Float.valueOf(0.0f));
                return true;
            }
            aVar6.o(cVar);
            return true;
        }
        if (t11 == p0.f15269c) {
            a<Integer, Integer> aVar7 = this.f81292j;
            if (aVar7 == null) {
                this.f81292j = new q(cVar, 100);
                return true;
            }
            aVar7.o(cVar);
            return true;
        }
        if (t11 == p0.C) {
            a<?, Float> aVar8 = this.f81295m;
            if (aVar8 == null) {
                this.f81295m = new q(cVar, Float.valueOf(100.0f));
                return true;
            }
            aVar8.o(cVar);
            return true;
        }
        if (t11 == p0.D) {
            a<?, Float> aVar9 = this.f81296n;
            if (aVar9 == null) {
                this.f81296n = new q(cVar, Float.valueOf(100.0f));
                return true;
            }
            aVar9.o(cVar);
            return true;
        }
        if (t11 == p0.f15283q) {
            if (this.f81293k == null) {
                this.f81293k = new d(Collections.singletonList(new h7.a(Float.valueOf(0.0f))));
            }
            this.f81293k.o(cVar);
            return true;
        }
        if (t11 != p0.f15284r) {
            return false;
        }
        if (this.f81294l == null) {
            this.f81294l = new d(Collections.singletonList(new h7.a(Float.valueOf(0.0f))));
        }
        this.f81294l.o(cVar);
        return true;
    }

    public final void d() {
        for (int i11 = 0; i11 < 9; i11++) {
            this.f81287e[i11] = 0.0f;
        }
    }

    @Nullable
    public a<?, Float> e() {
        return this.f81296n;
    }

    public Matrix f() {
        PointF pointFH;
        h7.d dVarH;
        PointF pointFH2;
        this.f81283a.reset();
        a<?, PointF> aVar = this.f81289g;
        if (aVar != null && (pointFH2 = aVar.h()) != null) {
            float f11 = pointFH2.x;
            if (f11 != 0.0f || pointFH2.y != 0.0f) {
                this.f81283a.preTranslate(f11, pointFH2.y);
            }
        }
        if (!this.f81297o) {
            a<Float, Float> aVar2 = this.f81291i;
            if (aVar2 != null) {
                float fFloatValue = aVar2 instanceof q ? aVar2.h().floatValue() : ((d) aVar2).q();
                if (fFloatValue != 0.0f) {
                    this.f81283a.preRotate(fFloatValue);
                }
            }
        } else if (aVar != null) {
            float f12 = aVar.f();
            PointF pointFH3 = aVar.h();
            float f13 = pointFH3.x;
            float f14 = pointFH3.y;
            aVar.n(1.0E-4f + f12);
            PointF pointFH4 = aVar.h();
            aVar.n(f12);
            this.f81283a.preRotate((float) Math.toDegrees(Math.atan2(pointFH4.y - f14, pointFH4.x - f13)));
        }
        d dVar = this.f81293k;
        if (dVar != null) {
            d dVar2 = this.f81294l;
            float fCos = dVar2 == null ? 0.0f : (float) Math.cos(Math.toRadians((-dVar2.q()) + 90.0f));
            d dVar3 = this.f81294l;
            float fSin = dVar3 == null ? 1.0f : (float) Math.sin(Math.toRadians((-dVar3.q()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(dVar.q()));
            d();
            float[] fArr = this.f81287e;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f15 = -fSin;
            fArr[3] = f15;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.f81284b.setValues(fArr);
            d();
            float[] fArr2 = this.f81287e;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f81285c.setValues(fArr2);
            d();
            float[] fArr3 = this.f81287e;
            fArr3[0] = fCos;
            fArr3[1] = f15;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.f81286d.setValues(fArr3);
            this.f81285c.preConcat(this.f81284b);
            this.f81286d.preConcat(this.f81285c);
            this.f81283a.preConcat(this.f81286d);
        }
        a<h7.d, h7.d> aVar3 = this.f81290h;
        if (aVar3 != null && (dVarH = aVar3.h()) != null && (dVarH.b() != 1.0f || dVarH.c() != 1.0f)) {
            this.f81283a.preScale(dVarH.b(), dVarH.c());
        }
        a<PointF, PointF> aVar4 = this.f81288f;
        if (aVar4 != null && (pointFH = aVar4.h()) != null) {
            float f16 = pointFH.x;
            if (f16 != 0.0f || pointFH.y != 0.0f) {
                this.f81283a.preTranslate(-f16, -pointFH.y);
            }
        }
        return this.f81283a;
    }

    public Matrix g(float f11) {
        a<?, PointF> aVar = this.f81289g;
        PointF pointFH = aVar == null ? null : aVar.h();
        a<h7.d, h7.d> aVar2 = this.f81290h;
        h7.d dVarH = aVar2 == null ? null : aVar2.h();
        this.f81283a.reset();
        if (pointFH != null) {
            this.f81283a.preTranslate(pointFH.x * f11, pointFH.y * f11);
        }
        if (dVarH != null) {
            double d11 = f11;
            this.f81283a.preScale((float) Math.pow(dVarH.b(), d11), (float) Math.pow(dVarH.c(), d11));
        }
        a<Float, Float> aVar3 = this.f81291i;
        if (aVar3 != null) {
            float fFloatValue = aVar3.h().floatValue();
            a<PointF, PointF> aVar4 = this.f81288f;
            PointF pointFH2 = aVar4 != null ? aVar4.h() : null;
            this.f81283a.preRotate(fFloatValue * f11, pointFH2 == null ? 0.0f : pointFH2.x, pointFH2 != null ? pointFH2.y : 0.0f);
        }
        return this.f81283a;
    }

    @Nullable
    public a<?, Integer> h() {
        return this.f81292j;
    }

    @Nullable
    public a<?, Float> i() {
        return this.f81295m;
    }

    public void j(float f11) {
        a<Integer, Integer> aVar = this.f81292j;
        if (aVar != null) {
            aVar.n(f11);
        }
        a<?, Float> aVar2 = this.f81295m;
        if (aVar2 != null) {
            aVar2.n(f11);
        }
        a<?, Float> aVar3 = this.f81296n;
        if (aVar3 != null) {
            aVar3.n(f11);
        }
        a<PointF, PointF> aVar4 = this.f81288f;
        if (aVar4 != null) {
            aVar4.n(f11);
        }
        a<?, PointF> aVar5 = this.f81289g;
        if (aVar5 != null) {
            aVar5.n(f11);
        }
        a<h7.d, h7.d> aVar6 = this.f81290h;
        if (aVar6 != null) {
            aVar6.n(f11);
        }
        a<Float, Float> aVar7 = this.f81291i;
        if (aVar7 != null) {
            aVar7.n(f11);
        }
        d dVar = this.f81293k;
        if (dVar != null) {
            dVar.n(f11);
        }
        d dVar2 = this.f81294l;
        if (dVar2 != null) {
            dVar2.n(f11);
        }
    }
}
