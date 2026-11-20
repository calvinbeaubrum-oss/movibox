package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class MutableClassToInstanceMap<B> extends u<Class<? extends B>, B> implements Serializable {
    private final Map<Class<? extends B>, B> delegate;

    /* JADX INFO: compiled from: source.java */
    public static final class SerializedForm<B> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Map<Class<? extends B>, B> backingMap;

        public SerializedForm(Map<Class<? extends B>, B> map) {
            this.backingMap = map;
        }

        public Object readResolve() {
            return MutableClassToInstanceMap.create(this.backingMap);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends v<Class<? extends B>, B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map.Entry f38545a;

        public a(Map.Entry entry) {
            this.f38545a = entry;
        }

        @Override // com.google.common.collect.v, java.util.Map.Entry
        public B setValue(B b11) {
            MutableClassToInstanceMap.cast(getKey(), b11);
            return (B) super.setValue(b11);
        }

        @Override // com.google.common.collect.x
        public Map.Entry<Class<? extends B>, B> u() {
            return this.f38545a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends z<Map.Entry<Class<? extends B>, B>> {

        /* JADX INFO: compiled from: source.java */
        public class a extends d1<Map.Entry<Class<? extends B>, B>, Map.Entry<Class<? extends B>, B>> {
            public a(b bVar, Iterator it) {
                super(it);
            }

            @Override // com.google.common.collect.d1
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<Class<? extends B>, B> a(Map.Entry<Class<? extends B>, B> entry) {
                return MutableClassToInstanceMap.checkedEntry(entry);
            }
        }

        public b() {
        }

        @Override // com.google.common.collect.z, com.google.common.collect.r, com.google.common.collect.x
        /* JADX INFO: renamed from: delegate */
        public Set<Map.Entry<Class<? extends B>, B>> u() {
            return MutableClassToInstanceMap.this.u().entrySet();
        }

        @Override // com.google.common.collect.r, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Class<? extends B>, B>> iterator() {
            return new a(this, u().iterator());
        }

        @Override // com.google.common.collect.r, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.r, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }
    }

    private MutableClassToInstanceMap(Map<Class<? extends B>, B> map) {
        this.delegate = (Map) com.google.common.base.m.p(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T cast(Class<T> cls, Object obj) {
        return (T) com.google.common.primitives.e.d(cls).cast(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <B> Map.Entry<Class<? extends B>, B> checkedEntry(Map.Entry<Class<? extends B>, B> entry) {
        return new a(entry);
    }

    public static <B> MutableClassToInstanceMap<B> create() {
        return new MutableClassToInstanceMap<>(new HashMap());
    }

    public static <B> MutableClassToInstanceMap<B> create(Map<Class<? extends B>, B> map) {
        return new MutableClassToInstanceMap<>(map);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    private Object writeReplace() {
        return new SerializedForm(u());
    }

    @Override // com.google.common.collect.u, com.google.common.collect.x
    /* JADX INFO: renamed from: delegate */
    public Map<Class<? extends B>, B> u() {
        return this.delegate;
    }

    @Override // com.google.common.collect.u, java.util.Map
    public Set<Map.Entry<Class<? extends B>, B>> entrySet() {
        return new b();
    }

    public <T extends B> T getInstance(Class<T> cls) {
        return (T) cast(cls, get(cls));
    }

    @Override // com.google.common.collect.u, java.util.Map
    public B put(Class<? extends B> cls, B b11) {
        cast(cls, b11);
        return (B) super.put(cls, b11);
    }

    @Override // com.google.common.collect.u, java.util.Map
    public void putAll(Map<? extends Class<? extends B>, ? extends B> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            cast((Class) entry.getKey(), entry.getValue());
        }
        super.putAll(linkedHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends B> T putInstance(Class<T> cls, T t11) {
        return (T) cast(cls, put((Class<? extends T>) cls, t11));
    }
}
