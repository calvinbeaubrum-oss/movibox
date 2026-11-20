package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.TraceUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class Loader implements LoaderErrorThrower {
    public static final int DONT_RETRY = 2;
    public static final int DONT_RETRY_FATAL = 3;
    public static final int RETRY = 0;
    public static final int RETRY_RESET_ERROR_COUNT = 1;
    private LoadTask<? extends Loadable> currentTask;
    private final ExecutorService downloadExecutorService;
    private IOException fatalError;

    /* JADX INFO: compiled from: source.java */
    public interface Callback<T extends Loadable> {
        void onLoadCanceled(T t11, long j11, long j12, boolean z11);

        void onLoadCompleted(T t11, long j11, long j12);

        int onLoadError(T t11, long j11, long j12, IOException iOException);
    }

    /* JADX INFO: compiled from: source.java */
    public final class LoadTask<T extends Loadable> extends Handler implements Runnable {
        private static final int MSG_CANCEL = 1;
        private static final int MSG_END_OF_SOURCE = 2;
        private static final int MSG_FATAL_ERROR = 4;
        private static final int MSG_IO_EXCEPTION = 3;
        private static final int MSG_START = 0;
        private static final String TAG = "LoadTask";
        private Callback<T> callback;
        private volatile boolean canceled;
        private IOException currentError;
        public final int defaultMinRetryCount;
        private int errorCount;
        private volatile Thread executorThread;
        private final T loadable;
        private volatile boolean released;
        private final long startTimeMs;

        public LoadTask(Looper looper, T t11, Callback<T> callback, int i11, long j11) {
            super(looper);
            this.loadable = t11;
            this.callback = callback;
            this.defaultMinRetryCount = i11;
            this.startTimeMs = j11;
        }

        private void execute() {
            this.currentError = null;
            Loader.this.downloadExecutorService.execute(Loader.this.currentTask);
        }

        private void finish() {
            Loader.this.currentTask = null;
        }

        private long getRetryDelayMillis() {
            return Math.min((this.errorCount - 1) * 1000, 5000);
        }

        public final void cancel(boolean z11) {
            this.released = z11;
            this.currentError = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z11) {
                    sendEmptyMessage(1);
                }
            } else {
                this.canceled = true;
                this.loadable.cancelLoad();
                if (this.executorThread != null) {
                    this.executorThread.interrupt();
                }
            }
            if (z11) {
                finish();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.callback.onLoadCanceled(this.loadable, jElapsedRealtime, jElapsedRealtime - this.startTimeMs, true);
                this.callback = null;
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (this.released) {
                return;
            }
            int i11 = message.what;
            if (i11 == 0) {
                execute();
                return;
            }
            if (i11 == 4) {
                throw ((Error) message.obj);
            }
            finish();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j11 = jElapsedRealtime - this.startTimeMs;
            if (this.canceled) {
                this.callback.onLoadCanceled(this.loadable, jElapsedRealtime, j11, false);
                return;
            }
            int i12 = message.what;
            if (i12 == 1) {
                this.callback.onLoadCanceled(this.loadable, jElapsedRealtime, j11, false);
                return;
            }
            if (i12 == 2) {
                try {
                    this.callback.onLoadCompleted(this.loadable, jElapsedRealtime, j11);
                    return;
                } catch (RuntimeException e11) {
                    Log.e(TAG, "Unexpected exception handling load completed", e11);
                    Loader.this.fatalError = new UnexpectedLoaderException(e11);
                    return;
                }
            }
            if (i12 != 3) {
                return;
            }
            IOException iOException = (IOException) message.obj;
            this.currentError = iOException;
            int iOnLoadError = this.callback.onLoadError(this.loadable, jElapsedRealtime, j11, iOException);
            if (iOnLoadError == 3) {
                Loader.this.fatalError = this.currentError;
            } else if (iOnLoadError != 2) {
                this.errorCount = iOnLoadError != 1 ? 1 + this.errorCount : 1;
                start(getRetryDelayMillis());
            }
        }

        public final void maybeThrowError(int i11) throws IOException {
            IOException iOException = this.currentError;
            if (iOException != null && this.errorCount > i11) {
                throw iOException;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.executorThread = Thread.currentThread();
                if (!this.canceled) {
                    TraceUtil.beginSection("load:" + this.loadable.getClass().getSimpleName());
                    try {
                        this.loadable.load();
                        TraceUtil.endSection();
                    } catch (Throwable th2) {
                        TraceUtil.endSection();
                        throw th2;
                    }
                }
                if (this.released) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (IOException e11) {
                if (this.released) {
                    return;
                }
                obtainMessage(3, e11).sendToTarget();
            } catch (OutOfMemoryError e12) {
                Log.e(TAG, "OutOfMemory error loading stream", e12);
                if (this.released) {
                    return;
                }
                obtainMessage(3, new UnexpectedLoaderException(e12)).sendToTarget();
            } catch (Error e13) {
                Log.e(TAG, "Unexpected error loading stream", e13);
                if (!this.released) {
                    obtainMessage(4, e13).sendToTarget();
                }
                throw e13;
            } catch (InterruptedException unused) {
                Assertions.checkState(this.canceled);
                if (this.released) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (Exception e14) {
                Log.e(TAG, "Unexpected exception loading stream", e14);
                if (this.released) {
                    return;
                }
                obtainMessage(3, new UnexpectedLoaderException(e14)).sendToTarget();
            }
        }

        public final void start(long j11) {
            Assertions.checkState(Loader.this.currentTask == null);
            Loader.this.currentTask = this;
            if (j11 > 0) {
                sendEmptyMessageDelayed(0, j11);
            } else {
                execute();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface Loadable {
        void cancelLoad();

        void load() throws InterruptedException, IOException;
    }

    /* JADX INFO: compiled from: source.java */
    public interface ReleaseCallback {
        void onLoaderReleased();
    }

    /* JADX INFO: compiled from: source.java */
    public static final class ReleaseTask implements Runnable {
        private final ReleaseCallback callback;

        public ReleaseTask(ReleaseCallback releaseCallback) {
            this.callback = releaseCallback;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.callback.onLoaderReleased();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public @interface RetryAction {
    }

    /* JADX INFO: compiled from: source.java */
    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable th2) {
            super("Unexpected " + th2.getClass().getSimpleName() + ": " + th2.getMessage(), th2);
        }
    }

    public Loader(String str) {
        this.downloadExecutorService = Util.newSingleThreadExecutor(str);
    }

    public final void cancelLoading() {
        this.currentTask.cancel(false);
    }

    public final boolean isLoading() {
        return this.currentTask != null;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.LoaderErrorThrower
    public final void maybeThrowError() throws IOException {
        maybeThrowError(Integer.MIN_VALUE);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.LoaderErrorThrower
    public final void maybeThrowError(int i11) throws IOException {
        IOException iOException = this.fatalError;
        if (iOException != null) {
            throw iOException;
        }
        LoadTask<? extends Loadable> loadTask = this.currentTask;
        if (loadTask != null) {
            if (i11 == Integer.MIN_VALUE) {
                i11 = loadTask.defaultMinRetryCount;
            }
            loadTask.maybeThrowError(i11);
        }
    }

    public final void release() {
        release(null);
    }

    public final void release(ReleaseCallback releaseCallback) {
        LoadTask<? extends Loadable> loadTask = this.currentTask;
        if (loadTask != null) {
            loadTask.cancel(true);
        }
        if (releaseCallback != null) {
            this.downloadExecutorService.execute(new ReleaseTask(releaseCallback));
        }
        this.downloadExecutorService.shutdown();
    }

    public final <T extends Loadable> long startLoading(T t11, Callback<T> callback, int i11) {
        Looper looperMyLooper = Looper.myLooper();
        Assertions.checkState(looperMyLooper != null);
        this.fatalError = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new LoadTask(looperMyLooper, t11, callback, i11, jElapsedRealtime).start(0L);
        return jElapsedRealtime;
    }
}
