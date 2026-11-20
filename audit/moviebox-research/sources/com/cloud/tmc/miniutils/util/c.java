package com.cloud.tmc.miniutils.util;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public static void a(@NonNull View view) {
        view.setTag("TAG_OFFSET");
        Object tag = view.getTag(-123);
        if (tag == null || !((Boolean) tag).booleanValue()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + e(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            view.setTag(-123, Boolean.TRUE);
        }
    }

    public static void b(@NonNull Window window) {
        View viewFindViewWithTag = window.getDecorView().findViewWithTag("TAG_OFFSET");
        if (viewFindViewWithTag == null) {
            return;
        }
        a(viewFindViewWithTag);
    }

    public static int c() {
        Resources resources = e0.a().getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier != 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static String d(int i11) {
        try {
            return e0.a().getResources().getResourceEntryName(i11);
        } catch (Exception unused) {
            return "";
        }
    }

    public static int e() {
        Resources resources = e0.a().getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static void f(@NonNull Window window) {
        View viewFindViewWithTag = ((ViewGroup) window.getDecorView()).findViewWithTag("TAG_STATUS_BAR");
        if (viewFindViewWithTag == null) {
            return;
        }
        viewFindViewWithTag.setVisibility(8);
    }

    public static boolean g(@NonNull Activity activity) {
        return h(activity.getWindow());
    }

    public static boolean h(@NonNull Window window) {
        boolean z11;
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        int childCount = viewGroup.getChildCount();
        int i11 = 0;
        while (true) {
            if (i11 >= childCount) {
                z11 = false;
                break;
            }
            View childAt = viewGroup.getChildAt(i11);
            int id2 = childAt.getId();
            if (id2 != -1 && "navigationBarBackground".equals(d(id2)) && childAt.getVisibility() == 0) {
                z11 = true;
                break;
            }
            i11++;
        }
        if (z11) {
            return (viewGroup.getSystemUiVisibility() & 2) == 0;
        }
        return z11;
    }

    public static void i(@NonNull Activity activity, boolean z11) {
        j(activity.getWindow(), z11);
    }

    public static void j(@NonNull Window window, boolean z11) {
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            int id2 = childAt.getId();
            if (id2 != -1 && "navigationBarBackground".equals(d(id2))) {
                childAt.setVisibility(z11 ? 0 : 4);
            }
        }
        if (z11) {
            viewGroup.setSystemUiVisibility(viewGroup.getSystemUiVisibility() & (-4611));
        } else {
            viewGroup.setSystemUiVisibility(viewGroup.getSystemUiVisibility() | 4610);
        }
    }

    public static void k(@NonNull Activity activity, boolean z11) {
        l(activity.getWindow(), z11);
    }

    public static void l(@NonNull Window window, boolean z11) {
        if (Build.VERSION.SDK_INT >= 23) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z11 ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        }
    }

    public static void m(@NonNull Activity activity, boolean z11) {
        n(activity.getWindow(), z11);
    }

    public static void n(@NonNull Window window, boolean z11) {
        if (z11) {
            window.clearFlags(1024);
            o(window);
            b(window);
        } else {
            window.addFlags(1024);
            f(window);
            q(window);
        }
    }

    public static void o(@NonNull Window window) {
        View viewFindViewWithTag = ((ViewGroup) window.getDecorView()).findViewWithTag("TAG_STATUS_BAR");
        if (viewFindViewWithTag == null) {
            return;
        }
        viewFindViewWithTag.setVisibility(0);
    }

    public static void p(@NonNull View view) {
        Object tag = view.getTag(-123);
        if (tag == null || !((Boolean) tag).booleanValue()) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin - e(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        view.setTag(-123, Boolean.FALSE);
    }

    public static void q(@NonNull Window window) {
        View viewFindViewWithTag = window.getDecorView().findViewWithTag("TAG_OFFSET");
        if (viewFindViewWithTag == null) {
            return;
        }
        p(viewFindViewWithTag);
    }

    public static void r(@NonNull Activity activity) {
        s(activity.getWindow());
    }

    public static void s(@NonNull Window window) {
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1280);
        window.setStatusBarColor(0);
    }
}
