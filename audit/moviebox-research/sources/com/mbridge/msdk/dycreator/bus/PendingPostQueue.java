package com.mbridge.msdk.dycreator.bus;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class PendingPostQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PendingPost f43654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PendingPost f43655b;

    public final synchronized PendingPost a() {
        PendingPost pendingPost;
        pendingPost = this.f43654a;
        if (pendingPost != null) {
            PendingPost pendingPost2 = pendingPost.f43653c;
            this.f43654a = pendingPost2;
            if (pendingPost2 == null) {
                this.f43655b = null;
            }
        }
        return pendingPost;
    }

    public final synchronized PendingPost a(int i11) throws InterruptedException {
        try {
            if (this.f43654a == null) {
                wait(i11);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return a();
    }

    public final synchronized void a(PendingPost pendingPost) {
        try {
            if (pendingPost == null) {
                throw new NullPointerException("null cannot be enqueued");
            }
            PendingPost pendingPost2 = this.f43655b;
            if (pendingPost2 != null) {
                pendingPost2.f43653c = pendingPost;
                this.f43655b = pendingPost;
            } else {
                if (this.f43654a != null) {
                    throw new IllegalStateException("Head present, but no tail");
                }
                this.f43655b = pendingPost;
                this.f43654a = pendingPost;
            }
            notifyAll();
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
