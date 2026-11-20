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
public final class v implements r2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f74256a;

    public v(float f11) {
        this.f74256a = f11;
    }

    @Override // r2.a
    public float a(float f11) {
        return f11 / this.f74256a;
    }

    @Override // r2.a
    public float b(float f11) {
        return f11 * this.f74256a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof v) && Float.compare(this.f74256a, ((v) obj).f74256a) == 0;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f74256a);
    }

    public String toString() {
        return "LinearFontScaleConverter(fontScale=" + this.f74256a + ')';
    }
}
