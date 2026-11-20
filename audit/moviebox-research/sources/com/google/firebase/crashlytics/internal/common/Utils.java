package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class Utils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f40176a = ExecutorUtils.c("awaitEvenIfOnMainThread task continuation executor");

    public static <T> T d(Task<T> task) throws InterruptedException, TimeoutException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        task.continueWith(f40176a, new Continuation() { // from class: com.google.firebase.crashlytics.internal.common.h0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return Utils.g(countDownLatch, task2);
            }
        });
        countDownLatch.await(4L, TimeUnit.SECONDS);
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (task.isCanceled()) {
            throw new CancellationException("Task is already canceled");
        }
        if (task.isComplete()) {
            throw new IllegalStateException(task.getException());
        }
        throw new TimeoutException();
    }

    public static boolean e(CountDownLatch countDownLatch, long j11, TimeUnit timeUnit) {
        boolean zAwait;
        boolean z11 = false;
        try {
            long nanos = timeUnit.toNanos(j11);
            long jNanoTime = System.nanoTime() + nanos;
            while (true) {
                try {
                    zAwait = countDownLatch.await(nanos, TimeUnit.NANOSECONDS);
                    break;
                } catch (InterruptedException unused) {
                    z11 = true;
                    nanos = jNanoTime - System.nanoTime();
                }
            }
            if (z11) {
                Thread.currentThread().interrupt();
            }
            return zAwait;
        } catch (Throwable th2) {
            if (z11) {
                Thread.currentThread().interrupt();
            }
            throw th2;
        }
    }

    public static <T> Task<T> f(Executor executor, final Callable<Task<T>> callable) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.Utils.1

            /* JADX INFO: Add missing generic type declarations: [T] */
            /* JADX INFO: renamed from: com.google.firebase.crashlytics.internal.common.Utils$1$a */
            /* JADX INFO: compiled from: source.java */
            /* JADX INFO: loaded from: classes6.dex */
            public class a<T> implements Continuation<T, Void> {
                public a() {
                }

                @Override // com.google.android.gms.tasks.Continuation
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Void then(@NonNull Task<T> task) throws Exception {
                    if (task.isSuccessful()) {
                        taskCompletionSource.setResult(task.getResult());
                        return null;
                    }
                    taskCompletionSource.setException(task.getException());
                    return null;
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((Task) callable.call()).continueWith(new a());
                } catch (Exception e11) {
                    taskCompletionSource.setException(e11);
                }
            }
        });
        return taskCompletionSource.getTask();
    }

    public static /* synthetic */ Object g(CountDownLatch countDownLatch, Task task) throws Exception {
        countDownLatch.countDown();
        return null;
    }

    public static /* synthetic */ Void h(TaskCompletionSource taskCompletionSource, Task task) throws Exception {
        if (task.isSuccessful()) {
            taskCompletionSource.trySetResult(task.getResult());
            return null;
        }
        Exception exception = task.getException();
        Objects.requireNonNull(exception);
        taskCompletionSource.trySetException(exception);
        return null;
    }

    public static /* synthetic */ Void i(TaskCompletionSource taskCompletionSource, Task task) throws Exception {
        if (task.isSuccessful()) {
            taskCompletionSource.trySetResult(task.getResult());
            return null;
        }
        Exception exception = task.getException();
        Objects.requireNonNull(exception);
        taskCompletionSource.trySetException(exception);
        return null;
    }

    public static <T> Task<T> j(Task<T> task, Task<T> task2) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Continuation<T, TContinuationResult> continuation = new Continuation() { // from class: com.google.firebase.crashlytics.internal.common.g0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task3) {
                return Utils.h(taskCompletionSource, task3);
            }
        };
        task.continueWith(continuation);
        task2.continueWith(continuation);
        return taskCompletionSource.getTask();
    }

    public static <T> Task<T> k(Executor executor, Task<T> task, Task<T> task2) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Continuation<T, TContinuationResult> continuation = new Continuation() { // from class: com.google.firebase.crashlytics.internal.common.i0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task3) {
                return Utils.i(taskCompletionSource, task3);
            }
        };
        task.continueWith(executor, continuation);
        task2.continueWith(executor, continuation);
        return taskCompletionSource.getTask();
    }
}
