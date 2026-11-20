package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class ImmutableClassToInstanceMap<B> extends q2<Class<? extends B>, B> implements Serializable {
    private static final ImmutableClassToInstanceMap<Object> EMPTY = new ImmutableClassToInstanceMap<>(ImmutableMap.of());
    private final ImmutableMap<Class<? extends B>, B> delegate;

    /* JADX INFO: compiled from: source.java */
    public static final class b<B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableMap.b<Class<? extends B>, B> f39324a = ImmutableMap.builder();

        public static <B, T extends B> T b(Class<T> cls, B b11) {
            return (T) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives.m.d(cls).cast(b11);
        }

        public ImmutableClassToInstanceMap<B> a() {
            ImmutableMap<Class<? extends B>, B> immutableMapA = this.f39324a.a();
            return immutableMapA.isEmpty() ? ImmutableClassToInstanceMap.of() : new ImmutableClassToInstanceMap<>(immutableMapA);
        }

        public <T extends B> b<B> c(Map<? extends Class<? extends T>, ? extends T> map) {
            for (Map.Entry<? extends Class<? extends T>, ? extends T> entry : map.entrySet()) {
                Class key = entry.getKey();
                T value = entry.getValue();
                this.f39324a.d((Class<? extends B>) key, (B) b(key, value));
            }
            return this;
        }
    }

    private ImmutableClassToInstanceMap(ImmutableMap<Class<? extends B>, B> immutableMap) {
        this.delegate = immutableMap;
    }

    public static <B> b<B> builder() {
        return new b<>();
    }

    public static <B, S extends B> ImmutableClassToInstanceMap<B> copyOf(Map<? extends Class<? extends S>, ? extends S> map) {
        return map instanceof ImmutableClassToInstanceMap ? (ImmutableClassToInstanceMap) map : new b().c(map).a();
    }

    public static <B> ImmutableClassToInstanceMap<B> of() {
        return (ImmutableClassToInstanceMap<B>) EMPTY;
    }

    public static <B, T extends B> ImmutableClassToInstanceMap<B> of(Class<T> cls, T t11) {
        return new ImmutableClassToInstanceMap<>(ImmutableMap.of(cls, t11));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t2
    public Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }

    public <T extends B> T getInstance(Class<T> cls) {
        return this.delegate.get(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(cls));
    }

    @Deprecated
    public <T extends B> T putInstance(Class<T> cls, T t11) {
        throw new UnsupportedOperationException();
    }

    public Object readResolve() {
        return isEmpty() ? of() : this;
    }
}
