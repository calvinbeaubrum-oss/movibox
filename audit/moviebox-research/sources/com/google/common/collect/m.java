package com.google.common.collect;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class m {

    /* JADX INFO: compiled from: source.java */
    public static class a<E> extends AbstractCollection<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Collection<E> f38702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.google.common.base.n<? super E> f38703b;

        public a(Collection<E> collection, com.google.common.base.n<? super E> nVar) {
            this.f38702a = collection;
            this.f38703b = nVar;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(E e11) {
            com.google.common.base.m.d(this.f38703b.apply(e11));
            return this.f38702a.add(e11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            Iterator<? extends E> it = collection.iterator();
            while (it.hasNext()) {
                com.google.common.base.m.d(this.f38703b.apply(it.next()));
            }
            return this.f38702a.addAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            e0.l(this.f38702a, this.f38703b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (m.c(this.f38702a, obj)) {
                return this.f38703b.apply(obj);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return m.a(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return !e0.b(this.f38702a, this.f38703b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return Iterators.l(this.f38702a.iterator(), this.f38703b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            return contains(obj) && this.f38702a.remove(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            Iterator<E> it = this.f38702a.iterator();
            boolean z11 = false;
            while (it.hasNext()) {
                E next = it.next();
                if (this.f38703b.apply(next) && collection.contains(next)) {
                    it.remove();
                    z11 = true;
                }
            }
            return z11;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            Iterator<E> it = this.f38702a.iterator();
            boolean z11 = false;
            while (it.hasNext()) {
                E next = it.next();
                if (this.f38703b.apply(next) && !collection.contains(next)) {
                    it.remove();
                    z11 = true;
                }
            }
            return z11;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            Iterator<E> it = this.f38702a.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                if (this.f38703b.apply(it.next())) {
                    i11++;
                }
            }
            return i11;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return Lists.k(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) Lists.k(iterator()).toArray(tArr);
        }
    }

    public static boolean a(Collection<?> collection, Collection<?> collection2) {
        Iterator<?> it = collection2.iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static StringBuilder b(int i11) {
        l.b(i11, "size");
        return new StringBuilder((int) Math.min(((long) i11) * 8, 1073741824L));
    }

    public static boolean c(Collection<?> collection, Object obj) {
        com.google.common.base.m.p(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static boolean d(Collection<?> collection, Object obj) {
        com.google.common.base.m.p(collection);
        try {
            return collection.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static String e(Collection<?> collection) {
        StringBuilder sbB = b(collection.size());
        sbB.append('[');
        boolean z11 = true;
        for (Object obj : collection) {
            if (!z11) {
                sbB.append(", ");
            }
            if (obj == collection) {
                sbB.append("(this Collection)");
            } else {
                sbB.append(obj);
            }
            z11 = false;
        }
        sbB.append(']');
        return sbB.toString();
    }
}
