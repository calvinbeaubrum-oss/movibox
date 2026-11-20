package com.mbridge.msdk.dycreator.bus;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
class AsyncPoster implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PendingPostQueue f43621a = new PendingPostQueue();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EventBus f43622b;

    public AsyncPoster(EventBus eventBus) {
        this.f43622b = eventBus;
    }

    public void enqueue(Subscription subscription, Object obj) {
        this.f43621a.a(PendingPost.a(subscription, obj));
        EventBus.f43626a.execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        PendingPost pendingPostA = this.f43621a.a();
        if (pendingPostA == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.f43622b.a(pendingPostA);
    }
}
