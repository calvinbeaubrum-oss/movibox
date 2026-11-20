package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class ImmutableTable<R, C, V> extends z<R, C, V> implements Serializable {

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
            ImmutableList.b bVar = new ImmutableList.b(objArr.length);
            while (true) {
                Object[] objArr2 = this.cellValues;
                if (i11 >= objArr2.length) {
                    return RegularImmutableTable.forOrderedComponents(bVar.h(), ImmutableSet.copyOf(this.rowKeys), ImmutableSet.copyOf(this.columnKeys));
                }
                bVar.a(ImmutableTable.cellOf(this.rowKeys[this.cellRowIndices[i11]], this.columnKeys[this.cellColumnIndices[i11]], objArr2[i11]));
                i11++;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b<R, C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<p7.a<R, C, V>> f39393a = Lists.h();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Comparator<? super R> f39394b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Comparator<? super C> f39395c;

        public ImmutableTable<R, C, V> a() {
            int size = this.f39393a.size();
            if (size != 0) {
                return size != 1 ? RegularImmutableTable.forCells(this.f39393a, this.f39394b, this.f39395c) : new SingletonImmutableTable((p7.a) j5.h(this.f39393a));
            }
            return ImmutableTable.of();
        }

        public b<R, C, V> b(b<R, C, V> bVar) {
            this.f39393a.addAll(bVar.f39393a);
            return this;
        }

        public b<R, C, V> c(p7.a<? extends R, ? extends C, ? extends V> aVar) {
            if (aVar instanceof Tables.ImmutableCell) {
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(aVar.getRowKey(), "row");
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(aVar.getColumnKey(), "column");
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(aVar.getValue(), AppMeasurementSdk.ConditionalUserProperty.VALUE);
                this.f39393a.add(aVar);
            } else {
                d(aVar.getRowKey(), aVar.getColumnKey(), aVar.getValue());
            }
            return this;
        }

        public b<R, C, V> d(R r11, C c11, V v11) {
            this.f39393a.add(ImmutableTable.cellOf(r11, c11, v11));
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c<R, C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<d<R, C, V>> f39396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p7<R, C, d<R, C, V>> f39397b;

        public c() {
            this.f39396a = new ArrayList();
            this.f39397b = HashBasedTable.create();
        }

        public c<R, C, V> a(c<R, C, V> cVar, BinaryOperator<V> binaryOperator) {
            for (d<R, C, V> dVar : cVar.f39396a) {
                b(dVar.getRowKey(), dVar.getColumnKey(), dVar.getValue(), binaryOperator);
            }
            return this;
        }

        public void b(R r11, C c11, V v11, BinaryOperator<V> binaryOperator) {
            d<R, C, V> dVar = this.f39397b.get(r11, c11);
            if (dVar != null) {
                dVar.a(v11, binaryOperator);
                return;
            }
            d<R, C, V> dVar2 = new d<>(r11, c11, v11);
            this.f39396a.add(dVar2);
            this.f39397b.put(r11, c11, dVar2);
        }

        public ImmutableTable<R, C, V> c() {
            return ImmutableTable.copyOf(this.f39396a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d<R, C, V> extends Tables.b<R, C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final R f39398a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C f39399b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public V f39400c;

        public d(R r11, C c11, V v11) {
            this.f39398a = (R) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(r11, "row");
            this.f39399b = (C) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(c11, "column");
            this.f39400c = (V) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(v11, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        }

        public void a(V v11, BinaryOperator<V> binaryOperator) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(v11, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            this.f39400c = (V) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(binaryOperator.apply(this.f39400c, v11), "mergeFunction.apply");
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7.a
        public C getColumnKey() {
            return this.f39399b;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7.a
        public R getRowKey() {
            return this.f39398a;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7.a
        public V getValue() {
            return this.f39400c;
        }
    }

    public static <R, C, V> b<R, C, V> builder() {
        return new b<>();
    }

    public static <R, C, V> p7.a<R, C, V> cellOf(R r11, C c11, V v11) {
        return Tables.b(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(r11, "rowKey"), com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(c11, "columnKey"), com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(v11, AppMeasurementSdk.ConditionalUserProperty.VALUE));
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(p7<? extends R, ? extends C, ? extends V> p7Var) {
        return p7Var instanceof ImmutableTable ? (ImmutableTable) p7Var : copyOf(p7Var.cellSet());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <R, C, V> ImmutableTable<R, C, V> copyOf(Iterable<? extends p7.a<? extends R, ? extends C, ? extends V>> iterable) {
        b bVarBuilder = builder();
        Iterator<? extends p7.a<? extends R, ? extends C, ? extends V>> it = iterable.iterator();
        while (it.hasNext()) {
            bVarBuilder.c(it.next());
        }
        return bVarBuilder.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ b lambda$toImmutableTable$0() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void lambda$toImmutableTable$1(Function function, Function function2, Function function3, b bVar, Object obj) {
        bVar.d(function.apply(obj), function2.apply(obj), function3.apply(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ c lambda$toImmutableTable$4() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void lambda$toImmutableTable$5(Function function, Function function2, Function function3, BinaryOperator binaryOperator, c cVar, Object obj) {
        cVar.b(function.apply(obj), function2.apply(obj), function3.apply(obj), binaryOperator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ c lambda$toImmutableTable$6(BinaryOperator binaryOperator, c cVar, c cVar2) {
        return cVar.a(cVar2, binaryOperator);
    }

    public static <R, C, V> ImmutableTable<R, C, V> of() {
        return (ImmutableTable<R, C, V>) SparseImmutableTable.EMPTY;
    }

    public static <R, C, V> ImmutableTable<R, C, V> of(R r11, C c11, V v11) {
        return new SingletonImmutableTable(r11, c11, v11);
    }

    public static <T, R, C, V> Collector<T, ?, ImmutableTable<R, C, V>> toImmutableTable(final Function<? super T, ? extends R> function, final Function<? super T, ? extends C> function2, final Function<? super T, ? extends V> function3) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(function, "rowFunction");
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(function2, "columnFunction");
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(function3, "valueFunction");
        return Collector.of(new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.w4
            @Override // java.util.function.Supplier
            public final Object get() {
                return ImmutableTable.lambda$toImmutableTable$0();
            }
        }, new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.x4
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ImmutableTable.lambda$toImmutableTable$1(function, function2, function3, (ImmutableTable.b) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.y4
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableTable.b) obj).b((ImmutableTable.b) obj2);
            }
        }, new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableTable.b) obj).a();
            }
        }, new Collector.Characteristics[0]);
    }

    public static <T, R, C, V> Collector<T, ?, ImmutableTable<R, C, V>> toImmutableTable(final Function<? super T, ? extends R> function, final Function<? super T, ? extends C> function2, final Function<? super T, ? extends V> function3, final BinaryOperator<V> binaryOperator) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(function, "rowFunction");
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(function2, "columnFunction");
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(function3, "valueFunction");
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(binaryOperator, "mergeFunction");
        return Collector.of(new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.a5
            @Override // java.util.function.Supplier
            public final Object get() {
                return ImmutableTable.lambda$toImmutableTable$4();
            }
        }, new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.b5
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ImmutableTable.lambda$toImmutableTable$5(function, function2, function3, binaryOperator, (ImmutableTable.c) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.c5
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ImmutableTable.lambda$toImmutableTable$6(binaryOperator, (ImmutableTable.c) obj, (ImmutableTable.c) obj2);
            }
        }, new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.d5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableTable.c) obj).c();
            }
        }, new Collector.Characteristics[0]);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public final t7<p7.a<R, C, V>> cellIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public ImmutableSet<p7.a<R, C, V>> cellSet() {
        return (ImmutableSet) super.cellSet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public final Spliterator<p7.a<R, C, V>> cellSpliterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // 
    /* JADX INFO: renamed from: column */
    public ImmutableMap<R, V> mo154column(C c11) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(c11, "columnKey");
        return (ImmutableMap) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.f.a((ImmutableMap) columnMap().get(c11), ImmutableMap.of());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public ImmutableSet<C> columnKeySet() {
        return columnMap().keySet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public abstract ImmutableMap<C, Map<R, V>> columnMap();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public boolean contains(Object obj, Object obj2) {
        return get(obj, obj2) != null;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public /* bridge */ /* synthetic */ boolean containsColumn(Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public /* bridge */ /* synthetic */ boolean containsRow(Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public abstract ImmutableSet<p7.a<R, C, V>> createCellSet();

    public abstract SerializedForm createSerializedForm();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public abstract ImmutableCollection<V> createValues();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public /* bridge */ /* synthetic */ Object get(Object obj, Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    @Deprecated
    public final V put(R r11, C c11, V v11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    @Deprecated
    public final void putAll(p7<? extends R, ? extends C, ? extends V> p7Var) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    @Deprecated
    public final V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public ImmutableMap<C, V> row(R r11) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(r11, "rowKey");
        return (ImmutableMap) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.f.a((ImmutableMap) rowMap().get(r11), ImmutableMap.of());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public ImmutableSet<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public abstract ImmutableMap<R, Map<C, V>> rowMap();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public abstract /* synthetic */ int size();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public final Iterator<V> valuesIterator() {
        throw new AssertionError("should never be called");
    }

    public final Object writeReplace() {
        return createSerializedForm();
    }
}
