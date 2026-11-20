package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements k<K, V> {

    /* JADX INFO: compiled from: source.java */
    public static class SerializedForm<K, V> extends ImmutableMap.SerializedForm<K, V> {
        private static final long serialVersionUID = 0;

        public SerializedForm(ImmutableBiMap<K, V> immutableBiMap) {
            super(immutableBiMap);
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        public a<K, V> makeBuilder(int i11) {
            return new a<>(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a<K, V> extends ImmutableMap.b<K, V> {
        public a() {
        }

        public a(int i11) {
            super(i11);
        }

        @Override // com.google.common.collect.ImmutableMap.b
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public ImmutableBiMap<K, V> a() {
            return d();
        }

        @Override // com.google.common.collect.ImmutableMap.b
        @Deprecated
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public ImmutableBiMap<K, V> c() {
            throw new UnsupportedOperationException("Not supported for bimaps");
        }

        @Override // com.google.common.collect.ImmutableMap.b
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public ImmutableBiMap<K, V> d() {
            int i11 = this.f38356c;
            if (i11 == 0) {
                return ImmutableBiMap.of();
            }
            if (this.f38354a != null) {
                if (this.f38357d) {
                    this.f38355b = Arrays.copyOf(this.f38355b, i11 * 2);
                }
                ImmutableMap.b.k(this.f38355b, this.f38356c, this.f38354a);
            }
            this.f38357d = true;
            return new RegularImmutableBiMap(this.f38355b, this.f38356c);
        }

        @Override // com.google.common.collect.ImmutableMap.b
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public a<K, V> g(K k11, V v11) {
            super.g(k11, v11);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public a<K, V> h(Map.Entry<? extends K, ? extends V> entry) {
            super.h(entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public a<K, V> i(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.i(iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public a<K, V> j(Map<? extends K, ? extends V> map) {
            super.j(map);
            return this;
        }
    }

    public static <K, V> a<K, V> builder() {
        return new a<>();
    }

    public static <K, V> a<K, V> builderWithExpectedSize(int i11) {
        l.b(i11, "expectedSize");
        return new a<>(i11);
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new a(iterable instanceof Collection ? ((Collection) iterable).size() : 4).i(iterable).a();
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
        l.a(k11, v11);
        return new RegularImmutableBiMap(new Object[]{k11, v11}, 1);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k11, V v11, K k12, V v12) {
        l.a(k11, v11);
        l.a(k12, v12);
        return new RegularImmutableBiMap(new Object[]{k11, v11, k12, v12}, 2);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13) {
        l.a(k11, v11);
        l.a(k12, v12);
        l.a(k13, v13);
        return new RegularImmutableBiMap(new Object[]{k11, v11, k12, v12, k13, v13}, 3);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        l.a(k11, v11);
        l.a(k12, v12);
        l.a(k13, v13);
        l.a(k14, v14);
        return new RegularImmutableBiMap(new Object[]{k11, v11, k12, v12, k13, v13, k14, v14}, 4);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15) {
        l.a(k11, v11);
        l.a(k12, v12);
        l.a(k13, v13);
        l.a(k14, v14);
        l.a(k15, v15);
        return new RegularImmutableBiMap(new Object[]{k11, v11, k12, v12, k13, v13, k14, v14, k15, v15}, 5);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16) {
        l.a(k11, v11);
        l.a(k12, v12);
        l.a(k13, v13);
        l.a(k14, v14);
        l.a(k15, v15);
        l.a(k16, v16);
        return new RegularImmutableBiMap(new Object[]{k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16}, 6);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16, K k17, V v17) {
        l.a(k11, v11);
        l.a(k12, v12);
        l.a(k13, v13);
        l.a(k14, v14);
        l.a(k15, v15);
        l.a(k16, v16);
        l.a(k17, v17);
        return new RegularImmutableBiMap(new Object[]{k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16, k17, v17}, 7);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16, K k17, V v17, K k18, V v18) {
        l.a(k11, v11);
        l.a(k12, v12);
        l.a(k13, v13);
        l.a(k14, v14);
        l.a(k15, v15);
        l.a(k16, v16);
        l.a(k17, v17);
        l.a(k18, v18);
        return new RegularImmutableBiMap(new Object[]{k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16, k17, v17, k18, v18}, 8);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16, K k17, V v17, K k18, V v18, K k19, V v19) {
        l.a(k11, v11);
        l.a(k12, v12);
        l.a(k13, v13);
        l.a(k14, v14);
        l.a(k15, v15);
        l.a(k16, v16);
        l.a(k17, v17);
        l.a(k18, v18);
        l.a(k19, v19);
        return new RegularImmutableBiMap(new Object[]{k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16, k17, v17, k18, v18, k19, v19}, 9);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16, K k17, V v17, K k18, V v18, K k19, V v19, K k21, V v21) {
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
        return new RegularImmutableBiMap(new Object[]{k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16, k17, v17, k18, v18, k19, v19, k21, v21}, 10);
    }

    @SafeVarargs
    public static <K, V> ImmutableBiMap<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... entryArr) {
        return copyOf((Iterable) Arrays.asList(entryArr));
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.ImmutableMap
    public final ImmutableSet<V> createValues() {
        throw new AssertionError("should never be called");
    }

    @Deprecated
    public final V forcePut(K k11, V v11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.k
    public abstract ImmutableBiMap<V, K> inverse();

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<V> values() {
        return inverse().keySet();
    }

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new SerializedForm(this);
    }
}
