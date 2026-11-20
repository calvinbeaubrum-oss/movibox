package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.coroutines.Continuation;
import okhttp3.Call;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class m<ResponseT, ReturnT> extends d0<ReturnT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0 f75290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Call.Factory f75291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i<ResponseBody, ResponseT> f75292c;

    /* JADX INFO: compiled from: source.java */
    public static final class a<ResponseT, ReturnT> extends m<ResponseT, ReturnT> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final retrofit2.c<ResponseT, ReturnT> f75293d;

        public a(a0 a0Var, Call.Factory factory, i<ResponseBody, ResponseT> iVar, retrofit2.c<ResponseT, ReturnT> cVar) {
            super(a0Var, factory, iVar);
            this.f75293d = cVar;
        }

        @Override // retrofit2.m
        public ReturnT c(retrofit2.b<ResponseT> bVar, Object[] objArr) {
            return this.f75293d.b(bVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b<ResponseT> extends m<ResponseT, Object> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final retrofit2.c<ResponseT, retrofit2.b<ResponseT>> f75294d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f75295e;

        public b(a0 a0Var, Call.Factory factory, i<ResponseBody, ResponseT> iVar, retrofit2.c<ResponseT, retrofit2.b<ResponseT>> cVar, boolean z11) {
            super(a0Var, factory, iVar);
            this.f75294d = cVar;
            this.f75295e = z11;
        }

        @Override // retrofit2.m
        public Object c(retrofit2.b<ResponseT> bVar, Object[] objArr) {
            retrofit2.b<ResponseT> bVarB = this.f75294d.b(bVar);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                return this.f75295e ? KotlinExtensions.b(bVarB, continuation) : KotlinExtensions.a(bVarB, continuation);
            } catch (Exception e11) {
                return KotlinExtensions.d(e11, continuation);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c<ResponseT> extends m<ResponseT, Object> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final retrofit2.c<ResponseT, retrofit2.b<ResponseT>> f75296d;

        public c(a0 a0Var, Call.Factory factory, i<ResponseBody, ResponseT> iVar, retrofit2.c<ResponseT, retrofit2.b<ResponseT>> cVar) {
            super(a0Var, factory, iVar);
            this.f75296d = cVar;
        }

        @Override // retrofit2.m
        public Object c(retrofit2.b<ResponseT> bVar, Object[] objArr) {
            retrofit2.b<ResponseT> bVarB = this.f75296d.b(bVar);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                return KotlinExtensions.c(bVarB, continuation);
            } catch (Exception e11) {
                return KotlinExtensions.d(e11, continuation);
            }
        }
    }

    public m(a0 a0Var, Call.Factory factory, i<ResponseBody, ResponseT> iVar) {
        this.f75290a = a0Var;
        this.f75291b = factory;
        this.f75292c = iVar;
    }

    public static <ResponseT, ReturnT> retrofit2.c<ResponseT, ReturnT> d(c0 c0Var, Method method, Type type, Annotation[] annotationArr) {
        try {
            return (retrofit2.c<ResponseT, ReturnT>) c0Var.a(type, annotationArr);
        } catch (RuntimeException e11) {
            throw g0.n(method, e11, "Unable to create call adapter for %s", type);
        }
    }

    public static <ResponseT> i<ResponseBody, ResponseT> e(c0 c0Var, Method method, Type type) {
        try {
            return c0Var.h(type, method.getAnnotations());
        } catch (RuntimeException e11) {
            throw g0.n(method, e11, "Unable to create converter for %s", type);
        }
    }

    public static <ResponseT, ReturnT> m<ResponseT, ReturnT> f(c0 c0Var, Method method, a0 a0Var) {
        Type genericReturnType;
        boolean z11;
        boolean z12 = a0Var.f75213k;
        Annotation[] annotations = method.getAnnotations();
        if (z12) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type typeF = g0.f(0, (ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]);
            if (g0.h(typeF) == b0.class && (typeF instanceof ParameterizedType)) {
                typeF = g0.g(0, (ParameterizedType) typeF);
                z11 = true;
            } else {
                z11 = false;
            }
            genericReturnType = new g0.b(null, retrofit2.b.class, typeF);
            annotations = f0.a(annotations);
        } else {
            genericReturnType = method.getGenericReturnType();
            z11 = false;
        }
        retrofit2.c cVarD = d(c0Var, method, genericReturnType, annotations);
        Type typeA = cVarD.a();
        if (typeA == Response.class) {
            throw g0.m(method, "'" + g0.h(typeA).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        }
        if (typeA == b0.class) {
            throw g0.m(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
        }
        if (a0Var.f75205c.equals("HEAD") && !Void.class.equals(typeA)) {
            throw g0.m(method, "HEAD method must use Void as response type.", new Object[0]);
        }
        i iVarE = e(c0Var, method, typeA);
        Call.Factory factory = c0Var.f75243b;
        if (z12) {
            return z11 ? new c(a0Var, factory, iVarE, cVarD) : new b(a0Var, factory, iVarE, cVarD, false);
        }
        return new a(a0Var, factory, iVarE, cVarD);
    }

    @Override // retrofit2.d0
    public final ReturnT a(Object[] objArr) {
        return c(new o(this.f75290a, objArr, this.f75291b, this.f75292c), objArr);
    }

    public abstract ReturnT c(retrofit2.b<ResponseT> bVar, Object[] objArr);
}
