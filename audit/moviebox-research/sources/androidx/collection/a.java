package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a<K, V> extends v0<K, V> implements Map<K, V> {

    @Nullable
    a<K, V>.C0035a mEntrySet;

    @Nullable
    a<K, V>.c mKeySet;

    @Nullable
    a<K, V>.e mValues;

    /* JADX INFO: renamed from: androidx.collection.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public final class C0035a extends AbstractSet<Map.Entry<K, V>> {
        public C0035a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        @NonNull
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a.this.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class b extends j<K> {
        public b() {
            super(a.this.size());
        }

        @Override // androidx.collection.j
        public K a(int i11) {
            return a.this.keyAt(i11);
        }

        @Override // androidx.collection.j
        public void c(int i11) {
            a.this.removeAt(i11);
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
        public boolean addAll(@NonNull Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            a.this.clear();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return a.this.containsKey(obj);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(@NonNull Collection<?> collection) {
            return a.this.containsAll(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return a.equalsSetHelper(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int size = a.this.size() - 1; size >= 0; size--) {
                K kKeyAt = a.this.keyAt(size);
                iHashCode += kKeyAt == null ? 0 : kKeyAt.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return a.this.isEmpty();
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        @NonNull
        public Iterator<K> iterator() {
            return new b();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iIndexOfKey = a.this.indexOfKey(obj);
            if (iIndexOfKey < 0) {
                return false;
            }
            a.this.removeAt(iIndexOfKey);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(@NonNull Collection<?> collection) {
            return a.this.removeAll(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(@NonNull Collection<?> collection) {
            return a.this.retainAll(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return a.this.size();
        }

        @Override // java.util.Set, java.util.Collection
        @NonNull
        public Object[] toArray() {
            int size = a.this.size();
            Object[] objArr = new Object[size];
            for (int i11 = 0; i11 < size; i11++) {
                objArr[i11] = a.this.keyAt(i11);
            }
            return objArr;
        }

        @Override // java.util.Set, java.util.Collection
        @NonNull
        public <T> T[] toArray(@NonNull T[] tArr) {
            int size = size();
            if (tArr.length < size) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
            }
            for (int i11 = 0; i11 < size; i11++) {
                tArr[i11] = a.this.keyAt(i11);
            }
            if (tArr.length > size) {
                tArr[size] = null;
            }
            return tArr;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1906b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f1907c;

        public d() {
            this.f1905a = a.this.size() - 1;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f1906b++;
            this.f1907c = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.f1907c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return m1.a.c(entry.getKey(), a.this.keyAt(this.f1906b)) && m1.a.c(entry.getValue(), a.this.valueAt(this.f1906b));
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f1907c) {
                return a.this.keyAt(this.f1906b);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f1907c) {
                return a.this.valueAt(this.f1906b);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1906b < this.f1905a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.f1907c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            K kKeyAt = a.this.keyAt(this.f1906b);
            V vValueAt = a.this.valueAt(this.f1906b);
            return (kKeyAt == null ? 0 : kKeyAt.hashCode()) ^ (vValueAt != null ? vValueAt.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f1907c) {
                throw new IllegalStateException();
            }
            a.this.removeAt(this.f1906b);
            this.f1906b--;
            this.f1905a--;
            this.f1907c = false;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v11) {
            if (this.f1907c) {
                return a.this.setValueAt(this.f1906b, v11);
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
        public boolean addAll(@NonNull Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            a.this.clear();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return a.this.__restricted$indexOfValue(obj) >= 0;
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
            return a.this.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        @NonNull
        public Iterator<V> iterator() {
            return new f();
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int i__restricted$indexOfValue = a.this.__restricted$indexOfValue(obj);
            if (i__restricted$indexOfValue < 0) {
                return false;
            }
            a.this.removeAt(i__restricted$indexOfValue);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(@NonNull Collection<?> collection) {
            int size = a.this.size();
            int i11 = 0;
            boolean z11 = false;
            while (i11 < size) {
                if (collection.contains(a.this.valueAt(i11))) {
                    a.this.removeAt(i11);
                    i11--;
                    size--;
                    z11 = true;
                }
                i11++;
            }
            return z11;
        }

        @Override // java.util.Collection
        public boolean retainAll(@NonNull Collection<?> collection) {
            int size = a.this.size();
            int i11 = 0;
            boolean z11 = false;
            while (i11 < size) {
                if (!collection.contains(a.this.valueAt(i11))) {
                    a.this.removeAt(i11);
                    i11--;
                    size--;
                    z11 = true;
                }
                i11++;
            }
            return z11;
        }

        @Override // java.util.Collection
        public int size() {
            return a.this.size();
        }

        @Override // java.util.Collection
        @NonNull
        public Object[] toArray() {
            int size = a.this.size();
            Object[] objArr = new Object[size];
            for (int i11 = 0; i11 < size; i11++) {
                objArr[i11] = a.this.valueAt(i11);
            }
            return objArr;
        }

        @Override // java.util.Collection
        @NonNull
        public <T> T[] toArray(@NonNull T[] tArr) {
            int size = size();
            if (tArr.length < size) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
            }
            for (int i11 = 0; i11 < size; i11++) {
                tArr[i11] = a.this.valueAt(i11);
            }
            if (tArr.length > size) {
                tArr[size] = null;
            }
            return tArr;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class f extends j<V> {
        public f() {
            super(a.this.size());
        }

        @Override // androidx.collection.j
        public V a(int i11) {
            return a.this.valueAt(i11);
        }

        @Override // androidx.collection.j
        public void c(int i11) {
            a.this.removeAt(i11);
        }
    }

    public a() {
    }

    public a(int i11) {
        super(i11);
    }

    public a(@Nullable v0 v0Var) {
        super(v0Var);
    }

    public static <T> boolean equalsSetHelper(Set<T> set, Object obj) {
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

    public boolean containsAll(@NonNull Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.collection.v0, java.util.Map
    public boolean containsKey(@Nullable Object obj) {
        return super.containsKey(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.collection.v0, java.util.Map
    public boolean containsValue(@Nullable Object obj) {
        return super.containsValue(obj);
    }

    @Override // java.util.Map
    @NonNull
    public Set<Map.Entry<K, V>> entrySet() {
        a<K, V>.C0035a c0035a = this.mEntrySet;
        if (c0035a != null) {
            return c0035a;
        }
        a<K, V>.C0035a c0035a2 = new C0035a();
        this.mEntrySet = c0035a2;
        return c0035a2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.collection.v0, java.util.Map
    public V get(@Nullable Object obj) {
        return (V) super.get(obj);
    }

    @Override // java.util.Map
    @NonNull
    public Set<K> keySet() {
        a<K, V>.c cVar = this.mKeySet;
        if (cVar != null) {
            return cVar;
        }
        a<K, V>.c cVar2 = new c();
        this.mKeySet = cVar2;
        return cVar2;
    }

    @Override // java.util.Map
    public void putAll(@NonNull Map<? extends K, ? extends V> map) {
        ensureCapacity(size() + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.collection.v0, java.util.Map
    public V remove(@Nullable Object obj) {
        return (V) super.remove(obj);
    }

    public boolean removeAll(@NonNull Collection<?> collection) {
        int size = size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
        return size != size();
    }

    public boolean retainAll(@NonNull Collection<?> collection) {
        int size = size();
        for (int size2 = size() - 1; size2 >= 0; size2--) {
            if (!collection.contains(keyAt(size2))) {
                removeAt(size2);
            }
        }
        return size != size();
    }

    @Override // java.util.Map
    @NonNull
    public Collection<V> values() {
        a<K, V>.e eVar = this.mValues;
        if (eVar != null) {
            return eVar;
        }
        a<K, V>.e eVar2 = new e();
        this.mValues = eVar2;
        return eVar2;
    }
}
