package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class u<K, V> extends x implements Map<K, V> {
    public void clear() {
        u().clear();
    }

    public boolean containsKey(Object obj) {
        return u().containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return u().containsValue(obj);
    }

    @Override // com.google.common.collect.x
    /* JADX INFO: renamed from: delegate */
    public abstract Map<K, V> u();

    public Set<Map.Entry<K, V>> entrySet() {
        return u().entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || u().equals(obj);
    }

    public V get(Object obj) {
        return u().get(obj);
    }

    public int hashCode() {
        return u().hashCode();
    }

    public boolean isEmpty() {
        return u().isEmpty();
    }

    public Set<K> keySet() {
        return u().keySet();
    }

    public V put(K k11, V v11) {
        return u().put(k11, v11);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        u().putAll(map);
    }

    public V remove(Object obj) {
        return u().remove(obj);
    }

    public int size() {
        return u().size();
    }

    public void standardClear() {
        Iterators.e(entrySet().iterator());
    }

    public boolean standardContainsKey(Object obj) {
        return Maps.f(this, obj);
    }

    public boolean standardContainsValue(Object obj) {
        return Maps.g(this, obj);
    }

    public boolean standardEquals(Object obj) {
        return Maps.h(this, obj);
    }

    public int standardHashCode() {
        return Sets.d(entrySet());
    }

    public boolean standardIsEmpty() {
        return !entrySet().iterator().hasNext();
    }

    public void standardPutAll(Map<? extends K, ? extends V> map) {
        Maps.t(this, map);
    }

    public V standardRemove(Object obj) {
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (com.google.common.base.j.a(next.getKey(), obj)) {
                V value = next.getValue();
                it.remove();
                return value;
            }
        }
        return null;
    }

    public String standardToString() {
        return Maps.x(this);
    }

    public Collection<V> values() {
        return u().values();
    }
}
