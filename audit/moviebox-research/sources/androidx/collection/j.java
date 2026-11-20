package androidx.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableIterator;

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
public abstract class j<T> implements Iterator<T>, KMutableIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1935c;

    public j(int i11) {
        this.f1933a = i11;
    }

    public abstract T a(int i11);

    public abstract void c(int i11);

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f1934b < this.f1933a;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T tA = a(this.f1934b);
        this.f1934b++;
        this.f1935c = true;
        return tA;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.f1935c) {
            m1.d.b("Call next() before removing an element.");
        }
        int i11 = this.f1934b - 1;
        this.f1934b = i11;
        c(i11);
        this.f1933a--;
        this.f1935c = false;
    }
}
