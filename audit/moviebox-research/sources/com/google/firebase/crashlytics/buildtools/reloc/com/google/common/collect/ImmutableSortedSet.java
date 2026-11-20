package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import OooO.OooO0OO;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Collector;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class ImmutableSortedSet<E> extends ImmutableSortedSetFauxverideShim<E> implements NavigableSet<E>, e7<E> {
    static final int SPLITERATOR_CHARACTERISTICS = 1301;
    final transient Comparator<? super E> comparator;
    transient ImmutableSortedSet<E> descendingSet;

    /* JADX INFO: compiled from: source.java */
    public static class SerializedForm<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super E> comparator;
        final Object[] elements;

        public SerializedForm(Comparator<? super E> comparator, Object[] objArr) {
            this.comparator = comparator;
            this.elements = objArr;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Object readResolve() {
            return new b(this.comparator).l(this.elements).g();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends Spliterators.AbstractSpliterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t7<E> f39388a;

        public a(long j11, int i11) {
            super(j11, i11);
            this.f39388a = ImmutableSortedSet.this.iterator();
        }

        @Override // java.util.Spliterator
        public Comparator<? super E> getComparator() {
            return ImmutableSortedSet.this.comparator;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super E> consumer) {
            if (!this.f39388a.hasNext()) {
                return false;
            }
            consumer.accept(this.f39388a.next());
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b<E> extends ImmutableSet.a<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Comparator<? super E> f39390c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public E[] f39391d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f39392e;

        public b(Comparator<? super E> comparator) {
            super(true);
            this.f39390c = (Comparator) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(comparator);
            this.f39391d = (E[]) new Object[4];
            this.f39392e = 0;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet.a
        public void i() {
            E[] eArr = this.f39391d;
            this.f39391d = (E[]) Arrays.copyOf(eArr, eArr.length);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet.a
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public b<E> a(E e11) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(e11);
            j();
            if (this.f39392e == this.f39391d.length) {
                p();
                int i11 = this.f39392e;
                int iD = ImmutableCollection.a.d(i11, i11 + 1);
                E[] eArr = this.f39391d;
                if (iD > eArr.length) {
                    this.f39391d = (E[]) Arrays.copyOf(eArr, iD);
                }
            }
            E[] eArr2 = this.f39391d;
            int i12 = this.f39392e;
            this.f39392e = i12 + 1;
            eArr2[i12] = e11;
            return this;
        }

        public b<E> l(E... eArr) {
            p6.b(eArr);
            for (E e11 : eArr) {
                a(e11);
            }
            return this;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet.a
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public b<E> f(Iterator<? extends E> it) {
            super.f(it);
            return this;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet.a
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public ImmutableSortedSet<E> g() {
            p();
            if (this.f39392e == 0) {
                return ImmutableSortedSet.emptySet(this.f39390c);
            }
            this.f39377b = true;
            return new RegularImmutableSortedSet(ImmutableList.asImmutableList(this.f39391d, this.f39392e), this.f39390c);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet.a
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public b<E> h(ImmutableSet.a<E> aVar) {
            j();
            b bVar = (b) aVar;
            for (int i11 = 0; i11 < bVar.f39392e; i11++) {
                a(bVar.f39391d[i11]);
            }
            return this;
        }

        public final void p() {
            int i11 = this.f39392e;
            if (i11 == 0) {
                return;
            }
            Arrays.sort(this.f39391d, 0, i11, this.f39390c);
            int i12 = 1;
            int i13 = 1;
            while (true) {
                int i14 = this.f39392e;
                if (i12 >= i14) {
                    Arrays.fill(this.f39391d, i13, i14, (Object) null);
                    this.f39392e = i13;
                    return;
                }
                Comparator<? super E> comparator = this.f39390c;
                E[] eArr = this.f39391d;
                int iCompare = comparator.compare(eArr[i13 - 1], eArr[i12]);
                if (iCompare < 0) {
                    E[] eArr2 = this.f39391d;
                    eArr2[i13] = eArr2[i12];
                    i13++;
                } else if (iCompare > 0) {
                    throw new AssertionError("Comparator " + this.f39390c + " compare method violates its contract");
                }
                i12++;
            }
        }
    }

    public ImmutableSortedSet(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> ImmutableSortedSet<E> construct(Comparator<? super E> comparator, int i11, E... eArr) {
        if (i11 == 0) {
            return emptySet(comparator);
        }
        p6.c(eArr, i11);
        Arrays.sort(eArr, 0, i11, comparator);
        int i12 = 1;
        for (int i13 = 1; i13 < i11; i13++) {
            OooO0OO.OooO0o oooO0o = (Object) eArr[i13];
            if (comparator.compare(oooO0o, (Object) eArr[i12 - 1]) != 0) {
                eArr[i12] = oooO0o;
                i12++;
            }
        }
        Arrays.fill(eArr, i12, i11, (Object) null);
        return new RegularImmutableSortedSet(ImmutableList.asImmutableList(eArr, i12), comparator);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(Ordering.natural(), iterable);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Collection<? extends E> collection) {
        return copyOf((Comparator) Ordering.natural(), (Collection) collection);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(comparator);
        if (f7.b(comparator, iterable) && (iterable instanceof ImmutableSortedSet)) {
            ImmutableSortedSet<E> immutableSortedSet = (ImmutableSortedSet) iterable;
            if (!immutableSortedSet.isPartialView()) {
                return immutableSortedSet;
            }
        }
        Object[] objArrK = j5.k(iterable);
        return construct(comparator, objArrK.length, objArrK);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Collection<? extends E> collection) {
        return copyOf((Comparator) comparator, (Iterable) collection);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        return new b(comparator).f(it).g();
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterator<? extends E> it) {
        return copyOf(Ordering.natural(), it);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/firebase/crashlytics/buildtools/reloc/com/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet copyOf(Comparable[] comparableArr) {
        return construct(Ordering.natural(), comparableArr.length, (Object[]) comparableArr.clone());
    }

    public static <E> ImmutableSortedSet<E> copyOfSorted(SortedSet<E> sortedSet) {
        Comparator comparatorA = f7.a(sortedSet);
        ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) sortedSet);
        return immutableListCopyOf.isEmpty() ? emptySet(comparatorA) : new RegularImmutableSortedSet(immutableListCopyOf, comparatorA);
    }

    public static <E> RegularImmutableSortedSet<E> emptySet(Comparator<? super E> comparator) {
        return Ordering.natural().equals(comparator) ? (RegularImmutableSortedSet<E>) RegularImmutableSortedSet.NATURAL_EMPTY_SET : new RegularImmutableSortedSet<>(ImmutableList.of(), comparator);
    }

    public static <E extends Comparable<?>> b<E> naturalOrder() {
        return new b<>(Ordering.natural());
    }

    public static <E> ImmutableSortedSet<E> of() {
        return RegularImmutableSortedSet.NATURAL_EMPTY_SET;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/firebase/crashlytics/buildtools/reloc/com/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable) {
        return new RegularImmutableSortedSet(ImmutableList.of(comparable), Ordering.natural());
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/firebase/crashlytics/buildtools/reloc/com/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2) {
        return construct(Ordering.natural(), 2, comparable, comparable2);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/firebase/crashlytics/buildtools/reloc/com/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return construct(Ordering.natural(), 3, comparable, comparable2, comparable3);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/firebase/crashlytics/buildtools/reloc/com/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4) {
        return construct(Ordering.natural(), 4, comparable, comparable2, comparable3, comparable4);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/firebase/crashlytics/buildtools/reloc/com/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5) {
        return construct(Ordering.natural(), 5, comparable, comparable2, comparable3, comparable4, comparable5);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/firebase/crashlytics/buildtools/reloc/com/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable comparable6, Comparable... comparableArr) {
        int length = comparableArr.length + 6;
        Comparable[] comparableArr2 = new Comparable[length];
        comparableArr2[0] = comparable;
        comparableArr2[1] = comparable2;
        comparableArr2[2] = comparable3;
        comparableArr2[3] = comparable4;
        comparableArr2[4] = comparable5;
        comparableArr2[5] = comparable6;
        System.arraycopy(comparableArr, 0, comparableArr2, 6, comparableArr.length);
        return construct(Ordering.natural(), length, comparableArr2);
    }

    public static <E> b<E> orderedBy(Comparator<E> comparator) {
        return new b<>(comparator);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<?>> b<E> reverseOrder() {
        return new b<>(Collections.reverseOrder());
    }

    public static <E> Collector<E, ?, ImmutableSortedSet<E>> toImmutableSortedSet(Comparator<? super E> comparator) {
        return m1.t(comparator);
    }

    public static int unsafeCompare(Comparator<?> comparator, Object obj, Object obj2) {
        return comparator.compare(obj, obj2);
    }

    public E ceiling(E e11) {
        return (E) j5.e(tailSet((Object) e11, true), null);
    }

    @Override // java.util.SortedSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.e7
    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    public abstract ImmutableSortedSet<E> createDescendingSet();

    @Override // java.util.NavigableSet
    public abstract t7<E> descendingIterator();

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

    public E first() {
        return iterator().next();
    }

    public E floor(E e11) {
        return (E) Iterators.o(headSet((Object) e11, true).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public ImmutableSortedSet<E> headSet(E e11) {
        return headSet((Object) e11, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public ImmutableSortedSet<E> headSet(E e11, boolean z11) {
        return headSetImpl(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(e11), z11);
    }

    public abstract ImmutableSortedSet<E> headSetImpl(E e11, boolean z11);

    public E higher(E e11) {
        return (E) j5.e(tailSet((Object) e11, false), null);
    }

    public abstract int indexOf(Object obj);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public abstract t7<E> iterator();

    public E last() {
        return descendingIterator().next();
    }

    public E lower(E e11) {
        return (E) Iterators.o(headSet((Object) e11, false).descendingIterator(), null);
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

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return new a(size(), 1365);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public ImmutableSortedSet<E> subSet(E e11, E e12) {
        return subSet((Object) e11, true, (Object) e12, false);
    }

    @Override // java.util.NavigableSet
    public ImmutableSortedSet<E> subSet(E e11, boolean z11, E e12, boolean z12) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(e11);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(e12);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(this.comparator.compare(e11, e12) <= 0);
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
        return tailSetImpl(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(e11), z11);
    }

    public abstract ImmutableSortedSet<E> tailSetImpl(E e11, boolean z11);

    public int unsafeCompare(Object obj, Object obj2) {
        return unsafeCompare(this.comparator, obj, obj2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this.comparator, toArray());
    }
}
