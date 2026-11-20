package org.apache.tools.ant.taskdefs;

import org.apache.tools.ant.a0;
import org.apache.tools.ant.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class Parallel extends z implements a0 {

    /* JADX INFO: renamed from: org.apache.tools.ant.taskdefs.Parallel$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass1 extends Thread {
        private final /* synthetic */ Parallel this$0;

        public AnonymousClass1(Parallel parallel) {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public synchronized void run() {
            try {
                wait(Parallel.v(null));
                synchronized (Parallel.x(null)) {
                    Parallel.y(null, false);
                    Parallel.z(null, true);
                    Parallel.x(null).notifyAll();
                }
            } catch (InterruptedException unused) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class TaskRunnable implements Runnable {
        private Throwable exception;
        private boolean finished;
        private z task;
        private final /* synthetic */ Parallel this$0;

        public TaskRunnable(Parallel parallel, z zVar) {
            this.task = zVar;
        }

        public Throwable getException() {
            return this.exception;
        }

        public boolean isFinished() {
            return this.finished;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.task.o();
                synchronized (Parallel.x(null)) {
                    this.finished = true;
                    Parallel.x(null).notifyAll();
                }
            } catch (Throwable th2) {
                try {
                    this.exception = th2;
                    if (Parallel.A(null)) {
                        Parallel.y(null, false);
                    }
                } finally {
                    synchronized (Parallel.x(null)) {
                        this.finished = true;
                        Parallel.x(null).notifyAll();
                    }
                }
            }
        }
    }

    public static /* synthetic */ boolean A(Parallel parallel) {
        throw null;
    }

    public static /* synthetic */ long v(Parallel parallel) {
        throw null;
    }

    public static /* synthetic */ Object x(Parallel parallel) {
        throw null;
    }

    public static /* synthetic */ boolean y(Parallel parallel, boolean z11) {
        throw null;
    }

    public static /* synthetic */ boolean z(Parallel parallel, boolean z11) {
        throw null;
    }
}
