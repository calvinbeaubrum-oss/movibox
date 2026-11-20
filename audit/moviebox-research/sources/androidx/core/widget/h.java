package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(21)
    public static class a {
        public static ColorStateList a(ImageView imageView) {
            return imageView.getImageTintList();
        }

        public static PorterDuff.Mode b(ImageView imageView) {
            return imageView.getImageTintMode();
        }

        public static void c(ImageView imageView, ColorStateList colorStateList) {
            imageView.setImageTintList(colorStateList);
        }

        public static void d(ImageView imageView, PorterDuff.Mode mode) {
            imageView.setImageTintMode(mode);
        }
    }

    @Nullable
    public static ColorStateList a(@NonNull ImageView imageView) {
        return a.a(imageView);
    }

    @Nullable
    public static PorterDuff.Mode b(@NonNull ImageView imageView) {
        return a.b(imageView);
    }

    public static void c(@NonNull ImageView imageView, @Nullable ColorStateList colorStateList) {
        Drawable drawable;
        int i11 = Build.VERSION.SDK_INT;
        a.c(imageView, colorStateList);
        if (i11 != 21 || (drawable = imageView.getDrawable()) == null || a.a(imageView) == null) {
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(imageView.getDrawableState());
        }
        imageView.setImageDrawable(drawable);
    }

    public static void d(@NonNull ImageView imageView, @Nullable PorterDuff.Mode mode) {
        Drawable drawable;
        int i11 = Build.VERSION.SDK_INT;
        a.d(imageView, mode);
        if (i11 != 21 || (drawable = imageView.getDrawable()) == null || a.a(imageView) == null) {
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(imageView.getDrawableState());
        }
        imageView.setImageDrawable(drawable);
    }
}
