package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.o1;
import java.util.Arrays;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class d<E> extends AbstractPersistentList<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f3384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f3385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3387d;

    public d(Object[] objArr, Object[] objArr2, int i11, int i12) {
        this.f3384a = objArr;
        this.f3385b = objArr2;
        this.f3386c = i11;
        this.f3387d = i12;
        if (!(size() > 32)) {
            o1.a("Trie-based persistent vector should have at least 33 elements, got " + size());
        }
        v1.a.a(size() - j.d(size()) <= kotlin.ranges.a.g(objArr2.length, 32));
    }

    @Override // java.util.List, s1.f
    public s1.f<E> add(int i11, E e11) {
        v1.d.b(i11, size());
        if (i11 == size()) {
            return add((Object) e11);
        }
        int iX = x();
        if (i11 >= iX) {
            return i(this.f3384a, i11 - iX, e11);
        }
        c cVar = new c(null);
        return i(g(this.f3384a, this.f3387d, i11, e11, cVar), 0, cVar.a());
    }

    @Override // java.util.Collection, java.util.List, s1.f
    public s1.f<E> add(E e11) {
        int size = size() - x();
        if (size >= 32) {
            return s(this.f3384a, this.f3385b, j.c(e11));
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.f3385b, 32);
        Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
        objArrCopyOf[size] = e11;
        return new d(this.f3384a, objArrCopyOf, size() + 1, this.f3387d);
    }

    public final Object[] e(int i11) {
        if (x() <= i11) {
            return this.f3385b;
        }
        Object[] objArr = this.f3384a;
        for (int i12 = this.f3387d; i12 > 0; i12 -= 5) {
            Object[] objArr2 = objArr[j.a(i11, i12)];
            Intrinsics.e(objArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr = objArr2;
        }
        return objArr;
    }

    @Override // s1.f
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public PersistentVectorBuilder<E> builder() {
        return new PersistentVectorBuilder<>(this, this.f3384a, this.f3385b, this.f3387d);
    }

    public final Object[] g(Object[] objArr, int i11, int i12, Object obj, c cVar) {
        Object[] objArrCopyOf;
        int iA = j.a(i12, i11);
        if (i11 == 0) {
            if (iA == 0) {
                objArrCopyOf = new Object[32];
            } else {
                objArrCopyOf = Arrays.copyOf(objArr, 32);
                Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
            }
            ArraysKt___ArraysJvmKt.l(objArr, objArrCopyOf, iA + 1, iA, 31);
            cVar.b(objArr[31]);
            objArrCopyOf[iA] = obj;
            return objArrCopyOf;
        }
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr, 32);
        Intrinsics.f(objArrCopyOf2, "copyOf(this, newSize)");
        int i13 = i11 - 5;
        Object obj2 = objArr[iA];
        String str = "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>";
        Intrinsics.e(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objArrCopyOf2[iA] = g((Object[]) obj2, i13, i12, obj, cVar);
        int i14 = iA + 1;
        while (i14 < 32 && objArrCopyOf2[i14] != null) {
            Object obj3 = objArr[i14];
            Intrinsics.e(obj3, str);
            Object[] objArr2 = objArrCopyOf2;
            objArr2[i14] = g((Object[]) obj3, i13, 0, cVar.a(), cVar);
            i14++;
            objArrCopyOf2 = objArr2;
            str = str;
        }
        return objArrCopyOf2;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public E get(int i11) {
        v1.d.a(i11, size());
        return (E) e(i11)[i11 & 31];
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f3386c;
    }

    @Override // s1.f
    public s1.f<E> h(int i11) {
        v1.d.a(i11, size());
        int iX = x();
        return i11 >= iX ? w(this.f3384a, iX, this.f3387d, i11 - iX) : w(v(this.f3384a, this.f3387d, i11, new c(this.f3385b[0])), iX, this.f3387d, 0);
    }

    public final d<E> i(Object[] objArr, int i11, Object obj) {
        int size = size() - x();
        Object[] objArrCopyOf = Arrays.copyOf(this.f3385b, 32);
        Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
        if (size < 32) {
            ArraysKt___ArraysJvmKt.l(this.f3385b, objArrCopyOf, i11 + 1, i11, size);
            objArrCopyOf[i11] = obj;
            return new d<>(objArr, objArrCopyOf, size() + 1, this.f3387d);
        }
        Object[] objArr2 = this.f3385b;
        Object obj2 = objArr2[31];
        ArraysKt___ArraysJvmKt.l(objArr2, objArrCopyOf, i11 + 1, i11, size - 1);
        objArrCopyOf[i11] = obj;
        return s(objArr, objArrCopyOf, j.c(obj2));
    }

    public final Object[] j(Object[] objArr, int i11, int i12, c cVar) {
        Object[] objArrJ;
        int iA = j.a(i12, i11);
        if (i11 == 5) {
            cVar.b(objArr[iA]);
            objArrJ = null;
        } else {
            Object obj = objArr[iA];
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrJ = j((Object[]) obj, i11 - 5, i12, cVar);
        }
        if (objArrJ == null && iA == 0) {
            return null;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, 32);
        Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
        objArrCopyOf[iA] = objArrJ;
        return objArrCopyOf;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ListIterator<E> listIterator(int i11) {
        v1.d.b(i11, size());
        return new e(this.f3384a, this.f3385b, i11, size(), (this.f3387d / 5) + 1);
    }

    @Override // s1.f
    public s1.f<E> p(Function1<? super E, Boolean> function1) {
        PersistentVectorBuilder<E> persistentVectorBuilderBuilder = builder();
        persistentVectorBuilderBuilder.M(function1);
        return persistentVectorBuilderBuilder.build();
    }

    public final s1.f<E> r(Object[] objArr, int i11, int i12) {
        if (i12 == 0) {
            if (objArr.length == 33) {
                objArr = Arrays.copyOf(objArr, 32);
                Intrinsics.f(objArr, "copyOf(this, newSize)");
            }
            return new h(objArr);
        }
        c cVar = new c(null);
        Object[] objArrJ = j(objArr, i12, i11 - 1, cVar);
        Intrinsics.d(objArrJ);
        Object objA = cVar.a();
        Intrinsics.e(objA, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr2 = (Object[]) objA;
        if (objArrJ[1] != null) {
            return new d(objArrJ, objArr2, i11, i12);
        }
        Object obj = objArrJ[0];
        Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        return new d((Object[]) obj, objArr2, i11, i12 - 5);
    }

    public final d<E> s(Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int size = size() >> 5;
        int i11 = this.f3387d;
        if (size <= (1 << i11)) {
            return new d<>(u(objArr, i11, objArr2), objArr3, size() + 1, this.f3387d);
        }
        Object[] objArrC = j.c(objArr);
        int i12 = this.f3387d + 5;
        return new d<>(u(objArrC, i12, objArr2), objArr3, size() + 1, i12);
    }

    @Override // kotlin.collections.AbstractList, java.util.List, s1.f
    public s1.f<E> set(int i11, E e11) {
        v1.d.a(i11, size());
        if (x() > i11) {
            return new d(y(this.f3384a, this.f3387d, i11, e11), this.f3385b, size(), this.f3387d);
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.f3385b, 32);
        Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
        objArrCopyOf[i11 & 31] = e11;
        return new d(this.f3384a, objArrCopyOf, size(), this.f3387d);
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0019  */
    public final Object[] u(Object[] objArr, int i11, Object[] objArr2) {
        Object[] objArrCopyOf;
        int iA = j.a(size() - 1, i11);
        if (objArr != null) {
            objArrCopyOf = Arrays.copyOf(objArr, 32);
            Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
            if (objArrCopyOf == null) {
                objArrCopyOf = new Object[32];
            }
        } else {
            objArrCopyOf = new Object[32];
        }
        if (i11 == 5) {
            objArrCopyOf[iA] = objArr2;
        } else {
            objArrCopyOf[iA] = u((Object[]) objArrCopyOf[iA], i11 - 5, objArr2);
        }
        return objArrCopyOf;
    }

    public final Object[] v(Object[] objArr, int i11, int i12, c cVar) {
        Object[] objArrCopyOf;
        int iA = j.a(i12, i11);
        if (i11 == 0) {
            if (iA == 0) {
                objArrCopyOf = new Object[32];
            } else {
                objArrCopyOf = Arrays.copyOf(objArr, 32);
                Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
            }
            ArraysKt___ArraysJvmKt.l(objArr, objArrCopyOf, iA, iA + 1, 32);
            objArrCopyOf[31] = cVar.a();
            cVar.b(objArr[iA]);
            return objArrCopyOf;
        }
        int iA2 = objArr[31] == null ? j.a(x() - 1, i11) : 31;
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr, 32);
        Intrinsics.f(objArrCopyOf2, "copyOf(this, newSize)");
        int i13 = i11 - 5;
        int i14 = iA + 1;
        if (i14 <= iA2) {
            while (true) {
                Object obj = objArrCopyOf2[iA2];
                Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                objArrCopyOf2[iA2] = v((Object[]) obj, i13, 0, cVar);
                if (iA2 == i14) {
                    break;
                }
                iA2--;
            }
        }
        Object obj2 = objArrCopyOf2[iA];
        Intrinsics.e(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objArrCopyOf2[iA] = v((Object[]) obj2, i13, i12, cVar);
        return objArrCopyOf2;
    }

    public final s1.f<E> w(Object[] objArr, int i11, int i12, int i13) {
        int size = size() - i11;
        v1.a.a(i13 < size);
        if (size == 1) {
            return r(objArr, i11, i12);
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.f3385b, 32);
        Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
        int i14 = size - 1;
        if (i13 < i14) {
            ArraysKt___ArraysJvmKt.l(this.f3385b, objArrCopyOf, i13, i13 + 1, size);
        }
        objArrCopyOf[i14] = null;
        return new d(objArr, objArrCopyOf, (i11 + size) - 1, i12);
    }

    public final int x() {
        return j.d(size());
    }

    public final Object[] y(Object[] objArr, int i11, int i12, Object obj) {
        int iA = j.a(i12, i11);
        Object[] objArrCopyOf = Arrays.copyOf(objArr, 32);
        Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
        if (i11 == 0) {
            objArrCopyOf[iA] = obj;
        } else {
            Object obj2 = objArrCopyOf[iA];
            Intrinsics.e(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrCopyOf[iA] = y((Object[]) obj2, i11 - 5, i12, obj);
        }
        return objArrCopyOf;
    }
}
