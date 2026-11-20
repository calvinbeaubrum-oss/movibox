package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ImmutableRangeMap<K extends Comparable<?>, V> implements r0<K, V>, Serializable {
    private static final ImmutableRangeMap<Comparable<?>, Object> EMPTY = new ImmutableRangeMap<>(ImmutableList.of(), ImmutableList.of());
    private static final long serialVersionUID = 0;
    private final transient ImmutableList<Range<K>> ranges;
    private final transient ImmutableList<V> values;

    /* JADX INFO: compiled from: source.java */
    public static class SerializedForm<K extends Comparable<?>, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final ImmutableMap<Range<K>, V> mapOfRanges;

        public SerializedForm(ImmutableMap<Range<K>, V> immutableMap) {
            this.mapOfRanges = immutableMap;
        }

        public Object createRangeMap() {
            a aVar = new a();
            g1<Map.Entry<Range<K>, V>> it = this.mapOfRanges.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Range<K>, V> next = it.next();
                aVar.b(next.getKey(), next.getValue());
            }
            return aVar.a();
        }

        public Object readResolve() {
            return this.mapOfRanges.isEmpty() ? ImmutableRangeMap.of() : createRangeMap();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a<K extends Comparable<?>, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Map.Entry<Range<K>, V>> f38383a = Lists.i();

        public ImmutableRangeMap<K, V> a() {
            Collections.sort(this.f38383a, Range.rangeLexOrdering().onKeys());
            ImmutableList.a aVar = new ImmutableList.a(this.f38383a.size());
            ImmutableList.a aVar2 = new ImmutableList.a(this.f38383a.size());
            for (int i11 = 0; i11 < this.f38383a.size(); i11++) {
                Range<K> key = this.f38383a.get(i11).getKey();
                if (i11 > 0) {
                    Range<K> key2 = this.f38383a.get(i11 - 1).getKey();
                    if (key.isConnected(key2) && !key.intersection(key2).isEmpty()) {
                        throw new IllegalArgumentException("Overlapping ranges: range " + key2 + " overlaps with entry " + key);
                    }
                }
                aVar.a(key);
                aVar2.a(this.f38383a.get(i11).getValue());
            }
            return new ImmutableRangeMap<>(aVar.m(), aVar2.m());
        }

        public a<K, V> b(Range<K> range, V v11) {
            com.google.common.base.m.p(range);
            com.google.common.base.m.p(v11);
            com.google.common.base.m.k(!range.isEmpty(), "Range must not be empty, but was %s", range);
            this.f38383a.add(Maps.i(range, v11));
            return this;
        }
    }

    public ImmutableRangeMap(ImmutableList<Range<K>> immutableList, ImmutableList<V> immutableList2) {
        this.ranges = immutableList;
        this.values = immutableList2;
    }

    public static <K extends Comparable<?>, V> a<K, V> builder() {
        return new a<>();
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> copyOf(r0<K, ? extends V> r0Var) {
        if (r0Var instanceof ImmutableRangeMap) {
            return (ImmutableRangeMap) r0Var;
        }
        Map<Range<K>, ? extends V> mapAsMapOfRanges = r0Var.asMapOfRanges();
        ImmutableList.a aVar = new ImmutableList.a(mapAsMapOfRanges.size());
        ImmutableList.a aVar2 = new ImmutableList.a(mapAsMapOfRanges.size());
        for (Map.Entry entry : mapAsMapOfRanges.entrySet()) {
            aVar.a((Range) entry.getKey());
            aVar2.a(entry.getValue());
        }
        return new ImmutableRangeMap<>(aVar.m(), aVar2.m());
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of() {
        return (ImmutableRangeMap<K, V>) EMPTY;
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of(Range<K> range, V v11) {
        return new ImmutableRangeMap<>(ImmutableList.of(range), ImmutableList.of(v11));
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // 
    /* JADX INFO: renamed from: asDescendingMapOfRanges, reason: merged with bridge method [inline-methods] */
    public ImmutableMap<Range<K>, V> mo147asDescendingMapOfRanges() {
        return this.ranges.isEmpty() ? ImmutableMap.of() : new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges.reverse(), Range.rangeLexOrdering().reverse()), this.values.reverse());
    }

    @Override // com.google.common.collect.r0
    public ImmutableMap<Range<K>, V> asMapOfRanges() {
        return this.ranges.isEmpty() ? ImmutableMap.of() : new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges, Range.rangeLexOrdering()), this.values);
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        if (obj instanceof r0) {
            return asMapOfRanges().equals(((r0) obj).asMapOfRanges());
        }
        return false;
    }

    public V get(K k11) {
        int iA = SortedLists.a(this.ranges, Range.lowerBoundFn(), Cut.belowValue(k11), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (iA != -1 && this.ranges.get(iA).contains(k11)) {
            return this.values.get(iA);
        }
        return null;
    }

    public Map.Entry<Range<K>, V> getEntry(K k11) {
        int iA = SortedLists.a(this.ranges, Range.lowerBoundFn(), Cut.belowValue(k11), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (iA == -1) {
            return null;
        }
        Range<K> range = this.ranges.get(iA);
        if (range.contains(k11)) {
            return Maps.i(range, this.values.get(iA));
        }
        return null;
    }

    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Deprecated
    public final void put(Range<K> range, V v11) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(r0<K, ? extends V> r0Var) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putCoalescing(Range<K> range, V v11) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void remove(Range<K> range) {
        throw new UnsupportedOperationException();
    }

    public Range<K> span() {
        if (this.ranges.isEmpty()) {
            throw new NoSuchElementException();
        }
        Range<K> range = this.ranges.get(0);
        ImmutableList<Range<K>> immutableList = this.ranges;
        return Range.create(range.lowerBound, immutableList.get(immutableList.size() - 1).upperBound);
    }

    @Override // 
    /* JADX INFO: renamed from: subRangeMap */
    public ImmutableRangeMap<K, V> mo148subRangeMap(final Range<K> range) {
        if (((Range) com.google.common.base.m.p(range)).isEmpty()) {
            return of();
        }
        if (this.ranges.isEmpty() || range.encloses(span())) {
            return this;
        }
        ImmutableList<Range<K>> immutableList = this.ranges;
        com.google.common.base.f fVarUpperBoundFn = Range.upperBoundFn();
        Comparable comparable = range.lowerBound;
        SortedLists.KeyPresentBehavior keyPresentBehavior = SortedLists.KeyPresentBehavior.FIRST_AFTER;
        SortedLists.KeyAbsentBehavior keyAbsentBehavior = SortedLists.KeyAbsentBehavior.NEXT_HIGHER;
        final int iA = SortedLists.a(immutableList, fVarUpperBoundFn, comparable, keyPresentBehavior, keyAbsentBehavior);
        int iA2 = SortedLists.a(this.ranges, Range.lowerBoundFn(), range.upperBound, SortedLists.KeyPresentBehavior.ANY_PRESENT, keyAbsentBehavior);
        if (iA >= iA2) {
            return of();
        }
        final int i11 = iA2 - iA;
        return (ImmutableRangeMap<K, V>) new ImmutableRangeMap<K, V>(this, new ImmutableList<Range<K>>() { // from class: com.google.common.collect.ImmutableRangeMap.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.List
            public Range<K> get(int i12) {
                com.google.common.base.m.n(i12, i11);
                return (i12 == 0 || i12 == i11 + (-1)) ? ((Range) ImmutableRangeMap.this.ranges.get(i12 + iA)).intersection(range) : (Range) ImmutableRangeMap.this.ranges.get(i12 + iA);
            }

            @Override // com.google.common.collect.ImmutableCollection
            public boolean isPartialView() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return i11;
            }
        }, this.values.subList(iA, iA2)) { // from class: com.google.common.collect.ImmutableRangeMap.2
            @Override // com.google.common.collect.ImmutableRangeMap
            /* JADX INFO: renamed from: asDescendingMapOfRanges */
            public /* bridge */ /* synthetic */ Map mo147asDescendingMapOfRanges() {
                return super.mo147asDescendingMapOfRanges();
            }

            @Override // com.google.common.collect.ImmutableRangeMap, com.google.common.collect.r0
            public /* bridge */ /* synthetic */ Map asMapOfRanges() {
                return super.asMapOfRanges();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.google.common.collect.ImmutableRangeMap
            /* JADX INFO: renamed from: subRangeMap, reason: merged with bridge method [inline-methods] */
            public ImmutableRangeMap<K, V> mo148subRangeMap(Range<K> range2) {
                return range.isConnected(range2) ? this.mo148subRangeMap((Range) range2.intersection(range)) : ImmutableRangeMap.of();
            }
        };
    }

    public String toString() {
        return asMapOfRanges().toString();
    }

    public Object writeReplace() {
        return new SerializedForm(asMapOfRanges());
    }
}
