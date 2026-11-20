package kotlin.collections;

import java.util.List;
import java.util.RandomAccess;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class MovingSubList<E> extends AbstractList<E> implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<E> f68769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f68770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f68771c;

    @Override // kotlin.collections.AbstractList, java.util.List
    public E get(int i11) {
        AbstractList.Companion.b(i11, this.f68771c);
        return this.f68769a.get(this.f68770b + i11);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f68771c;
    }
}
