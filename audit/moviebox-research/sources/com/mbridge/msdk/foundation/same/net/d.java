package com.mbridge.msdk.foundation.same.net;

import android.os.Handler;
import com.mbridge.msdk.foundation.tools.ad;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f44555a = d.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f44556b;

    /* JADX INFO: compiled from: source.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final i f44574b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final k f44575c;

        public a(i iVar, k kVar) {
            this.f44574b = iVar;
            this.f44575c = kVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f44574b.q()) {
                this.f44574b.a("canceled-at-delivery");
                this.f44574b.c();
                return;
            }
            k kVar = this.f44575c;
            com.mbridge.msdk.foundation.same.net.b.a aVar = kVar.f44689a;
            if (aVar == null) {
                this.f44574b.a(kVar);
            } else {
                this.f44574b.a(aVar);
            }
            this.f44574b.a("done");
            this.f44574b.d();
        }
    }

    public d(final Handler handler) {
        this.f44556b = new Executor() { // from class: com.mbridge.msdk.foundation.same.net.d.1
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public final void a(final i<?> iVar) {
        Executor executor = this.f44556b;
        if (executor != null) {
            executor.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.d.2
                @Override // java.lang.Runnable
                public final void run() {
                    iVar.c();
                }
            });
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public final void a(final i<?> iVar, final long j11, final long j12) {
        Executor executor = this.f44556b;
        if (executor != null) {
            executor.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.d.3
                @Override // java.lang.Runnable
                public final void run() {
                    iVar.a(j11, j12);
                }
            });
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public final void a(i<?> iVar, com.mbridge.msdk.foundation.same.net.b.a aVar) {
        ad.c(this.f44555a, "postError error=" + aVar.f44551a);
        if (this.f44556b != null) {
            this.f44556b.execute(new a(iVar, k.a(aVar)));
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public final void a(i<?> iVar, k<?> kVar) {
        Executor executor = this.f44556b;
        if (executor != null) {
            executor.execute(new a(iVar, kVar));
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public final void b(final i<?> iVar) {
        Executor executor = this.f44556b;
        if (executor != null) {
            executor.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.d.4
                @Override // java.lang.Runnable
                public final void run() {
                    iVar.d();
                }
            });
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public final void c(final i<?> iVar) {
        Executor executor = this.f44556b;
        if (executor != null) {
            executor.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.d.5
                @Override // java.lang.Runnable
                public final void run() {
                    iVar.e();
                }
            });
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public final void d(final i<?> iVar) {
        Executor executor = this.f44556b;
        if (executor != null) {
            executor.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.d.6
                @Override // java.lang.Runnable
                public final void run() {
                    iVar.f();
                }
            });
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public final void e(final i<?> iVar) {
        Executor executor = this.f44556b;
        if (executor != null) {
            executor.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.d.7
                @Override // java.lang.Runnable
                public final void run() {
                    iVar.g();
                }
            });
        }
    }
}
