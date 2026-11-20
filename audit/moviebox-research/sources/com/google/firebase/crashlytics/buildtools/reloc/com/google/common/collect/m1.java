package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Collector<Object, ?, ImmutableList<Object>> f39732a = Collector.of(new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.a1
        @Override // java.util.function.Supplier
        public final Object get() {
            return ImmutableList.builder();
        }
    }, new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.j1
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            ((ImmutableList.b) obj).a(obj2);
        }
    }, new BinaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.k1
        @Override // java.util.function.BiFunction
        public final Object apply(Object obj, Object obj2) {
            return ((ImmutableList.b) obj).i((ImmutableList.b) obj2);
        }
    }, new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l1
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return ((ImmutableList.b) obj).h();
        }
    }, new Collector.Characteristics[0]);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Collector<Object, ?, ImmutableSet<Object>> f39733b = Collector.of(new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g0
        @Override // java.util.function.Supplier
        public final Object get() {
            return ImmutableSet.builder();
        }
    }, new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.h0
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            ((ImmutableSet.a) obj).a(obj2);
        }
    }, new BinaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.i0
        @Override // java.util.function.BiFunction
        public final Object apply(Object obj, Object obj2) {
            return ((ImmutableSet.a) obj).h((ImmutableSet.a) obj2);
        }
    }, new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.j0
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return ((ImmutableSet.a) obj).g();
        }
    }, new Collector.Characteristics[0]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Collector<Range<Comparable>, ?, ImmutableRangeSet<Comparable>> f39734c = Collector.of(new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.f1
        @Override // java.util.function.Supplier
        public final Object get() {
            return ImmutableRangeSet.builder();
        }
    }, new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g1
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            ((ImmutableRangeSet.a) obj).a((Range) obj2);
        }
    }, new BinaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.h1
        @Override // java.util.function.BiFunction
        public final Object apply(Object obj, Object obj2) {
            return ((ImmutableRangeSet.a) obj).d((ImmutableRangeSet.a) obj2);
        }
    }, new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.i1
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return ((ImmutableRangeSet.a) obj).c();
        }
    }, new Collector.Characteristics[0]);

    public static /* synthetic */ void g(Function function, Function function2, ImmutableBiMap.a aVar, Object obj) {
        aVar.d(function.apply(obj), function2.apply(obj));
    }

    public static /* synthetic */ void h(Function function, Function function2, ImmutableMap.b bVar, Object obj) {
        bVar.d(function.apply(obj), function2.apply(obj));
    }

    public static /* synthetic */ void i(Function function, Function function2, ImmutableRangeMap.a aVar, Object obj) {
        aVar.c((Range) function.apply(obj), function2.apply(obj));
    }

    public static /* synthetic */ ImmutableSortedMap.a j(Comparator comparator) {
        return new ImmutableSortedMap.a(comparator);
    }

    public static /* synthetic */ void k(Function function, Function function2, ImmutableSortedMap.a aVar, Object obj) {
        aVar.d(function.apply(obj), function2.apply(obj));
    }

    public static /* synthetic */ ImmutableSortedSet.b l(Comparator comparator) {
        return new ImmutableSortedSet.b(comparator);
    }

    public static <T, K, V> Collector<T, ?, ImmutableBiMap<K, V>> m(final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(function);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(function2);
        return Collector.of(new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.w0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new ImmutableBiMap.a();
            }
        }, new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.x0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                m1.g(function, function2, (ImmutableBiMap.a) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.y0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableBiMap.a) obj).b((ImmutableBiMap.a) obj2);
            }
        }, new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableBiMap.a) obj).a();
            }
        }, new Collector.Characteristics[0]);
    }

    public static <E> Collector<E, ?, ImmutableList<E>> n() {
        return (Collector<E, ?, ImmutableList<E>>) f39732a;
    }

    public static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> o(final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(function);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(function2);
        return Collector.of(new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new ImmutableMap.b();
            }
        }, new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                m1.h(function, function2, (ImmutableMap.b) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.u0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableMap.b) obj).b((ImmutableMap.b) obj2);
            }
        }, new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableMap.b) obj).a();
            }
        }, new Collector.Characteristics[0]);
    }

    public static <T, K extends Comparable<? super K>, V> Collector<T, ?, ImmutableRangeMap<K, V>> p(final Function<? super T, Range<K>> function, final Function<? super T, ? extends V> function2) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(function);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(function2);
        return Collector.of(new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.b1
            @Override // java.util.function.Supplier
            public final Object get() {
                return ImmutableRangeMap.builder();
            }
        }, new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.c1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                m1.i(function, function2, (ImmutableRangeMap.a) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.d1
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableRangeMap.a) obj).b((ImmutableRangeMap.a) obj2);
            }
        }, new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.e1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableRangeMap.a) obj).a();
            }
        }, new Collector.Characteristics[0]);
    }

    public static <E extends Comparable<? super E>> Collector<Range<E>, ?, ImmutableRangeSet<E>> q() {
        return (Collector<Range<E>, ?, ImmutableRangeSet<E>>) f39734c;
    }

    public static <E> Collector<E, ?, ImmutableSet<E>> r() {
        return (Collector<E, ?, ImmutableSet<E>>) f39733b;
    }

    public static <T, K, V> Collector<T, ?, ImmutableSortedMap<K, V>> s(final Comparator<? super K> comparator, final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(comparator);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(function);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(function2);
        return Collector.of(new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.o0
            @Override // java.util.function.Supplier
            public final Object get() {
                return m1.j(comparator);
            }
        }, new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                m1.k(function, function2, (ImmutableSortedMap.a) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableSortedMap.a) obj).b((ImmutableSortedMap.a) obj2);
            }
        }, new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.r0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableSortedMap.a) obj).a();
            }
        }, Collector.Characteristics.UNORDERED);
    }

    public static <E> Collector<E, ?, ImmutableSortedSet<E>> t(final Comparator<? super E> comparator) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(comparator);
        return Collector.of(new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.k0
            @Override // java.util.function.Supplier
            public final Object get() {
                return m1.l(comparator);
            }
        }, new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((ImmutableSortedSet.b) obj).a(obj2);
            }
        }, new BinaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.m0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableSortedSet.b) obj).h((ImmutableSortedSet.b) obj2);
            }
        }, new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableSortedSet.b) obj).g();
            }
        }, new Collector.Characteristics[0]);
    }
}
