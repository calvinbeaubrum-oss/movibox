package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class RegularImmutableSortedSet<E> extends ImmutableSortedSet<E> {
    static final RegularImmutableSortedSet<Comparable> NATURAL_EMPTY_SET = new RegularImmutableSortedSet<>(ImmutableList.of(), Ordering.natural());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient ImmutableList<E> f39572a;

    public RegularImmutableSortedSet(ImmutableList<E> immutableList, Comparator<? super E> comparator) {
        super(comparator);
        this.f39572a = immutableList;
    }

    public final int a(Object obj) throws ClassCastException {
        return Collections.binarySearch(this.f39572a, obj, unsafeComparator());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E ceiling(E e11) {
        int iTailIndex = tailIndex(e11, true);
        if (iTailIndex == size()) {
            return null;
        }
        return this.f39572a.get(iTailIndex);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return a(obj) >= 0;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof l6) {
            collection = ((l6) collection).elementSet();
        }
        if (!f7.b(comparator(), collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        t7<E> it = iterator();
        Iterator<?> it2 = collection.iterator();
        if (!it.hasNext()) {
            return false;
        }
        Object next = it2.next();
        E next2 = it.next();
        while (true) {
            try {
                int iUnsafeCompare = unsafeCompare(next2, next);
                if (iUnsafeCompare < 0) {
                    if (!it.hasNext()) {
                        return false;
                    }
                    next2 = it.next();
                } else if (iUnsafeCompare == 0) {
                    if (!it2.hasNext()) {
                        return true;
                    }
                    next = it2.next();
                } else if (iUnsafeCompare > 0) {
                    return false;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i11) {
        return this.f39572a.copyIntoArray(objArr, i11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet
    public ImmutableList<E> createAsList() {
        return size() <= 1 ? this.f39572a : new ImmutableSortedAsList(this, this.f39572a);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> createDescendingSet() {
        Comparator comparatorReverseOrder = Collections.reverseOrder(this.comparator);
        return isEmpty() ? ImmutableSortedSet.emptySet(comparatorReverseOrder) : new RegularImmutableSortedSet(this.f39572a.reverse(), comparatorReverseOrder);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public t7<E> descendingIterator() {
        return this.f39572a.reverse().iterator();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (!f7.b(this.comparator, set)) {
            return containsAll(set);
        }
        Iterator<E> it = set.iterator();
        try {
            t7<E> it2 = iterator();
            while (it2.hasNext()) {
                E next = it2.next();
                E next2 = it.next();
                if (next2 == null || unsafeCompare(next, next2) != 0) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NoSuchElementException unused) {
            return false;
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public E first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.f39572a.get(0);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E floor(E e11) {
        int iHeadIndex = headIndex(e11, true) - 1;
        if (iHeadIndex == -1) {
            return null;
        }
        return this.f39572a.get(iHeadIndex);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> consumer) {
        this.f39572a.forEach(consumer);
    }

    public RegularImmutableSortedSet<E> getSubSet(int i11, int i12) {
        if (i11 == 0 && i12 == size()) {
            return this;
        }
        return i11 < i12 ? new RegularImmutableSortedSet<>(this.f39572a.subList(i11, i12), this.comparator) : ImmutableSortedSet.emptySet(this.comparator);
    }

    public int headIndex(E e11, boolean z11) {
        int iBinarySearch = Collections.binarySearch(this.f39572a, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(e11), comparator());
        if (iBinarySearch >= 0) {
            return z11 ? iBinarySearch + 1 : iBinarySearch;
        }
        return ~iBinarySearch;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> headSetImpl(E e11, boolean z11) {
        return getSubSet(0, headIndex(e11, z11));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E higher(E e11) {
        int iTailIndex = tailIndex(e11, false);
        if (iTailIndex == size()) {
            return null;
        }
        return this.f39572a.get(iTailIndex);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            int iBinarySearch = Collections.binarySearch(this.f39572a, obj, unsafeComparator());
            if (iBinarySearch >= 0) {
                return iBinarySearch;
            }
            return -1;
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.f39572a.isPartialView();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public t7<E> iterator() {
        return this.f39572a.iterator();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public E last() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.f39572a.get(size() - 1);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E lower(E e11) {
        int iHeadIndex = headIndex(e11, false) - 1;
        if (iHeadIndex == -1) {
            return null;
        }
        return this.f39572a.get(iHeadIndex);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f39572a.size();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return asList().spliterator();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> subSetImpl(E e11, boolean z11, E e12, boolean z12) {
        return tailSetImpl(e11, z11).headSetImpl(e12, z12);
    }

    public int tailIndex(E e11, boolean z11) {
        int iBinarySearch = Collections.binarySearch(this.f39572a, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(e11), comparator());
        if (iBinarySearch >= 0) {
            return z11 ? iBinarySearch : iBinarySearch + 1;
        }
        return ~iBinarySearch;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> tailSetImpl(E e11, boolean z11) {
        return getSubSet(tailIndex(e11, z11), size());
    }

    public Comparator<Object> unsafeComparator() {
        return this.comparator;
    }
}
