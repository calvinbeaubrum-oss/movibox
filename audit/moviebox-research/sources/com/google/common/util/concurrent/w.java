package com.google.common.util.concurrent;

import com.google.j2objc.annotations.Weak;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f38952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f38953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f38954c;

    /* JADX INFO: compiled from: source.java */
    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Weak
        public final w f38955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Condition f38956b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f38957c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public a f38958d;

        public a(w wVar) {
            this.f38955a = (w) com.google.common.base.m.q(wVar, "monitor");
            this.f38956b = wVar.f38953b.newCondition();
        }

        public abstract boolean a();
    }

    public w() {
        this(false);
    }

    public w(boolean z11) {
        this.f38954c = null;
        this.f38952a = z11;
        this.f38953b = new ReentrantLock(z11);
    }

    public void b() {
        this.f38953b.lock();
    }

    public boolean c() {
        return this.f38953b.isHeldByCurrentThread();
    }

    public final boolean d(a aVar) {
        try {
            return aVar.a();
        } catch (Error | RuntimeException e11) {
            f();
            throw e11;
        }
    }

    public void e() {
        ReentrantLock reentrantLock = this.f38953b;
        try {
            if (reentrantLock.getHoldCount() == 1) {
                g();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void f() {
        for (a aVar = this.f38954c; aVar != null; aVar = aVar.f38958d) {
            aVar.f38956b.signalAll();
        }
    }

    public final void g() {
        for (a aVar = this.f38954c; aVar != null; aVar = aVar.f38958d) {
            if (d(aVar)) {
                aVar.f38956b.signal();
                return;
            }
        }
    }
}
