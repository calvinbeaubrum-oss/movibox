package com.google.common.util.concurrent;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ExecutionSequencer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f38890a;

    /* JADX INFO: compiled from: source.java */
    public enum RunningState {
        NOT_RUN,
        CANCELLED,
        STARTED
    }

    /* JADX INFO: compiled from: source.java */
    public static final class TaskNonReentrantExecutor extends AtomicReference<RunningState> implements Executor, Runnable {
        Executor delegate;
        ExecutionSequencer sequencer;
        Thread submitting;
        Runnable task;

        private TaskNonReentrantExecutor(Executor executor, ExecutionSequencer executionSequencer) {
            super(RunningState.NOT_RUN);
            this.delegate = executor;
        }

        public /* synthetic */ TaskNonReentrantExecutor(Executor executor, ExecutionSequencer executionSequencer, j jVar) {
            this(executor, executionSequencer);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean trySetCancelled() {
            return compareAndSet(RunningState.NOT_RUN, RunningState.CANCELLED);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean trySetStarted() {
            return compareAndSet(RunningState.NOT_RUN, RunningState.STARTED);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (get() == RunningState.CANCELLED) {
                this.delegate = null;
                return;
            }
            this.submitting = Thread.currentThread();
            try {
                ExecutionSequencer executionSequencer = this.sequencer;
                Objects.requireNonNull(executionSequencer);
                a aVar = executionSequencer.f38890a;
                if (aVar.f38891a == this.submitting) {
                    com.google.common.base.m.v(aVar.f38892b == null);
                    aVar.f38892b = runnable;
                    Executor executor = this.delegate;
                    Objects.requireNonNull(executor);
                    aVar.f38893c = executor;
                    this.delegate = null;
                } else {
                    Executor executor2 = this.delegate;
                    Objects.requireNonNull(executor2);
                    this.delegate = null;
                    this.task = runnable;
                    executor2.execute(this);
                }
            } finally {
                this.submitting = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Executor executor;
            Thread threadCurrentThread = Thread.currentThread();
            j jVar = null;
            if (threadCurrentThread != this.submitting) {
                Runnable runnable = this.task;
                Objects.requireNonNull(runnable);
                this.task = null;
                runnable.run();
                return;
            }
            a aVar = new a(jVar);
            aVar.f38891a = threadCurrentThread;
            ExecutionSequencer executionSequencer = this.sequencer;
            Objects.requireNonNull(executionSequencer);
            executionSequencer.f38890a = aVar;
            try {
                Runnable runnable2 = this.task;
                Objects.requireNonNull(runnable2);
                this.task = null;
                runnable2.run();
                while (true) {
                    Runnable runnable3 = aVar.f38892b;
                    if (runnable3 == null || (executor = aVar.f38893c) == null) {
                        break;
                    }
                    aVar.f38892b = null;
                    aVar.f38893c = null;
                    executor.execute(runnable3);
                }
                aVar.f38891a = null;
            } catch (Throwable th2) {
                aVar.f38891a = null;
                throw th2;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Thread f38891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Runnable f38892b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Executor f38893c;

        public a() {
        }

        public /* synthetic */ a(j jVar) {
            this();
        }
    }
}
