package com.google.common.collect;

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

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {
    private static final h1<Object> EMPTY_ITR = new b(RegularImmutableList.EMPTY, 0);

    /* JADX INFO: compiled from: source.java */
    public static class ReverseImmutableList<E> extends ImmutableList<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final transient ImmutableList<E> f38349a;

        public ReverseImmutableList(ImmutableList<E> immutableList) {
            this.f38349a = immutableList;
        }

        public final int a(int i11) {
            return (size() - 1) - i11;
        }

        public final int b(int i11) {
            return size() - i11;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f38349a.contains(obj);
        }

        @Override // java.util.List
        public E get(int i11) {
            com.google.common.base.m.n(i11, size());
            return this.f38349a.get(a(i11));
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(Object obj) {
            int iLastIndexOf = this.f38349a.lastIndexOf(obj);
            if (iLastIndexOf >= 0) {
                return a(iLastIndexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return this.f38349a.isPartialView();
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(Object obj) {
            int iIndexOf = this.f38349a.indexOf(obj);
            if (iIndexOf >= 0) {
                return a(iIndexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i11) {
            return super.listIterator(i11);
        }

        @Override // com.google.common.collect.ImmutableList
        public ImmutableList<E> reverse() {
            return this.f38349a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f38349a.size();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i11, int i12) {
            com.google.common.base.m.u(i11, i12, size());
            return this.f38349a.subList(b(i12), b(i11)).reverse();
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
            com.google.common.base.m.n(i11, this.length);
            return ImmutableList.this.get(i11 + this.offset);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public Object[] internalArray() {
            return ImmutableList.this.internalArray();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int internalArrayEnd() {
            return ImmutableList.this.internalArrayStart() + this.offset + this.length;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int internalArrayStart() {
            return ImmutableList.this.internalArrayStart() + this.offset;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i11) {
            return super.listIterator(i11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.length;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i11, int i12) {
            com.google.common.base.m.u(i11, i12, this.length);
            ImmutableList immutableList = ImmutableList.this;
            int i13 = this.offset;
            return immutableList.subList(i11 + i13, i12 + i13);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a<E> extends ImmutableCollection.a<E> {
        public a() {
            this(4);
        }

        public a(int i11) {
            super(i11);
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public a<E> a(E e11) {
            super.f(e11);
            return this;
        }

        public a<E> j(E... eArr) {
            super.b(eArr);
            return this;
        }

        public a<E> k(Iterable<? extends E> iterable) {
            super.c(iterable);
            return this;
        }

        public a<E> l(Iterator<? extends E> it) {
            super.d(it);
            return this;
        }

        public ImmutableList<E> m() {
            this.f38348c = true;
            return ImmutableList.asImmutableList(this.f38346a, this.f38347b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b<E> extends com.google.common.collect.a<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImmutableList<E> f38350c;

        public b(ImmutableList<E> immutableList, int i11) {
            super(immutableList.size(), i11);
            this.f38350c = immutableList;
        }

        @Override // com.google.common.collect.a
        public E a(int i11) {
            return this.f38350c.get(i11);
        }
    }

    public static <E> ImmutableList<E> asImmutableList(Object[] objArr) {
        return asImmutableList(objArr, objArr.length);
    }

    public static <E> ImmutableList<E> asImmutableList(Object[] objArr, int i11) {
        return i11 == 0 ? of() : new RegularImmutableList(objArr, i11);
    }

    public static <E> a<E> builder() {
        return new a<>();
    }

    public static <E> a<E> builderWithExpectedSize(int i11) {
        l.b(i11, "expectedSize");
        return new a<>(i11);
    }

    private static <E> ImmutableList<E> construct(Object... objArr) {
        return asImmutableList(l0.b(objArr));
    }

    public static <E> ImmutableList<E> copyOf(Iterable<? extends E> iterable) {
        com.google.common.base.m.p(iterable);
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
        return !it.hasNext() ? of((Object) next) : new a().a(next).l(it).m();
    }

    public static <E> ImmutableList<E> copyOf(E[] eArr) {
        return eArr.length == 0 ? of() : construct((Object[]) eArr.clone());
    }

    public static <E> ImmutableList<E> of() {
        return (ImmutableList<E>) RegularImmutableList.EMPTY;
    }

    public static <E> ImmutableList<E> of(E e11) {
        return construct(e11);
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
        com.google.common.base.m.e(eArr.length <= 2147483635, "the total number of elements must fit in an int");
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
        Comparable[] comparableArr = (Comparable[]) e0.q(iterable, new Comparable[0]);
        l0.b(comparableArr);
        Arrays.sort(comparableArr);
        return asImmutableList(comparableArr);
    }

    public static <E> ImmutableList<E> sortedCopyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        com.google.common.base.m.p(comparator);
        Object[] objArrP = e0.p(iterable);
        l0.b(objArrP);
        Arrays.sort(objArrP, comparator);
        return asImmutableList(objArrP);
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

    @Override // com.google.common.collect.ImmutableCollection
    @Deprecated
    public final ImmutableList<E> asList() {
        return this;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i11) {
        int size = size();
        for (int i12 = 0; i12 < size; i12++) {
            objArr[i11 + i12] = get(i12);
        }
        return i11 + size;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return Lists.d(this, obj);
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
        return Lists.e(this, obj);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public g1<E> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return Lists.g(this, obj);
    }

    @Override // java.util.List
    public h1<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public h1<E> listIterator(int i11) {
        com.google.common.base.m.s(i11, size());
        return isEmpty() ? (h1<E>) EMPTY_ITR : new b(this, i11);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i11) {
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
    public ImmutableList<E> subList(int i11, int i12) {
        com.google.common.base.m.u(i11, i12, size());
        int i13 = i12 - i11;
        if (i13 == size()) {
            return this;
        }
        return i13 == 0 ? of() : subListUnchecked(i11, i12);
    }

    public ImmutableList<E> subListUnchecked(int i11, int i12) {
        return new SubList(i11, i12 - i11);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(toArray());
    }
}
