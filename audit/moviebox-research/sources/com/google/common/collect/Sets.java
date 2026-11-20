package com.google.common.collect;

import com.google.common.base.Predicates;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class Sets {

    /* JADX INFO: compiled from: source.java */
    public static final class UnmodifiableNavigableSet<E> extends b0<E> implements NavigableSet<E>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public transient UnmodifiableNavigableSet<E> f38581a;
        private final NavigableSet<E> delegate;
        private final SortedSet<E> unmodifiableDelegate;

        public UnmodifiableNavigableSet(NavigableSet<E> navigableSet) {
            this.delegate = (NavigableSet) com.google.common.base.m.p(navigableSet);
            this.unmodifiableDelegate = Collections.unmodifiableSortedSet(navigableSet);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e11) {
            return this.delegate.ceiling(e11);
        }

        @Override // com.google.common.collect.b0, com.google.common.collect.z, com.google.common.collect.r, com.google.common.collect.x
        /* JADX INFO: renamed from: delegate */
        public SortedSet<E> u() {
            return this.unmodifiableDelegate;
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return Iterators.C(this.delegate.descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            UnmodifiableNavigableSet<E> unmodifiableNavigableSet = this.f38581a;
            if (unmodifiableNavigableSet != null) {
                return unmodifiableNavigableSet;
            }
            UnmodifiableNavigableSet<E> unmodifiableNavigableSet2 = new UnmodifiableNavigableSet<>(this.delegate.descendingSet());
            this.f38581a = unmodifiableNavigableSet2;
            unmodifiableNavigableSet2.f38581a = this;
            return unmodifiableNavigableSet2;
        }

        @Override // java.util.NavigableSet
        public E floor(E e11) {
            return this.delegate.floor(e11);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e11, boolean z11) {
            return Sets.k(this.delegate.headSet(e11, z11));
        }

        @Override // java.util.NavigableSet
        public E higher(E e11) {
            return this.delegate.higher(e11);
        }

        @Override // java.util.NavigableSet
        public E lower(E e11) {
            return this.delegate.lower(e11);
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e11, boolean z11, E e12, boolean z12) {
            return Sets.k(this.delegate.subSet(e11, z11, e12, z12));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e11, boolean z11) {
            return Sets.k(this.delegate.tailSet(e11, z11));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: compiled from: source.java */
    public class a<E> extends e<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Set f38582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Set f38583b;

        /* JADX INFO: renamed from: com.google.common.collect.Sets$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0395a extends AbstractIterator<E> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Iterator<E> f38584c;

            public C0395a() {
                this.f38584c = a.this.f38582a.iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            public E a() {
                while (this.f38584c.hasNext()) {
                    E next = this.f38584c.next();
                    if (a.this.f38583b.contains(next)) {
                        return next;
                    }
                }
                return b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Set set, Set set2) {
            super(null);
            this.f38582a = set;
            this.f38583b = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public g1<E> iterator() {
            return new C0395a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f38582a.contains(obj) && this.f38583b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return this.f38582a.containsAll(collection) && this.f38583b.containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return Collections.disjoint(this.f38583b, this.f38582a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator<E> it = this.f38582a.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                if (this.f38583b.contains(it.next())) {
                    i11++;
                }
            }
            return i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b<E> extends m.a<E> implements Set<E> {
        public b(Set<E> set, com.google.common.base.n<? super E> nVar) {
            super(set, nVar);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return Sets.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.d(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c<E> extends b<E> implements SortedSet<E> {
        public c(SortedSet<E> sortedSet, com.google.common.base.n<? super E> nVar) {
            super(sortedSet, nVar);
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            return ((SortedSet) this.f38702a).comparator();
        }

        @Override // java.util.SortedSet
        public E first() {
            return (E) Iterators.m(this.f38702a.iterator(), this.f38703b);
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(E e11) {
            return new c(((SortedSet) this.f38702a).headSet(e11), this.f38703b);
        }

        @Override // java.util.SortedSet
        public E last() {
            SortedSet sortedSetHeadSet = (SortedSet) this.f38702a;
            while (true) {
                E e11 = (Object) sortedSetHeadSet.last();
                if (this.f38703b.apply(e11)) {
                    return e11;
                }
                sortedSetHeadSet = sortedSetHeadSet.headSet(e11);
            }
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(E e11, E e12) {
            return new c(((SortedSet) this.f38702a).subSet(e11, e12), this.f38703b);
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(E e11) {
            return new c(((SortedSet) this.f38702a).tailSet(e11), this.f38703b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class d<E> extends AbstractSet<E> {
        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return Sets.i(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) com.google.common.base.m.p(collection));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class e<E> extends AbstractSet<E> {
        public e() {
        }

        public /* synthetic */ e(w0 w0Var) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean add(E e11) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
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

    public static <E> Set<E> b(Set<E> set, com.google.common.base.n<? super E> nVar) {
        if (set instanceof SortedSet) {
            return c((SortedSet) set, nVar);
        }
        if (!(set instanceof b)) {
            return new b((Set) com.google.common.base.m.p(set), (com.google.common.base.n) com.google.common.base.m.p(nVar));
        }
        b bVar = (b) set;
        return new b((Set) bVar.f38702a, Predicates.c(bVar.f38703b, nVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> SortedSet<E> c(SortedSet<E> sortedSet, com.google.common.base.n<? super E> nVar) {
        if (!(sortedSet instanceof b)) {
            return new c((SortedSet) com.google.common.base.m.p(sortedSet), (com.google.common.base.n) com.google.common.base.m.p(nVar));
        }
        b bVar = (b) sortedSet;
        return new c((SortedSet) bVar.f38702a, Predicates.c(bVar.f38703b, nVar));
    }

    public static int d(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i11 = ~(~(i11 + (next != null ? next.hashCode() : 0)));
        }
        return i11;
    }

    public static <E> e<E> e(Set<E> set, Set<?> set2) {
        com.google.common.base.m.q(set, "set1");
        com.google.common.base.m.q(set2, "set2");
        return new a(set, set2);
    }

    public static <E> HashSet<E> f() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> g(int i11) {
        return new HashSet<>(Maps.d(i11));
    }

    public static <E> Set<E> h() {
        return Collections.newSetFromMap(Maps.q());
    }

    public static boolean i(Set<?> set, Collection<?> collection) {
        com.google.common.base.m.p(collection);
        if (collection instanceof j0) {
            collection = ((j0) collection).elementSet();
        }
        return (!(collection instanceof Set) || collection.size() <= set.size()) ? j(set, collection.iterator()) : Iterators.v(set.iterator(), collection);
    }

    public static boolean j(Set<?> set, Iterator<?> it) {
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= set.remove(it.next());
        }
        return zRemove;
    }

    public static <E> NavigableSet<E> k(NavigableSet<E> navigableSet) {
        return ((navigableSet instanceof ImmutableCollection) || (navigableSet instanceof UnmodifiableNavigableSet)) ? navigableSet : new UnmodifiableNavigableSet(navigableSet);
    }
}
