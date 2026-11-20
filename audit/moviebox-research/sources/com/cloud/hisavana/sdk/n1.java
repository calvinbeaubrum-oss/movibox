package com.cloud.hisavana.sdk;

import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class n1<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public n1<K, V>.b f29909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public n1<K, V>.c f29910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public n1<K, V>.e f29911c;

    /* JADX INFO: compiled from: source.java */
    public final class a<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f29912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f29913b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f29914c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f29915d = false;

        public a(int i11) {
            this.f29912a = i11;
            this.f29913b = n1.this.n();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f29914c < this.f29913b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t11 = (T) n1.this.b(this.f29914c, this.f29912a);
            this.f29914c++;
            this.f29915d = true;
            return t11;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f29915d) {
                throw new IllegalStateException();
            }
            int i11 = this.f29914c - 1;
            this.f29914c = i11;
            this.f29913b--;
            this.f29915d = false;
            n1.this.e(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class b implements Set<Map.Entry<K, V>> {
        public b() {
        }

        @Override // java.util.Set, java.util.Collection
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int iN = n1.this.n();
            for (Map.Entry<K, V> entry : collection) {
                n1.this.f(entry.getKey(), entry.getValue());
            }
            return iN != n1.this.n();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            n1.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iA = n1.this.a(entry.getKey());
            if (iA < 0) {
                return false;
            }
            return Objects.equals(n1.this.b(iA, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return n1.h(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iN = n1.this.n() - 1; iN >= 0; iN--) {
                Object objB = n1.this.b(iN, 0);
                Object objB2 = n1.this.b(iN, 1);
                iHashCode += (objB == null ? 0 : objB.hashCode()) ^ (objB2 == null ? 0 : objB2.hashCode());
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return n1.this.n() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return n1.this.n();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class c implements Set<K> {
        public c() {
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
            n1.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return n1.this.a(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return n1.g(n1.this.k(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return n1.h(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iN = n1.this.n() - 1; iN >= 0; iN--) {
                Object objB = n1.this.b(iN, 0);
                iHashCode += objB == null ? 0 : objB.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return n1.this.n() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iA = n1.this.a(obj);
            if (iA < 0) {
                return false;
            }
            n1.this.e(iA);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return n1.l(n1.this.k(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return n1.o(n1.this.k(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return n1.this.n();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return n1.this.m(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) n1.this.i(tArr, 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f29919a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f29921c = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f29920b = -1;

        public d() {
            this.f29919a = n1.this.n() - 1;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f29920b++;
            this.f29921c = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.f29921c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return Objects.equals(entry.getKey(), n1.this.b(this.f29920b, 0)) && Objects.equals(entry.getValue(), n1.this.b(this.f29920b, 1));
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f29921c) {
                return (K) n1.this.b(this.f29920b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f29921c) {
                return (V) n1.this.b(this.f29920b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f29920b < this.f29919a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.f29921c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object objB = n1.this.b(this.f29920b, 0);
            Object objB2 = n1.this.b(this.f29920b, 1);
            return (objB == null ? 0 : objB.hashCode()) ^ (objB2 != null ? objB2.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f29921c) {
                throw new IllegalStateException();
            }
            n1.this.e(this.f29920b);
            this.f29920b--;
            this.f29919a--;
            this.f29921c = false;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v11) {
            if (this.f29921c) {
                return (V) n1.this.c(this.f29920b, v11);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class e implements Collection<V> {
        public e() {
        }

        @Override // java.util.Collection
        public boolean add(V v11) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            n1.this.d();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return n1.this.j(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return n1.this.n() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int iJ = n1.this.j(obj);
            if (iJ < 0) {
                return false;
            }
            n1.this.e(iJ);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int iN = n1.this.n();
            int i11 = 0;
            boolean z11 = false;
            while (i11 < iN) {
                if (collection.contains(n1.this.b(i11, 1))) {
                    n1.this.e(i11);
                    i11--;
                    iN--;
                    z11 = true;
                }
                i11++;
            }
            return z11;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int iN = n1.this.n();
            int i11 = 0;
            boolean z11 = false;
            while (i11 < iN) {
                if (!collection.contains(n1.this.b(i11, 1))) {
                    n1.this.e(i11);
                    i11--;
                    iN--;
                    z11 = true;
                }
                i11++;
            }
            return z11;
        }

        @Override // java.util.Collection
        public int size() {
            return n1.this.n();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return n1.this.m(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) n1.this.i(tArr, 1);
        }
    }

    public static <K, V> boolean g(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean h(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean l(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean o(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public abstract int a(Object obj);

    public abstract Object b(int i11, int i12);

    public abstract V c(int i11, V v11);

    public abstract void d();

    public abstract void e(int i11);

    public abstract void f(K k11, V v11);

    public <T> T[] i(T[] tArr, int i11) {
        int iN = n();
        if (tArr.length < iN) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iN));
        }
        for (int i12 = 0; i12 < iN; i12++) {
            tArr[i12] = b(i12, i11);
        }
        if (tArr.length > iN) {
            tArr[iN] = null;
        }
        return tArr;
    }

    public abstract int j(Object obj);

    public abstract Map<K, V> k();

    public Object[] m(int i11) {
        int iN = n();
        Object[] objArr = new Object[iN];
        for (int i12 = 0; i12 < iN; i12++) {
            objArr[i12] = b(i12, i11);
        }
        return objArr;
    }

    public abstract int n();

    public Set<Map.Entry<K, V>> p() {
        if (this.f29909a == null) {
            this.f29909a = new b();
        }
        return this.f29909a;
    }

    public Set<K> q() {
        if (this.f29910b == null) {
            this.f29910b = new c();
        }
        return this.f29910b;
    }

    public Collection<V> r() {
        if (this.f29911c == null) {
            this.f29911c = new e();
        }
        return this.f29911c;
    }
}
