package io.reactivex.rxjava3.internal.operators.flowable;

import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class a<T, R> extends io.reactivex.rxjava3.core.e<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final io.reactivex.rxjava3.core.e<T> f67370b;

    public a(io.reactivex.rxjava3.core.e<T> eVar) {
        Objects.requireNonNull(eVar, "source is null");
        this.f67370b = eVar;
    }
}
