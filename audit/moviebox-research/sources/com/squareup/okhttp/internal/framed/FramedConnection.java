package com.squareup.okhttp.internal.framed;

import com.google.android.gms.common.api.Api;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.NamedRunnable;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import okhttp3.internal.http2.Settings;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class FramedConnection implements Closeable {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final ExecutorService f49089y = new ThreadPoolExecutor(0, Api.BaseClientBuilder.API_PRIORITY_OTHER, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.squareup.okhttp.internal.g.s("OkHttp FramedConnection", true));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Protocol f49090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f49091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f49092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Integer, com.squareup.okhttp.internal.framed.a> f49093d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f49094f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f49095g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f49096h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f49097i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f49098j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ExecutorService f49099k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Map<Integer, g> f49100l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final PushObserver f49101m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f49102n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f49103o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f49104p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public h f49105q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final h f49106r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f49107s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Variant f49108t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Socket f49109u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final FrameWriter f49110v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Reader f49111w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Set<Integer> f49112x;

    /* JADX INFO: compiled from: source.java */
    public class Reader extends NamedRunnable implements FrameReader.Handler {
        final FrameReader frameReader;

        private Reader(FrameReader frameReader) {
            super("OkHttp %s", FramedConnection.this.f49094f);
            this.frameReader = frameReader;
        }

        private void ackSettingsLater(final h hVar) {
            FramedConnection.f49089y.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{FramedConnection.this.f49094f}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.Reader.3
                @Override // com.squareup.okhttp.internal.NamedRunnable
                public void execute() {
                    try {
                        FramedConnection.this.f49110v.ackSettings(hVar);
                    } catch (IOException unused) {
                    }
                }
            });
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void ackSettings() {
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void alternateService(int i11, String str, ByteString byteString, String str2, int i12, long j11) {
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void data(boolean z11, int i11, BufferedSource bufferedSource, int i12) throws IOException {
            if (FramedConnection.this.l0(i11)) {
                FramedConnection.this.h0(i11, bufferedSource, i12, z11);
                return;
            }
            com.squareup.okhttp.internal.framed.a aVarB0 = FramedConnection.this.b0(i11);
            if (aVarB0 == null) {
                FramedConnection.this.z0(i11, ErrorCode.INVALID_STREAM);
                bufferedSource.skip(i12);
            } else {
                aVarB0.v(bufferedSource, i12);
                if (z11) {
                    aVarB0.w();
                }
            }
        }

        @Override // com.squareup.okhttp.internal.NamedRunnable
        public void execute() throws Throwable {
            ErrorCode errorCode;
            ErrorCode errorCode2;
            ErrorCode errorCode3 = ErrorCode.INTERNAL_ERROR;
            try {
                try {
                    if (!FramedConnection.this.f49091b) {
                        this.frameReader.readConnectionPreface();
                    }
                    while (this.frameReader.nextFrame(this)) {
                    }
                    errorCode2 = ErrorCode.NO_ERROR;
                    try {
                        try {
                            FramedConnection.this.W(errorCode2, ErrorCode.CANCEL);
                        } catch (IOException unused) {
                            ErrorCode errorCode4 = ErrorCode.PROTOCOL_ERROR;
                            FramedConnection.this.W(errorCode4, errorCode4);
                        }
                    } catch (Throwable th2) {
                        errorCode = errorCode2;
                        th = th2;
                        try {
                            FramedConnection.this.W(errorCode, errorCode3);
                        } catch (IOException unused2) {
                        }
                        com.squareup.okhttp.internal.g.c(this.frameReader);
                        throw th;
                    }
                } catch (IOException unused3) {
                }
            } catch (IOException unused4) {
                errorCode2 = errorCode3;
            } catch (Throwable th3) {
                th = th3;
                errorCode = errorCode3;
                FramedConnection.this.W(errorCode, errorCode3);
                com.squareup.okhttp.internal.g.c(this.frameReader);
                throw th;
            }
            com.squareup.okhttp.internal.g.c(this.frameReader);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void goAway(int i11, ErrorCode errorCode, ByteString byteString) {
            com.squareup.okhttp.internal.framed.a[] aVarArr;
            byteString.size();
            synchronized (FramedConnection.this) {
                aVarArr = (com.squareup.okhttp.internal.framed.a[]) FramedConnection.this.f49093d.values().toArray(new com.squareup.okhttp.internal.framed.a[FramedConnection.this.f49093d.size()]);
                FramedConnection.this.f49097i = true;
            }
            for (com.squareup.okhttp.internal.framed.a aVar : aVarArr) {
                if (aVar.o() > i11 && aVar.s()) {
                    aVar.y(ErrorCode.REFUSED_STREAM);
                    FramedConnection.this.q0(aVar.o());
                }
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void headers(boolean z11, boolean z12, int i11, int i12, List<com.squareup.okhttp.internal.framed.b> list, HeadersMode headersMode) {
            if (FramedConnection.this.l0(i11)) {
                FramedConnection.this.i0(i11, list, z12);
                return;
            }
            synchronized (FramedConnection.this) {
                try {
                    if (FramedConnection.this.f49097i) {
                        return;
                    }
                    com.squareup.okhttp.internal.framed.a aVarB0 = FramedConnection.this.b0(i11);
                    if (aVarB0 != null) {
                        if (headersMode.failIfStreamPresent()) {
                            aVarB0.n(ErrorCode.PROTOCOL_ERROR);
                            FramedConnection.this.q0(i11);
                            return;
                        } else {
                            aVarB0.x(list, headersMode);
                            if (z12) {
                                aVarB0.w();
                                return;
                            }
                            return;
                        }
                    }
                    if (headersMode.failIfStreamAbsent()) {
                        FramedConnection.this.z0(i11, ErrorCode.INVALID_STREAM);
                        return;
                    }
                    if (i11 <= FramedConnection.this.f49095g) {
                        return;
                    }
                    if (i11 % 2 == FramedConnection.this.f49096h % 2) {
                        return;
                    }
                    final com.squareup.okhttp.internal.framed.a aVar = new com.squareup.okhttp.internal.framed.a(i11, FramedConnection.this, z11, z12, list);
                    FramedConnection.this.f49095g = i11;
                    FramedConnection.this.f49093d.put(Integer.valueOf(i11), aVar);
                    FramedConnection.f49089y.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{FramedConnection.this.f49094f, Integer.valueOf(i11)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.Reader.1
                        @Override // com.squareup.okhttp.internal.NamedRunnable
                        public void execute() {
                            try {
                                FramedConnection.this.f49092c.b(aVar);
                            } catch (IOException e11) {
                                com.squareup.okhttp.internal.c.logger.log(Level.INFO, "FramedConnection.Listener failure for " + FramedConnection.this.f49094f, (Throwable) e11);
                                try {
                                    aVar.l(ErrorCode.PROTOCOL_ERROR);
                                } catch (IOException unused) {
                                }
                            }
                        }
                    });
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void ping(boolean z11, int i11, int i12) {
            if (!z11) {
                FramedConnection.this.x0(true, i11, i12, null);
                return;
            }
            g gVarP0 = FramedConnection.this.p0(i11);
            if (gVarP0 != null) {
                gVarP0.b();
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void priority(int i11, int i12, int i13, boolean z11) {
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void pushPromise(int i11, int i12, List<com.squareup.okhttp.internal.framed.b> list) {
            FramedConnection.this.j0(i12, list);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void rstStream(int i11, ErrorCode errorCode) {
            if (FramedConnection.this.l0(i11)) {
                FramedConnection.this.k0(i11, errorCode);
                return;
            }
            com.squareup.okhttp.internal.framed.a aVarQ0 = FramedConnection.this.q0(i11);
            if (aVarQ0 != null) {
                aVarQ0.y(errorCode);
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void settings(boolean z11, h hVar) {
            com.squareup.okhttp.internal.framed.a[] aVarArr;
            long j11;
            int i11;
            synchronized (FramedConnection.this) {
                try {
                    int iE = FramedConnection.this.f49106r.e(65536);
                    if (z11) {
                        FramedConnection.this.f49106r.a();
                    }
                    FramedConnection.this.f49106r.j(hVar);
                    if (FramedConnection.this.Z() == Protocol.HTTP_2) {
                        ackSettingsLater(hVar);
                    }
                    int iE2 = FramedConnection.this.f49106r.e(65536);
                    aVarArr = null;
                    if (iE2 == -1 || iE2 == iE) {
                        j11 = 0;
                    } else {
                        j11 = iE2 - iE;
                        if (!FramedConnection.this.f49107s) {
                            FramedConnection.this.U(j11);
                            FramedConnection.this.f49107s = true;
                        }
                        if (!FramedConnection.this.f49093d.isEmpty()) {
                            aVarArr = (com.squareup.okhttp.internal.framed.a[]) FramedConnection.this.f49093d.values().toArray(new com.squareup.okhttp.internal.framed.a[FramedConnection.this.f49093d.size()]);
                        }
                    }
                    FramedConnection.f49089y.execute(new NamedRunnable("OkHttp %s settings", FramedConnection.this.f49094f) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.Reader.2
                        @Override // com.squareup.okhttp.internal.NamedRunnable
                        public void execute() {
                            FramedConnection.this.f49092c.a(FramedConnection.this);
                        }
                    });
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (aVarArr == null || j11 == 0) {
                return;
            }
            for (com.squareup.okhttp.internal.framed.a aVar : aVarArr) {
                synchronized (aVar) {
                    aVar.i(j11);
                }
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void windowUpdate(int i11, long j11) {
            if (i11 == 0) {
                synchronized (FramedConnection.this) {
                    FramedConnection framedConnection = FramedConnection.this;
                    framedConnection.f49104p += j11;
                    framedConnection.notifyAll();
                }
                return;
            }
            com.squareup.okhttp.internal.framed.a aVarB0 = FramedConnection.this.b0(i11);
            if (aVarB0 != null) {
                synchronized (aVarB0) {
                    aVarB0.i(j11);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Socket f49113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f49114b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public BufferedSource f49115c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public BufferedSink f49116d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public b f49117e = b.f49121a;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Protocol f49118f = Protocol.SPDY_3;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public PushObserver f49119g = PushObserver.CANCEL;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f49120h;

        public a(boolean z11) throws IOException {
            this.f49120h = z11;
        }

        public FramedConnection i() throws IOException {
            return new FramedConnection(this);
        }

        public a j(Protocol protocol) {
            this.f49118f = protocol;
            return this;
        }

        public a k(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.f49113a = socket;
            this.f49114b = str;
            this.f49115c = bufferedSource;
            this.f49116d = bufferedSink;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f49121a = new a();

        /* JADX INFO: compiled from: source.java */
        public static class a extends b {
            @Override // com.squareup.okhttp.internal.framed.FramedConnection.b
            public void b(com.squareup.okhttp.internal.framed.a aVar) throws IOException {
                aVar.l(ErrorCode.REFUSED_STREAM);
            }
        }

        public void a(FramedConnection framedConnection) {
        }

        public abstract void b(com.squareup.okhttp.internal.framed.a aVar) throws IOException;
    }

    public FramedConnection(a aVar) throws IOException {
        this.f49093d = new HashMap();
        this.f49098j = System.nanoTime();
        this.f49103o = 0L;
        this.f49105q = new h();
        h hVar = new h();
        this.f49106r = hVar;
        this.f49107s = false;
        this.f49112x = new LinkedHashSet();
        Protocol protocol = aVar.f49118f;
        this.f49090a = protocol;
        this.f49101m = aVar.f49119g;
        boolean z11 = aVar.f49120h;
        this.f49091b = z11;
        this.f49092c = aVar.f49117e;
        this.f49096h = aVar.f49120h ? 1 : 2;
        if (aVar.f49120h && protocol == Protocol.HTTP_2) {
            this.f49096h += 2;
        }
        this.f49102n = aVar.f49120h ? 1 : 2;
        if (aVar.f49120h) {
            this.f49105q.l(7, 0, 16777216);
        }
        String str = aVar.f49114b;
        this.f49094f = str;
        if (protocol == Protocol.HTTP_2) {
            this.f49108t = new d();
            this.f49099k = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.squareup.okhttp.internal.g.s(String.format("OkHttp %s Push Observer", str), true));
            hVar.l(7, 0, Settings.DEFAULT_INITIAL_WINDOW_SIZE);
            hVar.l(5, 0, 16384);
        } else {
            if (protocol != Protocol.SPDY_3) {
                throw new AssertionError(protocol);
            }
            this.f49108t = new i();
            this.f49099k = null;
        }
        this.f49104p = hVar.e(65536);
        this.f49109u = aVar.f49113a;
        this.f49110v = this.f49108t.newWriter(aVar.f49116d, z11);
        Reader reader = new Reader(this.f49108t.newReader(aVar.f49115c, z11));
        this.f49111w = reader;
        new Thread(reader).start();
    }

    public void A0(final int i11, final long j11) {
        f49089y.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.f49094f, Integer.valueOf(i11)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.2
            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void execute() {
                try {
                    FramedConnection.this.f49110v.windowUpdate(i11, j11);
                } catch (IOException unused) {
                }
            }
        });
    }

    public void U(long j11) {
        this.f49104p += j11;
        if (j11 > 0) {
            notifyAll();
        }
    }

    public final void W(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        int i11;
        com.squareup.okhttp.internal.framed.a[] aVarArr;
        g[] gVarArr = null;
        try {
            u0(errorCode);
            e = null;
        } catch (IOException e11) {
            e = e11;
        }
        synchronized (this) {
            try {
                if (this.f49093d.isEmpty()) {
                    aVarArr = null;
                } else {
                    aVarArr = (com.squareup.okhttp.internal.framed.a[]) this.f49093d.values().toArray(new com.squareup.okhttp.internal.framed.a[this.f49093d.size()]);
                    this.f49093d.clear();
                    t0(false);
                }
                Map<Integer, g> map = this.f49100l;
                if (map != null) {
                    g[] gVarArr2 = (g[]) map.values().toArray(new g[this.f49100l.size()]);
                    this.f49100l = null;
                    gVarArr = gVarArr2;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (aVarArr != null) {
            for (com.squareup.okhttp.internal.framed.a aVar : aVarArr) {
                try {
                    aVar.l(errorCode2);
                } catch (IOException e12) {
                    if (e != null) {
                        e = e12;
                    }
                }
            }
        }
        if (gVarArr != null) {
            for (g gVar : gVarArr) {
                gVar.a();
            }
        }
        try {
            this.f49110v.close();
        } catch (IOException e13) {
            if (e == null) {
                e = e13;
            }
        }
        try {
            this.f49109u.close();
        } catch (IOException e14) {
            e = e14;
        }
        if (e != null) {
            throw e;
        }
    }

    public Protocol Z() {
        return this.f49090a;
    }

    public synchronized com.squareup.okhttp.internal.framed.a b0(int i11) {
        return this.f49093d.get(Integer.valueOf(i11));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        W(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    public synchronized int d0() {
        return this.f49106r.f(Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public final com.squareup.okhttp.internal.framed.a e0(int i11, List<com.squareup.okhttp.internal.framed.b> list, boolean z11, boolean z12) throws IOException {
        int i12;
        com.squareup.okhttp.internal.framed.a aVar;
        boolean z13 = !z11;
        boolean z14 = !z12;
        synchronized (this.f49110v) {
            try {
                synchronized (this) {
                    try {
                        if (this.f49097i) {
                            throw new IOException("shutdown");
                        }
                        i12 = this.f49096h;
                        this.f49096h = i12 + 2;
                        aVar = new com.squareup.okhttp.internal.framed.a(i12, this, z13, z14, list);
                        if (aVar.t()) {
                            this.f49093d.put(Integer.valueOf(i12), aVar);
                            t0(false);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (i11 == 0) {
                    this.f49110v.synStream(z13, z14, i12, i11, list);
                } else {
                    if (this.f49091b) {
                        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                    }
                    this.f49110v.pushPromise(i11, i12, list);
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (!z11) {
            this.f49110v.flush();
        }
        return aVar;
    }

    public void flush() throws IOException {
        this.f49110v.flush();
    }

    public com.squareup.okhttp.internal.framed.a g0(List<com.squareup.okhttp.internal.framed.b> list, boolean z11, boolean z12) throws IOException {
        return e0(0, list, z11, z12);
    }

    public final void h0(final int i11, BufferedSource bufferedSource, final int i12, final boolean z11) throws IOException {
        final Buffer buffer = new Buffer();
        long j11 = i12;
        bufferedSource.require(j11);
        bufferedSource.read(buffer, j11);
        if (buffer.size() == j11) {
            this.f49099k.execute(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.f49094f, Integer.valueOf(i11)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.6
                @Override // com.squareup.okhttp.internal.NamedRunnable
                public void execute() {
                    try {
                        boolean zOnData = FramedConnection.this.f49101m.onData(i11, buffer, i12, z11);
                        if (zOnData) {
                            FramedConnection.this.f49110v.rstStream(i11, ErrorCode.CANCEL);
                        }
                        if (zOnData || z11) {
                            synchronized (FramedConnection.this) {
                                try {
                                    FramedConnection.this.f49112x.remove(Integer.valueOf(i11));
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(buffer.size() + " != " + i12);
    }

    public final void i0(final int i11, final List<com.squareup.okhttp.internal.framed.b> list, final boolean z11) {
        this.f49099k.execute(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.f49094f, Integer.valueOf(i11)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.5
            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void execute() {
                boolean zOnHeaders = FramedConnection.this.f49101m.onHeaders(i11, list, z11);
                if (zOnHeaders) {
                    try {
                        FramedConnection.this.f49110v.rstStream(i11, ErrorCode.CANCEL);
                    } catch (IOException unused) {
                        return;
                    }
                }
                if (zOnHeaders || z11) {
                    synchronized (FramedConnection.this) {
                        FramedConnection.this.f49112x.remove(Integer.valueOf(i11));
                    }
                }
            }
        });
    }

    public final void j0(final int i11, final List<com.squareup.okhttp.internal.framed.b> list) {
        synchronized (this) {
            try {
                if (this.f49112x.contains(Integer.valueOf(i11))) {
                    z0(i11, ErrorCode.PROTOCOL_ERROR);
                } else {
                    this.f49112x.add(Integer.valueOf(i11));
                    this.f49099k.execute(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[]{this.f49094f, Integer.valueOf(i11)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.4
                        @Override // com.squareup.okhttp.internal.NamedRunnable
                        public void execute() {
                            if (FramedConnection.this.f49101m.onRequest(i11, list)) {
                                try {
                                    FramedConnection.this.f49110v.rstStream(i11, ErrorCode.CANCEL);
                                    synchronized (FramedConnection.this) {
                                        FramedConnection.this.f49112x.remove(Integer.valueOf(i11));
                                    }
                                } catch (IOException unused) {
                                }
                            }
                        }
                    });
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void k0(final int i11, final ErrorCode errorCode) {
        this.f49099k.execute(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.f49094f, Integer.valueOf(i11)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.7
            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void execute() {
                FramedConnection.this.f49101m.onReset(i11, errorCode);
                synchronized (FramedConnection.this) {
                    FramedConnection.this.f49112x.remove(Integer.valueOf(i11));
                }
            }
        });
    }

    public final boolean l0(int i11) {
        return this.f49090a == Protocol.HTTP_2 && i11 != 0 && (i11 & 1) == 0;
    }

    public final synchronized g p0(int i11) {
        Map<Integer, g> map;
        map = this.f49100l;
        return map != null ? map.remove(Integer.valueOf(i11)) : null;
    }

    public synchronized com.squareup.okhttp.internal.framed.a q0(int i11) {
        com.squareup.okhttp.internal.framed.a aVarRemove;
        try {
            aVarRemove = this.f49093d.remove(Integer.valueOf(i11));
            if (aVarRemove != null && this.f49093d.isEmpty()) {
                t0(true);
            }
            notifyAll();
        } catch (Throwable th2) {
            throw th2;
        }
        return aVarRemove;
    }

    public void s0() throws IOException {
        this.f49110v.connectionPreface();
        this.f49110v.settings(this.f49105q);
        int iE = this.f49105q.e(65536);
        if (iE != 65536) {
            this.f49110v.windowUpdate(0, iE - 65536);
        }
    }

    public final synchronized void t0(boolean z11) {
        long jNanoTime;
        if (z11) {
            try {
                jNanoTime = System.nanoTime();
            } catch (Throwable th2) {
                throw th2;
            }
        } else {
            jNanoTime = Long.MAX_VALUE;
        }
        this.f49098j = jNanoTime;
    }

    public void u0(ErrorCode errorCode) throws IOException {
        synchronized (this.f49110v) {
            synchronized (this) {
                if (this.f49097i) {
                    return;
                }
                this.f49097i = true;
                this.f49110v.goAway(this.f49095g, errorCode, com.squareup.okhttp.internal.g.f49214a);
            }
        }
    }

    public void v0(int i11, boolean z11, Buffer buffer, long j11) throws IOException {
        long j12;
        int iMin;
        long j13;
        if (j11 == 0) {
            this.f49110v.data(z11, i11, buffer, 0);
            return;
        }
        while (j11 > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        try {
                            j12 = this.f49104p;
                            if (j12 <= 0) {
                                if (!this.f49093d.containsKey(Integer.valueOf(i11))) {
                                    throw new IOException("stream closed");
                                }
                                wait();
                            }
                        } catch (InterruptedException unused) {
                            throw new InterruptedIOException();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                iMin = Math.min((int) Math.min(j11, j12), this.f49110v.maxDataLength());
                j13 = iMin;
                this.f49104p -= j13;
            }
            j11 -= j13;
            this.f49110v.data(z11 && j11 == 0, i11, buffer, iMin);
        }
    }

    public final void w0(boolean z11, int i11, int i12, g gVar) throws IOException {
        synchronized (this.f49110v) {
            if (gVar != null) {
                try {
                    gVar.c();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            this.f49110v.ping(z11, i11, i12);
        }
    }

    public final void x0(final boolean z11, final int i11, final int i12, final g gVar) {
        f49089y.execute(new NamedRunnable("OkHttp %s ping %08x%08x", new Object[]{this.f49094f, Integer.valueOf(i11), Integer.valueOf(i12)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.3
            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void execute() {
                try {
                    FramedConnection.this.w0(z11, i11, i12, gVar);
                } catch (IOException unused) {
                }
            }
        });
    }

    public void y0(int i11, ErrorCode errorCode) throws IOException {
        this.f49110v.rstStream(i11, errorCode);
    }

    public void z0(final int i11, final ErrorCode errorCode) {
        f49089y.submit(new NamedRunnable("OkHttp %s stream %d", new Object[]{this.f49094f, Integer.valueOf(i11)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.1
            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void execute() {
                try {
                    FramedConnection.this.y0(i11, errorCode);
                } catch (IOException unused) {
                }
            }
        });
    }
}
