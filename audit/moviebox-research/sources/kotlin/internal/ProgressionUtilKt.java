package kotlin.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;

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
public final class ProgressionUtilKt {
    public static final int a(int i11, int i12, int i13) {
        return e(e(i11, i13) - e(i12, i13), i13);
    }

    public static final long b(long j11, long j12, long j13) {
        return f(f(j11, j13) - f(j12, j13), j13);
    }

    @PublishedApi
    public static final int c(int i11, int i12, int i13) {
        if (i13 > 0) {
            return i11 >= i12 ? i12 : i12 - a(i12, i11, i13);
        }
        if (i13 < 0) {
            return i11 <= i12 ? i12 : i12 + a(i11, i12, -i13);
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    @PublishedApi
    public static final long d(long j11, long j12, long j13) {
        if (j13 > 0) {
            return j11 >= j12 ? j12 : j12 - b(j12, j11, j13);
        }
        if (j13 < 0) {
            return j11 <= j12 ? j12 : j12 + b(j11, j12, -j13);
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    public static final int e(int i11, int i12) {
        int i13 = i11 % i12;
        return i13 >= 0 ? i13 : i13 + i12;
    }

    public static final long f(long j11, long j12) {
        long j13 = j11 % j12;
        return j13 >= 0 ? j13 : j13 + j12;
    }
}
