package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.Metadata;
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
@Metadata
@SourceDebugExtension
public final class RingBuffer<T> extends AbstractList<T> implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f68776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f68777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f68778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f68779d;

    public RingBuffer(int i11) {
        this(new Object[i11], 0);
    }

    public RingBuffer(Object[] buffer, int i11) {
        Intrinsics.g(buffer, "buffer");
        this.f68776a = buffer;
        if (i11 < 0) {
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i11).toString());
        }
        if (i11 <= buffer.length) {
            this.f68777b = buffer.length;
            this.f68779d = i11;
            return;
        }
        throw new IllegalArgumentException(("ring buffer filled size: " + i11 + " cannot be larger than the buffer size: " + buffer.length).toString());
    }

    @Override // java.util.Collection, java.util.List
    public final void add(T t11) {
        if (i()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.f68776a[(this.f68778c + size()) % this.f68777b] = t11;
        this.f68779d = size() + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final RingBuffer<T> g(int i11) {
        Object[] array;
        int i12 = this.f68777b;
        int iG = kotlin.ranges.a.g(i12 + (i12 >> 1) + 1, i11);
        if (this.f68778c == 0) {
            array = Arrays.copyOf(this.f68776a, iG);
            Intrinsics.f(array, "copyOf(...)");
        } else {
            array = toArray(new Object[iG]);
        }
        return new RingBuffer<>(array, size());
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public T get(int i11) {
        AbstractList.Companion.b(i11, size());
        return (T) this.f68776a[(this.f68778c + i11) % this.f68777b];
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f68779d;
    }

    public final boolean i() {
        return size() == this.f68777b;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<T> iterator() {
        return new AbstractIterator<T>(this) { // from class: kotlin.collections.RingBuffer.iterator.1

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f68780c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f68781d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ RingBuffer<T> f68782f;

            {
                this.f68782f = this;
                this.f68780c = this.size();
                this.f68781d = this.f68778c;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.collections.AbstractIterator
            public void a() {
                if (this.f68780c == 0) {
                    c();
                    return;
                }
                d(this.f68782f.f68776a[this.f68781d]);
                this.f68781d = (this.f68781d + 1) % this.f68782f.f68777b;
                this.f68780c--;
            }
        };
    }

    public final void j(int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i11).toString());
        }
        if (i11 > size()) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i11 + ", size = " + size()).toString());
        }
        if (i11 > 0) {
            int i12 = this.f68778c;
            int i13 = (i12 + i11) % this.f68777b;
            if (i12 > i13) {
                ArraysKt___ArraysJvmKt.u(this.f68776a, null, i12, this.f68777b);
                ArraysKt___ArraysJvmKt.u(this.f68776a, null, 0, i13);
            } else {
                ArraysKt___ArraysJvmKt.u(this.f68776a, null, i12, i13);
            }
            this.f68778c = i13;
            this.f68779d = size() - i11;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.g(array, "array");
        int length = array.length;
        Object[] objArr = array;
        if (length < size()) {
            Object[] objArr2 = (T[]) Arrays.copyOf(array, size());
            Intrinsics.f(objArr2, "copyOf(...)");
            objArr = objArr2;
        }
        int size = size();
        int i11 = 0;
        int i12 = 0;
        for (int i13 = this.f68778c; i12 < size && i13 < this.f68777b; i13++) {
            objArr[i12] = this.f68776a[i13];
            i12++;
        }
        while (i12 < size) {
            objArr[i12] = this.f68776a[i11];
            i12++;
            i11++;
        }
        return (T[]) f.g(size, objArr);
    }
}
