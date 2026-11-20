package io.reactivex.rxjava3.internal.subscriptions;

import m10.d;
import u30.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public enum EmptySubscription implements d<Object> {
    INSTANCE;

    public static void complete(c<?> cVar) {
        cVar.onSubscribe(INSTANCE);
        cVar.onComplete();
    }

    public static void error(Throwable th2, c<?> cVar) {
        cVar.onSubscribe(INSTANCE);
        cVar.onError(th2);
    }

    @Override // u30.d
    public void cancel() {
    }

    @Override // m10.g
    public void clear() {
    }

    @Override // m10.g
    public boolean isEmpty() {
        return true;
    }

    @Override // m10.g
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // m10.g
    public Object poll() {
        return null;
    }

    @Override // u30.d
    public void request(long j11) {
        SubscriptionHelper.validate(j11);
    }

    @Override // m10.c
    public int requestFusion(int i11) {
        return i11 & 2;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }
}
