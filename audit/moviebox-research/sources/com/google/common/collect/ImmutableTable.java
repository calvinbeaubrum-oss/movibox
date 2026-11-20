package com.google.common.collect;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ImmutableTable<R, C, V> extends i<R, C, V> implements Serializable {
    private static final long serialVersionUID = 912559;

    /* JADX INFO: compiled from: source.java */
    public static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final int[] cellColumnIndices;
        private final int[] cellRowIndices;
        private final Object[] cellValues;
        private final Object[] columnKeys;
        private final Object[] rowKeys;

        public SerializedForm(Object[] objArr, Object[] objArr2, Object[] objArr3, int[] iArr, int[] iArr2) {
            this.rowKeys = objArr;
            this.columnKeys = objArr2;
            this.cellValues = objArr3;
            this.cellRowIndices = iArr;
            this.cellColumnIndices = iArr2;
        }

        public static SerializedForm create(ImmutableTable<?, ?, ?> immutableTable, int[] iArr, int[] iArr2) {
            return new SerializedForm(immutableTable.rowKeySet().toArray(), immutableTable.columnKeySet().toArray(), immutableTable.values().toArray(), iArr, iArr2);
        }

        public Object readResolve() {
            Object[] objArr = this.cellValues;
            if (objArr.length == 0) {
                return ImmutableTable.of();
            }
            int i11 = 0;
            if (objArr.length == 1) {
                return ImmutableTable.of(this.rowKeys[0], this.columnKeys[0], objArr[0]);
            }
            ImmutableList.a aVar = new ImmutableList.a(objArr.length);
            while (true) {
                Object[] objArr2 = this.cellValues;
                if (i11 >= objArr2.length) {
                    return RegularImmutableTable.forOrderedComponents(aVar.m(), ImmutableSet.copyOf(this.rowKeys), ImmutableSet.copyOf(this.columnKeys));
                }
                aVar.a(ImmutableTable.cellOf(this.rowKeys[this.cellRowIndices[i11]], this.columnKeys[this.cellColumnIndices[i11]], objArr2[i11]));
                i11++;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a<R, C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<b1.a<R, C, V>> f38405a = Lists.i();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Comparator<? super R> f38406b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Comparator<? super C> f38407c;

        public ImmutableTable<R, C, V> a() {
            return b();
        }

        public ImmutableTable<R, C, V> b() {
            int size = this.f38405a.size();
            if (size != 0) {
                return size != 1 ? RegularImmutableTable.forCells(this.f38405a, this.f38406b, this.f38407c) : new SingletonImmutableTable((b1.a) e0.j(this.f38405a));
            }
            return ImmutableTable.of();
        }

        public a<R, C, V> c(b1.a<? extends R, ? extends C, ? extends V> aVar) {
            if (aVar instanceof Tables.ImmutableCell) {
                com.google.common.base.m.q(aVar.getRowKey(), "row");
                com.google.common.base.m.q(aVar.getColumnKey(), "column");
                com.google.common.base.m.q(aVar.getValue(), AppMeasurementSdk.ConditionalUserProperty.VALUE);
                this.f38405a.add(aVar);
            } else {
                d(aVar.getRowKey(), aVar.getColumnKey(), aVar.getValue());
            }
            return this;
        }

        public a<R, C, V> d(R r11, C c11, V v11) {
            this.f38405a.add(ImmutableTable.cellOf(r11, c11, v11));
            return this;
        }
    }

    public static <R, C, V> a<R, C, V> builder() {
        return new a<>();
    }

    public static <R, C, V> b1.a<R, C, V> cellOf(R r11, C c11, V v11) {
        return Tables.b(com.google.common.base.m.q(r11, "rowKey"), com.google.common.base.m.q(c11, "columnKey"), com.google.common.base.m.q(v11, AppMeasurementSdk.ConditionalUserProperty.VALUE));
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(b1<? extends R, ? extends C, ? extends V> b1Var) {
        return b1Var instanceof ImmutableTable ? (ImmutableTable) b1Var : copyOf(b1Var.cellSet());
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(Iterable<? extends b1.a<? extends R, ? extends C, ? extends V>> iterable) {
        a aVarBuilder = builder();
        Iterator<? extends b1.a<? extends R, ? extends C, ? extends V>> it = iterable.iterator();
        while (it.hasNext()) {
            aVarBuilder.c(it.next());
        }
        return aVarBuilder.a();
    }

    public static <R, C, V> ImmutableTable<R, C, V> of() {
        return (ImmutableTable<R, C, V>) SparseImmutableTable.EMPTY;
    }

    public static <R, C, V> ImmutableTable<R, C, V> of(R r11, C c11, V v11) {
        return new SingletonImmutableTable(r11, c11, v11);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.i
    public final g1<b1.a<R, C, V>> cellIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.i, com.google.common.collect.b1
    public ImmutableSet<b1.a<R, C, V>> cellSet() {
        return (ImmutableSet) super.cellSet();
    }

    @Override // com.google.common.collect.i
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // 
    /* JADX INFO: renamed from: column */
    public ImmutableMap<R, V> mo150column(C c11) {
        com.google.common.base.m.q(c11, "columnKey");
        return (ImmutableMap) com.google.common.base.h.a((ImmutableMap) columnMap().get(c11), ImmutableMap.of());
    }

    @Override // com.google.common.collect.i, com.google.common.collect.b1
    public ImmutableSet<C> columnKeySet() {
        return columnMap().keySet();
    }

    @Override // com.google.common.collect.b1
    public abstract ImmutableMap<C, Map<R, V>> columnMap();

    @Override // com.google.common.collect.i
    public boolean contains(Object obj, Object obj2) {
        return get(obj, obj2) != null;
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ boolean containsColumn(Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ boolean containsRow(Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.common.collect.i
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // com.google.common.collect.i
    public abstract ImmutableSet<b1.a<R, C, V>> createCellSet();

    public abstract SerializedForm createSerializedForm();

    @Override // com.google.common.collect.i
    public abstract ImmutableCollection<V> createValues();

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ Object get(Object obj, Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.i
    @Deprecated
    public final V put(R r11, C c11, V v11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.i
    @Deprecated
    public final void putAll(b1<? extends R, ? extends C, ? extends V> b1Var) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.i
    @Deprecated
    public final V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.b1
    public ImmutableMap<C, V> row(R r11) {
        com.google.common.base.m.q(r11, "rowKey");
        return (ImmutableMap) com.google.common.base.h.a((ImmutableMap) rowMap().get(r11), ImmutableMap.of());
    }

    @Override // com.google.common.collect.i, com.google.common.collect.b1
    public ImmutableSet<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.b1
    public abstract ImmutableMap<R, Map<C, V>> rowMap();

    @Override // com.google.common.collect.b1
    public abstract /* synthetic */ int size();

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.i
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    @Override // com.google.common.collect.i
    public final Iterator<V> valuesIterator() {
        throw new AssertionError("should never be called");
    }

    public final Object writeReplace() {
        return createSerializedForm();
    }
}
