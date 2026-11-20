package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class e<T> extends io.reactivex.rxjava3.core.j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k10.k<? extends Throwable> f67426a;

    public e(k10.k<? extends Throwable> kVar) {
        this.f67426a = kVar;
    }

    @Override // io.reactivex.rxjava3.core.j
    public void z(io.reactivex.rxjava3.core.o<? super T> oVar) {
        try {
            th = (Throwable) ExceptionHelper.c(this.f67426a.get(), "Supplier returned a null Throwable.");
        } catch (Throwable th2) {
            th = th2;
            i10.a.b(th);
        }
        EmptyDisposable.error(th, oVar);
    }
}
