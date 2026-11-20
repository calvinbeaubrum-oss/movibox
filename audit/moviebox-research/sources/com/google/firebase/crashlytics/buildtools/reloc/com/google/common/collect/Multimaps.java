package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class Multimaps {

    /* JADX INFO: compiled from: source.java */
    public static class CustomListMultimap<K, V> extends AbstractListMultimap<K, V> {
        private static final long serialVersionUID = 0;
        transient com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.q<? extends List<V>> factory;

        public CustomListMultimap(Map<K, Collection<V>> map, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.q<? extends List<V>> qVar) {
            super(map);
            this.factory = (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.q) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(qVar);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.factory = (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.q) objectInputStream.readObject();
            setMap((Map) objectInputStream.readObject());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractListMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap
        public List<V> createCollection() {
            return this.factory.get();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class CustomSetMultimap<K, V> extends AbstractSetMultimap<K, V> {
        private static final long serialVersionUID = 0;
        transient com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.q<? extends Set<V>> factory;

        public CustomSetMultimap(Map<K, Collection<V>> map, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.q<? extends Set<V>> qVar) {
            super(map);
            this.factory = (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.q) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(qVar);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.factory = (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.q) objectInputStream.readObject();
            setMap((Map) objectInputStream.readObject());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap
        public Set<V> createCollection() {
            return this.factory.get();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap
        public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
            if (collection instanceof NavigableSet) {
                return Sets.j((NavigableSet) collection);
            }
            return collection instanceof SortedSet ? Collections.unmodifiableSortedSet((SortedSet) collection) : Collections.unmodifiableSet((Set) collection);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap
        public Collection<V> wrapCollection(K k11, Collection<V> collection) {
            if (collection instanceof NavigableSet) {
                return new AbstractMapBasedMultimap.m(k11, (NavigableSet) collection, null);
            }
            return collection instanceof SortedSet ? new AbstractMapBasedMultimap.o(k11, (SortedSet) collection, null) : new AbstractMapBasedMultimap.n(k11, (Set) collection);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a<K, V> extends Maps.m<K, Collection<V>> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final z5<K, V> f39529d;

        /* JADX INFO: renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multimaps$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0411a extends Maps.g<K, Collection<V>> {

            /* JADX INFO: renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multimaps$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            public class C0412a implements com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<K, Collection<V>> {
                public C0412a() {
                }

                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d, java.util.function.Function
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Collection<V> apply(K k11) {
                    return a.this.f39529d.get(k11);
                }
            }

            public C0411a() {
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.g
            public Map<K, Collection<V>> a() {
                return a.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return Maps.a(a.this.f39529d.keySet(), new C0412a());
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.g, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                a.this.h(((Map.Entry) obj).getKey());
                return true;
            }
        }

        public a(z5<K, V> z5Var) {
            this.f39529d = (z5) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(z5Var);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.m
        public Set<Map.Entry<K, Collection<V>>> a() {
            return new C0411a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f39529d.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f39529d.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Collection<V> get(Object obj) {
            if (containsKey(obj)) {
                return this.f39529d.get(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Collection<V> remove(Object obj) {
            if (containsKey(obj)) {
                return this.f39529d.removeAll(obj);
            }
            return null;
        }

        public void h(Object obj) {
            this.f39529d.keySet().remove(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f39529d.isEmpty();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.m, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f39529d.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f39529d.keySet().size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class b<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        public abstract z5<K, V> a();

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
    public static class c<K, V> extends t<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z5<K, V> f39532a;

        /* JADX INFO: compiled from: source.java */
        public class a extends r7<Map.Entry<K, Collection<V>>, l6.a<K>> {

            /* JADX INFO: renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multimaps$c$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            public class C0413a extends Multisets.b<K> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Map.Entry f39534a;

                public C0413a(Map.Entry entry) {
                    this.f39534a = entry;
                }

                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6.a
                public int getCount() {
                    return ((Collection) this.f39534a.getValue()).size();
                }

                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6.a
                public K getElement() {
                    return (K) this.f39534a.getKey();
                }
            }

            public a(Iterator it) {
                super(it);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.r7
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public l6.a<K> a(Map.Entry<K, Collection<V>> entry) {
                return new C0413a(entry);
            }
        }

        public c(z5<K, V> z5Var) {
            this.f39532a = z5Var;
        }

        public static /* synthetic */ void b(Consumer consumer, Map.Entry entry) {
            consumer.accept(entry.getKey());
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f39532a.clear();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, java.util.AbstractCollection, java.util.Collection, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
        public boolean contains(Object obj) {
            return this.f39532a.containsKey(obj);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
        public int count(Object obj) {
            Collection collection = (Collection) Maps.s(this.f39532a.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t
        public int distinctElements() {
            return this.f39532a.asMap().size();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t
        public Iterator<K> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
        public Set<K> elementSet() {
            return this.f39532a.keySet();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t
        public Iterator<l6.a<K>> entryIterator() {
            return new a(this.f39532a.asMap().entrySet().iterator());
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, java.lang.Iterable
        public void forEach(final Consumer<? super K> consumer) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(consumer);
            this.f39532a.entries().forEach(new Consumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g6
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    Multimaps.c.b(consumer, (Map.Entry) obj);
                }
            });
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return Maps.j(this.f39532a.entries().iterator());
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
        public int remove(Object obj, int i11) {
            n1.b(i11, "occurrences");
            if (i11 == 0) {
                return count(obj);
            }
            Collection collection = (Collection) Maps.s(this.f39532a.asMap(), obj);
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

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
        public int size() {
            return this.f39532a.size();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, java.util.Collection, java.lang.Iterable
        public Spliterator<K> spliterator() {
            return x1.e(this.f39532a.entries().spliterator(), new o3());
        }
    }

    public static boolean c(z5<?, ?> z5Var, Object obj) {
        if (obj == z5Var) {
            return true;
        }
        if (obj instanceof z5) {
            return z5Var.asMap().equals(((z5) obj).asMap());
        }
        return false;
    }

    public static <T, K, V, M extends z5<K, V>> Collector<T, ?, M> d(final Function<? super T, ? extends K> function, final Function<? super T, ? extends Stream<? extends V>> function2, Supplier<M> supplier) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(function);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(function2);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(supplier);
        return Collector.of(supplier, new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.d6
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Multimaps.e(function, function2, (z5) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.e6
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Multimaps.f((z5) obj, (z5) obj2);
            }
        }, new Collector.Characteristics[0]);
    }

    public static /* synthetic */ void e(Function function, Function function2, z5 z5Var, Object obj) {
        final Collection collection = z5Var.get(function.apply(obj));
        Stream streamA = b3.a(function2.apply(obj));
        collection.getClass();
        streamA.forEachOrdered(new Consumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.f6
            @Override // java.util.function.Consumer
            public final void accept(Object obj2) {
                collection.add(obj2);
            }
        });
    }

    public static /* synthetic */ z5 f(z5 z5Var, z5 z5Var2) {
        z5Var.putAll(z5Var2);
        return z5Var;
    }

    public static <K, V> q5<K, V> g(Map<K, Collection<V>> map, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.q<? extends List<V>> qVar) {
        return new CustomListMultimap(map, qVar);
    }

    public static <K, V> z6<K, V> h(Map<K, Collection<V>> map, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.q<? extends Set<V>> qVar) {
        return new CustomSetMultimap(map, qVar);
    }
}
