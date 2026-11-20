package kotlinx.coroutines;

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
public final class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.c0 f69322a = new kotlinx.coroutines.internal.c0("REMOVED_TASK");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.c0 f69323b = new kotlinx.coroutines.internal.c0("CLOSED_EMPTY");

    public static final long c(long j11) {
        if (j11 <= 0) {
            return 0L;
        }
        if (j11 >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j11;
    }
}
