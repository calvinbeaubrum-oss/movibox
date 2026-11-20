package com.blankj.utilcode.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class AdaptScreenUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<Field> f25221a;

    public static void b(@NonNull Resources resources, float f11) {
        resources.getDisplayMetrics().xdpi = f11;
        Utils.a().getResources().getDisplayMetrics().xdpi = f11;
        d(resources, f11);
    }

    public static void c(Resources resources, float f11) {
        Iterator<Field> it = f25221a.iterator();
        while (it.hasNext()) {
            try {
                DisplayMetrics displayMetrics = (DisplayMetrics) it.next().get(resources);
                if (displayMetrics != null) {
                    displayMetrics.xdpi = f11;
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public static void d(Resources resources, float f11) {
        if (f25221a != null) {
            c(resources, f11);
            return;
        }
        f25221a = new ArrayList();
        Class<?> superclass = resources.getClass();
        Field[] declaredFields = superclass.getDeclaredFields();
        while (declaredFields != null && declaredFields.length > 0) {
            for (Field field : declaredFields) {
                if (field.getType().isAssignableFrom(DisplayMetrics.class)) {
                    field.setAccessible(true);
                    DisplayMetrics displayMetricsE = e(resources, field);
                    if (displayMetricsE != null) {
                        f25221a.add(field);
                        displayMetricsE.xdpi = f11;
                    }
                }
            }
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                return;
            } else {
                declaredFields = superclass.getDeclaredFields();
            }
        }
    }

    public static DisplayMetrics e(Resources resources, Field field) {
        try {
            return (DisplayMetrics) field.get(resources);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Runnable f() {
        return new Runnable() { // from class: com.blankj.utilcode.util.AdaptScreenUtils.1
            @Override // java.lang.Runnable
            public void run() {
                AdaptScreenUtils.g();
            }
        };
    }

    public static void g() {
        b(Resources.getSystem(), Resources.getSystem().getDisplayMetrics().xdpi);
    }
}
