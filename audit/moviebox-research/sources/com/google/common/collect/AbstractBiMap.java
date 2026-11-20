package com.google.common.collect;

import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
abstract class AbstractBiMap<K, V> extends u<K, V> implements k<K, V>, Serializable {
    private static final long serialVersionUID = 0;
    private transient Map<K, V> delegate;
    private transient Set<Map.Entry<K, V>> entrySet;

    @RetainedWith
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
            Object object = objectInputStream.readObject();
            Objects.requireNonNull(object);
            setInverse((AbstractBiMap) object);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(inverse());
        }

        @Override // com.google.common.collect.AbstractBiMap
        public K checkKey(K k11) {
            return this.inverse.checkValue(k11);
        }

        @Override // com.google.common.collect.AbstractBiMap
        public V checkValue(V v11) {
            return this.inverse.checkKey(v11);
        }

        @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.u, com.google.common.collect.x
        /* JADX INFO: renamed from: delegate */
        public /* bridge */ /* synthetic */ Object u() {
            return super.u();
        }

        public Object readResolve() {
            return inverse().inverse();
        }

        @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.u, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map.Entry<K, V> f38199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterator f38200b;

        public a(Iterator it) {
            this.f38200b = it;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            Map.Entry<K, V> entry = (Map.Entry) this.f38200b.next();
            this.f38199a = entry;
            return new b(entry);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f38200b.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            Map.Entry<K, V> entry = this.f38199a;
            if (entry == null) {
                throw new IllegalStateException("no calls to next() since the last call to remove()");
            }
            V value = entry.getValue();
            this.f38200b.remove();
            AbstractBiMap.this.removeFromInverseMap(value);
            this.f38199a = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends v<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map.Entry<K, V> f38202a;

        public b(Map.Entry<K, V> entry) {
            this.f38202a = entry;
        }

        @Override // com.google.common.collect.v, java.util.Map.Entry
        public V setValue(V v11) {
            AbstractBiMap.this.checkValue(v11);
            com.google.common.base.m.w(AbstractBiMap.this.entrySet().contains(this), "entry no longer in map");
            if (com.google.common.base.j.a(v11, getValue())) {
                return v11;
            }
            com.google.common.base.m.k(!AbstractBiMap.this.containsValue(v11), "value already present: %s", v11);
            V value = this.f38202a.setValue(v11);
            com.google.common.base.m.w(com.google.common.base.j.a(v11, AbstractBiMap.this.get(getKey())), "entry no longer in map");
            AbstractBiMap.this.updateInverseMap(getKey(), true, value, v11);
            return value;
        }

        @Override // com.google.common.collect.x
        public Map.Entry<K, V> u() {
            return this.f38202a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends z<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<Map.Entry<K, V>> f38204a;

        public c() {
            this.f38204a = AbstractBiMap.this.delegate.entrySet();
        }

        public /* synthetic */ c(AbstractBiMap abstractBiMap, a aVar) {
            this();
        }

        @Override // com.google.common.collect.r, java.util.Collection, java.util.Set
        public void clear() {
            AbstractBiMap.this.clear();
        }

        @Override // com.google.common.collect.r, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return Maps.e(u(), obj);
        }

        @Override // com.google.common.collect.r, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
        }

        @Override // com.google.common.collect.z, com.google.common.collect.r, com.google.common.collect.x
        /* JADX INFO: renamed from: delegate */
        public Set<Map.Entry<K, V>> u() {
            return this.f38204a;
        }

        @Override // com.google.common.collect.r, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return AbstractBiMap.this.entrySetIterator();
        }

        @Override // com.google.common.collect.r, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!this.f38204a.contains(obj) || !(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            ((AbstractBiMap) AbstractBiMap.this.inverse).delegate.remove(entry.getValue());
            this.f38204a.remove(entry);
            return true;
        }

        @Override // com.google.common.collect.r, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // com.google.common.collect.r, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }

        @Override // com.google.common.collect.r, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.r, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends z<K> {
        public d() {
        }

        public /* synthetic */ d(AbstractBiMap abstractBiMap, a aVar) {
            this();
        }

        @Override // com.google.common.collect.r, java.util.Collection, java.util.Set
        public void clear() {
            AbstractBiMap.this.clear();
        }

        @Override // com.google.common.collect.z, com.google.common.collect.r, com.google.common.collect.x
        /* JADX INFO: renamed from: delegate */
        public Set<K> u() {
            return AbstractBiMap.this.delegate.keySet();
        }

        @Override // com.google.common.collect.r, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return Maps.l(AbstractBiMap.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.r, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            AbstractBiMap.this.removeFromBothMaps(obj);
            return true;
        }

        @Override // com.google.common.collect.r, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // com.google.common.collect.r, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends z<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<V> f38207a;

        public e() {
            this.f38207a = AbstractBiMap.this.inverse.keySet();
        }

        public /* synthetic */ e(AbstractBiMap abstractBiMap, a aVar) {
            this();
        }

        @Override // com.google.common.collect.z, com.google.common.collect.r, com.google.common.collect.x
        /* JADX INFO: renamed from: delegate */
        public Set<V> u() {
            return this.f38207a;
        }

        @Override // com.google.common.collect.r, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return Maps.D(AbstractBiMap.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.r, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.r, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        @Override // com.google.common.collect.x
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
        if (zContainsKey && com.google.common.base.j.a(v11, get(k11))) {
            return v11;
        }
        if (z11) {
            inverse().remove(v11);
        } else {
            com.google.common.base.m.k(!containsValue(v11), "value already present: %s", v11);
        }
        V vPut = this.delegate.put(k11, v11);
        updateInverseMap(k11, zContainsKey, vPut, v11);
        return vPut;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V removeFromBothMaps(Object obj) {
        V v11 = (V) k0.a(this.delegate.remove(obj));
        removeFromInverseMap(v11);
        return v11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFromInverseMap(V v11) {
        this.inverse.delegate.remove(v11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void updateInverseMap(K k11, boolean z11, V v11, V v12) {
        if (z11) {
            removeFromInverseMap(k0.a(v11));
        }
        this.inverse.delegate.put(v12, k11);
    }

    public K checkKey(K k11) {
        return k11;
    }

    public V checkValue(V v11) {
        return v11;
    }

    @Override // com.google.common.collect.u, java.util.Map
    public void clear() {
        this.delegate.clear();
        this.inverse.delegate.clear();
    }

    @Override // com.google.common.collect.u, java.util.Map
    public boolean containsValue(Object obj) {
        return this.inverse.containsKey(obj);
    }

    @Override // com.google.common.collect.u, com.google.common.collect.x
    /* JADX INFO: renamed from: delegate */
    public Map<K, V> u() {
        return this.delegate;
    }

    @Override // com.google.common.collect.u, java.util.Map
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

    @Override // com.google.common.collect.k
    public k<V, K> inverse() {
        return this.inverse;
    }

    @Override // com.google.common.collect.u, java.util.Map
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

    @Override // com.google.common.collect.u, java.util.Map
    public V put(K k11, V v11) {
        return putInBothMaps(k11, v11, false);
    }

    @Override // com.google.common.collect.u, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.common.collect.u, java.util.Map
    public V remove(Object obj) {
        if (containsKey(obj)) {
            return removeFromBothMaps(obj);
        }
        return null;
    }

    public void setDelegates(Map<K, V> map, Map<V, K> map2) {
        com.google.common.base.m.v(this.delegate == null);
        com.google.common.base.m.v(this.inverse == null);
        com.google.common.base.m.d(map.isEmpty());
        com.google.common.base.m.d(map2.isEmpty());
        com.google.common.base.m.d(map != map2);
        this.delegate = map;
        this.inverse = makeInverse(map2);
    }

    public void setInverse(AbstractBiMap<V, K> abstractBiMap) {
        this.inverse = abstractBiMap;
    }

    @Override // com.google.common.collect.u, java.util.Map
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
