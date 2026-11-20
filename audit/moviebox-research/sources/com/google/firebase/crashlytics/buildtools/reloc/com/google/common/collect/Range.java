package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class Range<C extends Comparable> extends RangeGwtSerializationDependencies implements com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n<C> {
    private static final Range<Comparable> ALL = new Range<>(Cut.belowAll(), Cut.aboveAll());
    private static final long serialVersionUID = 0;
    final Cut<C> lowerBound;
    final Cut<C> upperBound;

    /* JADX INFO: compiled from: source.java */
    public static class RangeLexOrdering extends Ordering<Range<?>> implements Serializable {
        static final Ordering<Range<?>> INSTANCE = new RangeLexOrdering();
        private static final long serialVersionUID = 0;

        private RangeLexOrdering() {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Ordering, java.util.Comparator
        public int compare(Range<?> range, Range<?> range2) {
            return k2.f().d(range.lowerBound, range2.lowerBound).d(range.upperBound, range2.upperBound).e();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f39546a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f39546a = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f39546a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<Range, Cut> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f39547a = new b();

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d, java.util.function.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Cut apply(Range range) {
            return range.lowerBound;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<Range, Cut> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f39548a = new c();

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d, java.util.function.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Cut apply(Range range) {
            return range.upperBound;
        }
    }

    private Range(Cut<C> cut, Cut<C> cut2) {
        this.lowerBound = (Cut) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(cut);
        this.upperBound = (Cut) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(cut2);
        if (cut.compareTo((Cut) cut2) > 0 || cut == Cut.aboveAll() || cut2 == Cut.belowAll()) {
            throw new IllegalArgumentException("Invalid range: " + toString(cut, cut2));
        }
    }

    public static <C extends Comparable<?>> Range<C> all() {
        return (Range<C>) ALL;
    }

    public static <C extends Comparable<?>> Range<C> atLeast(C c11) {
        return create(Cut.belowValue(c11), Cut.aboveAll());
    }

    public static <C extends Comparable<?>> Range<C> atMost(C c11) {
        return create(Cut.belowAll(), Cut.aboveValue(c11));
    }

    private static <T> SortedSet<T> cast(Iterable<T> iterable) {
        return (SortedSet) iterable;
    }

    public static <C extends Comparable<?>> Range<C> closed(C c11, C c12) {
        return create(Cut.belowValue(c11), Cut.aboveValue(c12));
    }

    public static <C extends Comparable<?>> Range<C> closedOpen(C c11, C c12) {
        return create(Cut.belowValue(c11), Cut.belowValue(c12));
    }

    public static int compareOrThrow(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static <C extends Comparable<?>> Range<C> create(Cut<C> cut, Cut<C> cut2) {
        return new Range<>(cut, cut2);
    }

    public static <C extends Comparable<?>> Range<C> downTo(C c11, BoundType boundType) {
        int i11 = a.f39546a[boundType.ordinal()];
        if (i11 == 1) {
            return greaterThan(c11);
        }
        if (i11 == 2) {
            return atLeast(c11);
        }
        throw new AssertionError();
    }

    public static <C extends Comparable<?>> Range<C> encloseAll(Iterable<C> iterable) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(iterable);
        if (iterable instanceof SortedSet) {
            SortedSet sortedSetCast = cast(iterable);
            Comparator comparator = sortedSetCast.comparator();
            if (Ordering.natural().equals(comparator) || comparator == null) {
                return closed((Comparable) sortedSetCast.first(), (Comparable) sortedSetCast.last());
            }
        }
        Iterator<C> it = iterable.iterator();
        Comparable comparable = (Comparable) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(it.next());
        Comparable comparable2 = comparable;
        while (it.hasNext()) {
            Comparable comparable3 = (Comparable) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(it.next());
            comparable = (Comparable) Ordering.natural().min(comparable, comparable3);
            comparable2 = (Comparable) Ordering.natural().max(comparable2, comparable3);
        }
        return closed(comparable, comparable2);
    }

    public static <C extends Comparable<?>> Range<C> greaterThan(C c11) {
        return create(Cut.aboveValue(c11), Cut.aboveAll());
    }

    public static <C extends Comparable<?>> Range<C> lessThan(C c11) {
        return create(Cut.belowAll(), Cut.belowValue(c11));
    }

    public static <C extends Comparable<?>> com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<Range<C>, Cut<C>> lowerBoundFn() {
        return b.f39547a;
    }

    public static <C extends Comparable<?>> Range<C> open(C c11, C c12) {
        return create(Cut.aboveValue(c11), Cut.belowValue(c12));
    }

    public static <C extends Comparable<?>> Range<C> openClosed(C c11, C c12) {
        return create(Cut.aboveValue(c11), Cut.aboveValue(c12));
    }

    public static <C extends Comparable<?>> Range<C> range(C c11, BoundType boundType, C c12, BoundType boundType2) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(boundType);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(boundType2);
        BoundType boundType3 = BoundType.OPEN;
        return create(boundType == boundType3 ? Cut.aboveValue(c11) : Cut.belowValue(c11), boundType2 == boundType3 ? Cut.belowValue(c12) : Cut.aboveValue(c12));
    }

    public static <C extends Comparable<?>> Ordering<Range<C>> rangeLexOrdering() {
        return (Ordering<Range<C>>) RangeLexOrdering.INSTANCE;
    }

    public static <C extends Comparable<?>> Range<C> singleton(C c11) {
        return closed(c11, c11);
    }

    private static String toString(Cut<?> cut, Cut<?> cut2) {
        StringBuilder sb2 = new StringBuilder(16);
        cut.describeAsLowerBound(sb2);
        sb2.append("..");
        cut2.describeAsUpperBound(sb2);
        return sb2.toString();
    }

    public static <C extends Comparable<?>> Range<C> upTo(C c11, BoundType boundType) {
        int i11 = a.f39546a[boundType.ordinal()];
        if (i11 == 1) {
            return lessThan(c11);
        }
        if (i11 == 2) {
            return atMost(c11);
        }
        throw new AssertionError();
    }

    public static <C extends Comparable<?>> com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<Range<C>, Cut<C>> upperBoundFn() {
        return c.f39548a;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
    @Deprecated
    public boolean apply(C c11) {
        return contains(c11);
    }

    public Range<C> canonical(DiscreteDomain<C> discreteDomain) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(discreteDomain);
        Cut<C> cutCanonical = this.lowerBound.canonical(discreteDomain);
        Cut<C> cutCanonical2 = this.upperBound.canonical(discreteDomain);
        return (cutCanonical == this.lowerBound && cutCanonical2 == this.upperBound) ? this : create(cutCanonical, cutCanonical2);
    }

    public boolean contains(C c11) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(c11);
        return this.lowerBound.isLessThan(c11) && !this.upperBound.isLessThan(c11);
    }

    public boolean containsAll(Iterable<? extends C> iterable) {
        if (j5.i(iterable)) {
            return true;
        }
        if (iterable instanceof SortedSet) {
            SortedSet sortedSetCast = cast(iterable);
            Comparator comparator = sortedSetCast.comparator();
            if (Ordering.natural().equals(comparator) || comparator == null) {
                return contains((Comparable) sortedSetCast.first()) && contains((Comparable) sortedSetCast.last());
            }
        }
        Iterator<? extends C> it = iterable.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean encloses(Range<C> range) {
        return this.lowerBound.compareTo((Cut) range.lowerBound) <= 0 && this.upperBound.compareTo((Cut) range.upperBound) >= 0;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
    public boolean equals(Object obj) {
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        return this.lowerBound.equals(range.lowerBound) && this.upperBound.equals(range.upperBound);
    }

    public boolean hasLowerBound() {
        return this.lowerBound != Cut.belowAll();
    }

    public boolean hasUpperBound() {
        return this.upperBound != Cut.aboveAll();
    }

    public int hashCode() {
        return (this.lowerBound.hashCode() * 31) + this.upperBound.hashCode();
    }

    public Range<C> intersection(Range<C> range) {
        int iCompareTo = this.lowerBound.compareTo((Cut) range.lowerBound);
        int iCompareTo2 = this.upperBound.compareTo((Cut) range.upperBound);
        if (iCompareTo >= 0 && iCompareTo2 <= 0) {
            return this;
        }
        if (iCompareTo > 0 || iCompareTo2 < 0) {
            return create(iCompareTo >= 0 ? this.lowerBound : range.lowerBound, iCompareTo2 <= 0 ? this.upperBound : range.upperBound);
        }
        return range;
    }

    public boolean isConnected(Range<C> range) {
        return this.lowerBound.compareTo((Cut) range.upperBound) <= 0 && range.lowerBound.compareTo((Cut) this.upperBound) <= 0;
    }

    public boolean isEmpty() {
        return this.lowerBound.equals(this.upperBound);
    }

    public BoundType lowerBoundType() {
        return this.lowerBound.typeAsLowerBound();
    }

    public C lowerEndpoint() {
        return (C) this.lowerBound.endpoint();
    }

    public Object readResolve() {
        return equals(ALL) ? all() : this;
    }

    public Range<C> span(Range<C> range) {
        int iCompareTo = this.lowerBound.compareTo((Cut) range.lowerBound);
        int iCompareTo2 = this.upperBound.compareTo((Cut) range.upperBound);
        if (iCompareTo <= 0 && iCompareTo2 >= 0) {
            return this;
        }
        if (iCompareTo < 0 || iCompareTo2 > 0) {
            return create(iCompareTo <= 0 ? this.lowerBound : range.lowerBound, iCompareTo2 >= 0 ? this.upperBound : range.upperBound);
        }
        return range;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n, java.util.function.Predicate
    public /* bridge */ /* synthetic */ boolean test(Object obj) {
        return com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.m.a(this, obj);
    }

    public String toString() {
        return toString(this.lowerBound, this.upperBound);
    }

    public BoundType upperBoundType() {
        return this.upperBound.typeAsUpperBound();
    }

    public C upperEndpoint() {
        return (C) this.upperBound.endpoint();
    }
}
