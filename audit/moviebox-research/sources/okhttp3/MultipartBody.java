package okhttp3;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

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
public final class MultipartBody extends RequestBody {

    @JvmField
    public static final MediaType ALTERNATIVE;
    private static final byte[] COLONSPACE;
    private static final byte[] CRLF;
    public static final Companion Companion = new Companion(null);
    private static final byte[] DASHDASH;

    @JvmField
    public static final MediaType DIGEST;

    @JvmField
    public static final MediaType FORM;

    @JvmField
    public static final MediaType MIXED;

    @JvmField
    public static final MediaType PARALLEL;
    private final ByteString boundaryByteString;
    private long contentLength;
    private final MediaType contentType;
    private final List<Part> parts;
    private final MediaType type;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Builder {
        private final ByteString boundary;
        private final List<Part> parts;
        private MediaType type;

        /* JADX WARN: Multi-variable type inference failed */
        @JvmOverloads
        public Builder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @JvmOverloads
        public Builder(String boundary) {
            Intrinsics.g(boundary, "boundary");
            this.boundary = ByteString.Companion.encodeUtf8(boundary);
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Builder(String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i11 & 1) != 0) {
                str = UUID.randomUUID().toString();
                Intrinsics.f(str, "UUID.randomUUID().toString()");
            }
            this(str);
        }

        public final Builder addFormDataPart(String name, String value) {
            Intrinsics.g(name, "name");
            Intrinsics.g(value, "value");
            addPart(Part.Companion.createFormData(name, value));
            return this;
        }

        public final Builder addFormDataPart(String name, String str, RequestBody body) {
            Intrinsics.g(name, "name");
            Intrinsics.g(body, "body");
            addPart(Part.Companion.createFormData(name, str, body));
            return this;
        }

        public final Builder addPart(Headers headers, RequestBody body) {
            Intrinsics.g(body, "body");
            addPart(Part.Companion.create(headers, body));
            return this;
        }

        public final Builder addPart(Part part) {
            Intrinsics.g(part, "part");
            this.parts.add(part);
            return this;
        }

        public final Builder addPart(RequestBody body) {
            Intrinsics.g(body, "body");
            addPart(Part.Companion.create(body));
            return this;
        }

        public final MultipartBody build() {
            if (!this.parts.isEmpty()) {
                return new MultipartBody(this.boundary, this.type, Util.toImmutableList(this.parts));
            }
            throw new IllegalStateException("Multipart body must have at least one part.".toString());
        }

        public final Builder setType(MediaType type) {
            Intrinsics.g(type, "type");
            if (Intrinsics.b(type.type(), "multipart")) {
                this.type = type;
                return this;
            }
            throw new IllegalArgumentException(("multipart != " + type).toString());
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void appendQuotedString$okhttp(StringBuilder appendQuotedString, String key) {
            Intrinsics.g(appendQuotedString, "$this$appendQuotedString");
            Intrinsics.g(key, "key");
            appendQuotedString.append('\"');
            int length = key.length();
            for (int i11 = 0; i11 < length; i11++) {
                char cCharAt = key.charAt(i11);
                if (cCharAt == '\n') {
                    appendQuotedString.append("%0A");
                } else if (cCharAt == '\r') {
                    appendQuotedString.append("%0D");
                } else if (cCharAt != '\"') {
                    appendQuotedString.append(cCharAt);
                } else {
                    appendQuotedString.append("%22");
                }
            }
            appendQuotedString.append('\"');
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Part {
        public static final Companion Companion = new Companion(null);
        private final RequestBody body;
        private final Headers headers;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final Part create(Headers headers, RequestBody body) {
                Intrinsics.g(body, "body");
                DefaultConstructorMarker defaultConstructorMarker = null;
                if (!((headers != null ? headers.get(HttpHeaders.CONTENT_TYPE) : null) == null)) {
                    throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
                }
                if ((headers != null ? headers.get(HttpHeaders.CONTENT_LENGTH) : null) == null) {
                    return new Part(headers, body, defaultConstructorMarker);
                }
                throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
            }

            @JvmStatic
            public final Part create(RequestBody body) {
                Intrinsics.g(body, "body");
                return create(null, body);
            }

            @JvmStatic
            public final Part createFormData(String name, String value) {
                Intrinsics.g(name, "name");
                Intrinsics.g(value, "value");
                return createFormData(name, null, RequestBody.Companion.create$default(RequestBody.Companion, value, (MediaType) null, 1, (Object) null));
            }

            @JvmStatic
            public final Part createFormData(String name, String str, RequestBody body) {
                Intrinsics.g(name, "name");
                Intrinsics.g(body, "body");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("form-data; name=");
                Companion companion = MultipartBody.Companion;
                companion.appendQuotedString$okhttp(sb2, name);
                if (str != null) {
                    sb2.append("; filename=");
                    companion.appendQuotedString$okhttp(sb2, str);
                }
                String string = sb2.toString();
                Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
                return create(new Headers.Builder().addUnsafeNonAscii(HttpHeaders.CONTENT_DISPOSITION, string).build(), body);
            }
        }

        private Part(Headers headers, RequestBody requestBody) {
            this.headers = headers;
            this.body = requestBody;
        }

        public /* synthetic */ Part(Headers headers, RequestBody requestBody, DefaultConstructorMarker defaultConstructorMarker) {
            this(headers, requestBody);
        }

        @JvmStatic
        public static final Part create(Headers headers, RequestBody requestBody) {
            return Companion.create(headers, requestBody);
        }

        @JvmStatic
        public static final Part create(RequestBody requestBody) {
            return Companion.create(requestBody);
        }

        @JvmStatic
        public static final Part createFormData(String str, String str2) {
            return Companion.createFormData(str, str2);
        }

        @JvmStatic
        public static final Part createFormData(String str, String str2, RequestBody requestBody) {
            return Companion.createFormData(str, str2, requestBody);
        }

        @Deprecated
        @JvmName
        /* JADX INFO: renamed from: -deprecated_body, reason: not valid java name */
        public final RequestBody m258deprecated_body() {
            return this.body;
        }

        @Deprecated
        @JvmName
        /* JADX INFO: renamed from: -deprecated_headers, reason: not valid java name */
        public final Headers m259deprecated_headers() {
            return this.headers;
        }

        @JvmName
        public final RequestBody body() {
            return this.body;
        }

        @JvmName
        public final Headers headers() {
            return this.headers;
        }
    }

    static {
        MediaType.Companion companion = MediaType.Companion;
        MIXED = companion.get("multipart/mixed");
        ALTERNATIVE = companion.get("multipart/alternative");
        DIGEST = companion.get("multipart/digest");
        PARALLEL = companion.get("multipart/parallel");
        FORM = companion.get("multipart/form-data");
        COLONSPACE = new byte[]{(byte) 58, (byte) 32};
        CRLF = new byte[]{(byte) 13, (byte) 10};
        byte b11 = (byte) 45;
        DASHDASH = new byte[]{b11, b11};
    }

    public MultipartBody(ByteString boundaryByteString, MediaType type, List<Part> parts) {
        Intrinsics.g(boundaryByteString, "boundaryByteString");
        Intrinsics.g(type, "type");
        Intrinsics.g(parts, "parts");
        this.boundaryByteString = boundaryByteString;
        this.type = type;
        this.parts = parts;
        this.contentType = MediaType.Companion.get(type + "; boundary=" + boundary());
        this.contentLength = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long writeOrCountBytes(BufferedSink bufferedSink, boolean z11) throws IOException {
        Buffer buffer;
        if (z11) {
            bufferedSink = new Buffer();
            buffer = bufferedSink;
        } else {
            buffer = 0;
        }
        int size = this.parts.size();
        long j11 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            Part part = this.parts.get(i11);
            Headers headers = part.headers();
            RequestBody requestBodyBody = part.body();
            Intrinsics.d(bufferedSink);
            bufferedSink.write(DASHDASH);
            bufferedSink.write(this.boundaryByteString);
            bufferedSink.write(CRLF);
            if (headers != null) {
                int size2 = headers.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    bufferedSink.writeUtf8(headers.name(i12)).write(COLONSPACE).writeUtf8(headers.value(i12)).write(CRLF);
                }
            }
            MediaType mediaTypeContentType = requestBodyBody.contentType();
            if (mediaTypeContentType != null) {
                bufferedSink.writeUtf8("Content-Type: ").writeUtf8(mediaTypeContentType.toString()).write(CRLF);
            }
            long jContentLength = requestBodyBody.contentLength();
            if (jContentLength != -1) {
                bufferedSink.writeUtf8("Content-Length: ").writeDecimalLong(jContentLength).write(CRLF);
            } else if (z11) {
                Intrinsics.d(buffer);
                buffer.clear();
                return -1L;
            }
            byte[] bArr = CRLF;
            bufferedSink.write(bArr);
            if (z11) {
                j11 += jContentLength;
            } else {
                requestBodyBody.writeTo(bufferedSink);
            }
            bufferedSink.write(bArr);
        }
        Intrinsics.d(bufferedSink);
        byte[] bArr2 = DASHDASH;
        bufferedSink.write(bArr2);
        bufferedSink.write(this.boundaryByteString);
        bufferedSink.write(bArr2);
        bufferedSink.write(CRLF);
        if (!z11) {
            return j11;
        }
        Intrinsics.d(buffer);
        long size3 = j11 + buffer.size();
        buffer.clear();
        return size3;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_boundary, reason: not valid java name */
    public final String m254deprecated_boundary() {
        return boundary();
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_parts, reason: not valid java name */
    public final List<Part> m255deprecated_parts() {
        return this.parts;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m256deprecated_size() {
        return size();
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_type, reason: not valid java name */
    public final MediaType m257deprecated_type() {
        return this.type;
    }

    @JvmName
    public final String boundary() {
        return this.boundaryByteString.utf8();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        long j11 = this.contentLength;
        if (j11 != -1) {
            return j11;
        }
        long jWriteOrCountBytes = writeOrCountBytes(null, true);
        this.contentLength = jWriteOrCountBytes;
        return jWriteOrCountBytes;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.contentType;
    }

    public final Part part(int i11) {
        return this.parts.get(i11);
    }

    @JvmName
    public final List<Part> parts() {
        return this.parts;
    }

    @JvmName
    public final int size() {
        return this.parts.size();
    }

    @JvmName
    public final MediaType type() {
        return this.type;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink sink) throws IOException {
        Intrinsics.g(sink, "sink");
        writeOrCountBytes(sink, false);
    }
}
