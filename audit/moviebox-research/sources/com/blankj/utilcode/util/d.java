package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static int a() {
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier != 0) {
            return system.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static String b(int i11) {
        try {
            return Utils.a().getResources().getResourceEntryName(i11);
        } catch (Exception unused) {
            return "";
        }
    }

    public static int c() {
        Resources system = Resources.getSystem();
        return system.getDimensionPixelSize(system.getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static boolean d(@NonNull Activity activity) {
        return e(activity.getWindow());
    }

    public static boolean e(@NonNull Window window) {
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
            if (id2 != -1 && "navigationBarBackground".equals(b(id2)) && childAt.getVisibility() == 0) {
                z11 = true;
                break;
            }
            i11++;
        }
        if (!z11) {
            return z11;
        }
        if (j0.B() && Build.VERSION.SDK_INT < 29) {
            try {
                return Settings.Global.getInt(Utils.a().getContentResolver(), "navigationbar_hide_bar_enabled") == 0;
            } catch (Exception unused) {
            }
        }
        return (viewGroup.getSystemUiVisibility() & 2) == 0;
    }
}
