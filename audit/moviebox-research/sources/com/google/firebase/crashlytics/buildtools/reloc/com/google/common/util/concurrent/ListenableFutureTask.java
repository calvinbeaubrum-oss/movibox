package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class ListenableFutureTask<V> extends FutureTask<V> implements i0<V> {
    private final z executionList;

    public ListenableFutureTask(Runnable runnable, V v11) {
        super(runnable, v11);
        this.executionList = new z();
    }

    public ListenableFutureTask(Callable<V> callable) {
        super(callable);
        this.executionList = new z();
    }

    public static <V> ListenableFutureTask<V> create(Runnable runnable, V v11) {
        return new ListenableFutureTask<>(runnable, v11);
    }

    public static <V> ListenableFutureTask<V> create(Callable<V> callable) {
        return new ListenableFutureTask<>(callable);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.i0
    public void addListener(Runnable runnable, Executor executor) {
        this.executionList.a(runnable, executor);
    }

    @Override // java.util.concurrent.FutureTask
    public void done() {
        this.executionList.b();
    }
}
