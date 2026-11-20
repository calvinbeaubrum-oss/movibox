package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class d0<T> {
    public static <T> d0<T> b(c0 c0Var, Method method) {
        a0 a0VarB = a0.b(c0Var, method);
        Type genericReturnType = method.getGenericReturnType();
        if (g0.j(genericReturnType)) {
            throw g0.m(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType);
        }
        if (genericReturnType != Void.TYPE) {
            return m.f(c0Var, method, a0VarB);
        }
        throw g0.m(method, "Service methods cannot return void.", new Object[0]);
    }

    public abstract T a(Object[] objArr);
}
