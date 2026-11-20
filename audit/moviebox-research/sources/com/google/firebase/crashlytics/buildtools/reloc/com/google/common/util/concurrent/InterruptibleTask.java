package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
abstract class InterruptibleTask<T> extends AtomicReference<Runnable> implements Runnable {
    private static final Runnable DONE;
    private static final Runnable INTERRUPTING;

    /* JADX INFO: compiled from: source.java */
    public static final class DoNothingRunnable implements Runnable {
        private DoNothingRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    static {
        DONE = new DoNothingRunnable();
        INTERRUPTING = new DoNothingRunnable();
    }

    public abstract void afterRanInterruptibly(T t11, Throwable th2);

    public final void interruptTask() {
        Runnable runnable = get();
        if ((runnable instanceof Thread) && compareAndSet(runnable, INTERRUPTING)) {
            ((Thread) runnable).interrupt();
            set(DONE);
        }
    }

    public abstract boolean isDone();

    @Override // java.lang.Runnable
    public final void run() {
        T tRunInterruptibly;
        Thread threadCurrentThread = Thread.currentThread();
        if (compareAndSet(null, threadCurrentThread)) {
            boolean z11 = !isDone();
            if (z11) {
                try {
                    tRunInterruptibly = runInterruptibly();
                } catch (Throwable th2) {
                    if (!compareAndSet(threadCurrentThread, DONE)) {
                        while (get() == INTERRUPTING) {
                            Thread.yield();
                        }
                    }
                    if (z11) {
                        afterRanInterruptibly(null, th2);
                        return;
                    }
                    return;
                }
            } else {
                tRunInterruptibly = null;
            }
            if (!compareAndSet(threadCurrentThread, DONE)) {
                while (get() == INTERRUPTING) {
                    Thread.yield();
                }
            }
            if (z11) {
                afterRanInterruptibly(tRunInterruptibly, null);
            }
        }
    }

    public abstract T runInterruptibly() throws Exception;

    public abstract String toPendingString();

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String str;
        Runnable runnable = get();
        if (runnable == DONE) {
            str = "running=[DONE]";
        } else if (runnable == INTERRUPTING) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            str = "running=[RUNNING ON " + ((Thread) runnable).getName() + "]";
        } else {
            str = "running=[NOT STARTED YET]";
        }
        return str + ", " + toPendingString();
    }
}
