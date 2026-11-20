package com.google.common.collect;

import com.google.j2objc.annotations.Weak;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a1 {

    /* JADX INFO: compiled from: source.java */
    public static class a<E> extends Multisets.c<E> implements SortedSet<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Weak
        public final z0<E> f38675a;

        public a(z0<E> z0Var) {
            this.f38675a = z0Var;
        }

        @Override // com.google.common.collect.Multisets.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final z0<E> a() {
            return this.f38675a;
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            return a().comparator();
        }

        @Override // java.util.SortedSet
        public E first() {
            return (E) a1.d(a().firstEntry());
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(E e11) {
            return a().headMultiset(e11, BoundType.OPEN).elementSet();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return Multisets.e(a().entrySet().iterator());
        }

        @Override // java.util.SortedSet
        public E last() {
            return (E) a1.d(a().lastEntry());
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(E e11, E e12) {
            return a().subMultiset(e11, BoundType.CLOSED, e12, BoundType.OPEN).elementSet();
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(E e11) {
            return a().tailMultiset(e11, BoundType.CLOSED).elementSet();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b<E> extends a<E> implements NavigableSet<E> {
        public b(z0<E> z0Var) {
            super(z0Var);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e11) {
            return (E) a1.c(a().tailMultiset(e11, BoundType.CLOSED).firstEntry());
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return new b(a().descendingMultiset());
        }

        @Override // java.util.NavigableSet
        public E floor(E e11) {
            return (E) a1.c(a().headMultiset(e11, BoundType.CLOSED).lastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e11, boolean z11) {
            return new b(a().headMultiset(e11, BoundType.forBoolean(z11)));
        }

        @Override // java.util.NavigableSet
        public E higher(E e11) {
            return (E) a1.c(a().tailMultiset(e11, BoundType.OPEN).firstEntry());
        }

        @Override // java.util.NavigableSet
        public E lower(E e11) {
            return (E) a1.c(a().headMultiset(e11, BoundType.OPEN).lastEntry());
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            return (E) a1.c(a().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            return (E) a1.c(a().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e11, boolean z11, E e12, boolean z12) {
            return new b(a().subMultiset(e11, BoundType.forBoolean(z11), e12, BoundType.forBoolean(z12)));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e11, boolean z11) {
            return new b(a().tailMultiset(e11, BoundType.forBoolean(z11)));
        }
    }

    public static <E> E c(j0.a<E> aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.getElement();
    }

    public static <E> E d(j0.a<E> aVar) {
        if (aVar != null) {
            return aVar.getElement();
        }
        throw new NoSuchElementException();
    }
}
