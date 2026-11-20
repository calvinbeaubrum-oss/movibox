package kotlinx.coroutines.internal;

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
public final class d0 {
    public static final int a() {
        return e0.a();
    }

    public static final int b(String str, int i11, int i12, int i13) {
        return f0.a(str, i11, i12, i13);
    }

    public static final long c(String str, long j11, long j12, long j13) {
        return f0.b(str, j11, j12, j13);
    }

    public static final String d(String str) {
        return e0.b(str);
    }

    public static final String e(String str, String str2) {
        return f0.c(str, str2);
    }

    public static final boolean f(String str, boolean z11) {
        return f0.d(str, z11);
    }
}
