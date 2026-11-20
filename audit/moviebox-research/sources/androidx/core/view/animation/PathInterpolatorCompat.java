package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class PathInterpolatorCompat {

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(21)
    public static class a {
        public static Interpolator a(float f11, float f12) {
            return new PathInterpolator(f11, f12);
        }

        public static Interpolator b(float f11, float f12, float f13, float f14) {
            return new PathInterpolator(f11, f12, f13, f14);
        }

        public static Interpolator c(Path path) {
            return new PathInterpolator(path);
        }
    }

    private PathInterpolatorCompat() {
    }

    @NonNull
    public static Interpolator create(float f11, float f12) {
        return a.a(f11, f12);
    }

    @NonNull
    public static Interpolator create(float f11, float f12, float f13, float f14) {
        return a.b(f11, f12, f13, f14);
    }

    @NonNull
    public static Interpolator create(@NonNull Path path) {
        return a.c(path);
    }
}
