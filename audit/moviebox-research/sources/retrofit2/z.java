package retrofit2;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.applovin.exoplayer2.common.base.Ascii;
import java.io.EOFException;
import java.io.IOException;
import java.util.regex.Pattern;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class z {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final char[] f75366l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Pattern f75367m = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f75368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HttpUrl f75369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f75370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HttpUrl.Builder f75371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Request.Builder f75372e = new Request.Builder();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Headers.Builder f75373f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MediaType f75374g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f75375h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MultipartBody.Builder f75376i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FormBody.Builder f75377j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RequestBody f75378k;

    /* JADX INFO: compiled from: source.java */
    public static class a extends RequestBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RequestBody f75379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaType f75380b;

        public a(RequestBody requestBody, MediaType mediaType) {
            this.f75379a = requestBody;
            this.f75380b = mediaType;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() throws IOException {
            return this.f75379a.contentLength();
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return this.f75380b;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            this.f75379a.writeTo(bufferedSink);
        }
    }

    public z(String str, HttpUrl httpUrl, String str2, Headers headers, MediaType mediaType, boolean z11, boolean z12, boolean z13) {
        this.f75368a = str;
        this.f75369b = httpUrl;
        this.f75370c = str2;
        this.f75374g = mediaType;
        this.f75375h = z11;
        if (headers != null) {
            this.f75373f = headers.newBuilder();
        } else {
            this.f75373f = new Headers.Builder();
        }
        if (z12) {
            this.f75377j = new FormBody.Builder();
        } else if (z13) {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            this.f75376i = builder;
            builder.setType(MultipartBody.FORM);
        }
    }

    public static String i(String str, boolean z11) throws EOFException {
        int length = str.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt) != -1 || (!z11 && (iCodePointAt == 47 || iCodePointAt == 37))) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, 0, iCharCount);
                j(buffer, str, iCharCount, length, z11);
                return buffer.readUtf8();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str;
    }

    public static void j(Buffer buffer, String str, int i11, int i12, boolean z11) throws EOFException {
        Buffer buffer2 = null;
        while (i11 < i12) {
            int iCodePointAt = str.codePointAt(i11);
            if (!z11 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt < 32 || iCodePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt) != -1 || (!z11 && (iCodePointAt == 47 || iCodePointAt == 37))) {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.writeUtf8CodePoint(iCodePointAt);
                    while (!buffer2.exhausted()) {
                        byte b11 = buffer2.readByte();
                        buffer.writeByte(37);
                        char[] cArr = f75366l;
                        buffer.writeByte((int) cArr[((b11 & 255) >> 4) & 15]);
                        buffer.writeByte((int) cArr[b11 & Ascii.SI]);
                    }
                } else {
                    buffer.writeUtf8CodePoint(iCodePointAt);
                }
            }
            i11 += Character.charCount(iCodePointAt);
        }
    }

    public void a(String str, String str2, boolean z11) {
        if (z11) {
            this.f75377j.addEncoded(str, str2);
        } else {
            this.f75377j.add(str, str2);
        }
    }

    public void b(String str, String str2) {
        if (!HttpHeaders.CONTENT_TYPE.equalsIgnoreCase(str)) {
            this.f75373f.add(str, str2);
            return;
        }
        try {
            this.f75374g = MediaType.get(str2);
        } catch (IllegalArgumentException e11) {
            throw new IllegalArgumentException("Malformed content type: " + str2, e11);
        }
    }

    public void c(Headers headers) {
        this.f75373f.addAll(headers);
    }

    public void d(Headers headers, RequestBody requestBody) {
        this.f75376i.addPart(headers, requestBody);
    }

    public void e(MultipartBody.Part part) {
        this.f75376i.addPart(part);
    }

    public void f(String str, String str2, boolean z11) {
        if (this.f75370c == null) {
            throw new AssertionError();
        }
        String strI = i(str2, z11);
        String strReplace = this.f75370c.replace("{" + str + "}", strI);
        if (!f75367m.matcher(strReplace).matches()) {
            this.f75370c = strReplace;
            return;
        }
        throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + str2);
    }

    public void g(String str, String str2, boolean z11) {
        String str3 = this.f75370c;
        if (str3 != null) {
            HttpUrl.Builder builderNewBuilder = this.f75369b.newBuilder(str3);
            this.f75371d = builderNewBuilder;
            if (builderNewBuilder == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f75369b + ", Relative: " + this.f75370c);
            }
            this.f75370c = null;
        }
        if (z11) {
            this.f75371d.addEncodedQueryParameter(str, str2);
        } else {
            this.f75371d.addQueryParameter(str, str2);
        }
    }

    public <T> void h(Class<T> cls, T t11) {
        this.f75372e.tag(cls, t11);
    }

    public Request.Builder k() {
        HttpUrl httpUrlResolve;
        HttpUrl.Builder builder = this.f75371d;
        if (builder != null) {
            httpUrlResolve = builder.build();
        } else {
            httpUrlResolve = this.f75369b.resolve(this.f75370c);
            if (httpUrlResolve == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f75369b + ", Relative: " + this.f75370c);
            }
        }
        RequestBody aVar = this.f75378k;
        if (aVar == null) {
            FormBody.Builder builder2 = this.f75377j;
            if (builder2 != null) {
                aVar = builder2.build();
            } else {
                MultipartBody.Builder builder3 = this.f75376i;
                if (builder3 != null) {
                    aVar = builder3.build();
                } else if (this.f75375h) {
                    aVar = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = this.f75374g;
        if (mediaType != null) {
            if (aVar != null) {
                aVar = new a(aVar, mediaType);
            } else {
                this.f75373f.add(HttpHeaders.CONTENT_TYPE, mediaType.toString());
            }
        }
        return this.f75372e.url(httpUrlResolve).headers(this.f75373f.build()).method(this.f75368a, aVar);
    }

    public void l(RequestBody requestBody) {
        this.f75378k = requestBody;
    }

    public void m(Object obj) {
        this.f75370c = obj.toString();
    }
}
