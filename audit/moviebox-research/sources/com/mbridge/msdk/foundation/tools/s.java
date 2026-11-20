package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.MBridgeConstans;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class s implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Runnable f45085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Runnable f45086b;

    private Runnable a(final Runnable runnable) {
        return new Runnable() { // from class: com.mbridge.msdk.foundation.tools.s.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    try {
                        runnable.run();
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            ad.b("LimitExecutor", e11.getMessage());
                        }
                    }
                } finally {
                    s.this.a();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        Runnable runnable = this.f45086b;
        this.f45085a = runnable;
        this.f45086b = null;
        if (runnable != null) {
            q.a().execute(this.f45085a);
        }
    }

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(Runnable runnable) {
        try {
            if (this.f45085a == null) {
                this.f45085a = a(runnable);
                q.a().execute(this.f45085a);
            } else if (this.f45086b == null) {
                this.f45086b = a(runnable);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
