package d3;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Method f62874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f62875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f62876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f62877d;

    /* JADX INFO: renamed from: d3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @RequiresApi(21)
    public static class C0643a {
        public static void a(Drawable drawable, Resources.Theme theme) {
            drawable.applyTheme(theme);
        }

        public static boolean b(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        public static ColorFilter c(Drawable drawable) {
            return drawable.getColorFilter();
        }

        public static void d(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        public static void e(Drawable drawable, float f11, float f12) {
            drawable.setHotspot(f11, f12);
        }

        public static void f(Drawable drawable, int i11, int i12, int i13, int i14) {
            drawable.setHotspotBounds(i11, i12, i13, i14);
        }

        public static void g(Drawable drawable, int i11) {
            drawable.setTint(i11);
        }

        public static void h(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        public static void i(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(23)
    public static class b {
        public static int a(Drawable drawable) {
            return drawable.getLayoutDirection();
        }

        public static boolean b(Drawable drawable, int i11) {
            return drawable.setLayoutDirection(i11);
        }
    }

    public static void a(@NonNull Drawable drawable, @NonNull Resources.Theme theme) {
        C0643a.a(drawable, theme);
    }

    public static boolean b(@NonNull Drawable drawable) {
        return C0643a.b(drawable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(@NonNull Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        if (Build.VERSION.SDK_INT >= 23) {
            drawable.clearColorFilter();
            return;
        }
        drawable.clearColorFilter();
        if (drawable instanceof InsetDrawable) {
            c(((InsetDrawable) drawable).getDrawable());
            return;
        }
        if (drawable instanceof c) {
            c(((c) drawable).a());
            return;
        }
        if (!(drawable instanceof DrawableContainer) || (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) == null) {
            return;
        }
        int childCount = drawableContainerState.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            Drawable child = drawableContainerState.getChild(i11);
            if (child != null) {
                c(child);
            }
        }
    }

    public static int d(@NonNull Drawable drawable) {
        return drawable.getAlpha();
    }

    @Nullable
    public static ColorFilter e(@NonNull Drawable drawable) {
        return C0643a.c(drawable);
    }

    public static int f(@NonNull Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            return b.a(drawable);
        }
        if (!f62877d) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                f62876c = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f62877d = true;
        }
        Method method = f62876c;
        if (method != null) {
            try {
                return ((Integer) method.invoke(drawable, new Object[0])).intValue();
            } catch (Exception unused2) {
                f62876c = null;
            }
        }
        return 0;
    }

    public static void g(@NonNull Drawable drawable, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        C0643a.d(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static boolean h(@NonNull Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    @Deprecated
    public static void i(@NonNull Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void j(@NonNull Drawable drawable, boolean z11) {
        drawable.setAutoMirrored(z11);
    }

    public static void k(@NonNull Drawable drawable, float f11, float f12) {
        C0643a.e(drawable, f11, f12);
    }

    public static void l(@NonNull Drawable drawable, int i11, int i12, int i13, int i14) {
        C0643a.f(drawable, i11, i12, i13, i14);
    }

    public static boolean m(@NonNull Drawable drawable, int i11) {
        if (Build.VERSION.SDK_INT >= 23) {
            return b.b(drawable, i11);
        }
        if (!f62875b) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                f62874a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f62875b = true;
        }
        Method method = f62874a;
        if (method != null) {
            try {
                method.invoke(drawable, Integer.valueOf(i11));
                return true;
            } catch (Exception unused2) {
                f62874a = null;
            }
        }
        return false;
    }

    public static void n(@NonNull Drawable drawable, int i11) {
        C0643a.g(drawable, i11);
    }

    public static void o(@NonNull Drawable drawable, @Nullable ColorStateList colorStateList) {
        C0643a.h(drawable, colorStateList);
    }

    public static void p(@NonNull Drawable drawable, @Nullable PorterDuff.Mode mode) {
        C0643a.i(drawable, mode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T q(@NonNull Drawable drawable) {
        return drawable instanceof c ? (T) ((c) drawable).a() : drawable;
    }

    @NonNull
    public static Drawable r(@NonNull Drawable drawable) {
        return (Build.VERSION.SDK_INT < 23 && !(drawable instanceof d3.b)) ? new e(drawable) : drawable;
    }
}
