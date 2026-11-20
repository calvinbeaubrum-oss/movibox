package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements z6<K, V> {
    private static final long serialVersionUID = 0;
    private final transient ImmutableSet<V> emptySet;
    private transient ImmutableSet<Map.Entry<K, V>> entries;
    private transient ImmutableSetMultimap<V, K> inverse;

    /* JADX INFO: compiled from: source.java */
    public static final class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final transient ImmutableSetMultimap<K, V> f39385a;

        public EntrySet(ImmutableSetMultimap<K, V> immutableSetMultimap) {
            this.f39385a = immutableSetMultimap;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f39385a.containsEntry(entry.getKey(), entry.getValue());
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public t7<Map.Entry<K, V>> iterator() {
            return this.f39385a.entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f39385a.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a<K, V> extends ImmutableMultimap.c<K, V> {
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultimap.c
        public Collection<V> c() {
            return r6.f();
        }

        public ImmutableSetMultimap<K, V> h() {
            Collection collectionEntrySet = this.f39357a.entrySet();
            Comparator<? super K> comparator = this.f39358b;
            if (comparator != null) {
                collectionEntrySet = Ordering.from(comparator).onKeys().immutableSortedCopy(collectionEntrySet);
            }
            return ImmutableSetMultimap.fromMapEntries(collectionEntrySet, this.f39359c);
        }

        public a<K, V> i(ImmutableMultimap.c<K, V> cVar) {
            super.b(cVar);
            return this;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultimap.c
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public a<K, V> d(K k11, V v11) {
            super.d(k11, v11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultimap.c
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public a<K, V> e(Map.Entry<? extends K, ? extends V> entry) {
            super.e(entry);
            return this;
        }

        public a<K, V> l(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.f(iterable);
            return this;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultimap.c
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public a<K, V> g(K k11, Iterable<? extends V> iterable) {
            super.g(k11, iterable);
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final y6.b<ImmutableSetMultimap> f39386a = y6.a(ImmutableSetMultimap.class, "emptySet");
    }

    public ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> immutableMap, int i11, Comparator<? super V> comparator) {
        super(immutableMap, i11);
        this.emptySet = emptySet(comparator);
    }

    public static <K, V> a<K, V> builder() {
        return new a<>();
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(z5<? extends K, ? extends V> z5Var) {
        return copyOf(z5Var, null);
    }

    private static <K, V> ImmutableSetMultimap<K, V> copyOf(z5<? extends K, ? extends V> z5Var, Comparator<? super V> comparator) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(z5Var);
        if (z5Var.isEmpty() && comparator == null) {
            return of();
        }
        if (z5Var instanceof ImmutableSetMultimap) {
            ImmutableSetMultimap<K, V> immutableSetMultimap = (ImmutableSetMultimap) z5Var;
            if (!immutableSetMultimap.isPartialView()) {
                return immutableSetMultimap;
            }
        }
        return fromMapEntries(z5Var.asMap().entrySet(), comparator);
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new a().l(iterable).h();
    }

    private static <V> ImmutableSet<V> emptySet(Comparator<? super V> comparator) {
        return comparator == null ? ImmutableSet.of() : ImmutableSortedSet.emptySet(comparator);
    }

    public static <T, K, V> Collector<T, ?, ImmutableSetMultimap<K, V>> flatteningToImmutableSetMultimap(final Function<? super T, ? extends K> function, final Function<? super T, ? extends Stream<? extends V>> function2) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(function);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(function2);
        Function function3 = new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.k4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ImmutableSetMultimap.lambda$flatteningToImmutableSetMultimap$1(function, obj);
            }
        };
        Function function4 = new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ImmutableSetMultimap.lambda$flatteningToImmutableSetMultimap$2(function2, obj);
            }
        };
        final MultimapBuilder.d<Object, Object> dVarD = MultimapBuilder.a().d();
        dVarD.getClass();
        return Collectors.collectingAndThen(Multimaps.d(function3, function4, new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.m4
            @Override // java.util.function.Supplier
            public final Object get() {
                return dVarD.c();
            }
        }), new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ImmutableSetMultimap.copyOf((z5) obj);
            }
        });
    }

    public static <K, V> ImmutableSetMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, Comparator<? super V> comparator) {
        if (collection.isEmpty()) {
            return of();
        }
        ImmutableMap.b bVar = new ImmutableMap.b(collection.size());
        int size = 0;
        for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : collection) {
            K key = entry.getKey();
            ImmutableSet immutableSetValueSet = valueSet(comparator, entry.getValue());
            if (!immutableSetValueSet.isEmpty()) {
                bVar.d(key, immutableSetValueSet);
                size += immutableSetValueSet.size();
            }
        }
        return new ImmutableSetMultimap<>(bVar.a(), size, comparator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableSetMultimap<V, K> invert() {
        a aVarBuilder = builder();
        t7 it = entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            aVarBuilder.d(entry.getValue(), entry.getKey());
        }
        ImmutableSetMultimap<V, K> immutableSetMultimapH = aVarBuilder.h();
        immutableSetMultimapH.inverse = this;
        return immutableSetMultimapH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$flatteningToImmutableSetMultimap$1(Function function, Object obj) {
        return com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(function.apply(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$flatteningToImmutableSetMultimap$2(Function function, Object obj) {
        return b3.a(function.apply(obj)).peek(new g3());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void lambda$toImmutableSetMultimap$0(Function function, Function function2, a aVar, Object obj) {
        aVar.d(function.apply(obj), function2.apply(obj));
    }

    public static <K, V> ImmutableSetMultimap<K, V> of() {
        return EmptyImmutableSetMultimap.INSTANCE;
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k11, V v11) {
        a aVarBuilder = builder();
        aVarBuilder.d(k11, v11);
        return aVarBuilder.h();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k11, V v11, K k12, V v12) {
        a aVarBuilder = builder();
        aVarBuilder.d(k11, v11);
        aVarBuilder.d(k12, v12);
        return aVarBuilder.h();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13) {
        a aVarBuilder = builder();
        aVarBuilder.d(k11, v11);
        aVarBuilder.d(k12, v12);
        aVarBuilder.d(k13, v13);
        return aVarBuilder.h();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        a aVarBuilder = builder();
        aVarBuilder.d(k11, v11);
        aVarBuilder.d(k12, v12);
        aVarBuilder.d(k13, v13);
        aVarBuilder.d(k14, v14);
        return aVarBuilder.h();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15) {
        a aVarBuilder = builder();
        aVarBuilder.d(k11, v11);
        aVarBuilder.d(k12, v12);
        aVarBuilder.d(k13, v13);
        aVarBuilder.d(k14, v14);
        aVarBuilder.d(k15, v15);
        return aVarBuilder.h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        int i11 = objectInputStream.readInt();
        if (i11 < 0) {
            throw new InvalidObjectException("Invalid key count " + i11);
        }
        ImmutableMap.b bVarBuilder = ImmutableMap.builder();
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            Object object = objectInputStream.readObject();
            int i14 = objectInputStream.readInt();
            if (i14 <= 0) {
                throw new InvalidObjectException("Invalid value count " + i14);
            }
            ImmutableSet.a aVarValuesBuilder = valuesBuilder(comparator);
            for (int i15 = 0; i15 < i14; i15++) {
                aVarValuesBuilder.a(objectInputStream.readObject());
            }
            ImmutableSet immutableSetG = aVarValuesBuilder.g();
            if (immutableSetG.size() != i14) {
                throw new InvalidObjectException("Duplicate key-value pairs exist for key " + object);
            }
            bVarBuilder.d(object, immutableSetG);
            i12 += i14;
        }
        try {
            ImmutableMultimap.d.f39360a.b(this, bVarBuilder.a());
            ImmutableMultimap.d.f39361b.a(this, i12);
            b.f39386a.b(this, emptySet(comparator));
        } catch (IllegalArgumentException e11) {
            throw ((InvalidObjectException) new InvalidObjectException(e11.getMessage()).initCause(e11));
        }
    }

    public static <T, K, V> Collector<T, ?, ImmutableSetMultimap<K, V>> toImmutableSetMultimap(final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(function, "keyFunction");
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(function2, "valueFunction");
        return Collector.of(new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g4
            @Override // java.util.function.Supplier
            public final Object get() {
                return ImmutableSetMultimap.builder();
            }
        }, new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.h4
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ImmutableSetMultimap.lambda$toImmutableSetMultimap$0(function, function2, (ImmutableSetMultimap.a) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.i4
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableSetMultimap.a) obj).i((ImmutableSetMultimap.a) obj2);
            }
        }, new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.j4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableSetMultimap.a) obj).h();
            }
        }, new Collector.Characteristics[0]);
    }

    private static <V> ImmutableSet<V> valueSet(Comparator<? super V> comparator, Collection<? extends V> collection) {
        return comparator == null ? ImmutableSet.copyOf((Collection) collection) : ImmutableSortedSet.copyOf((Comparator) comparator, (Collection) collection);
    }

    private static <V> ImmutableSet.a<V> valuesBuilder(Comparator<? super V> comparator) {
        return comparator == null ? new ImmutableSet.a<>() : new ImmutableSortedSet.b(comparator);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(valueComparator());
        y6.j(this, objectOutputStream);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public ImmutableSet<Map.Entry<K, V>> entries() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.entries;
        if (immutableSet != null) {
            return immutableSet;
        }
        EntrySet entrySet = new EntrySet(this);
        this.entries = entrySet;
        return entrySet;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public ImmutableSet<V> get(K k11) {
        return (ImmutableSet) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.f.a((ImmutableSet) this.map.get(k11), this.emptySet);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultimap
    public ImmutableSetMultimap<V, K> inverse() {
        ImmutableSetMultimap<V, K> immutableSetMultimap = this.inverse;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        ImmutableSetMultimap<V, K> immutableSetMultimapInvert = invert();
        this.inverse = immutableSetMultimapInvert;
        return immutableSetMultimapInvert;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    @Deprecated
    public ImmutableSet<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    @Deprecated
    public ImmutableSet<V> replaceValues(K k11, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    public Comparator<? super V> valueComparator() {
        ImmutableSet<V> immutableSet = this.emptySet;
        if (immutableSet instanceof ImmutableSortedSet) {
            return ((ImmutableSortedSet) immutableSet).comparator();
        }
        return null;
    }
}
