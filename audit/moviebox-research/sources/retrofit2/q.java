package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import okhttp3.ResponseBody;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@IgnoreJRERequirement
public final class q extends i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i.a f75315a = new q();

    /* JADX INFO: compiled from: source.java */
    @IgnoreJRERequirement
    public static final class a<T> implements i<ResponseBody, Optional<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i<ResponseBody, T> f75316a;

        public a(i<ResponseBody, T> iVar) {
            this.f75316a = iVar;
        }

        @Override // retrofit2.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Optional<T> a(ResponseBody responseBody) throws IOException {
            return Optional.ofNullable(this.f75316a.a(responseBody));
        }
    }

    @Override // retrofit2.i.a
    public i<ResponseBody, ?> d(Type type, Annotation[] annotationArr, c0 c0Var) {
        if (i.a.b(type) != p.a()) {
            return null;
        }
        return new a(c0Var.h(i.a.a(0, (ParameterizedType) type), annotationArr));
    }
}
