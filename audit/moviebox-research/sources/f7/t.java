package f7;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.w0;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static w0<WeakReference<Interpolator>> f64703b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Interpolator f64702a = new LinearInterpolator();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static JsonReader.a f64704c = JsonReader.a.a("t", "s", "e", "o", "i", "h", "to", "ti");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static JsonReader.a f64705d = JsonReader.a.a("x", "y");

    @Nullable
    public static WeakReference<Interpolator> a(int i11) {
        WeakReference<Interpolator> weakReferenceG;
        synchronized (t.class) {
            weakReferenceG = g().g(i11);
        }
        return weakReferenceG;
    }

    public static Interpolator b(PointF pointF, PointF pointF2) {
        Interpolator interpolatorCreate;
        pointF.x = g7.k.b(pointF.x, -1.0f, 1.0f);
        pointF.y = g7.k.b(pointF.y, -100.0f, 100.0f);
        pointF2.x = g7.k.b(pointF2.x, -1.0f, 1.0f);
        float fB = g7.k.b(pointF2.y, -100.0f, 100.0f);
        pointF2.y = fB;
        int i11 = g7.l.i(pointF.x, pointF.y, pointF2.x, fB);
        WeakReference<Interpolator> weakReferenceA = com.airbnb.lottie.d.e() ? null : a(i11);
        Interpolator interpolator = weakReferenceA != null ? weakReferenceA.get() : null;
        if (weakReferenceA == null || interpolator == null) {
            try {
                interpolatorCreate = PathInterpolatorCompat.create(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e11) {
                interpolatorCreate = "The Path cannot loop back on itself.".equals(e11.getMessage()) ? PathInterpolatorCompat.create(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y) : new LinearInterpolator();
            }
            interpolator = interpolatorCreate;
            if (!com.airbnb.lottie.d.e()) {
                try {
                    h(i11, new WeakReference(interpolator));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
            }
        }
        return interpolator;
    }

    public static <T> h7.a<T> c(JsonReader jsonReader, com.airbnb.lottie.h hVar, float f11, n0<T> n0Var, boolean z11, boolean z12) throws IOException {
        if (z11 && z12) {
            return e(hVar, jsonReader, f11, n0Var);
        }
        return z11 ? d(hVar, jsonReader, f11, n0Var) : f(jsonReader, f11, n0Var);
    }

    public static <T> h7.a<T> d(com.airbnb.lottie.h hVar, JsonReader jsonReader, float f11, n0<T> n0Var) throws IOException {
        Interpolator interpolatorB;
        T t11;
        jsonReader.c();
        PointF pointFE = null;
        PointF pointFE2 = null;
        T tA = null;
        T tA2 = null;
        PointF pointFE3 = null;
        PointF pointFE4 = null;
        boolean z11 = false;
        float fI = 0.0f;
        while (jsonReader.g()) {
            switch (jsonReader.p(f64704c)) {
                case 0:
                    fI = (float) jsonReader.i();
                    break;
                case 1:
                    tA2 = n0Var.a(jsonReader, f11);
                    break;
                case 2:
                    tA = n0Var.a(jsonReader, f11);
                    break;
                case 3:
                    pointFE = s.e(jsonReader, 1.0f);
                    break;
                case 4:
                    pointFE2 = s.e(jsonReader, 1.0f);
                    break;
                case 5:
                    z11 = jsonReader.j() == 1;
                    break;
                case 6:
                    pointFE3 = s.e(jsonReader, f11);
                    break;
                case 7:
                    pointFE4 = s.e(jsonReader, f11);
                    break;
                default:
                    jsonReader.r();
                    break;
            }
        }
        jsonReader.e();
        if (z11) {
            interpolatorB = f64702a;
            t11 = tA2;
        } else {
            interpolatorB = (pointFE == null || pointFE2 == null) ? f64702a : b(pointFE, pointFE2);
            t11 = tA;
        }
        h7.a<T> aVar = new h7.a<>(hVar, tA2, t11, interpolatorB, fI, null);
        aVar.f66363o = pointFE3;
        aVar.f66364p = pointFE4;
        return aVar;
    }

    /* JADX WARN: Code duplicated, block: B:93:0x01ea  */
    public static <T> h7.a<T> e(com.airbnb.lottie.h hVar, JsonReader jsonReader, float f11, n0<T> n0Var) throws IOException {
        Interpolator interpolatorB;
        Interpolator interpolatorB2;
        Interpolator interpolatorB3;
        T t11;
        h7.a<T> aVar;
        PointF pointF;
        float f12;
        PointF pointF2;
        jsonReader.c();
        PointF pointFE = null;
        boolean z11 = false;
        PointF pointFE2 = null;
        PointF pointFE3 = null;
        PointF pointF3 = null;
        T tA = null;
        PointF pointF4 = null;
        PointF pointF5 = null;
        PointF pointF6 = null;
        float fI = 0.0f;
        PointF pointFE4 = null;
        T tA2 = null;
        while (jsonReader.g()) {
            switch (jsonReader.p(f64704c)) {
                case 0:
                    pointF = pointFE;
                    fI = (float) jsonReader.i();
                    pointFE = pointF;
                    break;
                case 1:
                    pointF = pointFE;
                    tA = n0Var.a(jsonReader, f11);
                    pointFE = pointF;
                    break;
                case 2:
                    pointF = pointFE;
                    tA2 = n0Var.a(jsonReader, f11);
                    pointFE = pointF;
                    break;
                case 3:
                    pointF = pointFE;
                    f12 = fI;
                    PointF pointF7 = pointFE4;
                    if (jsonReader.n() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.c();
                        float fI2 = 0.0f;
                        float fI3 = 0.0f;
                        float fI4 = 0.0f;
                        float fI5 = 0.0f;
                        while (jsonReader.g()) {
                            int iP = jsonReader.p(f64705d);
                            if (iP == 0) {
                                JsonReader.Token tokenN = jsonReader.n();
                                JsonReader.Token token = JsonReader.Token.NUMBER;
                                if (tokenN == token) {
                                    fI4 = (float) jsonReader.i();
                                    fI2 = fI4;
                                } else {
                                    jsonReader.b();
                                    fI2 = (float) jsonReader.i();
                                    fI4 = jsonReader.n() == token ? (float) jsonReader.i() : fI2;
                                    jsonReader.d();
                                }
                            } else if (iP != 1) {
                                jsonReader.r();
                            } else {
                                JsonReader.Token tokenN2 = jsonReader.n();
                                JsonReader.Token token2 = JsonReader.Token.NUMBER;
                                if (tokenN2 == token2) {
                                    fI5 = (float) jsonReader.i();
                                    fI3 = fI5;
                                } else {
                                    jsonReader.b();
                                    fI3 = (float) jsonReader.i();
                                    fI5 = jsonReader.n() == token2 ? (float) jsonReader.i() : fI3;
                                    jsonReader.d();
                                }
                            }
                        }
                        PointF pointF8 = new PointF(fI2, fI3);
                        PointF pointF9 = new PointF(fI4, fI5);
                        jsonReader.e();
                        pointF4 = pointF9;
                        pointF3 = pointF8;
                        pointFE4 = pointF7;
                        fI = f12;
                    } else {
                        pointFE2 = s.e(jsonReader, f11);
                        fI = f12;
                        pointFE4 = pointF7;
                    }
                    pointFE = pointF;
                    break;
                case 4:
                    if (jsonReader.n() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.c();
                        float fI6 = 0.0f;
                        float f13 = 0.0f;
                        float fI7 = 0.0f;
                        float fI8 = 0.0f;
                        while (jsonReader.g()) {
                            pointFE4 = pointFE4;
                            int iP2 = jsonReader.p(f64705d);
                            if (iP2 != 0) {
                                pointF2 = pointFE;
                                if (iP2 != 1) {
                                    jsonReader.r();
                                } else {
                                    JsonReader.Token tokenN3 = jsonReader.n();
                                    JsonReader.Token token3 = JsonReader.Token.NUMBER;
                                    if (tokenN3 == token3) {
                                        fI8 = (float) jsonReader.i();
                                        fI = fI;
                                        f13 = fI8;
                                    } else {
                                        float f14 = fI;
                                        jsonReader.b();
                                        float fI9 = (float) jsonReader.i();
                                        float fI10 = jsonReader.n() == token3 ? (float) jsonReader.i() : fI9;
                                        jsonReader.d();
                                        fI = f14;
                                        pointFE = pointF2;
                                        fI8 = fI10;
                                        f13 = fI9;
                                    }
                                }
                            } else {
                                pointF2 = pointFE;
                                float f15 = fI;
                                JsonReader.Token tokenN4 = jsonReader.n();
                                JsonReader.Token token4 = JsonReader.Token.NUMBER;
                                if (tokenN4 == token4) {
                                    fI7 = (float) jsonReader.i();
                                    fI = f15;
                                    fI6 = fI7;
                                } else {
                                    jsonReader.b();
                                    fI6 = (float) jsonReader.i();
                                    fI7 = jsonReader.n() == token4 ? (float) jsonReader.i() : fI6;
                                    jsonReader.d();
                                    fI = f15;
                                }
                            }
                            pointFE = pointF2;
                        }
                        pointF = pointFE;
                        f12 = fI;
                        PointF pointF10 = new PointF(fI6, f13);
                        PointF pointF11 = new PointF(fI7, fI8);
                        jsonReader.e();
                        pointF6 = pointF11;
                        pointF5 = pointF10;
                        fI = f12;
                    } else {
                        pointF = pointFE;
                        pointFE3 = s.e(jsonReader, f11);
                    }
                    pointFE = pointF;
                    break;
                case 5:
                    z11 = jsonReader.j() == 1;
                    break;
                case 6:
                    pointFE4 = s.e(jsonReader, f11);
                    break;
                case 7:
                    pointFE = s.e(jsonReader, f11);
                    break;
                default:
                    jsonReader.r();
                    break;
            }
        }
        PointF pointF12 = pointFE;
        float f16 = fI;
        PointF pointF13 = pointFE4;
        jsonReader.e();
        if (z11) {
            interpolatorB = f64702a;
            t11 = tA;
        } else {
            if (pointFE2 == null || pointFE3 == null) {
                if (pointF3 == null || pointF4 == null || pointF5 == null || pointF6 == null) {
                    interpolatorB = f64702a;
                } else {
                    interpolatorB2 = b(pointF3, pointF5);
                    interpolatorB3 = b(pointF4, pointF6);
                    t11 = tA2;
                    interpolatorB = null;
                }
                if (interpolatorB2 != null || interpolatorB3 == null) {
                    aVar = new h7.a<>(hVar, tA, t11, interpolatorB, f16, null);
                } else {
                    aVar = new h7.a<>(hVar, tA, t11, interpolatorB2, interpolatorB3, f16, null);
                }
                aVar.f66363o = pointF13;
                aVar.f66364p = pointF12;
                return aVar;
            }
            interpolatorB = b(pointFE2, pointFE3);
            t11 = tA2;
        }
        interpolatorB2 = null;
        interpolatorB3 = null;
        if (interpolatorB2 != null) {
            aVar = new h7.a<>(hVar, tA, t11, interpolatorB, f16, null);
        } else {
            aVar = new h7.a<>(hVar, tA, t11, interpolatorB, f16, null);
        }
        aVar.f66363o = pointF13;
        aVar.f66364p = pointF12;
        return aVar;
    }

    public static <T> h7.a<T> f(JsonReader jsonReader, float f11, n0<T> n0Var) throws IOException {
        return new h7.a<>(n0Var.a(jsonReader, f11));
    }

    public static w0<WeakReference<Interpolator>> g() {
        if (f64703b == null) {
            f64703b = new w0<>();
        }
        return f64703b;
    }

    public static void h(int i11, WeakReference<Interpolator> weakReference) {
        synchronized (t.class) {
            f64703b.m(i11, weakReference);
        }
    }
}
