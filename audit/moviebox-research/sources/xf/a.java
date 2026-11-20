package xf;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a implements Executor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Executor f80479b = new a("GENERAL_EXECUTOR", 4, 32);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ScheduledExecutorService f80480c = Executors.newScheduledThreadPool(4);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f80481d = 32;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ThreadPoolExecutor f80482a;

    /* JADX INFO: renamed from: xf.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class ThreadFactoryC0903a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f80483a = new AtomicInteger(1);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f80484b;

        public ThreadFactoryC0903a(String str) {
            this.f80484b = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format(Locale.US, "BiddingKit:%s #%d", this.f80484b, Integer.valueOf(this.f80483a.getAndIncrement())));
        }
    }

    public a(String str, int i11, int i12) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i11, i12, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0903a(str));
        this.f80482a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        int size = this.f80482a.getQueue().size();
        synchronized (a.class) {
            try {
                int i11 = f80481d;
                if (size == i11) {
                    f80481d = i11 * 2;
                    com.facebook.biddingkit.logging.b.a("MultiAsyncTaskExecutor", "Tasks queue too long. Size = " + i11);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.f80482a.execute(runnable);
    }
}
