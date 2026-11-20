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
public final class l extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f2099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f2100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2101c;

    public l(float f11, float f12) {
        super(null);
        this.f2099a = f11;
        this.f2100b = f12;
        this.f2101c = 2;
    }

    @Override // androidx.compose.animation.core.o
    public float a(int i11) {
        if (i11 == 0) {
            return this.f2099a;
        }
        if (i11 != 1) {
            return 0.0f;
        }
        return this.f2100b;
    }

    @Override // androidx.compose.animation.core.o
    public int b() {
        return this.f2101c;
    }

    @Override // androidx.compose.animation.core.o
    public void d() {
        this.f2099a = 0.0f;
        this.f2100b = 0.0f;
    }

    @Override // androidx.compose.animation.core.o
    public void e(int i11, float f11) {
        if (i11 == 0) {
            this.f2099a = f11;
        } else {
            if (i11 != 1) {
                return;
            }
            this.f2100b = f11;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (lVar.f2099a == this.f2099a && lVar.f2100b == this.f2100b) {
                return true;
            }
        }
        return false;
    }

    public final float f() {
        return this.f2099a;
    }

    public final float g() {
        return this.f2100b;
    }

    @Override // androidx.compose.animation.core.o
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public l c() {
        return new l(0.0f, 0.0f);
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.f2099a) * 31) + Float.floatToIntBits(this.f2100b);
    }

    public String toString() {
        return "AnimationVector2D: v1 = " + this.f2099a + ", v2 = " + this.f2100b;
    }
}
