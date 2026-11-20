package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.android.gms.common.api.Api;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Function;
import java.util.function.ObjIntConsumer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class Multisets {

    /* JADX INFO: compiled from: source.java */
    public static final class DecreasingCount implements Comparator<l6.a<?>> {
        static final DecreasingCount INSTANCE = new DecreasingCount();

        private DecreasingCount() {
        }

        @Override // java.util.Comparator
        public int compare(l6.a<?> aVar, l6.a<?> aVar2) {
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
            n1.b(i11, "count");
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6.a
        public final int getCount() {
            return this.count;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6.a
        public final E getElement() {
            return this.element;
        }

        public ImmutableEntry<E> nextInBucket() {
            return null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: compiled from: source.java */
    public static class a<E> extends r7<l6.a<E>, E> {
        public a(Iterator it) {
            super(it);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.r7
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public E a(l6.a<E> aVar) {
            return aVar.getElement();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class b<E> implements l6.a<E> {
        public boolean equals(Object obj) {
            if (!(obj instanceof l6.a)) {
                return false;
            }
            l6.a aVar = (l6.a) obj;
            return getCount() == aVar.getCount() && com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.g.a(getElement(), aVar.getElement());
        }

        public int hashCode() {
            E element = getElement();
            return (element == null ? 0 : element.hashCode()) ^ getCount();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6.a
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
    public static abstract class c<E> extends Sets.a<E> {
        public abstract l6<E> a();

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
    public static abstract class d<E> extends Sets.a<l6.a<E>> {
        public abstract l6<E> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof l6.a)) {
                return false;
            }
            l6.a aVar = (l6.a) obj;
            return aVar.getCount() > 0 && a().count(aVar.getElement()) == aVar.getCount();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof l6.a) {
                l6.a aVar = (l6.a) obj;
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
        public final l6<E> f39536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Iterator<l6.a<E>> f39537b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public l6.a<E> f39538c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f39539d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f39540f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f39541g;

        public e(l6<E> l6Var, Iterator<l6.a<E>> it) {
            this.f39536a = l6Var;
            this.f39537b = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f39539d > 0 || this.f39537b.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (this.f39539d == 0) {
                l6.a<E> next = this.f39537b.next();
                this.f39538c = next;
                int count = next.getCount();
                this.f39539d = count;
                this.f39540f = count;
            }
            this.f39539d--;
            this.f39541g = true;
            return this.f39538c.getElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            n1.e(this.f39541g);
            if (this.f39540f == 1) {
                this.f39537b.remove();
            } else {
                this.f39536a.remove(this.f39538c.getElement());
            }
            this.f39540f--;
            this.f39541g = false;
        }
    }

    public static <E> boolean b(final l6<E> l6Var, l6<? extends E> l6Var2) {
        if (l6Var2.isEmpty()) {
            return false;
        }
        l6Var.getClass();
        l6Var2.forEachEntry(new ObjIntConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.m6
            @Override // java.util.function.ObjIntConsumer
            public final void accept(Object obj, int i11) {
                l6Var.add(obj, i11);
            }
        });
        return true;
    }

    public static <E> boolean c(l6<E> l6Var, Collection<? extends E> collection) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(l6Var);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(collection);
        if (collection instanceof l6) {
            return b(l6Var, d(collection));
        }
        if (collection.isEmpty()) {
            return false;
        }
        return Iterators.a(l6Var, collection.iterator());
    }

    public static <T> l6<T> d(Iterable<T> iterable) {
        return (l6) iterable;
    }

    public static <E> Iterator<E> e(Iterator<l6.a<E>> it) {
        return new a(it);
    }

    public static boolean f(l6<?> l6Var, Object obj) {
        if (obj == l6Var) {
            return true;
        }
        if (obj instanceof l6) {
            l6 l6Var2 = (l6) obj;
            if (l6Var.size() == l6Var2.size() && l6Var.entrySet().size() == l6Var2.entrySet().size()) {
                for (l6.a aVar : l6Var2.entrySet()) {
                    if (l6Var.count(aVar.getElement()) != aVar.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static <E> l6.a<E> g(E e11, int i11) {
        return new ImmutableEntry(e11, i11);
    }

    public static int h(Iterable<?> iterable) {
        if (iterable instanceof l6) {
            return ((l6) iterable).elementSet().size();
        }
        return 11;
    }

    public static <E> Iterator<E> i(l6<E> l6Var) {
        return new e(l6Var, l6Var.entrySet().iterator());
    }

    public static /* synthetic */ Spliterator j(l6.a aVar) {
        return Collections.nCopies(aVar.getCount(), aVar.getElement()).spliterator();
    }

    public static boolean k(l6<?> l6Var, Collection<?> collection) {
        if (collection instanceof l6) {
            collection = ((l6) collection).elementSet();
        }
        return l6Var.elementSet().removeAll(collection);
    }

    public static boolean l(l6<?> l6Var, Collection<?> collection) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(collection);
        if (collection instanceof l6) {
            collection = ((l6) collection).elementSet();
        }
        return l6Var.elementSet().retainAll(collection);
    }

    public static <E> int m(l6<E> l6Var, E e11, int i11) {
        n1.b(i11, "count");
        int iCount = l6Var.count(e11);
        int i12 = i11 - iCount;
        if (i12 > 0) {
            l6Var.add(e11, i12);
        } else if (i12 < 0) {
            l6Var.remove(e11, -i12);
        }
        return iCount;
    }

    public static <E> boolean n(l6<E> l6Var, E e11, int i11, int i12) {
        n1.b(i11, "oldCount");
        n1.b(i12, "newCount");
        if (l6Var.count(e11) != i11) {
            return false;
        }
        l6Var.setCount(e11, i12);
        return true;
    }

    public static <E> Spliterator<E> o(l6<E> l6Var) {
        Spliterator spliterator = l6Var.entrySet().spliterator();
        return x1.b(spliterator, new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n6
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Multisets.j((l6.a) obj);
            }
        }, (spliterator.characteristics() & 1296) | 64, l6Var.size());
    }
}
