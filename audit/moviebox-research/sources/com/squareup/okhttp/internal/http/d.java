package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements HttpStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f49240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BufferedSource f49241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BufferedSink f49242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.squareup.okhttp.internal.http.g f49243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f49244e = 0;

    /* JADX INFO: compiled from: source.java */
    public abstract class b implements Source {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ForwardingTimeout f49245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f49246b;

        public b() {
            this.f49245a = new ForwardingTimeout(d.this.f49241b.timeout());
        }

        public final void a() throws IOException {
            if (d.this.f49244e != 5) {
                throw new IllegalStateException("state: " + d.this.f49244e);
            }
            d.this.g(this.f49245a);
            d.this.f49244e = 6;
            if (d.this.f49240a != null) {
                d.this.f49240a.r(d.this);
            }
        }

        public final void b() {
            if (d.this.f49244e == 6) {
                return;
            }
            d.this.f49244e = 6;
            if (d.this.f49240a != null) {
                d.this.f49240a.l();
                d.this.f49240a.r(d.this);
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.f49245a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class c implements Sink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ForwardingTimeout f49248a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f49249b;

        public c() {
            this.f49248a = new ForwardingTimeout(d.this.f49242c.timeout());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.f49249b) {
                return;
            }
            this.f49249b = true;
            d.this.f49242c.writeUtf8("0\r\n\r\n");
            d.this.g(this.f49248a);
            d.this.f49244e = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.f49249b) {
                return;
            }
            d.this.f49242c.flush();
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.f49248a;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j11) throws IOException {
            if (this.f49249b) {
                throw new IllegalStateException("closed");
            }
            if (j11 == 0) {
                return;
            }
            d.this.f49242c.writeHexadecimalUnsignedLong(j11);
            d.this.f49242c.writeUtf8("\r\n");
            d.this.f49242c.write(buffer, j11);
            d.this.f49242c.writeUtf8("\r\n");
        }
    }

    /* JADX INFO: renamed from: com.squareup.okhttp.internal.http.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0537d extends b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f49251d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f49252f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final com.squareup.okhttp.internal.http.g f49253g;

        public C0537d(com.squareup.okhttp.internal.http.g gVar) throws IOException {
            super();
            this.f49251d = -1L;
            this.f49252f = true;
            this.f49253g = gVar;
        }

        public final void c() throws IOException {
            if (this.f49251d != -1) {
                d.this.f49241b.readUtf8LineStrict();
            }
            try {
                this.f49251d = d.this.f49241b.readHexadecimalUnsignedLong();
                String strTrim = d.this.f49241b.readUtf8LineStrict().trim();
                if (this.f49251d < 0 || !(strTrim.isEmpty() || strTrim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f49251d + strTrim + "\"");
                }
                if (this.f49251d == 0) {
                    this.f49252f = false;
                    this.f49253g.t(d.this.n());
                    a();
                }
            } catch (NumberFormatException e11) {
                throw new ProtocolException(e11.getMessage());
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f49246b) {
                return;
            }
            if (this.f49252f && !com.squareup.okhttp.internal.g.g(this, 100, TimeUnit.MILLISECONDS)) {
                b();
            }
            this.f49246b = true;
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j11) throws IOException {
            if (j11 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j11);
            }
            if (this.f49246b) {
                throw new IllegalStateException("closed");
            }
            if (!this.f49252f) {
                return -1L;
            }
            long j12 = this.f49251d;
            if (j12 == 0 || j12 == -1) {
                c();
                if (!this.f49252f) {
                    return -1L;
                }
            }
            long j13 = d.this.f49241b.read(buffer, Math.min(j11, this.f49251d));
            if (j13 != -1) {
                this.f49251d -= j13;
                return j13;
            }
            b();
            throw new ProtocolException("unexpected end of stream");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class e implements Sink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ForwardingTimeout f49255a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f49256b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f49257c;

        public e(long j11) {
            this.f49255a = new ForwardingTimeout(d.this.f49242c.timeout());
            this.f49257c = j11;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f49256b) {
                return;
            }
            this.f49256b = true;
            if (this.f49257c > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            d.this.g(this.f49255a);
            d.this.f49244e = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (this.f49256b) {
                return;
            }
            d.this.f49242c.flush();
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.f49255a;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j11) throws IOException {
            if (this.f49256b) {
                throw new IllegalStateException("closed");
            }
            com.squareup.okhttp.internal.g.a(buffer.size(), 0L, j11);
            if (j11 <= this.f49257c) {
                d.this.f49242c.write(buffer, j11);
                this.f49257c -= j11;
                return;
            }
            throw new ProtocolException("expected " + this.f49257c + " bytes but received " + j11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f extends b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f49259d;

        public f(long j11) throws IOException {
            super();
            this.f49259d = j11;
            if (j11 == 0) {
                a();
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f49246b) {
                return;
            }
            if (this.f49259d != 0 && !com.squareup.okhttp.internal.g.g(this, 100, TimeUnit.MILLISECONDS)) {
                b();
            }
            this.f49246b = true;
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j11) throws IOException {
            if (j11 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j11);
            }
            if (this.f49246b) {
                throw new IllegalStateException("closed");
            }
            if (this.f49259d == 0) {
                return -1L;
            }
            long j12 = d.this.f49241b.read(buffer, Math.min(this.f49259d, j11));
            if (j12 == -1) {
                b();
                throw new ProtocolException("unexpected end of stream");
            }
            long j13 = this.f49259d - j12;
            this.f49259d = j13;
            if (j13 == 0) {
                a();
            }
            return j12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g extends b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f49261d;

        public g() {
            super();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f49246b) {
                return;
            }
            if (!this.f49261d) {
                b();
            }
            this.f49246b = true;
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j11) throws IOException {
            if (j11 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j11);
            }
            if (this.f49246b) {
                throw new IllegalStateException("closed");
            }
            if (this.f49261d) {
                return -1L;
            }
            long j12 = d.this.f49241b.read(buffer, j11);
            if (j12 != -1) {
                return j12;
            }
            this.f49261d = true;
            a();
            return -1L;
        }
    }

    public d(n nVar, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.f49240a = nVar;
        this.f49241b = bufferedSource;
        this.f49242c = bufferedSink;
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void cancel() {
        jo.a aVarC = this.f49240a.c();
        if (aVarC != null) {
            aVarC.b();
        }
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public Sink createRequestBody(Request request, long j11) throws IOException {
        if ("chunked".equalsIgnoreCase(request.header("Transfer-Encoding"))) {
            return i();
        }
        if (j11 != -1) {
            return k(j11);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void finishRequest() throws IOException {
        this.f49242c.flush();
    }

    public final void g(ForwardingTimeout forwardingTimeout) {
        Timeout timeoutDelegate = forwardingTimeout.delegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        timeoutDelegate.clearDeadline();
        timeoutDelegate.clearTimeout();
    }

    public final Source h(Response response) throws IOException {
        if (!com.squareup.okhttp.internal.http.g.n(response)) {
            return l(0L);
        }
        if ("chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return j(this.f49243d);
        }
        long jE = OkHeaders.e(response);
        return jE != -1 ? l(jE) : m();
    }

    public Sink i() {
        if (this.f49244e == 1) {
            this.f49244e = 2;
            return new c();
        }
        throw new IllegalStateException("state: " + this.f49244e);
    }

    public Source j(com.squareup.okhttp.internal.http.g gVar) throws IOException {
        if (this.f49244e == 4) {
            this.f49244e = 5;
            return new C0537d(gVar);
        }
        throw new IllegalStateException("state: " + this.f49244e);
    }

    public Sink k(long j11) {
        if (this.f49244e == 1) {
            this.f49244e = 2;
            return new e(j11);
        }
        throw new IllegalStateException("state: " + this.f49244e);
    }

    public Source l(long j11) throws IOException {
        if (this.f49244e == 4) {
            this.f49244e = 5;
            return new f(j11);
        }
        throw new IllegalStateException("state: " + this.f49244e);
    }

    public Source m() throws IOException {
        if (this.f49244e != 4) {
            throw new IllegalStateException("state: " + this.f49244e);
        }
        n nVar = this.f49240a;
        if (nVar == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.f49244e = 5;
        nVar.l();
        return new g();
    }

    public Headers n() throws IOException {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String utf8LineStrict = this.f49241b.readUtf8LineStrict();
            if (utf8LineStrict.length() == 0) {
                return builder.build();
            }
            com.squareup.okhttp.internal.c.instance.addLenient(builder, utf8LineStrict);
        }
    }

    public Response.Builder o() throws IOException {
        m mVarA;
        Response.Builder builderHeaders;
        int i11 = this.f49244e;
        if (i11 != 1 && i11 != 3) {
            throw new IllegalStateException("state: " + this.f49244e);
        }
        do {
            try {
                mVarA = m.a(this.f49241b.readUtf8LineStrict());
                builderHeaders = new Response.Builder().protocol(mVarA.f49325a).code(mVarA.f49326b).message(mVarA.f49327c).headers(n());
            } catch (EOFException e11) {
                IOException iOException = new IOException("unexpected end of stream on " + this.f49240a);
                iOException.initCause(e11);
                throw iOException;
            }
        } while (mVarA.f49326b == 100);
        this.f49244e = 4;
        return builderHeaders;
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public ResponseBody openResponseBody(Response response) throws IOException {
        return new i(response.headers(), Okio.buffer(h(response)));
    }

    public void p(Headers headers, String str) throws IOException {
        if (this.f49244e != 0) {
            throw new IllegalStateException("state: " + this.f49244e);
        }
        this.f49242c.writeUtf8(str).writeUtf8("\r\n");
        int size = headers.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f49242c.writeUtf8(headers.name(i11)).writeUtf8(": ").writeUtf8(headers.value(i11)).writeUtf8("\r\n");
        }
        this.f49242c.writeUtf8("\r\n");
        this.f49244e = 1;
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public Response.Builder readResponseHeaders() throws IOException {
        return o();
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void setHttpEngine(com.squareup.okhttp.internal.http.g gVar) {
        this.f49243d = gVar;
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void writeRequestBody(k kVar) throws IOException {
        if (this.f49244e == 1) {
            this.f49244e = 3;
            kVar.b(this.f49242c);
        } else {
            throw new IllegalStateException("state: " + this.f49244e);
        }
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void writeRequestHeaders(Request request) throws IOException {
        this.f49243d.C();
        p(request.headers(), j.a(request, this.f49243d.k().getRoute().getProxy().type()));
    }
}
