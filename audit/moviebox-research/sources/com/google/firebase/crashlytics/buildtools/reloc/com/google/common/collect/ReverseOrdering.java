package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class ReverseOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Ordering<? super T> forwardOrder;

    public ReverseOrdering(Ordering<? super T> ordering) {
        this.forwardOrder = (Ordering) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(ordering);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T t11, T t12) {
        return this.forwardOrder.compare(t12, t11);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReverseOrdering) {
            return this.forwardOrder.equals(((ReverseOrdering) obj).forwardOrder);
        }
        return false;
    }

    public int hashCode() {
        return -this.forwardOrder.hashCode();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Ordering
    public <E extends T> E max(Iterable<E> iterable) {
        return (E) this.forwardOrder.min(iterable);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Ordering
    public <E extends T> E max(E e11, E e12) {
        return (E) this.forwardOrder.min(e11, e12);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Ordering
    public <E extends T> E max(E e11, E e12, E e13, E... eArr) {
        return (E) this.forwardOrder.min(e11, e12, e13, eArr);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Ordering
    public <E extends T> E max(Iterator<E> it) {
        return (E) this.forwardOrder.min(it);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Ordering
    public <E extends T> E min(Iterable<E> iterable) {
        return (E) this.forwardOrder.max(iterable);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Ordering
    public <E extends T> E min(E e11, E e12) {
        return (E) this.forwardOrder.max(e11, e12);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Ordering
    public <E extends T> E min(E e11, E e12, E e13, E... eArr) {
        return (E) this.forwardOrder.max(e11, e12, e13, eArr);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Ordering
    public <E extends T> E min(Iterator<E> it) {
        return (E) this.forwardOrder.max(it);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Ordering
    public <S extends T> Ordering<S> reverse() {
        return this.forwardOrder;
    }

    public String toString() {
        return this.forwardOrder + ".reverse()";
    }
}
