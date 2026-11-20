package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask extends AbstractFuture<Void> implements Runnable {
    private final Runnable delegate;

    public MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask(Runnable runnable) {
        this.delegate = (Runnable) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.delegate.run();
        } catch (Throwable th2) {
            setException(th2);
            throw com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.r.e(th2);
        }
    }
}
