package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@SinceKotlin
@Metadata
@WasExperimental
@SourceDebugExtension
public final class ArrayDeque<E> extends AbstractMutableList<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f68729d = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object[] f68730f = new Object[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f68731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f68732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f68733c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ArrayDeque() {
        this.f68732b = f68730f;
    }

    public ArrayDeque(int i11) {
        Object[] objArr;
        if (i11 == 0) {
            objArr = f68730f;
        } else {
            if (i11 <= 0) {
                throw new IllegalArgumentException("Illegal Capacity: " + i11);
            }
            objArr = new Object[i11];
        }
        this.f68732b = objArr;
    }

    private final void g(int i11) {
        if (i11 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f68732b;
        if (i11 <= objArr.length) {
            return;
        }
        if (objArr == f68730f) {
            this.f68732b = new Object[kotlin.ranges.a.d(i11, 10)];
        } else {
            e(AbstractList.Companion.e(objArr.length, i11));
        }
    }

    public final void a(int i11, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.f68732b.length;
        while (i11 < length && it.hasNext()) {
            this.f68732b[i11] = it.next();
            i11++;
        }
        int i12 = this.f68731a;
        for (int i13 = 0; i13 < i12 && it.hasNext(); i13++) {
            this.f68732b[i13] = it.next();
        }
        this.f68733c = size() + collection.size();
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int i11, E e11) {
        AbstractList.Companion.c(i11, size());
        if (i11 == size()) {
            addLast(e11);
            return;
        }
        if (i11 == 0) {
            addFirst(e11);
            return;
        }
        g(size() + 1);
        int iU = u(this.f68731a + i11);
        if (i11 < ((size() + 1) >> 1)) {
            int iF = f(iU);
            int iF2 = f(this.f68731a);
            int i12 = this.f68731a;
            if (iF >= i12) {
                Object[] objArr = this.f68732b;
                objArr[iF2] = objArr[i12];
                ArraysKt___ArraysJvmKt.l(objArr, objArr, i12, i12 + 1, iF + 1);
            } else {
                Object[] objArr2 = this.f68732b;
                ArraysKt___ArraysJvmKt.l(objArr2, objArr2, i12 - 1, i12, objArr2.length);
                Object[] objArr3 = this.f68732b;
                objArr3[objArr3.length - 1] = objArr3[0];
                ArraysKt___ArraysJvmKt.l(objArr3, objArr3, 0, 1, iF + 1);
            }
            this.f68732b[iF] = e11;
            this.f68731a = iF2;
        } else {
            int iU2 = u(this.f68731a + size());
            if (iU < iU2) {
                Object[] objArr4 = this.f68732b;
                ArraysKt___ArraysJvmKt.l(objArr4, objArr4, iU + 1, iU, iU2);
            } else {
                Object[] objArr5 = this.f68732b;
                ArraysKt___ArraysJvmKt.l(objArr5, objArr5, 1, 0, iU2);
                Object[] objArr6 = this.f68732b;
                objArr6[0] = objArr6[objArr6.length - 1];
                ArraysKt___ArraysJvmKt.l(objArr6, objArr6, iU + 1, iU, objArr6.length - 1);
            }
            this.f68732b[iU] = e11;
        }
        this.f68733c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e11) {
        addLast(e11);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i11, Collection<? extends E> elements) {
        Intrinsics.g(elements, "elements");
        AbstractList.Companion.c(i11, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (i11 == size()) {
            return addAll(elements);
        }
        g(size() + elements.size());
        int iU = u(this.f68731a + size());
        int iU2 = u(this.f68731a + i11);
        int size = elements.size();
        if (i11 < ((size() + 1) >> 1)) {
            int i12 = this.f68731a;
            int length = i12 - size;
            if (iU2 < i12) {
                Object[] objArr = this.f68732b;
                ArraysKt___ArraysJvmKt.l(objArr, objArr, length, i12, objArr.length);
                if (size >= iU2) {
                    Object[] objArr2 = this.f68732b;
                    ArraysKt___ArraysJvmKt.l(objArr2, objArr2, objArr2.length - size, 0, iU2);
                } else {
                    Object[] objArr3 = this.f68732b;
                    ArraysKt___ArraysJvmKt.l(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f68732b;
                    ArraysKt___ArraysJvmKt.l(objArr4, objArr4, 0, size, iU2);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.f68732b;
                ArraysKt___ArraysJvmKt.l(objArr5, objArr5, length, i12, iU2);
            } else {
                Object[] objArr6 = this.f68732b;
                length += objArr6.length;
                int i13 = iU2 - i12;
                int length2 = objArr6.length - length;
                if (length2 >= i13) {
                    ArraysKt___ArraysJvmKt.l(objArr6, objArr6, length, i12, iU2);
                } else {
                    ArraysKt___ArraysJvmKt.l(objArr6, objArr6, length, i12, i12 + length2);
                    Object[] objArr7 = this.f68732b;
                    ArraysKt___ArraysJvmKt.l(objArr7, objArr7, 0, this.f68731a + length2, iU2);
                }
            }
            this.f68731a = length;
            a(s(iU2 - size), elements);
        } else {
            int i14 = iU2 + size;
            if (iU2 < iU) {
                int i15 = size + iU;
                Object[] objArr8 = this.f68732b;
                if (i15 <= objArr8.length) {
                    ArraysKt___ArraysJvmKt.l(objArr8, objArr8, i14, iU2, iU);
                } else if (i14 >= objArr8.length) {
                    ArraysKt___ArraysJvmKt.l(objArr8, objArr8, i14 - objArr8.length, iU2, iU);
                } else {
                    int length3 = iU - (i15 - objArr8.length);
                    ArraysKt___ArraysJvmKt.l(objArr8, objArr8, 0, length3, iU);
                    Object[] objArr9 = this.f68732b;
                    ArraysKt___ArraysJvmKt.l(objArr9, objArr9, i14, iU2, length3);
                }
            } else {
                Object[] objArr10 = this.f68732b;
                ArraysKt___ArraysJvmKt.l(objArr10, objArr10, size, 0, iU);
                Object[] objArr11 = this.f68732b;
                if (i14 >= objArr11.length) {
                    ArraysKt___ArraysJvmKt.l(objArr11, objArr11, i14 - objArr11.length, iU2, objArr11.length);
                } else {
                    ArraysKt___ArraysJvmKt.l(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f68732b;
                    ArraysKt___ArraysJvmKt.l(objArr12, objArr12, i14, iU2, objArr12.length - size);
                }
            }
            a(iU2, elements);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.g(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        g(size() + elements.size());
        a(u(this.f68731a + size()), elements);
        return true;
    }

    public final void addFirst(E e11) {
        g(size() + 1);
        int iF = f(this.f68731a);
        this.f68731a = iF;
        this.f68732b[iF] = e11;
        this.f68733c = size() + 1;
    }

    public final void addLast(E e11) {
        g(size() + 1);
        this.f68732b[u(this.f68731a + size())] = e11;
        this.f68733c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int iU = u(this.f68731a + size());
        int i11 = this.f68731a;
        if (i11 < iU) {
            ArraysKt___ArraysJvmKt.u(this.f68732b, null, i11, iU);
        } else if (!isEmpty()) {
            Object[] objArr = this.f68732b;
            ArraysKt___ArraysJvmKt.u(objArr, null, this.f68731a, objArr.length);
            ArraysKt___ArraysJvmKt.u(this.f68732b, null, 0, iU);
        }
        this.f68731a = 0;
        this.f68733c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void e(int i11) {
        Object[] objArr = new Object[i11];
        Object[] objArr2 = this.f68732b;
        ArraysKt___ArraysJvmKt.l(objArr2, objArr, 0, this.f68731a, objArr2.length);
        Object[] objArr3 = this.f68732b;
        int length = objArr3.length;
        int i12 = this.f68731a;
        ArraysKt___ArraysJvmKt.l(objArr3, objArr, length - i12, 0, i12);
        this.f68731a = 0;
        this.f68732b = objArr;
    }

    public final int f(int i11) {
        return i11 == 0 ? d.U(this.f68732b) : i11 - 1;
    }

    public final E first() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.f68732b[this.f68731a];
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i11) {
        AbstractList.Companion.b(i11, size());
        return (E) this.f68732b[u(this.f68731a + i11)];
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.f68733c;
    }

    public final E i() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.f68732b[this.f68731a];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i11;
        int iU = u(this.f68731a + size());
        int length = this.f68731a;
        if (length < iU) {
            while (length < iU) {
                if (Intrinsics.b(obj, this.f68732b[length])) {
                    i11 = this.f68731a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iU) {
            return -1;
        }
        int length2 = this.f68732b.length;
        while (length < length2) {
            if (Intrinsics.b(obj, this.f68732b[length])) {
                i11 = this.f68731a;
            } else {
                length++;
            }
        }
        for (int i12 = 0; i12 < iU; i12++) {
            if (Intrinsics.b(obj, this.f68732b[i12])) {
                length = i12 + this.f68732b.length;
                i11 = this.f68731a;
            }
        }
        return -1;
        return length - i11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    public final int j(int i11) {
        if (i11 == d.U(this.f68732b)) {
            return 0;
        }
        return i11 + 1;
    }

    public final E last() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.f68732b[u(this.f68731a + g.n(this))];
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int iU;
        int i11;
        int iU2 = u(this.f68731a + size());
        int i12 = this.f68731a;
        if (i12 < iU2) {
            iU = iU2 - 1;
            if (i12 <= iU) {
                while (!Intrinsics.b(obj, this.f68732b[iU])) {
                    if (iU != i12) {
                        iU--;
                    }
                }
                i11 = this.f68731a;
                return iU - i11;
            }
            return -1;
        }
        if (i12 > iU2) {
            for (int i13 = iU2 - 1; -1 < i13; i13--) {
                if (Intrinsics.b(obj, this.f68732b[i13])) {
                    iU = i13 + this.f68732b.length;
                    i11 = this.f68731a;
                    return iU - i11;
                }
            }
            iU = d.U(this.f68732b);
            int i14 = this.f68731a;
            if (i14 <= iU) {
                while (!Intrinsics.b(obj, this.f68732b[iU])) {
                    if (iU != i14) {
                        iU--;
                    }
                }
                i11 = this.f68731a;
                return iU - i11;
            }
        }
        return -1;
    }

    public final E r() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.f68732b[u(this.f68731a + g.n(this))];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> elements) {
        int iU;
        Intrinsics.g(elements, "elements");
        boolean z11 = false;
        z11 = false;
        z11 = false;
        if (!isEmpty() && this.f68732b.length != 0) {
            int iU2 = u(this.f68731a + size());
            int i11 = this.f68731a;
            if (i11 < iU2) {
                iU = i11;
                while (i11 < iU2) {
                    Object obj = this.f68732b[i11];
                    if (!elements.contains(obj)) {
                        this.f68732b[iU] = obj;
                        iU++;
                    } else {
                        z11 = true;
                    }
                    i11++;
                }
                ArraysKt___ArraysJvmKt.u(this.f68732b, null, iU, iU2);
            } else {
                int length = this.f68732b.length;
                int i12 = i11;
                boolean z12 = false;
                while (i11 < length) {
                    Object[] objArr = this.f68732b;
                    Object obj2 = objArr[i11];
                    objArr[i11] = null;
                    if (!elements.contains(obj2)) {
                        this.f68732b[i12] = obj2;
                        i12++;
                    } else {
                        z12 = true;
                    }
                    i11++;
                }
                iU = u(i12);
                for (int i13 = 0; i13 < iU2; i13++) {
                    Object[] objArr2 = this.f68732b;
                    Object obj3 = objArr2[i13];
                    objArr2[i13] = null;
                    if (!elements.contains(obj3)) {
                        this.f68732b[iU] = obj3;
                        iU = j(iU);
                    } else {
                        z12 = true;
                    }
                }
                z11 = z12;
            }
            if (z11) {
                this.f68733c = s(iU - this.f68731a);
            }
        }
        return z11;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int i11) {
        AbstractList.Companion.b(i11, size());
        if (i11 == g.n(this)) {
            return removeLast();
        }
        if (i11 == 0) {
            return removeFirst();
        }
        int iU = u(this.f68731a + i11);
        E e11 = (E) this.f68732b[iU];
        if (i11 < (size() >> 1)) {
            int i12 = this.f68731a;
            if (iU >= i12) {
                Object[] objArr = this.f68732b;
                ArraysKt___ArraysJvmKt.l(objArr, objArr, i12 + 1, i12, iU);
            } else {
                Object[] objArr2 = this.f68732b;
                ArraysKt___ArraysJvmKt.l(objArr2, objArr2, 1, 0, iU);
                Object[] objArr3 = this.f68732b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i13 = this.f68731a;
                ArraysKt___ArraysJvmKt.l(objArr3, objArr3, i13 + 1, i13, objArr3.length - 1);
            }
            Object[] objArr4 = this.f68732b;
            int i14 = this.f68731a;
            objArr4[i14] = null;
            this.f68731a = j(i14);
        } else {
            int iU2 = u(this.f68731a + g.n(this));
            if (iU <= iU2) {
                Object[] objArr5 = this.f68732b;
                ArraysKt___ArraysJvmKt.l(objArr5, objArr5, iU, iU + 1, iU2 + 1);
            } else {
                Object[] objArr6 = this.f68732b;
                ArraysKt___ArraysJvmKt.l(objArr6, objArr6, iU, iU + 1, objArr6.length);
                Object[] objArr7 = this.f68732b;
                objArr7[objArr7.length - 1] = objArr7[0];
                ArraysKt___ArraysJvmKt.l(objArr7, objArr7, 0, 1, iU2 + 1);
            }
            this.f68732b[iU2] = null;
        }
        this.f68733c = size() - 1;
        return e11;
    }

    public final E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        Object[] objArr = this.f68732b;
        int i11 = this.f68731a;
        E e11 = (E) objArr[i11];
        objArr[i11] = null;
        this.f68731a = j(i11);
        this.f68733c = size() - 1;
        return e11;
    }

    public final E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        int iU = u(this.f68731a + g.n(this));
        Object[] objArr = this.f68732b;
        E e11 = (E) objArr[iU];
        objArr[iU] = null;
        this.f68733c = size() - 1;
        return e11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> elements) {
        int iU;
        Intrinsics.g(elements, "elements");
        boolean z11 = false;
        z11 = false;
        z11 = false;
        if (!isEmpty() && this.f68732b.length != 0) {
            int iU2 = u(this.f68731a + size());
            int i11 = this.f68731a;
            if (i11 < iU2) {
                iU = i11;
                while (i11 < iU2) {
                    Object obj = this.f68732b[i11];
                    if (elements.contains(obj)) {
                        this.f68732b[iU] = obj;
                        iU++;
                    } else {
                        z11 = true;
                    }
                    i11++;
                }
                ArraysKt___ArraysJvmKt.u(this.f68732b, null, iU, iU2);
            } else {
                int length = this.f68732b.length;
                int i12 = i11;
                boolean z12 = false;
                while (i11 < length) {
                    Object[] objArr = this.f68732b;
                    Object obj2 = objArr[i11];
                    objArr[i11] = null;
                    if (elements.contains(obj2)) {
                        this.f68732b[i12] = obj2;
                        i12++;
                    } else {
                        z12 = true;
                    }
                    i11++;
                }
                iU = u(i12);
                for (int i13 = 0; i13 < iU2; i13++) {
                    Object[] objArr2 = this.f68732b;
                    Object obj3 = objArr2[i13];
                    objArr2[i13] = null;
                    if (elements.contains(obj3)) {
                        this.f68732b[iU] = obj3;
                        iU = j(iU);
                    } else {
                        z12 = true;
                    }
                }
                z11 = z12;
            }
            if (z11) {
                this.f68733c = s(iU - this.f68731a);
            }
        }
        return z11;
    }

    public final int s(int i11) {
        return i11 < 0 ? i11 + this.f68732b.length : i11;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int i11, E e11) {
        AbstractList.Companion.b(i11, size());
        int iU = u(this.f68731a + i11);
        Object[] objArr = this.f68732b;
        E e12 = (E) objArr[iU];
        objArr[iU] = e11;
        return e12;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] array) {
        Intrinsics.g(array, "array");
        if (array.length < size()) {
            array = (T[]) b.a(array, size());
        }
        int iU = u(this.f68731a + size());
        int i11 = this.f68731a;
        if (i11 < iU) {
            ArraysKt___ArraysJvmKt.p(this.f68732b, array, 0, i11, iU, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr = this.f68732b;
            ArraysKt___ArraysJvmKt.l(objArr, array, 0, this.f68731a, objArr.length);
            Object[] objArr2 = this.f68732b;
            ArraysKt___ArraysJvmKt.l(objArr2, array, objArr2.length - this.f68731a, 0, iU);
        }
        return (T[]) f.g(size(), array);
    }

    public final int u(int i11) {
        Object[] objArr = this.f68732b;
        return i11 >= objArr.length ? i11 - objArr.length : i11;
    }

    public final E v() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }
}
