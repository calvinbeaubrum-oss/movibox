package com.cloud.tmc.miniutils.util;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class p {
    public static void a(@NonNull Activity activity) {
        b(activity.getWindow());
    }

    public static void b(@NonNull Window window) {
        InputMethodManager inputMethodManager = (InputMethodManager) e0.a().getSystemService("input_method");
        if (inputMethodManager == null) {
            return;
        }
        String[] strArr = {"mLastSrvView", "mCurRootView", "mServedView", "mNextServedView"};
        for (int i11 = 0; i11 < 4; i11++) {
            try {
                Field declaredField = InputMethodManager.class.getDeclaredField(strArr[i11]);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                Object obj = declaredField.get(inputMethodManager);
                if ((obj instanceof View) && ((View) obj).getRootView() == window.getDecorView().getRootView()) {
                    declaredField.set(inputMethodManager, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void c() {
        InputMethodManager inputMethodManager = (InputMethodManager) e0.a().getSystemService("input_method");
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.toggleSoftInput(0, 0);
    }
}
