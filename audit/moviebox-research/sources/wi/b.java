package wi;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.material.R$attr;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f79522a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f79523b = {R.attr.state_pressed};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f79524c = {R.attr.state_hovered, R.attr.state_focused};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f79525d = {R.attr.state_focused};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f79526e = {R.attr.state_hovered};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f79527f = {R.attr.state_selected, R.attr.state_pressed};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f79528g = {R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f79529h = {R.attr.state_selected, R.attr.state_focused};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f79530i = {R.attr.state_selected, R.attr.state_hovered};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f79531j = {R.attr.state_selected};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f79532k = {R.attr.state_enabled, R.attr.state_pressed};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f79533l = b.class.getSimpleName();

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(21)
    public static class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static Drawable b(@NonNull Context context, int i11) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            gradientDrawable.setShape(1);
            return new RippleDrawable(com.google.android.material.color.b.g(context, R$attr.colorControlHighlight, ColorStateList.valueOf(0)), null, new InsetDrawable((Drawable) gradientDrawable, i11, i11, i11, i11));
        }
    }

    @NonNull
    public static ColorStateList a(@Nullable ColorStateList colorStateList) {
        if (f79522a) {
            int[] iArr = f79525d;
            return new ColorStateList(new int[][]{f79531j, iArr, StateSet.NOTHING}, new int[]{d(colorStateList, f79527f), d(colorStateList, iArr), d(colorStateList, f79523b)});
        }
        int[] iArr2 = f79527f;
        int[] iArr3 = f79528g;
        int[] iArr4 = f79529h;
        int[] iArr5 = f79530i;
        int[] iArr6 = f79523b;
        int[] iArr7 = f79524c;
        int[] iArr8 = f79525d;
        int[] iArr9 = f79526e;
        return new ColorStateList(new int[][]{iArr2, iArr3, iArr4, iArr5, f79531j, iArr6, iArr7, iArr8, iArr9, StateSet.NOTHING}, new int[]{d(colorStateList, iArr2), d(colorStateList, iArr3), d(colorStateList, iArr4), d(colorStateList, iArr5), 0, d(colorStateList, iArr6), d(colorStateList, iArr7), d(colorStateList, iArr8), d(colorStateList, iArr9), 0});
    }

    @NonNull
    @RequiresApi(21)
    public static Drawable b(@NonNull Context context, int i11) {
        return a.b(context, i11);
    }

    @TargetApi(21)
    public static int c(int i11) {
        return c3.b.k(i11, Math.min(Color.alpha(i11) * 2, 255));
    }

    public static int d(@Nullable ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return f79522a ? c(colorForState) : colorForState;
    }

    @NonNull
    public static ColorStateList e(@Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 22 && i11 <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f79532k, 0)) != 0) {
            Log.w(f79533l, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        }
        return colorStateList;
    }

    public static boolean f(@NonNull int[] iArr) {
        boolean z11 = false;
        boolean z12 = false;
        for (int i11 : iArr) {
            if (i11 == 16842910) {
                z11 = true;
            } else if (i11 == 16842908 || i11 == 16842919 || i11 == 16843623) {
                z12 = true;
            }
        }
        return z11 && z12;
    }
}
