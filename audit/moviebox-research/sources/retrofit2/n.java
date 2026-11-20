package retrofit2;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f75297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<?> f75298b;

    public n(Method method, List<?> list) {
        this.f75297a = method;
        this.f75298b = Collections.unmodifiableList(list);
    }

    public Method a() {
        return this.f75297a;
    }

    public String toString() {
        return String.format("%s.%s() %s", this.f75297a.getDeclaringClass().getName(), this.f75297a.getName(), this.f75298b);
    }
}
