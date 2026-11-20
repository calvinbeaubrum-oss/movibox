package androidx.core.provider;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
class SelfDestructiveThread$3 implements Runnable {
    final /* synthetic */ h this$0;
    final /* synthetic */ Callable val$callable;
    final /* synthetic */ Condition val$cond;
    final /* synthetic */ AtomicReference val$holder;
    final /* synthetic */ ReentrantLock val$lock;
    final /* synthetic */ AtomicBoolean val$running;

    public SelfDestructiveThread$3(h hVar, AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
        this.val$holder = atomicReference;
        this.val$callable = callable;
        this.val$lock = reentrantLock;
        this.val$running = atomicBoolean;
        this.val$cond = condition;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.val$holder.set(this.val$callable.call());
        } catch (Exception unused) {
        }
        this.val$lock.lock();
        try {
            this.val$running.set(false);
            this.val$cond.signal();
        } finally {
            this.val$lock.unlock();
        }
    }
}
