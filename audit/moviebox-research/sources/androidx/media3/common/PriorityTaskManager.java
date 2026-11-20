package androidx.media3.common;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class PriorityTaskManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f8895a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PriorityQueue<Integer> f8896b = new PriorityQueue<>(10, Collections.reverseOrder());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8897c = Integer.MIN_VALUE;

    /* JADX INFO: compiled from: source.java */
    public static class PriorityTooLowException extends IOException {
        public PriorityTooLowException(int i11, int i12) {
            super("Priority too low [priority=" + i11 + ", highest=" + i12 + "]");
        }
    }

    public void a(int i11) {
        synchronized (this.f8895a) {
            this.f8896b.add(Integer.valueOf(i11));
            this.f8897c = Math.max(this.f8897c, i11);
        }
    }

    public void b(int i11) throws InterruptedException {
        synchronized (this.f8895a) {
            while (this.f8897c != i11) {
                try {
                    this.f8895a.wait();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public void c(int i11) throws PriorityTooLowException {
        synchronized (this.f8895a) {
            try {
                if (this.f8897c != i11) {
                    throw new PriorityTooLowException(i11, this.f8897c);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void d(int i11) {
        synchronized (this.f8895a) {
            this.f8896b.remove(Integer.valueOf(i11));
            this.f8897c = this.f8896b.isEmpty() ? Integer.MIN_VALUE : ((Integer) u0.i(this.f8896b.peek())).intValue();
            this.f8895a.notifyAll();
        }
    }
}
