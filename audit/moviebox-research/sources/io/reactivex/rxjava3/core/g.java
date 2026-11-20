package io.reactivex.rxjava3.core;

import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class g<T> implements i<T> {
    @Override // io.reactivex.rxjava3.core.i
    public final void a(h<? super T> hVar) {
        Objects.requireNonNull(hVar, "observer is null");
        h<? super T> hVarV = p10.a.v(this, hVar);
        Objects.requireNonNull(hVarV, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            b(hVarV);
        } catch (NullPointerException e11) {
            throw e11;
        } catch (Throwable th2) {
            i10.a.b(th2);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }

    public abstract void b(h<? super T> hVar);
}
