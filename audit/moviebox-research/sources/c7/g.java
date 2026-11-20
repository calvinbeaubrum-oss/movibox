package c7;

import androidx.annotation.Nullable;
import b7.n;
import com.airbnb.lottie.LottieDrawable;
import x6.p;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class g implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b7.b f14684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b7.b f14685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n f14686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f14687e;

    public g(String str, b7.b bVar, b7.b bVar2, n nVar, boolean z11) {
        this.f14683a = str;
        this.f14684b = bVar;
        this.f14685c = bVar2;
        this.f14686d = nVar;
        this.f14687e = z11;
    }

    @Override // c7.c
    @Nullable
    public x6.c a(LottieDrawable lottieDrawable, com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new p(lottieDrawable, aVar, this);
    }

    public b7.b b() {
        return this.f14684b;
    }

    public String c() {
        return this.f14683a;
    }

    public b7.b d() {
        return this.f14685c;
    }

    public n e() {
        return this.f14686d;
    }

    public boolean f() {
        return this.f14687e;
    }
}
