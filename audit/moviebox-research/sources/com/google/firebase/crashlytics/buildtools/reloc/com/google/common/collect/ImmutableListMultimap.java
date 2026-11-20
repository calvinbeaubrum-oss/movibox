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
public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> implements q5<K, V> {
    private static final long serialVersionUID = 0;
    private transient ImmutableListMultimap<V, K> inverse;

    /* JADX INFO: compiled from: source.java */
    public static final class a<K, V> extends ImmutableMultimap.c<K, V> {
        public ImmutableListMultimap<K, V> h() {
            return (ImmutableListMultimap) super.a();
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

    public ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> immutableMap, int i11) {
        super(immutableMap, i11);
    }

    public static <K, V> a<K, V> builder() {
        return new a<>();
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(z5<? extends K, ? extends V> z5Var) {
        if (z5Var.isEmpty()) {
            return of();
        }
        if (z5Var instanceof ImmutableListMultimap) {
            ImmutableListMultimap<K, V> immutableListMultimap = (ImmutableListMultimap) z5Var;
            if (!immutableListMultimap.isPartialView()) {
                return immutableListMultimap;
            }
        }
        return fromMapEntries(z5Var.asMap().entrySet(), null);
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new a().l(iterable).h();
    }

    public static <T, K, V> Collector<T, ?, ImmutableListMultimap<K, V>> flatteningToImmutableListMultimap(final Function<? super T, ? extends K> function, final Function<? super T, ? extends Stream<? extends V>> function2) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(function);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(function2);
        Function function3 = new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ImmutableListMultimap.lambda$flatteningToImmutableListMultimap$1(function, obj);
            }
        };
        Function function4 = new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.m3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ImmutableListMultimap.lambda$flatteningToImmutableListMultimap$2(function2, obj);
            }
        };
        final MultimapBuilder.b<Object, Object> bVarA = MultimapBuilder.a().a();
        bVarA.getClass();
        return Collectors.collectingAndThen(Multimaps.d(function3, function4, new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.e3
            @Override // java.util.function.Supplier
            public final Object get() {
                return bVarA.c();
            }
        }), new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.f3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ImmutableListMultimap.copyOf((z5) obj);
            }
        });
    }

    public static <K, V> ImmutableListMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, Comparator<? super V> comparator) {
        if (collection.isEmpty()) {
            return of();
        }
        ImmutableMap.b bVar = new ImmutableMap.b(collection.size());
        int size = 0;
        for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : collection) {
            K key = entry.getKey();
            Collection<? extends V> value = entry.getValue();
            ImmutableList immutableListCopyOf = comparator == null ? ImmutableList.copyOf((Collection) value) : ImmutableList.sortedCopyOf(comparator, value);
            if (!immutableListCopyOf.isEmpty()) {
                bVar.d(key, immutableListCopyOf);
                size += immutableListCopyOf.size();
            }
        }
        return new ImmutableListMultimap<>(bVar.a(), size);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableListMultimap<V, K> invert() {
        a aVarBuilder = builder();
        t7 it = entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            aVarBuilder.d(entry.getValue(), entry.getKey());
        }
        ImmutableListMultimap<V, K> immutableListMultimapH = aVarBuilder.h();
        immutableListMultimapH.inverse = this;
        return immutableListMultimapH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$flatteningToImmutableListMultimap$1(Function function, Object obj) {
        return com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(function.apply(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$flatteningToImmutableListMultimap$2(Function function, Object obj) {
        return b3.a(function.apply(obj)).peek(new g3());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void lambda$toImmutableListMultimap$0(Function function, Function function2, a aVar, Object obj) {
        aVar.d(function.apply(obj), function2.apply(obj));
    }

    public static <K, V> ImmutableListMultimap<K, V> of() {
        return EmptyImmutableListMultimap.INSTANCE;
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k11, V v11) {
        a aVarBuilder = builder();
        aVarBuilder.d(k11, v11);
        return aVarBuilder.h();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k11, V v11, K k12, V v12) {
        a aVarBuilder = builder();
        aVarBuilder.d(k11, v11);
        aVarBuilder.d(k12, v12);
        return aVarBuilder.h();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13) {
        a aVarBuilder = builder();
        aVarBuilder.d(k11, v11);
        aVarBuilder.d(k12, v12);
        aVarBuilder.d(k13, v13);
        return aVarBuilder.h();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        a aVarBuilder = builder();
        aVarBuilder.d(k11, v11);
        aVarBuilder.d(k12, v12);
        aVarBuilder.d(k13, v13);
        aVarBuilder.d(k14, v14);
        return aVarBuilder.h();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15) {
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
            ImmutableList.b bVarBuilder2 = ImmutableList.builder();
            for (int i15 = 0; i15 < i14; i15++) {
                bVarBuilder2.a(objectInputStream.readObject());
            }
            bVarBuilder.d(object, bVarBuilder2.h());
            i12 += i14;
        }
        try {
            ImmutableMultimap.d.f39360a.b(this, bVarBuilder.a());
            ImmutableMultimap.d.f39361b.a(this, i12);
        } catch (IllegalArgumentException e11) {
            throw ((InvalidObjectException) new InvalidObjectException(e11.getMessage()).initCause(e11));
        }
    }

    public static <T, K, V> Collector<T, ?, ImmutableListMultimap<K, V>> toImmutableListMultimap(final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(function, "keyFunction");
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(function2, "valueFunction");
        return Collector.of(new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.h3
            @Override // java.util.function.Supplier
            public final Object get() {
                return ImmutableListMultimap.builder();
            }
        }, new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.i3
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ImmutableListMultimap.lambda$toImmutableListMultimap$0(function, function2, (ImmutableListMultimap.a) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.j3
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableListMultimap.a) obj).i((ImmutableListMultimap.a) obj2);
            }
        }, new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.k3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableListMultimap.a) obj).h();
            }
        }, new Collector.Characteristics[0]);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        y6.j(this, objectOutputStream);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public ImmutableList<V> get(K k11) {
        ImmutableList<V> immutableList = (ImmutableList) this.map.get(k11);
        return immutableList == null ? ImmutableList.of() : immutableList;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultimap
    public ImmutableListMultimap<V, K> inverse() {
        ImmutableListMultimap<V, K> immutableListMultimap = this.inverse;
        if (immutableListMultimap != null) {
            return immutableListMultimap;
        }
        ImmutableListMultimap<V, K> immutableListMultimapInvert = invert();
        this.inverse = immutableListMultimapInvert;
        return immutableListMultimapInvert;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    @Deprecated
    public ImmutableList<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    @Deprecated
    public ImmutableList<V> replaceValues(K k11, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }
}
