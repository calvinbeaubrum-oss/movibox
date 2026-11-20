package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Method, d0<?>> f75242a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Call.Factory f75243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HttpUrl f75244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<i.a> f75245d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<c.a> f75246e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Executor f75247f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f75248g;

    /* JADX INFO: compiled from: source.java */
    public class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y f75249a = y.f();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object[] f75250b = new Object[0];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Class f75251c;

        public a(Class cls) {
            this.f75251c = cls;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            if (objArr == null) {
                objArr = this.f75250b;
            }
            return this.f75249a.h(method) ? this.f75249a.g(method, this.f75251c, obj, objArr) : c0.this.c(method).a(objArr);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y f75253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Call.Factory f75254b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public HttpUrl f75255c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<i.a> f75256d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<c.a> f75257e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Executor f75258f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f75259g;

        public b() {
            this(y.f());
        }

        public b(y yVar) {
            this.f75256d = new ArrayList();
            this.f75257e = new ArrayList();
            this.f75253a = yVar;
        }

        public b a(c.a aVar) {
            List<c.a> list = this.f75257e;
            Objects.requireNonNull(aVar, "factory == null");
            list.add(aVar);
            return this;
        }

        public b b(i.a aVar) {
            List<i.a> list = this.f75256d;
            Objects.requireNonNull(aVar, "factory == null");
            list.add(aVar);
            return this;
        }

        public b c(String str) {
            Objects.requireNonNull(str, "baseUrl == null");
            return d(HttpUrl.get(str));
        }

        public b d(HttpUrl httpUrl) {
            Objects.requireNonNull(httpUrl, "baseUrl == null");
            List<String> listPathSegments = httpUrl.pathSegments();
            if ("".equals(listPathSegments.get(listPathSegments.size() - 1))) {
                this.f75255c = httpUrl;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + httpUrl);
        }

        public c0 e() {
            if (this.f75255c == null) {
                throw new IllegalStateException("Base URL required.");
            }
            Call.Factory okHttpClient = this.f75254b;
            if (okHttpClient == null) {
                okHttpClient = new OkHttpClient();
            }
            Call.Factory factory = okHttpClient;
            Executor executorB = this.f75258f;
            if (executorB == null) {
                executorB = this.f75253a.b();
            }
            Executor executor = executorB;
            ArrayList arrayList = new ArrayList(this.f75257e);
            arrayList.addAll(this.f75253a.a(executor));
            ArrayList arrayList2 = new ArrayList(this.f75256d.size() + 1 + this.f75253a.d());
            arrayList2.add(new retrofit2.a());
            arrayList2.addAll(this.f75256d);
            arrayList2.addAll(this.f75253a.c());
            return new c0(factory, this.f75255c, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), executor, this.f75259g);
        }

        public b f(Call.Factory factory) {
            Objects.requireNonNull(factory, "factory == null");
            this.f75254b = factory;
            return this;
        }

        public b g(OkHttpClient okHttpClient) {
            Objects.requireNonNull(okHttpClient, "client == null");
            return f(okHttpClient);
        }
    }

    public c0(Call.Factory factory, HttpUrl httpUrl, List<i.a> list, List<c.a> list2, Executor executor, boolean z11) {
        this.f75243b = factory;
        this.f75244c = httpUrl;
        this.f75245d = list;
        this.f75246e = list2;
        this.f75247f = executor;
        this.f75248g = z11;
    }

    public c<?, ?> a(Type type, Annotation[] annotationArr) {
        return d(null, type, annotationArr);
    }

    public <T> T b(Class<T> cls) {
        j(cls);
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(cls));
    }

    public d0<?> c(Method method) {
        d0<?> d0VarB;
        d0<?> d0Var = this.f75242a.get(method);
        if (d0Var != null) {
            return d0Var;
        }
        synchronized (this.f75242a) {
            try {
                d0VarB = this.f75242a.get(method);
                if (d0VarB == null) {
                    d0VarB = d0.b(this, method);
                    this.f75242a.put(method, d0VarB);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return d0VarB;
    }

    public c<?, ?> d(c.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int iIndexOf = this.f75246e.indexOf(aVar) + 1;
        int size = this.f75246e.size();
        for (int i11 = iIndexOf; i11 < size; i11++) {
            c<?, ?> cVarA = this.f75246e.get(i11).a(type, annotationArr, this);
            if (cVarA != null) {
                return cVarA;
            }
        }
        StringBuilder sb2 = new StringBuilder("Could not locate call adapter for ");
        sb2.append(type);
        sb2.append(".\n");
        if (aVar != null) {
            sb2.append("  Skipped:");
            for (int i12 = 0; i12 < iIndexOf; i12++) {
                sb2.append("\n   * ");
                sb2.append(this.f75246e.get(i12).getClass().getName());
            }
            sb2.append('\n');
        }
        sb2.append("  Tried:");
        int size2 = this.f75246e.size();
        while (iIndexOf < size2) {
            sb2.append("\n   * ");
            sb2.append(this.f75246e.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb2.toString());
    }

    public <T> i<T, RequestBody> e(i.a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "parameterAnnotations == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        int iIndexOf = this.f75245d.indexOf(aVar) + 1;
        int size = this.f75245d.size();
        for (int i11 = iIndexOf; i11 < size; i11++) {
            i<T, RequestBody> iVar = (i<T, RequestBody>) this.f75245d.get(i11).c(type, annotationArr, annotationArr2, this);
            if (iVar != null) {
                return iVar;
            }
        }
        StringBuilder sb2 = new StringBuilder("Could not locate RequestBody converter for ");
        sb2.append(type);
        sb2.append(".\n");
        if (aVar != null) {
            sb2.append("  Skipped:");
            for (int i12 = 0; i12 < iIndexOf; i12++) {
                sb2.append("\n   * ");
                sb2.append(this.f75245d.get(i12).getClass().getName());
            }
            sb2.append('\n');
        }
        sb2.append("  Tried:");
        int size2 = this.f75245d.size();
        while (iIndexOf < size2) {
            sb2.append("\n   * ");
            sb2.append(this.f75245d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb2.toString());
    }

    public <T> i<ResponseBody, T> f(i.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int iIndexOf = this.f75245d.indexOf(aVar) + 1;
        int size = this.f75245d.size();
        for (int i11 = iIndexOf; i11 < size; i11++) {
            i<ResponseBody, T> iVar = (i<ResponseBody, T>) this.f75245d.get(i11).d(type, annotationArr, this);
            if (iVar != null) {
                return iVar;
            }
        }
        StringBuilder sb2 = new StringBuilder("Could not locate ResponseBody converter for ");
        sb2.append(type);
        sb2.append(".\n");
        if (aVar != null) {
            sb2.append("  Skipped:");
            for (int i12 = 0; i12 < iIndexOf; i12++) {
                sb2.append("\n   * ");
                sb2.append(this.f75245d.get(i12).getClass().getName());
            }
            sb2.append('\n');
        }
        sb2.append("  Tried:");
        int size2 = this.f75245d.size();
        while (iIndexOf < size2) {
            sb2.append("\n   * ");
            sb2.append(this.f75245d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb2.toString());
    }

    public <T> i<T, RequestBody> g(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return e(null, type, annotationArr, annotationArr2);
    }

    public <T> i<ResponseBody, T> h(Type type, Annotation[] annotationArr) {
        return f(null, type, annotationArr);
    }

    public <T> i<T, String> i(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int size = this.f75245d.size();
        for (int i11 = 0; i11 < size; i11++) {
            i<T, String> iVar = (i<T, String>) this.f75245d.get(i11).e(type, annotationArr, this);
            if (iVar != null) {
                return iVar;
            }
        }
        return retrofit2.a.d.f75200a;
    }

    public final void j(Class<?> cls) {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
        ArrayDeque arrayDeque = new ArrayDeque(1);
        arrayDeque.add(cls);
        while (!arrayDeque.isEmpty()) {
            Class<?> cls2 = (Class) arrayDeque.removeFirst();
            if (cls2.getTypeParameters().length != 0) {
                StringBuilder sb2 = new StringBuilder("Type parameters are unsupported on ");
                sb2.append(cls2.getName());
                if (cls2 != cls) {
                    sb2.append(" which is an interface of ");
                    sb2.append(cls.getName());
                }
                throw new IllegalArgumentException(sb2.toString());
            }
            Collections.addAll(arrayDeque, cls2.getInterfaces());
        }
        if (this.f75248g) {
            y yVarF = y.f();
            for (Method method : cls.getDeclaredMethods()) {
                if (!yVarF.h(method) && !Modifier.isStatic(method.getModifiers())) {
                    c(method);
                }
            }
        }
    }
}
