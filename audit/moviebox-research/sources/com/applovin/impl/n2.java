package com.applovin.impl;

import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f21225a;

    public static IBinder a(Bundle bundle, String str) {
        return xp.f24372a >= 18 ? bundle.getBinder(str) : b(bundle, str);
    }

    private static IBinder b(Bundle bundle, String str) {
        Method method = f21225a;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("getIBinder", String.class);
                f21225a = method2;
                method2.setAccessible(true);
                method = f21225a;
            } catch (NoSuchMethodException e11) {
                pc.b("BundleUtil", "Failed to retrieve getIBinder method", e11);
                return null;
            }
        }
        try {
            return (IBinder) method.invoke(bundle, str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e12) {
            pc.b("BundleUtil", "Failed to invoke getIBinder via reflection", e12);
            return null;
        }
    }
}
