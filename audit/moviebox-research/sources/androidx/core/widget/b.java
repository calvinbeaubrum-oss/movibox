package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Field f8093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f8094b;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(21)
    public static class a {
        public static ColorStateList a(CompoundButton compoundButton) {
            return compoundButton.getButtonTintList();
        }

        public static PorterDuff.Mode b(CompoundButton compoundButton) {
            return compoundButton.getButtonTintMode();
        }

        public static void c(CompoundButton compoundButton, ColorStateList colorStateList) {
            compoundButton.setButtonTintList(colorStateList);
        }

        public static void d(CompoundButton compoundButton, PorterDuff.Mode mode) {
            compoundButton.setButtonTintMode(mode);
        }
    }

    /* JADX INFO: renamed from: androidx.core.widget.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @RequiresApi(23)
    public static class C0077b {
        public static Drawable a(CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }

    @Nullable
    public static Drawable a(@NonNull CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 23) {
            return C0077b.a(compoundButton);
        }
        if (!f8094b) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f8093a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f8094b = true;
        }
        Field field = f8093a;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException unused2) {
                f8093a = null;
            }
        }
        return null;
    }

    @Nullable
    public static ColorStateList b(@NonNull CompoundButton compoundButton) {
        return a.a(compoundButton);
    }

    @Nullable
    public static PorterDuff.Mode c(@NonNull CompoundButton compoundButton) {
        return a.b(compoundButton);
    }

    public static void d(@NonNull CompoundButton compoundButton, @Nullable ColorStateList colorStateList) {
        a.c(compoundButton, colorStateList);
    }

    public static void e(@NonNull CompoundButton compoundButton, @Nullable PorterDuff.Mode mode) {
        a.d(compoundButton, mode);
    }
}
