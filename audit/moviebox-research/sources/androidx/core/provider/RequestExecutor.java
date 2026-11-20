package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import androidx.annotation.NonNull;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class RequestExecutor {

    /* JADX INFO: compiled from: source.java */
    public static class DefaultThreadFactory implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f7807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7808b;

        /* JADX INFO: compiled from: source.java */
        public static class ProcessPriorityThread extends Thread {
            private final int mPriority;

            public ProcessPriorityThread(Runnable runnable, String str, int i11) {
                super(runnable, str);
                this.mPriority = i11;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.mPriority);
                super.run();
            }
        }

        public DefaultThreadFactory(@NonNull String str, int i11) {
            this.f7807a = str;
            this.f7808b = i11;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new ProcessPriorityThread(runnable, this.f7807a, this.f7808b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class ReplyRunnable<T> implements Runnable {

        @NonNull
        private Callable<T> mCallable;

        @NonNull
        private androidx.core.util.a<T> mConsumer;

        @NonNull
        private Handler mHandler;

        public ReplyRunnable(@NonNull Handler handler, @NonNull Callable<T> callable, @NonNull androidx.core.util.a<T> aVar) {
            this.mCallable = callable;
            this.mConsumer = aVar;
            this.mHandler = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            final T tCall;
            try {
                tCall = this.mCallable.call();
            } catch (Exception unused) {
                tCall = null;
            }
            final androidx.core.util.a<T> aVar = this.mConsumer;
            this.mHandler.post(new Runnable() { // from class: androidx.core.provider.RequestExecutor.ReplyRunnable.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    aVar.accept(tCall);
                }
            });
        }
    }

    public static ThreadPoolExecutor a(@NonNull String str, int i11, int i12) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i12, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new DefaultThreadFactory(str, i11));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static <T> void b(@NonNull Executor executor, @NonNull Callable<T> callable, @NonNull androidx.core.util.a<T> aVar) {
        executor.execute(new ReplyRunnable(a.a(), callable, aVar));
    }

    public static <T> T c(@NonNull ExecutorService executorService, @NonNull Callable<T> callable, int i11) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i11, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e11) {
            throw e11;
        } catch (ExecutionException e12) {
            throw new RuntimeException(e12);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
