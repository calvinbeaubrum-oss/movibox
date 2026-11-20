package b7;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class n implements c7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final e f14050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final o<PointF, PointF> f14051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final g f14052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final b f14053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final d f14054e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final b f14055f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final b f14056g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final b f14057h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final b f14058i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f14059j;

    public n() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public n(@Nullable e eVar, @Nullable o<PointF, PointF> oVar, @Nullable g gVar, @Nullable b bVar, @Nullable d dVar, @Nullable b bVar2, @Nullable b bVar3, @Nullable b bVar4, @Nullable b bVar5) {
        this.f14059j = false;
        this.f14050a = eVar;
        this.f14051b = oVar;
        this.f14052c = gVar;
        this.f14053d = bVar;
        this.f14054e = dVar;
        this.f14057h = bVar2;
        this.f14058i = bVar3;
        this.f14055f = bVar4;
        this.f14056g = bVar5;
    }

    @Override // c7.c
    @Nullable
    public x6.c a(LottieDrawable lottieDrawable, com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return null;
    }

    public y6.p b() {
        return new y6.p(this);
    }

    @Nullable
    public e c() {
        return this.f14050a;
    }

    @Nullable
    public b d() {
        return this.f14058i;
    }

    @Nullable
    public d e() {
        return this.f14054e;
    }

    @Nullable
    public o<PointF, PointF> f() {
        return this.f14051b;
    }

    @Nullable
    public b g() {
        return this.f14053d;
    }

    @Nullable
    public g h() {
        return this.f14052c;
    }

    @Nullable
    public b i() {
        return this.f14055f;
    }

    @Nullable
    public b j() {
        return this.f14056g;
    }

    @Nullable
    public b k() {
        return this.f14057h;
    }

    public boolean l() {
        return this.f14059j;
    }

    public void m(boolean z11) {
        this.f14059j = z11;
    }
}
