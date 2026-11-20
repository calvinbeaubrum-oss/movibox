package io.reactivex.rxjava3.core;

import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class a implements c {
    public static NullPointerException c(Throwable th2) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th2);
        return nullPointerException;
    }

    @Override // io.reactivex.rxjava3.core.c
    public final void a(b bVar) {
        Objects.requireNonNull(bVar, "observer is null");
        try {
            b bVarU = p10.a.u(this, bVar);
            Objects.requireNonNull(bVarU, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            b(bVarU);
        } catch (NullPointerException e11) {
            throw e11;
        } catch (Throwable th2) {
            i10.a.b(th2);
            p10.a.q(th2);
            throw c(th2);
        }
    }

    public abstract void b(b bVar);
}
