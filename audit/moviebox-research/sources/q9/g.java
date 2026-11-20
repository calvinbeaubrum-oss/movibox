package q9;

import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.cloud.hisavana.protocol.okhttptransport.OkHttpBridgeRequestCallback;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.concurrent.Executor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.chromium.net.CronetEngine;
import org.chromium.net.UrlRequest;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CronetEngine f74468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f74469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f74470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f74471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f74472e;

    /* JADX INFO: compiled from: source.java */
    public class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Request f74473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OkHttpBridgeRequestCallback f74474b;

        public a(Request request, OkHttpBridgeRequestCallback okHttpBridgeRequestCallback) {
            this.f74473a = request;
            this.f74474b = okHttpBridgeRequestCallback;
        }

        @Override // q9.g.c
        public Response getResponse() throws IOException {
            return g.this.f74470c.g(this.f74473a, this.f74474b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UrlRequest f74476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f74477b;

        public b(UrlRequest urlRequest, c cVar) {
            this.f74476a = urlRequest;
            this.f74477b = cVar;
        }

        public UrlRequest a() {
            return this.f74476a;
        }

        public Response b() throws IOException {
            return this.f74477b.getResponse();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        Response getResponse() throws IOException;
    }

    public g(CronetEngine cronetEngine, Executor executor, e eVar, i iVar, d dVar) {
        this.f74468a = cronetEngine;
        this.f74469b = executor;
        this.f74471d = eVar;
        this.f74470c = iVar;
        this.f74472e = dVar;
    }

    public b b(Request request, int i11, int i12) throws IOException {
        OkHttpBridgeRequestCallback okHttpBridgeRequestCallback = new OkHttpBridgeRequestCallback(i11, this.f74472e);
        UrlRequest.Builder builderAllowDirectExecutor = this.f74468a.newUrlRequestBuilder(request.url().toString(), okHttpBridgeRequestCallback, MoreExecutors.a()).allowDirectExecutor();
        builderAllowDirectExecutor.addRequestAnnotation(request.headers());
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
                if (requestBodyBody.contentType() != null) {
                    builderAllowDirectExecutor.addHeader(HttpHeaders.CONTENT_TYPE, requestBodyBody.contentType().toString());
                } else if (request.header(HttpHeaders.CONTENT_TYPE) == null) {
                    builderAllowDirectExecutor.addHeader(HttpHeaders.CONTENT_TYPE, OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
                }
                builderAllowDirectExecutor.setUploadDataProvider(this.f74471d.a(requestBodyBody, i12), this.f74469b);
            }
        }
        return new b(builderAllowDirectExecutor.build(), c(request, okHttpBridgeRequestCallback));
    }

    public final c c(Request request, OkHttpBridgeRequestCallback okHttpBridgeRequestCallback) {
        return new a(request, okHttpBridgeRequestCallback);
    }
}
