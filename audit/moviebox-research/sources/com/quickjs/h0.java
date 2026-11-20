package com.quickjs;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Thread f48941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f48942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public QuickJS f48943c;

    public h0(QuickJS quickJS) {
        this.f48943c = quickJS;
        a();
    }

    public synchronized void a() {
        try {
            Thread thread = this.f48941a;
            if (thread != null && thread != Thread.currentThread()) {
                throw new Error("All QuickJS methods must be called on the same thread. Invalid QuickJS thread access: current thread is " + Thread.currentThread() + " while the locker has thread " + this.f48941a);
            }
            if (this.f48941a != Thread.currentThread()) {
                this.f48941a = Thread.currentThread();
                this.f48942b = false;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void b() {
        if (this.f48942b && this.f48941a == null) {
            throw new Error("Invalid QuickJS thread access: the locker has been released!");
        }
        if (this.f48941a == Thread.currentThread()) {
            return;
        }
        throw new Error("All QuickJS methods must be called on the same thread. Invalid QuickJS thread access: current thread is " + Thread.currentThread() + " while the locker has thread " + this.f48941a);
    }
}
