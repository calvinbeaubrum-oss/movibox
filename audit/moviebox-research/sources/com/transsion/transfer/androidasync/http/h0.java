package com.transsion.transfer.androidasync.http;

import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.transsion.api.gateway.utils.EncoderUtil;
import com.transsion.transfer.androidasync.AsyncServer;
import com.transsion.transfer.androidasync.ByteBufferList;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.LinkedList;
import java.util.UUID;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class h0 implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkedList<ByteBufferList> f58673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.transsion.transfer.androidasync.l f58674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.transsion.transfer.androidasync.p f58675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f58676d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HybiParser f58677e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public fy.a f58678f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d0.c f58679g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public fy.d f58680h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d0.b f58681i;

    /* JADX INFO: compiled from: source.java */
    public class a extends HybiParser {
        public a(com.transsion.transfer.androidasync.r rVar) {
            super(rVar);
        }

        @Override // com.transsion.transfer.androidasync.http.HybiParser
        public void A(String str) {
            h0.l(h0.this);
        }

        @Override // com.transsion.transfer.androidasync.http.HybiParser
        public void B(String str) {
            if (h0.this.f58681i != null) {
                h0.this.f58681i.a(str);
            }
        }

        @Override // com.transsion.transfer.androidasync.http.HybiParser
        public void H(Exception exc) {
            fy.a aVar = h0.this.f58678f;
            if (aVar != null) {
                aVar.i(exc);
            }
        }

        @Override // com.transsion.transfer.androidasync.http.HybiParser
        public void J(byte[] bArr) {
            h0.this.f58675c.m(new ByteBufferList(bArr));
        }

        @Override // com.transsion.transfer.androidasync.http.HybiParser
        public void x(int i11, String str) {
            h0.this.f58674b.close();
        }

        @Override // com.transsion.transfer.androidasync.http.HybiParser
        public void y(String str) {
            if (h0.this.f58679g != null) {
                h0.this.f58679g.a(str);
            }
        }

        @Override // com.transsion.transfer.androidasync.http.HybiParser
        public void z(byte[] bArr) {
            h0.this.B(new ByteBufferList(bArr));
        }
    }

    public h0(com.transsion.transfer.androidasync.http.server.b bVar, com.transsion.transfer.androidasync.http.server.d dVar) {
        this(bVar.getSocket());
        String strV = v(bVar.getHeaders().c("Sec-WebSocket-Key") + WebSocketProtocol.ACCEPT_MAGIC);
        bVar.getHeaders().c("Origin");
        dVar.d(101);
        dVar.getHeaders().f("Upgrade", "WebSocket");
        dVar.getHeaders().f("Connection", "Upgrade");
        dVar.getHeaders().f("Sec-WebSocket-Accept", strV);
        String strC = bVar.getHeaders().c("Sec-WebSocket-Protocol");
        if (!TextUtils.isEmpty(strC)) {
            dVar.getHeaders().f("Sec-WebSocket-Protocol", strC);
        }
        dVar.u();
        M(false, false);
    }

    public h0(com.transsion.transfer.androidasync.l lVar) {
        this.f58674b = lVar;
        this.f58675c = new com.transsion.transfer.androidasync.p(lVar);
    }

    public static void D(j jVar, String... strArr) {
        Headers headersH = jVar.h();
        String strEncodeToString = Base64.encodeToString(N(UUID.randomUUID()), 2);
        headersH.f("Sec-WebSocket-Version", PrepareException.ERROR_WARMUP_DOWNLOAD_EXCEPTION);
        headersH.f("Sec-WebSocket-Key", strEncodeToString);
        headersH.f("Sec-WebSocket-Extensions", "x-webkit-deflate-frame");
        headersH.f("Connection", "Upgrade");
        headersH.f("Upgrade", "websocket");
        if (strArr != null) {
            for (String str : strArr) {
                headersH.a("Sec-WebSocket-Protocol", str);
            }
        }
        headersH.f("Pragma", "no-cache");
        headersH.f(HttpHeaders.CACHE_CONTROL, "no-cache");
        if (TextUtils.isEmpty(jVar.h().c("User-Agent"))) {
            jVar.h().f("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.15 Safari/537.36");
        }
    }

    public static d0 F(Headers headers, k kVar) {
        String strC;
        String strC2;
        if (kVar == null || kVar.b() != 101 || !"websocket".equalsIgnoreCase(kVar.g().c("Upgrade")) || (strC = kVar.g().c("Sec-WebSocket-Accept")) == null || (strC2 = headers.c("Sec-WebSocket-Key")) == null) {
            return null;
        }
        if (!strC.equalsIgnoreCase(v(strC2 + WebSocketProtocol.ACCEPT_MAGIC).trim())) {
            return null;
        }
        String strC3 = headers.c("Sec-WebSocket-Extensions");
        boolean z11 = strC3 != null && strC3.equals("x-webkit-deflate-frame");
        h0 h0Var = new h0(kVar.w());
        h0Var.f58676d = kVar.g().c("Sec-WebSocket-Protocol");
        h0Var.M(true, z11);
        return h0Var;
    }

    public static byte[] N(UUID uuid) {
        byte[] bArr = new byte[16];
        ByteBuffer.wrap(bArr).asLongBuffer().put(new long[]{uuid.getMostSignificantBits(), uuid.getLeastSignificantBits()});
        return bArr;
    }

    public static /* bridge */ /* synthetic */ d0.a l(h0 h0Var) {
        h0Var.getClass();
        return null;
    }

    public static String v(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncoderUtil.ALGORITHM_SHA_1);
            messageDigest.update(str.getBytes("iso-8859-1"), 0, str.length());
            return Base64.encodeToString(messageDigest.digest(), 2);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.transsion.transfer.androidasync.r
    public void A(fy.a aVar) {
        this.f58678f = aVar;
    }

    public final void B(ByteBufferList byteBufferList) {
        if (this.f58673a == null) {
            com.transsion.transfer.androidasync.c0.a(this, byteBufferList);
            if (byteBufferList.C() > 0) {
                LinkedList<ByteBufferList> linkedList = new LinkedList<>();
                this.f58673a = linkedList;
                linkedList.add(byteBufferList);
                return;
            }
            return;
        }
        while (!e()) {
            ByteBufferList byteBufferListRemove = this.f58673a.remove();
            com.transsion.transfer.androidasync.c0.a(this, byteBufferListRemove);
            if (byteBufferListRemove.C() > 0) {
                this.f58673a.add(0, byteBufferListRemove);
            }
        }
        if (this.f58673a.size() == 0) {
            this.f58673a = null;
        }
    }

    @Override // com.transsion.transfer.androidasync.http.d0
    public void E(d0.b bVar) {
        this.f58681i = bVar;
    }

    @Override // com.transsion.transfer.androidasync.r
    public fy.d G() {
        return this.f58680h;
    }

    public final /* synthetic */ void H(String str) {
        this.f58675c.m(new ByteBufferList(ByteBuffer.wrap(this.f58677e.G(str))));
    }

    @Override // com.transsion.transfer.androidasync.http.d0
    public void I(d0.c cVar) {
        this.f58679g = cVar;
    }

    public final /* synthetic */ void J(byte[] bArr) {
        this.f58675c.m(new ByteBufferList(this.f58677e.t(bArr)));
    }

    public final /* synthetic */ void K(String str) {
        this.f58675c.m(new ByteBufferList(this.f58677e.s(str)));
    }

    public void L(final byte[] bArr) {
        a().D(new Runnable() { // from class: com.transsion.transfer.androidasync.http.e0
            @Override // java.lang.Runnable
            public final void run() {
                this.f58651a.J(bArr);
            }
        });
    }

    public final void M(boolean z11, boolean z12) {
        a aVar = new a(this.f58674b);
        this.f58677e = aVar;
        aVar.L(z11);
        this.f58677e.K(z12);
        if (this.f58674b.e()) {
            this.f58674b.resume();
        }
    }

    @Override // com.transsion.transfer.androidasync.l, com.transsion.transfer.androidasync.r, com.transsion.transfer.androidasync.u
    public AsyncServer a() {
        return this.f58674b.a();
    }

    @Override // com.transsion.transfer.androidasync.r
    public void close() {
        this.f58674b.close();
    }

    @Override // com.transsion.transfer.androidasync.r
    public boolean e() {
        return this.f58674b.e();
    }

    @Override // com.transsion.transfer.androidasync.u
    public void f() {
        this.f58674b.f();
    }

    @Override // com.transsion.transfer.androidasync.u
    public boolean isOpen() {
        return this.f58674b.isOpen();
    }

    @Override // com.transsion.transfer.androidasync.u
    public fy.j k() {
        return this.f58675c.k();
    }

    @Override // com.transsion.transfer.androidasync.u
    public void m(ByteBufferList byteBufferList) {
        L(byteBufferList.l());
    }

    @Override // com.transsion.transfer.androidasync.r
    public void o(fy.d dVar) {
        this.f58680h = dVar;
    }

    @Override // com.transsion.transfer.androidasync.u
    public void p(fy.j jVar) {
        this.f58675c.p(jVar);
    }

    @Override // com.transsion.transfer.androidasync.r
    public void pause() {
        this.f58674b.pause();
    }

    @Override // com.transsion.transfer.androidasync.r
    public void resume() {
        this.f58674b.resume();
    }

    @Override // com.transsion.transfer.androidasync.r
    public String s() {
        return null;
    }

    @Override // com.transsion.transfer.androidasync.http.d0
    public void send(final String str) {
        a().D(new Runnable() { // from class: com.transsion.transfer.androidasync.http.f0
            @Override // java.lang.Runnable
            public final void run() {
                this.f58653a.K(str);
            }
        });
    }

    @Override // com.transsion.transfer.androidasync.http.d0
    public void x(final String str) {
        a().D(new Runnable() { // from class: com.transsion.transfer.androidasync.http.g0
            @Override // java.lang.Runnable
            public final void run() {
                this.f58671a.H(str);
            }
        });
    }

    @Override // com.transsion.transfer.androidasync.u
    public void y(fy.a aVar) {
        this.f58674b.y(aVar);
    }
}
