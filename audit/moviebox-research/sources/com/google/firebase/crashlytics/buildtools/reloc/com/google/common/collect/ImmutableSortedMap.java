package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.Spliterator;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class ImmutableSortedMap<K, V> extends ImmutableSortedMapFauxverideShim<K, V> implements NavigableMap<K, V> {
    private static final long serialVersionUID = 0;
    private transient ImmutableSortedMap<K, V> descendingMap;
    private final transient RegularImmutableSortedSet<K> keySet;
    private final transient ImmutableList<V> valueList;
    private static final Comparator<Comparable> NATURAL_ORDER = Ordering.natural();
    private static final ImmutableSortedMap<Comparable, Object> NATURAL_EMPTY_MAP = new ImmutableSortedMap<>(ImmutableSortedSet.emptySet(Ordering.natural()), ImmutableList.of());

    /* JADX INFO: compiled from: source.java */
    public static class SerializedForm extends ImmutableMap.SerializedForm {
        private static final long serialVersionUID = 0;
        private final Comparator<Object> comparator;

        public SerializedForm(ImmutableSortedMap<?, ?> immutableSortedMap) {
            super(immutableSortedMap);
            this.comparator = immutableSortedMap.comparator();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap.SerializedForm
        public Object readResolve() {
            return createMap(new a(this.comparator));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class a<K, V> extends ImmutableMap.b<K, V> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Comparator<? super K> f39387e;

        public a(Comparator<? super K> comparator) {
            this.f39387e = (Comparator) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(comparator);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap.b
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public ImmutableSortedMap<K, V> a() {
            int i11 = this.f39341c;
            if (i11 != 0) {
                return i11 != 1 ? ImmutableSortedMap.fromEntries(this.f39387e, false, this.f39340b, i11) : ImmutableSortedMap.of(this.f39387e, this.f39340b[0].getKey(), this.f39340b[0].getValue());
            }
            return ImmutableSortedMap.emptyMap(this.f39387e);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap.b
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public a<K, V> b(ImmutableMap.b<K, V> bVar) {
            super.b(bVar);
            return this;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap.b
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public a<K, V> d(K k11, V v11) {
            super.d(k11, v11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap.b
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public a<K, V> e(Map.Entry<? extends K, ? extends V> entry) {
            super.e(entry);
            return this;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap.b
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public a<K, V> f(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.f(iterable);
            return this;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap.b
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public a<K, V> g(Map<? extends K, ? extends V> map) {
            super.g(map);
            return this;
        }
    }

    public ImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList) {
        this(regularImmutableSortedSet, immutableList, null);
    }

    public ImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList, ImmutableSortedMap<K, V> immutableSortedMap) {
        this.keySet = regularImmutableSortedSet;
        this.valueList = immutableList;
        this.descendingMap = immutableSortedMap;
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return copyOf(iterable, (Ordering) NATURAL_ORDER);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable, Comparator<? super K> comparator) {
        return fromEntries((Comparator) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(comparator), false, iterable);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        return copyOfInternal(map, (Ordering) NATURAL_ORDER);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        return copyOfInternal(map, (Comparator) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(comparator));
    }

    private static <K, V> ImmutableSortedMap<K, V> copyOfInternal(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        boolean zEquals = false;
        if (map instanceof SortedMap) {
            Comparator<? super K> comparator2 = ((SortedMap) map).comparator();
            if (comparator2 != null) {
                zEquals = comparator.equals(comparator2);
            } else if (comparator == NATURAL_ORDER) {
                zEquals = true;
            }
        }
        if (zEquals && (map instanceof ImmutableSortedMap)) {
            ImmutableSortedMap<K, V> immutableSortedMap = (ImmutableSortedMap) map;
            if (!immutableSortedMap.isPartialView()) {
                return immutableSortedMap;
            }
        }
        return fromEntries(comparator, zEquals, map.entrySet());
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOfSorted(SortedMap<K, ? extends V> sortedMap) {
        Comparator<? super K> comparator = sortedMap.comparator();
        if (comparator == null) {
            comparator = NATURAL_ORDER;
        }
        if (sortedMap instanceof ImmutableSortedMap) {
            ImmutableSortedMap<K, V> immutableSortedMap = (ImmutableSortedMap) sortedMap;
            if (!immutableSortedMap.isPartialView()) {
                return immutableSortedMap;
            }
        }
        return fromEntries(comparator, true, sortedMap.entrySet());
    }

    public static <K, V> ImmutableSortedMap<K, V> emptyMap(Comparator<? super K> comparator) {
        return Ordering.natural().equals(comparator) ? of() : new ImmutableSortedMap<>(ImmutableSortedSet.emptySet(comparator), ImmutableList.of());
    }

    private static <K, V> ImmutableSortedMap<K, V> fromEntries(Comparator<? super K> comparator, boolean z11, Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Map.Entry[] entryArr = (Map.Entry[]) j5.l(iterable, ImmutableMap.EMPTY_ENTRY_ARRAY);
        return fromEntries(comparator, z11, entryArr, entryArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> ImmutableSortedMap<K, V> fromEntries(final Comparator<? super K> comparator, boolean z11, Map.Entry<K, V>[] entryArr, int i11) {
        if (i11 == 0) {
            return emptyMap(comparator);
        }
        if (i11 == 1) {
            return of(comparator, entryArr[0].getKey(), entryArr[0].getValue());
        }
        Object[] objArr = new Object[i11];
        Object[] objArr2 = new Object[i11];
        if (z11) {
            for (int i12 = 0; i12 < i11; i12++) {
                K key = entryArr[i12].getKey();
                V value = entryArr[i12].getValue();
                n1.a(key, value);
                objArr[i12] = key;
                objArr2[i12] = value;
            }
        } else {
            Arrays.sort(entryArr, 0, i11, new Comparator<Map.Entry<K, V>>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMap.1
                @Override // java.util.Comparator
                public int compare(Map.Entry<K, V> entry, Map.Entry<K, V> entry2) {
                    return comparator.compare(entry.getKey(), entry2.getKey());
                }
            });
            Object key2 = entryArr[0].getKey();
            objArr[0] = key2;
            V value2 = entryArr[0].getValue();
            objArr2[0] = value2;
            n1.a(objArr[0], value2);
            int i13 = 1;
            while (i13 < i11) {
                Object key3 = entryArr[i13].getKey();
                V value3 = entryArr[i13].getValue();
                n1.a(key3, value3);
                objArr[i13] = key3;
                objArr2[i13] = value3;
                ImmutableMap.checkNoConflict(comparator.compare(key2, key3) != 0, "key", entryArr[i13 - 1], entryArr[i13]);
                i13++;
                key2 = key3;
            }
        }
        return new ImmutableSortedMap<>(new RegularImmutableSortedSet(new RegularImmutableList(objArr), comparator), new RegularImmutableList(objArr2));
    }

    private ImmutableSortedMap<K, V> getSubMap(int i11, int i12) {
        if (i11 == 0 && i12 == size()) {
            return this;
        }
        return i11 == i12 ? emptyMap(comparator()) : new ImmutableSortedMap<>(this.keySet.getSubSet(i11, i12), this.valueList.subList(i11, i12));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TreeMap lambda$toImmutableSortedMap$0(Comparator comparator) {
        return new TreeMap(comparator);
    }

    public static <K extends Comparable<?>, V> a<K, V> naturalOrder() {
        return new a<>(Ordering.natural());
    }

    public static <K, V> ImmutableSortedMap<K, V> of() {
        return (ImmutableSortedMap<K, V>) NATURAL_EMPTY_MAP;
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;)Lcom/google/firebase/crashlytics/buildtools/reloc/com/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj) {
        return of(Ordering.natural(), comparable, obj);
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;)Lcom/google/firebase/crashlytics/buildtools/reloc/com/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2) {
        return ofEntries(ImmutableMap.entryOf(comparable, obj), ImmutableMap.entryOf(comparable2, obj2));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;)Lcom/google/firebase/crashlytics/buildtools/reloc/com/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3) {
        return ofEntries(ImmutableMap.entryOf(comparable, obj), ImmutableMap.entryOf(comparable2, obj2), ImmutableMap.entryOf(comparable3, obj3));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/firebase/crashlytics/buildtools/reloc/com/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4) {
        return ofEntries(ImmutableMap.entryOf(comparable, obj), ImmutableMap.entryOf(comparable2, obj2), ImmutableMap.entryOf(comparable3, obj3), ImmutableMap.entryOf(comparable4, obj4));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/firebase/crashlytics/buildtools/reloc/com/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4, Comparable comparable5, Object obj5) {
        return ofEntries(ImmutableMap.entryOf(comparable, obj), ImmutableMap.entryOf(comparable2, obj2), ImmutableMap.entryOf(comparable3, obj3), ImmutableMap.entryOf(comparable4, obj4), ImmutableMap.entryOf(comparable5, obj5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> ImmutableSortedMap<K, V> of(Comparator<? super K> comparator, K k11, V v11) {
        return new ImmutableSortedMap<>(new RegularImmutableSortedSet(ImmutableList.of(k11), (Comparator) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(comparator)), ImmutableList.of(v11));
    }

    private static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> ofEntries(Map.Entry<K, V>... entryArr) {
        return fromEntries(Ordering.natural(), false, entryArr, entryArr.length);
    }

    public static <K, V> a<K, V> orderedBy(Comparator<K> comparator) {
        return new a<>(comparator);
    }

    public static <K extends Comparable<?>, V> a<K, V> reverseOrder() {
        return new a<>(Ordering.natural().reverse());
    }

    public static <T, K, V> Collector<T, ?, ImmutableSortedMap<K, V>> toImmutableSortedMap(Comparator<? super K> comparator, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return m1.s(comparator, function, function2);
    }

    public static <T, K, V> Collector<T, ?, ImmutableSortedMap<K, V>> toImmutableSortedMap(final Comparator<? super K> comparator, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, BinaryOperator<V> binaryOperator) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(comparator);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(function);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(function2);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(binaryOperator);
        return Collectors.collectingAndThen(Collectors.toMap(function, function2, binaryOperator, new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.o4
            @Override // java.util.function.Supplier
            public final Object get() {
                return ImmutableSortedMap.lambda$toImmutableSortedMap$0(comparator);
            }
        }), new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ImmutableSortedMap.copyOfSorted((TreeMap) obj);
            }
        });
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K k11) {
        return tailMap((Object) k11, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k11) {
        return (K) Maps.k(ceilingEntry(k11));
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return keySet().comparator();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return isEmpty() ? ImmutableSet.of() : new ImmutableMapEntrySet<K, V>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMap.1EntrySet

            /* JADX INFO: renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMap$1EntrySet$1, reason: invalid class name */
            /* JADX INFO: compiled from: source.java */
            public class AnonymousClass1 extends ImmutableAsList<Map.Entry<K, V>> {
                public AnonymousClass1() {
                }

                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableAsList
                public ImmutableCollection<Map.Entry<K, V>> delegateCollection() {
                    return C1EntrySet.this;
                }

                @Override // java.util.List
                public Map.Entry<K, V> get(int i11) {
                    return new AbstractMap.SimpleImmutableEntry(ImmutableSortedMap.this.keySet.asList().get(i11), ImmutableSortedMap.this.valueList.get(i11));
                }

                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
                public Spliterator<Map.Entry<K, V>> spliterator() {
                    return x1.c(size(), 1297, new IntFunction() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q4
                        @Override // java.util.function.IntFunction
                        public final Object apply(int i11) {
                            return this.f39749a.get(i11);
                        }
                    });
                }
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet
            public ImmutableList<Map.Entry<K, V>> createAsList() {
                return new AnonymousClass1();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Map.Entry<K, V>> consumer) {
                asList().forEach(consumer);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
            public t7<Map.Entry<K, V>> iterator() {
                return asList().iterator();
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMapEntrySet
            public ImmutableMap<K, V> map() {
                return ImmutableSortedMap.this;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
            public Spliterator<Map.Entry<K, V>> spliterator() {
                return asList().spliterator();
            }
        };
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
    public ImmutableCollection<V> createValues() {
        throw new AssertionError("should never be called");
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedSet<K> descendingKeySet() {
        return this.keySet.descendingSet();
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> descendingMap() {
        ImmutableSortedMap<K, V> immutableSortedMap = this.descendingMap;
        if (immutableSortedMap == null) {
            return isEmpty() ? emptyMap(Ordering.from(comparator()).reverse()) : new ImmutableSortedMap<>((RegularImmutableSortedSet) this.keySet.descendingSet(), this.valueList.reverse(), this);
        }
        return immutableSortedMap;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return entrySet().asList().get(0);
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return keySet().first();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K k11) {
        return headMap((Object) k11, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k11) {
        return (K) Maps.k(floorEntry(k11));
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(biConsumer);
        ImmutableList<K> immutableListAsList = this.keySet.asList();
        for (int i11 = 0; i11 < size(); i11++) {
            biConsumer.accept(immutableListAsList.get(i11), this.valueList.get(i11));
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        int iIndexOf = this.keySet.indexOf(obj);
        if (iIndexOf == -1) {
            return null;
        }
        return this.valueList.get(iIndexOf);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> headMap(K k11) {
        return headMap((Object) k11, false);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> headMap(K k11, boolean z11) {
        return getSubMap(0, this.keySet.headIndex((K) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(k11), z11));
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K k11) {
        return tailMap((Object) k11, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k11) {
        return (K) Maps.k(higherEntry(k11));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return this.keySet.isPartialView() || this.valueList.isPartialView();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSortedSet<K> keySet() {
        return this.keySet;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return entrySet().asList().get(size() - 1);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return keySet().last();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K k11) {
        return headMap((Object) k11, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k11) {
        return (K) Maps.k(lowerEntry(k11));
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedSet<K> navigableKeySet() {
        return this.keySet;
    }

    @Override // java.util.NavigableMap
    @Deprecated
    public final Map.Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    @Deprecated
    public final Map.Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public int size() {
        return this.valueList.size();
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> subMap(K k11, K k12) {
        return subMap((Object) k11, true, (Object) k12, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> subMap(K k11, boolean z11, K k12, boolean z12) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(k11);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(k12);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.k(comparator().compare(k11, k12) <= 0, "expected fromKey <= toKey but %s > %s", k11, k12);
        return headMap((Object) k12, z12).tailMap((Object) k11, z11);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> tailMap(K k11) {
        return tailMap((Object) k11, true);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> tailMap(K k11, boolean z11) {
        return getSubMap(this.keySet.tailIndex((K) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(k11), z11), size());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableCollection<V> values() {
        return this.valueList;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new SerializedForm(this);
    }
}
