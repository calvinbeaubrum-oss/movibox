package c7;

import com.airbnb.lottie.LottieDrawable;
import x6.r;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class l implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b7.h f14704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f14705d;

    public l(String str, int i11, b7.h hVar, boolean z11) {
        this.f14702a = str;
        this.f14703b = i11;
        this.f14704c = hVar;
        this.f14705d = z11;
    }

    @Override // c7.c
    public x6.c a(LottieDrawable lottieDrawable, com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new r(lottieDrawable, aVar, this);
    }

    public String b() {
        return this.f14702a;
    }

    public b7.h c() {
        return this.f14704c;
    }

    public boolean d() {
        return this.f14705d;
    }

    public String toString() {
        return "ShapePath{name=" + this.f14702a + ", index=" + this.f14703b + '}';
    }
}
