package com.transsion.transfer.androidasync.http.server;

import android.annotation.TargetApi;
import android.util.Log;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.logging.type.LogSeverity;
import com.transsion.transfer.androidasync.AsyncServer;
import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.c0;
import com.transsion.transfer.androidasync.http.Headers;
import com.transsion.transfer.androidasync.http.HttpUtil;
import com.transsion.transfer.androidasync.http.Multimap;
import com.transsion.transfer.androidasync.http.d0;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@TargetApi(5)
public class AsyncHttpServer extends n {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Hashtable<Integer, String> f58741h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<com.transsion.transfer.androidasync.k> f58742e = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public fy.f f58743f = new AnonymousClass1();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public fy.a f58744g;

    /* JADX INFO: renamed from: com.transsion.transfer.androidasync.http.server.AsyncHttpServer$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public class AnonymousClass1 implements fy.f {

        /* JADX INFO: renamed from: com.transsion.transfer.androidasync.http.server.AsyncHttpServer$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C06021 extends n.a {
            public final fy.i<Exception> A;
            public final /* synthetic */ com.transsion.transfer.androidasync.l B;

            /* JADX INFO: renamed from: q, reason: collision with root package name */
            public n.a f58746q;

            /* JADX INFO: renamed from: r, reason: collision with root package name */
            public r f58747r;

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            public String f58748s;

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            public String f58749t;

            /* JADX INFO: renamed from: u, reason: collision with root package name */
            public boolean f58750u;

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public boolean f58751v;

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public k f58752w;

            /* JADX INFO: renamed from: x, reason: collision with root package name */
            public boolean f58753x;

            /* JADX INFO: renamed from: y, reason: collision with root package name */
            public boolean f58754y;

            /* JADX INFO: renamed from: z, reason: collision with root package name */
            public final Runnable f58755z;

            /* JADX INFO: renamed from: com.transsion.transfer.androidasync.http.server.AsyncHttpServer$1$1$a */
            /* JADX INFO: compiled from: source.java */
            public class a implements fy.i<Exception> {
                public a() {
                }
            }

            /* JADX INFO: renamed from: com.transsion.transfer.androidasync.http.server.AsyncHttpServer$1$1$b */
            /* JADX INFO: compiled from: source.java */
            public class b implements fy.a {
                public b() {
                }

                @Override // fy.a
                public void i(Exception exc) {
                    C06021.this.resume();
                    if (exc != null) {
                        C06021.this.L(exc);
                        return;
                    }
                    C06021 c06021 = C06021.this;
                    c06021.f58753x = true;
                    c06021.U();
                }
            }

            /* JADX INFO: renamed from: com.transsion.transfer.androidasync.http.server.AsyncHttpServer$1$1$c */
            /* JADX INFO: compiled from: source.java */
            public class c extends k {
                public c(com.transsion.transfer.androidasync.l lVar, com.transsion.transfer.androidasync.http.server.c cVar) {
                    super(lVar, cVar);
                }

                @Override // com.transsion.transfer.androidasync.http.server.k
                public void D() {
                    C06021.this.f58750u = true;
                    super.D();
                    this.f58784d.A(null);
                    AsyncHttpServer.this.r(n(), C06021.this.f58752w);
                    C06021.this.a0();
                }

                @Override // com.transsion.transfer.androidasync.http.server.k
                public void F(Exception exc) {
                    super.F(exc);
                    if (exc != null) {
                        C06021.this.B.o(new fy.d.a());
                        C06021.this.B.A(new fy.a.C0680a());
                        C06021.this.B.close();
                    }
                }
            }

            /* JADX INFO: renamed from: com.transsion.transfer.androidasync.http.server.AsyncHttpServer$1$1$d */
            /* JADX INFO: compiled from: source.java */
            public class d extends fy.d.a {
                public d() {
                }

                @Override // fy.d.a, fy.d
                public void D(com.transsion.transfer.androidasync.r rVar, ByteBufferList byteBufferList) {
                    super.D(rVar, byteBufferList);
                    C06021.this.f58762i.close();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C06021(com.transsion.transfer.androidasync.l lVar) {
                super();
                this.B = lVar;
                this.f58746q = this;
                this.f58755z = new Runnable() { // from class: com.transsion.transfer.androidasync.http.server.AsyncHttpServer.1.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                };
                this.A = new a();
            }

            @Override // com.transsion.transfer.androidasync.http.server.c
            public gy.a T(Headers headers) {
                String[] strArrSplit = S().split(" ");
                String str = strArrSplit[1];
                this.f58748s = str;
                String strDecode = URLDecoder.decode(str.split("\\?")[0]);
                this.f58749t = strDecode;
                String str2 = strArrSplit[0];
                this.f58766m = str2;
                n.d dVarA = AsyncHttpServer.this.a(str2, strDecode);
                if (dVarA == null) {
                    return null;
                }
                this.f58800o = dVarA.f58808c;
                this.f58747r = dVarA.f58809d;
                return null;
            }

            @Override // com.transsion.transfer.androidasync.http.server.c
            public void U() {
                Headers headers = getHeaders();
                if (!this.f58753x && "100-continue".equals(headers.c("Expect"))) {
                    pause();
                    c0.h(this.f58762i, "HTTP/1.1 100 Continue\r\n\r\n".getBytes(), new b());
                    return;
                }
                c cVar = new c(this.B, this);
                this.f58752w = cVar;
                boolean zQ = AsyncHttpServer.this.q(this, cVar);
                this.f58754y = zQ;
                if (zQ) {
                    return;
                }
                if (this.f58747r == null) {
                    this.f58752w.d(404);
                    this.f58752w.f();
                } else if (!getBody().J() || this.f58751v) {
                    b0();
                }
            }

            @Override // com.transsion.transfer.androidasync.http.server.c
            public gy.a W(Headers headers) {
                return AsyncHttpServer.this.s(headers);
            }

            public final void a0() {
                if (this.f58751v && this.f58750u && !AsyncHttpServer.this.n(this.f58752w)) {
                    if (AsyncHttpServer.this.m(this.f58746q, this.f58752w)) {
                        AnonymousClass1.this.t(this.B);
                    } else {
                        this.B.close();
                    }
                }
            }

            public void b0() {
                AsyncHttpServer.this.p(this.f58747r, this, this.f58752w);
            }

            @Override // com.transsion.transfer.androidasync.http.server.b
            public String getPath() {
                return this.f58749t;
            }

            @Override // com.transsion.transfer.androidasync.http.server.c, fy.a
            public void i(Exception exc) {
                if (AsyncHttpServer.this.n(this.f58752w)) {
                    return;
                }
                this.f58751v = true;
                super.i(exc);
                this.f58762i.o(new d());
                if (exc != null) {
                    this.f58762i.close();
                    return;
                }
                a0();
                if (!getBody().J() || this.f58754y) {
                    return;
                }
                b0();
            }

            @Override // com.transsion.transfer.androidasync.http.server.b
            public Multimap j() {
                String[] strArrSplit = this.f58748s.split("\\?", 2);
                return strArrSplit.length < 2 ? new Multimap() : Multimap.parseQuery(strArrSplit[1]);
            }
        }

        public AnonymousClass1() {
        }

        @Override // fy.a
        public void i(Exception exc) {
            AsyncHttpServer.this.t(exc);
        }

        @Override // fy.f
        public void q(com.transsion.transfer.androidasync.k kVar) {
            AsyncHttpServer.this.f58742e.add(kVar);
        }

        @Override // fy.f
        public void t(com.transsion.transfer.androidasync.l lVar) {
            new C06021(lVar).X(lVar);
            lVar.resume();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(d0 d0Var, b bVar);
    }

    static {
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        f58741h = hashtable;
        hashtable.put(200, "OK");
        f58741h.put(202, "Accepted");
        f58741h.put(206, "Partial Content");
        f58741h.put(101, "Switching Protocols");
        f58741h.put(301, "Moved Permanently");
        f58741h.put(302, "Found");
        f58741h.put(304, "Not Modified");
        f58741h.put(Integer.valueOf(LogSeverity.WARNING_VALUE), "Bad Request");
        f58741h.put(401, "Unauthorized");
        f58741h.put(404, "Not Found");
        f58741h.put(500, "Internal Server Error");
    }

    public static String l(int i11) {
        String str = f58741h.get(Integer.valueOf(i11));
        return str == null ? "Unknown" : str;
    }

    public boolean m(b bVar, d dVar) {
        return HttpUtil.e(dVar.C(), bVar.getHeaders());
    }

    public boolean n(d dVar) {
        return dVar.b() == 101;
    }

    public com.transsion.transfer.androidasync.k o(AsyncServer asyncServer, int i11) {
        return asyncServer.y(null, i11, this.f58743f);
    }

    public void p(r rVar, b bVar, d dVar) {
        if (rVar != null) {
            try {
                rVar.b(bVar, dVar);
            } catch (Exception e11) {
                Log.e("AsyncHttpServer", "request callback raised uncaught exception. Catching versus crashing process", e11);
                dVar.d(500);
                dVar.f();
            }
        }
    }

    public boolean q(b bVar, d dVar) {
        return false;
    }

    public void r(b bVar, d dVar) {
    }

    public gy.a s(Headers headers) {
        return new t(headers.c(HttpHeaders.CONTENT_TYPE));
    }

    public final void t(Exception exc) {
        fy.a aVar = this.f58744g;
        if (aVar != null) {
            aVar.i(exc);
        }
    }

    public void u() {
        ArrayList<com.transsion.transfer.androidasync.k> arrayList = this.f58742e;
        if (arrayList != null) {
            Iterator<com.transsion.transfer.androidasync.k> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().stop();
            }
        }
    }
}
