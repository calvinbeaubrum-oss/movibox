package com.google.common.collect;

import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class TreeMultiset<E> extends h<E> implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient e<E> header;
    private final transient GeneralRange<E> range;
    private final transient f<e<E>> rootReference;

    /* JADX INFO: compiled from: source.java */
    public enum Aggregate {
        SIZE { // from class: com.google.common.collect.TreeMultiset.Aggregate.1
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public int nodeAggregate(e<?> eVar) {
                return eVar.f38637b;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public long treeAggregate(e<?> eVar) {
                if (eVar == null) {
                    return 0L;
                }
                return eVar.f38639d;
            }
        },
        DISTINCT { // from class: com.google.common.collect.TreeMultiset.Aggregate.2
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public int nodeAggregate(e<?> eVar) {
                return 1;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public long treeAggregate(e<?> eVar) {
                if (eVar == null) {
                    return 0L;
                }
                return eVar.f38638c;
            }
        };

        /* synthetic */ Aggregate(a aVar) {
            this();
        }

        public abstract int nodeAggregate(e<?> eVar);

        public abstract long treeAggregate(e<?> eVar);
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends Multisets.b<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f38627a;

        public a(e eVar) {
            this.f38627a = eVar;
        }

        @Override // com.google.common.collect.j0.a
        public int getCount() {
            int iW = this.f38627a.w();
            return iW == 0 ? TreeMultiset.this.count(getElement()) : iW;
        }

        @Override // com.google.common.collect.j0.a
        public E getElement() {
            return (E) this.f38627a.x();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Iterator<j0.a<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e<E> f38629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public j0.a<E> f38630b;

        public b() {
            this.f38629a = TreeMultiset.this.firstNode();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public j0.a<E> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            TreeMultiset treeMultiset = TreeMultiset.this;
            e<E> eVar = this.f38629a;
            Objects.requireNonNull(eVar);
            j0.a<E> aVarWrapEntry = treeMultiset.wrapEntry(eVar);
            this.f38630b = aVarWrapEntry;
            if (this.f38629a.L() == TreeMultiset.this.header) {
                this.f38629a = null;
            } else {
                this.f38629a = this.f38629a.L();
            }
            return aVarWrapEntry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f38629a == null) {
                return false;
            }
            if (!TreeMultiset.this.range.tooHigh(this.f38629a.x())) {
                return true;
            }
            this.f38629a = null;
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.base.m.w(this.f38630b != null, "no calls to next() since the last call to remove()");
            TreeMultiset.this.setCount(this.f38630b.getElement(), 0);
            this.f38630b = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Iterator<j0.a<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e<E> f38632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public j0.a<E> f38633b = null;

        public c() {
            this.f38632a = TreeMultiset.this.lastNode();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public j0.a<E> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Objects.requireNonNull(this.f38632a);
            j0.a<E> aVarWrapEntry = TreeMultiset.this.wrapEntry(this.f38632a);
            this.f38633b = aVarWrapEntry;
            if (this.f38632a.z() == TreeMultiset.this.header) {
                this.f38632a = null;
            } else {
                this.f38632a = this.f38632a.z();
            }
            return aVarWrapEntry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f38632a == null) {
                return false;
            }
            if (!TreeMultiset.this.range.tooLow(this.f38632a.x())) {
                return true;
            }
            this.f38632a = null;
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.base.m.w(this.f38633b != null, "no calls to next() since the last call to remove()");
            TreeMultiset.this.setCount(this.f38633b.getElement(), 0);
            this.f38633b = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38635a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f38635a = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38635a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final E f38636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f38637b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f38638c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f38639d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f38640e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public e<E> f38641f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public e<E> f38642g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public e<E> f38643h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public e<E> f38644i;

        public e() {
            this.f38636a = null;
            this.f38637b = 1;
        }

        public e(E e11, int i11) {
            com.google.common.base.m.d(i11 > 0);
            this.f38636a = e11;
            this.f38637b = i11;
            this.f38639d = i11;
            this.f38638c = 1;
            this.f38640e = 1;
            this.f38641f = null;
            this.f38642g = null;
        }

        public static long M(e<?> eVar) {
            if (eVar == null) {
                return 0L;
            }
            return eVar.f38639d;
        }

        public static int y(e<?> eVar) {
            if (eVar == null) {
                return 0;
            }
            return eVar.f38640e;
        }

        public final e<E> A() {
            int iR = r();
            if (iR == -2) {
                Objects.requireNonNull(this.f38642g);
                if (this.f38642g.r() > 0) {
                    this.f38642g = this.f38642g.I();
                }
                return H();
            }
            if (iR != 2) {
                C();
                return this;
            }
            Objects.requireNonNull(this.f38641f);
            if (this.f38641f.r() < 0) {
                this.f38641f = this.f38641f.H();
            }
            return I();
        }

        public final void B() {
            D();
            C();
        }

        public final void C() {
            this.f38640e = Math.max(y(this.f38641f), y(this.f38642g)) + 1;
        }

        public final void D() {
            this.f38638c = TreeMultiset.distinctElements(this.f38641f) + 1 + TreeMultiset.distinctElements(this.f38642g);
            this.f38639d = ((long) this.f38637b) + M(this.f38641f) + M(this.f38642g);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e<E> E(Comparator<? super E> comparator, E e11, int i11, int[] iArr) {
            int iCompare = comparator.compare(e11, x());
            if (iCompare < 0) {
                e<E> eVar = this.f38641f;
                if (eVar == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f38641f = eVar.E(comparator, e11, i11, iArr);
                int i12 = iArr[0];
                if (i12 > 0) {
                    if (i11 >= i12) {
                        this.f38638c--;
                        this.f38639d -= (long) i12;
                    } else {
                        this.f38639d -= (long) i11;
                    }
                }
                return i12 == 0 ? this : A();
            }
            if (iCompare <= 0) {
                int i13 = this.f38637b;
                iArr[0] = i13;
                if (i11 >= i13) {
                    return u();
                }
                this.f38637b = i13 - i11;
                this.f38639d -= (long) i11;
                return this;
            }
            e<E> eVar2 = this.f38642g;
            if (eVar2 == null) {
                iArr[0] = 0;
                return this;
            }
            this.f38642g = eVar2.E(comparator, e11, i11, iArr);
            int i14 = iArr[0];
            if (i14 > 0) {
                if (i11 >= i14) {
                    this.f38638c--;
                    this.f38639d -= (long) i14;
                } else {
                    this.f38639d -= (long) i11;
                }
            }
            return A();
        }

        public final e<E> F(e<E> eVar) {
            e<E> eVar2 = this.f38642g;
            if (eVar2 == null) {
                return this.f38641f;
            }
            this.f38642g = eVar2.F(eVar);
            this.f38638c--;
            this.f38639d -= (long) eVar.f38637b;
            return A();
        }

        public final e<E> G(e<E> eVar) {
            e<E> eVar2 = this.f38641f;
            if (eVar2 == null) {
                return this.f38642g;
            }
            this.f38641f = eVar2.G(eVar);
            this.f38638c--;
            this.f38639d -= (long) eVar.f38637b;
            return A();
        }

        public final e<E> H() {
            com.google.common.base.m.v(this.f38642g != null);
            e<E> eVar = this.f38642g;
            this.f38642g = eVar.f38641f;
            eVar.f38641f = this;
            eVar.f38639d = this.f38639d;
            eVar.f38638c = this.f38638c;
            B();
            eVar.C();
            return eVar;
        }

        public final e<E> I() {
            com.google.common.base.m.v(this.f38641f != null);
            e<E> eVar = this.f38641f;
            this.f38641f = eVar.f38642g;
            eVar.f38642g = this;
            eVar.f38639d = this.f38639d;
            eVar.f38638c = this.f38638c;
            B();
            eVar.C();
            return eVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e<E> J(Comparator<? super E> comparator, E e11, int i11, int i12, int[] iArr) {
            int iCompare = comparator.compare(e11, x());
            if (iCompare < 0) {
                e<E> eVar = this.f38641f;
                if (eVar == null) {
                    iArr[0] = 0;
                    return (i11 != 0 || i12 <= 0) ? this : p(e11, i12);
                }
                this.f38641f = eVar.J(comparator, e11, i11, i12, iArr);
                int i13 = iArr[0];
                if (i13 == i11) {
                    if (i12 == 0 && i13 != 0) {
                        this.f38638c--;
                    } else if (i12 > 0 && i13 == 0) {
                        this.f38638c++;
                    }
                    this.f38639d += (long) (i12 - i13);
                }
                return A();
            }
            if (iCompare <= 0) {
                int i14 = this.f38637b;
                iArr[0] = i14;
                if (i11 == i14) {
                    if (i12 == 0) {
                        return u();
                    }
                    this.f38639d += (long) (i12 - i14);
                    this.f38637b = i12;
                }
                return this;
            }
            e<E> eVar2 = this.f38642g;
            if (eVar2 == null) {
                iArr[0] = 0;
                return (i11 != 0 || i12 <= 0) ? this : q(e11, i12);
            }
            this.f38642g = eVar2.J(comparator, e11, i11, i12, iArr);
            int i15 = iArr[0];
            if (i15 == i11) {
                if (i12 == 0 && i15 != 0) {
                    this.f38638c--;
                } else if (i12 > 0 && i15 == 0) {
                    this.f38638c++;
                }
                this.f38639d += (long) (i12 - i15);
            }
            return A();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e<E> K(Comparator<? super E> comparator, E e11, int i11, int[] iArr) {
            int iCompare = comparator.compare(e11, x());
            if (iCompare < 0) {
                e<E> eVar = this.f38641f;
                if (eVar == null) {
                    iArr[0] = 0;
                    return i11 > 0 ? p(e11, i11) : this;
                }
                this.f38641f = eVar.K(comparator, e11, i11, iArr);
                if (i11 == 0 && iArr[0] != 0) {
                    this.f38638c--;
                } else if (i11 > 0 && iArr[0] == 0) {
                    this.f38638c++;
                }
                this.f38639d += (long) (i11 - iArr[0]);
                return A();
            }
            if (iCompare <= 0) {
                int i12 = this.f38637b;
                iArr[0] = i12;
                if (i11 == 0) {
                    return u();
                }
                this.f38639d += (long) (i11 - i12);
                this.f38637b = i11;
                return this;
            }
            e<E> eVar2 = this.f38642g;
            if (eVar2 == null) {
                iArr[0] = 0;
                return i11 > 0 ? q(e11, i11) : this;
            }
            this.f38642g = eVar2.K(comparator, e11, i11, iArr);
            if (i11 == 0 && iArr[0] != 0) {
                this.f38638c--;
            } else if (i11 > 0 && iArr[0] == 0) {
                this.f38638c++;
            }
            this.f38639d += (long) (i11 - iArr[0]);
            return A();
        }

        public final e<E> L() {
            e<E> eVar = this.f38644i;
            Objects.requireNonNull(eVar);
            return eVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e<E> o(Comparator<? super E> comparator, E e11, int i11, int[] iArr) {
            int iCompare = comparator.compare(e11, x());
            if (iCompare < 0) {
                e<E> eVar = this.f38641f;
                if (eVar == null) {
                    iArr[0] = 0;
                    return p(e11, i11);
                }
                int i12 = eVar.f38640e;
                e<E> eVarO = eVar.o(comparator, e11, i11, iArr);
                this.f38641f = eVarO;
                if (iArr[0] == 0) {
                    this.f38638c++;
                }
                this.f38639d += (long) i11;
                return eVarO.f38640e == i12 ? this : A();
            }
            if (iCompare <= 0) {
                int i13 = this.f38637b;
                iArr[0] = i13;
                long j11 = i11;
                com.google.common.base.m.d(((long) i13) + j11 <= 2147483647L);
                this.f38637b += i11;
                this.f38639d += j11;
                return this;
            }
            e<E> eVar2 = this.f38642g;
            if (eVar2 == null) {
                iArr[0] = 0;
                return q(e11, i11);
            }
            int i14 = eVar2.f38640e;
            e<E> eVarO2 = eVar2.o(comparator, e11, i11, iArr);
            this.f38642g = eVarO2;
            if (iArr[0] == 0) {
                this.f38638c++;
            }
            this.f38639d += (long) i11;
            return eVarO2.f38640e == i14 ? this : A();
        }

        public final e<E> p(E e11, int i11) {
            this.f38641f = new e<>(e11, i11);
            TreeMultiset.successor(z(), this.f38641f, this);
            this.f38640e = Math.max(2, this.f38640e);
            this.f38638c++;
            this.f38639d += (long) i11;
            return this;
        }

        public final e<E> q(E e11, int i11) {
            e<E> eVar = new e<>(e11, i11);
            this.f38642g = eVar;
            TreeMultiset.successor(this, eVar, L());
            this.f38640e = Math.max(2, this.f38640e);
            this.f38638c++;
            this.f38639d += (long) i11;
            return this;
        }

        public final int r() {
            return y(this.f38641f) - y(this.f38642g);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final e<E> s(Comparator<? super E> comparator, E e11) {
            int iCompare = comparator.compare(e11, x());
            if (iCompare < 0) {
                e<E> eVar = this.f38641f;
                return eVar == null ? this : (e) com.google.common.base.h.a(eVar.s(comparator, e11), this);
            }
            if (iCompare == 0) {
                return this;
            }
            e<E> eVar2 = this.f38642g;
            if (eVar2 == null) {
                return null;
            }
            return eVar2.s(comparator, e11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int t(Comparator<? super E> comparator, E e11) {
            int iCompare = comparator.compare(e11, x());
            if (iCompare < 0) {
                e<E> eVar = this.f38641f;
                if (eVar == null) {
                    return 0;
                }
                return eVar.t(comparator, e11);
            }
            if (iCompare <= 0) {
                return this.f38637b;
            }
            e<E> eVar2 = this.f38642g;
            if (eVar2 == null) {
                return 0;
            }
            return eVar2.t(comparator, e11);
        }

        public String toString() {
            return Multisets.g(x(), w()).toString();
        }

        public final e<E> u() {
            int i11 = this.f38637b;
            this.f38637b = 0;
            TreeMultiset.successor(z(), L());
            e<E> eVar = this.f38641f;
            if (eVar == null) {
                return this.f38642g;
            }
            e<E> eVar2 = this.f38642g;
            if (eVar2 == null) {
                return eVar;
            }
            if (eVar.f38640e >= eVar2.f38640e) {
                e<E> eVarZ = z();
                eVarZ.f38641f = this.f38641f.F(eVarZ);
                eVarZ.f38642g = this.f38642g;
                eVarZ.f38638c = this.f38638c - 1;
                eVarZ.f38639d = this.f38639d - ((long) i11);
                return eVarZ.A();
            }
            e<E> eVarL = L();
            eVarL.f38642g = this.f38642g.G(eVarL);
            eVarL.f38641f = this.f38641f;
            eVarL.f38638c = this.f38638c - 1;
            eVarL.f38639d = this.f38639d - ((long) i11);
            return eVarL.A();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final e<E> v(Comparator<? super E> comparator, E e11) {
            int iCompare = comparator.compare(e11, x());
            if (iCompare > 0) {
                e<E> eVar = this.f38642g;
                return eVar == null ? this : (e) com.google.common.base.h.a(eVar.v(comparator, e11), this);
            }
            if (iCompare == 0) {
                return this;
            }
            e<E> eVar2 = this.f38641f;
            if (eVar2 == null) {
                return null;
            }
            return eVar2.v(comparator, e11);
        }

        public int w() {
            return this.f38637b;
        }

        public E x() {
            return (E) k0.a(this.f38636a);
        }

        public final e<E> z() {
            e<E> eVar = this.f38643h;
            Objects.requireNonNull(eVar);
            return eVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public T f38645a;

        public f() {
        }

        public /* synthetic */ f(a aVar) {
            this();
        }

        public void a(T t11, T t12) {
            if (this.f38645a != t11) {
                throw new ConcurrentModificationException();
            }
            this.f38645a = t12;
        }

        public void b() {
            this.f38645a = null;
        }

        public T c() {
            return this.f38645a;
        }
    }

    public TreeMultiset(f<e<E>> fVar, GeneralRange<E> generalRange, e<E> eVar) {
        super(generalRange.comparator());
        this.rootReference = fVar;
        this.range = generalRange;
        this.header = eVar;
    }

    public TreeMultiset(Comparator<? super E> comparator) {
        super(comparator);
        this.range = GeneralRange.all(comparator);
        e<E> eVar = new e<>();
        this.header = eVar;
        successor(eVar, eVar);
        this.rootReference = new f<>(null);
    }

    private long aggregateAboveRange(Aggregate aggregate, e<E> eVar) {
        long jTreeAggregate;
        long jAggregateAboveRange;
        if (eVar == null) {
            return 0L;
        }
        int iCompare = comparator().compare(k0.a(this.range.getUpperEndpoint()), eVar.x());
        if (iCompare > 0) {
            return aggregateAboveRange(aggregate, eVar.f38642g);
        }
        if (iCompare == 0) {
            int i11 = d.f38635a[this.range.getUpperBoundType().ordinal()];
            if (i11 != 1) {
                if (i11 == 2) {
                    return aggregate.treeAggregate(eVar.f38642g);
                }
                throw new AssertionError();
            }
            jTreeAggregate = aggregate.nodeAggregate(eVar);
            jAggregateAboveRange = aggregate.treeAggregate(eVar.f38642g);
        } else {
            jTreeAggregate = aggregate.treeAggregate(eVar.f38642g) + ((long) aggregate.nodeAggregate(eVar));
            jAggregateAboveRange = aggregateAboveRange(aggregate, eVar.f38641f);
        }
        return jTreeAggregate + jAggregateAboveRange;
    }

    private long aggregateBelowRange(Aggregate aggregate, e<E> eVar) {
        long jTreeAggregate;
        long jAggregateBelowRange;
        if (eVar == null) {
            return 0L;
        }
        int iCompare = comparator().compare(k0.a(this.range.getLowerEndpoint()), eVar.x());
        if (iCompare < 0) {
            return aggregateBelowRange(aggregate, eVar.f38641f);
        }
        if (iCompare == 0) {
            int i11 = d.f38635a[this.range.getLowerBoundType().ordinal()];
            if (i11 != 1) {
                if (i11 == 2) {
                    return aggregate.treeAggregate(eVar.f38641f);
                }
                throw new AssertionError();
            }
            jTreeAggregate = aggregate.nodeAggregate(eVar);
            jAggregateBelowRange = aggregate.treeAggregate(eVar.f38641f);
        } else {
            jTreeAggregate = aggregate.treeAggregate(eVar.f38641f) + ((long) aggregate.nodeAggregate(eVar));
            jAggregateBelowRange = aggregateBelowRange(aggregate, eVar.f38642g);
        }
        return jTreeAggregate + jAggregateBelowRange;
    }

    private long aggregateForEntries(Aggregate aggregate) {
        e<E> eVarC = this.rootReference.c();
        long jTreeAggregate = aggregate.treeAggregate(eVarC);
        if (this.range.hasLowerBound()) {
            jTreeAggregate -= aggregateBelowRange(aggregate, eVarC);
        }
        return this.range.hasUpperBound() ? jTreeAggregate - aggregateAboveRange(aggregate, eVarC) : jTreeAggregate;
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset<>(Ordering.natural());
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> iterable) {
        TreeMultiset<E> treeMultisetCreate = create();
        e0.a(treeMultisetCreate, iterable);
        return treeMultisetCreate;
    }

    public static <E> TreeMultiset<E> create(Comparator<? super E> comparator) {
        return comparator == null ? new TreeMultiset<>(Ordering.natural()) : new TreeMultiset<>(comparator);
    }

    public static int distinctElements(e<?> eVar) {
        if (eVar == null) {
            return 0;
        }
        return eVar.f38638c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e<E> firstNode() {
        e<E> eVarL;
        e<E> eVarC = this.rootReference.c();
        if (eVarC == null) {
            return null;
        }
        if (this.range.hasLowerBound()) {
            Object objA = k0.a(this.range.getLowerEndpoint());
            eVarL = eVarC.s(comparator(), objA);
            if (eVarL == null) {
                return null;
            }
            if (this.range.getLowerBoundType() == BoundType.OPEN && comparator().compare(objA, eVarL.x()) == 0) {
                eVarL = eVarL.L();
            }
        } else {
            eVarL = this.header.L();
        }
        if (eVarL == this.header || !this.range.contains(eVarL.x())) {
            return null;
        }
        return eVarL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e<E> lastNode() {
        e<E> eVarZ;
        e<E> eVarC = this.rootReference.c();
        if (eVarC == null) {
            return null;
        }
        if (this.range.hasUpperBound()) {
            Object objA = k0.a(this.range.getUpperEndpoint());
            eVarZ = eVarC.v(comparator(), objA);
            if (eVarZ == null) {
                return null;
            }
            if (this.range.getUpperBoundType() == BoundType.OPEN && comparator().compare(objA, eVarZ.x()) == 0) {
                eVarZ = eVarZ.z();
            }
        } else {
            eVarZ = this.header.z();
        }
        if (eVarZ == this.header || !this.range.contains(eVarZ.x())) {
            return null;
        }
        return eVarZ;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        Object object = objectInputStream.readObject();
        Objects.requireNonNull(object);
        Comparator comparator = (Comparator) object;
        u0.a(h.class, "comparator").b(this, comparator);
        u0.a(TreeMultiset.class, "range").b(this, GeneralRange.all(comparator));
        u0.a(TreeMultiset.class, "rootReference").b(this, new f(null));
        e eVar = new e();
        u0.a(TreeMultiset.class, "header").b(this, eVar);
        successor(eVar, eVar);
        u0.f(this, objectInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void successor(e<T> eVar, e<T> eVar2) {
        eVar.f38644i = eVar2;
        eVar2.f38643h = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void successor(e<T> eVar, e<T> eVar2, e<T> eVar3) {
        successor(eVar, eVar2);
        successor(eVar2, eVar3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public j0.a<E> wrapEntry(e<E> eVar) {
        return new a(eVar);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(elementSet().comparator());
        u0.k(this, objectOutputStream);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.j0
    public int add(E e11, int i11) {
        l.b(i11, "occurrences");
        if (i11 == 0) {
            return count(e11);
        }
        com.google.common.base.m.d(this.range.contains(e11));
        e<E> eVarC = this.rootReference.c();
        if (eVarC != null) {
            int[] iArr = new int[1];
            this.rootReference.a(eVarC, eVarC.o(comparator(), e11, i11, iArr));
            return iArr[0];
        }
        comparator().compare(e11, e11);
        e<E> eVar = new e<>(e11, i11);
        e<E> eVar2 = this.header;
        successor(eVar2, eVar, eVar2);
        this.rootReference.a(eVarC, eVar);
        return 0;
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        if (this.range.hasLowerBound() || this.range.hasUpperBound()) {
            Iterators.e(entryIterator());
            return;
        }
        e<E> eVarL = this.header.L();
        while (true) {
            e<E> eVar = this.header;
            if (eVarL == eVar) {
                successor(eVar, eVar);
                this.rootReference.b();
                return;
            }
            e<E> eVarL2 = eVarL.L();
            eVarL.f38637b = 0;
            eVarL.f38641f = null;
            eVarL.f38642g = null;
            eVarL.f38643h = null;
            eVarL.f38644i = null;
            eVarL = eVarL2;
        }
    }

    @Override // com.google.common.collect.h, com.google.common.collect.z0, com.google.common.collect.x0
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j0
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.j0
    public int count(Object obj) {
        try {
            e<E> eVarC = this.rootReference.c();
            if (this.range.contains(obj) && eVarC != null) {
                return eVarC.t(comparator(), obj);
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.h
    public Iterator<j0.a<E>> descendingEntryIterator() {
        return new c();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.z0
    public /* bridge */ /* synthetic */ z0 descendingMultiset() {
        return super.descendingMultiset();
    }

    @Override // com.google.common.collect.d
    public int distinctElements() {
        return Ints.l(aggregateForEntries(Aggregate.DISTINCT));
    }

    @Override // com.google.common.collect.d
    public Iterator<E> elementIterator() {
        return Multisets.e(entryIterator());
    }

    @Override // com.google.common.collect.h, com.google.common.collect.d, com.google.common.collect.j0
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.d
    public Iterator<j0.a<E>> entryIterator() {
        return new b();
    }

    @Override // com.google.common.collect.d, com.google.common.collect.j0
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.z0
    public /* bridge */ /* synthetic */ j0.a firstEntry() {
        return super.firstEntry();
    }

    @Override // com.google.common.collect.z0
    public z0<E> headMultiset(E e11, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.upTo(comparator(), e11, boundType)), this.header);
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return Multisets.i(this);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.z0
    public /* bridge */ /* synthetic */ j0.a lastEntry() {
        return super.lastEntry();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.z0
    public /* bridge */ /* synthetic */ j0.a pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.z0
    public /* bridge */ /* synthetic */ j0.a pollLastEntry() {
        return super.pollLastEntry();
    }

    @Override // com.google.common.collect.d, com.google.common.collect.j0
    public int remove(Object obj, int i11) {
        l.b(i11, "occurrences");
        if (i11 == 0) {
            return count(obj);
        }
        e<E> eVarC = this.rootReference.c();
        int[] iArr = new int[1];
        try {
            if (this.range.contains(obj) && eVarC != null) {
                this.rootReference.a(eVarC, eVarC.E(comparator(), obj, i11, iArr));
                return iArr[0];
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.d, com.google.common.collect.j0
    public int setCount(E e11, int i11) {
        l.b(i11, "count");
        if (!this.range.contains(e11)) {
            com.google.common.base.m.d(i11 == 0);
            return 0;
        }
        e<E> eVarC = this.rootReference.c();
        if (eVarC == null) {
            if (i11 > 0) {
                add(e11, i11);
            }
            return 0;
        }
        int[] iArr = new int[1];
        this.rootReference.a(eVarC, eVarC.K(comparator(), e11, i11, iArr));
        return iArr[0];
    }

    @Override // com.google.common.collect.d, com.google.common.collect.j0
    public boolean setCount(E e11, int i11, int i12) {
        l.b(i12, "newCount");
        l.b(i11, "oldCount");
        com.google.common.base.m.d(this.range.contains(e11));
        e<E> eVarC = this.rootReference.c();
        if (eVarC != null) {
            int[] iArr = new int[1];
            this.rootReference.a(eVarC, eVarC.J(comparator(), e11, i11, i12, iArr));
            return iArr[0] == i11;
        }
        if (i11 != 0) {
            return false;
        }
        if (i12 > 0) {
            add(e11, i12);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j0
    public int size() {
        return Ints.l(aggregateForEntries(Aggregate.SIZE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.h, com.google.common.collect.z0
    public /* bridge */ /* synthetic */ z0 subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return super.subMultiset(obj, boundType, obj2, boundType2);
    }

    @Override // com.google.common.collect.z0
    public z0<E> tailMultiset(E e11, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.downTo(comparator(), e11, boundType)), this.header);
    }
}
