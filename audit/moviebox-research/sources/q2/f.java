package q2;

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
public final class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f74227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f74228b;

    public f(float f11, float f12) {
        this.f74227a = f11;
        this.f74228b = f12;
    }

    @Override // q2.e
    public /* synthetic */ float H0(float f11) {
        return d.b(this, f11);
    }

    @Override // q2.n
    public /* synthetic */ long M(float f11) {
        return m.b(this, f11);
    }

    @Override // q2.n
    public float M0() {
        return this.f74228b;
    }

    @Override // q2.e
    public /* synthetic */ float N0(float f11) {
        return d.d(this, f11);
    }

    @Override // q2.n
    public /* synthetic */ float O(long j11) {
        return m.a(this, j11);
    }

    @Override // q2.e
    public /* synthetic */ long V0(long j11) {
        return d.e(this, j11);
    }

    @Override // q2.e
    public /* synthetic */ long X(float f11) {
        return d.f(this, f11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return Float.compare(this.f74227a, fVar.f74227a) == 0 && Float.compare(this.f74228b, fVar.f74228b) == 0;
    }

    @Override // q2.e
    public float getDensity() {
        return this.f74227a;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.f74227a) * 31) + Float.floatToIntBits(this.f74228b);
    }

    @Override // q2.e
    public /* synthetic */ int k0(float f11) {
        return d.a(this, f11);
    }

    @Override // q2.e
    public /* synthetic */ float p0(long j11) {
        return d.c(this, j11);
    }

    public String toString() {
        return "DensityImpl(density=" + this.f74227a + ", fontScale=" + this.f74228b + ')';
    }
}
