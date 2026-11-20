package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.FloatIterator;

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
public final class e extends FloatIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f68932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f68933b;

    public e(float[] array) {
        Intrinsics.g(array, "array");
        this.f68932a = array;
    }

    @Override // kotlin.collections.FloatIterator
    public float a() {
        try {
            float[] fArr = this.f68932a;
            int i11 = this.f68933b;
            this.f68933b = i11 + 1;
            return fArr[i11];
        } catch (ArrayIndexOutOfBoundsException e11) {
            this.f68933b--;
            throw new NoSuchElementException(e11.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f68933b < this.f68932a.length;
    }
}
