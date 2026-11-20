package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
abstract class RegularImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {

    /* JADX INFO: compiled from: source.java */
    public final class CellSet extends IndexedImmutableSet<p7.a<R, C, V>> {
        public CellSet() {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof p7.a)) {
                return false;
            }
            p7.a aVar = (p7.a) obj;
            Object obj2 = RegularImmutableTable.this.get(aVar.getRowKey(), aVar.getColumnKey());
            return obj2 != null && obj2.equals(aVar.getValue());
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.IndexedImmutableSet
        public p7.a<R, C, V> get(int i11) {
            return RegularImmutableTable.this.getCell(i11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
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

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return RegularImmutableTable.this.size();
        }
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> forCells(Iterable<p7.a<R, C, V>> iterable) {
        return i(iterable, null, null);
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> forCells(List<p7.a<R, C, V>> list, final Comparator<? super R> comparator, final Comparator<? super C> comparator2) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(list);
        if (comparator != null || comparator2 != null) {
            Collections.sort(list, new Comparator<p7.a<R, C, V>>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.RegularImmutableTable.1
                @Override // java.util.Comparator
                public int compare(p7.a<R, C, V> aVar, p7.a<R, C, V> aVar2) {
                    Comparator comparator3 = comparator;
                    int iCompare = comparator3 == null ? 0 : comparator3.compare(aVar.getRowKey(), aVar2.getRowKey());
                    if (iCompare != 0) {
                        return iCompare;
                    }
                    Comparator comparator4 = comparator2;
                    if (comparator4 == null) {
                        return 0;
                    }
                    return comparator4.compare(aVar.getColumnKey(), aVar2.getColumnKey());
                }
            });
        }
        return i(list, comparator, comparator2);
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> forOrderedComponents(ImmutableList<p7.a<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        return ((long) immutableList.size()) > (((long) immutableSet.size()) * ((long) immutableSet2.size())) / 2 ? new DenseImmutableTable(immutableList, immutableSet, immutableSet2) : new SparseImmutableTable(immutableList, immutableSet, immutableSet2);
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> i(Iterable<p7.a<R, C, V>> iterable, Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        ImmutableList immutableListCopyOf = ImmutableList.copyOf(iterable);
        for (p7.a<R, C, V> aVar : iterable) {
            linkedHashSet.add(aVar.getRowKey());
            linkedHashSet2.add(aVar.getColumnKey());
        }
        return forOrderedComponents(immutableListCopyOf, comparator == null ? ImmutableSet.copyOf((Collection) linkedHashSet) : ImmutableSet.copyOf((Collection) ImmutableList.sortedCopyOf(comparator, linkedHashSet)), comparator2 == null ? ImmutableSet.copyOf((Collection) linkedHashSet2) : ImmutableSet.copyOf((Collection) ImmutableList.sortedCopyOf(comparator2, linkedHashSet2)));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public final ImmutableSet<p7.a<R, C, V>> createCellSet() {
        return isEmpty() ? ImmutableSet.of() : new CellSet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public final ImmutableCollection<V> createValues() {
        return isEmpty() ? ImmutableList.of() : new Values();
    }

    public abstract p7.a<R, C, V> getCell(int i11);

    public abstract V getValue(int i11);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public abstract /* synthetic */ int size();
}
