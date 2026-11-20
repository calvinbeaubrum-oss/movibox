package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f1693a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1694b = {-16842910};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f1695c = {R.attr.state_focused};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f1696d = {R.attr.state_activated};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f1697e = {R.attr.state_pressed};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f1698f = {R.attr.state_checked};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f1699g = {R.attr.state_selected};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f1700h = {-16842919, -16842908};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f1701i = new int[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f1702j = new int[1];

    public static void a(@NonNull View view, @NonNull Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R$styleable.AppCompatTheme);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowActionBar)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int b(@NonNull Context context, int i11) {
        ColorStateList colorStateListE = e(context, i11);
        if (colorStateListE != null && colorStateListE.isStateful()) {
            return colorStateListE.getColorForState(f1694b, colorStateListE.getDefaultColor());
        }
        TypedValue typedValueF = f();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValueF, true);
        return d(context, i11, typedValueF.getFloat());
    }

    public static int c(@NonNull Context context, int i11) {
        int[] iArr = f1702j;
        iArr[0] = i11;
        n0 n0VarU = n0.u(context, null, iArr);
        try {
            return n0VarU.b(0, 0);
        } finally {
            n0VarU.x();
        }
    }

    public static int d(@NonNull Context context, int i11, float f11) {
        int iC = c(context, i11);
        return c3.b.k(iC, Math.round(Color.alpha(iC) * f11));
    }

    @Nullable
    public static ColorStateList e(@NonNull Context context, int i11) {
        int[] iArr = f1702j;
        iArr[0] = i11;
        n0 n0VarU = n0.u(context, null, iArr);
        try {
            return n0VarU.c(0);
        } finally {
            n0VarU.x();
        }
    }

    public static TypedValue f() {
        ThreadLocal<TypedValue> threadLocal = f1693a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }
}
