package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
class MoreExecutors$Application$1 implements Runnable {
    final /* synthetic */ MoreExecutors.a this$0;
    final /* synthetic */ ExecutorService val$service;
    final /* synthetic */ long val$terminationTimeout;
    final /* synthetic */ TimeUnit val$timeUnit;

    public MoreExecutors$Application$1(MoreExecutors.a aVar, ExecutorService executorService, long j11, TimeUnit timeUnit) {
        this.val$service = executorService;
        this.val$terminationTimeout = j11;
        this.val$timeUnit = timeUnit;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.val$service.shutdown();
            this.val$service.awaitTermination(this.val$terminationTimeout, this.val$timeUnit);
        } catch (InterruptedException unused) {
        }
    }
}
