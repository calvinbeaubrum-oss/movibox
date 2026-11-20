package com.google.common.collect;

import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final double HASH_FLOODING_FPP = 0.001d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f38267h = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Object f38268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int f38269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient int f38270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient Set<K> f38271d;
    transient int[] entries;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient Set<Map.Entry<K, V>> f38272f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public transient Collection<V> f38273g;
    transient Object[] keys;
    transient Object[] values;

    /* JADX INFO: compiled from: source.java */
    public class a extends CompactHashMap<K, V>.e<K> {
        public a() {
            super(CompactHashMap.this, null);
        }

        @Override // com.google.common.collect.CompactHashMap.e
        public K b(int i11) {
            return (K) CompactHashMap.this.e(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends CompactHashMap<K, V>.e<Map.Entry<K, V>> {
        public b() {
            super(CompactHashMap.this, null);
        }

        @Override // com.google.common.collect.CompactHashMap.e
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> b(int i11) {
            return new g(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends CompactHashMap<K, V>.e<V> {
        public c() {
            super(CompactHashMap.this, null);
        }

        @Override // com.google.common.collect.CompactHashMap.e
        public V b(int i11) {
            return (V) CompactHashMap.this.r(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends AbstractSet<Map.Entry<K, V>> {
        public d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map<K, V> mapDelegateOrNull = CompactHashMap.this.delegateOrNull();
            if (mapDelegateOrNull != null) {
                return mapDelegateOrNull.entrySet().contains(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iD = CompactHashMap.this.d(entry.getKey());
            return iD != -1 && com.google.common.base.j.a(CompactHashMap.this.r(iD), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return CompactHashMap.this.entrySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map<K, V> mapDelegateOrNull = CompactHashMap.this.delegateOrNull();
            if (mapDelegateOrNull != null) {
                return mapDelegateOrNull.entrySet().remove(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (CompactHashMap.this.needsAllocArrays()) {
                return false;
            }
            int iC = CompactHashMap.this.c();
            int iF = n.f(entry.getKey(), entry.getValue(), iC, CompactHashMap.this.i(), CompactHashMap.this.g(), CompactHashMap.this.h(), CompactHashMap.this.j());
            if (iF == -1) {
                return false;
            }
            CompactHashMap.this.moveLastEntry(iF, iC);
            CompactHashMap.access$1210(CompactHashMap.this);
            CompactHashMap.this.incrementModCount();
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public abstract class e<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f38278a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f38279b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f38280c;

        public e() {
            this.f38278a = CompactHashMap.this.f38269b;
            this.f38279b = CompactHashMap.this.firstEntryIndex();
            this.f38280c = -1;
        }

        public /* synthetic */ e(CompactHashMap compactHashMap, a aVar) {
            this();
        }

        public final void a() {
            if (CompactHashMap.this.f38269b != this.f38278a) {
                throw new ConcurrentModificationException();
            }
        }

        public abstract T b(int i11);

        public void c() {
            this.f38278a += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f38279b >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i11 = this.f38279b;
            this.f38280c = i11;
            T tB = b(i11);
            this.f38279b = CompactHashMap.this.getSuccessor(this.f38279b);
            return tB;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            l.e(this.f38280c >= 0);
            c();
            CompactHashMap compactHashMap = CompactHashMap.this;
            compactHashMap.remove(compactHashMap.e(this.f38280c));
            this.f38279b = CompactHashMap.this.adjustAfterRemove(this.f38279b, this.f38280c);
            this.f38280c = -1;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f extends AbstractSet<K> {
        public f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return CompactHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return CompactHashMap.this.keySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map<K, V> mapDelegateOrNull = CompactHashMap.this.delegateOrNull();
            if (mapDelegateOrNull != null) {
                return mapDelegateOrNull.keySet().remove(obj);
            }
            return CompactHashMap.this.f(obj) != CompactHashMap.f38267h;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class g extends com.google.common.collect.b<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f38283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f38284b;

        public g(int i11) {
            this.f38283a = (K) CompactHashMap.this.e(i11);
            this.f38284b = i11;
        }

        public final void a() {
            int i11 = this.f38284b;
            if (i11 == -1 || i11 >= CompactHashMap.this.size() || !com.google.common.base.j.a(this.f38283a, CompactHashMap.this.e(this.f38284b))) {
                this.f38284b = CompactHashMap.this.d(this.f38283a);
            }
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public K getKey() {
            return this.f38283a;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V getValue() {
            Map<K, V> mapDelegateOrNull = CompactHashMap.this.delegateOrNull();
            if (mapDelegateOrNull != null) {
                return (V) k0.a(mapDelegateOrNull.get(this.f38283a));
            }
            a();
            int i11 = this.f38284b;
            return i11 == -1 ? (V) k0.b() : (V) CompactHashMap.this.r(i11);
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V setValue(V v11) {
            Map<K, V> mapDelegateOrNull = CompactHashMap.this.delegateOrNull();
            if (mapDelegateOrNull != null) {
                return (V) k0.a(mapDelegateOrNull.put(this.f38283a, v11));
            }
            a();
            int i11 = this.f38284b;
            if (i11 == -1) {
                CompactHashMap.this.put(this.f38283a, v11);
                return (V) k0.b();
            }
            V v12 = (V) CompactHashMap.this.r(i11);
            CompactHashMap.this.q(this.f38284b, v11);
            return v12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h extends AbstractCollection<V> {
        public h() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return CompactHashMap.this.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    public CompactHashMap() {
        init(3);
    }

    public CompactHashMap(int i11) {
        init(i11);
    }

    public static /* synthetic */ int access$1210(CompactHashMap compactHashMap) {
        int i11 = compactHashMap.f38270c;
        compactHashMap.f38270c = i11 - 1;
        return i11;
    }

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap<>();
    }

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int i11) {
        return new CompactHashMap<>(i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i11 = objectInputStream.readInt();
        if (i11 < 0) {
            throw new InvalidObjectException("Invalid size: " + i11);
        }
        init(i11);
        for (int i12 = 0; i12 < i11; i12++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<Map.Entry<K, V>> itEntrySetIterator = entrySetIterator();
        while (itEntrySetIterator.hasNext()) {
            Map.Entry<K, V> next = itEntrySetIterator.next();
            objectOutputStream.writeObject(next.getKey());
            objectOutputStream.writeObject(next.getValue());
        }
    }

    public final int a(int i11) {
        return g()[i11];
    }

    public void accessEntry(int i11) {
    }

    public int adjustAfterRemove(int i11, int i12) {
        return i11 - 1;
    }

    public int allocArrays() {
        com.google.common.base.m.w(needsAllocArrays(), "Arrays already allocated");
        int i11 = this.f38269b;
        int iJ = n.j(i11);
        this.f38268a = n.a(iJ);
        n(iJ - 1);
        this.entries = new int[i11];
        this.keys = new Object[i11];
        this.values = new Object[i11];
        return i11;
    }

    public final int c() {
        return (1 << (this.f38269b & 31)) - 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        incrementModCount();
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            this.f38269b = Ints.f(size(), 3, 1073741823);
            mapDelegateOrNull.clear();
            this.f38268a = null;
            this.f38270c = 0;
            return;
        }
        Arrays.fill(h(), 0, this.f38270c, (Object) null);
        Arrays.fill(j(), 0, this.f38270c, (Object) null);
        n.g(i());
        Arrays.fill(g(), 0, this.f38270c, 0);
        this.f38270c = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.containsKey(obj);
        }
        return d(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.containsValue(obj);
        }
        for (int i11 = 0; i11 < this.f38270c; i11++) {
            if (com.google.common.base.j.a(obj, r(i11))) {
                return true;
            }
        }
        return false;
    }

    public Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> mapCreateHashFloodingResistantDelegate = createHashFloodingResistantDelegate(c() + 1);
        int iFirstEntryIndex = firstEntryIndex();
        while (iFirstEntryIndex >= 0) {
            mapCreateHashFloodingResistantDelegate.put(e(iFirstEntryIndex), r(iFirstEntryIndex));
            iFirstEntryIndex = getSuccessor(iFirstEntryIndex);
        }
        this.f38268a = mapCreateHashFloodingResistantDelegate;
        this.entries = null;
        this.keys = null;
        this.values = null;
        incrementModCount();
        return mapCreateHashFloodingResistantDelegate;
    }

    public Set<Map.Entry<K, V>> createEntrySet() {
        return new d();
    }

    public Map<K, V> createHashFloodingResistantDelegate(int i11) {
        return new LinkedHashMap(i11, 1.0f);
    }

    public Set<K> createKeySet() {
        return new f();
    }

    public Collection<V> createValues() {
        return new h();
    }

    public final int d(Object obj) {
        if (needsAllocArrays()) {
            return -1;
        }
        int iD = c0.d(obj);
        int iC = c();
        int iH = n.h(i(), iD & iC);
        if (iH == 0) {
            return -1;
        }
        int iB = n.b(iD, iC);
        do {
            int i11 = iH - 1;
            int iA = a(i11);
            if (n.b(iA, iC) == iB && com.google.common.base.j.a(obj, e(i11))) {
                return i11;
            }
            iH = n.c(iA, iC);
        } while (iH != 0);
        return -1;
    }

    public Map<K, V> delegateOrNull() {
        Object obj = this.f38268a;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final K e(int i11) {
        return (K) h()[i11];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f38272f;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> setCreateEntrySet = createEntrySet();
        this.f38272f = setCreateEntrySet;
        return setCreateEntrySet;
    }

    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        return mapDelegateOrNull != null ? mapDelegateOrNull.entrySet().iterator() : new b();
    }

    public final Object f(Object obj) {
        if (needsAllocArrays()) {
            return f38267h;
        }
        int iC = c();
        int iF = n.f(obj, null, iC, i(), g(), h(), null);
        if (iF == -1) {
            return f38267h;
        }
        V vR = r(iF);
        moveLastEntry(iF, iC);
        this.f38270c--;
        incrementModCount();
        return vR;
    }

    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    public final int[] g() {
        int[] iArr = this.entries;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.get(obj);
        }
        int iD = d(obj);
        if (iD == -1) {
            return null;
        }
        accessEntry(iD);
        return r(iD);
    }

    public int getSuccessor(int i11) {
        int i12 = i11 + 1;
        if (i12 < this.f38270c) {
            return i12;
        }
        return -1;
    }

    public final Object[] h() {
        Object[] objArr = this.keys;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public final Object i() {
        Object obj = this.f38268a;
        Objects.requireNonNull(obj);
        return obj;
    }

    public void incrementModCount() {
        this.f38269b += 32;
    }

    public void init(int i11) {
        com.google.common.base.m.e(i11 >= 0, "Expected size must be >= 0");
        this.f38269b = Ints.f(i11, 1, 1073741823);
    }

    public void insertEntry(int i11, K k11, V v11, int i12, int i13) {
        m(i11, n.d(i12, 0, i13));
        p(i11, k11);
        q(i11, v11);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public final Object[] j() {
        Object[] objArr = this.values;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public final void k(int i11) {
        int iMin;
        int length = g().length;
        if (i11 <= length || (iMin = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        resizeEntries(iMin);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f38271d;
        if (set != null) {
            return set;
        }
        Set<K> setCreateKeySet = createKeySet();
        this.f38271d = setCreateKeySet;
        return setCreateKeySet;
    }

    public Iterator<K> keySetIterator() {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        return mapDelegateOrNull != null ? mapDelegateOrNull.keySet().iterator() : new a();
    }

    public final int l(int i11, int i12, int i13, int i14) {
        Object objA = n.a(i12);
        int i15 = i12 - 1;
        if (i14 != 0) {
            n.i(objA, i13 & i15, i14 + 1);
        }
        Object objI = i();
        int[] iArrG = g();
        for (int i16 = 0; i16 <= i11; i16++) {
            int iH = n.h(objI, i16);
            while (iH != 0) {
                int i17 = iH - 1;
                int i18 = iArrG[i17];
                int iB = n.b(i18, i11) | i16;
                int i19 = iB & i15;
                int iH2 = n.h(objA, i19);
                n.i(objA, i19, iH);
                iArrG[i17] = n.d(iB, iH2, i15);
                iH = n.c(i18, i11);
            }
        }
        this.f38268a = objA;
        n(i15);
        return i15;
    }

    public final void m(int i11, int i12) {
        g()[i11] = i12;
    }

    public void moveLastEntry(int i11, int i12) {
        Object objI = i();
        int[] iArrG = g();
        Object[] objArrH = h();
        Object[] objArrJ = j();
        int size = size();
        int i13 = size - 1;
        if (i11 >= i13) {
            objArrH[i11] = null;
            objArrJ[i11] = null;
            iArrG[i11] = 0;
            return;
        }
        Object obj = objArrH[i13];
        objArrH[i11] = obj;
        objArrJ[i11] = objArrJ[i13];
        objArrH[i13] = null;
        objArrJ[i13] = null;
        iArrG[i11] = iArrG[i13];
        iArrG[i13] = 0;
        int iD = c0.d(obj) & i12;
        int iH = n.h(objI, iD);
        if (iH == size) {
            n.i(objI, iD, i11 + 1);
            return;
        }
        while (true) {
            int i14 = iH - 1;
            int i15 = iArrG[i14];
            int iC = n.c(i15, i12);
            if (iC == size) {
                iArrG[i14] = n.d(i15, i11 + 1, i12);
                return;
            }
            iH = iC;
        }
    }

    public final void n(int i11) {
        this.f38269b = n.d(this.f38269b, 32 - Integer.numberOfLeadingZeros(i11), 31);
    }

    public boolean needsAllocArrays() {
        return this.f38268a == null;
    }

    public final void p(int i11, K k11) {
        h()[i11] = k11;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k11, V v11) {
        int iL;
        int i11;
        if (needsAllocArrays()) {
            allocArrays();
        }
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.put(k11, v11);
        }
        int[] iArrG = g();
        Object[] objArrH = h();
        Object[] objArrJ = j();
        int i12 = this.f38270c;
        int i13 = i12 + 1;
        int iD = c0.d(k11);
        int iC = c();
        int i14 = iD & iC;
        int iH = n.h(i(), i14);
        if (iH != 0) {
            int iB = n.b(iD, iC);
            int i15 = 0;
            while (true) {
                int i16 = iH - 1;
                int i17 = iArrG[i16];
                if (n.b(i17, iC) == iB && com.google.common.base.j.a(k11, objArrH[i16])) {
                    V v12 = (V) objArrJ[i16];
                    objArrJ[i16] = v11;
                    accessEntry(i16);
                    return v12;
                }
                int iC2 = n.c(i17, iC);
                i15++;
                if (iC2 != 0) {
                    iH = iC2;
                } else {
                    if (i15 >= 9) {
                        return convertToHashFloodingResistantImplementation().put(k11, v11);
                    }
                    if (i13 > iC) {
                        iL = l(iC, n.e(iC), iD, i12);
                        i11 = iL;
                    } else {
                        iArrG[i16] = n.d(i17, i13, iC);
                        i11 = iC;
                    }
                }
            }
        } else if (i13 > iC) {
            iL = l(iC, n.e(iC), iD, i12);
            i11 = iL;
        } else {
            n.i(i(), i14, i13);
            i11 = iC;
        }
        k(i13);
        insertEntry(i12, k11, v11, iD, i11);
        this.f38270c = i13;
        incrementModCount();
        return null;
    }

    public final void q(int i11, V v11) {
        j()[i11] = v11;
    }

    public final V r(int i11) {
        return (V) j()[i11];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.remove(obj);
        }
        V v11 = (V) f(obj);
        if (v11 == f38267h) {
            return null;
        }
        return v11;
    }

    public void resizeEntries(int i11) {
        this.entries = Arrays.copyOf(g(), i11);
        this.keys = Arrays.copyOf(h(), i11);
        this.values = Arrays.copyOf(j(), i11);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        return mapDelegateOrNull != null ? mapDelegateOrNull.size() : this.f38270c;
    }

    public void trimToSize() {
        if (needsAllocArrays()) {
            return;
        }
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            Map<K, V> mapCreateHashFloodingResistantDelegate = createHashFloodingResistantDelegate(size());
            mapCreateHashFloodingResistantDelegate.putAll(mapDelegateOrNull);
            this.f38268a = mapCreateHashFloodingResistantDelegate;
            return;
        }
        int i11 = this.f38270c;
        if (i11 < g().length) {
            resizeEntries(i11);
        }
        int iJ = n.j(i11);
        int iC = c();
        if (iJ < iC) {
            l(iC, iJ, 0, 0);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.f38273g;
        if (collection != null) {
            return collection;
        }
        Collection<V> collectionCreateValues = createValues();
        this.f38273g = collectionCreateValues;
        return collectionCreateValues;
    }

    public Iterator<V> valuesIterator() {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        return mapDelegateOrNull != null ? mapDelegateOrNull.values().iterator() : new c();
    }
}
