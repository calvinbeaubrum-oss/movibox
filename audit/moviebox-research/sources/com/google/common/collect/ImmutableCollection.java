package com.google.common.collect;

import com.google.android.gms.common.api.Api;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] EMPTY_ARRAY = new Object[0];

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public static abstract class a<E> extends b<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object[] f38346a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f38347b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f38348c;

        public a(int i11) {
            l.b(i11, "initialCapacity");
            this.f38346a = new Object[i11];
            this.f38347b = 0;
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        public b<E> b(E... eArr) {
            g(eArr, eArr.length);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        public b<E> c(Iterable<? extends E> iterable) {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                h(this.f38347b + collection.size());
                if (collection instanceof ImmutableCollection) {
                    this.f38347b = ((ImmutableCollection) collection).copyIntoArray(this.f38346a, this.f38347b);
                    return this;
                }
            }
            super.c(iterable);
            return this;
        }

        public a<E> f(E e11) {
            com.google.common.base.m.p(e11);
            h(this.f38347b + 1);
            Object[] objArr = this.f38346a;
            int i11 = this.f38347b;
            this.f38347b = i11 + 1;
            objArr[i11] = e11;
            return this;
        }

        public final void g(Object[] objArr, int i11) {
            l0.c(objArr, i11);
            h(this.f38347b + i11);
            System.arraycopy(objArr, 0, this.f38346a, this.f38347b, i11);
            this.f38347b += i11;
        }

        public final void h(int i11) {
            Object[] objArr = this.f38346a;
            if (objArr.length < i11) {
                this.f38346a = Arrays.copyOf(objArr, b.e(objArr.length, i11));
                this.f38348c = false;
            } else if (this.f38348c) {
                this.f38346a = (Object[]) objArr.clone();
                this.f38348c = false;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public static abstract class b<E> {
        public static int e(int i11, int i12) {
            if (i12 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int iHighestOneBit = i11 + (i11 >> 1) + 1;
            if (iHighestOneBit < i12) {
                iHighestOneBit = Integer.highestOneBit(i12 - 1) << 1;
            }
            return iHighestOneBit < 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : iHighestOneBit;
        }

        public abstract b<E> a(E e11);

        public b<E> b(E... eArr) {
            for (E e11 : eArr) {
                a(e11);
            }
            return this;
        }

        public b<E> c(Iterable<? extends E> iterable) {
            Iterator<? extends E> it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }

        public b<E> d(Iterator<? extends E> it) {
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e11) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> asList() {
        return isEmpty() ? ImmutableList.of() : ImmutableList.asImmutableList(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(Object obj);

    public int copyIntoArray(Object[] objArr, int i11) {
        g1<E> it = iterator();
        while (it.hasNext()) {
            objArr[i11] = it.next();
            i11++;
        }
        return i11;
    }

    public Object[] internalArray() {
        return null;
    }

    public int internalArrayEnd() {
        throw new UnsupportedOperationException();
    }

    public int internalArrayStart() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean isPartialView();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public abstract g1<E> iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(EMPTY_ARRAY);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        com.google.common.base.m.p(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] objArrInternalArray = internalArray();
            if (objArrInternalArray != null) {
                return (T[]) p0.a(objArrInternalArray, internalArrayStart(), internalArrayEnd(), tArr);
            }
            tArr = (T[]) l0.e(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        copyIntoArray(tArr, 0);
        return tArr;
    }

    public Object writeReplace() {
        return new ImmutableList.SerializedForm(toArray());
    }
}
