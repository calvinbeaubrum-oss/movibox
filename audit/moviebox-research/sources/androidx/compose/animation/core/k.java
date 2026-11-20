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
public final class k extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f2097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2098b;

    public k(float f11) {
        super(null);
        this.f2097a = f11;
        this.f2098b = 1;
    }

    @Override // androidx.compose.animation.core.o
    public float a(int i11) {
        if (i11 == 0) {
            return this.f2097a;
        }
        return 0.0f;
    }

    @Override // androidx.compose.animation.core.o
    public int b() {
        return this.f2098b;
    }

    @Override // androidx.compose.animation.core.o
    public void d() {
        this.f2097a = 0.0f;
    }

    @Override // androidx.compose.animation.core.o
    public void e(int i11, float f11) {
        if (i11 == 0) {
            this.f2097a = f11;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof k) && ((k) obj).f2097a == this.f2097a;
    }

    public final float f() {
        return this.f2097a;
    }

    @Override // androidx.compose.animation.core.o
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public k c() {
        return new k(0.0f);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f2097a);
    }

    public String toString() {
        return "AnimationVector1D: value = " + this.f2097a;
    }
}
