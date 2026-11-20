package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class SerialExecutorImpl implements t6.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f13493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Runnable f13494c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque<Task> f13492a = new ArrayDeque<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f13495d = new Object();

    /* JADX INFO: compiled from: source.java */
    public static class Task implements Runnable {
        final Runnable mRunnable;
        final SerialExecutorImpl mSerialExecutor;

        public Task(@NonNull SerialExecutorImpl serialExecutorImpl, @NonNull Runnable runnable) {
            this.mSerialExecutor = serialExecutorImpl;
            this.mRunnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.mRunnable.run();
                synchronized (this.mSerialExecutor.f13495d) {
                    this.mSerialExecutor.a();
                }
            } catch (Throwable th2) {
                synchronized (this.mSerialExecutor.f13495d) {
                    this.mSerialExecutor.a();
                    throw th2;
                }
            }
        }
    }

    public SerialExecutorImpl(@NonNull Executor executor) {
        this.f13493b = executor;
    }

    public void a() {
        Task taskPoll = this.f13492a.poll();
        this.f13494c = taskPoll;
        if (taskPoll != null) {
            this.f13493b.execute(taskPoll);
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        synchronized (this.f13495d) {
            try {
                this.f13492a.add(new Task(this, runnable));
                if (this.f13494c == null) {
                    a();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // t6.a
    public boolean m() {
        boolean z11;
        synchronized (this.f13495d) {
            z11 = !this.f13492a.isEmpty();
        }
        return z11;
    }
}
