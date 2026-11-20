package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(19)
public final class o implements androidx.lifecycle.r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Field f649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Field f650d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Field f651f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f652a;

    public o(Activity activity) {
        this.f652a = activity;
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static void a() {
        try {
            f648b = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f650d = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f651f = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f649c = declaredField3;
            declaredField3.setAccessible(true);
            f648b = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.r
    public void onStateChanged(@NonNull androidx.lifecycle.u uVar, @NonNull Lifecycle.Event event) {
        if (event != Lifecycle.Event.ON_DESTROY) {
            return;
        }
        if (f648b == 0) {
            a();
        }
        if (f648b == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f652a.getSystemService("input_method");
            try {
                Object obj = f649c.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            try {
                                View view = (View) f650d.get(inputMethodManager);
                                if (view == null) {
                                    return;
                                }
                                if (view.isAttachedToWindow()) {
                                    return;
                                }
                                try {
                                    f651f.set(inputMethodManager, null);
                                    inputMethodManager.isActive();
                                } catch (IllegalAccessException unused) {
                                }
                            } catch (ClassCastException unused2) {
                            }
                        } catch (IllegalAccessException unused3) {
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}
