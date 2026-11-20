package h7;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.Nullable;
import com.airbnb.lottie.h;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final h f66349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final T f66350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public T f66351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final Interpolator f66352d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final Interpolator f66353e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final Interpolator f66354f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f66355g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public Float f66356h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f66357i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f66358j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f66359k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f66360l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f66361m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f66362n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PointF f66363o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public PointF f66364p;

    public a(h hVar, @Nullable T t11, @Nullable T t12, @Nullable Interpolator interpolator, float f11, @Nullable Float f12) {
        this.f66357i = -3987645.8f;
        this.f66358j = -3987645.8f;
        this.f66359k = 784923401;
        this.f66360l = 784923401;
        this.f66361m = Float.MIN_VALUE;
        this.f66362n = Float.MIN_VALUE;
        this.f66363o = null;
        this.f66364p = null;
        this.f66349a = hVar;
        this.f66350b = t11;
        this.f66351c = t12;
        this.f66352d = interpolator;
        this.f66353e = null;
        this.f66354f = null;
        this.f66355g = f11;
        this.f66356h = f12;
    }

    public a(h hVar, @Nullable T t11, @Nullable T t12, @Nullable Interpolator interpolator, @Nullable Interpolator interpolator2, float f11, @Nullable Float f12) {
        this.f66357i = -3987645.8f;
        this.f66358j = -3987645.8f;
        this.f66359k = 784923401;
        this.f66360l = 784923401;
        this.f66361m = Float.MIN_VALUE;
        this.f66362n = Float.MIN_VALUE;
        this.f66363o = null;
        this.f66364p = null;
        this.f66349a = hVar;
        this.f66350b = t11;
        this.f66351c = t12;
        this.f66352d = null;
        this.f66353e = interpolator;
        this.f66354f = interpolator2;
        this.f66355g = f11;
        this.f66356h = f12;
    }

    public a(h hVar, @Nullable T t11, @Nullable T t12, @Nullable Interpolator interpolator, @Nullable Interpolator interpolator2, @Nullable Interpolator interpolator3, float f11, @Nullable Float f12) {
        this.f66357i = -3987645.8f;
        this.f66358j = -3987645.8f;
        this.f66359k = 784923401;
        this.f66360l = 784923401;
        this.f66361m = Float.MIN_VALUE;
        this.f66362n = Float.MIN_VALUE;
        this.f66363o = null;
        this.f66364p = null;
        this.f66349a = hVar;
        this.f66350b = t11;
        this.f66351c = t12;
        this.f66352d = interpolator;
        this.f66353e = interpolator2;
        this.f66354f = interpolator3;
        this.f66355g = f11;
        this.f66356h = f12;
    }

    public a(T t11) {
        this.f66357i = -3987645.8f;
        this.f66358j = -3987645.8f;
        this.f66359k = 784923401;
        this.f66360l = 784923401;
        this.f66361m = Float.MIN_VALUE;
        this.f66362n = Float.MIN_VALUE;
        this.f66363o = null;
        this.f66364p = null;
        this.f66349a = null;
        this.f66350b = t11;
        this.f66351c = t11;
        this.f66352d = null;
        this.f66353e = null;
        this.f66354f = null;
        this.f66355g = Float.MIN_VALUE;
        this.f66356h = Float.valueOf(Float.MAX_VALUE);
    }

    public a(T t11, T t12) {
        this.f66357i = -3987645.8f;
        this.f66358j = -3987645.8f;
        this.f66359k = 784923401;
        this.f66360l = 784923401;
        this.f66361m = Float.MIN_VALUE;
        this.f66362n = Float.MIN_VALUE;
        this.f66363o = null;
        this.f66364p = null;
        this.f66349a = null;
        this.f66350b = t11;
        this.f66351c = t12;
        this.f66352d = null;
        this.f66353e = null;
        this.f66354f = null;
        this.f66355g = Float.MIN_VALUE;
        this.f66356h = Float.valueOf(Float.MAX_VALUE);
    }

    public boolean a(float f11) {
        return f11 >= f() && f11 < c();
    }

    public a<T> b(T t11, T t12) {
        return new a<>(t11, t12);
    }

    public float c() {
        if (this.f66349a == null) {
            return 1.0f;
        }
        if (this.f66362n == Float.MIN_VALUE) {
            if (this.f66356h == null) {
                this.f66362n = 1.0f;
            } else {
                this.f66362n = f() + ((this.f66356h.floatValue() - this.f66355g) / this.f66349a.e());
            }
        }
        return this.f66362n;
    }

    public float d() {
        if (this.f66358j == -3987645.8f) {
            this.f66358j = ((Float) this.f66351c).floatValue();
        }
        return this.f66358j;
    }

    public int e() {
        if (this.f66360l == 784923401) {
            this.f66360l = ((Integer) this.f66351c).intValue();
        }
        return this.f66360l;
    }

    public float f() {
        h hVar = this.f66349a;
        if (hVar == null) {
            return 0.0f;
        }
        if (this.f66361m == Float.MIN_VALUE) {
            this.f66361m = (this.f66355g - hVar.p()) / this.f66349a.e();
        }
        return this.f66361m;
    }

    public float g() {
        if (this.f66357i == -3987645.8f) {
            this.f66357i = ((Float) this.f66350b).floatValue();
        }
        return this.f66357i;
    }

    public int h() {
        if (this.f66359k == 784923401) {
            this.f66359k = ((Integer) this.f66350b).intValue();
        }
        return this.f66359k;
    }

    public boolean i() {
        return this.f66352d == null && this.f66353e == null && this.f66354f == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f66350b + ", endValue=" + this.f66351c + ", startFrame=" + this.f66355g + ", endFrame=" + this.f66356h + ", interpolator=" + this.f66352d + '}';
    }
}
