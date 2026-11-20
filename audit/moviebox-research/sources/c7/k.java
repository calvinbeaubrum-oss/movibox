package c7;

import com.airbnb.lottie.LottieDrawable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class k implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c> f14700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f14701c;

    public k(String str, List<c> list, boolean z11) {
        this.f14699a = str;
        this.f14700b = list;
        this.f14701c = z11;
    }

    @Override // c7.c
    public x6.c a(LottieDrawable lottieDrawable, com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new x6.d(lottieDrawable, aVar, this, hVar);
    }

    public List<c> b() {
        return this.f14700b;
    }

    public String c() {
        return this.f14699a;
    }

    public boolean d() {
        return this.f14701c;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f14699a + "' Shapes: " + Arrays.toString(this.f14700b.toArray()) + '}';
    }
}
