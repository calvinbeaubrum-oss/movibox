package com.apm.insight.runtime;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HandlerThread f17122a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile Handler f17125d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Queue<c> f17123b = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Queue<Message> f17124c = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f17126e = new Object();

    /* JADX INFO: compiled from: source.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            while (!r.this.f17124c.isEmpty()) {
                if (r.this.f17125d != null) {
                    try {
                        r.this.f17125d.sendMessageAtFrontOfQueue((Message) r.this.f17124c.poll());
                    } catch (Throwable unused) {
                    }
                }
            }
            while (!r.this.f17123b.isEmpty()) {
                c cVar = (c) r.this.f17123b.poll();
                if (r.this.f17125d != null) {
                    try {
                        r.this.f17125d.sendMessageAtTime(cVar.f17131a, cVar.f17132b);
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile int f17128a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile boolean f17129b;

        public b(String str) {
            super(str);
            this.f17128a = 0;
            this.f17129b = false;
        }

        /* JADX INFO: Infinite loop detected, blocks: 19, insns: 0 */
        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            super.onLooperPrepared();
            synchronized (r.this.f17126e) {
                try {
                    r.this.f17125d = new Handler();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            r.this.f17125d.post(r.this.new a());
            while (true) {
                try {
                    Looper.loop();
                } catch (Throwable th3) {
                    try {
                        com.apm.insight.b.f.a(com.apm.insight.e.g()).a().c();
                        if (this.f17128a < 5) {
                            com.apm.insight.c.a();
                            k.a(th3, "NPTH_CATCH");
                        } else if (!this.f17129b) {
                            this.f17129b = true;
                            com.apm.insight.c.a();
                            k.a(new RuntimeException(), "NPTH_ERR_MAX");
                        }
                        this.f17128a++;
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Message f17131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f17132b;

        public c(Message message, long j11) {
            this.f17131a = message;
            this.f17132b = j11;
        }
    }

    static {
        new Object() { // from class: com.apm.insight.runtime.r.1
        };
        new Object() { // from class: com.apm.insight.runtime.r.2
        };
    }

    public r(String str) {
        this.f17122a = new b(str);
    }

    private boolean a(Message message, long j11) {
        if (j11 < 0) {
            j11 = 0;
        }
        return b(message, SystemClock.uptimeMillis() + j11);
    }

    private Message b(Runnable runnable) {
        return Message.obtain(this.f17125d, runnable);
    }

    private boolean b(Message message, long j11) {
        if (this.f17125d == null) {
            synchronized (this.f17126e) {
                try {
                    if (this.f17125d == null) {
                        this.f17123b.add(new c(message, j11));
                        return true;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        try {
            return this.f17125d.sendMessageAtTime(message, j11);
        } catch (Throwable unused) {
            return true;
        }
    }

    @Nullable
    public final Handler a() {
        return this.f17125d;
    }

    public final boolean a(Runnable runnable) {
        return a(b(runnable), 0L);
    }

    public final boolean a(Runnable runnable, long j11) {
        return a(b(runnable), j11);
    }

    public final void b() {
        this.f17122a.start();
    }

    public final HandlerThread c() {
        return this.f17122a;
    }
}
