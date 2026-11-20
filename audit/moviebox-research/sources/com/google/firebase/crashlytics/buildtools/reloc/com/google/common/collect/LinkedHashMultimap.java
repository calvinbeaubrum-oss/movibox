package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class LinkedHashMultimap<K, V> extends LinkedHashMultimapGwtSerializationDependencies<K, V> {
    private static final int DEFAULT_KEY_CAPACITY = 16;
    private static final int DEFAULT_VALUE_SET_CAPACITY = 2;
    static final double VALUE_SET_LOAD_FACTOR = 1.0d;
    private static final long serialVersionUID = 1;
    private transient ValueEntry<K, V> multimapHeaderEntry;
    transient int valueSetCapacity;

    /* JADX INFO: compiled from: source.java */
    public static final class ValueEntry<K, V> extends ImmutableEntry<K, V> implements c<K, V> {
        ValueEntry<K, V> nextInValueBucket;
        ValueEntry<K, V> predecessorInMultimap;
        c<K, V> predecessorInValueSet;
        final int smearedValueHash;
        ValueEntry<K, V> successorInMultimap;
        c<K, V> successorInValueSet;

        public ValueEntry(K k11, V v11, int i11, ValueEntry<K, V> valueEntry) {
            super(k11, v11);
            this.smearedValueHash = i11;
            this.nextInValueBucket = valueEntry;
        }

        public ValueEntry<K, V> getPredecessorInMultimap() {
            return this.predecessorInMultimap;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.LinkedHashMultimap.c
        public c<K, V> getPredecessorInValueSet() {
            return this.predecessorInValueSet;
        }

        public ValueEntry<K, V> getSuccessorInMultimap() {
            return this.successorInMultimap;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.LinkedHashMultimap.c
        public c<K, V> getSuccessorInValueSet() {
            return this.successorInValueSet;
        }

        public boolean matchesValue(Object obj, int i11) {
            return this.smearedValueHash == i11 && com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.g.a(getValue(), obj);
        }

        public void setPredecessorInMultimap(ValueEntry<K, V> valueEntry) {
            this.predecessorInMultimap = valueEntry;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.LinkedHashMultimap.c
        public void setPredecessorInValueSet(c<K, V> cVar) {
            this.predecessorInValueSet = cVar;
        }

        public void setSuccessorInMultimap(ValueEntry<K, V> valueEntry) {
            this.successorInMultimap = valueEntry;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.LinkedHashMultimap.c
        public void setSuccessorInValueSet(c<K, V> cVar) {
            this.successorInValueSet = cVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ValueEntry<K, V> f39423a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ValueEntry<K, V> f39424b;

        public a() {
            this.f39423a = LinkedHashMultimap.this.multimapHeaderEntry.successorInMultimap;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            ValueEntry<K, V> valueEntry = this.f39423a;
            this.f39424b = valueEntry;
            this.f39423a = valueEntry.successorInMultimap;
            return valueEntry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f39423a != LinkedHashMultimap.this.multimapHeaderEntry;
        }

        @Override // java.util.Iterator
        public void remove() {
            n1.e(this.f39424b != null);
            LinkedHashMultimap.this.remove(this.f39424b.getKey(), this.f39424b.getValue());
            this.f39424b = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class b extends Sets.a<V> implements c<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f39426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ValueEntry<K, V>[] f39427b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f39428c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f39429d = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public c<K, V> f39430f = this;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public c<K, V> f39431g = this;

        /* JADX INFO: compiled from: source.java */
        public class a implements Iterator<V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public c<K, V> f39433a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public ValueEntry<K, V> f39434b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f39435c;

            public a() {
                this.f39433a = b.this.f39430f;
                this.f39435c = b.this.f39429d;
            }

            public final void a() {
                if (b.this.f39429d != this.f39435c) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                return this.f39433a != b.this;
            }

            @Override // java.util.Iterator
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                ValueEntry<K, V> valueEntry = (ValueEntry) this.f39433a;
                V value = valueEntry.getValue();
                this.f39434b = valueEntry;
                this.f39433a = valueEntry.getSuccessorInValueSet();
                return value;
            }

            @Override // java.util.Iterator
            public void remove() {
                a();
                n1.e(this.f39434b != null);
                b.this.remove(this.f39434b.getValue());
                this.f39435c = b.this.f39429d;
                this.f39434b = null;
            }
        }

        public b(K k11, int i11) {
            this.f39426a = k11;
            this.f39427b = new ValueEntry[y2.a(i11, 1.0d)];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(V v11) {
            int iD = y2.d(v11);
            int iE = e() & iD;
            ValueEntry<K, V> valueEntry = this.f39427b[iE];
            for (ValueEntry<K, V> valueEntry2 = valueEntry; valueEntry2 != null; valueEntry2 = valueEntry2.nextInValueBucket) {
                if (valueEntry2.matchesValue(v11, iD)) {
                    return false;
                }
            }
            ValueEntry<K, V> valueEntry3 = new ValueEntry<>(this.f39426a, v11, iD, valueEntry);
            LinkedHashMultimap.succeedsInValueSet(this.f39431g, valueEntry3);
            LinkedHashMultimap.succeedsInValueSet(valueEntry3, this);
            LinkedHashMultimap.succeedsInMultimap(LinkedHashMultimap.this.multimapHeaderEntry.getPredecessorInMultimap(), valueEntry3);
            LinkedHashMultimap.succeedsInMultimap(valueEntry3, LinkedHashMultimap.this.multimapHeaderEntry);
            this.f39427b[iE] = valueEntry3;
            this.f39428c++;
            this.f39429d++;
            f();
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Arrays.fill(this.f39427b, (Object) null);
            this.f39428c = 0;
            for (c<K, V> successorInValueSet = this.f39430f; successorInValueSet != this; successorInValueSet = successorInValueSet.getSuccessorInValueSet()) {
                LinkedHashMultimap.deleteFromMultimap((ValueEntry) successorInValueSet);
            }
            LinkedHashMultimap.succeedsInValueSet(this, this);
            this.f39429d++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            int iD = y2.d(obj);
            for (ValueEntry<K, V> valueEntry = this.f39427b[e() & iD]; valueEntry != null; valueEntry = valueEntry.nextInValueBucket) {
                if (valueEntry.matchesValue(obj, iD)) {
                    return true;
                }
            }
            return false;
        }

        public final int e() {
            return this.f39427b.length - 1;
        }

        public final void f() {
            if (y2.b(this.f39428c, this.f39427b.length, 1.0d)) {
                int length = this.f39427b.length * 2;
                ValueEntry<K, V>[] valueEntryArr = new ValueEntry[length];
                this.f39427b = valueEntryArr;
                int i11 = length - 1;
                for (c<K, V> successorInValueSet = this.f39430f; successorInValueSet != this; successorInValueSet = successorInValueSet.getSuccessorInValueSet()) {
                    ValueEntry<K, V> valueEntry = (ValueEntry) successorInValueSet;
                    int i12 = valueEntry.smearedValueHash & i11;
                    valueEntry.nextInValueBucket = valueEntryArr[i12];
                    valueEntryArr[i12] = valueEntry;
                }
            }
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super V> consumer) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(consumer);
            for (c<K, V> successorInValueSet = this.f39430f; successorInValueSet != this; successorInValueSet = successorInValueSet.getSuccessorInValueSet()) {
                consumer.accept(((ValueEntry) successorInValueSet).getValue());
            }
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.LinkedHashMultimap.c
        public c<K, V> getPredecessorInValueSet() {
            return this.f39431g;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.LinkedHashMultimap.c
        public c<K, V> getSuccessorInValueSet() {
            return this.f39430f;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int iD = y2.d(obj);
            int iE = e() & iD;
            ValueEntry<K, V> valueEntry = null;
            for (ValueEntry<K, V> valueEntry2 = this.f39427b[iE]; valueEntry2 != null; valueEntry2 = valueEntry2.nextInValueBucket) {
                if (valueEntry2.matchesValue(obj, iD)) {
                    if (valueEntry == null) {
                        this.f39427b[iE] = valueEntry2.nextInValueBucket;
                    } else {
                        valueEntry.nextInValueBucket = valueEntry2.nextInValueBucket;
                    }
                    LinkedHashMultimap.deleteFromValueSet(valueEntry2);
                    LinkedHashMultimap.deleteFromMultimap(valueEntry2);
                    this.f39428c--;
                    this.f39429d++;
                    return true;
                }
                valueEntry = valueEntry2;
            }
            return false;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.LinkedHashMultimap.c
        public void setPredecessorInValueSet(c<K, V> cVar) {
            this.f39431g = cVar;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.LinkedHashMultimap.c
        public void setSuccessorInValueSet(c<K, V> cVar) {
            this.f39430f = cVar;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f39428c;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c<K, V> {
        c<K, V> getPredecessorInValueSet();

        c<K, V> getSuccessorInValueSet();

        void setPredecessorInValueSet(c<K, V> cVar);

        void setSuccessorInValueSet(c<K, V> cVar);
    }

    private LinkedHashMultimap(int i11, int i12) {
        super(r6.d(i11));
        this.valueSetCapacity = 2;
        n1.b(i12, "expectedValuesPerKey");
        this.valueSetCapacity = i12;
        ValueEntry<K, V> valueEntry = new ValueEntry<>(null, null, 0, null);
        this.multimapHeaderEntry = valueEntry;
        succeedsInMultimap(valueEntry, valueEntry);
    }

    public static <K, V> LinkedHashMultimap<K, V> create() {
        return new LinkedHashMultimap<>(16, 2);
    }

    public static <K, V> LinkedHashMultimap<K, V> create(int i11, int i12) {
        return new LinkedHashMultimap<>(Maps.b(i11), Maps.b(i12));
    }

    public static <K, V> LinkedHashMultimap<K, V> create(z5<? extends K, ? extends V> z5Var) {
        LinkedHashMultimap<K, V> linkedHashMultimapCreate = create(z5Var.keySet().size(), 2);
        linkedHashMultimapCreate.putAll(z5Var);
        return linkedHashMultimapCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void deleteFromMultimap(ValueEntry<K, V> valueEntry) {
        succeedsInMultimap(valueEntry.getPredecessorInMultimap(), valueEntry.getSuccessorInMultimap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void deleteFromValueSet(c<K, V> cVar) {
        succeedsInValueSet(cVar.getPredecessorInValueSet(), cVar.getSuccessorInValueSet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        ValueEntry<K, V> valueEntry = new ValueEntry<>(null, null, 0, null);
        this.multimapHeaderEntry = valueEntry;
        succeedsInMultimap(valueEntry, valueEntry);
        this.valueSetCapacity = 2;
        int i11 = objectInputStream.readInt();
        Map mapD = r6.d(12);
        for (int i12 = 0; i12 < i11; i12++) {
            Object object = objectInputStream.readObject();
            mapD.put(object, createCollection(object));
        }
        int i13 = objectInputStream.readInt();
        for (int i14 = 0; i14 < i13; i14++) {
            Object object2 = objectInputStream.readObject();
            ((Collection) mapD.get(object2)).add(objectInputStream.readObject());
        }
        setMap(mapD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void succeedsInMultimap(ValueEntry<K, V> valueEntry, ValueEntry<K, V> valueEntry2) {
        valueEntry.setSuccessorInMultimap(valueEntry2);
        valueEntry2.setPredecessorInMultimap(valueEntry);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void succeedsInValueSet(c<K, V> cVar, c<K, V> cVar2) {
        cVar.setSuccessorInValueSet(cVar2);
        cVar2.setPredecessorInValueSet(cVar);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(keySet().size());
        Iterator<K> it = keySet().iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public void clear() {
        super.clear();
        ValueEntry<K, V> valueEntry = this.multimapHeaderEntry;
        succeedsInMultimap(valueEntry, valueEntry);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> createCollection(K k11) {
        return new b(k11, this.valueSetCapacity);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap
    public Set<V> createCollection() {
        return r6.e(this.valueSetCapacity);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public Set<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public Iterator<Map.Entry<K, V>> entryIterator() {
        return new a();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public Spliterator<Map.Entry<K, V>> entrySpliterator() {
        return Spliterators.spliterator(entries(), 17);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap
    public /* bridge */ /* synthetic */ void forEach(BiConsumer biConsumer) {
        super.forEach(biConsumer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ Set get(Object obj) {
        return super.get(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public Set<K> keySet() {
        return super.keySet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public /* bridge */ /* synthetic */ l6 keys() {
        return super.keys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public /* bridge */ /* synthetic */ boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ boolean putAll(z5 z5Var) {
        return super.putAll(z5Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ Set removeAll(Object obj) {
        return super.removeAll(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public Set<V> replaceValues(K k11, Iterable<? extends V> iterable) {
        return super.replaceValues((Object) k11, (Iterable) iterable);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public Iterator<V> valueIterator() {
        return Maps.y(entryIterator());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public Spliterator<V> valueSpliterator() {
        return x1.e(entrySpliterator(), new s3());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public Collection<V> values() {
        return super.values();
    }
}
