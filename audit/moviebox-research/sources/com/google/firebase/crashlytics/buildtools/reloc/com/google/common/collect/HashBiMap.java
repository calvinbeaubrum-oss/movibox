package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class HashBiMap<K, V> extends Maps.h<K, V> implements d0<K, V>, Serializable {
    private static final double LOAD_FACTOR = 1.0d;
    private static final long serialVersionUID = 0;
    private transient BiEntry<K, V> firstInKeyInsertionOrder;
    private transient BiEntry<K, V>[] hashTableKToV;
    private transient BiEntry<K, V>[] hashTableVToK;
    private transient d0<V, K> inverse;
    private transient BiEntry<K, V> lastInKeyInsertionOrder;
    private transient int mask;
    private transient int modCount;
    private transient int size;

    /* JADX INFO: compiled from: source.java */
    public static final class BiEntry<K, V> extends ImmutableEntry<K, V> {
        final int keyHash;
        BiEntry<K, V> nextInKToVBucket;
        BiEntry<K, V> nextInKeyInsertionOrder;
        BiEntry<K, V> nextInVToKBucket;
        BiEntry<K, V> prevInKeyInsertionOrder;
        final int valueHash;

        public BiEntry(K k11, int i11, V v11, int i12) {
            super(k11, v11);
            this.keyHash = i11;
            this.valueHash = i12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class Inverse extends Maps.h<V, K> implements d0<V, K>, Serializable {

        /* JADX INFO: compiled from: source.java */
        public class a extends HashBiMap<K, V>.b<Map.Entry<V, K>> {

            /* JADX INFO: renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.HashBiMap$Inverse$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            public class C0408a extends q<V, K> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public BiEntry<K, V> f39310a;

                public C0408a(BiEntry<K, V> biEntry) {
                    this.f39310a = biEntry;
                }

                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q, java.util.Map.Entry
                public V getKey() {
                    return this.f39310a.value;
                }

                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q, java.util.Map.Entry
                public K getValue() {
                    return this.f39310a.key;
                }

                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q, java.util.Map.Entry
                public K setValue(K k11) {
                    K k12 = this.f39310a.key;
                    int iD = y2.d(k11);
                    if (iD == this.f39310a.keyHash && com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.g.a(k11, k12)) {
                        return k11;
                    }
                    com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.j(HashBiMap.this.seekByKey(k11, iD) == null, "value already present: %s", k11);
                    HashBiMap.this.delete(this.f39310a);
                    BiEntry<K, V> biEntry = this.f39310a;
                    BiEntry<K, V> biEntry2 = new BiEntry<>(k11, iD, biEntry.value, biEntry.valueHash);
                    this.f39310a = biEntry2;
                    HashBiMap.this.insert(biEntry2, null);
                    a aVar = a.this;
                    aVar.f39319c = HashBiMap.this.modCount;
                    return k12;
                }
            }

            public a() {
                super();
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.HashBiMap.b
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<V, K> a(BiEntry<K, V> biEntry) {
                return new C0408a(biEntry);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public final class b extends Maps.i<V, K> {

            /* JADX INFO: compiled from: source.java */
            public class a extends HashBiMap<K, V>.b<V> {
                public a() {
                    super();
                }

                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.HashBiMap.b
                public V a(BiEntry<K, V> biEntry) {
                    return biEntry.value;
                }
            }

            public b() {
                super(Inverse.this);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<V> iterator() {
                return new a();
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                BiEntry biEntrySeekByValue = HashBiMap.this.seekByValue(obj, y2.d(obj));
                if (biEntrySeekByValue == null) {
                    return false;
                }
                HashBiMap.this.delete(biEntrySeekByValue);
                return true;
            }
        }

        public Inverse() {
        }

        public /* synthetic */ Inverse(HashBiMap hashBiMap, a aVar) {
            this();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.h, java.util.AbstractMap, java.util.Map
        public void clear() {
            forward().clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return forward().containsValue(obj);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.h
        public Iterator<Map.Entry<V, K>> entryIterator() {
            return new a();
        }

        @Override // java.util.Map
        public void forEach(final BiConsumer<? super V, ? super K> biConsumer) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(biConsumer);
            HashBiMap.this.forEach(new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.x2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    f.a(biConsumer, obj2, obj);
                }
            });
        }

        public K forcePut(V v11, K k11) {
            return (K) HashBiMap.this.putInverse(v11, k11, true);
        }

        public d0<K, V> forward() {
            return HashBiMap.this;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K get(Object obj) {
            return (K) Maps.k(HashBiMap.this.seekByValue(obj, y2.d(obj)));
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.d0
        public d0<K, V> inverse() {
            return forward();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<V> keySet() {
            return new b();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K put(V v11, K k11) {
            return (K) HashBiMap.this.putInverse(v11, k11, false);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K remove(Object obj) {
            BiEntry biEntrySeekByValue = HashBiMap.this.seekByValue(obj, y2.d(obj));
            if (biEntrySeekByValue == null) {
                return null;
            }
            HashBiMap.this.delete(biEntrySeekByValue);
            biEntrySeekByValue.prevInKeyInsertionOrder = null;
            biEntrySeekByValue.nextInKeyInsertionOrder = null;
            return biEntrySeekByValue.key;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        public void replaceAll(BiFunction<? super V, ? super K, ? extends K> biFunction) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(biFunction);
            clear();
            for (BiEntry<K, V> biEntry = HashBiMap.this.firstInKeyInsertionOrder; biEntry != null; biEntry = biEntry.nextInKeyInsertionOrder) {
                V v11 = biEntry.value;
                put(v11, biFunction.apply(v11, biEntry.key));
            }
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.h, java.util.AbstractMap, java.util.Map
        public int size() {
            return HashBiMap.this.size;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> values() {
            return forward().keySet();
        }

        public Object writeReplace() {
            return new InverseSerializedForm(HashBiMap.this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class InverseSerializedForm<K, V> implements Serializable {
        private final HashBiMap<K, V> bimap;

        public InverseSerializedForm(HashBiMap<K, V> hashBiMap) {
            this.bimap = hashBiMap;
        }

        public Object readResolve() {
            return this.bimap.inverse();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends HashBiMap<K, V>.b<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.HashBiMap$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0409a extends q<K, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public BiEntry<K, V> f39315a;

            public C0409a(BiEntry<K, V> biEntry) {
                this.f39315a = biEntry;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q, java.util.Map.Entry
            public K getKey() {
                return this.f39315a.key;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q, java.util.Map.Entry
            public V getValue() {
                return this.f39315a.value;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q, java.util.Map.Entry
            public V setValue(V v11) {
                V v12 = this.f39315a.value;
                int iD = y2.d(v11);
                if (iD == this.f39315a.valueHash && com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.g.a(v11, v12)) {
                    return v11;
                }
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.j(HashBiMap.this.seekByValue(v11, iD) == null, "value already present: %s", v11);
                HashBiMap.this.delete(this.f39315a);
                BiEntry<K, V> biEntry = this.f39315a;
                BiEntry<K, V> biEntry2 = new BiEntry<>(biEntry.key, biEntry.keyHash, v11, iD);
                HashBiMap.this.insert(biEntry2, this.f39315a);
                BiEntry<K, V> biEntry3 = this.f39315a;
                biEntry3.prevInKeyInsertionOrder = null;
                biEntry3.nextInKeyInsertionOrder = null;
                a aVar = a.this;
                aVar.f39319c = HashBiMap.this.modCount;
                a aVar2 = a.this;
                if (aVar2.f39318b == this.f39315a) {
                    aVar2.f39318b = biEntry2;
                }
                this.f39315a = biEntry2;
                return v12;
            }
        }

        public a() {
            super();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.HashBiMap.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> a(BiEntry<K, V> biEntry) {
            return new C0409a(biEntry);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public abstract class b<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BiEntry<K, V> f39317a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BiEntry<K, V> f39318b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f39319c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f39320d;

        public b() {
            this.f39317a = HashBiMap.this.firstInKeyInsertionOrder;
            this.f39319c = HashBiMap.this.modCount;
            this.f39320d = HashBiMap.this.size();
        }

        public abstract T a(BiEntry<K, V> biEntry);

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (HashBiMap.this.modCount == this.f39319c) {
                return this.f39317a != null && this.f39320d > 0;
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            BiEntry<K, V> biEntry = this.f39317a;
            this.f39317a = biEntry.nextInKeyInsertionOrder;
            this.f39318b = biEntry;
            this.f39320d--;
            return a(biEntry);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (HashBiMap.this.modCount != this.f39319c) {
                throw new ConcurrentModificationException();
            }
            n1.e(this.f39318b != null);
            HashBiMap.this.delete(this.f39318b);
            this.f39319c = HashBiMap.this.modCount;
            this.f39318b = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class c extends Maps.i<K, V> {

        /* JADX INFO: compiled from: source.java */
        public class a extends HashBiMap<K, V>.b<K> {
            public a() {
                super();
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.HashBiMap.b
            public K a(BiEntry<K, V> biEntry) {
                return biEntry.key;
            }
        }

        public c() {
            super(HashBiMap.this);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            BiEntry biEntrySeekByKey = HashBiMap.this.seekByKey(obj, y2.d(obj));
            if (biEntrySeekByKey == null) {
                return false;
            }
            HashBiMap.this.delete(biEntrySeekByKey);
            biEntrySeekByKey.prevInKeyInsertionOrder = null;
            biEntrySeekByKey.nextInKeyInsertionOrder = null;
            return true;
        }
    }

    private HashBiMap(int i11) {
        init(i11);
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    public static <K, V> HashBiMap<K, V> create(int i11) {
        return new HashBiMap<>(i11);
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> map) {
        HashBiMap<K, V> hashBiMapCreate = create(map.size());
        hashBiMapCreate.putAll(map);
        return hashBiMapCreate;
    }

    private BiEntry<K, V>[] createTable(int i11) {
        return new BiEntry[i11];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delete(BiEntry<K, V> biEntry) {
        BiEntry<K, V> biEntry2;
        int i11 = biEntry.keyHash & this.mask;
        BiEntry<K, V> biEntry3 = null;
        BiEntry<K, V> biEntry4 = null;
        for (BiEntry<K, V> biEntry5 = this.hashTableKToV[i11]; biEntry5 != biEntry; biEntry5 = biEntry5.nextInKToVBucket) {
            biEntry4 = biEntry5;
        }
        if (biEntry4 == null) {
            this.hashTableKToV[i11] = biEntry.nextInKToVBucket;
        } else {
            biEntry4.nextInKToVBucket = biEntry.nextInKToVBucket;
        }
        int i12 = biEntry.valueHash & this.mask;
        BiEntry<K, V> biEntry6 = this.hashTableVToK[i12];
        while (true) {
            biEntry2 = biEntry3;
            biEntry3 = biEntry6;
            if (biEntry3 == biEntry) {
                break;
            } else {
                biEntry6 = biEntry3.nextInVToKBucket;
            }
        }
        if (biEntry2 == null) {
            this.hashTableVToK[i12] = biEntry.nextInVToKBucket;
        } else {
            biEntry2.nextInVToKBucket = biEntry.nextInVToKBucket;
        }
        BiEntry<K, V> biEntry7 = biEntry.prevInKeyInsertionOrder;
        if (biEntry7 == null) {
            this.firstInKeyInsertionOrder = biEntry.nextInKeyInsertionOrder;
        } else {
            biEntry7.nextInKeyInsertionOrder = biEntry.nextInKeyInsertionOrder;
        }
        BiEntry<K, V> biEntry8 = biEntry.nextInKeyInsertionOrder;
        if (biEntry8 == null) {
            this.lastInKeyInsertionOrder = biEntry7;
        } else {
            biEntry8.prevInKeyInsertionOrder = biEntry7;
        }
        this.size--;
        this.modCount++;
    }

    private void init(int i11) {
        n1.b(i11, "expectedSize");
        int iA = y2.a(i11, 1.0d);
        this.hashTableKToV = createTable(iA);
        this.hashTableVToK = createTable(iA);
        this.firstInKeyInsertionOrder = null;
        this.lastInKeyInsertionOrder = null;
        this.size = 0;
        this.mask = iA - 1;
        this.modCount = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void insert(BiEntry<K, V> biEntry, BiEntry<K, V> biEntry2) {
        int i11 = biEntry.keyHash;
        int i12 = this.mask;
        int i13 = i11 & i12;
        BiEntry<K, V>[] biEntryArr = this.hashTableKToV;
        biEntry.nextInKToVBucket = biEntryArr[i13];
        biEntryArr[i13] = biEntry;
        int i14 = biEntry.valueHash & i12;
        BiEntry<K, V>[] biEntryArr2 = this.hashTableVToK;
        biEntry.nextInVToKBucket = biEntryArr2[i14];
        biEntryArr2[i14] = biEntry;
        if (biEntry2 == null) {
            BiEntry<K, V> biEntry3 = this.lastInKeyInsertionOrder;
            biEntry.prevInKeyInsertionOrder = biEntry3;
            biEntry.nextInKeyInsertionOrder = null;
            if (biEntry3 == null) {
                this.firstInKeyInsertionOrder = biEntry;
            } else {
                biEntry3.nextInKeyInsertionOrder = biEntry;
            }
            this.lastInKeyInsertionOrder = biEntry;
        } else {
            BiEntry<K, V> biEntry4 = biEntry2.prevInKeyInsertionOrder;
            biEntry.prevInKeyInsertionOrder = biEntry4;
            if (biEntry4 == null) {
                this.firstInKeyInsertionOrder = biEntry;
            } else {
                biEntry4.nextInKeyInsertionOrder = biEntry;
            }
            BiEntry<K, V> biEntry5 = biEntry2.nextInKeyInsertionOrder;
            biEntry.nextInKeyInsertionOrder = biEntry5;
            if (biEntry5 == null) {
                this.lastInKeyInsertionOrder = biEntry;
            } else {
                biEntry5.prevInKeyInsertionOrder = biEntry;
            }
        }
        this.size++;
        this.modCount++;
    }

    private V put(K k11, V v11, boolean z11) {
        int iD = y2.d(k11);
        int iD2 = y2.d(v11);
        BiEntry<K, V> biEntrySeekByKey = seekByKey(k11, iD);
        if (biEntrySeekByKey != null && iD2 == biEntrySeekByKey.valueHash && com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.g.a(v11, biEntrySeekByKey.value)) {
            return v11;
        }
        BiEntry<K, V> biEntrySeekByValue = seekByValue(v11, iD2);
        if (biEntrySeekByValue != null) {
            if (!z11) {
                throw new IllegalArgumentException("value already present: " + v11);
            }
            delete(biEntrySeekByValue);
        }
        BiEntry<K, V> biEntry = new BiEntry<>(k11, iD, v11, iD2);
        if (biEntrySeekByKey == null) {
            insert(biEntry, null);
            rehashIfNecessary();
            return null;
        }
        delete(biEntrySeekByKey);
        insert(biEntry, biEntrySeekByKey);
        biEntrySeekByKey.prevInKeyInsertionOrder = null;
        biEntrySeekByKey.nextInKeyInsertionOrder = null;
        rehashIfNecessary();
        return biEntrySeekByKey.value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public K putInverse(V v11, K k11, boolean z11) {
        int iD = y2.d(v11);
        int iD2 = y2.d(k11);
        BiEntry<K, V> biEntrySeekByValue = seekByValue(v11, iD);
        BiEntry<K, V> biEntrySeekByKey = seekByKey(k11, iD2);
        if (biEntrySeekByValue != null && iD2 == biEntrySeekByValue.keyHash && com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.g.a(k11, biEntrySeekByValue.key)) {
            return k11;
        }
        if (biEntrySeekByKey != null && !z11) {
            throw new IllegalArgumentException("key already present: " + k11);
        }
        if (biEntrySeekByValue != null) {
            delete(biEntrySeekByValue);
        }
        if (biEntrySeekByKey != null) {
            delete(biEntrySeekByKey);
        }
        insert(new BiEntry<>(k11, iD2, v11, iD), biEntrySeekByKey);
        if (biEntrySeekByKey != null) {
            biEntrySeekByKey.prevInKeyInsertionOrder = null;
            biEntrySeekByKey.nextInKeyInsertionOrder = null;
        }
        if (biEntrySeekByValue != null) {
            biEntrySeekByValue.prevInKeyInsertionOrder = null;
            biEntrySeekByValue.nextInKeyInsertionOrder = null;
        }
        rehashIfNecessary();
        return (K) Maps.k(biEntrySeekByValue);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int iH = y6.h(objectInputStream);
        init(16);
        y6.c(this, objectInputStream, iH);
    }

    private void rehashIfNecessary() {
        BiEntry<K, V>[] biEntryArr = this.hashTableKToV;
        if (y2.b(this.size, biEntryArr.length, 1.0d)) {
            int length = biEntryArr.length * 2;
            this.hashTableKToV = createTable(length);
            this.hashTableVToK = createTable(length);
            this.mask = length - 1;
            this.size = 0;
            for (BiEntry<K, V> biEntry = this.firstInKeyInsertionOrder; biEntry != null; biEntry = biEntry.nextInKeyInsertionOrder) {
                insert(biEntry, biEntry);
            }
            this.modCount++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BiEntry<K, V> seekByKey(Object obj, int i11) {
        for (BiEntry<K, V> biEntry = this.hashTableKToV[this.mask & i11]; biEntry != null; biEntry = biEntry.nextInKToVBucket) {
            if (i11 == biEntry.keyHash && com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.g.a(obj, biEntry.key)) {
                return biEntry;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BiEntry<K, V> seekByValue(Object obj, int i11) {
        for (BiEntry<K, V> biEntry = this.hashTableVToK[this.mask & i11]; biEntry != null; biEntry = biEntry.nextInVToKBucket) {
            if (i11 == biEntry.valueHash && com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.g.a(obj, biEntry.value)) {
                return biEntry;
            }
        }
        return null;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        y6.i(this, objectOutputStream);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.h, java.util.AbstractMap, java.util.Map
    public void clear() {
        this.size = 0;
        Arrays.fill(this.hashTableKToV, (Object) null);
        Arrays.fill(this.hashTableVToK, (Object) null);
        this.firstInKeyInsertionOrder = null;
        this.lastInKeyInsertionOrder = null;
        this.modCount++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return seekByKey(obj, y2.d(obj)) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return seekByValue(obj, y2.d(obj)) != null;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.h
    public Iterator<Map.Entry<K, V>> entryIterator() {
        return new a();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.h, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(biConsumer);
        for (BiEntry<K, V> biEntry = this.firstInKeyInsertionOrder; biEntry != null; biEntry = biEntry.nextInKeyInsertionOrder) {
            biConsumer.accept(biEntry.key, biEntry.value);
        }
    }

    public V forcePut(K k11, V v11) {
        return put(k11, v11, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        return (V) Maps.z(seekByKey(obj, y2.d(obj)));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.d0
    public d0<V, K> inverse() {
        d0<V, K> d0Var = this.inverse;
        if (d0Var != null) {
            return d0Var;
        }
        Inverse inverse = new Inverse(this, null);
        this.inverse = inverse;
        return inverse;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        return new c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k11, V v11) {
        return put(k11, v11, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        BiEntry<K, V> biEntrySeekByKey = seekByKey(obj, y2.d(obj));
        if (biEntrySeekByKey == null) {
            return null;
        }
        delete(biEntrySeekByKey);
        biEntrySeekByKey.prevInKeyInsertionOrder = null;
        biEntrySeekByKey.nextInKeyInsertionOrder = null;
        return biEntrySeekByKey.value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(biFunction);
        clear();
        for (BiEntry<K, V> biEntry = this.firstInKeyInsertionOrder; biEntry != null; biEntry = biEntry.nextInKeyInsertionOrder) {
            K k11 = biEntry.key;
            put(k11, biFunction.apply(k11, biEntry.value));
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.h, java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<V> values() {
        return inverse().keySet();
    }
}
