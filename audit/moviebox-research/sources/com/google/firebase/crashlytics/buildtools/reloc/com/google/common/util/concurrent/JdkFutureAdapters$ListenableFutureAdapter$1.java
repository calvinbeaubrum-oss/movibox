package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
class JdkFutureAdapters$ListenableFutureAdapter$1 implements Runnable {
    final /* synthetic */ h0 this$0;

    public JdkFutureAdapters$ListenableFutureAdapter$1(h0 h0Var) {
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            n0.a(h0.f(null));
        } catch (Throwable unused) {
        }
        h0.g(null).b();
    }
}
