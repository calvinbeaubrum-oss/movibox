package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f40012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f40013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f40014c;

    /* JADX INFO: compiled from: source.java */
    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j0 f40015a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Condition f40016b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f40017c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public a f40018d;

        public a(j0 j0Var) {
            this.f40015a = (j0) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(j0Var, "monitor");
            this.f40016b = j0Var.f40013b.newCondition();
        }

        public abstract boolean a();
    }

    public j0() {
        this(false);
    }

    public j0(boolean z11) {
        this.f40014c = null;
        this.f40012a = z11;
        this.f40013b = new ReentrantLock(z11);
    }

    public void b() {
        this.f40013b.lock();
    }

    public boolean c() {
        return this.f40013b.isHeldByCurrentThread();
    }

    public final boolean d(a aVar) {
        try {
            return aVar.a();
        } catch (Throwable th2) {
            f();
            throw com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.r.e(th2);
        }
    }

    public void e() {
        ReentrantLock reentrantLock = this.f40013b;
        try {
            if (reentrantLock.getHoldCount() == 1) {
                g();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void f() {
        for (a aVar = this.f40014c; aVar != null; aVar = aVar.f40018d) {
            aVar.f40016b.signalAll();
        }
    }

    public final void g() {
        for (a aVar = this.f40014c; aVar != null; aVar = aVar.f40018d) {
            if (d(aVar)) {
                aVar.f40016b.signal();
                return;
            }
        }
    }
}
