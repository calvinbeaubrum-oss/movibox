package i7;

import androidx.annotation.NonNull;
import com.alibaba.android.arouter.facade.template.ILogger;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements ThreadFactory {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicInteger f67157d = new AtomicInteger(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f67158a = new AtomicInteger(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadGroup f67159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f67160c;

    /* JADX INFO: compiled from: source.java */
    public class a implements Thread.UncaughtExceptionHandler {
        public a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th2) {
            com.alibaba.android.arouter.launcher.a.f15376c.info(ILogger.defaultTag, "Running task appeared exception! Thread [" + thread.getName() + "], because [" + th2.getMessage() + "]");
        }
    }

    public c() {
        SecurityManager securityManager = System.getSecurityManager();
        this.f67159b = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.f67160c = "ARouter task pool No." + f67157d.getAndIncrement() + ", thread No.";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(@NonNull Runnable runnable) {
        String str = this.f67160c + this.f67158a.getAndIncrement();
        com.alibaba.android.arouter.launcher.a.f15376c.info(ILogger.defaultTag, "Thread production, name is [" + str + "]");
        Thread thread = new Thread(this.f67159b, runnable, str, 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        thread.setUncaughtExceptionHandler(new a());
        return thread;
    }
}
