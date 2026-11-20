package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface c<R, T> {

    /* JADX INFO: compiled from: source.java */
    public static abstract class a {
        public static Type b(int i11, ParameterizedType parameterizedType) {
            return g0.g(i11, parameterizedType);
        }

        public static Class<?> c(Type type) {
            return g0.h(type);
        }

        public abstract c<?, ?> a(Type type, Annotation[] annotationArr, c0 c0Var);
    }

    Type a();

    T b(b<R> bVar);
}
