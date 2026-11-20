package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class f extends com.applovin.impl.h implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient Map f18797d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient int f18798f;

    /* JADX INFO: compiled from: source.java */
    public class a extends c {
        public a() {
            super();
        }

        @Override // com.applovin.impl.f.c
        public Object a(Object obj, Object obj2) {
            return obj2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends vc.f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final transient Map f18800c;

        /* JADX INFO: compiled from: source.java */
        public class a extends vc.c {
            public a() {
            }

            @Override // com.applovin.impl.vc.c
            public Map a() {
                return b.this;
            }

            @Override // com.applovin.impl.vc.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return q3.a(b.this.f18800c.entrySet(), obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return b.this.new C0181b();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                f.this.c(((Map.Entry) obj).getKey());
                return true;
            }
        }

        /* JADX INFO: renamed from: com.applovin.impl.f$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0181b implements Iterator {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Iterator f18803a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Collection f18804b;

            public C0181b() {
                this.f18803a = b.this.f18800c.entrySet().iterator();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry next() {
                Map.Entry entry = (Map.Entry) this.f18803a.next();
                this.f18804b = (Collection) entry.getValue();
                return b.this.a(entry);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f18803a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                p3.a(this.f18804b != null);
                this.f18803a.remove();
                f.b(f.this, this.f18804b.size());
                this.f18804b.clear();
                this.f18804b = null;
            }
        }

        public b(Map map) {
            this.f18800c = map;
        }

        public Map.Entry a(Map.Entry entry) {
            Object key = entry.getKey();
            return vc.a(key, f.this.a(key, (Collection) entry.getValue()));
        }

        @Override // com.applovin.impl.vc.f
        public Set a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.f18800c == f.this.f18797d) {
                f.this.clear();
            } else {
                xb.a((Iterator) new C0181b());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return vc.b(this.f18800c, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(Object obj) {
            return this == obj || this.f18800c.equals(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection get(Object obj) {
            Collection collection = (Collection) vc.c(this.f18800c, obj);
            if (collection == null) {
                return null;
            }
            return f.this.a(obj, collection);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.f18800c.hashCode();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set keySet() {
            return f.this.e();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection remove(Object obj) {
            Collection collection = (Collection) this.f18800c.remove(obj);
            if (collection == null) {
                return null;
            }
            Collection collectionG = f.this.g();
            collectionG.addAll(collection);
            f.b(f.this, collection.size());
            collection.clear();
            return collectionG;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f18800c.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.f18800c.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public abstract class c implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Iterator f18806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18807b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Collection f18808c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Iterator f18809d = xb.c();

        public c() {
            this.f18806a = f.this.f18797d.entrySet().iterator();
        }

        public abstract Object a(Object obj, Object obj2);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f18806a.hasNext() || this.f18809d.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!this.f18809d.hasNext()) {
                Map.Entry entry = (Map.Entry) this.f18806a.next();
                this.f18807b = entry.getKey();
                Collection collection = (Collection) entry.getValue();
                this.f18808c = collection;
                this.f18809d = collection.iterator();
            }
            return a(this.f18807b, this.f18809d.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f18809d.remove();
            if (this.f18808c.isEmpty()) {
                this.f18806a.remove();
            }
            f.c(f.this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends vc.d {

        /* JADX INFO: compiled from: source.java */
        public class a implements Iterator {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Map.Entry f18812a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Iterator f18813b;

            public a(Iterator it) {
                this.f18813b = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f18813b.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                Map.Entry entry = (Map.Entry) this.f18813b.next();
                this.f18812a = entry;
                return entry.getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                p3.a(this.f18812a != null);
                Collection collection = (Collection) this.f18812a.getValue();
                this.f18813b.remove();
                f.b(f.this, collection.size());
                collection.clear();
                this.f18812a = null;
            }
        }

        public d(Map map) {
            super(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            xb.a(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection collection) {
            return a().keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return this == obj || a().keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return a().keySet().hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a(a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Collection collection = (Collection) a().remove(obj);
            if (collection != null) {
                int size = collection.size();
                collection.clear();
                f.b(f.this, size);
                if (size > 0) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends h implements NavigableMap {
        public e(NavigableMap navigableMap) {
            super(navigableMap);
        }

        public Map.Entry a(Iterator it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry entry = (Map.Entry) it.next();
            Collection collectionG = f.this.g();
            collectionG.addAll((Collection) entry.getValue());
            it.remove();
            return vc.a(entry.getKey(), f.this.c(collectionG));
        }

        @Override // com.applovin.impl.f.h, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public NavigableMap headMap(Object obj) {
            return headMap(obj, false);
        }

        @Override // com.applovin.impl.f.h, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public NavigableMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        @Override // com.applovin.impl.f.h, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public NavigableMap tailMap(Object obj) {
            return tailMap(obj, true);
        }

        @Override // java.util.NavigableMap
        public Map.Entry ceilingEntry(Object obj) {
            Map.Entry entryCeilingEntry = d().ceilingEntry(obj);
            if (entryCeilingEntry == null) {
                return null;
            }
            return a(entryCeilingEntry);
        }

        @Override // java.util.NavigableMap
        public Object ceilingKey(Object obj) {
            return d().ceilingKey(obj);
        }

        @Override // java.util.NavigableMap
        public NavigableSet descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap descendingMap() {
            return f.this.new e(d().descendingMap());
        }

        @Override // com.applovin.impl.f.h
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public NavigableSet c() {
            return f.this.new C0182f(d());
        }

        @Override // com.applovin.impl.f.h
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableMap d() {
            return (NavigableMap) super.d();
        }

        @Override // java.util.NavigableMap
        public Map.Entry firstEntry() {
            Map.Entry entryFirstEntry = d().firstEntry();
            if (entryFirstEntry == null) {
                return null;
            }
            return a(entryFirstEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry floorEntry(Object obj) {
            Map.Entry entryFloorEntry = d().floorEntry(obj);
            if (entryFloorEntry == null) {
                return null;
            }
            return a(entryFloorEntry);
        }

        @Override // java.util.NavigableMap
        public Object floorKey(Object obj) {
            return d().floorKey(obj);
        }

        @Override // java.util.NavigableMap
        public NavigableMap headMap(Object obj, boolean z11) {
            return f.this.new e(d().headMap(obj, z11));
        }

        @Override // java.util.NavigableMap
        public Map.Entry higherEntry(Object obj) {
            Map.Entry entryHigherEntry = d().higherEntry(obj);
            if (entryHigherEntry == null) {
                return null;
            }
            return a(entryHigherEntry);
        }

        @Override // java.util.NavigableMap
        public Object higherKey(Object obj) {
            return d().higherKey(obj);
        }

        @Override // com.applovin.impl.f.h, com.applovin.impl.f.b, java.util.AbstractMap, java.util.Map
        public NavigableSet keySet() {
            return (NavigableSet) super.keySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry lastEntry() {
            Map.Entry entryLastEntry = d().lastEntry();
            if (entryLastEntry == null) {
                return null;
            }
            return a(entryLastEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry lowerEntry(Object obj) {
            Map.Entry entryLowerEntry = d().lowerEntry(obj);
            if (entryLowerEntry == null) {
                return null;
            }
            return a(entryLowerEntry);
        }

        @Override // java.util.NavigableMap
        public Object lowerKey(Object obj) {
            return d().lowerKey(obj);
        }

        @Override // java.util.NavigableMap
        public NavigableSet navigableKeySet() {
            return keySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollFirstEntry() {
            return a(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollLastEntry() {
            return a(descendingMap().entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public NavigableMap subMap(Object obj, boolean z11, Object obj2, boolean z12) {
            return f.this.new e(d().subMap(obj, z11, obj2, z12));
        }

        @Override // java.util.NavigableMap
        public NavigableMap tailMap(Object obj, boolean z11) {
            return f.this.new e(d().tailMap(obj, z11));
        }
    }

    /* JADX INFO: renamed from: com.applovin.impl.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0182f extends i implements NavigableSet {
        public C0182f(NavigableMap navigableMap) {
            super(navigableMap);
        }

        @Override // com.applovin.impl.f.i, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public NavigableSet headSet(Object obj) {
            return headSet(obj, false);
        }

        @Override // com.applovin.impl.f.i, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public NavigableSet subSet(Object obj, Object obj2) {
            return subSet(obj, true, obj2, false);
        }

        @Override // com.applovin.impl.f.i, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public NavigableSet tailSet(Object obj) {
            return tailSet(obj, true);
        }

        @Override // com.applovin.impl.f.i
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public NavigableMap b() {
            return (NavigableMap) super.b();
        }

        @Override // java.util.NavigableSet
        public Object ceiling(Object obj) {
            return b().ceilingKey(obj);
        }

        @Override // java.util.NavigableSet
        public Iterator descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet descendingSet() {
            return f.this.new C0182f(b().descendingMap());
        }

        @Override // java.util.NavigableSet
        public Object floor(Object obj) {
            return b().floorKey(obj);
        }

        @Override // java.util.NavigableSet
        public NavigableSet headSet(Object obj, boolean z11) {
            return f.this.new C0182f(b().headMap(obj, z11));
        }

        @Override // java.util.NavigableSet
        public Object higher(Object obj) {
            return b().higherKey(obj);
        }

        @Override // java.util.NavigableSet
        public Object lower(Object obj) {
            return b().lowerKey(obj);
        }

        @Override // java.util.NavigableSet
        public Object pollFirst() {
            return xb.c(iterator());
        }

        @Override // java.util.NavigableSet
        public Object pollLast() {
            return xb.c(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet subSet(Object obj, boolean z11, Object obj2, boolean z12) {
            return f.this.new C0182f(b().subMap(obj, z11, obj2, z12));
        }

        @Override // java.util.NavigableSet
        public NavigableSet tailSet(Object obj, boolean z11) {
            return f.this.new C0182f(b().tailMap(obj, z11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g extends k implements RandomAccess {
        public g(Object obj, List list, j jVar) {
            super(obj, list, jVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h extends b implements SortedMap {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        SortedSet f18818f;

        public h(SortedMap sortedMap) {
            super(sortedMap);
        }

        public SortedSet c() {
            return f.this.new i(d());
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return d().comparator();
        }

        public SortedMap d() {
            return (SortedMap) this.f18800c;
        }

        @Override // java.util.SortedMap
        public Object firstKey() {
            return d().firstKey();
        }

        public SortedMap headMap(Object obj) {
            return f.this.new h(d().headMap(obj));
        }

        @Override // com.applovin.impl.f.b, java.util.AbstractMap, java.util.Map
        public SortedSet keySet() {
            SortedSet sortedSet = this.f18818f;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet sortedSetC = c();
            this.f18818f = sortedSetC;
            return sortedSetC;
        }

        @Override // java.util.SortedMap
        public Object lastKey() {
            return d().lastKey();
        }

        public SortedMap subMap(Object obj, Object obj2) {
            return f.this.new h(d().subMap(obj, obj2));
        }

        public SortedMap tailMap(Object obj) {
            return f.this.new h(d().tailMap(obj));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i extends d implements SortedSet {
        public i(SortedMap sortedMap) {
            super(sortedMap);
        }

        public SortedMap b() {
            return (SortedMap) super.a();
        }

        @Override // java.util.SortedSet
        public Comparator comparator() {
            return b().comparator();
        }

        @Override // java.util.SortedSet
        public Object first() {
            return b().firstKey();
        }

        public SortedSet headSet(Object obj) {
            return f.this.new i(b().headMap(obj));
        }

        @Override // java.util.SortedSet
        public Object last() {
            return b().lastKey();
        }

        public SortedSet subSet(Object obj, Object obj2) {
            return f.this.new i(b().subMap(obj, obj2));
        }

        public SortedSet tailSet(Object obj) {
            return f.this.new i(b().tailMap(obj));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class j extends AbstractCollection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f18821a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Collection f18822b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final j f18823c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Collection f18824d;

        /* JADX INFO: compiled from: source.java */
        public class a implements Iterator {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Iterator f18826a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final Collection f18827b;

            public a() {
                Collection collection = j.this.f18822b;
                this.f18827b = collection;
                this.f18826a = f.b(collection);
            }

            public a(Iterator it) {
                this.f18827b = j.this.f18822b;
                this.f18826a = it;
            }

            public Iterator a() {
                b();
                return this.f18826a;
            }

            public void b() {
                j.this.e();
                if (j.this.f18822b != this.f18827b) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                b();
                return this.f18826a.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                b();
                return this.f18826a.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f18826a.remove();
                f.c(f.this);
                j.this.f();
            }
        }

        public j(Object obj, Collection collection, j jVar) {
            this.f18821a = obj;
            this.f18822b = collection;
            this.f18823c = jVar;
            this.f18824d = jVar == null ? null : jVar.c();
        }

        public void a() {
            j jVar = this.f18823c;
            if (jVar != null) {
                jVar.a();
            } else {
                f.this.f18797d.put(this.f18821a, this.f18822b);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(Object obj) {
            e();
            boolean zIsEmpty = this.f18822b.isEmpty();
            boolean zAdd = this.f18822b.add(obj);
            if (zAdd) {
                f.b(f.this);
                if (zIsEmpty) {
                    a();
                }
            }
            return zAdd;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = this.f18822b.addAll(collection);
            if (zAddAll) {
                f.a(f.this, this.f18822b.size() - size);
                if (size == 0) {
                    a();
                }
            }
            return zAddAll;
        }

        public j b() {
            return this.f18823c;
        }

        public Collection c() {
            return this.f18822b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.f18822b.clear();
            f.b(f.this, size);
            f();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            e();
            return this.f18822b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection collection) {
            e();
            return this.f18822b.containsAll(collection);
        }

        public Object d() {
            return this.f18821a;
        }

        public void e() {
            Collection collection;
            j jVar = this.f18823c;
            if (jVar != null) {
                jVar.e();
                if (this.f18823c.c() != this.f18824d) {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (!this.f18822b.isEmpty() || (collection = (Collection) f.this.f18797d.get(this.f18821a)) == null) {
                    return;
                }
                this.f18822b = collection;
            }
        }

        @Override // java.util.Collection
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            e();
            return this.f18822b.equals(obj);
        }

        public void f() {
            j jVar = this.f18823c;
            if (jVar != null) {
                jVar.f();
            } else if (this.f18822b.isEmpty()) {
                f.this.f18797d.remove(this.f18821a);
            }
        }

        @Override // java.util.Collection
        public int hashCode() {
            e();
            return this.f18822b.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            e();
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            e();
            boolean zRemove = this.f18822b.remove(obj);
            if (zRemove) {
                f.c(f.this);
                f();
            }
            return zRemove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zRemoveAll = this.f18822b.removeAll(collection);
            if (zRemoveAll) {
                f.a(f.this, this.f18822b.size() - size);
                f();
            }
            return zRemoveAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection collection) {
            Preconditions.checkNotNull(collection);
            int size = size();
            boolean zRetainAll = this.f18822b.retainAll(collection);
            if (zRetainAll) {
                f.a(f.this, this.f18822b.size() - size);
                f();
            }
            return zRetainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            e();
            return this.f18822b.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            e();
            return this.f18822b.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class k extends j implements List {

        /* JADX INFO: compiled from: source.java */
        public class a extends j.a implements ListIterator {
            public a() {
                super();
            }

            public a(int i11) {
                super(k.this.g().listIterator(i11));
            }

            private ListIterator c() {
                return (ListIterator) a();
            }

            @Override // java.util.ListIterator
            public void add(Object obj) {
                boolean zIsEmpty = k.this.isEmpty();
                c().add(obj);
                f.b(f.this);
                if (zIsEmpty) {
                    k.this.a();
                }
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
            public Object previous() {
                return c().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return c().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(Object obj) {
                c().set(obj);
            }
        }

        public k(Object obj, List list, j jVar) {
            super(obj, list, jVar);
        }

        @Override // java.util.List
        public void add(int i11, Object obj) {
            e();
            boolean zIsEmpty = c().isEmpty();
            g().add(i11, obj);
            f.b(f.this);
            if (zIsEmpty) {
                a();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i11, Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = g().addAll(i11, collection);
            if (zAddAll) {
                f.a(f.this, c().size() - size);
                if (size == 0) {
                    a();
                }
            }
            return zAddAll;
        }

        public List g() {
            return (List) c();
        }

        @Override // java.util.List
        public Object get(int i11) {
            e();
            return g().get(i11);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            e();
            return g().indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            e();
            return g().lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator listIterator() {
            e();
            return new a();
        }

        @Override // java.util.List
        public ListIterator listIterator(int i11) {
            e();
            return new a(i11);
        }

        @Override // java.util.List
        public Object remove(int i11) {
            e();
            Object objRemove = g().remove(i11);
            f.c(f.this);
            f();
            return objRemove;
        }

        @Override // java.util.List
        public Object set(int i11, Object obj) {
            e();
            return g().set(i11, obj);
        }

        @Override // java.util.List
        public List subList(int i11, int i12) {
            e();
            return f.this.a(d(), g().subList(i11, i12), b() == null ? this : b());
        }
    }

    public f(Map map) {
        Preconditions.checkArgument(map.isEmpty());
        this.f18797d = map;
    }

    public static /* synthetic */ int a(f fVar, int i11) {
        int i12 = fVar.f18798f + i11;
        fVar.f18798f = i12;
        return i12;
    }

    public static /* synthetic */ int b(f fVar) {
        int i11 = fVar.f18798f;
        fVar.f18798f = i11 + 1;
        return i11;
    }

    public static /* synthetic */ int b(f fVar, int i11) {
        int i12 = fVar.f18798f - i11;
        fVar.f18798f = i12;
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Iterator b(Collection collection) {
        return collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    public static /* synthetic */ int c(f fVar) {
        int i11 = fVar.f18798f;
        fVar.f18798f = i11 - 1;
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Object obj) {
        Collection collection = (Collection) vc.d(this.f18797d, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.f18798f -= size;
        }
    }

    public abstract Collection a(Object obj, Collection collection);

    public final List a(Object obj, List list, j jVar) {
        return list instanceof RandomAccess ? new g(obj, list, jVar) : new k(obj, list, jVar);
    }

    public Collection b(Object obj) {
        return g();
    }

    public abstract Collection c(Collection collection);

    @Override // com.applovin.impl.uf
    public void clear() {
        Iterator it = this.f18797d.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        this.f18797d.clear();
        this.f18798f = 0;
    }

    @Override // com.applovin.impl.h
    public Collection d() {
        return new com.applovin.impl.h.a();
    }

    @Override // com.applovin.impl.h
    public Iterator f() {
        return new a();
    }

    public abstract Collection g();

    public final Map h() {
        Map map = this.f18797d;
        if (map instanceof NavigableMap) {
            return new e((NavigableMap) this.f18797d);
        }
        return map instanceof SortedMap ? new h((SortedMap) this.f18797d) : new b(this.f18797d);
    }

    public final Set i() {
        Map map = this.f18797d;
        if (map instanceof NavigableMap) {
            return new C0182f((NavigableMap) this.f18797d);
        }
        return map instanceof SortedMap ? new i((SortedMap) this.f18797d) : new d(this.f18797d);
    }

    @Override // com.applovin.impl.uf
    public boolean put(Object obj, Object obj2) {
        Collection collection = (Collection) this.f18797d.get(obj);
        if (collection != null) {
            if (!collection.add(obj2)) {
                return false;
            }
            this.f18798f++;
            return true;
        }
        Collection collectionB = b(obj);
        if (!collectionB.add(obj2)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.f18798f++;
        this.f18797d.put(obj, collectionB);
        return true;
    }

    @Override // com.applovin.impl.uf
    public int size() {
        return this.f18798f;
    }

    @Override // com.applovin.impl.h, com.applovin.impl.uf
    public Collection values() {
        return super.values();
    }
}
