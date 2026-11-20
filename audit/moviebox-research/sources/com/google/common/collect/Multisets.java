package com.google.common.collect;

import com.google.android.gms.common.api.Api;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class Multisets {

    /* JADX INFO: compiled from: source.java */
    public static final class DecreasingCount implements Comparator<j0.a<?>> {
        static final DecreasingCount INSTANCE = new DecreasingCount();

        private DecreasingCount() {
        }

        @Override // java.util.Comparator
        public int compare(j0.a<?> aVar, j0.a<?> aVar2) {
            return aVar2.getCount() - aVar.getCount();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class ImmutableEntry<E> extends b<E> implements Serializable {
        private static final long serialVersionUID = 0;
        private final int count;
        private final E element;

        public ImmutableEntry(E e11, int i11) {
            this.element = e11;
            this.count = i11;
            l.b(i11, "count");
        }

        @Override // com.google.common.collect.j0.a
        public final int getCount() {
            return this.count;
        }

        @Override // com.google.common.collect.j0.a
        public final E getElement() {
            return this.element;
        }

        public ImmutableEntry<E> nextInBucket() {
            return null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: compiled from: source.java */
    public class a<E> extends d1<j0.a<E>, E> {
        public a(Iterator it) {
            super(it);
        }

        @Override // com.google.common.collect.d1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public E a(j0.a<E> aVar) {
            return aVar.getElement();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class b<E> implements j0.a<E> {
        public boolean equals(Object obj) {
            if (!(obj instanceof j0.a)) {
                return false;
            }
            j0.a aVar = (j0.a) obj;
            return getCount() == aVar.getCount() && com.google.common.base.j.a(getElement(), aVar.getElement());
        }

        public int hashCode() {
            E element = getElement();
            return (element == null ? 0 : element.hashCode()) ^ getCount();
        }

        @Override // com.google.common.collect.j0.a
        public String toString() {
            String strValueOf = String.valueOf(getElement());
            int count = getCount();
            if (count == 1) {
                return strValueOf;
            }
            return strValueOf + " x " + count;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class c<E> extends Sets.d<E> {
        public abstract j0<E> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return a().contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return a().containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return a().remove(obj, Api.BaseClientBuilder.API_PRIORITY_OTHER) > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().entrySet().size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class d<E> extends Sets.d<j0.a<E>> {
        public abstract j0<E> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof j0.a)) {
                return false;
            }
            j0.a aVar = (j0.a) obj;
            return aVar.getCount() > 0 && a().count(aVar.getElement()) == aVar.getCount();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof j0.a) {
                j0.a aVar = (j0.a) obj;
                Object element = aVar.getElement();
                int count = aVar.getCount();
                if (count != 0) {
                    return a().setCount(element, count, 0);
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e<E> implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j0<E> f38539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Iterator<j0.a<E>> f38540b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public j0.a<E> f38541c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f38542d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f38543f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f38544g;

        public e(j0<E> j0Var, Iterator<j0.a<E>> it) {
            this.f38539a = j0Var;
            this.f38540b = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f38542d > 0 || this.f38540b.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (this.f38542d == 0) {
                j0.a<E> next = this.f38540b.next();
                this.f38541c = next;
                int count = next.getCount();
                this.f38542d = count;
                this.f38543f = count;
            }
            this.f38542d--;
            this.f38544g = true;
            j0.a<E> aVar = this.f38541c;
            Objects.requireNonNull(aVar);
            return aVar.getElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            l.e(this.f38544g);
            if (this.f38543f == 1) {
                this.f38540b.remove();
            } else {
                j0<E> j0Var = this.f38539a;
                j0.a<E> aVar = this.f38541c;
                Objects.requireNonNull(aVar);
                j0Var.remove(aVar.getElement());
            }
            this.f38543f--;
            this.f38544g = false;
        }
    }

    public static <E> boolean a(j0<E> j0Var, AbstractMapBasedMultiset<? extends E> abstractMapBasedMultiset) {
        if (abstractMapBasedMultiset.isEmpty()) {
            return false;
        }
        abstractMapBasedMultiset.addTo(j0Var);
        return true;
    }

    public static <E> boolean b(j0<E> j0Var, j0<? extends E> j0Var2) {
        if (j0Var2 instanceof AbstractMapBasedMultiset) {
            return a(j0Var, (AbstractMapBasedMultiset) j0Var2);
        }
        if (j0Var2.isEmpty()) {
            return false;
        }
        for (j0.a<? extends E> aVar : j0Var2.entrySet()) {
            j0Var.add(aVar.getElement(), aVar.getCount());
        }
        return true;
    }

    public static <E> boolean c(j0<E> j0Var, Collection<? extends E> collection) {
        com.google.common.base.m.p(j0Var);
        com.google.common.base.m.p(collection);
        if (collection instanceof j0) {
            return b(j0Var, d(collection));
        }
        if (collection.isEmpty()) {
            return false;
        }
        return Iterators.a(j0Var, collection.iterator());
    }

    public static <T> j0<T> d(Iterable<T> iterable) {
        return (j0) iterable;
    }

    public static <E> Iterator<E> e(Iterator<j0.a<E>> it) {
        return new a(it);
    }

    public static boolean f(j0<?> j0Var, Object obj) {
        if (obj == j0Var) {
            return true;
        }
        if (obj instanceof j0) {
            j0 j0Var2 = (j0) obj;
            if (j0Var.size() == j0Var2.size() && j0Var.entrySet().size() == j0Var2.entrySet().size()) {
                for (j0.a aVar : j0Var2.entrySet()) {
                    if (j0Var.count(aVar.getElement()) != aVar.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static <E> j0.a<E> g(E e11, int i11) {
        return new ImmutableEntry(e11, i11);
    }

    public static int h(Iterable<?> iterable) {
        if (iterable instanceof j0) {
            return ((j0) iterable).elementSet().size();
        }
        return 11;
    }

    public static <E> Iterator<E> i(j0<E> j0Var) {
        return new e(j0Var, j0Var.entrySet().iterator());
    }

    public static boolean j(j0<?> j0Var, Collection<?> collection) {
        if (collection instanceof j0) {
            collection = ((j0) collection).elementSet();
        }
        return j0Var.elementSet().removeAll(collection);
    }

    public static boolean k(j0<?> j0Var, Collection<?> collection) {
        com.google.common.base.m.p(collection);
        if (collection instanceof j0) {
            collection = ((j0) collection).elementSet();
        }
        return j0Var.elementSet().retainAll(collection);
    }

    public static <E> int l(j0<E> j0Var, E e11, int i11) {
        l.b(i11, "count");
        int iCount = j0Var.count(e11);
        int i12 = i11 - iCount;
        if (i12 > 0) {
            j0Var.add(e11, i12);
        } else if (i12 < 0) {
            j0Var.remove(e11, -i12);
        }
        return iCount;
    }

    public static <E> boolean m(j0<E> j0Var, E e11, int i11, int i12) {
        l.b(i11, "oldCount");
        l.b(i12, "newCount");
        if (j0Var.count(e11) != i11) {
            return false;
        }
        j0Var.setCount(e11, i12);
        return true;
    }
}
