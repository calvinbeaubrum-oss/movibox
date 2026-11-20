package com.google.common.reflect;

import com.google.common.base.m;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    public static <T> T a(Class<T> cls, InvocationHandler invocationHandler) {
        m.p(invocationHandler);
        m.k(cls.isInterface(), "%s is not an interface", cls);
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler));
    }
}
