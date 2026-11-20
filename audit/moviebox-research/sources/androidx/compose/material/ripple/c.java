package androidx.compose.material.ripple;

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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f3171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f3172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f3173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f3174d;

    public c(float f11, float f12, float f13, float f14) {
        this.f3171a = f11;
        this.f3172b = f12;
        this.f3173c = f13;
        this.f3174d = f14;
    }

    public final float a() {
        return this.f3171a;
    }

    public final float b() {
        return this.f3172b;
    }

    public final float c() {
        return this.f3173c;
    }

    public final float d() {
        return this.f3174d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f3171a == cVar.f3171a && this.f3172b == cVar.f3172b && this.f3173c == cVar.f3173c && this.f3174d == cVar.f3174d;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.f3171a) * 31) + Float.floatToIntBits(this.f3172b)) * 31) + Float.floatToIntBits(this.f3173c)) * 31) + Float.floatToIntBits(this.f3174d);
    }

    public String toString() {
        return "RippleAlpha(draggedAlpha=" + this.f3171a + ", focusedAlpha=" + this.f3172b + ", hoveredAlpha=" + this.f3173c + ", pressedAlpha=" + this.f3174d + ')';
    }
}
