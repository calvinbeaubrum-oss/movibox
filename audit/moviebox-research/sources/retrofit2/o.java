package retrofit2;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import java.io.IOException;
import java.util.Objects;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class o<T> implements retrofit2.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0 f75299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f75300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Call.Factory f75301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i<ResponseBody, T> f75302d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f75303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Call f75304g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Throwable f75305h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f75306i;

    /* JADX INFO: compiled from: source.java */
    public class a implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f75307a;

        public a(d dVar) {
            this.f75307a = dVar;
        }

        private void a(Throwable th2) {
            try {
                this.f75307a.a(o.this, th2);
            } catch (Throwable th3) {
                g0.s(th3);
                th3.printStackTrace();
            }
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            a(iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            try {
                try {
                    this.f75307a.b(o.this, o.this.d(response));
                } catch (Throwable th2) {
                    g0.s(th2);
                    th2.printStackTrace();
                }
            } catch (Throwable th3) {
                g0.s(th3);
                a(th3);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends ResponseBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ResponseBody f75309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BufferedSource f75310b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public IOException f75311c;

        /* JADX INFO: compiled from: source.java */
        public class a extends ForwardingSource {
            public a(Source source) {
                super(source);
            }

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j11) throws IOException {
                try {
                    return super.read(buffer, j11);
                } catch (IOException e11) {
                    b.this.f75311c = e11;
                    throw e11;
                }
            }
        }

        public b(ResponseBody responseBody) {
            this.f75309a = responseBody;
            this.f75310b = Okio.buffer(new a(responseBody.source()));
        }

        public void a() throws IOException {
            IOException iOException = this.f75311c;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f75309a.close();
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.f75309a.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.f75309a.contentType();
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            return this.f75310b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends ResponseBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaType f75313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f75314b;

        public c(MediaType mediaType, long j11) {
            this.f75313a = mediaType;
            this.f75314b = j11;
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.f75314b;
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.f75313a;
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public o(a0 a0Var, Object[] objArr, Call.Factory factory, i<ResponseBody, T> iVar) {
        this.f75299a = a0Var;
        this.f75300b = objArr;
        this.f75301c = factory;
        this.f75302d = iVar;
    }

    @Override // retrofit2.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public o<T> clone() {
        return new o<>(this.f75299a, this.f75300b, this.f75301c, this.f75302d);
    }

    public final Call b() throws IOException {
        Call callNewCall = this.f75301c.newCall(this.f75299a.a(this.f75300b));
        if (callNewCall != null) {
            return callNewCall;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    public final Call c() throws IOException {
        Call call = this.f75304g;
        if (call != null) {
            return call;
        }
        Throwable th2 = this.f75305h;
        if (th2 != null) {
            if (th2 instanceof IOException) {
                throw ((IOException) th2);
            }
            if (th2 instanceof RuntimeException) {
                throw ((RuntimeException) th2);
            }
            throw ((Error) th2);
        }
        try {
            Call callB = b();
            this.f75304g = callB;
            return callB;
        } catch (IOException | Error | RuntimeException e11) {
            g0.s(e11);
            this.f75305h = e11;
            throw e11;
        }
    }

    @Override // retrofit2.b
    public void cancel() {
        Call call;
        this.f75303f = true;
        synchronized (this) {
            call = this.f75304g;
        }
        if (call != null) {
            call.cancel();
        }
    }

    public b0<T> d(Response response) throws IOException {
        ResponseBody responseBodyBody = response.body();
        Response responseBuild = response.newBuilder().body(new c(responseBodyBody.contentType(), responseBodyBody.contentLength())).build();
        int iCode = responseBuild.code();
        if (iCode < 200 || iCode >= 300) {
            try {
                return b0.c(g0.a(responseBodyBody), responseBuild);
            } finally {
                responseBodyBody.close();
            }
        }
        if (iCode == 204 || iCode == 205) {
            responseBodyBody.close();
            return b0.g(null, responseBuild);
        }
        b bVar = new b(responseBodyBody);
        try {
            return b0.g(this.f75302d.a(bVar), responseBuild);
        } catch (RuntimeException e11) {
            bVar.a();
            throw e11;
        }
    }

    @Override // retrofit2.b
    public void e(d<T> dVar) {
        Call call;
        Throwable th2;
        Objects.requireNonNull(dVar, "callback == null");
        synchronized (this) {
            try {
                if (this.f75306i) {
                    throw new IllegalStateException("Already executed.");
                }
                this.f75306i = true;
                call = this.f75304g;
                th2 = this.f75305h;
                if (call == null && th2 == null) {
                    try {
                        Call callB = b();
                        this.f75304g = callB;
                        call = callB;
                    } catch (Throwable th3) {
                        th2 = th3;
                        g0.s(th2);
                        this.f75305h = th2;
                    }
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
        if (th2 != null) {
            dVar.a(this, th2);
            return;
        }
        if (this.f75303f) {
            call.cancel();
        }
        FirebasePerfOkHttpClient.enqueue(call, new a(dVar));
    }

    @Override // retrofit2.b
    public b0<T> execute() throws IOException {
        Call callC;
        synchronized (this) {
            if (this.f75306i) {
                throw new IllegalStateException("Already executed.");
            }
            this.f75306i = true;
            callC = c();
        }
        if (this.f75303f) {
            callC.cancel();
        }
        return d(FirebasePerfOkHttpClient.execute(callC));
    }

    @Override // retrofit2.b
    public boolean isCanceled() {
        boolean z11 = true;
        if (this.f75303f) {
            return true;
        }
        synchronized (this) {
            try {
                Call call = this.f75304g;
                if (call == null || !call.isCanceled()) {
                    z11 = false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z11;
    }

    @Override // retrofit2.b
    public synchronized Request request() {
        try {
        } catch (IOException e11) {
            throw new RuntimeException("Unable to create request.", e11);
        }
        return c().request();
    }
}
