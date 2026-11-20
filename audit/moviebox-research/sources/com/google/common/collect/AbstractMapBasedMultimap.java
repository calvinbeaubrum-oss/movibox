package com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
abstract class AbstractMapBasedMultimap<K, V> extends com.google.common.collect.c<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    private transient Map<K, Collection<V>> map;
    private transient int totalSize;

    /* JADX INFO: compiled from: source.java */
    public class a extends AbstractMapBasedMultimap<K, V>.d<V> {
        public a(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.d
        public V a(K k11, V v11) {
            return v11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AbstractMapBasedMultimap<K, V>.d<Map.Entry<K, V>> {
        public b(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> a(K k11, V v11) {
            return Maps.i(k11, v11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends Maps.q<K, Collection<V>> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient Map<K, Collection<V>> f38212d;

        /* JADX INFO: compiled from: source.java */
        public class a extends Maps.i<K, Collection<V>> {
            public a() {
            }

            @Override // com.google.common.collect.Maps.i
            public Map<K, Collection<V>> a() {
                return c.this;
            }

            @Override // com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return com.google.common.collect.m.c(c.this.f38212d.entrySet(), obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return c.this.new b();
            }

            @Override // com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                AbstractMapBasedMultimap.this.removeValuesForKey(entry.getKey());
                return true;
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b implements Iterator<Map.Entry<K, Collection<V>>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Iterator<Map.Entry<K, Collection<V>>> f38215a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Collection<V> f38216b;

            public b() {
                this.f38215a = c.this.f38212d.entrySet().iterator();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, Collection<V>> next() {
                Map.Entry<K, Collection<V>> next = this.f38215a.next();
                this.f38216b = next.getValue();
                return c.this.g(next);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f38215a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                com.google.common.base.m.w(this.f38216b != null, "no calls to next() since the last call to remove()");
                this.f38215a.remove();
                AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, this.f38216b.size());
                this.f38216b.clear();
                this.f38216b = null;
            }
        }

        public c(Map<K, Collection<V>> map) {
            this.f38212d = map;
        }

        @Override // com.google.common.collect.Maps.q
        public Set<Map.Entry<K, Collection<V>>> a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.f38212d == AbstractMapBasedMultimap.this.map) {
                AbstractMapBasedMultimap.this.clear();
            } else {
                Iterators.e(new b());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return Maps.u(this.f38212d, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection<V> get(Object obj) {
            Collection<V> collection = (Collection) Maps.v(this.f38212d, obj);
            if (collection == null) {
                return null;
            }
            return AbstractMapBasedMultimap.this.wrapCollection(obj, collection);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(Object obj) {
            return this == obj || this.f38212d.equals(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Collection<V> remove(Object obj) {
            Collection<V> collectionRemove = this.f38212d.remove(obj);
            if (collectionRemove == null) {
                return null;
            }
            Collection<V> collectionCreateCollection = AbstractMapBasedMultimap.this.createCollection();
            collectionCreateCollection.addAll(collectionRemove);
            AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, collectionRemove.size());
            collectionRemove.clear();
            return collectionCreateCollection;
        }

        public Map.Entry<K, Collection<V>> g(Map.Entry<K, Collection<V>> entry) {
            K key = entry.getKey();
            return Maps.i(key, AbstractMapBasedMultimap.this.wrapCollection(key, entry.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.f38212d.hashCode();
        }

        @Override // com.google.common.collect.Maps.q, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return AbstractMapBasedMultimap.this.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f38212d.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.f38212d.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public abstract class d<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<Map.Entry<K, Collection<V>>> f38218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public K f38219b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Collection<V> f38220c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Iterator<V> f38221d = Iterators.k();

        public d() {
            this.f38218a = AbstractMapBasedMultimap.this.map.entrySet().iterator();
        }

        public abstract T a(K k11, V v11);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f38218a.hasNext() || this.f38221d.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f38221d.hasNext()) {
                Map.Entry<K, Collection<V>> next = this.f38218a.next();
                this.f38219b = next.getKey();
                Collection<V> value = next.getValue();
                this.f38220c = value;
                this.f38221d = value.iterator();
            }
            return a(k0.a(this.f38219b), this.f38221d.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f38221d.remove();
            Collection<V> collection = this.f38220c;
            Objects.requireNonNull(collection);
            if (collection.isEmpty()) {
                this.f38218a.remove();
            }
            AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends Maps.l<K, Collection<V>> {

        /* JADX INFO: compiled from: source.java */
        public class a implements Iterator<K> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Map.Entry<K, Collection<V>> f38224a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Iterator f38225b;

            public a(Iterator it) {
                this.f38225b = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f38225b.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                Map.Entry<K, Collection<V>> entry = (Map.Entry) this.f38225b.next();
                this.f38224a = entry;
                return entry.getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                com.google.common.base.m.w(this.f38224a != null, "no calls to next() since the last call to remove()");
                Collection<V> value = this.f38224a.getValue();
                this.f38225b.remove();
                AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, value.size());
                value.clear();
                this.f38224a = null;
            }
        }

        public e(Map<K, Collection<V>> map) {
            super(map);
        }

        @Override // com.google.common.collect.Maps.l, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Iterators.e(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return b().keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return this == obj || b().keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return b().keySet().hashCode();
        }

        @Override // com.google.common.collect.Maps.l, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(b().entrySet().iterator());
        }

        @Override // com.google.common.collect.Maps.l, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Collection<V> collectionRemove = b().remove(obj);
            if (collectionRemove != null) {
                int size = collectionRemove.size();
                collectionRemove.clear();
                AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, size);
                if (size > 0) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f extends AbstractMapBasedMultimap<K, V>.i implements NavigableMap<K, Collection<V>> {
        public f(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> ceilingEntry(K k11) {
            Map.Entry<K, Collection<V>> entryCeilingEntry = j().ceilingEntry(k11);
            if (entryCeilingEntry == null) {
                return null;
            }
            return g(entryCeilingEntry);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k11) {
            return j().ceilingKey(k11);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> descendingMap() {
            return new f(j().descendingMap());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry<K, Collection<V>> entryFirstEntry = j().firstEntry();
            if (entryFirstEntry == null) {
                return null;
            }
            return g(entryFirstEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> floorEntry(K k11) {
            Map.Entry<K, Collection<V>> entryFloorEntry = j().floorEntry(k11);
            if (entryFloorEntry == null) {
                return null;
            }
            return g(entryFloorEntry);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k11) {
            return j().floorKey(k11);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> headMap(K k11, boolean z11) {
            return new f(j().headMap(k11, z11));
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> higherEntry(K k11) {
            Map.Entry<K, Collection<V>> entryHigherEntry = j().higherEntry(k11);
            if (entryHigherEntry == null) {
                return null;
            }
            return g(entryHigherEntry);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k11) {
            return j().higherKey(k11);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableSet<K> h() {
            return new g(j());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> headMap(K k11) {
            return headMap(k11, false);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry<K, Collection<V>> entryLastEntry = j().lastEntry();
            if (entryLastEntry == null) {
                return null;
            }
            return g(entryLastEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lowerEntry(K k11) {
            Map.Entry<K, Collection<V>> entryLowerEntry = j().lowerEntry(k11);
            if (entryLowerEntry == null) {
                return null;
            }
            return g(entryLowerEntry);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k11) {
            return j().lowerKey(k11);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, com.google.common.collect.AbstractMapBasedMultimap.c, com.google.common.collect.Maps.q, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableSet<K> keySet() {
            return (NavigableSet) super.keySet();
        }

        public Map.Entry<K, Collection<V>> n(Iterator<Map.Entry<K, Collection<V>>> it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry<K, Collection<V>> next = it.next();
            Collection<V> collectionCreateCollection = AbstractMapBasedMultimap.this.createCollection();
            collectionCreateCollection.addAll(next.getValue());
            it.remove();
            return Maps.i(next.getKey(), AbstractMapBasedMultimap.this.unmodifiableCollectionSubclass(collectionCreateCollection));
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return i();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> j() {
            return (NavigableMap) super.j();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return n(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return n(descendingMap().entrySet().iterator());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> subMap(K k11, K k12) {
            return subMap(k11, true, k12, false);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> tailMap(K k11) {
            return tailMap(k11, true);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> subMap(K k11, boolean z11, K k12, boolean z12) {
            return new f(j().subMap(k11, z11, k12, z12));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> tailMap(K k11, boolean z11) {
            return new f(j().tailMap(k11, z11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g extends AbstractMapBasedMultimap<K, V>.j implements NavigableSet<K> {
        public g(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k11) {
            return b().ceilingKey(k11);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return new g(b().descendingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.j, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public NavigableSet<K> headSet(K k11) {
            return headSet(k11, false);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.j
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> b() {
            return (NavigableMap) super.b();
        }

        @Override // java.util.NavigableSet
        public K floor(K k11) {
            return b().floorKey(k11);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.j, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public NavigableSet<K> subSet(K k11, K k12) {
            return subSet(k11, true, k12, false);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k11, boolean z11) {
            return new g(b().headMap(k11, z11));
        }

        @Override // java.util.NavigableSet
        public K higher(K k11) {
            return b().higherKey(k11);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.j, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public NavigableSet<K> tailSet(K k11) {
            return tailSet(k11, true);
        }

        @Override // java.util.NavigableSet
        public K lower(K k11) {
            return b().lowerKey(k11);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            return (K) Iterators.u(iterator());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) Iterators.u(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k11, boolean z11, K k12, boolean z12) {
            return new g(b().subMap(k11, z11, k12, z12));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k11, boolean z11) {
            return new g(b().tailMap(k11, z11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h extends AbstractMapBasedMultimap<K, V>.l implements RandomAccess {
        public h(AbstractMapBasedMultimap abstractMapBasedMultimap, K k11, List<V> list, AbstractMapBasedMultimap<K, V>.k kVar) {
            super(k11, list, kVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i extends AbstractMapBasedMultimap<K, V>.c implements SortedMap<K, Collection<V>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public SortedSet<K> f38229g;

        public i(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return j().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return j().firstKey();
        }

        @Override // com.google.common.collect.Maps.q
        public SortedSet<K> h() {
            return new j(j());
        }

        public SortedMap<K, Collection<V>> headMap(K k11) {
            return new i(j().headMap(k11));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.c, com.google.common.collect.Maps.q, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: i */
        public SortedSet<K> keySet() {
            SortedSet<K> sortedSet = this.f38229g;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet<K> sortedSetH = h();
            this.f38229g = sortedSetH;
            return sortedSetH;
        }

        public SortedMap<K, Collection<V>> j() {
            return (SortedMap) this.f38212d;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return j().lastKey();
        }

        public SortedMap<K, Collection<V>> subMap(K k11, K k12) {
            return new i(j().subMap(k11, k12));
        }

        public SortedMap<K, Collection<V>> tailMap(K k11) {
            return new i(j().tailMap(k11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class j extends AbstractMapBasedMultimap<K, V>.e implements SortedSet<K> {
        public j(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        public SortedMap<K, Collection<V>> b() {
            return (SortedMap) super.b();
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return b().comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return b().firstKey();
        }

        public SortedSet<K> headSet(K k11) {
            return new j(b().headMap(k11));
        }

        @Override // java.util.SortedSet
        public K last() {
            return b().lastKey();
        }

        public SortedSet<K> subSet(K k11, K k12) {
            return new j(b().subMap(k11, k12));
        }

        public SortedSet<K> tailSet(K k11) {
            return new j(b().tailMap(k11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class k extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f38232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Collection<V> f38233b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AbstractMapBasedMultimap<K, V>.k f38234c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Collection<V> f38235d;

        /* JADX INFO: compiled from: source.java */
        public class a implements Iterator<V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Iterator<V> f38237a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Collection<V> f38238b;

            public a() {
                Collection<V> collection = k.this.f38233b;
                this.f38238b = collection;
                this.f38237a = AbstractMapBasedMultimap.iteratorOrListIterator(collection);
            }

            public a(Iterator<V> it) {
                this.f38238b = k.this.f38233b;
                this.f38237a = it;
            }

            public Iterator<V> a() {
                b();
                return this.f38237a;
            }

            public void b() {
                k.this.g();
                if (k.this.f38233b != this.f38238b) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                b();
                return this.f38237a.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                b();
                return this.f38237a.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f38237a.remove();
                AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
                k.this.i();
            }
        }

        public k(K k11, Collection<V> collection, AbstractMapBasedMultimap<K, V>.k kVar) {
            this.f38232a = k11;
            this.f38233b = collection;
            this.f38234c = kVar;
            this.f38235d = kVar == null ? null : kVar.e();
        }

        public void a() {
            AbstractMapBasedMultimap<K, V>.k kVar = this.f38234c;
            if (kVar != null) {
                kVar.a();
            } else {
                AbstractMapBasedMultimap.this.map.put(this.f38232a, this.f38233b);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(V v11) {
            g();
            boolean zIsEmpty = this.f38233b.isEmpty();
            boolean zAdd = this.f38233b.add(v11);
            if (zAdd) {
                AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
                if (zIsEmpty) {
                    a();
                }
            }
            return zAdd;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = this.f38233b.addAll(collection);
            if (zAddAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.f38233b.size() - size);
                if (size == 0) {
                    a();
                }
            }
            return zAddAll;
        }

        public AbstractMapBasedMultimap<K, V>.k b() {
            return this.f38234c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.f38233b.clear();
            AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, size);
            i();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            g();
            return this.f38233b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            g();
            return this.f38233b.containsAll(collection);
        }

        public Collection<V> e() {
            return this.f38233b;
        }

        @Override // java.util.Collection
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            g();
            return this.f38233b.equals(obj);
        }

        public K f() {
            return this.f38232a;
        }

        public void g() {
            Collection<V> collection;
            AbstractMapBasedMultimap<K, V>.k kVar = this.f38234c;
            if (kVar != null) {
                kVar.g();
                if (this.f38234c.e() != this.f38235d) {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (!this.f38233b.isEmpty() || (collection = (Collection) AbstractMapBasedMultimap.this.map.get(this.f38232a)) == null) {
                    return;
                }
                this.f38233b = collection;
            }
        }

        @Override // java.util.Collection
        public int hashCode() {
            g();
            return this.f38233b.hashCode();
        }

        public void i() {
            AbstractMapBasedMultimap<K, V>.k kVar = this.f38234c;
            if (kVar != null) {
                kVar.i();
            } else if (this.f38233b.isEmpty()) {
                AbstractMapBasedMultimap.this.map.remove(this.f38232a);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            g();
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            g();
            boolean zRemove = this.f38233b.remove(obj);
            if (zRemove) {
                AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
                i();
            }
            return zRemove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zRemoveAll = this.f38233b.removeAll(collection);
            if (zRemoveAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.f38233b.size() - size);
                i();
            }
            return zRemoveAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            com.google.common.base.m.p(collection);
            int size = size();
            boolean zRetainAll = this.f38233b.retainAll(collection);
            if (zRetainAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.f38233b.size() - size);
                i();
            }
            return zRetainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            g();
            return this.f38233b.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            g();
            return this.f38233b.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class l extends AbstractMapBasedMultimap<K, V>.k implements List<V> {

        /* JADX INFO: compiled from: source.java */
        public class a extends AbstractMapBasedMultimap<K, V>.k.a implements ListIterator<V> {
            public a() {
                super();
            }

            public a(int i11) {
                super(l.this.j().listIterator(i11));
            }

            @Override // java.util.ListIterator
            public void add(V v11) {
                boolean zIsEmpty = l.this.isEmpty();
                c().add(v11);
                AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
                if (zIsEmpty) {
                    l.this.a();
                }
            }

            public final ListIterator<V> c() {
                return (ListIterator) a();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return c().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return c().nextIndex();
            }

            @Override // java.util.ListIterator
            public V previous() {
                return c().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return c().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(V v11) {
                c().set(v11);
            }
        }

        public l(K k11, List<V> list, AbstractMapBasedMultimap<K, V>.k kVar) {
            super(k11, list, kVar);
        }

        @Override // java.util.List
        public void add(int i11, V v11) {
            g();
            boolean zIsEmpty = e().isEmpty();
            j().add(i11, v11);
            AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
            if (zIsEmpty) {
                a();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i11, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = j().addAll(i11, collection);
            if (zAddAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, e().size() - size);
                if (size == 0) {
                    a();
                }
            }
            return zAddAll;
        }

        @Override // java.util.List
        public V get(int i11) {
            g();
            return j().get(i11);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            g();
            return j().indexOf(obj);
        }

        public List<V> j() {
            return (List) e();
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            g();
            return j().lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            g();
            return new a();
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i11) {
            g();
            return new a(i11);
        }

        @Override // java.util.List
        public V remove(int i11) {
            g();
            V vRemove = j().remove(i11);
            AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
            i();
            return vRemove;
        }

        @Override // java.util.List
        public V set(int i11, V v11) {
            g();
            return j().set(i11, v11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public List<V> subList(int i11, int i12) {
            g();
            return AbstractMapBasedMultimap.this.wrapList(f(), j().subList(i11, i12), b() == null ? this : b());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class m extends AbstractMapBasedMultimap<K, V>.o implements NavigableSet<V> {
        public m(K k11, NavigableSet<V> navigableSet, AbstractMapBasedMultimap<K, V>.k kVar) {
            super(k11, navigableSet, kVar);
        }

        @Override // java.util.NavigableSet
        public V ceiling(V v11) {
            return j().ceiling(v11);
        }

        @Override // java.util.NavigableSet
        public Iterator<V> descendingIterator() {
            return new k.a(j().descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> descendingSet() {
            return r(j().descendingSet());
        }

        @Override // java.util.NavigableSet
        public V floor(V v11) {
            return j().floor(v11);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> headSet(V v11, boolean z11) {
            return r(j().headSet(v11, z11));
        }

        @Override // java.util.NavigableSet
        public V higher(V v11) {
            return j().higher(v11);
        }

        @Override // java.util.NavigableSet
        public V lower(V v11) {
            return j().lower(v11);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.o
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public NavigableSet<V> j() {
            return (NavigableSet) super.j();
        }

        @Override // java.util.NavigableSet
        public V pollFirst() {
            return (V) Iterators.u(iterator());
        }

        @Override // java.util.NavigableSet
        public V pollLast() {
            return (V) Iterators.u(descendingIterator());
        }

        public final NavigableSet<V> r(NavigableSet<V> navigableSet) {
            return new m(this.f38232a, navigableSet, b() == null ? this : b());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> subSet(V v11, boolean z11, V v12, boolean z12) {
            return r(j().subSet(v11, z11, v12, z12));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> tailSet(V v11, boolean z11) {
            return r(j().tailSet(v11, z11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class n extends AbstractMapBasedMultimap<K, V>.k implements Set<V> {
        public n(K k11, Set<V> set) {
            super(k11, set, null);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.k, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zI = Sets.i((Set) this.f38233b, collection);
            if (zI) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.f38233b.size() - size);
                i();
            }
            return zI;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class o extends AbstractMapBasedMultimap<K, V>.k implements SortedSet<V> {
        public o(K k11, SortedSet<V> sortedSet, AbstractMapBasedMultimap<K, V>.k kVar) {
            super(k11, sortedSet, kVar);
        }

        @Override // java.util.SortedSet
        public Comparator<? super V> comparator() {
            return j().comparator();
        }

        @Override // java.util.SortedSet
        public V first() {
            g();
            return j().first();
        }

        @Override // java.util.SortedSet
        public SortedSet<V> headSet(V v11) {
            g();
            return new o(f(), j().headSet(v11), b() == null ? this : b());
        }

        public SortedSet<V> j() {
            return (SortedSet) e();
        }

        @Override // java.util.SortedSet
        public V last() {
            g();
            return j().last();
        }

        @Override // java.util.SortedSet
        public SortedSet<V> subSet(V v11, V v12) {
            g();
            return new o(f(), j().subSet(v11, v12), b() == null ? this : b());
        }

        @Override // java.util.SortedSet
        public SortedSet<V> tailSet(V v11) {
            g();
            return new o(f(), j().tailSet(v11), b() == null ? this : b());
        }
    }

    public AbstractMapBasedMultimap(Map<K, Collection<V>> map) {
        com.google.common.base.m.d(map.isEmpty());
        this.map = map;
    }

    public static /* synthetic */ int access$208(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i11 = abstractMapBasedMultimap.totalSize;
        abstractMapBasedMultimap.totalSize = i11 + 1;
        return i11;
    }

    public static /* synthetic */ int access$210(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i11 = abstractMapBasedMultimap.totalSize;
        abstractMapBasedMultimap.totalSize = i11 - 1;
        return i11;
    }

    public static /* synthetic */ int access$212(AbstractMapBasedMultimap abstractMapBasedMultimap, int i11) {
        int i12 = abstractMapBasedMultimap.totalSize + i11;
        abstractMapBasedMultimap.totalSize = i12;
        return i12;
    }

    public static /* synthetic */ int access$220(AbstractMapBasedMultimap abstractMapBasedMultimap, int i11) {
        int i12 = abstractMapBasedMultimap.totalSize - i11;
        abstractMapBasedMultimap.totalSize = i12;
        return i12;
    }

    private Collection<V> getOrCreateCollection(K k11) {
        Collection<V> collection = this.map.get(k11);
        if (collection != null) {
            return collection;
        }
        Collection<V> collectionCreateCollection = createCollection(k11);
        this.map.put(k11, collectionCreateCollection);
        return collectionCreateCollection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Iterator<E> iteratorOrListIterator(Collection<E> collection) {
        return collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeValuesForKey(Object obj) {
        Collection collection = (Collection) Maps.w(this.map, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.totalSize -= size;
        }
    }

    public Map<K, Collection<V>> backingMap() {
        return this.map;
    }

    @Override // com.google.common.collect.h0
    public void clear() {
        Iterator<Collection<V>> it = this.map.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.map.clear();
        this.totalSize = 0;
    }

    @Override // com.google.common.collect.h0
    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // com.google.common.collect.c
    public Map<K, Collection<V>> createAsMap() {
        return new c(this.map);
    }

    public abstract Collection<V> createCollection();

    public Collection<V> createCollection(K k11) {
        return createCollection();
    }

    @Override // com.google.common.collect.c
    public Collection<Map.Entry<K, V>> createEntries() {
        return this instanceof v0 ? new com.google.common.collect.c.b(this) : new com.google.common.collect.c.a();
    }

    @Override // com.google.common.collect.c
    public Set<K> createKeySet() {
        return new e(this.map);
    }

    @Override // com.google.common.collect.c
    public j0<K> createKeys() {
        return new Multimaps.c(this);
    }

    public final Map<K, Collection<V>> createMaybeNavigableAsMap() {
        Map<K, Collection<V>> map = this.map;
        if (map instanceof NavigableMap) {
            return new f((NavigableMap) this.map);
        }
        return map instanceof SortedMap ? new i((SortedMap) this.map) : new c(this.map);
    }

    public final Set<K> createMaybeNavigableKeySet() {
        Map<K, Collection<V>> map = this.map;
        if (map instanceof NavigableMap) {
            return new g((NavigableMap) this.map);
        }
        return map instanceof SortedMap ? new j((SortedMap) this.map) : new e(this.map);
    }

    public Collection<V> createUnmodifiableEmptyCollection() {
        return (Collection<V>) unmodifiableCollectionSubclass(createCollection());
    }

    @Override // com.google.common.collect.c
    public Collection<V> createValues() {
        return new com.google.common.collect.c.C0399c();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.h0
    public Collection<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.c
    public Iterator<Map.Entry<K, V>> entryIterator() {
        return new b(this);
    }

    @Override // com.google.common.collect.h0
    public Collection<V> get(K k11) {
        Collection<V> collectionCreateCollection = this.map.get(k11);
        if (collectionCreateCollection == null) {
            collectionCreateCollection = createCollection(k11);
        }
        return wrapCollection(k11, collectionCreateCollection);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.h0
    public boolean put(K k11, V v11) {
        Collection<V> collection = this.map.get(k11);
        if (collection != null) {
            if (!collection.add(v11)) {
                return false;
            }
            this.totalSize++;
            return true;
        }
        Collection<V> collectionCreateCollection = createCollection(k11);
        if (!collectionCreateCollection.add(v11)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.totalSize++;
        this.map.put(k11, collectionCreateCollection);
        return true;
    }

    @Override // com.google.common.collect.h0
    public Collection<V> removeAll(Object obj) {
        Collection<V> collectionRemove = this.map.remove(obj);
        if (collectionRemove == null) {
            return createUnmodifiableEmptyCollection();
        }
        Collection collectionCreateCollection = createCollection();
        collectionCreateCollection.addAll(collectionRemove);
        this.totalSize -= collectionRemove.size();
        collectionRemove.clear();
        return (Collection<V>) unmodifiableCollectionSubclass(collectionCreateCollection);
    }

    @Override // com.google.common.collect.c
    public Collection<V> replaceValues(K k11, Iterable<? extends V> iterable) {
        Iterator<? extends V> it = iterable.iterator();
        if (!it.hasNext()) {
            return removeAll(k11);
        }
        Collection<V> orCreateCollection = getOrCreateCollection(k11);
        Collection<V> collectionCreateCollection = createCollection();
        collectionCreateCollection.addAll(orCreateCollection);
        this.totalSize -= orCreateCollection.size();
        orCreateCollection.clear();
        while (it.hasNext()) {
            if (orCreateCollection.add(it.next())) {
                this.totalSize++;
            }
        }
        return (Collection<V>) unmodifiableCollectionSubclass(collectionCreateCollection);
    }

    public final void setMap(Map<K, Collection<V>> map) {
        this.map = map;
        this.totalSize = 0;
        for (Collection<V> collection : map.values()) {
            com.google.common.base.m.d(!collection.isEmpty());
            this.totalSize += collection.size();
        }
    }

    @Override // com.google.common.collect.h0
    public int size() {
        return this.totalSize;
    }

    public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        return Collections.unmodifiableCollection(collection);
    }

    @Override // com.google.common.collect.c
    public Iterator<V> valueIterator() {
        return new a(this);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.h0
    public Collection<V> values() {
        return super.values();
    }

    public Collection<V> wrapCollection(K k11, Collection<V> collection) {
        return new k(k11, collection, null);
    }

    public final List<V> wrapList(K k11, List<V> list, AbstractMapBasedMultimap<K, V>.k kVar) {
        return list instanceof RandomAccess ? new h(this, k11, list, kVar) : new l(k11, list, kVar);
    }
}
