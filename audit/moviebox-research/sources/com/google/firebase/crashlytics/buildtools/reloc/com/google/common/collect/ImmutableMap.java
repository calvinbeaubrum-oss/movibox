package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {
    static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Map.Entry[0];
    private transient ImmutableSet<Map.Entry<K, V>> entrySet;
    private transient ImmutableSet<K> keySet;
    private transient ImmutableSetMultimap<K, V> multimapView;
    private transient ImmutableCollection<V> values;

    /* JADX INFO: compiled from: source.java */
    public static abstract class IteratorBasedImmutableMap<K, V> extends ImmutableMap<K, V> {
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
        public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
            return new ImmutableMapEntrySet<K, V>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap.1EntrySetImpl
                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
                public t7<Map.Entry<K, V>> iterator() {
                    return IteratorBasedImmutableMap.this.entryIterator();
                }

                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMapEntrySet
                public ImmutableMap<K, V> map() {
                    return IteratorBasedImmutableMap.this;
                }
            };
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            return new ImmutableMapKeySet(this);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
        public ImmutableCollection<V> createValues() {
            return new ImmutableMapValues(this);
        }

        public abstract t7<Map.Entry<K, V>> entryIterator();

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set entrySet() {
            return super.entrySet();
        }

        public Spliterator<Map.Entry<K, V>> entrySpliterator() {
            return Spliterators.spliterator(entryIterator(), size(), 1297);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return super.keySet();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class MapViewOfValuesAsSingletonSets extends IteratorBasedImmutableMap<K, ImmutableSet<V>> {

        /* JADX INFO: compiled from: source.java */
        public class a extends t7<Map.Entry<K, ImmutableSet<V>>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Iterator f39333a;

            /* JADX INFO: renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            public class C0410a extends q<K, ImmutableSet<V>> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Map.Entry f39335a;

                public C0410a(Map.Entry entry) {
                    this.f39335a = entry;
                }

                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q, java.util.Map.Entry
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public ImmutableSet<V> getValue() {
                    return ImmutableSet.of(this.f39335a.getValue());
                }

                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q, java.util.Map.Entry
                public K getKey() {
                    return (K) this.f39335a.getKey();
                }
            }

            public a(Iterator it) {
                this.f39333a = it;
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, ImmutableSet<V>> next() {
                return new C0410a((Map.Entry) this.f39333a.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f39333a.hasNext();
            }
        }

        public MapViewOfValuesAsSingletonSets() {
        }

        public /* synthetic */ MapViewOfValuesAsSingletonSets(ImmutableMap immutableMap, a aVar) {
            this();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap, java.util.Map
        public boolean containsKey(Object obj) {
            return ImmutableMap.this.containsKey(obj);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            return ImmutableMap.this.keySet();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        public t7<Map.Entry<K, ImmutableSet<V>>> entryIterator() {
            return new a(ImmutableMap.this.entrySet().iterator());
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap, java.util.Map
        public ImmutableSet<V> get(Object obj) {
            Object obj2 = ImmutableMap.this.get(obj);
            if (obj2 == null) {
                return null;
            }
            return ImmutableSet.of(obj2);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap, java.util.Map
        public int hashCode() {
            return ImmutableMap.this.hashCode();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
        public boolean isHashCodeFast() {
            return ImmutableMap.this.isHashCodeFast();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return ImmutableMap.this.isPartialView();
        }

        @Override // java.util.Map
        public int size() {
            return ImmutableMap.this.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final Object[] keys;
        private final Object[] values;

        public SerializedForm(ImmutableMap<?, ?> immutableMap) {
            this.keys = new Object[immutableMap.size()];
            this.values = new Object[immutableMap.size()];
            t7<Map.Entry<?, ?>> it = immutableMap.entrySet().iterator();
            int i11 = 0;
            while (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                this.keys[i11] = next.getKey();
                this.values[i11] = next.getValue();
                i11++;
            }
        }

        public Object createMap(b<Object, Object> bVar) {
            int i11 = 0;
            while (true) {
                Object[] objArr = this.keys;
                if (i11 >= objArr.length) {
                    return bVar.a();
                }
                bVar.d(objArr[i11], this.values[i11]);
                i11++;
            }
        }

        public Object readResolve() {
            return createMap(new b<>(this.keys.length));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends t7<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t7 f39337a;

        public a(t7 t7Var) {
            this.f39337a = t7Var;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f39337a.hasNext();
        }

        @Override // java.util.Iterator
        public K next() {
            return (K) ((Map.Entry) this.f39337a.next()).getKey();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Comparator<? super V> f39339a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map.Entry<K, V>[] f39340b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f39341c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f39342d;

        public b() {
            this(4);
        }

        public b(int i11) {
            this.f39340b = new Map.Entry[i11];
            this.f39341c = 0;
            this.f39342d = false;
        }

        public ImmutableMap<K, V> a() {
            if (this.f39339a != null) {
                if (this.f39342d) {
                    this.f39340b = (Map.Entry[]) Arrays.copyOf(this.f39340b, this.f39341c);
                }
                Arrays.sort(this.f39340b, 0, this.f39341c, Ordering.from(this.f39339a).onResultOf(Maps.x()));
            }
            int i11 = this.f39341c;
            if (i11 == 0) {
                return ImmutableMap.of();
            }
            if (i11 == 1) {
                return ImmutableMap.of((Object) this.f39340b[0].getKey(), (Object) this.f39340b[0].getValue());
            }
            this.f39342d = true;
            return RegularImmutableMap.fromEntryArray(i11, this.f39340b);
        }

        public b<K, V> b(b<K, V> bVar) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(bVar);
            c(this.f39341c + bVar.f39341c);
            System.arraycopy(bVar.f39340b, 0, this.f39340b, this.f39341c, bVar.f39341c);
            this.f39341c += bVar.f39341c;
            return this;
        }

        public final void c(int i11) {
            Map.Entry<K, V>[] entryArr = this.f39340b;
            if (i11 > entryArr.length) {
                this.f39340b = (Map.Entry[]) Arrays.copyOf(entryArr, ImmutableCollection.a.d(entryArr.length, i11));
                this.f39342d = false;
            }
        }

        public b<K, V> d(K k11, V v11) {
            c(this.f39341c + 1);
            Map.Entry<K, V> entryEntryOf = ImmutableMap.entryOf(k11, v11);
            Map.Entry<K, V>[] entryArr = this.f39340b;
            int i11 = this.f39341c;
            this.f39341c = i11 + 1;
            entryArr[i11] = entryEntryOf;
            return this;
        }

        public b<K, V> e(Map.Entry<? extends K, ? extends V> entry) {
            return d(entry.getKey(), entry.getValue());
        }

        public b<K, V> f(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                c(this.f39341c + ((Collection) iterable).size());
            }
            Iterator<? extends Map.Entry<? extends K, ? extends V>> it = iterable.iterator();
            while (it.hasNext()) {
                e(it.next());
            }
            return this;
        }

        public b<K, V> g(Map<? extends K, ? extends V> map) {
            return f(map.entrySet());
        }
    }

    public static <K, V> b<K, V> builder() {
        return new b<>();
    }

    public static <K, V> b<K, V> builderWithExpectedSize(int i11) {
        n1.b(i11, "expectedSize");
        return new b<>(i11);
    }

    public static void checkNoConflict(boolean z11, String str, Map.Entry<?, ?> entry, Map.Entry<?, ?> entry2) {
        if (!z11) {
            throw conflictException(str, entry, entry2);
        }
    }

    public static IllegalArgumentException conflictException(String str, Object obj, Object obj2) {
        return new IllegalArgumentException("Multiple entries with same " + str + ": " + obj + " and " + obj2);
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Map.Entry[] entryArr = (Map.Entry[]) j5.l(iterable, EMPTY_ENTRY_ARRAY);
        int length = entryArr.length;
        if (length == 0) {
            return of();
        }
        if (length != 1) {
            return RegularImmutableMap.fromEntries(entryArr);
        }
        Map.Entry entry = entryArr[0];
        return of(entry.getKey(), entry.getValue());
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap) && !(map instanceof SortedMap)) {
            ImmutableMap<K, V> immutableMap = (ImmutableMap) map;
            if (!immutableMap.isPartialView()) {
                return immutableMap;
            }
        } else if (map instanceof EnumMap) {
            return copyOfEnumMap((EnumMap) map);
        }
        return copyOf(map.entrySet());
    }

    private static <K extends Enum<K>, V> ImmutableMap<K, V> copyOfEnumMap(EnumMap<K, ? extends V> enumMap) {
        EnumMap enumMap2 = new EnumMap((EnumMap) enumMap);
        for (Map.Entry<K, V> entry : enumMap2.entrySet()) {
            n1.a(entry.getKey(), entry.getValue());
        }
        return ImmutableEnumMap.asImmutable(enumMap2);
    }

    public static <K, V> Map.Entry<K, V> entryOf(K k11, V v11) {
        n1.a(k11, v11);
        return new AbstractMap.SimpleImmutableEntry(k11, v11);
    }

    public static <K, V> ImmutableMap<K, V> of() {
        return (ImmutableMap<K, V>) RegularImmutableMap.EMPTY;
    }

    public static <K, V> ImmutableMap<K, V> of(K k11, V v11) {
        return ImmutableBiMap.of((Object) k11, (Object) v11);
    }

    public static <K, V> ImmutableMap<K, V> of(K k11, V v11, K k12, V v12) {
        return RegularImmutableMap.fromEntries(entryOf(k11, v11), entryOf(k12, v12));
    }

    public static <K, V> ImmutableMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13) {
        return RegularImmutableMap.fromEntries(entryOf(k11, v11), entryOf(k12, v12), entryOf(k13, v13));
    }

    public static <K, V> ImmutableMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        return RegularImmutableMap.fromEntries(entryOf(k11, v11), entryOf(k12, v12), entryOf(k13, v13), entryOf(k14, v14));
    }

    public static <K, V> ImmutableMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15) {
        return RegularImmutableMap.fromEntries(entryOf(k11, v11), entryOf(k12, v12), entryOf(k13, v13), entryOf(k14, v14), entryOf(k15, v15));
    }

    public static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return m1.o(function, function2);
    }

    public static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, BinaryOperator<V> binaryOperator) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(function);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(function2);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(binaryOperator);
        return Collectors.collectingAndThen(Collectors.toMap(function, function2, binaryOperator, new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p3
            @Override // java.util.function.Supplier
            public final Object get() {
                return new LinkedHashMap();
            }
        }), new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ImmutableMap.copyOf((Map) obj);
            }
        });
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
    @Deprecated
    public final V compute(K k11, BiFunction<? super K, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V computeIfAbsent(K k11, Function<? super K, ? extends V> function) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V computeIfPresent(K k11, BiFunction<? super K, ? super V, ? extends V> biFunction) {
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
        return Maps.f(this, obj);
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
        return Sets.b(entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isHashCodeFast() {
        return false;
    }

    public abstract boolean isPartialView();

    public t7<K> keyIterator() {
        return new a(entrySet().iterator());
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

    public Spliterator<K> keySpliterator() {
        return x1.e(entrySet().spliterator(), new o3());
    }

    @Override // java.util.Map
    @Deprecated
    public final V merge(K k11, V v11, BiFunction<? super V, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException();
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
    public final V putIfAbsent(K k11, V v11) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V replace(K k11, V v11) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final boolean replace(K k11, V v11, V v12) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return Maps.u(this);
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
