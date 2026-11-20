package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class EnumBiMap<K extends Enum<K>, V extends Enum<V>> extends AbstractBiMap<K, V> {
    private static final long serialVersionUID = 0;
    private transient Class<K> keyType;
    private transient Class<V> valueType;

    private EnumBiMap(Class<K> cls, Class<V> cls2) {
        super(v7.f(new EnumMap(cls)), v7.f(new EnumMap(cls2)));
        this.keyType = cls;
        this.valueType = cls2;
    }

    public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Class<K> cls, Class<V> cls2) {
        return new EnumBiMap<>(cls, cls2);
    }

    public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Map<K, V> map) {
        EnumBiMap<K, V> enumBiMapCreate = create(inferKeyType(map), inferValueType(map));
        enumBiMapCreate.putAll(map);
        return enumBiMapCreate;
    }

    public static <K extends Enum<K>> Class<K> inferKeyType(Map<K, ?> map) {
        if (map instanceof EnumBiMap) {
            return ((EnumBiMap) map).keyType();
        }
        if (map instanceof EnumHashBiMap) {
            return ((EnumHashBiMap) map).keyType();
        }
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(!map.isEmpty());
        return map.keySet().iterator().next().getDeclaringClass();
    }

    private static <V extends Enum<V>> Class<V> inferValueType(Map<?, V> map) {
        if (map instanceof EnumBiMap) {
            return ((EnumBiMap) map).valueType;
        }
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(!map.isEmpty());
        return map.values().iterator().next().getDeclaringClass();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.keyType = (Class) objectInputStream.readObject();
        this.valueType = (Class) objectInputStream.readObject();
        setDelegates(v7.f(new EnumMap(this.keyType)), v7.f(new EnumMap(this.valueType)));
        y6.b(this, objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.keyType);
        objectOutputStream.writeObject(this.valueType);
        y6.i(this, objectOutputStream);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractBiMap
    public K checkKey(K k11) {
        return (K) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(k11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractBiMap
    public V checkValue(V v11) {
        return (V) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(v11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractBiMap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, java.util.Map
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractBiMap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, java.util.Map
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractBiMap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractBiMap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.d0
    public /* bridge */ /* synthetic */ d0 inverse() {
        return super.inverse();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractBiMap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    public Class<K> keyType() {
        return this.keyType;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractBiMap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, java.util.Map
    public /* bridge */ /* synthetic */ void putAll(Map map) {
        super.putAll(map);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractBiMap, java.util.Map
    public /* bridge */ /* synthetic */ void replaceAll(BiFunction biFunction) {
        super.replaceAll(biFunction);
    }

    public Class<V> valueType() {
        return this.valueType;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractBiMap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, java.util.Map
    public /* bridge */ /* synthetic */ Set values() {
        return super.values();
    }
}
