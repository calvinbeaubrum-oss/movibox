package x9;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f80443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f80444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f80445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f80446d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f80447e = new HandlerC0901a();

    /* JADX INFO: renamed from: x9.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class HandlerC0901a extends Handler {
        public HandlerC0901a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            long j11;
            synchronized (a.this) {
                try {
                    if (a.this.f80446d) {
                        return;
                    }
                    long jElapsedRealtime = a.this.f80445c - SystemClock.elapsedRealtime();
                    long j12 = 0;
                    if (jElapsedRealtime <= 0) {
                        a.this.e();
                    } else {
                        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                        a.this.f(jElapsedRealtime);
                        long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                        if (jElapsedRealtime < a.this.f80444b) {
                            j11 = jElapsedRealtime - jElapsedRealtime3;
                            if (j11 < 0) {
                            }
                            sendMessageDelayed(obtainMessage(1), j12);
                        } else {
                            j11 = a.this.f80444b - jElapsedRealtime3;
                            while (j11 < 0) {
                                j11 += a.this.f80444b;
                            }
                        }
                        j12 = j11;
                        sendMessageDelayed(obtainMessage(1), j12);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public a(long j11, long j12) {
        this.f80443a = j11;
        this.f80444b = j12;
    }

    public final synchronized void d() {
        this.f80446d = true;
        this.f80447e.removeMessages(1);
    }

    public abstract void e();

    public abstract void f(long j11);

    public final synchronized a g() {
        this.f80446d = false;
        if (this.f80443a <= 0) {
            e();
            return this;
        }
        this.f80445c = SystemClock.elapsedRealtime() + this.f80443a;
        Handler handler = this.f80447e;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }
}
