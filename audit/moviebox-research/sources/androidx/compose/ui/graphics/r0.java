package androidx.compose.ui.graphics;

import android.graphics.Matrix;
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
public final class r0 {
    public static final void a(Matrix matrix, float[] fArr) {
        float f11 = fArr[0];
        float f12 = fArr[1];
        float f13 = fArr[2];
        float f14 = fArr[3];
        float f15 = fArr[4];
        float f16 = fArr[5];
        float f17 = fArr[6];
        float f18 = fArr[7];
        float f19 = fArr[8];
        float f21 = fArr[12];
        float f22 = fArr[13];
        float f23 = fArr[15];
        fArr[0] = f11;
        fArr[1] = f15;
        fArr[2] = f21;
        fArr[3] = f12;
        fArr[4] = f16;
        fArr[5] = f22;
        fArr[6] = f14;
        fArr[7] = f18;
        fArr[8] = f23;
        matrix.setValues(fArr);
        fArr[0] = f11;
        fArr[1] = f12;
        fArr[2] = f13;
        fArr[3] = f14;
        fArr[4] = f15;
        fArr[5] = f16;
        fArr[6] = f17;
        fArr[7] = f18;
        fArr[8] = f19;
    }

    public static final void b(float[] fArr, Matrix matrix) {
        matrix.getValues(fArr);
        float f11 = fArr[0];
        float f12 = fArr[1];
        float f13 = fArr[2];
        float f14 = fArr[3];
        float f15 = fArr[4];
        float f16 = fArr[5];
        float f17 = fArr[6];
        float f18 = fArr[7];
        float f19 = fArr[8];
        fArr[0] = f11;
        fArr[1] = f14;
        fArr[2] = 0.0f;
        fArr[3] = f17;
        fArr[4] = f12;
        fArr[5] = f15;
        fArr[6] = 0.0f;
        fArr[7] = f18;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 1.0f;
        fArr[11] = 0.0f;
        fArr[12] = f13;
        fArr[13] = f16;
        fArr[14] = 0.0f;
        fArr[15] = f19;
    }
}
