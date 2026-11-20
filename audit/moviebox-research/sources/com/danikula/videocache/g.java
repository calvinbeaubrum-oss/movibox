package com.danikula.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f32350a = new AtomicInteger(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f32351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile e f32352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<b> f32353d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f32354e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f32355f;

    /* JADX INFO: compiled from: source.java */
    public static final class a extends Handler implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f32356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<b> f32357b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.f32356a = str;
            this.f32357b = list;
        }

        @Override // com.danikula.videocache.b
        public void a(String str, int i11) {
            Message messageObtainMessage = obtainMessage();
            messageObtainMessage.arg1 = i11;
            sendMessage(messageObtainMessage);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Iterator<b> it = this.f32357b.iterator();
            while (it.hasNext()) {
                it.next().a(this.f32356a, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f32353d = copyOnWriteArrayList;
        this.f32351b = (String) l.c(str);
        this.f32355f = (c) l.c(cVar);
        this.f32354e = new a(str, copyOnWriteArrayList);
    }

    public synchronized void a() {
        try {
            if (this.f32350a.decrementAndGet() <= 0) {
                if (this.f32352c != null) {
                    this.f32352c.e();
                }
                this.f32352c = null;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public int b() {
        return this.f32350a.get();
    }

    public final e c() {
        e eVar = new e(this.f32355f.f32342c);
        this.f32355f.f32342c.B();
        eVar.l(this.f32354e);
        return eVar;
    }

    public void d(d dVar, Socket socket) throws IOException, ProxyCacheException {
        e();
        try {
            this.f32350a.incrementAndGet();
            this.f32352c.f();
            this.f32352c.k(dVar, socket);
        } finally {
            q.f("processRequest， shutdown, threadName = " + Thread.currentThread().getName());
            a();
        }
    }

    public final synchronized void e() throws ProxyCacheException {
        try {
            this.f32352c = this.f32352c == null ? c() : this.f32352c;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void f() {
        if (this.f32352c != null) {
            this.f32352c.g();
        }
    }
}
