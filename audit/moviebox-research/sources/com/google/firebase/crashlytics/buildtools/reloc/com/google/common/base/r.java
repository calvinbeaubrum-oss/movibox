package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f39097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Method f39098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f39099c;

    static {
        Object objB = b();
        f39097a = objB;
        f39098b = objB == null ? null : a();
        f39099c = objB != null ? d() : null;
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

    public static Method d() {
        try {
            Method methodC = c("getStackTraceDepth", Throwable.class);
            if (methodC == null) {
                return null;
            }
            methodC.invoke(b(), new Throwable());
            return methodC;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Deprecated
    public static RuntimeException e(Throwable th2) {
        f(th2);
        throw new RuntimeException(th2);
    }

    public static void f(Throwable th2) {
        l.n(th2);
        if (th2 instanceof RuntimeException) {
            throw ((RuntimeException) th2);
        }
        if (th2 instanceof Error) {
            throw ((Error) th2);
        }
    }
}
