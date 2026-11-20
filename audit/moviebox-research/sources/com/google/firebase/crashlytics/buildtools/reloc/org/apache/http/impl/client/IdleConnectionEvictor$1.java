package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
class IdleConnectionEvictor$1 implements Runnable {
    final /* synthetic */ b this$0;
    final /* synthetic */ ak.a val$connectionManager;

    public IdleConnectionEvictor$1(b bVar, ak.a aVar) {
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            Thread.sleep(b.a(null));
            throw null;
        } catch (Exception e11) {
            b.b(null, e11);
        }
    }
}
