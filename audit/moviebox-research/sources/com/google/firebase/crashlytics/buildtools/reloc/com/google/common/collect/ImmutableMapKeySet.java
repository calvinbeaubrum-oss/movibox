package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.Serializable;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class ImmutableMapKeySet<K, V> extends IndexedImmutableSet<K> {
    private final ImmutableMap<K, V> map;

    /* JADX INFO: compiled from: source.java */
    public static class KeySetSerializedForm<K> implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableMap<K, ?> map;

        public KeySetSerializedForm(ImmutableMap<K, ?> immutableMap) {
            this.map = immutableMap;
        }

        public Object readResolve() {
            return this.map.keySet();
        }
    }

    public ImmutableMapKeySet(ImmutableMap<K, V> immutableMap) {
        this.map = immutableMap;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.IndexedImmutableSet, java.lang.Iterable
    public void forEach(final Consumer<? super K> consumer) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(consumer);
        this.map.forEach(new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.r3
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                androidx.compose.ui.contentcapture.h.a(consumer, obj);
            }
        });
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.IndexedImmutableSet
    public K get(int i11) {
        return this.map.entrySet().asList().get(i11).getKey();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return true;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.IndexedImmutableSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public t7<K> iterator() {
        return this.map.keyIterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.map.size();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.IndexedImmutableSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<K> spliterator() {
        return this.map.keySpliterator();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new KeySetSerializedForm(this.map);
    }
}
