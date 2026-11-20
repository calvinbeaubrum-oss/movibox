package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.o1;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class PersistentVectorBuilder<E> extends AbstractMutableList<E> implements s1.f.a<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s1.f<? extends E> f3372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f3373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f3374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3375d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public v1.e f3376f = new v1.e();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object[] f3377g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object[] f3378h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3379i;

    public PersistentVectorBuilder(s1.f<? extends E> fVar, Object[] objArr, Object[] objArr2, int i11) {
        this.f3372a = fVar;
        this.f3373b = objArr;
        this.f3374c = objArr2;
        this.f3375d = i11;
        this.f3377g = this.f3373b;
        this.f3378h = this.f3374c;
        this.f3379i = this.f3372a.size();
    }

    private final Object[] C(Object[] objArr, int i11, int i12, c cVar) {
        Object[] objArrC;
        int iA = j.a(i12 - 1, i11);
        if (i11 == 5) {
            cVar.b(objArr[iA]);
            objArrC = null;
        } else {
            Object obj = objArr[iA];
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrC = C((Object[]) obj, i11 - 5, i12, cVar);
        }
        if (objArrC == null && iA == 0) {
            return null;
        }
        Object[] objArrX = x(objArr);
        objArrX[iA] = objArrC;
        return objArrX;
    }

    private final Object[] N(Object[] objArr, int i11, int i12, c cVar) {
        int iA = j.a(i12, i11);
        if (i11 == 0) {
            Object obj = objArr[iA];
            Object[] objArrL = ArraysKt___ArraysJvmKt.l(objArr, x(objArr), iA, iA + 1, 32);
            objArrL[31] = cVar.a();
            cVar.b(obj);
            return objArrL;
        }
        int iA2 = objArr[31] == null ? j.a(Q() - 1, i11) : 31;
        Object[] objArrX = x(objArr);
        int i13 = i11 - 5;
        int i14 = iA + 1;
        if (i14 <= iA2) {
            while (true) {
                Object obj2 = objArrX[iA2];
                Intrinsics.e(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                objArrX[iA2] = N((Object[]) obj2, i13, 0, cVar);
                if (iA2 == i14) {
                    break;
                }
                iA2--;
            }
        }
        Object obj3 = objArrX[iA];
        Intrinsics.e(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objArrX[iA] = N((Object[]) obj3, i13, i12, cVar);
        return objArrX;
    }

    private final int Q() {
        if (size() <= 32) {
            return 0;
        }
        return j.d(size());
    }

    private final Object[] a(int i11) {
        if (Q() <= i11) {
            return this.f3378h;
        }
        Object[] objArr = this.f3377g;
        Intrinsics.d(objArr);
        for (int i12 = this.f3375d; i12 > 0; i12 -= 5) {
            Object[] objArr2 = objArr[j.a(i11, i12)];
            Intrinsics.e(objArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr = objArr2;
        }
        return objArr;
    }

    private final Object[] s(Object[] objArr, int i11, int i12, Object obj, c cVar) {
        Object obj2;
        int iA = j.a(i12, i11);
        if (i11 == 0) {
            cVar.b(objArr[31]);
            Object[] objArrL = ArraysKt___ArraysJvmKt.l(objArr, x(objArr), iA + 1, iA, 31);
            objArrL[iA] = obj;
            return objArrL;
        }
        Object[] objArrX = x(objArr);
        int i13 = i11 - 5;
        Object obj3 = objArrX[iA];
        Intrinsics.e(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objArrX[iA] = s((Object[]) obj3, i13, i12, obj, cVar);
        while (true) {
            iA++;
            if (iA >= 32 || (obj2 = objArrX[iA]) == null) {
                break;
            }
            Intrinsics.e(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrX[iA] = s((Object[]) obj2, i13, 0, cVar.a(), cVar);
        }
        return objArrX;
    }

    public final Object[] A(Object obj) {
        Object[] objArr = new Object[33];
        objArr[0] = obj;
        objArr[32] = this.f3376f;
        return objArr;
    }

    public final Object[] B(Object[] objArr, int i11, int i12) {
        if (!(i12 >= 0)) {
            o1.a("shift should be positive");
        }
        if (i12 == 0) {
            return objArr;
        }
        int iA = j.a(i11, i12);
        Object obj = objArr[iA];
        Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object objB = B((Object[]) obj, i11, i12 - 5);
        if (iA < 31) {
            int i13 = iA + 1;
            if (objArr[i13] != null) {
                if (v(objArr)) {
                    ArraysKt___ArraysJvmKt.u(objArr, null, i13, 32);
                }
                objArr = ArraysKt___ArraysJvmKt.l(objArr, z(), 0, 0, i13);
            }
        }
        if (objB == objArr[iA]) {
            return objArr;
        }
        Object[] objArrX = x(objArr);
        objArrX[iA] = objB;
        return objArrX;
    }

    public final void D(Object[] objArr, int i11, int i12) {
        if (i12 == 0) {
            this.f3377g = null;
            if (objArr == null) {
                objArr = new Object[0];
            }
            this.f3378h = objArr;
            this.f3379i = i11;
            this.f3375d = i12;
            return;
        }
        c cVar = new c(null);
        Intrinsics.d(objArr);
        Object[] objArrC = C(objArr, i12, i11, cVar);
        Intrinsics.d(objArrC);
        Object objA = cVar.a();
        Intrinsics.e(objA, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        this.f3378h = (Object[]) objA;
        this.f3379i = i11;
        if (objArrC[1] == null) {
            this.f3377g = (Object[]) objArrC[0];
            this.f3375d = i12 - 5;
        } else {
            this.f3377g = objArrC;
            this.f3375d = i12;
        }
    }

    public final Object[] E(Object[] objArr, int i11, int i12, Iterator<Object[]> it) {
        if (!it.hasNext()) {
            o1.a("invalid buffersIterator");
        }
        if (!(i12 >= 0)) {
            o1.a("negative shift");
        }
        if (i12 == 0) {
            return it.next();
        }
        Object[] objArrX = x(objArr);
        int iA = j.a(i11, i12);
        int i13 = i12 - 5;
        objArrX[iA] = E((Object[]) objArrX[iA], i11, i13, it);
        while (true) {
            iA++;
            if (iA >= 32 || !it.hasNext()) {
                break;
            }
            objArrX[iA] = E((Object[]) objArrX[iA], 0, i13, it);
        }
        return objArrX;
    }

    public final Object[] F(Object[] objArr, int i11, Object[][] objArr2) {
        Iterator<Object[]> itA = ArrayIteratorKt.a(objArr2);
        int i12 = i11 >> 5;
        int i13 = this.f3375d;
        Object[] objArrE = i12 < (1 << i13) ? E(objArr, i11, i13, itA) : x(objArr);
        while (itA.hasNext()) {
            this.f3375d += 5;
            objArrE = A(objArrE);
            int i14 = this.f3375d;
            E(objArrE, 1 << i14, i14, itA);
        }
        return objArrE;
    }

    public final void G(Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int size = size() >> 5;
        int i11 = this.f3375d;
        if (size > (1 << i11)) {
            this.f3377g = H(A(objArr), objArr2, this.f3375d + 5);
            this.f3378h = objArr3;
            this.f3375d += 5;
            this.f3379i = size() + 1;
            return;
        }
        if (objArr == null) {
            this.f3377g = objArr2;
            this.f3378h = objArr3;
            this.f3379i = size() + 1;
        } else {
            this.f3377g = H(objArr, objArr2, i11);
            this.f3378h = objArr3;
            this.f3379i = size() + 1;
        }
    }

    public final Object[] H(Object[] objArr, Object[] objArr2, int i11) {
        int iA = j.a(size() - 1, i11);
        Object[] objArrX = x(objArr);
        if (i11 == 5) {
            objArrX[iA] = objArr2;
        } else {
            objArrX[iA] = H((Object[]) objArrX[iA], objArr2, i11 - 5);
        }
        return objArrX;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int I(Function1<? super E, Boolean> function1, Object[] objArr, int i11, int i12, c cVar, List<Object[]> list, List<Object[]> list2) {
        if (v(objArr)) {
            list.add(objArr);
        }
        Object objA = cVar.a();
        Intrinsics.e(objA, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr2 = (Object[]) objA;
        Object[] objArrRemove = objArr2;
        for (int i13 = 0; i13 < i11; i13++) {
            Object obj = objArr[i13];
            if (!function1.invoke(obj).booleanValue()) {
                if (i12 == 32) {
                    objArrRemove = list.isEmpty() ^ true ? list.remove(list.size() - 1) : z();
                    i12 = 0;
                }
                objArrRemove[i12] = obj;
                i12++;
            }
        }
        cVar.b(objArrRemove);
        if (objArr2 != cVar.a()) {
            list2.add(objArr2);
        }
        return i12;
    }

    public final int J(Function1<? super E, Boolean> function1, Object[] objArr, int i11, c cVar) {
        Object[] objArrX = objArr;
        int i12 = i11;
        boolean z11 = false;
        for (int i13 = 0; i13 < i11; i13++) {
            Object obj = objArr[i13];
            if (function1.invoke(obj).booleanValue()) {
                if (!z11) {
                    objArrX = x(objArr);
                    z11 = true;
                    i12 = i13;
                }
            } else if (z11) {
                objArrX[i12] = obj;
                i12++;
            }
        }
        cVar.b(objArrX);
        return i12;
    }

    public final boolean K(Function1<? super E, Boolean> function1) {
        Object[] objArrE;
        int iU = U();
        c cVar = new c(null);
        if (this.f3377g == null) {
            return L(function1, iU, cVar) != iU;
        }
        ListIterator<Object[]> listIteratorW = w(0);
        int iJ = 32;
        while (iJ == 32 && listIteratorW.hasNext()) {
            iJ = J(function1, listIteratorW.next(), 32, cVar);
        }
        if (iJ == 32) {
            v1.a.a(!listIteratorW.hasNext());
            int iL = L(function1, iU, cVar);
            if (iL == 0) {
                D(this.f3377g, size(), this.f3375d);
            }
            return iL != iU;
        }
        int iPreviousIndex = listIteratorW.previousIndex() << 5;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int I = iJ;
        while (listIteratorW.hasNext()) {
            I = I(function1, listIteratorW.next(), 32, I, cVar, arrayList2, arrayList);
            iPreviousIndex = iPreviousIndex;
        }
        int i11 = iPreviousIndex;
        int I2 = I(function1, this.f3378h, iU, I, cVar, arrayList2, arrayList);
        Object objA = cVar.a();
        Intrinsics.e(objA, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr = (Object[]) objA;
        ArraysKt___ArraysJvmKt.u(objArr, null, I2, 32);
        if (arrayList.isEmpty()) {
            objArrE = this.f3377g;
            Intrinsics.d(objArrE);
        } else {
            objArrE = E(this.f3377g, i11, this.f3375d, arrayList.iterator());
        }
        int size = i11 + (arrayList.size() << 5);
        this.f3377g = P(objArrE, size);
        this.f3378h = objArr;
        this.f3379i = size + I2;
        return true;
    }

    public final int L(Function1<? super E, Boolean> function1, int i11, c cVar) {
        int iJ = J(function1, this.f3378h, i11, cVar);
        if (iJ == i11) {
            v1.a.a(cVar.a() == this.f3378h);
            return i11;
        }
        Object objA = cVar.a();
        Intrinsics.e(objA, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr = (Object[]) objA;
        ArraysKt___ArraysJvmKt.u(objArr, null, iJ, i11);
        this.f3378h = objArr;
        this.f3379i = size() - (i11 - iJ);
        return iJ;
    }

    public final boolean M(Function1<? super E, Boolean> function1) {
        boolean zK = K(function1);
        if (zK) {
            ((AbstractList) this).modCount++;
        }
        return zK;
    }

    public final Object O(Object[] objArr, int i11, int i12, int i13) {
        int size = size() - i11;
        v1.a.a(i13 < size);
        if (size == 1) {
            Object obj = this.f3378h[0];
            D(objArr, i11, i12);
            return obj;
        }
        Object[] objArr2 = this.f3378h;
        Object obj2 = objArr2[i13];
        Object[] objArrL = ArraysKt___ArraysJvmKt.l(objArr2, x(objArr2), i13, i13 + 1, size);
        objArrL[size - 1] = null;
        this.f3377g = objArr;
        this.f3378h = objArrL;
        this.f3379i = (i11 + size) - 1;
        this.f3375d = i12;
        return obj2;
    }

    public final Object[] P(Object[] objArr, int i11) {
        if (!((i11 & 31) == 0)) {
            o1.a("invalid size");
        }
        if (i11 == 0) {
            this.f3375d = 0;
            return null;
        }
        int i12 = i11 - 1;
        while (true) {
            int i13 = this.f3375d;
            if ((i12 >> i13) != 0) {
                return B(objArr, i12, i13);
            }
            this.f3375d = i13 - 5;
            Object[] objArr2 = objArr[0];
            Intrinsics.e(objArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr = objArr2;
        }
    }

    public final Object[] R(Object[] objArr, int i11, int i12, E e11, c cVar) {
        int iA = j.a(i12, i11);
        Object[] objArrX = x(objArr);
        if (i11 != 0) {
            Object obj = objArrX[iA];
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrX[iA] = R((Object[]) obj, i11 - 5, i12, e11, cVar);
            return objArrX;
        }
        if (objArrX != objArr) {
            ((AbstractList) this).modCount++;
        }
        cVar.b(objArrX[iA]);
        objArrX[iA] = e11;
        return objArrX;
    }

    public final Object[] S(int i11, int i12, Object[][] objArr, int i13, Object[] objArr2) {
        if (this.f3377g == null) {
            throw new IllegalStateException("root is null".toString());
        }
        ListIterator<Object[]> listIteratorW = w(Q() >> 5);
        while (listIteratorW.previousIndex() != i11) {
            Object[] objArrPrevious = listIteratorW.previous();
            ArraysKt___ArraysJvmKt.l(objArrPrevious, objArr2, 0, 32 - i12, 32);
            objArr2 = y(objArrPrevious, i12);
            i13--;
            objArr[i13] = objArr2;
        }
        return listIteratorW.previous();
    }

    public final void T(Collection<? extends E> collection, int i11, Object[] objArr, int i12, Object[][] objArr2, int i13, Object[] objArr3) {
        Object[] objArrZ;
        if (!(i13 >= 1)) {
            o1.a("requires at least one nullBuffer");
        }
        Object[] objArrX = x(objArr);
        objArr2[0] = objArrX;
        int i14 = i11 & 31;
        int size = ((i11 + collection.size()) - 1) & 31;
        int i15 = (i12 - i14) + size;
        if (i15 < 32) {
            ArraysKt___ArraysJvmKt.l(objArrX, objArr3, size + 1, i14, i12);
        } else {
            int i16 = i15 - 31;
            if (i13 == 1) {
                objArrZ = objArrX;
            } else {
                objArrZ = z();
                i13--;
                objArr2[i13] = objArrZ;
            }
            int i17 = i12 - i16;
            ArraysKt___ArraysJvmKt.l(objArrX, objArr3, 0, i17, i12);
            ArraysKt___ArraysJvmKt.l(objArrX, objArrZ, size + 1, i14, i17);
            objArr3 = objArrZ;
        }
        Iterator<? extends E> it = collection.iterator();
        e(objArrX, i14, it);
        for (int i18 = 1; i18 < i13; i18++) {
            objArr2[i18] = e(z(), 0, it);
        }
        e(objArr3, 0, it);
    }

    public final int U() {
        return V(size());
    }

    public final int V(int i11) {
        return i11 <= 32 ? i11 : i11 - j.d(i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int i11, E e11) {
        v1.d.b(i11, size());
        if (i11 == size()) {
            add(e11);
            return;
        }
        ((AbstractList) this).modCount++;
        int iQ = Q();
        if (i11 >= iQ) {
            u(this.f3377g, i11 - iQ, e11);
            return;
        }
        c cVar = new c(null);
        Object[] objArr = this.f3377g;
        Intrinsics.d(objArr);
        u(s(objArr, this.f3375d, i11, e11, cVar), 0, cVar.a());
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e11) {
        ((AbstractList) this).modCount++;
        int iU = U();
        if (iU < 32) {
            Object[] objArrX = x(this.f3378h);
            objArrX[iU] = e11;
            this.f3378h = objArrX;
            this.f3379i = size() + 1;
        } else {
            G(this.f3377g, this.f3378h, A(e11));
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i11, Collection<? extends E> collection) {
        Object[] objArrL;
        v1.d.b(i11, size());
        if (i11 == size()) {
            return addAll(collection);
        }
        if (collection.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        int i12 = (i11 >> 5) << 5;
        int size = (((size() - i12) + collection.size()) - 1) / 32;
        if (size == 0) {
            v1.a.a(i11 >= Q());
            int i13 = i11 & 31;
            int size2 = ((i11 + collection.size()) - 1) & 31;
            Object[] objArr = this.f3378h;
            Object[] objArrL2 = ArraysKt___ArraysJvmKt.l(objArr, x(objArr), size2 + 1, i13, U());
            e(objArrL2, i13, collection.iterator());
            this.f3378h = objArrL2;
            this.f3379i = size() + collection.size();
            return true;
        }
        Object[][] objArr2 = new Object[size][];
        int iU = U();
        int iV = V(size() + collection.size());
        if (i11 >= Q()) {
            objArrL = z();
            T(collection, i11, this.f3378h, iU, objArr2, size, objArrL);
        } else if (iV > iU) {
            int i14 = iV - iU;
            objArrL = y(this.f3378h, i14);
            r(collection, i11, i14, objArr2, size, objArrL);
        } else {
            int i15 = iU - iV;
            objArrL = ArraysKt___ArraysJvmKt.l(this.f3378h, z(), 0, i15, iU);
            int i16 = 32 - i15;
            Object[] objArrY = y(this.f3378h, i16);
            int i17 = size - 1;
            objArr2[i17] = objArrY;
            r(collection, i11, i16, objArr2, i17, objArrY);
        }
        this.f3377g = F(this.f3377g, i12, objArr2);
        this.f3378h = objArrL;
        this.f3379i = size() + collection.size();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        int iU = U();
        Iterator<? extends E> it = collection.iterator();
        if (32 - iU >= collection.size()) {
            this.f3378h = e(x(this.f3378h), iU, it);
            this.f3379i = size() + collection.size();
        } else {
            int size = ((collection.size() + iU) - 1) / 32;
            Object[][] objArr = new Object[size][];
            objArr[0] = e(x(this.f3378h), iU, it);
            for (int i11 = 1; i11 < size; i11++) {
                objArr[i11] = e(z(), 0, it);
            }
            this.f3377g = F(this.f3377g, Q(), objArr);
            this.f3378h = e(z(), 0, it);
            this.f3379i = size() + collection.size();
        }
        return true;
    }

    @Override // s1.f.a
    public s1.f<E> build() {
        d dVar;
        if (this.f3377g == this.f3373b && this.f3378h == this.f3374c) {
            dVar = this.f3372a;
        } else {
            this.f3376f = new v1.e();
            Object[] objArr = this.f3377g;
            this.f3373b = objArr;
            Object[] objArr2 = this.f3378h;
            this.f3374c = objArr2;
            if (objArr != null) {
                Object[] objArr3 = this.f3377g;
                Intrinsics.d(objArr3);
                dVar = new d(objArr3, this.f3378h, size(), this.f3375d);
            } else if (objArr2.length == 0) {
                dVar = j.b();
            } else {
                Object[] objArrCopyOf = Arrays.copyOf(this.f3378h, size());
                Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
                dVar = new h(objArrCopyOf);
            }
        }
        this.f3372a = dVar;
        return (s1.f<E>) dVar;
    }

    public final Object[] e(Object[] objArr, int i11, Iterator<? extends Object> it) {
        while (i11 < 32 && it.hasNext()) {
            objArr[i11] = it.next();
            i11++;
        }
        return objArr;
    }

    public final int f() {
        return ((AbstractList) this).modCount;
    }

    public final Object[] g() {
        return this.f3377g;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i11) {
        v1.d.a(i11, size());
        return (E) a(i11)[i11 & 31];
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.f3379i;
    }

    public final int i() {
        return this.f3375d;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return listIterator();
    }

    public final Object[] j() {
        return this.f3378h;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int i11) {
        v1.d.b(i11, size());
        return new f(this, i11);
    }

    public final void r(Collection<? extends E> collection, int i11, int i12, Object[][] objArr, int i13, Object[] objArr2) {
        if (this.f3377g == null) {
            throw new IllegalStateException("root is null".toString());
        }
        int i14 = i11 >> 5;
        Object[] objArrS = S(i14, i12, objArr, i13, objArr2);
        int iQ = i13 - (((Q() >> 5) - 1) - i14);
        if (iQ < i13) {
            objArr2 = objArr[iQ];
            Intrinsics.d(objArr2);
        }
        T(collection, i11, objArrS, 32, objArr, iQ, objArr2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(final Collection<? extends Object> collection) {
        return M(new Function1<E, Boolean>() { // from class: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVectorBuilder.removeAll.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(E e11) {
                return Boolean.valueOf(collection.contains(e11));
            }
        });
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int i11) {
        v1.d.a(i11, size());
        ((AbstractList) this).modCount++;
        int iQ = Q();
        if (i11 >= iQ) {
            return (E) O(this.f3377g, iQ, this.f3375d, i11 - iQ);
        }
        c cVar = new c(this.f3378h[0]);
        Object[] objArr = this.f3377g;
        Intrinsics.d(objArr);
        O(N(objArr, this.f3375d, i11, cVar), iQ, this.f3375d, 0);
        return (E) cVar.a();
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int i11, E e11) {
        v1.d.a(i11, size());
        if (Q() > i11) {
            c cVar = new c(null);
            Object[] objArr = this.f3377g;
            Intrinsics.d(objArr);
            this.f3377g = R(objArr, this.f3375d, i11, e11, cVar);
            return (E) cVar.a();
        }
        Object[] objArrX = x(this.f3378h);
        if (objArrX != this.f3378h) {
            ((AbstractList) this).modCount++;
        }
        int i12 = i11 & 31;
        E e12 = (E) objArrX[i12];
        objArrX[i12] = e11;
        this.f3378h = objArrX;
        return e12;
    }

    public final void u(Object[] objArr, int i11, E e11) {
        int iU = U();
        Object[] objArrX = x(this.f3378h);
        if (iU < 32) {
            ArraysKt___ArraysJvmKt.l(this.f3378h, objArrX, i11 + 1, i11, iU);
            objArrX[i11] = e11;
            this.f3377g = objArr;
            this.f3378h = objArrX;
            this.f3379i = size() + 1;
            return;
        }
        Object[] objArr2 = this.f3378h;
        Object obj = objArr2[31];
        ArraysKt___ArraysJvmKt.l(objArr2, objArrX, i11 + 1, i11, 31);
        objArrX[i11] = e11;
        G(objArr, objArrX, A(obj));
    }

    public final boolean v(Object[] objArr) {
        return objArr.length == 33 && objArr[32] == this.f3376f;
    }

    public final ListIterator<Object[]> w(int i11) {
        Object[] objArr = this.f3377g;
        if (objArr == null) {
            throw new IllegalStateException("Invalid root".toString());
        }
        int iQ = Q() >> 5;
        v1.d.b(i11, iQ);
        int i12 = this.f3375d;
        return i12 == 0 ? new g(objArr, i11) : new i(objArr, i11, iQ, i12 / 5);
    }

    public final Object[] x(Object[] objArr) {
        if (objArr == null) {
            return z();
        }
        return v(objArr) ? objArr : ArraysKt___ArraysJvmKt.p(objArr, z(), 0, 0, kotlin.ranges.a.g(objArr.length, 32), 6, null);
    }

    public final Object[] y(Object[] objArr, int i11) {
        return v(objArr) ? ArraysKt___ArraysJvmKt.l(objArr, objArr, i11, 0, 32 - i11) : ArraysKt___ArraysJvmKt.l(objArr, z(), i11, 0, 32 - i11);
    }

    public final Object[] z() {
        Object[] objArr = new Object[33];
        objArr[32] = this.f3376f;
        return objArr;
    }
}
