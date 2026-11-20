package cm;

import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.net.cronet.okhttptransport.OkHttpBridgeRequestCallback;
import java.io.IOException;
import java.util.concurrent.Executor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.chromium.net.CronetEngine;
import org.chromium.net.UrlRequest;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CronetEngine f14983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f14984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f14985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f14986d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f14987e;

    /* JADX INFO: compiled from: source.java */
    public class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Request f14988a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OkHttpBridgeRequestCallback f14989b;

        public a(Request request, OkHttpBridgeRequestCallback okHttpBridgeRequestCallback) {
            this.f14988a = request;
            this.f14989b = okHttpBridgeRequestCallback;
        }

        @Override // cm.g.c
        public Response getResponse() throws IOException {
            return g.this.f14985c.f(this.f14988a, this.f14989b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UrlRequest f14991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f14992b;

        public b(UrlRequest urlRequest, c cVar) {
            this.f14991a = urlRequest;
            this.f14992b = cVar;
        }

        public UrlRequest a() {
            return this.f14991a;
        }

        public Response b() throws IOException {
            return this.f14992b.getResponse();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        Response getResponse() throws IOException;
    }

    public g(CronetEngine cronetEngine, Executor executor, e eVar, i iVar, d dVar) {
        this.f14983a = cronetEngine;
        this.f14984b = executor;
        this.f14986d = eVar;
        this.f14985c = iVar;
        this.f14987e = dVar;
    }

    public b b(Request request, int i11, int i12) throws IOException {
        OkHttpBridgeRequestCallback okHttpBridgeRequestCallback = new OkHttpBridgeRequestCallback(i11, this.f14987e);
        UrlRequest.Builder builderAllowDirectExecutor = this.f14983a.newUrlRequestBuilder(request.url().toString(), okHttpBridgeRequestCallback, MoreExecutors.a()).allowDirectExecutor();
        builderAllowDirectExecutor.setHttpMethod(request.method());
        for (int i13 = 0; i13 < request.headers().size(); i13++) {
            builderAllowDirectExecutor.addHeader(request.headers().name(i13), request.headers().value(i13));
        }
        RequestBody requestBodyBody = request.body();
        if (requestBodyBody != null) {
            if (request.header(HttpHeaders.CONTENT_LENGTH) == null && requestBodyBody.contentLength() != -1) {
                builderAllowDirectExecutor.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(requestBodyBody.contentLength()));
            }
            if (requestBodyBody.contentLength() != 0) {
                if (request.header(HttpHeaders.CONTENT_TYPE) != null || requestBodyBody.contentType() == null) {
                    builderAllowDirectExecutor.addHeader(HttpHeaders.CONTENT_TYPE, OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
                } else {
                    builderAllowDirectExecutor.addHeader(HttpHeaders.CONTENT_TYPE, requestBodyBody.contentType().toString());
                }
                builderAllowDirectExecutor.setUploadDataProvider(this.f14986d.a(requestBodyBody, i12), this.f14984b);
            }
        }
        return new b(builderAllowDirectExecutor.build(), c(request, okHttpBridgeRequestCallback));
    }

    public final c c(Request request, OkHttpBridgeRequestCallback okHttpBridgeRequestCallback) {
        return new a(request, okHttpBridgeRequestCallback);
    }
}
