package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class p<E> extends w<E> implements z0<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Comparator<? super E> f38722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient NavigableSet<E> f38723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient Set<j0.a<E>> f38724c;

    /* JADX INFO: compiled from: source.java */
    public class a extends Multisets.d<E> {
        public a() {
        }

        @Override // com.google.common.collect.Multisets.d
        public j0<E> a() {
            return p.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<j0.a<E>> iterator() {
            return p.this.w();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return p.this.x().entrySet().size();
        }
    }

    @Override // com.google.common.collect.z0, com.google.common.collect.x0
    public Comparator<? super E> comparator() {
        Comparator<? super E> comparator = this.f38722a;
        if (comparator != null) {
            return comparator;
        }
        Ordering orderingReverse = Ordering.from(x().comparator()).reverse();
        this.f38722a = orderingReverse;
        return orderingReverse;
    }

    @Override // com.google.common.collect.z0
    public z0<E> descendingMultiset() {
        return x();
    }

    @Override // com.google.common.collect.j0
    public NavigableSet<E> elementSet() {
        NavigableSet<E> navigableSet = this.f38723b;
        if (navigableSet != null) {
            return navigableSet;
        }
        a1.b bVar = new a1.b(this);
        this.f38723b = bVar;
        return bVar;
    }

    @Override // com.google.common.collect.w, com.google.common.collect.j0
    public Set<j0.a<E>> entrySet() {
        Set<j0.a<E>> set = this.f38724c;
        if (set != null) {
            return set;
        }
        Set<j0.a<E>> setV = v();
        this.f38724c = setV;
        return setV;
    }

    @Override // com.google.common.collect.z0
    public j0.a<E> firstEntry() {
        return x().lastEntry();
    }

    @Override // com.google.common.collect.z0
    public z0<E> headMultiset(E e11, BoundType boundType) {
        return x().tailMultiset(e11, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.z0
    public j0.a<E> lastEntry() {
        return x().firstEntry();
    }

    @Override // com.google.common.collect.z0
    public j0.a<E> pollFirstEntry() {
        return x().pollLastEntry();
    }

    @Override // com.google.common.collect.z0
    public j0.a<E> pollLastEntry() {
        return x().pollFirstEntry();
    }

    @Override // com.google.common.collect.z0
    public z0<E> subMultiset(E e11, BoundType boundType, E e12, BoundType boundType2) {
        return x().subMultiset(e12, boundType2, e11, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.z0
    public z0<E> tailMultiset(E e11, BoundType boundType) {
        return x().headMultiset(e11, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.r, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return standardToArray();
    }

    @Override // com.google.common.collect.r, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) standardToArray(tArr);
    }

    @Override // com.google.common.collect.x
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.r, com.google.common.collect.x
    public j0<E> u() {
        return x();
    }

    public Set<j0.a<E>> v() {
        return new a();
    }

    public abstract Iterator<j0.a<E>> w();

    public abstract z0<E> x();
}
