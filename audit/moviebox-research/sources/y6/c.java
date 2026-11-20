package y6;

import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements y6.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.airbnb.lottie.model.layer.a f81241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y6.a.b f81242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y6.a<Integer, Integer> f81243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f81244d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f81245e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f81246f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f81247g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f81248h = Float.NaN;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f81249i = Float.NaN;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f81250j = Float.NaN;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f81251k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float[] f81252l = new float[9];

    /* JADX INFO: compiled from: source.java */
    public class a extends h7.c<Float> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ h7.c f81253d;

        public a(h7.c cVar) {
            this.f81253d = cVar;
        }

        @Override // h7.c
        @Nullable
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Float a(h7.b<Float> bVar) {
            Float f11 = (Float) this.f81253d.a(bVar);
            if (f11 == null) {
                return null;
            }
            return Float.valueOf(f11.floatValue() * 2.55f);
        }
    }

    public c(y6.a.b bVar, com.airbnb.lottie.model.layer.a aVar, f7.j jVar) {
        this.f81242b = bVar;
        this.f81241a = aVar;
        y6.a<Integer, Integer> aVarA = jVar.a().a();
        this.f81243c = aVarA;
        aVarA.a(this);
        aVar.i(aVarA);
        d dVarA = jVar.d().a();
        this.f81244d = dVarA;
        dVarA.a(this);
        aVar.i(dVarA);
        d dVarA2 = jVar.b().a();
        this.f81245e = dVarA2;
        dVarA2.a(this);
        aVar.i(dVarA2);
        d dVarA3 = jVar.c().a();
        this.f81246f = dVarA3;
        dVarA3.a(this);
        aVar.i(dVarA3);
        d dVarA4 = jVar.e().a();
        this.f81247g = dVarA4;
        dVarA4.a(this);
        aVar.i(dVarA4);
    }

    public void a(Paint paint, Matrix matrix, int i11) {
        float fQ = this.f81245e.q() * 0.017453292f;
        float fFloatValue = this.f81246f.h().floatValue();
        double d11 = fQ;
        float fSin = ((float) Math.sin(d11)) * fFloatValue;
        float fCos = ((float) Math.cos(d11 + 3.141592653589793d)) * fFloatValue;
        this.f81241a.f15254x.f().getValues(this.f81252l);
        float[] fArr = this.f81252l;
        float f11 = fArr[0];
        float f12 = fArr[4];
        matrix.getValues(fArr);
        float[] fArr2 = this.f81252l;
        float f13 = fArr2[0] / f11;
        float f14 = fSin * f13;
        float f15 = fCos * (fArr2[4] / f12);
        int iIntValue = this.f81243c.h().intValue();
        int iArgb = Color.argb(Math.round((this.f81244d.h().floatValue() * i11) / 255.0f), Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue));
        float fMax = Math.max(this.f81247g.h().floatValue() * f13, Float.MIN_VALUE);
        if (this.f81248h == fMax && this.f81249i == f14 && this.f81250j == f15 && this.f81251k == iArgb) {
            return;
        }
        this.f81248h = fMax;
        this.f81249i = f14;
        this.f81250j = f15;
        this.f81251k = iArgb;
        paint.setShadowLayer(fMax, f14, f15, iArgb);
    }

    @Override // y6.a.b
    public void b() {
        this.f81242b.b();
    }

    public void c(@Nullable h7.c<Integer> cVar) {
        this.f81243c.o(cVar);
    }

    public void d(@Nullable h7.c<Float> cVar) {
        this.f81245e.o(cVar);
    }

    public void e(@Nullable h7.c<Float> cVar) {
        this.f81246f.o(cVar);
    }

    public void f(@Nullable h7.c<Float> cVar) {
        if (cVar == null) {
            this.f81244d.o(null);
        } else {
            this.f81244d.o(new a(cVar));
        }
    }

    public void g(@Nullable h7.c<Float> cVar) {
        this.f81247g.o(cVar);
    }
}
