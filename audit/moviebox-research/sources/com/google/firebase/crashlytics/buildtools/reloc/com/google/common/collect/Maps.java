package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.android.gms.common.api.Api;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicates;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class Maps {

    /* JADX INFO: compiled from: source.java */
    public enum EntryFunction implements com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<Map.Entry<?, ?>, Object> {
        KEY { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.EntryFunction.1
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.EntryFunction, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d, java.util.function.Function
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        },
        VALUE { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.EntryFunction.2
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.EntryFunction, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d, java.util.function.Function
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        };

        /* synthetic */ EntryFunction(a aVar) {
            this();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d, java.util.function.Function
        public abstract /* synthetic */ Object apply(Object obj);
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: compiled from: source.java */
    public static class a<K, V> extends r7<Map.Entry<K, V>, K> {
        public a(Iterator it) {
            super(it);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.r7
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public K a(Map.Entry<K, V> entry) {
            return entry.getKey();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: compiled from: source.java */
    public static class b<K, V> extends r7<Map.Entry<K, V>, V> {
        public b(Iterator it) {
            super(it);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.r7
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public V a(Map.Entry<K, V> entry) {
            return entry.getValue();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: compiled from: source.java */
    public static class c<K, V> extends r7<K, Map.Entry<K, V>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d f39511b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Iterator it, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d dVar) {
            super(it);
            this.f39511b = dVar;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.r7
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> a(K k11) {
            return Maps.g(k11, this.f39511b.apply(k11));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: compiled from: source.java */
    public static class d<K, V> extends q<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map.Entry f39512a;

        public d(Map.Entry entry) {
            this.f39512a = entry;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q, java.util.Map.Entry
        public K getKey() {
            return (K) this.f39512a.getKey();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q, java.util.Map.Entry
        public V getValue() {
            return (V) this.f39512a.getValue();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: compiled from: source.java */
    public static class e<K, V> extends t7<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f39513a;

        public e(Iterator it) {
            this.f39513a = it;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            return Maps.v((Map.Entry) this.f39513a.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f39513a.hasNext();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class f<K, V> extends q2<K, V> implements NavigableMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public transient Comparator<? super K> f39514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public transient Set<Map.Entry<K, V>> f39515b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public transient NavigableSet<K> f39516c;

        /* JADX INFO: compiled from: source.java */
        public class a extends g<K, V> {
            public a() {
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.g
            public Map<K, V> a() {
                return f.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return f.this.g();
            }
        }

        public static <T> Ordering<T> v(Comparator<T> comparator) {
            return Ordering.from(comparator).reverse();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k11) {
            return u().floorEntry(k11);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k11) {
            return u().floorKey(k11);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator = this.f39514a;
            if (comparator != null) {
                return comparator;
            }
            Comparator<? super K> comparator2 = u().comparator();
            if (comparator2 == null) {
                comparator2 = Ordering.natural();
            }
            Ordering orderingV = v(comparator2);
            this.f39514a = orderingV;
            return orderingV;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t2
        public final Map<K, V> delegate() {
            return u();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return u().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return u();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f39515b;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> setF = f();
            this.f39515b = setF;
            return setF;
        }

        public Set<Map.Entry<K, V>> f() {
            return new a();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return u().lastEntry();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return u().lastKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k11) {
            return u().ceilingEntry(k11);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k11) {
            return u().ceilingKey(k11);
        }

        public abstract Iterator<Map.Entry<K, V>> g();

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k11, boolean z11) {
            return u().tailMap(k11, z11).descendingMap();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> headMap(K k11) {
            return headMap(k11, false);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k11) {
            return u().lowerEntry(k11);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k11) {
            return u().lowerKey(k11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return u().firstEntry();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return u().firstKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k11) {
            return u().higherEntry(k11);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k11) {
            return u().higherKey(k11);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            NavigableSet<K> navigableSet = this.f39516c;
            if (navigableSet != null) {
                return navigableSet;
            }
            j jVar = new j(this);
            this.f39516c = jVar;
            return jVar;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            return u().pollLastEntry();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            return u().pollFirstEntry();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k11, boolean z11, K k12, boolean z12) {
            return u().subMap(k12, z12, k11, z11).descendingMap();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> subMap(K k11, K k12) {
            return subMap(k11, true, k12, false);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k11, boolean z11) {
            return u().headMap(k11, z11).descendingMap();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> tailMap(K k11) {
            return tailMap(k11, true);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t2
        public String toString() {
            return standardToString();
        }

        public abstract NavigableMap<K, V> u();

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, java.util.Map
        public Collection<V> values() {
            return new l(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class g<K, V> extends Sets.a<Map.Entry<K, V>> {
        public abstract Map<K, V> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object objS = Maps.s(a(), key);
            if (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.g.a(objS, entry.getValue())) {
                return objS != null || a().containsKey(key);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (contains(obj)) {
                return a().keySet().remove(((Map.Entry) obj).getKey());
            }
            return false;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Sets.a, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(collection));
            } catch (UnsupportedOperationException unused) {
                return Sets.i(this, collection.iterator());
            }
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Sets.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetE = Sets.e(collection.size());
                for (Object obj : collection) {
                    if (contains(obj)) {
                        hashSetE.add(((Map.Entry) obj).getKey());
                    }
                }
                return a().keySet().retainAll(hashSetE);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class h<K, V> extends AbstractMap<K, V> {

        /* JADX INFO: compiled from: source.java */
        public class a extends g<K, V> {
            public a() {
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.g
            public Map<K, V> a() {
                return h.this;
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Map.Entry<K, V>> consumer) {
                h.this.forEachEntry(consumer);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return h.this.entryIterator();
            }

            @Override // java.util.Collection, java.lang.Iterable, java.util.Set
            public Spliterator<Map.Entry<K, V>> spliterator() {
                return h.this.entrySpliterator();
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Iterators.d(entryIterator());
        }

        public abstract Iterator<Map.Entry<K, V>> entryIterator();

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new a();
        }

        public Spliterator<Map.Entry<K, V>> entrySpliterator() {
            return Spliterators.spliterator(entryIterator(), size(), 65);
        }

        public void forEachEntry(Consumer<? super Map.Entry<K, V>> consumer) {
            entryIterator().forEachRemaining(consumer);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public abstract int size();
    }

    /* JADX INFO: compiled from: source.java */
    public static class i<K, V> extends Sets.a<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<K, V> f39519a;

        public i(Map<K, V> map) {
            this.f39519a = (Map) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            f().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return f().containsKey(obj);
        }

        /* JADX INFO: renamed from: e */
        public Map<K, V> f() {
            return this.f39519a;
        }

        @Override // java.lang.Iterable
        public void forEach(final Consumer<? super K> consumer) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(consumer);
            this.f39519a.forEach(new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    androidx.compose.ui.contentcapture.h.a(consumer, obj);
                }
            });
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return f().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return Maps.j(f().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            f().remove(obj);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return f().size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class j<K, V> extends k<K, V> implements NavigableSet<K> {
        public j(NavigableMap<K, V> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k11) {
            return e().ceilingKey(k11);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return e().descendingKeySet();
        }

        @Override // java.util.NavigableSet
        public K floor(K k11) {
            return e().floorKey(k11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.k
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableMap<K, V> f() {
            return (NavigableMap) this.f39519a;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k11, boolean z11) {
            return e().headMap(k11, z11).navigableKeySet();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.k, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> headSet(K k11) {
            return headSet(k11, false);
        }

        @Override // java.util.NavigableSet
        public K higher(K k11) {
            return e().higherKey(k11);
        }

        @Override // java.util.NavigableSet
        public K lower(K k11) {
            return e().lowerKey(k11);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            return (K) Maps.k(e().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) Maps.k(e().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k11, boolean z11, K k12, boolean z12) {
            return e().subMap(k11, z11, k12, z12).navigableKeySet();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.k, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> subSet(K k11, K k12) {
            return subSet(k11, true, k12, false);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k11, boolean z11) {
            return e().tailMap(k11, z11).navigableKeySet();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.k, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> tailSet(K k11) {
            return tailSet(k11, true);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class k<K, V> extends i<K, V> implements SortedSet<K> {
        public k(SortedMap<K, V> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return f().comparator();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.i
        public SortedMap<K, V> f() {
            return (SortedMap) super.f();
        }

        @Override // java.util.SortedSet
        public K first() {
            return f().firstKey();
        }

        public SortedSet<K> headSet(K k11) {
            return new k(f().headMap(k11));
        }

        @Override // java.util.SortedSet
        public K last() {
            return f().lastKey();
        }

        public SortedSet<K> subSet(K k11, K k12) {
            return new k(f().subMap(k11, k12));
        }

        public SortedSet<K> tailSet(K k11) {
            return new k(f().tailMap(k11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class l<K, V> extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<K, V> f39520a;

        public l(Map<K, V> map) {
            this.f39520a = (Map) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            e().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return e().containsValue(obj);
        }

        public final Map<K, V> e() {
            return this.f39520a;
        }

        @Override // java.lang.Iterable
        public void forEach(final Consumer<? super V> consumer) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(consumer);
            this.f39520a.forEach(new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.w5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    androidx.compose.ui.contentcapture.h.a(consumer, obj2);
                }
            });
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return e().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return Maps.y(e().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry<K, V> entry : e().entrySet()) {
                    if (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.g.a(obj, entry.getValue())) {
                        e().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetD = Sets.d();
                for (Map.Entry<K, V> entry : e().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSetD.add(entry.getKey());
                    }
                }
                return e().keySet().removeAll(hashSetD);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetD = Sets.d();
                for (Map.Entry<K, V> entry : e().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSetD.add(entry.getKey());
                    }
                }
                return e().keySet().retainAll(hashSetD);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return e().size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class m<K, V> extends AbstractMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public transient Set<Map.Entry<K, V>> f39521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public transient Set<K> f39522b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public transient Collection<V> f39523c;

        public abstract Set<Map.Entry<K, V>> a();

        /* JADX INFO: renamed from: c */
        public Set<K> h() {
            return new i(this);
        }

        public Collection<V> d() {
            return new l(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f39521a;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> setA = a();
            this.f39521a = setA;
            return setA;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            Set<K> set = this.f39522b;
            if (set != null) {
                return set;
            }
            Set<K> setH = h();
            this.f39522b = setH;
            return setH;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Collection<V> collection = this.f39523c;
            if (collection != null) {
                return collection;
            }
            Collection<V> collectionD = d();
            this.f39523c = collectionD;
            return collectionD;
        }
    }

    public static <V> com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n<Map.Entry<?, V>> A(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n<? super V> nVar) {
        return Predicates.b(nVar, x());
    }

    public static <K, V> Iterator<Map.Entry<K, V>> a(Set<K> set, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<? super K, V> dVar) {
        return new c(set.iterator(), dVar);
    }

    public static int b(int i11) {
        if (i11 >= 3) {
            return i11 < 1073741824 ? (int) ((i11 / 0.75f) + 1.0f) : Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        n1.b(i11, "expectedSize");
        return i11 + 1;
    }

    public static <K, V> boolean c(Collection<Map.Entry<K, V>> collection, Object obj) {
        if (obj instanceof Map.Entry) {
            return collection.contains(v((Map.Entry) obj));
        }
        return false;
    }

    public static boolean d(Map<?, ?> map, Object obj) {
        return Iterators.f(j(map.entrySet().iterator()), obj);
    }

    public static boolean e(Map<?, ?> map, Object obj) {
        return Iterators.f(y(map.entrySet().iterator()), obj);
    }

    public static boolean f(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static <K, V> Map.Entry<K, V> g(K k11, V v11) {
        return new ImmutableEntry(k11, v11);
    }

    public static <E> ImmutableMap<E, Integer> h(Collection<E> collection) {
        ImmutableMap.b bVar = new ImmutableMap.b(collection.size());
        Iterator<E> it = collection.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            bVar.d(it.next(), Integer.valueOf(i11));
            i11++;
        }
        return bVar.a();
    }

    public static <K> com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<Map.Entry<K, ?>, K> i() {
        return EntryFunction.KEY;
    }

    public static <K, V> Iterator<K> j(Iterator<Map.Entry<K, V>> it) {
        return new a(it);
    }

    public static <K> K k(Map.Entry<K, ?> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    public static <K> com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n<Map.Entry<K, ?>> l(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n<? super K> nVar) {
        return Predicates.b(nVar, i());
    }

    public static <K, V> HashMap<K, V> m() {
        return new HashMap<>();
    }

    public static <K, V> HashMap<K, V> n(int i11) {
        return new HashMap<>(b(i11));
    }

    public static <K, V> LinkedHashMap<K, V> o() {
        return new LinkedHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> p(int i11) {
        return new LinkedHashMap<>(b(i11));
    }

    public static <K, V> void q(Map<K, V> map, Map<? extends K, ? extends V> map2) {
        for (Map.Entry<? extends K, ? extends V> entry : map2.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
    }

    public static boolean r(Map<?, ?> map, Object obj) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static <V> V s(Map<?, V> map, Object obj) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static <V> V t(Map<?, V> map, Object obj) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static String u(Map<?, ?> map) {
        StringBuilder sbC = j2.c(map.size());
        sbC.append('{');
        boolean z11 = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!z11) {
                sbC.append(", ");
            }
            sbC.append(entry.getKey());
            sbC.append('=');
            sbC.append(entry.getValue());
            z11 = false;
        }
        sbC.append('}');
        return sbC.toString();
    }

    public static <K, V> Map.Entry<K, V> v(Map.Entry<? extends K, ? extends V> entry) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(entry);
        return new d(entry);
    }

    public static <K, V> t7<Map.Entry<K, V>> w(Iterator<Map.Entry<K, V>> it) {
        return new e(it);
    }

    public static <V> com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<Map.Entry<?, V>, V> x() {
        return EntryFunction.VALUE;
    }

    public static <K, V> Iterator<V> y(Iterator<Map.Entry<K, V>> it) {
        return new b(it);
    }

    public static <V> V z(Map.Entry<?, V> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }
}
