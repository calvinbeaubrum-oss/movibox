package com.google.protobuf;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class x0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final x0 f41432c = new x0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentMap<Class<?>, b1<?>> f41434b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c1 f41433a = new g0();

    public static x0 a() {
        return f41432c;
    }

    public <T> void b(T t11, a1 a1Var, p pVar) throws IOException {
        e(t11).h(t11, a1Var, pVar);
    }

    public b1<?> c(Class<?> cls, b1<?> b1Var) {
        y.b(cls, "messageType");
        y.b(b1Var, "schema");
        return this.f41434b.putIfAbsent(cls, b1Var);
    }

    public <T> b1<T> d(Class<T> cls) {
        y.b(cls, "messageType");
        b1<T> b1Var = (b1) this.f41434b.get(cls);
        if (b1Var != null) {
            return b1Var;
        }
        b1<T> b1VarA = this.f41433a.a(cls);
        b1<T> b1Var2 = (b1<T>) c(cls, b1VarA);
        return b1Var2 != null ? b1Var2 : b1VarA;
    }

    public <T> b1<T> e(T t11) {
        return d(t11.getClass());
    }
}
