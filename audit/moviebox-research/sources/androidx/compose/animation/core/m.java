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
public final class m extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f2102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f2103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f2104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2105d;

    public m(float f11, float f12, float f13) {
        super(null);
        this.f2102a = f11;
        this.f2103b = f12;
        this.f2104c = f13;
        this.f2105d = 3;
    }

    @Override // androidx.compose.animation.core.o
    public float a(int i11) {
        if (i11 == 0) {
            return this.f2102a;
        }
        if (i11 == 1) {
            return this.f2103b;
        }
        if (i11 != 2) {
            return 0.0f;
        }
        return this.f2104c;
    }

    @Override // androidx.compose.animation.core.o
    public int b() {
        return this.f2105d;
    }

    @Override // androidx.compose.animation.core.o
    public void d() {
        this.f2102a = 0.0f;
        this.f2103b = 0.0f;
        this.f2104c = 0.0f;
    }

    @Override // androidx.compose.animation.core.o
    public void e(int i11, float f11) {
        if (i11 == 0) {
            this.f2102a = f11;
        } else if (i11 == 1) {
            this.f2103b = f11;
        } else {
            if (i11 != 2) {
                return;
            }
            this.f2104c = f11;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (mVar.f2102a == this.f2102a && mVar.f2103b == this.f2103b && mVar.f2104c == this.f2104c) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.animation.core.o
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public m c() {
        return new m(0.0f, 0.0f, 0.0f);
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.f2102a) * 31) + Float.floatToIntBits(this.f2103b)) * 31) + Float.floatToIntBits(this.f2104c);
    }

    public String toString() {
        return "AnimationVector3D: v1 = " + this.f2102a + ", v2 = " + this.f2103b + ", v3 = " + this.f2104c;
    }
}
