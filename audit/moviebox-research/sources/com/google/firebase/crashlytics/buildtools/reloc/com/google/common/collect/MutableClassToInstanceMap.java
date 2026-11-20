package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Function;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class MutableClassToInstanceMap<B> extends q2<Class<? extends B>, B> implements Serializable {
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
    public static class a extends r2<Class<? extends B>, B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map.Entry f39542a;

        public a(Map.Entry entry) {
            this.f39542a = entry;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t2
        /* JADX INFO: renamed from: f */
        public Map.Entry<Class<? extends B>, B> delegate() {
            return this.f39542a;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.r2, java.util.Map.Entry
        public B setValue(B b11) {
            return (B) super.setValue(MutableClassToInstanceMap.cast(getKey(), b11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends v2<Map.Entry<Class<? extends B>, B>> {

        /* JADX INFO: compiled from: source.java */
        public class a extends r7<Map.Entry<Class<? extends B>, B>, Map.Entry<Class<? extends B>, B>> {
            public a(Iterator it) {
                super(it);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.r7
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<Class<? extends B>, B> a(Map.Entry<Class<? extends B>, B> entry) {
                return MutableClassToInstanceMap.checkedEntry(entry);
            }
        }

        public b() {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t2
        public Set<Map.Entry<Class<? extends B>, B>> delegate() {
            return MutableClassToInstanceMap.this.delegate().entrySet();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Class<? extends B>, B>> iterator() {
            return new a(delegate().iterator());
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public Spliterator<Map.Entry<Class<? extends B>, B>> spliterator() {
            return x1.e(delegate().spliterator(), new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.o6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return MutableClassToInstanceMap.access$100((Map.Entry) obj);
                }
            });
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }
    }

    private MutableClassToInstanceMap(Map<Class<? extends B>, B> map) {
        this.delegate = (Map) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(map);
    }

    public static /* synthetic */ Map.Entry access$100(Map.Entry entry) {
        return checkedEntry(entry);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <B, T extends B> T cast(Class<T> cls, B b11) {
        return (T) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives.m.d(cls).cast(b11);
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

    private Object writeReplace() {
        return new SerializedForm(delegate());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t2
    public Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, java.util.Map
    public Set<Map.Entry<Class<? extends B>, B>> entrySet() {
        return new b();
    }

    public <T extends B> T getInstance(Class<T> cls) {
        return (T) cast(cls, get(cls));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, java.util.Map
    public B put(Class<? extends B> cls, B b11) {
        return (B) super.put(cls, cast(cls, b11));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, java.util.Map
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
