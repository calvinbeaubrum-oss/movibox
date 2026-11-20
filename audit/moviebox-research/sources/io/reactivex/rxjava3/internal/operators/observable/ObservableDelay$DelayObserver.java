package io.reactivex.rxjava3.internal.operators.observable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class ObservableDelay$DelayObserver<T> implements io.reactivex.rxjava3.core.o<T>, h10.b {

    /* JADX INFO: compiled from: source.java */
    public final class OnComplete implements Runnable {
        final /* synthetic */ ObservableDelay$DelayObserver this$0;

        public OnComplete(ObservableDelay$DelayObserver observableDelay$DelayObserver) {
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:?, code lost:
        
            throw null;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            try {
                throw null;
            } catch (Throwable unused) {
                throw null;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class OnError implements Runnable {
        final /* synthetic */ ObservableDelay$DelayObserver this$0;
        private final Throwable throwable;

        public OnError(ObservableDelay$DelayObserver observableDelay$DelayObserver, Throwable th2) {
            this.throwable = th2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:?, code lost:
        
            throw null;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            try {
                throw null;
            } catch (Throwable unused) {
                throw null;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class OnNext implements Runnable {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final T f67394t;
        final /* synthetic */ ObservableDelay$DelayObserver this$0;

        public OnNext(ObservableDelay$DelayObserver observableDelay$DelayObserver, T t11) {
            this.f67394t = t11;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw null;
        }
    }
}
