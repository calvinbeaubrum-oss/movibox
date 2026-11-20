package androidx.compose.ui.platform;

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
public final class g1 {
    public static final boolean a(float[] fArr, float[] fArr2) {
        float f11 = fArr[0];
        float f12 = fArr[1];
        float f13 = fArr[2];
        float f14 = fArr[3];
        float f15 = fArr[4];
        float f16 = fArr[5];
        float f17 = fArr[6];
        float f18 = fArr[7];
        float f19 = fArr[8];
        float f21 = fArr[9];
        float f22 = fArr[10];
        float f23 = fArr[11];
        float f24 = fArr[12];
        float f25 = fArr[13];
        float f26 = fArr[14];
        float f27 = fArr[15];
        float f28 = (f11 * f16) - (f12 * f15);
        float f29 = (f11 * f17) - (f13 * f15);
        float f31 = (f11 * f18) - (f14 * f15);
        float f32 = (f12 * f17) - (f13 * f16);
        float f33 = (f12 * f18) - (f14 * f16);
        float f34 = (f13 * f18) - (f14 * f17);
        float f35 = (f19 * f25) - (f21 * f24);
        float f36 = (f19 * f26) - (f22 * f24);
        float f37 = (f19 * f27) - (f23 * f24);
        float f38 = (f21 * f26) - (f22 * f25);
        float f39 = (f21 * f27) - (f23 * f25);
        float f40 = (f22 * f27) - (f23 * f26);
        float f41 = (((((f28 * f40) - (f29 * f39)) + (f31 * f38)) + (f32 * f37)) - (f33 * f36)) + (f34 * f35);
        if (f41 == 0.0f) {
            return false;
        }
        float f42 = 1.0f / f41;
        fArr2[0] = (((f16 * f40) - (f17 * f39)) + (f18 * f38)) * f42;
        fArr2[1] = ((((-f12) * f40) + (f13 * f39)) - (f14 * f38)) * f42;
        fArr2[2] = (((f25 * f34) - (f26 * f33)) + (f27 * f32)) * f42;
        fArr2[3] = ((((-f21) * f34) + (f22 * f33)) - (f23 * f32)) * f42;
        float f43 = -f15;
        fArr2[4] = (((f43 * f40) + (f17 * f37)) - (f18 * f36)) * f42;
        fArr2[5] = (((f40 * f11) - (f13 * f37)) + (f14 * f36)) * f42;
        float f44 = -f24;
        fArr2[6] = (((f44 * f34) + (f26 * f31)) - (f27 * f29)) * f42;
        fArr2[7] = (((f34 * f19) - (f22 * f31)) + (f23 * f29)) * f42;
        fArr2[8] = (((f15 * f39) - (f16 * f37)) + (f18 * f35)) * f42;
        fArr2[9] = ((((-f11) * f39) + (f37 * f12)) - (f14 * f35)) * f42;
        fArr2[10] = (((f24 * f33) - (f25 * f31)) + (f27 * f28)) * f42;
        fArr2[11] = ((((-f19) * f33) + (f31 * f21)) - (f23 * f28)) * f42;
        fArr2[12] = (((f43 * f38) + (f16 * f36)) - (f17 * f35)) * f42;
        fArr2[13] = (((f11 * f38) - (f12 * f36)) + (f13 * f35)) * f42;
        fArr2[14] = (((f44 * f32) + (f25 * f29)) - (f26 * f28)) * f42;
        fArr2[15] = (((f19 * f32) - (f21 * f29)) + (f22 * f28)) * f42;
        return true;
    }
}
