package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class SequentialExecutor implements Executor {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Logger f39966g = Logger.getLogger(SequentialExecutor.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f39967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Deque<Runnable> f39968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WorkerRunningState f39969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f39970d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final QueueWorker f39971f;

    /* JADX INFO: compiled from: source.java */
    public final class QueueWorker implements Runnable {
        private QueueWorker() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
        
            if (r1 == false) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
        
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x004c, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0052, code lost:
        
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0053, code lost:
        
            r3.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0059, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x005a, code lost:
        
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor.f39966g.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + r3, (java.lang.Throwable) r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:?, code lost:
        
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
                    synchronized (SequentialExecutor.this.f39968b) {
                        if (!z11) {
                            WorkerRunningState workerRunningState = SequentialExecutor.this.f39969c;
                            WorkerRunningState workerRunningState2 = WorkerRunningState.RUNNING;
                            if (workerRunningState != workerRunningState2) {
                                SequentialExecutor.d(SequentialExecutor.this);
                                SequentialExecutor.this.f39969c = workerRunningState2;
                                z11 = true;
                            }
                        }
                        Runnable runnable = (Runnable) SequentialExecutor.this.f39968b.poll();
                        if (runnable == null) {
                            SequentialExecutor.this.f39969c = WorkerRunningState.IDLE;
                        }
                    }
                    if (zInterrupted) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
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
                synchronized (SequentialExecutor.this.f39968b) {
                    SequentialExecutor.this.f39969c = WorkerRunningState.IDLE;
                    throw e11;
                }
            }
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
        long j11 = sequentialExecutor.f39970d;
        sequentialExecutor.f39970d = 1 + j11;
        return j11;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0061  */
    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        WorkerRunningState workerRunningState;
        boolean z11;
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(runnable);
        synchronized (this.f39968b) {
            WorkerRunningState workerRunningState2 = this.f39969c;
            if (workerRunningState2 != WorkerRunningState.RUNNING && workerRunningState2 != (workerRunningState = WorkerRunningState.QUEUED)) {
                long j11 = this.f39970d;
                Runnable runnable2 = new Runnable() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        runnable.run();
                    }
                };
                this.f39968b.add(runnable2);
                WorkerRunningState workerRunningState3 = WorkerRunningState.QUEUING;
                this.f39969c = workerRunningState3;
                try {
                    this.f39967a.execute(this.f39971f);
                    if (this.f39969c != workerRunningState3) {
                        return;
                    }
                    synchronized (this.f39968b) {
                        try {
                            if (this.f39970d == j11 && this.f39969c == workerRunningState3) {
                                this.f39969c = workerRunningState;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    return;
                } catch (Error | RuntimeException e11) {
                    synchronized (this.f39968b) {
                        try {
                            WorkerRunningState workerRunningState4 = this.f39969c;
                            if (workerRunningState4 != WorkerRunningState.IDLE && workerRunningState4 != WorkerRunningState.QUEUING) {
                                z11 = false;
                            } else if (this.f39968b.removeLastOccurrence(runnable2)) {
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
            this.f39968b.add(runnable);
        }
    }
}
