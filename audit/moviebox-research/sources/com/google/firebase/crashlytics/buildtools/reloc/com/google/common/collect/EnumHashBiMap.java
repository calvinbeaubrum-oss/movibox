package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class EnumHashBiMap<K extends Enum<K>, V> extends AbstractBiMap<K, V> {
    private static final long serialVersionUID = 0;
    private transient Class<K> keyType;

    private EnumHashBiMap(Class<K> cls) {
        super(v7.f(new EnumMap(cls)), Maps.n(cls.getEnumConstants().length));
        this.keyType = cls;
    }

    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Class<K> cls) {
        return new EnumHashBiMap<>(cls);
    }

    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Map<K, ? extends V> map) {
        EnumHashBiMap<K, V> enumHashBiMapCreate = create(EnumBiMap.inferKeyType(map));
        enumHashBiMapCreate.putAll(map);
        return enumHashBiMapCreate;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.keyType = (Class) objectInputStream.readObject();
        setDelegates(v7.f(new EnumMap(this.keyType)), new HashMap((this.keyType.getEnumConstants().length * 3) / 2));
        y6.b(this, objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.keyType);
        y6.i(this, objectOutputStream);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractBiMap
    public K checkKey(K k11) {
        return (K) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(k11);
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

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractBiMap
    public V forcePut(K k11, V v11) {
        return (V) super.forcePut(k11, (Object) v11);
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
    public V put(K k11, V v11) {
        return (V) super.put(k11, (Object) v11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractBiMap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, java.util.Map
    public /* bridge */ /* synthetic */ void putAll(Map map) {
        super.putAll(map);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractBiMap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, java.util.Map
    public /* bridge */ /* synthetic */ Object remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractBiMap, java.util.Map
    public /* bridge */ /* synthetic */ void replaceAll(BiFunction biFunction) {
        super.replaceAll(biFunction);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractBiMap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, java.util.Map
    public /* bridge */ /* synthetic */ Set values() {
        return super.values();
    }
}
