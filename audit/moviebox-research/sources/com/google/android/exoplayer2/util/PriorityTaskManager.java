package com.google.android.exoplayer2.util;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class PriorityTaskManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f35536a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PriorityQueue<Integer> f35537b = new PriorityQueue<>(10, Collections.reverseOrder());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f35538c = Integer.MIN_VALUE;

    /* JADX INFO: compiled from: source.java */
    public static class PriorityTooLowException extends IOException {
        public PriorityTooLowException(int i11, int i12) {
            super("Priority too low [priority=" + i11 + ", highest=" + i12 + "]");
        }
    }

    public void a(int i11) {
        synchronized (this.f35536a) {
            this.f35537b.add(Integer.valueOf(i11));
            this.f35538c = Math.max(this.f35538c, i11);
        }
    }

    public void b(int i11) throws InterruptedException {
        synchronized (this.f35536a) {
            while (this.f35538c != i11) {
                try {
                    this.f35536a.wait();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public void c(int i11) throws PriorityTooLowException {
        synchronized (this.f35536a) {
            try {
                if (this.f35538c != i11) {
                    throw new PriorityTooLowException(i11, this.f35538c);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void d(int i11) {
        synchronized (this.f35536a) {
            this.f35537b.remove(Integer.valueOf(i11));
            this.f35538c = this.f35537b.isEmpty() ? Integer.MIN_VALUE : ((Integer) o0.j(this.f35537b.peek())).intValue();
            this.f35536a.notifyAll();
        }
    }
}
