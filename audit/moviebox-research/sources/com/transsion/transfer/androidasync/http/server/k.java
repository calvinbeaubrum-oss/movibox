package com.transsion.transfer.androidasync.http.server;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.transfer.androidasync.AsyncServer;
import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.c0;
import com.transsion.transfer.androidasync.http.Headers;
import com.transsion.transfer.androidasync.http.HttpUtil;
import com.transsion.transfer.androidasync.http.Protocol;
import com.transsion.transfer.androidasync.u;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class k implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public fy.e f58783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.transsion.transfer.androidasync.l f58784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f58785e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public u f58787g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public fy.j f58788h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f58789i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f58790j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public fy.a f58793m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Headers f58781a = new Headers();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f58782b = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f58786f = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f58791k = 200;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f58792l = "HTTP/1.1";

    public k(com.transsion.transfer.androidasync.l lVar, c cVar) {
        this.f58784d = lVar;
        this.f58785e = cVar;
        if (HttpUtil.d(Protocol.HTTP_1_1, cVar.getHeaders())) {
            this.f58781a.f("Connection", "Keep-Alive");
        }
    }

    public final /* synthetic */ void A(InputStream inputStream, Exception exc) {
        com.transsion.transfer.androidasync.util.e.a(inputStream);
        D();
    }

    public final /* synthetic */ void B(final InputStream inputStream) {
        c0.e(inputStream, this.f58782b, this, new fy.a() { // from class: com.transsion.transfer.androidasync.http.server.i
            @Override // fy.a
            public final void i(Exception exc) {
                this.f58778a.A(inputStream, exc);
            }
        }, this.f58783c);
    }

    @Override // com.transsion.transfer.androidasync.http.server.d
    public String C() {
        return this.f58792l;
    }

    public void D() {
        this.f58790j = true;
    }

    public void F(Exception exc) {
    }

    public void G(final String str, final ByteBufferList byteBufferList) {
        a().D(new Runnable() { // from class: com.transsion.transfer.androidasync.http.server.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f58774a.w(byteBufferList, str);
            }
        });
    }

    public void H(String str, String str2) {
        try {
            J(str, str2.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e11) {
            throw new AssertionError(e11);
        }
    }

    public void J(String str, byte[] bArr) {
        G(str, new ByteBufferList(bArr));
    }

    public void K(final InputStream inputStream, long j11) {
        long j12;
        long j13 = j11 - 1;
        String strC = this.f58785e.getHeaders().c("Range");
        if (strC != null) {
            String[] strArrSplit = strC.split("=");
            if (strArrSplit.length != 2 || !"bytes".equals(strArrSplit[0])) {
                d(TTAdConstant.PACKAGE_NAME_CODE);
                f();
                return;
            }
            String[] strArrSplit2 = strArrSplit[1].split("-");
            try {
                if (strArrSplit2.length > 2) {
                    throw new MalformedRangeException();
                }
                long j14 = !TextUtils.isEmpty(strArrSplit2[0]) ? Long.parseLong(strArrSplit2[0]) : 0L;
                if (strArrSplit2.length == 2 && !TextUtils.isEmpty(strArrSplit2[1])) {
                    j13 = Long.parseLong(strArrSplit2[1]);
                }
                d(206);
                getHeaders().f("Content-Range", String.format(Locale.ENGLISH, "bytes %d-%d/%d", Long.valueOf(j14), Long.valueOf(j13), Long.valueOf(j11)));
                j12 = j14;
            } catch (Exception unused) {
                d(TTAdConstant.PACKAGE_NAME_CODE);
                f();
                return;
            }
        } else {
            j12 = 0;
        }
        try {
            if (j12 != inputStream.skip(j12)) {
                throw new StreamSkipException("skip failed to skip requested amount");
            }
            long j15 = (j13 - j12) + 1;
            this.f58782b = j15;
            this.f58781a.f(HttpHeaders.CONTENT_LENGTH, String.valueOf(j15));
            this.f58781a.f("Accept-Ranges", "bytes");
            if (this.f58785e.getMethod().equals("HEAD")) {
                u();
                D();
            } else {
                if (this.f58782b != 0) {
                    a().D(new Runnable() { // from class: com.transsion.transfer.androidasync.http.server.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f58770a.B(inputStream);
                        }
                    });
                    return;
                }
                u();
                com.transsion.transfer.androidasync.util.e.a(inputStream);
                D();
            }
        } catch (Exception unused2) {
            d(500);
            f();
        }
    }

    @Override // com.transsion.transfer.androidasync.u
    public AsyncServer a() {
        return this.f58784d.a();
    }

    @Override // com.transsion.transfer.androidasync.http.server.d
    public int b() {
        return this.f58791k;
    }

    @Override // com.transsion.transfer.androidasync.http.server.d
    public d d(int i11) {
        this.f58791k = i11;
        return this;
    }

    @Override // com.transsion.transfer.androidasync.http.server.d, com.transsion.transfer.androidasync.u
    public void f() {
        if (this.f58789i) {
            return;
        }
        this.f58789i = true;
        boolean z11 = this.f58786f;
        if (z11 && this.f58787g == null) {
            return;
        }
        if (!z11) {
            this.f58781a.d("Transfer-Encoding");
        }
        u uVar = this.f58787g;
        if (uVar instanceof iy.a) {
            uVar.f();
            return;
        }
        if (this.f58786f) {
            D();
        } else if (!this.f58785e.getMethod().equalsIgnoreCase("HEAD")) {
            H("text/html", "");
        } else {
            u();
            D();
        }
    }

    @Override // com.transsion.transfer.androidasync.http.server.d
    public Headers getHeaders() {
        return this.f58781a;
    }

    @Override // fy.a
    public void i(Exception exc) {
        f();
    }

    @Override // com.transsion.transfer.androidasync.u
    public fy.j k() {
        u uVar = this.f58787g;
        return uVar != null ? uVar.k() : this.f58788h;
    }

    @Override // com.transsion.transfer.androidasync.u
    public void m(ByteBufferList byteBufferList) {
        u uVar;
        if (!this.f58786f) {
            o();
        }
        if (byteBufferList.C() == 0 || (uVar = this.f58787g) == null) {
            return;
        }
        uVar.m(byteBufferList);
    }

    public b n() {
        return this.f58785e;
    }

    public void o() {
        final boolean z11;
        if (this.f58786f) {
            return;
        }
        this.f58786f = true;
        String strC = this.f58781a.c("Transfer-Encoding");
        if ("".equals(strC)) {
            this.f58781a.e("Transfer-Encoding");
        }
        boolean z12 = ("Chunked".equalsIgnoreCase(strC) || strC == null) && !CampaignEx.JSON_NATIVE_VIDEO_CLOSE.equalsIgnoreCase(this.f58781a.c("Connection"));
        if (this.f58782b < 0) {
            String strC2 = this.f58781a.c(HttpHeaders.CONTENT_LENGTH);
            if (!TextUtils.isEmpty(strC2)) {
                this.f58782b = Long.valueOf(strC2).longValue();
            }
        }
        if (this.f58782b >= 0 || !z12) {
            z11 = false;
        } else {
            this.f58781a.f("Transfer-Encoding", "Chunked");
            z11 = true;
        }
        c0.h(this.f58784d, this.f58781a.g(String.format(Locale.ENGLISH, "%s %s %s", this.f58792l, Integer.valueOf(this.f58791k), AsyncHttpServer.l(this.f58791k))).getBytes(), new fy.a() { // from class: com.transsion.transfer.androidasync.http.server.f
            @Override // fy.a
            public final void i(Exception exc) {
                this.f58772a.s(z11, exc);
            }
        });
    }

    @Override // com.transsion.transfer.androidasync.u
    public void p(fy.j jVar) {
        u uVar = this.f58787g;
        if (uVar != null) {
            uVar.p(jVar);
        } else {
            this.f58788h = jVar;
        }
    }

    public final /* synthetic */ void r() {
        fy.j jVarK = k();
        if (jVarK != null) {
            jVarK.a();
        }
    }

    public final /* synthetic */ void s(boolean z11, Exception exc) {
        if (exc != null) {
            F(exc);
            return;
        }
        if (z11) {
            iy.a aVar = new iy.a(this.f58784d);
            aVar.n(0);
            this.f58787g = aVar;
        } else {
            this.f58787g = this.f58784d;
        }
        this.f58787g.y(this.f58793m);
        this.f58793m = null;
        this.f58787g.p(this.f58788h);
        this.f58788h = null;
        if (this.f58789i) {
            f();
        } else {
            a().D(new Runnable() { // from class: com.transsion.transfer.androidasync.http.server.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f58777a.r();
                }
            });
        }
    }

    @Override // com.transsion.transfer.androidasync.http.server.d
    public void send(String str) {
        String strC = this.f58781a.c(HttpHeaders.CONTENT_TYPE);
        if (strC == null) {
            strC = "text/html; charset=utf-8";
        }
        H(strC, str);
    }

    public String toString() {
        return this.f58781a == null ? super.toString() : this.f58781a.g(String.format(Locale.ENGLISH, "%s %s %s", this.f58792l, Integer.valueOf(this.f58791k), AsyncHttpServer.l(this.f58791k)));
    }

    @Override // com.transsion.transfer.androidasync.http.server.d
    public void u() {
        o();
    }

    public final /* synthetic */ void v(Exception exc) {
        D();
    }

    public final /* synthetic */ void w(ByteBufferList byteBufferList, String str) {
        long jC = byteBufferList.C();
        this.f58782b = jC;
        this.f58781a.f(HttpHeaders.CONTENT_LENGTH, Long.toString(jC));
        if (str != null) {
            this.f58781a.f(HttpHeaders.CONTENT_TYPE, str);
        }
        c0.g(this, byteBufferList, new fy.a() { // from class: com.transsion.transfer.androidasync.http.server.j
            @Override // fy.a
            public final void i(Exception exc) {
                this.f58780a.v(exc);
            }
        });
    }

    @Override // com.transsion.transfer.androidasync.u
    public void y(fy.a aVar) {
        u uVar = this.f58787g;
        if (uVar != null) {
            uVar.y(aVar);
        } else {
            this.f58793m = aVar;
        }
    }

    @Override // com.transsion.transfer.androidasync.http.server.d
    public void z(File file, fy.e eVar) {
        try {
            this.f58783c = eVar;
            if (this.f58781a.c(HttpHeaders.CONTENT_TYPE) == null) {
                this.f58781a.f(HttpHeaders.CONTENT_TYPE, n.g(file.getAbsolutePath()));
            }
            K(new BufferedInputStream(new FileInputStream(file), 64000), file.length());
        } catch (FileNotFoundException unused) {
            d(404);
            f();
        }
    }
}
