package q2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
public final class h implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f74229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f74230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r2.a f74231c;

    public h(float f11, float f12, r2.a aVar) {
        this.f74229a = f11;
        this.f74230b = f12;
        this.f74231c = aVar;
    }

    @Override // q2.e
    public /* synthetic */ float H0(float f11) {
        return d.b(this, f11);
    }

    @Override // q2.n
    public long M(float f11) {
        return x.b(this.f74231c.a(f11));
    }

    @Override // q2.n
    public float M0() {
        return this.f74230b;
    }

    @Override // q2.e
    public /* synthetic */ float N0(float f11) {
        return d.d(this, f11);
    }

    @Override // q2.n
    public float O(long j11) {
        if (y.g(w.g(j11), y.f74261b.b())) {
            return i.h(this.f74231c.b(w.h(j11)));
        }
        throw new IllegalStateException("Only Sp can convert to Px".toString());
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
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return Float.compare(this.f74229a, hVar.f74229a) == 0 && Float.compare(this.f74230b, hVar.f74230b) == 0 && Intrinsics.b(this.f74231c, hVar.f74231c);
    }

    @Override // q2.e
    public float getDensity() {
        return this.f74229a;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.f74229a) * 31) + Float.floatToIntBits(this.f74230b)) * 31) + this.f74231c.hashCode();
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
        return "DensityWithConverter(density=" + this.f74229a + ", fontScale=" + this.f74230b + ", converter=" + this.f74231c + ')';
    }
}
