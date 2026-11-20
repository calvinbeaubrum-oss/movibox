package com.google.common.collect;

import com.google.j2objc.annotations.RetainedWith;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    private static final int CUTOFF = 751619276;
    private static final double DESIRED_LOAD_FACTOR = 0.7d;
    static final int MAX_TABLE_SIZE = 1073741824;

    @RetainedWith
    private transient ImmutableList<E> asList;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
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
    /* JADX INFO: loaded from: classes4.dex */
    public static class a<E> extends ImmutableCollection.a<E> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object[] f38392d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f38393e;

        public a() {
            super(4);
        }

        public a(int i11) {
            super(i11);
            this.f38392d = new Object[ImmutableSet.chooseTableSize(i11)];
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public a<E> a(E e11) {
            com.google.common.base.m.p(e11);
            if (this.f38392d != null && ImmutableSet.chooseTableSize(this.f38347b) <= this.f38392d.length) {
                m(e11);
                return this;
            }
            this.f38392d = null;
            super.f(e11);
            return this;
        }

        public a<E> j(E... eArr) {
            if (this.f38392d != null) {
                for (E e11 : eArr) {
                    a(e11);
                }
            } else {
                super.b(eArr);
            }
            return this;
        }

        public a<E> k(Iterable<? extends E> iterable) {
            com.google.common.base.m.p(iterable);
            if (this.f38392d != null) {
                Iterator<? extends E> it = iterable.iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
            } else {
                super.c(iterable);
            }
            return this;
        }

        public a<E> l(Iterator<? extends E> it) {
            com.google.common.base.m.p(it);
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }

        public final void m(E e11) {
            Objects.requireNonNull(this.f38392d);
            int length = this.f38392d.length - 1;
            int iHashCode = e11.hashCode();
            int iC = c0.c(iHashCode);
            while (true) {
                int i11 = iC & length;
                Object[] objArr = this.f38392d;
                Object obj = objArr[i11];
                if (obj == null) {
                    objArr[i11] = e11;
                    this.f38393e += iHashCode;
                    super.f(e11);
                    return;
                } else if (obj.equals(e11)) {
                    return;
                } else {
                    iC = i11 + 1;
                }
            }
        }

        public ImmutableSet<E> n() {
            ImmutableSet<E> immutableSetConstruct;
            int i11 = this.f38347b;
            if (i11 == 0) {
                return ImmutableSet.of();
            }
            if (i11 == 1) {
                Object obj = this.f38346a[0];
                Objects.requireNonNull(obj);
                return ImmutableSet.of(obj);
            }
            if (this.f38392d == null || ImmutableSet.chooseTableSize(i11) != this.f38392d.length) {
                immutableSetConstruct = ImmutableSet.construct(this.f38347b, this.f38346a);
                this.f38347b = immutableSetConstruct.size();
            } else {
                Object[] objArrCopyOf = ImmutableSet.shouldTrim(this.f38347b, this.f38346a.length) ? Arrays.copyOf(this.f38346a, this.f38347b) : this.f38346a;
                int i12 = this.f38393e;
                Object[] objArr = this.f38392d;
                immutableSetConstruct = new RegularImmutableSet<>(objArrCopyOf, i12, objArr, objArr.length - 1, this.f38347b);
            }
            this.f38348c = true;
            this.f38392d = null;
            return immutableSetConstruct;
        }
    }

    public static <E> a<E> builder() {
        return new a<>();
    }

    public static <E> a<E> builderWithExpectedSize(int i11) {
        l.b(i11, "expectedSize");
        return new a<>(i11);
    }

    public static int chooseTableSize(int i11) {
        int iMax = Math.max(i11, 2);
        if (iMax >= CUTOFF) {
            com.google.common.base.m.e(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (((double) iHighestOneBit) * DESIRED_LOAD_FACTOR < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ImmutableSet<E> construct(int i11, Object... objArr) {
        if (i11 == 0) {
            return of();
        }
        if (i11 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return of(obj);
        }
        int iChooseTableSize = chooseTableSize(i11);
        Object[] objArr2 = new Object[iChooseTableSize];
        int i12 = iChooseTableSize - 1;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < i11; i15++) {
            Object objA = l0.a(objArr[i15], i15);
            int iHashCode = objA.hashCode();
            int iC = c0.c(iHashCode);
            while (true) {
                int i16 = iC & i12;
                Object obj2 = objArr2[i16];
                if (obj2 == null) {
                    objArr[i14] = objA;
                    objArr2[i16] = objA;
                    i13 += iHashCode;
                    i14++;
                    break;
                }
                if (obj2.equals(objA)) {
                    break;
                }
                iC++;
            }
        }
        Arrays.fill(objArr, i14, i11, (Object) null);
        if (i14 == 1) {
            Object obj3 = objArr[0];
            Objects.requireNonNull(obj3);
            return new SingletonImmutableSet(obj3);
        }
        if (chooseTableSize(i14) < iChooseTableSize / 2) {
            return construct(i14, objArr);
        }
        if (shouldTrim(i14, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i14);
        }
        return new RegularImmutableSet(objArr, i13, objArr2, i12, i14);
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
        }
        Object[] array = collection.toArray();
        return construct(array.length, array);
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        return !it.hasNext() ? of((Object) next) : new a().a(next).l(it).n();
    }

    public static <E> ImmutableSet<E> copyOf(E[] eArr) {
        int length = eArr.length;
        if (length != 0) {
            return length != 1 ? construct(eArr.length, (Object[]) eArr.clone()) : of((Object) eArr[0]);
        }
        return of();
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
        com.google.common.base.m.e(eArr.length <= 2147483641, "the total number of elements must fit in an int");
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

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean shouldTrim(int i11, int i12) {
        return i11 < (i12 >> 1) + (i12 >> 2);
    }

    @Override // com.google.common.collect.ImmutableCollection
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
        return ImmutableList.asImmutableList(toArray());
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
        return Sets.d(this);
    }

    public boolean isHashCodeFast() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public abstract g1<E> iterator();

    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(toArray());
    }
}
