package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
abstract class RegularImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {

    /* JADX INFO: compiled from: source.java */
    public final class CellSet extends IndexedImmutableSet<b1.a<R, C, V>> {
        public CellSet() {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof b1.a)) {
                return false;
            }
            b1.a aVar = (b1.a) obj;
            Object obj2 = RegularImmutableTable.this.get(aVar.getRowKey(), aVar.getColumnKey());
            return obj2 != null && obj2.equals(aVar.getValue());
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public b1.a<R, C, V> get(int i11) {
            return RegularImmutableTable.this.getCell(i11);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return RegularImmutableTable.this.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class Values extends ImmutableList<V> {
        public Values() {
        }

        @Override // java.util.List
        public V get(int i11) {
            return (V) RegularImmutableTable.this.getValue(i11);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return RegularImmutableTable.this.size();
        }
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> b(Iterable<b1.a<R, C, V>> iterable, Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        ImmutableList immutableListCopyOf = ImmutableList.copyOf(iterable);
        for (b1.a<R, C, V> aVar : iterable) {
            linkedHashSet.add(aVar.getRowKey());
            linkedHashSet2.add(aVar.getColumnKey());
        }
        return forOrderedComponents(immutableListCopyOf, comparator == null ? ImmutableSet.copyOf((Collection) linkedHashSet) : ImmutableSet.copyOf((Collection) ImmutableList.sortedCopyOf(comparator, linkedHashSet)), comparator2 == null ? ImmutableSet.copyOf((Collection) linkedHashSet2) : ImmutableSet.copyOf((Collection) ImmutableList.sortedCopyOf(comparator2, linkedHashSet2)));
    }

    public static /* synthetic */ int c(Comparator comparator, Comparator comparator2, b1.a aVar, b1.a aVar2) {
        int iCompare = comparator == null ? 0 : comparator.compare(aVar.getRowKey(), aVar2.getRowKey());
        if (iCompare != 0) {
            return iCompare;
        }
        if (comparator2 == null) {
            return 0;
        }
        return comparator2.compare(aVar.getColumnKey(), aVar2.getColumnKey());
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> forCells(Iterable<b1.a<R, C, V>> iterable) {
        return b(iterable, null, null);
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> forCells(List<b1.a<R, C, V>> list, final Comparator<? super R> comparator, final Comparator<? super C> comparator2) {
        com.google.common.base.m.p(list);
        if (comparator != null || comparator2 != null) {
            Collections.sort(list, new Comparator() { // from class: com.google.common.collect.t0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return RegularImmutableTable.c(comparator, comparator2, (b1.a) obj, (b1.a) obj2);
                }
            });
        }
        return b(list, comparator, comparator2);
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> forOrderedComponents(ImmutableList<b1.a<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        return ((long) immutableList.size()) > (((long) immutableSet.size()) * ((long) immutableSet2.size())) / 2 ? new DenseImmutableTable(immutableList, immutableSet, immutableSet2) : new SparseImmutableTable(immutableList, immutableSet, immutableSet2);
    }

    public final void checkNoDuplicate(R r11, C c11, V v11, V v12) {
        com.google.common.base.m.m(v11 == null, "Duplicate key: (row=%s, column=%s), values: [%s, %s].", r11, c11, v12, v11);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.i
    public final ImmutableSet<b1.a<R, C, V>> createCellSet() {
        return isEmpty() ? ImmutableSet.of() : new CellSet();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.i
    public final ImmutableCollection<V> createValues() {
        return isEmpty() ? ImmutableList.of() : new Values();
    }

    public abstract b1.a<R, C, V> getCell(int i11);

    public abstract V getValue(int i11);

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.b1
    public abstract /* synthetic */ int size();
}
