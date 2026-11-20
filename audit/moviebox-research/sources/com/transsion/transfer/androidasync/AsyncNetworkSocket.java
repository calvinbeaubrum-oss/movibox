package com.transsion.transfer.androidasync;

import android.util.Log;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class AsyncNetworkSocket implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InetSocketAddress f58404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q f58405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SelectionKey f58406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AsyncServer f58407d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.transsion.transfer.androidasync.util.a f58409f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f58410g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public fy.j f58411h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public fy.d f58412i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public fy.a f58413j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f58414k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Exception f58415l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public fy.a f58416m;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ByteBufferList f58408e = new ByteBufferList();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f58417n = false;

    @Override // com.transsion.transfer.androidasync.r
    public void A(fy.a aVar) {
        this.f58416m = aVar;
    }

    public void B(AsyncServer asyncServer, SelectionKey selectionKey) {
        this.f58407d = asyncServer;
        this.f58406c = selectionKey;
    }

    public final void D() {
        if (this.f58408e.r()) {
            c0.a(this, this.f58408e);
        }
    }

    @Override // com.transsion.transfer.androidasync.r
    public fy.d G() {
        return this.f58412i;
    }

    @Override // com.transsion.transfer.androidasync.l, com.transsion.transfer.androidasync.r, com.transsion.transfer.androidasync.u
    public AsyncServer a() {
        return this.f58407d;
    }

    public void c(SocketChannel socketChannel, InetSocketAddress inetSocketAddress) throws IOException {
        this.f58404a = inetSocketAddress;
        this.f58409f = new com.transsion.transfer.androidasync.util.a();
        this.f58405b = new b0(socketChannel);
    }

    @Override // com.transsion.transfer.androidasync.r
    public void close() {
        h();
        r(null);
    }

    @Override // com.transsion.transfer.androidasync.r
    public boolean e() {
        return this.f58417n;
    }

    @Override // com.transsion.transfer.androidasync.u
    public void f() {
        this.f58405b.e();
    }

    public final void h() {
        this.f58406c.cancel();
        try {
            this.f58405b.close();
        } catch (IOException unused) {
        }
    }

    public q i() {
        return this.f58405b;
    }

    @Override // com.transsion.transfer.androidasync.u
    public boolean isOpen() {
        return this.f58405b.b() && this.f58406c.isValid();
    }

    @Override // com.transsion.transfer.androidasync.u
    public fy.j k() {
        return this.f58411h;
    }

    public final void l(int i11) throws IOException {
        if (!this.f58406c.isValid()) {
            throw new IOException(new CancelledKeyException());
        }
        if (i11 > 0) {
            SelectionKey selectionKey = this.f58406c;
            selectionKey.interestOps(selectionKey.interestOps() | 4);
        } else {
            SelectionKey selectionKey2 = this.f58406c;
            selectionKey2.interestOps(selectionKey2.interestOps() & (-5));
        }
    }

    @Override // com.transsion.transfer.androidasync.u
    public void m(final ByteBufferList byteBufferList) {
        if (this.f58407d.o() != Thread.currentThread()) {
            this.f58407d.H(new Runnable() { // from class: com.transsion.transfer.androidasync.AsyncNetworkSocket.1
                @Override // java.lang.Runnable
                public void run() {
                    AsyncNetworkSocket.this.m(byteBufferList);
                }
            });
            return;
        }
        if (this.f58405b.b()) {
            try {
                int iC = byteBufferList.C();
                ByteBuffer[] byteBufferArrK = byteBufferList.k();
                this.f58405b.g(byteBufferArrK);
                byteBufferList.b(byteBufferArrK);
                l(byteBufferList.C());
                this.f58407d.C(iC - byteBufferList.C());
            } catch (IOException e11) {
                h();
                v(e11);
                r(e11);
            }
        }
    }

    public void n() {
        if (!this.f58405b.a()) {
            SelectionKey selectionKey = this.f58406c;
            selectionKey.interestOps(selectionKey.interestOps() & (-5));
        }
        fy.j jVar = this.f58411h;
        if (jVar != null) {
            jVar.a();
        }
    }

    @Override // com.transsion.transfer.androidasync.r
    public void o(fy.d dVar) {
        this.f58412i = dVar;
    }

    @Override // com.transsion.transfer.androidasync.u
    public void p(fy.j jVar) {
        this.f58411h = jVar;
    }

    @Override // com.transsion.transfer.androidasync.r
    public void pause() {
        if (this.f58407d.o() != Thread.currentThread()) {
            this.f58407d.H(new Runnable() { // from class: com.transsion.transfer.androidasync.AsyncNetworkSocket.2
                @Override // java.lang.Runnable
                public void run() {
                    AsyncNetworkSocket.this.pause();
                }
            });
        } else {
            if (this.f58417n) {
                return;
            }
            this.f58417n = true;
            try {
                SelectionKey selectionKey = this.f58406c;
                selectionKey.interestOps(selectionKey.interestOps() & (-2));
            } catch (Exception unused) {
            }
        }
    }

    public int q() {
        long j11;
        int i11;
        D();
        boolean z11 = false;
        if (this.f58417n) {
            return 0;
        }
        ByteBuffer byteBufferA = this.f58409f.a();
        try {
            j11 = this.f58405b.read(byteBufferA);
        } catch (Exception e11) {
            h();
            v(e11);
            r(e11);
            j11 = -1;
        }
        if (j11 < 0) {
            h();
            z11 = true;
            i11 = 0;
        } else {
            i11 = (int) (((long) 0) + j11);
        }
        if (j11 > 0) {
            this.f58409f.e(j11);
            byteBufferA.flip();
            this.f58408e.a(byteBufferA);
            c0.a(this, this.f58408e);
        } else {
            ByteBufferList.A(byteBufferA);
        }
        if (z11) {
            v(null);
            r(null);
        }
        return i11;
    }

    public void r(Exception exc) {
        if (this.f58410g) {
            return;
        }
        this.f58410g = true;
        fy.a aVar = this.f58413j;
        if (aVar != null) {
            aVar.i(exc);
            this.f58413j = null;
        }
    }

    @Override // com.transsion.transfer.androidasync.r
    public void resume() {
        if (this.f58407d.o() != Thread.currentThread()) {
            this.f58407d.H(new Runnable() { // from class: com.transsion.transfer.androidasync.AsyncNetworkSocket.3
                @Override // java.lang.Runnable
                public void run() {
                    AsyncNetworkSocket.this.resume();
                }
            });
            return;
        }
        if (this.f58417n) {
            this.f58417n = false;
            try {
                SelectionKey selectionKey = this.f58406c;
                selectionKey.interestOps(selectionKey.interestOps() | 1);
            } catch (Exception unused) {
            }
            D();
            if (isOpen()) {
                return;
            }
            v(this.f58415l);
        }
    }

    @Override // com.transsion.transfer.androidasync.r
    public String s() {
        return null;
    }

    public void t(Exception exc) {
        if (this.f58414k) {
            return;
        }
        this.f58414k = true;
        fy.a aVar = this.f58416m;
        if (aVar != null) {
            aVar.i(exc);
        } else if (exc != null) {
            Log.e("NIO", "Unhandled exception", exc);
        }
    }

    public void v(Exception exc) {
        if (this.f58408e.r()) {
            this.f58415l = exc;
        } else {
            t(exc);
        }
    }

    @Override // com.transsion.transfer.androidasync.u
    public void y(fy.a aVar) {
        this.f58413j = aVar;
    }
}
