package i7;

import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.utils.d;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f67153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f67154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f67155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile b f67156d;

    /* JADX INFO: compiled from: source.java */
    public class a implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            com.alibaba.android.arouter.launcher.a.f15376c.error(ILogger.defaultTag, "Task rejected, too many task!");
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f67153a = iAvailableProcessors;
        int i11 = iAvailableProcessors + 1;
        f67154b = i11;
        f67155c = i11;
    }

    public b(int i11, int i12, long j11, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i11, i12, j11, timeUnit, blockingQueue, threadFactory, new a());
    }

    public static b a() {
        if (f67156d == null) {
            synchronized (b.class) {
                try {
                    if (f67156d == null) {
                        f67156d = new b(f67154b, f67155c, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(64), new c());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f67156d;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th2) {
        super.afterExecute(runnable, th2);
        if (th2 == null && (runnable instanceof Future)) {
            try {
                ((Future) runnable).get();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (CancellationException e11) {
                th2 = e11;
            } catch (ExecutionException e12) {
                th2 = e12.getCause();
            }
        }
        if (th2 != null) {
            com.alibaba.android.arouter.launcher.a.f15376c.warning(ILogger.defaultTag, "Running task appeared exception! Thread [" + Thread.currentThread().getName() + "], because [" + th2.getMessage() + "]\n" + d.a(th2.getStackTrace()));
        }
    }
}
