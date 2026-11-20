package com.google.common.util.concurrent;

import com.google.j2objc.annotations.RetainedWith;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class SequentialExecutor implements Executor {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Logger f38901g = Logger.getLogger(SequentialExecutor.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f38902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Deque<Runnable> f38903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WorkerRunningState f38904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f38905d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @RetainedWith
    public final QueueWorker f38906f;

    /* JADX INFO: compiled from: source.java */
    public final class QueueWorker implements Runnable {
        Runnable task;

        private QueueWorker() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0045, code lost:
        
            if (r1 == false) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
        
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x004e, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0054, code lost:
        
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
        
            r8.task.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0060, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0062, code lost:
        
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0063, code lost:
        
            com.google.common.util.concurrent.SequentialExecutor.f38901g.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + r8.task, (java.lang.Throwable) r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0080, code lost:
        
            r8.task = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0082, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void workOnQueue() {
            boolean z11 = false;
            boolean zInterrupted = false;
            while (true) {
                try {
                    synchronized (SequentialExecutor.this.f38903b) {
                        if (!z11) {
                            WorkerRunningState workerRunningState = SequentialExecutor.this.f38904c;
                            WorkerRunningState workerRunningState2 = WorkerRunningState.RUNNING;
                            if (workerRunningState != workerRunningState2) {
                                SequentialExecutor.d(SequentialExecutor.this);
                                SequentialExecutor.this.f38904c = workerRunningState2;
                                z11 = true;
                            }
                        }
                        Runnable runnable = (Runnable) SequentialExecutor.this.f38903b.poll();
                        this.task = runnable;
                        if (runnable == null) {
                            SequentialExecutor.this.f38904c = WorkerRunningState.IDLE;
                        }
                    }
                    if (zInterrupted) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                    this.task = null;
                } catch (Throwable th2) {
                    if (zInterrupted) {
                        Thread.currentThread().interrupt();
                    }
                    throw th2;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                workOnQueue();
            } catch (Error e11) {
                synchronized (SequentialExecutor.this.f38903b) {
                    SequentialExecutor.this.f38904c = WorkerRunningState.IDLE;
                    throw e11;
                }
            }
        }

        public String toString() {
            Runnable runnable = this.task;
            if (runnable != null) {
                return "SequentialExecutorWorker{running=" + runnable + "}";
            }
            return "SequentialExecutorWorker{state=" + SequentialExecutor.this.f38904c + "}";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum WorkerRunningState {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    public static /* synthetic */ long d(SequentialExecutor sequentialExecutor) {
        long j11 = sequentialExecutor.f38905d;
        sequentialExecutor.f38905d = 1 + j11;
        return j11;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0061  */
    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        WorkerRunningState workerRunningState;
        boolean z11;
        com.google.common.base.m.p(runnable);
        synchronized (this.f38903b) {
            WorkerRunningState workerRunningState2 = this.f38904c;
            if (workerRunningState2 != WorkerRunningState.RUNNING && workerRunningState2 != (workerRunningState = WorkerRunningState.QUEUED)) {
                long j11 = this.f38905d;
                Runnable runnable2 = new Runnable(this) { // from class: com.google.common.util.concurrent.SequentialExecutor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        runnable.run();
                    }

                    public String toString() {
                        return runnable.toString();
                    }
                };
                this.f38903b.add(runnable2);
                WorkerRunningState workerRunningState3 = WorkerRunningState.QUEUING;
                this.f38904c = workerRunningState3;
                try {
                    this.f38902a.execute(this.f38906f);
                    if (this.f38904c != workerRunningState3) {
                        return;
                    }
                    synchronized (this.f38903b) {
                        try {
                            if (this.f38905d == j11 && this.f38904c == workerRunningState3) {
                                this.f38904c = workerRunningState;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    return;
                } catch (Error | RuntimeException e11) {
                    synchronized (this.f38903b) {
                        try {
                            WorkerRunningState workerRunningState4 = this.f38904c;
                            if (workerRunningState4 != WorkerRunningState.IDLE && workerRunningState4 != WorkerRunningState.QUEUING) {
                                z11 = false;
                            } else if (this.f38903b.removeLastOccurrence(runnable2)) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (!(e11 instanceof RejectedExecutionException) || z11) {
                                throw e11;
                            }
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                    return;
                }
            }
            this.f38903b.add(runnable);
        }
    }

    public String toString() {
        return "SequentialExecutor@" + System.identityHashCode(this) + "{" + this.f38902a + "}";
    }
}
