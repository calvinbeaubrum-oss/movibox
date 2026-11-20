package androidx.collection;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.jvm.internal.markers.KMutableSet;

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
public final class b<E> implements Collection<E>, Set<E>, KMutableCollection, KMutableSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f1912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f1913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1914c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class a extends j<E> {
        public a() {
            super(b.this.i());
        }

        @Override // androidx.collection.j
        public E a(int i11) {
            return b.this.v(i11);
        }

        @Override // androidx.collection.j
        public void c(int i11) {
            b.this.j(i11);
        }
    }

    @JvmOverloads
    public b() {
        this(0, 1, null);
    }

    @JvmOverloads
    public b(int i11) {
        this.f1912a = m1.a.f70585a;
        this.f1913b = m1.a.f70587c;
        if (i11 > 0) {
            d.a(this, i11);
        }
    }

    public /* synthetic */ b(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i11);
    }

    public final void a(int i11) {
        int i12 = i();
        if (f().length < i11) {
            int[] iArrF = f();
            Object[] objArrE = e();
            d.a(this, i11);
            if (i() > 0) {
                ArraysKt___ArraysJvmKt.o(iArrF, f(), 0, 0, i(), 6, null);
                ArraysKt___ArraysJvmKt.p(objArrE, e(), 0, 0, i(), 6, null);
            }
        }
        if (i() != i12) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e11) {
        int i11;
        int iC;
        int i12 = i();
        if (e11 == null) {
            iC = d.d(this);
            i11 = 0;
        } else {
            int iHashCode = e11.hashCode();
            i11 = iHashCode;
            iC = d.c(this, e11, iHashCode);
        }
        if (iC >= 0) {
            return false;
        }
        int i13 = ~iC;
        if (i12 >= f().length) {
            int i14 = 8;
            if (i12 >= 8) {
                i14 = (i12 >> 1) + i12;
            } else if (i12 < 4) {
                i14 = 4;
            }
            int[] iArrF = f();
            Object[] objArrE = e();
            d.a(this, i14);
            if (i12 != i()) {
                throw new ConcurrentModificationException();
            }
            if (!(f().length == 0)) {
                ArraysKt___ArraysJvmKt.o(iArrF, f(), 0, 0, iArrF.length, 6, null);
                ArraysKt___ArraysJvmKt.p(objArrE, e(), 0, 0, objArrE.length, 6, null);
            }
        }
        if (i13 < i12) {
            int i15 = i13 + 1;
            ArraysKt___ArraysJvmKt.j(f(), f(), i15, i13, i12);
            ArraysKt___ArraysJvmKt.l(e(), e(), i15, i13, i12);
        }
        if (i12 != i() || i13 >= f().length) {
            throw new ConcurrentModificationException();
        }
        f()[i13] = i11;
        e()[i13] = e11;
        u(i() + 1);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.g(elements, "elements");
        a(i() + elements.size());
        Iterator<? extends E> it = elements.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        if (i() != 0) {
            s(m1.a.f70585a);
            r(m1.a.f70587c);
            u(0);
        }
        if (i() != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.g(elements, "elements");
        Iterator<? extends Object> it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final Object[] e() {
        return this.f1913b;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Set) && size() == ((Set) obj).size()) {
            try {
                int i11 = i();
                for (int i12 = 0; i12 < i11; i12++) {
                    if (((Set) obj).contains(v(i12))) {
                    }
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public final int[] f() {
        return this.f1912a;
    }

    public int g() {
        return this.f1914c;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArrF = f();
        int i11 = i();
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            i12 += iArrF[i13];
        }
        return i12;
    }

    public final int i() {
        return this.f1914c;
    }

    public final int indexOf(Object obj) {
        return obj == null ? d.d(this) : d.c(this, obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return i() <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new a();
    }

    public final E j(int i11) {
        int i12 = i();
        E e11 = (E) e()[i11];
        if (i12 <= 1) {
            clear();
        } else {
            int i13 = i12 - 1;
            if (f().length <= 8 || i() >= f().length / 3) {
                if (i11 < i13) {
                    int i14 = i11 + 1;
                    ArraysKt___ArraysJvmKt.j(f(), f(), i11, i14, i12);
                    ArraysKt___ArraysJvmKt.l(e(), e(), i11, i14, i12);
                }
                e()[i13] = null;
            } else {
                int i15 = i() > 8 ? i() + (i() >> 1) : 8;
                int[] iArrF = f();
                Object[] objArrE = e();
                d.a(this, i15);
                if (i11 > 0) {
                    ArraysKt___ArraysJvmKt.o(iArrF, f(), 0, 0, i11, 6, null);
                    ArraysKt___ArraysJvmKt.p(objArrE, e(), 0, 0, i11, 6, null);
                }
                if (i11 < i13) {
                    int i16 = i11 + 1;
                    ArraysKt___ArraysJvmKt.j(iArrF, f(), i11, i16, i12);
                    ArraysKt___ArraysJvmKt.l(objArrE, e(), i11, i16, i12);
                }
            }
            if (i12 != i()) {
                throw new ConcurrentModificationException();
            }
            u(i13);
        }
        return e11;
    }

    public final void r(Object[] objArr) {
        Intrinsics.g(objArr, "<set-?>");
        this.f1913b = objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        j(iIndexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.g(elements, "elements");
        Iterator<? extends Object> it = elements.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics.g(elements, "elements");
        boolean z11 = false;
        for (int i11 = i() - 1; -1 < i11; i11--) {
            if (!CollectionsKt___CollectionsKt.X(elements, e()[i11])) {
                j(i11);
                z11 = true;
            }
        }
        return z11;
    }

    public final void s(int[] iArr) {
        Intrinsics.g(iArr, "<set-?>");
        this.f1912a = iArr;
    }

    @Override // java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return g();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return ArraysKt___ArraysJvmKt.r(this.f1913b, 0, this.f1914c);
    }

    @Override // java.util.Collection, java.util.Set
    public final <T> T[] toArray(T[] array) {
        Intrinsics.g(array, "array");
        T[] result = (T[]) c.a(array, this.f1914c);
        ArraysKt___ArraysJvmKt.l(this.f1913b, result, 0, 0, this.f1914c);
        Intrinsics.f(result, "result");
        return result;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(i() * 14);
        sb2.append('{');
        int i11 = i();
        for (int i12 = 0; i12 < i11; i12++) {
            if (i12 > 0) {
                sb2.append(", ");
            }
            E eV = v(i12);
            if (eV != this) {
                sb2.append(eV);
            } else {
                sb2.append("(this Set)");
            }
        }
        sb2.append('}');
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public final void u(int i11) {
        this.f1914c = i11;
    }

    public final E v(int i11) {
        return (E) e()[i11];
    }
}
