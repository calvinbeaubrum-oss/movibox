package f2;

import kotlin.Metadata;
import l.p;

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
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f64527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f64528b;

    public a(long j11, float f11) {
        this.f64527a = j11;
        this.f64528b = f11;
    }

    public final float a() {
        return this.f64528b;
    }

    public final long b() {
        return this.f64527a;
    }

    public final void c(float f11) {
        this.f64528b = f11;
    }

    public final void d(long j11) {
        this.f64527a = j11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f64527a == aVar.f64527a && Float.compare(this.f64528b, aVar.f64528b) == 0;
    }

    public int hashCode() {
        return (p.a(this.f64527a) * 31) + Float.floatToIntBits(this.f64528b);
    }

    public String toString() {
        return "DataPointAtTime(time=" + this.f64527a + ", dataPoint=" + this.f64528b + ')';
    }
}
