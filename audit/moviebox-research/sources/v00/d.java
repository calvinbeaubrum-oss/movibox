package v00;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class d<T> implements v00.b<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f78678c = "d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w00.a<ResponseBody, T> f78679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Call f78680b;

    /* JADX INFO: compiled from: source.java */
    public class a implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v00.c f78681a;

        public a(v00.c cVar) {
            this.f78681a = cVar;
        }

        public final void a(Throwable th2) {
            try {
                this.f78681a.b(d.this, th2);
            } catch (Throwable th3) {
                Log.w(d.f78678c, "Error on executing callback", th3);
            }
        }

        @Override // okhttp3.Callback
        public void onFailure(@NonNull Call call, @NonNull IOException iOException) {
            a(iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(@NonNull Call call, @NonNull Response response) {
            try {
                d dVar = d.this;
                try {
                    this.f78681a.a(d.this, dVar.e(response, dVar.f78679a));
                } catch (Throwable th2) {
                    Log.w(d.f78678c, "Error on excuting callback", th2);
                }
            } catch (Throwable th3) {
                a(th3);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends ResponseBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ResponseBody f78683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public IOException f78684b;

        /* JADX INFO: compiled from: source.java */
        public class a extends ForwardingSource {
            public a(Source source) {
                super(source);
            }

            @Override // okio.ForwardingSource, okio.Source
            public long read(@NonNull Buffer buffer, long j11) throws IOException {
                try {
                    return super.read(buffer, j11);
                } catch (IOException e11) {
                    b.this.f78684b = e11;
                    throw e11;
                }
            }
        }

        public b(ResponseBody responseBody) {
            this.f78683a = responseBody;
        }

        public void a() throws IOException {
            IOException iOException = this.f78684b;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f78683a.close();
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.f78683a.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.f78683a.contentType();
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            return Okio.buffer(new a(this.f78683a.source()));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends ResponseBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final MediaType f78686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f78687b;

        public c(@Nullable MediaType mediaType, long j11) {
            this.f78686a = mediaType;
            this.f78687b = j11;
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.f78687b;
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.f78686a;
        }

        @Override // okhttp3.ResponseBody
        @NonNull
        public BufferedSource source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public d(@NonNull Call call, w00.a<ResponseBody, T> aVar) {
        this.f78680b = call;
        this.f78679a = aVar;
    }

    @Override // v00.b
    public void a(v00.c<T> cVar) {
        FirebasePerfOkHttpClient.enqueue(this.f78680b, new a(cVar));
    }

    public final e<T> e(Response response, w00.a<ResponseBody, T> aVar) throws IOException {
        ResponseBody responseBodyBody = response.body();
        Response responseBuild = response.newBuilder().body(new c(responseBodyBody.contentType(), responseBodyBody.contentLength())).build();
        int iCode = responseBuild.code();
        if (iCode < 200 || iCode >= 300) {
            try {
                Buffer buffer = new Buffer();
                responseBodyBody.source().readAll(buffer);
                return e.c(ResponseBody.create(responseBodyBody.contentType(), responseBodyBody.contentLength(), buffer), responseBuild);
            } finally {
                responseBodyBody.close();
            }
        }
        if (iCode == 204 || iCode == 205) {
            responseBodyBody.close();
            return e.g(null, responseBuild);
        }
        b bVar = new b(responseBodyBody);
        try {
            return e.g(aVar.a(bVar), responseBuild);
        } catch (RuntimeException e11) {
            bVar.a();
            throw e11;
        }
    }

    @Override // v00.b
    public e<T> execute() throws IOException {
        Call call;
        synchronized (this) {
            call = this.f78680b;
        }
        return e(FirebasePerfOkHttpClient.execute(call), this.f78679a);
    }
}
