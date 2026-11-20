package org.apache.tools.ant.util;

import java.util.Enumeration;
import java.util.Vector;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class Watchdog implements Runnable {
    public static final String ERROR_INVALID_TIMEOUT = "timeout less than 1.";
    private Vector observers = new Vector(1);
    private volatile boolean stopped = false;
    private long timeout;

    public Watchdog(long j11) {
        this.timeout = -1L;
        if (j11 < 1) {
            throw new IllegalArgumentException(ERROR_INVALID_TIMEOUT);
        }
        this.timeout = j11;
    }

    public void addTimeoutObserver(r rVar) {
        this.observers.addElement(rVar);
    }

    public final void fireTimeoutOccured() {
        Enumeration enumerationElements = this.observers.elements();
        while (enumerationElements.hasMoreElements()) {
            ((r) enumerationElements.nextElement()).timeoutOccured(this);
        }
    }

    public void removeTimeoutObserver(r rVar) {
        this.observers.removeElement(rVar);
    }

    @Override // java.lang.Runnable
    public synchronized void run() {
        long jCurrentTimeMillis = System.currentTimeMillis() + this.timeout;
        while (!this.stopped) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (jCurrentTimeMillis <= jCurrentTimeMillis2) {
                break;
            } else {
                try {
                    wait(jCurrentTimeMillis - jCurrentTimeMillis2);
                } catch (InterruptedException unused) {
                }
            }
        }
        if (!this.stopped) {
            fireTimeoutOccured();
        }
    }

    public synchronized void start() {
        this.stopped = false;
        Thread thread = new Thread(this, "WATCHDOG");
        thread.setDaemon(true);
        thread.start();
    }

    public synchronized void stop() {
        this.stopped = true;
        notifyAll();
    }
}
