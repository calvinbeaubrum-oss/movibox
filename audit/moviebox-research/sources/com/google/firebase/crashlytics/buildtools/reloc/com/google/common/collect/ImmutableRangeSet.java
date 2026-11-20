package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives.Ints;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collector;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class ImmutableRangeSet<C extends Comparable> extends v<C> implements Serializable {
    private transient ImmutableRangeSet<C> complement;
    private final transient ImmutableList<Range<C>> ranges;
    private static final ImmutableRangeSet<Comparable<?>> EMPTY = new ImmutableRangeSet<>(ImmutableList.of());
    private static final ImmutableRangeSet<Comparable<?>> ALL = new ImmutableRangeSet<>(ImmutableList.of(Range.all()));

    /* JADX INFO: compiled from: source.java */
    public final class AsSet extends ImmutableSortedSet<C> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public transient Integer f39368a;
        private final DiscreteDomain<C> domain;

        /* JADX INFO: compiled from: source.java */
        public class a extends AbstractIterator<C> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Iterator<Range<C>> f39369c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Iterator<C> f39370d = Iterators.h();

            public a() {
                this.f39369c = ImmutableRangeSet.this.ranges.iterator();
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public C a() {
                while (!this.f39370d.hasNext()) {
                    if (!this.f39369c.hasNext()) {
                        return (C) b();
                    }
                    this.f39370d = ContiguousSet.create(this.f39369c.next(), AsSet.this.domain).iterator();
                }
                return this.f39370d.next();
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b extends AbstractIterator<C> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Iterator<Range<C>> f39372c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Iterator<C> f39373d = Iterators.h();

            public b() {
                this.f39372c = ImmutableRangeSet.this.ranges.reverse().iterator();
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public C a() {
                while (!this.f39373d.hasNext()) {
                    if (!this.f39372c.hasNext()) {
                        return (C) b();
                    }
                    this.f39373d = ContiguousSet.create(this.f39372c.next(), AsSet.this.domain).descendingIterator();
                }
                return this.f39373d.next();
            }
        }

        public AsSet(DiscreteDomain<C> discreteDomain) {
            super(Ordering.natural());
            this.domain = discreteDomain;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                return ImmutableRangeSet.this.contains((Comparable) obj);
            } catch (ClassCastException unused) {
                return false;
            }
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet
        public ImmutableSortedSet<C> createDescendingSet() {
            return new DescendingImmutableSortedSet(this);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
        public t7<C> descendingIterator() {
            return new b();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet
        public ImmutableSortedSet<C> headSetImpl(C c11, boolean z11) {
            return subSet(Range.upTo(c11, BoundType.forBoolean(z11)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet
        public int indexOf(Object obj) {
            if (!contains(obj)) {
                return -1;
            }
            Comparable comparable = (Comparable) obj;
            t7 it = ImmutableRangeSet.this.ranges.iterator();
            long size = 0;
            while (it.hasNext()) {
                Range range = (Range) it.next();
                if (range.contains(comparable)) {
                    return Ints.i(size + ((long) ContiguousSet.create(range, this.domain).indexOf(comparable)));
                }
                size += (long) ContiguousSet.create(range, this.domain).size();
            }
            throw new AssertionError("impossible");
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return ImmutableRangeSet.this.ranges.isPartialView();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public t7<C> iterator() {
            return new a();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Integer numValueOf = this.f39368a;
            if (numValueOf == null) {
                t7 it = ImmutableRangeSet.this.ranges.iterator();
                long size = 0;
                while (it.hasNext()) {
                    size += (long) ContiguousSet.create((Range) it.next(), this.domain).size();
                    if (size >= 2147483647L) {
                        break;
                    }
                }
                numValueOf = Integer.valueOf(Ints.i(size));
                this.f39368a = numValueOf;
            }
            return numValueOf.intValue();
        }

        public ImmutableSortedSet<C> subSet(Range<C> range) {
            return ImmutableRangeSet.this.subRangeSet((Range) range).asSet(this.domain);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet
        public ImmutableSortedSet<C> subSetImpl(C c11, boolean z11, C c12, boolean z12) {
            return (z11 || z12 || Range.compareOrThrow(c11, c12) != 0) ? subSet(Range.range(c11, BoundType.forBoolean(z11), c12, BoundType.forBoolean(z12))) : ImmutableSortedSet.of();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet
        public ImmutableSortedSet<C> tailSetImpl(C c11, boolean z11) {
            return subSet(Range.downTo(c11, BoundType.forBoolean(z11)));
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return ImmutableRangeSet.this.ranges.toString();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return new AsSetSerializedForm(ImmutableRangeSet.this.ranges, this.domain);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class AsSetSerializedForm<C extends Comparable> implements Serializable {
        private final DiscreteDomain<C> domain;
        private final ImmutableList<Range<C>> ranges;

        public AsSetSerializedForm(ImmutableList<Range<C>> immutableList, DiscreteDomain<C> discreteDomain) {
            this.ranges = immutableList;
            this.domain = discreteDomain;
        }

        public Object readResolve() {
            return new ImmutableRangeSet(this.ranges).asSet(this.domain);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class ComplementRanges extends ImmutableList<Range<C>> {
        private final boolean positiveBoundedAbove;
        private final boolean positiveBoundedBelow;
        private final int size;

        /* JADX WARN: Multi-variable type inference failed */
        public ComplementRanges() {
            boolean zHasLowerBound = ((Range) ImmutableRangeSet.this.ranges.get(0)).hasLowerBound();
            this.positiveBoundedBelow = zHasLowerBound;
            boolean zHasUpperBound = ((Range) j5.f(ImmutableRangeSet.this.ranges)).hasUpperBound();
            this.positiveBoundedAbove = zHasUpperBound;
            int size = ImmutableRangeSet.this.ranges.size();
            size = zHasLowerBound ? size : size - 1;
            this.size = zHasUpperBound ? size + 1 : size;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public Range<C> get(int i11) {
            Cut<C> cutBelowAll;
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.l(i11, this.size);
            if (this.positiveBoundedBelow) {
                cutBelowAll = i11 == 0 ? Cut.belowAll() : ((Range) ImmutableRangeSet.this.ranges.get(i11 - 1)).upperBound;
            } else {
                cutBelowAll = ((Range) ImmutableRangeSet.this.ranges.get(i11)).upperBound;
            }
            return Range.create(cutBelowAll, (this.positiveBoundedAbove && i11 == this.size + (-1)) ? Cut.aboveAll() : ((Range) ImmutableRangeSet.this.ranges.get(i11 + (!this.positiveBoundedBelow ? 1 : 0))).lowerBound);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.size;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class SerializedForm<C extends Comparable> implements Serializable {
        private final ImmutableList<Range<C>> ranges;

        public SerializedForm(ImmutableList<Range<C>> immutableList) {
            this.ranges = immutableList;
        }

        public Object readResolve() {
            if (this.ranges.isEmpty()) {
                return ImmutableRangeSet.of();
            }
            return this.ranges.equals(ImmutableList.of(Range.all())) ? ImmutableRangeSet.all() : new ImmutableRangeSet(this.ranges);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class a<C extends Comparable<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Range<C>> f39375a = Lists.h();

        public a<C> a(Range<C> range) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.j(!range.isEmpty(), "range must not be empty, but was %s", range);
            this.f39375a.add(range);
            return this;
        }

        public a<C> b(Iterable<Range<C>> iterable) {
            Iterator<Range<C>> it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }

        public ImmutableRangeSet<C> c() {
            ImmutableList.b bVar = new ImmutableList.b(this.f39375a.size());
            Collections.sort(this.f39375a, Range.rangeLexOrdering());
            q6 q6VarR = Iterators.r(this.f39375a.iterator());
            while (q6VarR.hasNext()) {
                Range rangeSpan = (Range) q6VarR.next();
                while (q6VarR.hasNext()) {
                    Range<C> range = (Range) q6VarR.peek();
                    if (!rangeSpan.isConnected(range)) {
                        break;
                    }
                    com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.k(rangeSpan.intersection(range).isEmpty(), "Overlapping ranges not permitted but found %s overlapping %s", rangeSpan, range);
                    rangeSpan = rangeSpan.span((Range) q6VarR.next());
                }
                bVar.a(rangeSpan);
            }
            ImmutableList immutableListH = bVar.h();
            if (immutableListH.isEmpty()) {
                return ImmutableRangeSet.of();
            }
            return (immutableListH.size() == 1 && ((Range) j5.h(immutableListH)).equals(Range.all())) ? ImmutableRangeSet.all() : new ImmutableRangeSet<>(immutableListH);
        }

        public a<C> d(a<C> aVar) {
            b(aVar.f39375a);
            return this;
        }
    }

    public ImmutableRangeSet(ImmutableList<Range<C>> immutableList) {
        this.ranges = immutableList;
    }

    private ImmutableRangeSet(ImmutableList<Range<C>> immutableList, ImmutableRangeSet<C> immutableRangeSet) {
        this.ranges = immutableList;
        this.complement = immutableRangeSet;
    }

    public static <C extends Comparable> ImmutableRangeSet<C> all() {
        return ALL;
    }

    public static <C extends Comparable<?>> a<C> builder() {
        return new a<>();
    }

    public static <C extends Comparable> ImmutableRangeSet<C> copyOf(v6<C> v6Var) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(v6Var);
        if (v6Var.isEmpty()) {
            return of();
        }
        if (v6Var.encloses(Range.all())) {
            return all();
        }
        if (v6Var instanceof ImmutableRangeSet) {
            ImmutableRangeSet<C> immutableRangeSet = (ImmutableRangeSet) v6Var;
            if (!immutableRangeSet.isPartialView()) {
                return immutableRangeSet;
            }
        }
        return new ImmutableRangeSet<>(ImmutableList.copyOf((Collection) v6Var.asRanges()));
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> copyOf(Iterable<Range<C>> iterable) {
        return new a().b(iterable).c();
    }

    private ImmutableList<Range<C>> intersectRanges(final Range<C> range) {
        if (this.ranges.isEmpty() || range.isEmpty()) {
            return ImmutableList.of();
        }
        if (range.encloses(span())) {
            return this.ranges;
        }
        final int iA = range.hasLowerBound() ? SortedLists.a(this.ranges, Range.upperBoundFn(), range.lowerBound, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER) : 0;
        final int iA2 = (range.hasUpperBound() ? SortedLists.a(this.ranges, Range.lowerBoundFn(), range.upperBound, SortedLists.KeyPresentBehavior.FIRST_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER) : this.ranges.size()) - iA;
        return iA2 == 0 ? ImmutableList.of() : (ImmutableList<Range<C>>) new ImmutableList<Range<C>>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableRangeSet.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.List
            public Range<C> get(int i11) {
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.l(i11, iA2);
                return (i11 == 0 || i11 == iA2 + (-1)) ? ((Range) ImmutableRangeSet.this.ranges.get(i11 + iA)).intersection(range) : (Range) ImmutableRangeSet.this.ranges.get(i11 + iA);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
            public boolean isPartialView() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return iA2;
            }
        };
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of() {
        return EMPTY;
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of(Range<C> range) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(range);
        if (range.isEmpty()) {
            return of();
        }
        return range.equals(Range.all()) ? all() : new ImmutableRangeSet<>(ImmutableList.of(range));
    }

    public static <E extends Comparable<? super E>> Collector<Range<E>, ?, ImmutableRangeSet<E>> toImmutableRangeSet() {
        return m1.q();
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> unionOf(Iterable<Range<C>> iterable) {
        return copyOf(TreeRangeSet.create(iterable));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v6
    @Deprecated
    public void add(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
    @Deprecated
    public void addAll(v6<C> v6Var) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
    @Deprecated
    public void addAll(Iterable<Range<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: asDescendingSetOfRanges, reason: merged with bridge method [inline-methods] */
    public ImmutableSet<Range<C>> m153asDescendingSetOfRanges() {
        return this.ranges.isEmpty() ? ImmutableSet.of() : new RegularImmutableSortedSet(this.ranges.reverse(), Range.rangeLexOrdering().reverse());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v6
    public ImmutableSet<Range<C>> asRanges() {
        return this.ranges.isEmpty() ? ImmutableSet.of() : new RegularImmutableSortedSet(this.ranges, Range.rangeLexOrdering());
    }

    public ImmutableSortedSet<C> asSet(DiscreteDomain<C> discreteDomain) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(discreteDomain);
        if (isEmpty()) {
            return ImmutableSortedSet.of();
        }
        Range<C> rangeCanonical = span().canonical(discreteDomain);
        if (!rangeCanonical.hasLowerBound()) {
            throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
        }
        if (!rangeCanonical.hasUpperBound()) {
            try {
                discreteDomain.maxValue();
            } catch (NoSuchElementException unused) {
                throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
            }
        }
        return new AsSet(discreteDomain);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v6
    public ImmutableRangeSet<C> complement() {
        ImmutableRangeSet<C> immutableRangeSet = this.complement;
        if (immutableRangeSet != null) {
            return immutableRangeSet;
        }
        if (this.ranges.isEmpty()) {
            ImmutableRangeSet<C> immutableRangeSetAll = all();
            this.complement = immutableRangeSetAll;
            return immutableRangeSetAll;
        }
        if (this.ranges.size() == 1 && this.ranges.get(0).equals(Range.all())) {
            ImmutableRangeSet<C> immutableRangeSetOf = of();
            this.complement = immutableRangeSetOf;
            return immutableRangeSetOf;
        }
        ImmutableRangeSet<C> immutableRangeSet2 = new ImmutableRangeSet<>(new ComplementRanges(), this);
        this.complement = immutableRangeSet2;
        return immutableRangeSet2;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    public ImmutableRangeSet<C> difference(v6<C> v6Var) {
        TreeRangeSet treeRangeSetCreate = TreeRangeSet.create(this);
        treeRangeSetCreate.removeAll(v6Var);
        return copyOf(treeRangeSetCreate);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v6
    public boolean encloses(Range<C> range) {
        int iB = SortedLists.b(this.ranges, Range.lowerBoundFn(), range.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        return iB != -1 && this.ranges.get(iB).encloses(range);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
    public /* bridge */ /* synthetic */ boolean enclosesAll(v6 v6Var) {
        return super.enclosesAll(v6Var);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return u6.b(this, iterable);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public ImmutableRangeSet<C> intersection(v6<C> v6Var) {
        TreeRangeSet treeRangeSetCreate = TreeRangeSet.create(this);
        treeRangeSetCreate.removeAll(v6Var.complement());
        return copyOf(treeRangeSetCreate);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
    public boolean intersects(Range<C> range) {
        int iB = SortedLists.b(this.ranges, Range.lowerBoundFn(), range.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        if (iB < this.ranges.size() && this.ranges.get(iB).isConnected(range) && !this.ranges.get(iB).intersection(range).isEmpty()) {
            return true;
        }
        if (iB > 0) {
            int i11 = iB - 1;
            if (this.ranges.get(i11).isConnected(range) && !this.ranges.get(i11).intersection(range).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v6
    public boolean isEmpty() {
        return this.ranges.isEmpty();
    }

    public boolean isPartialView() {
        return this.ranges.isPartialView();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
    public Range<C> rangeContaining(C c11) {
        int iB = SortedLists.b(this.ranges, Range.lowerBoundFn(), Cut.belowValue(c11), Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (iB == -1) {
            return null;
        }
        Range<C> range = this.ranges.get(iB);
        if (range.contains(c11)) {
            return range;
        }
        return null;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v6
    @Deprecated
    public void remove(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v6
    @Deprecated
    public void removeAll(v6<C> v6Var) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
    @Deprecated
    public void removeAll(Iterable<Range<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    public Range<C> span() {
        if (this.ranges.isEmpty()) {
            throw new NoSuchElementException();
        }
        Cut<C> cut = this.ranges.get(0).lowerBound;
        ImmutableList<Range<C>> immutableList = this.ranges;
        return Range.create(cut, immutableList.get(immutableList.size() - 1).upperBound);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v6
    public ImmutableRangeSet<C> subRangeSet(Range<C> range) {
        if (!isEmpty()) {
            Range<C> rangeSpan = span();
            if (range.encloses(rangeSpan)) {
                return this;
            }
            if (range.isConnected(rangeSpan)) {
                return new ImmutableRangeSet<>(intersectRanges(range));
            }
        }
        return of();
    }

    public ImmutableRangeSet<C> union(v6<C> v6Var) {
        return unionOf(j5.c(asRanges(), v6Var.asRanges()));
    }

    public Object writeReplace() {
        return new SerializedForm(this.ranges);
    }
}
