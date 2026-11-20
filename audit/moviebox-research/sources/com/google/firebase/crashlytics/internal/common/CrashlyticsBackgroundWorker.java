package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class CrashlyticsBackgroundWorker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f40101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Task<Void> f40102b = Tasks.forResult(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f40103c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ThreadLocal<Boolean> f40104d = new ThreadLocal<>();

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public class a implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f40105a;

        public a(Runnable runnable) {
            this.f40105a = runnable;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            this.f40105a.run();
            return null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public class b<T> implements Continuation<Void, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Callable f40107a;

        public b(Callable callable) {
            this.f40107a = callable;
        }

        @Override // com.google.android.gms.tasks.Continuation
        public T then(@NonNull Task<Void> task) throws Exception {
            return (T) this.f40107a.call();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public class c<T> implements Continuation<T, Void> {
        public c() {
        }

        @Override // com.google.android.gms.tasks.Continuation
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void then(@NonNull Task<T> task) throws Exception {
            return null;
        }
    }

    public CrashlyticsBackgroundWorker(Executor executor) {
        this.f40101a = executor;
        executor.execute(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker.1
            @Override // java.lang.Runnable
            public void run() {
                CrashlyticsBackgroundWorker.this.f40104d.set(Boolean.TRUE);
            }
        });
    }

    public void b() {
        if (!e()) {
            throw new IllegalStateException("Not running on background worker thread as intended.");
        }
    }

    public Executor c() {
        return this.f40101a;
    }

    public final <T> Task<Void> d(Task<T> task) {
        return task.continueWith(this.f40101a, new c());
    }

    public final boolean e() {
        return Boolean.TRUE.equals(this.f40104d.get());
    }

    public final <T> Continuation<Void, T> f(Callable<T> callable) {
        return new b(callable);
    }

    public Task<Void> g(Runnable runnable) {
        return h(new a(runnable));
    }

    public <T> Task<T> h(Callable<T> callable) {
        Task<T> taskContinueWith;
        synchronized (this.f40103c) {
            taskContinueWith = this.f40102b.continueWith(this.f40101a, f(callable));
            this.f40102b = d(taskContinueWith);
        }
        return taskContinueWith;
    }

    public <T> Task<T> i(Callable<Task<T>> callable) {
        Task<T> taskContinueWithTask;
        synchronized (this.f40103c) {
            taskContinueWithTask = this.f40102b.continueWithTask(this.f40101a, f(callable));
            this.f40102b = d(taskContinueWithTask);
        }
        return taskContinueWithTask;
    }
}
