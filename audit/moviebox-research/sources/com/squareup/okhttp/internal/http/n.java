package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.ConnectionPool;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.Sink;
import okio.Timeout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Address f49328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConnectionPool f49329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f49330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public jo.a f49331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f49332e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f49333f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HttpStream f49334g;

    public n(ConnectionPool connectionPool, Address address) {
        this.f49329b = connectionPool;
        this.f49328a = address;
    }

    public void a(jo.a aVar) {
        aVar.f68122j.add(new WeakReference(this));
    }

    public void b() {
        HttpStream httpStream;
        jo.a aVar;
        synchronized (this.f49329b) {
            this.f49333f = true;
            httpStream = this.f49334g;
            aVar = this.f49331d;
        }
        if (httpStream != null) {
            httpStream.cancel();
        } else if (aVar != null) {
            aVar.b();
        }
    }

    public synchronized jo.a c() {
        return this.f49331d;
    }

    public void d() {
        f(true, false, true);
    }

    public final void e(IOException iOException) {
        synchronized (this.f49329b) {
            try {
                if (this.f49330c != null) {
                    jo.a aVar = this.f49331d;
                    if (aVar.f68119g == 0) {
                        this.f49330c.a(aVar.getRoute(), iOException);
                    } else {
                        this.f49330c = null;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        d();
    }

    /* JADX WARN: Code duplicated, block: B:30:0x004e  */
    public final void f(boolean z11, boolean z12, boolean z13) {
        jo.a aVar;
        jo.a aVar2;
        synchronized (this.f49329b) {
            aVar = null;
            if (z13) {
                try {
                    this.f49334g = null;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (z12) {
                this.f49332e = true;
            }
            jo.a aVar3 = this.f49331d;
            if (aVar3 != null) {
                if (z11) {
                    aVar3.f68123k = true;
                }
                if (this.f49334g == null && (this.f49332e || aVar3.f68123k)) {
                    p(aVar3);
                    jo.a aVar4 = this.f49331d;
                    if (aVar4.f68119g > 0) {
                        this.f49330c = null;
                    }
                    if (aVar4.f68122j.isEmpty()) {
                        this.f49331d.f68124l = System.nanoTime();
                        if (com.squareup.okhttp.internal.c.instance.connectionBecameIdle(this.f49329b, this.f49331d)) {
                            aVar2 = this.f49331d;
                        } else {
                            aVar2 = null;
                        }
                    } else {
                        aVar2 = null;
                    }
                    this.f49331d = null;
                    aVar = aVar2;
                }
            }
        }
        if (aVar != null) {
            com.squareup.okhttp.internal.g.d(aVar.getSocket());
        }
    }

    public final jo.a g(int i11, int i12, int i13, boolean z11) throws RouteException, IOException {
        synchronized (this.f49329b) {
            try {
                if (this.f49332e) {
                    throw new IllegalStateException("released");
                }
                if (this.f49334g != null) {
                    throw new IllegalStateException("stream != null");
                }
                if (this.f49333f) {
                    throw new IOException("Canceled");
                }
                jo.a aVar = this.f49331d;
                if (aVar != null && !aVar.f68123k) {
                    return aVar;
                }
                jo.a aVar2 = com.squareup.okhttp.internal.c.instance.get(this.f49329b, this.f49328a, this);
                if (aVar2 != null) {
                    this.f49331d = aVar2;
                    return aVar2;
                }
                if (this.f49330c == null) {
                    this.f49330c = new l(this.f49328a, q());
                }
                jo.a aVar3 = new jo.a(this.f49330c.g());
                a(aVar3);
                synchronized (this.f49329b) {
                    com.squareup.okhttp.internal.c.instance.put(this.f49329b, aVar3);
                    this.f49331d = aVar3;
                    if (this.f49333f) {
                        throw new IOException("Canceled");
                    }
                }
                aVar3.c(i11, i12, i13, this.f49328a.getConnectionSpecs(), z11);
                q().a(aVar3.getRoute());
                return aVar3;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final jo.a h(int i11, int i12, int i13, boolean z11, boolean z12) throws RouteException, IOException {
        while (true) {
            jo.a aVarG = g(i11, i12, i13, z11);
            synchronized (this.f49329b) {
                try {
                    if (aVarG.f68119g == 0) {
                        return aVarG;
                    }
                    if (aVarG.h(z12)) {
                        return aVarG;
                    }
                    d();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public final boolean i(RouteException routeException) {
        IOException lastConnectException = routeException.getLastConnectException();
        if (lastConnectException instanceof ProtocolException) {
            return false;
        }
        if (lastConnectException instanceof InterruptedIOException) {
            return lastConnectException instanceof SocketTimeoutException;
        }
        return (((lastConnectException instanceof SSLHandshakeException) && (lastConnectException.getCause() instanceof CertificateException)) || (lastConnectException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    public final boolean j(IOException iOException) {
        return ((iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) ? false : true;
    }

    public HttpStream k(int i11, int i12, int i13, boolean z11, boolean z12) throws RouteException, IOException {
        HttpStream dVar;
        try {
            jo.a aVarH = h(i11, i12, i13, z11, z12);
            if (aVarH.f68118f != null) {
                dVar = new e(this, aVarH.f68118f);
            } else {
                aVarH.getSocket().setSoTimeout(i12);
                Timeout timeout = aVarH.f68120h.timeout();
                long j11 = i12;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                timeout.timeout(j11, timeUnit);
                aVarH.f68121i.timeout().timeout(i13, timeUnit);
                dVar = new d(this, aVarH.f68120h, aVarH.f68121i);
            }
            synchronized (this.f49329b) {
                aVarH.f68119g++;
                this.f49334g = dVar;
            }
            return dVar;
        } catch (IOException e11) {
            throw new RouteException(e11);
        }
    }

    public void l() {
        f(true, false, false);
    }

    public boolean m(RouteException routeException) {
        if (this.f49331d != null) {
            e(routeException.getLastConnectException());
        }
        l lVar = this.f49330c;
        return (lVar == null || lVar.c()) && i(routeException);
    }

    public boolean n(IOException iOException, Sink sink) {
        jo.a aVar = this.f49331d;
        if (aVar != null) {
            int i11 = aVar.f68119g;
            e(iOException);
            if (i11 == 1) {
                return false;
            }
        }
        boolean z11 = sink == null || (sink instanceof k);
        l lVar = this.f49330c;
        return (lVar == null || lVar.c()) && j(iOException) && z11;
    }

    public void o() {
        f(false, true, false);
    }

    public final void p(jo.a aVar) {
        int size = aVar.f68122j.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (aVar.f68122j.get(i11).get() == this) {
                aVar.f68122j.remove(i11);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public final com.squareup.okhttp.internal.f q() {
        return com.squareup.okhttp.internal.c.instance.routeDatabase(this.f49329b);
    }

    public void r(HttpStream httpStream) {
        synchronized (this.f49329b) {
            if (httpStream != null) {
                if (httpStream == this.f49334g) {
                }
            }
            throw new IllegalStateException("expected " + this.f49334g + " but was " + httpStream);
        }
        f(false, false, true);
    }

    public String toString() {
        return this.f49328a.toString();
    }
}
