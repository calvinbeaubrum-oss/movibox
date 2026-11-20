package okhttp3.internal.connection;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.ws.RealWebSocket;
import okio.Buffer;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class Exchange {
    private final RealCall call;
    private final ExchangeCodec codec;
    private final RealConnection connection;
    private final EventListener eventListener;
    private final ExchangeFinder finder;
    private boolean isDuplex;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class RequestBodySink extends ForwardingSink {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        final /* synthetic */ Exchange this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestBodySink(Exchange exchange, Sink delegate, long j11) {
            super(delegate);
            Intrinsics.g(delegate, "delegate");
            this.this$0 = exchange;
            this.contentLength = j11;
        }

        private final <E extends IOException> E complete(E e11) {
            if (this.completed) {
                return e11;
            }
            this.completed = true;
            return (E) this.this$0.bodyComplete(this.bytesReceived, false, true, e11);
        }

        @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            long j11 = this.contentLength;
            if (j11 != -1 && this.bytesReceived != j11) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                complete(null);
            } catch (IOException e11) {
                throw complete(e11);
            }
        }

        @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e11) {
                throw complete(e11);
            }
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer source, long j11) throws IOException {
            Intrinsics.g(source, "source");
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            long j12 = this.contentLength;
            if (j12 == -1 || this.bytesReceived + j11 <= j12) {
                try {
                    super.write(source, j11);
                    this.bytesReceived += j11;
                    return;
                } catch (IOException e11) {
                    throw complete(e11);
                }
            }
            throw new ProtocolException("expected " + this.contentLength + " bytes but received " + (this.bytesReceived + j11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class ResponseBodySource extends ForwardingSource {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        private boolean invokeStartEvent;
        final /* synthetic */ Exchange this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResponseBodySource(Exchange exchange, Source delegate, long j11) {
            super(delegate);
            Intrinsics.g(delegate, "delegate");
            this.this$0 = exchange;
            this.contentLength = j11;
            this.invokeStartEvent = true;
            if (j11 == 0) {
                complete(null);
            }
        }

        @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            try {
                super.close();
                complete(null);
            } catch (IOException e11) {
                throw complete(e11);
            }
        }

        public final <E extends IOException> E complete(E e11) {
            if (this.completed) {
                return e11;
            }
            this.completed = true;
            if (e11 == null && this.invokeStartEvent) {
                this.invokeStartEvent = false;
                this.this$0.getEventListener$okhttp().responseBodyStart(this.this$0.getCall$okhttp());
            }
            return (E) this.this$0.bodyComplete(this.bytesReceived, true, false, e11);
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer sink, long j11) throws IOException {
            Intrinsics.g(sink, "sink");
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            try {
                long j12 = delegate().read(sink, j11);
                if (this.invokeStartEvent) {
                    this.invokeStartEvent = false;
                    this.this$0.getEventListener$okhttp().responseBodyStart(this.this$0.getCall$okhttp());
                }
                if (j12 == -1) {
                    complete(null);
                    return -1L;
                }
                long j13 = this.bytesReceived + j12;
                long j14 = this.contentLength;
                if (j14 != -1 && j13 > j14) {
                    throw new ProtocolException("expected " + this.contentLength + " bytes but received " + j13);
                }
                this.bytesReceived = j13;
                if (j13 == j14) {
                    complete(null);
                }
                return j12;
            } catch (IOException e11) {
                throw complete(e11);
            }
        }
    }

    public Exchange(RealCall call, EventListener eventListener, ExchangeFinder finder, ExchangeCodec codec) {
        Intrinsics.g(call, "call");
        Intrinsics.g(eventListener, "eventListener");
        Intrinsics.g(finder, "finder");
        Intrinsics.g(codec, "codec");
        this.call = call;
        this.eventListener = eventListener;
        this.finder = finder;
        this.codec = codec;
        this.connection = codec.getConnection();
    }

    private final void trackFailure(IOException iOException) {
        this.finder.trackFailure(iOException);
        this.codec.getConnection().trackFailure$okhttp(this.call, iOException);
    }

    public final <E extends IOException> E bodyComplete(long j11, boolean z11, boolean z12, E e11) {
        if (e11 != null) {
            trackFailure(e11);
        }
        if (z12) {
            if (e11 != null) {
                this.eventListener.requestFailed(this.call, e11);
            } else {
                this.eventListener.requestBodyEnd(this.call, j11);
            }
        }
        if (z11) {
            if (e11 != null) {
                this.eventListener.responseFailed(this.call, e11);
            } else {
                this.eventListener.responseBodyEnd(this.call, j11);
            }
        }
        return (E) this.call.messageDone$okhttp(this, z12, z11, e11);
    }

    public final void cancel() {
        this.codec.cancel();
    }

    public final Sink createRequestBody(Request request, boolean z11) throws IOException {
        Intrinsics.g(request, "request");
        this.isDuplex = z11;
        RequestBody requestBodyBody = request.body();
        Intrinsics.d(requestBodyBody);
        long jContentLength = requestBodyBody.contentLength();
        this.eventListener.requestBodyStart(this.call);
        return new RequestBodySink(this, this.codec.createRequestBody(request, jContentLength), jContentLength);
    }

    public final void detachWithViolence() {
        this.codec.cancel();
        this.call.messageDone$okhttp(this, true, true, null);
    }

    public final void finishRequest() throws IOException {
        try {
            this.codec.finishRequest();
        } catch (IOException e11) {
            this.eventListener.requestFailed(this.call, e11);
            trackFailure(e11);
            throw e11;
        }
    }

    public final void flushRequest() throws IOException {
        try {
            this.codec.flushRequest();
        } catch (IOException e11) {
            this.eventListener.requestFailed(this.call, e11);
            trackFailure(e11);
            throw e11;
        }
    }

    public final RealCall getCall$okhttp() {
        return this.call;
    }

    public final RealConnection getConnection$okhttp() {
        return this.connection;
    }

    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    public final ExchangeFinder getFinder$okhttp() {
        return this.finder;
    }

    public final boolean isCoalescedConnection$okhttp() {
        return !Intrinsics.b(this.finder.getAddress$okhttp().url().host(), this.connection.route().address().url().host());
    }

    public final boolean isDuplex$okhttp() {
        return this.isDuplex;
    }

    public final RealWebSocket.Streams newWebSocketStreams() throws SocketException {
        this.call.timeoutEarlyExit();
        return this.codec.getConnection().newWebSocketStreams$okhttp(this);
    }

    public final void noNewExchangesOnConnection() {
        this.codec.getConnection().noNewExchanges$okhttp();
    }

    public final void noRequestBody() {
        this.call.messageDone$okhttp(this, true, false, null);
    }

    public final ResponseBody openResponseBody(Response response) throws IOException {
        Intrinsics.g(response, "response");
        try {
            String strHeader$default = Response.header$default(response, HttpHeaders.CONTENT_TYPE, null, 2, null);
            long jReportedContentLength = this.codec.reportedContentLength(response);
            return new RealResponseBody(strHeader$default, jReportedContentLength, Okio.buffer(new ResponseBodySource(this, this.codec.openResponseBodySource(response), jReportedContentLength)));
        } catch (IOException e11) {
            this.eventListener.responseFailed(this.call, e11);
            trackFailure(e11);
            throw e11;
        }
    }

    public final Response.Builder readResponseHeaders(boolean z11) throws IOException {
        try {
            Response.Builder responseHeaders = this.codec.readResponseHeaders(z11);
            if (responseHeaders != null) {
                responseHeaders.initExchange$okhttp(this);
            }
            return responseHeaders;
        } catch (IOException e11) {
            this.eventListener.responseFailed(this.call, e11);
            trackFailure(e11);
            throw e11;
        }
    }

    public final void responseHeadersEnd(Response response) {
        Intrinsics.g(response, "response");
        this.eventListener.responseHeadersEnd(this.call, response);
    }

    public final void responseHeadersStart() {
        this.eventListener.responseHeadersStart(this.call);
    }

    public final Headers trailers() throws IOException {
        return this.codec.trailers();
    }

    public final void webSocketUpgradeFailed() {
        bodyComplete(-1L, true, true, null);
    }

    public final void writeRequestHeaders(Request request) throws IOException {
        Intrinsics.g(request, "request");
        try {
            this.eventListener.requestHeadersStart(this.call);
            this.codec.writeRequestHeaders(request);
            this.eventListener.requestHeadersEnd(this.call, request);
        } catch (IOException e11) {
            this.eventListener.requestFailed(this.call, e11);
            trackFailure(e11);
            throw e11;
        }
    }
}
