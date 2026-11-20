package com.bumptech.glide.repackaged.com.google.common.collect;

import com.bumptech.glide.repackaged.com.google.common.base.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class RegularImmutableBiMap<K, V> extends ImmutableBiMap {
    static final RegularImmutableBiMap<Object, Object> EMPTY = new RegularImmutableBiMap<>(null, null, ImmutableMap.EMPTY_ENTRY_ARRAY, 0, 0);
    private final transient Map.Entry<K, V>[] entries;
    private final transient int hashCode;
    private transient ImmutableBiMap inverse;
    private final transient ImmutableMapEntry<K, V>[] keyTable;
    private final transient int mask;
    private final transient ImmutableMapEntry<K, V>[] valueTable;

    /* JADX INFO: compiled from: source.java */
    public final class Inverse extends ImmutableBiMap {

        /* JADX INFO: compiled from: source.java */
        public final class InverseEntrySet extends ImmutableMapEntrySet<V, K> {
            public InverseEntrySet() {
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
            public ImmutableList<Map.Entry<V, K>> createAsList() {
                return new ImmutableAsList<Map.Entry<V, K>>() { // from class: com.bumptech.glide.repackaged.com.google.common.collect.RegularImmutableBiMap.Inverse.InverseEntrySet.1
                    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableAsList
                    public ImmutableCollection<Map.Entry<V, K>> delegateCollection() {
                        return InverseEntrySet.this;
                    }

                    @Override // java.util.List
                    public Map.Entry<V, K> get(int i11) {
                        Map.Entry entry = RegularImmutableBiMap.this.entries[i11];
                        return Maps.immutableEntry(entry.getValue(), entry.getKey());
                    }
                };
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMapEntrySet, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
            public int hashCode() {
                return RegularImmutableBiMap.this.hashCode;
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMapEntrySet, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet
            public boolean isHashCodeFast() {
                return true;
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
            public UnmodifiableIterator<Map.Entry<V, K>> iterator() {
                return asList().iterator();
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMapEntrySet
            public ImmutableMap<V, K> map() {
                return Inverse.this;
            }
        }

        private Inverse() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap
        public ImmutableSet<Map.Entry<V, K>> createEntrySet() {
            return new InverseEntrySet();
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap, java.util.Map
        public K get(Object obj) {
            if (obj != null && RegularImmutableBiMap.this.valueTable != null) {
                for (ImmutableMapEntry nextInValueBucket = RegularImmutableBiMap.this.valueTable[Hashing.smear(obj.hashCode()) & RegularImmutableBiMap.this.mask]; nextInValueBucket != null; nextInValueBucket = nextInValueBucket.getNextInValueBucket()) {
                    if (obj.equals(nextInValueBucket.getValue())) {
                        return nextInValueBucket.getKey();
                    }
                }
            }
            return null;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableBiMap
        public ImmutableBiMap inverse() {
            return RegularImmutableBiMap.this;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return false;
        }

        @Override // java.util.Map
        public int size() {
            return inverse().size();
        }
    }

    private RegularImmutableBiMap(ImmutableMapEntry<K, V>[] immutableMapEntryArr, ImmutableMapEntry<K, V>[] immutableMapEntryArr2, Map.Entry<K, V>[] entryArr, int i11, int i12) {
        this.keyTable = immutableMapEntryArr;
        this.valueTable = immutableMapEntryArr2;
        this.entries = entryArr;
        this.mask = i11;
        this.hashCode = i12;
    }

    private static void checkNoConflictInValueBucket(Object obj, Map.Entry<?, ?> entry, ImmutableMapEntry<?, ?> immutableMapEntry) {
        while (immutableMapEntry != null) {
            ImmutableMap.checkNoConflict(!obj.equals(immutableMapEntry.getValue()), AppMeasurementSdk.ConditionalUserProperty.VALUE, entry, immutableMapEntry);
            immutableMapEntry = immutableMapEntry.getNextInValueBucket();
        }
    }

    public static <K, V> RegularImmutableBiMap<K, V> fromEntryArray(int i11, Map.Entry<K, V>[] entryArr) {
        ImmutableMapEntry nonTerminalImmutableBiMapEntry;
        int i12 = i11;
        Preconditions.checkPositionIndex(i12, entryArr.length);
        int iClosedTableSize = Hashing.closedTableSize(i12, 1.2d);
        int i13 = iClosedTableSize - 1;
        ImmutableMapEntry[] immutableMapEntryArrCreateEntryArray = ImmutableMapEntry.createEntryArray(iClosedTableSize);
        ImmutableMapEntry[] immutableMapEntryArrCreateEntryArray2 = ImmutableMapEntry.createEntryArray(iClosedTableSize);
        Map.Entry<K, V>[] entryArrCreateEntryArray = i12 == entryArr.length ? entryArr : ImmutableMapEntry.createEntryArray(i11);
        int i14 = 0;
        int i15 = 0;
        while (i14 < i12) {
            Map.Entry<K, V> entry = entryArr[i14];
            K key = entry.getKey();
            V value = entry.getValue();
            CollectPreconditions.checkEntryNotNull(key, value);
            int iHashCode = key.hashCode();
            int iHashCode2 = value.hashCode();
            int iSmear = Hashing.smear(iHashCode) & i13;
            int iSmear2 = Hashing.smear(iHashCode2) & i13;
            ImmutableMapEntry immutableMapEntry = immutableMapEntryArrCreateEntryArray[iSmear];
            RegularImmutableMap.checkNoConflictInKeyBucket(key, entry, immutableMapEntry);
            ImmutableMapEntry immutableMapEntry2 = immutableMapEntryArrCreateEntryArray2[iSmear2];
            checkNoConflictInValueBucket(value, entry, immutableMapEntry2);
            if (immutableMapEntry2 == null && immutableMapEntry == null) {
                nonTerminalImmutableBiMapEntry = ((entry instanceof ImmutableMapEntry) && ((ImmutableMapEntry) entry).isReusable()) ? (ImmutableMapEntry) entry : new ImmutableMapEntry(key, value);
            } else {
                nonTerminalImmutableBiMapEntry = new ImmutableMapEntry.NonTerminalImmutableBiMapEntry(key, value, immutableMapEntry, immutableMapEntry2);
            }
            immutableMapEntryArrCreateEntryArray[iSmear] = nonTerminalImmutableBiMapEntry;
            immutableMapEntryArrCreateEntryArray2[iSmear2] = nonTerminalImmutableBiMapEntry;
            entryArrCreateEntryArray[i14] = nonTerminalImmutableBiMapEntry;
            i15 += iHashCode ^ iHashCode2;
            i14++;
            i12 = i11;
        }
        return new RegularImmutableBiMap<>(immutableMapEntryArrCreateEntryArray, immutableMapEntryArrCreateEntryArray2, entryArrCreateEntryArray, i13, i15);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return isEmpty() ? ImmutableSet.of() : new ImmutableMapEntrySet.RegularEntrySet(this, this.entries);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        ImmutableMapEntry<K, V>[] immutableMapEntryArr = this.keyTable;
        if (immutableMapEntryArr == null) {
            return null;
        }
        return (V) RegularImmutableMap.get(obj, immutableMapEntryArr, this.mask);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap, java.util.Map
    public int hashCode() {
        return this.hashCode;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableBiMap
    public ImmutableBiMap inverse() {
        if (isEmpty()) {
            return ImmutableBiMap.of();
        }
        ImmutableBiMap immutableBiMap = this.inverse;
        if (immutableBiMap != null) {
            return immutableBiMap;
        }
        Inverse inverse = new Inverse();
        this.inverse = inverse;
        return inverse;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap
    public boolean isHashCodeFast() {
        return true;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.entries.length;
    }
}
