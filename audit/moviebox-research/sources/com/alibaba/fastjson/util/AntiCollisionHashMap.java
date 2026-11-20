package com.alibaba.fastjson.util;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class AntiCollisionHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int KEY = 16777619;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int M_MASK = -2023358765;
    static final int SEED = -2128831035;
    private static final long serialVersionUID = 362498820763181265L;
    private transient Set<Map.Entry<K, V>> entrySet;
    volatile transient Set<K> keySet;
    final float loadFactor;
    volatile transient int modCount;
    final int random;
    transient int size;
    transient b<K, V>[] table;
    int threshold;
    volatile transient Collection<V> values;

    /* JADX INFO: compiled from: source.java */
    public static class b<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f15483a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public V f15484b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b<K, V> f15485c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f15486d;

        public b(int i11, K k11, V v11, b<K, V> bVar) {
            this.f15484b = v11;
            this.f15485c = bVar;
            this.f15483a = k11;
            this.f15486d = i11;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K key = getKey();
            Object key2 = entry.getKey();
            if (key != key2 && (key == null || !key.equals(key2))) {
                return false;
            }
            V value = getValue();
            Object value2 = entry.getValue();
            return value == value2 || (value != null && value.equals(value2));
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.f15483a;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.f15484b;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            K k11 = this.f15483a;
            int iHashCode = k11 == null ? 0 : k11.hashCode();
            V v11 = this.f15484b;
            return iHashCode ^ (v11 != null ? v11.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v11) {
            V v12 = this.f15484b;
            this.f15484b = v11;
            return v12;
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class c extends AntiCollisionHashMap<K, V>.e<Map.Entry<K, V>> {
        public c() {
            super();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            return a();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class d extends AbstractSet<Map.Entry<K, V>> {
        public d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AntiCollisionHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            b<K, V> entry2 = AntiCollisionHashMap.this.getEntry(entry.getKey());
            return entry2 != null && entry2.equals(entry);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return AntiCollisionHashMap.this.newEntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return AntiCollisionHashMap.this.removeMapping(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AntiCollisionHashMap.this.size;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public abstract class e<E> implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b<K, V> f15489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15490b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f15491c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public b<K, V> f15492d;

        public e() {
            b<K, V> bVar;
            this.f15490b = AntiCollisionHashMap.this.modCount;
            if (AntiCollisionHashMap.this.size > 0) {
                b<K, V>[] bVarArr = AntiCollisionHashMap.this.table;
                do {
                    int i11 = this.f15491c;
                    if (i11 >= bVarArr.length) {
                        return;
                    }
                    this.f15491c = i11 + 1;
                    bVar = bVarArr[i11];
                    this.f15489a = bVar;
                } while (bVar == null);
            }
        }

        public final b<K, V> a() {
            b<K, V> bVar;
            if (AntiCollisionHashMap.this.modCount != this.f15490b) {
                throw new ConcurrentModificationException();
            }
            b<K, V> bVar2 = this.f15489a;
            if (bVar2 == null) {
                throw new NoSuchElementException();
            }
            b<K, V> bVar3 = bVar2.f15485c;
            this.f15489a = bVar3;
            if (bVar3 == null) {
                b<K, V>[] bVarArr = AntiCollisionHashMap.this.table;
                do {
                    int i11 = this.f15491c;
                    if (i11 >= bVarArr.length) {
                        break;
                    }
                    this.f15491c = i11 + 1;
                    bVar = bVarArr[i11];
                    this.f15489a = bVar;
                } while (bVar == null);
            }
            this.f15492d = bVar2;
            return bVar2;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f15489a != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f15492d == null) {
                throw new IllegalStateException();
            }
            if (AntiCollisionHashMap.this.modCount != this.f15490b) {
                throw new ConcurrentModificationException();
            }
            K k11 = this.f15492d.f15483a;
            this.f15492d = null;
            AntiCollisionHashMap.this.removeEntryForKey(k11);
            this.f15490b = AntiCollisionHashMap.this.modCount;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class f extends AntiCollisionHashMap<K, V>.e<K> {
        public f() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return a().getKey();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class g extends AbstractSet<K> {
        public g() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AntiCollisionHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return AntiCollisionHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return AntiCollisionHashMap.this.newKeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return AntiCollisionHashMap.this.removeEntryForKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AntiCollisionHashMap.this.size;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class h extends AntiCollisionHashMap<K, V>.e<V> {
        public h() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return a().f15484b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class i extends AbstractCollection<V> {
        public i() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AntiCollisionHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return AntiCollisionHashMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return AntiCollisionHashMap.this.newValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AntiCollisionHashMap.this.size;
        }
    }

    public AntiCollisionHashMap() {
        this.keySet = null;
        this.values = null;
        this.random = new Random().nextInt(99999);
        this.entrySet = null;
        this.loadFactor = 0.75f;
        this.threshold = 12;
        this.table = new b[16];
        init();
    }

    public AntiCollisionHashMap(int i11) {
        this(i11, 0.75f);
    }

    public AntiCollisionHashMap(int i11, float f11) {
        this.keySet = null;
        this.values = null;
        this.random = new Random().nextInt(99999);
        this.entrySet = null;
        if (i11 < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + i11);
        }
        i11 = i11 > 1073741824 ? 1073741824 : i11;
        if (f11 <= 0.0f || Float.isNaN(f11)) {
            throw new IllegalArgumentException("Illegal load factor: " + f11);
        }
        int i12 = 1;
        while (i12 < i11) {
            i12 <<= 1;
        }
        this.loadFactor = f11;
        this.threshold = (int) (i12 * f11);
        this.table = new b[i12];
        init();
    }

    public AntiCollisionHashMap(Map<? extends K, ? extends V> map) {
        this(Math.max(((int) (map.size() / 0.75f)) + 1, 16), 0.75f);
        putAllForCreate(map);
    }

    private boolean containsNullValue() {
        for (b<K, V> bVar : this.table) {
            for (; bVar != null; bVar = bVar.f15485c) {
                if (bVar.f15484b == null) {
                    return true;
                }
            }
        }
        return false;
    }

    private Set<Map.Entry<K, V>> entrySet0() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        d dVar = new d();
        this.entrySet = dVar;
        return dVar;
    }

    private V getForNullKey() {
        for (b<K, V> bVar = this.table[0]; bVar != null; bVar = bVar.f15485c) {
            if (bVar.f15483a == null) {
                return bVar.f15484b;
            }
        }
        return null;
    }

    public static int hash(int i11) {
        int i12 = i11 * i11;
        int i13 = i12 ^ ((i12 >>> 20) ^ (i12 >>> 12));
        return (i13 >>> 4) ^ ((i13 >>> 7) ^ i13);
    }

    private int hashString(String str) {
        int iCharAt = this.random * SEED;
        for (int i11 = 0; i11 < str.length(); i11++) {
            iCharAt = (iCharAt * KEY) ^ str.charAt(i11);
        }
        return ((iCharAt >> 1) ^ iCharAt) & M_MASK;
    }

    public static int indexFor(int i11, int i12) {
        return i11 & (i12 - 1);
    }

    private void putAllForCreate(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            putForCreate(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void putForCreate(K k11, V v11) {
        K k12;
        int iHash = k11 == 0 ? 0 : k11 instanceof String ? hash(hashString((String) k11)) : hash(k11.hashCode());
        int iIndexFor = indexFor(iHash, this.table.length);
        for (b<K, V> bVar = this.table[iIndexFor]; bVar != null; bVar = bVar.f15485c) {
            if (bVar.f15486d == iHash && ((k12 = bVar.f15483a) == k11 || (k11 != 0 && k11.equals(k12)))) {
                bVar.f15484b = v11;
                return;
            }
        }
        createEntry(iHash, k11, v11, iIndexFor);
    }

    private V putForNullKey(V v11) {
        for (b<K, V> bVar = this.table[0]; bVar != null; bVar = bVar.f15485c) {
            if (bVar.f15483a == null) {
                V v12 = bVar.f15484b;
                bVar.f15484b = v11;
                return v12;
            }
        }
        this.modCount++;
        addEntry(0, null, v11, 0);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.table = new b[objectInputStream.readInt()];
        init();
        int i11 = objectInputStream.readInt();
        for (int i12 = 0; i12 < i11; i12++) {
            putForCreate(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Iterator<Map.Entry<K, V>> it = this.size > 0 ? entrySet0().iterator() : null;
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.table.length);
        objectOutputStream.writeInt(this.size);
        if (it != null) {
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                objectOutputStream.writeObject(next.getKey());
                objectOutputStream.writeObject(next.getValue());
            }
        }
    }

    public void addEntry(int i11, K k11, V v11, int i12) {
        b<K, V>[] bVarArr = this.table;
        bVarArr[i12] = new b<>(i11, k11, v11, bVarArr[i12]);
        int i13 = this.size;
        this.size = i13 + 1;
        if (i13 >= this.threshold) {
            resize(this.table.length * 2);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.modCount++;
        b<K, V>[] bVarArr = this.table;
        for (int i11 = 0; i11 < bVarArr.length; i11++) {
            bVarArr[i11] = null;
        }
        this.size = 0;
    }

    @Override // java.util.AbstractMap
    public Object clone() {
        AntiCollisionHashMap antiCollisionHashMap;
        try {
            antiCollisionHashMap = (AntiCollisionHashMap) super.clone();
        } catch (CloneNotSupportedException unused) {
            antiCollisionHashMap = null;
        }
        antiCollisionHashMap.table = new b[this.table.length];
        antiCollisionHashMap.entrySet = null;
        antiCollisionHashMap.modCount = 0;
        antiCollisionHashMap.size = 0;
        antiCollisionHashMap.init();
        antiCollisionHashMap.putAllForCreate(this);
        return antiCollisionHashMap;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return getEntry(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            return containsNullValue();
        }
        for (b<K, V> bVar : this.table) {
            for (; bVar != null; bVar = bVar.f15485c) {
                if (obj.equals(bVar.f15484b)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void createEntry(int i11, K k11, V v11, int i12) {
        b<K, V>[] bVarArr = this.table;
        bVarArr[i12] = new b<>(i11, k11, v11, bVarArr[i12]);
        this.size++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return entrySet0();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        K k11;
        if (obj == null) {
            return getForNullKey();
        }
        int iHash = obj instanceof String ? hash(hashString((String) obj)) : hash(obj.hashCode());
        b<K, V>[] bVarArr = this.table;
        for (b<K, V> bVar = bVarArr[indexFor(iHash, bVarArr.length)]; bVar != null; bVar = bVar.f15485c) {
            if (bVar.f15486d == iHash && ((k11 = bVar.f15483a) == obj || obj.equals(k11))) {
                return bVar.f15484b;
            }
        }
        return null;
    }

    public final b<K, V> getEntry(Object obj) {
        K k11;
        int iHash = obj == null ? 0 : obj instanceof String ? hash(hashString((String) obj)) : hash(obj.hashCode());
        for (b<K, V> bVar = r1[indexFor(iHash, this.table.length)]; bVar != null; bVar = bVar.f15485c) {
            if (bVar.f15486d == iHash && ((k11 = bVar.f15483a) == obj || (obj != null && obj.equals(k11)))) {
                return bVar;
            }
        }
        return null;
    }

    public void init() {
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        g gVar = new g();
        this.keySet = gVar;
        return gVar;
    }

    public Iterator<Map.Entry<K, V>> newEntryIterator() {
        return new c();
    }

    public Iterator<K> newKeyIterator() {
        return new f();
    }

    public Iterator<V> newValueIterator() {
        return new h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k11, V v11) {
        K k12;
        if (k11 == 0) {
            return putForNullKey(v11);
        }
        int iHash = k11 instanceof String ? hash(hashString((String) k11)) : hash(k11.hashCode());
        int iIndexFor = indexFor(iHash, this.table.length);
        for (b<K, V> bVar = this.table[iIndexFor]; bVar != null; bVar = bVar.f15485c) {
            if (bVar.f15486d == iHash && ((k12 = bVar.f15483a) == k11 || k11.equals(k12))) {
                V v12 = bVar.f15484b;
                bVar.f15484b = v11;
                return v12;
            }
        }
        this.modCount++;
        addEntry(iHash, k11, v11, iIndexFor);
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        int size = map.size();
        if (size == 0) {
            return;
        }
        if (size > this.threshold) {
            int i11 = (int) ((size / this.loadFactor) + 1.0f);
            if (i11 > 1073741824) {
                i11 = 1073741824;
            }
            int length = this.table.length;
            while (length < i11) {
                length <<= 1;
            }
            if (length > this.table.length) {
                resize(length);
            }
        }
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        b<K, V> bVarRemoveEntryForKey = removeEntryForKey(obj);
        if (bVarRemoveEntryForKey == null) {
            return null;
        }
        return bVarRemoveEntryForKey.f15484b;
    }

    public final b<K, V> removeEntryForKey(Object obj) {
        int iHash;
        K k11;
        if (obj == null) {
            iHash = 0;
        } else {
            iHash = obj instanceof String ? hash(hashString((String) obj)) : hash(obj.hashCode());
        }
        int iIndexFor = indexFor(iHash, this.table.length);
        b<K, V> bVar = this.table[iIndexFor];
        b<K, V> bVar2 = bVar;
        while (bVar != null) {
            b<K, V> bVar3 = bVar.f15485c;
            if (bVar.f15486d == iHash && ((k11 = bVar.f15483a) == obj || (obj != null && obj.equals(k11)))) {
                this.modCount++;
                this.size--;
                if (bVar2 == bVar) {
                    this.table[iIndexFor] = bVar3;
                } else {
                    bVar2.f15485c = bVar3;
                }
                return bVar;
            }
            bVar2 = bVar;
            bVar = bVar3;
        }
        return bVar;
    }

    public final b<K, V> removeMapping(Object obj) {
        int iHash;
        if (!(obj instanceof Map.Entry)) {
            return null;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        if (key == null) {
            iHash = 0;
        } else {
            iHash = key instanceof String ? hash(hashString((String) key)) : hash(key.hashCode());
        }
        int iIndexFor = indexFor(iHash, this.table.length);
        b<K, V> bVar = this.table[iIndexFor];
        b<K, V> bVar2 = bVar;
        while (bVar != null) {
            b<K, V> bVar3 = bVar.f15485c;
            if (bVar.f15486d == iHash && bVar.equals(entry)) {
                this.modCount++;
                this.size--;
                if (bVar2 == bVar) {
                    this.table[iIndexFor] = bVar3;
                } else {
                    bVar2.f15485c = bVar3;
                }
                return bVar;
            }
            bVar2 = bVar;
            bVar = bVar3;
        }
        return bVar;
    }

    public void resize(int i11) {
        if (this.table.length == 1073741824) {
            this.threshold = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            return;
        }
        b<K, V>[] bVarArr = new b[i11];
        transfer(bVarArr);
        this.table = bVarArr;
        this.threshold = (int) (i11 * this.loadFactor);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public void transfer(b[] bVarArr) {
        b<K, V>[] bVarArr2 = this.table;
        int length = bVarArr.length;
        for (int i11 = 0; i11 < bVarArr2.length; i11++) {
            b<K, V> bVar = bVarArr2[i11];
            if (bVar != null) {
                bVarArr2[i11] = null;
                while (true) {
                    b<K, V> bVar2 = bVar.f15485c;
                    int iIndexFor = indexFor(bVar.f15486d, length);
                    bVar.f15485c = bVarArr[iIndexFor];
                    bVarArr[iIndexFor] = bVar;
                    if (bVar2 == null) {
                        break;
                    } else {
                        bVar = bVar2;
                    }
                }
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        i iVar = new i();
        this.values = iVar;
        return iVar;
    }
}
