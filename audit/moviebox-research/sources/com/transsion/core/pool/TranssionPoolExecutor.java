package com.transsion.core.pool;

import android.os.Process;
import android.os.StrictMode;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.transsion.core.log.LogUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.xml.transform.TransformerException;
import org.json.JSONException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class TranssionPoolExecutor extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f51831a;

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
            if (obj != null && comparableFutureTask.object != null && obj.getClass().equals(comparableFutureTask.object.getClass())) {
                Object obj2 = this.object;
                if (obj2 instanceof Comparable) {
                    return ((Comparable) obj2).compareTo(comparableFutureTask.object);
                }
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class DefaultThreadFactory implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f51832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final UncaughtThrowableStrategy f51833b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f51834c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f51835d;

        public DefaultThreadFactory(String str, UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z11) {
            this.f51832a = str;
            this.f51833b = uncaughtThrowableStrategy;
            this.f51834c = z11;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(@NonNull Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "zero-" + this.f51832a + "-thread-" + this.f51835d) { // from class: com.transsion.core.pool.TranssionPoolExecutor.DefaultThreadFactory.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Process.setThreadPriority(10);
                    if (DefaultThreadFactory.this.f51834c) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        super.run();
                    } catch (Throwable th2) {
                        DefaultThreadFactory.this.f51833b.handle(th2);
                    }
                }
            };
            this.f51835d = this.f51835d + 1;
            return thread;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum UncaughtThrowableStrategy {
        IGNORE,
        LOG { // from class: com.transsion.core.pool.TranssionPoolExecutor.UncaughtThrowableStrategy.1
            @Override // com.transsion.core.pool.TranssionPoolExecutor.UncaughtThrowableStrategy
            public void handle(Throwable th2) throws JSONException, TransformerException, IOException {
                LogUtils.d("ZeroPoolExecutor", "Request threw uncaught throwable", th2);
            }
        },
        THROW { // from class: com.transsion.core.pool.TranssionPoolExecutor.UncaughtThrowableStrategy.2
            @Override // com.transsion.core.pool.TranssionPoolExecutor.UncaughtThrowableStrategy
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

    /* JADX INFO: compiled from: source.java */
    public static class a implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Pattern f51836a;

        public a(Pattern pattern) {
            this.f51836a = pattern;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.f51836a.matcher(str).matches();
        }
    }

    public TranssionPoolExecutor(int i11, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z11, boolean z12) {
        super(0, Api.BaseClientBuilder.API_PRIORITY_OTHER, 60L, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory(str, uncaughtThrowableStrategy, z11));
        this.f51831a = z12;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("size is :");
            sb2.append(getPoolSize());
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static int a() throws JSONException, TransformerException, IOException {
        File[] fileArrListFiles;
        try {
            fileArrListFiles = new File("/sys/devices/system/cpu/").listFiles(new a(Pattern.compile("cpu[0-9]+")));
        } catch (Throwable th2) {
            LogUtils.d("ZeroPoolExecutor", "Failed to calculate accurate cpu count", th2);
            fileArrListFiles = null;
        }
        return Math.min(4, Math.max(Math.max(1, Runtime.getRuntime().availableProcessors()), fileArrListFiles != null ? fileArrListFiles.length : 0));
    }

    public static TranssionPoolExecutor c() {
        return d(a(), "source", UncaughtThrowableStrategy.DEFAULT);
    }

    public static TranssionPoolExecutor d(int i11, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return new TranssionPoolExecutor(i11, str, uncaughtThrowableStrategy, false, false);
    }

    public final <T> Future<T> b(Future<T> future) {
        if (this.f51831a) {
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
        if (this.f51831a) {
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
        return b(super.submit(runnable));
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(Runnable runnable, T t11) {
        return b(super.submit(runnable, t11));
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return b(super.submit(callable));
    }
}
