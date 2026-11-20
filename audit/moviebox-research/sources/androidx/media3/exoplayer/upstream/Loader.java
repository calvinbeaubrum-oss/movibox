package androidx.media3.exoplayer.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import z3.j0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class Loader implements n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f11434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f11435e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f11436f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f11437g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f11438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public LoadTask<? extends d> f11439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public IOException f11440c;

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
            Loader.this.f11438a.execute((Runnable) z3.a.e(Loader.this.f11439b));
        }

        private void finish() {
            Loader.this.f11439b = null;
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
                ((b) z3.a.e(this.callback)).o(this.loadable, jElapsedRealtime, jElapsedRealtime - this.startTimeMs, true);
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
            b bVar = (b) z3.a.e(this.callback);
            if (this.canceled) {
                bVar.o(this.loadable, jElapsedRealtime, j11, false);
                return;
            }
            int i12 = message.what;
            if (i12 == 1) {
                try {
                    bVar.n(this.loadable, jElapsedRealtime, j11);
                    return;
                } catch (RuntimeException e11) {
                    z3.o.d(TAG, "Unexpected exception handling load completed", e11);
                    Loader.this.f11440c = new UnexpectedLoaderException(e11);
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
            c cVarK = bVar.k(this.loadable, jElapsedRealtime, j11, iOException, i13);
            if (cVarK.f11441a == 3) {
                Loader.this.f11440c = this.currentError;
            } else if (cVarK.f11441a != 2) {
                if (cVarK.f11441a == 1) {
                    this.errorCount = 1;
                }
                start(cVarK.f11442b != C.TIME_UNSET ? cVarK.f11442b : getRetryDelayMillis());
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
                    j0.a("load:" + this.loadable.getClass().getSimpleName());
                    try {
                        this.loadable.load();
                        j0.c();
                    } catch (Throwable th2) {
                        j0.c();
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
                    z3.o.d(TAG, "Unexpected error loading stream", e12);
                    obtainMessage(3, e12).sendToTarget();
                }
                throw e12;
            } catch (Exception e13) {
                if (this.released) {
                    return;
                }
                z3.o.d(TAG, "Unexpected exception loading stream", e13);
                obtainMessage(2, new UnexpectedLoaderException(e13)).sendToTarget();
            } catch (OutOfMemoryError e14) {
                if (this.released) {
                    return;
                }
                z3.o.d(TAG, "OutOfMemory error loading stream", e14);
                obtainMessage(2, new UnexpectedLoaderException(e14)).sendToTarget();
            }
        }

        public void start(long j11) {
            z3.a.g(Loader.this.f11439b == null);
            Loader.this.f11439b = this;
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
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unexpected ");
            sb2.append(th2.getClass().getSimpleName());
            if (th2.getMessage() != null) {
                str = ": " + th2.getMessage();
            } else {
                str = "";
            }
            sb2.append(str);
            super(sb2.toString(), th2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b<T extends d> {
        c k(T t11, long j11, long j12, IOException iOException, int i11);

        void n(T t11, long j11, long j12);

        void o(T t11, long j11, long j12, boolean z11);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f11442b;

        public c(int i11, long j11) {
            this.f11441a = i11;
            this.f11442b = j11;
        }

        public boolean c() {
            int i11 = this.f11441a;
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
        f11434d = g(false, C.TIME_UNSET);
        f11435e = g(true, C.TIME_UNSET);
        f11436f = new c(2, j11);
        f11437g = new c(3, j11);
    }

    public Loader(String str) {
        this.f11438a = u0.T0("ExoPlayer:Loader:" + str);
    }

    public static c g(boolean z11, long j11) {
        return new c(z11 ? 1 : 0, j11);
    }

    public void e() {
        ((LoadTask) z3.a.i(this.f11439b)).cancel(false);
    }

    public void f() {
        this.f11440c = null;
    }

    public boolean h() {
        return this.f11440c != null;
    }

    public boolean i() {
        return this.f11439b != null;
    }

    public void j(int i11) throws IOException {
        IOException iOException = this.f11440c;
        if (iOException != null) {
            throw iOException;
        }
        LoadTask<? extends d> loadTask = this.f11439b;
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
        LoadTask<? extends d> loadTask = this.f11439b;
        if (loadTask != null) {
            loadTask.cancel(true);
        }
        if (eVar != null) {
            this.f11438a.execute(new ReleaseTask(eVar));
        }
        this.f11438a.shutdown();
    }

    public <T extends d> long m(T t11, b<T> bVar, int i11) {
        Looper looper = (Looper) z3.a.i(Looper.myLooper());
        this.f11440c = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new LoadTask(looper, t11, bVar, i11, jElapsedRealtime).start(0L);
        return jElapsedRealtime;
    }

    @Override // androidx.media3.exoplayer.upstream.n
    public void maybeThrowError() throws IOException {
        j(Integer.MIN_VALUE);
    }
}
