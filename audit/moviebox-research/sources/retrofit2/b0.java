package retrofit2;

import java.util.Objects;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class b0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Response f75239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f75240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ResponseBody f75241c;

    public b0(Response response, T t11, ResponseBody responseBody) {
        this.f75239a = response;
        this.f75240b = t11;
        this.f75241c = responseBody;
    }

    public static <T> b0<T> c(ResponseBody responseBody, Response response) {
        Objects.requireNonNull(responseBody, "body == null");
        Objects.requireNonNull(response, "rawResponse == null");
        if (response.isSuccessful()) {
            throw new IllegalArgumentException("rawResponse should not be successful response");
        }
        return new b0<>(response, null, responseBody);
    }

    public static <T> b0<T> g(T t11, Response response) {
        Objects.requireNonNull(response, "rawResponse == null");
        if (response.isSuccessful()) {
            return new b0<>(response, t11, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public T a() {
        return this.f75240b;
    }

    public int b() {
        return this.f75239a.code();
    }

    public ResponseBody d() {
        return this.f75241c;
    }

    public boolean e() {
        return this.f75239a.isSuccessful();
    }

    public String f() {
        return this.f75239a.message();
    }

    public String toString() {
        return this.f75239a.toString();
    }
}
