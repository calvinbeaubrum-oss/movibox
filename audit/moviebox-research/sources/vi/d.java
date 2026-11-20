package vi;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.n0;
import com.google.android.material.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class d {
    @Nullable
    public static ColorStateList a(@NonNull Context context, @NonNull TypedArray typedArray, int i11) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!typedArray.hasValue(i11) || (resourceId = typedArray.getResourceId(i11, 0)) == 0 || (colorStateListA = d1.a.a(context, resourceId)) == null) ? typedArray.getColorStateList(i11) : colorStateListA;
    }

    @Nullable
    public static ColorStateList b(@NonNull Context context, @NonNull n0 n0Var, int i11) {
        int iN;
        ColorStateList colorStateListA;
        return (!n0Var.s(i11) || (iN = n0Var.n(i11, 0)) == 0 || (colorStateListA = d1.a.a(context, iN)) == null) ? n0Var.c(i11) : colorStateListA;
    }

    public static int c(TypedValue typedValue) {
        return Build.VERSION.SDK_INT >= 22 ? typedValue.getComplexUnit() : typedValue.data & 15;
    }

    public static int d(@NonNull Context context, @NonNull TypedArray typedArray, int i11, int i12) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i11, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i11, i12);
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, i12);
        typedArrayObtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    @Nullable
    public static Drawable e(@NonNull Context context, @NonNull TypedArray typedArray, int i11) {
        int resourceId;
        Drawable drawableB;
        return (!typedArray.hasValue(i11) || (resourceId = typedArray.getResourceId(i11, 0)) == 0 || (drawableB = d1.a.b(context, resourceId)) == null) ? typedArray.getDrawable(i11) : drawableB;
    }

    public static float f(@NonNull Context context) {
        return context.getResources().getConfiguration().fontScale;
    }

    public static int g(@NonNull TypedArray typedArray, int i11, int i12) {
        return typedArray.hasValue(i11) ? i11 : i12;
    }

    @Nullable
    public static e h(@NonNull Context context, @NonNull TypedArray typedArray, int i11) {
        int resourceId;
        if (!typedArray.hasValue(i11) || (resourceId = typedArray.getResourceId(i11, 0)) == 0) {
            return null;
        }
        return new e(context, resourceId);
    }

    public static int i(@NonNull Context context, int i11, int i12) {
        if (i11 == 0) {
            return i12;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i11, R$styleable.TextAppearance);
        TypedValue typedValue = new TypedValue();
        boolean value = typedArrayObtainStyledAttributes.getValue(R$styleable.TextAppearance_android_textSize, typedValue);
        typedArrayObtainStyledAttributes.recycle();
        if (value) {
            return c(typedValue) == 2 ? Math.round(TypedValue.complexToFloat(typedValue.data) * context.getResources().getDisplayMetrics().density) : TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }
        return i12;
    }

    public static boolean j(@NonNull Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static boolean k(@NonNull Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }
}
