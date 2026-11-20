package cm;

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
/* JADX INFO: loaded from: classes6.dex */
public final class b implements Interceptor, AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f14975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Call, UrlRequest> f14976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScheduledExecutorService f14977c;

    /* JADX INFO: renamed from: cm.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0158b extends h<C0158b, b> {
        public C0158b(CronetEngine cronetEngine) {
            super(cronetEngine, C0158b.class);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [cm.b, java.lang.Object] */
        @Override // cm.h
        public /* bridge */ /* synthetic */ b a() {
            return super.a();
        }

        @Override // cm.h
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public b b(g gVar) {
            return new b(gVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends cm.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Call f14978b;

        public c(ResponseBody responseBody, Call call) {
            super(responseBody);
            this.f14978b = call;
        }

        @Override // cm.c
        public void a() {
            b.this.f14976b.remove(this.f14978b);
        }
    }

    public b(g gVar) {
        this.f14976b = new ConcurrentHashMap();
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        this.f14977c = scheduledThreadPoolExecutor;
        this.f14975a = (g) m.p(gVar);
        scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() { // from class: cm.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f14974a.c();
            }
        }, 500L, 500L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        Iterator<Map.Entry<Call, UrlRequest>> it = this.f14976b.entrySet().iterator();
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

    public static C0158b d(CronetEngine cronetEngine) {
        return new C0158b(cronetEngine);
    }

    private Response e(Response response, Call call) {
        m.p(response.body());
        return response.body() instanceof c ? response : response.newBuilder().body(new c(response.body(), call)).build();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.f14977c.shutdown();
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        if (chain.call().isCanceled()) {
            throw new IOException("Canceled");
        }
        g.b bVarB = this.f14975a.b(chain.request(), chain.readTimeoutMillis(), chain.writeTimeoutMillis());
        this.f14976b.put(chain.call(), bVarB.a());
        try {
            bVarB.a().start();
            return e(bVarB.b(), chain.call());
        } catch (IOException | RuntimeException e11) {
            this.f14976b.remove(chain.call());
            throw e11;
        }
    }
}
