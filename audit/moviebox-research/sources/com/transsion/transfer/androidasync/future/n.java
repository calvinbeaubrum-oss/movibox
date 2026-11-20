package com.transsion.transfer.androidasync.future;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class n implements com.transsion.transfer.androidasync.future.b {
    boolean cancelled;
    boolean complete;
    private com.transsion.transfer.androidasync.future.a parent;
    public static final com.transsion.transfer.androidasync.future.a COMPLETED = new a();
    public static final com.transsion.transfer.androidasync.future.a CANCELLED = new b();

    /* JADX INFO: compiled from: source.java */
    public class a extends n {
        public a() {
            setComplete();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends n {
        public b() {
            cancel();
        }
    }

    @Override // com.transsion.transfer.androidasync.future.a
    public boolean cancel() {
        synchronized (this) {
            try {
                if (this.complete) {
                    return false;
                }
                if (this.cancelled) {
                    return true;
                }
                this.cancelled = true;
                com.transsion.transfer.androidasync.future.a aVar = this.parent;
                this.parent = null;
                if (aVar != null) {
                    aVar.cancel();
                }
                cancelCleanup();
                cleanup();
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void cancelCleanup() {
    }

    public void cleanup() {
    }

    public void completeCleanup() {
    }

    @Override // com.transsion.transfer.androidasync.future.a
    public boolean isCancelled() {
        boolean z11;
        com.transsion.transfer.androidasync.future.a aVar;
        synchronized (this) {
            try {
                z11 = this.cancelled || ((aVar = this.parent) != null && aVar.isCancelled());
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z11;
    }

    public boolean isDone() {
        return this.complete;
    }

    public com.transsion.transfer.androidasync.future.a reset() {
        cancel();
        this.complete = false;
        this.cancelled = false;
        return this;
    }

    public boolean setComplete() {
        synchronized (this) {
            try {
                if (this.cancelled) {
                    return false;
                }
                if (this.complete) {
                    return false;
                }
                this.complete = true;
                this.parent = null;
                completeCleanup();
                cleanup();
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.transsion.transfer.androidasync.future.b
    public boolean setParent(com.transsion.transfer.androidasync.future.a aVar) {
        synchronized (this) {
            try {
                if (isDone()) {
                    return false;
                }
                this.parent = aVar;
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
