package androidx.compose.runtime;

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
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3418c;

    public i0(int i11, int i12, int i13) {
        this.f3416a = i11;
        this.f3417b = i12;
        this.f3418c = i13;
    }

    public final int a() {
        return this.f3418c;
    }

    public final int b() {
        return this.f3417b;
    }

    public final int c() {
        return this.f3416a;
    }

    public final void d(int i11) {
        this.f3418c = i11;
    }

    public final void e(int i11) {
        this.f3417b = i11;
    }

    public final void f(int i11) {
        this.f3416a = i11;
    }
}
