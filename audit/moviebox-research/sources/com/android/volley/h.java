package com.android.volley;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f16510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Request<?>> f16511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PriorityBlockingQueue<Request<?>> f16512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PriorityBlockingQueue<Request<?>> f16513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f16514e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f f16515f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j f16516g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final NetworkDispatcher[] f16517h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CacheDispatcher f16518i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<b> f16519j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<a> f16520k;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(Request<?> request, int i11);
    }

    /* JADX INFO: compiled from: source.java */
    @Deprecated
    public interface b<T> {
        void a(Request<T> request);
    }

    public h(c cVar, f fVar) {
        this(cVar, fVar, 4);
    }

    public h(c cVar, f fVar, int i11) {
        this(cVar, fVar, i11, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
    }

    public h(c cVar, f fVar, int i11, j jVar) {
        this.f16510a = new AtomicInteger();
        this.f16511b = new HashSet();
        this.f16512c = new PriorityBlockingQueue<>();
        this.f16513d = new PriorityBlockingQueue<>();
        this.f16519j = new ArrayList();
        this.f16520k = new ArrayList();
        this.f16514e = cVar;
        this.f16515f = fVar;
        this.f16517h = new NetworkDispatcher[i11];
        this.f16516g = jVar;
    }

    public <T> Request<T> a(Request<T> request) {
        request.setRequestQueue(this);
        synchronized (this.f16511b) {
            this.f16511b.add(request);
        }
        request.setSequence(d());
        request.addMarker("add-to-queue");
        e(request, 0);
        b(request);
        return request;
    }

    public <T> void b(Request<T> request) {
        if (request.shouldCache()) {
            this.f16512c.add(request);
        } else {
            f(request);
        }
    }

    public <T> void c(Request<T> request) {
        synchronized (this.f16511b) {
            this.f16511b.remove(request);
        }
        synchronized (this.f16519j) {
            try {
                Iterator<b> it = this.f16519j.iterator();
                while (it.hasNext()) {
                    it.next().a(request);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        e(request, 5);
    }

    public int d() {
        return this.f16510a.incrementAndGet();
    }

    public void e(Request<?> request, int i11) {
        synchronized (this.f16520k) {
            try {
                Iterator<a> it = this.f16520k.iterator();
                while (it.hasNext()) {
                    it.next().a(request, i11);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public <T> void f(Request<T> request) {
        this.f16513d.add(request);
    }

    public void g() {
        h();
        CacheDispatcher cacheDispatcher = new CacheDispatcher(this.f16512c, this.f16513d, this.f16514e, this.f16516g);
        this.f16518i = cacheDispatcher;
        cacheDispatcher.start();
        for (int i11 = 0; i11 < this.f16517h.length; i11++) {
            NetworkDispatcher networkDispatcher = new NetworkDispatcher(this.f16513d, this.f16515f, this.f16514e, this.f16516g);
            this.f16517h[i11] = networkDispatcher;
            networkDispatcher.start();
        }
    }

    public void h() {
        CacheDispatcher cacheDispatcher = this.f16518i;
        if (cacheDispatcher != null) {
            cacheDispatcher.quit();
        }
        for (NetworkDispatcher networkDispatcher : this.f16517h) {
            if (networkDispatcher != null) {
                networkDispatcher.quit();
            }
        }
    }
}
