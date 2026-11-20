package androidx.compose.ui.graphics.colorspace;

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
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f4099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f4100b;

    public y(float f11, float f12) {
        this.f4099a = f11;
        this.f4100b = f12;
    }

    public y(float f11, float f12, float f13) {
        this(f11, f12, f13, f11 + f12 + f13);
    }

    public y(float f11, float f12, float f13, float f14) {
        this(f11 / f14, f12 / f14);
    }

    public final float a() {
        return this.f4099a;
    }

    public final float b() {
        return this.f4100b;
    }

    public final float[] c() {
        float f11 = this.f4099a;
        float f12 = this.f4100b;
        return new float[]{f11 / f12, 1.0f, ((1.0f - f11) - f12) / f12};
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return Float.compare(this.f4099a, yVar.f4099a) == 0 && Float.compare(this.f4100b, yVar.f4100b) == 0;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.f4099a) * 31) + Float.floatToIntBits(this.f4100b);
    }

    public String toString() {
        return "WhitePoint(x=" + this.f4099a + ", y=" + this.f4100b + ')';
    }
}
