package com.google.common.collect;

import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
abstract class AbstractMapBasedMultiset<E> extends d<E> implements Serializable {
    private static final long serialVersionUID = 0;
    transient m0<E> backingMap;
    transient long size;

    /* JADX INFO: compiled from: source.java */
    public class a extends AbstractMapBasedMultiset<E>.c<E> {
        public a() {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultiset.c
        public E b(int i11) {
            return AbstractMapBasedMultiset.this.backingMap.i(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AbstractMapBasedMultiset<E>.c<j0.a<E>> {
        public b() {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultiset.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public j0.a<E> b(int i11) {
            return AbstractMapBasedMultiset.this.backingMap.g(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public abstract class c<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f38247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f38248b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f38249c;

        public c() {
            this.f38247a = AbstractMapBasedMultiset.this.backingMap.e();
            this.f38249c = AbstractMapBasedMultiset.this.backingMap.f38707d;
        }

        public final void a() {
            if (AbstractMapBasedMultiset.this.backingMap.f38707d != this.f38249c) {
                throw new ConcurrentModificationException();
            }
        }

        public abstract T b(int i11);

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f38247a >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T tB = b(this.f38247a);
            int i11 = this.f38247a;
            this.f38248b = i11;
            this.f38247a = AbstractMapBasedMultiset.this.backingMap.s(i11);
            return tB;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            l.e(this.f38248b != -1);
            AbstractMapBasedMultiset abstractMapBasedMultiset = AbstractMapBasedMultiset.this;
            abstractMapBasedMultiset.size -= (long) abstractMapBasedMultiset.backingMap.x(this.f38248b);
            this.f38247a = AbstractMapBasedMultiset.this.backingMap.t(this.f38247a, this.f38248b);
            this.f38248b = -1;
            this.f38249c = AbstractMapBasedMultiset.this.backingMap.f38707d;
        }
    }

    public AbstractMapBasedMultiset(int i11) {
        this.backingMap = newBackingMap(i11);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int iH = u0.h(objectInputStream);
        this.backingMap = newBackingMap(3);
        u0.g(this, objectInputStream, iH);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        u0.k(this, objectOutputStream);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.j0
    public final int add(E e11, int i11) {
        if (i11 == 0) {
            return count(e11);
        }
        com.google.common.base.m.g(i11 > 0, "occurrences cannot be negative: %s", i11);
        int iM = this.backingMap.m(e11);
        if (iM == -1) {
            this.backingMap.u(e11, i11);
            this.size += (long) i11;
            return 0;
        }
        int iK = this.backingMap.k(iM);
        long j11 = i11;
        long j12 = ((long) iK) + j11;
        com.google.common.base.m.i(j12 <= 2147483647L, "too many occurrences: %s", j12);
        this.backingMap.B(iM, (int) j12);
        this.size += j11;
        return iK;
    }

    public void addTo(j0<? super E> j0Var) {
        com.google.common.base.m.p(j0Var);
        int iE = this.backingMap.e();
        while (iE >= 0) {
            j0Var.add(this.backingMap.i(iE), this.backingMap.k(iE));
            iE = this.backingMap.s(iE);
        }
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.backingMap.a();
        this.size = 0L;
    }

    @Override // com.google.common.collect.j0
    public final int count(Object obj) {
        return this.backingMap.f(obj);
    }

    @Override // com.google.common.collect.d
    public final int distinctElements() {
        return this.backingMap.C();
    }

    @Override // com.google.common.collect.d
    public final Iterator<E> elementIterator() {
        return new a();
    }

    @Override // com.google.common.collect.d
    public final Iterator<j0.a<E>> entryIterator() {
        return new b();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        return Multisets.i(this);
    }

    public abstract m0<E> newBackingMap(int i11);

    @Override // com.google.common.collect.d, com.google.common.collect.j0
    public final int remove(Object obj, int i11) {
        if (i11 == 0) {
            return count(obj);
        }
        com.google.common.base.m.g(i11 > 0, "occurrences cannot be negative: %s", i11);
        int iM = this.backingMap.m(obj);
        if (iM == -1) {
            return 0;
        }
        int iK = this.backingMap.k(iM);
        if (iK > i11) {
            this.backingMap.B(iM, iK - i11);
        } else {
            this.backingMap.x(iM);
            i11 = iK;
        }
        this.size -= (long) i11;
        return iK;
    }

    @Override // com.google.common.collect.d, com.google.common.collect.j0
    public final int setCount(E e11, int i11) {
        l.b(i11, "count");
        m0<E> m0Var = this.backingMap;
        int iV = i11 == 0 ? m0Var.v(e11) : m0Var.u(e11, i11);
        this.size += (long) (i11 - iV);
        return iV;
    }

    @Override // com.google.common.collect.d, com.google.common.collect.j0
    public final boolean setCount(E e11, int i11, int i12) {
        l.b(i11, "oldCount");
        l.b(i12, "newCount");
        int iM = this.backingMap.m(e11);
        if (iM == -1) {
            if (i11 != 0) {
                return false;
            }
            if (i12 > 0) {
                this.backingMap.u(e11, i12);
                this.size += (long) i12;
            }
            return true;
        }
        if (this.backingMap.k(iM) != i11) {
            return false;
        }
        if (i12 == 0) {
            this.backingMap.x(iM);
            this.size -= (long) i11;
        } else {
            this.backingMap.B(iM, i12);
            this.size += (long) (i12 - i11);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j0
    public final int size() {
        return Ints.l(this.size);
    }
}
