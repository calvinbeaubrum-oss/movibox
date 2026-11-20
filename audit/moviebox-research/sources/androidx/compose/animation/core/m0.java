package androidx.compose.animation.core;

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
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f2106a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f2109d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f2110e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f2111f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f2107b = Math.sqrt(50.0d);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f2112g = 1.0f;

    public m0(float f11) {
        this.f2106a = f11;
    }

    public final float a() {
        return this.f2112g;
    }

    public final float b() {
        double d11 = this.f2107b;
        return (float) (d11 * d11);
    }

    public final void c() {
        if (this.f2108c) {
            return;
        }
        if (this.f2106a == n0.b()) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        float f11 = this.f2112g;
        double d11 = ((double) f11) * ((double) f11);
        if (f11 > 1.0f) {
            double d12 = this.f2107b;
            double d13 = d11 - ((double) 1);
            this.f2109d = (((double) (-f11)) * d12) + (d12 * Math.sqrt(d13));
            double d14 = -this.f2112g;
            double d15 = this.f2107b;
            this.f2110e = (d14 * d15) - (d15 * Math.sqrt(d13));
        } else if (f11 >= 0.0f && f11 < 1.0f) {
            this.f2111f = this.f2107b * Math.sqrt(((double) 1) - d11);
        }
        this.f2108c = true;
    }

    public final void d(float f11) {
        if (f11 < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.f2112g = f11;
        this.f2108c = false;
    }

    public final void e(float f11) {
        this.f2106a = f11;
    }

    public final void f(float f11) {
        if (b() <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.f2107b = Math.sqrt(f11);
        this.f2108c = false;
    }

    public final long g(float f11, float f12, long j11) {
        double dCos;
        double dExp;
        c();
        float f13 = f11 - this.f2106a;
        double d11 = j11 / 1000.0d;
        float f14 = this.f2112g;
        if (f14 > 1.0f) {
            double d12 = f13;
            double d13 = this.f2110e;
            double d14 = f12;
            double d15 = this.f2109d;
            double d16 = d12 - (((d13 * d12) - d14) / (d13 - d15));
            double d17 = ((d12 * d13) - d14) / (d13 - d15);
            dExp = (Math.exp(d13 * d11) * d16) + (Math.exp(this.f2109d * d11) * d17);
            double d18 = this.f2110e;
            double dExp2 = d16 * d18 * Math.exp(d18 * d11);
            double d19 = this.f2109d;
            dCos = dExp2 + (d17 * d19 * Math.exp(d19 * d11));
        } else if (f14 == 1.0f) {
            double d21 = this.f2107b;
            double d22 = f13;
            double d23 = ((double) f12) + (d21 * d22);
            double d24 = d22 + (d23 * d11);
            double dExp3 = Math.exp((-d21) * d11) * d24;
            double dExp4 = d24 * Math.exp((-this.f2107b) * d11);
            double d25 = this.f2107b;
            dCos = (dExp4 * (-d25)) + (d23 * Math.exp((-d25) * d11));
            dExp = dExp3;
        } else {
            double d26 = ((double) 1) / this.f2111f;
            double d27 = this.f2107b;
            double d28 = f13;
            double d29 = d26 * ((((double) f14) * d27 * d28) + ((double) f12));
            double dExp5 = Math.exp(((double) (-f14)) * d27 * d11) * ((Math.cos(this.f2111f * d11) * d28) + (Math.sin(this.f2111f * d11) * d29));
            double d31 = this.f2107b;
            float f15 = this.f2112g;
            double d32 = (-d31) * dExp5 * ((double) f15);
            double dExp6 = Math.exp(((double) (-f15)) * d31 * d11);
            double d33 = this.f2111f;
            double dSin = (-d33) * d28 * Math.sin(d33 * d11);
            double d34 = this.f2111f;
            dCos = d32 + (dExp6 * (dSin + (d29 * d34 * Math.cos(d34 * d11))));
            dExp = dExp5;
        }
        return n0.a((float) (dExp + ((double) this.f2106a)), (float) dCos);
    }
}
