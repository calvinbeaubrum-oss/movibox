package com.apm.insight.b;

import android.os.SystemClock;
import com.apm.insight.runtime.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f16633b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f16634a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f16635c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Runnable f16636d;

    public c(b bVar) {
        Runnable runnable = new Runnable() { // from class: com.apm.insight.b.c.1
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                if (c.this.f16635c) {
                    return;
                }
                c.this.f16634a.d();
                long unused = c.f16633b = SystemClock.uptimeMillis();
                if (com.apm.insight.runtime.j.a().b()) {
                    n.a().a(c.this.f16636d, 500L);
                } else {
                    n.a().a(c.this.f16636d, 500L);
                }
                com.apm.insight.runtime.b.a(c.f16633b);
            }
        };
        this.f16636d = runnable;
        this.f16634a = bVar;
        n.a().a(runnable, 5000L);
    }

    public static boolean c() {
        return SystemClock.uptimeMillis() - f16633b <= 15000;
    }

    public final void a() {
        if (this.f16635c) {
            return;
        }
        n.a().a(this.f16636d, 5000L);
    }

    public final void b() {
        this.f16635c = true;
    }
}
