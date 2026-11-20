package sl;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import vl.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class i implements Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callback f76394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.firebase.perf.metrics.j f76395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Timer f76396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f76397d;

    public i(Callback callback, k kVar, Timer timer, long j11) {
        this.f76394a = callback;
        this.f76395b = com.google.firebase.perf.metrics.j.d(kVar);
        this.f76397d = j11;
        this.f76396c = timer;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        Request request = call.request();
        if (request != null) {
            HttpUrl httpUrlUrl = request.url();
            if (httpUrlUrl != null) {
                this.f76395b.s(httpUrlUrl.url().toString());
            }
            if (request.method() != null) {
                this.f76395b.h(request.method());
            }
        }
        this.f76395b.m(this.f76397d);
        this.f76395b.q(this.f76396c.getDurationMicros());
        j.d(this.f76395b);
        this.f76394a.onFailure(call, iOException);
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) throws IOException {
        FirebasePerfOkHttpClient.a(response, this.f76395b, this.f76397d, this.f76396c.getDurationMicros());
        this.f76394a.onResponse(call, response);
    }
}
