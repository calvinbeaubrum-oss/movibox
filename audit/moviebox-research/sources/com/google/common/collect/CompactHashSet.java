package com.google.common.collect;

import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
class CompactHashSet<E> extends AbstractSet<E> implements Serializable {
    static final double HASH_FLOODING_FPP = 0.001d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Object f38287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int[] f38288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient int f38289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient int f38290d;
    transient Object[] elements;

    /* JADX INFO: compiled from: source.java */
    public class a implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f38291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f38292b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f38293c = -1;

        public a() {
            this.f38291a = CompactHashSet.this.f38289c;
            this.f38292b = CompactHashSet.this.firstEntryIndex();
        }

        public final void a() {
            if (CompactHashSet.this.f38289c != this.f38291a) {
                throw new ConcurrentModificationException();
            }
        }

        public void b() {
            this.f38291a += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f38292b >= 0;
        }

        @Override // java.util.Iterator
        public E next() {
            a();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i11 = this.f38292b;
            this.f38293c = i11;
            E e11 = (E) CompactHashSet.this.b(i11);
            this.f38292b = CompactHashSet.this.getSuccessor(this.f38292b);
            return e11;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            l.e(this.f38293c >= 0);
            b();
            CompactHashSet compactHashSet = CompactHashSet.this;
            compactHashSet.remove(compactHashSet.b(this.f38293c));
            this.f38292b = CompactHashSet.this.adjustAfterRemove(this.f38292b, this.f38293c);
            this.f38293c = -1;
        }
    }

    public CompactHashSet() {
        init(3);
    }

    public CompactHashSet(int i11) {
        init(i11);
    }

    public static <E> CompactHashSet<E> create() {
        return new CompactHashSet<>();
    }

    public static <E> CompactHashSet<E> create(Collection<? extends E> collection) {
        CompactHashSet<E> compactHashSetCreateWithExpectedSize = createWithExpectedSize(collection.size());
        compactHashSetCreateWithExpectedSize.addAll(collection);
        return compactHashSetCreateWithExpectedSize;
    }

    @SafeVarargs
    public static <E> CompactHashSet<E> create(E... eArr) {
        CompactHashSet<E> compactHashSetCreateWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(compactHashSetCreateWithExpectedSize, eArr);
        return compactHashSetCreateWithExpectedSize;
    }

    public static <E> CompactHashSet<E> createWithExpectedSize(int i11) {
        return new CompactHashSet<>(i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i11 = objectInputStream.readInt();
        if (i11 < 0) {
            throw new InvalidObjectException("Invalid size: " + i11);
        }
        init(i11);
        for (int i12 = 0; i12 < i11; i12++) {
            add(objectInputStream.readObject());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    public final Set<E> a(int i11) {
        return new LinkedHashSet(i11, 1.0f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e11) {
        if (needsAllocArrays()) {
            allocArrays();
        }
        Set<E> setDelegateOrNull = delegateOrNull();
        if (setDelegateOrNull != null) {
            return setDelegateOrNull.add(e11);
        }
        int[] iArrI = i();
        Object[] objArrG = g();
        int i11 = this.f38290d;
        int i12 = i11 + 1;
        int iD = c0.d(e11);
        int iF = f();
        int i13 = iD & iF;
        int iH = n.h(j(), i13);
        if (iH != 0) {
            int iB = n.b(iD, iF);
            int i14 = 0;
            while (true) {
                int i15 = iH - 1;
                int i16 = iArrI[i15];
                if (n.b(i16, iF) == iB && com.google.common.base.j.a(e11, objArrG[i15])) {
                    return false;
                }
                int iC = n.c(i16, iF);
                i14++;
                if (iC != 0) {
                    iH = iC;
                } else {
                    if (i14 >= 9) {
                        return convertToHashFloodingResistantImplementation().add(e11);
                    }
                    if (i12 > iF) {
                        iF = r(iF, n.e(iF), iD, i11);
                    } else {
                        iArrI[i15] = n.d(i16, i12, iF);
                    }
                }
            }
        } else if (i12 > iF) {
            iF = r(iF, n.e(iF), iD, i11);
        } else {
            n.i(j(), i13, i12);
        }
        o(i12);
        insertEntry(i11, e11, iD, iF);
        this.f38290d = i12;
        incrementModCount();
        return true;
    }

    public int adjustAfterRemove(int i11, int i12) {
        return i11 - 1;
    }

    public int allocArrays() {
        com.google.common.base.m.w(needsAllocArrays(), "Arrays already allocated");
        int i11 = this.f38289c;
        int iJ = n.j(i11);
        this.f38287a = n.a(iJ);
        v(iJ - 1);
        this.f38288b = new int[i11];
        this.elements = new Object[i11];
        return i11;
    }

    public final E b(int i11) {
        return (E) g()[i11];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        incrementModCount();
        Set<E> setDelegateOrNull = delegateOrNull();
        if (setDelegateOrNull != null) {
            this.f38289c = Ints.f(size(), 3, 1073741823);
            setDelegateOrNull.clear();
            this.f38287a = null;
            this.f38290d = 0;
            return;
        }
        Arrays.fill(g(), 0, this.f38290d, (Object) null);
        n.g(j());
        Arrays.fill(i(), 0, this.f38290d, 0);
        this.f38290d = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        Set<E> setDelegateOrNull = delegateOrNull();
        if (setDelegateOrNull != null) {
            return setDelegateOrNull.contains(obj);
        }
        int iD = c0.d(obj);
        int iF = f();
        int iH = n.h(j(), iD & iF);
        if (iH == 0) {
            return false;
        }
        int iB = n.b(iD, iF);
        do {
            int i11 = iH - 1;
            int iE = e(i11);
            if (n.b(iE, iF) == iB && com.google.common.base.j.a(obj, b(i11))) {
                return true;
            }
            iH = n.c(iE, iF);
        } while (iH != 0);
        return false;
    }

    public Set<E> convertToHashFloodingResistantImplementation() {
        Set<E> setA = a(f() + 1);
        int iFirstEntryIndex = firstEntryIndex();
        while (iFirstEntryIndex >= 0) {
            setA.add(b(iFirstEntryIndex));
            iFirstEntryIndex = getSuccessor(iFirstEntryIndex);
        }
        this.f38287a = setA;
        this.f38288b = null;
        this.elements = null;
        incrementModCount();
        return setA;
    }

    public Set<E> delegateOrNull() {
        Object obj = this.f38287a;
        if (obj instanceof Set) {
            return (Set) obj;
        }
        return null;
    }

    public final int e(int i11) {
        return i()[i11];
    }

    public final int f() {
        return (1 << (this.f38289c & 31)) - 1;
    }

    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    public final Object[] g() {
        Object[] objArr = this.elements;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public int getSuccessor(int i11) {
        int i12 = i11 + 1;
        if (i12 < this.f38290d) {
            return i12;
        }
        return -1;
    }

    public final int[] i() {
        int[] iArr = this.f38288b;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public void incrementModCount() {
        this.f38289c += 32;
    }

    public void init(int i11) {
        com.google.common.base.m.e(i11 >= 0, "Expected size must be >= 0");
        this.f38289c = Ints.f(i11, 1, 1073741823);
    }

    public void insertEntry(int i11, E e11, int i12, int i13) {
        u(i11, n.d(i12, 0, i13));
        s(i11, e11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isUsingHashFloodingResistance() {
        return delegateOrNull() != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        Set<E> setDelegateOrNull = delegateOrNull();
        return setDelegateOrNull != null ? setDelegateOrNull.iterator() : new a();
    }

    public final Object j() {
        Object obj = this.f38287a;
        Objects.requireNonNull(obj);
        return obj;
    }

    public void moveLastEntry(int i11, int i12) {
        Object objJ = j();
        int[] iArrI = i();
        Object[] objArrG = g();
        int size = size();
        int i13 = size - 1;
        if (i11 >= i13) {
            objArrG[i11] = null;
            iArrI[i11] = 0;
            return;
        }
        Object obj = objArrG[i13];
        objArrG[i11] = obj;
        objArrG[i13] = null;
        iArrI[i11] = iArrI[i13];
        iArrI[i13] = 0;
        int iD = c0.d(obj) & i12;
        int iH = n.h(objJ, iD);
        if (iH == size) {
            n.i(objJ, iD, i11 + 1);
            return;
        }
        while (true) {
            int i14 = iH - 1;
            int i15 = iArrI[i14];
            int iC = n.c(i15, i12);
            if (iC == size) {
                iArrI[i14] = n.d(i15, i11 + 1, i12);
                return;
            }
            iH = iC;
        }
    }

    public boolean needsAllocArrays() {
        return this.f38287a == null;
    }

    public final void o(int i11) {
        int iMin;
        int length = i().length;
        if (i11 <= length || (iMin = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        resizeEntries(iMin);
    }

    public final int r(int i11, int i12, int i13, int i14) {
        Object objA = n.a(i12);
        int i15 = i12 - 1;
        if (i14 != 0) {
            n.i(objA, i13 & i15, i14 + 1);
        }
        Object objJ = j();
        int[] iArrI = i();
        for (int i16 = 0; i16 <= i11; i16++) {
            int iH = n.h(objJ, i16);
            while (iH != 0) {
                int i17 = iH - 1;
                int i18 = iArrI[i17];
                int iB = n.b(i18, i11) | i16;
                int i19 = iB & i15;
                int iH2 = n.h(objA, i19);
                n.i(objA, i19, iH);
                iArrI[i17] = n.d(iB, iH2, i15);
                iH = n.c(i18, i11);
            }
        }
        this.f38287a = objA;
        v(i15);
        return i15;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        Set<E> setDelegateOrNull = delegateOrNull();
        if (setDelegateOrNull != null) {
            return setDelegateOrNull.remove(obj);
        }
        int iF = f();
        int iF2 = n.f(obj, null, iF, j(), i(), g(), null);
        if (iF2 == -1) {
            return false;
        }
        moveLastEntry(iF2, iF);
        this.f38290d--;
        incrementModCount();
        return true;
    }

    public void resizeEntries(int i11) {
        this.f38288b = Arrays.copyOf(i(), i11);
        this.elements = Arrays.copyOf(g(), i11);
    }

    public final void s(int i11, E e11) {
        g()[i11] = e11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        Set<E> setDelegateOrNull = delegateOrNull();
        return setDelegateOrNull != null ? setDelegateOrNull.size() : this.f38290d;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        if (needsAllocArrays()) {
            return new Object[0];
        }
        Set<E> setDelegateOrNull = delegateOrNull();
        return setDelegateOrNull != null ? setDelegateOrNull.toArray() : Arrays.copyOf(g(), this.f38290d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (!needsAllocArrays()) {
            Set<E> setDelegateOrNull = delegateOrNull();
            return setDelegateOrNull != null ? (T[]) setDelegateOrNull.toArray(tArr) : (T[]) l0.h(g(), 0, this.f38290d, tArr);
        }
        if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }

    public void trimToSize() {
        if (needsAllocArrays()) {
            return;
        }
        Set<E> setDelegateOrNull = delegateOrNull();
        if (setDelegateOrNull != null) {
            Set<E> setA = a(size());
            setA.addAll(setDelegateOrNull);
            this.f38287a = setA;
            return;
        }
        int i11 = this.f38290d;
        if (i11 < i().length) {
            resizeEntries(i11);
        }
        int iJ = n.j(i11);
        int iF = f();
        if (iJ < iF) {
            r(iF, iJ, 0, 0);
        }
    }

    public final void u(int i11, int i12) {
        i()[i11] = i12;
    }

    public final void v(int i11) {
        this.f38289c = n.d(this.f38289c, 32 - Integer.numberOfLeadingZeros(i11), 31);
    }
}
