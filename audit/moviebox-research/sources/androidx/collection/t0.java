package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public static final long[] f1991a = {-9187201950435737345L, -1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l0 f1992b = new l0(0);

    public static final void a(long[] metadata, int i11) {
        Intrinsics.g(metadata, "metadata");
        int i12 = (i11 + 7) >> 3;
        for (int i13 = 0; i13 < i12; i13++) {
            long j11 = metadata[i13] & (-9187201950435737472L);
            metadata[i13] = (-72340172838076674L) & ((~j11) + (j11 >>> 7));
        }
        int iT = kotlin.collections.d.T(metadata);
        int i14 = iT - 1;
        metadata[i14] = (metadata[i14] & 72057594037927935L) | (-72057594037927936L);
        metadata[iT] = metadata[0];
    }

    public static final int b(long[] metadata, int i11, int i12) {
        Intrinsics.g(metadata, "metadata");
        while (i11 < i12) {
            if (((metadata[i11 >> 3] >> ((i11 & 7) << 3)) & 255) == 128) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static final int c(int i11) {
        if (i11 == 7) {
            return 6;
        }
        return i11 - (i11 / 8);
    }

    public static final <K, V> l0<K, V> d() {
        return new l0<>(0, 1, null);
    }

    public static final int e(int i11) {
        if (i11 == 0) {
            return 6;
        }
        return (i11 * 2) + 1;
    }

    public static final int f(int i11) {
        if (i11 > 0) {
            return (-1) >>> Integer.numberOfLeadingZeros(i11);
        }
        return 0;
    }

    public static final int g(int i11) {
        if (i11 == 7) {
            return 8;
        }
        return i11 + ((i11 - 1) / 7);
    }
}
