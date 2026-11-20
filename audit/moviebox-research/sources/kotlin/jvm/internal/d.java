package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.DoubleIterator;

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
public final class d extends DoubleIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double[] f68930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f68931b;

    public d(double[] array) {
        Intrinsics.g(array, "array");
        this.f68930a = array;
    }

    @Override // kotlin.collections.DoubleIterator
    public double a() {
        try {
            double[] dArr = this.f68930a;
            int i11 = this.f68931b;
            this.f68931b = i11 + 1;
            return dArr[i11];
        } catch (ArrayIndexOutOfBoundsException e11) {
            this.f68931b--;
            throw new NoSuchElementException(e11.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f68931b < this.f68930a.length;
    }
}
