package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Method f8100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f8101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Field f8102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f8103d;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(23)
    public static class a {
        public static boolean a(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        public static int b(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }

        public static void c(PopupWindow popupWindow, boolean z11) {
            popupWindow.setOverlapAnchor(z11);
        }

        public static void d(PopupWindow popupWindow, int i11) {
            popupWindow.setWindowLayoutType(i11);
        }
    }

    public static void a(@NonNull PopupWindow popupWindow, boolean z11) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.c(popupWindow, z11);
            return;
        }
        if (!f8103d) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                f8102c = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f8103d = true;
        }
        Field field = f8102c;
        if (field != null) {
            try {
                field.set(popupWindow, Boolean.valueOf(z11));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public static void b(@NonNull PopupWindow popupWindow, int i11) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.d(popupWindow, i11);
            return;
        }
        if (!f8101b) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                f8100a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            f8101b = true;
        }
        Method method = f8100a;
        if (method != null) {
            try {
                method.invoke(popupWindow, Integer.valueOf(i11));
            } catch (Exception unused2) {
            }
        }
    }

    public static void c(@NonNull PopupWindow popupWindow, @NonNull View view, int i11, int i12, int i13) {
        popupWindow.showAsDropDown(view, i11, i12, i13);
    }
}
