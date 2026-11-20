package x6;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.p0;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class n implements m, y6.a.b, k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f80361e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LottieDrawable f80362f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PolystarShape.Type f80363g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f80364h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f80365i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final y6.a<?, Float> f80366j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final y6.a<?, PointF> f80367k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final y6.a<?, Float> f80368l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public final y6.a<?, Float> f80369m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final y6.a<?, Float> f80370n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public final y6.a<?, Float> f80371o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final y6.a<?, Float> f80372p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f80374r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f80357a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f80358b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PathMeasure f80359c = new PathMeasure();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f80360d = new float[2];

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b f80373q = new b();

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f80375a;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            f80375a = iArr;
            try {
                iArr[PolystarShape.Type.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f80375a[PolystarShape.Type.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public n(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        this.f80362f = lottieDrawable;
        this.f80361e = polystarShape.d();
        PolystarShape.Type typeJ = polystarShape.j();
        this.f80363g = typeJ;
        this.f80364h = polystarShape.k();
        this.f80365i = polystarShape.l();
        y6.d dVarA = polystarShape.g().a();
        this.f80366j = dVarA;
        y6.a<PointF, PointF> aVarA = polystarShape.h().a();
        this.f80367k = aVarA;
        y6.d dVarA2 = polystarShape.i().a();
        this.f80368l = dVarA2;
        y6.d dVarA3 = polystarShape.e().a();
        this.f80370n = dVarA3;
        y6.d dVarA4 = polystarShape.f().a();
        this.f80372p = dVarA4;
        PolystarShape.Type type = PolystarShape.Type.STAR;
        if (typeJ == type) {
            this.f80369m = polystarShape.b().a();
            this.f80371o = polystarShape.c().a();
        } else {
            this.f80369m = null;
            this.f80371o = null;
        }
        aVar.i(dVarA);
        aVar.i(aVarA);
        aVar.i(dVarA2);
        aVar.i(dVarA3);
        aVar.i(dVarA4);
        if (typeJ == type) {
            aVar.i(this.f80369m);
            aVar.i(this.f80371o);
        }
        dVarA.a(this);
        aVarA.a(this);
        dVarA2.a(this);
        dVarA3.a(this);
        dVarA4.a(this);
        if (typeJ == type) {
            this.f80369m.a(this);
            this.f80371o.a(this);
        }
    }

    private void j() {
        this.f80374r = false;
        this.f80362f.invalidateSelf();
    }

    @Override // y6.a.b
    public void b() {
        j();
    }

    @Override // x6.c
    public void c(List<c> list, List<c> list2) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            c cVar = list.get(i11);
            if (cVar instanceof u) {
                u uVar = (u) cVar;
                if (uVar.j() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f80373q.a(uVar);
                    uVar.d(this);
                }
            }
        }
    }

    @Override // a7.e
    public <T> void d(T t11, @Nullable h7.c<T> cVar) {
        y6.a<?, Float> aVar;
        y6.a<?, Float> aVar2;
        if (t11 == p0.f15289w) {
            this.f80366j.o(cVar);
            return;
        }
        if (t11 == p0.f15290x) {
            this.f80368l.o(cVar);
            return;
        }
        if (t11 == p0.f15280n) {
            this.f80367k.o(cVar);
            return;
        }
        if (t11 == p0.f15291y && (aVar2 = this.f80369m) != null) {
            aVar2.o(cVar);
            return;
        }
        if (t11 == p0.f15292z) {
            this.f80370n.o(cVar);
            return;
        }
        if (t11 == p0.A && (aVar = this.f80371o) != null) {
            aVar.o(cVar);
        } else if (t11 == p0.B) {
            this.f80372p.o(cVar);
        }
    }

    @Override // a7.e
    public void e(a7.d dVar, int i11, List<a7.d> list, a7.d dVar2) {
        g7.k.k(dVar, i11, list, dVar2, this);
    }

    public final void g() {
        double d11;
        float f11;
        n nVar;
        n nVar2 = this;
        int iFloor = (int) Math.floor(nVar2.f80366j.h().floatValue());
        y6.a<?, Float> aVar = nVar2.f80368l;
        double radians = Math.toRadians((aVar == null ? 0.0d : aVar.h().floatValue()) - 90.0d);
        double d12 = iFloor;
        float fFloatValue = nVar2.f80372p.h().floatValue() / 100.0f;
        float fFloatValue2 = nVar2.f80370n.h().floatValue();
        double d13 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d13);
        float fSin = (float) (Math.sin(radians) * d13);
        nVar2.f80357a.moveTo(fCos, fSin);
        double d14 = (float) (6.283185307179586d / d12);
        double dCeil = Math.ceil(d12);
        double d15 = radians + d14;
        int i11 = 0;
        while (true) {
            double d16 = i11;
            if (d16 >= dCeil) {
                n nVar3 = nVar2;
                PointF pointFH = nVar3.f80367k.h();
                nVar3.f80357a.offset(pointFH.x, pointFH.y);
                nVar3.f80357a.close();
                return;
            }
            int i12 = i11;
            float fCos2 = (float) (d13 * Math.cos(d15));
            double d17 = d14;
            float fSin2 = (float) (d13 * Math.sin(d15));
            if (fFloatValue != 0.0f) {
                d11 = d13;
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos3 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                f11 = fSin2;
                double dAtan3 = (float) (Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                float f12 = fFloatValue2 * fFloatValue * 0.25f;
                float f13 = fCos3 * f12;
                float f14 = fSin3 * f12;
                float fCos4 = ((float) Math.cos(dAtan3)) * f12;
                float fSin4 = f12 * ((float) Math.sin(dAtan3));
                if (d16 == dCeil - 1.0d) {
                    nVar = this;
                    nVar.f80358b.reset();
                    nVar.f80358b.moveTo(fCos, fSin);
                    float f15 = fCos - f13;
                    float f16 = fSin - f14;
                    float f17 = fCos2 + fCos4;
                    float f18 = fSin4 + f11;
                    nVar.f80358b.cubicTo(f15, f16, f17, f18, fCos2, f11);
                    nVar.f80359c.setPath(nVar.f80358b, false);
                    PathMeasure pathMeasure = nVar.f80359c;
                    pathMeasure.getPosTan(pathMeasure.getLength() * 0.9999f, nVar.f80360d, null);
                    Path path = nVar.f80357a;
                    float[] fArr = nVar.f80360d;
                    path.cubicTo(f15, f16, f17, f18, fArr[0], fArr[1]);
                } else {
                    nVar = this;
                    nVar.f80357a.cubicTo(fCos - f13, fSin - f14, fCos2 + fCos4, f11 + fSin4, fCos2, f11);
                }
            } else {
                d11 = d13;
                f11 = fSin2;
                nVar = nVar2;
                if (d16 != dCeil - 1.0d) {
                    nVar.f80357a.lineTo(fCos2, f11);
                }
                fSin = f11;
                fCos = fCos2;
                d14 = d17;
                i11 = i12 + 1;
                nVar2 = nVar;
                d13 = d11;
            }
            d15 += d17;
            fSin = f11;
            fCos = fCos2;
            d14 = d17;
            i11 = i12 + 1;
            nVar2 = nVar;
            d13 = d11;
        }
    }

    @Override // x6.c
    public String getName() {
        return this.f80361e;
    }

    @Override // x6.m
    public Path getPath() {
        if (this.f80374r) {
            return this.f80357a;
        }
        this.f80357a.reset();
        if (this.f80364h) {
            this.f80374r = true;
            return this.f80357a;
        }
        int i11 = a.f80375a[this.f80363g.ordinal()];
        if (i11 == 1) {
            i();
        } else if (i11 == 2) {
            g();
        }
        this.f80357a.close();
        this.f80373q.b(this.f80357a);
        this.f80374r = true;
        return this.f80357a;
    }

    public final void i() {
        float f11;
        float f12;
        double d11;
        float fSin;
        float f13;
        float f14;
        float f15;
        float fFloatValue = this.f80366j.h().floatValue();
        y6.a<?, Float> aVar = this.f80368l;
        double radians = Math.toRadians((aVar == null ? 0.0d : aVar.h().floatValue()) - 90.0d);
        double d12 = fFloatValue;
        float f16 = (float) (6.283185307179586d / d12);
        if (this.f80365i) {
            f16 *= -1.0f;
        }
        float f17 = f16 / 2.0f;
        float f18 = fFloatValue - ((int) fFloatValue);
        if (f18 != 0.0f) {
            radians += (double) ((1.0f - f18) * f17);
        }
        float fFloatValue2 = this.f80370n.h().floatValue();
        float fFloatValue3 = this.f80369m.h().floatValue();
        y6.a<?, Float> aVar2 = this.f80371o;
        float fFloatValue4 = aVar2 != null ? aVar2.h().floatValue() / 100.0f : 0.0f;
        y6.a<?, Float> aVar3 = this.f80372p;
        float fFloatValue5 = aVar3 != null ? aVar3.h().floatValue() / 100.0f : 0.0f;
        if (f18 != 0.0f) {
            f13 = ((fFloatValue2 - fFloatValue3) * f18) + fFloatValue3;
            double d13 = f13;
            float fCos = (float) (d13 * Math.cos(radians));
            fSin = (float) (d13 * Math.sin(radians));
            this.f80357a.moveTo(fCos, fSin);
            d11 = radians + ((double) ((f16 * f18) / 2.0f));
            f11 = fCos;
            f12 = f17;
        } else {
            double d14 = fFloatValue2;
            float fCos2 = (float) (Math.cos(radians) * d14);
            float fSin2 = (float) (d14 * Math.sin(radians));
            this.f80357a.moveTo(fCos2, fSin2);
            f11 = fCos2;
            f12 = f17;
            d11 = radians + ((double) f12);
            fSin = fSin2;
            f13 = 0.0f;
        }
        double dCeil = Math.ceil(d12) * 2.0d;
        int i11 = 0;
        float f19 = f12;
        float f21 = f11;
        boolean z11 = false;
        while (true) {
            double d15 = i11;
            if (d15 >= dCeil) {
                PointF pointFH = this.f80367k.h();
                this.f80357a.offset(pointFH.x, pointFH.y);
                this.f80357a.close();
                return;
            }
            float f22 = z11 ? fFloatValue2 : fFloatValue3;
            float f23 = (f13 == 0.0f || d15 != dCeil - 2.0d) ? f19 : (f16 * f18) / 2.0f;
            if (f13 == 0.0f || d15 != dCeil - 1.0d) {
                f13 = f22;
            }
            double d16 = f13;
            double d17 = dCeil;
            float fCos3 = (float) (d16 * Math.cos(d11));
            float fSin3 = (float) (d16 * Math.sin(d11));
            if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                this.f80357a.lineTo(fCos3, fSin3);
                f14 = fFloatValue4;
                f15 = fFloatValue5;
            } else {
                f14 = fFloatValue4;
                double dAtan2 = (float) (Math.atan2(fSin, f21) - 1.5707963267948966d);
                float fCos4 = (float) Math.cos(dAtan2);
                float fSin4 = (float) Math.sin(dAtan2);
                f15 = fFloatValue5;
                double dAtan3 = (float) (Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                float fCos5 = (float) Math.cos(dAtan3);
                float fSin5 = (float) Math.sin(dAtan3);
                float f24 = z11 ? f14 : f15;
                float f25 = z11 ? f15 : f14;
                float f26 = (z11 ? fFloatValue3 : fFloatValue2) * f24 * 0.47829f;
                float f27 = fCos4 * f26;
                float f28 = f26 * fSin4;
                float f29 = (z11 ? fFloatValue2 : fFloatValue3) * f25 * 0.47829f;
                float f31 = fCos5 * f29;
                float f32 = f29 * fSin5;
                if (f18 != 0.0f) {
                    if (i11 == 0) {
                        f27 *= f18;
                        f28 *= f18;
                    } else if (d15 == d17 - 1.0d) {
                        f31 *= f18;
                        f32 *= f18;
                    }
                }
                this.f80357a.cubicTo(f21 - f27, fSin - f28, fCos3 + f31, fSin3 + f32, fCos3, fSin3);
            }
            d11 += (double) f23;
            z11 = !z11;
            i11++;
            f21 = fCos3;
            fSin = fSin3;
            fFloatValue5 = f15;
            fFloatValue4 = f14;
            f13 = f13;
            f16 = f16;
            dCeil = d17;
        }
    }
}
