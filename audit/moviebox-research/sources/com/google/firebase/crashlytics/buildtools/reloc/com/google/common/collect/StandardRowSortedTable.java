package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
class StandardRowSortedTable<R, C, V> extends StandardTable<R, C, V> {
    private static final long serialVersionUID = 0;

    /* JADX INFO: compiled from: source.java */
    public class b extends StandardTable<R, C, V>.h implements SortedMap<R, Map<C, V>> {
        public b() {
            super();
        }

        @Override // java.util.SortedMap
        public Comparator<? super R> comparator() {
            return StandardRowSortedTable.this.sortedBackingMap().comparator();
        }

        @Override // java.util.SortedMap
        public R firstKey() {
            return (R) StandardRowSortedTable.this.sortedBackingMap().firstKey();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.m
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public SortedSet<R> h() {
            return new Maps.k(this);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.m, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public SortedSet<R> keySet() {
            return (SortedSet) super.keySet();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> headMap(R r11) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(r11);
            return new StandardRowSortedTable(StandardRowSortedTable.this.sortedBackingMap().headMap(r11), StandardRowSortedTable.this.factory).rowMap();
        }

        @Override // java.util.SortedMap
        public R lastKey() {
            return (R) StandardRowSortedTable.this.sortedBackingMap().lastKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> subMap(R r11, R r12) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(r11);
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(r12);
            return new StandardRowSortedTable(StandardRowSortedTable.this.sortedBackingMap().subMap(r11, r12), StandardRowSortedTable.this.factory).rowMap();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> tailMap(R r11) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(r11);
            return new StandardRowSortedTable(StandardRowSortedTable.this.sortedBackingMap().tailMap(r11), StandardRowSortedTable.this.factory).rowMap();
        }
    }

    public StandardRowSortedTable(SortedMap<R, Map<C, V>> sortedMap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.q<? extends Map<C, V>> qVar) {
        super(sortedMap, qVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SortedMap<R, Map<C, V>> sortedBackingMap() {
        return (SortedMap) this.backingMap;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable
    public SortedMap<R, Map<C, V>> createRowMap() {
        return new b();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public SortedSet<R> rowKeySet() {
        return (SortedSet) rowMap().keySet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public SortedMap<R, Map<C, V>> rowMap() {
        return (SortedMap) super.rowMap();
    }
}
