package com.transsion.transfer.androidasync.http;

import android.net.Uri;
import android.text.TextUtils;
import com.transsion.transfer.androidasync.AsyncSSLSocketWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class n extends t {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SSLContext f58709j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TrustManager[] f58710k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public HostnameVerifier f58711l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<m> f58712m;

    /* JADX INFO: compiled from: source.java */
    public class a implements AsyncSSLSocketWrapper.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ fy.b f58713a;

        public a(fy.b bVar) {
            this.f58713a = bVar;
        }

        @Override // com.transsion.transfer.androidasync.AsyncSSLSocketWrapper.g
        public void a(Exception exc, com.transsion.transfer.androidasync.b bVar) {
            this.f58713a.a(exc, bVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements fy.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ fy.b f58715a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f58716b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ g.a f58717c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Uri f58718d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f58719e;

        /* JADX INFO: compiled from: source.java */
        public class a implements fy.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.transsion.transfer.androidasync.l f58721a;

            /* JADX INFO: renamed from: com.transsion.transfer.androidasync.http.n$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            public class C0600a implements com.transsion.transfer.androidasync.x.a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public String f58723a;

                public C0600a() {
                }

                @Override // com.transsion.transfer.androidasync.x.a
                public void a(String str) {
                    b.this.f58717c.f58669b.u(str);
                    if (this.f58723a != null) {
                        if (TextUtils.isEmpty(str.trim())) {
                            a.this.f58721a.o(null);
                            a.this.f58721a.A(null);
                            a aVar = a.this;
                            b bVar = b.this;
                            n.this.E(aVar.f58721a, bVar.f58717c, bVar.f58718d, bVar.f58719e, bVar.f58715a);
                            return;
                        }
                        return;
                    }
                    String strTrim = str.trim();
                    this.f58723a = strTrim;
                    if (strTrim.matches("HTTP/1.\\d 2\\d\\d .*")) {
                        return;
                    }
                    a.this.f58721a.o(null);
                    a.this.f58721a.A(null);
                    b.this.f58715a.a(new IOException("non 2xx status line: " + this.f58723a), a.this.f58721a);
                }
            }

            /* JADX INFO: renamed from: com.transsion.transfer.androidasync.http.n$b$a$b, reason: collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            public class C0601b implements fy.a {
                public C0601b() {
                }

                @Override // fy.a
                public void i(Exception exc) {
                    if (!a.this.f58721a.isOpen() && exc == null) {
                        exc = new IOException("socket closed before proxy connect response");
                    }
                    a aVar = a.this;
                    b.this.f58715a.a(exc, aVar.f58721a);
                }
            }

            public a(com.transsion.transfer.androidasync.l lVar) {
                this.f58721a = lVar;
            }

            @Override // fy.a
            public void i(Exception exc) {
                if (exc != null) {
                    b.this.f58715a.a(exc, this.f58721a);
                    return;
                }
                com.transsion.transfer.androidasync.x xVar = new com.transsion.transfer.androidasync.x();
                xVar.a(new C0600a());
                this.f58721a.o(xVar);
                this.f58721a.A(new C0601b());
            }
        }

        public b(fy.b bVar, boolean z11, g.a aVar, Uri uri, int i11) {
            this.f58715a = bVar;
            this.f58716b = z11;
            this.f58717c = aVar;
            this.f58718d = uri;
            this.f58719e = i11;
        }

        @Override // fy.b
        public void a(Exception exc, com.transsion.transfer.androidasync.l lVar) {
            if (exc != null) {
                this.f58715a.a(exc, lVar);
                return;
            }
            if (!this.f58716b) {
                n.this.E(lVar, this.f58717c, this.f58718d, this.f58719e, this.f58715a);
                return;
            }
            String str = String.format(Locale.ENGLISH, "CONNECT %s:%s HTTP/1.1\r\nHost: %s\r\n\r\n", this.f58718d.getHost(), Integer.valueOf(this.f58719e), this.f58718d.getHost());
            this.f58717c.f58669b.u("Proxying: " + str);
            com.transsion.transfer.androidasync.c0.h(lVar, str.getBytes(), new a(lVar));
        }
    }

    public n(AsyncHttpClient asyncHttpClient) {
        super(asyncHttpClient, "https", 443);
        this.f58712m = new ArrayList();
    }

    public void A(m mVar) {
        this.f58712m.add(mVar);
    }

    public SSLEngine B(g.a aVar, String str, int i11) {
        SSLContext sSLContextD = D();
        Iterator<m> it = this.f58712m.iterator();
        SSLEngine sSLEngineA = null;
        while (it.hasNext() && (sSLEngineA = it.next().a(sSLContextD, str, i11)) == null) {
        }
        Iterator<m> it2 = this.f58712m.iterator();
        while (it2.hasNext()) {
            it2.next().b(sSLEngineA, aVar, str, i11);
        }
        return sSLEngineA;
    }

    public AsyncSSLSocketWrapper.g C(g.a aVar, fy.b bVar) {
        return new a(bVar);
    }

    public SSLContext D() {
        SSLContext sSLContext = this.f58709j;
        return sSLContext != null ? sSLContext : AsyncSSLSocketWrapper.q();
    }

    public void E(com.transsion.transfer.androidasync.l lVar, g.a aVar, Uri uri, int i11, fy.b bVar) {
        AsyncSSLSocketWrapper.v(lVar, uri.getHost(), i11, B(aVar, uri.getHost(), i11), this.f58710k, this.f58711l, true, C(aVar, bVar));
    }

    @Override // com.transsion.transfer.androidasync.http.t
    public fy.b z(g.a aVar, Uri uri, int i11, boolean z11, fy.b bVar) {
        return new b(bVar, z11, aVar, uri, i11);
    }
}
