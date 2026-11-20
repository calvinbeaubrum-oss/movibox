package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

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
public abstract class a<E> implements ListIterator<E>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3381b;

    public a(int i11, int i12) {
        this.f3380a = i11;
        this.f3381b = i12;
    }

    public final void a() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    }

    @Override // java.util.ListIterator
    public void add(E e11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void c() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
    }

    public final int d() {
        return this.f3380a;
    }

    public final int f() {
        return this.f3381b;
    }

    public final void g(int i11) {
        this.f3380a = i11;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.f3380a < this.f3381b;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.f3380a > 0;
    }

    public final void i(int i11) {
        this.f3381b = i11;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.f3380a;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.f3380a - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public void set(E e11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
