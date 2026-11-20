package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.Serializable;
import java.util.Map;
import java.util.function.BiConsumer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    static final ImmutableMap<Object, Object> EMPTY = new RegularImmutableMap(ImmutableMap.EMPTY_ENTRY_ARRAY, null, 0);
    static final double HASH_FLOODING_FPP = 0.001d;
    static final int MAX_HASH_BUCKET_LENGTH = 8;
    static final double MAX_LOAD_FACTOR = 1.2d;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient ImmutableMapEntry<K, V>[] f39558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient int f39559b;
    final transient Map.Entry<K, V>[] entries;

    /* JADX INFO: compiled from: source.java */
    public static final class KeySet<K, V> extends IndexedImmutableSet<K> {
        private final RegularImmutableMap<K, V> map;

        /* JADX INFO: compiled from: source.java */
        public static class SerializedForm<K> implements Serializable {
            private static final long serialVersionUID = 0;
            final ImmutableMap<K, ?> map;

            public SerializedForm(ImmutableMap<K, ?> immutableMap) {
                this.map = immutableMap;
            }

            public Object readResolve() {
                return this.map.keySet();
            }
        }

        public KeySet(RegularImmutableMap<K, V> regularImmutableMap) {
            this.map = regularImmutableMap;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.map.containsKey(obj);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.IndexedImmutableSet
        public K get(int i11) {
            return this.map.entries[i11].getKey();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return new SerializedForm(this.map);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class Values<K, V> extends ImmutableList<V> {
        final RegularImmutableMap<K, V> map;

        /* JADX INFO: compiled from: source.java */
        public static class SerializedForm<V> implements Serializable {
            private static final long serialVersionUID = 0;
            final ImmutableMap<?, V> map;

            public SerializedForm(ImmutableMap<?, V> immutableMap) {
                this.map = immutableMap;
            }

            public Object readResolve() {
                return this.map.values();
            }
        }

        public Values(RegularImmutableMap<K, V> regularImmutableMap) {
            this.map = regularImmutableMap;
        }

        @Override // java.util.List
        public V get(int i11) {
            return this.map.entries[i11].getValue();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.map.size();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return new SerializedForm(this.map);
        }
    }

    public RegularImmutableMap(Map.Entry<K, V>[] entryArr, ImmutableMapEntry<K, V>[] immutableMapEntryArr, int i11) {
        this.entries = entryArr;
        this.f39558a = immutableMapEntryArr;
        this.f39559b = i11;
    }

    public static int checkNoConflictInKeyBucket(Object obj, Map.Entry<?, ?> entry, ImmutableMapEntry<?, ?> immutableMapEntry) {
        int i11 = 0;
        while (immutableMapEntry != null) {
            ImmutableMap.checkNoConflict(!obj.equals(immutableMapEntry.getKey()), "key", entry, immutableMapEntry);
            i11++;
            immutableMapEntry = immutableMapEntry.getNextInKeyBucket();
        }
        return i11;
    }

    public static <K, V> ImmutableMap<K, V> fromEntries(Map.Entry<K, V>... entryArr) {
        return fromEntryArray(entryArr.length, entryArr);
    }

    public static <K, V> ImmutableMap<K, V> fromEntryArray(int i11, Map.Entry<K, V>[] entryArr) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.q(i11, entryArr.length);
        if (i11 == 0) {
            return (RegularImmutableMap) EMPTY;
        }
        Map.Entry<K, V>[] entryArrCreateEntryArray = i11 == entryArr.length ? entryArr : ImmutableMapEntry.createEntryArray(i11);
        int iA = y2.a(i11, MAX_LOAD_FACTOR);
        ImmutableMapEntry[] immutableMapEntryArrCreateEntryArray = ImmutableMapEntry.createEntryArray(iA);
        int i12 = iA - 1;
        for (int i13 = 0; i13 < i11; i13++) {
            Map.Entry<K, V> entry = entryArr[i13];
            K key = entry.getKey();
            V value = entry.getValue();
            n1.a(key, value);
            int iC = y2.c(key.hashCode()) & i12;
            ImmutableMapEntry immutableMapEntry = immutableMapEntryArrCreateEntryArray[iC];
            ImmutableMapEntry immutableMapEntryMakeImmutable = immutableMapEntry == null ? makeImmutable(entry, key, value) : new ImmutableMapEntry.NonTerminalImmutableMapEntry(key, value, immutableMapEntry);
            immutableMapEntryArrCreateEntryArray[iC] = immutableMapEntryMakeImmutable;
            entryArrCreateEntryArray[i13] = immutableMapEntryMakeImmutable;
            if (checkNoConflictInKeyBucket(key, immutableMapEntryMakeImmutable, immutableMapEntry) > 8) {
                return JdkBackedImmutableMap.create(i11, entryArr);
            }
        }
        return new RegularImmutableMap(entryArrCreateEntryArray, immutableMapEntryArrCreateEntryArray, i12);
    }

    public static <V> V get(Object obj, ImmutableMapEntry<?, V>[] immutableMapEntryArr, int i11) {
        if (obj != null && immutableMapEntryArr != null) {
            for (ImmutableMapEntry<?, V> nextInKeyBucket = immutableMapEntryArr[i11 & y2.c(obj.hashCode())]; nextInKeyBucket != null; nextInKeyBucket = nextInKeyBucket.getNextInKeyBucket()) {
                if (obj.equals(nextInKeyBucket.getKey())) {
                    return nextInKeyBucket.getValue();
                }
            }
        }
        return null;
    }

    public static <K, V> ImmutableMapEntry<K, V> makeImmutable(Map.Entry<K, V> entry) {
        return makeImmutable(entry, entry.getKey(), entry.getValue());
    }

    public static <K, V> ImmutableMapEntry<K, V> makeImmutable(Map.Entry<K, V> entry, K k11, V v11) {
        return ((entry instanceof ImmutableMapEntry) && ((ImmutableMapEntry) entry).isReusable()) ? (ImmutableMapEntry) entry : new ImmutableMapEntry<>(k11, v11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new ImmutableMapEntrySet.RegularEntrySet(this, this.entries);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        return new KeySet(this);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
    public ImmutableCollection<V> createValues() {
        return new Values(this);
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(biConsumer);
        for (Map.Entry<K, V> entry : this.entries) {
            biConsumer.accept(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        return (V) get(obj, this.f39558a, this.f39559b);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.entries.length;
    }
}
