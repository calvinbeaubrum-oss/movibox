package com.mbridge.msdk.e.a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class q {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f43837e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final j f43838f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final t f43839g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final k[] f43840h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private c f43841i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f43833a = new AtomicInteger();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<p<?>> f43834b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PriorityBlockingQueue<p<?>> f43835c = new PriorityBlockingQueue<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PriorityBlockingQueue<p<?>> f43836d = new PriorityBlockingQueue<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List<a> f43842j = new ArrayList();

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(p<?> pVar, int i11);
    }

    public q(j jVar, t tVar, int i11, b bVar) {
        this.f43837e = bVar;
        this.f43838f = jVar;
        this.f43840h = new k[i11];
        this.f43839g = tVar;
    }

    public final <T> p<T> a(p<T> pVar) {
        pVar.a(this);
        synchronized (this.f43834b) {
            this.f43834b.add(pVar);
        }
        pVar.c(this.f43833a.incrementAndGet());
        a(pVar, 0);
        if (pVar.p()) {
            this.f43835c.add(pVar);
        } else {
            c(pVar);
        }
        return pVar;
    }

    public final void a() {
        c cVar = this.f43841i;
        if (cVar != null) {
            cVar.a();
        }
        for (k kVar : this.f43840h) {
            if (kVar != null) {
                kVar.a();
            }
        }
        c cVar2 = new c(this.f43835c, this.f43836d, this.f43837e, this.f43839g);
        this.f43841i = cVar2;
        cVar2.start();
        for (int i11 = 0; i11 < this.f43840h.length; i11++) {
            k kVar2 = new k(this.f43836d, this.f43838f, this.f43837e, this.f43839g);
            this.f43840h[i11] = kVar2;
            kVar2.start();
        }
    }

    public final void a(p<?> pVar, int i11) {
        synchronized (this.f43842j) {
            try {
                Iterator<a> it = this.f43842j.iterator();
                while (it.hasNext()) {
                    it.next().a(pVar, i11);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final <T> void b(p<T> pVar) {
        synchronized (this.f43834b) {
            this.f43834b.remove(pVar);
        }
        a(pVar, 5);
    }

    public final <T> void c(p<T> pVar) {
        this.f43836d.add(pVar);
    }
}
