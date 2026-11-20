package com.pgl.ssdk;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f48824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f48825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f48826c;

    static {
        try {
            f48824a = Class.class.getDeclaredMethod("forName", String.class);
            f48825b = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            f48826c = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (NoSuchMethodException | NullPointerException unused) {
        }
    }

    public static Object a(Object obj, Class cls, String str, Object obj2) {
        try {
            Field fieldA = a(cls, str);
            if (fieldA == null) {
                return obj2;
            }
            fieldA.setAccessible(true);
            return fieldA.get(obj);
        } catch (Throwable unused) {
            return obj2;
        }
    }

    public static Object a(Object obj, Class cls, String str, Class[] clsArr, Object... objArr) {
        try {
            Method methodA = a(cls, str, clsArr);
            if (methodA != null) {
                return methodA.invoke(obj, objArr);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static Field a(Class cls, String str) {
        if (!a()) {
            return null;
        }
        try {
            Field field = (Field) f48826c.invoke(cls, str);
            try {
                field.setAccessible(true);
            } catch (Throwable unused) {
            }
            return field;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static Method a(Class cls, String str, Class[] clsArr) {
        if (!a()) {
            return null;
        }
        try {
            Method method = (Method) f48825b.invoke(cls, str, clsArr);
            try {
                method.setAccessible(true);
            } catch (Throwable unused) {
            }
            return method;
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static boolean a() {
        return (f48824a == null || f48825b == null || f48826c == null) ? false : true;
    }
}
