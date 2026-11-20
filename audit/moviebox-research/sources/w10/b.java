package w10;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.collections.CollectionsKt___CollectionsKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public class b extends a {
    @SinceKotlin
    @ExperimentalUnsignedTypes
    public static String a(byte[] bArr) {
        String strO0;
        return (bArr == null || (strO0 = CollectionsKt___CollectionsKt.o0(UByteArray.a(bArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : strO0;
    }

    @SinceKotlin
    @ExperimentalUnsignedTypes
    public static String b(int[] iArr) {
        String strO0;
        return (iArr == null || (strO0 = CollectionsKt___CollectionsKt.o0(UIntArray.a(iArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : strO0;
    }

    @SinceKotlin
    @ExperimentalUnsignedTypes
    public static String c(short[] sArr) {
        String strO0;
        return (sArr == null || (strO0 = CollectionsKt___CollectionsKt.o0(UShortArray.a(sArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : strO0;
    }

    @SinceKotlin
    @ExperimentalUnsignedTypes
    public static String d(long[] jArr) {
        String strO0;
        return (jArr == null || (strO0 = CollectionsKt___CollectionsKt.o0(ULongArray.a(jArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : strO0;
    }
}
