package k6;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f68318a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f68319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f68320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Field f68321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f68322e;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static class a {
        public static float a(View view) {
            return view.getTransitionAlpha();
        }

        public static void b(View view, float f11) {
            view.setTransitionAlpha(f11);
        }
    }

    public void a(@NonNull View view) {
    }

    @SuppressLint({"PrivateApi", "SoonBlockedPrivateApi"})
    public final void b() {
        if (f68320c) {
            return;
        }
        try {
            Class cls = Integer.TYPE;
            Method declaredMethod = View.class.getDeclaredMethod("setFrame", cls, cls, cls, cls);
            f68319b = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException unused) {
        }
        f68320c = true;
    }

    @SuppressLint({"NewApi"})
    public float c(@NonNull View view) {
        if (f68318a) {
            try {
                return a.a(view);
            } catch (NoSuchMethodError unused) {
                f68318a = false;
            }
        }
        return view.getAlpha();
    }

    public void d(@NonNull View view) {
    }

    @SuppressLint({"BanUncheckedReflection"})
    public void e(@NonNull View view, int i11, int i12, int i13, int i14) {
        b();
        Method method = f68319b;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e11) {
                throw new RuntimeException(e11.getCause());
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void f(@NonNull View view, float f11) {
        if (f68318a) {
            try {
                a.b(view, f11);
                return;
            } catch (NoSuchMethodError unused) {
                f68318a = false;
            }
        }
        view.setAlpha(f11);
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public void g(@NonNull View view, int i11) {
        if (!f68322e) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f68321d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f68322e = true;
        }
        Field field = f68321d;
        if (field != null) {
            try {
                f68321d.setInt(view, i11 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public void h(@NonNull View view, @NonNull Matrix matrix) {
        throw null;
    }

    public void i(@NonNull View view, @NonNull Matrix matrix) {
        throw null;
    }
}
