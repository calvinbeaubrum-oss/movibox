package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.lang.Comparable;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class ContiguousSet<C extends Comparable> extends ImmutableSortedSet<C> {
    final DiscreteDomain<C> domain;

    public ContiguousSet(DiscreteDomain<C> discreteDomain) {
        super(Ordering.natural());
        this.domain = discreteDomain;
    }

    @Deprecated
    public static <E> ImmutableSortedSet.b<E> builder() {
        throw new UnsupportedOperationException();
    }

    public static ContiguousSet<Integer> closed(int i11, int i12) {
        return create(Range.closed(Integer.valueOf(i11), Integer.valueOf(i12)), DiscreteDomain.integers());
    }

    public static ContiguousSet<Long> closed(long j11, long j12) {
        return create(Range.closed(Long.valueOf(j11), Long.valueOf(j12)), DiscreteDomain.longs());
    }

    public static ContiguousSet<Integer> closedOpen(int i11, int i12) {
        return create(Range.closedOpen(Integer.valueOf(i11), Integer.valueOf(i12)), DiscreteDomain.integers());
    }

    public static ContiguousSet<Long> closedOpen(long j11, long j12) {
        return create(Range.closedOpen(Long.valueOf(j11), Long.valueOf(j12)), DiscreteDomain.longs());
    }

    public static <C extends Comparable> ContiguousSet<C> create(Range<C> range, DiscreteDomain<C> discreteDomain) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(range);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(discreteDomain);
        try {
            Range<C> rangeIntersection = !range.hasLowerBound() ? range.intersection(Range.atLeast(discreteDomain.minValue())) : range;
            if (!range.hasUpperBound()) {
                rangeIntersection = rangeIntersection.intersection(Range.atMost(discreteDomain.maxValue()));
            }
            return (rangeIntersection.isEmpty() || Range.compareOrThrow(range.lowerBound.leastValueAbove(discreteDomain), range.upperBound.greatestValueBelow(discreteDomain)) > 0) ? new EmptyContiguousSet(discreteDomain) : new RegularContiguousSet(rangeIntersection, discreteDomain);
        } catch (NoSuchElementException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<C> createDescendingSet() {
        return new DescendingImmutableSortedSet(this);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public ContiguousSet<C> headSet(C c11) {
        return headSetImpl((Comparable) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(c11), false);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public ContiguousSet<C> headSet(C c11, boolean z11) {
        return headSetImpl((Comparable) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(c11), z11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet
    public abstract ContiguousSet<C> headSetImpl(C c11, boolean z11);

    public abstract ContiguousSet<C> intersection(ContiguousSet<C> contiguousSet);

    public abstract Range<C> range();

    public abstract Range<C> range(BoundType boundType, BoundType boundType2);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public ContiguousSet<C> subSet(C c11, C c12) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(c11);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(c12);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(comparator().compare(c11, c12) <= 0);
        return subSetImpl((Comparable) c11, true, (Comparable) c12, false);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public ContiguousSet<C> subSet(C c11, boolean z11, C c12, boolean z12) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(c11);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(c12);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(comparator().compare(c11, c12) <= 0);
        return subSetImpl((Comparable) c11, z11, (Comparable) c12, z12);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet
    public abstract ContiguousSet<C> subSetImpl(C c11, boolean z11, C c12, boolean z12);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public ContiguousSet<C> tailSet(C c11) {
        return tailSetImpl((Comparable) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(c11), true);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public ContiguousSet<C> tailSet(C c11, boolean z11) {
        return tailSetImpl((Comparable) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(c11), z11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet
    public abstract ContiguousSet<C> tailSetImpl(C c11, boolean z11);

    @Override // java.util.AbstractCollection
    public String toString() {
        return range().toString();
    }
}
