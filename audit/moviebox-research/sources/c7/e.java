package c7;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.GradientType;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GradientType f14668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path.FillType f14669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b7.c f14670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b7.d f14671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b7.f f14672e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b7.f f14673f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f14674g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final b7.b f14675h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final b7.b f14676i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f14677j;

    public e(String str, GradientType gradientType, Path.FillType fillType, b7.c cVar, b7.d dVar, b7.f fVar, b7.f fVar2, b7.b bVar, b7.b bVar2, boolean z11) {
        this.f14668a = gradientType;
        this.f14669b = fillType;
        this.f14670c = cVar;
        this.f14671d = dVar;
        this.f14672e = fVar;
        this.f14673f = fVar2;
        this.f14674g = str;
        this.f14675h = bVar;
        this.f14676i = bVar2;
        this.f14677j = z11;
    }

    @Override // c7.c
    public x6.c a(LottieDrawable lottieDrawable, com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new x6.h(lottieDrawable, hVar, aVar, this);
    }

    public b7.f b() {
        return this.f14673f;
    }

    public Path.FillType c() {
        return this.f14669b;
    }

    public b7.c d() {
        return this.f14670c;
    }

    public GradientType e() {
        return this.f14668a;
    }

    public String f() {
        return this.f14674g;
    }

    public b7.d g() {
        return this.f14671d;
    }

    public b7.f h() {
        return this.f14672e;
    }

    public boolean i() {
        return this.f14677j;
    }
}
