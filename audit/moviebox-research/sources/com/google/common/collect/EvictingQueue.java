package com.google.common.collect;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class EvictingQueue<E> extends y<E> implements Serializable {
    private static final long serialVersionUID = 0;
    private final Queue<E> delegate;
    final int maxSize;

    private EvictingQueue(int i11) {
        com.google.common.base.m.g(i11 >= 0, "maxSize (%s) must >= 0", i11);
        this.delegate = new ArrayDeque(i11);
        this.maxSize = i11;
    }

    public static <E> EvictingQueue<E> create(int i11) {
        return new EvictingQueue<>(i11);
    }

    @Override // com.google.common.collect.r, java.util.Collection, java.util.Queue
    public boolean add(E e11) {
        com.google.common.base.m.p(e11);
        if (this.maxSize == 0) {
            return true;
        }
        if (size() == this.maxSize) {
            this.delegate.remove();
        }
        this.delegate.add(e11);
        return true;
    }

    @Override // com.google.common.collect.r, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        int size = collection.size();
        if (size < this.maxSize) {
            return standardAddAll(collection);
        }
        clear();
        return e0.a(this, e0.n(collection, size - this.maxSize));
    }

    @Override // com.google.common.collect.y, com.google.common.collect.r, com.google.common.collect.x
    /* JADX INFO: renamed from: delegate */
    public Queue<E> u() {
        return this.delegate;
    }

    @Override // com.google.common.collect.y, java.util.Queue
    public boolean offer(E e11) {
        return add(e11);
    }

    public int remainingCapacity() {
        return this.maxSize - size();
    }

    @Override // com.google.common.collect.r, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return super.toArray();
    }
}
