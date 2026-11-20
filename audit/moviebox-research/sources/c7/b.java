package c7;

import android.graphics.PointF;
import b7.o;
import com.airbnb.lottie.LottieDrawable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o<PointF, PointF> f14662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b7.f f14663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f14664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f14665e;

    public b(String str, o<PointF, PointF> oVar, b7.f fVar, boolean z11, boolean z12) {
        this.f14661a = str;
        this.f14662b = oVar;
        this.f14663c = fVar;
        this.f14664d = z11;
        this.f14665e = z12;
    }

    @Override // c7.c
    public x6.c a(LottieDrawable lottieDrawable, com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new x6.f(lottieDrawable, aVar, this);
    }

    public String b() {
        return this.f14661a;
    }

    public o<PointF, PointF> c() {
        return this.f14662b;
    }

    public b7.f d() {
        return this.f14663c;
    }

    public boolean e() {
        return this.f14665e;
    }

    public boolean f() {
        return this.f14664d;
    }
}
