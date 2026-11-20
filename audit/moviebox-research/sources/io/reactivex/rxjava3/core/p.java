package io.reactivex.rxjava3.core;

import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class p<T> implements r<T> {
    @Override // io.reactivex.rxjava3.core.r
    public final void a(q<? super T> qVar) {
        Objects.requireNonNull(qVar, "observer is null");
        q<? super T> qVarX = p10.a.x(this, qVar);
        Objects.requireNonNull(qVarX, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            b(qVarX);
        } catch (NullPointerException e11) {
            throw e11;
        } catch (Throwable th2) {
            i10.a.b(th2);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }

    public abstract void b(q<? super T> qVar);
}
