package com.polygamma.ogm;

import android.os.SystemClock;
import com.polygamma.ogm.j;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import p007do.x;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class j extends i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Executor f48876f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Runnable f48877g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f48878h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ x f48879i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(x xVar, p007do.s sVar, Runnable runnable, long j11, long j12) {
        super(xVar, new Runnable() { // from class: do.w
            @Override // java.lang.Runnable
            public final void run() {
                j.b();
            }
        }, j11, j12);
        this.f48879i = xVar;
        Objects.requireNonNull(sVar);
        this.f48876f = sVar;
        Objects.requireNonNull(runnable);
        this.f48877g = runnable;
    }

    public static /* synthetic */ void b() {
    }

    @Override // com.polygamma.ogm.l, java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        if (runAndReset()) {
            try {
                if (this.f48878h) {
                    this.f48878h = false;
                    this.f48877g.run();
                    long jUptimeMillis = SystemClock.uptimeMillis() + this.f48875e;
                    try {
                        this.f48879i.c(this, jUptimeMillis, true);
                        this.f48881c = jUptimeMillis;
                    } catch (RejectedExecutionException unused) {
                        cancel(false);
                    }
                } else {
                    this.f48878h = true;
                    this.f48876f.execute(this);
                }
            } catch (Throwable th2) {
                setException(th2);
            }
        }
    }
}
