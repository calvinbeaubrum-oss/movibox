package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.g;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;
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
public final class Response implements Closeable {
    private final ResponseBody body;
    private final Response cacheResponse;
    private final int code;
    private final Exchange exchange;
    private final Handshake handshake;
    private final Headers headers;
    private CacheControl lazyCacheControl;
    private final String message;
    private final Response networkResponse;
    private final Response priorResponse;
    private final Protocol protocol;
    private final long receivedResponseAtMillis;
    private final Request request;
    private final long sentRequestAtMillis;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static class Builder {
        private ResponseBody body;
        private Response cacheResponse;
        private int code;
        private Exchange exchange;
        private Handshake handshake;
        private Headers.Builder headers;
        private String message;
        private Response networkResponse;
        private Response priorResponse;
        private Protocol protocol;
        private long receivedResponseAtMillis;
        private Request request;
        private long sentRequestAtMillis;

        public Builder() {
            this.code = -1;
            this.headers = new Headers.Builder();
        }

        public Builder(Response response) {
            Intrinsics.g(response, "response");
            this.code = -1;
            this.request = response.request();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.handshake = response.handshake();
            this.headers = response.headers().newBuilder();
            this.body = response.body();
            this.networkResponse = response.networkResponse();
            this.cacheResponse = response.cacheResponse();
            this.priorResponse = response.priorResponse();
            this.sentRequestAtMillis = response.sentRequestAtMillis();
            this.receivedResponseAtMillis = response.receivedResponseAtMillis();
            this.exchange = response.exchange();
        }

        private final void checkPriorResponse(Response response) {
            if (response != null) {
                if (!(response.body() == null)) {
                    throw new IllegalArgumentException("priorResponse.body != null".toString());
                }
            }
        }

        private final void checkSupportResponse(String str, Response response) {
            if (response != null) {
                if (!(response.body() == null)) {
                    throw new IllegalArgumentException((str + ".body != null").toString());
                }
                if (!(response.networkResponse() == null)) {
                    throw new IllegalArgumentException((str + ".networkResponse != null").toString());
                }
                if (!(response.cacheResponse() == null)) {
                    throw new IllegalArgumentException((str + ".cacheResponse != null").toString());
                }
                if (response.priorResponse() == null) {
                    return;
                }
                throw new IllegalArgumentException((str + ".priorResponse != null").toString());
            }
        }

        public Builder addHeader(String name, String value) {
            Intrinsics.g(name, "name");
            Intrinsics.g(value, "value");
            this.headers.add(name, value);
            return this;
        }

        public Builder body(ResponseBody responseBody) {
            this.body = responseBody;
            return this;
        }

        public Response build() {
            int i11 = this.code;
            if (!(i11 >= 0)) {
                throw new IllegalStateException(("code < 0: " + this.code).toString());
            }
            Request request = this.request;
            if (request == null) {
                throw new IllegalStateException("request == null".toString());
            }
            Protocol protocol = this.protocol;
            if (protocol == null) {
                throw new IllegalStateException("protocol == null".toString());
            }
            String str = this.message;
            if (str != null) {
                return new Response(request, protocol, str, i11, this.handshake, this.headers.build(), this.body, this.networkResponse, this.cacheResponse, this.priorResponse, this.sentRequestAtMillis, this.receivedResponseAtMillis, this.exchange);
            }
            throw new IllegalStateException("message == null".toString());
        }

        public Builder cacheResponse(Response response) {
            checkSupportResponse("cacheResponse", response);
            this.cacheResponse = response;
            return this;
        }

        public Builder code(int i11) {
            this.code = i11;
            return this;
        }

        public final ResponseBody getBody$okhttp() {
            return this.body;
        }

        public final Response getCacheResponse$okhttp() {
            return this.cacheResponse;
        }

        public final int getCode$okhttp() {
            return this.code;
        }

        public final Exchange getExchange$okhttp() {
            return this.exchange;
        }

        public final Handshake getHandshake$okhttp() {
            return this.handshake;
        }

        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        public final String getMessage$okhttp() {
            return this.message;
        }

        public final Response getNetworkResponse$okhttp() {
            return this.networkResponse;
        }

        public final Response getPriorResponse$okhttp() {
            return this.priorResponse;
        }

        public final Protocol getProtocol$okhttp() {
            return this.protocol;
        }

        public final long getReceivedResponseAtMillis$okhttp() {
            return this.receivedResponseAtMillis;
        }

        public final Request getRequest$okhttp() {
            return this.request;
        }

        public final long getSentRequestAtMillis$okhttp() {
            return this.sentRequestAtMillis;
        }

        public Builder handshake(Handshake handshake) {
            this.handshake = handshake;
            return this;
        }

        public Builder header(String name, String value) {
            Intrinsics.g(name, "name");
            Intrinsics.g(value, "value");
            this.headers.set(name, value);
            return this;
        }

        public Builder headers(Headers headers) {
            Intrinsics.g(headers, "headers");
            this.headers = headers.newBuilder();
            return this;
        }

        public final void initExchange$okhttp(Exchange deferredTrailers) {
            Intrinsics.g(deferredTrailers, "deferredTrailers");
            this.exchange = deferredTrailers;
        }

        public Builder message(String message) {
            Intrinsics.g(message, "message");
            this.message = message;
            return this;
        }

        public Builder networkResponse(Response response) {
            checkSupportResponse("networkResponse", response);
            this.networkResponse = response;
            return this;
        }

        public Builder priorResponse(Response response) {
            checkPriorResponse(response);
            this.priorResponse = response;
            return this;
        }

        public Builder protocol(Protocol protocol) {
            Intrinsics.g(protocol, "protocol");
            this.protocol = protocol;
            return this;
        }

        public Builder receivedResponseAtMillis(long j11) {
            this.receivedResponseAtMillis = j11;
            return this;
        }

        public Builder removeHeader(String name) {
            Intrinsics.g(name, "name");
            this.headers.removeAll(name);
            return this;
        }

        public Builder request(Request request) {
            Intrinsics.g(request, "request");
            this.request = request;
            return this;
        }

        public Builder sentRequestAtMillis(long j11) {
            this.sentRequestAtMillis = j11;
            return this;
        }

        public final void setBody$okhttp(ResponseBody responseBody) {
            this.body = responseBody;
        }

        public final void setCacheResponse$okhttp(Response response) {
            this.cacheResponse = response;
        }

        public final void setCode$okhttp(int i11) {
            this.code = i11;
        }

        public final void setExchange$okhttp(Exchange exchange) {
            this.exchange = exchange;
        }

        public final void setHandshake$okhttp(Handshake handshake) {
            this.handshake = handshake;
        }

        public final void setHeaders$okhttp(Headers.Builder builder) {
            Intrinsics.g(builder, "<set-?>");
            this.headers = builder;
        }

        public final void setMessage$okhttp(String str) {
            this.message = str;
        }

        public final void setNetworkResponse$okhttp(Response response) {
            this.networkResponse = response;
        }

        public final void setPriorResponse$okhttp(Response response) {
            this.priorResponse = response;
        }

        public final void setProtocol$okhttp(Protocol protocol) {
            this.protocol = protocol;
        }

        public final void setReceivedResponseAtMillis$okhttp(long j11) {
            this.receivedResponseAtMillis = j11;
        }

        public final void setRequest$okhttp(Request request) {
            this.request = request;
        }

        public final void setSentRequestAtMillis$okhttp(long j11) {
            this.sentRequestAtMillis = j11;
        }
    }

    public Response(Request request, Protocol protocol, String message, int i11, Handshake handshake, Headers headers, ResponseBody responseBody, Response response, Response response2, Response response3, long j11, long j12, Exchange exchange) {
        Intrinsics.g(request, "request");
        Intrinsics.g(protocol, "protocol");
        Intrinsics.g(message, "message");
        Intrinsics.g(headers, "headers");
        this.request = request;
        this.protocol = protocol;
        this.message = message;
        this.code = i11;
        this.handshake = handshake;
        this.headers = headers;
        this.body = responseBody;
        this.networkResponse = response;
        this.cacheResponse = response2;
        this.priorResponse = response3;
        this.sentRequestAtMillis = j11;
        this.receivedResponseAtMillis = j12;
        this.exchange = exchange;
    }

    public static /* synthetic */ String header$default(Response response, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        return response.header(str, str2);
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_body, reason: not valid java name */
    public final ResponseBody m293deprecated_body() {
        return this.body;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_cacheControl, reason: not valid java name */
    public final CacheControl m294deprecated_cacheControl() {
        return cacheControl();
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_cacheResponse, reason: not valid java name */
    public final Response m295deprecated_cacheResponse() {
        return this.cacheResponse;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_code, reason: not valid java name */
    public final int m296deprecated_code() {
        return this.code;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_handshake, reason: not valid java name */
    public final Handshake m297deprecated_handshake() {
        return this.handshake;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_headers, reason: not valid java name */
    public final Headers m298deprecated_headers() {
        return this.headers;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_message, reason: not valid java name */
    public final String m299deprecated_message() {
        return this.message;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_networkResponse, reason: not valid java name */
    public final Response m300deprecated_networkResponse() {
        return this.networkResponse;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_priorResponse, reason: not valid java name */
    public final Response m301deprecated_priorResponse() {
        return this.priorResponse;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_protocol, reason: not valid java name */
    public final Protocol m302deprecated_protocol() {
        return this.protocol;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_receivedResponseAtMillis, reason: not valid java name */
    public final long m303deprecated_receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_request, reason: not valid java name */
    public final Request m304deprecated_request() {
        return this.request;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_sentRequestAtMillis, reason: not valid java name */
    public final long m305deprecated_sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    @JvmName
    public final ResponseBody body() {
        return this.body;
    }

    @JvmName
    public final CacheControl cacheControl() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl cacheControl2 = CacheControl.Companion.parse(this.headers);
        this.lazyCacheControl = cacheControl2;
        return cacheControl2;
    }

    @JvmName
    public final Response cacheResponse() {
        return this.cacheResponse;
    }

    public final List<Challenge> challenges() {
        String str;
        Headers headers = this.headers;
        int i11 = this.code;
        if (i11 == 401) {
            str = "WWW-Authenticate";
        } else {
            if (i11 != 407) {
                return g.l();
            }
            str = "Proxy-Authenticate";
        }
        return HttpHeaders.parseChallenges(headers, str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ResponseBody responseBody = this.body;
        if (responseBody == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
        }
        responseBody.close();
    }

    @JvmName
    public final int code() {
        return this.code;
    }

    @JvmName
    public final Exchange exchange() {
        return this.exchange;
    }

    @JvmName
    public final Handshake handshake() {
        return this.handshake;
    }

    @JvmOverloads
    public final String header(String str) {
        return header$default(this, str, null, 2, null);
    }

    @JvmOverloads
    public final String header(String name, String str) {
        Intrinsics.g(name, "name");
        String str2 = this.headers.get(name);
        return str2 != null ? str2 : str;
    }

    public final List<String> headers(String name) {
        Intrinsics.g(name, "name");
        return this.headers.values(name);
    }

    @JvmName
    public final Headers headers() {
        return this.headers;
    }

    public final boolean isRedirect() {
        int i11 = this.code;
        if (i11 != 307 && i11 != 308) {
            switch (i11) {
                case NOTICE_VALUE:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public final boolean isSuccessful() {
        int i11 = this.code;
        return 200 <= i11 && 299 >= i11;
    }

    @JvmName
    public final String message() {
        return this.message;
    }

    @JvmName
    public final Response networkResponse() {
        return this.networkResponse;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final ResponseBody peekBody(long j11) throws IOException {
        ResponseBody responseBody = this.body;
        Intrinsics.d(responseBody);
        BufferedSource bufferedSourcePeek = responseBody.source().peek();
        Buffer buffer = new Buffer();
        bufferedSourcePeek.request(j11);
        buffer.write((Source) bufferedSourcePeek, Math.min(j11, bufferedSourcePeek.getBuffer().size()));
        return ResponseBody.Companion.create(buffer, this.body.contentType(), buffer.size());
    }

    @JvmName
    public final Response priorResponse() {
        return this.priorResponse;
    }

    @JvmName
    public final Protocol protocol() {
        return this.protocol;
    }

    @JvmName
    public final long receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    @JvmName
    public final Request request() {
        return this.request;
    }

    @JvmName
    public final long sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url() + '}';
    }

    public final Headers trailers() throws IOException {
        Exchange exchange = this.exchange;
        if (exchange != null) {
            return exchange.trailers();
        }
        throw new IllegalStateException("trailers not available".toString());
    }
}
