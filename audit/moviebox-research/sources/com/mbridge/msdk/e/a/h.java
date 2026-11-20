package com.mbridge.msdk.e.a;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class h implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f43789a;

    /* JADX INFO: compiled from: source.java */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final p f43792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final r f43793b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Runnable f43794c;

        public a(p pVar, r rVar, Runnable runnable) {
            this.f43792a = pVar;
            this.f43793b = rVar;
            this.f43794c = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f43792a.m()) {
                this.f43792a.c("canceled-at-delivery");
                return;
            }
            if (this.f43793b.a()) {
                this.f43792a.a(this.f43793b.f43843a);
            } else {
                this.f43792a.b(this.f43793b.f43845c);
            }
            if (!this.f43793b.f43846d) {
                this.f43792a.c("done");
            }
            Runnable runnable = this.f43794c;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public h(final Handler handler) {
        this.f43789a = new Executor() { // from class: com.mbridge.msdk.e.a.h.1
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    public h(Executor executor) {
        this.f43789a = executor;
    }

    @Override // com.mbridge.msdk.e.a.t
    public final void a(p<?> pVar, r<?> rVar) {
        a(pVar, rVar, null);
    }

    @Override // com.mbridge.msdk.e.a.t
    public final void a(p<?> pVar, r<?> rVar, Runnable runnable) {
        pVar.t();
        this.f43789a.execute(new a(pVar, rVar, runnable));
    }

    @Override // com.mbridge.msdk.e.a.t
    public final void a(p<?> pVar, z zVar) {
        this.f43789a.execute(new a(pVar, r.a(zVar), null));
    }
}
