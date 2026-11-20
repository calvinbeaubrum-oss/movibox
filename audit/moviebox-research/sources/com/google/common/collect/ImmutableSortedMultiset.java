package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ImmutableSortedMultiset<E> extends ImmutableSortedMultisetFauxverideShim<E> implements z0<E> {
    transient ImmutableSortedMultiset<E> descendingMultiset;

    /* JADX INFO: compiled from: source.java */
    public static final class SerializedForm<E> implements Serializable {
        final Comparator<? super E> comparator;
        final int[] counts;
        final E[] elements;

        public SerializedForm(z0<E> z0Var) {
            this.comparator = z0Var.comparator();
            int size = z0Var.entrySet().size();
            this.elements = (E[]) new Object[size];
            this.counts = new int[size];
            int i11 = 0;
            for (j0.a<E> aVar : z0Var.entrySet()) {
                this.elements[i11] = aVar.getElement();
                this.counts[i11] = aVar.getCount();
                i11++;
            }
        }

        public Object readResolve() {
            int length = this.elements.length;
            a aVar = new a(this.comparator);
            for (int i11 = 0; i11 < length; i11++) {
                aVar.j(this.elements[i11], this.counts[i11]);
            }
            return aVar.k();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class a<E> extends ImmutableMultiset.b<E> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Comparator<? super E> f38399d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public E[] f38400e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int[] f38401f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f38402g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f38403h;

        public a(Comparator<? super E> comparator) {
            super(true);
            this.f38399d = (Comparator) com.google.common.base.m.p(comparator);
            this.f38400e = (E[]) new Object[4];
            this.f38401f = new int[4];
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public a<E> a(E e11) {
            return j(e11, 1);
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public a<E> g(E... eArr) {
            for (E e11 : eArr) {
                a(e11);
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public a<E> h(Iterable<? extends E> iterable) {
            if (iterable instanceof j0) {
                for (j0.a<E> aVar : ((j0) iterable).entrySet()) {
                    j(aVar.getElement(), aVar.getCount());
                }
            } else {
                Iterator<? extends E> it = iterable.iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public a<E> i(Iterator<? extends E> it) {
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public a<E> j(E e11, int i11) {
            com.google.common.base.m.p(e11);
            l.b(i11, "occurrences");
            if (i11 == 0) {
                return this;
            }
            u();
            E[] eArr = this.f38400e;
            int i12 = this.f38402g;
            eArr[i12] = e11;
            this.f38401f[i12] = i11;
            this.f38402g = i12 + 1;
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public ImmutableSortedMultiset<E> k() {
            t();
            int i11 = this.f38402g;
            if (i11 == 0) {
                return ImmutableSortedMultiset.emptyMultiset(this.f38399d);
            }
            RegularImmutableSortedSet regularImmutableSortedSet = (RegularImmutableSortedSet) ImmutableSortedSet.construct(this.f38399d, i11, this.f38400e);
            long[] jArr = new long[this.f38402g + 1];
            int i12 = 0;
            while (i12 < this.f38402g) {
                int i13 = i12 + 1;
                jArr[i13] = jArr[i12] + ((long) this.f38401f[i12]);
                i12 = i13;
            }
            this.f38403h = true;
            return new RegularImmutableSortedMultiset(regularImmutableSortedSet, jArr, 0, this.f38402g);
        }

        public final void s(boolean z11) {
            int i11 = this.f38402g;
            if (i11 == 0) {
                return;
            }
            Object[] objArr = (E[]) Arrays.copyOf(this.f38400e, i11);
            Arrays.sort(objArr, this.f38399d);
            int i12 = 1;
            for (int i13 = 1; i13 < objArr.length; i13++) {
                if (this.f38399d.compare((Object) objArr[i12 - 1], (Object) objArr[i13]) < 0) {
                    objArr[i12] = objArr[i13];
                    i12++;
                }
            }
            Arrays.fill(objArr, i12, this.f38402g, (Object) null);
            if (z11) {
                int i14 = i12 * 4;
                int i15 = this.f38402g;
                if (i14 > i15 * 3) {
                    objArr = (E[]) Arrays.copyOf(objArr, com.google.common.math.d.h(i15, (i15 / 2) + 1));
                }
            }
            int[] iArr = new int[objArr.length];
            for (int i16 = 0; i16 < this.f38402g; i16++) {
                int iBinarySearch = Arrays.binarySearch(objArr, 0, i12, this.f38400e[i16], this.f38399d);
                int i17 = this.f38401f[i16];
                if (i17 >= 0) {
                    iArr[iBinarySearch] = iArr[iBinarySearch] + i17;
                } else {
                    iArr[iBinarySearch] = ~i17;
                }
            }
            this.f38400e = (E[]) objArr;
            this.f38401f = iArr;
            this.f38402g = i12;
        }

        public final void t() {
            s(false);
            int i11 = 0;
            int i12 = 0;
            while (true) {
                int i13 = this.f38402g;
                if (i11 >= i13) {
                    Arrays.fill(this.f38400e, i12, i13, (Object) null);
                    Arrays.fill(this.f38401f, i12, this.f38402g, 0);
                    this.f38402g = i12;
                    return;
                }
                int[] iArr = this.f38401f;
                int i14 = iArr[i11];
                if (i14 > 0) {
                    E[] eArr = this.f38400e;
                    eArr[i12] = eArr[i11];
                    iArr[i12] = i14;
                    i12++;
                }
                i11++;
            }
        }

        public final void u() {
            int i11 = this.f38402g;
            E[] eArr = this.f38400e;
            if (i11 == eArr.length) {
                s(true);
            } else if (this.f38403h) {
                this.f38400e = (E[]) Arrays.copyOf(eArr, eArr.length);
            }
            this.f38403h = false;
        }
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(Ordering.natural(), iterable);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableSortedMultiset) {
            ImmutableSortedMultiset<E> immutableSortedMultiset = (ImmutableSortedMultiset) iterable;
            if (comparator.equals(immutableSortedMultiset.comparator())) {
                return immutableSortedMultiset.isPartialView() ? copyOfSortedEntries(comparator, immutableSortedMultiset.entrySet().asList()) : immutableSortedMultiset;
            }
        }
        return new a(comparator).h(iterable).k();
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        com.google.common.base.m.p(comparator);
        return new a(comparator).i(it).k();
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterator<? extends E> it) {
        return copyOf(Ordering.natural(), it);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset copyOf(Comparable[] comparableArr) {
        return copyOf(Ordering.natural(), Arrays.asList(comparableArr));
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSorted(z0<E> z0Var) {
        return copyOfSortedEntries(z0Var.comparator(), Lists.j(z0Var.entrySet()));
    }

    private static <E> ImmutableSortedMultiset<E> copyOfSortedEntries(Comparator<? super E> comparator, Collection<j0.a<E>> collection) {
        if (collection.isEmpty()) {
            return emptyMultiset(comparator);
        }
        ImmutableList.a aVar = new ImmutableList.a(collection.size());
        long[] jArr = new long[collection.size() + 1];
        int i11 = 0;
        for (j0.a<E> aVar2 : collection) {
            aVar.a(aVar2.getElement());
            int i12 = i11 + 1;
            jArr[i12] = jArr[i11] + ((long) aVar2.getCount());
            i11 = i12;
        }
        return new RegularImmutableSortedMultiset(new RegularImmutableSortedSet(aVar.m(), comparator), jArr, 0, collection.size());
    }

    public static <E> ImmutableSortedMultiset<E> emptyMultiset(Comparator<? super E> comparator) {
        return Ordering.natural().equals(comparator) ? (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET : new RegularImmutableSortedMultiset(comparator);
    }

    public static <E extends Comparable<?>> a<E> naturalOrder() {
        return new a<>(Ordering.natural());
    }

    public static <E> ImmutableSortedMultiset<E> of() {
        return (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable) {
        return new RegularImmutableSortedMultiset((RegularImmutableSortedSet) ImmutableSortedSet.of(comparable), new long[]{0, 1}, 0, 1);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3, comparable4));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3, comparable4, comparable5));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable comparable6, Comparable... comparableArr) {
        ArrayList arrayListM = Lists.m(comparableArr.length + 6);
        Collections.addAll(arrayListM, comparable, comparable2, comparable3, comparable4, comparable5, comparable6);
        Collections.addAll(arrayListM, comparableArr);
        return copyOf(Ordering.natural(), arrayListM);
    }

    public static <E> a<E> orderedBy(Comparator<E> comparator) {
        return new a<>(comparator);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<?>> a<E> reverseOrder() {
        return new a<>(Ordering.natural().reverse());
    }

    @Override // com.google.common.collect.z0, com.google.common.collect.x0
    public final Comparator<? super E> comparator() {
        return elementSet().comparator();
    }

    @Override // com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.common.collect.ImmutableMultiset, com.google.common.collect.j0
    public abstract /* synthetic */ int count(Object obj);

    public ImmutableSortedMultiset<E> descendingMultiset() {
        ImmutableSortedMultiset<E> immutableSortedMultisetEmptyMultiset = this.descendingMultiset;
        if (immutableSortedMultisetEmptyMultiset == null) {
            immutableSortedMultisetEmptyMultiset = isEmpty() ? emptyMultiset(Ordering.from(comparator()).reverse()) : new DescendingImmutableSortedMultiset<>(this);
            this.descendingMultiset = immutableSortedMultisetEmptyMultiset;
        }
        return immutableSortedMultisetEmptyMultiset;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.j0
    public abstract ImmutableSortedSet<E> elementSet();

    public abstract /* synthetic */ j0.a firstEntry();

    public abstract ImmutableSortedMultiset<E> headMultiset(E e11, BoundType boundType);

    public abstract /* synthetic */ j0.a lastEntry();

    @Override // com.google.common.collect.z0
    @Deprecated
    public final j0.a<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.z0
    @Deprecated
    public final j0.a<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.z0
    public ImmutableSortedMultiset<E> subMultiset(E e11, BoundType boundType, E e12, BoundType boundType2) {
        com.google.common.base.m.l(comparator().compare(e11, e12) <= 0, "Expected lowerBound <= upperBound but %s > %s", e11, e12);
        return tailMultiset((Object) e11, boundType).headMultiset((Object) e12, boundType2);
    }

    public abstract ImmutableSortedMultiset<E> tailMultiset(E e11, BoundType boundType);

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this);
    }
}
