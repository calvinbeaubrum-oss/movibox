package com.bykv.vk.openvk.preload.b;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d<IN, OUT> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static AtomicLong f25644d = new AtomicLong();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    d f25645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    IN f25646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    OUT f25647c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bykv.vk.openvk.preload.b.b.a f25648e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f25649f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f25650g;

    public abstract Object a(b<OUT> bVar, IN in2) throws Throwable;

    public final void a(b bVar, d dVar, IN in2, com.bykv.vk.openvk.preload.b.b.a aVar, Object[] objArr) {
        this.f25649f = new c(bVar);
        this.f25645a = dVar;
        this.f25646b = in2;
        this.f25648e = aVar;
        if (dVar != null) {
            this.f25650g = dVar.f25650g;
        } else {
            long andIncrement = f25644d.getAndIncrement();
            this.f25650g = andIncrement;
            if (andIncrement < 0) {
                throw new RuntimeException("Pipeline ID use up!");
            }
        }
        a(objArr);
    }

    public void a(Object... objArr) {
    }

    public final long b() {
        return this.f25650g;
    }

    public final void b(Throwable th2) {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.f25648e;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f25649f, this, th2);
    }

    public final void c() {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.f25648e;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f25649f, this);
    }

    public final void c(Throwable th2) {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.f25648e;
        if (aVar == null) {
            return;
        }
        aVar.b(this.f25649f, this, th2);
    }

    public final void d() {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.f25648e;
        if (aVar == null) {
            return;
        }
        aVar.c(this.f25649f, this);
    }

    public final void d(Throwable th2) {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.f25648e;
        if (aVar == null) {
            return;
        }
        aVar.c(this.f25649f, this, th2);
    }

    public final void e() {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.f25648e;
        if (aVar == null) {
            return;
        }
        aVar.b(this.f25649f, this);
    }

    public final OUT f() {
        return this.f25647c;
    }
}
