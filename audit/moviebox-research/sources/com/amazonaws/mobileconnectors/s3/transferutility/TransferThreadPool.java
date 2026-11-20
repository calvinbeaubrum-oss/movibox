package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class TransferThreadPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Log f15857a = LogFactory.b(TransferService.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ExecutorService f15858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ExecutorService f15859c;

    public static ExecutorService a(int i11) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i11, i11, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static synchronized void b(int i11) {
        try {
            f15857a.a("Initializing the thread pool of size: " + i11);
            int iMax = Math.max((int) Math.ceil(((double) i11) / 2.0d), 1);
            if (f15858b == null) {
                f15858b = a(iMax);
            }
            if (f15859c == null) {
                f15859c = a(iMax);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static <T> Future<T> c(Callable<T> callable) {
        b(TransferUtilityOptions.getDefaultThreadPoolSize());
        return callable instanceof UploadPartTask ? f15859c.submit(callable) : f15858b.submit(callable);
    }
}
