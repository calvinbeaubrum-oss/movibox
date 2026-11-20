package q2;

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
public final class u {
    public static final long a(int i11, int i12) {
        return t.c((((long) i12) & 4294967295L) | (((long) i11) << 32));
    }

    public static final long b(long j11) {
        return p.c((((j11 << 32) >> 33) & 4294967295L) | ((j11 >> 33) << 32));
    }

    public static final long c(long j11) {
        int iRound = Math.round(y1.m.i(j11));
        return t.c((((long) Math.round(y1.m.g(j11))) & 4294967295L) | (((long) iRound) << 32));
    }

    public static final long d(long j11) {
        return y1.n.a(t.g(j11), t.f(j11));
    }
}
