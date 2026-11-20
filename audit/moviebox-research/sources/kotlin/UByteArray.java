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
public final class UByteArray implements Collection<UByte>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f68691a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Iterator<UByte>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f68692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f68693b;

        public a(byte[] array) {
            Intrinsics.g(array, "array");
            this.f68692a = array;
        }

        public byte a() {
            int i11 = this.f68693b;
            byte[] bArr = this.f68692a;
            if (i11 >= bArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f68693b));
            }
            this.f68693b = i11 + 1;
            return UByte.b(bArr[i11]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f68693b < this.f68692a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ UByte next() {
            return UByte.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @PublishedApi
    public /* synthetic */ UByteArray(byte[] bArr) {
        this.f68691a = bArr;
    }

    public static final /* synthetic */ UByteArray a(byte[] bArr) {
        return new UByteArray(bArr);
    }

    public static boolean f(byte[] bArr, byte b11) {
        return d.E(bArr, b11);
    }

    public static boolean g(byte[] bArr, Collection<UByte> elements) {
        Intrinsics.g(elements, "elements");
        Collection<UByte> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!(obj instanceof UByte) || !d.E(bArr, ((UByte) obj).h())) {
                return false;
            }
        }
        return true;
    }

    public static boolean i(byte[] bArr, Object obj) {
        return (obj instanceof UByteArray) && Intrinsics.b(bArr, ((UByteArray) obj).y());
    }

    public static final byte j(byte[] bArr, int i11) {
        return UByte.b(bArr[i11]);
    }

    public static int s(byte[] bArr) {
        return bArr.length;
    }

    public static int u(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    public static boolean v(byte[] bArr) {
        return bArr.length == 0;
    }

    public static Iterator<UByte> w(byte[] bArr) {
        return new a(bArr);
    }

    public static String x(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(UByte uByte) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UByte> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UByte) {
            return e(((UByte) obj).h());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.g(elements, "elements");
        return g(this.f68691a, elements);
    }

    public boolean e(byte b11) {
        return f(this.f68691a, b11);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return i(this.f68691a, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return u(this.f68691a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return v(this.f68691a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<UByte> iterator() {
        return w(this.f68691a);
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public int size() {
        return s(this.f68691a);
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
        return x(this.f68691a);
    }

    public final /* synthetic */ byte[] y() {
        return this.f68691a;
    }
}
