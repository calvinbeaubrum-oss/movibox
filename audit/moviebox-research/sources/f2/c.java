package f2;

import androidx.compose.ui.input.pointer.g;
import androidx.compose.ui.input.pointer.r;
import androidx.compose.ui.input.pointer.z;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f64531a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f64532b;

    public static final void c(androidx.compose.ui.input.pointer.util.a aVar, z zVar) {
        if (f64531a) {
            e(aVar, zVar);
        } else {
            d(aVar, zVar);
        }
    }

    public static final void d(androidx.compose.ui.input.pointer.util.a aVar, z zVar) {
        if (r.b(zVar)) {
            aVar.f(zVar.h());
            aVar.e();
        }
        long jK = zVar.k();
        List<g> listE = zVar.e();
        int size = listE.size();
        int i11 = 0;
        while (i11 < size) {
            g gVar = listE.get(i11);
            long jQ = y1.g.q(gVar.b(), jK);
            long jB = gVar.b();
            aVar.f(y1.g.r(aVar.c(), jQ));
            aVar.a(gVar.c(), aVar.c());
            i11++;
            jK = jB;
        }
        aVar.f(y1.g.r(aVar.c(), y1.g.q(zVar.h(), jK)));
        aVar.a(zVar.o(), aVar.c());
    }

    public static final void e(androidx.compose.ui.input.pointer.util.a aVar, z zVar) {
        if (r.b(zVar)) {
            aVar.e();
        }
        if (!r.d(zVar)) {
            List<g> listE = zVar.e();
            int size = listE.size();
            for (int i11 = 0; i11 < size; i11++) {
                g gVar = listE.get(i11);
                aVar.a(gVar.c(), gVar.a());
            }
            aVar.a(zVar.o(), zVar.g());
        }
        if (r.d(zVar) && zVar.o() - aVar.d() > 40) {
            aVar.e();
        }
        aVar.g(zVar.o());
    }

    public static final float f(float[] fArr, float[] fArr2, int i11, boolean z11) {
        int i12 = i11 - 1;
        float f11 = fArr2[i12];
        float fSignum = 0.0f;
        int i13 = i12;
        while (i13 > 0) {
            int i14 = i13 - 1;
            float f12 = fArr2[i14];
            if (f11 != f12) {
                float f13 = (z11 ? -fArr[i14] : fArr[i13] - fArr[i14]) / (f11 - f12);
                fSignum += (f13 - (Math.signum(fSignum) * ((float) Math.sqrt(2 * Math.abs(fSignum))))) * Math.abs(f13);
                if (i13 == i12) {
                    fSignum *= 0.5f;
                }
            }
            i13--;
            f11 = f12;
        }
        return Math.signum(fSignum) * ((float) Math.sqrt(2 * Math.abs(fSignum)));
    }

    public static final float g(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        float f11 = 0.0f;
        for (int i11 = 0; i11 < length; i11++) {
            f11 += fArr[i11] * fArr2[i11];
        }
        return f11;
    }

    public static final boolean h() {
        return f64532b;
    }

    public static final float[] i(float[] fArr, float[] fArr2, int i11, int i12, float[] fArr3) {
        int i13 = i12;
        if (i13 < 1) {
            h2.a.a("The degree must be at positive integer");
        }
        if (i11 == 0) {
            h2.a.a("At least one point must be provided");
        }
        if (i13 >= i11) {
            i13 = i11 - 1;
        }
        int i14 = i13 + 1;
        float[][] fArr4 = new float[i14][];
        for (int i15 = 0; i15 < i14; i15++) {
            fArr4[i15] = new float[i11];
        }
        for (int i16 = 0; i16 < i11; i16++) {
            fArr4[0][i16] = 1.0f;
            for (int i17 = 1; i17 < i14; i17++) {
                fArr4[i17][i16] = fArr4[i17 - 1][i16] * fArr[i16];
            }
        }
        float[][] fArr5 = new float[i14][];
        for (int i18 = 0; i18 < i14; i18++) {
            fArr5[i18] = new float[i11];
        }
        float[][] fArr6 = new float[i14][];
        for (int i19 = 0; i19 < i14; i19++) {
            fArr6[i19] = new float[i14];
        }
        int i21 = 0;
        while (i21 < i14) {
            float[] fArr7 = fArr5[i21];
            ArraysKt___ArraysJvmKt.i(fArr4[i21], fArr7, 0, 0, i11);
            for (int i22 = 0; i22 < i21; i22++) {
                float[] fArr8 = fArr5[i22];
                float fG = g(fArr7, fArr8);
                for (int i23 = 0; i23 < i11; i23++) {
                    fArr7[i23] = fArr7[i23] - (fArr8[i23] * fG);
                }
            }
            float fSqrt = (float) Math.sqrt(g(fArr7, fArr7));
            if (fSqrt < 1.0E-6f) {
                fSqrt = 1.0E-6f;
            }
            float f11 = 1.0f / fSqrt;
            for (int i24 = 0; i24 < i11; i24++) {
                fArr7[i24] = fArr7[i24] * f11;
            }
            float[] fArr9 = fArr6[i21];
            int i25 = 0;
            while (i25 < i14) {
                fArr9[i25] = i25 < i21 ? 0.0f : g(fArr7, fArr4[i25]);
                i25++;
            }
            i21++;
        }
        for (int i26 = i13; -1 < i26; i26--) {
            float fG2 = g(fArr5[i26], fArr2);
            float[] fArr10 = fArr6[i26];
            int i27 = i26 + 1;
            if (i27 <= i13) {
                int i28 = i13;
                while (true) {
                    fG2 -= fArr10[i28] * fArr3[i28];
                    if (i28 != i27) {
                        i28--;
                    }
                }
            }
            fArr3[i26] = fG2 / fArr10[i26];
        }
        return fArr3;
    }

    public static final void j(a[] aVarArr, int i11, long j11, float f11) {
        a aVar = aVarArr[i11];
        if (aVar == null) {
            aVarArr[i11] = new a(j11, f11);
        } else {
            aVar.d(j11);
            aVar.c(f11);
        }
    }
}
