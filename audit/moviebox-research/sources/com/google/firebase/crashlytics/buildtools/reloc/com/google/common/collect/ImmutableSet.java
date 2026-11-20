package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.Serializable;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.stream.Collector;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    private static final int CUTOFF = 751619276;
    private static final double DESIRED_LOAD_FACTOR = 0.7d;
    static final double HASH_FLOODING_FPP = 0.001d;
    static final int MAX_RUN_MULTIPLIER = 12;
    static final int MAX_TABLE_SIZE = 1073741824;
    static final int SPLITERATOR_CHARACTERISTICS = 1297;
    private transient ImmutableList<E> asList;

    /* JADX INFO: compiled from: source.java */
    public static abstract class Indexed<E> extends ImmutableSet<E> {
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] objArr, int i11) {
            return asList().copyIntoArray(objArr, i11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet
        public ImmutableList<E> createAsList() {
            return new ImmutableAsList<E>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet.Indexed.1
                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableAsList
                public Indexed<E> delegateCollection() {
                    return Indexed.this;
                }

                @Override // java.util.List
                public E get(int i11) {
                    return (E) Indexed.this.get(i11);
                }
            };
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super E> consumer) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(consumer);
            int size = size();
            for (int i11 = 0; i11 < size; i11++) {
                consumer.accept(get(i11));
            }
        }

        public abstract E get(int i11);

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public t7<E> iterator() {
            return asList().iterator();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
        public Spliterator<E> spliterator() {
            return x1.c(size(), ImmutableSet.SPLITERATOR_CHARACTERISTICS, new IntFunction() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.f4
                @Override // java.util.function.IntFunction
                public final Object apply(int i11) {
                    return this.f39686a.get(i11);
                }
            });
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        public SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        public Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class a<E> extends ImmutableCollection.a<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d<E> f39376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f39377b;

        public a() {
            this(4);
        }

        public a(int i11) {
            this.f39376a = new c(i11);
        }

        public a(boolean z11) {
            this.f39376a = null;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public a<E> a(E e11) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(e11);
            j();
            this.f39376a = this.f39376a.a(e11);
            return this;
        }

        public a<E> f(Iterator<? extends E> it) {
            super.c(it);
            return this;
        }

        public ImmutableSet<E> g() {
            this.f39377b = true;
            d<E> dVarG = this.f39376a.g();
            this.f39376a = dVarG;
            return dVarG.c();
        }

        public a<E> h(a<E> aVar) {
            j();
            this.f39376a = this.f39376a.d(aVar.f39376a);
            return this;
        }

        public void i() {
            this.f39376a = this.f39376a.e();
        }

        public final void j() {
            if (this.f39377b) {
                i();
                this.f39377b = false;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b<E> extends d<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set<Object> f39378c;

        public b(d<E> dVar) {
            super(dVar);
            this.f39378c = Sets.e(this.f39384b);
            for (int i11 = 0; i11 < this.f39384b; i11++) {
                this.f39378c.add(this.f39383a[i11]);
            }
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet.d
        public d<E> a(E e11) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(e11);
            if (this.f39378c.add(e11)) {
                b(e11);
            }
            return this;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet.d
        public ImmutableSet<E> c() {
            int i11 = this.f39384b;
            if (i11 != 0) {
                return i11 != 1 ? new JdkBackedImmutableSet(this.f39378c, ImmutableList.asImmutableList(this.f39383a, this.f39384b)) : ImmutableSet.of((Object) this.f39383a[0]);
            }
            return ImmutableSet.of();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet.d
        public d<E> e() {
            return new b(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c<E> extends d<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object[] f39379c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f39380d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f39381e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f39382f;

        public c(int i11) {
            super(i11);
            int iChooseTableSize = ImmutableSet.chooseTableSize(i11);
            this.f39379c = new Object[iChooseTableSize];
            this.f39380d = ImmutableSet.maxRunBeforeFallback(iChooseTableSize);
            this.f39381e = (int) (((double) iChooseTableSize) * ImmutableSet.DESIRED_LOAD_FACTOR);
        }

        public c(c<E> cVar) {
            super(cVar);
            Object[] objArr = cVar.f39379c;
            this.f39379c = Arrays.copyOf(objArr, objArr.length);
            this.f39380d = cVar.f39380d;
            this.f39381e = cVar.f39381e;
            this.f39382f = cVar.f39382f;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet.d
        public d<E> a(E e11) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(e11);
            int iHashCode = e11.hashCode();
            int iC = y2.c(iHashCode);
            int length = this.f39379c.length - 1;
            for (int i11 = iC; i11 - iC < this.f39380d; i11++) {
                int i12 = i11 & length;
                Object obj = this.f39379c[i12];
                if (obj == null) {
                    b(e11);
                    this.f39379c[i12] = e11;
                    this.f39382f += iHashCode;
                    h(this.f39384b);
                    return this;
                }
                if (obj.equals(e11)) {
                    return this;
                }
            }
            return new b(this).a(e11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet.d
        public ImmutableSet<E> c() {
            int i11 = this.f39384b;
            if (i11 == 0) {
                return ImmutableSet.of();
            }
            if (i11 == 1) {
                return ImmutableSet.of((Object) this.f39383a[0]);
            }
            Object[] objArrCopyOf = this.f39383a;
            if (i11 != objArrCopyOf.length) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i11);
            }
            int i12 = this.f39382f;
            Object[] objArr = this.f39379c;
            return new RegularImmutableSet(objArrCopyOf, i12, objArr, objArr.length - 1);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet.d
        public d<E> e() {
            return new c(this);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet.d
        public d<E> g() {
            int iChooseTableSize = ImmutableSet.chooseTableSize(this.f39384b);
            if (iChooseTableSize * 2 < this.f39379c.length) {
                this.f39379c = ImmutableSet.rebuildHashTable(iChooseTableSize, this.f39383a, this.f39384b);
            }
            return ImmutableSet.hashFloodingDetected(this.f39379c) ? new b(this) : this;
        }

        public void h(int i11) {
            if (i11 > this.f39381e) {
                Object[] objArr = this.f39379c;
                if (objArr.length < 1073741824) {
                    int length = objArr.length * 2;
                    this.f39379c = ImmutableSet.rebuildHashTable(length, this.f39383a, this.f39384b);
                    this.f39380d = ImmutableSet.maxRunBeforeFallback(length);
                    this.f39381e = (int) (((double) length) * ImmutableSet.DESIRED_LOAD_FACTOR);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class d<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public E[] f39383a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f39384b;

        public d(int i11) {
            this.f39383a = (E[]) new Object[i11];
            this.f39384b = 0;
        }

        public d(d<E> dVar) {
            E[] eArr = dVar.f39383a;
            this.f39383a = (E[]) Arrays.copyOf(eArr, eArr.length);
            this.f39384b = dVar.f39384b;
        }

        public abstract d<E> a(E e11);

        public final void b(E e11) {
            f(this.f39384b + 1);
            E[] eArr = this.f39383a;
            int i11 = this.f39384b;
            this.f39384b = i11 + 1;
            eArr[i11] = e11;
        }

        public abstract ImmutableSet<E> c();

        public final d<E> d(d<E> dVar) {
            d<E> dVarA = this;
            for (int i11 = 0; i11 < dVar.f39384b; i11++) {
                dVarA = dVarA.a(dVar.f39383a[i11]);
            }
            return dVarA;
        }

        public abstract d<E> e();

        public final void f(int i11) {
            E[] eArr = this.f39383a;
            if (i11 > eArr.length) {
                this.f39383a = (E[]) Arrays.copyOf(this.f39383a, ImmutableCollection.a.d(eArr.length, i11));
            }
        }

        public d<E> g() {
            return this;
        }
    }

    public static <E> a<E> builder() {
        return new a<>();
    }

    public static <E> a<E> builderWithExpectedSize(int i11) {
        n1.b(i11, "expectedSize");
        return new a<>(i11);
    }

    public static int chooseTableSize(int i11) {
        int iMax = Math.max(i11, 2);
        if (iMax >= CUTOFF) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.e(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (((double) iHighestOneBit) * DESIRED_LOAD_FACTOR < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet$d] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    private static <E> ImmutableSet<E> construct(int i11, Object... objArr) {
        ?? r11;
        if (i11 == 0) {
            return of();
        }
        int i12 = 0;
        if (i11 == 1) {
            return of(objArr[0]);
        }
        c cVar = new c(4);
        while (i12 < i11) {
            r11 = cVar;
            Object objA = r11.a(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(objArr[i12]));
            i12++;
            r11 = objA;
        }
        r11 = cVar;
        return r11.g().c();
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        return iterable instanceof Collection ? copyOf((Collection) iterable) : copyOf(iterable.iterator());
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.isPartialView()) {
                return immutableSet;
            }
        } else if (collection instanceof EnumSet) {
            return copyOfEnumSet((EnumSet) collection);
        }
        Object[] array = collection.toArray();
        return construct(array.length, array);
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        return !it.hasNext() ? of((Object) next) : new a().a(next).f(it).g();
    }

    public static <E> ImmutableSet<E> copyOf(E[] eArr) {
        int length = eArr.length;
        if (length != 0) {
            return length != 1 ? construct(eArr.length, (Object[]) eArr.clone()) : of((Object) eArr[0]);
        }
        return of();
    }

    private static ImmutableSet copyOfEnumSet(EnumSet enumSet) {
        return ImmutableEnumSet.asImmutable(EnumSet.copyOf(enumSet));
    }

    public static boolean hashFloodingDetected(Object[] objArr) {
        int iMaxRunBeforeFallback = maxRunBeforeFallback(objArr.length);
        int i11 = 0;
        while (i11 < objArr.length && objArr[i11] != null) {
            i11++;
            if (i11 > iMaxRunBeforeFallback) {
                return true;
            }
        }
        int length = objArr.length - 1;
        while (length > i11 && objArr[length] != null) {
            if (((objArr.length - 1) - length) + i11 > iMaxRunBeforeFallback) {
                return true;
            }
            length--;
        }
        int i12 = i11 + 1;
        while (i12 < length) {
            int i13 = 0;
            while (i12 < length && objArr[i12] != null) {
                i13++;
                if (i13 > iMaxRunBeforeFallback) {
                    return true;
                }
                i12++;
            }
            i12++;
        }
        return false;
    }

    public static int maxRunBeforeFallback(int i11) {
        return com.google.firebase.crashlytics.buildtools.reloc.com.google.common.math.c.d(i11, RoundingMode.UNNECESSARY) * 12;
    }

    public static <E> ImmutableSet<E> of() {
        return RegularImmutableSet.EMPTY;
    }

    public static <E> ImmutableSet<E> of(E e11) {
        return new SingletonImmutableSet(e11);
    }

    public static <E> ImmutableSet<E> of(E e11, E e12) {
        return construct(2, e11, e12);
    }

    public static <E> ImmutableSet<E> of(E e11, E e12, E e13) {
        return construct(3, e11, e12, e13);
    }

    public static <E> ImmutableSet<E> of(E e11, E e12, E e13, E e14) {
        return construct(4, e11, e12, e13, e14);
    }

    public static <E> ImmutableSet<E> of(E e11, E e12, E e13, E e14, E e15) {
        return construct(5, e11, e12, e13, e14, e15);
    }

    @SafeVarargs
    public static <E> ImmutableSet<E> of(E e11, E e12, E e13, E e14, E e15, E e16, E... eArr) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.e(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e11;
        objArr[1] = e12;
        objArr[2] = e13;
        objArr[3] = e14;
        objArr[4] = e15;
        objArr[5] = e16;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return construct(length, objArr);
    }

    public static Object[] rebuildHashTable(int i11, Object[] objArr, int i12) {
        int i13;
        Object[] objArr2 = new Object[i11];
        int i14 = i11 - 1;
        for (int i15 = 0; i15 < i12; i15++) {
            Object obj = objArr[i15];
            int iC = y2.c(obj.hashCode());
            while (true) {
                i13 = iC & i14;
                if (objArr2[i13] == null) {
                    break;
                }
                iC++;
            }
            objArr2[i13] = obj;
        }
        return objArr2;
    }

    public static <E> Collector<E, ?, ImmutableSet<E>> toImmutableSet() {
        return m1.r();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> immutableListCreateAsList = createAsList();
        this.asList = immutableListCreateAsList;
        return immutableListCreateAsList;
    }

    public ImmutableList<E> createAsList() {
        return new RegularImmutableAsList(this, toArray());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && isHashCodeFast() && ((ImmutableSet) obj).isHashCodeFast() && hashCode() != obj.hashCode()) {
            return false;
        }
        return Sets.a(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.b(this);
    }

    public boolean isHashCodeFast() {
        return false;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public abstract t7<E> iterator();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(toArray());
    }
}
