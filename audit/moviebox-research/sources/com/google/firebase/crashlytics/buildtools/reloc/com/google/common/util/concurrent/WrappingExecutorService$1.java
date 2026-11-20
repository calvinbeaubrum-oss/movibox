package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
class WrappingExecutorService$1 implements Runnable {
    final /* synthetic */ o0 this$0;
    final /* synthetic */ Callable val$wrapped;

    public WrappingExecutorService$1(o0 o0Var, Callable callable) {
        this.val$wrapped = callable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.val$wrapped.call();
        } catch (Exception e11) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.r.f(e11);
            throw new RuntimeException(e11);
        }
    }
}
