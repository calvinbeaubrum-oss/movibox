package com.mbridge.msdk.dycreator.bus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class HandlerPoster extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PendingPostQueue f43646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f43647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EventBus f43648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f43649d;

    public HandlerPoster(EventBus eventBus, Looper looper, int i11) {
        super(looper);
        this.f43648c = eventBus;
        this.f43647b = i11;
        this.f43646a = new PendingPostQueue();
    }

    public final void a(Subscription subscription, Object obj) {
        PendingPost pendingPostA = PendingPost.a(subscription, obj);
        synchronized (this) {
            try {
                this.f43646a.a(pendingPostA);
                if (!this.f43649d) {
                    this.f43649d = true;
                    if (!sendMessage(obtainMessage())) {
                        throw new EventBusException("Could not send handler message");
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            long jUptimeMillis = SystemClock.uptimeMillis();
            do {
                PendingPost pendingPostA = this.f43646a.a();
                if (pendingPostA == null) {
                    synchronized (this) {
                        pendingPostA = this.f43646a.a();
                        if (pendingPostA == null) {
                            this.f43649d = false;
                            return;
                        }
                    }
                }
                this.f43648c.a(pendingPostA);
            } while (SystemClock.uptimeMillis() - jUptimeMillis < this.f43647b);
            if (!sendMessage(obtainMessage())) {
                throw new EventBusException("Could not send handler message");
            }
            this.f43649d = true;
        } catch (Throwable th2) {
            this.f43649d = false;
            throw th2;
        }
    }
}
