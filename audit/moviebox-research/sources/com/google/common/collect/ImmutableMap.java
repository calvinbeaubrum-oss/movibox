package com.google.common.collect;

import com.google.j2objc.annotations.RetainedWith;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {
    static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Map.Entry[0];

    @RetainedWith
    private transient ImmutableSet<Map.Entry<K, V>> entrySet;

    @RetainedWith
    private transient ImmutableSet<K> keySet;
    private transient ImmutableSetMultimap<K, V> multimapView;

    @RetainedWith
    private transient ImmutableCollection<V> values;

    /* JADX INFO: compiled from: source.java */
    public static abstract class IteratorBasedImmutableMap<K, V> extends ImmutableMap<K, V> {
        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
            return new ImmutableMapEntrySet<K, V>() { // from class: com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap.1EntrySetImpl
                @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
                public g1<Map.Entry<K, V>> iterator() {
                    return IteratorBasedImmutableMap.this.entryIterator();
                }

                @Override // com.google.common.collect.ImmutableMapEntrySet
                public ImmutableMap<K, V> map() {
                    return IteratorBasedImmutableMap.this;
                }
            };
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            return new ImmutableMapKeySet(this);
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableCollection<V> createValues() {
            return new ImmutableMapValues(this);
        }

        public abstract g1<Map.Entry<K, V>> entryIterator();

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set entrySet() {
            return super.entrySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return super.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class MapViewOfValuesAsSingletonSets extends IteratorBasedImmutableMap<K, ImmutableSet<V>> {

        /* JADX INFO: compiled from: source.java */
        public class a extends g1<Map.Entry<K, ImmutableSet<V>>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Iterator f38351a;

            /* JADX INFO: renamed from: com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            public class C0392a extends com.google.common.collect.b<K, ImmutableSet<V>> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Map.Entry f38352a;

                public C0392a(a aVar, Map.Entry entry) {
                    this.f38352a = entry;
                }

                @Override // com.google.common.collect.b, java.util.Map.Entry
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public ImmutableSet<V> getValue() {
                    return ImmutableSet.of(this.f38352a.getValue());
                }

                @Override // com.google.common.collect.b, java.util.Map.Entry
                public K getKey() {
                    return (K) this.f38352a.getKey();
                }
            }

            public a(MapViewOfValuesAsSingletonSets mapViewOfValuesAsSingletonSets, Iterator it) {
                this.f38351a = it;
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, ImmutableSet<V>> next() {
                return new C0392a(this, (Map.Entry) this.f38351a.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f38351a.hasNext();
            }
        }

        public MapViewOfValuesAsSingletonSets() {
        }

        public /* synthetic */ MapViewOfValuesAsSingletonSets(ImmutableMap immutableMap, a aVar) {
            this();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public boolean containsKey(Object obj) {
            return ImmutableMap.this.containsKey(obj);
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            return ImmutableMap.this.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        public g1<Map.Entry<K, ImmutableSet<V>>> entryIterator() {
            return new a(this, ImmutableMap.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public ImmutableSet<V> get(Object obj) {
            Object obj2 = ImmutableMap.this.get(obj);
            if (obj2 == null) {
                return null;
            }
            return ImmutableSet.of(obj2);
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public int hashCode() {
            return ImmutableMap.this.hashCode();
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isHashCodeFast() {
            return ImmutableMap.this.isHashCodeFast();
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return ImmutableMap.this.isPartialView();
        }

        @Override // java.util.Map
        public int size() {
            return ImmutableMap.this.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class SerializedForm<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Object keys;
        private final Object values;

        public SerializedForm(ImmutableMap<K, V> immutableMap) {
            Object[] objArr = new Object[immutableMap.size()];
            Object[] objArr2 = new Object[immutableMap.size()];
            g1<Map.Entry<K, V>> it = immutableMap.entrySet().iterator();
            int i11 = 0;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                objArr[i11] = next.getKey();
                objArr2[i11] = next.getValue();
                i11++;
            }
            this.keys = objArr;
            this.values = objArr2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Object legacyReadResolve() {
            Object[] objArr = (Object[]) this.keys;
            Object[] objArr2 = (Object[]) this.values;
            b<K, V> bVarMakeBuilder = makeBuilder(objArr.length);
            for (int i11 = 0; i11 < objArr.length; i11++) {
                bVarMakeBuilder.g(objArr[i11], objArr2[i11]);
            }
            return bVarMakeBuilder.d();
        }

        public b<K, V> makeBuilder(int i11) {
            return new b<>(i11);
        }

        public final Object readResolve() {
            Object obj = this.keys;
            if (!(obj instanceof ImmutableSet)) {
                return legacyReadResolve();
            }
            ImmutableSet immutableSet = (ImmutableSet) obj;
            ImmutableCollection immutableCollection = (ImmutableCollection) this.values;
            b<K, V> bVarMakeBuilder = makeBuilder(immutableSet.size());
            g1 it = immutableSet.iterator();
            g1 it2 = immutableCollection.iterator();
            while (it.hasNext()) {
                bVarMakeBuilder.g(it.next(), it2.next());
            }
            return bVarMakeBuilder.d();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends g1<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g1 f38353a;

        public a(ImmutableMap immutableMap, g1 g1Var) {
            this.f38353a = g1Var;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f38353a.hasNext();
        }

        @Override // java.util.Iterator
        public K next() {
            return (K) ((Map.Entry) this.f38353a.next()).getKey();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Comparator<? super V> f38354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object[] f38355b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f38356c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f38357d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public a f38358e;

        /* JADX INFO: compiled from: source.java */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Object f38359a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Object f38360b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Object f38361c;

            public a(Object obj, Object obj2, Object obj3) {
                this.f38359a = obj;
                this.f38360b = obj2;
                this.f38361c = obj3;
            }

            public IllegalArgumentException a() {
                return new IllegalArgumentException("Multiple entries with same key: " + this.f38359a + "=" + this.f38360b + " and " + this.f38359a + "=" + this.f38361c);
            }
        }

        public b() {
            this(4);
        }

        public b(int i11) {
            this.f38355b = new Object[i11 * 2];
            this.f38356c = 0;
            this.f38357d = false;
        }

        private void e(int i11) {
            int i12 = i11 * 2;
            Object[] objArr = this.f38355b;
            if (i12 > objArr.length) {
                this.f38355b = Arrays.copyOf(objArr, ImmutableCollection.b.e(objArr.length, i12));
                this.f38357d = false;
            }
        }

        public static <V> void k(Object[] objArr, int i11, Comparator<? super V> comparator) {
            Map.Entry[] entryArr = new Map.Entry[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                int i13 = i12 * 2;
                Object obj = objArr[i13];
                Objects.requireNonNull(obj);
                Object obj2 = objArr[i13 + 1];
                Objects.requireNonNull(obj2);
                entryArr[i12] = new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
            Arrays.sort(entryArr, 0, i11, Ordering.from(comparator).onResultOf(Maps.C()));
            for (int i14 = 0; i14 < i11; i14++) {
                int i15 = i14 * 2;
                objArr[i15] = entryArr[i14].getKey();
                objArr[i15 + 1] = entryArr[i14].getValue();
            }
        }

        public ImmutableMap<K, V> a() {
            return d();
        }

        public final ImmutableMap<K, V> b(boolean z11) {
            Object[] objArrF;
            a aVar;
            a aVar2;
            if (z11 && (aVar2 = this.f38358e) != null) {
                throw aVar2.a();
            }
            int length = this.f38356c;
            if (this.f38354a == null) {
                objArrF = this.f38355b;
            } else {
                if (this.f38357d) {
                    this.f38355b = Arrays.copyOf(this.f38355b, length * 2);
                }
                objArrF = this.f38355b;
                if (!z11) {
                    objArrF = f(objArrF, this.f38356c);
                    if (objArrF.length < this.f38355b.length) {
                        length = objArrF.length >>> 1;
                    }
                }
                k(objArrF, length, this.f38354a);
            }
            this.f38357d = true;
            RegularImmutableMap regularImmutableMapCreate = RegularImmutableMap.create(length, objArrF, this);
            if (!z11 || (aVar = this.f38358e) == null) {
                return regularImmutableMapCreate;
            }
            throw aVar.a();
        }

        public ImmutableMap<K, V> c() {
            return b(false);
        }

        public ImmutableMap<K, V> d() {
            return b(true);
        }

        public final Object[] f(Object[] objArr, int i11) {
            HashSet hashSet = new HashSet();
            BitSet bitSet = new BitSet();
            for (int i12 = i11 - 1; i12 >= 0; i12--) {
                Object obj = objArr[i12 * 2];
                Objects.requireNonNull(obj);
                if (!hashSet.add(obj)) {
                    bitSet.set(i12);
                }
            }
            if (bitSet.isEmpty()) {
                return objArr;
            }
            Object[] objArr2 = new Object[(i11 - bitSet.cardinality()) * 2];
            int i13 = 0;
            int i14 = 0;
            while (i13 < i11 * 2) {
                if (bitSet.get(i13 >>> 1)) {
                    i13 += 2;
                } else {
                    int i15 = i14 + 1;
                    int i16 = i13 + 1;
                    Object obj2 = objArr[i13];
                    Objects.requireNonNull(obj2);
                    objArr2[i14] = obj2;
                    i14 += 2;
                    i13 += 2;
                    Object obj3 = objArr[i16];
                    Objects.requireNonNull(obj3);
                    objArr2[i15] = obj3;
                }
            }
            return objArr2;
        }

        public b<K, V> g(K k11, V v11) {
            e(this.f38356c + 1);
            l.a(k11, v11);
            Object[] objArr = this.f38355b;
            int i11 = this.f38356c;
            objArr[i11 * 2] = k11;
            objArr[(i11 * 2) + 1] = v11;
            this.f38356c = i11 + 1;
            return this;
        }

        public b<K, V> h(Map.Entry<? extends K, ? extends V> entry) {
            return g(entry.getKey(), entry.getValue());
        }

        public b<K, V> i(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                e(this.f38356c + ((Collection) iterable).size());
            }
            Iterator<? extends Map.Entry<? extends K, ? extends V>> it = iterable.iterator();
            while (it.hasNext()) {
                h(it.next());
            }
            return this;
        }

        public b<K, V> j(Map<? extends K, ? extends V> map) {
            return i(map.entrySet());
        }
    }

    public static <K, V> b<K, V> builder() {
        return new b<>();
    }

    public static <K, V> b<K, V> builderWithExpectedSize(int i11) {
        l.b(i11, "expectedSize");
        return new b<>(i11);
    }

    public static void checkNoConflict(boolean z11, String str, Object obj, Object obj2) {
        if (!z11) {
            throw conflictException(str, obj, obj2);
        }
    }

    public static IllegalArgumentException conflictException(String str, Object obj, Object obj2) {
        return new IllegalArgumentException("Multiple entries with same " + str + ": " + obj + " and " + obj2);
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        b bVar = new b(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        bVar.i(iterable);
        return bVar.a();
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap) && !(map instanceof SortedMap)) {
            ImmutableMap<K, V> immutableMap = (ImmutableMap) map;
            if (!immutableMap.isPartialView()) {
                return immutableMap;
            }
        }
        return copyOf(map.entrySet());
    }

    public static <K, V> Map.Entry<K, V> entryOf(K k11, V v11) {
        l.a(k11, v11);
        return new AbstractMap.SimpleImmutableEntry(k11, v11);
    }

    public static <K, V> ImmutableMap<K, V> of() {
        return (ImmutableMap<K, V>) RegularImmutableMap.EMPTY;
    }

    public static <K, V> ImmutableMap<K, V> of(K k11, V v11) {
        l.a(k11, v11);
        return RegularImmutableMap.create(1, new Object[]{k11, v11});
    }

    public static <K, V> ImmutableMap<K, V> of(K k11, V v11, K k12, V v12) {
        l.a(k11, v11);
        l.a(k12, v12);
        return RegularImmutableMap.create(2, new Object[]{k11, v11, k12, v12});
    }

    public static <K, V> ImmutableMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13) {
        l.a(k11, v11);
        l.a(k12, v12);
        l.a(k13, v13);
        return RegularImmutableMap.create(3, new Object[]{k11, v11, k12, v12, k13, v13});
    }

    public static <K, V> ImmutableMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        l.a(k11, v11);
        l.a(k12, v12);
        l.a(k13, v13);
        l.a(k14, v14);
        return RegularImmutableMap.create(4, new Object[]{k11, v11, k12, v12, k13, v13, k14, v14});
    }

    public static <K, V> ImmutableMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15) {
        l.a(k11, v11);
        l.a(k12, v12);
        l.a(k13, v13);
        l.a(k14, v14);
        l.a(k15, v15);
        return RegularImmutableMap.create(5, new Object[]{k11, v11, k12, v12, k13, v13, k14, v14, k15, v15});
    }

    public static <K, V> ImmutableMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16) {
        l.a(k11, v11);
        l.a(k12, v12);
        l.a(k13, v13);
        l.a(k14, v14);
        l.a(k15, v15);
        l.a(k16, v16);
        return RegularImmutableMap.create(6, new Object[]{k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16});
    }

    public static <K, V> ImmutableMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16, K k17, V v17) {
        l.a(k11, v11);
        l.a(k12, v12);
        l.a(k13, v13);
        l.a(k14, v14);
        l.a(k15, v15);
        l.a(k16, v16);
        l.a(k17, v17);
        return RegularImmutableMap.create(7, new Object[]{k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16, k17, v17});
    }

    public static <K, V> ImmutableMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16, K k17, V v17, K k18, V v18) {
        l.a(k11, v11);
        l.a(k12, v12);
        l.a(k13, v13);
        l.a(k14, v14);
        l.a(k15, v15);
        l.a(k16, v16);
        l.a(k17, v17);
        l.a(k18, v18);
        return RegularImmutableMap.create(8, new Object[]{k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16, k17, v17, k18, v18});
    }

    public static <K, V> ImmutableMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16, K k17, V v17, K k18, V v18, K k19, V v19) {
        l.a(k11, v11);
        l.a(k12, v12);
        l.a(k13, v13);
        l.a(k14, v14);
        l.a(k15, v15);
        l.a(k16, v16);
        l.a(k17, v17);
        l.a(k18, v18);
        l.a(k19, v19);
        return RegularImmutableMap.create(9, new Object[]{k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16, k17, v17, k18, v18, k19, v19});
    }

    public static <K, V> ImmutableMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16, K k17, V v17, K k18, V v18, K k19, V v19, K k21, V v21) {
        l.a(k11, v11);
        l.a(k12, v12);
        l.a(k13, v13);
        l.a(k14, v14);
        l.a(k15, v15);
        l.a(k16, v16);
        l.a(k17, v17);
        l.a(k18, v18);
        l.a(k19, v19);
        l.a(k21, v21);
        return RegularImmutableMap.create(10, new Object[]{k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16, k17, v17, k18, v18, k19, v19, k21, v21});
    }

    @SafeVarargs
    public static <K, V> ImmutableMap<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... entryArr) {
        return copyOf(Arrays.asList(entryArr));
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public ImmutableSetMultimap<K, V> asMultimap() {
        if (isEmpty()) {
            return ImmutableSetMultimap.of();
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap = this.multimapView;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap2 = new ImmutableSetMultimap<>(new MapViewOfValuesAsSingletonSets(this, null), size(), null);
        this.multimapView = immutableSetMultimap2;
        return immutableSetMultimap2;
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public abstract ImmutableSet<Map.Entry<K, V>> createEntrySet();

    public abstract ImmutableSet<K> createKeySet();

    public abstract ImmutableCollection<V> createValues();

    @Override // java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<Map.Entry<K, V>> immutableSetCreateEntrySet = createEntrySet();
        this.entrySet = immutableSetCreateEntrySet;
        return immutableSetCreateEntrySet;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return Maps.h(this, obj);
    }

    @Override // java.util.Map
    public abstract V get(Object obj);

    @Override // java.util.Map
    public final V getOrDefault(Object obj, V v11) {
        V v12 = get(obj);
        return v12 != null ? v12 : v11;
    }

    @Override // java.util.Map
    public int hashCode() {
        return Sets.d(entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isHashCodeFast() {
        return false;
    }

    public abstract boolean isPartialView();

    public g1<K> keyIterator() {
        return new a(this, entrySet().iterator());
    }

    @Override // java.util.Map
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> immutableSet = this.keySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<K> immutableSetCreateKeySet = createKeySet();
        this.keySet = immutableSetCreateKeySet;
        return immutableSetCreateKeySet;
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K k11, V v11) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return Maps.x(this);
    }

    @Override // java.util.Map
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.values;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        ImmutableCollection<V> immutableCollectionCreateValues = createValues();
        this.values = immutableCollectionCreateValues;
        return immutableCollectionCreateValues;
    }

    public Object writeReplace() {
        return new SerializedForm(this);
    }
}
