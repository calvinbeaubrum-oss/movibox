package com.bumptech.glide.repackaged.com.google.common.collect;

import com.bumptech.glide.repackaged.com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.NavigableSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ImmutableSortedSet<E> extends ImmutableSortedSetFauxverideShim<E> implements SortedIterable<E>, NavigableSet<E> {
    private static final RegularImmutableSortedSet<Comparable> NATURAL_EMPTY_SET;
    private static final Comparator<Comparable> NATURAL_ORDER;
    final transient Comparator<? super E> comparator;
    transient ImmutableSortedSet<E> descendingSet;

    static {
        Ordering orderingNatural = Ordering.natural();
        NATURAL_ORDER = orderingNatural;
        NATURAL_EMPTY_SET = new RegularImmutableSortedSet<>(ImmutableList.of(), orderingNatural);
    }

    public ImmutableSortedSet(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    public static <E> RegularImmutableSortedSet<E> emptySet(Comparator<? super E> comparator) {
        return NATURAL_ORDER.equals(comparator) ? (RegularImmutableSortedSet<E>) NATURAL_EMPTY_SET : new RegularImmutableSortedSet<>(ImmutableList.of(), comparator);
    }

    public static int unsafeCompare(Comparator<?> comparator, Object obj, Object obj2) {
        return comparator.compare(obj, obj2);
    }

    public E ceiling(E e11) {
        return (E) Iterables.getFirst(tailSet((Object) e11, true), null);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.SortedIterable
    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    public ImmutableSortedSet<E> createDescendingSet() {
        return new DescendingImmutableSortedSet(this);
    }

    @Override // java.util.NavigableSet
    public abstract UnmodifiableIterator<E> descendingIterator();

    @Override // java.util.NavigableSet
    public ImmutableSortedSet<E> descendingSet() {
        ImmutableSortedSet<E> immutableSortedSet = this.descendingSet;
        if (immutableSortedSet != null) {
            return immutableSortedSet;
        }
        ImmutableSortedSet<E> immutableSortedSetCreateDescendingSet = createDescendingSet();
        this.descendingSet = immutableSortedSetCreateDescendingSet;
        immutableSortedSetCreateDescendingSet.descendingSet = this;
        return immutableSortedSetCreateDescendingSet;
    }

    @Override // java.util.SortedSet
    public E first() {
        return iterator().next();
    }

    public E floor(E e11) {
        return (E) Iterators.getNext(headSet((Object) e11, true).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public ImmutableSortedSet<E> headSet(E e11) {
        return headSet((Object) e11, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public ImmutableSortedSet<E> headSet(E e11, boolean z11) {
        return headSetImpl(Preconditions.checkNotNull(e11), z11);
    }

    public abstract ImmutableSortedSet<E> headSetImpl(E e11, boolean z11);

    public E higher(E e11) {
        return (E) Iterables.getFirst(tailSet((Object) e11, false), null);
    }

    public abstract int indexOf(Object obj);

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public abstract UnmodifiableIterator<E> iterator();

    @Override // java.util.SortedSet
    public E last() {
        return descendingIterator().next();
    }

    public E lower(E e11) {
        return (E) Iterators.getNext(headSet((Object) e11, false).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public ImmutableSortedSet<E> subSet(E e11, E e12) {
        return subSet((Object) e11, true, (Object) e12, false);
    }

    @Override // java.util.NavigableSet
    public ImmutableSortedSet<E> subSet(E e11, boolean z11, E e12, boolean z12) {
        Preconditions.checkNotNull(e11);
        Preconditions.checkNotNull(e12);
        Preconditions.checkArgument(this.comparator.compare(e11, e12) <= 0);
        return subSetImpl(e11, z11, e12, z12);
    }

    public abstract ImmutableSortedSet<E> subSetImpl(E e11, boolean z11, E e12, boolean z12);

    @Override // java.util.NavigableSet, java.util.SortedSet
    public ImmutableSortedSet<E> tailSet(E e11) {
        return tailSet((Object) e11, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public ImmutableSortedSet<E> tailSet(E e11, boolean z11) {
        return tailSetImpl(Preconditions.checkNotNull(e11), z11);
    }

    public abstract ImmutableSortedSet<E> tailSetImpl(E e11, boolean z11);

    public int unsafeCompare(Object obj, Object obj2) {
        return unsafeCompare(this.comparator, obj, obj2);
    }
}
