package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class ArrayListMultimap<K, V> extends ArrayListMultimapGwtSerializationDependencies<K, V> {
    private static final int DEFAULT_VALUES_PER_KEY = 3;
    private static final long serialVersionUID = 0;
    transient int expectedValuesPerKey;

    private ArrayListMultimap() {
        this(12, 3);
    }

    private ArrayListMultimap(int i11, int i12) {
        super(r6.b(i11));
        n1.b(i12, "expectedValuesPerKey");
        this.expectedValuesPerKey = i12;
    }

    private ArrayListMultimap(z5<? extends K, ? extends V> z5Var) {
        this(z5Var.keySet().size(), z5Var instanceof ArrayListMultimap ? ((ArrayListMultimap) z5Var).expectedValuesPerKey : 3);
        putAll(z5Var);
    }

    public static <K, V> ArrayListMultimap<K, V> create() {
        return new ArrayListMultimap<>();
    }

    public static <K, V> ArrayListMultimap<K, V> create(int i11, int i12) {
        return new ArrayListMultimap<>(i11, i12);
    }

    public static <K, V> ArrayListMultimap<K, V> create(z5<? extends K, ? extends V> z5Var) {
        return new ArrayListMultimap<>(z5Var);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.expectedValuesPerKey = 3;
        int iH = y6.h(objectInputStream);
        setMap(Maps.m());
        y6.e(this, objectInputStream, iH);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        y6.j(this, objectOutputStream);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractListMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractListMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap
    public List<V> createCollection() {
        return new ArrayList(this.expectedValuesPerKey);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ Collection entries() {
        return super.entries();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractListMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap
    public /* bridge */ /* synthetic */ void forEach(BiConsumer biConsumer) {
        super.forEach(biConsumer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractListMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ List get(Object obj) {
        return super.get(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public /* bridge */ /* synthetic */ l6 keys() {
        return super.keys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractListMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public /* bridge */ /* synthetic */ boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ boolean putAll(z5 z5Var) {
        return super.putAll(z5Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractListMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ List removeAll(Object obj) {
        return super.removeAll(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractListMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public /* bridge */ /* synthetic */ List replaceValues(Object obj, Iterable iterable) {
        return super.replaceValues(obj, iterable);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Deprecated
    public void trimToSize() {
        Iterator<Collection<V>> it = backingMap().values().iterator();
        while (it.hasNext()) {
            ((ArrayList) it.next()).trimToSize();
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }
}
