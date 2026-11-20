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
public final class n extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f2113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f2114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f2115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f2116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2117e;

    public n(float f11, float f12, float f13, float f14) {
        super(null);
        this.f2113a = f11;
        this.f2114b = f12;
        this.f2115c = f13;
        this.f2116d = f14;
        this.f2117e = 4;
    }

    @Override // androidx.compose.animation.core.o
    public float a(int i11) {
        if (i11 == 0) {
            return this.f2113a;
        }
        if (i11 == 1) {
            return this.f2114b;
        }
        if (i11 == 2) {
            return this.f2115c;
        }
        if (i11 != 3) {
            return 0.0f;
        }
        return this.f2116d;
    }

    @Override // androidx.compose.animation.core.o
    public int b() {
        return this.f2117e;
    }

    @Override // androidx.compose.animation.core.o
    public void d() {
        this.f2113a = 0.0f;
        this.f2114b = 0.0f;
        this.f2115c = 0.0f;
        this.f2116d = 0.0f;
    }

    @Override // androidx.compose.animation.core.o
    public void e(int i11, float f11) {
        if (i11 == 0) {
            this.f2113a = f11;
            return;
        }
        if (i11 == 1) {
            this.f2114b = f11;
        } else if (i11 == 2) {
            this.f2115c = f11;
        } else {
            if (i11 != 3) {
                return;
            }
            this.f2116d = f11;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (nVar.f2113a == this.f2113a && nVar.f2114b == this.f2114b && nVar.f2115c == this.f2115c && nVar.f2116d == this.f2116d) {
                return true;
            }
        }
        return false;
    }

    public final float f() {
        return this.f2113a;
    }

    public final float g() {
        return this.f2114b;
    }

    public final float h() {
        return this.f2115c;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.f2113a) * 31) + Float.floatToIntBits(this.f2114b)) * 31) + Float.floatToIntBits(this.f2115c)) * 31) + Float.floatToIntBits(this.f2116d);
    }

    public final float i() {
        return this.f2116d;
    }

    @Override // androidx.compose.animation.core.o
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public n c() {
        return new n(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public String toString() {
        return "AnimationVector4D: v1 = " + this.f2113a + ", v2 = " + this.f2114b + ", v3 = " + this.f2115c + ", v4 = " + this.f2116d;
    }
}
