package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

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
public final class d0 {
    public static final long a(int i11) {
        return b(i11, i11);
    }

    public static final long b(int i11, int i12) {
        return c0.c(d(i11, i12));
    }

    public static final long c(long j11, int i11, int i12) {
        int iK = kotlin.ranges.a.k(c0.k(j11), i11, i12);
        int iK2 = kotlin.ranges.a.k(c0.g(j11), i11, i12);
        return (iK == c0.k(j11) && iK2 == c0.g(j11)) ? j11 : b(iK, iK2);
    }

    public static final long d(int i11, int i12) {
        if (i11 < 0) {
            throw new IllegalArgumentException(("start cannot be negative. [start: " + i11 + ", end: " + i12 + ']').toString());
        }
        if (i12 >= 0) {
            return (((long) i12) & 4294967295L) | (((long) i11) << 32);
        }
        throw new IllegalArgumentException(("end cannot be negative. [start: " + i11 + ", end: " + i12 + ']').toString());
    }
}
