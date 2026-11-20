package c7;

import androidx.annotation.Nullable;
import b7.o;
import com.airbnb.lottie.LottieDrawable;
import x6.q;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class h implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o<Float, Float> f14689b;

    public h(String str, o<Float, Float> oVar) {
        this.f14688a = str;
        this.f14689b = oVar;
    }

    @Override // c7.c
    @Nullable
    public x6.c a(LottieDrawable lottieDrawable, com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new q(lottieDrawable, aVar, this);
    }

    public o<Float, Float> b() {
        return this.f14689b;
    }

    public String c() {
        return this.f14688a;
    }
}
