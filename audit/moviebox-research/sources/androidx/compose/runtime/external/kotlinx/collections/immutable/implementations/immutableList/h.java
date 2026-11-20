package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class h<E> extends AbstractPersistentList<E> implements s1.d<E> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3395b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f3396c = 8;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f3397d = new h(new Object[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f3398a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final h a() {
            return h.f3397d;
        }
    }

    public h(Object[] objArr) {
        this.f3398a = objArr;
        v1.a.a(objArr.length <= 32);
    }

    @Override // java.util.List, s1.f
    public s1.f<E> add(int i11, E e11) {
        v1.d.b(i11, size());
        if (i11 == size()) {
            return add((Object) e11);
        }
        if (size() < 32) {
            Object[] objArrF = f(size() + 1);
            ArraysKt___ArraysJvmKt.p(this.f3398a, objArrF, 0, 0, i11, 6, null);
            ArraysKt___ArraysJvmKt.l(this.f3398a, objArrF, i11 + 1, i11, size());
            objArrF[i11] = e11;
            return new h(objArrF);
        }
        Object[] objArr = this.f3398a;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.f(objArrCopyOf, "copyOf(this, size)");
        ArraysKt___ArraysJvmKt.l(this.f3398a, objArrCopyOf, i11 + 1, i11, size() - 1);
        objArrCopyOf[i11] = e11;
        return new d(objArrCopyOf, j.c(this.f3398a[31]), size() + 1, 0);
    }

    @Override // java.util.Collection, java.util.List, s1.f
    public s1.f<E> add(E e11) {
        if (size() >= 32) {
            return new d(this.f3398a, j.c(e11), size() + 1, 0);
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.f3398a, size() + 1);
        Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
        objArrCopyOf[size()] = e11;
        return new h(objArrCopyOf);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList, java.util.Collection, java.util.List, s1.f
    public s1.f<E> addAll(Collection<? extends E> collection) {
        if (size() + collection.size() > 32) {
            s1.f.a<E> aVarBuilder = builder();
            aVarBuilder.addAll(collection);
            return aVarBuilder.build();
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.f3398a, size() + collection.size());
        Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
        int size = size();
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            objArrCopyOf[size] = it.next();
            size++;
        }
        return new h(objArrCopyOf);
    }

    @Override // s1.f
    public s1.f.a<E> builder() {
        return new PersistentVectorBuilder(this, null, this.f3398a, 0);
    }

    public final Object[] f(int i11) {
        return new Object[i11];
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public E get(int i11) {
        v1.d.a(i11, size());
        return (E) this.f3398a[i11];
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f3398a.length;
    }

    @Override // s1.f
    public s1.f<E> h(int i11) {
        v1.d.a(i11, size());
        if (size() == 1) {
            return f3397d;
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.f3398a, size() - 1);
        Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
        ArraysKt___ArraysJvmKt.l(this.f3398a, objArrCopyOf, i11, i11 + 1, size());
        return new h(objArrCopyOf);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public int indexOf(Object obj) {
        return kotlin.collections.d.a0(this.f3398a, obj);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        return kotlin.collections.d.o0(this.f3398a, obj);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ListIterator<E> listIterator(int i11) {
        v1.d.b(i11, size());
        return new b(this.f3398a, i11, size());
    }

    @Override // s1.f
    public s1.f<E> p(Function1<? super E, Boolean> function1) {
        Object[] objArrCopyOf = this.f3398a;
        int size = size();
        int size2 = size();
        boolean z11 = false;
        for (int i11 = 0; i11 < size2; i11++) {
            Object obj = this.f3398a[i11];
            if (function1.invoke(obj).booleanValue()) {
                if (!z11) {
                    Object[] objArr = this.f3398a;
                    objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
                    Intrinsics.f(objArrCopyOf, "copyOf(this, size)");
                    z11 = true;
                    size = i11;
                }
            } else if (z11) {
                objArrCopyOf[size] = obj;
                size++;
            }
        }
        if (size == size()) {
            return this;
        }
        return size == 0 ? f3397d : new h(ArraysKt___ArraysJvmKt.r(objArrCopyOf, 0, size));
    }

    @Override // kotlin.collections.AbstractList, java.util.List, s1.f
    public s1.f<E> set(int i11, E e11) {
        v1.d.a(i11, size());
        Object[] objArr = this.f3398a;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.f(objArrCopyOf, "copyOf(this, size)");
        objArrCopyOf[i11] = e11;
        return new h(objArrCopyOf);
    }
}
