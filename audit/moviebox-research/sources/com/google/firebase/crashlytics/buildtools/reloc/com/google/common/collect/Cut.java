package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives.Booleans;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
abstract class Cut<C extends Comparable> implements Comparable<Cut<C>>, Serializable {
    private static final long serialVersionUID = 0;
    final C endpoint;

    /* JADX INFO: compiled from: source.java */
    public static final class AboveAll extends Cut<Comparable<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AboveAll f39289a = new AboveAll();
        private static final long serialVersionUID = 0;

        private AboveAll() {
            super(null);
        }

        private Object readResolve() {
            return f39289a;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut, java.lang.Comparable
        public int compareTo(Cut<Comparable<?>> cut) {
            return cut == this ? 0 : 1;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public void describeAsLowerBound(StringBuilder sb2) {
            throw new AssertionError();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public void describeAsUpperBound(StringBuilder sb2) {
            sb2.append("+∞)");
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public Comparable<?> endpoint() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public Comparable<?> greatestValueBelow(DiscreteDomain<Comparable<?>> discreteDomain) {
            return discreteDomain.maxValue();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public boolean isLessThan(Comparable<?> comparable) {
            return false;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public Comparable<?> leastValueAbove(DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError();
        }

        public String toString() {
            return "+∞";
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public BoundType typeAsLowerBound() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public BoundType typeAsUpperBound() {
            throw new IllegalStateException();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public Cut<Comparable<?>> withLowerBoundType(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public Cut<Comparable<?>> withUpperBoundType(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class AboveValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        public AboveValue(C c11) {
            super((Comparable) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(c11));
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public Cut<C> canonical(DiscreteDomain<C> discreteDomain) {
            Comparable comparableLeastValueAbove = leastValueAbove(discreteDomain);
            return comparableLeastValueAbove != null ? Cut.belowValue(comparableLeastValueAbove) : Cut.aboveAll();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((Cut) obj);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public void describeAsLowerBound(StringBuilder sb2) {
            sb2.append('(');
            sb2.append(this.endpoint);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public void describeAsUpperBound(StringBuilder sb2) {
            sb2.append(this.endpoint);
            sb2.append(']');
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public C greatestValueBelow(DiscreteDomain<C> discreteDomain) {
            return this.endpoint;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public int hashCode() {
            return ~this.endpoint.hashCode();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public boolean isLessThan(C c11) {
            return Range.compareOrThrow(this.endpoint, c11) < 0;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public C leastValueAbove(DiscreteDomain<C> discreteDomain) {
            return (C) discreteDomain.next(this.endpoint);
        }

        public String toString() {
            return "/" + this.endpoint + "\\";
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public BoundType typeAsLowerBound() {
            return BoundType.OPEN;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public BoundType typeAsUpperBound() {
            return BoundType.CLOSED;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public Cut<C> withLowerBoundType(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            int i11 = a.f39291a[boundType.ordinal()];
            if (i11 == 1) {
                Comparable next = discreteDomain.next(this.endpoint);
                return next == null ? Cut.belowAll() : Cut.belowValue(next);
            }
            if (i11 == 2) {
                return this;
            }
            throw new AssertionError();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public Cut<C> withUpperBoundType(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            int i11 = a.f39291a[boundType.ordinal()];
            if (i11 == 1) {
                return this;
            }
            if (i11 != 2) {
                throw new AssertionError();
            }
            Comparable next = discreteDomain.next(this.endpoint);
            return next == null ? Cut.aboveAll() : Cut.belowValue(next);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class BelowAll extends Cut<Comparable<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BelowAll f39290a = new BelowAll();
        private static final long serialVersionUID = 0;

        private BelowAll() {
            super(null);
        }

        private Object readResolve() {
            return f39290a;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public Cut<Comparable<?>> canonical(DiscreteDomain<Comparable<?>> discreteDomain) {
            try {
                return Cut.belowValue(discreteDomain.minValue());
            } catch (NoSuchElementException unused) {
                return this;
            }
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut, java.lang.Comparable
        public int compareTo(Cut<Comparable<?>> cut) {
            return cut == this ? 0 : -1;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public void describeAsLowerBound(StringBuilder sb2) {
            sb2.append("(-∞");
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public void describeAsUpperBound(StringBuilder sb2) {
            throw new AssertionError();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public Comparable<?> endpoint() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public Comparable<?> greatestValueBelow(DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public boolean isLessThan(Comparable<?> comparable) {
            return true;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public Comparable<?> leastValueAbove(DiscreteDomain<Comparable<?>> discreteDomain) {
            return discreteDomain.minValue();
        }

        public String toString() {
            return "-∞";
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public BoundType typeAsLowerBound() {
            throw new IllegalStateException();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public BoundType typeAsUpperBound() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public Cut<Comparable<?>> withLowerBoundType(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new IllegalStateException();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public Cut<Comparable<?>> withUpperBoundType(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError("this statement should be unreachable");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class BelowValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        public BelowValue(C c11) {
            super((Comparable) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(c11));
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((Cut) obj);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public void describeAsLowerBound(StringBuilder sb2) {
            sb2.append('[');
            sb2.append(this.endpoint);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public void describeAsUpperBound(StringBuilder sb2) {
            sb2.append(this.endpoint);
            sb2.append(')');
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public C greatestValueBelow(DiscreteDomain<C> discreteDomain) {
            return (C) discreteDomain.previous(this.endpoint);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public int hashCode() {
            return this.endpoint.hashCode();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public boolean isLessThan(C c11) {
            return Range.compareOrThrow(this.endpoint, c11) <= 0;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public C leastValueAbove(DiscreteDomain<C> discreteDomain) {
            return this.endpoint;
        }

        public String toString() {
            return "\\" + this.endpoint + "/";
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public BoundType typeAsLowerBound() {
            return BoundType.CLOSED;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public BoundType typeAsUpperBound() {
            return BoundType.OPEN;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public Cut<C> withLowerBoundType(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            int i11 = a.f39291a[boundType.ordinal()];
            if (i11 == 1) {
                return this;
            }
            if (i11 != 2) {
                throw new AssertionError();
            }
            Comparable comparablePrevious = discreteDomain.previous(this.endpoint);
            return comparablePrevious == null ? Cut.belowAll() : new AboveValue(comparablePrevious);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Cut
        public Cut<C> withUpperBoundType(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            int i11 = a.f39291a[boundType.ordinal()];
            if (i11 == 1) {
                Comparable comparablePrevious = discreteDomain.previous(this.endpoint);
                return comparablePrevious == null ? Cut.aboveAll() : new AboveValue(comparablePrevious);
            }
            if (i11 == 2) {
                return this;
            }
            throw new AssertionError();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f39291a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f39291a = iArr;
            try {
                iArr[BoundType.CLOSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f39291a[BoundType.OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public Cut(C c11) {
        this.endpoint = c11;
    }

    public static <C extends Comparable> Cut<C> aboveAll() {
        return AboveAll.f39289a;
    }

    public static <C extends Comparable> Cut<C> aboveValue(C c11) {
        return new AboveValue(c11);
    }

    public static <C extends Comparable> Cut<C> belowAll() {
        return BelowAll.f39290a;
    }

    public static <C extends Comparable> Cut<C> belowValue(C c11) {
        return new BelowValue(c11);
    }

    public Cut<C> canonical(DiscreteDomain<C> discreteDomain) {
        return this;
    }

    @Override // java.lang.Comparable
    public int compareTo(Cut<C> cut) {
        if (cut == belowAll()) {
            return 1;
        }
        if (cut == aboveAll()) {
            return -1;
        }
        int iCompareOrThrow = Range.compareOrThrow(this.endpoint, cut.endpoint);
        return iCompareOrThrow != 0 ? iCompareOrThrow : Booleans.a(this instanceof AboveValue, cut instanceof AboveValue);
    }

    public abstract void describeAsLowerBound(StringBuilder sb2);

    public abstract void describeAsUpperBound(StringBuilder sb2);

    public C endpoint() {
        return this.endpoint;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Cut)) {
            return false;
        }
        try {
            return compareTo((Cut) obj) == 0;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public abstract C greatestValueBelow(DiscreteDomain<C> discreteDomain);

    public abstract int hashCode();

    public abstract boolean isLessThan(C c11);

    public abstract C leastValueAbove(DiscreteDomain<C> discreteDomain);

    public abstract BoundType typeAsLowerBound();

    public abstract BoundType typeAsUpperBound();

    public abstract Cut<C> withLowerBoundType(BoundType boundType, DiscreteDomain<C> discreteDomain);

    public abstract Cut<C> withUpperBoundType(BoundType boundType, DiscreteDomain<C> discreteDomain);
}
