package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class EvictingQueue<E> extends u2<E> implements Serializable {
    private static final long serialVersionUID = 0;
    private final Queue<E> delegate;
    final int maxSize;

    private EvictingQueue(int i11) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.f(i11 >= 0, "maxSize (%s) must >= 0", i11);
        this.delegate = new ArrayDeque(i11);
        this.maxSize = i11;
    }

    public static <E> EvictingQueue<E> create(int i11) {
        return new EvictingQueue<>(i11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.util.Queue
    public boolean add(E e11) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(e11);
        if (this.maxSize == 0) {
            return true;
        }
        if (size() == this.maxSize) {
            this.delegate.remove();
        }
        this.delegate.add(e11);
        return true;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        int size = collection.size();
        if (size < this.maxSize) {
            return standardAddAll(collection);
        }
        clear();
        return j5.a(this, j5.j(collection, size - this.maxSize));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return delegate().contains(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(obj));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.u2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t2
    public Queue<E> delegate() {
        return this.delegate;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.u2, java.util.Queue
    public boolean offer(E e11) {
        return add(e11);
    }

    public int remainingCapacity() {
        return this.maxSize - size();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return delegate().remove(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(obj));
    }
}
