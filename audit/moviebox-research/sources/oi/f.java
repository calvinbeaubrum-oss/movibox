package oi;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class f {

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(21)
    public static class a {
        public static void a(@NonNull Outline outline, @NonNull Path path) {
            outline.setConvexPath(path);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(30)
    public static class b {
        public static void a(@NonNull Outline outline, @NonNull Path path) {
            outline.setPath(path);
        }
    }

    @Nullable
    public static Drawable a(@Nullable Drawable drawable, @Nullable Drawable drawable2) {
        return b(drawable, drawable2, -1, -1);
    }

    @Nullable
    public static Drawable b(@Nullable Drawable drawable, @Nullable Drawable drawable2, int i11, int i12) {
        Drawable gVar = drawable2;
        int i13 = i11;
        int intrinsicHeight = i12;
        if (drawable == null) {
            return gVar;
        }
        if (gVar == null) {
            return drawable;
        }
        boolean z11 = (i13 == -1 || intrinsicHeight == -1) ? false : true;
        if (i13 == -1) {
            i13 = i(drawable, drawable2);
        }
        if (intrinsicHeight == -1) {
            intrinsicHeight = h(drawable, drawable2);
        }
        if (i13 > drawable.getIntrinsicWidth() || intrinsicHeight > drawable.getIntrinsicHeight()) {
            float f11 = i13 / intrinsicHeight;
            if (f11 >= drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight()) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                intrinsicHeight = (int) (intrinsicWidth / f11);
                i13 = intrinsicWidth;
            } else {
                intrinsicHeight = drawable.getIntrinsicHeight();
                i13 = (int) (f11 * intrinsicHeight);
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable, gVar});
            layerDrawable.setLayerSize(1, i13, intrinsicHeight);
            layerDrawable.setLayerGravity(1, 17);
            return layerDrawable;
        }
        if (z11) {
            gVar = new g(gVar, i13, intrinsicHeight);
        }
        LayerDrawable layerDrawable2 = new LayerDrawable(new Drawable[]{drawable, gVar});
        int iMax = Math.max((drawable.getIntrinsicWidth() - i13) / 2, 0);
        int iMax2 = Math.max((drawable.getIntrinsicHeight() - intrinsicHeight) / 2, 0);
        layerDrawable2.setLayerInset(1, iMax, iMax2, iMax, iMax2);
        return layerDrawable2;
    }

    @Nullable
    public static Drawable c(@Nullable Drawable drawable, @Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode) {
        return e(drawable, colorStateList, mode, false);
    }

    @Nullable
    public static Drawable d(@Nullable Drawable drawable, @Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode) {
        return e(drawable, colorStateList, mode, Build.VERSION.SDK_INT < 23);
    }

    @Nullable
    public static Drawable e(@Nullable Drawable drawable, @Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, boolean z11) {
        if (drawable == null) {
            return null;
        }
        if (colorStateList != null) {
            drawable = d3.a.r(drawable).mutate();
            if (mode != null) {
                d3.a.p(drawable, mode);
            }
        } else if (z11) {
            drawable.mutate();
        }
        return drawable;
    }

    @NonNull
    public static int[] f(@NonNull int[] iArr) {
        for (int i11 = 0; i11 < iArr.length; i11++) {
            int i12 = iArr[i11];
            if (i12 == 16842912) {
                return iArr;
            }
            if (i12 == 0) {
                int[] iArr2 = (int[]) iArr.clone();
                iArr2[i11] = 16842912;
                return iArr2;
            }
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length + 1);
        iArrCopyOf[iArr.length] = 16842912;
        return iArrCopyOf;
    }

    @Nullable
    public static ColorStateList g(@Nullable Drawable drawable) {
        if (drawable instanceof ColorDrawable) {
            return ColorStateList.valueOf(((ColorDrawable) drawable).getColor());
        }
        if (Build.VERSION.SDK_INT < 29 || !oi.a.a(drawable)) {
            return null;
        }
        return oi.b.a(drawable).getColorStateList();
    }

    public static int h(@NonNull Drawable drawable, @NonNull Drawable drawable2) {
        int intrinsicHeight = drawable2.getIntrinsicHeight();
        return intrinsicHeight != -1 ? intrinsicHeight : drawable.getIntrinsicHeight();
    }

    public static int i(@NonNull Drawable drawable, @NonNull Drawable drawable2) {
        int intrinsicWidth = drawable2.getIntrinsicWidth();
        return intrinsicWidth != -1 ? intrinsicWidth : drawable.getIntrinsicWidth();
    }

    @NonNull
    public static int[] j(@NonNull int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        int i11 = 0;
        for (int i12 : iArr) {
            if (i12 != 16842912) {
                iArr2[i11] = i12;
                i11++;
            }
        }
        return iArr2;
    }

    @NonNull
    public static AttributeSet k(@NonNull Context context, int i11, @NonNull CharSequence charSequence) {
        int next;
        try {
            XmlResourceParser xml = context.getResources().getXml(i11);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            if (TextUtils.equals(xml.getName(), charSequence)) {
                return Xml.asAttributeSet(xml);
            }
            throw new XmlPullParserException("Must have a <" + ((Object) charSequence) + "> start tag");
        } catch (IOException e11) {
            e = e11;
            Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(i11));
            notFoundException.initCause(e);
            throw notFoundException;
        } catch (XmlPullParserException e12) {
            e = e12;
            Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(i11));
            notFoundException2.initCause(e);
            throw notFoundException2;
        }
    }

    public static void l(@NonNull Outline outline, @NonNull Path path) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 30) {
            b.a(outline, path);
            return;
        }
        if (i11 >= 29) {
            try {
                a.a(outline, path);
            } catch (IllegalArgumentException unused) {
            }
        } else if (path.isConvex()) {
            a.a(outline, path);
        }
    }

    @TargetApi(21)
    public static void m(@Nullable RippleDrawable rippleDrawable, int i11) {
        if (Build.VERSION.SDK_INT >= 23) {
            rippleDrawable.setRadius(i11);
            return;
        }
        try {
            RippleDrawable.class.getDeclaredMethod("setMaxRadius", Integer.TYPE).invoke(rippleDrawable, Integer.valueOf(i11));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e11) {
            throw new IllegalStateException("Couldn't set RippleDrawable radius", e11);
        }
    }

    public static void n(@NonNull Drawable drawable, int i11) {
        boolean z11 = i11 != 0;
        if (Build.VERSION.SDK_INT == 21) {
            if (z11) {
                drawable.setColorFilter(i11, PorterDuff.Mode.SRC_IN);
                return;
            } else {
                drawable.setColorFilter(null);
                return;
            }
        }
        if (z11) {
            d3.a.n(drawable, i11);
        } else {
            d3.a.o(drawable, null);
        }
    }

    @Nullable
    public static PorterDuffColorFilter o(@NonNull Drawable drawable, @Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }
}
