package k6;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
public class f0 extends c0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f68342f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f68343g = true;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static class a {
        public static void a(View view, Matrix matrix) {
            view.setAnimationMatrix(matrix);
        }

        public static void b(View view, Matrix matrix) {
            view.transformMatrixToGlobal(matrix);
        }

        public static void c(View view, Matrix matrix) {
            view.transformMatrixToLocal(matrix);
        }
    }

    @Override // k6.c0
    @SuppressLint({"NewApi"})
    public void h(@NonNull View view, @NonNull Matrix matrix) {
        if (f68342f) {
            try {
                a.b(view, matrix);
            } catch (NoSuchMethodError unused) {
                f68342f = false;
            }
        }
    }

    @Override // k6.c0
    @SuppressLint({"NewApi"})
    public void i(@NonNull View view, @NonNull Matrix matrix) {
        if (f68343g) {
            try {
                a.c(view, matrix);
            } catch (NoSuchMethodError unused) {
                f68343g = false;
            }
        }
    }
}
