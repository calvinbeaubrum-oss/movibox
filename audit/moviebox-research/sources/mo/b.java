package mo;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.tmc.network.log.LogLevel;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.w;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class b implements Interceptor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f71150f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0762b f71151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Set<String> f71152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile LogLevel f71153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile LogLevel f71154d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(Buffer buffer) {
            Intrinsics.g(buffer, "<this>");
            try {
                Buffer buffer2 = new Buffer();
                buffer.copyTo(buffer2, 0L, kotlin.ranges.a.h(buffer.size(), 64L));
                int i11 = 0;
                do {
                    i11++;
                    if (buffer2.exhausted()) {
                        break;
                    }
                    int utf8CodePoint = buffer2.readUtf8CodePoint();
                    if (Character.isISOControl(utf8CodePoint) && !Character.isWhitespace(utf8CodePoint)) {
                        return false;
                    }
                } while (i11 < 16);
                return true;
            } catch (EOFException unused) {
                return false;
            }
        }

        public final boolean b(MediaType mediaType) {
            if (!Intrinsics.b(mediaType == null ? null : mediaType.type(), MimeTypes.BASE_TYPE_TEXT)) {
                if (!Intrinsics.b(mediaType == null ? null : mediaType.subtype(), "json")) {
                    if (!Intrinsics.b(mediaType != null ? mediaType.subtype() : null, "x-www-form-urlencoded")) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: mo.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface InterfaceC0762b {
        void log(String str);
    }

    @JvmOverloads
    public b(InterfaceC0762b logger) {
        Intrinsics.g(logger, "logger");
        this.f71151a = logger;
        this.f71152b = w.f();
        LogLevel logLevel = LogLevel.NONE;
        this.f71153c = logLevel;
        this.f71154d = logLevel;
    }

    public final boolean a(Headers headers) {
        String str = headers.get(HttpHeaders.CONTENT_ENCODING);
        return (str == null || l.v(str, "identity", true) || l.v(str, "gzip", true)) ? false : true;
    }

    public final void b(Headers headers, int i11) {
        String strValue = this.f71152b.contains(headers.name(i11)) ? "██" : headers.value(i11);
        this.f71151a.log(headers.name(i11) + ": " + strValue);
    }

    @JvmName
    public final void c(LogLevel logLevel) {
        Intrinsics.g(logLevel, "<set-?>");
        this.f71153c = logLevel;
    }

    @JvmName
    public final void d(LogLevel logLevel) {
        Intrinsics.g(logLevel, "<set-?>");
        this.f71154d = logLevel;
    }

    public final b e(LogLevel level) {
        Intrinsics.g(level, "level");
        c(level);
        return this;
    }

    public final b f(LogLevel level) {
        Intrinsics.g(level, "level");
        d(level);
        return this;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Exception {
        String str;
        String str2;
        String str3;
        Charset charset;
        Long lValueOf;
        Intrinsics.g(chain, "chain");
        LogLevel logLevel = this.f71153c;
        LogLevel logLevel2 = this.f71154d;
        Request request = chain.request();
        LogLevel logLevel3 = LogLevel.NONE;
        if (logLevel == logLevel3 && logLevel2 == logLevel3) {
            return chain.proceed(request);
        }
        boolean z11 = logLevel == LogLevel.BODY;
        boolean z12 = z11 || logLevel == LogLevel.HEADERS;
        RequestBody requestBodyBody = request.body();
        boolean zB = f71150f.b(requestBodyBody == null ? null : requestBodyBody.contentType());
        Connection connection = chain.connection();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("--> ");
        sb2.append(request.method());
        sb2.append(' ');
        sb2.append(request.url());
        sb2.append(connection != null ? Intrinsics.p(" ", connection.protocol()) : "");
        String string = sb2.toString();
        if (!z12 && requestBodyBody != null) {
            string = string + " (" + requestBodyBody.contentLength() + "-byte body)";
        }
        this.f71151a.log(string);
        if (z12) {
            Headers headers = request.headers();
            if (requestBodyBody != null) {
                MediaType mediaTypeContentType = requestBodyBody.contentType();
                if (mediaTypeContentType != null && headers.get(HttpHeaders.CONTENT_TYPE) == null) {
                    this.f71151a.log(Intrinsics.p("Content-Type: ", mediaTypeContentType));
                }
                if (requestBodyBody.contentLength() != -1 && headers.get(HttpHeaders.CONTENT_LENGTH) == null) {
                    this.f71151a.log(Intrinsics.p("Content-Length: ", Long.valueOf(requestBodyBody.contentLength())));
                }
            } else {
                z12 = z12;
            }
            int size = headers.size();
            if (size > 0) {
                int i11 = 0;
                while (true) {
                    int i12 = i11 + 1;
                    b(headers, i11);
                    if (i12 >= size) {
                        break;
                    }
                    i11 = i12;
                }
            }
            if (!z11 || requestBodyBody == null) {
                this.f71151a.log(Intrinsics.p("--> END ", request.method()));
            } else if (a(request.headers())) {
                this.f71151a.log("--> END " + request.method() + " (encoded body omitted)");
            } else if (requestBodyBody.isDuplex()) {
                this.f71151a.log("--> END " + request.method() + " (duplex request body omitted)");
            } else if (zB) {
                Buffer buffer = new Buffer();
                requestBodyBody.writeTo(buffer);
                MediaType mediaTypeContentType2 = requestBodyBody.contentType();
                Charset UTF_8 = mediaTypeContentType2 == null ? null : mediaTypeContentType2.charset(StandardCharsets.UTF_8);
                if (UTF_8 == null) {
                    UTF_8 = StandardCharsets.UTF_8;
                    Intrinsics.f(UTF_8, "UTF_8");
                }
                this.f71151a.log("");
                if (f71150f.a(buffer)) {
                    this.f71151a.log(buffer.readString(UTF_8));
                    this.f71151a.log("--> END " + request.method() + " (" + requestBodyBody.contentLength() + "-byte body)");
                } else {
                    this.f71151a.log("--> END " + request.method() + " (binary " + requestBodyBody.contentLength() + "-byte body omitted)");
                }
            } else {
                this.f71151a.log("--> END " + request.method() + " (non text request body omitted.)");
            }
        } else {
            z12 = z12;
        }
        long jNanoTime = System.nanoTime();
        try {
            Response responseProceed = chain.proceed(request);
            boolean z13 = logLevel2 == LogLevel.BODY;
            boolean z14 = z13 || logLevel2 == LogLevel.HEADERS;
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
            ResponseBody responseBodyBody = responseProceed.body();
            Intrinsics.d(responseBodyBody);
            long jContentLength = responseBodyBody.contentLength();
            if (jContentLength != -1) {
                str = jContentLength + "-byte";
            } else {
                str = "unknown-length";
            }
            InterfaceC0762b interfaceC0762b = this.f71151a;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("<-- ");
            sb3.append(responseProceed.code());
            if (responseProceed.message().length() == 0) {
                str2 = "";
            } else {
                str2 = String.valueOf(' ') + responseProceed.message();
            }
            sb3.append(str2);
            sb3.append(' ');
            sb3.append(responseProceed.request().url());
            sb3.append(" (");
            sb3.append(millis);
            sb3.append("ms");
            if (z12) {
                str3 = "";
            } else {
                str3 = ", " + str + " body";
            }
            sb3.append(str3);
            sb3.append(')');
            interfaceC0762b.log(sb3.toString());
            boolean zB2 = f71150f.b(responseBodyBody.contentType());
            if (z14) {
                Headers headers2 = responseProceed.headers();
                int size2 = headers2.size();
                if (size2 > 0) {
                    int i13 = 0;
                    while (true) {
                        int i14 = i13 + 1;
                        b(headers2, i13);
                        if (i14 >= size2) {
                            break;
                        }
                        i13 = i14;
                    }
                }
                if (!z13 || !okhttp3.internal.http.HttpHeaders.promisesBody(responseProceed)) {
                    this.f71151a.log("<-- END HTTP");
                } else if (a(responseProceed.headers())) {
                    this.f71151a.log("<-- END HTTP (encoded body omitted)");
                } else if (zB2) {
                    BufferedSource bufferedSourceSource = responseBodyBody.source();
                    bufferedSourceSource.request(Long.MAX_VALUE);
                    Buffer buffer2 = bufferedSourceSource.getBuffer();
                    if (l.v("gzip", headers2.get(HttpHeaders.CONTENT_ENCODING), true)) {
                        lValueOf = Long.valueOf(buffer2.size());
                        GzipSource gzipSource = new GzipSource(buffer2.clone());
                        try {
                            buffer2 = new Buffer();
                            buffer2.writeAll(gzipSource);
                            charset = null;
                            CloseableKt.a(gzipSource, null);
                        } catch (Throwable th2) {
                            try {
                                throw th2;
                            } catch (Throwable th3) {
                                CloseableKt.a(gzipSource, th2);
                                throw th3;
                            }
                        }
                    } else {
                        charset = null;
                        lValueOf = null;
                    }
                    MediaType mediaTypeContentType3 = responseBodyBody.contentType();
                    Charset UTF_9 = mediaTypeContentType3 == null ? charset : mediaTypeContentType3.charset(StandardCharsets.UTF_8);
                    if (UTF_9 == null) {
                        UTF_9 = StandardCharsets.UTF_8;
                        Intrinsics.f(UTF_9, "UTF_8");
                    }
                    if (!f71150f.a(buffer2)) {
                        this.f71151a.log("");
                        this.f71151a.log("<-- END HTTP (binary " + buffer2.size() + "-byte body omitted)");
                        return responseProceed;
                    }
                    if (jContentLength != 0) {
                        this.f71151a.log("");
                        this.f71151a.log(buffer2.clone().readString(UTF_9));
                    }
                    if (lValueOf != null) {
                        this.f71151a.log("<-- END HTTP (" + buffer2.size() + "-byte, " + lValueOf + "-gzipped-byte body)");
                    } else {
                        this.f71151a.log("<-- END HTTP (" + buffer2.size() + "-byte body)");
                    }
                } else {
                    this.f71151a.log("<-- END HTTP (non text response body omitted.)");
                }
            }
            return responseProceed;
        } catch (Exception e11) {
            this.f71151a.log(Intrinsics.p("<-- HTTP FAILED: ", e11));
            throw e11;
        }
    }
}
