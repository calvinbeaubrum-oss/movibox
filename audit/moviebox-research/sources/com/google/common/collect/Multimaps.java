package com.google.common.collect;

import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class Multimaps {

    /* JADX INFO: compiled from: source.java */
    public static class CustomListMultimap<K, V> extends AbstractListMultimap<K, V> {
        private static final long serialVersionUID = 0;
        transient com.google.common.base.q<? extends List<V>> factory;

        public CustomListMultimap(Map<K, Collection<V>> map, com.google.common.base.q<? extends List<V>> qVar) {
            super(map);
            this.factory = (com.google.common.base.q) com.google.common.base.m.p(qVar);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            Object object = objectInputStream.readObject();
            Objects.requireNonNull(object);
            this.factory = (com.google.common.base.q) object;
            Object object2 = objectInputStream.readObject();
            Objects.requireNonNull(object2);
            setMap((Map) object2);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public List<V> createCollection() {
            return this.factory.get2();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a<K, V> extends Maps.q<K, Collection<V>> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Weak
        public final h0<K, V> f38535d;

        /* JADX INFO: renamed from: com.google.common.collect.Multimaps$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0393a extends Maps.i<K, Collection<V>> {
            public C0393a() {
            }

            @Override // com.google.common.collect.Maps.i
            public Map<K, Collection<V>> a() {
                return a.this;
            }

            public final /* synthetic */ Collection e(Object obj) {
                return a.this.f38535d.get(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return Maps.c(a.this.f38535d.keySet(), new com.google.common.base.f() { // from class: com.google.common.collect.i0
                    @Override // com.google.common.base.f
                    public final Object apply(Object obj) {
                        return this.f38701a.e(obj);
                    }
                });
            }

            @Override // com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                a.this.h(entry.getKey());
                return true;
            }
        }

        public a(h0<K, V> h0Var) {
            this.f38535d = (h0) com.google.common.base.m.p(h0Var);
        }

        @Override // com.google.common.collect.Maps.q
        public Set<Map.Entry<K, Collection<V>>> a() {
            return new C0393a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f38535d.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f38535d.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Collection<V> get(Object obj) {
            if (containsKey(obj)) {
                return this.f38535d.get(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Collection<V> remove(Object obj) {
            if (containsKey(obj)) {
                return this.f38535d.removeAll(obj);
            }
            return null;
        }

        public void h(Object obj) {
            this.f38535d.keySet().remove(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f38535d.isEmpty();
        }

        @Override // com.google.common.collect.Maps.q, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f38535d.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f38535d.keySet().size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class b<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        public abstract h0<K, V> a();

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a().containsEntry(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a().remove(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c<K, V> extends d<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Weak
        public final h0<K, V> f38537a;

        /* JADX INFO: compiled from: source.java */
        public class a extends d1<Map.Entry<K, Collection<V>>, j0.a<K>> {

            /* JADX INFO: renamed from: com.google.common.collect.Multimaps$c$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            public class C0394a extends Multisets.b<K> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Map.Entry f38538a;

                public C0394a(a aVar, Map.Entry entry) {
                    this.f38538a = entry;
                }

                @Override // com.google.common.collect.j0.a
                public int getCount() {
                    return ((Collection) this.f38538a.getValue()).size();
                }

                @Override // com.google.common.collect.j0.a
                public K getElement() {
                    return (K) this.f38538a.getKey();
                }
            }

            public a(c cVar, Iterator it) {
                super(it);
            }

            @Override // com.google.common.collect.d1
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public j0.a<K> a(Map.Entry<K, Collection<V>> entry) {
                return new C0394a(this, entry);
            }
        }

        public c(h0<K, V> h0Var) {
            this.f38537a = h0Var;
        }

        @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f38537a.clear();
        }

        @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j0
        public boolean contains(Object obj) {
            return this.f38537a.containsKey(obj);
        }

        @Override // com.google.common.collect.j0
        public int count(Object obj) {
            Collection collection = (Collection) Maps.v(this.f38537a.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        @Override // com.google.common.collect.d
        public int distinctElements() {
            return this.f38537a.asMap().size();
        }

        @Override // com.google.common.collect.d
        public Iterator<K> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.d, com.google.common.collect.j0
        public Set<K> elementSet() {
            return this.f38537a.keySet();
        }

        @Override // com.google.common.collect.d
        public Iterator<j0.a<K>> entryIterator() {
            return new a(this, this.f38537a.asMap().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return Maps.l(this.f38537a.entries().iterator());
        }

        @Override // com.google.common.collect.d, com.google.common.collect.j0
        public int remove(Object obj, int i11) {
            l.b(i11, "occurrences");
            if (i11 == 0) {
                return count(obj);
            }
            Collection collection = (Collection) Maps.v(this.f38537a.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            int size = collection.size();
            if (i11 >= size) {
                collection.clear();
            } else {
                Iterator it = collection.iterator();
                for (int i12 = 0; i12 < i11; i12++) {
                    it.next();
                    it.remove();
                }
            }
            return size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j0
        public int size() {
            return this.f38537a.size();
        }
    }

    public static boolean a(h0<?, ?> h0Var, Object obj) {
        if (obj == h0Var) {
            return true;
        }
        if (obj instanceof h0) {
            return h0Var.asMap().equals(((h0) obj).asMap());
        }
        return false;
    }

    public static <K, V> g0<K, V> b(Map<K, Collection<V>> map, com.google.common.base.q<? extends List<V>> qVar) {
        return new CustomListMultimap(map, qVar);
    }
}
