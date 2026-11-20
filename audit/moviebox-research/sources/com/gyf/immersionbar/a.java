package com.gyf.immersionbar;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f41608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f41609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f41610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f41611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f41612e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f41613f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f41614g;

    public a(Activity activity) {
        this.f41613f = activity.getResources().getConfiguration().orientation == 1;
        this.f41614g = j(activity);
        this.f41608a = c(activity, "status_bar_height");
        this.f41609b = b(activity);
        int iE = e(activity);
        this.f41611d = iE;
        this.f41612e = h(activity);
        this.f41610c = iE > 0;
    }

    public static int c(Context context, String str) {
        try {
            int identifier = Resources.getSystem().getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                int dimensionPixelSize2 = Resources.getSystem().getDimensionPixelSize(identifier);
                if (dimensionPixelSize2 >= dimensionPixelSize && (Build.VERSION.SDK_INT < 29 || str.equals("status_bar_height"))) {
                    return dimensionPixelSize2;
                }
                float f11 = (dimensionPixelSize * Resources.getSystem().getDisplayMetrics().density) / context.getResources().getDisplayMetrics().density;
                return (int) (f11 >= 0.0f ? f11 + 0.5f : f11 - 0.5f);
            }
        } catch (Resources.NotFoundException unused) {
        }
        return 0;
    }

    public static int f(@NonNull Context context) {
        return c(context, context.getResources().getConfiguration().orientation == 1 ? "navigation_bar_height" : "navigation_bar_height_landscape");
    }

    public static int i(@NonNull Context context) {
        return c(context, "navigation_bar_width");
    }

    public int a() {
        return this.f41609b;
    }

    @TargetApi(14)
    public final int b(Activity activity) {
        View viewFindViewById = activity.getWindow().findViewById(R$id.action_bar_container);
        int measuredHeight = viewFindViewById != null ? viewFindViewById.getMeasuredHeight() : 0;
        if (measuredHeight != 0) {
            return measuredHeight;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
        return TypedValue.complexToDimensionPixelSize(typedValue.data, activity.getResources().getDisplayMetrics());
    }

    public int d() {
        return this.f41611d;
    }

    @TargetApi(14)
    public final int e(Context context) {
        if (l((Activity) context)) {
            return f(context);
        }
        return 0;
    }

    public int g() {
        return this.f41612e;
    }

    @TargetApi(14)
    public final int h(Context context) {
        if (l((Activity) context)) {
            return c(context, "navigation_bar_width");
        }
        return 0;
    }

    @SuppressLint({"NewApi"})
    public final float j(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        float f11 = displayMetrics.widthPixels;
        float f12 = displayMetrics.density;
        return Math.min(f11 / f12, displayMetrics.heightPixels / f12);
    }

    public int k() {
        return this.f41608a;
    }

    @TargetApi(14)
    public final boolean l(Activity activity) {
        g.a aVarA = g.a(activity);
        if (!aVarA.f41658b && aVarA.f41657a) {
            return false;
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i11 = displayMetrics.heightPixels;
        int i12 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        return i12 - displayMetrics2.widthPixels > 0 || i11 - displayMetrics2.heightPixels > 0;
    }

    public boolean m() {
        return this.f41610c;
    }

    public boolean n() {
        return this.f41614g >= 600.0f || this.f41613f;
    }
}
