package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class ImmutableBiMap<K, V> extends ImmutableBiMapFauxverideShim<K, V> implements d0<K, V> {

    /* JADX INFO: compiled from: source.java */
    public static class SerializedForm extends ImmutableMap.SerializedForm {
        private static final long serialVersionUID = 0;

        public SerializedForm(ImmutableBiMap<?, ?> immutableBiMap) {
            super(immutableBiMap);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap.SerializedForm
        public Object readResolve() {
            return createMap(new a());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a<K, V> extends ImmutableMap.b<K, V> {
        public a() {
        }

        public a(int i11) {
            super(i11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap.b
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public ImmutableBiMap<K, V> a() {
            int i11 = this.f39341c;
            if (i11 == 0) {
                return ImmutableBiMap.of();
            }
            if (i11 == 1) {
                return ImmutableBiMap.of((Object) this.f39340b[0].getKey(), (Object) this.f39340b[0].getValue());
            }
            if (this.f39339a != null) {
                if (this.f39342d) {
                    this.f39340b = (Map.Entry[]) Arrays.copyOf(this.f39340b, i11);
                }
                Arrays.sort(this.f39340b, 0, this.f39341c, Ordering.from(this.f39339a).onResultOf(Maps.x()));
            }
            this.f39342d = true;
            return RegularImmutableBiMap.fromEntryArray(this.f39341c, this.f39340b);
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

    public static <K, V> a<K, V> builder() {
        return new a<>();
    }

    public static <K, V> a<K, V> builderWithExpectedSize(int i11) {
        n1.b(i11, "expectedSize");
        return new a<>(i11);
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Map.Entry[] entryArr = (Map.Entry[]) j5.l(iterable, ImmutableMap.EMPTY_ENTRY_ARRAY);
        int length = entryArr.length;
        if (length == 0) {
            return of();
        }
        if (length != 1) {
            return RegularImmutableBiMap.fromEntries(entryArr);
        }
        Map.Entry entry = entryArr[0];
        return of(entry.getKey(), entry.getValue());
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if (map instanceof ImmutableBiMap) {
            ImmutableBiMap<K, V> immutableBiMap = (ImmutableBiMap) map;
            if (!immutableBiMap.isPartialView()) {
                return immutableBiMap;
            }
        }
        return copyOf((Iterable) map.entrySet());
    }

    public static <K, V> ImmutableBiMap<K, V> of() {
        return RegularImmutableBiMap.EMPTY;
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k11, V v11) {
        return new SingletonImmutableBiMap(k11, v11);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k11, V v11, K k12, V v12) {
        return RegularImmutableBiMap.fromEntries(ImmutableMap.entryOf(k11, v11), ImmutableMap.entryOf(k12, v12));
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13) {
        return RegularImmutableBiMap.fromEntries(ImmutableMap.entryOf(k11, v11), ImmutableMap.entryOf(k12, v12), ImmutableMap.entryOf(k13, v13));
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        return RegularImmutableBiMap.fromEntries(ImmutableMap.entryOf(k11, v11), ImmutableMap.entryOf(k12, v12), ImmutableMap.entryOf(k13, v13), ImmutableMap.entryOf(k14, v14));
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15) {
        return RegularImmutableBiMap.fromEntries(ImmutableMap.entryOf(k11, v11), ImmutableMap.entryOf(k12, v12), ImmutableMap.entryOf(k13, v13), ImmutableMap.entryOf(k14, v14), ImmutableMap.entryOf(k15, v15));
    }

    public static <T, K, V> Collector<T, ?, ImmutableBiMap<K, V>> toImmutableBiMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return m1.m(function, function2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
    public final ImmutableSet<V> createValues() {
        throw new AssertionError("should never be called");
    }

    @Deprecated
    public V forcePut(K k11, V v11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.d0
    public abstract ImmutableBiMap<V, K> inverse();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<V> values() {
        return inverse().keySet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new SerializedForm(this);
    }
}
