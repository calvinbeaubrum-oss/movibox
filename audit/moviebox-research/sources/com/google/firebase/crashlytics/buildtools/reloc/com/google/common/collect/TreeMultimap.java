package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BiConsumer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class TreeMultimap<K, V> extends AbstractSortedKeySortedSetMultimap<K, V> {
    private static final long serialVersionUID = 0;
    private transient Comparator<? super K> keyComparator;
    private transient Comparator<? super V> valueComparator;

    public TreeMultimap(Comparator<? super K> comparator, Comparator<? super V> comparator2) {
        super(new TreeMap(comparator));
        this.keyComparator = comparator;
        this.valueComparator = comparator2;
    }

    private TreeMultimap(Comparator<? super K> comparator, Comparator<? super V> comparator2, z5<? extends K, ? extends V> z5Var) {
        this(comparator, comparator2);
        putAll(z5Var);
    }

    public static <K extends Comparable, V extends Comparable> TreeMultimap<K, V> create() {
        return new TreeMultimap<>(Ordering.natural(), Ordering.natural());
    }

    public static <K extends Comparable, V extends Comparable> TreeMultimap<K, V> create(z5<? extends K, ? extends V> z5Var) {
        return new TreeMultimap<>(Ordering.natural(), Ordering.natural(), z5Var);
    }

    public static <K, V> TreeMultimap<K, V> create(Comparator<? super K> comparator, Comparator<? super V> comparator2) {
        return new TreeMultimap<>((Comparator) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(comparator), (Comparator) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(comparator2));
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.keyComparator = (Comparator) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n((Comparator) objectInputStream.readObject());
        this.valueComparator = (Comparator) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n((Comparator) objectInputStream.readObject());
        setMap(new TreeMap(this.keyComparator));
        y6.d(this, objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(keyComparator());
        objectOutputStream.writeObject(valueComparator());
        y6.j(this, objectOutputStream);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSortedKeySortedSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSortedSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public NavigableMap<K, Collection<V>> asMap() {
        return (NavigableMap) super.asMap();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
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

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public Map<K, Collection<V>> createAsMap() {
        return createMaybeNavigableAsMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> createCollection(K k11) {
        if (k11 == 0) {
            keyComparator().compare(k11, k11);
        }
        return super.createCollection(k11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSortedSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap
    public SortedSet<V> createCollection() {
        return new TreeSet(this.valueComparator);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ Set entries() {
        return super.entries();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap
    public /* bridge */ /* synthetic */ void forEach(BiConsumer biConsumer) {
        super.forEach(biConsumer);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSortedSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public NavigableSet<V> get(K k11) {
        return (NavigableSet) super.get((Object) k11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Deprecated
    public Comparator<? super K> keyComparator() {
        return this.keyComparator;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSortedKeySortedSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public NavigableSet<K> keySet() {
        return (NavigableSet) super.keySet();
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

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSortedSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ SortedSet removeAll(Object obj) {
        return super.removeAll(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSortedSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public /* bridge */ /* synthetic */ SortedSet replaceValues(Object obj, Iterable iterable) {
        return super.replaceValues(obj, iterable);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSortedKeySortedSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSortedSetMultimap
    public Comparator<? super V> valueComparator() {
        return this.valueComparator;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSortedSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }
}
