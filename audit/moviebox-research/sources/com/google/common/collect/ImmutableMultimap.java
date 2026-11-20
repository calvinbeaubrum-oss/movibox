package com.google.common.collect;

import com.google.j2objc.annotations.Weak;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ImmutableMultimap<K, V> extends j<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final transient ImmutableMap<K, ? extends ImmutableCollection<V>> map;
    final transient int size;

    /* JADX INFO: compiled from: source.java */
    public static class EntryCollection<K, V> extends ImmutableCollection<Map.Entry<K, V>> {
        private static final long serialVersionUID = 0;

        @Weak
        final ImmutableMultimap<K, V> multimap;

        public EntryCollection(ImmutableMultimap<K, V> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.multimap.containsEntry(entry.getKey(), entry.getValue());
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return this.multimap.isPartialView();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public g1<Map.Entry<K, V>> iterator() {
            return this.multimap.entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.multimap.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class Keys extends ImmutableMultiset<K> {
        public Keys() {
        }

        private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Use KeysSerializedForm");
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return ImmutableMultimap.this.containsKey(obj);
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.j0
        public int count(Object obj) {
            ImmutableCollection<V> immutableCollection = ImmutableMultimap.this.map.get(obj);
            if (immutableCollection == null) {
                return 0;
            }
            return immutableCollection.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.j0
        public ImmutableSet<K> elementSet() {
            return ImmutableMultimap.this.keySet();
        }

        @Override // com.google.common.collect.ImmutableMultiset
        public j0.a<K> getEntry(int i11) {
            Map.Entry<K, ? extends ImmutableCollection<V>> entry = ImmutableMultimap.this.map.entrySet().asList().get(i11);
            return Multisets.g(entry.getKey(), entry.getValue().size());
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j0
        public int size() {
            return ImmutableMultimap.this.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return new KeysSerializedForm(ImmutableMultimap.this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class KeysSerializedForm implements Serializable {
        final ImmutableMultimap<?, ?> multimap;

        public KeysSerializedForm(ImmutableMultimap<?, ?> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        public Object readResolve() {
            return this.multimap.keys();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class Values<K, V> extends ImmutableCollection<V> {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Weak
        public final transient ImmutableMultimap<K, V> f38364a;

        public Values(ImmutableMultimap<K, V> immutableMultimap) {
            this.f38364a = immutableMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f38364a.containsValue(obj);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] objArr, int i11) {
            g1<? extends ImmutableCollection<V>> it = this.f38364a.map.values().iterator();
            while (it.hasNext()) {
                i11 = it.next().copyIntoArray(objArr, i11);
            }
            return i11;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public g1<V> iterator() {
            return this.f38364a.valueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f38364a.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends g1<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<? extends Map.Entry<K, ? extends ImmutableCollection<V>>> f38365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public K f38366b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Iterator<V> f38367c = Iterators.i();

        public a() {
            this.f38365a = ImmutableMultimap.this.map.entrySet().iterator();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!this.f38367c.hasNext()) {
                Map.Entry<K, ? extends ImmutableCollection<V>> next = this.f38365a.next();
                this.f38366b = next.getKey();
                this.f38367c = next.getValue().iterator();
            }
            K k11 = this.f38366b;
            Objects.requireNonNull(k11);
            return Maps.i(k11, this.f38367c.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f38367c.hasNext() || this.f38365a.hasNext();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends g1<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Iterator<? extends ImmutableCollection<V>> f38369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Iterator<V> f38370b = Iterators.i();

        public b() {
            this.f38369a = ImmutableMultimap.this.map.values().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f38370b.hasNext() || this.f38369a.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            if (!this.f38370b.hasNext()) {
                this.f38370b = this.f38369a.next().iterator();
            }
            return this.f38370b.next();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<K, Collection<V>> f38372a = p0.i();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Comparator<? super K> f38373b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Comparator<? super V> f38374c;

        public ImmutableMultimap<K, V> a() {
            Collection collectionEntrySet = this.f38372a.entrySet();
            Comparator<? super K> comparator = this.f38373b;
            if (comparator != null) {
                collectionEntrySet = Ordering.from(comparator).onKeys().immutableSortedCopy(collectionEntrySet);
            }
            return ImmutableListMultimap.fromMapEntries(collectionEntrySet, this.f38374c);
        }

        public Collection<V> b() {
            return new ArrayList();
        }

        public c<K, V> c(K k11, V v11) {
            l.a(k11, v11);
            Collection<V> collection = this.f38372a.get(k11);
            if (collection == null) {
                Map<K, Collection<V>> map = this.f38372a;
                Collection<V> collectionB = b();
                map.put(k11, collectionB);
                collection = collectionB;
            }
            collection.add(v11);
            return this;
        }

        public c<K, V> d(Map.Entry<? extends K, ? extends V> entry) {
            return c(entry.getKey(), entry.getValue());
        }

        public c<K, V> e(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            Iterator<? extends Map.Entry<? extends K, ? extends V>> it = iterable.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final u0.b<ImmutableMultimap> f38375a = u0.a(ImmutableMultimap.class, "map");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final u0.b<ImmutableMultimap> f38376b = u0.a(ImmutableMultimap.class, "size");
    }

    public ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> immutableMap, int i11) {
        this.map = immutableMap;
        this.size = i11;
    }

    public static <K, V> c<K, V> builder() {
        return new c<>();
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(h0<? extends K, ? extends V> h0Var) {
        if (h0Var instanceof ImmutableMultimap) {
            ImmutableMultimap<K, V> immutableMultimap = (ImmutableMultimap) h0Var;
            if (!immutableMultimap.isPartialView()) {
                return immutableMultimap;
            }
        }
        return ImmutableListMultimap.copyOf((h0) h0Var);
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return ImmutableListMultimap.copyOf((Iterable) iterable);
    }

    public static <K, V> ImmutableMultimap<K, V> of() {
        return ImmutableListMultimap.of();
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k11, V v11) {
        return ImmutableListMultimap.of((Object) k11, (Object) v11);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k11, V v11, K k12, V v12) {
        return ImmutableListMultimap.of((Object) k11, (Object) v11, (Object) k12, (Object) v12);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13) {
        return ImmutableListMultimap.of((Object) k11, (Object) v11, (Object) k12, (Object) v12, (Object) k13, (Object) v13);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        return ImmutableListMultimap.of((Object) k11, (Object) v11, (Object) k12, (Object) v12, (Object) k13, (Object) v13, (Object) k14, (Object) v14);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15) {
        return ImmutableListMultimap.of((Object) k11, (Object) v11, (Object) k12, (Object) v12, (Object) k13, (Object) v13, (Object) k14, (Object) v14, (Object) k15, (Object) v15);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.h0
    public ImmutableMap<K, Collection<V>> asMap() {
        return this.map;
    }

    @Override // com.google.common.collect.h0
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.h0
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.h0
    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // com.google.common.collect.c
    public boolean containsValue(Object obj) {
        return obj != null && super.containsValue(obj);
    }

    @Override // com.google.common.collect.c
    public Map<K, Collection<V>> createAsMap() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.c
    public ImmutableCollection<Map.Entry<K, V>> createEntries() {
        return new EntryCollection(this);
    }

    @Override // com.google.common.collect.c
    public Set<K> createKeySet() {
        throw new AssertionError("unreachable");
    }

    @Override // com.google.common.collect.c
    public ImmutableMultiset<K> createKeys() {
        return new Keys();
    }

    @Override // com.google.common.collect.c
    public ImmutableCollection<V> createValues() {
        return new Values(this);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.h0
    public ImmutableCollection<Map.Entry<K, V>> entries() {
        return (ImmutableCollection) super.entries();
    }

    @Override // com.google.common.collect.c
    public g1<Map.Entry<K, V>> entryIterator() {
        return new a();
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.h0
    public abstract ImmutableCollection<V> get(K k11);

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public abstract ImmutableMultimap<V, K> inverse();

    @Override // com.google.common.collect.c, com.google.common.collect.h0
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public boolean isPartialView() {
        return this.map.isPartialView();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.h0
    public ImmutableSet<K> keySet() {
        return this.map.keySet();
    }

    @Override // com.google.common.collect.c
    public ImmutableMultiset<K> keys() {
        return (ImmutableMultiset) super.keys();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.h0
    @Deprecated
    public final boolean put(K k11, V v11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.c
    @Deprecated
    public final boolean putAll(h0<? extends K, ? extends V> h0Var) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.c
    @Deprecated
    public final boolean putAll(K k11, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.h0
    @Deprecated
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.h0
    @Deprecated
    public ImmutableCollection<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.c
    @Deprecated
    public ImmutableCollection<V> replaceValues(K k11, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.h0
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.c
    public g1<V> valueIterator() {
        return new b();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.h0
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }
}
