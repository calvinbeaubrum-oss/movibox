package com.google.android.datatransport.runtime;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class SafeLoggingExecutor implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f32570a;

    /* JADX INFO: compiled from: source.java */
    public static class SafeLoggingRunnable implements Runnable {
        private final Runnable delegate;

        public SafeLoggingRunnable(Runnable runnable) {
            this.delegate = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.delegate.run();
            } catch (Exception e11) {
                ig.a.d("Executor", "Background execution failure.", e11);
            }
        }
    }

    public SafeLoggingExecutor(Executor executor) {
        this.f32570a = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f32570a.execute(new SafeLoggingRunnable(runnable));
    }
}
