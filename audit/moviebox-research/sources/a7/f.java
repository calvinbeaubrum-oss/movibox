package a7;

import androidx.annotation.Nullable;
import androidx.collection.x;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f433b = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x<String, com.airbnb.lottie.h> f434a = new x<>(20);

    public static f b() {
        return f433b;
    }

    @Nullable
    public com.airbnb.lottie.h a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.f434a.get(str);
    }

    public void c(@Nullable String str, com.airbnb.lottie.h hVar) {
        if (str == null) {
            return;
        }
        this.f434a.put(str, hVar);
    }
}
