package sl;

import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class h<T> implements ResponseHandler<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ResponseHandler<? extends T> f76391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Timer f76392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.firebase.perf.metrics.j f76393c;

    public h(ResponseHandler<? extends T> responseHandler, Timer timer, com.google.firebase.perf.metrics.j jVar) {
        this.f76391a = responseHandler;
        this.f76392b = timer;
        this.f76393c = jVar;
    }

    @Override // org.apache.http.client.ResponseHandler
    public T handleResponse(HttpResponse httpResponse) throws IOException {
        this.f76393c.q(this.f76392b.getDurationMicros());
        this.f76393c.i(httpResponse.getStatusLine().getStatusCode());
        Long lA = j.a(httpResponse);
        if (lA != null) {
            this.f76393c.o(lA.longValue());
        }
        String strB = j.b(httpResponse);
        if (strB != null) {
            this.f76393c.n(strB);
        }
        this.f76393c.c();
        return this.f76391a.handleResponse(httpResponse);
    }
}
