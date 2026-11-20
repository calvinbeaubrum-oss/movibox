package q9;

import android.util.Log;
import com.google.common.base.m;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.chromium.net.CronetEngine;
import org.chromium.net.UrlRequest;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements Interceptor, AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f74460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Call, UrlRequest> f74461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScheduledExecutorService f74462c;

    /* JADX INFO: renamed from: q9.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0815b extends h<C0815b, b> {
        public C0815b(CronetEngine cronetEngine) {
            super(cronetEngine, C0815b.class);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, q9.b] */
        @Override // q9.h
        public /* bridge */ /* synthetic */ b a() {
            return super.a();
        }

        @Override // q9.h
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public b b(g gVar) {
            return new b(gVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends q9.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Call f74463b;

        public c(ResponseBody responseBody, Call call) {
            super(responseBody);
            this.f74463b = call;
        }

        @Override // q9.c
        public void a() {
            b.this.f74461b.remove(this.f74463b);
        }
    }

    public b(g gVar) {
        this.f74461b = new ConcurrentHashMap();
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        this.f74462c = scheduledThreadPoolExecutor;
        this.f74460a = (g) m.p(gVar);
        scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() { // from class: q9.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f74459a.c();
            }
        }, 500L, 500L, TimeUnit.MILLISECONDS);
    }

    public static C0815b d(CronetEngine cronetEngine) {
        return new C0815b(cronetEngine);
    }

    public final /* synthetic */ void c() {
        Iterator<Map.Entry<Call, UrlRequest>> it = this.f74461b.entrySet().iterator();
        while (it.hasNext()) {
            try {
                Map.Entry<Call, UrlRequest> next = it.next();
                if (next.getKey().isCanceled()) {
                    it.remove();
                    next.getValue().cancel();
                }
            } catch (RuntimeException e11) {
                Log.w("CronetInterceptor", "Unable to propagate cancellation status", e11);
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.f74462c.shutdown();
    }

    public final Response e(Response response, Call call) {
        m.p(response.body());
        return response.body() instanceof c ? response : response.newBuilder().body(new c(response.body(), call)).build();
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        if (chain.call().isCanceled()) {
            throw new IOException("Canceled");
        }
        g.b bVarB = this.f74460a.b(chain.request(), chain.readTimeoutMillis(), chain.writeTimeoutMillis());
        this.f74461b.put(chain.call(), bVarB.a());
        try {
            bVarB.a().start();
            return e(bVarB.b(), chain.call());
        } catch (IOException | RuntimeException e11) {
            this.f74461b.remove(chain.call());
            throw e11;
        }
    }
}
