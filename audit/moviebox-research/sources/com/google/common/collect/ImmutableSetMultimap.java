package com.google.common.collect;

import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements v0<K, V> {
    private static final long serialVersionUID = 0;
    private final transient ImmutableSet<V> emptySet;

    @RetainedWith
    private transient ImmutableSet<Map.Entry<K, V>> entries;

    @RetainedWith
    private transient ImmutableSetMultimap<V, K> inverse;

    /* JADX INFO: compiled from: source.java */
    public static final class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Weak
        public final transient ImmutableSetMultimap<K, V> f38394a;

        public EntrySet(ImmutableSetMultimap<K, V> immutableSetMultimap) {
            this.f38394a = immutableSetMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f38394a.containsEntry(entry.getKey(), entry.getValue());
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public g1<Map.Entry<K, V>> iterator() {
            return this.f38394a.entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f38394a.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a<K, V> extends ImmutableMultimap.c<K, V> {
        @Override // com.google.common.collect.ImmutableMultimap.c
        public Collection<V> b() {
            return p0.h();
        }

        public ImmutableSetMultimap<K, V> f() {
            Collection collectionEntrySet = this.f38372a.entrySet();
            Comparator<? super K> comparator = this.f38373b;
            if (comparator != null) {
                collectionEntrySet = Ordering.from(comparator).onKeys().immutableSortedCopy(collectionEntrySet);
            }
            return ImmutableSetMultimap.fromMapEntries(collectionEntrySet, this.f38374c);
        }

        @Override // com.google.common.collect.ImmutableMultimap.c
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public a<K, V> c(K k11, V v11) {
            super.c(k11, v11);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.c
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public a<K, V> d(Map.Entry<? extends K, ? extends V> entry) {
            super.d(entry);
            return this;
        }

        public a<K, V> i(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.e(iterable);
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final u0.b<ImmutableSetMultimap> f38395a = u0.a(ImmutableSetMultimap.class, "emptySet");
    }

    public ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> immutableMap, int i11, Comparator<? super V> comparator) {
        super(immutableMap, i11);
        this.emptySet = emptySet(comparator);
    }

    public static <K, V> a<K, V> builder() {
        return new a<>();
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(h0<? extends K, ? extends V> h0Var) {
        return copyOf(h0Var, null);
    }

    private static <K, V> ImmutableSetMultimap<K, V> copyOf(h0<? extends K, ? extends V> h0Var, Comparator<? super V> comparator) {
        com.google.common.base.m.p(h0Var);
        if (h0Var.isEmpty() && comparator == null) {
            return of();
        }
        if (h0Var instanceof ImmutableSetMultimap) {
            ImmutableSetMultimap<K, V> immutableSetMultimap = (ImmutableSetMultimap) h0Var;
            if (!immutableSetMultimap.isPartialView()) {
                return immutableSetMultimap;
            }
        }
        return fromMapEntries(h0Var.asMap().entrySet(), comparator);
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new a().i(iterable).f();
    }

    private static <V> ImmutableSet<V> emptySet(Comparator<? super V> comparator) {
        return comparator == null ? ImmutableSet.of() : ImmutableSortedSet.emptySet(comparator);
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
                bVar.g(key, immutableSetValueSet);
                size += immutableSetValueSet.size();
            }
        }
        return new ImmutableSetMultimap<>(bVar.d(), size, comparator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableSetMultimap<V, K> invert() {
        a aVarBuilder = builder();
        g1 it = entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            aVarBuilder.c(entry.getValue(), entry.getKey());
        }
        ImmutableSetMultimap<V, K> immutableSetMultimapF = aVarBuilder.f();
        immutableSetMultimapF.inverse = this;
        return immutableSetMultimapF;
    }

    public static <K, V> ImmutableSetMultimap<K, V> of() {
        return EmptyImmutableSetMultimap.INSTANCE;
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k11, V v11) {
        a aVarBuilder = builder();
        aVarBuilder.c(k11, v11);
        return aVarBuilder.f();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k11, V v11, K k12, V v12) {
        a aVarBuilder = builder();
        aVarBuilder.c(k11, v11);
        aVarBuilder.c(k12, v12);
        return aVarBuilder.f();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13) {
        a aVarBuilder = builder();
        aVarBuilder.c(k11, v11);
        aVarBuilder.c(k12, v12);
        aVarBuilder.c(k13, v13);
        return aVarBuilder.f();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        a aVarBuilder = builder();
        aVarBuilder.c(k11, v11);
        aVarBuilder.c(k12, v12);
        aVarBuilder.c(k13, v13);
        aVarBuilder.c(k14, v14);
        return aVarBuilder.f();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15) {
        a aVarBuilder = builder();
        aVarBuilder.c(k11, v11);
        aVarBuilder.c(k12, v12);
        aVarBuilder.c(k13, v13);
        aVarBuilder.c(k14, v14);
        aVarBuilder.c(k15, v15);
        return aVarBuilder.f();
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
            Objects.requireNonNull(object);
            int i14 = objectInputStream.readInt();
            if (i14 <= 0) {
                throw new InvalidObjectException("Invalid value count " + i14);
            }
            ImmutableSet.a aVarValuesBuilder = valuesBuilder(comparator);
            for (int i15 = 0; i15 < i14; i15++) {
                Object object2 = objectInputStream.readObject();
                Objects.requireNonNull(object2);
                aVarValuesBuilder.a(object2);
            }
            ImmutableSet immutableSetN = aVarValuesBuilder.n();
            if (immutableSetN.size() != i14) {
                throw new InvalidObjectException("Duplicate key-value pairs exist for key " + object);
            }
            bVarBuilder.g(object, immutableSetN);
            i12 += i14;
        }
        try {
            ImmutableMultimap.d.f38375a.b(this, bVarBuilder.d());
            ImmutableMultimap.d.f38376b.a(this, i12);
            b.f38395a.b(this, emptySet(comparator));
        } catch (IllegalArgumentException e11) {
            throw ((InvalidObjectException) new InvalidObjectException(e11.getMessage()).initCause(e11));
        }
    }

    private static <V> ImmutableSet<V> valueSet(Comparator<? super V> comparator, Collection<? extends V> collection) {
        return comparator == null ? ImmutableSet.copyOf((Collection) collection) : ImmutableSortedSet.copyOf((Comparator) comparator, (Collection) collection);
    }

    private static <V> ImmutableSet.a<V> valuesBuilder(Comparator<? super V> comparator) {
        return comparator == null ? new ImmutableSet.a<>() : new ImmutableSortedSet.a(comparator);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(valueComparator());
        u0.j(this, objectOutputStream);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.h0
    public ImmutableSet<Map.Entry<K, V>> entries() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.entries;
        if (immutableSet != null) {
            return immutableSet;
        }
        EntrySet entrySet = new EntrySet(this);
        this.entries = entrySet;
        return entrySet;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.h0
    public ImmutableSet<V> get(K k11) {
        return (ImmutableSet) com.google.common.base.h.a((ImmutableSet) this.map.get(k11), this.emptySet);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableSetMultimap<V, K> inverse() {
        ImmutableSetMultimap<V, K> immutableSetMultimap = this.inverse;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        ImmutableSetMultimap<V, K> immutableSetMultimapInvert = invert();
        this.inverse = immutableSetMultimapInvert;
        return immutableSetMultimapInvert;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.h0
    @Deprecated
    public final ImmutableSet<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c
    @Deprecated
    public final ImmutableSet<V> replaceValues(K k11, Iterable<? extends V> iterable) {
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
