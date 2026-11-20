package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.q;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class SingleDelay$Delay implements q<Object> {

    /* JADX INFO: compiled from: source.java */
    public final class OnError implements Runnable {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Throwable f67457e;
        final /* synthetic */ SingleDelay$Delay this$1;

        public OnError(SingleDelay$Delay singleDelay$Delay, Throwable th2) {
            this.f67457e = th2;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class OnSuccess implements Runnable {
        final /* synthetic */ SingleDelay$Delay this$1;
        private final Object value;

        public OnSuccess(SingleDelay$Delay singleDelay$Delay, Object obj) {
            this.value = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw null;
        }
    }
}
