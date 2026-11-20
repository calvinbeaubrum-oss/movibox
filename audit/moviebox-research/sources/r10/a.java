package r10;

import h10.b;
import io.reactivex.rxjava3.core.f;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.c;
import java.util.concurrent.atomic.AtomicReference;
import u30.d;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class a<T> implements f<T>, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<d> f75089a = new AtomicReference<>();

    public void a() {
        this.f75089a.get().request(Long.MAX_VALUE);
    }

    @Override // h10.b
    public final void dispose() {
        SubscriptionHelper.cancel(this.f75089a);
    }

    @Override // h10.b
    public final boolean isDisposed() {
        return this.f75089a.get() == SubscriptionHelper.CANCELLED;
    }

    @Override // u30.c
    public final void onSubscribe(d dVar) {
        if (c.d(this.f75089a, dVar, getClass())) {
            a();
        }
    }
}
