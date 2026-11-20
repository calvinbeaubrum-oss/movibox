package com.applovin.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class oc {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f21485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f21486e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f21487f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f21488g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f21489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f21490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IOException f21491c;

    /* JADX INFO: compiled from: source.java */
    public interface b {
        c a(e eVar, long j11, long j12, IOException iOException, int i11);

        void a(e eVar, long j11, long j12);

        void a(e eVar, long j11, long j12, boolean z11);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f21492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f21493b;

        private c(int i11, long j11) {
            this.f21492a = i11;
            this.f21493b = j11;
        }

        public boolean a() {
            int i11 = this.f21492a;
            return i11 == 0 || i11 == 1;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class d extends Handler implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21494a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e f21495b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f21496c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private b f21497d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private IOException f21498f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f21499g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Thread f21500h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f21501i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private volatile boolean f21502j;

        public d(Looper looper, e eVar, b bVar, int i11, long j11) {
            super(looper);
            this.f21495b = eVar;
            this.f21497d = bVar;
            this.f21494a = i11;
            this.f21496c = j11;
        }

        private void a() {
            this.f21498f = null;
            oc.this.f21489a.execute((Runnable) b1.a(oc.this.f21490b));
        }

        private void b() {
            oc.this.f21490b = null;
        }

        private long c() {
            return Math.min((this.f21499g - 1) * 1000, 5000);
        }

        public void a(int i11) throws IOException {
            IOException iOException = this.f21498f;
            if (iOException != null && this.f21499g > i11) {
                throw iOException;
            }
        }

        public void a(long j11) {
            b1.b(oc.this.f21490b == null);
            oc.this.f21490b = this;
            if (j11 > 0) {
                sendEmptyMessageDelayed(0, j11);
            } else {
                a();
            }
        }

        public void a(boolean z11) {
            this.f21502j = z11;
            this.f21498f = null;
            if (hasMessages(0)) {
                this.f21501i = true;
                removeMessages(0);
                if (!z11) {
                    sendEmptyMessage(1);
                }
            } else {
                synchronized (this) {
                    try {
                        this.f21501i = true;
                        this.f21495b.b();
                        Thread thread = this.f21500h;
                        if (thread != null) {
                            thread.interrupt();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            if (z11) {
                b();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                ((b) b1.a(this.f21497d)).a(this.f21495b, jElapsedRealtime, jElapsedRealtime - this.f21496c, true);
                this.f21497d = null;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f21502j) {
                return;
            }
            int i11 = message.what;
            if (i11 == 0) {
                a();
                return;
            }
            if (i11 == 3) {
                throw ((Error) message.obj);
            }
            b();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j11 = jElapsedRealtime - this.f21496c;
            b bVar = (b) b1.a(this.f21497d);
            if (this.f21501i) {
                bVar.a(this.f21495b, jElapsedRealtime, j11, false);
                return;
            }
            int i12 = message.what;
            if (i12 == 1) {
                try {
                    bVar.a(this.f21495b, jElapsedRealtime, j11);
                    return;
                } catch (RuntimeException e11) {
                    pc.a("LoadTask", "Unexpected exception handling load completed", e11);
                    oc.this.f21491c = new h(e11);
                    return;
                }
            }
            if (i12 != 2) {
                return;
            }
            IOException iOException = (IOException) message.obj;
            this.f21498f = iOException;
            int i13 = this.f21499g + 1;
            this.f21499g = i13;
            c cVarA = bVar.a(this.f21495b, jElapsedRealtime, j11, iOException, i13);
            if (cVarA.f21492a == 3) {
                oc.this.f21491c = this.f21498f;
            } else if (cVarA.f21492a != 2) {
                if (cVarA.f21492a == 1) {
                    this.f21499g = 1;
                }
                a(cVarA.f21493b != C.TIME_UNSET ? cVarA.f21493b : c());
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z11;
            try {
                synchronized (this) {
                    z11 = !this.f21501i;
                    this.f21500h = Thread.currentThread();
                }
                if (z11) {
                    ko.a("load:" + this.f21495b.getClass().getSimpleName());
                    try {
                        this.f21495b.a();
                        ko.a();
                    } catch (Throwable th2) {
                        ko.a();
                        throw th2;
                    }
                }
                synchronized (this) {
                    this.f21500h = null;
                    Thread.interrupted();
                }
                if (this.f21502j) {
                    return;
                }
                sendEmptyMessage(1);
            } catch (IOException e11) {
                if (this.f21502j) {
                    return;
                }
                obtainMessage(2, e11).sendToTarget();
            } catch (Error e12) {
                if (!this.f21502j) {
                    pc.a("LoadTask", "Unexpected error loading stream", e12);
                    obtainMessage(3, e12).sendToTarget();
                }
                throw e12;
            } catch (Exception e13) {
                if (this.f21502j) {
                    return;
                }
                pc.a("LoadTask", "Unexpected exception loading stream", e13);
                obtainMessage(2, new h(e13)).sendToTarget();
            } catch (OutOfMemoryError e14) {
                if (this.f21502j) {
                    return;
                }
                pc.a("LoadTask", "OutOfMemory error loading stream", e14);
                obtainMessage(2, new h(e14)).sendToTarget();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface e {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: source.java */
    public interface f {
        void d();
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final f f21504a;

        public g(f fVar) {
            this.f21504a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f21504a.d();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class h extends IOException {
        public h(Throwable th2) {
            super("Unexpected " + th2.getClass().getSimpleName() + ": " + th2.getMessage(), th2);
        }
    }

    static {
        long j11 = C.TIME_UNSET;
        f21485d = a(false, C.TIME_UNSET);
        f21486e = a(true, C.TIME_UNSET);
        f21487f = new c(2, j11);
        f21488g = new c(3, j11);
    }

    public oc(String str) {
        this.f21489a = xp.e("ExoPlayer:Loader:" + str);
    }

    public static c a(boolean z11, long j11) {
        return new c(z11 ? 1 : 0, j11);
    }

    public long a(e eVar, b bVar, int i11) {
        Looper looper = (Looper) b1.b(Looper.myLooper());
        this.f21491c = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new d(looper, eVar, bVar, i11, jElapsedRealtime).a(0L);
        return jElapsedRealtime;
    }

    public void a() {
        ((d) b1.b(this.f21490b)).a(false);
    }

    public void a(int i11) throws IOException {
        IOException iOException = this.f21491c;
        if (iOException != null) {
            throw iOException;
        }
        d dVar = this.f21490b;
        if (dVar != null) {
            if (i11 == Integer.MIN_VALUE) {
                i11 = dVar.f21494a;
            }
            dVar.a(i11);
        }
    }

    public void a(f fVar) {
        d dVar = this.f21490b;
        if (dVar != null) {
            dVar.a(true);
        }
        if (fVar != null) {
            this.f21489a.execute(new g(fVar));
        }
        this.f21489a.shutdown();
    }

    public void b() {
        this.f21491c = null;
    }

    public boolean c() {
        return this.f21491c != null;
    }

    public boolean d() {
        return this.f21490b != null;
    }
}
