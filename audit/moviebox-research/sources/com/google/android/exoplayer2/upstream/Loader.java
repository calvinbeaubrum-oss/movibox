package com.google.android.exoplayer2.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class Loader implements a0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f35229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f35230e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f35231f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f35232g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f35233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public LoadTask<? extends d> f35234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public IOException f35235c;

    /* JADX INFO: compiled from: source.java */
    @SuppressLint({"HandlerLeak"})
    public final class LoadTask<T extends d> extends Handler implements Runnable {
        private static final int MSG_FATAL_ERROR = 3;
        private static final int MSG_FINISH = 1;
        private static final int MSG_IO_EXCEPTION = 2;
        private static final int MSG_START = 0;
        private static final String TAG = "LoadTask";

        @Nullable
        private b<T> callback;
        private boolean canceled;

        @Nullable
        private IOException currentError;
        public final int defaultMinRetryCount;
        private int errorCount;

        @Nullable
        private Thread executorThread;
        private final T loadable;
        private volatile boolean released;
        private final long startTimeMs;

        public LoadTask(Looper looper, T t11, b<T> bVar, int i11, long j11) {
            super(looper);
            this.loadable = t11;
            this.callback = bVar;
            this.defaultMinRetryCount = i11;
            this.startTimeMs = j11;
        }

        private void execute() {
            this.currentError = null;
            Loader.this.f35233a.execute((Runnable) com.google.android.exoplayer2.util.a.e(Loader.this.f35234b));
        }

        private void finish() {
            Loader.this.f35234b = null;
        }

        private long getRetryDelayMillis() {
            return Math.min((this.errorCount - 1) * 1000, 5000);
        }

        public void cancel(boolean z11) {
            this.released = z11;
            this.currentError = null;
            if (hasMessages(0)) {
                this.canceled = true;
                removeMessages(0);
                if (!z11) {
                    sendEmptyMessage(1);
                }
            } else {
                synchronized (this) {
                    try {
                        this.canceled = true;
                        this.loadable.cancelLoad();
                        Thread thread = this.executorThread;
                        if (thread != null) {
                            thread.interrupt();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            if (z11) {
                finish();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                ((b) com.google.android.exoplayer2.util.a.e(this.callback)).j(this.loadable, jElapsedRealtime, jElapsedRealtime - this.startTimeMs, true);
                this.callback = null;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.released) {
                return;
            }
            int i11 = message.what;
            if (i11 == 0) {
                execute();
                return;
            }
            if (i11 == 3) {
                throw ((Error) message.obj);
            }
            finish();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j11 = jElapsedRealtime - this.startTimeMs;
            b bVar = (b) com.google.android.exoplayer2.util.a.e(this.callback);
            if (this.canceled) {
                bVar.j(this.loadable, jElapsedRealtime, j11, false);
                return;
            }
            int i12 = message.what;
            if (i12 == 1) {
                try {
                    bVar.l(this.loadable, jElapsedRealtime, j11);
                    return;
                } catch (RuntimeException e11) {
                    com.google.android.exoplayer2.util.s.d(TAG, "Unexpected exception handling load completed", e11);
                    Loader.this.f35235c = new UnexpectedLoaderException(e11);
                    return;
                }
            }
            if (i12 != 2) {
                return;
            }
            IOException iOException = (IOException) message.obj;
            this.currentError = iOException;
            int i13 = this.errorCount + 1;
            this.errorCount = i13;
            c cVarN = bVar.n(this.loadable, jElapsedRealtime, j11, iOException, i13);
            if (cVarN.f35236a == 3) {
                Loader.this.f35235c = this.currentError;
            } else if (cVarN.f35236a != 2) {
                if (cVarN.f35236a == 1) {
                    this.errorCount = 1;
                }
                start(cVarN.f35237b != C.TIME_UNSET ? cVarN.f35237b : getRetryDelayMillis());
            }
        }

        public void maybeThrowError(int i11) throws IOException {
            IOException iOException = this.currentError;
            if (iOException != null && this.errorCount > i11) {
                throw iOException;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z11;
            try {
                synchronized (this) {
                    z11 = !this.canceled;
                    this.executorThread = Thread.currentThread();
                }
                if (z11) {
                    l0.a("load:" + this.loadable.getClass().getSimpleName());
                    try {
                        this.loadable.load();
                        l0.c();
                    } catch (Throwable th2) {
                        l0.c();
                        throw th2;
                    }
                }
                synchronized (this) {
                    this.executorThread = null;
                    Thread.interrupted();
                }
                if (this.released) {
                    return;
                }
                sendEmptyMessage(1);
            } catch (IOException e11) {
                if (this.released) {
                    return;
                }
                obtainMessage(2, e11).sendToTarget();
            } catch (Error e12) {
                if (!this.released) {
                    com.google.android.exoplayer2.util.s.d(TAG, "Unexpected error loading stream", e12);
                    obtainMessage(3, e12).sendToTarget();
                }
                throw e12;
            } catch (Exception e13) {
                if (this.released) {
                    return;
                }
                com.google.android.exoplayer2.util.s.d(TAG, "Unexpected exception loading stream", e13);
                obtainMessage(2, new UnexpectedLoaderException(e13)).sendToTarget();
            } catch (OutOfMemoryError e14) {
                if (this.released) {
                    return;
                }
                com.google.android.exoplayer2.util.s.d(TAG, "OutOfMemory error loading stream", e14);
                obtainMessage(2, new UnexpectedLoaderException(e14)).sendToTarget();
            }
        }

        public void start(long j11) {
            com.google.android.exoplayer2.util.a.g(Loader.this.f35234b == null);
            Loader.this.f35234b = this;
            if (j11 > 0) {
                sendEmptyMessageDelayed(0, j11);
            } else {
                execute();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class ReleaseTask implements Runnable {
        private final e callback;

        public ReleaseTask(e eVar) {
            this.callback = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.callback.onLoaderReleased();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable th2) {
            super("Unexpected " + th2.getClass().getSimpleName() + ": " + th2.getMessage(), th2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b<T extends d> {
        void j(T t11, long j11, long j12, boolean z11);

        void l(T t11, long j11, long j12);

        c n(T t11, long j11, long j12, IOException iOException, int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f35236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f35237b;

        public c(int i11, long j11) {
            this.f35236a = i11;
            this.f35237b = j11;
        }

        public boolean c() {
            int i11 = this.f35236a;
            return i11 == 0 || i11 == 1;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void cancelLoad();

        void load() throws IOException;
    }

    /* JADX INFO: compiled from: source.java */
    public interface e {
        void onLoaderReleased();
    }

    static {
        long j11 = C.TIME_UNSET;
        f35229d = g(false, C.TIME_UNSET);
        f35230e = g(true, C.TIME_UNSET);
        f35231f = new c(2, j11);
        f35232g = new c(3, j11);
    }

    public Loader(String str) {
        this.f35233a = o0.D0("ExoPlayer:Loader:" + str);
    }

    public static c g(boolean z11, long j11) {
        return new c(z11 ? 1 : 0, j11);
    }

    public void e() {
        ((LoadTask) com.google.android.exoplayer2.util.a.i(this.f35234b)).cancel(false);
    }

    public void f() {
        this.f35235c = null;
    }

    public boolean h() {
        return this.f35235c != null;
    }

    public boolean i() {
        return this.f35234b != null;
    }

    public void j(int i11) throws IOException {
        IOException iOException = this.f35235c;
        if (iOException != null) {
            throw iOException;
        }
        LoadTask<? extends d> loadTask = this.f35234b;
        if (loadTask != null) {
            if (i11 == Integer.MIN_VALUE) {
                i11 = loadTask.defaultMinRetryCount;
            }
            loadTask.maybeThrowError(i11);
        }
    }

    public void k() {
        l(null);
    }

    public void l(@Nullable e eVar) {
        LoadTask<? extends d> loadTask = this.f35234b;
        if (loadTask != null) {
            loadTask.cancel(true);
        }
        if (eVar != null) {
            this.f35233a.execute(new ReleaseTask(eVar));
        }
        this.f35233a.shutdown();
    }

    public <T extends d> long m(T t11, b<T> bVar, int i11) {
        Looper looper = (Looper) com.google.android.exoplayer2.util.a.i(Looper.myLooper());
        this.f35235c = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new LoadTask(looper, t11, bVar, i11, jElapsedRealtime).start(0L);
        return jElapsedRealtime;
    }

    @Override // com.google.android.exoplayer2.upstream.a0
    public void maybeThrowError() throws IOException {
        j(Integer.MIN_VALUE);
    }
}
