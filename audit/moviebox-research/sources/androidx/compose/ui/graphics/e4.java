package androidx.compose.ui.graphics;

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
public interface e4 extends q2.e {
    float B();

    float E();

    void K0(c5 c5Var);

    void a(float f11);

    void b(float f11);

    void c(y4 y4Var);

    void d(float f11);

    void e(float f11);

    void f(float f11);

    void g(float f11);

    void h(float f11);

    long i0();

    void j(float f11);

    void l0(long j11);

    void n(int i11);

    float o();

    float q();

    void r(long j11);

    float s();

    void setAlpha(float f11);

    void t(boolean z11);

    void u(long j11);

    float v();

    void w(float f11);

    float y();

    float z();
}
