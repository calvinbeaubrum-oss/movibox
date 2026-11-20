package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class v7<K, V> extends q2<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<K, V> f39779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Set<Map.Entry<K, V>> f39780b;

    /* JADX INFO: compiled from: source.java */
    public final class b extends Maps.g<K, V> {

        /* JADX INFO: compiled from: source.java */
        public class a extends r7<K, Map.Entry<K, V>> {

            /* JADX INFO: renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v7$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            public class C0417a extends q<K, V> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Object f39783a;

                public C0417a(Object obj) {
                    this.f39783a = obj;
                }

                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q, java.util.Map.Entry
                public K getKey() {
                    return (K) this.f39783a;
                }

                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q, java.util.Map.Entry
                public V getValue() {
                    return v7.this.get(this.f39783a);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q, java.util.Map.Entry
                public V setValue(V v11) {
                    return (V) v7.this.put(this.f39783a, v11);
                }
            }

            public a(Iterator it) {
                super(it);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.r7
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> a(K k11) {
                return new C0417a(k11);
            }
        }

        public b() {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.g
        public Map<K, V> a() {
            return v7.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a(v7.this.keySet().iterator());
        }
    }

    public v7(Map<K, V> map) {
        this.f39779a = map;
    }

    public static <K, V> v7<K, V> f(Map<K, V> map) {
        return new v7<>(map);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t2
    public Map<K, V> delegate() {
        return this.f39779a;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f39780b;
        if (set != null) {
            return set;
        }
        b bVar = new b();
        this.f39780b = bVar;
        return bVar;
    }
}
