package kl;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.google.firebase.messaging.threads.ThreadPriority;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kl.a f68634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile kl.a f68635b;

    /* JADX INFO: renamed from: kl.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0740b implements kl.a {
        public C0740b() {
        }

        @Override // kl.a
        @NonNull
        public ExecutorService a(ThreadFactory threadFactory, ThreadPriority threadPriority) {
            return b(1, threadFactory, threadPriority);
        }

        @NonNull
        @SuppressLint({"ThreadPoolCreation"})
        public ExecutorService b(int i11, ThreadFactory threadFactory, ThreadPriority threadPriority) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i11, i11, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            return Executors.unconfigurableExecutorService(threadPoolExecutor);
        }
    }

    static {
        C0740b c0740b = new C0740b();
        f68634a = c0740b;
        f68635b = c0740b;
    }

    public static kl.a a() {
        return f68635b;
    }
}
