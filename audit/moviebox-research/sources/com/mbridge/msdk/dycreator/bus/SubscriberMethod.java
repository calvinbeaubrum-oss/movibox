package com.mbridge.msdk.dycreator.bus;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class SubscriberMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Method f43656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ThreadMode f43657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Class<?> f43658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f43659d;

    public SubscriberMethod(Method method, ThreadMode threadMode, Class<?> cls) {
        this.f43656a = method;
        this.f43657b = threadMode;
        this.f43658c = cls;
    }

    private synchronized void a() {
        if (this.f43659d == null) {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append(this.f43656a.getDeclaringClass().getName());
            sb2.append('#');
            sb2.append(this.f43656a.getName());
            sb2.append('(');
            sb2.append(this.f43658c.getName());
            this.f43659d = sb2.toString();
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SubscriberMethod)) {
            return false;
        }
        a();
        return this.f43659d.equals(((SubscriberMethod) obj).f43659d);
    }

    public final int hashCode() {
        return this.f43656a.hashCode();
    }
}
