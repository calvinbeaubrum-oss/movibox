package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class Callables$4 implements Runnable {
    final /* synthetic */ com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.q val$nameSupplier;
    final /* synthetic */ Runnable val$task;

    public Callables$4(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.q qVar, Runnable runnable) {
        this.val$nameSupplier = qVar;
        this.val$task = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        boolean zB = y.b((String) this.val$nameSupplier.get(), threadCurrentThread);
        try {
            this.val$task.run();
        } finally {
            if (zB) {
                y.b(name, threadCurrentThread);
            }
        }
    }
}
