package com.mbridge.msdk.foundation.same.report.b;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class b extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f44787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f44788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile a f44789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.report.b.a f44790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f44791e;

    /* JADX INFO: compiled from: source.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f44793b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f44794c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f44795d;

        private a() {
            this.f44793b = SystemClock.uptimeMillis();
        }

        public final boolean a() {
            return !this.f44794c || this.f44793b - this.f44795d >= ((long) b.this.f44791e);
        }

        public final void b() {
            this.f44794c = false;
            this.f44795d = SystemClock.uptimeMillis();
            b.this.f44788b.postAtFrontOfQueue(this);
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (b.this) {
                this.f44794c = true;
                this.f44793b = SystemClock.uptimeMillis();
            }
        }
    }

    private b() {
        super("AnrMonitor-Thread");
        this.f44788b = new Handler(Looper.getMainLooper());
        this.f44791e = 5000;
    }

    public static b a() {
        if (f44787a == null) {
            synchronized (b.class) {
                try {
                    if (f44787a == null) {
                        f44787a = new b();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f44787a;
    }

    public final b a(int i11, com.mbridge.msdk.foundation.same.report.b.a aVar) {
        this.f44791e = i11;
        this.f44790d = aVar;
        return this;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0025 */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            if (isInterrupted() || !(this.f44789c == null || this.f44789c.f44794c)) {
                try {
                    Thread.sleep(this.f44791e);
                } catch (Exception unused) {
                }
            } else {
                synchronized (this) {
                    if (this.f44789c == null) {
                        this.f44789c = new a();
                    }
                    this.f44789c.b();
                    long jUptimeMillis = this.f44791e;
                    long jUptimeMillis2 = SystemClock.uptimeMillis();
                    while (jUptimeMillis > 0) {
                        try {
                            wait(jUptimeMillis);
                        } catch (InterruptedException e11) {
                            Log.w("AnrMonitor", e11.toString());
                        }
                        jUptimeMillis = ((long) this.f44791e) - (SystemClock.uptimeMillis() - jUptimeMillis2);
                    }
                    if (!this.f44789c.a()) {
                        com.mbridge.msdk.foundation.same.report.b.a aVar = this.f44790d;
                        if (aVar != null) {
                            aVar.a();
                        }
                    } else if (!Debug.isDebuggerConnected() && !Debug.waitingForDebugger() && this.f44790d != null) {
                        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
                        this.f44790d.a(c.a(stackTrace), stackTrace);
                    }
                }
            }
        }
    }
}
