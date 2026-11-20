package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class MoreExecutors {

    /* JADX INFO: renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.MoreExecutors$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ i0 val$future;
        final /* synthetic */ BlockingQueue val$queue;

        public AnonymousClass1(BlockingQueue blockingQueue, i0 i0Var) {
            this.val$queue = blockingQueue;
            this.val$future = i0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$queue.add(this.val$future);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.MoreExecutors$5, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static class AnonymousClass5 implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f39963a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Executor f39964b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AbstractFuture f39965c;

        public AnonymousClass5(Executor executor, AbstractFuture abstractFuture) {
            this.f39964b = executor;
            this.f39965c = abstractFuture;
        }

        @Override // java.util.concurrent.Executor
        public void execute(final Runnable runnable) {
            try {
                this.f39964b.execute(new Runnable() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.MoreExecutors.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass5.this.f39963a = false;
                        runnable.run();
                    }
                });
            } catch (RejectedExecutionException e11) {
                if (this.f39963a) {
                    this.f39965c.setException(e11);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum DirectExecutor implements Executor {
        INSTANCE;

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }

        @Override // java.lang.Enum
        public String toString() {
            return "MoreExecutors.directExecutor()";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class a {
    }

    public static Executor a() {
        return DirectExecutor.INSTANCE;
    }

    public static Executor b(Executor executor, AbstractFuture<?> abstractFuture) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(executor);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(abstractFuture);
        return executor == a() ? executor : new AnonymousClass5(executor, abstractFuture);
    }
}
