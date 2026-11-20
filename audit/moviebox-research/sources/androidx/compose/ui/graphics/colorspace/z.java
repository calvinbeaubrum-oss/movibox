package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.y1;
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
public final class z extends c {
    public z(String str, int i11) {
        super(str, b.f4018a.c(), i11, null);
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public float[] b(float[] fArr) {
        float f11 = fArr[0];
        if (f11 < -2.0f) {
            f11 = -2.0f;
        }
        if (f11 > 2.0f) {
            f11 = 2.0f;
        }
        fArr[0] = f11;
        float f12 = fArr[1];
        if (f12 < -2.0f) {
            f12 = -2.0f;
        }
        if (f12 > 2.0f) {
            f12 = 2.0f;
        }
        fArr[1] = f12;
        float f13 = fArr[2];
        float f14 = f13 >= -2.0f ? f13 : -2.0f;
        fArr[2] = f14 <= 2.0f ? f14 : 2.0f;
        return fArr;
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public float e(int i11) {
        return 2.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public float f(int i11) {
        return -2.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public long j(float f11, float f12, float f13) {
        if (f11 < -2.0f) {
            f11 = -2.0f;
        }
        if (f11 > 2.0f) {
            f11 = 2.0f;
        }
        if (f12 < -2.0f) {
            f12 = -2.0f;
        }
        return (((long) Float.floatToRawIntBits(f11)) << 32) | (((long) Float.floatToRawIntBits(f12 <= 2.0f ? f12 : 2.0f)) & 4294967295L);
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public float[] l(float[] fArr) {
        float f11 = fArr[0];
        if (f11 < -2.0f) {
            f11 = -2.0f;
        }
        if (f11 > 2.0f) {
            f11 = 2.0f;
        }
        fArr[0] = f11;
        float f12 = fArr[1];
        if (f12 < -2.0f) {
            f12 = -2.0f;
        }
        if (f12 > 2.0f) {
            f12 = 2.0f;
        }
        fArr[1] = f12;
        float f13 = fArr[2];
        float f14 = f13 >= -2.0f ? f13 : -2.0f;
        fArr[2] = f14 <= 2.0f ? f14 : 2.0f;
        return fArr;
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public float m(float f11, float f12, float f13) {
        if (f13 < -2.0f) {
            f13 = -2.0f;
        }
        if (f13 > 2.0f) {
            return 2.0f;
        }
        return f13;
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public long n(float f11, float f12, float f13, float f14, c cVar) {
        if (f11 < -2.0f) {
            f11 = -2.0f;
        }
        if (f11 > 2.0f) {
            f11 = 2.0f;
        }
        if (f12 < -2.0f) {
            f12 = -2.0f;
        }
        if (f12 > 2.0f) {
            f12 = 2.0f;
        }
        if (f13 < -2.0f) {
            f13 = -2.0f;
        }
        return y1.a(f11, f12, f13 <= 2.0f ? f13 : 2.0f, f14, cVar);
    }
}
