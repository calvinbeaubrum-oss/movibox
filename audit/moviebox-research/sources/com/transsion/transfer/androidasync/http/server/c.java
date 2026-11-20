package com.transsion.transfer.androidasync.http.server;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.transsion.transfer.androidasync.http.Headers;
import com.transsion.transfer.androidasync.http.HttpUtil;
import com.transsion.transfer.androidasync.http.Protocol;
import com.transsion.transfer.androidasync.v;
import com.transsion.transfer.androidasync.x;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class c extends v implements com.transsion.transfer.androidasync.http.server.b, fy.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f58760g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.transsion.transfer.androidasync.l f58762i;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f58766m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public gy.a f58767n;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Headers f58761h = new Headers();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public HashMap<String, Object> f58763j = new HashMap<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public fy.a f58764k = new a();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public x.a f58765l = new b();

    /* JADX INFO: compiled from: source.java */
    public class a implements fy.a {
        public a() {
        }

        @Override // fy.a
        public void i(Exception exc) {
            c.this.i(exc);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements x.a {
        public b() {
        }

        @Override // com.transsion.transfer.androidasync.x.a
        public void a(String str) {
            if (c.this.f58760g == null) {
                c.this.f58760g = str;
                if (c.this.f58760g.contains("HTTP/")) {
                    return;
                }
                c.this.V();
                c.this.f58762i.o(new fy.d.a());
                c.this.L(new IOException("data/header received was not not http"));
                return;
            }
            if (!"\r".equals(str)) {
                c.this.f58761h.b(str);
                return;
            }
            c cVar = c.this;
            com.transsion.transfer.androidasync.r rVarC = HttpUtil.c(cVar.f58762i, Protocol.HTTP_1_1, cVar.f58761h, true);
            c cVar2 = c.this;
            cVar2.f58767n = cVar2.T(cVar2.f58761h);
            c cVar3 = c.this;
            if (cVar3.f58767n == null) {
                cVar3.f58767n = HttpUtil.b(rVarC, cVar3.f58764k, c.this.f58761h);
                c cVar4 = c.this;
                if (cVar4.f58767n == null) {
                    cVar4.f58767n = cVar4.W(cVar4.f58761h);
                    c cVar5 = c.this;
                    if (cVar5.f58767n == null) {
                        cVar5.f58767n = new t(cVar5.f58761h.c(HttpHeaders.CONTENT_TYPE));
                    }
                }
            }
            c cVar6 = c.this;
            cVar6.f58767n.B(rVarC, cVar6.f58764k);
            c.this.U();
        }
    }

    @Override // com.transsion.transfer.androidasync.s, com.transsion.transfer.androidasync.r
    public fy.d G() {
        return this.f58762i.G();
    }

    public String S() {
        return this.f58760g;
    }

    public abstract gy.a T(Headers headers);

    public abstract void U();

    public void V() {
        System.out.println("not http!");
    }

    public abstract gy.a W(Headers headers);

    public void X(com.transsion.transfer.androidasync.l lVar) {
        this.f58762i = lVar;
        x xVar = new x();
        this.f58762i.o(xVar);
        xVar.a(this.f58765l);
        this.f58762i.A(new fy.a.C0680a());
    }

    @Override // com.transsion.transfer.androidasync.v, com.transsion.transfer.androidasync.r
    public boolean e() {
        return this.f58762i.e();
    }

    @Override // com.transsion.transfer.androidasync.http.server.b
    public gy.a getBody() {
        return this.f58767n;
    }

    @Override // com.transsion.transfer.androidasync.http.server.b
    public Headers getHeaders() {
        return this.f58761h;
    }

    @Override // com.transsion.transfer.androidasync.http.server.b
    public String getMethod() {
        return this.f58766m;
    }

    @Override // com.transsion.transfer.androidasync.http.server.b
    public com.transsion.transfer.androidasync.l getSocket() {
        return this.f58762i;
    }

    public void i(Exception exc) {
        L(exc);
    }

    @Override // com.transsion.transfer.androidasync.s, com.transsion.transfer.androidasync.r
    public void o(fy.d dVar) {
        this.f58762i.o(dVar);
    }

    @Override // com.transsion.transfer.androidasync.v, com.transsion.transfer.androidasync.r
    public void pause() {
        this.f58762i.pause();
    }

    @Override // com.transsion.transfer.androidasync.v, com.transsion.transfer.androidasync.r
    public void resume() {
        this.f58762i.resume();
    }

    public String toString() {
        Headers headers = this.f58761h;
        return headers == null ? super.toString() : headers.g(this.f58760g);
    }
}
