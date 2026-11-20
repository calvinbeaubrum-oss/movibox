package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
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

        public static <K, V> ValueEntry<K, V> newHeader() {
            return new ValueEntry<>(null, null, 0, null);
        }

        public ValueEntry<K, V> getPredecessorInMultimap() {
            ValueEntry<K, V> valueEntry = this.predecessorInMultimap;
            Objects.requireNonNull(valueEntry);
            return valueEntry;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public c<K, V> getPredecessorInValueSet() {
            c<K, V> cVar = this.predecessorInValueSet;
            Objects.requireNonNull(cVar);
            return cVar;
        }

        public ValueEntry<K, V> getSuccessorInMultimap() {
            ValueEntry<K, V> valueEntry = this.successorInMultimap;
            Objects.requireNonNull(valueEntry);
            return valueEntry;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public c<K, V> getSuccessorInValueSet() {
            c<K, V> cVar = this.successorInValueSet;
            Objects.requireNonNull(cVar);
            return cVar;
        }

        public boolean matchesValue(Object obj, int i11) {
            return this.smearedValueHash == i11 && com.google.common.base.j.a(getValue(), obj);
        }

        public void setPredecessorInMultimap(ValueEntry<K, V> valueEntry) {
            this.predecessorInMultimap = valueEntry;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public void setPredecessorInValueSet(c<K, V> cVar) {
            this.predecessorInValueSet = cVar;
        }

        public void setSuccessorInMultimap(ValueEntry<K, V> valueEntry) {
            this.successorInMultimap = valueEntry;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public void setSuccessorInValueSet(c<K, V> cVar) {
            this.successorInValueSet = cVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ValueEntry<K, V> f38425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ValueEntry<K, V> f38426b;

        public a() {
            this.f38425a = LinkedHashMultimap.this.multimapHeaderEntry.getSuccessorInMultimap();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            ValueEntry<K, V> valueEntry = this.f38425a;
            this.f38426b = valueEntry;
            this.f38425a = valueEntry.getSuccessorInMultimap();
            return valueEntry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f38425a != LinkedHashMultimap.this.multimapHeaderEntry;
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.base.m.w(this.f38426b != null, "no calls to next() since the last call to remove()");
            LinkedHashMultimap.this.remove(this.f38426b.getKey(), this.f38426b.getValue());
            this.f38426b = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class b extends Sets.d<V> implements c<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f38428a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ValueEntry<K, V>[] f38429b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f38430c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f38431d = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public c<K, V> f38432f = this;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public c<K, V> f38433g = this;

        /* JADX INFO: compiled from: source.java */
        public class a implements Iterator<V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public c<K, V> f38435a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public ValueEntry<K, V> f38436b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f38437c;

            public a() {
                this.f38435a = b.this.f38432f;
                this.f38437c = b.this.f38431d;
            }

            public final void a() {
                if (b.this.f38431d != this.f38437c) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                return this.f38435a != b.this;
            }

            @Override // java.util.Iterator
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                ValueEntry<K, V> valueEntry = (ValueEntry) this.f38435a;
                V value = valueEntry.getValue();
                this.f38436b = valueEntry;
                this.f38435a = valueEntry.getSuccessorInValueSet();
                return value;
            }

            @Override // java.util.Iterator
            public void remove() {
                a();
                com.google.common.base.m.w(this.f38436b != null, "no calls to next() since the last call to remove()");
                b.this.remove(this.f38436b.getValue());
                this.f38437c = b.this.f38431d;
                this.f38436b = null;
            }
        }

        public b(K k11, int i11) {
            this.f38428a = k11;
            this.f38429b = new ValueEntry[c0.a(i11, 1.0d)];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(V v11) {
            int iD = c0.d(v11);
            int iE = e() & iD;
            ValueEntry<K, V> valueEntry = this.f38429b[iE];
            for (ValueEntry<K, V> valueEntry2 = valueEntry; valueEntry2 != null; valueEntry2 = valueEntry2.nextInValueBucket) {
                if (valueEntry2.matchesValue(v11, iD)) {
                    return false;
                }
            }
            ValueEntry<K, V> valueEntry3 = new ValueEntry<>(this.f38428a, v11, iD, valueEntry);
            LinkedHashMultimap.succeedsInValueSet(this.f38433g, valueEntry3);
            LinkedHashMultimap.succeedsInValueSet(valueEntry3, this);
            LinkedHashMultimap.succeedsInMultimap(LinkedHashMultimap.this.multimapHeaderEntry.getPredecessorInMultimap(), valueEntry3);
            LinkedHashMultimap.succeedsInMultimap(valueEntry3, LinkedHashMultimap.this.multimapHeaderEntry);
            this.f38429b[iE] = valueEntry3;
            this.f38430c++;
            this.f38431d++;
            f();
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Arrays.fill(this.f38429b, (Object) null);
            this.f38430c = 0;
            for (c<K, V> successorInValueSet = this.f38432f; successorInValueSet != this; successorInValueSet = successorInValueSet.getSuccessorInValueSet()) {
                LinkedHashMultimap.deleteFromMultimap((ValueEntry) successorInValueSet);
            }
            LinkedHashMultimap.succeedsInValueSet(this, this);
            this.f38431d++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            int iD = c0.d(obj);
            for (ValueEntry<K, V> valueEntry = this.f38429b[e() & iD]; valueEntry != null; valueEntry = valueEntry.nextInValueBucket) {
                if (valueEntry.matchesValue(obj, iD)) {
                    return true;
                }
            }
            return false;
        }

        public final int e() {
            return this.f38429b.length - 1;
        }

        public final void f() {
            if (c0.b(this.f38430c, this.f38429b.length, 1.0d)) {
                int length = this.f38429b.length * 2;
                ValueEntry<K, V>[] valueEntryArr = new ValueEntry[length];
                this.f38429b = valueEntryArr;
                int i11 = length - 1;
                for (c<K, V> successorInValueSet = this.f38432f; successorInValueSet != this; successorInValueSet = successorInValueSet.getSuccessorInValueSet()) {
                    ValueEntry<K, V> valueEntry = (ValueEntry) successorInValueSet;
                    int i12 = valueEntry.smearedValueHash & i11;
                    valueEntry.nextInValueBucket = valueEntryArr[i12];
                    valueEntryArr[i12] = valueEntry;
                }
            }
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public c<K, V> getPredecessorInValueSet() {
            return this.f38433g;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public c<K, V> getSuccessorInValueSet() {
            return this.f38432f;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int iD = c0.d(obj);
            int iE = e() & iD;
            ValueEntry<K, V> valueEntry = null;
            for (ValueEntry<K, V> valueEntry2 = this.f38429b[iE]; valueEntry2 != null; valueEntry2 = valueEntry2.nextInValueBucket) {
                if (valueEntry2.matchesValue(obj, iD)) {
                    if (valueEntry == null) {
                        this.f38429b[iE] = valueEntry2.nextInValueBucket;
                    } else {
                        valueEntry.nextInValueBucket = valueEntry2.nextInValueBucket;
                    }
                    LinkedHashMultimap.deleteFromValueSet(valueEntry2);
                    LinkedHashMultimap.deleteFromMultimap(valueEntry2);
                    this.f38430c--;
                    this.f38431d++;
                    return true;
                }
                valueEntry = valueEntry2;
            }
            return false;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public void setPredecessorInValueSet(c<K, V> cVar) {
            this.f38433g = cVar;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public void setSuccessorInValueSet(c<K, V> cVar) {
            this.f38432f = cVar;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f38430c;
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
        super(p0.f(i11));
        this.valueSetCapacity = 2;
        l.b(i12, "expectedValuesPerKey");
        this.valueSetCapacity = i12;
        ValueEntry<K, V> valueEntryNewHeader = ValueEntry.newHeader();
        this.multimapHeaderEntry = valueEntryNewHeader;
        succeedsInMultimap(valueEntryNewHeader, valueEntryNewHeader);
    }

    public static <K, V> LinkedHashMultimap<K, V> create() {
        return new LinkedHashMultimap<>(16, 2);
    }

    public static <K, V> LinkedHashMultimap<K, V> create(int i11, int i12) {
        return new LinkedHashMultimap<>(Maps.d(i11), Maps.d(i12));
    }

    public static <K, V> LinkedHashMultimap<K, V> create(h0<? extends K, ? extends V> h0Var) {
        LinkedHashMultimap<K, V> linkedHashMultimapCreate = create(h0Var.keySet().size(), 2);
        linkedHashMultimapCreate.putAll(h0Var);
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
        ValueEntry<K, V> valueEntryNewHeader = ValueEntry.newHeader();
        this.multimapHeaderEntry = valueEntryNewHeader;
        succeedsInMultimap(valueEntryNewHeader, valueEntryNewHeader);
        this.valueSetCapacity = 2;
        int i11 = objectInputStream.readInt();
        Map mapF = p0.f(12);
        for (int i12 = 0; i12 < i11; i12++) {
            Object object = objectInputStream.readObject();
            mapF.put(object, createCollection(object));
        }
        int i13 = objectInputStream.readInt();
        for (int i14 = 0; i14 < i13; i14++) {
            Object object2 = objectInputStream.readObject();
            Object object3 = objectInputStream.readObject();
            Collection collection = (Collection) mapF.get(object2);
            Objects.requireNonNull(collection);
            collection.add(object3);
        }
        setMap(mapF);
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

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.c, com.google.common.collect.h0
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.h0
    public void clear() {
        super.clear();
        ValueEntry<K, V> valueEntry = this.multimapHeaderEntry;
        succeedsInMultimap(valueEntry, valueEntry);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.h0
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.h0
    public /* bridge */ /* synthetic */ boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> createCollection(K k11) {
        return new b(k11, this.valueSetCapacity);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public Set<V> createCollection() {
        return p0.g(this.valueSetCapacity);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.h0
    public Set<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
    public Iterator<Map.Entry<K, V>> entryIterator() {
        return new a();
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.c
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.h0
    public /* bridge */ /* synthetic */ Set get(Object obj) {
        return super.get(obj);
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.h0
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.h0
    public Set<K> keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ j0 keys() {
        return super.keys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.h0
    public /* bridge */ /* synthetic */ boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ boolean putAll(h0 h0Var) {
        return super.putAll(h0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.h0
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.h0
    public /* bridge */ /* synthetic */ Set removeAll(Object obj) {
        return super.removeAll(obj);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
    public Set<V> replaceValues(K k11, Iterable<? extends V> iterable) {
        return super.replaceValues((Object) k11, (Iterable) iterable);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.h0
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
    public Iterator<V> valueIterator() {
        return Maps.D(entryIterator());
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.h0
    public Collection<V> values() {
        return super.values();
    }
}
