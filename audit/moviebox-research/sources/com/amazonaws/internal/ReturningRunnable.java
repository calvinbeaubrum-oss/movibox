package com.amazonaws.internal;

import com.amazonaws.async.Callback;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ReturningRunnable<R> {

    /* JADX INFO: renamed from: com.amazonaws.internal.ReturningRunnable$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ ReturningRunnable this$0;
        final /* synthetic */ Callback val$callback;

        public AnonymousClass1(ReturningRunnable returningRunnable, Callback callback) {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                throw null;
            } catch (Exception e11) {
                ReturningRunnable.a(null).getClass();
                new Exception(ReturningRunnable.a(null), e11);
                throw null;
            }
        }
    }

    public static /* synthetic */ String a(ReturningRunnable returningRunnable) {
        throw null;
    }
}
