package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Unit;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a extends i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f75196a = true;

    /* JADX INFO: renamed from: retrofit2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0827a implements i<ResponseBody, ResponseBody> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0827a f75197a = new C0827a();

        @Override // retrofit2.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ResponseBody a(ResponseBody responseBody) throws IOException {
            try {
                return g0.a(responseBody);
            } finally {
                responseBody.close();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements i<RequestBody, RequestBody> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f75198a = new b();

        @Override // retrofit2.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public RequestBody a(RequestBody requestBody) {
            return requestBody;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements i<ResponseBody, ResponseBody> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f75199a = new c();

        @Override // retrofit2.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ResponseBody a(ResponseBody responseBody) {
            return responseBody;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements i<Object, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f75200a = new d();

        @Override // retrofit2.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(Object obj) {
            return obj.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e implements i<ResponseBody, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f75201a = new e();

        @Override // retrofit2.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Unit a(ResponseBody responseBody) {
            responseBody.close();
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f implements i<ResponseBody, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f75202a = new f();

        @Override // retrofit2.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(ResponseBody responseBody) {
            responseBody.close();
            return null;
        }
    }

    @Override // retrofit2.i.a
    public i<?, RequestBody> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, c0 c0Var) {
        if (RequestBody.class.isAssignableFrom(g0.h(type))) {
            return b.f75198a;
        }
        return null;
    }

    @Override // retrofit2.i.a
    public i<ResponseBody, ?> d(Type type, Annotation[] annotationArr, c0 c0Var) {
        if (type == ResponseBody.class) {
            return g0.l(annotationArr, y30.w.class) ? c.f75199a : C0827a.f75197a;
        }
        if (type == Void.class) {
            return f.f75202a;
        }
        if (!this.f75196a || type != Unit.class) {
            return null;
        }
        try {
            return e.f75201a;
        } catch (NoClassDefFoundError unused) {
            this.f75196a = false;
            return null;
        }
    }
}
