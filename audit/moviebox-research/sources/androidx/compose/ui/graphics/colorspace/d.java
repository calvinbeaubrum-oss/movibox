package androidx.compose.ui.graphics.colorspace;

import androidx.collection.c0;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
public final class d {
    public static final double a(double d11, double d12, double d13, double d14, double d15, double d16) {
        return Math.copySign(o(d11 < 0.0d ? -d11 : d11, d12, d13, d14, d15, d16), d11);
    }

    public static final double b(double d11, double d12, double d13, double d14, double d15, double d16) {
        return Math.copySign(q(d11 < 0.0d ? -d11 : d11, d12, d13, d14, d15, d16), d11);
    }

    @JvmOverloads
    public static final c c(c cVar, y yVar, a aVar) {
        if (!b.e(cVar.g(), b.f4018a.b())) {
            return cVar;
        }
        Intrinsics.e(cVar, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        Rgb rgb = (Rgb) cVar;
        if (f(rgb.R(), yVar)) {
            return cVar;
        }
        return new Rgb(rgb, l(e(aVar.b(), rgb.R().c(), yVar.c()), rgb.Q()), yVar);
    }

    public static /* synthetic */ c d(c cVar, y yVar, a aVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            aVar = a.f4013b.a();
        }
        return c(cVar, yVar, aVar);
    }

    public static final float[] e(float[] fArr, float[] fArr2, float[] fArr3) {
        float[] fArrN = n(fArr, fArr2);
        float[] fArrN2 = n(fArr, fArr3);
        return l(k(fArr), m(new float[]{fArrN2[0] / fArrN[0], fArrN2[1] / fArrN[1], fArrN2[2] / fArrN[2]}, fArr));
    }

    public static final boolean f(y yVar, y yVar2) {
        if (yVar == yVar2) {
            return true;
        }
        return Math.abs(yVar.a() - yVar2.a()) < 0.001f && Math.abs(yVar.b() - yVar2.b()) < 0.001f;
    }

    public static final boolean g(float[] fArr, float[] fArr2) {
        if (fArr == fArr2) {
            return true;
        }
        int length = fArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (Float.compare(fArr[i11], fArr2[i11]) != 0 && Math.abs(fArr[i11] - fArr2[i11]) > 0.001f) {
                return false;
            }
        }
        return true;
    }

    public static final h h(c cVar, c cVar2, int i11) {
        int iD = cVar.d();
        int iD2 = cVar2.d();
        if ((iD | iD2) < 0) {
            return j(cVar, cVar2, i11);
        }
        c0<h> c0VarA = i.a();
        int i12 = iD | (iD2 << 6) | (i11 << 12);
        h hVarC = c0VarA.c(i12);
        if (hVarC == null) {
            hVarC = j(cVar, cVar2, i11);
            c0VarA.t(i12, hVarC);
        }
        return hVarC;
    }

    public static /* synthetic */ h i(c cVar, c cVar2, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            cVar2 = g.f4027a.w();
        }
        if ((i12 & 2) != 0) {
            i11 = n.f4079a.b();
        }
        return h(cVar, cVar2, i11);
    }

    public static final h j(c cVar, c cVar2, int i11) {
        h hVar;
        if (cVar == cVar2) {
            return h.f4051g.c(cVar);
        }
        long jG = cVar.g();
        b.a aVar = b.f4018a;
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (b.e(jG, aVar.b()) && b.e(cVar2.g(), aVar.b())) {
            Intrinsics.e(cVar, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
            Intrinsics.e(cVar2, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
            hVar = new h.b((Rgb) cVar, (Rgb) cVar2, i11, defaultConstructorMarker);
        } else {
            hVar = new h(cVar, cVar2, i11, defaultConstructorMarker);
        }
        return hVar;
    }

    public static final float[] k(float[] fArr) {
        float f11 = fArr[0];
        float f12 = fArr[3];
        float f13 = fArr[6];
        float f14 = fArr[1];
        float f15 = fArr[4];
        float f16 = fArr[7];
        float f17 = fArr[2];
        float f18 = fArr[5];
        float f19 = fArr[8];
        float f21 = (f15 * f19) - (f16 * f18);
        float f22 = (f16 * f17) - (f14 * f19);
        float f23 = (f14 * f18) - (f15 * f17);
        float f24 = (f11 * f21) + (f12 * f22) + (f13 * f23);
        float[] fArr2 = new float[fArr.length];
        fArr2[0] = f21 / f24;
        fArr2[1] = f22 / f24;
        fArr2[2] = f23 / f24;
        fArr2[3] = ((f13 * f18) - (f12 * f19)) / f24;
        fArr2[4] = ((f19 * f11) - (f13 * f17)) / f24;
        fArr2[5] = ((f17 * f12) - (f18 * f11)) / f24;
        fArr2[6] = ((f12 * f16) - (f13 * f15)) / f24;
        fArr2[7] = ((f13 * f14) - (f16 * f11)) / f24;
        fArr2[8] = ((f11 * f15) - (f12 * f14)) / f24;
        return fArr2;
    }

    public static final float[] l(float[] fArr, float[] fArr2) {
        float f11 = fArr[0] * fArr2[0];
        float f12 = fArr[3];
        float f13 = fArr2[1];
        float f14 = fArr[6];
        float f15 = fArr2[2];
        float f16 = fArr[1];
        float f17 = fArr2[0];
        float f18 = fArr[4];
        float f19 = fArr[7];
        float f21 = fArr[2] * f17;
        float f22 = fArr[5];
        float f23 = f21 + (fArr2[1] * f22);
        float f24 = fArr[8];
        float f25 = fArr[0];
        float f26 = fArr2[3] * f25;
        float f27 = fArr2[4];
        float f28 = f26 + (f12 * f27);
        float f29 = fArr2[5];
        float f31 = fArr[1];
        float f32 = fArr2[3];
        float f33 = fArr[2];
        float f34 = f25 * fArr2[6];
        float f35 = fArr[3];
        float f36 = fArr2[7];
        float f37 = f34 + (f35 * f36);
        float f38 = fArr2[8];
        float f39 = fArr2[6];
        return new float[]{f11 + (f12 * f13) + (f14 * f15), (f16 * f17) + (f13 * f18) + (f19 * f15), f23 + (f15 * f24), f28 + (f14 * f29), (f31 * f32) + (f18 * f27) + (f19 * f29), (f32 * f33) + (f22 * fArr2[4]) + (f29 * f24), f37 + (f14 * f38), (f31 * f39) + (fArr[4] * f36) + (f19 * f38), (f33 * f39) + (fArr[5] * fArr2[7]) + (f24 * f38)};
    }

    public static final float[] m(float[] fArr, float[] fArr2) {
        float f11 = fArr[0];
        float f12 = fArr[1];
        float f13 = fArr[2];
        return new float[]{fArr[0] * fArr2[0], fArr[1] * fArr2[1], fArr[2] * fArr2[2], fArr2[3] * f11, fArr2[4] * f12, fArr2[5] * f13, f11 * fArr2[6], f12 * fArr2[7], f13 * fArr2[8]};
    }

    public static final float[] n(float[] fArr, float[] fArr2) {
        float f11 = fArr2[0];
        float f12 = fArr2[1];
        float f13 = fArr2[2];
        fArr2[0] = (fArr[0] * f11) + (fArr[3] * f12) + (fArr[6] * f13);
        fArr2[1] = (fArr[1] * f11) + (fArr[4] * f12) + (fArr[7] * f13);
        fArr2[2] = (fArr[2] * f11) + (fArr[5] * f12) + (fArr[8] * f13);
        return fArr2;
    }

    public static final double o(double d11, double d12, double d13, double d14, double d15, double d16) {
        return d11 >= d15 * d14 ? (Math.pow(d11, 1.0d / d16) - d13) / d12 : d11 / d14;
    }

    public static final double p(double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18) {
        return d11 >= d15 * d14 ? (Math.pow(d11 - d16, 1.0d / d18) - d13) / d12 : (d11 - d17) / d14;
    }

    public static final double q(double d11, double d12, double d13, double d14, double d15, double d16) {
        return d11 >= d15 ? Math.pow((d12 * d11) + d13, d16) : d11 * d14;
    }

    public static final double r(double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18) {
        return d11 >= d15 ? Math.pow((d12 * d11) + d13, d18) + d16 : (d14 * d11) + d17;
    }
}
