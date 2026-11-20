package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
abstract class AbstractBiMap<K, V> extends q2<K, V> implements d0<K, V>, Serializable {
    private static final long serialVersionUID = 0;
    private transient Map<K, V> delegate;
    private transient Set<Map.Entry<K, V>> entrySet;
    transient AbstractBiMap<V, K> inverse;
    private transient Set<K> keySet;
    private transient Set<V> valueSet;

    /* JADX INFO: compiled from: source.java */
    public static class Inverse<K, V> extends AbstractBiMap<K, V> {
        private static final long serialVersionUID = 0;

        public Inverse(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
            super(map, abstractBiMap, null);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            setInverse((AbstractBiMap) objectInputStream.readObject());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(inverse());
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractBiMap
        public K checkKey(K k11) {
            return this.inverse.checkValue(k11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractBiMap
        public V checkValue(V v11) {
            return this.inverse.checkKey(v11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractBiMap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t2
        public /* bridge */ /* synthetic */ Object delegate() {
            return super.delegate();
        }

        public Object readResolve() {
            return inverse().inverse();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractBiMap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map.Entry<K, V> f39202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterator f39203b;

        public a(Iterator it) {
            this.f39203b = it;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            Map.Entry<K, V> entry = (Map.Entry) this.f39203b.next();
            this.f39202a = entry;
            return new b(entry);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f39203b.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            n1.e(this.f39202a != null);
            V value = this.f39202a.getValue();
            this.f39203b.remove();
            AbstractBiMap.this.removeFromInverseMap(value);
            this.f39202a = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends r2<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map.Entry<K, V> f39205a;

        public b(Map.Entry<K, V> entry) {
            this.f39205a = entry;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t2
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> delegate() {
            return this.f39205a;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.r2, java.util.Map.Entry
        public V setValue(V v11) {
            AbstractBiMap.this.checkValue(v11);
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.u(AbstractBiMap.this.entrySet().contains(this), "entry no longer in map");
            if (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.g.a(v11, getValue())) {
                return v11;
            }
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.j(!AbstractBiMap.this.containsValue(v11), "value already present: %s", v11);
            V value = this.f39205a.setValue(v11);
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.u(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.g.a(v11, AbstractBiMap.this.get(getKey())), "entry no longer in map");
            AbstractBiMap.this.updateInverseMap(getKey(), true, value, v11);
            return value;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends v2<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<Map.Entry<K, V>> f39207a;

        public c() {
            this.f39207a = AbstractBiMap.this.delegate.entrySet();
        }

        public /* synthetic */ c(AbstractBiMap abstractBiMap, a aVar) {
            this();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.util.Set
        public void clear() {
            AbstractBiMap.this.clear();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return Maps.c(delegate(), obj);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t2
        public Set<Map.Entry<K, V>> delegate() {
            return this.f39207a;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return AbstractBiMap.this.entrySetIterator();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!this.f39207a.contains(obj)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            ((AbstractBiMap) AbstractBiMap.this.inverse).delegate.remove(entry.getValue());
            this.f39207a.remove(entry);
            return true;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends v2<K> {
        public d() {
        }

        public /* synthetic */ d(AbstractBiMap abstractBiMap, a aVar) {
            this();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.util.Set
        public void clear() {
            AbstractBiMap.this.clear();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t2
        public Set<K> delegate() {
            return AbstractBiMap.this.delegate.keySet();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return Maps.j(AbstractBiMap.this.entrySet().iterator());
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            AbstractBiMap.this.removeFromBothMaps(obj);
            return true;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends v2<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<V> f39210a;

        public e() {
            this.f39210a = AbstractBiMap.this.inverse.keySet();
        }

        public /* synthetic */ e(AbstractBiMap abstractBiMap, a aVar) {
            this();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t2
        public Set<V> delegate() {
            return this.f39210a;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return Maps.y(AbstractBiMap.this.entrySet().iterator());
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t2
        public String toString() {
            return standardToString();
        }
    }

    private AbstractBiMap(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
        this.delegate = map;
        this.inverse = abstractBiMap;
    }

    public /* synthetic */ AbstractBiMap(Map map, AbstractBiMap abstractBiMap, a aVar) {
        this(map, abstractBiMap);
    }

    public AbstractBiMap(Map<K, V> map, Map<V, K> map2) {
        setDelegates(map, map2);
    }

    private V putInBothMaps(K k11, V v11, boolean z11) {
        checkKey(k11);
        checkValue(v11);
        boolean zContainsKey = containsKey(k11);
        if (zContainsKey && com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.g.a(v11, get(k11))) {
            return v11;
        }
        if (z11) {
            inverse().remove(v11);
        } else {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.j(!containsValue(v11), "value already present: %s", v11);
        }
        V vPut = this.delegate.put(k11, v11);
        updateInverseMap(k11, zContainsKey, vPut, v11);
        return vPut;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V removeFromBothMaps(Object obj) {
        V vRemove = this.delegate.remove(obj);
        removeFromInverseMap(vRemove);
        return vRemove;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFromInverseMap(V v11) {
        this.inverse.delegate.remove(v11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInverseMap(K k11, boolean z11, V v11, V v12) {
        if (z11) {
            removeFromInverseMap(v11);
        }
        this.inverse.delegate.put(v12, k11);
    }

    public K checkKey(K k11) {
        return k11;
    }

    public V checkValue(V v11) {
        return v11;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, java.util.Map
    public void clear() {
        this.delegate.clear();
        this.inverse.delegate.clear();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, java.util.Map
    public boolean containsValue(Object obj) {
        return this.inverse.containsKey(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t2
    public Map<K, V> delegate() {
        return this.delegate;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        c cVar = new c(this, null);
        this.entrySet = cVar;
        return cVar;
    }

    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        return new a(this.delegate.entrySet().iterator());
    }

    public V forcePut(K k11, V v11) {
        return putInBothMaps(k11, v11, true);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.d0
    public d0<V, K> inverse() {
        return this.inverse;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        d dVar = new d(this, null);
        this.keySet = dVar;
        return dVar;
    }

    public AbstractBiMap<V, K> makeInverse(Map<V, K> map) {
        return new Inverse(map, this);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, java.util.Map
    public V put(K k11, V v11) {
        return putInBothMaps(k11, v11, false);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, java.util.Map
    public V remove(Object obj) {
        if (containsKey(obj)) {
            return removeFromBothMaps(obj);
        }
        return null;
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
        this.delegate.replaceAll(biFunction);
        this.inverse.delegate.clear();
        Iterator<Map.Entry<K, V>> it = this.delegate.entrySet().iterator();
        Map.Entry<K, V> entry = null;
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (this.inverse.delegate.putIfAbsent(next.getValue(), next.getKey()) != null) {
                it.remove();
                entry = next;
            }
        }
        if (entry == null) {
            return;
        }
        throw new IllegalArgumentException("value already present: " + entry.getValue());
    }

    public void setDelegates(Map<K, V> map, Map<V, K> map2) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.t(this.delegate == null);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.t(this.inverse == null);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(map.isEmpty());
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(map2.isEmpty());
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(map != map2);
        this.delegate = map;
        this.inverse = makeInverse(map2);
    }

    public void setInverse(AbstractBiMap<V, K> abstractBiMap) {
        this.inverse = abstractBiMap;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, java.util.Map
    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set != null) {
            return set;
        }
        e eVar = new e(this, null);
        this.valueSet = eVar;
        return eVar;
    }
}
