package com.cloud.sdk.commonutil.pool;

import android.os.Process;
import android.os.StrictMode;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class HSPoolExecutor extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f30245a;

    /* JADX INFO: compiled from: source.java */
    public class ComparableFutureTask<V> extends FutureTask<V> implements Comparable<ComparableFutureTask<V>> {
        private Object object;

        public ComparableFutureTask(Runnable runnable, V v11) {
            super(runnable, v11);
            this.object = runnable;
        }

        public ComparableFutureTask(Callable<V> callable) {
            super(callable);
            this.object = callable;
        }

        @Override // java.lang.Comparable
        public int compareTo(ComparableFutureTask<V> comparableFutureTask) {
            if (this == comparableFutureTask) {
                return 0;
            }
            if (comparableFutureTask == null) {
                return -1;
            }
            Object obj = this.object;
            if (obj == null || comparableFutureTask.object == null || !obj.getClass().equals(comparableFutureTask.object.getClass())) {
                return 0;
            }
            Object obj2 = this.object;
            if (obj2 instanceof Comparable) {
                return ((Comparable) obj2).compareTo(comparableFutureTask.object);
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class DefaultThreadFactory implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f30246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final UncaughtThrowableStrategy f30247b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f30248c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f30249d;

        public DefaultThreadFactory(String str, UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z11) {
            this.f30246a = str;
            this.f30247b = uncaughtThrowableStrategy;
            this.f30248c = z11;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(@NonNull Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "zero-" + this.f30246a + "-thread-" + this.f30249d) { // from class: com.cloud.sdk.commonutil.pool.HSPoolExecutor.DefaultThreadFactory.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Process.setThreadPriority(10);
                    if (DefaultThreadFactory.this.f30248c) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        super.run();
                    } catch (Throwable th2) {
                        DefaultThreadFactory.this.f30247b.handle(th2);
                    }
                }
            };
            this.f30249d = this.f30249d + 1;
            return thread;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum UncaughtThrowableStrategy {
        IGNORE,
        LOG { // from class: com.cloud.sdk.commonutil.pool.HSPoolExecutor.UncaughtThrowableStrategy.1
            @Override // com.cloud.sdk.commonutil.pool.HSPoolExecutor.UncaughtThrowableStrategy
            public void handle(Throwable th2) {
            }
        },
        THROW { // from class: com.cloud.sdk.commonutil.pool.HSPoolExecutor.UncaughtThrowableStrategy.2
            @Override // com.cloud.sdk.commonutil.pool.HSPoolExecutor.UncaughtThrowableStrategy
            public void handle(Throwable th2) {
                super.handle(th2);
                if (th2 != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th2);
                }
            }
        };

        public static final UncaughtThrowableStrategy DEFAULT = LOG;

        /* synthetic */ UncaughtThrowableStrategy(a aVar) {
            this();
        }

        public void handle(Throwable th2) {
        }
    }

    public HSPoolExecutor(int i11, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z11, boolean z12) {
        super(0, Api.BaseClientBuilder.API_PRIORITY_OTHER, 60L, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory(str, uncaughtThrowableStrategy, z11));
        this.f30245a = z12;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("size is :");
            sb2.append(getPoolSize());
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static HSPoolExecutor b() {
        return new HSPoolExecutor(20, "zero", UncaughtThrowableStrategy.DEFAULT, false, false);
    }

    public final <T> Future<T> a(Future<T> future) {
        if (this.f30245a) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e11) {
                throw new RuntimeException(e11);
            }
        }
        return future;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (this.f30245a) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t11) {
        return new ComparableFutureTask(runnable, t11);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new ComparableFutureTask(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(Runnable runnable) {
        return a(super.submit(runnable));
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(Runnable runnable, T t11) {
        return a(super.submit(runnable, t11));
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return a(super.submit(callable));
    }
}
