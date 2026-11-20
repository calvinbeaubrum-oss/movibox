package com.squareup.okhttp.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f49070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f49071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class[] f49072c;

    public d(Class<?> cls, String str, Class... clsArr) {
        this.f49070a = cls;
        this.f49071b = str;
        this.f49072c = clsArr;
    }

    public static Method b(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
            } catch (NoSuchMethodException unused) {
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }

    public final Method a(Class<?> cls) {
        Class<?> cls2;
        String str = this.f49071b;
        if (str == null) {
            return null;
        }
        Method methodB = b(cls, str, this.f49072c);
        if (methodB == null || (cls2 = this.f49070a) == null || cls2.isAssignableFrom(methodB.getReturnType())) {
            return methodB;
        }
        return null;
    }

    public Object c(T t11, Object... objArr) throws InvocationTargetException {
        Method methodA = a(t11.getClass());
        if (methodA == null) {
            throw new AssertionError("Method " + this.f49071b + " not supported for object " + t11);
        }
        try {
            return methodA.invoke(t11, objArr);
        } catch (IllegalAccessException e11) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + methodA);
            assertionError.initCause(e11);
            throw assertionError;
        }
    }

    public Object d(T t11, Object... objArr) throws InvocationTargetException {
        Method methodA = a(t11.getClass());
        if (methodA == null) {
            return null;
        }
        try {
            return methodA.invoke(t11, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public Object e(T t11, Object... objArr) {
        try {
            return d(t11, objArr);
        } catch (InvocationTargetException e11) {
            Throwable targetException = e11.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object f(T t11, Object... objArr) {
        try {
            return c(t11, objArr);
        } catch (InvocationTargetException e11) {
            Throwable targetException = e11.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public boolean g(T t11) {
        return a(t11.getClass()) != null;
    }
}
