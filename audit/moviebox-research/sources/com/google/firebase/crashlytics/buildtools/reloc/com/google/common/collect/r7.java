package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class r7<F, T> implements Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator<? extends F> f39757a;

    public r7(Iterator<? extends F> it) {
        this.f39757a = (Iterator) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(it);
    }

    public abstract T a(F f11);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f39757a.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return a(this.f39757a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f39757a.remove();
    }
}
