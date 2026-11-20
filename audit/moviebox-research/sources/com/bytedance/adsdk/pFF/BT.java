package com.bytedance.adsdk.pFF;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class BT<K, V> {
    BT<K, V>.pFF pFF;

    /* JADX INFO: compiled from: source.java */
    public final class pFF implements Set<K> {
        public pFF() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k11) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            BT.this.zY();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return BT.this.sc(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return BT.sc(BT.this.pFF(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return BT.sc(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iSc = BT.this.sc() - 1; iSc >= 0; iSc--) {
                Object objSc = BT.this.sc(iSc, 0);
                iHashCode += objSc == null ? 0 : objSc.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return BT.this.sc() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new sc(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iSc = BT.this.sc(obj);
            if (iSc < 0) {
                return false;
            }
            BT.this.sc(iSc);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return BT.pFF(BT.this.pFF(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return BT.zY(BT.this.pFF(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return BT.this.sc();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return BT.this.pFF(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) BT.this.sc(tArr, 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class sc<T> implements Iterator<T> {
        boolean We = false;
        int pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        final int f26082sc;
        int zY;

        public sc(int i11) {
            this.f26082sc = i11;
            this.pFF = BT.this.sc();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.zY < this.pFF;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t11 = (T) BT.this.sc(this.zY, this.f26082sc);
            this.zY++;
            this.We = true;
            return t11;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.We) {
                throw new IllegalStateException();
            }
            int i11 = this.zY - 1;
            this.zY = i11;
            this.pFF--;
            this.We = false;
            BT.this.sc(i11);
        }
    }

    public static <K, V> boolean pFF(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean sc(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean sc(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size() && set.containsAll(set2)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean zY(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public Set<K> We() {
        if (this.pFF == null) {
            this.pFF = new pFF();
        }
        return this.pFF;
    }

    public abstract Map<K, V> pFF();

    public Object[] pFF(int i11) {
        int iSc = sc();
        Object[] objArr = new Object[iSc];
        for (int i12 = 0; i12 < iSc; i12++) {
            objArr[i12] = sc(i12, i11);
        }
        return objArr;
    }

    public abstract int sc();

    public abstract int sc(Object obj);

    public abstract Object sc(int i11, int i12);

    public abstract void sc(int i11);

    public <T> T[] sc(T[] tArr, int i11) {
        int iSc = sc();
        if (tArr.length < iSc) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iSc));
        }
        for (int i12 = 0; i12 < iSc; i12++) {
            tArr[i12] = sc(i12, i11);
        }
        if (tArr.length > iSc) {
            tArr[iSc] = null;
        }
        return tArr;
    }

    public abstract void zY();
}
