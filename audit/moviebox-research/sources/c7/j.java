package c7;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class j implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f14693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path.FillType f14694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final b7.a f14696d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final b7.d f14697e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f14698f;

    public j(String str, boolean z11, Path.FillType fillType, @Nullable b7.a aVar, @Nullable b7.d dVar, boolean z12) {
        this.f14695c = str;
        this.f14693a = z11;
        this.f14694b = fillType;
        this.f14696d = aVar;
        this.f14697e = dVar;
        this.f14698f = z12;
    }

    @Override // c7.c
    public x6.c a(LottieDrawable lottieDrawable, com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new x6.g(lottieDrawable, aVar, this);
    }

    @Nullable
    public b7.a b() {
        return this.f14696d;
    }

    public Path.FillType c() {
        return this.f14694b;
    }

    public String d() {
        return this.f14695c;
    }

    @Nullable
    public b7.d e() {
        return this.f14697e;
    }

    public boolean f() {
        return this.f14698f;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f14693a + '}';
    }
}
