package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {

    /* JADX INFO: compiled from: source.java */
    public static class ReverseImmutableList<E> extends ImmutableList<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final transient ImmutableList<E> f39328a;

        public ReverseImmutableList(ImmutableList<E> immutableList) {
            this.f39328a = immutableList;
        }

        public final int a(int i11) {
            return (size() - 1) - i11;
        }

        public final int b(int i11) {
            return size() - i11;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f39328a.contains(obj);
        }

        @Override // java.util.List
        public E get(int i11) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.l(i11, size());
            return this.f39328a.get(a(i11));
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(Object obj) {
            int iLastIndexOf = this.f39328a.lastIndexOf(obj);
            if (iLastIndexOf >= 0) {
                return a(iLastIndexOf);
            }
            return -1;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return this.f39328a.isPartialView();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(Object obj) {
            int iIndexOf = this.f39328a.indexOf(obj);
            if (iIndexOf >= 0) {
                return a(iIndexOf);
            }
            return -1;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i11) {
            return super.listIterator(i11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList
        public ImmutableList<E> reverse() {
            return this.f39328a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f39328a.size();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i11, int i12) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.s(i11, i12, size());
            return this.f39328a.subList(b(i12), b(i11)).reverse();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        public SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        public Object readResolve() {
            return ImmutableList.copyOf(this.elements);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class SubList extends ImmutableList<E> {
        final transient int length;
        final transient int offset;

        public SubList(int i11, int i12) {
            this.offset = i11;
            this.length = i12;
        }

        @Override // java.util.List
        public E get(int i11) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.l(i11, this.length);
            return ImmutableList.this.get(i11 + this.offset);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i11) {
            return super.listIterator(i11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.length;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i11, int i12) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.s(i11, i12, this.length);
            ImmutableList immutableList = ImmutableList.this;
            int i13 = this.offset;
            return immutableList.subList(i11 + i13, i12 + i13);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends c<E> {
        public a(int i11, int i12) {
            super(i11, i12);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.c
        public E a(int i11) {
            return ImmutableList.this.get(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b<E> extends ImmutableCollection.a<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object[] f39330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f39331b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f39332c;

        public b() {
            this(4);
        }

        public b(int i11) {
            this.f39330a = new Object[i11];
            this.f39331b = 0;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public b<E> a(E e11) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(e11);
            j(this.f39331b + 1);
            Object[] objArr = this.f39330a;
            int i11 = this.f39331b;
            this.f39331b = i11 + 1;
            objArr[i11] = e11;
            return this;
        }

        public final void f(Object[] objArr, int i11) {
            j(this.f39331b + i11);
            System.arraycopy(objArr, 0, this.f39330a, this.f39331b, i11);
            this.f39331b += i11;
        }

        public b<E> g(Iterator<? extends E> it) {
            super.c(it);
            return this;
        }

        public ImmutableList<E> h() {
            this.f39332c = true;
            return ImmutableList.asImmutableList(this.f39330a, this.f39331b);
        }

        public b<E> i(b<E> bVar) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(bVar);
            f(bVar.f39330a, bVar.f39331b);
            return this;
        }

        public final void j(int i11) {
            Object[] objArr = this.f39330a;
            if (objArr.length < i11) {
                this.f39330a = Arrays.copyOf(objArr, ImmutableCollection.a.d(objArr.length, i11));
                this.f39332c = false;
            } else if (this.f39332c) {
                this.f39330a = Arrays.copyOf(objArr, objArr.length);
                this.f39332c = false;
            }
        }
    }

    public static <E> ImmutableList<E> asImmutableList(Object[] objArr) {
        return asImmutableList(objArr, objArr.length);
    }

    public static <E> ImmutableList<E> asImmutableList(Object[] objArr, int i11) {
        if (i11 == 0) {
            return of();
        }
        if (i11 == 1) {
            return of(objArr[0]);
        }
        if (i11 < objArr.length) {
            objArr = Arrays.copyOf(objArr, i11);
        }
        return new RegularImmutableList(objArr);
    }

    public static <E> b<E> builder() {
        return new b<>();
    }

    public static <E> b<E> builderWithExpectedSize(int i11) {
        n1.b(i11, "expectedSize");
        return new b<>(i11);
    }

    private static <E> ImmutableList<E> construct(Object... objArr) {
        return asImmutableList(p6.b(objArr));
    }

    public static <E> ImmutableList<E> copyOf(Iterable<? extends E> iterable) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(iterable);
        return iterable instanceof Collection ? copyOf((Collection) iterable) : copyOf(iterable.iterator());
    }

    public static <E> ImmutableList<E> copyOf(Collection<? extends E> collection) {
        if (!(collection instanceof ImmutableCollection)) {
            return construct(collection.toArray());
        }
        ImmutableList<E> immutableListAsList = ((ImmutableCollection) collection).asList();
        return immutableListAsList.isPartialView() ? asImmutableList(immutableListAsList.toArray()) : immutableListAsList;
    }

    public static <E> ImmutableList<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        return !it.hasNext() ? of((Object) next) : new b().a(next).g(it).h();
    }

    public static <E> ImmutableList<E> copyOf(E[] eArr) {
        int length = eArr.length;
        if (length != 0) {
            return length != 1 ? construct((Object[]) eArr.clone()) : of((Object) eArr[0]);
        }
        return of();
    }

    public static <E> ImmutableList<E> of() {
        return (ImmutableList<E>) RegularImmutableList.EMPTY;
    }

    public static <E> ImmutableList<E> of(E e11) {
        return new SingletonImmutableList(e11);
    }

    public static <E> ImmutableList<E> of(E e11, E e12) {
        return construct(e11, e12);
    }

    public static <E> ImmutableList<E> of(E e11, E e12, E e13) {
        return construct(e11, e12, e13);
    }

    public static <E> ImmutableList<E> of(E e11, E e12, E e13, E e14) {
        return construct(e11, e12, e13, e14);
    }

    public static <E> ImmutableList<E> of(E e11, E e12, E e13, E e14, E e15) {
        return construct(e11, e12, e13, e14, e15);
    }

    public static <E> ImmutableList<E> of(E e11, E e12, E e13, E e14, E e15, E e16) {
        return construct(e11, e12, e13, e14, e15, e16);
    }

    public static <E> ImmutableList<E> of(E e11, E e12, E e13, E e14, E e15, E e16, E e17) {
        return construct(e11, e12, e13, e14, e15, e16, e17);
    }

    public static <E> ImmutableList<E> of(E e11, E e12, E e13, E e14, E e15, E e16, E e17, E e18) {
        return construct(e11, e12, e13, e14, e15, e16, e17, e18);
    }

    public static <E> ImmutableList<E> of(E e11, E e12, E e13, E e14, E e15, E e16, E e17, E e18, E e19) {
        return construct(e11, e12, e13, e14, e15, e16, e17, e18, e19);
    }

    public static <E> ImmutableList<E> of(E e11, E e12, E e13, E e14, E e15, E e16, E e17, E e18, E e19, E e21) {
        return construct(e11, e12, e13, e14, e15, e16, e17, e18, e19, e21);
    }

    public static <E> ImmutableList<E> of(E e11, E e12, E e13, E e14, E e15, E e16, E e17, E e18, E e19, E e21, E e22) {
        return construct(e11, e12, e13, e14, e15, e16, e17, e18, e19, e21, e22);
    }

    @SafeVarargs
    public static <E> ImmutableList<E> of(E e11, E e12, E e13, E e14, E e15, E e16, E e17, E e18, E e19, E e21, E e22, E e23, E... eArr) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.e(eArr.length <= 2147483635, "the total number of elements must fit in an int");
        Object[] objArr = new Object[eArr.length + 12];
        objArr[0] = e11;
        objArr[1] = e12;
        objArr[2] = e13;
        objArr[3] = e14;
        objArr[4] = e15;
        objArr[5] = e16;
        objArr[6] = e17;
        objArr[7] = e18;
        objArr[8] = e19;
        objArr[9] = e21;
        objArr[10] = e22;
        objArr[11] = e23;
        System.arraycopy(eArr, 0, objArr, 12, eArr.length);
        return construct(objArr);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<? super E>> ImmutableList<E> sortedCopyOf(Iterable<? extends E> iterable) {
        Comparable[] comparableArr = (Comparable[]) j5.l(iterable, new Comparable[0]);
        p6.b(comparableArr);
        Arrays.sort(comparableArr);
        return asImmutableList(comparableArr);
    }

    public static <E> ImmutableList<E> sortedCopyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(comparator);
        Object[] objArrK = j5.k(iterable);
        p6.b(objArrK);
        Arrays.sort(objArrK, comparator);
        return asImmutableList(objArrK);
    }

    public static <E> Collector<E, ?, ImmutableList<E>> toImmutableList() {
        return m1.n();
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i11, E e11) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i11, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
    public final ImmutableList<E> asList() {
        return this;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i11) {
        int size = size();
        for (int i12 = 0; i12 < size; i12++) {
            objArr[i11 + i12] = get(i12);
        }
        return i11 + size;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return Lists.c(this, obj);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> consumer) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(consumer);
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            consumer.accept(get(i11));
        }
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i11 = 1;
        for (int i12 = 0; i12 < size; i12++) {
            i11 = ~(~((i11 * 31) + get(i12).hashCode()));
        }
        return i11;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return Lists.d(this, obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public t7<E> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return Lists.f(this, obj);
    }

    @Override // java.util.List
    public u7<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public u7<E> listIterator(int i11) {
        return new a(size(), i11);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i11) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final void replaceAll(UnaryOperator<E> unaryOperator) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> reverse() {
        return size() <= 1 ? this : new ReverseImmutableList(this);
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i11, E e11) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final void sort(Comparator<? super E> comparator) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return x1.c(size(), 1296, new a3(this));
    }

    @Override // java.util.List
    public ImmutableList<E> subList(int i11, int i12) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.s(i11, i12, size());
        int i13 = i12 - i11;
        if (i13 == size()) {
            return this;
        }
        if (i13 == 0) {
            return of();
        }
        return i13 == 1 ? of((Object) get(i11)) : subListUnchecked(i11, i12);
    }

    public ImmutableList<E> subListUnchecked(int i11, int i12) {
        return new SubList(i11, i12 - i11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(toArray());
    }
}
