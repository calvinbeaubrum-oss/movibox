package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class r<E> extends x implements Collection<E> {
    public boolean add(E e11) {
        return u().add(e11);
    }

    public boolean addAll(Collection<? extends E> collection) {
        return u().addAll(collection);
    }

    public void clear() {
        u().clear();
    }

    public boolean contains(Object obj) {
        return u().contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return u().containsAll(collection);
    }

    @Override // com.google.common.collect.x
    /* JADX INFO: renamed from: delegate */
    public abstract Collection<E> u();

    @Override // java.util.Collection
    public boolean isEmpty() {
        return u().isEmpty();
    }

    public Iterator<E> iterator() {
        return u().iterator();
    }

    public boolean remove(Object obj) {
        return u().remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        return u().removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return u().retainAll(collection);
    }

    @Override // java.util.Collection
    public int size() {
        return u().size();
    }

    public boolean standardAddAll(Collection<? extends E> collection) {
        return Iterators.a(this, collection.iterator());
    }

    public void standardClear() {
        Iterators.e(iterator());
    }

    public boolean standardContains(Object obj) {
        return Iterators.g(iterator(), obj);
    }

    public boolean standardContainsAll(Collection<?> collection) {
        return m.a(this, collection);
    }

    public boolean standardIsEmpty() {
        return !iterator().hasNext();
    }

    public boolean standardRemove(Object obj) {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (com.google.common.base.j.a(it.next(), obj)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public boolean standardRemoveAll(Collection<?> collection) {
        return Iterators.v(iterator(), collection);
    }

    public boolean standardRetainAll(Collection<?> collection) {
        return Iterators.x(iterator(), collection);
    }

    public Object[] standardToArray() {
        return toArray(new Object[size()]);
    }

    public <T> T[] standardToArray(T[] tArr) {
        return (T[]) l0.g(this, tArr);
    }

    public String standardToString() {
        return m.e(this);
    }

    public Object[] toArray() {
        return u().toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return (T[]) u().toArray(tArr);
    }
}
