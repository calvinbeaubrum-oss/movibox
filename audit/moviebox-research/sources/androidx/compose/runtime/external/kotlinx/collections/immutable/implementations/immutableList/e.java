package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import kotlin.Metadata;

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
public final class e<T> extends a<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T[] f3388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i<T> f3389d;

    public e(Object[] objArr, T[] tArr, int i11, int i12, int i13) {
        super(i11, i12);
        this.f3388c = tArr;
        int iD = j.d(i12);
        this.f3389d = new i<>(objArr, kotlin.ranges.a.g(i11, iD), iD, i13);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public T next() {
        a();
        if (this.f3389d.hasNext()) {
            g(d() + 1);
            return this.f3389d.next();
        }
        T[] tArr = this.f3388c;
        int iD = d();
        g(iD + 1);
        return tArr[iD - this.f3389d.f()];
    }

    @Override // java.util.ListIterator
    public T previous() {
        c();
        if (d() <= this.f3389d.f()) {
            g(d() - 1);
            return this.f3389d.previous();
        }
        T[] tArr = this.f3388c;
        g(d() - 1);
        return tArr[d() - this.f3389d.f()];
    }
}
