package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.y1;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class l extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f4073e = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public l(String str, int i11) {
        super(str, b.f4018a.a(), i11, null);
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public float[] b(float[] fArr) {
        float f11 = fArr[0];
        k kVar = k.f4062a;
        float f12 = f11 / kVar.c()[0];
        float f13 = fArr[1] / kVar.c()[1];
        float f14 = fArr[2] / kVar.c()[2];
        float fCbrt = f12 > 0.008856452f ? (float) Math.cbrt(f12) : (f12 * 7.787037f) + 0.13793103f;
        float fCbrt2 = f13 > 0.008856452f ? (float) Math.cbrt(f13) : (f13 * 7.787037f) + 0.13793103f;
        float fCbrt3 = f14 > 0.008856452f ? (float) Math.cbrt(f14) : 0.13793103f + (f14 * 7.787037f);
        float f15 = (116.0f * fCbrt2) - 16.0f;
        float f16 = (fCbrt - fCbrt2) * 500.0f;
        float f17 = (fCbrt2 - fCbrt3) * 200.0f;
        if (f15 < 0.0f) {
            f15 = 0.0f;
        }
        if (f15 > 100.0f) {
            f15 = 100.0f;
        }
        fArr[0] = f15;
        if (f16 < -128.0f) {
            f16 = -128.0f;
        }
        if (f16 > 128.0f) {
            f16 = 128.0f;
        }
        fArr[1] = f16;
        if (f17 < -128.0f) {
            f17 = -128.0f;
        }
        fArr[2] = f17 <= 128.0f ? f17 : 128.0f;
        return fArr;
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public float e(int i11) {
        return i11 == 0 ? 100.0f : 128.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public float f(int i11) {
        return i11 == 0 ? 0.0f : -128.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public long j(float f11, float f12, float f13) {
        if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        if (f11 > 100.0f) {
            f11 = 100.0f;
        }
        if (f12 < -128.0f) {
            f12 = -128.0f;
        }
        if (f12 > 128.0f) {
            f12 = 128.0f;
        }
        float f14 = (f11 + 16.0f) / 116.0f;
        float f15 = (f12 * 0.002f) + f14;
        float f16 = f15 > 0.20689656f ? f15 * f15 * f15 : (f15 - 0.13793103f) * 0.12841855f;
        float f17 = f14 > 0.20689656f ? f14 * f14 * f14 : (f14 - 0.13793103f) * 0.12841855f;
        k kVar = k.f4062a;
        float f18 = f16 * kVar.c()[0];
        return (((long) Float.floatToRawIntBits(f17 * kVar.c()[1])) & 4294967295L) | (((long) Float.floatToRawIntBits(f18)) << 32);
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public float[] l(float[] fArr) {
        float f11 = fArr[0];
        if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        if (f11 > 100.0f) {
            f11 = 100.0f;
        }
        fArr[0] = f11;
        float f12 = fArr[1];
        if (f12 < -128.0f) {
            f12 = -128.0f;
        }
        if (f12 > 128.0f) {
            f12 = 128.0f;
        }
        fArr[1] = f12;
        float f13 = fArr[2];
        float f14 = f13 >= -128.0f ? f13 : -128.0f;
        float f15 = f14 <= 128.0f ? f14 : 128.0f;
        fArr[2] = f15;
        float f16 = (f11 + 16.0f) / 116.0f;
        float f17 = (f12 * 0.002f) + f16;
        float f18 = f16 - (f15 * 0.005f);
        float f19 = f17 > 0.20689656f ? f17 * f17 * f17 : (f17 - 0.13793103f) * 0.12841855f;
        float f21 = f16 > 0.20689656f ? f16 * f16 * f16 : (f16 - 0.13793103f) * 0.12841855f;
        float f22 = f18 > 0.20689656f ? f18 * f18 * f18 : (f18 - 0.13793103f) * 0.12841855f;
        k kVar = k.f4062a;
        fArr[0] = f19 * kVar.c()[0];
        fArr[1] = f21 * kVar.c()[1];
        fArr[2] = f22 * kVar.c()[2];
        return fArr;
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public float m(float f11, float f12, float f13) {
        if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        if (f11 > 100.0f) {
            f11 = 100.0f;
        }
        if (f13 < -128.0f) {
            f13 = -128.0f;
        }
        if (f13 > 128.0f) {
            f13 = 128.0f;
        }
        float f14 = ((f11 + 16.0f) / 116.0f) - (f13 * 0.005f);
        return (f14 > 0.20689656f ? f14 * f14 * f14 : 0.12841855f * (f14 - 0.13793103f)) * k.f4062a.c()[2];
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public long n(float f11, float f12, float f13, float f14, c cVar) {
        k kVar = k.f4062a;
        float f15 = f11 / kVar.c()[0];
        float f16 = f12 / kVar.c()[1];
        float f17 = f13 / kVar.c()[2];
        float fCbrt = f15 > 0.008856452f ? (float) Math.cbrt(f15) : (f15 * 7.787037f) + 0.13793103f;
        float fCbrt2 = f16 > 0.008856452f ? (float) Math.cbrt(f16) : (f16 * 7.787037f) + 0.13793103f;
        float f18 = (116.0f * fCbrt2) - 16.0f;
        float f19 = (fCbrt - fCbrt2) * 500.0f;
        float fCbrt3 = (fCbrt2 - (f17 > 0.008856452f ? (float) Math.cbrt(f17) : (f17 * 7.787037f) + 0.13793103f)) * 200.0f;
        if (f18 < 0.0f) {
            f18 = 0.0f;
        }
        if (f18 > 100.0f) {
            f18 = 100.0f;
        }
        if (f19 < -128.0f) {
            f19 = -128.0f;
        }
        if (f19 > 128.0f) {
            f19 = 128.0f;
        }
        if (fCbrt3 < -128.0f) {
            fCbrt3 = -128.0f;
        }
        return y1.a(f18, f19, fCbrt3 <= 128.0f ? fCbrt3 : 128.0f, f14, cVar);
    }
}
