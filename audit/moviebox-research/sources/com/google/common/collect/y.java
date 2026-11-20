package com.google.common.collect;

import java.util.NoSuchElementException;
import java.util.Queue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class y<E> extends r<E> implements Queue<E> {
    @Override // com.google.common.collect.r, com.google.common.collect.x
    /* JADX INFO: renamed from: delegate */
    public abstract Queue<E> u();

    @Override // java.util.Queue
    public E element() {
        return u().element();
    }

    public boolean offer(E e11) {
        return u().offer(e11);
    }

    @Override // java.util.Queue
    public E peek() {
        return u().peek();
    }

    @Override // java.util.Queue
    public E poll() {
        return u().poll();
    }

    @Override // java.util.Queue
    public E remove() {
        return u().remove();
    }

    public boolean standardOffer(E e11) {
        try {
            return add(e11);
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    public E standardPeek() {
        try {
            return element();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    public E standardPoll() {
        try {
            return remove();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }
}
