package o10;

import h10.b;
import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.c;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class a<T> implements o<T>, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<b> f72259a = new AtomicReference<>();

    public void a() {
    }

    @Override // h10.b
    public final void dispose() {
        DisposableHelper.dispose(this.f72259a);
    }

    @Override // h10.b
    public final boolean isDisposed() {
        return this.f72259a.get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.rxjava3.core.o
    public final void onSubscribe(b bVar) {
        if (c.c(this.f72259a, bVar, getClass())) {
            a();
        }
    }
}
