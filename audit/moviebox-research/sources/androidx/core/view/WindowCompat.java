package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class WindowCompat {
    public static final int FEATURE_ACTION_BAR = 8;
    public static final int FEATURE_ACTION_BAR_OVERLAY = 9;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;

    /* JADX INFO: compiled from: source.java */
    public static class a {
        public static void a(@NonNull Window window, boolean z11) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z11 ? systemUiVisibility & (-1793) : systemUiVisibility | 1792);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(28)
    public static class b {
        public static <T> T a(Window window, int i11) {
            return (T) window.requireViewById(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(30)
    public static class c {
        public static void a(@NonNull Window window, boolean z11) {
            window.setDecorFitsSystemWindows(z11);
        }
    }

    private WindowCompat() {
    }

    @NonNull
    public static WindowInsetsControllerCompat getInsetsController(@NonNull Window window, @NonNull View view) {
        return new WindowInsetsControllerCompat(window, view);
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull Window window, int i11) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T) b.a(window, i11);
        }
        T t11 = (T) window.findViewById(i11);
        if (t11 != null) {
            return t11;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Window");
    }

    public static void setDecorFitsSystemWindows(@NonNull Window window, boolean z11) {
        if (Build.VERSION.SDK_INT >= 30) {
            c.a(window, z11);
        } else {
            a.a(window, z11);
        }
    }
}
