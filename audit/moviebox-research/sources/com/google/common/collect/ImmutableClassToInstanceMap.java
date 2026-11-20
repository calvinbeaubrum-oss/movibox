package com.google.common.collect;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ImmutableClassToInstanceMap<B> extends u<Class<? extends B>, B> implements Serializable {
    private static final ImmutableClassToInstanceMap<Object> EMPTY = new ImmutableClassToInstanceMap<>(ImmutableMap.of());
    private final ImmutableMap<Class<? extends B>, B> delegate;

    /* JADX INFO: compiled from: source.java */
    public static final class b<B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableMap.b<Class<? extends B>, B> f38345a = ImmutableMap.builder();

        public static <T> T b(Class<T> cls, Object obj) {
            return (T) com.google.common.primitives.e.d(cls).cast(obj);
        }

        public ImmutableClassToInstanceMap<B> a() {
            ImmutableMap<Class<? extends B>, B> immutableMapD = this.f38345a.d();
            return immutableMapD.isEmpty() ? ImmutableClassToInstanceMap.of() : new ImmutableClassToInstanceMap<>(immutableMapD);
        }

        public <T extends B> b<B> c(Map<? extends Class<? extends T>, ? extends T> map) {
            for (Map.Entry<? extends Class<? extends T>, ? extends T> entry : map.entrySet()) {
                Class key = entry.getKey();
                T value = entry.getValue();
                this.f38345a.g((Class<? extends B>) key, (B) b(key, value));
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

    @Override // com.google.common.collect.u, com.google.common.collect.x
    /* JADX INFO: renamed from: delegate */
    public Map<Class<? extends B>, B> u() {
        return this.delegate;
    }

    public <T extends B> T getInstance(Class<T> cls) {
        return this.delegate.get(com.google.common.base.m.p(cls));
    }

    @Deprecated
    public <T extends B> T putInstance(Class<T> cls, T t11) {
        throw new UnsupportedOperationException();
    }

    public Object readResolve() {
        return isEmpty() ? of() : this;
    }
}
