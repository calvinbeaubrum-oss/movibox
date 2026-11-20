package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class c4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l3 f18090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f18091b;

    public c4() {
        this(l3.f20326a);
    }

    public c4(l3 l3Var) {
        this.f18090a = l3Var;
    }

    public synchronized void a() {
        while (!this.f18091b) {
            wait();
        }
    }

    public synchronized void b() {
        boolean z11 = false;
        while (!this.f18091b) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z11 = true;
            }
        }
        if (z11) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized boolean c() {
        boolean z11;
        z11 = this.f18091b;
        this.f18091b = false;
        return z11;
    }

    public synchronized boolean d() {
        return this.f18091b;
    }

    public synchronized boolean e() {
        if (this.f18091b) {
            return false;
        }
        this.f18091b = true;
        notifyAll();
        return true;
    }
}
