package androidx.compose.animation.core;

import kotlin.Metadata;
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
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f2134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f2135b;

    public s(double d11, double d12) {
        this.f2134a = d11;
        this.f2135b = d12;
    }

    public final double e() {
        return this.f2135b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return Double.compare(this.f2134a, sVar.f2134a) == 0 && Double.compare(this.f2135b, sVar.f2135b) == 0;
    }

    public final double f() {
        return this.f2134a;
    }

    public int hashCode() {
        return (r.a(this.f2134a) * 31) + r.a(this.f2135b);
    }

    public String toString() {
        return "ComplexDouble(_real=" + this.f2134a + ", _imaginary=" + this.f2135b + ')';
    }
}
