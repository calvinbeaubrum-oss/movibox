package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.collections.d;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;

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
@ExperimentalUnsignedTypes
@JvmInline
@SourceDebugExtension
public final class UIntArray implements Collection<UInt>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f68696a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Iterator<UInt>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f68697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f68698b;

        public a(int[] array) {
            Intrinsics.g(array, "array");
            this.f68697a = array;
        }

        public int a() {
            int i11 = this.f68698b;
            int[] iArr = this.f68697a;
            if (i11 >= iArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f68698b));
            }
            this.f68698b = i11 + 1;
            return UInt.b(iArr[i11]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f68698b < this.f68697a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ UInt next() {
            return UInt.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @PublishedApi
    public /* synthetic */ UIntArray(int[] iArr) {
        this.f68696a = iArr;
    }

    public static final /* synthetic */ UIntArray a(int[] iArr) {
        return new UIntArray(iArr);
    }

    public static boolean f(int[] iArr, int i11) {
        return d.G(iArr, i11);
    }

    public static boolean g(int[] iArr, Collection<UInt> elements) {
        Intrinsics.g(elements, "elements");
        Collection<UInt> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!(obj instanceof UInt) || !d.G(iArr, ((UInt) obj).h())) {
                return false;
            }
        }
        return true;
    }

    public static boolean i(int[] iArr, Object obj) {
        return (obj instanceof UIntArray) && Intrinsics.b(iArr, ((UIntArray) obj).y());
    }

    public static final int j(int[] iArr, int i11) {
        return UInt.b(iArr[i11]);
    }

    public static int s(int[] iArr) {
        return iArr.length;
    }

    public static int u(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public static boolean v(int[] iArr) {
        return iArr.length == 0;
    }

    public static Iterator<UInt> w(int[] iArr) {
        return new a(iArr);
    }

    public static String x(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(UInt uInt) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UInt> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UInt) {
            return e(((UInt) obj).h());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.g(elements, "elements");
        return g(this.f68696a, elements);
    }

    public boolean e(int i11) {
        return f(this.f68696a, i11);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return i(this.f68696a, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return u(this.f68696a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return v(this.f68696a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<UInt> iterator() {
        return w(this.f68696a);
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public int size() {
        return s(this.f68696a);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.g(array, "array");
        return (T[]) CollectionToArray.b(this, array);
    }

    public String toString() {
        return x(this.f68696a);
    }

    public final /* synthetic */ int[] y() {
        return this.f68696a;
    }
}
