package io;

import java.lang.ref.ReferenceQueue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class l0 extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReferenceQueue f67307b;

    public l0() {
        super(0);
        this.f67307b = new ReferenceQueue();
        Thread thread = new Thread(new Runnable() { // from class: io.j0
            @Override // java.lang.Runnable
            public final void run() {
                this.f67300a.c();
            }
        });
        thread.setDaemon(true);
        thread.setName("pg-ogm-finalizer");
        thread.start();
    }

    @Override // io.e
    public final Runnable a(Object obj, Runnable runnable) {
        final p007do.y yVar = new p007do.y(obj, this.f67307b, runnable);
        return new Runnable() { // from class: io.k0
            @Override // java.lang.Runnable
            public final void run() {
                yVar.clear();
            }
        };
    }

    public final void c() {
        while (true) {
            try {
                ((p007do.y) this.f67307b.remove()).clear();
            } catch (InterruptedException unused) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused2) {
                    Thread.yield();
                }
            }
        }
    }
}
