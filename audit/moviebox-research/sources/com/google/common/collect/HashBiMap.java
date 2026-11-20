package com.google.common.collect;

import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements k<K, V>, Serializable {
    private static final int ABSENT = -1;
    private static final int ENDPOINT = -2;
    private transient Set<Map.Entry<K, V>> entrySet;
    private transient int firstInInsertionOrder;
    private transient int[] hashTableKToV;
    private transient int[] hashTableVToK;

    @RetainedWith
    private transient k<V, K> inverse;
    private transient Set<K> keySet;
    transient K[] keys;
    private transient int lastInInsertionOrder;
    transient int modCount;
    private transient int[] nextInBucketKToV;
    private transient int[] nextInBucketVToK;
    private transient int[] nextInInsertionOrder;
    private transient int[] prevInInsertionOrder;
    transient int size;
    private transient Set<V> valueSet;
    transient V[] values;

    /* JADX INFO: compiled from: source.java */
    public static class Inverse<K, V> extends AbstractMap<V, K> implements k<V, K>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public transient Set<Map.Entry<V, K>> f38329a;
        private final HashBiMap<K, V> forward;

        public Inverse(HashBiMap<K, V> hashBiMap) {
            this.forward = hashBiMap;
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            ((HashBiMap) this.forward).inverse = this;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.forward.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.forward.containsValue(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(Object obj) {
            return this.forward.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<V, K>> entrySet() {
            Set<Map.Entry<V, K>> set = this.f38329a;
            if (set != null) {
                return set;
            }
            d dVar = new d(this.forward);
            this.f38329a = dVar;
            return dVar;
        }

        public K forcePut(V v11, K k11) {
            return this.forward.putInverse(v11, k11, true);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K get(Object obj) {
            return this.forward.getInverse(obj);
        }

        @Override // com.google.common.collect.k
        public k<K, V> inverse() {
            return this.forward;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<V> keySet() {
            return this.forward.values();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K put(V v11, K k11) {
            return this.forward.putInverse(v11, k11, false);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K remove(Object obj) {
            return this.forward.removeInverse(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.forward.size;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> values() {
            return this.forward.keySet();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class a extends com.google.common.collect.b<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f38330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f38331b;

        public a(int i11) {
            this.f38330a = (K) k0.a(HashBiMap.this.keys[i11]);
            this.f38331b = i11;
        }

        public void a() {
            int i11 = this.f38331b;
            if (i11 != -1) {
                HashBiMap hashBiMap = HashBiMap.this;
                if (i11 <= hashBiMap.size && com.google.common.base.j.a(hashBiMap.keys[i11], this.f38330a)) {
                    return;
                }
            }
            this.f38331b = HashBiMap.this.findEntryByKey(this.f38330a);
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public K getKey() {
            return this.f38330a;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V getValue() {
            a();
            int i11 = this.f38331b;
            return i11 == -1 ? (V) k0.b() : (V) k0.a(HashBiMap.this.values[i11]);
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V setValue(V v11) {
            a();
            int i11 = this.f38331b;
            if (i11 == -1) {
                HashBiMap.this.put(this.f38330a, v11);
                return (V) k0.b();
            }
            V v12 = (V) k0.a(HashBiMap.this.values[i11]);
            if (com.google.common.base.j.a(v12, v11)) {
                return v11;
            }
            HashBiMap.this.replaceValueInEntry(this.f38331b, v11, false);
            return v12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b<K, V> extends com.google.common.collect.b<V, K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashBiMap<K, V> f38333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V f38334b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f38335c;

        public b(HashBiMap<K, V> hashBiMap, int i11) {
            this.f38333a = hashBiMap;
            this.f38334b = (V) k0.a(hashBiMap.values[i11]);
            this.f38335c = i11;
        }

        private void a() {
            int i11 = this.f38335c;
            if (i11 != -1) {
                HashBiMap<K, V> hashBiMap = this.f38333a;
                if (i11 <= hashBiMap.size && com.google.common.base.j.a(this.f38334b, hashBiMap.values[i11])) {
                    return;
                }
            }
            this.f38335c = this.f38333a.findEntryByValue(this.f38334b);
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V getKey() {
            return this.f38334b;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public K getValue() {
            a();
            int i11 = this.f38335c;
            return i11 == -1 ? (K) k0.b() : (K) k0.a(this.f38333a.keys[i11]);
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public K setValue(K k11) {
            a();
            int i11 = this.f38335c;
            if (i11 == -1) {
                this.f38333a.putInverse(this.f38334b, k11, false);
                return (K) k0.b();
            }
            K k12 = (K) k0.a(this.f38333a.keys[i11]);
            if (com.google.common.base.j.a(k12, k11)) {
                return k11;
            }
            this.f38333a.replaceKeyInEntry(this.f38335c, k11, false);
            return k12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class c extends g<K, V, Map.Entry<K, V>> {
        public c() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> a(int i11) {
            return new a(i11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int iFindEntryByKey = HashBiMap.this.findEntryByKey(key);
            return iFindEntryByKey != -1 && com.google.common.base.j.a(value, HashBiMap.this.values[iFindEntryByKey]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int iD = c0.d(key);
            int iFindEntryByKey = HashBiMap.this.findEntryByKey(key, iD);
            if (iFindEntryByKey == -1 || !com.google.common.base.j.a(value, HashBiMap.this.values[iFindEntryByKey])) {
                return false;
            }
            HashBiMap.this.removeEntryKeyHashKnown(iFindEntryByKey, iD);
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d<K, V> extends g<K, V, Map.Entry<V, K>> {
        public d(HashBiMap<K, V> hashBiMap) {
            super(hashBiMap);
        }

        @Override // com.google.common.collect.HashBiMap.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<V, K> a(int i11) {
            return new b(this.f38339a, i11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int iFindEntryByValue = this.f38339a.findEntryByValue(key);
            return iFindEntryByValue != -1 && com.google.common.base.j.a(this.f38339a.keys[iFindEntryByValue], value);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int iD = c0.d(key);
            int iFindEntryByValue = this.f38339a.findEntryByValue(key, iD);
            if (iFindEntryByValue == -1 || !com.google.common.base.j.a(this.f38339a.keys[iFindEntryByValue], value)) {
                return false;
            }
            this.f38339a.removeEntryValueHashKnown(iFindEntryByValue, iD);
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class e extends g<K, V, K> {
        public e() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.g
        public K a(int i11) {
            return (K) k0.a(HashBiMap.this.keys[i11]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return HashBiMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int iD = c0.d(obj);
            int iFindEntryByKey = HashBiMap.this.findEntryByKey(obj, iD);
            if (iFindEntryByKey == -1) {
                return false;
            }
            HashBiMap.this.removeEntryKeyHashKnown(iFindEntryByKey, iD);
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class f extends g<K, V, V> {
        public f() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.g
        public V a(int i11) {
            return (V) k0.a(HashBiMap.this.values[i11]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return HashBiMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int iD = c0.d(obj);
            int iFindEntryByValue = HashBiMap.this.findEntryByValue(obj, iD);
            if (iFindEntryByValue == -1) {
                return false;
            }
            HashBiMap.this.removeEntryValueHashKnown(iFindEntryByValue, iD);
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class g<K, V, T> extends AbstractSet<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashBiMap<K, V> f38339a;

        /* JADX INFO: compiled from: source.java */
        public class a implements Iterator<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f38340a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f38341b = -1;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f38342c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f38343d;

            public a() {
                this.f38340a = ((HashBiMap) g.this.f38339a).firstInInsertionOrder;
                HashBiMap<K, V> hashBiMap = g.this.f38339a;
                this.f38342c = hashBiMap.modCount;
                this.f38343d = hashBiMap.size;
            }

            public final void a() {
                if (g.this.f38339a.modCount != this.f38342c) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                return this.f38340a != -2 && this.f38343d > 0;
            }

            @Override // java.util.Iterator
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T t11 = (T) g.this.a(this.f38340a);
                this.f38341b = this.f38340a;
                this.f38340a = ((HashBiMap) g.this.f38339a).nextInInsertionOrder[this.f38340a];
                this.f38343d--;
                return t11;
            }

            @Override // java.util.Iterator
            public void remove() {
                a();
                l.e(this.f38341b != -1);
                g.this.f38339a.removeEntry(this.f38341b);
                int i11 = this.f38340a;
                HashBiMap<K, V> hashBiMap = g.this.f38339a;
                if (i11 == hashBiMap.size) {
                    this.f38340a = this.f38341b;
                }
                this.f38341b = -1;
                this.f38342c = hashBiMap.modCount;
            }
        }

        public g(HashBiMap<K, V> hashBiMap) {
            this.f38339a = hashBiMap;
        }

        public abstract T a(int i11);

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f38339a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<T> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f38339a.size;
        }
    }

    private HashBiMap(int i11) {
        init(i11);
    }

    private int bucket(int i11) {
        return i11 & (this.hashTableKToV.length - 1);
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

    private static int[] createFilledWithAbsent(int i11) {
        int[] iArr = new int[i11];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private void deleteFromTableKToV(int i11, int i12) {
        com.google.common.base.m.d(i11 != -1);
        int iBucket = bucket(i12);
        int[] iArr = this.hashTableKToV;
        int i13 = iArr[iBucket];
        if (i13 == i11) {
            int[] iArr2 = this.nextInBucketKToV;
            iArr[iBucket] = iArr2[i11];
            iArr2[i11] = -1;
            return;
        }
        int i14 = this.nextInBucketKToV[i13];
        while (true) {
            int i15 = i13;
            i13 = i14;
            if (i13 == -1) {
                throw new AssertionError("Expected to find entry with key " + this.keys[i11]);
            }
            if (i13 == i11) {
                int[] iArr3 = this.nextInBucketKToV;
                iArr3[i15] = iArr3[i11];
                iArr3[i11] = -1;
                return;
            }
            i14 = this.nextInBucketKToV[i13];
        }
    }

    private void deleteFromTableVToK(int i11, int i12) {
        com.google.common.base.m.d(i11 != -1);
        int iBucket = bucket(i12);
        int[] iArr = this.hashTableVToK;
        int i13 = iArr[iBucket];
        if (i13 == i11) {
            int[] iArr2 = this.nextInBucketVToK;
            iArr[iBucket] = iArr2[i11];
            iArr2[i11] = -1;
            return;
        }
        int i14 = this.nextInBucketVToK[i13];
        while (true) {
            int i15 = i13;
            i13 = i14;
            if (i13 == -1) {
                throw new AssertionError("Expected to find entry with value " + this.values[i11]);
            }
            if (i13 == i11) {
                int[] iArr3 = this.nextInBucketVToK;
                iArr3[i15] = iArr3[i11];
                iArr3[i11] = -1;
                return;
            }
            i14 = this.nextInBucketVToK[i13];
        }
    }

    private void ensureCapacity(int i11) {
        int[] iArr = this.nextInBucketKToV;
        if (iArr.length < i11) {
            int iE = ImmutableCollection.b.e(iArr.length, i11);
            this.keys = (K[]) Arrays.copyOf(this.keys, iE);
            this.values = (V[]) Arrays.copyOf(this.values, iE);
            this.nextInBucketKToV = expandAndFillWithAbsent(this.nextInBucketKToV, iE);
            this.nextInBucketVToK = expandAndFillWithAbsent(this.nextInBucketVToK, iE);
            this.prevInInsertionOrder = expandAndFillWithAbsent(this.prevInInsertionOrder, iE);
            this.nextInInsertionOrder = expandAndFillWithAbsent(this.nextInInsertionOrder, iE);
        }
        if (this.hashTableKToV.length < i11) {
            int iA = c0.a(i11, 1.0d);
            this.hashTableKToV = createFilledWithAbsent(iA);
            this.hashTableVToK = createFilledWithAbsent(iA);
            for (int i12 = 0; i12 < this.size; i12++) {
                int iBucket = bucket(c0.d(this.keys[i12]));
                int[] iArr2 = this.nextInBucketKToV;
                int[] iArr3 = this.hashTableKToV;
                iArr2[i12] = iArr3[iBucket];
                iArr3[iBucket] = i12;
                int iBucket2 = bucket(c0.d(this.values[i12]));
                int[] iArr4 = this.nextInBucketVToK;
                int[] iArr5 = this.hashTableVToK;
                iArr4[i12] = iArr5[iBucket2];
                iArr5[iBucket2] = i12;
            }
        }
    }

    private static int[] expandAndFillWithAbsent(int[] iArr, int i11) {
        int length = iArr.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, i11);
        Arrays.fill(iArrCopyOf, length, i11, -1);
        return iArrCopyOf;
    }

    private void insertIntoTableKToV(int i11, int i12) {
        com.google.common.base.m.d(i11 != -1);
        int iBucket = bucket(i12);
        int[] iArr = this.nextInBucketKToV;
        int[] iArr2 = this.hashTableKToV;
        iArr[i11] = iArr2[iBucket];
        iArr2[iBucket] = i11;
    }

    private void insertIntoTableVToK(int i11, int i12) {
        com.google.common.base.m.d(i11 != -1);
        int iBucket = bucket(i12);
        int[] iArr = this.nextInBucketVToK;
        int[] iArr2 = this.hashTableVToK;
        iArr[i11] = iArr2[iBucket];
        iArr2[iBucket] = i11;
    }

    private void moveEntryToIndex(int i11, int i12) {
        int i13;
        int i14;
        if (i11 == i12) {
            return;
        }
        int i15 = this.prevInInsertionOrder[i11];
        int i16 = this.nextInInsertionOrder[i11];
        setSucceeds(i15, i12);
        setSucceeds(i12, i16);
        K[] kArr = this.keys;
        K k11 = kArr[i11];
        V[] vArr = this.values;
        V v11 = vArr[i11];
        kArr[i12] = k11;
        vArr[i12] = v11;
        int iBucket = bucket(c0.d(k11));
        int[] iArr = this.hashTableKToV;
        int i17 = iArr[iBucket];
        if (i17 == i11) {
            iArr[iBucket] = i12;
        } else {
            int i18 = this.nextInBucketKToV[i17];
            while (true) {
                i13 = i17;
                i17 = i18;
                if (i17 == i11) {
                    break;
                } else {
                    i18 = this.nextInBucketKToV[i17];
                }
            }
            this.nextInBucketKToV[i13] = i12;
        }
        int[] iArr2 = this.nextInBucketKToV;
        iArr2[i12] = iArr2[i11];
        iArr2[i11] = -1;
        int iBucket2 = bucket(c0.d(v11));
        int[] iArr3 = this.hashTableVToK;
        int i19 = iArr3[iBucket2];
        if (i19 == i11) {
            iArr3[iBucket2] = i12;
        } else {
            int i21 = this.nextInBucketVToK[i19];
            while (true) {
                i14 = i19;
                i19 = i21;
                if (i19 == i11) {
                    break;
                } else {
                    i21 = this.nextInBucketVToK[i19];
                }
            }
            this.nextInBucketVToK[i14] = i12;
        }
        int[] iArr4 = this.nextInBucketVToK;
        iArr4[i12] = iArr4[i11];
        iArr4[i11] = -1;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int iH = u0.h(objectInputStream);
        init(16);
        u0.c(this, objectInputStream, iH);
    }

    private void removeEntry(int i11, int i12, int i13) {
        com.google.common.base.m.d(i11 != -1);
        deleteFromTableKToV(i11, i12);
        deleteFromTableVToK(i11, i13);
        setSucceeds(this.prevInInsertionOrder[i11], this.nextInInsertionOrder[i11]);
        moveEntryToIndex(this.size - 1, i11);
        K[] kArr = this.keys;
        int i14 = this.size;
        kArr[i14 - 1] = null;
        this.values[i14 - 1] = null;
        this.size = i14 - 1;
        this.modCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceKeyInEntry(int i11, K k11, boolean z11) {
        int i12;
        com.google.common.base.m.d(i11 != -1);
        int iD = c0.d(k11);
        int iFindEntryByKey = findEntryByKey(k11, iD);
        int i13 = this.lastInInsertionOrder;
        if (iFindEntryByKey == -1) {
            i12 = -2;
        } else {
            if (!z11) {
                throw new IllegalArgumentException("Key already present in map: " + k11);
            }
            i13 = this.prevInInsertionOrder[iFindEntryByKey];
            i12 = this.nextInInsertionOrder[iFindEntryByKey];
            removeEntryKeyHashKnown(iFindEntryByKey, iD);
            if (i11 == this.size) {
                i11 = iFindEntryByKey;
            }
        }
        if (i13 == i11) {
            i13 = this.prevInInsertionOrder[i11];
        } else if (i13 == this.size) {
            i13 = iFindEntryByKey;
        }
        if (i12 == i11) {
            iFindEntryByKey = this.nextInInsertionOrder[i11];
        } else if (i12 != this.size) {
            iFindEntryByKey = i12;
        }
        setSucceeds(this.prevInInsertionOrder[i11], this.nextInInsertionOrder[i11]);
        deleteFromTableKToV(i11, c0.d(this.keys[i11]));
        this.keys[i11] = k11;
        insertIntoTableKToV(i11, c0.d(k11));
        setSucceeds(i13, i11);
        setSucceeds(i11, iFindEntryByKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceValueInEntry(int i11, V v11, boolean z11) {
        com.google.common.base.m.d(i11 != -1);
        int iD = c0.d(v11);
        int iFindEntryByValue = findEntryByValue(v11, iD);
        if (iFindEntryByValue != -1) {
            if (!z11) {
                throw new IllegalArgumentException("Value already present in map: " + v11);
            }
            removeEntryValueHashKnown(iFindEntryByValue, iD);
            if (i11 == this.size) {
                i11 = iFindEntryByValue;
            }
        }
        deleteFromTableVToK(i11, c0.d(this.values[i11]));
        this.values[i11] = v11;
        insertIntoTableVToK(i11, iD);
    }

    private void setSucceeds(int i11, int i12) {
        if (i11 == -2) {
            this.firstInInsertionOrder = i12;
        } else {
            this.nextInInsertionOrder[i11] = i12;
        }
        if (i12 == -2) {
            this.lastInInsertionOrder = i11;
        } else {
            this.prevInInsertionOrder[i12] = i11;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        u0.i(this, objectOutputStream);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, (Object) null);
        Arrays.fill(this.hashTableKToV, -1);
        Arrays.fill(this.hashTableVToK, -1);
        Arrays.fill(this.nextInBucketKToV, 0, this.size, -1);
        Arrays.fill(this.nextInBucketVToK, 0, this.size, -1);
        Arrays.fill(this.prevInInsertionOrder, 0, this.size, -1);
        Arrays.fill(this.nextInInsertionOrder, 0, this.size, -1);
        this.size = 0;
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.modCount++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return findEntryByKey(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return findEntryByValue(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        c cVar = new c();
        this.entrySet = cVar;
        return cVar;
    }

    public int findEntry(Object obj, int i11, int[] iArr, int[] iArr2, Object[] objArr) {
        int i12 = iArr[bucket(i11)];
        while (i12 != -1) {
            if (com.google.common.base.j.a(objArr[i12], obj)) {
                return i12;
            }
            i12 = iArr2[i12];
        }
        return -1;
    }

    public int findEntryByKey(Object obj) {
        return findEntryByKey(obj, c0.d(obj));
    }

    public int findEntryByKey(Object obj, int i11) {
        return findEntry(obj, i11, this.hashTableKToV, this.nextInBucketKToV, this.keys);
    }

    public int findEntryByValue(Object obj) {
        return findEntryByValue(obj, c0.d(obj));
    }

    public int findEntryByValue(Object obj, int i11) {
        return findEntry(obj, i11, this.hashTableVToK, this.nextInBucketVToK, this.values);
    }

    public V forcePut(K k11, V v11) {
        return put(k11, v11, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        int iFindEntryByKey = findEntryByKey(obj);
        if (iFindEntryByKey == -1) {
            return null;
        }
        return this.values[iFindEntryByKey];
    }

    public K getInverse(Object obj) {
        int iFindEntryByValue = findEntryByValue(obj);
        if (iFindEntryByValue == -1) {
            return null;
        }
        return this.keys[iFindEntryByValue];
    }

    public void init(int i11) {
        l.b(i11, "expectedSize");
        int iA = c0.a(i11, 1.0d);
        this.size = 0;
        this.keys = (K[]) new Object[i11];
        this.values = (V[]) new Object[i11];
        this.hashTableKToV = createFilledWithAbsent(iA);
        this.hashTableVToK = createFilledWithAbsent(iA);
        this.nextInBucketKToV = createFilledWithAbsent(i11);
        this.nextInBucketVToK = createFilledWithAbsent(i11);
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.prevInInsertionOrder = createFilledWithAbsent(i11);
        this.nextInInsertionOrder = createFilledWithAbsent(i11);
    }

    @Override // com.google.common.collect.k
    public k<V, K> inverse() {
        k<V, K> kVar = this.inverse;
        if (kVar != null) {
            return kVar;
        }
        Inverse inverse = new Inverse(this);
        this.inverse = inverse;
        return inverse;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        e eVar = new e();
        this.keySet = eVar;
        return eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k11, V v11) {
        return put(k11, v11, false);
    }

    public V put(K k11, V v11, boolean z11) {
        int iD = c0.d(k11);
        int iFindEntryByKey = findEntryByKey(k11, iD);
        if (iFindEntryByKey != -1) {
            V v12 = this.values[iFindEntryByKey];
            if (com.google.common.base.j.a(v12, v11)) {
                return v11;
            }
            replaceValueInEntry(iFindEntryByKey, v11, z11);
            return v12;
        }
        int iD2 = c0.d(v11);
        int iFindEntryByValue = findEntryByValue(v11, iD2);
        if (!z11) {
            com.google.common.base.m.k(iFindEntryByValue == -1, "Value already present: %s", v11);
        } else if (iFindEntryByValue != -1) {
            removeEntryValueHashKnown(iFindEntryByValue, iD2);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i11 = this.size;
        kArr[i11] = k11;
        this.values[i11] = v11;
        insertIntoTableKToV(i11, iD);
        insertIntoTableVToK(this.size, iD2);
        setSucceeds(this.lastInInsertionOrder, this.size);
        setSucceeds(this.size, -2);
        this.size++;
        this.modCount++;
        return null;
    }

    public K putInverse(V v11, K k11, boolean z11) {
        int iD = c0.d(v11);
        int iFindEntryByValue = findEntryByValue(v11, iD);
        if (iFindEntryByValue != -1) {
            K k12 = this.keys[iFindEntryByValue];
            if (com.google.common.base.j.a(k12, k11)) {
                return k11;
            }
            replaceKeyInEntry(iFindEntryByValue, k11, z11);
            return k12;
        }
        int i11 = this.lastInInsertionOrder;
        int iD2 = c0.d(k11);
        int iFindEntryByKey = findEntryByKey(k11, iD2);
        if (!z11) {
            com.google.common.base.m.k(iFindEntryByKey == -1, "Key already present: %s", k11);
        } else if (iFindEntryByKey != -1) {
            i11 = this.prevInInsertionOrder[iFindEntryByKey];
            removeEntryKeyHashKnown(iFindEntryByKey, iD2);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i12 = this.size;
        kArr[i12] = k11;
        this.values[i12] = v11;
        insertIntoTableKToV(i12, iD2);
        insertIntoTableVToK(this.size, iD);
        int i13 = i11 == -2 ? this.firstInInsertionOrder : this.nextInInsertionOrder[i11];
        setSucceeds(i11, this.size);
        setSucceeds(this.size, i13);
        this.size++;
        this.modCount++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        int iD = c0.d(obj);
        int iFindEntryByKey = findEntryByKey(obj, iD);
        if (iFindEntryByKey == -1) {
            return null;
        }
        V v11 = this.values[iFindEntryByKey];
        removeEntryKeyHashKnown(iFindEntryByKey, iD);
        return v11;
    }

    public void removeEntry(int i11) {
        removeEntryKeyHashKnown(i11, c0.d(this.keys[i11]));
    }

    public void removeEntryKeyHashKnown(int i11, int i12) {
        removeEntry(i11, i12, c0.d(this.values[i11]));
    }

    public void removeEntryValueHashKnown(int i11, int i12) {
        removeEntry(i11, c0.d(this.keys[i11]), i12);
    }

    public K removeInverse(Object obj) {
        int iD = c0.d(obj);
        int iFindEntryByValue = findEntryByValue(obj, iD);
        if (iFindEntryByValue == -1) {
            return null;
        }
        K k11 = this.keys[iFindEntryByValue];
        removeEntryValueHashKnown(iFindEntryByValue, iD);
        return k11;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set != null) {
            return set;
        }
        f fVar = new f();
        this.valueSet = fVar;
        return fVar;
    }
}
