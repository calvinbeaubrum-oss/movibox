package com.google.common.collect;

import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class Lists {

    /* JADX INFO: compiled from: source.java */
    public static class OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        final E first;
        final E[] rest;

        public OnePlusArrayList(E e11, E[] eArr) {
            this.first = e11;
            this.rest = (E[]) ((Object[]) com.google.common.base.m.p(eArr));
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i11) {
            com.google.common.base.m.n(i11, size());
            return i11 == 0 ? this.first : this.rest[i11 - 1];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return com.google.common.math.d.h(this.rest.length, 1);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final com.google.common.base.f<? super F, ? extends T> function;

        /* JADX INFO: compiled from: source.java */
        public class a extends e1<F, T> {
            public a(ListIterator listIterator) {
                super(listIterator);
            }

            @Override // com.google.common.collect.d1
            public T a(F f11) {
                return TransformingRandomAccessList.this.function.apply(f11);
            }
        }

        public TransformingRandomAccessList(List<F> list, com.google.common.base.f<? super F, ? extends T> fVar) {
            this.fromList = (List) com.google.common.base.m.p(list);
            this.function = (com.google.common.base.f) com.google.common.base.m.p(fVar);
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i11) {
            return this.function.apply(this.fromList.get(i11));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.fromList.isEmpty();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i11) {
            return new a(this.fromList.listIterator(i11));
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int i11) {
            return this.function.apply(this.fromList.remove(i11));
        }

        @Override // java.util.AbstractList
        public void removeRange(int i11, int i12) {
            this.fromList.subList(i11, i12).clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final com.google.common.base.f<? super F, ? extends T> function;

        /* JADX INFO: compiled from: source.java */
        public class a extends e1<F, T> {
            public a(ListIterator listIterator) {
                super(listIterator);
            }

            @Override // com.google.common.collect.d1
            public T a(F f11) {
                return TransformingSequentialList.this.function.apply(f11);
            }
        }

        public TransformingSequentialList(List<F> list, com.google.common.base.f<? super F, ? extends T> fVar) {
            this.fromList = (List) com.google.common.base.m.p(list);
            this.function = (com.google.common.base.f) com.google.common.base.m.p(fVar);
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i11) {
            return new a(this.fromList.listIterator(i11));
        }

        @Override // java.util.AbstractList
        public void removeRange(int i11, int i12) {
            this.fromList.subList(i11, i12).clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    public static <E> List<E> a(E e11, E[] eArr) {
        return new OnePlusArrayList(e11, eArr);
    }

    public static <T> List<T> b(Iterable<T> iterable) {
        return (List) iterable;
    }

    public static int c(int i11) {
        l.b(i11, "arraySize");
        return Ints.l(((long) i11) + 5 + ((long) (i11 / 10)));
    }

    public static boolean d(List<?> list, Object obj) {
        if (obj == com.google.common.base.m.p(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return Iterators.h(list.iterator(), list2.iterator());
        }
        for (int i11 = 0; i11 < size; i11++) {
            if (!com.google.common.base.j.a(list.get(i11), list2.get(i11))) {
                return false;
            }
        }
        return true;
    }

    public static int e(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return f(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (com.google.common.base.j.a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    public static int f(List<?> list, Object obj) {
        int size = list.size();
        int i11 = 0;
        if (obj == null) {
            while (i11 < size) {
                if (list.get(i11) == null) {
                    return i11;
                }
                i11++;
            }
            return -1;
        }
        while (i11 < size) {
            if (obj.equals(list.get(i11))) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static int g(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return h(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (com.google.common.base.j.a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public static int h(List<?> list, Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    public static <E> ArrayList<E> i() {
        return new ArrayList<>();
    }

    public static <E> ArrayList<E> j(Iterable<? extends E> iterable) {
        com.google.common.base.m.p(iterable);
        return iterable instanceof Collection ? new ArrayList<>((Collection) iterable) : k(iterable.iterator());
    }

    public static <E> ArrayList<E> k(Iterator<? extends E> it) {
        ArrayList<E> arrayListI = i();
        Iterators.a(arrayListI, it);
        return arrayListI;
    }

    @SafeVarargs
    public static <E> ArrayList<E> l(E... eArr) {
        com.google.common.base.m.p(eArr);
        ArrayList<E> arrayList = new ArrayList<>(c(eArr.length));
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    public static <E> ArrayList<E> m(int i11) {
        l.b(i11, "initialArraySize");
        return new ArrayList<>(i11);
    }

    public static <E> ArrayList<E> n(int i11) {
        return new ArrayList<>(c(i11));
    }

    public static <F, T> List<T> o(List<F> list, com.google.common.base.f<? super F, ? extends T> fVar) {
        return list instanceof RandomAccess ? new TransformingRandomAccessList(list, fVar) : new TransformingSequentialList(list, fVar);
    }
}
