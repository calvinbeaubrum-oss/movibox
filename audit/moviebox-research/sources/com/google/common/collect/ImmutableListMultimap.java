package com.google.common.collect;

import com.google.j2objc.annotations.RetainedWith;
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
public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> implements g0<K, V> {
    private static final long serialVersionUID = 0;

    @RetainedWith
    private transient ImmutableListMultimap<V, K> inverse;

    /* JADX INFO: compiled from: source.java */
    public static final class a<K, V> extends ImmutableMultimap.c<K, V> {
        public ImmutableListMultimap<K, V> f() {
            return (ImmutableListMultimap) super.a();
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

    public ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> immutableMap, int i11) {
        super(immutableMap, i11);
    }

    public static <K, V> a<K, V> builder() {
        return new a<>();
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(h0<? extends K, ? extends V> h0Var) {
        if (h0Var.isEmpty()) {
            return of();
        }
        if (h0Var instanceof ImmutableListMultimap) {
            ImmutableListMultimap<K, V> immutableListMultimap = (ImmutableListMultimap) h0Var;
            if (!immutableListMultimap.isPartialView()) {
                return immutableListMultimap;
            }
        }
        return fromMapEntries(h0Var.asMap().entrySet(), null);
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new a().i(iterable).f();
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
                bVar.g(key, immutableListCopyOf);
                size += immutableListCopyOf.size();
            }
        }
        return new ImmutableListMultimap<>(bVar.d(), size);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableListMultimap<V, K> invert() {
        a aVarBuilder = builder();
        g1 it = entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            aVarBuilder.c(entry.getValue(), entry.getKey());
        }
        ImmutableListMultimap<V, K> immutableListMultimapF = aVarBuilder.f();
        immutableListMultimapF.inverse = this;
        return immutableListMultimapF;
    }

    public static <K, V> ImmutableListMultimap<K, V> of() {
        return EmptyImmutableListMultimap.INSTANCE;
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k11, V v11) {
        a aVarBuilder = builder();
        aVarBuilder.c(k11, v11);
        return aVarBuilder.f();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k11, V v11, K k12, V v12) {
        a aVarBuilder = builder();
        aVarBuilder.c(k11, v11);
        aVarBuilder.c(k12, v12);
        return aVarBuilder.f();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13) {
        a aVarBuilder = builder();
        aVarBuilder.c(k11, v11);
        aVarBuilder.c(k12, v12);
        aVarBuilder.c(k13, v13);
        return aVarBuilder.f();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        a aVarBuilder = builder();
        aVarBuilder.c(k11, v11);
        aVarBuilder.c(k12, v12);
        aVarBuilder.c(k13, v13);
        aVarBuilder.c(k14, v14);
        return aVarBuilder.f();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15) {
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
            ImmutableList.a aVarBuilder = ImmutableList.builder();
            for (int i15 = 0; i15 < i14; i15++) {
                Object object2 = objectInputStream.readObject();
                Objects.requireNonNull(object2);
                aVarBuilder.a(object2);
            }
            bVarBuilder.g(object, aVarBuilder.m());
            i12 += i14;
        }
        try {
            ImmutableMultimap.d.f38375a.b(this, bVarBuilder.d());
            ImmutableMultimap.d.f38376b.a(this, i12);
        } catch (IllegalArgumentException e11) {
            throw ((InvalidObjectException) new InvalidObjectException(e11.getMessage()).initCause(e11));
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        u0.j(this, objectOutputStream);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.h0
    public ImmutableList<V> get(K k11) {
        ImmutableList<V> immutableList = (ImmutableList) this.map.get(k11);
        return immutableList == null ? ImmutableList.of() : immutableList;
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableListMultimap<V, K> inverse() {
        ImmutableListMultimap<V, K> immutableListMultimap = this.inverse;
        if (immutableListMultimap != null) {
            return immutableListMultimap;
        }
        ImmutableListMultimap<V, K> immutableListMultimapInvert = invert();
        this.inverse = immutableListMultimapInvert;
        return immutableListMultimapInvert;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.h0
    @Deprecated
    public final ImmutableList<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c
    @Deprecated
    public final ImmutableList<V> replaceValues(K k11, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }
}
