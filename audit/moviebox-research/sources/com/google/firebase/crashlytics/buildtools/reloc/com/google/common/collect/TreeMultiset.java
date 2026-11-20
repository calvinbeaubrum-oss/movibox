package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class TreeMultiset<E> extends x<E> implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient e<E> header;
    private final transient GeneralRange<E> range;
    private final transient f<e<E>> rootReference;

    /* JADX INFO: compiled from: source.java */
    public enum Aggregate {
        SIZE { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.TreeMultiset.Aggregate.1
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.TreeMultiset.Aggregate
            public int nodeAggregate(e<?> eVar) {
                return eVar.f39629b;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.TreeMultiset.Aggregate
            public long treeAggregate(e<?> eVar) {
                if (eVar == null) {
                    return 0L;
                }
                return eVar.f39631d;
            }
        },
        DISTINCT { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.TreeMultiset.Aggregate.2
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.TreeMultiset.Aggregate
            public int nodeAggregate(e<?> eVar) {
                return 1;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.TreeMultiset.Aggregate
            public long treeAggregate(e<?> eVar) {
                if (eVar == null) {
                    return 0L;
                }
                return eVar.f39630c;
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
        public final /* synthetic */ e f39619a;

        public a(e eVar) {
            this.f39619a = eVar;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6.a
        public int getCount() {
            int iX = this.f39619a.x();
            return iX == 0 ? TreeMultiset.this.count(getElement()) : iX;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6.a
        public E getElement() {
            return (E) this.f39619a.y();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Iterator<l6.a<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e<E> f39621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public l6.a<E> f39622b;

        public b() {
            this.f39621a = TreeMultiset.this.firstNode();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public l6.a<E> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            l6.a<E> aVarWrapEntry = TreeMultiset.this.wrapEntry(this.f39621a);
            this.f39622b = aVarWrapEntry;
            if (this.f39621a.f39636i == TreeMultiset.this.header) {
                this.f39621a = null;
            } else {
                this.f39621a = this.f39621a.f39636i;
            }
            return aVarWrapEntry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f39621a == null) {
                return false;
            }
            if (!TreeMultiset.this.range.tooHigh(this.f39621a.y())) {
                return true;
            }
            this.f39621a = null;
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            n1.e(this.f39622b != null);
            TreeMultiset.this.setCount(this.f39622b.getElement(), 0);
            this.f39622b = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Iterator<l6.a<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e<E> f39624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public l6.a<E> f39625b = null;

        public c() {
            this.f39624a = TreeMultiset.this.lastNode();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public l6.a<E> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            l6.a<E> aVarWrapEntry = TreeMultiset.this.wrapEntry(this.f39624a);
            this.f39625b = aVarWrapEntry;
            if (this.f39624a.f39635h == TreeMultiset.this.header) {
                this.f39624a = null;
            } else {
                this.f39624a = this.f39624a.f39635h;
            }
            return aVarWrapEntry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f39624a == null) {
                return false;
            }
            if (!TreeMultiset.this.range.tooLow(this.f39624a.y())) {
                return true;
            }
            this.f39624a = null;
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            n1.e(this.f39625b != null);
            TreeMultiset.this.setCount(this.f39625b.getElement(), 0);
            this.f39625b = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f39627a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f39627a = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f39627a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final E f39628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f39629b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f39630c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f39631d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f39632e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public e<E> f39633f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public e<E> f39634g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public e<E> f39635h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public e<E> f39636i;

        public e(E e11, int i11) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(i11 > 0);
            this.f39628a = e11;
            this.f39629b = i11;
            this.f39631d = i11;
            this.f39630c = 1;
            this.f39632e = 1;
            this.f39633f = null;
            this.f39634g = null;
        }

        public static long L(e<?> eVar) {
            if (eVar == null) {
                return 0L;
            }
            return eVar.f39631d;
        }

        public static int z(e<?> eVar) {
            if (eVar == null) {
                return 0;
            }
            return eVar.f39632e;
        }

        public final e<E> A() {
            int iS = s();
            if (iS == -2) {
                if (this.f39634g.s() > 0) {
                    this.f39634g = this.f39634g.I();
                }
                return H();
            }
            if (iS != 2) {
                C();
                return this;
            }
            if (this.f39633f.s() < 0) {
                this.f39633f = this.f39633f.H();
            }
            return I();
        }

        public final void B() {
            D();
            C();
        }

        public final void C() {
            this.f39632e = Math.max(z(this.f39633f), z(this.f39634g)) + 1;
        }

        public final void D() {
            this.f39630c = TreeMultiset.distinctElements(this.f39633f) + 1 + TreeMultiset.distinctElements(this.f39634g);
            this.f39631d = ((long) this.f39629b) + L(this.f39633f) + L(this.f39634g);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e<E> E(Comparator<? super E> comparator, E e11, int i11, int[] iArr) {
            int iCompare = comparator.compare(e11, this.f39628a);
            if (iCompare < 0) {
                e<E> eVar = this.f39633f;
                if (eVar == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f39633f = eVar.E(comparator, e11, i11, iArr);
                int i12 = iArr[0];
                if (i12 > 0) {
                    if (i11 >= i12) {
                        this.f39630c--;
                        this.f39631d -= (long) i12;
                    } else {
                        this.f39631d -= (long) i11;
                    }
                }
                return i12 == 0 ? this : A();
            }
            if (iCompare <= 0) {
                int i13 = this.f39629b;
                iArr[0] = i13;
                if (i11 >= i13) {
                    return v();
                }
                this.f39629b = i13 - i11;
                this.f39631d -= (long) i11;
                return this;
            }
            e<E> eVar2 = this.f39634g;
            if (eVar2 == null) {
                iArr[0] = 0;
                return this;
            }
            this.f39634g = eVar2.E(comparator, e11, i11, iArr);
            int i14 = iArr[0];
            if (i14 > 0) {
                if (i11 >= i14) {
                    this.f39630c--;
                    this.f39631d -= (long) i14;
                } else {
                    this.f39631d -= (long) i11;
                }
            }
            return A();
        }

        public final e<E> F(e<E> eVar) {
            e<E> eVar2 = this.f39634g;
            if (eVar2 == null) {
                return this.f39633f;
            }
            this.f39634g = eVar2.F(eVar);
            this.f39630c--;
            this.f39631d -= (long) eVar.f39629b;
            return A();
        }

        public final e<E> G(e<E> eVar) {
            e<E> eVar2 = this.f39633f;
            if (eVar2 == null) {
                return this.f39634g;
            }
            this.f39633f = eVar2.G(eVar);
            this.f39630c--;
            this.f39631d -= (long) eVar.f39629b;
            return A();
        }

        public final e<E> H() {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.t(this.f39634g != null);
            e<E> eVar = this.f39634g;
            this.f39634g = eVar.f39633f;
            eVar.f39633f = this;
            eVar.f39631d = this.f39631d;
            eVar.f39630c = this.f39630c;
            B();
            eVar.C();
            return eVar;
        }

        public final e<E> I() {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.t(this.f39633f != null);
            e<E> eVar = this.f39633f;
            this.f39633f = eVar.f39634g;
            eVar.f39634g = this;
            eVar.f39631d = this.f39631d;
            eVar.f39630c = this.f39630c;
            B();
            eVar.C();
            return eVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e<E> J(Comparator<? super E> comparator, E e11, int i11, int i12, int[] iArr) {
            int iCompare = comparator.compare(e11, this.f39628a);
            if (iCompare < 0) {
                e<E> eVar = this.f39633f;
                if (eVar == null) {
                    iArr[0] = 0;
                    return (i11 != 0 || i12 <= 0) ? this : q(e11, i12);
                }
                this.f39633f = eVar.J(comparator, e11, i11, i12, iArr);
                int i13 = iArr[0];
                if (i13 == i11) {
                    if (i12 == 0 && i13 != 0) {
                        this.f39630c--;
                    } else if (i12 > 0 && i13 == 0) {
                        this.f39630c++;
                    }
                    this.f39631d += (long) (i12 - i13);
                }
                return A();
            }
            if (iCompare <= 0) {
                int i14 = this.f39629b;
                iArr[0] = i14;
                if (i11 == i14) {
                    if (i12 == 0) {
                        return v();
                    }
                    this.f39631d += (long) (i12 - i14);
                    this.f39629b = i12;
                }
                return this;
            }
            e<E> eVar2 = this.f39634g;
            if (eVar2 == null) {
                iArr[0] = 0;
                return (i11 != 0 || i12 <= 0) ? this : r(e11, i12);
            }
            this.f39634g = eVar2.J(comparator, e11, i11, i12, iArr);
            int i15 = iArr[0];
            if (i15 == i11) {
                if (i12 == 0 && i15 != 0) {
                    this.f39630c--;
                } else if (i12 > 0 && i15 == 0) {
                    this.f39630c++;
                }
                this.f39631d += (long) (i12 - i15);
            }
            return A();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e<E> K(Comparator<? super E> comparator, E e11, int i11, int[] iArr) {
            int iCompare = comparator.compare(e11, this.f39628a);
            if (iCompare < 0) {
                e<E> eVar = this.f39633f;
                if (eVar == null) {
                    iArr[0] = 0;
                    return i11 > 0 ? q(e11, i11) : this;
                }
                this.f39633f = eVar.K(comparator, e11, i11, iArr);
                if (i11 == 0 && iArr[0] != 0) {
                    this.f39630c--;
                } else if (i11 > 0 && iArr[0] == 0) {
                    this.f39630c++;
                }
                this.f39631d += (long) (i11 - iArr[0]);
                return A();
            }
            if (iCompare <= 0) {
                int i12 = this.f39629b;
                iArr[0] = i12;
                if (i11 == 0) {
                    return v();
                }
                this.f39631d += (long) (i11 - i12);
                this.f39629b = i11;
                return this;
            }
            e<E> eVar2 = this.f39634g;
            if (eVar2 == null) {
                iArr[0] = 0;
                return i11 > 0 ? r(e11, i11) : this;
            }
            this.f39634g = eVar2.K(comparator, e11, i11, iArr);
            if (i11 == 0 && iArr[0] != 0) {
                this.f39630c--;
            } else if (i11 > 0 && iArr[0] == 0) {
                this.f39630c++;
            }
            this.f39631d += (long) (i11 - iArr[0]);
            return A();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e<E> p(Comparator<? super E> comparator, E e11, int i11, int[] iArr) {
            int iCompare = comparator.compare(e11, this.f39628a);
            if (iCompare < 0) {
                e<E> eVar = this.f39633f;
                if (eVar == null) {
                    iArr[0] = 0;
                    return q(e11, i11);
                }
                int i12 = eVar.f39632e;
                e<E> eVarP = eVar.p(comparator, e11, i11, iArr);
                this.f39633f = eVarP;
                if (iArr[0] == 0) {
                    this.f39630c++;
                }
                this.f39631d += (long) i11;
                return eVarP.f39632e == i12 ? this : A();
            }
            if (iCompare <= 0) {
                int i13 = this.f39629b;
                iArr[0] = i13;
                long j11 = i11;
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(((long) i13) + j11 <= 2147483647L);
                this.f39629b += i11;
                this.f39631d += j11;
                return this;
            }
            e<E> eVar2 = this.f39634g;
            if (eVar2 == null) {
                iArr[0] = 0;
                return r(e11, i11);
            }
            int i14 = eVar2.f39632e;
            e<E> eVarP2 = eVar2.p(comparator, e11, i11, iArr);
            this.f39634g = eVarP2;
            if (iArr[0] == 0) {
                this.f39630c++;
            }
            this.f39631d += (long) i11;
            return eVarP2.f39632e == i14 ? this : A();
        }

        public final e<E> q(E e11, int i11) {
            e<E> eVar = new e<>(e11, i11);
            this.f39633f = eVar;
            TreeMultiset.successor(this.f39635h, eVar, this);
            this.f39632e = Math.max(2, this.f39632e);
            this.f39630c++;
            this.f39631d += (long) i11;
            return this;
        }

        public final e<E> r(E e11, int i11) {
            e<E> eVar = new e<>(e11, i11);
            this.f39634g = eVar;
            TreeMultiset.successor(this, eVar, this.f39636i);
            this.f39632e = Math.max(2, this.f39632e);
            this.f39630c++;
            this.f39631d += (long) i11;
            return this;
        }

        public final int s() {
            return z(this.f39633f) - z(this.f39634g);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final e<E> t(Comparator<? super E> comparator, E e11) {
            int iCompare = comparator.compare(e11, this.f39628a);
            if (iCompare < 0) {
                e<E> eVar = this.f39633f;
                return eVar == null ? this : (e) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.f.a(eVar.t(comparator, e11), this);
            }
            if (iCompare == 0) {
                return this;
            }
            e<E> eVar2 = this.f39634g;
            if (eVar2 == null) {
                return null;
            }
            return eVar2.t(comparator, e11);
        }

        public String toString() {
            return Multisets.g(y(), x()).toString();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int u(Comparator<? super E> comparator, E e11) {
            int iCompare = comparator.compare(e11, this.f39628a);
            if (iCompare < 0) {
                e<E> eVar = this.f39633f;
                if (eVar == null) {
                    return 0;
                }
                return eVar.u(comparator, e11);
            }
            if (iCompare <= 0) {
                return this.f39629b;
            }
            e<E> eVar2 = this.f39634g;
            if (eVar2 == null) {
                return 0;
            }
            return eVar2.u(comparator, e11);
        }

        public final e<E> v() {
            int i11 = this.f39629b;
            this.f39629b = 0;
            TreeMultiset.successor(this.f39635h, this.f39636i);
            e<E> eVar = this.f39633f;
            if (eVar == null) {
                return this.f39634g;
            }
            e<E> eVar2 = this.f39634g;
            if (eVar2 == null) {
                return eVar;
            }
            if (eVar.f39632e >= eVar2.f39632e) {
                e<E> eVar3 = this.f39635h;
                eVar3.f39633f = eVar.F(eVar3);
                eVar3.f39634g = this.f39634g;
                eVar3.f39630c = this.f39630c - 1;
                eVar3.f39631d = this.f39631d - ((long) i11);
                return eVar3.A();
            }
            e<E> eVar4 = this.f39636i;
            eVar4.f39634g = eVar2.G(eVar4);
            eVar4.f39633f = this.f39633f;
            eVar4.f39630c = this.f39630c - 1;
            eVar4.f39631d = this.f39631d - ((long) i11);
            return eVar4.A();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final e<E> w(Comparator<? super E> comparator, E e11) {
            int iCompare = comparator.compare(e11, this.f39628a);
            if (iCompare > 0) {
                e<E> eVar = this.f39634g;
                return eVar == null ? this : (e) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.f.a(eVar.w(comparator, e11), this);
            }
            if (iCompare == 0) {
                return this;
            }
            e<E> eVar2 = this.f39633f;
            if (eVar2 == null) {
                return null;
            }
            return eVar2.w(comparator, e11);
        }

        public int x() {
            return this.f39629b;
        }

        public E y() {
            return this.f39628a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public T f39637a;

        public f() {
        }

        public /* synthetic */ f(a aVar) {
            this();
        }

        public void a(T t11, T t12) {
            if (this.f39637a != t11) {
                throw new ConcurrentModificationException();
            }
            this.f39637a = t12;
        }

        public void b() {
            this.f39637a = null;
        }

        public T c() {
            return this.f39637a;
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
        e<E> eVar = new e<>(null, 1);
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
        int iCompare = comparator().compare(this.range.getUpperEndpoint(), eVar.f39628a);
        if (iCompare > 0) {
            return aggregateAboveRange(aggregate, eVar.f39634g);
        }
        if (iCompare == 0) {
            int i11 = d.f39627a[this.range.getUpperBoundType().ordinal()];
            if (i11 != 1) {
                if (i11 == 2) {
                    return aggregate.treeAggregate(eVar.f39634g);
                }
                throw new AssertionError();
            }
            jTreeAggregate = aggregate.nodeAggregate(eVar);
            jAggregateAboveRange = aggregate.treeAggregate(eVar.f39634g);
        } else {
            jTreeAggregate = aggregate.treeAggregate(eVar.f39634g) + ((long) aggregate.nodeAggregate(eVar));
            jAggregateAboveRange = aggregateAboveRange(aggregate, eVar.f39633f);
        }
        return jTreeAggregate + jAggregateAboveRange;
    }

    private long aggregateBelowRange(Aggregate aggregate, e<E> eVar) {
        long jTreeAggregate;
        long jAggregateBelowRange;
        if (eVar == null) {
            return 0L;
        }
        int iCompare = comparator().compare(this.range.getLowerEndpoint(), eVar.f39628a);
        if (iCompare < 0) {
            return aggregateBelowRange(aggregate, eVar.f39633f);
        }
        if (iCompare == 0) {
            int i11 = d.f39627a[this.range.getLowerBoundType().ordinal()];
            if (i11 != 1) {
                if (i11 == 2) {
                    return aggregate.treeAggregate(eVar.f39633f);
                }
                throw new AssertionError();
            }
            jTreeAggregate = aggregate.nodeAggregate(eVar);
            jAggregateBelowRange = aggregate.treeAggregate(eVar.f39633f);
        } else {
            jTreeAggregate = aggregate.treeAggregate(eVar.f39633f) + ((long) aggregate.nodeAggregate(eVar));
            jAggregateBelowRange = aggregateBelowRange(aggregate, eVar.f39634g);
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
        j5.a(treeMultisetCreate, iterable);
        return treeMultisetCreate;
    }

    public static <E> TreeMultiset<E> create(Comparator<? super E> comparator) {
        return comparator == null ? new TreeMultiset<>(Ordering.natural()) : new TreeMultiset<>(comparator);
    }

    public static int distinctElements(e<?> eVar) {
        if (eVar == null) {
            return 0;
        }
        return eVar.f39630c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e<E> firstNode() {
        e<E> eVarT;
        if (this.rootReference.c() == null) {
            return null;
        }
        if (this.range.hasLowerBound()) {
            E lowerEndpoint = this.range.getLowerEndpoint();
            eVarT = this.rootReference.c().t(comparator(), lowerEndpoint);
            if (eVarT == null) {
                return null;
            }
            if (this.range.getLowerBoundType() == BoundType.OPEN && comparator().compare(lowerEndpoint, eVarT.y()) == 0) {
                eVarT = eVarT.f39636i;
            }
        } else {
            eVarT = this.header.f39636i;
        }
        if (eVarT == this.header || !this.range.contains(eVarT.y())) {
            return null;
        }
        return eVarT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e<E> lastNode() {
        e<E> eVarW;
        if (this.rootReference.c() == null) {
            return null;
        }
        if (this.range.hasUpperBound()) {
            E upperEndpoint = this.range.getUpperEndpoint();
            eVarW = this.rootReference.c().w(comparator(), upperEndpoint);
            if (eVarW == null) {
                return null;
            }
            if (this.range.getUpperBoundType() == BoundType.OPEN && comparator().compare(upperEndpoint, eVarW.y()) == 0) {
                eVarW = eVarW.f39635h;
            }
        } else {
            eVarW = this.header.f39635h;
        }
        if (eVarW == this.header || !this.range.contains(eVarW.y())) {
            return null;
        }
        return eVarW;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        y6.a(x.class, "comparator").b(this, comparator);
        y6.a(TreeMultiset.class, "range").b(this, GeneralRange.all(comparator));
        y6.a(TreeMultiset.class, "rootReference").b(this, new f(null));
        e eVar = new e(null, 1);
        y6.a(TreeMultiset.class, "header").b(this, eVar);
        successor(eVar, eVar);
        y6.f(this, objectInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void successor(e<T> eVar, e<T> eVar2) {
        eVar.f39636i = eVar2;
        eVar2.f39635h = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void successor(e<T> eVar, e<T> eVar2, e<T> eVar3) {
        successor(eVar, eVar2);
        successor(eVar2, eVar3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l6.a<E> wrapEntry(e<E> eVar) {
        return new a(eVar);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(elementSet().comparator());
        y6.k(this, objectOutputStream);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int add(E e11, int i11) {
        n1.b(i11, "occurrences");
        if (i11 == 0) {
            return count(e11);
        }
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(this.range.contains(e11));
        e<E> eVarC = this.rootReference.c();
        if (eVarC != null) {
            int[] iArr = new int[1];
            this.rootReference.a(eVarC, eVarC.p(comparator(), e11, i11, iArr));
            return iArr[0];
        }
        comparator().compare(e11, e11);
        e<E> eVar = new e<>(e11, i11);
        e<E> eVar2 = this.header;
        successor(eVar2, eVar, eVar2);
        this.rootReference.a(eVarC, eVar);
        return 0;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        if (this.range.hasLowerBound() || this.range.hasUpperBound()) {
            Iterators.d(entryIterator());
            return;
        }
        e<E> eVar = this.header.f39636i;
        while (true) {
            e<E> eVar2 = this.header;
            if (eVar == eVar2) {
                successor(eVar2, eVar2);
                this.rootReference.b();
                return;
            }
            e<E> eVar3 = eVar.f39636i;
            eVar.f39629b = 0;
            eVar.f39633f = null;
            eVar.f39634g = null;
            eVar.f39635h = null;
            eVar.f39636i = null;
            eVar = eVar3;
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.x, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.e7
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, java.util.AbstractCollection, java.util.Collection, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int count(Object obj) {
        try {
            e<E> eVarC = this.rootReference.c();
            if (this.range.contains(obj) && eVarC != null) {
                return eVarC.u(comparator(), obj);
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.x
    public Iterator<l6.a<E>> descendingEntryIterator() {
        return new c();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.x, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7
    public /* bridge */ /* synthetic */ g7 descendingMultiset() {
        return super.descendingMultiset();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t
    public int distinctElements() {
        return Ints.i(aggregateForEntries(Aggregate.DISTINCT));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t
    public Iterator<E> elementIterator() {
        return Multisets.e(entryIterator());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.x, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t
    public Iterator<l6.a<E>> entryIterator() {
        return new b();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.x, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7
    public /* bridge */ /* synthetic */ l6.a firstEntry() {
        return super.firstEntry();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, java.lang.Iterable
    public /* bridge */ /* synthetic */ void forEach(Consumer consumer) {
        k6.a(this, consumer);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public void forEachEntry(ObjIntConsumer<? super E> objIntConsumer) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(objIntConsumer);
        for (e<E> eVarFirstNode = firstNode(); eVarFirstNode != this.header && eVarFirstNode != null && !this.range.tooHigh(eVarFirstNode.y()); eVarFirstNode = eVarFirstNode.f39636i) {
            objIntConsumer.accept(eVarFirstNode.y(), eVarFirstNode.x());
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7
    public g7<E> headMultiset(E e11, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.upTo(comparator(), e11, boundType)), this.header);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return Multisets.i(this);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.x, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7
    public /* bridge */ /* synthetic */ l6.a lastEntry() {
        return super.lastEntry();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.x, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7
    public /* bridge */ /* synthetic */ l6.a pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.x, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7
    public /* bridge */ /* synthetic */ l6.a pollLastEntry() {
        return super.pollLastEntry();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int remove(Object obj, int i11) {
        n1.b(i11, "occurrences");
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

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int setCount(E e11, int i11) {
        n1.b(i11, "count");
        if (!this.range.contains(e11)) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(i11 == 0);
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

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public boolean setCount(E e11, int i11, int i12) {
        n1.b(i12, "newCount");
        n1.b(i11, "oldCount");
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(this.range.contains(e11));
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

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int size() {
        return Ints.i(aggregateForEntries(Aggregate.SIZE));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return k6.c(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.x, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7
    public /* bridge */ /* synthetic */ g7 subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return super.subMultiset(obj, boundType, obj2, boundType2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7
    public g7<E> tailMultiset(E e11, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.downTo(comparator(), e11, boundType)), this.header);
    }
}
