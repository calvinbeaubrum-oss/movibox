package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.Serializable;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.Function;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class ImmutableEnumMap<K extends Enum<K>, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient EnumMap<K, V> f39325a;

    /* JADX INFO: compiled from: source.java */
    public static class EnumSerializedForm<K extends Enum<K>, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final EnumMap<K, V> delegate;

        public EnumSerializedForm(EnumMap<K, V> enumMap) {
            this.delegate = enumMap;
        }

        public Object readResolve() {
            return new ImmutableEnumMap(this.delegate);
        }
    }

    public ImmutableEnumMap(EnumMap<K, V> enumMap) {
        this.f39325a = enumMap;
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(!enumMap.isEmpty());
    }

    public static <K extends Enum<K>, V> ImmutableMap<K, V> asImmutable(EnumMap<K, V> enumMap) {
        int size = enumMap.size();
        if (size == 0) {
            return ImmutableMap.of();
        }
        if (size != 1) {
            return new ImmutableEnumMap(enumMap);
        }
        Map.Entry entry = (Map.Entry) j5.h(enumMap.entrySet());
        return ImmutableMap.of(entry.getKey(), entry.getValue());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.f39325a.containsKey(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
    public t7<Map.Entry<K, V>> entryIterator() {
        return Maps.w(this.f39325a.entrySet().iterator());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
    public Spliterator<Map.Entry<K, V>> entrySpliterator() {
        return x1.e(this.f39325a.entrySet().spliterator(), new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Maps.v((Map.Entry) obj);
            }
        });
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap, java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableEnumMap) {
            obj = ((ImmutableEnumMap) obj).f39325a;
        }
        return this.f39325a.equals(obj);
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        this.f39325a.forEach(biConsumer);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        return this.f39325a.get(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
    public t7<K> keyIterator() {
        return Iterators.z(this.f39325a.keySet().iterator());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
    public Spliterator<K> keySpliterator() {
        return this.f39325a.keySet().spliterator();
    }

    @Override // java.util.Map
    public int size() {
        return this.f39325a.size();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new EnumSerializedForm(this.f39325a);
    }
}
