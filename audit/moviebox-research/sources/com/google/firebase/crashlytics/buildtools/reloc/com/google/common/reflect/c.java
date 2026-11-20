package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class c {
    public static <T> T a(Class<T> cls, InvocationHandler invocationHandler) {
        l.n(invocationHandler);
        l.j(cls.isInterface(), "%s is not an interface", cls);
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler));
    }
}
