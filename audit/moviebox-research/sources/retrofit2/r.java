package retrofit2;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class r<T> {

    /* JADX INFO: compiled from: source.java */
    public class a extends r<Iterable<T>> {
        public a() {
        }

        @Override // retrofit2.r
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z zVar, Iterable<T> iterable) throws IOException {
            if (iterable == null) {
                return;
            }
            Iterator<T> it = iterable.iterator();
            while (it.hasNext()) {
                r.this.a(zVar, it.next());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends r<Object> {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // retrofit2.r
        public void a(z zVar, Object obj) throws IOException {
            if (obj == null) {
                return;
            }
            int length = Array.getLength(obj);
            for (int i11 = 0; i11 < length; i11++) {
                r.this.a(zVar, Array.get(obj, i11));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c<T> extends r<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f75319a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f75320b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final retrofit2.i<T, RequestBody> f75321c;

        public c(Method method, int i11, retrofit2.i<T, RequestBody> iVar) {
            this.f75319a = method;
            this.f75320b = i11;
            this.f75321c = iVar;
        }

        @Override // retrofit2.r
        public void a(z zVar, T t11) {
            if (t11 == null) {
                throw g0.o(this.f75319a, this.f75320b, "Body parameter value must not be null.", new Object[0]);
            }
            try {
                zVar.l(this.f75321c.a(t11));
            } catch (IOException e11) {
                throw g0.p(this.f75319a, e11, this.f75320b, "Unable to convert " + t11 + " to RequestBody", new Object[0]);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d<T> extends r<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f75322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final retrofit2.i<T, String> f75323b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f75324c;

        public d(String str, retrofit2.i<T, String> iVar, boolean z11) {
            Objects.requireNonNull(str, "name == null");
            this.f75322a = str;
            this.f75323b = iVar;
            this.f75324c = z11;
        }

        @Override // retrofit2.r
        public void a(z zVar, T t11) throws IOException {
            String strA;
            if (t11 == null || (strA = this.f75323b.a(t11)) == null) {
                return;
            }
            zVar.a(this.f75322a, strA, this.f75324c);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e<T> extends r<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f75325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f75326b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final retrofit2.i<T, String> f75327c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f75328d;

        public e(Method method, int i11, retrofit2.i<T, String> iVar, boolean z11) {
            this.f75325a = method;
            this.f75326b = i11;
            this.f75327c = iVar;
            this.f75328d = z11;
        }

        @Override // retrofit2.r
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z zVar, Map<String, T> map) throws IOException {
            if (map == null) {
                throw g0.o(this.f75325a, this.f75326b, "Field map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw g0.o(this.f75325a, this.f75326b, "Field map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw g0.o(this.f75325a, this.f75326b, "Field map contained null value for key '" + key + "'.", new Object[0]);
                }
                String strA = this.f75327c.a(value);
                if (strA == null) {
                    throw g0.o(this.f75325a, this.f75326b, "Field map value '" + value + "' converted to null by " + this.f75327c.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                }
                zVar.a(key, strA, this.f75328d);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f<T> extends r<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f75329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final retrofit2.i<T, String> f75330b;

        public f(String str, retrofit2.i<T, String> iVar) {
            Objects.requireNonNull(str, "name == null");
            this.f75329a = str;
            this.f75330b = iVar;
        }

        @Override // retrofit2.r
        public void a(z zVar, T t11) throws IOException {
            String strA;
            if (t11 == null || (strA = this.f75330b.a(t11)) == null) {
                return;
            }
            zVar.b(this.f75329a, strA);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g<T> extends r<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f75331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f75332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final retrofit2.i<T, String> f75333c;

        public g(Method method, int i11, retrofit2.i<T, String> iVar) {
            this.f75331a = method;
            this.f75332b = i11;
            this.f75333c = iVar;
        }

        @Override // retrofit2.r
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z zVar, Map<String, T> map) throws IOException {
            if (map == null) {
                throw g0.o(this.f75331a, this.f75332b, "Header map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw g0.o(this.f75331a, this.f75332b, "Header map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw g0.o(this.f75331a, this.f75332b, "Header map contained null value for key '" + key + "'.", new Object[0]);
                }
                zVar.b(key, this.f75333c.a(value));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class h extends r<Headers> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f75334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f75335b;

        public h(Method method, int i11) {
            this.f75334a = method;
            this.f75335b = i11;
        }

        @Override // retrofit2.r
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z zVar, Headers headers) {
            if (headers == null) {
                throw g0.o(this.f75334a, this.f75335b, "Headers parameter must not be null.", new Object[0]);
            }
            zVar.c(headers);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class i<T> extends r<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f75336a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f75337b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Headers f75338c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final retrofit2.i<T, RequestBody> f75339d;

        public i(Method method, int i11, Headers headers, retrofit2.i<T, RequestBody> iVar) {
            this.f75336a = method;
            this.f75337b = i11;
            this.f75338c = headers;
            this.f75339d = iVar;
        }

        @Override // retrofit2.r
        public void a(z zVar, T t11) {
            if (t11 == null) {
                return;
            }
            try {
                zVar.d(this.f75338c, this.f75339d.a(t11));
            } catch (IOException e11) {
                throw g0.o(this.f75336a, this.f75337b, "Unable to convert " + t11 + " to RequestBody", e11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class j<T> extends r<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f75340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f75341b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final retrofit2.i<T, RequestBody> f75342c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f75343d;

        public j(Method method, int i11, retrofit2.i<T, RequestBody> iVar, String str) {
            this.f75340a = method;
            this.f75341b = i11;
            this.f75342c = iVar;
            this.f75343d = str;
        }

        @Override // retrofit2.r
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z zVar, Map<String, T> map) throws IOException {
            if (map == null) {
                throw g0.o(this.f75340a, this.f75341b, "Part map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw g0.o(this.f75340a, this.f75341b, "Part map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw g0.o(this.f75340a, this.f75341b, "Part map contained null value for key '" + key + "'.", new Object[0]);
                }
                zVar.d(Headers.of(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"" + key + "\"", "Content-Transfer-Encoding", this.f75343d), this.f75342c.a(value));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class k<T> extends r<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f75344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f75345b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f75346c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final retrofit2.i<T, String> f75347d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f75348e;

        public k(Method method, int i11, String str, retrofit2.i<T, String> iVar, boolean z11) {
            this.f75344a = method;
            this.f75345b = i11;
            Objects.requireNonNull(str, "name == null");
            this.f75346c = str;
            this.f75347d = iVar;
            this.f75348e = z11;
        }

        @Override // retrofit2.r
        public void a(z zVar, T t11) throws IOException {
            if (t11 != null) {
                zVar.f(this.f75346c, this.f75347d.a(t11), this.f75348e);
                return;
            }
            throw g0.o(this.f75344a, this.f75345b, "Path parameter \"" + this.f75346c + "\" value must not be null.", new Object[0]);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class l<T> extends r<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f75349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final retrofit2.i<T, String> f75350b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f75351c;

        public l(String str, retrofit2.i<T, String> iVar, boolean z11) {
            Objects.requireNonNull(str, "name == null");
            this.f75349a = str;
            this.f75350b = iVar;
            this.f75351c = z11;
        }

        @Override // retrofit2.r
        public void a(z zVar, T t11) throws IOException {
            String strA;
            if (t11 == null || (strA = this.f75350b.a(t11)) == null) {
                return;
            }
            zVar.g(this.f75349a, strA, this.f75351c);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class m<T> extends r<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f75352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f75353b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final retrofit2.i<T, String> f75354c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f75355d;

        public m(Method method, int i11, retrofit2.i<T, String> iVar, boolean z11) {
            this.f75352a = method;
            this.f75353b = i11;
            this.f75354c = iVar;
            this.f75355d = z11;
        }

        @Override // retrofit2.r
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z zVar, Map<String, T> map) throws IOException {
            if (map == null) {
                throw g0.o(this.f75352a, this.f75353b, "Query map was null", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw g0.o(this.f75352a, this.f75353b, "Query map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw g0.o(this.f75352a, this.f75353b, "Query map contained null value for key '" + key + "'.", new Object[0]);
                }
                String strA = this.f75354c.a(value);
                if (strA == null) {
                    throw g0.o(this.f75352a, this.f75353b, "Query map value '" + value + "' converted to null by " + this.f75354c.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                }
                zVar.g(key, strA, this.f75355d);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class n<T> extends r<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final retrofit2.i<T, String> f75356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f75357b;

        public n(retrofit2.i<T, String> iVar, boolean z11) {
            this.f75356a = iVar;
            this.f75357b = z11;
        }

        @Override // retrofit2.r
        public void a(z zVar, T t11) throws IOException {
            if (t11 == null) {
                return;
            }
            zVar.g(this.f75356a.a(t11), null, this.f75357b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class o extends r<MultipartBody.Part> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f75358a = new o();

        @Override // retrofit2.r
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z zVar, MultipartBody.Part part) {
            if (part != null) {
                zVar.e(part);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class p extends r<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f75359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f75360b;

        public p(Method method, int i11) {
            this.f75359a = method;
            this.f75360b = i11;
        }

        @Override // retrofit2.r
        public void a(z zVar, Object obj) {
            if (obj == null) {
                throw g0.o(this.f75359a, this.f75360b, "@Url parameter is null.", new Object[0]);
            }
            zVar.m(obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class q<T> extends r<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<T> f75361a;

        public q(Class<T> cls) {
            this.f75361a = cls;
        }

        @Override // retrofit2.r
        public void a(z zVar, T t11) {
            zVar.h(this.f75361a, t11);
        }
    }

    public abstract void a(z zVar, T t11) throws IOException;

    public final r<Object> b() {
        return new b();
    }

    public final r<Iterable<T>> c() {
        return new a();
    }
}
