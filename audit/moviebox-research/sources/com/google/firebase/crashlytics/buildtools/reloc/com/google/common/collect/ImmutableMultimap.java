package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ObjIntConsumer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class ImmutableMultimap<K, V> extends s<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final transient ImmutableMap<K, ? extends ImmutableCollection<V>> map;
    final transient int size;

    /* JADX INFO: compiled from: source.java */
    public static class EntryCollection<K, V> extends ImmutableCollection<Map.Entry<K, V>> {
        private static final long serialVersionUID = 0;
        final ImmutableMultimap<K, V> multimap;

        public EntryCollection(ImmutableMultimap<K, V> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.multimap.containsEntry(entry.getKey(), entry.getValue());
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return this.multimap.isPartialView();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public t7<Map.Entry<K, V>> iterator() {
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

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return ImmutableMultimap.this.containsKey(obj);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
        public int count(Object obj) {
            ImmutableCollection<V> immutableCollection = ImmutableMultimap.this.map.get(obj);
            if (immutableCollection == null) {
                return 0;
            }
            return immutableCollection.size();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
        public ImmutableSet<K> elementSet() {
            return ImmutableMultimap.this.keySet();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, java.lang.Iterable
        public /* bridge */ /* synthetic */ void forEach(Consumer consumer) {
            k6.a(this, consumer);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
        public /* bridge */ /* synthetic */ void forEachEntry(ObjIntConsumer objIntConsumer) {
            k6.b(this, objIntConsumer);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset
        public l6.a<K> getEntry(int i11) {
            Map.Entry<K, ? extends ImmutableCollection<V>> entry = ImmutableMultimap.this.map.entrySet().asList().get(i11);
            return Multisets.g(entry.getKey(), entry.getValue().size());
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
        public int size() {
            return ImmutableMultimap.this.size();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
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
        public final transient ImmutableMultimap<K, V> f39349a;

        public Values(ImmutableMultimap<K, V> immutableMultimap) {
            this.f39349a = immutableMultimap;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f39349a.containsValue(obj);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] objArr, int i11) {
            t7<? extends ImmutableCollection<V>> it = this.f39349a.map.values().iterator();
            while (it.hasNext()) {
                i11 = it.next().copyIntoArray(objArr, i11);
            }
            return i11;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public t7<V> iterator() {
            return this.f39349a.valueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f39349a.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends t7<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<? extends Map.Entry<K, ? extends ImmutableCollection<V>>> f39350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public K f39351b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Iterator<V> f39352c = Iterators.h();

        public a() {
            this.f39350a = ImmutableMultimap.this.map.entrySet().iterator();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!this.f39352c.hasNext()) {
                Map.Entry<K, ? extends ImmutableCollection<V>> next = this.f39350a.next();
                this.f39351b = next.getKey();
                this.f39352c = next.getValue().iterator();
            }
            return Maps.g(this.f39351b, this.f39352c.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f39352c.hasNext() || this.f39350a.hasNext();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends t7<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Iterator<? extends ImmutableCollection<V>> f39354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Iterator<V> f39355b = Iterators.h();

        public b() {
            this.f39354a = ImmutableMultimap.this.map.values().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f39355b.hasNext() || this.f39354a.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            if (!this.f39355b.hasNext()) {
                this.f39355b = this.f39354a.next().iterator();
            }
            return this.f39355b.next();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map<K, Collection<V>> f39357a = r6.g();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Comparator<? super K> f39358b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Comparator<? super V> f39359c;

        public ImmutableMultimap<K, V> a() {
            Collection collectionEntrySet = this.f39357a.entrySet();
            Comparator<? super K> comparator = this.f39358b;
            if (comparator != null) {
                collectionEntrySet = Ordering.from(comparator).onKeys().immutableSortedCopy(collectionEntrySet);
            }
            return ImmutableListMultimap.fromMapEntries(collectionEntrySet, this.f39359c);
        }

        public c<K, V> b(c<K, V> cVar) {
            for (Map.Entry<K, Collection<V>> entry : cVar.f39357a.entrySet()) {
                g(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public Collection<V> c() {
            return new ArrayList();
        }

        public c<K, V> d(K k11, V v11) {
            n1.a(k11, v11);
            Collection<V> collection = this.f39357a.get(k11);
            if (collection == null) {
                Map<K, Collection<V>> map = this.f39357a;
                Collection<V> collectionC = c();
                map.put(k11, collectionC);
                collection = collectionC;
            }
            collection.add(v11);
            return this;
        }

        public c<K, V> e(Map.Entry<? extends K, ? extends V> entry) {
            return d(entry.getKey(), entry.getValue());
        }

        public c<K, V> f(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            Iterator<? extends Map.Entry<? extends K, ? extends V>> it = iterable.iterator();
            while (it.hasNext()) {
                e(it.next());
            }
            return this;
        }

        public c<K, V> g(K k11, Iterable<? extends V> iterable) {
            if (k11 == null) {
                throw new NullPointerException("null key in entry: null=" + j5.m(iterable));
            }
            Collection<V> collection = this.f39357a.get(k11);
            if (collection != null) {
                for (V v11 : iterable) {
                    n1.a(k11, v11);
                    collection.add(v11);
                }
                return this;
            }
            Iterator<? extends V> it = iterable.iterator();
            if (!it.hasNext()) {
                return this;
            }
            Collection<V> collectionC = c();
            while (it.hasNext()) {
                V next = it.next();
                n1.a(k11, next);
                collectionC.add(next);
            }
            this.f39357a.put(k11, collectionC);
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final y6.b<ImmutableMultimap> f39360a = y6.a(ImmutableMultimap.class, "map");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final y6.b<ImmutableMultimap> f39361b = y6.a(ImmutableMultimap.class, "size");
    }

    public ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> immutableMap, int i11) {
        this.map = immutableMap;
        this.size = i11;
    }

    public static <K, V> c<K, V> builder() {
        return new c<>();
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(z5<? extends K, ? extends V> z5Var) {
        if (z5Var instanceof ImmutableMultimap) {
            ImmutableMultimap<K, V> immutableMultimap = (ImmutableMultimap) z5Var;
            if (!immutableMultimap.isPartialView()) {
                return immutableMultimap;
            }
        }
        return ImmutableListMultimap.copyOf((z5) z5Var);
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return ImmutableListMultimap.copyOf((Iterable) iterable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Spliterator lambda$entrySpliterator$1(Map.Entry entry) {
        final Object key = entry.getKey();
        return x1.e(((Collection) entry.getValue()).spliterator(), new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.u3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Maps.g(key, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$forEach$3(final BiConsumer biConsumer, final Object obj, Collection collection) {
        collection.forEach(new Consumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.w3
            @Override // java.util.function.Consumer
            public final void accept(Object obj2) {
                f.a(biConsumer, obj, obj2);
            }
        });
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

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public ImmutableMap<K, Collection<V>> asMap() {
        return this.map;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public boolean containsValue(Object obj) {
        return obj != null && super.containsValue(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public Map<K, Collection<V>> createAsMap() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public ImmutableCollection<Map.Entry<K, V>> createEntries() {
        return new EntryCollection(this);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public Set<K> createKeySet() {
        throw new AssertionError("unreachable");
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public ImmutableMultiset<K> createKeys() {
        return new Keys();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public ImmutableCollection<V> createValues() {
        return new Values(this);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public ImmutableCollection<Map.Entry<K, V>> entries() {
        return (ImmutableCollection) super.entries();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public t7<Map.Entry<K, V>> entryIterator() {
        return new a();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public Spliterator<Map.Entry<K, V>> entrySpliterator() {
        return x1.b(asMap().entrySet().spliterator(), new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.x3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ImmutableMultimap.lambda$entrySpliterator$1((Map.Entry) obj);
            }
        }, (this instanceof z6 ? 1 : 0) | 64, size());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void forEach(final BiConsumer<? super K, ? super V> biConsumer) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(biConsumer);
        asMap().forEach(new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v3
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ImmutableMultimap.lambda$forEach$3(biConsumer, obj, (Collection) obj2);
            }
        });
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public abstract ImmutableCollection<V> get(K k11);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public abstract ImmutableMultimap<V, K> inverse();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public boolean isPartialView() {
        return this.map.isPartialView();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public ImmutableSet<K> keySet() {
        return this.map.keySet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public ImmutableMultiset<K> keys() {
        return (ImmutableMultiset) super.keys();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    @Deprecated
    public boolean put(K k11, V v11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    @Deprecated
    public boolean putAll(z5<? extends K, ? extends V> z5Var) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    @Deprecated
    public boolean putAll(K k11, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    @Deprecated
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    @Deprecated
    public ImmutableCollection<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    @Deprecated
    public ImmutableCollection<V> replaceValues(K k11, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public int size() {
        return this.size;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public t7<V> valueIterator() {
        return new b();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }
}
