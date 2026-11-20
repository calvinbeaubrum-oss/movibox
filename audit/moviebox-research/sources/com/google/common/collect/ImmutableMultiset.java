package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ImmutableMultiset<E> extends ImmutableMultisetGwtSerializationDependencies<E> implements j0<E> {
    private transient ImmutableList<E> asList;
    private transient ImmutableSet<j0.a<E>> entrySet;

    /* JADX INFO: compiled from: source.java */
    public final class EntrySet extends IndexedImmutableSet<j0.a<E>> {
        private static final long serialVersionUID = 0;

        public EntrySet() {
        }

        public /* synthetic */ EntrySet(ImmutableMultiset immutableMultiset, a aVar) {
            this();
        }

        private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Use EntrySetSerializedForm");
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof j0.a)) {
                return false;
            }
            j0.a aVar = (j0.a) obj;
            return aVar.getCount() > 0 && ImmutableMultiset.this.count(aVar.getElement()) == aVar.getCount();
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public j0.a<E> get(int i11) {
            return ImmutableMultiset.this.getEntry(i11);
        }

        @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return ImmutableMultiset.this.hashCode();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return ImmutableMultiset.this.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ImmutableMultiset.this.elementSet().size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return new EntrySetSerializedForm(ImmutableMultiset.this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class EntrySetSerializedForm<E> implements Serializable {
        final ImmutableMultiset<E> multiset;

        public EntrySetSerializedForm(ImmutableMultiset<E> immutableMultiset) {
            this.multiset = immutableMultiset;
        }

        public Object readResolve() {
            return this.multiset.entrySet();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends g1<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f38377a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public E f38378b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Iterator f38379c;

        public a(ImmutableMultiset immutableMultiset, Iterator it) {
            this.f38379c = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f38377a > 0 || this.f38379c.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.f38377a <= 0) {
                j0.a aVar = (j0.a) this.f38379c.next();
                this.f38378b = (E) aVar.getElement();
                this.f38377a = aVar.getCount();
            }
            this.f38377a--;
            E e11 = this.f38378b;
            Objects.requireNonNull(e11);
            return e11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b<E> extends ImmutableCollection.b<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public m0<E> f38380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f38381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f38382c;

        public b() {
            this(4);
        }

        public b(int i11) {
            this.f38381b = false;
            this.f38382c = false;
            this.f38380a = m0.c(i11);
        }

        public b(boolean z11) {
            this.f38381b = false;
            this.f38382c = false;
            this.f38380a = null;
        }

        public static <T> m0<T> l(Iterable<T> iterable) {
            if (iterable instanceof RegularImmutableMultiset) {
                return ((RegularImmutableMultiset) iterable).contents;
            }
            if (iterable instanceof AbstractMapBasedMultiset) {
                return ((AbstractMapBasedMultiset) iterable).backingMap;
            }
            return null;
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public b<E> a(E e11) {
            return j(e11, 1);
        }

        public b<E> g(E... eArr) {
            super.b(eArr);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b<E> h(Iterable<? extends E> iterable) {
            Objects.requireNonNull(this.f38380a);
            if (iterable instanceof j0) {
                j0 j0VarD = Multisets.d(iterable);
                m0 m0VarL = l(j0VarD);
                if (m0VarL != null) {
                    m0<E> m0Var = this.f38380a;
                    m0Var.d(Math.max(m0Var.C(), m0VarL.C()));
                    for (int iE = m0VarL.e(); iE >= 0; iE = m0VarL.s(iE)) {
                        j(m0VarL.i(iE), m0VarL.k(iE));
                    }
                } else {
                    Set<j0.a<E>> setEntrySet = j0VarD.entrySet();
                    m0<E> m0Var2 = this.f38380a;
                    m0Var2.d(Math.max(m0Var2.C(), setEntrySet.size()));
                    for (j0.a<E> aVar : j0VarD.entrySet()) {
                        j(aVar.getElement(), aVar.getCount());
                    }
                }
            } else {
                super.c(iterable);
            }
            return this;
        }

        public b<E> i(Iterator<? extends E> it) {
            super.d(it);
            return this;
        }

        public b<E> j(E e11, int i11) {
            Objects.requireNonNull(this.f38380a);
            if (i11 == 0) {
                return this;
            }
            if (this.f38381b) {
                this.f38380a = new m0<>(this.f38380a);
                this.f38382c = false;
            }
            this.f38381b = false;
            com.google.common.base.m.p(e11);
            m0<E> m0Var = this.f38380a;
            m0Var.u(e11, i11 + m0Var.f(e11));
            return this;
        }

        public ImmutableMultiset<E> k() {
            Objects.requireNonNull(this.f38380a);
            if (this.f38380a.C() == 0) {
                return ImmutableMultiset.of();
            }
            if (this.f38382c) {
                this.f38380a = new m0<>(this.f38380a);
                this.f38382c = false;
            }
            this.f38381b = true;
            return new RegularImmutableMultiset(this.f38380a);
        }
    }

    public static <E> b<E> builder() {
        return new b<>();
    }

    private static <E> ImmutableMultiset<E> copyFromElements(E... eArr) {
        return new b().g(eArr).k();
    }

    public static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends j0.a<? extends E>> collection) {
        b bVar = new b(collection.size());
        for (j0.a<? extends E> aVar : collection) {
            bVar.j(aVar.getElement(), aVar.getCount());
        }
        return bVar.k();
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableMultiset) {
            ImmutableMultiset<E> immutableMultiset = (ImmutableMultiset) iterable;
            if (!immutableMultiset.isPartialView()) {
                return immutableMultiset;
            }
        }
        b bVar = new b(Multisets.h(iterable));
        bVar.h(iterable);
        return bVar.k();
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> it) {
        return new b().i(it).k();
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] eArr) {
        return copyFromElements(eArr);
    }

    private ImmutableSet<j0.a<E>> createEntrySet() {
        return isEmpty() ? ImmutableSet.of() : new EntrySet(this, null);
    }

    public static <E> ImmutableMultiset<E> of() {
        return RegularImmutableMultiset.EMPTY;
    }

    public static <E> ImmutableMultiset<E> of(E e11) {
        return copyFromElements(e11);
    }

    public static <E> ImmutableMultiset<E> of(E e11, E e12) {
        return copyFromElements(e11, e12);
    }

    public static <E> ImmutableMultiset<E> of(E e11, E e12, E e13) {
        return copyFromElements(e11, e12, e13);
    }

    public static <E> ImmutableMultiset<E> of(E e11, E e12, E e13, E e14) {
        return copyFromElements(e11, e12, e13, e14);
    }

    public static <E> ImmutableMultiset<E> of(E e11, E e12, E e13, E e14, E e15) {
        return copyFromElements(e11, e12, e13, e14, e15);
    }

    public static <E> ImmutableMultiset<E> of(E e11, E e12, E e13, E e14, E e15, E e16, E... eArr) {
        return new b().a(e11).a(e12).a(e13).a(e14).a(e15).a(e16).g(eArr).k();
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.j0
    @Deprecated
    public final int add(E e11, int i11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> immutableListAsList = super.asList();
        this.asList = immutableListAsList;
        return immutableListAsList;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return count(obj) > 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i11) {
        g1<j0.a<E>> it = entrySet().iterator();
        while (it.hasNext()) {
            j0.a<E> next = it.next();
            Arrays.fill(objArr, i11, next.getCount() + i11, next.getElement());
            i11 += next.getCount();
        }
        return i11;
    }

    public abstract /* synthetic */ int count(Object obj);

    @Override // com.google.common.collect.j0
    public abstract ImmutableSet<E> elementSet();

    @Override // com.google.common.collect.j0
    public ImmutableSet<j0.a<E>> entrySet() {
        ImmutableSet<j0.a<E>> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<j0.a<E>> immutableSetCreateEntrySet = createEntrySet();
        this.entrySet = immutableSetCreateEntrySet;
        return immutableSetCreateEntrySet;
    }

    @Override // java.util.Collection, com.google.common.collect.j0
    public boolean equals(Object obj) {
        return Multisets.f(this, obj);
    }

    public abstract j0.a<E> getEntry(int i11);

    @Override // java.util.Collection, com.google.common.collect.j0
    public int hashCode() {
        return Sets.d(entrySet());
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public g1<E> iterator() {
        return new a(this, entrySet().iterator());
    }

    @Override // com.google.common.collect.j0
    @Deprecated
    public final int remove(Object obj, int i11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.j0
    @Deprecated
    public final int setCount(E e11, int i11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.j0
    @Deprecated
    public final boolean setCount(E e11, int i11, int i12) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public abstract Object writeReplace();
}
