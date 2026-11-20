package com.google.common.collect;

import com.google.android.gms.common.api.Api;
import com.google.common.base.Predicates;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class Maps {

    /* JADX INFO: compiled from: source.java */
    public enum EntryFunction implements com.google.common.base.f<Map.Entry<?, ?>, Object> {
        KEY { // from class: com.google.common.collect.Maps.EntryFunction.1
            @Override // com.google.common.collect.Maps.EntryFunction, com.google.common.base.f
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        },
        VALUE { // from class: com.google.common.collect.Maps.EntryFunction.2
            @Override // com.google.common.collect.Maps.EntryFunction, com.google.common.base.f
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        };

        /* synthetic */ EntryFunction(c cVar) {
            this();
        }

        @Override // com.google.common.base.f
        public abstract /* synthetic */ Object apply(Map.Entry<?, ?> entry);
    }

    /* JADX INFO: Add missing generic type declarations: [K, V2] */
    /* JADX INFO: compiled from: source.java */
    public class a<K, V2> extends com.google.common.collect.b<K, V2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map.Entry f38513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f38514b;

        public a(Map.Entry entry, j jVar) {
            this.f38513a = entry;
            this.f38514b = jVar;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public K getKey() {
            return (K) this.f38513a.getKey();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V2 getValue() {
            return (V2) this.f38514b.a(this.f38513a.getKey(), this.f38513a.getValue());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [K, V1, V2] */
    /* JADX INFO: compiled from: source.java */
    public class b<K, V1, V2> implements com.google.common.base.f<Map.Entry<K, V1>, Map.Entry<K, V2>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f38515a;

        public b(j jVar) {
            this.f38515a = jVar;
        }

        @Override // com.google.common.base.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V2> apply(Map.Entry<K, V1> entry) {
            return Maps.z(this.f38515a, entry);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: compiled from: source.java */
    public class c<K, V> extends d1<Map.Entry<K, V>, K> {
        public c(Iterator it) {
            super(it);
        }

        @Override // com.google.common.collect.d1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public K a(Map.Entry<K, V> entry) {
            return entry.getKey();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: compiled from: source.java */
    public class d<K, V> extends d1<Map.Entry<K, V>, V> {
        public d(Iterator it) {
            super(it);
        }

        @Override // com.google.common.collect.d1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public V a(Map.Entry<K, V> entry) {
            return entry.getValue();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: compiled from: source.java */
    public class e<K, V> extends d1<K, Map.Entry<K, V>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.google.common.base.f f38516b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Iterator it, com.google.common.base.f fVar) {
            super(it);
            this.f38516b = fVar;
        }

        @Override // com.google.common.collect.d1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> a(K k11) {
            return Maps.i(k11, this.f38516b.apply(k11));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: compiled from: source.java */
    public class f<K, V> extends com.google.common.collect.b<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map.Entry f38517a;

        public f(Map.Entry entry) {
            this.f38517a = entry;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public K getKey() {
            return (K) this.f38517a.getKey();
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V getValue() {
            return (V) this.f38517a.getValue();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [K, V1, V2] */
    /* JADX INFO: compiled from: source.java */
    public class g<K, V1, V2> implements j<K, V1, V2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.google.common.base.f f38518a;

        public g(com.google.common.base.f fVar) {
            this.f38518a = fVar;
        }

        @Override // com.google.common.collect.Maps.j
        public V2 a(K k11, V1 v11) {
            return (V2) this.f38518a.apply(v11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class h<K, V> extends u<K, V> implements NavigableMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public transient Comparator<? super K> f38519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public transient Set<Map.Entry<K, V>> f38520b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public transient NavigableSet<K> f38521c;

        /* JADX INFO: compiled from: source.java */
        public class a extends i<K, V> {
            public a() {
            }

            @Override // com.google.common.collect.Maps.i
            public Map<K, V> a() {
                return h.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return h.this.v();
            }
        }

        public static <T> Ordering<T> x(Comparator<T> comparator) {
            return Ordering.from(comparator).reverse();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k11) {
            return w().floorEntry(k11);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k11) {
            return w().floorKey(k11);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator = this.f38519a;
            if (comparator != null) {
                return comparator;
            }
            Comparator<? super K> comparator2 = w().comparator();
            if (comparator2 == null) {
                comparator2 = Ordering.natural();
            }
            Ordering orderingX = x(comparator2);
            this.f38519a = orderingX;
            return orderingX;
        }

        @Override // com.google.common.collect.u, com.google.common.collect.x
        /* JADX INFO: renamed from: delegate */
        public final Map<K, V> u() {
            return w();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return w().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return w();
        }

        @Override // com.google.common.collect.u, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f38520b;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> setU = u();
            this.f38520b = setU;
            return setU;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return w().lastEntry();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return w().lastKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k11) {
            return w().ceilingEntry(k11);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k11) {
            return w().ceilingKey(k11);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k11, boolean z11) {
            return w().tailMap(k11, z11).descendingMap();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> headMap(K k11) {
            return headMap(k11, false);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k11) {
            return w().lowerEntry(k11);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k11) {
            return w().lowerKey(k11);
        }

        @Override // com.google.common.collect.u, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return w().firstEntry();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return w().firstKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k11) {
            return w().higherEntry(k11);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k11) {
            return w().higherKey(k11);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            NavigableSet<K> navigableSet = this.f38521c;
            if (navigableSet != null) {
                return navigableSet;
            }
            m mVar = new m(this);
            this.f38521c = mVar;
            return mVar;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            return w().pollLastEntry();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            return w().pollFirstEntry();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k11, boolean z11, K k12, boolean z12) {
            return w().subMap(k12, z12, k11, z11).descendingMap();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> subMap(K k11, K k12) {
            return subMap(k11, true, k12, false);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k11, boolean z11) {
            return w().headMap(k11, z11).descendingMap();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> tailMap(K k11) {
            return tailMap(k11, true);
        }

        @Override // com.google.common.collect.x
        public String toString() {
            return standardToString();
        }

        public Set<Map.Entry<K, V>> u() {
            return new a();
        }

        public abstract Iterator<Map.Entry<K, V>> v();

        @Override // com.google.common.collect.u, java.util.Map
        public Collection<V> values() {
            return new p(this);
        }

        public abstract NavigableMap<K, V> w();
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class i<K, V> extends Sets.d<Map.Entry<K, V>> {
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
            Object objV = Maps.v(a(), key);
            if (com.google.common.base.j.a(objV, entry.getValue())) {
                return objV != null || a().containsKey(key);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (contains(obj) && (obj instanceof Map.Entry)) {
                return a().keySet().remove(((Map.Entry) obj).getKey());
            }
            return false;
        }

        @Override // com.google.common.collect.Sets.d, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) com.google.common.base.m.p(collection));
            } catch (UnsupportedOperationException unused) {
                return Sets.j(this, collection.iterator());
            }
        }

        @Override // com.google.common.collect.Sets.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) com.google.common.base.m.p(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetG = Sets.g(collection.size());
                for (Object obj : collection) {
                    if (contains(obj) && (obj instanceof Map.Entry)) {
                        hashSetG.add(((Map.Entry) obj).getKey());
                    }
                }
                return a().keySet().retainAll(hashSetG);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface j<K, V1, V2> {
        V2 a(K k11, V1 v11);
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class k<K, V> extends AbstractMap<K, V> {

        /* JADX INFO: compiled from: source.java */
        public class a extends i<K, V> {
            public a() {
            }

            @Override // com.google.common.collect.Maps.i
            public Map<K, V> a() {
                return k.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return k.this.a();
            }
        }

        public abstract Iterator<Map.Entry<K, V>> a();

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Iterators.e(a());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class l<K, V> extends Sets.d<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Weak
        public final Map<K, V> f38524a;

        public l(Map<K, V> map) {
            this.f38524a = (Map) com.google.common.base.m.p(map);
        }

        /* JADX INFO: renamed from: a */
        public Map<K, V> b() {
            return this.f38524a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            b().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return b().containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return b().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return Maps.l(b().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            b().remove(obj);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b().size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class m<K, V> extends n<K, V> implements NavigableSet<K> {
        public m(NavigableMap<K, V> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k11) {
            return a().ceilingKey(k11);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return a().descendingKeySet();
        }

        @Override // com.google.common.collect.Maps.n
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableMap<K, V> b() {
            return (NavigableMap) this.f38524a;
        }

        @Override // java.util.NavigableSet
        public K floor(K k11) {
            return a().floorKey(k11);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k11, boolean z11) {
            return a().headMap(k11, z11).navigableKeySet();
        }

        @Override // com.google.common.collect.Maps.n, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> headSet(K k11) {
            return headSet(k11, false);
        }

        @Override // java.util.NavigableSet
        public K higher(K k11) {
            return a().higherKey(k11);
        }

        @Override // java.util.NavigableSet
        public K lower(K k11) {
            return a().lowerKey(k11);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            return (K) Maps.m(a().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) Maps.m(a().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k11, boolean z11, K k12, boolean z12) {
            return a().subMap(k11, z11, k12, z12).navigableKeySet();
        }

        @Override // com.google.common.collect.Maps.n, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> subSet(K k11, K k12) {
            return subSet(k11, true, k12, false);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k11, boolean z11) {
            return a().tailMap(k11, z11).navigableKeySet();
        }

        @Override // com.google.common.collect.Maps.n, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> tailSet(K k11) {
            return tailSet(k11, true);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class n<K, V> extends l<K, V> implements SortedSet<K> {
        public n(SortedMap<K, V> sortedMap) {
            super(sortedMap);
        }

        @Override // com.google.common.collect.Maps.l
        public SortedMap<K, V> b() {
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
            return new n(b().headMap(k11));
        }

        @Override // java.util.SortedSet
        public K last() {
            return b().lastKey();
        }

        public SortedSet<K> subSet(K k11, K k12) {
            return new n(b().subMap(k11, k12));
        }

        public SortedSet<K> tailSet(K k11) {
            return new n(b().tailMap(k11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class o<K, V1, V2> extends k<K, V2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<K, V1> f38525a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final j<? super K, ? super V1, V2> f38526b;

        public o(Map<K, V1> map, j<? super K, ? super V1, V2> jVar) {
            this.f38525a = (Map) com.google.common.base.m.p(map);
            this.f38526b = (j) com.google.common.base.m.p(jVar);
        }

        @Override // com.google.common.collect.Maps.k
        public Iterator<Map.Entry<K, V2>> a() {
            return Iterators.B(this.f38525a.entrySet().iterator(), Maps.a(this.f38526b));
        }

        @Override // com.google.common.collect.Maps.k, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f38525a.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f38525a.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 get(Object obj) {
            V1 v11 = this.f38525a.get(obj);
            if (v11 != null || this.f38525a.containsKey(obj)) {
                return this.f38526b.a(obj, (Object) k0.a(v11));
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f38525a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 remove(Object obj) {
            if (this.f38525a.containsKey(obj)) {
                return this.f38526b.a(obj, (Object) k0.a(this.f38525a.remove(obj)));
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f38525a.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V2> values() {
            return new p(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class p<K, V> extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Weak
        public final Map<K, V> f38527a;

        public p(Map<K, V> map) {
            this.f38527a = (Map) com.google.common.base.m.p(map);
        }

        public final Map<K, V> a() {
            return this.f38527a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return a().containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return Maps.D(a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (com.google.common.base.j.a(obj, entry.getValue())) {
                        a().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) com.google.common.base.m.p(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetF = Sets.f();
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSetF.add(entry.getKey());
                    }
                }
                return a().keySet().removeAll(hashSetF);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) com.google.common.base.m.p(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetF = Sets.f();
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSetF.add(entry.getKey());
                    }
                }
                return a().keySet().retainAll(hashSetF);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class q<K, V> extends AbstractMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public transient Set<Map.Entry<K, V>> f38528a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public transient Set<K> f38529b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public transient Collection<V> f38530c;

        public abstract Set<Map.Entry<K, V>> a();

        /* JADX INFO: renamed from: c */
        public Set<K> h() {
            return new l(this);
        }

        public Collection<V> d() {
            return new p(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f38528a;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> setA = a();
            this.f38528a = setA;
            return setA;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            Set<K> set = this.f38529b;
            if (set != null) {
                return set;
            }
            Set<K> setH = h();
            this.f38529b = setH;
            return setH;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Collection<V> collection = this.f38530c;
            if (collection != null) {
                return collection;
            }
            Collection<V> collectionD = d();
            this.f38530c = collectionD;
            return collectionD;
        }
    }

    public static <K, V1, V2> Map<K, V2> A(Map<K, V1> map, com.google.common.base.f<? super V1, V2> fVar) {
        return y(map, b(fVar));
    }

    public static <K, V> Map.Entry<K, V> B(Map.Entry<? extends K, ? extends V> entry) {
        com.google.common.base.m.p(entry);
        return new f(entry);
    }

    public static <V> com.google.common.base.f<Map.Entry<?, V>, V> C() {
        return EntryFunction.VALUE;
    }

    public static <K, V> Iterator<V> D(Iterator<Map.Entry<K, V>> it) {
        return new d(it);
    }

    public static <V> V E(Map.Entry<?, V> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    public static <V> com.google.common.base.n<Map.Entry<?, V>> F(com.google.common.base.n<? super V> nVar) {
        return Predicates.e(nVar, C());
    }

    public static <K, V1, V2> com.google.common.base.f<Map.Entry<K, V1>, Map.Entry<K, V2>> a(j<? super K, ? super V1, V2> jVar) {
        com.google.common.base.m.p(jVar);
        return new b(jVar);
    }

    public static <K, V1, V2> j<K, V1, V2> b(com.google.common.base.f<? super V1, V2> fVar) {
        com.google.common.base.m.p(fVar);
        return new g(fVar);
    }

    public static <K, V> Iterator<Map.Entry<K, V>> c(Set<K> set, com.google.common.base.f<? super K, V> fVar) {
        return new e(set.iterator(), fVar);
    }

    public static int d(int i11) {
        if (i11 >= 3) {
            return i11 < 1073741824 ? (int) Math.ceil(((double) i11) / 0.75d) : Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        com.google.common.collect.l.b(i11, "expectedSize");
        return i11 + 1;
    }

    public static <K, V> boolean e(Collection<Map.Entry<K, V>> collection, Object obj) {
        if (obj instanceof Map.Entry) {
            return collection.contains(B((Map.Entry) obj));
        }
        return false;
    }

    public static boolean f(Map<?, ?> map, Object obj) {
        return Iterators.g(l(map.entrySet().iterator()), obj);
    }

    public static boolean g(Map<?, ?> map, Object obj) {
        return Iterators.g(D(map.entrySet().iterator()), obj);
    }

    public static boolean h(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static <K, V> Map.Entry<K, V> i(K k11, V v11) {
        return new ImmutableEntry(k11, v11);
    }

    public static <E> ImmutableMap<E, Integer> j(Collection<E> collection) {
        ImmutableMap.b bVar = new ImmutableMap.b(collection.size());
        Iterator<E> it = collection.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            bVar.g(it.next(), Integer.valueOf(i11));
            i11++;
        }
        return bVar.d();
    }

    public static <K> com.google.common.base.f<Map.Entry<K, ?>, K> k() {
        return EntryFunction.KEY;
    }

    public static <K, V> Iterator<K> l(Iterator<Map.Entry<K, V>> it) {
        return new c(it);
    }

    public static <K> K m(Map.Entry<K, ?> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    public static <K> com.google.common.base.n<Map.Entry<K, ?>> n(com.google.common.base.n<? super K> nVar) {
        return Predicates.e(nVar, k());
    }

    public static <K, V> HashMap<K, V> o() {
        return new HashMap<>();
    }

    public static <K, V> HashMap<K, V> p(int i11) {
        return new HashMap<>(d(i11));
    }

    public static <K, V> IdentityHashMap<K, V> q() {
        return new IdentityHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> r() {
        return new LinkedHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> s(int i11) {
        return new LinkedHashMap<>(d(i11));
    }

    public static <K, V> void t(Map<K, V> map, Map<? extends K, ? extends V> map2) {
        for (Map.Entry<? extends K, ? extends V> entry : map2.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
    }

    public static boolean u(Map<?, ?> map, Object obj) {
        com.google.common.base.m.p(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static <V> V v(Map<?, V> map, Object obj) {
        com.google.common.base.m.p(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static <V> V w(Map<?, V> map, Object obj) {
        com.google.common.base.m.p(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static String x(Map<?, ?> map) {
        StringBuilder sbB = com.google.common.collect.m.b(map.size());
        sbB.append('{');
        boolean z11 = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!z11) {
                sbB.append(", ");
            }
            sbB.append(entry.getKey());
            sbB.append('=');
            sbB.append(entry.getValue());
            z11 = false;
        }
        sbB.append('}');
        return sbB.toString();
    }

    public static <K, V1, V2> Map<K, V2> y(Map<K, V1> map, j<? super K, ? super V1, V2> jVar) {
        return new o(map, jVar);
    }

    public static <V2, K, V1> Map.Entry<K, V2> z(j<? super K, ? super V1, V2> jVar, Map.Entry<K, V1> entry) {
        com.google.common.base.m.p(jVar);
        com.google.common.base.m.p(entry);
        return new a(entry, jVar);
    }
}
