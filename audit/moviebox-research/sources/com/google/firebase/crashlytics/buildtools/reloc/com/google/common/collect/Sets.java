package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class Sets {

    /* JADX INFO: compiled from: source.java */
    public static final class UnmodifiableNavigableSet<E> extends w2<E> implements NavigableSet<E>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public transient UnmodifiableNavigableSet<E> f39573a;
        private final NavigableSet<E> delegate;
        private final SortedSet<E> unmodifiableDelegate;

        public UnmodifiableNavigableSet(NavigableSet<E> navigableSet) {
            this.delegate = (NavigableSet) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(navigableSet);
            this.unmodifiableDelegate = Collections.unmodifiableSortedSet(navigableSet);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e11) {
            return this.delegate.ceiling(e11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.w2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t2
        public SortedSet<E> delegate() {
            return this.unmodifiableDelegate;
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return Iterators.z(this.delegate.descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            UnmodifiableNavigableSet<E> unmodifiableNavigableSet = this.f39573a;
            if (unmodifiableNavigableSet != null) {
                return unmodifiableNavigableSet;
            }
            UnmodifiableNavigableSet<E> unmodifiableNavigableSet2 = new UnmodifiableNavigableSet<>(this.delegate.descendingSet());
            this.f39573a = unmodifiableNavigableSet2;
            unmodifiableNavigableSet2.f39573a = this;
            return unmodifiableNavigableSet2;
        }

        @Override // java.util.NavigableSet
        public E floor(E e11) {
            return this.delegate.floor(e11);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super E> consumer) {
            this.delegate.forEach(consumer);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e11, boolean z11) {
            return Sets.j(this.delegate.headSet(e11, z11));
        }

        @Override // java.util.NavigableSet
        public E higher(E e11) {
            return this.delegate.higher(e11);
        }

        @Override // java.util.NavigableSet
        public E lower(E e11) {
            return this.delegate.lower(e11);
        }

        @Override // java.util.Collection
        public Stream<E> parallelStream() {
            return this.delegate.parallelStream();
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super E> predicate) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public Stream<E> stream() {
            return this.delegate.stream();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e11, boolean z11, E e12, boolean z12) {
            return Sets.j(this.delegate.subSet(e11, z11, e12, z12));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e11, boolean z11) {
            return Sets.j(this.delegate.tailSet(e11, z11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class a<E> extends AbstractSet<E> {
        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return Sets.h(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(collection));
        }
    }

    public static boolean a(Set<?> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static int b(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i11 = ~(~(i11 + (next != null ? next.hashCode() : 0)));
        }
        return i11;
    }

    public static <E> Set<E> c() {
        return Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static <E> HashSet<E> d() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> e(int i11) {
        return new HashSet<>(Maps.b(i11));
    }

    public static <E> LinkedHashSet<E> f() {
        return new LinkedHashSet<>();
    }

    public static <E> LinkedHashSet<E> g(int i11) {
        return new LinkedHashSet<>(Maps.b(i11));
    }

    public static boolean h(Set<?> set, Collection<?> collection) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(collection);
        if (collection instanceof l6) {
            collection = ((l6) collection).elementSet();
        }
        return (!(collection instanceof Set) || collection.size() <= set.size()) ? i(set, collection.iterator()) : Iterators.t(set.iterator(), collection);
    }

    public static boolean i(Set<?> set, Iterator<?> it) {
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= set.remove(it.next());
        }
        return zRemove;
    }

    public static <E> NavigableSet<E> j(NavigableSet<E> navigableSet) {
        return ((navigableSet instanceof ImmutableCollection) || (navigableSet instanceof UnmodifiableNavigableSet)) ? navigableSet : new UnmodifiableNavigableSet(navigableSet);
    }
}
