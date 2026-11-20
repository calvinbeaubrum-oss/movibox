package com.mbridge.msdk.dycreator.bus;

import android.util.Log;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class BackgroundPoster implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PendingPostQueue f43623a = new PendingPostQueue();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f43624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EventBus f43625c;

    public BackgroundPoster(EventBus eventBus) {
        this.f43625c = eventBus;
    }

    public final void enqueue(Subscription subscription, Object obj) {
        PendingPost pendingPostA = PendingPost.a(subscription, obj);
        synchronized (this) {
            try {
                this.f43623a.a(pendingPostA);
                if (!this.f43624b) {
                    this.f43624b = true;
                    EventBus.f43626a.execute(this);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        while (true) {
            try {
                try {
                    PendingPost pendingPostA = this.f43623a.a(1000);
                    if (pendingPostA == null) {
                        synchronized (this) {
                            pendingPostA = this.f43623a.a();
                            if (pendingPostA == null) {
                                this.f43624b = false;
                                this.f43624b = false;
                                return;
                            }
                        }
                    }
                    this.f43625c.a(pendingPostA);
                } catch (InterruptedException e11) {
                    Log.w("Event", Thread.currentThread().getName() + " was interruppted", e11);
                    this.f43624b = false;
                    return;
                }
            } catch (Throwable th2) {
                this.f43624b = false;
                throw th2;
            }
        }
    }
}
