package io.reactivex.rxjava3.internal.operators.flowable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class f<T, B> extends r10.a<B> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FlowableWindowBoundary$WindowBoundaryMainSubscriber<T, B> f67375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f67376c;

    public f(FlowableWindowBoundary$WindowBoundaryMainSubscriber<T, B> flowableWindowBoundary$WindowBoundaryMainSubscriber) {
        this.f67375b = flowableWindowBoundary$WindowBoundaryMainSubscriber;
    }

    @Override // u30.c
    public void onComplete() {
        if (this.f67376c) {
            return;
        }
        this.f67376c = true;
        this.f67375b.innerComplete();
    }

    @Override // u30.c
    public void onError(Throwable th2) {
        if (this.f67376c) {
            p10.a.q(th2);
        } else {
            this.f67376c = true;
            this.f67375b.innerError(th2);
        }
    }

    @Override // u30.c
    public void onNext(B b11) {
        if (this.f67376c) {
            return;
        }
        this.f67375b.innerNext();
    }
}
