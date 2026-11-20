package a7;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PointF f418c;

    public a() {
        this.f416a = new PointF();
        this.f417b = new PointF();
        this.f418c = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f416a = pointF;
        this.f417b = pointF2;
        this.f418c = pointF3;
    }

    public PointF a() {
        return this.f416a;
    }

    public PointF b() {
        return this.f417b;
    }

    public PointF c() {
        return this.f418c;
    }

    public void d(float f11, float f12) {
        this.f416a.set(f11, f12);
    }

    public void e(float f11, float f12) {
        this.f417b.set(f11, f12);
    }

    public void f(float f11, float f12) {
        this.f418c.set(f11, f12);
    }

    @NonNull
    @SuppressLint({"DefaultLocale"})
    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.f418c.x), Float.valueOf(this.f418c.y), Float.valueOf(this.f416a.x), Float.valueOf(this.f416a.y), Float.valueOf(this.f417b.x), Float.valueOf(this.f417b.y));
    }
}
