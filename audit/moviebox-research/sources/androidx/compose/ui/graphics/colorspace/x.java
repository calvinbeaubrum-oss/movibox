package androidx.compose.ui.graphics.colorspace;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f4092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f4093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f4094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f4095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final double f4096e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final double f4097f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final double f4098g;

    public x(double d11, double d12, double d13, double d14, double d15, double d16, double d17) {
        this.f4092a = d11;
        this.f4093b = d12;
        this.f4094c = d13;
        this.f4095d = d14;
        this.f4096e = d15;
        this.f4097f = d16;
        this.f4098g = d17;
        if (Double.isNaN(d12) || Double.isNaN(d13) || Double.isNaN(d14) || Double.isNaN(d15) || Double.isNaN(d16) || Double.isNaN(d17) || Double.isNaN(d11)) {
            throw new IllegalArgumentException("Parameters cannot be NaN");
        }
        if (d15 < 0.0d || d15 > 1.0d) {
            throw new IllegalArgumentException("Parameter d must be in the range [0..1], was " + d15);
        }
        if (d15 == 0.0d && (d12 == 0.0d || d11 == 0.0d)) {
            throw new IllegalArgumentException("Parameter a or g is zero, the transfer function is constant");
        }
        if (d15 >= 1.0d && d14 == 0.0d) {
            throw new IllegalArgumentException("Parameter c is zero, the transfer function is constant");
        }
        if ((d12 == 0.0d || d11 == 0.0d) && d14 == 0.0d) {
            throw new IllegalArgumentException("Parameter a or g is zero, and c is zero, the transfer function is constant");
        }
        if (d14 < 0.0d) {
            throw new IllegalArgumentException("The transfer function must be increasing");
        }
        if (d12 < 0.0d || d11 < 0.0d) {
            throw new IllegalArgumentException("The transfer function must be positive or increasing");
        }
    }

    public /* synthetic */ x(double d11, double d12, double d13, double d14, double d15, double d16, double d17, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(d11, d12, d13, d14, d15, (i11 & 32) != 0 ? 0.0d : d16, (i11 & 64) != 0 ? 0.0d : d17);
    }

    public final double a() {
        return this.f4093b;
    }

    public final double b() {
        return this.f4094c;
    }

    public final double c() {
        return this.f4095d;
    }

    public final double d() {
        return this.f4096e;
    }

    public final double e() {
        return this.f4097f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return Double.compare(this.f4092a, xVar.f4092a) == 0 && Double.compare(this.f4093b, xVar.f4093b) == 0 && Double.compare(this.f4094c, xVar.f4094c) == 0 && Double.compare(this.f4095d, xVar.f4095d) == 0 && Double.compare(this.f4096e, xVar.f4096e) == 0 && Double.compare(this.f4097f, xVar.f4097f) == 0 && Double.compare(this.f4098g, xVar.f4098g) == 0;
    }

    public final double f() {
        return this.f4098g;
    }

    public final double g() {
        return this.f4092a;
    }

    public int hashCode() {
        return (((((((((((androidx.compose.animation.core.r.a(this.f4092a) * 31) + androidx.compose.animation.core.r.a(this.f4093b)) * 31) + androidx.compose.animation.core.r.a(this.f4094c)) * 31) + androidx.compose.animation.core.r.a(this.f4095d)) * 31) + androidx.compose.animation.core.r.a(this.f4096e)) * 31) + androidx.compose.animation.core.r.a(this.f4097f)) * 31) + androidx.compose.animation.core.r.a(this.f4098g);
    }

    public String toString() {
        return "TransferParameters(gamma=" + this.f4092a + ", a=" + this.f4093b + ", b=" + this.f4094c + ", c=" + this.f4095d + ", d=" + this.f4096e + ", e=" + this.f4097f + ", f=" + this.f4098g + ')';
    }
}
