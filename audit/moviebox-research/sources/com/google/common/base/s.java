package com.google.common.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f38196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Method f38197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f38198c;

    static {
        Object objB = b();
        f38196a = objB;
        f38197b = objB == null ? null : a();
        f38198c = objB != null ? d(objB) : null;
    }

    public static Method a() {
        return c("getStackTraceElement", Throwable.class, Integer.TYPE);
    }

    public static Object b() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
        } catch (ThreadDeath e11) {
            throw e11;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method c(String str, Class<?>... clsArr) throws ThreadDeath {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e11) {
            throw e11;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method d(Object obj) {
        try {
            Method methodC = c("getStackTraceDepth", Throwable.class);
            if (methodC == null) {
                return null;
            }
            methodC.invoke(obj, new Throwable());
            return methodC;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Deprecated
    public static <X extends Throwable> void e(Throwable th2, Class<X> cls) throws Throwable {
        if (th2 != null) {
            h(th2, cls);
        }
    }

    @Deprecated
    public static void f(Throwable th2) {
        if (th2 != null) {
            i(th2);
        }
    }

    public static <X extends Throwable> void g(Throwable th2, Class<X> cls) throws Throwable {
        e(th2, cls);
        f(th2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: X extends java.lang.Throwable */
    public static <X extends Throwable> void h(Throwable th2, Class<X> cls) throws Throwable {
        m.p(th2);
        if (cls.isInstance(th2)) {
            throw cls.cast(th2);
        }
    }

    public static void i(Throwable th2) {
        m.p(th2);
        if (th2 instanceof RuntimeException) {
            throw ((RuntimeException) th2);
        }
        if (th2 instanceof Error) {
            throw ((Error) th2);
        }
    }
}
