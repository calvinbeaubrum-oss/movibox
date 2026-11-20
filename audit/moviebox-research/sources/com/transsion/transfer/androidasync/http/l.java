package com.transsion.transfer.androidasync.http;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.transsion.transfer.androidasync.AsyncServer;
import com.transsion.transfer.androidasync.ByteBufferList;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class l extends com.transsion.transfer.androidasync.v implements k, g.i {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public j f58697h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.transsion.transfer.androidasync.l f58698i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Headers f58699j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f58701l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f58702m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f58703n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.transsion.transfer.androidasync.u f58705p;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public fy.a f58696g = new b();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f58700k = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f58704o = true;

    /* JADX INFO: compiled from: source.java */
    public class a implements fy.a {
        public a() {
        }

        @Override // fy.a
        public void i(Exception exc) {
            l.this.Q(exc);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements fy.a {
        public b() {
        }

        @Override // fy.a
        public void i(Exception exc) {
            if (l.this.g() == null) {
                l.this.L(new ConnectionClosedException("connection closed before headers received.", exc));
                return;
            }
            if (exc != null) {
                l lVar = l.this;
                if (!lVar.f58700k) {
                    lVar.L(new ConnectionClosedException("connection closed before response completed.", exc));
                    return;
                }
            }
            l.this.L(exc);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends fy.d.a {
        public c() {
        }

        @Override // fy.d.a, fy.d
        public void D(com.transsion.transfer.androidasync.r rVar, ByteBufferList byteBufferList) {
            super.D(rVar, byteBufferList);
            l.this.f58698i.close();
        }
    }

    public l(j jVar) {
        this.f58697h = jVar;
    }

    @Override // com.transsion.transfer.androidasync.http.g.i
    public com.transsion.transfer.androidasync.u F() {
        return this.f58705p;
    }

    @Override // com.transsion.transfer.androidasync.s
    public void L(Exception exc) {
        super.L(exc);
        S();
        this.f58698i.p(null);
        this.f58698i.y(null);
        this.f58698i.A(null);
        this.f58700k = true;
    }

    public void O() {
    }

    public void P() {
        gy.a aVarE = this.f58697h.e();
        if (aVarE != null) {
            aVarE.H(this.f58697h, this.f58705p, new a());
        } else {
            Q(null);
        }
    }

    public abstract void Q(Exception exc);

    public void R(com.transsion.transfer.androidasync.l lVar) {
        this.f58698i = lVar;
        if (lVar == null) {
            return;
        }
        lVar.A(this.f58696g);
    }

    public final void S() {
        this.f58698i.o(new c());
    }

    @Override // com.transsion.transfer.androidasync.v, com.transsion.transfer.androidasync.r, com.transsion.transfer.androidasync.u
    public AsyncServer a() {
        return this.f58698i.a();
    }

    @Override // com.transsion.transfer.androidasync.http.k, com.transsion.transfer.androidasync.http.g.i
    public int b() {
        return this.f58701l;
    }

    @Override // com.transsion.transfer.androidasync.v, com.transsion.transfer.androidasync.r
    public void close() {
        super.close();
        S();
    }

    @Override // com.transsion.transfer.androidasync.http.g.i
    public g.i d(int i11) {
        this.f58701l = i11;
        return this;
    }

    @Override // com.transsion.transfer.androidasync.http.k, com.transsion.transfer.androidasync.http.g.i
    public Headers g() {
        return this.f58699j;
    }

    @Override // com.transsion.transfer.androidasync.http.g.i
    public g.i h(com.transsion.transfer.androidasync.u uVar) {
        this.f58705p = uVar;
        return this;
    }

    @Override // com.transsion.transfer.androidasync.http.g.i
    public g.i l(String str) {
        this.f58702m = str;
        return this;
    }

    @Override // com.transsion.transfer.androidasync.http.g.i
    public g.i n(com.transsion.transfer.androidasync.r rVar) {
        M(rVar);
        return this;
    }

    @Override // com.transsion.transfer.androidasync.http.g.i
    public String protocol() {
        return this.f58702m;
    }

    @Override // com.transsion.transfer.androidasync.http.g.i
    public g.i r(String str) {
        this.f58703n = str;
        return this;
    }

    @Override // com.transsion.transfer.androidasync.v, com.transsion.transfer.androidasync.r
    public String s() {
        String string;
        Multimap semicolonDelimited = Multimap.parseSemicolonDelimited(g().c(HttpHeaders.CONTENT_TYPE));
        if (semicolonDelimited == null || (string = semicolonDelimited.getString("charset")) == null || !Charset.isSupported(string)) {
            return null;
        }
        return string;
    }

    @Override // com.transsion.transfer.androidasync.http.g.i
    public com.transsion.transfer.androidasync.l socket() {
        return this.f58698i;
    }

    public String toString() {
        Headers headers = this.f58699j;
        if (headers == null) {
            return super.toString();
        }
        return headers.g(this.f58702m + " " + this.f58701l + " " + this.f58703n);
    }

    @Override // com.transsion.transfer.androidasync.http.g.i
    public g.i v(Headers headers) {
        this.f58699j = headers;
        return this;
    }
}
