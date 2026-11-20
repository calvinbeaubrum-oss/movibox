package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.Serializable;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class ImmutableMapValues<K, V> extends ImmutableCollection<V> {
    private final ImmutableMap<K, V> map;

    /* JADX INFO: compiled from: source.java */
    public static class SerializedForm<V> implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableMap<?, V> map;

        public SerializedForm(ImmutableMap<?, V> immutableMap) {
            this.map = immutableMap;
        }

        public Object readResolve() {
            return this.map.values();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends t7<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t7<Map.Entry<K, V>> f39347a;

        public a() {
            this.f39347a = ImmutableMapValues.this.map.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f39347a.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return this.f39347a.next().getValue();
        }
    }

    public ImmutableMapValues(ImmutableMap<K, V> immutableMap) {
        this.map = immutableMap;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
    public ImmutableList<V> asList() {
        final ImmutableList<Map.Entry<K, V>> immutableListAsList = this.map.entrySet().asList();
        return new ImmutableAsList<V>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMapValues.2
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableAsList
            public ImmutableCollection<V> delegateCollection() {
                return ImmutableMapValues.this;
            }

            @Override // java.util.List
            public V get(int i11) {
                return (V) ((Map.Entry) immutableListAsList.get(i11)).getValue();
            }
        };
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return obj != null && Iterators.f(iterator(), obj);
    }

    @Override // java.lang.Iterable
    public void forEach(final Consumer<? super V> consumer) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(consumer);
        this.map.forEach(new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t3
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                androidx.compose.ui.contentcapture.h.a(consumer, obj2);
            }
        });
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return true;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public t7<V> iterator() {
        return new a();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.map.size();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<V> spliterator() {
        return x1.e(this.map.entrySet().spliterator(), new s3());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this.map);
    }
}
