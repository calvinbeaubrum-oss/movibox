package kotlin.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.ULong;
import y10.b;
import y10.c;

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
public final class UProgressionUtilKt {
    public static final int a(int i11, int i12, int i13) {
        int iA = b.a(i11, i13);
        int iA2 = b.a(i12, i13);
        int iCompare = Integer.compare(iA ^ Integer.MIN_VALUE, iA2 ^ Integer.MIN_VALUE);
        int iB = UInt.b(iA - iA2);
        return iCompare >= 0 ? iB : UInt.b(iB + i13);
    }

    public static final long b(long j11, long j12, long j13) {
        long jA = c.a(j11, j13);
        long jA2 = c.a(j12, j13);
        int iCompare = Long.compare(jA ^ Long.MIN_VALUE, jA2 ^ Long.MIN_VALUE);
        long jB = ULong.b(jA - jA2);
        return iCompare >= 0 ? jB : ULong.b(jB + j13);
    }

    @SinceKotlin
    @PublishedApi
    public static final long c(long j11, long j12, long j13) {
        if (j13 > 0) {
            return Long.compare(j11 ^ Long.MIN_VALUE, j12 ^ Long.MIN_VALUE) >= 0 ? j12 : ULong.b(j12 - b(j12, j11, ULong.b(j13)));
        }
        if (j13 < 0) {
            return Long.compare(j11 ^ Long.MIN_VALUE, j12 ^ Long.MIN_VALUE) <= 0 ? j12 : ULong.b(j12 + b(j11, j12, ULong.b(-j13)));
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    @SinceKotlin
    @PublishedApi
    public static final int d(int i11, int i12, int i13) {
        if (i13 > 0) {
            return Integer.compare(i11 ^ Integer.MIN_VALUE, i12 ^ Integer.MIN_VALUE) >= 0 ? i12 : UInt.b(i12 - a(i12, i11, UInt.b(i13)));
        }
        if (i13 < 0) {
            return Integer.compare(i11 ^ Integer.MIN_VALUE, i12 ^ Integer.MIN_VALUE) <= 0 ? i12 : UInt.b(i12 + a(i11, i12, UInt.b(-i13)));
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
