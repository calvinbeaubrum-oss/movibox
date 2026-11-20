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
public final class ULongArray implements Collection<ULong>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[] f68701a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Iterator<ULong>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f68702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f68703b;

        public a(long[] array) {
            Intrinsics.g(array, "array");
            this.f68702a = array;
        }

        public long a() {
            int i11 = this.f68703b;
            long[] jArr = this.f68702a;
            if (i11 >= jArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f68703b));
            }
            this.f68703b = i11 + 1;
            return ULong.b(jArr[i11]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f68703b < this.f68702a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ ULong next() {
            return ULong.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @PublishedApi
    public /* synthetic */ ULongArray(long[] jArr) {
        this.f68701a = jArr;
    }

    public static final /* synthetic */ ULongArray a(long[] jArr) {
        return new ULongArray(jArr);
    }

    public static boolean f(long[] jArr, long j11) {
        return d.H(jArr, j11);
    }

    public static boolean g(long[] jArr, Collection<ULong> elements) {
        Intrinsics.g(elements, "elements");
        Collection<ULong> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!(obj instanceof ULong) || !d.H(jArr, ((ULong) obj).i())) {
                return false;
            }
        }
        return true;
    }

    public static boolean i(long[] jArr, Object obj) {
        return (obj instanceof ULongArray) && Intrinsics.b(jArr, ((ULongArray) obj).y());
    }

    public static final long j(long[] jArr, int i11) {
        return ULong.b(jArr[i11]);
    }

    public static int s(long[] jArr) {
        return jArr.length;
    }

    public static int u(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    public static boolean v(long[] jArr) {
        return jArr.length == 0;
    }

    public static Iterator<ULong> w(long[] jArr) {
        return new a(jArr);
    }

    public static String x(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(ULong uLong) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends ULong> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ULong) {
            return e(((ULong) obj).i());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.g(elements, "elements");
        return g(this.f68701a, elements);
    }

    public boolean e(long j11) {
        return f(this.f68701a, j11);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return i(this.f68701a, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return u(this.f68701a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return v(this.f68701a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<ULong> iterator() {
        return w(this.f68701a);
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public int size() {
        return s(this.f68701a);
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
        return x(this.f68701a);
    }

    public final /* synthetic */ long[] y() {
        return this.f68701a;
    }
}
