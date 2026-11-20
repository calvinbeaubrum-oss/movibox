package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;

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
/* JADX INFO: loaded from: classes8.dex */
@SinceKotlin
@Metadata
public final class PackageReference implements ClassBasedDeclarationContainer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f68907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f68908b;

    public PackageReference(Class<?> jClass, String moduleName) {
        Intrinsics.g(jClass, "jClass");
        Intrinsics.g(moduleName, "moduleName");
        this.f68907a = jClass;
        this.f68908b = moduleName;
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class<?> c() {
        return this.f68907a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof PackageReference) && Intrinsics.b(c(), ((PackageReference) obj).c());
    }

    public int hashCode() {
        return c().hashCode();
    }

    public String toString() {
        return c().toString() + " (Kotlin reflection is not available)";
    }
}
