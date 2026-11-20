package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface i<F, T> {

    /* JADX INFO: compiled from: source.java */
    public static abstract class a {
        public static Type a(int i11, ParameterizedType parameterizedType) {
            return g0.g(i11, parameterizedType);
        }

        public static Class<?> b(Type type) {
            return g0.h(type);
        }

        public i<?, RequestBody> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, c0 c0Var) {
            return null;
        }

        public i<ResponseBody, ?> d(Type type, Annotation[] annotationArr, c0 c0Var) {
            return null;
        }

        public i<?, String> e(Type type, Annotation[] annotationArr, c0 c0Var) {
            return null;
        }
    }

    T a(F f11) throws IOException;
}
