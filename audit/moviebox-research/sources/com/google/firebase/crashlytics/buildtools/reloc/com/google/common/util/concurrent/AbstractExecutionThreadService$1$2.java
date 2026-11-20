package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import java.util.logging.Level;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
class AbstractExecutionThreadService$1$2 implements Runnable {
    final /* synthetic */ a.C0421a this$1;

    public AbstractExecutionThreadService$1$2(a.C0421a c0421a) {
        this.this$1 = c0421a;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            a.this.f();
            this.this$1.j();
            if (this.this$1.h()) {
                try {
                    a.this.c();
                } catch (Throwable th2) {
                    try {
                        a.this.e();
                    } catch (Exception e11) {
                        a.f39974b.log(Level.WARNING, "Error while attempting to shut down the service after failure.", (Throwable) e11);
                    }
                    this.this$1.i(th2);
                    return;
                }
            }
            a.this.e();
            this.this$1.k();
        } catch (Throwable th3) {
            this.this$1.i(th3);
        }
    }
}
