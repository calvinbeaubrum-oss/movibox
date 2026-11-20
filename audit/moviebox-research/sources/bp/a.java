package bp;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.c0;
import retrofit2.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a extends i.a {
    public static a f() {
        return new a();
    }

    @Override // retrofit2.i.a
    public i<?, RequestBody> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, c0 c0Var) {
        return new b();
    }

    @Override // retrofit2.i.a
    public i<ResponseBody, ?> d(Type type, Annotation[] annotationArr, c0 c0Var) {
        return new c(type, g(annotationArr));
    }

    public final String g(Annotation[] annotationArr) {
        if (annotationArr != null && annotationArr.length != 0) {
            for (Annotation annotation : annotationArr) {
                if (annotation instanceof yo.c) {
                    return "1311";
                }
            }
        }
        return "no_code";
    }
}
