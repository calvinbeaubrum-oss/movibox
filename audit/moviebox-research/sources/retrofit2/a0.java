package retrofit2;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.coroutines.Continuation;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f75203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HttpUrl f75204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f75205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f75206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Headers f75207e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MediaType f75208f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f75209g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f75210h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f75211i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final r<?>[] f75212j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f75213k;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final Pattern f75214x = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final Pattern f75215y = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c0 f75216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f75217b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Annotation[] f75218c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Annotation[][] f75219d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Type[] f75220e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f75221f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f75222g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f75223h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f75224i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f75225j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f75226k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f75227l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f75228m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f75229n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f75230o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f75231p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f75232q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public String f75233r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public Headers f75234s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public MediaType f75235t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public Set<String> f75236u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public r<?>[] f75237v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f75238w;

        public a(c0 c0Var, Method method) {
            this.f75216a = c0Var;
            this.f75217b = method;
            this.f75218c = method.getAnnotations();
            this.f75220e = method.getGenericParameterTypes();
            this.f75219d = method.getParameterAnnotations();
        }

        public static Class<?> a(Class<?> cls) {
            if (Boolean.TYPE == cls) {
                return Boolean.class;
            }
            if (Byte.TYPE == cls) {
                return Byte.class;
            }
            if (Character.TYPE == cls) {
                return Character.class;
            }
            if (Double.TYPE == cls) {
                return Double.class;
            }
            if (Float.TYPE == cls) {
                return Float.class;
            }
            if (Integer.TYPE == cls) {
                return Integer.class;
            }
            if (Long.TYPE == cls) {
                return Long.class;
            }
            return Short.TYPE == cls ? Short.class : cls;
        }

        public static Set<String> h(String str) {
            Matcher matcher = f75214x.matcher(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            return linkedHashSet;
        }

        public a0 b() {
            for (Annotation annotation : this.f75218c) {
                e(annotation);
            }
            if (this.f75229n == null) {
                throw g0.m(this.f75217b, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            if (!this.f75230o) {
                if (this.f75232q) {
                    throw g0.m(this.f75217b, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
                if (this.f75231p) {
                    throw g0.m(this.f75217b, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
            }
            int length = this.f75219d.length;
            this.f75237v = new r[length];
            int i11 = length - 1;
            int i12 = 0;
            while (true) {
                boolean z11 = true;
                if (i12 >= length) {
                    break;
                }
                r<?>[] rVarArr = this.f75237v;
                Type type = this.f75220e[i12];
                Annotation[] annotationArr = this.f75219d[i12];
                if (i12 != i11) {
                    z11 = false;
                }
                rVarArr[i12] = f(i12, type, annotationArr, z11);
                i12++;
            }
            if (this.f75233r == null && !this.f75228m) {
                throw g0.m(this.f75217b, "Missing either @%s URL or @Url parameter.", this.f75229n);
            }
            boolean z12 = this.f75231p;
            if (!z12 && !this.f75232q && !this.f75230o && this.f75223h) {
                throw g0.m(this.f75217b, "Non-body HTTP method cannot contain @Body.", new Object[0]);
            }
            if (z12 && !this.f75221f) {
                throw g0.m(this.f75217b, "Form-encoded method must contain at least one @Field.", new Object[0]);
            }
            if (!this.f75232q || this.f75222g) {
                return new a0(this);
            }
            throw g0.m(this.f75217b, "Multipart method must contain at least one @Part.", new Object[0]);
        }

        public final Headers c(String[] strArr) {
            Headers.Builder builder = new Headers.Builder();
            for (String str : strArr) {
                int iIndexOf = str.indexOf(58);
                if (iIndexOf == -1 || iIndexOf == 0 || iIndexOf == str.length() - 1) {
                    throw g0.m(this.f75217b, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String strSubstring = str.substring(0, iIndexOf);
                String strTrim = str.substring(iIndexOf + 1).trim();
                if (HttpHeaders.CONTENT_TYPE.equalsIgnoreCase(strSubstring)) {
                    try {
                        this.f75235t = MediaType.get(strTrim);
                    } catch (IllegalArgumentException e11) {
                        throw g0.n(this.f75217b, e11, "Malformed content type: %s", strTrim);
                    }
                } else {
                    builder.add(strSubstring, strTrim);
                }
            }
            return builder.build();
        }

        public final void d(String str, String str2, boolean z11) {
            String str3 = this.f75229n;
            if (str3 != null) {
                throw g0.m(this.f75217b, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.f75229n = str;
            this.f75230o = z11;
            if (str2.isEmpty()) {
                return;
            }
            int iIndexOf = str2.indexOf(63);
            if (iIndexOf != -1 && iIndexOf < str2.length() - 1) {
                String strSubstring = str2.substring(iIndexOf + 1);
                if (f75214x.matcher(strSubstring).find()) {
                    throw g0.m(this.f75217b, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", strSubstring);
                }
            }
            this.f75233r = str2;
            this.f75236u = h(str2);
        }

        public final void e(Annotation annotation) {
            if (annotation instanceof y30.b) {
                d("DELETE", ((y30.b) annotation).value(), false);
                return;
            }
            if (annotation instanceof y30.f) {
                d("GET", ((y30.f) annotation).value(), false);
                return;
            }
            if (annotation instanceof y30.g) {
                d("HEAD", ((y30.g) annotation).value(), false);
                return;
            }
            if (annotation instanceof y30.n) {
                d("PATCH", ((y30.n) annotation).value(), true);
                return;
            }
            if (annotation instanceof y30.o) {
                d("POST", ((y30.o) annotation).value(), true);
                return;
            }
            if (annotation instanceof y30.p) {
                d("PUT", ((y30.p) annotation).value(), true);
                return;
            }
            if (annotation instanceof y30.m) {
                d("OPTIONS", ((y30.m) annotation).value(), false);
                return;
            }
            if (annotation instanceof y30.h) {
                y30.h hVar = (y30.h) annotation;
                d(hVar.method(), hVar.path(), hVar.hasBody());
                return;
            }
            if (annotation instanceof y30.k) {
                String[] strArrValue = ((y30.k) annotation).value();
                if (strArrValue.length == 0) {
                    throw g0.m(this.f75217b, "@Headers annotation is empty.", new Object[0]);
                }
                this.f75234s = c(strArrValue);
                return;
            }
            if (annotation instanceof y30.l) {
                if (this.f75231p) {
                    throw g0.m(this.f75217b, "Only one encoding annotation is allowed.", new Object[0]);
                }
                this.f75232q = true;
            } else if (annotation instanceof y30.e) {
                if (this.f75232q) {
                    throw g0.m(this.f75217b, "Only one encoding annotation is allowed.", new Object[0]);
                }
                this.f75231p = true;
            }
        }

        public final r<?> f(int i11, Type type, Annotation[] annotationArr, boolean z11) {
            r<?> rVar;
            if (annotationArr != null) {
                rVar = null;
                for (Annotation annotation : annotationArr) {
                    r<?> rVarG = g(i11, type, annotationArr, annotation);
                    if (rVarG != null) {
                        if (rVar != null) {
                            throw g0.o(this.f75217b, i11, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                        rVar = rVarG;
                    }
                }
            } else {
                rVar = null;
            }
            if (rVar != null) {
                return rVar;
            }
            if (z11) {
                try {
                    if (g0.h(type) == Continuation.class) {
                        this.f75238w = true;
                        return null;
                    }
                } catch (NoClassDefFoundError unused) {
                }
            }
            throw g0.o(this.f75217b, i11, "No Retrofit annotation found.", new Object[0]);
        }

        public final r<?> g(int i11, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof y30.y) {
                j(i11, type);
                if (this.f75228m) {
                    throw g0.o(this.f75217b, i11, "Multiple @Url method annotations found.", new Object[0]);
                }
                if (this.f75224i) {
                    throw g0.o(this.f75217b, i11, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.f75225j) {
                    throw g0.o(this.f75217b, i11, "A @Url parameter must not come after a @Query.", new Object[0]);
                }
                if (this.f75226k) {
                    throw g0.o(this.f75217b, i11, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.f75227l) {
                    throw g0.o(this.f75217b, i11, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.f75233r != null) {
                    throw g0.o(this.f75217b, i11, "@Url cannot be used with @%s URL", this.f75229n);
                }
                this.f75228m = true;
                if (type == HttpUrl.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                    return new r.p(this.f75217b, i11);
                }
                throw g0.o(this.f75217b, i11, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
            }
            if (annotation instanceof y30.s) {
                j(i11, type);
                if (this.f75225j) {
                    throw g0.o(this.f75217b, i11, "A @Path parameter must not come after a @Query.", new Object[0]);
                }
                if (this.f75226k) {
                    throw g0.o(this.f75217b, i11, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.f75227l) {
                    throw g0.o(this.f75217b, i11, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.f75228m) {
                    throw g0.o(this.f75217b, i11, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.f75233r == null) {
                    throw g0.o(this.f75217b, i11, "@Path can only be used with relative url on @%s", this.f75229n);
                }
                this.f75224i = true;
                y30.s sVar = (y30.s) annotation;
                String strValue = sVar.value();
                i(i11, strValue);
                return new r.k(this.f75217b, i11, strValue, this.f75216a.i(type, annotationArr), sVar.encoded());
            }
            if (annotation instanceof y30.t) {
                j(i11, type);
                y30.t tVar = (y30.t) annotation;
                String strValue2 = tVar.value();
                boolean zEncoded = tVar.encoded();
                Class<?> clsH = g0.h(type);
                this.f75225j = true;
                if (!Iterable.class.isAssignableFrom(clsH)) {
                    return clsH.isArray() ? new r.l(strValue2, this.f75216a.i(a(clsH.getComponentType()), annotationArr), zEncoded).b() : new r.l(strValue2, this.f75216a.i(type, annotationArr), zEncoded);
                }
                if (type instanceof ParameterizedType) {
                    return new r.l(strValue2, this.f75216a.i(g0.g(0, (ParameterizedType) type), annotationArr), zEncoded).c();
                }
                throw g0.o(this.f75217b, i11, clsH.getSimpleName() + " must include generic type (e.g., " + clsH.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof y30.v) {
                j(i11, type);
                boolean zEncoded2 = ((y30.v) annotation).encoded();
                Class<?> clsH2 = g0.h(type);
                this.f75226k = true;
                if (!Iterable.class.isAssignableFrom(clsH2)) {
                    return clsH2.isArray() ? new r.n(this.f75216a.i(a(clsH2.getComponentType()), annotationArr), zEncoded2).b() : new r.n(this.f75216a.i(type, annotationArr), zEncoded2);
                }
                if (type instanceof ParameterizedType) {
                    return new r.n(this.f75216a.i(g0.g(0, (ParameterizedType) type), annotationArr), zEncoded2).c();
                }
                throw g0.o(this.f75217b, i11, clsH2.getSimpleName() + " must include generic type (e.g., " + clsH2.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof y30.u) {
                j(i11, type);
                Class<?> clsH3 = g0.h(type);
                this.f75227l = true;
                if (!Map.class.isAssignableFrom(clsH3)) {
                    throw g0.o(this.f75217b, i11, "@QueryMap parameter type must be Map.", new Object[0]);
                }
                Type typeI = g0.i(type, clsH3, Map.class);
                if (!(typeI instanceof ParameterizedType)) {
                    throw g0.o(this.f75217b, i11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType = (ParameterizedType) typeI;
                Type typeG = g0.g(0, parameterizedType);
                if (String.class == typeG) {
                    return new r.m(this.f75217b, i11, this.f75216a.i(g0.g(1, parameterizedType), annotationArr), ((y30.u) annotation).encoded());
                }
                throw g0.o(this.f75217b, i11, "@QueryMap keys must be of type String: " + typeG, new Object[0]);
            }
            if (annotation instanceof y30.i) {
                j(i11, type);
                String strValue3 = ((y30.i) annotation).value();
                Class<?> clsH4 = g0.h(type);
                if (!Iterable.class.isAssignableFrom(clsH4)) {
                    return clsH4.isArray() ? new r.f(strValue3, this.f75216a.i(a(clsH4.getComponentType()), annotationArr)).b() : new r.f(strValue3, this.f75216a.i(type, annotationArr));
                }
                if (type instanceof ParameterizedType) {
                    return new r.f(strValue3, this.f75216a.i(g0.g(0, (ParameterizedType) type), annotationArr)).c();
                }
                throw g0.o(this.f75217b, i11, clsH4.getSimpleName() + " must include generic type (e.g., " + clsH4.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof y30.j) {
                if (type == Headers.class) {
                    return new r.h(this.f75217b, i11);
                }
                j(i11, type);
                Class<?> clsH5 = g0.h(type);
                if (!Map.class.isAssignableFrom(clsH5)) {
                    throw g0.o(this.f75217b, i11, "@HeaderMap parameter type must be Map.", new Object[0]);
                }
                Type typeI2 = g0.i(type, clsH5, Map.class);
                if (!(typeI2 instanceof ParameterizedType)) {
                    throw g0.o(this.f75217b, i11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType2 = (ParameterizedType) typeI2;
                Type typeG2 = g0.g(0, parameterizedType2);
                if (String.class == typeG2) {
                    return new r.g(this.f75217b, i11, this.f75216a.i(g0.g(1, parameterizedType2), annotationArr));
                }
                throw g0.o(this.f75217b, i11, "@HeaderMap keys must be of type String: " + typeG2, new Object[0]);
            }
            if (annotation instanceof y30.c) {
                j(i11, type);
                if (!this.f75231p) {
                    throw g0.o(this.f75217b, i11, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
                y30.c cVar = (y30.c) annotation;
                String strValue4 = cVar.value();
                boolean zEncoded3 = cVar.encoded();
                this.f75221f = true;
                Class<?> clsH6 = g0.h(type);
                if (!Iterable.class.isAssignableFrom(clsH6)) {
                    return clsH6.isArray() ? new r.d(strValue4, this.f75216a.i(a(clsH6.getComponentType()), annotationArr), zEncoded3).b() : new r.d(strValue4, this.f75216a.i(type, annotationArr), zEncoded3);
                }
                if (type instanceof ParameterizedType) {
                    return new r.d(strValue4, this.f75216a.i(g0.g(0, (ParameterizedType) type), annotationArr), zEncoded3).c();
                }
                throw g0.o(this.f75217b, i11, clsH6.getSimpleName() + " must include generic type (e.g., " + clsH6.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof y30.d) {
                j(i11, type);
                if (!this.f75231p) {
                    throw g0.o(this.f75217b, i11, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                }
                Class<?> clsH7 = g0.h(type);
                if (!Map.class.isAssignableFrom(clsH7)) {
                    throw g0.o(this.f75217b, i11, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                Type typeI3 = g0.i(type, clsH7, Map.class);
                if (!(typeI3 instanceof ParameterizedType)) {
                    throw g0.o(this.f75217b, i11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType3 = (ParameterizedType) typeI3;
                Type typeG3 = g0.g(0, parameterizedType3);
                if (String.class == typeG3) {
                    i iVarI = this.f75216a.i(g0.g(1, parameterizedType3), annotationArr);
                    this.f75221f = true;
                    return new r.e(this.f75217b, i11, iVarI, ((y30.d) annotation).encoded());
                }
                throw g0.o(this.f75217b, i11, "@FieldMap keys must be of type String: " + typeG3, new Object[0]);
            }
            if (annotation instanceof y30.q) {
                j(i11, type);
                if (!this.f75232q) {
                    throw g0.o(this.f75217b, i11, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                }
                y30.q qVar = (y30.q) annotation;
                this.f75222g = true;
                String strValue5 = qVar.value();
                Class<?> clsH8 = g0.h(type);
                if (strValue5.isEmpty()) {
                    if (!Iterable.class.isAssignableFrom(clsH8)) {
                        if (clsH8.isArray()) {
                            if (MultipartBody.Part.class.isAssignableFrom(clsH8.getComponentType())) {
                                return r.o.f75358a.b();
                            }
                            throw g0.o(this.f75217b, i11, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                        if (MultipartBody.Part.class.isAssignableFrom(clsH8)) {
                            return r.o.f75358a;
                        }
                        throw g0.o(this.f75217b, i11, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    if (type instanceof ParameterizedType) {
                        if (MultipartBody.Part.class.isAssignableFrom(g0.h(g0.g(0, (ParameterizedType) type)))) {
                            return r.o.f75358a.c();
                        }
                        throw g0.o(this.f75217b, i11, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    throw g0.o(this.f75217b, i11, clsH8.getSimpleName() + " must include generic type (e.g., " + clsH8.getSimpleName() + "<String>)", new Object[0]);
                }
                Headers headersOf = Headers.of(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"" + strValue5 + "\"", "Content-Transfer-Encoding", qVar.encoding());
                if (!Iterable.class.isAssignableFrom(clsH8)) {
                    if (!clsH8.isArray()) {
                        if (MultipartBody.Part.class.isAssignableFrom(clsH8)) {
                            throw g0.o(this.f75217b, i11, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        }
                        return new r.i(this.f75217b, i11, headersOf, this.f75216a.g(type, annotationArr, this.f75218c));
                    }
                    Class<?> clsA = a(clsH8.getComponentType());
                    if (MultipartBody.Part.class.isAssignableFrom(clsA)) {
                        throw g0.o(this.f75217b, i11, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new r.i(this.f75217b, i11, headersOf, this.f75216a.g(clsA, annotationArr, this.f75218c)).b();
                }
                if (type instanceof ParameterizedType) {
                    Type typeG4 = g0.g(0, (ParameterizedType) type);
                    if (MultipartBody.Part.class.isAssignableFrom(g0.h(typeG4))) {
                        throw g0.o(this.f75217b, i11, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new r.i(this.f75217b, i11, headersOf, this.f75216a.g(typeG4, annotationArr, this.f75218c)).c();
                }
                throw g0.o(this.f75217b, i11, clsH8.getSimpleName() + " must include generic type (e.g., " + clsH8.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof y30.r) {
                j(i11, type);
                if (!this.f75232q) {
                    throw g0.o(this.f75217b, i11, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                }
                this.f75222g = true;
                Class<?> clsH9 = g0.h(type);
                if (!Map.class.isAssignableFrom(clsH9)) {
                    throw g0.o(this.f75217b, i11, "@PartMap parameter type must be Map.", new Object[0]);
                }
                Type typeI4 = g0.i(type, clsH9, Map.class);
                if (!(typeI4 instanceof ParameterizedType)) {
                    throw g0.o(this.f75217b, i11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType4 = (ParameterizedType) typeI4;
                Type typeG5 = g0.g(0, parameterizedType4);
                if (String.class == typeG5) {
                    Type typeG6 = g0.g(1, parameterizedType4);
                    if (MultipartBody.Part.class.isAssignableFrom(g0.h(typeG6))) {
                        throw g0.o(this.f75217b, i11, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                    }
                    return new r.j(this.f75217b, i11, this.f75216a.g(typeG6, annotationArr, this.f75218c), ((y30.r) annotation).encoding());
                }
                throw g0.o(this.f75217b, i11, "@PartMap keys must be of type String: " + typeG5, new Object[0]);
            }
            if (annotation instanceof y30.a) {
                j(i11, type);
                if (this.f75231p || this.f75232q) {
                    throw g0.o(this.f75217b, i11, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                }
                if (this.f75223h) {
                    throw g0.o(this.f75217b, i11, "Multiple @Body method annotations found.", new Object[0]);
                }
                try {
                    i iVarG = this.f75216a.g(type, annotationArr, this.f75218c);
                    this.f75223h = true;
                    return new r.c(this.f75217b, i11, iVarG);
                } catch (RuntimeException e11) {
                    throw g0.p(this.f75217b, e11, i11, "Unable to create @Body converter for %s", type);
                }
            }
            if (!(annotation instanceof y30.x)) {
                return null;
            }
            j(i11, type);
            Class<?> clsH10 = g0.h(type);
            for (int i12 = i11 - 1; i12 >= 0; i12--) {
                r<?> rVar = this.f75237v[i12];
                if ((rVar instanceof r.q) && ((r.q) rVar).f75361a.equals(clsH10)) {
                    throw g0.o(this.f75217b, i11, "@Tag type " + clsH10.getName() + " is duplicate of parameter #" + (i12 + 1) + " and would always overwrite its value.", new Object[0]);
                }
            }
            return new r.q(clsH10);
        }

        public final void i(int i11, String str) {
            if (!f75215y.matcher(str).matches()) {
                throw g0.o(this.f75217b, i11, "@Path parameter name must match %s. Found: %s", f75214x.pattern(), str);
            }
            if (!this.f75236u.contains(str)) {
                throw g0.o(this.f75217b, i11, "URL \"%s\" does not contain \"{%s}\".", this.f75233r, str);
            }
        }

        public final void j(int i11, Type type) {
            if (g0.j(type)) {
                throw g0.o(this.f75217b, i11, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }
    }

    public a0(a aVar) {
        this.f75203a = aVar.f75217b;
        this.f75204b = aVar.f75216a.f75244c;
        this.f75205c = aVar.f75229n;
        this.f75206d = aVar.f75233r;
        this.f75207e = aVar.f75234s;
        this.f75208f = aVar.f75235t;
        this.f75209g = aVar.f75230o;
        this.f75210h = aVar.f75231p;
        this.f75211i = aVar.f75232q;
        this.f75212j = aVar.f75237v;
        this.f75213k = aVar.f75238w;
    }

    public static a0 b(c0 c0Var, Method method) {
        return new a(c0Var, method).b();
    }

    public Request a(Object[] objArr) throws IOException {
        r<?>[] rVarArr = this.f75212j;
        int length = objArr.length;
        if (length != rVarArr.length) {
            throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + rVarArr.length + ")");
        }
        z zVar = new z(this.f75205c, this.f75204b, this.f75206d, this.f75207e, this.f75208f, this.f75209g, this.f75210h, this.f75211i);
        if (this.f75213k) {
            length--;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i11 = 0; i11 < length; i11++) {
            arrayList.add(objArr[i11]);
            rVarArr[i11].a(zVar, objArr[i11]);
        }
        return zVar.k().tag(n.class, new n(this.f75203a, arrayList)).build();
    }
}
