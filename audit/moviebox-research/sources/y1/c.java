package y1;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class c {
    public static final String a(float f11, int i11) {
        if (Float.isNaN(f11)) {
            return "NaN";
        }
        if (Float.isInfinite(f11)) {
            return f11 < 0.0f ? "-Infinity" : "Infinity";
        }
        int iMax = Math.max(i11, 0);
        float fPow = (float) Math.pow(10.0f, iMax);
        float f12 = f11 * fPow;
        int i12 = (int) f12;
        if (f12 - i12 >= 0.5f) {
            i12++;
        }
        float f13 = i12 / fPow;
        return iMax > 0 ? String.valueOf(f13) : String.valueOf((int) f13);
    }
}
