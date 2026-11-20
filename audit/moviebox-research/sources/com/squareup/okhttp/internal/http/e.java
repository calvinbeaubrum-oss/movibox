package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.internal.framed.ErrorCode;
import com.squareup.okhttp.internal.framed.FramedConnection;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements HttpStream {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ByteString f49263e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ByteString f49264f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ByteString f49265g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ByteString f49266h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ByteString f49267i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ByteString f49268j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ByteString f49269k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ByteString f49270l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final List<ByteString> f49271m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final List<ByteString> f49272n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final List<ByteString> f49273o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final List<ByteString> f49274p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f49275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FramedConnection f49276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f49277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.squareup.okhttp.internal.framed.a f49278d;

    /* JADX INFO: compiled from: source.java */
    public class a extends ForwardingSource {
        public a(Source source) {
            super(source);
        }

        @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            e.this.f49275a.r(e.this);
            super.close();
        }
    }

    static {
        ByteString byteStringEncodeUtf8 = ByteString.encodeUtf8("connection");
        f49263e = byteStringEncodeUtf8;
        ByteString byteStringEncodeUtf9 = ByteString.encodeUtf8("host");
        f49264f = byteStringEncodeUtf9;
        ByteString byteStringEncodeUtf10 = ByteString.encodeUtf8("keep-alive");
        f49265g = byteStringEncodeUtf10;
        ByteString byteStringEncodeUtf11 = ByteString.encodeUtf8("proxy-connection");
        f49266h = byteStringEncodeUtf11;
        ByteString byteStringEncodeUtf12 = ByteString.encodeUtf8("transfer-encoding");
        f49267i = byteStringEncodeUtf12;
        ByteString byteStringEncodeUtf13 = ByteString.encodeUtf8("te");
        f49268j = byteStringEncodeUtf13;
        ByteString byteStringEncodeUtf14 = ByteString.encodeUtf8("encoding");
        f49269k = byteStringEncodeUtf14;
        ByteString byteStringEncodeUtf15 = ByteString.encodeUtf8("upgrade");
        f49270l = byteStringEncodeUtf15;
        ByteString byteString = com.squareup.okhttp.internal.framed.b.f49145e;
        ByteString byteString2 = com.squareup.okhttp.internal.framed.b.f49146f;
        ByteString byteString3 = com.squareup.okhttp.internal.framed.b.f49147g;
        ByteString byteString4 = com.squareup.okhttp.internal.framed.b.f49148h;
        ByteString byteString5 = com.squareup.okhttp.internal.framed.b.f49149i;
        ByteString byteString6 = com.squareup.okhttp.internal.framed.b.f49150j;
        f49271m = com.squareup.okhttp.internal.g.k(byteStringEncodeUtf8, byteStringEncodeUtf9, byteStringEncodeUtf10, byteStringEncodeUtf11, byteStringEncodeUtf12, byteString, byteString2, byteString3, byteString4, byteString5, byteString6);
        f49272n = com.squareup.okhttp.internal.g.k(byteStringEncodeUtf8, byteStringEncodeUtf9, byteStringEncodeUtf10, byteStringEncodeUtf11, byteStringEncodeUtf12);
        f49273o = com.squareup.okhttp.internal.g.k(byteStringEncodeUtf8, byteStringEncodeUtf9, byteStringEncodeUtf10, byteStringEncodeUtf11, byteStringEncodeUtf13, byteStringEncodeUtf12, byteStringEncodeUtf14, byteStringEncodeUtf15, byteString, byteString2, byteString3, byteString4, byteString5, byteString6);
        f49274p = com.squareup.okhttp.internal.g.k(byteStringEncodeUtf8, byteStringEncodeUtf9, byteStringEncodeUtf10, byteStringEncodeUtf11, byteStringEncodeUtf13, byteStringEncodeUtf12, byteStringEncodeUtf14, byteStringEncodeUtf15);
    }

    public e(n nVar, FramedConnection framedConnection) {
        this.f49275a = nVar;
        this.f49276b = framedConnection;
    }

    public static List<com.squareup.okhttp.internal.framed.b> b(Request request) {
        Headers headers = request.headers();
        ArrayList arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new com.squareup.okhttp.internal.framed.b(com.squareup.okhttp.internal.framed.b.f49145e, request.method()));
        arrayList.add(new com.squareup.okhttp.internal.framed.b(com.squareup.okhttp.internal.framed.b.f49146f, j.c(request.httpUrl())));
        arrayList.add(new com.squareup.okhttp.internal.framed.b(com.squareup.okhttp.internal.framed.b.f49148h, com.squareup.okhttp.internal.g.i(request.httpUrl())));
        arrayList.add(new com.squareup.okhttp.internal.framed.b(com.squareup.okhttp.internal.framed.b.f49147g, request.httpUrl().scheme()));
        int size = headers.size();
        for (int i11 = 0; i11 < size; i11++) {
            ByteString byteStringEncodeUtf8 = ByteString.encodeUtf8(headers.name(i11).toLowerCase(Locale.US));
            if (!f49273o.contains(byteStringEncodeUtf8)) {
                arrayList.add(new com.squareup.okhttp.internal.framed.b(byteStringEncodeUtf8, headers.value(i11)));
            }
        }
        return arrayList;
    }

    public static String c(String str, String str2) {
        return str + (char) 0 + str2;
    }

    public static Response.Builder d(List<com.squareup.okhttp.internal.framed.b> list) throws IOException {
        Headers.Builder builder = new Headers.Builder();
        int size = list.size();
        String str = null;
        for (int i11 = 0; i11 < size; i11++) {
            ByteString byteString = list.get(i11).f49151a;
            String strUtf8 = list.get(i11).f49152b.utf8();
            if (byteString.equals(com.squareup.okhttp.internal.framed.b.f49144d)) {
                str = strUtf8;
            } else if (!f49274p.contains(byteString)) {
                builder.add(byteString.utf8(), strUtf8);
            }
        }
        if (str == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        m mVarA = m.a("HTTP/1.1 " + str);
        return new Response.Builder().protocol(Protocol.HTTP_2).code(mVarA.f49326b).message(mVarA.f49327c).headers(builder.build());
    }

    public static Response.Builder e(List<com.squareup.okhttp.internal.framed.b> list) throws IOException {
        Headers.Builder builder = new Headers.Builder();
        int size = list.size();
        String str = null;
        String str2 = "HTTP/1.1";
        for (int i11 = 0; i11 < size; i11++) {
            ByteString byteString = list.get(i11).f49151a;
            String strUtf8 = list.get(i11).f49152b.utf8();
            int i12 = 0;
            while (i12 < strUtf8.length()) {
                int iIndexOf = strUtf8.indexOf(0, i12);
                if (iIndexOf == -1) {
                    iIndexOf = strUtf8.length();
                }
                String strSubstring = strUtf8.substring(i12, iIndexOf);
                if (byteString.equals(com.squareup.okhttp.internal.framed.b.f49144d)) {
                    str = strSubstring;
                } else if (byteString.equals(com.squareup.okhttp.internal.framed.b.f49150j)) {
                    str2 = strSubstring;
                } else if (!f49272n.contains(byteString)) {
                    builder.add(byteString.utf8(), strSubstring);
                }
                i12 = iIndexOf + 1;
            }
        }
        if (str == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        m mVarA = m.a(str2 + " " + str);
        return new Response.Builder().protocol(Protocol.SPDY_3).code(mVarA.f49326b).message(mVarA.f49327c).headers(builder.build());
    }

    public static List<com.squareup.okhttp.internal.framed.b> f(Request request) {
        Headers headers = request.headers();
        ArrayList arrayList = new ArrayList(headers.size() + 5);
        arrayList.add(new com.squareup.okhttp.internal.framed.b(com.squareup.okhttp.internal.framed.b.f49145e, request.method()));
        arrayList.add(new com.squareup.okhttp.internal.framed.b(com.squareup.okhttp.internal.framed.b.f49146f, j.c(request.httpUrl())));
        arrayList.add(new com.squareup.okhttp.internal.framed.b(com.squareup.okhttp.internal.framed.b.f49150j, "HTTP/1.1"));
        arrayList.add(new com.squareup.okhttp.internal.framed.b(com.squareup.okhttp.internal.framed.b.f49149i, com.squareup.okhttp.internal.g.i(request.httpUrl())));
        arrayList.add(new com.squareup.okhttp.internal.framed.b(com.squareup.okhttp.internal.framed.b.f49147g, request.httpUrl().scheme()));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = headers.size();
        for (int i11 = 0; i11 < size; i11++) {
            ByteString byteStringEncodeUtf8 = ByteString.encodeUtf8(headers.name(i11).toLowerCase(Locale.US));
            if (!f49271m.contains(byteStringEncodeUtf8)) {
                String strValue = headers.value(i11);
                if (linkedHashSet.add(byteStringEncodeUtf8)) {
                    arrayList.add(new com.squareup.okhttp.internal.framed.b(byteStringEncodeUtf8, strValue));
                } else {
                    for (int i12 = 0; i12 < arrayList.size(); i12++) {
                        if (((com.squareup.okhttp.internal.framed.b) arrayList.get(i12)).f49151a.equals(byteStringEncodeUtf8)) {
                            arrayList.set(i12, new com.squareup.okhttp.internal.framed.b(byteStringEncodeUtf8, c(((com.squareup.okhttp.internal.framed.b) arrayList.get(i12)).f49152b.utf8(), strValue)));
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void cancel() {
        com.squareup.okhttp.internal.framed.a aVar = this.f49278d;
        if (aVar != null) {
            aVar.n(ErrorCode.CANCEL);
        }
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public Sink createRequestBody(Request request, long j11) throws IOException {
        return this.f49278d.q();
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void finishRequest() throws IOException {
        this.f49278d.q().close();
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public ResponseBody openResponseBody(Response response) throws IOException {
        return new i(response.headers(), Okio.buffer(new a(this.f49278d.r())));
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public Response.Builder readResponseHeaders() throws IOException {
        return this.f49276b.Z() == Protocol.HTTP_2 ? d(this.f49278d.p()) : e(this.f49278d.p());
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void setHttpEngine(g gVar) {
        this.f49277c = gVar;
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void writeRequestBody(k kVar) throws IOException {
        kVar.b(this.f49278d.q());
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void writeRequestHeaders(Request request) throws IOException {
        if (this.f49278d != null) {
            return;
        }
        this.f49277c.C();
        com.squareup.okhttp.internal.framed.a aVarG0 = this.f49276b.g0(this.f49276b.Z() == Protocol.HTTP_2 ? b(request) : f(request), this.f49277c.q(request), true);
        this.f49278d = aVarG0;
        Timeout timeoutU = aVarG0.u();
        long readTimeout = this.f49277c.f49285a.getReadTimeout();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeoutU.timeout(readTimeout, timeUnit);
        this.f49278d.A().timeout(this.f49277c.f49285a.getWriteTimeout(), timeUnit);
    }
}
