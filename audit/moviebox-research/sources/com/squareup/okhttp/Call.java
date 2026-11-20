package com.squareup.okhttp;

import androidx.core.app.NotificationCompat;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.c;
import com.squareup.okhttp.internal.http.RequestException;
import com.squareup.okhttp.internal.http.RouteException;
import com.squareup.okhttp.internal.http.g;
import com.squareup.okhttp.internal.http.n;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.logging.Level;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class Call {
    volatile boolean canceled;
    private final OkHttpClient client;
    g engine;
    private boolean executed;
    Request originalRequest;

    /* JADX INFO: compiled from: source.java */
    public class ApplicationInterceptorChain implements Interceptor.Chain {
        private final boolean forWebSocket;
        private final int index;
        private final Request request;

        public ApplicationInterceptorChain(int i11, Request request, boolean z11) {
            this.index = i11;
            this.request = request;
            this.forWebSocket = z11;
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Connection connection() {
            return null;
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Response proceed(Request request) throws IOException {
            if (this.index >= Call.this.client.interceptors().size()) {
                return Call.this.getResponse(request, this.forWebSocket);
            }
            ApplicationInterceptorChain applicationInterceptorChain = Call.this.new ApplicationInterceptorChain(this.index + 1, request, this.forWebSocket);
            Interceptor interceptor = Call.this.client.interceptors().get(this.index);
            Response responseIntercept = interceptor.intercept(applicationInterceptorChain);
            if (responseIntercept != null) {
                return responseIntercept;
            }
            throw new NullPointerException("application interceptor " + interceptor + " returned null");
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Request request() {
            return this.request;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class AsyncCall extends NamedRunnable {
        private final boolean forWebSocket;
        private final Callback responseCallback;

        private AsyncCall(Callback callback, boolean z11) {
            super("OkHttp %s", Call.this.originalRequest.urlString());
            this.responseCallback = callback;
            this.forWebSocket = z11;
        }

        public void cancel() {
            Call.this.cancel();
        }

        @Override // com.squareup.okhttp.internal.NamedRunnable
        public void execute() {
            IOException e11;
            boolean z11;
            try {
                try {
                    Response responseWithInterceptorChain = Call.this.getResponseWithInterceptorChain(this.forWebSocket);
                    z11 = true;
                    try {
                        if (Call.this.canceled) {
                            this.responseCallback.onFailure(Call.this.originalRequest, new IOException("Canceled"));
                        } else {
                            this.responseCallback.onResponse(responseWithInterceptorChain);
                        }
                    } catch (IOException e12) {
                        e11 = e12;
                        if (z11) {
                            c.logger.log(Level.INFO, "Callback failure for " + Call.this.toLoggableString(), (Throwable) e11);
                        } else {
                            Call call = Call.this;
                            g gVar = call.engine;
                            this.responseCallback.onFailure(gVar == null ? call.originalRequest : gVar.l(), e11);
                        }
                    }
                } finally {
                    Call.this.client.getDispatcher().finished(this);
                }
            } catch (IOException e13) {
                e11 = e13;
                z11 = false;
            }
        }

        public Call get() {
            return Call.this;
        }

        public String host() {
            return Call.this.originalRequest.httpUrl().host();
        }

        public Request request() {
            return Call.this.originalRequest;
        }

        public Object tag() {
            return Call.this.originalRequest.tag();
        }
    }

    public Call(OkHttpClient okHttpClient, Request request) {
        this.client = okHttpClient.copyWithDefaults();
        this.originalRequest = request;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Response getResponseWithInterceptorChain(boolean z11) throws IOException {
        return new ApplicationInterceptorChain(0, this.originalRequest, z11).proceed(this.originalRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String toLoggableString() {
        return (this.canceled ? "canceled call" : NotificationCompat.CATEGORY_CALL) + " to " + this.originalRequest.httpUrl().resolve("/...");
    }

    public void cancel() {
        this.canceled = true;
        g gVar = this.engine;
        if (gVar != null) {
            gVar.e();
        }
    }

    public void enqueue(Callback callback) {
        enqueue(callback, false);
    }

    public void enqueue(Callback callback, boolean z11) {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        this.client.getDispatcher().enqueue(new AsyncCall(callback, z11));
    }

    public Response execute() throws IOException {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        try {
            this.client.getDispatcher().executed(this);
            Response responseWithInterceptorChain = getResponseWithInterceptorChain(false);
            if (responseWithInterceptorChain == null) {
                throw new IOException("Canceled");
            }
            this.client.getDispatcher().finished(this);
            return responseWithInterceptorChain;
        } catch (Throwable th2) {
            this.client.getDispatcher().finished(this);
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:55:0x00ee  */
    public Response getResponse(Request request, boolean z11) throws Throwable {
        Throwable th2;
        n nVar;
        RequestBody requestBodyBody = request.body();
        if (requestBodyBody != null) {
            Request.Builder builderNewBuilder = request.newBuilder();
            MediaType mediaTypeContentType = requestBodyBody.contentType();
            if (mediaTypeContentType != null) {
                builderNewBuilder.header(HttpHeaders.CONTENT_TYPE, mediaTypeContentType.toString());
            }
            long jContentLength = requestBodyBody.contentLength();
            if (jContentLength != -1) {
                builderNewBuilder.header(HttpHeaders.CONTENT_LENGTH, Long.toString(jContentLength));
                builderNewBuilder.removeHeader("Transfer-Encoding");
            } else {
                builderNewBuilder.header("Transfer-Encoding", "chunked");
                builderNewBuilder.removeHeader(HttpHeaders.CONTENT_LENGTH);
            }
            request = builderNewBuilder.build();
        }
        this.engine = new g(this.client, request, false, false, z11, null, null, null);
        int i11 = 0;
        while (!this.canceled) {
            boolean z12 = true;
            try {
                try {
                    try {
                        this.engine.y();
                        this.engine.s();
                        Response responseM = this.engine.m();
                        Request requestJ = this.engine.j();
                        if (requestJ == null) {
                            if (!z11) {
                                this.engine.w();
                            }
                            return responseM;
                        }
                        n nVarF = this.engine.f();
                        i11++;
                        if (i11 > 20) {
                            nVarF.o();
                            throw new ProtocolException("Too many follow-up requests: " + i11);
                        }
                        if (this.engine.x(requestJ.httpUrl())) {
                            nVar = nVarF;
                        } else {
                            nVarF.o();
                            nVar = null;
                        }
                        this.engine = new g(this.client, requestJ, false, false, z11, nVar, null, responseM);
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (z12) {
                            this.engine.f().o();
                        }
                        throw th2;
                    }
                } catch (RouteException e11) {
                    g gVarU = this.engine.u(e11);
                    if (gVarU == null) {
                        throw e11.getLastConnectException();
                    }
                    this.engine = gVarU;
                }
            } catch (RequestException e12) {
                throw e12.getCause();
            } catch (IOException e13) {
                g gVarV = this.engine.v(e13, null);
                if (gVarV == null) {
                    throw e13;
                }
                try {
                    this.engine = gVarV;
                } catch (Throwable th4) {
                    th2 = th4;
                    z12 = false;
                    if (z12) {
                        this.engine.f().o();
                    }
                    throw th2;
                }
            }
        }
        this.engine.w();
        throw new IOException("Canceled");
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public synchronized boolean isExecuted() {
        return this.executed;
    }

    public Object tag() {
        return this.originalRequest.tag();
    }
}
