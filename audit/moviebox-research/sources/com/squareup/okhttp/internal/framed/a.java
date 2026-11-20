package com.squareup.okhttp.internal.framed;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f49123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f49124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FramedConnection f49125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<com.squareup.okhttp.internal.framed.b> f49126e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<com.squareup.okhttp.internal.framed.b> f49127f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f49128g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f49129h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f49122a = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d f49130i = new d();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d f49131j = new d();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ErrorCode f49132k = null;

    /* JADX INFO: compiled from: source.java */
    public final class b implements Sink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Buffer f49133a = new Buffer();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f49134b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f49135c;

        public b() {
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (a.this) {
                try {
                    if (this.f49134b) {
                        return;
                    }
                    if (!a.this.f49129h.f49135c) {
                        if (this.f49133a.size() > 0) {
                            while (this.f49133a.size() > 0) {
                                d(true);
                            }
                        } else {
                            a.this.f49125d.v0(a.this.f49124c, true, null, 0L);
                        }
                    }
                    synchronized (a.this) {
                        this.f49134b = true;
                    }
                    a.this.f49125d.flush();
                    a.this.j();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public final void d(boolean z11) throws IOException {
            long jMin;
            a aVar;
            synchronized (a.this) {
                a.this.f49131j.enter();
                while (true) {
                    try {
                        a aVar2 = a.this;
                        if (aVar2.f49123b > 0 || this.f49135c || this.f49134b || aVar2.f49132k != null) {
                            break;
                        } else {
                            a.this.z();
                        }
                    } catch (Throwable th2) {
                        a.this.f49131j.exitAndThrowIfTimedOut();
                        throw th2;
                    }
                }
                a.this.f49131j.exitAndThrowIfTimedOut();
                a.this.k();
                jMin = Math.min(a.this.f49123b, this.f49133a.size());
                aVar = a.this;
                aVar.f49123b -= jMin;
            }
            aVar.f49131j.enter();
            try {
                a.this.f49125d.v0(a.this.f49124c, z11 && jMin == this.f49133a.size(), this.f49133a, jMin);
            } finally {
                a.this.f49131j.exitAndThrowIfTimedOut();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            synchronized (a.this) {
                a.this.k();
            }
            while (this.f49133a.size() > 0) {
                d(false);
                a.this.f49125d.flush();
            }
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return a.this.f49131j;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j11) throws IOException {
            this.f49133a.write(buffer, j11);
            while (this.f49133a.size() >= 16384) {
                d(false);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class c implements Source {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Buffer f49137a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Buffer f49138b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f49139c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f49140d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f49141f;

        public c(long j11) {
            this.f49137a = new Buffer();
            this.f49138b = new Buffer();
            this.f49139c = j11;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (a.this) {
                this.f49140d = true;
                this.f49138b.clear();
                a.this.notifyAll();
            }
            a.this.j();
        }

        public final void d() throws IOException {
            if (this.f49140d) {
                throw new IOException("stream closed");
            }
            if (a.this.f49132k == null) {
                return;
            }
            throw new IOException("stream was reset: " + a.this.f49132k);
        }

        public void e(BufferedSource bufferedSource, long j11) throws IOException {
            boolean z11;
            boolean z12;
            while (j11 > 0) {
                synchronized (a.this) {
                    z11 = this.f49141f;
                    z12 = this.f49138b.size() + j11 > this.f49139c;
                }
                if (z12) {
                    bufferedSource.skip(j11);
                    a.this.n(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z11) {
                    bufferedSource.skip(j11);
                    return;
                }
                long j12 = bufferedSource.read(this.f49137a, j11);
                if (j12 == -1) {
                    throw new EOFException();
                }
                j11 -= j12;
                synchronized (a.this) {
                    try {
                        boolean z13 = this.f49138b.size() == 0;
                        this.f49138b.writeAll(this.f49137a);
                        if (z13) {
                            a.this.notifyAll();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }

        public final void g() throws IOException {
            a.this.f49130i.enter();
            while (this.f49138b.size() == 0 && !this.f49141f && !this.f49140d && a.this.f49132k == null) {
                try {
                    a.this.z();
                } catch (Throwable th2) {
                    a.this.f49130i.exitAndThrowIfTimedOut();
                    throw th2;
                }
            }
            a.this.f49130i.exitAndThrowIfTimedOut();
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j11) throws IOException {
            if (j11 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j11);
            }
            synchronized (a.this) {
                try {
                    g();
                    d();
                    if (this.f49138b.size() == 0) {
                        return -1L;
                    }
                    Buffer buffer2 = this.f49138b;
                    long j12 = buffer2.read(buffer, Math.min(j11, buffer2.size()));
                    a aVar = a.this;
                    long j13 = aVar.f49122a + j12;
                    aVar.f49122a = j13;
                    if (j13 >= aVar.f49125d.f49105q.e(65536) / 2) {
                        a.this.f49125d.A0(a.this.f49124c, a.this.f49122a);
                        a.this.f49122a = 0L;
                    }
                    synchronized (a.this.f49125d) {
                        try {
                            a.this.f49125d.f49103o += j12;
                            if (a.this.f49125d.f49103o >= a.this.f49125d.f49105q.e(65536) / 2) {
                                a.this.f49125d.A0(0, a.this.f49125d.f49103o);
                                a.this.f49125d.f49103o = 0L;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    return j12;
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return a.this.f49130i;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends AsyncTimeout {
        public d() {
        }

        public void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }

        @Override // okio.AsyncTimeout
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // okio.AsyncTimeout
        public void timedOut() {
            a.this.n(ErrorCode.CANCEL);
        }
    }

    public a(int i11, FramedConnection framedConnection, boolean z11, boolean z12, List<com.squareup.okhttp.internal.framed.b> list) {
        if (framedConnection == null) {
            throw new NullPointerException("connection == null");
        }
        if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.f49124c = i11;
        this.f49125d = framedConnection;
        this.f49123b = framedConnection.f49106r.e(65536);
        c cVar = new c(framedConnection.f49105q.e(65536));
        this.f49128g = cVar;
        b bVar = new b();
        this.f49129h = bVar;
        cVar.f49141f = z12;
        bVar.f49135c = z11;
        this.f49126e = list;
    }

    public Timeout A() {
        return this.f49131j;
    }

    public void i(long j11) {
        this.f49123b += j11;
        if (j11 > 0) {
            notifyAll();
        }
    }

    public final void j() throws IOException {
        boolean z11;
        boolean zT;
        synchronized (this) {
            try {
                z11 = !this.f49128g.f49141f && this.f49128g.f49140d && (this.f49129h.f49135c || this.f49129h.f49134b);
                zT = t();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z11) {
            l(ErrorCode.CANCEL);
        } else {
            if (zT) {
                return;
            }
            this.f49125d.q0(this.f49124c);
        }
    }

    public final void k() throws IOException {
        if (this.f49129h.f49134b) {
            throw new IOException("stream closed");
        }
        if (this.f49129h.f49135c) {
            throw new IOException("stream finished");
        }
        if (this.f49132k == null) {
            return;
        }
        throw new IOException("stream was reset: " + this.f49132k);
    }

    public void l(ErrorCode errorCode) throws IOException {
        if (m(errorCode)) {
            this.f49125d.y0(this.f49124c, errorCode);
        }
    }

    public final boolean m(ErrorCode errorCode) {
        synchronized (this) {
            try {
                if (this.f49132k != null) {
                    return false;
                }
                if (this.f49128g.f49141f && this.f49129h.f49135c) {
                    return false;
                }
                this.f49132k = errorCode;
                notifyAll();
                this.f49125d.q0(this.f49124c);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void n(ErrorCode errorCode) {
        if (m(errorCode)) {
            this.f49125d.z0(this.f49124c, errorCode);
        }
    }

    public int o() {
        return this.f49124c;
    }

    public synchronized List<com.squareup.okhttp.internal.framed.b> p() throws IOException {
        List<com.squareup.okhttp.internal.framed.b> list;
        try {
            this.f49130i.enter();
            while (this.f49127f == null && this.f49132k == null) {
                try {
                    z();
                } catch (Throwable th2) {
                    this.f49130i.exitAndThrowIfTimedOut();
                    throw th2;
                }
            }
            this.f49130i.exitAndThrowIfTimedOut();
            list = this.f49127f;
            if (list == null) {
                throw new IOException("stream was reset: " + this.f49132k);
            }
        } catch (Throwable th3) {
            throw th3;
        }
        return list;
    }

    public Sink q() {
        synchronized (this) {
            try {
                if (this.f49127f == null && !s()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return this.f49129h;
    }

    public Source r() {
        return this.f49128g;
    }

    public boolean s() {
        return this.f49125d.f49091b == ((this.f49124c & 1) == 1);
    }

    public synchronized boolean t() {
        try {
            if (this.f49132k != null) {
                return false;
            }
            if (this.f49128g.f49141f || this.f49128g.f49140d) {
                if ((this.f49129h.f49135c || this.f49129h.f49134b) && this.f49127f != null) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public Timeout u() {
        return this.f49130i;
    }

    public void v(BufferedSource bufferedSource, int i11) throws IOException {
        this.f49128g.e(bufferedSource, i11);
    }

    public void w() {
        boolean zT;
        synchronized (this) {
            this.f49128g.f49141f = true;
            zT = t();
            notifyAll();
        }
        if (zT) {
            return;
        }
        this.f49125d.q0(this.f49124c);
    }

    public void x(List<com.squareup.okhttp.internal.framed.b> list, HeadersMode headersMode) {
        ErrorCode errorCode;
        boolean zT;
        synchronized (this) {
            try {
                errorCode = null;
                zT = true;
                if (this.f49127f == null) {
                    if (headersMode.failIfHeadersAbsent()) {
                        errorCode = ErrorCode.PROTOCOL_ERROR;
                    } else {
                        this.f49127f = list;
                        zT = t();
                        notifyAll();
                    }
                } else if (headersMode.failIfHeadersPresent()) {
                    errorCode = ErrorCode.STREAM_IN_USE;
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.f49127f);
                    arrayList.addAll(list);
                    this.f49127f = arrayList;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (errorCode != null) {
            n(errorCode);
        } else {
            if (zT) {
                return;
            }
            this.f49125d.q0(this.f49124c);
        }
    }

    public synchronized void y(ErrorCode errorCode) {
        if (this.f49132k == null) {
            this.f49132k = errorCode;
            notifyAll();
        }
    }

    public final void z() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }
}
