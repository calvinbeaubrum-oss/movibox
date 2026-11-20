package androidx.compose.animation.core;

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
public final class u implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f2138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f2139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f2140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f2141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f2142e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f2143f;

    public u(float f11, float f12, float f13, float f14) {
        this.f2138a = f11;
        this.f2139b = f12;
        this.f2140c = f13;
        this.f2141d = f14;
        if (!((Float.isNaN(f11) || Float.isNaN(f12) || Float.isNaN(f13) || Float.isNaN(f14)) ? false : true)) {
            k0.a("Parameters to CubicBezierEasing cannot be NaN. Actual parameters are: " + f11 + ", " + f12 + ", " + f13 + ", " + f14 + '.');
        }
        long jB = androidx.compose.ui.graphics.d1.b(0.0f, f12, f14, 1.0f, new float[5], 0);
        this.f2142e = Float.intBitsToFloat((int) (jB >> 32));
        this.f2143f = Float.intBitsToFloat((int) (jB & 4294967295L));
    }

    @Override // androidx.compose.animation.core.z
    public float a(float f11) {
        if (f11 <= 0.0f || f11 >= 1.0f) {
            return f11;
        }
        float fE = androidx.compose.ui.graphics.d1.e(0.0f - f11, this.f2138a - f11, this.f2140c - f11, 1.0f - f11);
        if (Float.isNaN(fE)) {
            b(f11);
        }
        float fC = androidx.compose.ui.graphics.d1.c(this.f2139b, this.f2141d, fE);
        float f12 = this.f2142e;
        float f13 = this.f2143f;
        if (fC < f12) {
            fC = f12;
        }
        return fC > f13 ? f13 : fC;
    }

    public final void b(float f11) {
        throw new IllegalArgumentException("The cubic curve with parameters (" + this.f2138a + ", " + this.f2139b + ", " + this.f2140c + ", " + this.f2141d + ") has no solution at " + f11);
    }

    public boolean equals(Object obj) {
        if (obj instanceof u) {
            u uVar = (u) obj;
            if (this.f2138a == uVar.f2138a && this.f2139b == uVar.f2139b && this.f2140c == uVar.f2140c && this.f2141d == uVar.f2141d) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.f2138a) * 31) + Float.floatToIntBits(this.f2139b)) * 31) + Float.floatToIntBits(this.f2140c)) * 31) + Float.floatToIntBits(this.f2141d);
    }

    public String toString() {
        return "CubicBezierEasing(a=" + this.f2138a + ", b=" + this.f2139b + ", c=" + this.f2140c + ", d=" + this.f2141d + ')';
    }
}
