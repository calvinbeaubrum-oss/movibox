package v00;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Response f78688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final T f78689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final ResponseBody f78690c;

    public e(Response response, @Nullable T t11, @Nullable ResponseBody responseBody) {
        this.f78688a = response;
        this.f78689b = t11;
        this.f78690c = responseBody;
    }

    public static <T> e<T> c(@NonNull ResponseBody responseBody, @NonNull Response response) {
        if (response.isSuccessful()) {
            throw new IllegalArgumentException("rawResponse should not be successful response");
        }
        return new e<>(response, null, responseBody);
    }

    public static <T> e<T> g(@Nullable T t11, @NonNull Response response) {
        if (response.isSuccessful()) {
            return new e<>(response, t11, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    @Nullable
    public T a() {
        return this.f78689b;
    }

    public int b() {
        return this.f78688a.code();
    }

    public Headers d() {
        return this.f78688a.headers();
    }

    public boolean e() {
        return this.f78688a.isSuccessful();
    }

    public String f() {
        return this.f78688a.message();
    }

    public String toString() {
        return this.f78688a.toString();
    }
}
