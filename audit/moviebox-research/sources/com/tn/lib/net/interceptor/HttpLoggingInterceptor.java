package com.tn.lib.net.interceptor;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.tn.lib.util.networkinfo.f;
import ep.b;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.w;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class HttpLoggingInterceptor implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f49395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Set<String> f49396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Level f49397c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public interface a {
        void log(String str);
    }

    @JvmOverloads
    public HttpLoggingInterceptor(a logger) {
        Intrinsics.g(logger, "logger");
        this.f49395a = logger;
        this.f49396b = w.f();
        this.f49397c = Level.NONE;
    }

    private final boolean a(Headers headers) {
        String str = headers.get(HttpHeaders.CONTENT_ENCODING);
        return (str == null || l.v(str, "identity", true) || l.v(str, "gzip", true)) ? false : true;
    }

    private final void c(Headers headers, int i11) {
        String strValue = this.f49396b.contains(headers.name(i11)) ? "██" : headers.value(i11);
        this.f49395a.log(headers.name(i11) + ": " + strValue);
    }

    @JvmName
    public final void b(Level level) {
        Intrinsics.g(level, "<set-?>");
        this.f49397c = level;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Exception {
        Charset UTF_8;
        Charset UTF_9;
        Intrinsics.g(chain, "chain");
        Level level = this.f49397c;
        Request request = chain.request();
        if (level == Level.NONE) {
            return chain.proceed(request);
        }
        boolean z11 = level == Level.BODY;
        boolean z12 = z11 || level == Level.HEADERS;
        RequestBody requestBodyBody = request.body();
        Connection connection = chain.connection();
        String str = " ";
        String str2 = "--> " + request.method() + " " + request.url() + (connection != null ? " " + connection.protocol() : "");
        if (!z12 && requestBodyBody != null) {
            str2 = str2 + " (" + requestBodyBody.contentLength() + "-byte body)";
        }
        this.f49395a.log(str2);
        if (z12) {
            Headers headers = request.headers();
            if (requestBodyBody != null) {
                MediaType mediaTypeContentType = requestBodyBody.contentType();
                if (mediaTypeContentType != null && headers.get(HttpHeaders.CONTENT_TYPE) == null) {
                    this.f49395a.log("Content-Type: " + mediaTypeContentType);
                }
                if (requestBodyBody.contentLength() != -1 && headers.get(HttpHeaders.CONTENT_LENGTH) == null) {
                    this.f49395a.log("Content-Length: " + requestBodyBody.contentLength());
                }
            } else {
                str = " ";
            }
            int size = headers.size();
            for (int i11 = 0; i11 < size; i11++) {
                c(headers, i11);
            }
            if (!z11 || requestBodyBody == null) {
                this.f49395a.log("--> END " + request.method());
            } else if (a(request.headers())) {
                this.f49395a.log("--> END " + request.method() + " (encoded body omitted)");
            } else if (requestBodyBody.isDuplex()) {
                this.f49395a.log("--> END " + request.method() + " (duplex request body omitted)");
            } else if (requestBodyBody.isOneShot()) {
                this.f49395a.log("--> END " + request.method() + " (one-shot body omitted)");
            } else {
                Buffer buffer = new Buffer();
                requestBodyBody.writeTo(buffer);
                MediaType mediaTypeContentType2 = requestBodyBody.contentType();
                if (mediaTypeContentType2 == null || (UTF_9 = mediaTypeContentType2.charset(StandardCharsets.UTF_8)) == null) {
                    UTF_9 = StandardCharsets.UTF_8;
                    Intrinsics.f(UTF_9, "UTF_8");
                }
                this.f49395a.log("");
                if (b.b(buffer)) {
                    this.f49395a.log(buffer.readString(UTF_9));
                    this.f49395a.log("--> END " + request.method() + " (" + requestBodyBody.contentLength() + "-byte body)");
                } else {
                    this.f49395a.log("--> END " + request.method() + " (binary " + requestBodyBody.contentLength() + "-byte body omitted)");
                }
            }
        } else {
            z12 = z12;
            str = " ";
        }
        long jNanoTime = System.nanoTime();
        try {
            Response responseProceed = chain.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
            ResponseBody responseBodyBody = responseProceed.body();
            Intrinsics.d(responseBodyBody);
            long jContentLength = responseBodyBody.contentLength();
            String str3 = jContentLength != -1 ? jContentLength + "-byte" : "unknown-length";
            this.f49395a.log("<-- " + responseProceed.code() + (responseProceed.message().length() == 0 ? "" : ' ' + responseProceed.message()) + str + responseProceed.request().url() + " (" + millis + "ms" + (z12 ? "" : ", " + str3 + " body") + ")");
            if (z12) {
                Headers headers2 = responseProceed.headers();
                int size2 = headers2.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    c(headers2, i12);
                }
                if (!z11 || !okhttp3.internal.http.HttpHeaders.promisesBody(responseProceed)) {
                    this.f49395a.log("<-- END HTTP");
                } else if (a(responseProceed.headers())) {
                    this.f49395a.log("<-- END HTTP (encoded body omitted)");
                } else {
                    BufferedSource bufferedSourceSource = responseBodyBody.source();
                    bufferedSourceSource.request(Long.MAX_VALUE);
                    Buffer buffer2 = bufferedSourceSource.getBuffer();
                    Long l11 = null;
                    if (l.v("gzip", headers2.get(HttpHeaders.CONTENT_ENCODING), true)) {
                        Long lValueOf = Long.valueOf(buffer2.size());
                        GzipSource gzipSource = new GzipSource(buffer2.clone());
                        try {
                            buffer2 = new Buffer();
                            buffer2.writeAll(gzipSource);
                            CloseableKt.a(gzipSource, null);
                            l11 = lValueOf;
                        } catch (Throwable th2) {
                            try {
                                throw th2;
                            } catch (Throwable th3) {
                                CloseableKt.a(gzipSource, th2);
                                throw th3;
                            }
                        }
                    }
                    MediaType mediaTypeContentType3 = responseBodyBody.contentType();
                    if (mediaTypeContentType3 == null || (UTF_8 = mediaTypeContentType3.charset(StandardCharsets.UTF_8)) == null) {
                        UTF_8 = StandardCharsets.UTF_8;
                        Intrinsics.f(UTF_8, "UTF_8");
                    }
                    if (!b.b(buffer2)) {
                        this.f49395a.log("");
                        this.f49395a.log("<-- END HTTP (binary " + buffer2.size() + "-byte body omitted)");
                        return responseProceed;
                    }
                    if (jContentLength != 0) {
                        this.f49395a.log("");
                        this.f49395a.log(buffer2.clone().readString(UTF_8));
                    }
                    if (l11 != null) {
                        this.f49395a.log("<-- END HTTP (" + buffer2.size() + "-byte, " + l11 + "-gzipped-byte body)");
                    } else {
                        this.f49395a.log("<-- END HTTP (" + buffer2.size() + "-byte body)");
                    }
                }
            }
            return responseProceed;
        } catch (Exception e11) {
            uo.b.f78622a.h("HttpTag", "net_state:" + f.f49475a.b() + " url:" + request.url() + "<-- HTTP FAILED: " + e11, true);
            throw e11;
        }
    }
}
