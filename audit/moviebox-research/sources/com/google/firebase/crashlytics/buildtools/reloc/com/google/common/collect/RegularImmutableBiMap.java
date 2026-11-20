package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.Serializable;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
class RegularImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    static final RegularImmutableBiMap<Object, Object> EMPTY = new RegularImmutableBiMap<>(null, null, ImmutableMap.EMPTY_ENTRY_ARRAY, 0, 0);
    static final double MAX_LOAD_FACTOR = 1.2d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient ImmutableMapEntry<K, V>[] f39553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient ImmutableMapEntry<K, V>[] f39554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient int f39555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f39556d;
    final transient Map.Entry<K, V>[] entries;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient ImmutableBiMap<V, K> f39557f;

    /* JADX INFO: compiled from: source.java */
    public final class Inverse extends ImmutableBiMap<V, K> {

        /* JADX INFO: compiled from: source.java */
        public final class InverseEntrySet extends ImmutableMapEntrySet<V, K> {
            public InverseEntrySet() {
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet
            public ImmutableList<Map.Entry<V, K>> createAsList() {
                return new ImmutableAsList<Map.Entry<V, K>>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.RegularImmutableBiMap.Inverse.InverseEntrySet.1
                    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableAsList
                    public ImmutableCollection<Map.Entry<V, K>> delegateCollection() {
                        return InverseEntrySet.this;
                    }

                    @Override // java.util.List
                    public Map.Entry<V, K> get(int i11) {
                        Map.Entry<K, V> entry = RegularImmutableBiMap.this.entries[i11];
                        return Maps.g(entry.getValue(), entry.getKey());
                    }
                };
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Map.Entry<V, K>> consumer) {
                asList().forEach(consumer);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMapEntrySet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
            public int hashCode() {
                return RegularImmutableBiMap.this.f39556d;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMapEntrySet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet
            public boolean isHashCodeFast() {
                return true;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
            public t7<Map.Entry<V, K>> iterator() {
                return asList().iterator();
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMapEntrySet
            public ImmutableMap<V, K> map() {
                return Inverse.this;
            }
        }

        public Inverse() {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
        public ImmutableSet<Map.Entry<V, K>> createEntrySet() {
            return new InverseEntrySet();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
        public ImmutableSet<V> createKeySet() {
            return new ImmutableMapKeySet(this);
        }

        @Override // java.util.Map
        public void forEach(final BiConsumer<? super V, ? super K> biConsumer) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(biConsumer);
            RegularImmutableBiMap.this.forEach(new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.w6
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    f.a(biConsumer, obj2, obj);
                }
            });
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap, java.util.Map
        public K get(Object obj) {
            if (obj != null && RegularImmutableBiMap.this.f39554b != null) {
                for (ImmutableMapEntry nextInValueBucket = RegularImmutableBiMap.this.f39554b[y2.c(obj.hashCode()) & RegularImmutableBiMap.this.f39555c]; nextInValueBucket != null; nextInValueBucket = nextInValueBucket.getNextInValueBucket()) {
                    if (obj.equals(nextInValueBucket.getValue())) {
                        return nextInValueBucket.getKey();
                    }
                }
            }
            return null;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableBiMap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.d0
        public ImmutableBiMap<K, V> inverse() {
            return RegularImmutableBiMap.this;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return false;
        }

        @Override // java.util.Map
        public int size() {
            return inverse().size();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableBiMap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
        public Object writeReplace() {
            return new InverseSerializedForm(RegularImmutableBiMap.this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class InverseSerializedForm<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        private final ImmutableBiMap<K, V> forward;

        public InverseSerializedForm(ImmutableBiMap<K, V> immutableBiMap) {
            this.forward = immutableBiMap;
        }

        public Object readResolve() {
            return this.forward.inverse();
        }
    }

    public RegularImmutableBiMap(ImmutableMapEntry<K, V>[] immutableMapEntryArr, ImmutableMapEntry<K, V>[] immutableMapEntryArr2, Map.Entry<K, V>[] entryArr, int i11, int i12) {
        this.f39553a = immutableMapEntryArr;
        this.f39554b = immutableMapEntryArr2;
        this.entries = entryArr;
        this.f39555c = i11;
        this.f39556d = i12;
    }

    public static int a(Object obj, Map.Entry<?, ?> entry, ImmutableMapEntry<?, ?> immutableMapEntry) {
        int i11 = 0;
        while (immutableMapEntry != null) {
            ImmutableMap.checkNoConflict(!obj.equals(immutableMapEntry.getValue()), AppMeasurementSdk.ConditionalUserProperty.VALUE, entry, immutableMapEntry);
            i11++;
            immutableMapEntry = immutableMapEntry.getNextInValueBucket();
        }
        return i11;
    }

    public static <K, V> ImmutableBiMap<K, V> fromEntries(Map.Entry<K, V>... entryArr) {
        return fromEntryArray(entryArr.length, entryArr);
    }

    public static <K, V> ImmutableBiMap<K, V> fromEntryArray(int i11, Map.Entry<K, V>[] entryArr) {
        int i12 = i11;
        Map.Entry<K, V>[] entryArr2 = entryArr;
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.q(i12, entryArr2.length);
        int iA = y2.a(i12, MAX_LOAD_FACTOR);
        int i13 = iA - 1;
        ImmutableMapEntry[] immutableMapEntryArrCreateEntryArray = ImmutableMapEntry.createEntryArray(iA);
        ImmutableMapEntry[] immutableMapEntryArrCreateEntryArray2 = ImmutableMapEntry.createEntryArray(iA);
        Map.Entry<K, V>[] entryArrCreateEntryArray = i12 == entryArr2.length ? entryArr2 : ImmutableMapEntry.createEntryArray(i11);
        int i14 = 0;
        int i15 = 0;
        while (i14 < i12) {
            Map.Entry<K, V> entry = entryArr2[i14];
            K key = entry.getKey();
            V value = entry.getValue();
            n1.a(key, value);
            int iHashCode = key.hashCode();
            int iHashCode2 = value.hashCode();
            int iC = y2.c(iHashCode) & i13;
            int iC2 = y2.c(iHashCode2) & i13;
            ImmutableMapEntry immutableMapEntry = immutableMapEntryArrCreateEntryArray[iC];
            int iCheckNoConflictInKeyBucket = RegularImmutableMap.checkNoConflictInKeyBucket(key, entry, immutableMapEntry);
            ImmutableMapEntry immutableMapEntry2 = immutableMapEntryArrCreateEntryArray2[iC2];
            int i16 = i13;
            int iA2 = a(value, entry, immutableMapEntry2);
            int i17 = i15;
            if (iCheckNoConflictInKeyBucket > 8 || iA2 > 8) {
                return JdkBackedImmutableBiMap.create(i11, entryArr);
            }
            ImmutableMapEntry immutableMapEntryMakeImmutable = (immutableMapEntry2 == null && immutableMapEntry == null) ? RegularImmutableMap.makeImmutable(entry, key, value) : new ImmutableMapEntry.NonTerminalImmutableBiMapEntry(key, value, immutableMapEntry, immutableMapEntry2);
            immutableMapEntryArrCreateEntryArray[iC] = immutableMapEntryMakeImmutable;
            immutableMapEntryArrCreateEntryArray2[iC2] = immutableMapEntryMakeImmutable;
            entryArrCreateEntryArray[i14] = immutableMapEntryMakeImmutable;
            i15 = i17 + (iHashCode ^ iHashCode2);
            i14++;
            i12 = i11;
            entryArr2 = entryArr;
            i13 = i16;
        }
        return new RegularImmutableBiMap(immutableMapEntryArrCreateEntryArray, immutableMapEntryArrCreateEntryArray2, entryArrCreateEntryArray, i13, i15);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return isEmpty() ? ImmutableSet.of() : new ImmutableMapEntrySet.RegularEntrySet(this, this.entries);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        return new ImmutableMapKeySet(this);
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
        ImmutableMapEntry<K, V>[] immutableMapEntryArr = this.f39553a;
        if (immutableMapEntryArr == null) {
            return null;
        }
        return (V) RegularImmutableMap.get(obj, immutableMapEntryArr, this.f39555c);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap, java.util.Map
    public int hashCode() {
        return this.f39556d;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableBiMap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.d0
    public ImmutableBiMap<V, K> inverse() {
        if (isEmpty()) {
            return ImmutableBiMap.of();
        }
        ImmutableBiMap<V, K> immutableBiMap = this.f39557f;
        if (immutableBiMap != null) {
            return immutableBiMap;
        }
        Inverse inverse = new Inverse();
        this.f39557f = inverse;
        return inverse;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
    public boolean isHashCodeFast() {
        return true;
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
