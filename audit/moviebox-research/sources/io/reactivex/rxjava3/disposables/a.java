package io.reactivex.rxjava3.disposables;

import h10.b;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class a {
    public static b a() {
        return EmptyDisposable.INSTANCE;
    }

    public static b b(Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }
}
