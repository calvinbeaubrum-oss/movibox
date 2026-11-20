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
public final class m extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f4074e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final float[] f4075f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final float[] f4076g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final float[] f4077h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final float[] f4078i;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        float[] fArrB = androidx.compose.ui.graphics.colorspace.a.f4013b.a().b();
        k kVar = k.f4062a;
        float[] fArrL = d.l(new float[]{0.818933f, 0.032984544f, 0.0482003f, 0.36186674f, 0.9293119f, 0.26436627f, -0.12885971f, 0.03614564f, 0.6338517f}, d.e(fArrB, kVar.b().c(), kVar.e().c()));
        f4075f = fArrL;
        float[] fArr = {0.21045426f, 1.9779985f, 0.025904037f, 0.7936178f, -2.4285922f, 0.78277177f, -0.004072047f, 0.4505937f, -0.80867577f};
        f4076g = fArr;
        f4077h = d.k(fArrL);
        f4078i = d.k(fArr);
    }

    public m(String str, int i11) {
        super(str, b.f4018a.a(), i11, null);
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public float[] b(float[] fArr) {
        d.n(f4075f, fArr);
        fArr[0] = s2.b.a(fArr[0]);
        fArr[1] = s2.b.a(fArr[1]);
        fArr[2] = s2.b.a(fArr[2]);
        d.n(f4076g, fArr);
        return fArr;
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public float e(int i11) {
        return i11 == 0 ? 1.0f : 0.5f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public float f(int i11) {
        return i11 == 0 ? 0.0f : -0.5f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public long j(float f11, float f12, float f13) {
        if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        if (f11 > 1.0f) {
            f11 = 1.0f;
        }
        if (f12 < -0.5f) {
            f12 = -0.5f;
        }
        if (f12 > 0.5f) {
            f12 = 0.5f;
        }
        if (f13 < -0.5f) {
            f13 = -0.5f;
        }
        float f14 = f13 <= 0.5f ? f13 : 0.5f;
        float[] fArr = f4078i;
        float f15 = (fArr[0] * f11) + (fArr[3] * f12) + (fArr[6] * f14);
        float f16 = (fArr[1] * f11) + (fArr[4] * f12) + (fArr[7] * f14);
        float f17 = (fArr[2] * f11) + (fArr[5] * f12) + (fArr[8] * f14);
        float f18 = f15 * f15 * f15;
        float f19 = f16 * f16 * f16;
        float f21 = f17 * f17 * f17;
        float[] fArr2 = f4077h;
        return (((long) Float.floatToRawIntBits(((fArr2[0] * f18) + (fArr2[3] * f19)) + (fArr2[6] * f21))) << 32) | (((long) Float.floatToRawIntBits((fArr2[1] * f18) + (fArr2[4] * f19) + (fArr2[7] * f21))) & 4294967295L);
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public float[] l(float[] fArr) {
        float f11 = fArr[0];
        if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        if (f11 > 1.0f) {
            f11 = 1.0f;
        }
        fArr[0] = f11;
        float f12 = fArr[1];
        if (f12 < -0.5f) {
            f12 = -0.5f;
        }
        if (f12 > 0.5f) {
            f12 = 0.5f;
        }
        fArr[1] = f12;
        float f13 = fArr[2];
        float f14 = f13 >= -0.5f ? f13 : -0.5f;
        fArr[2] = f14 <= 0.5f ? f14 : 0.5f;
        d.n(f4078i, fArr);
        float f15 = fArr[0];
        fArr[0] = f15 * f15 * f15;
        float f16 = fArr[1];
        fArr[1] = f16 * f16 * f16;
        float f17 = fArr[2];
        fArr[2] = f17 * f17 * f17;
        d.n(f4077h, fArr);
        return fArr;
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public float m(float f11, float f12, float f13) {
        if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        if (f11 > 1.0f) {
            f11 = 1.0f;
        }
        if (f12 < -0.5f) {
            f12 = -0.5f;
        }
        if (f12 > 0.5f) {
            f12 = 0.5f;
        }
        if (f13 < -0.5f) {
            f13 = -0.5f;
        }
        float f14 = f13 <= 0.5f ? f13 : 0.5f;
        float[] fArr = f4078i;
        float f15 = (fArr[0] * f11) + (fArr[3] * f12) + (fArr[6] * f14);
        float f16 = (fArr[1] * f11) + (fArr[4] * f12) + (fArr[7] * f14);
        float f17 = (fArr[2] * f11) + (fArr[5] * f12) + (fArr[8] * f14);
        float f18 = f15 * f15 * f15;
        float f19 = f16 * f16 * f16;
        float[] fArr2 = f4077h;
        return (fArr2[2] * f18) + (fArr2[5] * f19) + (fArr2[8] * f17 * f17 * f17);
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public long n(float f11, float f12, float f13, float f14, c cVar) {
        float[] fArr = f4075f;
        float f15 = (fArr[0] * f11) + (fArr[3] * f12) + (fArr[6] * f13);
        float f16 = (fArr[1] * f11) + (fArr[4] * f12) + (fArr[7] * f13);
        float f17 = (fArr[2] * f11) + (fArr[5] * f12) + (fArr[8] * f13);
        float fA = s2.b.a(f15);
        float fA2 = s2.b.a(f16);
        float fA3 = s2.b.a(f17);
        float[] fArr2 = f4076g;
        return y1.a((fArr2[0] * fA) + (fArr2[3] * fA2) + (fArr2[6] * fA3), (fArr2[1] * fA) + (fArr2[4] * fA2) + (fArr2[7] * fA3), (fArr2[2] * fA) + (fArr2[5] * fA2) + (fArr2[8] * fA3), f14, cVar);
    }
}
