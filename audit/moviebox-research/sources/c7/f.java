package c7;

import android.graphics.PointF;
import b7.o;
import com.airbnb.lottie.LottieDrawable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class f implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o<PointF, PointF> f14679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o<PointF, PointF> f14680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b7.b f14681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f14682e;

    public f(String str, o<PointF, PointF> oVar, o<PointF, PointF> oVar2, b7.b bVar, boolean z11) {
        this.f14678a = str;
        this.f14679b = oVar;
        this.f14680c = oVar2;
        this.f14681d = bVar;
        this.f14682e = z11;
    }

    @Override // c7.c
    public x6.c a(LottieDrawable lottieDrawable, com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new x6.o(lottieDrawable, aVar, this);
    }

    public b7.b b() {
        return this.f14681d;
    }

    public String c() {
        return this.f14678a;
    }

    public o<PointF, PointF> d() {
        return this.f14679b;
    }

    public o<PointF, PointF> e() {
        return this.f14680c;
    }

    public boolean f() {
        return this.f14682e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f14679b + ", size=" + this.f14680c + '}';
    }
}
