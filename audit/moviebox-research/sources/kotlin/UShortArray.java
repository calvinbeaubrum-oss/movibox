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
public final class UShortArray implements Collection<UShort>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final short[] f68707a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Iterator<UShort>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final short[] f68708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f68709b;

        public a(short[] array) {
            Intrinsics.g(array, "array");
            this.f68708a = array;
        }

        public short a() {
            int i11 = this.f68709b;
            short[] sArr = this.f68708a;
            if (i11 >= sArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f68709b));
            }
            this.f68709b = i11 + 1;
            return UShort.b(sArr[i11]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f68709b < this.f68708a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ UShort next() {
            return UShort.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @PublishedApi
    public /* synthetic */ UShortArray(short[] sArr) {
        this.f68707a = sArr;
    }

    public static final /* synthetic */ UShortArray a(short[] sArr) {
        return new UShortArray(sArr);
    }

    public static boolean f(short[] sArr, short s11) {
        return d.J(sArr, s11);
    }

    public static boolean g(short[] sArr, Collection<UShort> elements) {
        Intrinsics.g(elements, "elements");
        Collection<UShort> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!(obj instanceof UShort) || !d.J(sArr, ((UShort) obj).h())) {
                return false;
            }
        }
        return true;
    }

    public static boolean i(short[] sArr, Object obj) {
        return (obj instanceof UShortArray) && Intrinsics.b(sArr, ((UShortArray) obj).y());
    }

    public static final short j(short[] sArr, int i11) {
        return UShort.b(sArr[i11]);
    }

    public static int s(short[] sArr) {
        return sArr.length;
    }

    public static int u(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    public static boolean v(short[] sArr) {
        return sArr.length == 0;
    }

    public static Iterator<UShort> w(short[] sArr) {
        return new a(sArr);
    }

    public static String x(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(UShort uShort) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UShort> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UShort) {
            return e(((UShort) obj).h());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.g(elements, "elements");
        return g(this.f68707a, elements);
    }

    public boolean e(short s11) {
        return f(this.f68707a, s11);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return i(this.f68707a, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return u(this.f68707a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return v(this.f68707a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<UShort> iterator() {
        return w(this.f68707a);
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public int size() {
        return s(this.f68707a);
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
        return x(this.f68707a);
    }

    public final /* synthetic */ short[] y() {
        return this.f68707a;
    }
}
