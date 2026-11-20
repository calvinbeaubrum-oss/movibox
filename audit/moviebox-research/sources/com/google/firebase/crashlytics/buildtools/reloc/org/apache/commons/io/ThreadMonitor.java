package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
class ThreadMonitor implements Runnable {
    private final Thread thread;
    private final long timeout;

    private ThreadMonitor(Thread thread, long j11) {
        this.thread = thread;
        this.timeout = j11;
    }

    private static void sleep(long j11) throws InterruptedException {
        long jCurrentTimeMillis = System.currentTimeMillis() + j11;
        do {
            Thread.sleep(j11);
            j11 = jCurrentTimeMillis - System.currentTimeMillis();
        } while (j11 > 0);
    }

    public static Thread start(long j11) {
        return start(Thread.currentThread(), j11);
    }

    public static Thread start(Thread thread, long j11) {
        if (j11 <= 0) {
            return null;
        }
        Thread thread2 = new Thread(new ThreadMonitor(thread, j11), ThreadMonitor.class.getSimpleName());
        thread2.setDaemon(true);
        thread2.start();
        return thread2;
    }

    public static void stop(Thread thread) {
        if (thread != null) {
            thread.interrupt();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            sleep(this.timeout);
            this.thread.interrupt();
        } catch (InterruptedException unused) {
        }
    }
}
