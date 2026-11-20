package com.facebook.ads.redexgen.uinode;

import java.lang.reflect.Proxy;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5M, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C5M {
    public static <T> T A00(T t11, Class<T> cls) {
        ClassLoader classLoader = t11.getClass().getClassLoader();
        return cls.cast(Proxy.newProxyInstance(classLoader, new Class[]{cls}, new C5L(t11, classLoader)));
    }
}
