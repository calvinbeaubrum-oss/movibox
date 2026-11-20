package com.google.android.exoplayer2.util;

import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static Method f35547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public static Method f35548b;

    @Nullable
    public static IBinder a(Bundle bundle, @Nullable String str) {
        return o0.f35608a >= 18 ? bundle.getBinder(str) : b(bundle, str);
    }

    @Nullable
    public static IBinder b(Bundle bundle, @Nullable String str) {
        Method method = f35547a;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("getIBinder", String.class);
                f35547a = method2;
                method2.setAccessible(true);
                method = f35547a;
            } catch (NoSuchMethodException e11) {
                s.g("BundleUtil", "Failed to retrieve getIBinder method", e11);
                return null;
            }
        }
        try {
            return (IBinder) method.invoke(bundle, str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e12) {
            s.g("BundleUtil", "Failed to invoke getIBinder via reflection", e12);
            return null;
        }
    }

    public static void c(Bundle bundle, @Nullable String str, @Nullable IBinder iBinder) {
        if (o0.f35608a >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            d(bundle, str, iBinder);
        }
    }

    public static void d(Bundle bundle, @Nullable String str, @Nullable IBinder iBinder) {
        Method method = f35548b;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                f35548b = method2;
                method2.setAccessible(true);
                method = f35548b;
            } catch (NoSuchMethodException e11) {
                s.g("BundleUtil", "Failed to retrieve putIBinder method", e11);
                return;
            }
        }
        try {
            method.invoke(bundle, str, iBinder);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e12) {
            s.g("BundleUtil", "Failed to invoke putIBinder via reflection", e12);
        }
    }
}
