package com.transsion.transfer.androidasync;

import java.util.LinkedList;
import java.util.WeakHashMap;
import java.util.concurrent.Semaphore;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
class ThreadQueue extends LinkedList<Runnable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WeakHashMap<Thread, ThreadQueue> f58485a = new WeakHashMap<>();
    Semaphore queueSemaphore = new Semaphore(0);
    d waiter;

    public static ThreadQueue getOrCreateThreadQueue(Thread thread) {
        ThreadQueue threadQueue;
        WeakHashMap<Thread, ThreadQueue> weakHashMap = f58485a;
        synchronized (weakHashMap) {
            try {
                threadQueue = weakHashMap.get(thread);
                if (threadQueue == null) {
                    threadQueue = new ThreadQueue();
                    weakHashMap.put(thread, threadQueue);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return threadQueue;
    }

    public static void release(d dVar) {
        WeakHashMap<Thread, ThreadQueue> weakHashMap = f58485a;
        synchronized (weakHashMap) {
            try {
                for (ThreadQueue threadQueue : weakHashMap.values()) {
                    if (threadQueue.waiter == dVar) {
                        threadQueue.queueSemaphore.release();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(Runnable runnable) {
        boolean zAdd;
        synchronized (this) {
            zAdd = super.add(runnable);
        }
        return zAdd;
    }

    @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
    public Runnable remove() {
        synchronized (this) {
            try {
                if (isEmpty()) {
                    return null;
                }
                return (Runnable) super.remove();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public boolean remove(Object obj) {
        boolean zRemove;
        synchronized (this) {
            zRemove = super.remove(obj);
        }
        return zRemove;
    }
}
